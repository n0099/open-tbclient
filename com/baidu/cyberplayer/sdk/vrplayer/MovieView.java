package com.baidu.cyberplayer.sdk.vrplayer;

import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayer;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.ICyberVideoView;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.Utils;
import com.baidu.cyberplayer.sdk.mediainfo.MediaInfo;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import com.yy.mobile.framework.revenuesdk.baseapi.ErrorCode;
import java.util.HashMap;
import java.util.Map;
@Keep
/* loaded from: classes3.dex */
public class MovieView extends FrameLayout implements ICyberVideoView {
    public static final boolean ENABLE_DEBUG = false;
    public static final String TAG = "VrMovieView";
    public Context appContext;
    public boolean b2DVideo;
    public String cacheDir;
    public PlayerState curPlayerState;
    public RenderState curRenderState;
    public int curScaleType;
    public int displayMode;
    public boolean enableDetachedSurfaceTextureView;
    public boolean enableMediaCodec;
    public Map<String, String> headers;
    public String httpProxy;
    public int interactiveMode;
    public boolean isRestart;
    public Uri lastUri;
    public String lastVideoName;
    public boolean looping;
    public String mCoreLoadInfo;
    public int mDecodeMode;
    public CyberPlayerManager.HttpDNS mHttpDns;
    public boolean mIsAudioMuted;
    public HashMap<String, String> mOptions;
    public boolean mRemote;
    public float mSpeed;
    public int mVideoHeight;
    public int mVideoWidth;
    public CyberPlayer mediaPlayer;
    public OnBufferingEndListener onBufferingEndListener;
    public OnBufferingStartListener onBufferingStartListener;
    public CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener;
    public OnClickListener onClickListener;
    public CyberPlayerManager.OnCompletionListener onCompletionListener;
    public CyberPlayerManager.OnErrorListener onErrorListener;
    public CyberPlayerManager.OnInfoListener onInfoListener;
    public OnPitchYawRollListener onPitchYawRoll;
    public CyberPlayerManager.OnPreparedListener onPreparedListener;
    public OnRenderStartListener onRenderStartListener;
    public CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener;
    public OnSeekStartListener onSeekStartListener;
    public OnSurfaceReadyListener onSurfaceReadyListener;
    public View.OnTouchListener onTouchListener;
    public CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangeListener;
    public boolean pauseBufferingWhenPrepared;
    public int playerType;
    public int projectionMode;
    public View renderView;
    public int seekModeWhenPrepared;
    public int seekWhenPrepared;
    public int sourceType;
    public int srcHeight;
    public int srcWidth;
    public Surface surface;
    public PlayerState tarPlayerState;
    public Uri uri;
    public String videoName;
    public int viewType;

    /* loaded from: classes3.dex */
    public interface OnBufferingEndListener {
        void onBufferingEnd();
    }

    /* loaded from: classes3.dex */
    public interface OnBufferingStartListener {
        void onBufferingStart();
    }

    /* loaded from: classes3.dex */
    public interface OnBufferingUpdateListener {
        void onBufferingUpdate(int i);
    }

    /* loaded from: classes3.dex */
    public interface OnClickListener {
        void onClick(MotionEvent motionEvent);
    }

    /* loaded from: classes3.dex */
    public interface OnCompletionListener {
        void onCompletion();
    }

    /* loaded from: classes3.dex */
    public interface OnErrorListener {
        void onError(int i, int i2);
    }

    /* loaded from: classes3.dex */
    public interface OnInfoListener {
        void onInfo(int i, int i2);
    }

    /* loaded from: classes3.dex */
    public interface OnPitchYawRollListener {
        void onPitchYawRoll(float f, float f2, float f3);
    }

    /* loaded from: classes3.dex */
    public interface OnPreparedListener {
        void onPrepared();
    }

    /* loaded from: classes3.dex */
    public interface OnRenderStartListener {
        void onRenderStart();
    }

    /* loaded from: classes3.dex */
    public interface OnSeekCompleteListener {
        void onSeekComplete();
    }

    /* loaded from: classes3.dex */
    public interface OnSeekStartListener {
        void onSeekStart();
    }

    /* loaded from: classes3.dex */
    public interface OnSurfaceReadyListener {
        void onSurfaceReady();
    }

    /* loaded from: classes3.dex */
    public interface OnVideoSizeChangeListener {
        void onVideoSizeChange(int i, int i2);
    }

    /* loaded from: classes3.dex */
    public enum PlayerState {
        ERROR,
        IDLE,
        PREPARING,
        PREPARED,
        PLAYING,
        PAUSED,
        PLAYBACK_COMPLETED
    }

    /* loaded from: classes3.dex */
    public enum RenderState {
        PAUSED,
        RESUMED
    }

    public boolean createView(int i) {
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void debugShowOptions(View view2) {
    }

    public void destroyRender() {
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public View getView() {
        return this;
    }

    public void pauseRender() {
    }

    public void printCommonLog(int i, String str) {
    }

    public void resumeRender() {
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setClarityInfo(String str) {
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setExternalSurface(Surface surface) {
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public boolean setFilterRegion(float f, float f2, float f3, float f4) {
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnMediaSourceChangedListener(CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener) {
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoRotation(int i) {
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoScalingMode(int i) {
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stepToNextFrame() {
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void switchMediaSource(int i) {
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void switchMediaSource(int i, CyberPlayerManager.MediaSourceSwitchMode mediaSourceSwitchMode) {
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public boolean takeSnapshotAsync(ICyberVideoView.OnSnapShotCompleteListener onSnapShotCompleteListener) {
        return true;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public boolean takeSnapshotAsync(ICyberVideoView.OnSnapShotCompleteListener onSnapShotCompleteListener, float f, int i, int i2) {
        return true;
    }

    public MovieView(Context context) {
        super(context);
        this.enableDetachedSurfaceTextureView = true;
        this.b2DVideo = false;
        this.playerType = 0;
        this.enableMediaCodec = true;
        this.uri = null;
        this.lastUri = null;
        this.isRestart = false;
        this.curScaleType = 0;
        this.mCoreLoadInfo = "0.0.0.0";
        this.mRemote = true;
        this.mDecodeMode = 0;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        this.mIsAudioMuted = false;
        this.mSpeed = 1.0f;
        this.mOptions = new HashMap<>();
        PlayerState playerState = PlayerState.IDLE;
        this.curPlayerState = playerState;
        this.tarPlayerState = playerState;
        this.looping = false;
        this.curRenderState = RenderState.PAUSED;
        if (!isInEditMode()) {
            checkContext(context);
        }
    }

    public MovieView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.enableDetachedSurfaceTextureView = true;
        this.b2DVideo = false;
        this.playerType = 0;
        this.enableMediaCodec = true;
        this.uri = null;
        this.lastUri = null;
        this.isRestart = false;
        this.curScaleType = 0;
        this.mCoreLoadInfo = "0.0.0.0";
        this.mRemote = true;
        this.mDecodeMode = 0;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        this.mIsAudioMuted = false;
        this.mSpeed = 1.0f;
        this.mOptions = new HashMap<>();
        PlayerState playerState = PlayerState.IDLE;
        this.curPlayerState = playerState;
        this.tarPlayerState = playerState;
        this.looping = false;
        this.curRenderState = RenderState.PAUSED;
        checkContext(context);
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOption(String str, String str2) {
        if (this.curPlayerState == PlayerState.IDLE) {
            HashMap<String, String> hashMap = this.mOptions;
            if (hashMap != null) {
                hashMap.put(str, str2);
            }
            if (this.mediaPlayer != null) {
                if (str != null && str.equals(CyberPlayerManager.OPT_HTTP_PROXY) && !TextUtils.isEmpty(Utils.getSystemHttpProxy())) {
                    return;
                }
                this.mediaPlayer.setOption(str, str2);
                return;
            }
            return;
        }
        printCommonLog(1, "Do not set option when the video player playing");
    }

    public MovieView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.enableDetachedSurfaceTextureView = true;
        this.b2DVideo = false;
        this.playerType = 0;
        this.enableMediaCodec = true;
        this.uri = null;
        this.lastUri = null;
        this.isRestart = false;
        this.curScaleType = 0;
        this.mCoreLoadInfo = "0.0.0.0";
        this.mRemote = true;
        this.mDecodeMode = 0;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        this.mIsAudioMuted = false;
        this.mSpeed = 1.0f;
        this.mOptions = new HashMap<>();
        PlayerState playerState = PlayerState.IDLE;
        this.curPlayerState = playerState;
        this.tarPlayerState = playerState;
        this.looping = false;
        this.curRenderState = RenderState.PAUSED;
        checkContext(context);
    }

    public void destroyPlayer(boolean z, boolean z2) {
        CyberPlayer cyberPlayer = this.mediaPlayer;
        if (cyberPlayer != null) {
            cyberPlayer.setDisplay(null);
            this.mediaPlayer.release();
            this.mediaPlayer = null;
        }
        setCurPlayerState(PlayerState.IDLE);
        if (z2) {
            this.tarPlayerState = PlayerState.IDLE;
        }
        ((AudioManager) this.appContext.getSystemService("audio")).abandonAudioFocus(null);
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void getMediaRuntimeInfo(int i, CyberPlayerManager.OnMediaRuntimeInfoListener onMediaRuntimeInfoListener) {
        CyberPlayer cyberPlayer = this.mediaPlayer;
        if (cyberPlayer != null) {
            cyberPlayer.getMediaRuntimeInfo(i, onMediaRuntimeInfoListener);
        }
    }

    public void handleError(int i, int i2) {
        setCurPlayerState(PlayerState.ERROR);
        this.tarPlayerState = PlayerState.ERROR;
        CyberPlayerManager.OnErrorListener onErrorListener = this.onErrorListener;
        if (onErrorListener != null) {
            onErrorListener.onError(i, i2, null);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void seekTo(int i, int i2) {
        if (i >= 0 && getDuration() != 0) {
            printCommonLog(1, "seekTo");
            OnSeekStartListener onSeekStartListener = this.onSeekStartListener;
            if (onSeekStartListener != null) {
                onSeekStartListener.onSeekStart();
            }
            seekToInternal(i, i2);
        }
    }

    public void seekToInternal(int i, int i2) {
        if (isInPlaybackState()) {
            this.mediaPlayer.seekTo(i, i2);
            this.seekWhenPrepared = 0;
            this.seekModeWhenPrepared = 3;
            return;
        }
        this.seekWhenPrepared = i;
        this.seekModeWhenPrepared = i2;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setExternalInfo(String str, Object obj) {
        CyberPlayer cyberPlayer;
        if (!TextUtils.isEmpty(str) && (cyberPlayer = this.mediaPlayer) != null) {
            cyberPlayer.setExternalInfo(str, obj);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoURI(Uri uri, Map<String, String> map) {
        setVideoURI(uri, map, null);
    }

    private boolean isMp4WebVideo(String str) {
        if (!str.startsWith("http://") && !str.startsWith("https://")) {
            return false;
        }
        int lastIndexOf = str.lastIndexOf(".");
        int lastIndexOf2 = str.lastIndexOf(DefaultHlsExtractorFactory.MP4_FILE_EXTENSION);
        if (lastIndexOf == -1 || lastIndexOf2 == -1 || lastIndexOf != lastIndexOf2) {
            return false;
        }
        return true;
    }

    public void checkContext(Context context) {
        if (context != null) {
            this.appContext = context.getApplicationContext();
        } else {
            CyberLog.e(TAG, "Context not be null");
        }
    }

    public CyberPlayer createPlayer(int i) {
        int i2 = this.mDecodeMode;
        if (i2 == 3 || i2 < 0 || i2 > 4) {
            this.mDecodeMode = 0;
        }
        printCommonLog(1, "createplayer : " + i);
        return new CyberPlayer(this.mDecodeMode, null);
    }

    public void destroyPlayer(boolean z) {
        destroyPlayer(z, true);
    }

    public void enableCache(String str) {
        this.cacheDir = str;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void getMediaRuntimeInfo(CyberPlayerManager.OnMediaRuntimeInfoListener onMediaRuntimeInfoListener) {
        getMediaRuntimeInfo(100, onMediaRuntimeInfoListener);
    }

    public void initView(int i) {
        int hashCode;
        destroyView();
        createView(i);
        Object[] objArr = new Object[1];
        View view2 = this.renderView;
        if (view2 == null) {
            hashCode = 0;
        } else {
            hashCode = view2.hashCode();
        }
        objArr[0] = Integer.valueOf(hashCode);
        printCommonLog(1, String.format("rendView hashCode = %d", objArr));
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void muteOrUnmuteAudio(boolean z) {
        this.mIsAudioMuted = z;
        printCommonLog(1, "muteOrUnmuteAudio flag:" + z);
        CyberPlayer cyberPlayer = this.mediaPlayer;
        if (cyberPlayer != null) {
            cyberPlayer.muteOrUnmuteAudio(z);
        } else {
            printCommonLog(1, "muteOrUnmuteAudio must call after setVideoPath or setVideoURI");
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void seekTo(int i) {
        if (i >= 0 && getDuration() != 0) {
            printCommonLog(1, "seekTo");
            OnSeekStartListener onSeekStartListener = this.onSeekStartListener;
            if (onSeekStartListener != null) {
                onSeekStartListener.onSeekStart();
            }
            seekToInternal(i);
        }
    }

    public void seekToInternal(int i) {
        if (isInPlaybackState()) {
            this.mediaPlayer.seekTo(i);
            this.seekWhenPrepared = 0;
            return;
        }
        this.seekWhenPrepared = i;
    }

    public void setCurPlayerState(PlayerState playerState) {
        this.curPlayerState = playerState;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setDecodeMode(int i) {
        this.mDecodeMode = i;
    }

    public void setEnableDetachedSurfaceTextureView(boolean z) {
        this.enableDetachedSurfaceTextureView = z;
    }

    public void setEnableMediaCodec(boolean z) {
        this.enableMediaCodec = z;
    }

    public void setHttpProxy(String str) {
        this.httpProxy = str;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        CyberPlayer cyberPlayer = this.mediaPlayer;
        if (cyberPlayer != null && this.curPlayerState != PlayerState.ERROR) {
            cyberPlayer.setLooping(z);
        }
        this.looping = z;
    }

    public void setOnBufferingEndListener(OnBufferingEndListener onBufferingEndListener) {
        this.onBufferingEndListener = onBufferingEndListener;
    }

    public void setOnBufferingStartListener(OnBufferingStartListener onBufferingStartListener) {
        this.onBufferingStartListener = onBufferingStartListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnBufferingUpdateListener(CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.onBufferingUpdateListener = onBufferingUpdateListener;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.onCompletionListener = onCompletionListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.onErrorListener = onErrorListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        this.onInfoListener = onInfoListener;
    }

    public void setOnPitchYawRollListener(OnPitchYawRollListener onPitchYawRollListener) {
        this.onPitchYawRoll = onPitchYawRollListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.onPreparedListener = onPreparedListener;
    }

    public void setOnRenderStartListener(OnRenderStartListener onRenderStartListener) {
        this.onRenderStartListener = onRenderStartListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        this.onSeekCompleteListener = onSeekCompleteListener;
    }

    public void setOnSeekStartListener(OnSeekStartListener onSeekStartListener) {
        this.onSeekStartListener = onSeekStartListener;
    }

    public void setOnSurfaceReadyListener(OnSurfaceReadyListener onSurfaceReadyListener) {
        this.onSurfaceReadyListener = onSurfaceReadyListener;
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        super.setOnTouchListener(onTouchListener);
        this.onTouchListener = onTouchListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnVideoSizeChangedListener(CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.onVideoSizeChangeListener = onVideoSizeChangedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setPlayJson(String str) {
        CyberPlayer cyberPlayer = this.mediaPlayer;
        if (cyberPlayer != null) {
            cyberPlayer.setPlayJson(str);
        }
    }

    public void setPlayerType(int i) {
        this.playerType = i;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setRemote(boolean z) {
        this.mRemote = z;
    }

    public void setScaleType(int i) {
        this.curScaleType = i;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setSpeed(float f) {
        printCommonLog(1, "setSpeed()");
        this.mSpeed = f;
        CyberPlayer cyberPlayer = this.mediaPlayer;
        if (cyberPlayer != null) {
            cyberPlayer.setSpeed(f);
        } else {
            printCommonLog(1, "setSpeed must call after setVideoPath or setVideoURI");
        }
    }

    public void setVideoName(String str) {
        printCommonLog(1, "videoName:" + str);
        this.lastVideoName = this.videoName;
        this.videoName = str;
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    public void setViewType(int i) {
        this.viewType = i;
    }

    public void setVolume(float f) {
        CyberPlayer cyberPlayer = this.mediaPlayer;
        if (cyberPlayer != null) {
            cyberPlayer.setVolume(f, f);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void changeProxyDynamic(String str) {
        String str2;
        if (this.mediaPlayer == null || !TextUtils.isEmpty(Utils.getSystemHttpProxy())) {
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
            this.mediaPlayer.changeProxyDynamic(str, true);
        } else if (TextUtils.isEmpty(str2)) {
            return;
        } else {
            this.mediaPlayer.changeProxyDynamic(null, false);
        }
        this.mediaPlayer.seekTo(getCurrentPosition() + ErrorCode.SERVER_ERROR);
        HashMap<String, String> hashMap2 = this.mOptions;
        if (hashMap2 != null) {
            hashMap2.put(CyberPlayerManager.OPT_HTTP_PROXY, str);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void destory() {
        destroy();
    }

    public void destroyView() {
        CyberPlayer cyberPlayer = this.mediaPlayer;
        if (cyberPlayer != null) {
            cyberPlayer.setDisplay(null);
        }
        View view2 = this.renderView;
        if (view2 != null) {
            removeView(view2);
            this.renderView = null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getCurrentPosition() {
        if (isInPlaybackState()) {
            return this.mediaPlayer.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getDecodeMode() {
        return this.mDecodeMode;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getDuration() {
        if (isInPlaybackState()) {
            return this.mediaPlayer.getDuration();
        }
        return -1;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public MediaInfo getMediaInfo() {
        CyberPlayer cyberPlayer = this.mediaPlayer;
        if (cyberPlayer == null) {
            return null;
        }
        return cyberPlayer.getMediaInfo();
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public long getPlayedTime() {
        PlayerState playerState;
        CyberPlayer cyberPlayer = this.mediaPlayer;
        if (cyberPlayer != null && (playerState = this.curPlayerState) != PlayerState.IDLE && playerState != PlayerState.PREPARING) {
            return cyberPlayer.getPlayedTime();
        }
        return -1L;
    }

    public int getPlayerType() {
        return this.playerType;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getVideoHeight() {
        return this.mVideoHeight;
    }

    public Uri getVideoUri() {
        return this.uri;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getVideoWidth() {
        return this.mVideoWidth;
    }

    public int getViewType() {
        return this.viewType;
    }

    public void initVariable() {
        this.seekWhenPrepared = 0;
        this.seekModeWhenPrepared = 3;
        this.pauseBufferingWhenPrepared = false;
    }

    public boolean is23DReady() {
        return this.b2DVideo;
    }

    public boolean isAllReady() {
        if (this.renderView != null && this.mediaPlayer != null && is23DReady()) {
            return true;
        }
        return false;
    }

    public boolean isEnableDetachedSurfaceTextureView() {
        return this.enableDetachedSurfaceTextureView;
    }

    public boolean isEnableMediaCodec() {
        return this.enableMediaCodec;
    }

    public boolean isInPlaybackState() {
        PlayerState playerState;
        if (this.mediaPlayer != null && (playerState = this.curPlayerState) != PlayerState.ERROR && playerState != PlayerState.IDLE && playerState != PlayerState.PREPARING) {
            return true;
        }
        return false;
    }

    public boolean isLooping() {
        return this.looping;
    }

    public boolean isPlayerIdle() {
        if (this.mediaPlayer != null && this.curPlayerState == PlayerState.IDLE) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public boolean isPlaying() {
        if (isInPlaybackState() && this.mediaPlayer.isPlaying()) {
            return true;
        }
        return false;
    }

    public boolean isSurfaceReady() {
        if (!this.b2DVideo && this.surface != null) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        printCommonLog(1, DownloadStatisticConstants.UBC_TYPE_PAUSE);
        pausePlayer();
    }

    public void pauseBuffering() {
        printCommonLog(1, "pauseBuffering");
        if (isInPlaybackState()) {
            printCommonLog(1, "current state is in playback state ");
        } else {
            this.pauseBufferingWhenPrepared = true;
        }
    }

    public void pausePlayer() {
        if (isInPlaybackState() && (this.mediaPlayer.isPlaying() || this.curPlayerState == PlayerState.PREPARED)) {
            printCommonLog(1, "pausePlayer");
            this.mediaPlayer.pause();
            setCurPlayerState(PlayerState.PAUSED);
        }
        this.tarPlayerState = PlayerState.PAUSED;
    }

    public void reStart() {
        this.isRestart = true;
        setVideoName(this.videoName);
        setVideoURI(this.uri);
        start();
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void reset() {
        this.mIsAudioMuted = false;
        this.mSpeed = 1.0f;
        resetPlayer();
    }

    public void resetPlayer() {
        CyberPlayer cyberPlayer = this.mediaPlayer;
        if (cyberPlayer != null) {
            cyberPlayer.reset();
            this.mediaPlayer.setSurface(this.surface);
        }
        setCurPlayerState(PlayerState.IDLE);
        this.tarPlayerState = PlayerState.IDLE;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        printCommonLog(1, "start");
        startPlayer();
        resumeRender();
    }

    public void startPlayer() {
        if (isInPlaybackState()) {
            this.mediaPlayer.start();
            setCurPlayerState(PlayerState.PLAYING);
        }
        this.tarPlayerState = PlayerState.PLAYING;
        printCommonLog(1, "startPlayer");
    }

    public void stop() {
        printCommonLog(1, "stop");
        destroyPlayer(false);
        pauseRender();
        HashMap<String, String> hashMap = this.mOptions;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        stop();
    }

    public void destroy() {
        printCommonLog(1, "destroy");
        HashMap<String, String> hashMap = this.mOptions;
        if (hashMap != null) {
            hashMap.clear();
        }
        destroyPlayer(false);
        destroyView();
        destroyRender();
        this.surface = null;
        this.onCompletionListener = null;
        this.onPreparedListener = null;
        this.onBufferingUpdateListener = null;
        this.onSeekStartListener = null;
        this.onSeekCompleteListener = null;
        this.onInfoListener = null;
        this.onBufferingStartListener = null;
        this.onBufferingEndListener = null;
        this.onRenderStartListener = null;
        this.onSurfaceReadyListener = null;
        this.onVideoSizeChangeListener = null;
        this.onErrorListener = null;
        this.onClickListener = null;
    }

    public boolean init2D() {
        this.b2DVideo = true;
        if (this.playerType == 0) {
            this.playerType = 1;
        }
        if (this.viewType == 0) {
            this.viewType = 1;
        }
        printCommonLog(1, String.format("playerType:" + this.playerType + " interactiveMode:" + this.interactiveMode + " displayMode:" + this.displayMode + " sourceType:" + this.sourceType + " viewType:" + this.viewType, new Object[0]));
        initView(this.viewType);
        return true;
    }

    public void initPlayer(int i) {
        boolean z;
        if (this.lastUri != null) {
            z = true;
        } else {
            z = false;
        }
        destroyPlayer(z, false);
        ((AudioManager) this.appContext.getSystemService("audio")).requestAudioFocus(null, 3, 1);
        this.mediaPlayer = createPlayer(i);
        HashMap<String, String> hashMap = this.mOptions;
        if (hashMap != null) {
            for (String str : hashMap.keySet()) {
                this.mediaPlayer.setOption(str, this.mOptions.get(str));
            }
        }
        Surface surface = this.surface;
        if (surface != null) {
            this.mediaPlayer.setSurface(surface);
        }
        this.mediaPlayer.setOnPreparedListener(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.cyberplayer.sdk.vrplayer.MovieView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                MovieView.this.printCommonLog(1, "onPrepared");
                MovieView.this.setCurPlayerState(PlayerState.PREPARED);
                MovieView movieView = MovieView.this;
                movieView.mediaPlayer.setLooping(movieView.looping);
                CyberPlayerManager.OnPreparedListener onPreparedListener = MovieView.this.onPreparedListener;
                if (onPreparedListener != null) {
                    onPreparedListener.onPrepared();
                }
                MovieView movieView2 = MovieView.this;
                int i2 = movieView2.seekWhenPrepared;
                if (i2 != 0) {
                    movieView2.seekTo(i2, movieView2.seekModeWhenPrepared);
                }
                MovieView movieView3 = MovieView.this;
                if (movieView3.tarPlayerState == PlayerState.PLAYING) {
                    movieView3.start();
                } else if (movieView3.pauseBufferingWhenPrepared) {
                    movieView3.pauseBuffering();
                }
            }
        });
        this.mediaPlayer.setOnVideoSizeChangedListener(new CyberPlayerManager.OnVideoSizeChangedListener() { // from class: com.baidu.cyberplayer.sdk.vrplayer.MovieView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
            public void onVideoSizeChanged(int i2, int i3, int i4, int i5) {
                MovieView.this.printCommonLog(1, String.format("onVideoSizeChanged,w=%d,h=%d", Integer.valueOf(i2), Integer.valueOf(i3)));
                if (i2 != 0 && i3 != 0) {
                    MovieView.this.on23DVideoSizeChange(i2, i3, i4, i5);
                    MovieView.this.requestLayout();
                    MovieView.this.mVideoWidth = i2;
                    MovieView.this.mVideoHeight = i3;
                    CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener = MovieView.this.onVideoSizeChangeListener;
                    if (onVideoSizeChangedListener != null) {
                        onVideoSizeChangedListener.onVideoSizeChanged(i2, i3, i4, i5);
                    }
                }
            }
        });
        this.mediaPlayer.setOnCompletionListener(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.cyberplayer.sdk.vrplayer.MovieView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                MovieView.this.printCommonLog(1, "onCompletion");
                MovieView.this.setCurPlayerState(PlayerState.PLAYBACK_COMPLETED);
                MovieView movieView = MovieView.this;
                movieView.tarPlayerState = PlayerState.PLAYBACK_COMPLETED;
                CyberPlayerManager.OnCompletionListener onCompletionListener = movieView.onCompletionListener;
                if (onCompletionListener != null) {
                    onCompletionListener.onCompletion();
                }
            }
        });
        this.mediaPlayer.setOnErrorListener(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.cyberplayer.sdk.vrplayer.MovieView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i3, Object obj) {
                MovieView.this.printCommonLog(1, String.format("onError:err=%d,detail=%d", Integer.valueOf(i2), Integer.valueOf(i3)));
                if (i2 == -10000 && (i3 == 11 || i3 == 101 || i3 == -110 || i3 == -5)) {
                    i3 = 300;
                }
                MovieView.this.handleError(i2, i3);
                return true;
            }
        });
        this.mediaPlayer.setOnInfoListener(new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.cyberplayer.sdk.vrplayer.MovieView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i3, Object obj) {
                MovieView.this.printCommonLog(1, String.format("onInfo:what=%d,extra=%d", Integer.valueOf(i2), Integer.valueOf(i3)));
                CyberPlayerManager.OnInfoListener onInfoListener = MovieView.this.onInfoListener;
                if (onInfoListener != null) {
                    onInfoListener.onInfo(i2, i3, null);
                }
                if (i2 == 701) {
                    MovieView.this.printCommonLog(2, "onBufferingStart");
                    OnBufferingStartListener onBufferingStartListener = MovieView.this.onBufferingStartListener;
                    if (onBufferingStartListener != null) {
                        onBufferingStartListener.onBufferingStart();
                    }
                } else if (i2 == 702) {
                    MovieView.this.printCommonLog(2, "onBufferingEnd");
                    OnBufferingEndListener onBufferingEndListener = MovieView.this.onBufferingEndListener;
                    if (onBufferingEndListener != null) {
                        onBufferingEndListener.onBufferingEnd();
                    }
                } else if (i2 == 3) {
                    MovieView.this.printCommonLog(1, "onRenderStart");
                    OnRenderStartListener onRenderStartListener = MovieView.this.onRenderStartListener;
                    if (onRenderStartListener != null) {
                        onRenderStartListener.onRenderStart();
                    }
                }
                return true;
            }
        });
        this.mediaPlayer.setOnBufferingUpdateListener(new CyberPlayerManager.OnBufferingUpdateListener() { // from class: com.baidu.cyberplayer.sdk.vrplayer.MovieView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
            public void onBufferingUpdate(int i2) {
                MovieView.this.printCommonLog(2, String.format("onBufferingUpdate:percent=%d", Integer.valueOf(i2)));
                CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener = MovieView.this.onBufferingUpdateListener;
                if (onBufferingUpdateListener != null) {
                    onBufferingUpdateListener.onBufferingUpdate(i2);
                }
            }
        });
        this.mediaPlayer.setOnSeekCompleteListener(new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.cyberplayer.sdk.vrplayer.MovieView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                MovieView.this.printCommonLog(1, "onSeekComplete");
                CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener = MovieView.this.onSeekCompleteListener;
                if (onSeekCompleteListener != null) {
                    onSeekCompleteListener.onSeekComplete();
                }
            }
        });
    }

    public void on23DVideoSizeChange(int i, int i2, int i3, int i4) {
        if (i != 0 && i2 != 0 && this.renderView != null) {
            printCommonLog(1, "on23DVideoSizeChanged w:" + i + " h:" + i2);
        }
    }

    public void openVideo() {
        if (this.uri != null && isSurfaceReady()) {
            printCommonLog(1, String.format("uri:%s ", this.uri));
            initPlayer(this.playerType);
            initVariable();
            try {
                if (Build.VERSION.SDK_INT >= 14) {
                    this.mediaPlayer.setDataSource(this.appContext, this.uri, this.headers);
                } else {
                    this.mediaPlayer.setDataSource(this.uri.toString());
                }
                if (this.b2DVideo) {
                    printCommonLog(1, "video is 2d");
                } else {
                    this.mediaPlayer.setSurface(this.surface);
                }
                this.mediaPlayer.prepareAsync();
                if (this.mIsAudioMuted) {
                    muteOrUnmuteAudio(this.mIsAudioMuted);
                }
                setCurPlayerState(PlayerState.PREPARING);
            } catch (Exception unused) {
                handleError(1, 0);
            }
            requestLayout();
            invalidate();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoURI(Uri uri, Map<String, String> map, Map<String, String> map2) {
        printCommonLog(1, "videoURI:" + uri.toString());
        if (map2 != null) {
            this.mOptions.putAll(map2);
        }
        this.lastUri = this.uri;
        this.uri = uri;
        this.headers = map;
        openVideo();
    }
}
