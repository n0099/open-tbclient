package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.StateMachineVerify;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.cyberplayer.sdk.statistics.DpStatSessionImpl;
import com.baidu.cyberplayer.sdk.statistics.UbcSessionUploader;
import com.baidu.cyberplayer.sdk.utils.UrlUtils;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class MediaPlayerImpl extends PlayerProvider implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener {
    public static final int ERROR_SWITCH_MEDIA_SOURCE = -100;
    public static final float INVALID_SPEED = -1.0f;
    public static final int STATE_ERROR = -1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_PAUSED = 4;
    public static final int STATE_PLAYBACK_COMPLETED = 5;
    public static final int STATE_PLAYING = 3;
    public static final int STATE_PREPARED = 2;
    public static final int STATE_PREPARING = 1;
    public static final String TAG = "MediaPlayerImpl";
    public CyberPlayerManager.OnBufferingUpdateListener mBufferingUpdateListener;
    public CyberPlayerManager.OnCompletionListener mCompletionListener;
    public int mDuration;
    public boolean mEnableStateMachine;
    public CyberPlayerManager.OnErrorListener mErrorListener;
    public CyberPlayerManager.OnInfoListener mInfoListener;
    public boolean mIsAudioMuted;
    public boolean mIsDebugMode;
    public boolean mIsUserClickStart;
    public CyberPlayerManager.OnMediaSourceChangedListener mMediaSourceChangedListener;
    public boolean mOnFirstDisplay;
    public long mPauseStartTime;
    public MediaPlayer mPlayer;
    public int mPreparedCostTime;
    public CyberPlayerManager.OnPreparedListener mPreparedListener;
    public long mRealPlayedTime;
    public CyberPlayerManager.OnSeekCompleteListener mSeekCompleteListener;
    public DpStatSessionImpl mSessionImpl;
    public long mStartPlayTime;
    public long mStartPrepareTime;
    public long mTotalPauseTime;
    public String mUrl;
    public StateMachineVerify mVerifier;
    public CyberPlayerManager.OnVideoSizeChangedListener mVideoSizeChangeListener;
    public long mSeekToPosition = -1;
    public long mSeekWhenPrepared = -1;
    public int mSeekMode = 3;
    public int mCurrentState = 0;
    public int mTargetState = 0;
    public float mRequestSpeed = -1.0f;
    public Map<String, String> mOptions = new HashMap();

    private boolean checkInvalidOperationError(int i) {
        return i == -10002 || i == -10001 || i == -38;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void changeProxyDynamic(String str, boolean z) {
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getDecodeMode() {
        return 4;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public long getDownloadSpeed() {
        return 0L;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void getMediaRuntimeInfo(int i, CyberPlayerManager.OnMediaRuntimeInfoListener onMediaRuntimeInfoListener) {
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public String getPlayerConfigOptions() {
        return "";
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isRemotePlayer() {
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void stepToNextFrame() {
    }

    public MediaPlayerImpl() {
        boolean z = false;
        this.mIsDebugMode = false;
        boolean cfgBoolValueFast = CyberCfgManager.getInstance().getCfgBoolValueFast("enable_mp_record_state", false);
        boolean cfgBoolValueFast2 = CyberCfgManager.getInstance().getCfgBoolValueFast("enable_mp_state_forbid", false);
        this.mEnableStateMachine = (cfgBoolValueFast || cfgBoolValueFast2) ? true : true;
        StateMachineVerify stateMachineVerify = new StateMachineVerify(cfgBoolValueFast, cfgBoolValueFast2);
        this.mVerifier = stateMachineVerify;
        stateMachineVerify.setState(StateMachineVerify.State.IDLE);
        this.mIsDebugMode = CyberPlayerManager.isAppInDebugMode();
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.mPlayer = mediaPlayer;
        mediaPlayer.setOnPreparedListener(this);
        this.mPlayer.setOnCompletionListener(this);
        this.mPlayer.setOnBufferingUpdateListener(this);
        this.mPlayer.setOnSeekCompleteListener(this);
        this.mPlayer.setOnVideoSizeChangedListener(this);
        this.mPlayer.setOnErrorListener(this);
        this.mPlayer.setOnInfoListener(this);
        this.mSessionImpl = new DpStatSessionImpl();
        init();
        this.mOptions.clear();
        CyberLog.i(TAG, "isAppInDebugMode:" + CyberPlayerManager.isAppInDebugMode());
    }

    private int chooseUbcId() {
        if (!this.mSessionImpl.getIsBaiduUrl()) {
            return -1007;
        }
        if (hasException()) {
            return -1006;
        }
        if (!this.mSessionImpl.getIsUserStarted()) {
            return -1005;
        }
        if (CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_GRAY_RELEASE_SOLE_UBCID, false) && this.mSessionImpl.getIsGrayRelease()) {
            return -1004;
        }
        return -1009;
    }

    private void uploadSession() {
        DpStatSessionImpl dpStatSessionImpl = this.mSessionImpl;
        if (dpStatSessionImpl != null && !dpStatSessionImpl.getIsUpload()) {
            if (this.mStartPrepareTime > 0 || this.mIsUserClickStart) {
                this.mSessionImpl.initPlaySessionCommon(this);
                this.mSessionImpl.collectMediaFormatInfo(this);
                this.mSessionImpl.uploadSessionWithServerType(this, DpStatConstants.SERVER_TYPE_DUPLAYER_MONITOR);
                UbcSessionUploader.getInstance().upload(this.mSessionImpl.getMediaPlayerSessionDataForUBC(DpStatConstants.SERVER_TYPE_DUPLAYER_MONITOR), "ubc", chooseUbcId());
            }
            this.mSessionImpl.clear();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getCurrentPosition() {
        if (this.mPlayer != null) {
            long j = this.mSeekToPosition;
            if (j > -1) {
                return (int) j;
            }
            int i = this.mCurrentState;
            if (i != 0 && i != 1 && i != 2 && i != -1 && methodVerify(getCurrentMethodName())) {
                try {
                    return this.mPlayer.getCurrentPosition();
                } catch (IllegalStateException unused) {
                    CyberLog.e(TAG, "getCurrentPosition IllegalStateException error");
                }
            }
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void reset() {
        CyberLog.i(TAG, "reset");
        uploadSession();
        this.mSeekWhenPrepared = -1L;
        this.mSeekToPosition = -1L;
        this.mCurrentState = 0;
        this.mTargetState = 0;
        init();
        if (this.mPlayer != null && methodVerify(getCurrentMethodName())) {
            this.mVerifier.setState(StateMachineVerify.State.IDLE);
            try {
                this.mPlayer.reset();
            } catch (IllegalStateException unused) {
                CyberLog.e(TAG, "reset IllegalStateException error");
            }
        }
        DpStatSessionImpl dpStatSessionImpl = this.mSessionImpl;
        if (dpStatSessionImpl != null) {
            dpStatSessionImpl.clear();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void stop() {
        CyberLog.i(TAG, "stop");
        if (this.mPlayer != null && methodVerify(getCurrentMethodName())) {
            StateMachineVerify.State state = this.mVerifier.getState();
            this.mVerifier.setState(StateMachineVerify.State.STOPPED);
            this.mSeekWhenPrepared = -1L;
            this.mCurrentState = 0;
            this.mTargetState = 0;
            this.mRequestSpeed = -1.0f;
            try {
                this.mPlayer.stop();
            } catch (IllegalStateException e) {
                illegalStateHandle(e, -10002, state);
            } catch (Exception unused) {
            }
        }
    }

    private String getCurrentMethodName() {
        if (!this.mEnableStateMachine) {
            return "";
        }
        return new Exception().getStackTrace()[1].getMethodName();
    }

    private boolean hasException() {
        if (this.mCurrentState != -1 && (!this.mSessionImpl.getIsUserStarted() || this.mOnFirstDisplay)) {
            return false;
        }
        return true;
    }

    private void init() {
        this.mStartPrepareTime = -1L;
        this.mPreparedCostTime = 0;
        this.mStartPlayTime = -1L;
        this.mTotalPauseTime = 0L;
        this.mRealPlayedTime = -1L;
        this.mIsUserClickStart = false;
        this.mOnFirstDisplay = false;
        this.mRequestSpeed = -1.0f;
    }

    private boolean isInPlaybackState() {
        int i;
        if (this.mPlayer != null && (i = this.mCurrentState) != -1 && i != 0 && i != 1) {
            return true;
        }
        return false;
    }

    private boolean isOnPlaying() {
        if (this.mPlayer != null && methodVerify(getCurrentMethodName())) {
            return this.mPlayer.isPlaying();
        }
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getCurrentPositionSync() {
        return getCurrentPosition();
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getDuration() {
        if (this.mPlayer != null) {
            return this.mDuration;
        }
        return -1;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public long getPlayedTime() {
        if (this.mStartPlayTime > 0) {
            if (this.mPauseStartTime > 0) {
                this.mTotalPauseTime += System.currentTimeMillis() - this.mPauseStartTime;
            }
            this.mRealPlayedTime = (System.currentTimeMillis() - this.mStartPlayTime) - this.mTotalPauseTime;
        }
        return this.mRealPlayedTime;
    }

    public long getStartPlayTime() {
        return this.mStartPlayTime;
    }

    public String getUrl() {
        return this.mUrl;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getVideoHeight() {
        int i = this.mCurrentState;
        if (i == 1 || i == -1 || this.mPlayer == null || !methodVerify(getCurrentMethodName())) {
            return 0;
        }
        try {
            return this.mPlayer.getVideoHeight();
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getVideoWidth() {
        int i = this.mCurrentState;
        if (i == 1 || i == -1 || this.mPlayer == null || !methodVerify(getCurrentMethodName())) {
            return 0;
        }
        try {
            return this.mPlayer.getVideoWidth();
        } catch (Exception unused) {
            return 0;
        }
    }

    public boolean isAudioMuted() {
        return this.mIsAudioMuted;
    }

    public boolean isFirstDisp() {
        return this.mOnFirstDisplay;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isLooping() {
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null && mediaPlayer.isLooping()) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isPlaying() {
        if (isInPlaybackState() && this.mCurrentState == 3) {
            return true;
        }
        return false;
    }

    public boolean isUserClickStart() {
        return this.mIsUserClickStart;
    }

    private Uri handleUri(Uri uri, Map<String, String> map) {
        if (uri != null && map != null && !map.isEmpty()) {
            String str = map.get(CyberPlayerManager.OPT_URL_REPLACE_HOST);
            if (TextUtils.equals(map.get(CyberPlayerManager.OPT_URL_REPLACE_HOST_ENABLE), "1")) {
                uri = UrlUtils.replaceFreeHost(uri, str);
            }
            return UrlUtils.addCdnTag(uri, map.get("opt-url-add-query"));
        }
        return uri;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void seekTo(long j, int i) {
        CyberLog.i(TAG, "seekTo");
        if (isInPlaybackState()) {
            if (methodVerify(getCurrentMethodName())) {
                try {
                    if (Build.VERSION.SDK_INT >= 26) {
                        this.mPlayer.seekTo((int) j, i);
                    } else {
                        this.mPlayer.seekTo((int) j);
                    }
                } catch (IllegalStateException e) {
                    illegalStateHandle(e, -10002, this.mVerifier.getState());
                } catch (Exception unused) {
                }
            }
        } else {
            this.mSeekWhenPrepared = j;
            this.mSeekMode = i;
        }
        this.mSeekToPosition = j;
    }

    private void illegalStateHandle(IllegalStateException illegalStateException, int i, StateMachineVerify.State state) throws IllegalStateException {
        if (!this.mIsDebugMode) {
            onError(this.mPlayer, i, state.ordinal());
            return;
        }
        illegalStateException.printStackTrace();
        throw new IllegalStateException("Error Call in State " + state.toString());
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        CyberLog.i(TAG, "onVideoSizeChanged");
        CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener = this.mVideoSizeChangeListener;
        if (onVideoSizeChangedListener != null) {
            onVideoSizeChangedListener.onVideoSizeChanged(i, i2, 1, 1);
        }
    }

    private boolean methodVerify(String str) {
        StateMachineVerify stateMachineVerify = this.mVerifier;
        if (stateMachineVerify != null) {
            return stateMachineVerify.methodCall(str);
        }
        return true;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        CyberLog.i(TAG, "onCompletion");
        this.mCurrentState = 5;
        this.mTargetState = 5;
        StateMachineVerify stateMachineVerify = this.mVerifier;
        if (stateMachineVerify != null) {
            stateMachineVerify.setState(StateMachineVerify.State.PLAYBACK_COMPLETE);
        }
        CyberPlayerManager.OnCompletionListener onCompletionListener = this.mCompletionListener;
        if (onCompletionListener != null) {
            onCompletionListener.onCompletion();
        }
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        this.mSeekToPosition = -1L;
        CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener = this.mSeekCompleteListener;
        if (onSeekCompleteListener != null) {
            onSeekCompleteListener.onSeekComplete();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void seekTo(long j) {
        seekTo(j, 3);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDisplay(SurfaceHolder surfaceHolder) {
        CyberLog.i(TAG, "setDisplay");
        if (this.mPlayer != null && methodVerify(getCurrentMethodName())) {
            try {
                this.mPlayer.setDisplay(surfaceHolder);
            } catch (IllegalStateException e) {
                illegalStateHandle(e, -10000, this.mVerifier.getState());
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setLooping(boolean z) {
        if (this.mPlayer != null && methodVerify(getCurrentMethodName())) {
            this.mPlayer.setLooping(z);
            this.mSessionImpl.add(DpStatConstants.SESSION_TYPE_PLAY_COMMON, DpStatConstants.KEY_IS_LOOP_PLAYED, z ? 1 : 0);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnBufferingUpdateListener(CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.mBufferingUpdateListener = onBufferingUpdateListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.mCompletionListener = onCompletionListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.mErrorListener = onErrorListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        this.mInfoListener = onInfoListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnMediaSourceChangedListener(CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener) {
        this.mMediaSourceChangedListener = onMediaSourceChangedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.mPreparedListener = onPreparedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        this.mSeekCompleteListener = onSeekCompleteListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnVideoSizeChangedListener(CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.mVideoSizeChangeListener = onVideoSizeChangedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOptions(Map<String, String> map) {
        super.setOptions(map);
        this.mOptions.putAll(map);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setScreenOnWhilePlaying(boolean z) {
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setScreenOnWhilePlaying(z);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setSurface(Surface surface) {
        CyberLog.i(TAG, "setSurface");
        if (this.mPlayer != null && methodVerify(getCurrentMethodName())) {
            try {
                this.mPlayer.setSurface(surface);
            } catch (IllegalStateException e) {
                illegalStateHandle(e, -10000, this.mVerifier.getState());
            } catch (Exception unused) {
            }
        }
    }

    public void heartBeatUploadSession(int i) {
        DpStatSessionImpl dpStatSessionImpl = this.mSessionImpl;
        if (dpStatSessionImpl != null && !dpStatSessionImpl.getIsUpload()) {
            if (this.mStartPrepareTime > 0 || this.mIsUserClickStart) {
                this.mSessionImpl.initPlaySessionCommon(this);
                this.mSessionImpl.collectMediaFormatInfo(this);
                this.mSessionImpl.add(DpStatConstants.SESSION_TYPE_MEDIA_DATA_UTILIZATION_RATE, "upload_download_data_n", i);
                this.mSessionImpl.uploadSessionWithServerType(this, DpStatConstants.SERVER_TYPE_DUPLAYER_OTHER_DATA);
                UbcSessionUploader.getInstance().upload(this.mSessionImpl.getMediaPlayerSessionDataForUBC(DpStatConstants.SERVER_TYPE_DUPLAYER_OTHER_DATA), "ubc", -1008);
            }
            this.mSessionImpl.clear();
        }
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        CyberLog.i(TAG, "onPrepared");
        this.mCurrentState = 2;
        StateMachineVerify stateMachineVerify = this.mVerifier;
        if (stateMachineVerify != null) {
            stateMachineVerify.setState(StateMachineVerify.State.PREPARED);
        }
        MediaPlayer mediaPlayer2 = this.mPlayer;
        if (mediaPlayer2 != null) {
            this.mDuration = mediaPlayer2.getDuration();
        }
        CyberPlayerManager.OnPreparedListener onPreparedListener = this.mPreparedListener;
        if (onPreparedListener != null) {
            onPreparedListener.onPrepared();
        }
        int round = Math.round((float) (System.currentTimeMillis() - this.mStartPrepareTime));
        this.mPreparedCostTime = round;
        this.mSessionImpl.add(DpStatConstants.SESSION_TYPE_FIRST_SCREEN, DpStatConstants.KEY_PREPARED, round);
        long j = this.mSeekWhenPrepared;
        if (j > 0) {
            seekTo(j, this.mSeekMode);
        }
        this.mSeekWhenPrepared = -1L;
        if (this.mTargetState == 3) {
            start();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(String str) {
        CyberLog.d(TAG, "setDataSource:" + str);
        if (this.mPlayer != null && methodVerify(getCurrentMethodName())) {
            String defaultUrlStringFromMPD = MPDParser.getDefaultUrlStringFromMPD(str);
            this.mUrl = defaultUrlStringFromMPD;
            try {
                this.mPlayer.setDataSource(defaultUrlStringFromMPD);
            } catch (IOException unused) {
                onError(this.mPlayer, -1004, -1004);
            } catch (IllegalStateException e) {
                illegalStateHandle(e, -10001, this.mVerifier.getState());
            } catch (Exception unused2) {
            }
            this.mVerifier.setState(StateMachineVerify.State.INITIALIZED);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setSpeed(float f) {
        if (f >= 0.0f && f <= 4.0f && this.mPlayer != null && Build.VERSION.SDK_INT >= 23) {
            try {
                if ((isOnPlaying() || isPlaying()) && methodVerify(getCurrentMethodName())) {
                    CyberLog.i(TAG, "setSpeed to " + f);
                    this.mPlayer.setPlaybackParams(this.mPlayer.getPlaybackParams().setSpeed(f));
                    this.mRequestSpeed = -1.0f;
                    return;
                }
                this.mRequestSpeed = f;
            } catch (IllegalStateException unused) {
                CyberLog.e(TAG, "setSpeed IllegalStateException error");
            } catch (Exception unused2) {
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void muteOrUnmuteAudio(boolean z) {
        float f;
        this.mIsAudioMuted = z;
        CyberLog.i(TAG, "muteOrUnmuteAudio flag:" + z);
        CyberLog.y(TAG, "muteOrUnmuteAudio flag:" + z);
        if (this.mPlayer == null) {
            return;
        }
        if (this.mIsAudioMuted) {
            f = 0.0f;
        } else {
            f = 1.0f;
        }
        this.mPlayer.setVolume(f, f);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(FileDescriptor fileDescriptor) {
        if (this.mPlayer != null && methodVerify(getCurrentMethodName())) {
            this.mUrl = fileDescriptor.toString();
            try {
                this.mPlayer.setDataSource(fileDescriptor);
            } catch (IOException unused) {
                onError(this.mPlayer, -1004, -1004);
            } catch (IllegalStateException e) {
                illegalStateHandle(e, -10001, this.mVerifier.getState());
            } catch (Exception unused2) {
            }
            this.mVerifier.setState(StateMachineVerify.State.INITIALIZED);
        }
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener = this.mBufferingUpdateListener;
        if (onBufferingUpdateListener != null) {
            onBufferingUpdateListener.onBufferingUpdate(i);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOption(String str, String str2) {
        super.setOption(str, str2);
        this.mOptions.put(str, str2);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setVolume(float f, float f2) {
        if (this.mPlayer != null && methodVerify(getCurrentMethodName())) {
            this.mPlayer.setVolume(f, f2);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setWakeMode(Context context, int i) {
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setWakeMode(context, i);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void switchMediaSource(int i, CyberPlayerManager.MediaSourceSwitchMode mediaSourceSwitchMode) {
        CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener = this.mMediaSourceChangedListener;
        if (onMediaSourceChangedListener != null) {
            if (mediaSourceSwitchMode == CyberPlayerManager.MediaSourceSwitchMode.MEDIASOURCE_SWITCH_ABR_MODE) {
                onMediaSourceChangedListener.onMediaSourceChanged(0, i, null);
            } else {
                onMediaSourceChangedListener.onMediaSourceChanged(-100, i, null);
            }
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        boolean z;
        String str;
        CyberLog.e(TAG, "onError: (" + i + StringUtil.ARRAY_ELEMENT_SEPARATOR + i2 + SmallTailInfo.EMOTION_SUFFIX);
        int i3 = this.mCurrentState;
        StateMachineVerify.State state = StateMachineVerify.State.IDLE;
        if (CyberCfgManager.getInstance().getCfgBoolValueFast("drop_mediaplay_stop_error", true) && this.mCurrentState == 0 && this.mTargetState == 0) {
            z = true;
        } else {
            z = false;
        }
        this.mCurrentState = -1;
        this.mTargetState = -1;
        StateMachineVerify stateMachineVerify = this.mVerifier;
        if (stateMachineVerify != null) {
            state = stateMachineVerify.getState();
            this.mVerifier.setState(StateMachineVerify.State.ERROR);
        }
        if (z) {
            return false;
        }
        if (this.mVerifier != null) {
            if (checkInvalidOperationError(i)) {
                CyberLog.e(TAG, "Invalid Operation Err, current state:" + state.toString());
                this.mSessionImpl.add(DpStatConstants.SESSION_TYPE_ERROR, DpStatConstants.KEY_STATE_TRACE, this.mVerifier.getAllStateVerifyRecord());
            }
            str = StringUtil.ARRAY_ELEMENT_SEPARATOR + state.toString();
        } else {
            str = "";
        }
        if (CyberCfgManager.getInstance().getCfgBoolValueFast(CyberCfgManager.KEY_INT_JAVA_ERROR_CODE_MAPPING, true)) {
            i = CyberErrorMapper.getInstance().mapErrNo(i);
        } else {
            this.mSessionImpl.add(DpStatConstants.SESSION_TYPE_ERROR, DpStatConstants.KEY_NEW_ERROR_CODE, CyberErrorMapper.getInstance().mapErrNo(i));
        }
        this.mSessionImpl.add(DpStatConstants.SESSION_TYPE_ERROR, "error_code", i);
        this.mSessionImpl.add(DpStatConstants.SESSION_TYPE_ERROR, "sub_code", i2);
        this.mSessionImpl.add(DpStatConstants.SESSION_TYPE_ERROR, "time", System.currentTimeMillis());
        this.mSessionImpl.add(DpStatConstants.SESSION_TYPE_ERROR, "detail", "mediaplay error(" + i + "," + i2 + "), state(" + i3 + str + SmallTailInfo.EMOTION_SUFFIX);
        CyberPlayerManager.OnErrorListener onErrorListener = this.mErrorListener;
        if (onErrorListener != null && onErrorListener.onError(i, i2, null)) {
            return true;
        }
        return false;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        CyberLog.i(TAG, "onInfo: " + i);
        if (i == 3) {
            i = 904;
            this.mOnFirstDisplay = true;
            long currentTimeMillis = (System.currentTimeMillis() - this.mStartPlayTime) + this.mPreparedCostTime;
            this.mSessionImpl.add(DpStatConstants.SESSION_TYPE_FIRST_SCREEN, DpStatConstants.KEY_FIRST_DISPLAY, currentTimeMillis);
            CyberLog.d(TAG, "MpReduce, MediaPlayerImpl firstFrameCostTime=" + currentTimeMillis);
        }
        CyberPlayerManager.OnInfoListener onInfoListener = this.mInfoListener;
        if (onInfoListener != null && onInfoListener.onInfo(i, i2, null)) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        CyberLog.d(TAG, "setDataSource uri:" + uri);
        Uri handleUri = handleUri(MPDParser.getDefaultUrlFromMPD(uri), this.mOptions);
        this.mOptions.clear();
        if (this.mPlayer != null && methodVerify(getCurrentMethodName())) {
            this.mUrl = handleUri.toString();
            try {
                this.mPlayer.setDataSource(context, handleUri, map);
            } catch (IOException unused) {
                onError(this.mPlayer, -1004, -1004);
            } catch (IllegalStateException e) {
                illegalStateHandle(e, -10001, this.mVerifier.getState());
            } catch (Exception unused2) {
            }
            this.mVerifier.setState(StateMachineVerify.State.INITIALIZED);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void pause() {
        int i;
        CyberLog.i(TAG, DownloadStatisticConstants.UBC_TYPE_PAUSE);
        if (this.mPlayer != null && ((i = this.mCurrentState) == 4 || i == 3 || i == 5)) {
            if (methodVerify(getCurrentMethodName())) {
                StateMachineVerify.State state = this.mVerifier.getState();
                this.mVerifier.setState(StateMachineVerify.State.PAUSED);
                this.mCurrentState = 4;
                try {
                    this.mPlayer.pause();
                } catch (IllegalStateException e) {
                    illegalStateHandle(e, -10002, state);
                } catch (Exception unused) {
                }
                if (this.mStartPlayTime > 0 && this.mPauseStartTime == 0) {
                    this.mPauseStartTime = System.currentTimeMillis();
                }
            }
        } else {
            CyberLog.i(TAG, "no need do pause in state:" + this.mCurrentState);
        }
        this.mTargetState = 4;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void start() {
        CyberLog.i(TAG, "start");
        if (isInPlaybackState() && methodVerify(getCurrentMethodName())) {
            this.mCurrentState = 3;
            try {
                this.mPlayer.start();
            } catch (IllegalStateException e) {
                illegalStateHandle(e, -10002, this.mVerifier.getState());
            }
            this.mVerifier.setState(StateMachineVerify.State.STARTED);
            if (Math.abs(this.mRequestSpeed - (-1.0f)) > 1.0E-6d) {
                setSpeed(this.mRequestSpeed);
            }
            if (this.mStartPlayTime == -1) {
                this.mStartPlayTime = System.currentTimeMillis();
                this.mPauseStartTime = 0L;
            }
            if (this.mPauseStartTime > 0) {
                this.mTotalPauseTime += System.currentTimeMillis() - this.mPauseStartTime;
                this.mPauseStartTime = 0L;
            }
        }
        this.mIsUserClickStart = true;
        this.mTargetState = 3;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void prepareAsync() {
        CyberLog.i(TAG, "prepareAsync");
        if (this.mPlayer != null && methodVerify(getCurrentMethodName())) {
            StateMachineVerify.State state = this.mVerifier.getState();
            this.mVerifier.setState(StateMachineVerify.State.PREPARING);
            this.mCurrentState = 1;
            if (this.mStartPrepareTime == -1) {
                this.mStartPrepareTime = System.currentTimeMillis();
            }
            try {
                this.mPlayer.prepareAsync();
            } catch (IllegalStateException e) {
                illegalStateHandle(e, -10002, state);
            } catch (Exception e2) {
                if (e2 instanceof IOException) {
                    onError(this.mPlayer, -1004, -1004);
                }
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void release() {
        CyberLog.i(TAG, "release");
        uploadSession();
        if (this.mPlayer != null) {
            this.mSeekWhenPrepared = -1L;
            this.mVerifier.setState(StateMachineVerify.State.END);
            this.mVerifier = null;
            this.mIsUserClickStart = false;
            this.mOnFirstDisplay = false;
            this.mCurrentState = 0;
            this.mTargetState = 0;
            this.mPlayer.setOnPreparedListener(null);
            this.mPlayer.setOnCompletionListener(null);
            this.mPlayer.setOnBufferingUpdateListener(null);
            this.mPlayer.setOnSeekCompleteListener(null);
            this.mPlayer.setOnVideoSizeChangedListener(null);
            this.mPlayer.setOnErrorListener(null);
            this.mPlayer.setOnInfoListener(null);
            this.mPreparedListener = null;
            this.mCompletionListener = null;
            this.mBufferingUpdateListener = null;
            this.mSeekCompleteListener = null;
            this.mVideoSizeChangeListener = null;
            this.mErrorListener = null;
            this.mInfoListener = null;
            this.mMediaSourceChangedListener = null;
            this.mPlayer.release();
            this.mPlayer = null;
            this.mRequestSpeed = -1.0f;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void sendCommand(int i, int i2, long j, String str) {
        switch (i) {
            case 1001:
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            this.mSessionImpl.add(DpStatConstants.SESSION_TYPE_STAGE_INFO, next, jSONObject.getString(next));
                        }
                        return;
                    } catch (JSONException e) {
                        e.printStackTrace();
                        return;
                    }
                }
                return;
            case 1002:
                int round = Math.round((float) (j - this.mStartPlayTime)) + this.mPreparedCostTime;
                CyberLog.i(TAG, "sendCommand COMMAND_ON_FIRST_FRAME_DRAWED firstFrameCostTime:" + round);
                this.mSessionImpl.add(DpStatConstants.SESSION_TYPE_FIRST_SCREEN, DpStatConstants.KEY_FIRST_DISPLAY, round);
                CyberPlayerManager.OnInfoListener onInfoListener = this.mInfoListener;
                if (onInfoListener != null) {
                    onInfoListener.onInfo(904, round, null);
                    return;
                }
                return;
            case 1003:
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(str);
                        Iterator<String> keys2 = jSONObject2.keys();
                        while (keys2.hasNext()) {
                            String next2 = keys2.next();
                            this.mSessionImpl.add(i2, next2, jSONObject2.getString(next2));
                        }
                        return;
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(Context context, Uri uri) {
        CyberLog.d(TAG, "setDataSource uri:" + uri);
        Uri handleUri = handleUri(MPDParser.getDefaultUrlFromMPD(uri), this.mOptions);
        this.mOptions.clear();
        if (this.mPlayer != null && methodVerify(getCurrentMethodName())) {
            this.mUrl = handleUri.toString();
            try {
                this.mPlayer.setDataSource(context, handleUri);
            } catch (IOException unused) {
                onError(this.mPlayer, -1004, -1004);
            } catch (IllegalStateException e) {
                illegalStateHandle(e, -10001, this.mVerifier.getState());
            } catch (Exception unused2) {
            }
            this.mVerifier.setState(StateMachineVerify.State.INITIALIZED);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(String str, Map<String, String> map) {
        CyberLog.d(TAG, "setDataSource:" + str);
        if (this.mPlayer != null && methodVerify(getCurrentMethodName())) {
            String defaultUrlStringFromMPD = MPDParser.getDefaultUrlStringFromMPD(str);
            this.mUrl = defaultUrlStringFromMPD;
            try {
                this.mPlayer.setDataSource(defaultUrlStringFromMPD);
            } catch (IOException unused) {
                onError(this.mPlayer, -1004, -1004);
            } catch (IllegalStateException e) {
                illegalStateHandle(e, -10001, this.mVerifier.getState());
            } catch (Exception unused2) {
            }
            this.mVerifier.setState(StateMachineVerify.State.INITIALIZED);
        }
    }
}
