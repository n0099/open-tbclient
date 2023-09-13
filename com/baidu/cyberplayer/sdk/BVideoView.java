package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Region;
import android.net.Uri;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;
import com.baidu.cyberplayer.sdk.CyberClientInfoManager;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.CyberRender;
import com.baidu.cyberplayer.sdk.ICyberRenderView;
import com.baidu.cyberplayer.sdk.ICyberVideoView;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.debug.DebugConfigManager;
import com.baidu.cyberplayer.sdk.mediainfo.MediaInfo;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.searchbox.playerserver.PlayerPolicyManager;
import com.yy.mobile.framework.revenuesdk.baseapi.ErrorCode;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
@Keep
/* loaded from: classes3.dex */
public class BVideoView extends GLSurfaceView implements CyberPlayerManager.OnPreparedListener, CyberPlayerManager.OnCompletionListener, CyberPlayerManager.OnVideoSizeChangedListener, CyberPlayerManager.OnSeekCompleteListener, CyberPlayerManager.OnBufferingUpdateListener, CyberPlayerManager.OnErrorListener, CyberPlayerManager.OnInfoListener, CyberPlayerManager.OnMediaSourceChangedListener, ICyberVideoView {
    public static final int STATE_ERROR = -1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_PAUSED = 4;
    public static final int STATE_PLAYBACK_COMPLETED = 5;
    public static final int STATE_PLAYING = 3;
    public static final int STATE_PREPARED = 2;
    public static final int STATE_PREPARING = 1;
    public static String TAG = "BVideoView";
    public String mClarityInfo;
    public CyberClientInfoManager mClientInfoManager;
    public Context mContext;
    public int mCurrentState;
    public CyberPlayer mCyberPlayer;
    public ICyberRenderView.ICyberSurfaceListener mCyberSurfaceListener;
    public int mDecodeMode;
    public Map<String, String> mHeaders;
    public CyberPlayerManager.HttpDNS mHttpDns;
    public boolean mIsAudioMuted;
    public boolean mIsLooping;
    public String mJson;
    public CyberPlayerManager.MediaSourceSwitchMode mMediaSourceSwitchMode;
    public CyberPlayerManager.OnBufferingUpdateListener mOnBufferingUpdateListener;
    public CyberPlayerManager.OnCompletionListener mOnCompletionListener;
    public CyberPlayerManager.OnErrorListener mOnErrorListener;
    public CyberPlayerManager.OnInfoListener mOnInfoListener;
    public CyberPlayerManager.OnMediaSourceChangedListener mOnMediaSourceChangedListener;
    public CyberPlayerManager.OnPreparedListener mOnPreparedListener;
    public CyberPlayerManager.OnSeekCompleteListener mOnSeekCompleteListener;
    public ArrayList<ICyberVideoView.OnSnapShotCompleteListener> mOnSnapShotCompleteListenerList;
    public CyberPlayerManager.OnVideoSizeChangedListener mOnVideoSizeChangedListener;
    public long mOpenVideoBeginTime;
    public HashMap<String, String> mOptions;
    public boolean mRemote;
    public CyberRender mRender;
    public int mSeekMode;
    public int mSeekWhenPrepared;
    public float mSpeed;
    public int mSwitchSourceWhenPrepared;
    public int mTargetState;
    public Uri mUri;
    public int mVideoHeight;
    public int mVideoWidth;

    @Override // android.view.SurfaceView, android.view.View
    public boolean gatherTransparentRegion(Region region) {
        return true;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public View getView() {
        return this;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setExternalSurface(Surface surface) {
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public boolean setFilterRegion(float f, float f2, float f3, float f4) {
        return false;
    }

    public BVideoView(Context context) {
        this(context, null);
    }

    public static boolean hlsForceMediaPlayer(String str) {
        try {
            if (CyberCfgManager.getInstance().getCfgBoolValueFast(CyberCfgManager.KEY_INT_ENABLE_HLS_FORCE_MEDIAPLAYER, false) && str.split("\\?")[0].endsWith(".m3u8")) {
                CyberLog.d(TAG, "force mediaplayer");
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void debugShowOptions(View view2) {
        CyberPlayer cyberPlayer;
        Context context = this.mContext;
        if (context != null && (cyberPlayer = this.mCyberPlayer) != null) {
            DebugConfigManager.showPlayerConfigOptions(view2, context, cyberPlayer);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void getMediaRuntimeInfo(CyberPlayerManager.OnMediaRuntimeInfoListener onMediaRuntimeInfoListener) {
        getMediaRuntimeInfo(100, onMediaRuntimeInfoListener);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
    public void onBufferingUpdate(int i) {
        CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener = this.mOnBufferingUpdateListener;
        if (onBufferingUpdateListener != null) {
            onBufferingUpdateListener.onBufferingUpdate(i);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void seekTo(int i) {
        if (this.mCyberPlayer != null) {
            if (isInPlaybackState()) {
                this.mCyberPlayer.seekTo(i);
            } else {
                this.mSeekWhenPrepared = i;
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setClarityInfo(String str) {
        if (!TextUtils.isEmpty(str)) {
            CyberPlayer cyberPlayer = this.mCyberPlayer;
            if (cyberPlayer != null) {
                cyberPlayer.setClarityInfo(str);
                return;
            } else {
                this.mClarityInfo = str;
                return;
            }
        }
        CyberLog.w(TAG, "setClarityInfo is null");
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setDecodeMode(int i) {
        this.mDecodeMode = i;
    }

    public void setHttpDns(CyberPlayerManager.HttpDNS httpDNS) {
        this.mHttpDns = httpDNS;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        this.mIsLooping = z;
        CyberPlayer cyberPlayer = this.mCyberPlayer;
        if (cyberPlayer != null) {
            cyberPlayer.setLooping(z);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnBufferingUpdateListener(CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.mOnBufferingUpdateListener = onBufferingUpdateListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.mOnCompletionListener = onCompletionListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.mOnErrorListener = onErrorListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        this.mOnInfoListener = onInfoListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnMediaSourceChangedListener(CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener) {
        this.mOnMediaSourceChangedListener = onMediaSourceChangedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.mOnPreparedListener = onPreparedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        this.mOnSeekCompleteListener = onSeekCompleteListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnVideoSizeChangedListener(CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.mOnVideoSizeChangedListener = onVideoSizeChangedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setPlayJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            CyberPlayer cyberPlayer = this.mCyberPlayer;
            if (cyberPlayer != null) {
                cyberPlayer.setPlayJson(str);
                return;
            } else {
                this.mJson = str;
                return;
            }
        }
        CyberLog.w(TAG, "setPlayJson is null");
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setRemote(boolean z) {
        this.mRemote = z;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setSpeed(float f) {
        CyberLog.i(TAG, "setSpeed()");
        this.mSpeed = f;
        CyberPlayer cyberPlayer = this.mCyberPlayer;
        if (cyberPlayer != null) {
            cyberPlayer.setSpeed(f);
        } else {
            CyberLog.i(TAG, "setSpeed must call after setVideoPath or setVideoURI");
        }
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoRotation(int i) {
        CyberRender cyberRender = this.mRender;
        if (cyberRender != null) {
            cyberRender.setClientRotation(i);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoScalingMode(int i) {
        CyberRender cyberRender = this.mRender;
        if (cyberRender != null) {
            cyberRender.setDisplayeMode(i);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void switchMediaSource(int i) {
        if (isInPlaybackState()) {
            this.mCyberPlayer.switchMediaSource(i);
            return;
        }
        this.mSwitchSourceWhenPrepared = i;
        if (i == -1) {
            this.mMediaSourceSwitchMode = CyberPlayerManager.MediaSourceSwitchMode.MEDIASOURCE_SWITCH_ABR_MODE;
        } else {
            this.mMediaSourceSwitchMode = CyberPlayerManager.MediaSourceSwitchMode.MEDIASOURCE_SWITCH_FORCE_MODE;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public boolean takeSnapshotAsync(ICyberVideoView.OnSnapShotCompleteListener onSnapShotCompleteListener) {
        return takeSnapshotAsync(onSnapShotCompleteListener, 1.0f, 0, 0);
    }

    public BVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSeekMode = 3;
        this.mCurrentState = 0;
        this.mTargetState = 0;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        this.mOptions = new HashMap<>();
        this.mRemote = true;
        this.mDecodeMode = 0;
        this.mSpeed = 1.0f;
        this.mOpenVideoBeginTime = 0L;
        this.mJson = null;
        this.mClarityInfo = null;
        this.mCyberSurfaceListener = new ICyberRenderView.ICyberSurfaceListener() { // from class: com.baidu.cyberplayer.sdk.BVideoView.2
            @Override // com.baidu.cyberplayer.sdk.ICyberRenderView.ICyberSurfaceListener
            public void onSurfaceDestroyed(int i) {
            }

            @Override // com.baidu.cyberplayer.sdk.ICyberRenderView.ICyberSurfaceListener
            public void onSnapShotComplete(final int i, final int i2, final Buffer buffer) {
                CyberTaskExcutor.getInstance().execute(new Runnable() { // from class: com.baidu.cyberplayer.sdk.BVideoView.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (buffer != null) {
                            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                            createBitmap.copyPixelsFromBuffer(buffer);
                            Bitmap rotateBitmap = Utils.rotateBitmap(createBitmap);
                            CyberLog.d(BVideoView.TAG, "onTakeSnapShot rotate bmp finished");
                            synchronized (BVideoView.this.mOnSnapShotCompleteListenerList) {
                                for (int i3 = 0; i3 < BVideoView.this.mOnSnapShotCompleteListenerList.size(); i3++) {
                                    ((ICyberVideoView.OnSnapShotCompleteListener) BVideoView.this.mOnSnapShotCompleteListenerList.get(i3)).onSnapShotComplete(rotateBitmap);
                                }
                                BVideoView.this.mOnSnapShotCompleteListenerList.clear();
                            }
                        }
                    }
                });
            }

            @Override // com.baidu.cyberplayer.sdk.ICyberRenderView.ICyberSurfaceListener
            public void onSurfaceChanged(int i, int i2) {
                if (BVideoView.this.mCyberPlayer != null) {
                    try {
                        BVideoView.this.mCyberPlayer.updateDisplaySize(i, i2);
                    } catch (Exception unused) {
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.ICyberRenderView.ICyberSurfaceListener
            public void onSurfaceFirstFrameDrawed(final long j) {
                if (CyberCfgManager.getInstance().getCfgBoolValueFast(CyberCfgManager.KEY_INT_JUDGE_THREAD_ON_FIRST_FRAME, false) && Looper.getMainLooper().getThread() == Thread.currentThread()) {
                    BVideoView.this.onFirstFrameDrawed(j);
                } else {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.cyberplayer.sdk.BVideoView.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BVideoView.this.onFirstFrameDrawed(j);
                        }
                    });
                }
            }

            @Override // com.baidu.cyberplayer.sdk.ICyberRenderView.ICyberSurfaceListener
            public boolean onSurfaceReady(int i) {
                Surface createNewSurface;
                String str = BVideoView.TAG;
                CyberLog.d(str, "onSurfaceReady renderType:" + i);
                if (i == 0 && Build.VERSION.SDK_INT < 16) {
                    if (BVideoView.this.mCyberPlayer != null && BVideoView.this.mRender != null && (createNewSurface = BVideoView.this.mRender.createNewSurface()) != null) {
                        BVideoView.this.mCyberPlayer.setSurface(createNewSurface);
                        return true;
                    }
                    return true;
                }
                return false;
            }
        };
        this.mContext = context.getApplicationContext();
        this.mClientInfoManager = new CyberClientInfoManager();
        this.mOnSnapShotCompleteListenerList = new ArrayList<>();
        reset();
        initVideoView();
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void getMediaRuntimeInfo(int i, CyberPlayerManager.OnMediaRuntimeInfoListener onMediaRuntimeInfoListener) {
        CyberPlayer cyberPlayer = this.mCyberPlayer;
        if (cyberPlayer != null) {
            cyberPlayer.getMediaRuntimeInfo(i, onMediaRuntimeInfoListener);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void seekTo(int i, int i2) {
        if (this.mCyberPlayer != null) {
            if (isInPlaybackState()) {
                this.mCyberPlayer.seekTo(i, i2);
                return;
            }
            this.mSeekMode = i2;
            this.mSeekWhenPrepared = i;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setExternalInfo(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        CyberPlayer cyberPlayer = this.mCyberPlayer;
        if (cyberPlayer != null) {
            cyberPlayer.setExternalInfo(str, obj);
        } else {
            this.mClientInfoManager.setExternalInfo(str, obj);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOption(String str, String str2) {
        if (this.mCurrentState == 0) {
            HashMap<String, String> hashMap = this.mOptions;
            if (hashMap != null) {
                hashMap.put(str, str2);
            }
            if (this.mCyberPlayer != null) {
                if (str != null && str.equals(CyberPlayerManager.OPT_HTTP_PROXY) && !TextUtils.isEmpty(Utils.getSystemHttpProxy())) {
                    return;
                }
                this.mCyberPlayer.setOption(str, str2);
                return;
            }
            return;
        }
        CyberLog.i(TAG, "Do not set option when the video player playing");
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoURI(Uri uri, Map<String, String> map) {
        setVideoURI(uri, map, null);
    }

    public void setVolume(float f, float f2) {
        CyberPlayer cyberPlayer = this.mCyberPlayer;
        if (cyberPlayer != null) {
            cyberPlayer.setVolume(f, f2);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void switchMediaSource(int i, CyberPlayerManager.MediaSourceSwitchMode mediaSourceSwitchMode) {
        if (isInPlaybackState()) {
            this.mCyberPlayer.switchMediaSource(i, mediaSourceSwitchMode);
            return;
        }
        this.mSwitchSourceWhenPrepared = i;
        this.mMediaSourceSwitchMode = mediaSourceSwitchMode;
    }

    private void initVideoView() {
        if (CyberCfgManager.getInstance().getCfgBoolValueFast(CyberCfgManager.KEY_INT_VIDEOVIEW_AUTO_REQUEST_FOCUS, false)) {
            setFocusable(true);
            setFocusableInTouchMode(true);
            requestFocus();
        }
        this.mCurrentState = 0;
        this.mTargetState = 0;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        setEGLContextClientVersion(2);
        CyberRender cyberRender = new CyberRender();
        this.mRender = cyberRender;
        setRenderer(cyberRender);
        setRenderMode(0);
        this.mRender.setCyberSurfaceListener(this.mCyberSurfaceListener);
        this.mRender.setOnRequestRenderListener(new CyberRender.OnRequestRenderListener() { // from class: com.baidu.cyberplayer.sdk.BVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberRender.OnRequestRenderListener
            public void onRequestRender() {
                BVideoView.this.requestRender();
            }
        });
    }

    private void updateExternalInfoToPlayer() {
        ArrayList<CyberClientInfoManager.VideoClientInfoItem> itemsList;
        if (this.mCyberPlayer != null && (itemsList = this.mClientInfoManager.getItemsList()) != null) {
            int size = itemsList.size();
            for (int i = 0; i < size; i++) {
                CyberClientInfoManager.VideoClientInfoItem videoClientInfoItem = itemsList.get(i);
                if (videoClientInfoItem != null && videoClientInfoItem.getKey() != null) {
                    this.mCyberPlayer.setExternalInfo(videoClientInfoItem.getKey(), videoClientInfoItem.getData());
                }
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        String str = TAG;
        CyberLog.i(str, "start mCyberPlayer:" + this.mCyberPlayer + " mCurrentState:" + this.mCurrentState);
        if (isInPlaybackState()) {
            this.mCyberPlayer.start();
            this.mCurrentState = 3;
        } else {
            CyberPlayer cyberPlayer = this.mCyberPlayer;
            if (cyberPlayer != null) {
                cyberPlayer.sendCommand(1000, 1, 0L, null);
            }
        }
        this.mTargetState = 3;
    }

    private boolean isInPlaybackState() {
        int i;
        if (this.mCyberPlayer != null && (i = this.mCurrentState) != -1 && i != 0 && i != 1) {
            return true;
        }
        return false;
    }

    private boolean isPlayerReady() {
        int i;
        if (this.mCyberPlayer != null && (i = this.mCurrentState) != 0 && i != 1) {
            return true;
        }
        return false;
    }

    private void release() {
        CyberPlayer cyberPlayer = this.mCyberPlayer;
        if (cyberPlayer != null) {
            if (cyberPlayer.getDecodeMode() == 4) {
                this.mCyberPlayer.reset();
            }
            this.mCyberPlayer.release();
            this.mCyberPlayer = null;
            this.mCurrentState = 0;
            this.mTargetState = 0;
            this.mVideoWidth = 0;
            this.mVideoHeight = 0;
        }
        CyberRender cyberRender = this.mRender;
        if (cyberRender != null) {
            cyberRender.release();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getCurrentPosition() {
        if (isPlayerReady()) {
            return this.mCyberPlayer.getCurrentPosition();
        }
        return 0;
    }

    public int getCurrentPositionSync() {
        if (isPlayerReady()) {
            return this.mCyberPlayer.getCurrentPositionSync();
        }
        return 0;
    }

    public CyberPlayer getCyberPlayer() {
        return this.mCyberPlayer;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getDecodeMode() {
        CyberPlayer cyberPlayer = this.mCyberPlayer;
        if (cyberPlayer != null) {
            return cyberPlayer.getDecodeMode();
        }
        return this.mDecodeMode;
    }

    public long getDownloadSpeed() {
        CyberPlayer cyberPlayer = this.mCyberPlayer;
        if (cyberPlayer != null && this.mCurrentState != 0) {
            return cyberPlayer.getDownloadSpeed();
        }
        return -1L;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getDuration() {
        if (isPlayerReady()) {
            return this.mCyberPlayer.getDuration();
        }
        return -1;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public MediaInfo getMediaInfo() {
        CyberPlayer cyberPlayer = this.mCyberPlayer;
        if (cyberPlayer == null) {
            return null;
        }
        return cyberPlayer.getMediaInfo();
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public long getPlayedTime() {
        if (isPlayerReady()) {
            return this.mCyberPlayer.getPlayedTime();
        }
        return -1L;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getVideoHeight() {
        return this.mVideoHeight;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getVideoWidth() {
        return this.mVideoWidth;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public boolean isPlaying() {
        if (isInPlaybackState() && this.mCurrentState == 3) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        this.mCurrentState = 5;
        this.mTargetState = 5;
        CyberPlayerManager.OnCompletionListener onCompletionListener = this.mOnCompletionListener;
        if (onCompletionListener != null) {
            onCompletionListener.onCompletion();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
    public void onSeekComplete() {
        CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener = this.mOnSeekCompleteListener;
        if (onSeekCompleteListener != null) {
            onSeekCompleteListener.onSeekComplete();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stepToNextFrame() {
        if (this.mCyberPlayer != null) {
            if (this.mCurrentState == 3) {
                pause();
            }
            this.mCyberPlayer.stepToNextFrame();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFirstFrameDrawed(long j) {
        CyberPlayer cyberPlayer;
        if (Build.VERSION.SDK_INT <= 16 && (cyberPlayer = this.mCyberPlayer) != null && cyberPlayer.getDecodeMode() == 4) {
            this.mCyberPlayer.sendCommand(1002, 0, j, null);
        }
        if (this.mCyberPlayer != null) {
            long j2 = this.mOpenVideoBeginTime;
            if (j2 > 0) {
                setStatisticInfoInternal(DpStatConstants.SESSION_TYPE_FIRST_SCREEN, "surface_drawed", "" + (j - j2));
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void muteOrUnmuteAudio(boolean z) {
        this.mIsAudioMuted = z;
        String str = TAG;
        CyberLog.i(str, "muteOrUnmuteAudio flag:" + z);
        if (this.mCyberPlayer != null) {
            String str2 = TAG;
            CyberLog.y(str2, this.mCyberPlayer + ", muteOrUnmuteAudio flag:" + z);
            this.mCyberPlayer.muteOrUnmuteAudio(z);
            return;
        }
        CyberLog.i(TAG, "muteOrUnmuteAudio must call after setVideoPath or setVideoURI");
    }

    private void openVideo() {
        Surface createNewSurface;
        if (this.mUri == null) {
            return;
        }
        this.mOpenVideoBeginTime = System.currentTimeMillis();
        PlayerConfigManager.setRequestSource(PlayerPolicyManager.REQ_SOURCE_OPEN_VIDEO);
        PlayerConfigManager.startRequestPlayerServerCfg();
        release();
        try {
            if (hlsForceMediaPlayer(this.mUri.toString())) {
                this.mDecodeMode = 4;
            }
            CyberPlayer cyberPlayer = new CyberPlayer(this.mDecodeMode, this.mHttpDns, this.mRemote);
            this.mCyberPlayer = cyberPlayer;
            cyberPlayer.setOnPreparedListener(this);
            this.mCyberPlayer.setOnCompletionListener(this);
            this.mCyberPlayer.setOnVideoSizeChangedListener(this);
            this.mCyberPlayer.setOnSeekCompleteListener(this);
            this.mCyberPlayer.setOnBufferingUpdateListener(this);
            this.mCyberPlayer.setOnErrorListener(this);
            this.mCyberPlayer.setOnInfoListener(this);
            this.mCyberPlayer.setOnMediaSourceChangedListener(this);
            if (this.mOptions != null) {
                for (String str : this.mOptions.keySet()) {
                    this.mCyberPlayer.setOption(str, this.mOptions.get(str));
                }
            }
            if (this.mJson != null) {
                this.mCyberPlayer.setPlayJson(this.mJson);
            }
            if (this.mClarityInfo != null) {
                this.mCyberPlayer.setClarityInfo(this.mClarityInfo);
            }
            CyberPlayer cyberPlayer2 = this.mCyberPlayer;
            cyberPlayer2.setOption(CyberPlayerManager.OPT_CLIENT_SET_URL_TIME, "" + this.mOpenVideoBeginTime);
            this.mCyberPlayer.setDataSource(this.mContext, this.mUri, this.mHeaders);
            this.mCyberPlayer.prepareAsync();
            this.mCurrentState = 1;
            if (this.mRender != null && (createNewSurface = this.mRender.createNewSurface()) != null) {
                this.mCyberPlayer.setSurface(createNewSurface);
            }
            this.mCyberPlayer.setScreenOnWhilePlaying(true);
            if (this.mIsAudioMuted) {
                this.mCyberPlayer.muteOrUnmuteAudio(this.mIsAudioMuted);
            }
            if (this.mIsLooping) {
                this.mCyberPlayer.setLooping(this.mIsLooping);
            }
            if (this.mSpeed != 1.0f) {
                this.mCyberPlayer.setSpeed(this.mSpeed);
            }
            updateExternalInfoToPlayer();
        } catch (Exception e) {
            e.printStackTrace();
            int i = -111;
            if (CyberCfgManager.getInstance().getCfgBoolValueFast(CyberCfgManager.KEY_INT_JAVA_ERROR_CODE_MAPPING, true)) {
                i = CyberErrorMapper.getInstance().mapErrNo(-111);
            }
            onError(i, 0, null);
        }
    }

    private void setStatisticInfoInternal(int i, String str, String str2) {
        if (this.mCyberPlayer == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("type", "" + i);
        hashMap.put(str, str2);
        this.mCyberPlayer.setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        this.mCurrentState = -1;
        this.mTargetState = -1;
        CyberPlayerManager.OnErrorListener onErrorListener = this.mOnErrorListener;
        if (onErrorListener != null) {
            return onErrorListener.onError(i, i2, obj);
        }
        return true;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnMediaSourceChangedListener
    public boolean onMediaSourceChanged(int i, int i2, Object obj) {
        CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener = this.mOnMediaSourceChangedListener;
        if (onMediaSourceChangedListener != null && onMediaSourceChangedListener.onMediaSourceChanged(i, i2, obj)) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoURI(Uri uri, Map<String, String> map, Map<String, String> map2) {
        if (map2 != null) {
            this.mOptions.putAll(map2);
        }
        this.mUri = uri;
        this.mHeaders = map;
        this.mSeekWhenPrepared = -1;
        openVideo();
        requestLayout();
        invalidate();
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void changeProxyDynamic(String str) {
        String str2;
        if (this.mCyberPlayer == null || !TextUtils.isEmpty(Utils.getSystemHttpProxy())) {
            return;
        }
        HashMap<String, String> hashMap = this.mOptions;
        if (hashMap != null) {
            str2 = hashMap.get(CyberPlayerManager.OPT_HTTP_PROXY);
        } else {
            str2 = null;
        }
        if (!TextUtils.isEmpty(str)) {
            if (str.equals(str2)) {
                return;
            }
            this.mCyberPlayer.changeProxyDynamic(str, true);
        } else if (TextUtils.isEmpty(str2)) {
            return;
        } else {
            this.mCyberPlayer.changeProxyDynamic(null, false);
        }
        this.mCyberPlayer.seekTo(getCurrentPosition() + ErrorCode.SERVER_ERROR);
        HashMap<String, String> hashMap2 = this.mOptions;
        if (hashMap2 != null) {
            hashMap2.put(CyberPlayerManager.OPT_HTTP_PROXY, str);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void destory() {
        CyberLog.i(TAG, "destory called");
        release();
        HashMap<String, String> hashMap = this.mOptions;
        if (hashMap != null) {
            hashMap.clear();
            this.mOptions = null;
        }
        CyberClientInfoManager cyberClientInfoManager = this.mClientInfoManager;
        if (cyberClientInfoManager != null) {
            cyberClientInfoManager.clear();
            this.mClientInfoManager = null;
        }
        synchronized (this.mOnSnapShotCompleteListenerList) {
            if (this.mOnSnapShotCompleteListenerList != null) {
                this.mOnSnapShotCompleteListenerList.clear();
            }
        }
        Map<String, String> map = this.mHeaders;
        if (map != null) {
            map.clear();
            this.mHeaders = null;
        }
        this.mHttpDns = null;
        this.mOnPreparedListener = null;
        this.mOnVideoSizeChangedListener = null;
        this.mOnCompletionListener = null;
        this.mOnSeekCompleteListener = null;
        this.mOnBufferingUpdateListener = null;
        this.mOnErrorListener = null;
        this.mOnInfoListener = null;
        this.mOnMediaSourceChangedListener = null;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        this.mCurrentState = 2;
        CyberPlayerManager.OnPreparedListener onPreparedListener = this.mOnPreparedListener;
        if (onPreparedListener != null) {
            onPreparedListener.onPrepared();
        }
        int i = this.mSeekWhenPrepared;
        if (i > 0) {
            seekTo(i, this.mSeekMode);
        }
        this.mSeekWhenPrepared = -1;
        int i2 = this.mSwitchSourceWhenPrepared;
        if (i2 != Integer.MIN_VALUE) {
            switchMediaSource(i2, this.mMediaSourceSwitchMode);
            this.mSwitchSourceWhenPrepared = Integer.MIN_VALUE;
        }
        String str = TAG;
        CyberLog.i(str, "onPrepared mTargetState::" + this.mTargetState);
        if (this.mTargetState == 3 && this.mCurrentState == 2) {
            start();
        } else if (this.mTargetState == 4 && this.mCurrentState == 2) {
            pause();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        if (isInPlaybackState()) {
            this.mCyberPlayer.pause();
            this.mCurrentState = 4;
        } else if (this.mCyberPlayer != null && !CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_PAUSE_VV_STATISTIC_FIX, false)) {
            this.mCyberPlayer.sendCommand(1000, 0, 0L, null);
            setStatisticInfoInternal(20488, "preparing_paused_time", "" + System.currentTimeMillis());
        }
        this.mTargetState = 4;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void reset() {
        CyberPlayer cyberPlayer;
        this.mIsAudioMuted = false;
        this.mRemote = true;
        this.mIsLooping = false;
        this.mSpeed = 1.0f;
        this.mSeekWhenPrepared = -1;
        this.mSwitchSourceWhenPrepared = Integer.MIN_VALUE;
        this.mUri = null;
        this.mHeaders = null;
        this.mHttpDns = null;
        this.mClarityInfo = null;
        this.mJson = null;
        if (this.mCurrentState == -1 && (cyberPlayer = this.mCyberPlayer) != null) {
            cyberPlayer.release();
            this.mCyberPlayer = null;
        }
        this.mDecodeMode = 0;
        this.mCurrentState = 0;
        this.mTargetState = 0;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        CyberPlayer cyberPlayer2 = this.mCyberPlayer;
        if (cyberPlayer2 != null) {
            cyberPlayer2.reset();
        }
        CyberRender cyberRender = this.mRender;
        if (cyberRender != null) {
            cyberRender.reset();
        }
        HashMap<String, String> hashMap = this.mOptions;
        if (hashMap != null) {
            hashMap.clear();
        }
        CyberClientInfoManager cyberClientInfoManager = this.mClientInfoManager;
        if (cyberClientInfoManager != null) {
            cyberClientInfoManager.clear();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        CyberPlayer cyberPlayer = this.mCyberPlayer;
        if (cyberPlayer != null) {
            cyberPlayer.setOnPreparedListener(null);
            this.mCyberPlayer.setOnCompletionListener(null);
            this.mCyberPlayer.setOnVideoSizeChangedListener(null);
            this.mCyberPlayer.setOnSeekCompleteListener(null);
            this.mCyberPlayer.setOnBufferingUpdateListener(null);
            this.mCyberPlayer.setOnErrorListener(null);
            this.mCyberPlayer.setOnInfoListener(null);
            this.mCyberPlayer.setOnMediaSourceChangedListener(null);
            this.mCyberPlayer.stop();
            this.mCyberPlayer.release();
            this.mCyberPlayer = null;
            this.mCurrentState = 0;
            this.mTargetState = 0;
        }
        HashMap<String, String> hashMap = this.mOptions;
        if (hashMap != null) {
            hashMap.clear();
        }
        CyberRender cyberRender = this.mRender;
        if (cyberRender != null) {
            cyberRender.release();
        }
        CyberClientInfoManager cyberClientInfoManager = this.mClientInfoManager;
        if (cyberClientInfoManager != null) {
            cyberClientInfoManager.clear();
        }
        this.mJson = null;
        this.mClarityInfo = null;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        CyberPlayer cyberPlayer;
        if (i == 10001 && (cyberPlayer = this.mCyberPlayer) != null && cyberPlayer.getDecodeMode() != 4) {
            this.mRender.setRawFrameRotation(i2);
        } else if (i == 904) {
            setStatisticInfoInternal(DpStatConstants.SESSION_TYPE_FIRST_SCREEN, "v_first_disp_msg_t", System.currentTimeMillis() + "");
        }
        CyberPlayerManager.OnInfoListener onInfoListener = this.mOnInfoListener;
        if (onInfoListener != null && onInfoListener.onInfo(i, i2, obj)) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
    public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
        CyberRender cyberRender = this.mRender;
        if (cyberRender != null) {
            cyberRender.onVideoSizeChanged(i, i2, i3, i4);
        }
        CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener = this.mOnVideoSizeChangedListener;
        if (onVideoSizeChangedListener != null) {
            onVideoSizeChangedListener.onVideoSizeChanged(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public boolean takeSnapshotAsync(ICyberVideoView.OnSnapShotCompleteListener onSnapShotCompleteListener, float f, int i, int i2) {
        if (onSnapShotCompleteListener == null) {
            return false;
        }
        CyberLog.d(TAG, "takeSnapshotAsync called");
        if (this.mRender == null) {
            return false;
        }
        synchronized (this.mOnSnapShotCompleteListenerList) {
            if (this.mOnSnapShotCompleteListenerList.isEmpty()) {
                this.mRender.takeSnapshot(f, i, i2);
            }
            this.mOnSnapShotCompleteListenerList.add(onSnapShotCompleteListener);
        }
        return true;
    }
}
