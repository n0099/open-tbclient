package com.baidu.nadcore.video.plugin.videoplayer.model;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import java.io.Serializable;
@SuppressLint({"KotlinPropertyAccess"})
/* loaded from: classes3.dex */
public class BdVideo implements Serializable, Cloneable {
    public static final int ANIM_LOGO_DOWNLOAD_TOAST = 123;
    public static final int ANIM_LOGO_ENABLE = 120;
    public static final int ANIM_LOGO_JUMP_SCHEME = 121;
    public static final int ANIM_LOGO_LOAD_SCHEME = 122;
    public static final int CALLBACK = 104;
    public static final int CURRENT_LENGTH = 305;
    public static final int DATA_ID_ATTRIBUTE_ID = 8;
    public static final int DATA_ID_AUTOPLAY = 15;
    public static final int DATA_ID_COOKIE = 3;
    public static final int DATA_ID_FIXED = 14;
    public static final int DATA_ID_HEIGHT = 13;
    public static final int DATA_ID_HIDE_URL_LOG = 4;
    public static final int DATA_ID_HTTP_HEADER = 7;
    public static final int DATA_ID_PLAYER_EXT = 16;
    public static final int DATA_ID_PROXY = 6;
    public static final int DATA_ID_REFERRER = 9;
    public static final int DATA_ID_START_ON_PREPARE = 17;
    public static final int DATA_ID_USER_AGENT = 2;
    public static final int DATA_ID_VIDEO_TITLE = 1;
    public static final int DATA_ID_VIDEO_URL = 0;
    public static final int DATA_ID_WEB_URL = 5;
    public static final int DATA_ID_WIDTH = 12;
    public static final int DATA_ID_X = 10;
    public static final int DATA_ID_Y = 11;
    public static final String DEFAULT_DOWNLOAD_KEY = "";
    public static final String DEFAULT_LENGTH = "-1";
    public static final int DURATION = 112;
    public static final int EXT = 108;
    public static final int EXT_LOG = 111;
    public static final int FORMAT = 114;
    public static final int HOT_COMMENTS = 125;
    public static final int PAGE_URL = 5;
    public static final int PLAY_LOOP = 115;
    public static final int PLAY_PAGE = 124;
    public static final int POSTER = 107;
    public static final int RECOMMEND = 105;
    public static final int SHOW_SHARE = 110;
    public static final int SHOW_TITLE = 106;
    public static final int TITLE = 1;
    public static final int TRAFFIC_ALERT = 109;
    public static final int VID = 113;
    public static final int VIDEO_CLARITY = 303;
    public static final int VIDEO_EXPIRE_TIME = 127;
    public static final int VIDEO_FACE_AI = 302;
    public static final int VIDEO_FLOATING_CONF = 305;
    public static final int VIDEO_FROM = 301;
    public static final int VIDEO_MPD = 350;
    public static final int VIDEO_MPD_URL = 351;
    public static final int VIDEO_MPD_VID = 352;
    public static final int VIDEO_PLAYER_CONF = 304;
    public static final int VIDEO_RESOURCE_TYPE = 353;
    public static final int VIDEO_START_POSITION = 305;
    public static final int VIDEO_URL = 0;
    public static final long serialVersionUID = 2404871968738716077L;
    public String mBitRate;
    public String mDownloadUrl;
    public long mId;
    public String mImgUrl;
    public String mLocalSavePath;
    public String mPlayUrl;
    public String mReserve;
    public long mSeriesId;
    public String mShowShare;
    public String mShowTitle;
    public String mSourceUrl;
    public Object mTag;
    public String mTitle;
    public int mSeriesNum = 1;
    public String mTotalLength = "-1";
    public String mCurrentLength = "-1";
    public boolean mIsNew = false;
    public int mDecodeMode = 0;
    public String mDownloadKey = "";
    public int mDownloadFrom = 0;
    public String mAlbumId = "";
    public String mTvId = "";
    public String mVideoId = "";
    public String mVideoFrom = "";
    public String mVideoType = "";
    public int mType = 101;

    public void clearWatchedInfo() {
        this.mCurrentLength = "-1";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public BdVideo m39clone() {
        try {
            return (BdVideo) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getAlbumId() {
        return this.mAlbumId;
    }

    public String getBitRate() {
        return this.mBitRate;
    }

    public String getCurrentLength() {
        if (!TextUtils.isEmpty(this.mCurrentLength) && this.mCurrentLength.contains(".")) {
            String str = this.mCurrentLength;
            return str.substring(0, str.indexOf("."));
        }
        return this.mCurrentLength;
    }

    public int getDecodeMode() {
        return this.mDecodeMode;
    }

    public int getDownloadFrom() {
        return this.mDownloadFrom;
    }

    public String getDownloadKey() {
        return this.mDownloadKey;
    }

    public String getDownloadUrl() {
        return this.mDownloadUrl;
    }

    public long getId() {
        return this.mId;
    }

    public String getImgUrl() {
        return this.mImgUrl;
    }

    public String getLocalSavePath() {
        return this.mLocalSavePath;
    }

    public String getPlayUrl() {
        return this.mPlayUrl;
    }

    public String getReserve() {
        return this.mReserve;
    }

    public long getSeriesId() {
        return this.mSeriesId;
    }

    public int getSeriesNum() {
        return this.mSeriesNum;
    }

    public boolean getShowShare() {
        return Boolean.parseBoolean(this.mShowShare);
    }

    public boolean getShowTitle() {
        return Boolean.parseBoolean(this.mShowTitle);
    }

    public String getSourceUrl() {
        return this.mSourceUrl;
    }

    public Object getTag() {
        return this.mTag;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getTotalLength() {
        return this.mTotalLength;
    }

    public String getTvId() {
        return this.mTvId;
    }

    public int getType() {
        return this.mType;
    }

    public String getVideoFrom() {
        return this.mVideoFrom;
    }

    public String getVideoId() {
        return this.mVideoId;
    }

    public String getVideoType() {
        return this.mVideoType;
    }

    public boolean isNew() {
        return this.mIsNew;
    }

    public boolean equalsCustom(Object obj) {
        if (obj instanceof BdVideo) {
            BdVideo bdVideo = (BdVideo) obj;
            String playUrl = bdVideo.getPlayUrl();
            String sourceUrl = bdVideo.getSourceUrl();
            if (playUrl != null && sourceUrl != null) {
                if (!playUrl.equals(this.mPlayUrl) || !sourceUrl.equals(this.mSourceUrl)) {
                    return false;
                }
                return true;
            } else if (playUrl != null) {
                return playUrl.equals(this.mPlayUrl);
            } else {
                if (sourceUrl != null) {
                    return sourceUrl.equals(this.mSourceUrl);
                }
            }
        }
        return false;
    }

    public void setAlbumId(String str) {
        this.mAlbumId = str;
    }

    public void setBitRate(String str) {
        this.mBitRate = str;
    }

    public void setCurrentLength(String str) {
        this.mCurrentLength = str;
    }

    public void setDecodeMode(int i) {
        this.mDecodeMode = i;
    }

    public void setDownloadFrom(int i) {
        this.mDownloadFrom = i;
    }

    public void setDownloadKey(String str) {
        this.mDownloadKey = str;
    }

    public void setDownloadUrl(String str) {
        this.mDownloadUrl = str;
    }

    public void setId(long j) {
        this.mId = j;
    }

    public void setImgUrl(String str) {
        this.mImgUrl = str;
    }

    public void setIsNew(boolean z) {
        this.mIsNew = z;
    }

    public void setLocalSavePath(String str) {
        this.mLocalSavePath = str;
    }

    public void setPlayUrl(String str) {
        this.mPlayUrl = str;
    }

    public void setReserve(String str) {
        this.mReserve = str;
    }

    public void setSeriesId(long j) {
        this.mSeriesId = j;
    }

    public void setSeriesNum(int i) {
        this.mSeriesNum = i;
    }

    public void setShowShare(String str) {
        this.mShowShare = str;
    }

    public void setShowTitle(String str) {
        this.mShowTitle = str;
    }

    public void setSourceUrl(String str) {
        this.mSourceUrl = str;
    }

    public void setTag(Object obj) {
        this.mTag = obj;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void setTotalLength(String str) {
        this.mTotalLength = str;
    }

    public void setTvId(String str) {
        this.mTvId = str;
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void setVideoFrom(String str) {
        this.mVideoFrom = str;
    }

    public void setVideoId(String str) {
        this.mVideoId = str;
    }

    public void setVideoType(String str) {
        this.mVideoType = str;
    }

    public String toString() {
        return "title: " + getTitle() + "\n play url: " + getPlayUrl() + "\n pos: " + getCurrentLength() + "\n total: " + getTotalLength() + "\n DL url: " + getDownloadUrl() + "\n local path: " + getLocalSavePath() + "\n download from: " + getDownloadFrom();
    }
}
