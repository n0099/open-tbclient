package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import java.util.Map;
@Keep
/* loaded from: classes3.dex */
public class MediaInstanceState {
    public static final int INSTANCE_STATE_ACTIVE = 1;
    public static final int INSTANCE_STATE_IDLE = -1;
    public static final int INSTANCE_STATE_INACTIVE = 0;
    public static final int PLAY_LOOPED = 1;
    public static final int PLAY_MUTED = 0;
    public CyberPlayerManager.HttpDNS mDns;
    public Map<String, String> mHeader;
    public CyberPlayerManager.OnBufferingUpdateListener mOnBufferingUpdateListener;
    public CyberPlayerManager.OnCompletionListener mOnCompletionListener;
    public CyberPlayerManager.OnInfoListener mOnInfoListener;
    public CyberPlayerManager.OnMediaSourceChangedListener mOnMediaSourceChangedListener;
    public CyberPlayerManager.OnPreparedListener mOnPreparedListener;
    public CyberPlayerManager.OnSeekCompleteListener mOnSeekCompleteListener;
    public CyberPlayerManager.OnVideoSizeChangedListener mOnVideoSizeChangeListener;
    public Surface mSurface;
    public Uri mUri;
    public int mSeekWhenPrepared = -1;
    public int mDuration = 0;
    public float mLeftVolume = -1.0f;
    public float mRightVolume = -1.0f;
    public long mPlayedTime = 0;
    public long mDownLoadSpeed = 0;
    public int mDecoderMode = 0;
    public Context mContext = null;
    public boolean mIsMuted = false;
    public boolean mIsLooped = false;
    public boolean mIsPlaying = false;
    public int mDecodeMode = 0;
    public boolean mRemote = false;
    public int mCurrentInstanceState = -1;
    public int mInstanceDestroyCount = 0;
    public int mInstanceResumeCount = 0;
    public int mMediaSourceSwitchRank = Integer.MIN_VALUE;
    public CyberPlayerManager.MediaSourceSwitchMode mMediaSourceSwitchMode = CyberPlayerManager.MediaSourceSwitchMode.MEDIASOURCE_SWITCH_ABR_MODE;
    public String mClarityInfo = null;
    public String mPlayJson = null;

    public CyberPlayerManager.HttpDNS dns() {
        return this.mDns;
    }

    public String getClarityInfo() {
        return this.mClarityInfo;
    }

    public int getCurrentPosition() {
        return this.mSeekWhenPrepared;
    }

    public int getDecoderMode() {
        return this.mDecoderMode;
    }

    public long getDownLoadSpeed() {
        return this.mDownLoadSpeed;
    }

    public int getDuration() {
        return this.mDuration;
    }

    public Context getInstanceContext() {
        return this.mContext;
    }

    public Map<String, String> getInstanceHeader() {
        return this.mHeader;
    }

    public Surface getInstanceSurface() {
        return this.mSurface;
    }

    public Uri getInstanceUri() {
        return this.mUri;
    }

    public float getLRVolume() {
        float f = this.mLeftVolume;
        float f2 = this.mRightVolume;
        if (f <= f2) {
            return f2;
        }
        return f;
    }

    public CyberPlayerManager.MediaSourceSwitchMode getMediaSourceSwitchMode() {
        return this.mMediaSourceSwitchMode;
    }

    public int getMediaSourceSwitchRank() {
        return this.mMediaSourceSwitchRank;
    }

    public CyberPlayerManager.OnBufferingUpdateListener getOnBufferingUpdateListener() {
        return this.mOnBufferingUpdateListener;
    }

    public CyberPlayerManager.OnCompletionListener getOnCompletionListener() {
        return this.mOnCompletionListener;
    }

    public CyberPlayerManager.OnInfoListener getOnInfoListener() {
        return this.mOnInfoListener;
    }

    public CyberPlayerManager.OnMediaSourceChangedListener getOnMediaSourceChangedListener() {
        return this.mOnMediaSourceChangedListener;
    }

    public CyberPlayerManager.OnPreparedListener getOnPreparedListener() {
        return this.mOnPreparedListener;
    }

    public CyberPlayerManager.OnSeekCompleteListener getOnSeekCompleteListener() {
        return this.mOnSeekCompleteListener;
    }

    public CyberPlayerManager.OnVideoSizeChangedListener getOnVideoSizeChangedListener() {
        return this.mOnVideoSizeChangeListener;
    }

    public String getPlayJson() {
        return this.mPlayJson;
    }

    public long getPlayedTime() {
        return this.mPlayedTime;
    }

    public boolean getPlayingStatus() {
        return this.mIsPlaying;
    }

    public boolean isRemote() {
        return this.mRemote;
    }

    public boolean needActiveInstance() {
        if (this.mCurrentInstanceState == 0) {
            return true;
        }
        return false;
    }

    public void release() {
        this.mOnPreparedListener = null;
        this.mOnInfoListener = null;
        this.mOnSeekCompleteListener = null;
        this.mOnBufferingUpdateListener = null;
        this.mOnVideoSizeChangeListener = null;
        this.mOnPreparedListener = null;
        this.mOnMediaSourceChangedListener = null;
        this.mSurface = null;
        this.mDns = null;
        this.mHeader = null;
        this.mUri = null;
    }

    public int getInstanceStaticsCount(boolean z) {
        if (z) {
            int i = this.mInstanceDestroyCount + 1;
            this.mInstanceDestroyCount = i;
            return i;
        }
        int i2 = this.mInstanceResumeCount + 1;
        this.mInstanceResumeCount = i2;
        return i2;
    }

    public boolean getPlayStateByType(int i) {
        if (i == 0) {
            return this.mIsMuted;
        }
        if (i == 1) {
            return this.mIsLooped;
        }
        return false;
    }

    public void setClarityInfo(String str) {
        this.mClarityInfo = str;
    }

    public void setOnBufferingUpdateListener(CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.mOnBufferingUpdateListener = onBufferingUpdateListener;
    }

    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.mOnCompletionListener = onCompletionListener;
    }

    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        this.mOnInfoListener = onInfoListener;
    }

    public void setOnMediaSourceChangedListener(CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener) {
        this.mOnMediaSourceChangedListener = onMediaSourceChangedListener;
    }

    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.mOnPreparedListener = onPreparedListener;
    }

    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        this.mOnSeekCompleteListener = onSeekCompleteListener;
    }

    public void setOnVideoSizeChangedListener(CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.mOnVideoSizeChangeListener = onVideoSizeChangedListener;
    }

    public void setPlayJson(String str) {
        this.mPlayJson = str;
    }

    public void updateDecoderMode(int i) {
        this.mDecoderMode = i;
    }

    public void updateDns(CyberPlayerManager.HttpDNS httpDNS) {
        this.mDns = httpDNS;
    }

    public void updateDownLoadSpeed(long j) {
        this.mDownLoadSpeed = j;
    }

    public void updateInstanceState(int i) {
        this.mCurrentInstanceState = i;
    }

    public void updatePlayedTime(long j) {
        this.mPlayedTime = j;
    }

    public void updatePlayingStatus(boolean z) {
        this.mIsPlaying = z;
    }

    public void updateRemote(boolean z) {
        this.mRemote = z;
    }

    public void updateSurface(Surface surface) {
        this.mSurface = surface;
    }

    public void setMediaSourceSwitchInfo(int i, CyberPlayerManager.MediaSourceSwitchMode mediaSourceSwitchMode) {
        this.mMediaSourceSwitchMode = mediaSourceSwitchMode;
        this.mMediaSourceSwitchRank = i;
    }

    public void updatePlayStateByType(int i, boolean z) {
        if (i == 0) {
            this.mIsMuted = z;
        } else if (i == 1) {
            this.mIsLooped = z;
        }
    }

    public void updateSeekPos(int i, int i2) {
        if (i >= i2 - 100) {
            this.mSeekWhenPrepared = 0;
        } else {
            this.mSeekWhenPrepared = i;
        }
        this.mDuration = i2;
    }

    public void updateDataSource(Context context, Uri uri, Map<String, String> map) {
        this.mContext = context;
        this.mUri = uri;
        this.mHeader = map;
    }
}
