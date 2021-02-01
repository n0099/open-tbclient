package com.baidu.ala.recorder;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import com.baidu.ala.adp.lib.util.BdLog;
import com.baidu.ala.adp.lib.util.BdNetTypeUtil;
import com.baidu.ala.helper.StreamConfig;
import com.baidu.ala.ndk.AlaNDKPKPlayerAdapter;
import com.baidu.ala.ndk.AudioProcessModule;
import com.baidu.ala.player.AlaAudioPlayer;
import com.baidu.ala.player.CallStateReceiver;
import com.baidu.ala.recorder.video.RecorderHandler;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes6.dex */
public class AlaLivePKPlayer {
    private static final int JNI_NOTIFY_MESSAGE_NO_VIDEO_FRAME = 2;
    private static final int JNI_NOTIFY_MESSAGE_RENDER_VIDEO_FRAME = 1;
    private static final int JNI_NOTIFY_MESSAGE_STREAM_CMD = 3;
    public static final int LINE_INDEX1 = 1;
    public static final int LINE_INDEX2 = 2;
    private static final int PCM_BYTE_LENGTH = 2048;
    public static final int PLAYER_VIDEO_MODEL_FILL = 1;
    public static final int PLAYER_VIDEO_MODEL_FIT = 2;
    private static final String TAG = "LIVE_SDK_JNI";
    private WeakReference<Context> mContext;
    private RecorderHandler mHandler;
    private AlaNDKPKPlayerAdapter mNDKAdapter;
    private boolean mNativeFunctionsRegisted;
    private boolean mRunOpenSLES;
    private Map<Integer, AlaLivePKVideoPlayer> mPlayersMap = new ConcurrentHashMap();
    private AlaAudioPlayer mAudioPlayer = null;
    private int mNativePlayFlags = 0;
    private volatile boolean mEnableRtcACE = false;
    private volatile boolean mIsAudioThreadRun = false;
    private volatile boolean mIsSendFirstVideoFrame = false;
    private volatile boolean mIsPlaySound = true;
    private byte[] mPcmBytes = new byte[4096];
    private CallStateReceiver mCallState = null;
    private ExecutorService mExeService = Executors.newFixedThreadPool(1);

    public AlaLivePKPlayer(Context context, long j, RecorderHandler recorderHandler) {
        this.mNDKAdapter = null;
        this.mContext = null;
        this.mNativeFunctionsRegisted = false;
        this.mHandler = null;
        this.mRunOpenSLES = false;
        this.mNDKAdapter = new AlaNDKPKPlayerAdapter();
        this.mNDKAdapter.setNativeObject(j);
        this.mContext = new WeakReference<>(context);
        registerCallState();
        this.mNativeFunctionsRegisted = true;
        this.mHandler = recorderHandler;
        if (StreamConfig.initConfig(context) < 0) {
            BdLog.e("StreamConfig.initConfig");
        }
        this.mRunOpenSLES = StreamConfig.useOpenSLES();
    }

    public void deRegisterNativeObject() {
        this.mNDKAdapter.setNativeObject(0L);
        this.mNativeFunctionsRegisted = false;
    }

    public AlaLivePKVideoPlayer createPlayer() {
        if (getVideoPlayer(1) == null) {
            this.mPlayersMap.put(1, new AlaLivePKVideoPlayer(this.mContext.get(), 1));
        }
        return getVideoPlayer(1);
    }

    public AlaLivePKVideoPlayer createPlayer(int i) {
        if (getVideoPlayer(i) == null) {
            this.mPlayersMap.put(Integer.valueOf(i), new AlaLivePKVideoPlayer(this.mContext.get(), i));
        }
        return getVideoPlayer(i);
    }

    public void setEnableRtcACE(boolean z) {
        this.mEnableRtcACE = z;
    }

    public int startPlay(final String str, final int i, final String str2) {
        if (this.mEnableRtcACE) {
            if (!this.mRunOpenSLES) {
                if (this.mAudioPlayer == null) {
                    this.mAudioPlayer = new AlaAudioPlayer(48000, 4, this.mEnableRtcACE);
                }
            } else if (this.mNativePlayFlags == 0) {
                this.mNDKAdapter.setWebRtcHandle(AudioProcessModule.sharedInstance().getContext());
                if (AudioProcessModule.sharedInstance().createAudioPlayer(48000, 1, StreamConfig.OUTPUT_FRAMES_PER_BUFFER) != 0) {
                    BdLog.e("LIVE_SDK_JNIcreateAudioPlayer failed");
                }
                this.mNativePlayFlags = 1;
            }
        } else if (this.mAudioPlayer == null) {
            this.mAudioPlayer = new AlaAudioPlayer(44100, 4, this.mEnableRtcACE);
        }
        this.mExeService.submit(new Runnable() { // from class: com.baidu.ala.recorder.AlaLivePKPlayer.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaLivePKPlayer.this.mNDKAdapter.getNativeObject() != 0) {
                    int startPlayerNative = AlaLivePKPlayer.this.mNDKAdapter.startPlayerNative(str, i, AlaLivePKPlayer.this.getNetworkState(), str2);
                    if (startPlayerNative == 0) {
                        if (!AlaLivePKPlayer.this.mRunOpenSLES || !AlaLivePKPlayer.this.mEnableRtcACE) {
                            AlaLivePKPlayer.this.createAudioThreadJava();
                            return;
                        } else {
                            AlaLivePKPlayer.this.createAudioThreadCXX();
                            return;
                        }
                    }
                    BdLog.e("LIVE_SDK_JNIstartPlayerNative error:" + startPlayerNative);
                }
            }
        });
        return 0;
    }

    public AlaLivePKVideoPlayer getVideoPlayer(int i) {
        if (!this.mPlayersMap.containsKey(Integer.valueOf(i))) {
            return null;
        }
        return this.mPlayersMap.get(Integer.valueOf(i));
    }

    public int stopPlay() {
        for (Map.Entry<Integer, AlaLivePKVideoPlayer> entry : this.mPlayersMap.entrySet()) {
            AlaLivePKVideoPlayer value = entry.getValue();
            if (this.mNDKAdapter.getNativeObject() != 0) {
                this.mNDKAdapter.stopNative(value.mIndex);
            }
            this.mPlayersMap.remove(entry.getKey());
            value.release();
        }
        if (this.mPlayersMap.size() == 0) {
            deRegisterNativeObject();
        }
        if (this.mRunOpenSLES && this.mEnableRtcACE) {
            this.mExeService.submit(new Runnable() { // from class: com.baidu.ala.recorder.AlaLivePKPlayer.2
                @Override // java.lang.Runnable
                public void run() {
                    if (AudioProcessModule.sharedInstance().audioPlayerStop() != 0) {
                        BdLog.e("OpenSLES audio player stop failed");
                    }
                }
            });
            return 0;
        }
        return 0;
    }

    public void destroy() {
        unRegisterCallState();
        stopPlay();
        if (this.mExeService != null) {
            this.mExeService.shutdown();
        }
        this.mContext = null;
        this.mHandler = null;
    }

    private void jniNotifyMessage(int i, int i2, String str) {
        if (1 == i2) {
            if (!this.mIsSendFirstVideoFrame) {
                this.mIsSendFirstVideoFrame = true;
                if (this.mHandler != null) {
                    this.mHandler.sendPkPlayerOnFirstFrame();
                    return;
                }
                return;
            }
            return;
        }
        if (2 == i2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNetworkState() {
        int netType = BdNetTypeUtil.netType();
        if (netType > 2) {
            return 2;
        }
        return netType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createAudioThreadCXX() {
        if (!this.mIsAudioThreadRun && !this.mIsAudioThreadRun) {
            this.mIsAudioThreadRun = true;
            this.mExeService.submit(new Runnable() { // from class: com.baidu.ala.recorder.AlaLivePKPlayer.3
                @Override // java.lang.Runnable
                public void run() {
                    if (AudioProcessModule.sharedInstance().audioPlayerStart() != 0) {
                        BdLog.e("OpenSLES audio player start failed");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createAudioThreadJava() {
        if (!this.mRunOpenSLES && !this.mIsAudioThreadRun) {
            this.mExeService.submit(new Runnable() { // from class: com.baidu.ala.recorder.AlaLivePKPlayer.4
                @Override // java.lang.Runnable
                public void run() {
                    if (!AlaLivePKPlayer.this.mIsAudioThreadRun) {
                        AlaLivePKPlayer.this.mIsAudioThreadRun = true;
                        while (AlaLivePKPlayer.this.mIsAudioThreadRun && AlaLivePKPlayer.this.mNDKAdapter.getNativeObject() != 0) {
                            int audioPCMNative = AlaLivePKPlayer.this.mNDKAdapter.getAudioPCMNative(AlaLivePKPlayer.this.mPcmBytes);
                            if (audioPCMNative <= 0) {
                                Arrays.fill(AlaLivePKPlayer.this.mPcmBytes, (byte) 0);
                                audioPCMNative = 2048;
                            }
                            if (AlaLivePKPlayer.this.mAudioPlayer != null && AlaLivePKPlayer.this.mIsPlaySound) {
                                AlaLivePKPlayer.this.mAudioPlayer.writeData(AlaLivePKPlayer.this.mPcmBytes, 0, audioPCMNative);
                            }
                        }
                        if (AlaLivePKPlayer.this.mAudioPlayer != null) {
                            AlaLivePKPlayer.this.mAudioPlayer.stopAndRelease();
                        }
                        AlaLivePKPlayer.this.mIsAudioThreadRun = false;
                    }
                }
            });
        }
    }

    /* loaded from: classes6.dex */
    public class AlaLivePKVideoPlayer extends TextureView implements TextureView.SurfaceTextureListener {
        private int mIndex;
        private Surface mSurface;
        private boolean mSurfaceCreated;
        private SurfaceTexture mSurfaceTexture;

        public AlaLivePKVideoPlayer(Context context, int i) {
            super(context);
            this.mSurfaceCreated = false;
            this.mIndex = i;
            setSurfaceTextureListener(this);
        }

        public void release() {
            try {
                if (this.mSurfaceTexture != null) {
                    this.mSurfaceTexture.release();
                    this.mSurfaceTexture = null;
                }
                if (this.mSurface != null) {
                    this.mSurface.release();
                    this.mSurface = null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void textureSurfaceChanged(int i, int i2) {
            if (AlaLivePKPlayer.this.mNativeFunctionsRegisted) {
                if (AlaLivePKPlayer.this.mNDKAdapter.createSurfaceNative(this.mIndex, this.mSurface) != 0) {
                    this.mSurfaceCreated = false;
                    return;
                }
                this.mSurfaceCreated = true;
                AlaLivePKPlayer.this.mNDKAdapter.surfaceChangedNative(this.mIndex, i, i2, this.mSurface);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public synchronized void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            if (this.mSurfaceTexture != null) {
                setSurfaceTexture(this.mSurfaceTexture);
                if (this.mSurface == null) {
                    this.mSurface = new Surface(this.mSurfaceTexture);
                }
            } else {
                this.mSurfaceTexture = surfaceTexture;
                this.mSurface = new Surface(surfaceTexture);
            }
            textureSurfaceChanged(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public synchronized boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            boolean z;
            synchronized (this) {
                if (AlaLivePKPlayer.this.mNativeFunctionsRegisted) {
                    AlaLivePKPlayer.this.mNDKAdapter.destroySurfaceNative(this.mIndex);
                }
                this.mSurfaceCreated = false;
                z = this.mSurfaceTexture == null;
            }
            return z;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public synchronized void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            if (this.mSurfaceTexture == surfaceTexture && AlaLivePKPlayer.this.mNativeFunctionsRegisted) {
                AlaLivePKPlayer.this.mNDKAdapter.surfaceChangedNative(this.mIndex, i, i2, this.mSurface);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public synchronized void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    private void registerCallState() {
        if (this.mCallState == null) {
            this.mCallState = new CallStateReceiver(new CallStateReceiver.Callback() { // from class: com.baidu.ala.recorder.AlaLivePKPlayer.5
                @Override // com.baidu.ala.player.CallStateReceiver.Callback
                public void onInterruptionBegin() {
                    AlaLivePKPlayer.this.mIsPlaySound = false;
                    if (AlaLivePKPlayer.this.mRunOpenSLES) {
                        AlaLivePKPlayer.this.mExeService.submit(new Runnable() { // from class: com.baidu.ala.recorder.AlaLivePKPlayer.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (AlaLivePKPlayer.this.mNDKAdapter.getNativeObject() != 0 && AudioProcessModule.sharedInstance().audioPlayerSetOpt(1) != 0) {
                                    BdLog.e("OpenSLES audio player pause failed");
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.ala.player.CallStateReceiver.Callback
                public void onInterruptionEnd() {
                    AlaLivePKPlayer.this.mIsPlaySound = true;
                    if (AlaLivePKPlayer.this.mRunOpenSLES) {
                        AlaLivePKPlayer.this.mExeService.submit(new Runnable() { // from class: com.baidu.ala.recorder.AlaLivePKPlayer.5.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (AlaLivePKPlayer.this.mNDKAdapter.getNativeObject() != 0 && AudioProcessModule.sharedInstance().audioPlayerSetOpt(2) != 0) {
                                    BdLog.e("OpenSLES audio player resume failed");
                                }
                            }
                        });
                    }
                }
            });
            this.mCallState.register(this.mContext.get());
        }
    }

    private void unRegisterCallState() {
        if (this.mCallState != null) {
            this.mCallState.unregister(this.mContext.get());
            this.mCallState = null;
        }
    }
}
