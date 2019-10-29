package com.baidu.ala.liveRecorder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.telephony.TelephonyManager;
import android.view.Surface;
import android.view.TextureView;
import com.baidu.ala.livePlayer.AlaAudioPlayer;
import com.baidu.ala.livePlayer.StreamConfig;
import com.baidu.ala.liveRecorder.video.RecorderHandler;
import com.baidu.ala.ndk.AlaNDKPlayerAdapter;
import com.baidu.ala.ndk.AudioProcessModule;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class AlaLivePKPlayer {
    private static final int JNI_NOTIFY_MESSAGE_NO_VIDEO_FRAME = 2;
    private static final int JNI_NOTIFY_MESSAGE_RENDER_VIDEO_FRAME = 1;
    private static final int JNI_NOTIFY_MESSAGE_STREAM_CMD = 3;
    public static final int LINE_INDEX1 = 1;
    public static final int LINE_INDEX2 = 2;
    public static final int PLAYER_VIDEO_MODEL_FILL = 1;
    public static final int PLAYER_VIDEO_MODEL_FIT = 2;
    private WeakReference<Context> mContext;
    private RecorderHandler mHandler;
    private AlaNDKPlayerAdapter mNDKAdapter;
    private boolean mNativeFunctionsRegisted;
    private CallStateReceiver mReceiver;
    private boolean mRunOpenSLES;
    private Map<Integer, AlaLivePKVideoPlayer> mPlayersMap = new ConcurrentHashMap();
    private AlaAudioPlayer mAudioPlayer = null;
    private AudioManager mAudioManager = null;
    private int mNativePlayFlags = 0;
    private volatile boolean mEnableRtcACE = false;
    private volatile boolean mIsAudioThreadRun = false;
    private volatile boolean mIsSendFirstVideoFrame = false;
    private volatile boolean mIsPlaySound = true;
    private byte[] mPcmBytes = new byte[4096];

    public AlaLivePKPlayer(Context context, long j, RecorderHandler recorderHandler) {
        this.mNDKAdapter = null;
        this.mContext = null;
        this.mReceiver = null;
        this.mNativeFunctionsRegisted = false;
        this.mHandler = null;
        this.mRunOpenSLES = false;
        this.mNDKAdapter = new AlaNDKPlayerAdapter();
        this.mNDKAdapter.setNativeObject(j);
        this.mContext = new WeakReference<>(context);
        this.mReceiver = new CallStateReceiver();
        if (context != null) {
            this.mReceiver.register(context);
        }
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
                    this.mAudioPlayer = new AlaAudioPlayer(StreamConfig.Audio.AUDIO_RTC_FREQUENCY_48K, 4, this.mEnableRtcACE);
                    try {
                        this.mAudioManager = (AudioManager) this.mContext.get().getSystemService("audio");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        if (this.mAudioManager != null) {
                            this.mAudioManager.setMode(3);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            } else if (this.mNativePlayFlags == 0) {
                this.mNDKAdapter.setWebRtcHandle(AudioProcessModule.sharedInstance().getContext());
                if (AudioProcessModule.sharedInstance().createAudioPlayer(StreamConfig.OUTPUT_SAMPLE_RATE, 1, StreamConfig.OUTPUT_FRAMES_PER_BUFFER) != 0) {
                    BdLog.e("createAudioPlayer failed");
                }
                this.mNativePlayFlags = 1;
            }
        } else if (this.mAudioPlayer == null) {
            this.mAudioPlayer = new AlaAudioPlayer(StreamConfig.Audio.AUDIO_FREQUENCY, 4, this.mEnableRtcACE);
        }
        if (this.mNDKAdapter != null && this.mNDKAdapter.getNativeObject() != 0) {
            this.mNDKAdapter.setVideoFillModel(1, 2);
        }
        new Thread(new Runnable() { // from class: com.baidu.ala.liveRecorder.AlaLivePKPlayer.1
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
                    BdLog.e("startPlayerNative error:" + startPlayerNative);
                }
            }
        }).start();
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
            AudioProcessModule.sharedInstance().audioPlayerStop();
            return 0;
        }
        return 0;
    }

    public void destroy() {
        if (this.mReceiver != null) {
            this.mReceiver.unregister(this.mContext.get());
            this.mReceiver = null;
        }
        stopPlay();
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
            new Thread(new Runnable() { // from class: com.baidu.ala.liveRecorder.AlaLivePKPlayer.2
                @Override // java.lang.Runnable
                public void run() {
                    if (AudioProcessModule.sharedInstance().audioPlayerStart() != 0) {
                        BdLog.e("OpenSLES audio player start failed");
                    }
                    boolean z = false;
                    while (AlaLivePKPlayer.this.mIsAudioThreadRun && AlaLivePKPlayer.this.mNDKAdapter.getNativeObject() != 0) {
                        if (!AlaLivePKPlayer.this.mIsPlaySound) {
                            if (!z) {
                                if (AudioProcessModule.sharedInstance().audioPlayerSetOpt(1) != 0) {
                                    BdLog.e("OpenSLES audio player pause failed");
                                    z = true;
                                } else {
                                    z = true;
                                }
                            }
                        } else {
                            if (z && AudioProcessModule.sharedInstance().audioPlayerSetOpt(2) != 0) {
                                BdLog.e("OpenSLES audio player resume failed");
                            }
                            try {
                                Thread.sleep(40L);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    if (AudioProcessModule.sharedInstance().audioRecorderStop() != 0) {
                        BdLog.e("OpenSLES audio player stop failed");
                    }
                    AlaLivePKPlayer.this.mIsAudioThreadRun = false;
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createAudioThreadJava() {
        if (!this.mRunOpenSLES && !this.mIsAudioThreadRun && !this.mIsAudioThreadRun) {
            this.mIsAudioThreadRun = true;
            new Thread(new Runnable() { // from class: com.baidu.ala.liveRecorder.AlaLivePKPlayer.3
                @Override // java.lang.Runnable
                public void run() {
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
                    try {
                        if (AlaLivePKPlayer.this.mAudioManager != null && !AlaLivePKPlayer.this.mRunOpenSLES && AlaLivePKPlayer.this.mEnableRtcACE) {
                            AlaLivePKPlayer.this.mAudioManager.setMode(0);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (AlaLivePKPlayer.this.mAudioPlayer != null) {
                        AlaLivePKPlayer.this.mAudioPlayer.stopAndRelease();
                    }
                    AlaLivePKPlayer.this.mIsAudioThreadRun = false;
                }
            }).start();
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

    /* loaded from: classes6.dex */
    class CallStateReceiver extends BroadcastReceiver {
        private boolean isRegisted = false;

        CallStateReceiver() {
        }

        public void register(Context context) {
            if (context != null) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.PHONE_STATE");
                context.registerReceiver(this, intentFilter);
                this.isRegisted = true;
            }
        }

        public void unregister(Context context) {
            if (context != null && this.isRegisted) {
                context.unregisterReceiver(this);
            }
            this.isRegisted = false;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                switch (telephonyManager.getCallState()) {
                    case 0:
                        AlaLivePKPlayer.this.mIsPlaySound = true;
                        return;
                    case 1:
                    case 2:
                        AlaLivePKPlayer.this.mIsPlaySound = false;
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
