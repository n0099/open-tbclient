package com.baidu.nadcore.video.plugin.videoplayer.model;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import com.baidu.nadcore.video.plugin.videoplayer.model.ClarityUrlList;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.bu0;
import com.baidu.tieba.f21;
import com.baidu.tieba.i31;
import com.baidu.tieba.n01;
import com.baidu.tieba.su0;
import com.baidu.tieba.tu0;
import com.baidu.tieba.u01;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"KotlinPropertyAccess"})
/* loaded from: classes3.dex */
public class BdVideoSeries implements Serializable, Cloneable {
    public static final String FORMAT_FLV = "flv";
    public static final String FORMAT_NORMAL = "normal";
    public static final String FORMAT_YY = "yy";
    public static final String JSON_SITE_LOGO = "site_logo";
    public static final String JSON_SITE_NAME = "site_name";
    public static final String RESOURCE_TYPE_INTERACT = "interact";
    public static final int TITLE_LARGE = 2;
    public static final int TITLE_NORMAL = 1;
    public static final int TITLE_SMALL = 0;
    public static final int TITLE_XLARGE = 3;
    public static String searchID = null;
    public static final long serialVersionUID = 2404871968738716087L;
    public long mAccessTime;
    public String mAnimLogoDownloadScheme;
    public String mAnimLogoDownloadToast;
    public String mAnimLogoJumpScheme;
    public String mAsyncRequestReason;
    public int mBps;
    public String mBrief;
    public ClarityUrlList mClarityList;
    public String mClarityTitle;
    public List<n01> mCommentList;
    public long mCreateTime;
    public String mDetailId;
    public String mExt;
    public String mExtLog;
    public String mFloatDisable;
    public String mFormat;
    public boolean mHasDecodedMPD;
    public String mHasFaceDetect;
    public String mHttpHeader;
    public long mId;
    public String mImgUrl;
    public String mIntro;
    public boolean mIsFavorite;
    public boolean mIsFullShare;
    public boolean mIsHalfShare;
    public boolean mIsHistory;
    public boolean mIsOffline;
    public int mLoadFrom;
    public String mLongVideo;
    public String mMPD;
    public String mMPDUrl;
    public String mMPDVid;
    public String mMaxNum;
    public int mMoovSize;
    public int mOffset;
    public String mOriginalUrl;
    public String mPage;
    public String mPd;
    public String mPlayConf;
    public String mPlayerId;
    public String mPoster;
    public long mPrepareTime;
    public String mPreview6sUrl;
    public String mProxy;
    public String mRecommendList;
    public String mReserve;
    public String mResourceType;
    public String mSelectedVideoCurrentLength;
    public String mSelectedVideoTotalLength;
    public String mSeriesKey;
    public String mSiteDomain;
    public String mSiteListJason;
    public String mSiteName;
    public boolean mStartOnPreparedEnable;
    public Object mTag;
    public String mTitle;
    @Px
    public int mTitleSizePx;
    public String mUpdateInfo;
    public long mUpdateTime;
    public String mUrlExpireTime;
    public String mVPTYpe;
    public BdVideoAd mVideoAd;
    public List<BdVideo> mVideoList;
    public String mVideoType;
    public String mWebPlayerExt;
    public String vid;
    public boolean mIsFinished = false;
    public int mSelectedNum = 0;
    public int mSeriesType = 0;
    public boolean mIsUpdate = false;
    public int mSelectedIndex = -1;
    public int mTempVideoCount = -1;
    public boolean mIsFromWebpage = false;
    public String mFrom = "video";
    public boolean mNetToast = true;
    public String mNid = "";
    public boolean mIsPlayLoop = false;
    public boolean mAnimLogoEnable = true;
    public boolean mIsReplayVideo = false;
    public boolean mIsIgnoreScheme = false;
    public int mStartPosition = -1;
    public int mPositionMs = 0;
    public int mDurationMs = 0;

    public static String getSearchID() {
        return searchID;
    }

    private boolean isMultiPlanSmartClarityEffective() {
        return !"search".equals(getFrom());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public BdVideoSeries m54clone() {
        try {
            return (BdVideoSeries) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public long getAccessTime() {
        return this.mAccessTime;
    }

    public String getAnimLogoDownloadScheme() {
        return this.mAnimLogoDownloadScheme;
    }

    public String getAnimLogoDownloadToast() {
        return this.mAnimLogoDownloadToast;
    }

    public String getAnimLogoJumpScheme() {
        return this.mAnimLogoJumpScheme;
    }

    public String getBrief() {
        return this.mBrief;
    }

    public ClarityUrlList getClarityList() {
        return this.mClarityList;
    }

    public String getClarityTitle() {
        if (TextUtils.isEmpty(this.mClarityTitle)) {
            return bu0.b().getResources().getString(R.string.nad_clarity_sd);
        }
        return this.mClarityTitle;
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public String getDetailId() {
        return this.mDetailId;
    }

    public int getDuration() {
        return this.mDurationMs / 1000;
    }

    public int getDurationMs() {
        return this.mDurationMs;
    }

    public String getExt() {
        return this.mExt;
    }

    public String getExtLog() {
        return this.mExtLog;
    }

    @Nullable
    public String getFloatDisable() {
        return this.mFloatDisable;
    }

    public String getFormat() {
        return this.mFormat;
    }

    @NonNull
    public String getFrom() {
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "video";
        }
        return this.mFrom;
    }

    public List<n01> getHotComments() {
        return this.mCommentList;
    }

    public String getHttpHeader() {
        return this.mHttpHeader;
    }

    public long getId() {
        return this.mId;
    }

    public String getImgUrl() {
        return this.mImgUrl;
    }

    public String getIntro() {
        return this.mIntro;
    }

    public boolean getIsUpdate() {
        return this.mIsUpdate;
    }

    public int getLoadFrom() {
        return this.mLoadFrom;
    }

    public String getLongVideo() {
        return this.mLongVideo;
    }

    public String getMPD() {
        return this.mMPD;
    }

    public String getMPDUrl() {
        return this.mMPDUrl;
    }

    public String getMPDVid() {
        return this.mMPDVid;
    }

    public String getMaxNum() {
        return this.mMaxNum;
    }

    public int getMoovSize() {
        return this.mMoovSize;
    }

    public String getNid() {
        return this.mNid;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getOriginalUrl() {
        return this.mOriginalUrl;
    }

    @NonNull
    public String getPage() {
        String str = this.mPage;
        if (str == null) {
            return "";
        }
        return str;
    }

    @NonNull
    public String getPd() {
        String str = this.mPd;
        if (str == null) {
            return "";
        }
        return str;
    }

    public String getPlayConf() {
        return this.mPlayConf;
    }

    public String getPlayUrl() {
        ClarityUrlList clarityList = getClarityList();
        if (clarityList != null && clarityList.size() > 0) {
            return clarityList.getDefaultUrl();
        }
        return getSelectedVideo().getPlayUrl();
    }

    public String getPlayerId() {
        return this.mPlayerId;
    }

    public int getPosition() {
        return this.mPositionMs / 1000;
    }

    public int getPositionMs() {
        return this.mPositionMs;
    }

    public String getPoster() {
        return this.mPoster;
    }

    public long getPrepareTime() {
        return this.mPrepareTime;
    }

    public String getPreview6sUrl() {
        return this.mPreview6sUrl;
    }

    public String getProxy() {
        return this.mProxy;
    }

    public String getRecommendList() {
        return this.mRecommendList;
    }

    public String getReserve() {
        return this.mReserve;
    }

    @Nullable
    public String getResourceType() {
        return this.mResourceType;
    }

    public int getSelectedIndex() {
        return this.mSelectedIndex;
    }

    public int getSelectedNum() {
        return this.mSelectedNum;
    }

    @Nullable
    public BdVideo getSelectedVideo() {
        List<BdVideo> list = this.mVideoList;
        if (list != null && list.size() > 0) {
            int i = this.mSelectedIndex;
            if (i < 0 || i >= this.mVideoList.size()) {
                this.mSelectedIndex = 0;
            }
            return this.mVideoList.get(this.mSelectedIndex);
        }
        return null;
    }

    public String getSelectedVideoCurrentLength() {
        return this.mSelectedVideoCurrentLength;
    }

    public String getSelectedVideoTotalLength() {
        return this.mSelectedVideoTotalLength;
    }

    public String getSeriesKey() {
        return this.mSeriesKey;
    }

    public int getSeriesType() {
        return this.mSeriesType;
    }

    public String getSiteDomain() {
        return this.mSiteDomain;
    }

    public String getSiteName() {
        return this.mSiteName;
    }

    public boolean getStartOnPreparedEnable() {
        return this.mStartOnPreparedEnable;
    }

    public int getStartPosition() {
        int i = this.mStartPosition;
        if (i < 0) {
            return -1;
        }
        return i;
    }

    public Object getTag() {
        return this.mTag;
    }

    public int getTempVideoCount() {
        return this.mTempVideoCount;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public int getTitleSizePx() {
        return this.mTitleSizePx;
    }

    public String getUpdateInfo() {
        return this.mUpdateInfo;
    }

    public long getUpdateTime() {
        return this.mUpdateTime;
    }

    public String getUrlExpireTime() {
        return this.mUrlExpireTime;
    }

    public String getVPType() {
        return this.mVPTYpe;
    }

    @NonNull
    public String getVid() {
        if (TextUtils.isEmpty(this.vid)) {
            return "";
        }
        return this.vid;
    }

    public BdVideoAd getVideoAd() {
        return this.mVideoAd;
    }

    public int getVideoBps() {
        return this.mBps;
    }

    public int getVideoCount() {
        List<BdVideo> list = this.mVideoList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public String getVideoFaceDetect() {
        return this.mHasFaceDetect;
    }

    public List<BdVideo> getVideoList() {
        return this.mVideoList;
    }

    public String getVideoType() {
        return this.mVideoType;
    }

    public String getWebPlayerExt() {
        return this.mWebPlayerExt;
    }

    public boolean hasDecodedMPD() {
        return this.mHasDecodedMPD;
    }

    public boolean hasFinishedPlayingAllVideos() {
        List<BdVideo> list = this.mVideoList;
        if (list != null) {
            int size = list.size();
            int i = this.mSelectedIndex;
            if (size == i + 1) {
                return hasFinishedPlayingVideo(this.mVideoList.get(i));
            }
            return false;
        }
        int i2 = this.mTempVideoCount;
        if (i2 != -1 && i2 == this.mSelectedIndex + 1) {
            return isLengthTheSameNotZero(this.mSelectedVideoCurrentLength, this.mSelectedVideoTotalLength);
        }
        return false;
    }

    public boolean hasLongVideo() {
        return !TextUtils.isEmpty(getLongVideo());
    }

    public boolean hasPlayed() {
        if (this.mSelectedIndex != -1) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean isContainSingleVideo() {
        if (this.mVideoList != null) {
            if (getVideoCount() != 1) {
                return false;
            }
            return true;
        }
        int i = this.mTempVideoCount;
        if (i == -1 || i != 1) {
            return false;
        }
        return true;
    }

    public boolean isFavorite() {
        return this.mIsFavorite;
    }

    public boolean isFinished() {
        return this.mIsFinished;
    }

    public boolean isFromWebpage() {
        return this.mIsFromWebpage;
    }

    public boolean isFullShare() {
        return this.mIsFullShare;
    }

    public boolean isHalfShare() {
        return this.mIsHalfShare;
    }

    public boolean isHistory() {
        return this.mIsHistory;
    }

    public boolean isIgnoreScheme() {
        return this.mIsIgnoreScheme;
    }

    public boolean isInteractVideo() {
        if (RESOURCE_TYPE_INTERACT.equals(getResourceType()) && su0.a()) {
            return true;
        }
        return false;
    }

    public boolean isOffline() {
        BdVideo selectedVideo = getSelectedVideo();
        if (selectedVideo != null) {
            return !TextUtils.isEmpty(selectedVideo.getLocalSavePath());
        }
        return false;
    }

    public boolean isPlayLoop() {
        return this.mIsPlayLoop;
    }

    public boolean isReplayVideo() {
        return this.mIsReplayVideo;
    }

    public boolean ismAnimLogoEnable() {
        return this.mAnimLogoEnable;
    }

    public boolean needNetToast() {
        return this.mNetToast;
    }

    public void release() {
        if (this.mVideoList != null) {
            this.mVideoList = null;
        }
    }

    public void updateClarityUrlListFromMPD() {
        JSONArray b = u01.b(this.mMPD);
        if (b != null) {
            updateClarityUrlList(b, true);
        }
    }

    public static void amendLastPagePd(BdVideoSeries bdVideoSeries, String str) {
        if (bdVideoSeries == null) {
            return;
        }
        String extLog = bdVideoSeries.getExtLog();
        if (!TextUtils.isEmpty(extLog)) {
            JSONObject c = i31.c(extLog);
            i31.f(c, "lastpage_pd", str);
            bdVideoSeries.setExtLog(c.toString());
        }
    }

    public static boolean isLengthTheSameNotZero(String str, String str2) {
        if (str != null && str2 != null) {
            try {
                int parseInt = Integer.parseInt(str);
                int parseInt2 = Integer.parseInt(str2);
                if (parseInt2 > 0 && parseInt == parseInt2) {
                    return true;
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static double parseDoubleSafe(@Nullable String str, double d) {
        if (TextUtils.isEmpty(str)) {
            return d;
        }
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            f21.a(e.getMessage());
            return d;
        }
    }

    public static int parseIntSafe(@Nullable String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            f21.a(e.getMessage());
            return i;
        }
    }

    public void setClarityUrlList(String str, boolean z) {
        if (z) {
            JSONArray b = u01.b(str);
            if (b != null) {
                setClarityUrlList(b);
                return;
            }
            return;
        }
        setClarityUrlList(str);
    }

    public void updateClarityUrlList(JSONArray jSONArray, boolean z) {
        updateClarityUrlList(jSONArray.toString(), z);
    }

    public static String getFormattedLengthString(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                int parseInt = Integer.parseInt(str);
                if (parseInt < 0) {
                    return "";
                }
                return getTextWithSecond(parseInt);
            } catch (Exception e) {
                f21.f("getFormattedLengthString(" + str + SmallTailInfo.EMOTION_SUFFIX, e);
            }
        }
        return "";
    }

    public static boolean hasFinishedPlayingVideo(BdVideo bdVideo) {
        if (bdVideo != null && bdVideo.getCurrentLength() != null && bdVideo.getTotalLength() != null) {
            return isLengthTheSameNotZero(bdVideo.getCurrentLength(), bdVideo.getTotalLength());
        }
        return false;
    }

    public void appendVideoList(List<BdVideo> list) {
        List<BdVideo> list2;
        if (list != null && (list2 = this.mVideoList) != null) {
            list2.addAll(list);
        }
    }

    public boolean containVideo(BdVideo bdVideo) {
        int size;
        List<BdVideo> list = this.mVideoList;
        if (list == null || (size = list.size()) <= 0) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (this.mVideoList.get(i).equalsCustom(bdVideo)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        String str;
        if (!(obj instanceof BdVideoSeries) || (str = this.mDetailId) == null || !str.equals(((BdVideoSeries) obj).getDetailId())) {
            return false;
        }
        return true;
    }

    public BdVideo findVideoByIndex(int i) {
        List<BdVideo> list = this.mVideoList;
        if (list != null && i >= 0 && i < list.size()) {
            return this.mVideoList.get(i);
        }
        return null;
    }

    @Nullable
    public BdVideo getVideoByIndex(int i) {
        List<BdVideo> list = this.mVideoList;
        if (list != null && list.size() > 0 && i >= 0 && i < this.mVideoList.size()) {
            return this.mVideoList.get(i);
        }
        return null;
    }

    public int getVideoIndex(long j) {
        List<BdVideo> list;
        if (j >= 0 && (list = this.mVideoList) != null) {
            for (BdVideo bdVideo : list) {
                if (bdVideo.getId() == j) {
                    return this.mVideoList.indexOf(bdVideo);
                }
            }
        }
        return -1;
    }

    public void setAccessTime(long j) {
        this.mAccessTime = j;
    }

    public void setAnimLogoDownloadScheme(String str) {
        this.mAnimLogoDownloadScheme = str;
    }

    public void setAnimLogoDownloadToast(String str) {
        this.mAnimLogoDownloadToast = str;
    }

    public void setAnimLogoEnable(boolean z) {
        this.mAnimLogoEnable = z;
    }

    public void setAnimLogoJumpScheme(String str) {
        this.mAnimLogoJumpScheme = str;
    }

    public void setBrief(String str) {
        this.mBrief = str;
    }

    public void setClarityTitle(String str) {
        this.mClarityTitle = str;
    }

    public void setClarityUrlList(String str) {
        try {
            setClarityUrlList(new JSONArray(str));
        } catch (JSONException e) {
            if (bu0.f()) {
                e.printStackTrace();
            }
            this.mClarityList = new ClarityUrlList();
        }
    }

    public void setCreateTime(long j) {
        this.mCreateTime = j;
    }

    public void setDetailId(String str) {
        this.mDetailId = str;
    }

    public void setDuration(int i) {
        this.mDurationMs = i * 1000;
    }

    public void setDurationMs(int i) {
        this.mDurationMs = i;
    }

    public void setExt(String str) {
        this.mExt = str;
    }

    public void setExtLog(String str) {
        this.mExtLog = str;
        if (!TextUtils.isEmpty(str)) {
            searchID = i31.c(str).optString("searchID");
        }
    }

    public void setFavorite(boolean z) {
        this.mIsFavorite = z;
    }

    public void setFloatingDisable(@Nullable String str) {
        this.mFloatDisable = str;
    }

    public void setFormat(String str) {
        this.mFormat = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setFromWebpage(boolean z) {
        this.mIsFromWebpage = z;
    }

    public void setFullShare(boolean z) {
        this.mIsFullShare = z;
    }

    public void setHalfShare(boolean z) {
        this.mIsHalfShare = z;
    }

    public void setHasDecodedMPD(boolean z) {
        this.mHasDecodedMPD = z;
    }

    public void setHistory(boolean z) {
        this.mIsHistory = z;
    }

    public void setHotCommentList(List<n01> list) {
        this.mCommentList = list;
    }

    public void setHttpHeader(String str) {
        this.mHttpHeader = str;
    }

    public void setId(long j) {
        this.mId = j;
    }

    public void setIgnoreScheme(boolean z) {
        this.mIsIgnoreScheme = z;
    }

    public void setImgUrl(String str) {
        this.mImgUrl = str;
    }

    public void setIntro(String str) {
        this.mIntro = str;
    }

    public void setIsFinished(boolean z) {
        this.mIsFinished = z;
    }

    public void setIsUpdate(boolean z) {
        this.mIsUpdate = z;
    }

    public void setLoadFrom(int i) {
        this.mLoadFrom = i;
    }

    public void setLongVideo(String str) {
        this.mLongVideo = str;
    }

    public void setMPD(String str) {
        this.mMPD = str;
    }

    public void setMPDUrl(String str) {
        this.mMPDUrl = str;
    }

    public void setMPDVid(String str) {
        this.mMPDVid = str;
    }

    public void setMaxNum(String str) {
        this.mMaxNum = str;
    }

    public void setMoovSize(int i) {
        this.mMoovSize = i;
    }

    public void setNetToast(boolean z) {
        this.mNetToast = z;
    }

    public void setNid(String str) {
        this.mNid = str;
    }

    public void setOffline(boolean z) {
        this.mIsOffline = z;
    }

    public void setOffset(int i) {
        this.mOffset = i;
    }

    public void setOriginalUrl(String str) {
        this.mOriginalUrl = str;
    }

    public void setPage(String str) {
        this.mPage = str;
    }

    public void setPd(String str) {
        this.mPd = str;
    }

    public void setPlayConf(String str) {
        this.mPlayConf = str;
    }

    public void setPlayLoop(boolean z) {
        this.mIsPlayLoop = z;
    }

    public void setPlayerId(String str) {
        this.mPlayerId = str;
    }

    public void setPosition(int i) {
        this.mPositionMs = i * 1000;
    }

    public void setPositionMs(int i) {
        this.mPositionMs = i;
    }

    public void setPoster(String str) {
        this.mPoster = str;
    }

    public void setPrepareTime(long j) {
        if (j > 0) {
            this.mPrepareTime = j;
        }
    }

    public void setPreview6sUrl(String str) {
        this.mPreview6sUrl = str;
    }

    public void setProxy(String str) {
        this.mProxy = str;
    }

    public void setRecommendList(String str) {
        this.mRecommendList = str;
    }

    public void setReplayVideo(boolean z) {
        int i;
        this.mIsReplayVideo = z;
        if (z) {
            i = 0;
        } else {
            i = -1;
        }
        setStartPosition(i);
    }

    public void setReserve(String str) {
        this.mReserve = str;
    }

    public void setResourceType(String str) {
        this.mResourceType = str;
    }

    public void setSelectedIndex(int i) {
        this.mSelectedIndex = i;
    }

    public void setSelectedNum(int i) {
        this.mSelectedNum = i;
    }

    public void setSelectedVideoCurrentLength(String str) {
        this.mSelectedVideoCurrentLength = str;
    }

    public void setSelectedVideoTotalLength(String str) {
        this.mSelectedVideoTotalLength = str;
    }

    public void setSeriesKey(String str) {
        this.mSeriesKey = str;
    }

    public void setSeriesType(int i) {
        this.mSeriesType = i;
    }

    public void setShareMode(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mIsHalfShare = jSONObject.optBoolean("half", false);
            this.mIsFullShare = jSONObject.optBoolean("full", false);
            return;
        }
        this.mIsHalfShare = false;
        this.mIsFullShare = false;
    }

    public void setSiteDomain(String str) {
        this.mSiteDomain = str;
    }

    public void setSiteName(String str) {
        this.mSiteName = str;
    }

    public void setStartOnPreparedEnable(boolean z) {
        this.mStartOnPreparedEnable = z;
    }

    public void setStartPosition(int i) {
        this.mStartPosition = i;
    }

    public void setTag(Object obj) {
        this.mTag = obj;
    }

    public void setTempVideoCount(int i) {
        this.mTempVideoCount = i;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void setTitleSizePx(int i) {
        this.mTitleSizePx = i;
    }

    public void setUpdateInfo(String str) {
        this.mUpdateInfo = str;
    }

    public void setUpdateTime(long j) {
        this.mUpdateTime = j;
    }

    public void setUrlExpireTime(String str) {
        this.mUrlExpireTime = str;
    }

    public void setVPType(String str) {
        this.mVPTYpe = str;
    }

    public void setVid(String str) {
        this.vid = str;
    }

    public void setVideoAd(BdVideoAd bdVideoAd) {
        this.mVideoAd = bdVideoAd;
    }

    public void setVideoBps(int i) {
        this.mBps = i;
    }

    public void setVideoFaceDetect(String str) {
        this.mHasFaceDetect = str;
    }

    public void setVideoList(List<BdVideo> list) {
        this.mVideoList = list;
    }

    public void setVideoType(String str) {
        this.mVideoType = str;
    }

    public void setWebPlayerExt(String str) {
        this.mWebPlayerExt = str;
    }

    public void updateVideo(BdVideo bdVideo) {
        int size;
        List<BdVideo> list = this.mVideoList;
        if (list == null || (size = list.size()) <= 0) {
            return;
        }
        for (int i = 0; i < size; i++) {
            BdVideo bdVideo2 = this.mVideoList.get(i);
            if (bdVideo2.equalsCustom(bdVideo)) {
                this.mVideoList.remove(bdVideo2);
                this.mVideoList.add(bdVideo);
                return;
            }
        }
    }

    public static String getTextWithSecond(int i) {
        String format;
        int i2 = i / 3600;
        int i3 = (i % 3600) / 60;
        int i4 = i % 60;
        try {
            if (i2 != 0) {
                format = String.format(Locale.US, "%02d:%02d:%02d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            } else {
                format = String.format(Locale.US, "%02d:%02d", Integer.valueOf(i3), Integer.valueOf(i4));
            }
            return format;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String parseSite(String str) {
        if (!TextUtils.isEmpty(this.mSiteListJason) && !TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(this.mSiteListJason);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (jSONObject != null && jSONObject.has(JSON_SITE_NAME) && jSONObject.has(JSON_SITE_LOGO) && str.equals(jSONObject.getString(JSON_SITE_NAME))) {
                        return jSONObject.getString(JSON_SITE_LOGO);
                    }
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public boolean clearNewFlag() {
        setIsUpdate(false);
        f21.a("is update: " + getIsUpdate());
        List<BdVideo> list = this.mVideoList;
        if (list == null) {
            return false;
        }
        boolean z = false;
        for (BdVideo bdVideo : list) {
            if (bdVideo != null && bdVideo.isNew()) {
                bdVideo.setIsNew(false);
                z = true;
            }
        }
        return z;
    }

    public String getCurrentLengthString() {
        String str = "";
        if (getVideoList() != null) {
            int selectedIndex = getSelectedIndex();
            if (selectedIndex < 0 || selectedIndex >= getVideoList().size()) {
                return "";
            }
            BdVideo bdVideo = getVideoList().get(selectedIndex);
            if (bdVideo != null) {
                str = bdVideo.getCurrentLength();
            }
        } else if (this.mTempVideoCount != -1) {
            str = getSelectedVideoCurrentLength();
        }
        return getFormattedLengthString(str);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:1|(2:3|(1:19)(2:7|(5:9|10|11|(2:13|14)|17)))|20|10|11|(0)|17) */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0032 A[Catch: NumberFormatException -> 0x0037, TRY_LEAVE, TryCatch #0 {NumberFormatException -> 0x0037, blocks: (B:14:0x002c, B:16:0x0032), top: B:20:0x002c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getTotalLength() {
        String str;
        if (getVideoList() != null) {
            int selectedIndex = getSelectedIndex();
            if (selectedIndex < 0 || selectedIndex >= getVideoList().size()) {
                return 0;
            }
            BdVideo bdVideo = getVideoList().get(selectedIndex);
            if (bdVideo != null) {
                str = bdVideo.getTotalLength();
                if (!TextUtils.isEmpty(str)) {
                    return Integer.parseInt(str);
                }
                return 0;
            }
        }
        str = "";
        if (!TextUtils.isEmpty(str)) {
        }
        return 0;
    }

    public String getTotalLengthString() {
        String str = "";
        if (getVideoList() != null) {
            int selectedIndex = getSelectedIndex();
            if (selectedIndex < 0 || selectedIndex >= getVideoList().size()) {
                return "";
            }
            BdVideo bdVideo = getVideoList().get(selectedIndex);
            if (bdVideo != null) {
                str = bdVideo.getTotalLength();
            }
        } else if (this.mTempVideoCount != -1) {
            str = getSelectedVideoTotalLength();
        }
        return getFormattedLengthString(str);
    }

    public int getVideoIndex(BdVideo bdVideo) {
        List<BdVideo> list;
        if (bdVideo != null && (list = this.mVideoList) != null) {
            return list.indexOf(bdVideo);
        }
        return -1;
    }

    public void setClarityUrlList(JSONArray jSONArray) {
        this.mClarityList = new ClarityUrlList(jSONArray, isMultiPlanSmartClarityEffective());
    }

    public String toString() {
        boolean z;
        String nid;
        Integer valueOf;
        if (getVideoList() == null) {
            z = true;
        } else {
            z = false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(" detail id: ");
        if (TextUtils.isEmpty(getNid())) {
            nid = getVid();
        } else {
            nid = getNid();
        }
        sb.append(nid);
        sb.append(", title: ");
        sb.append(getTitle());
        sb.append(", video list size: ");
        if (z) {
            valueOf = null;
        } else {
            valueOf = Integer.valueOf(getVideoList().size());
        }
        sb.append(valueOf);
        sb.append(", from: ");
        sb.append(getFrom());
        sb.append(", page: ");
        sb.append(getPage());
        sb.append(", pd: ");
        sb.append(getPd());
        sb.append(", select video: ");
        sb.append(getSelectedVideo());
        return sb.toString();
    }

    public void updateClarityUrlList(String str, boolean z) {
        ClarityUrlList clarityUrlList = this.mClarityList;
        try {
            setClarityUrlList(new JSONArray(str));
        } catch (JSONException e) {
            e.printStackTrace();
            this.mClarityList = new ClarityUrlList();
        }
        if (z && clarityUrlList != null && clarityUrlList.size() > 0) {
            ClarityUrlList.c clarityByOriginRank = this.mClarityList.getClarityByOriginRank(clarityUrlList.getCurrentClarityUrl().b);
            if (clarityByOriginRank != null) {
                this.mClarityList.setCurrentClarityUrl(clarityByOriginRank);
                if (tu0.b()) {
                    this.mClarityList.setMultiRateSwitchRank(clarityByOriginRank.c);
                    return;
                }
                return;
            }
            this.mClarityList.updateCurrentClarityToLowest();
        }
    }

    public void updateClarityUrlList(String str, boolean z, boolean z2) {
        if (z2) {
            JSONArray b = u01.b(str);
            if (b != null) {
                updateClarityUrlList(b, z);
                return;
            }
            return;
        }
        updateClarityUrlList(str, z);
    }
}
