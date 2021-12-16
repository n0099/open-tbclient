package com.baidu.nadcore.video.plugin.videoplayer.model;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.view.InputDeviceCompat;
import c.a.c0.h0.t;
import c.a.c0.s.m0.d;
import c.a.c0.s.v0.h;
import c.a.c0.s.w.c;
import c.a.c0.u.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.video.plugin.videoplayer.model.ClarityUrlList;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"KotlinPropertyAccess"})
/* loaded from: classes10.dex */
public class BdVideoSeries implements Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic = null;
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
    public transient /* synthetic */ FieldHolder $fh;
    public long mAccessTime;
    public String mAnimLogoDownloadScheme;
    public String mAnimLogoDownloadToast;
    public boolean mAnimLogoEnable;
    public String mAnimLogoJumpScheme;
    public String mAsyncRequestReason;
    public int mBps;
    public String mBrief;
    public ClarityUrlList mClarityList;
    public String mClarityTitle;
    public List<d> mCommentList;
    public long mCreateTime;
    public String mDetailId;
    public int mDurationMs;
    public String mExt;
    public String mExtLog;
    public String mFloatDisable;
    public String mFormat;
    public String mFrom;
    public boolean mHasDecodedMPD;
    public String mHasFaceDetect;
    public String mHttpHeader;
    public long mId;
    public String mImgUrl;
    public String mIntro;
    public boolean mIsFavorite;
    public boolean mIsFinished;
    public boolean mIsFromWebpage;
    public boolean mIsFullShare;
    public boolean mIsHalfShare;
    public boolean mIsHistory;
    public boolean mIsIgnoreScheme;
    public boolean mIsOffline;
    public boolean mIsPlayLoop;
    public boolean mIsReplayVideo;
    public boolean mIsUpdate;
    public int mLoadFrom;
    public String mLongVideo;
    public String mMPD;
    public String mMPDUrl;
    public String mMPDVid;
    public String mMaxNum;
    public int mMoovSize;
    public boolean mNetToast;
    public String mNid;
    public int mOffset;
    public String mOriginalUrl;
    public String mPage;
    public String mPd;
    public String mPlayConf;
    public String mPlayerId;
    public int mPositionMs;
    public String mPoster;
    public long mPrepareTime;
    public String mPreview6sUrl;
    public String mProxy;
    public String mRecommendList;
    public String mReserve;
    public String mResourceType;
    public int mSelectedIndex;
    public int mSelectedNum;
    public String mSelectedVideoCurrentLength;
    public String mSelectedVideoTotalLength;
    public String mSeriesKey;
    public int mSeriesType;
    public String mSiteDomain;
    public String mSiteListJason;
    public String mSiteName;
    public boolean mStartOnPreparedEnable;
    public int mStartPosition;
    public Object mTag;
    public int mTempVideoCount;
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

    public BdVideoSeries() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mIsFinished = false;
        this.mSelectedNum = 0;
        this.mSeriesType = 0;
        this.mIsUpdate = false;
        this.mSelectedIndex = -1;
        this.mTempVideoCount = -1;
        this.mIsFromWebpage = false;
        this.mFrom = "video";
        this.mNetToast = true;
        this.mNid = "";
        this.mIsPlayLoop = false;
        this.mAnimLogoEnable = true;
        this.mIsReplayVideo = false;
        this.mIsIgnoreScheme = false;
        this.mStartPosition = -1;
        this.mPositionMs = 0;
        this.mDurationMs = 0;
    }

    public static void amendLastPagePd(BdVideoSeries bdVideoSeries, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, bdVideoSeries, str) == null) || bdVideoSeries == null) {
            return;
        }
        String extLog = bdVideoSeries.getExtLog();
        if (TextUtils.isEmpty(extLog)) {
            return;
        }
        JSONObject b2 = b.b(extLog);
        b.d(b2, "lastpage_pd", str);
        bdVideoSeries.setExtLog(b2.toString());
    }

    public static String getFormattedLengthString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    int parseInt = Integer.parseInt(str);
                    return parseInt < 0 ? "" : getTextWithSecond(parseInt);
                } catch (Exception e2) {
                    h.f("getFormattedLengthString(" + str + SmallTailInfo.EMOTION_SUFFIX, e2);
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String getSearchID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? searchID : (String) invokeV.objValue;
    }

    public static String getTextWithSecond(int i2) {
        InterceptResult invokeI;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) {
            int i3 = i2 / 3600;
            int i4 = (i2 % 3600) / 60;
            int i5 = i2 % 60;
            try {
                if (i3 != 0) {
                    format = String.format(Locale.US, "%02d:%02d:%02d", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
                } else {
                    format = String.format(Locale.US, "%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i5));
                }
                return format;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeI.objValue;
    }

    public static boolean hasFinishedPlayingVideo(BdVideo bdVideo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bdVideo)) == null) {
            if (bdVideo == null || bdVideo.getCurrentLength() == null || bdVideo.getTotalLength() == null) {
                return false;
            }
            return isLengthTheSameNotZero(bdVideo.getCurrentLength(), bdVideo.getTotalLength());
        }
        return invokeL.booleanValue;
    }

    public static boolean isLengthTheSameNotZero(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, str2)) == null) {
            if (str != null && str2 != null) {
                try {
                    int parseInt = Integer.parseInt(str);
                    int parseInt2 = Integer.parseInt(str2);
                    if (parseInt2 > 0 && parseInt == parseInt2) {
                        return true;
                    }
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    private boolean isMultiPlanSmartClarityEffective() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? !"search".equals(getFrom()) : invokeV.booleanValue;
    }

    public static double parseDoubleSafe(@Nullable String str, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{str, Double.valueOf(d2)})) == null) {
            if (TextUtils.isEmpty(str)) {
                return d2;
            }
            try {
                return Double.parseDouble(str);
            } catch (NumberFormatException e2) {
                h.a(e2.getMessage());
                return d2;
            }
        }
        return invokeCommon.doubleValue;
    }

    public static int parseIntSafe(@Nullable String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, str, i2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return i2;
            }
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e2) {
                h.a(e2.getMessage());
                return i2;
            }
        }
        return invokeLI.intValue;
    }

    public void appendVideoList(List<BdVideo> list) {
        List<BdVideo> list2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null || (list2 = this.mVideoList) == null) {
            return;
        }
        list2.addAll(list);
    }

    public boolean clearNewFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            setIsUpdate(false);
            h.a("is update: " + getIsUpdate());
            List<BdVideo> list = this.mVideoList;
            if (list != null) {
                boolean z = false;
                for (BdVideo bdVideo : list) {
                    if (bdVideo != null && bdVideo.isNew()) {
                        bdVideo.setIsNew(false);
                        z = true;
                    }
                }
                return z;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean containVideo(BdVideo bdVideo) {
        InterceptResult invokeL;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bdVideo)) == null) {
            List<BdVideo> list = this.mVideoList;
            if (list != null && (size = list.size()) > 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    if (this.mVideoList.get(i2).equalsCustom(bdVideo)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) ? (obj instanceof BdVideoSeries) && (str = this.mDetailId) != null && str.equals(((BdVideoSeries) obj).getDetailId()) : invokeL.booleanValue;
    }

    public BdVideo findVideoByIndex(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            List<BdVideo> list = this.mVideoList;
            if (list == null || i2 < 0 || i2 >= list.size()) {
                return null;
            }
            return this.mVideoList.get(i2);
        }
        return (BdVideo) invokeI.objValue;
    }

    public long getAccessTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mAccessTime : invokeV.longValue;
    }

    public String getAnimLogoDownloadScheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mAnimLogoDownloadScheme : (String) invokeV.objValue;
    }

    public String getAnimLogoDownloadToast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mAnimLogoDownloadToast : (String) invokeV.objValue;
    }

    public String getAnimLogoJumpScheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mAnimLogoJumpScheme : (String) invokeV.objValue;
    }

    public String getBrief() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mBrief : (String) invokeV.objValue;
    }

    public ClarityUrlList getClarityList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mClarityList : (ClarityUrlList) invokeV.objValue;
    }

    public String getClarityTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? TextUtils.isEmpty(this.mClarityTitle) ? c.a.c0.s.d.b().getResources().getString(t.nad_clarity_sd) : this.mClarityTitle : (String) invokeV.objValue;
    }

    public long getCreateTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mCreateTime : invokeV.longValue;
    }

    public String getCurrentLengthString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
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
        return (String) invokeV.objValue;
    }

    public String getDetailId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mDetailId : (String) invokeV.objValue;
    }

    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mDurationMs / 1000 : invokeV.intValue;
    }

    public int getDurationMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mDurationMs : invokeV.intValue;
    }

    public String getExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mExt : (String) invokeV.objValue;
    }

    public String getExtLog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mExtLog : (String) invokeV.objValue;
    }

    @Nullable
    public String getFloatDisable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mFloatDisable : (String) invokeV.objValue;
    }

    public String getFormat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.mFormat : (String) invokeV.objValue;
    }

    @NonNull
    public String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (TextUtils.isEmpty(this.mFrom)) {
                this.mFrom = "video";
            }
            return this.mFrom;
        }
        return (String) invokeV.objValue;
    }

    public List<d> getHotComments() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.mCommentList : (List) invokeV.objValue;
    }

    public String getHttpHeader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.mHttpHeader : (String) invokeV.objValue;
    }

    public long getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.mId : invokeV.longValue;
    }

    public String getImgUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.mImgUrl : (String) invokeV.objValue;
    }

    public String getIntro() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.mIntro : (String) invokeV.objValue;
    }

    public boolean getIsUpdate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.mIsUpdate : invokeV.booleanValue;
    }

    public int getLoadFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.mLoadFrom : invokeV.intValue;
    }

    public String getLongVideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.mLongVideo : (String) invokeV.objValue;
    }

    public String getMPD() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.mMPD : (String) invokeV.objValue;
    }

    public String getMPDUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.mMPDUrl : (String) invokeV.objValue;
    }

    public String getMPDVid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.mMPDVid : (String) invokeV.objValue;
    }

    public String getMaxNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.mMaxNum : (String) invokeV.objValue;
    }

    public int getMoovSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.mMoovSize : invokeV.intValue;
    }

    public String getNid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.mNid : (String) invokeV.objValue;
    }

    public int getOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.mOffset : invokeV.intValue;
    }

    public String getOriginalUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.mOriginalUrl : (String) invokeV.objValue;
    }

    @NonNull
    public String getPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            String str = this.mPage;
            return str == null ? "" : str;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public String getPd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            String str = this.mPd;
            return str == null ? "" : str;
        }
        return (String) invokeV.objValue;
    }

    public String getPlayConf() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.mPlayConf : (String) invokeV.objValue;
    }

    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            ClarityUrlList clarityList = getClarityList();
            if (clarityList != null && clarityList.size() > 0) {
                return clarityList.getDefaultUrl();
            }
            return getSelectedVideo().getPlayUrl();
        }
        return (String) invokeV.objValue;
    }

    public String getPlayerId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.mPlayerId : (String) invokeV.objValue;
    }

    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.mPositionMs / 1000 : invokeV.intValue;
    }

    public int getPositionMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.mPositionMs : invokeV.intValue;
    }

    public String getPoster() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.mPoster : (String) invokeV.objValue;
    }

    public long getPrepareTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.mPrepareTime : invokeV.longValue;
    }

    public String getPreview6sUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.mPreview6sUrl : (String) invokeV.objValue;
    }

    public String getProxy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.mProxy : (String) invokeV.objValue;
    }

    public String getRecommendList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.mRecommendList : (String) invokeV.objValue;
    }

    public String getReserve() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.mReserve : (String) invokeV.objValue;
    }

    @Nullable
    public String getResourceType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.mResourceType : (String) invokeV.objValue;
    }

    public int getSelectedIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.mSelectedIndex : invokeV.intValue;
    }

    public int getSelectedNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.mSelectedNum : invokeV.intValue;
    }

    @Nullable
    public BdVideo getSelectedVideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            List<BdVideo> list = this.mVideoList;
            if (list == null || list.size() <= 0) {
                return null;
            }
            int i2 = this.mSelectedIndex;
            if (i2 < 0 || i2 >= this.mVideoList.size()) {
                this.mSelectedIndex = 0;
            }
            return this.mVideoList.get(this.mSelectedIndex);
        }
        return (BdVideo) invokeV.objValue;
    }

    public String getSelectedVideoCurrentLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.mSelectedVideoCurrentLength : (String) invokeV.objValue;
    }

    public String getSelectedVideoTotalLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.mSelectedVideoTotalLength : (String) invokeV.objValue;
    }

    public String getSeriesKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.mSeriesKey : (String) invokeV.objValue;
    }

    public int getSeriesType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.mSeriesType : invokeV.intValue;
    }

    public String getSiteDomain() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.mSiteDomain : (String) invokeV.objValue;
    }

    public String getSiteName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.mSiteName : (String) invokeV.objValue;
    }

    public boolean getStartOnPreparedEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? this.mStartOnPreparedEnable : invokeV.booleanValue;
    }

    public int getStartPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            int i2 = this.mStartPosition;
            if (i2 < 0) {
                return -1;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public Object getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? this.mTag : invokeV.objValue;
    }

    public int getTempVideoCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? this.mTempVideoCount : invokeV.intValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? this.mTitle : (String) invokeV.objValue;
    }

    public int getTitleSizePx() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? this.mTitleSizePx : invokeV.intValue;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:3|(2:5|(1:21)(2:9|(5:11|12|13|(2:15|16)|19)))|22|12|13|(0)|19) */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0036 A[Catch: NumberFormatException -> 0x003b, TRY_LEAVE, TryCatch #0 {NumberFormatException -> 0x003b, blocks: (B:16:0x0030, B:18:0x0036), top: B:26:0x0030 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getTotalLength() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
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
        return invokeV.intValue;
    }

    public String getTotalLengthString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
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
        return (String) invokeV.objValue;
    }

    public String getUpdateInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) ? this.mUpdateInfo : (String) invokeV.objValue;
    }

    public long getUpdateTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? this.mUpdateTime : invokeV.longValue;
    }

    public String getUrlExpireTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? this.mUrlExpireTime : (String) invokeV.objValue;
    }

    public String getVPType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) ? this.mVPTYpe : (String) invokeV.objValue;
    }

    @NonNull
    public String getVid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) ? TextUtils.isEmpty(this.vid) ? "" : this.vid : (String) invokeV.objValue;
    }

    public BdVideoAd getVideoAd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) ? this.mVideoAd : (BdVideoAd) invokeV.objValue;
    }

    public int getVideoBps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) ? this.mBps : invokeV.intValue;
    }

    @Nullable
    public BdVideo getVideoByIndex(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048654, this, i2)) == null) {
            List<BdVideo> list = this.mVideoList;
            if (list == null || list.size() <= 0 || i2 < 0 || i2 >= this.mVideoList.size()) {
                return null;
            }
            return this.mVideoList.get(i2);
        }
        return (BdVideo) invokeI.objValue;
    }

    public int getVideoCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            List<BdVideo> list = this.mVideoList;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public String getVideoFaceDetect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) ? this.mHasFaceDetect : (String) invokeV.objValue;
    }

    public int getVideoIndex(BdVideo bdVideo) {
        InterceptResult invokeL;
        List<BdVideo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048658, this, bdVideo)) == null) {
            if (bdVideo == null || (list = this.mVideoList) == null) {
                return -1;
            }
            return list.indexOf(bdVideo);
        }
        return invokeL.intValue;
    }

    public List<BdVideo> getVideoList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) ? this.mVideoList : (List) invokeV.objValue;
    }

    public String getVideoType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) ? this.mVideoType : (String) invokeV.objValue;
    }

    public String getWebPlayerExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) ? this.mWebPlayerExt : (String) invokeV.objValue;
    }

    public boolean hasDecodedMPD() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) ? this.mHasDecodedMPD : invokeV.booleanValue;
    }

    public boolean hasFinishedPlayingAllVideos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            List<BdVideo> list = this.mVideoList;
            if (list != null) {
                int size = list.size();
                int i2 = this.mSelectedIndex;
                if (size == i2 + 1) {
                    return hasFinishedPlayingVideo(this.mVideoList.get(i2));
                }
                return false;
            }
            int i3 = this.mTempVideoCount;
            if (i3 == -1 || i3 != this.mSelectedIndex + 1) {
                return false;
            }
            return isLengthTheSameNotZero(this.mSelectedVideoCurrentLength, this.mSelectedVideoTotalLength);
        }
        return invokeV.booleanValue;
    }

    public boolean hasLongVideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) ? !TextUtils.isEmpty(getLongVideo()) : invokeV.booleanValue;
    }

    public boolean hasPlayed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) ? this.mSelectedIndex != -1 : invokeV.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) ? super.hashCode() : invokeV.intValue;
    }

    public boolean isContainSingleVideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) {
            if (this.mVideoList != null) {
                return getVideoCount() == 1;
            }
            int i2 = this.mTempVideoCount;
            return i2 != -1 && i2 == 1;
        }
        return invokeV.booleanValue;
    }

    public boolean isFavorite() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) ? this.mIsFavorite : invokeV.booleanValue;
    }

    public boolean isFinished() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) ? this.mIsFinished : invokeV.booleanValue;
    }

    public boolean isFromWebpage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) ? this.mIsFromWebpage : invokeV.booleanValue;
    }

    public boolean isFullShare() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) ? this.mIsFullShare : invokeV.booleanValue;
    }

    public boolean isHalfShare() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) ? this.mIsHalfShare : invokeV.booleanValue;
    }

    public boolean isHistory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) ? this.mIsHistory : invokeV.booleanValue;
    }

    public boolean isIgnoreScheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) ? this.mIsIgnoreScheme : invokeV.booleanValue;
    }

    public boolean isInteractVideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) ? RESOURCE_TYPE_INTERACT.equals(getResourceType()) && c.a() : invokeV.booleanValue;
    }

    public boolean isOffline() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) {
            BdVideo selectedVideo = getSelectedVideo();
            if (selectedVideo != null) {
                return !TextUtils.isEmpty(selectedVideo.getLocalSavePath());
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isPlayLoop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) ? this.mIsPlayLoop : invokeV.booleanValue;
    }

    public boolean isReplayVideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) ? this.mIsReplayVideo : invokeV.booleanValue;
    }

    public boolean ismAnimLogoEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) ? this.mAnimLogoEnable : invokeV.booleanValue;
    }

    public boolean needNetToast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) ? this.mNetToast : invokeV.booleanValue;
    }

    public String parseSite(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048681, this, str)) == null) {
            if (!TextUtils.isEmpty(this.mSiteListJason) && !TextUtils.isEmpty(str)) {
                try {
                    JSONArray jSONArray = new JSONArray(this.mSiteListJason);
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i2);
                        if (jSONObject != null && jSONObject.has(JSON_SITE_NAME) && jSONObject.has(JSON_SITE_LOGO) && str.equals(jSONObject.getString(JSON_SITE_NAME))) {
                            return jSONObject.getString(JSON_SITE_LOGO);
                        }
                    }
                } catch (Exception unused) {
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048682, this) == null) || this.mVideoList == null) {
            return;
        }
        this.mVideoList = null;
    }

    public void setAccessTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048683, this, j2) == null) {
            this.mAccessTime = j2;
        }
    }

    public void setAnimLogoDownloadScheme(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048684, this, str) == null) {
            this.mAnimLogoDownloadScheme = str;
        }
    }

    public void setAnimLogoDownloadToast(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048685, this, str) == null) {
            this.mAnimLogoDownloadToast = str;
        }
    }

    public void setAnimLogoEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048686, this, z) == null) {
            this.mAnimLogoEnable = z;
        }
    }

    public void setAnimLogoJumpScheme(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048687, this, str) == null) {
            this.mAnimLogoJumpScheme = str;
        }
    }

    public void setBrief(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048688, this, str) == null) {
            this.mBrief = str;
        }
    }

    public void setClarityTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048689, this, str) == null) {
            this.mClarityTitle = str;
        }
    }

    public void setClarityUrlList(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048690, this, str) == null) {
            try {
                setClarityUrlList(new JSONArray(str));
            } catch (JSONException e2) {
                if (c.a.c0.s.d.f()) {
                    e2.printStackTrace();
                }
                this.mClarityList = new ClarityUrlList();
            }
        }
    }

    public void setCreateTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048693, this, j2) == null) {
            this.mCreateTime = j2;
        }
    }

    public void setDetailId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048694, this, str) == null) {
            this.mDetailId = str;
        }
    }

    public void setDuration(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048695, this, i2) == null) {
            this.mDurationMs = i2 * 1000;
        }
    }

    public void setDurationMs(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048696, this, i2) == null) {
            this.mDurationMs = i2;
        }
    }

    public void setExt(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048697, this, str) == null) {
            this.mExt = str;
        }
    }

    public void setExtLog(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048698, this, str) == null) {
            this.mExtLog = str;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            searchID = b.b(str).optString("searchID");
        }
    }

    public void setFavorite(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048699, this, z) == null) {
            this.mIsFavorite = z;
        }
    }

    public void setFloatingDisable(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048700, this, str) == null) {
            this.mFloatDisable = str;
        }
    }

    public void setFormat(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048701, this, str) == null) {
            this.mFormat = str;
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048702, this, str) == null) {
            this.mFrom = str;
        }
    }

    public void setFromWebpage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048703, this, z) == null) {
            this.mIsFromWebpage = z;
        }
    }

    public void setFullShare(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048704, this, z) == null) {
            this.mIsFullShare = z;
        }
    }

    public void setHalfShare(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048705, this, z) == null) {
            this.mIsHalfShare = z;
        }
    }

    public void setHasDecodedMPD(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048706, this, z) == null) {
            this.mHasDecodedMPD = z;
        }
    }

    public void setHistory(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048707, this, z) == null) {
            this.mIsHistory = z;
        }
    }

    public void setHotCommentList(List<d> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048708, this, list) == null) {
            this.mCommentList = list;
        }
    }

    public void setHttpHeader(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048709, this, str) == null) {
            this.mHttpHeader = str;
        }
    }

    public void setId(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048710, this, j2) == null) {
            this.mId = j2;
        }
    }

    public void setIgnoreScheme(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048711, this, z) == null) {
            this.mIsIgnoreScheme = z;
        }
    }

    public void setImgUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048712, this, str) == null) {
            this.mImgUrl = str;
        }
    }

    public void setIntro(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048713, this, str) == null) {
            this.mIntro = str;
        }
    }

    public void setIsFinished(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048714, this, z) == null) {
            this.mIsFinished = z;
        }
    }

    public void setIsUpdate(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048715, this, z) == null) {
            this.mIsUpdate = z;
        }
    }

    public void setLoadFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048716, this, i2) == null) {
            this.mLoadFrom = i2;
        }
    }

    public void setLongVideo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048717, this, str) == null) {
            this.mLongVideo = str;
        }
    }

    public void setMPD(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048718, this, str) == null) {
            this.mMPD = str;
        }
    }

    public void setMPDUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048719, this, str) == null) {
            this.mMPDUrl = str;
        }
    }

    public void setMPDVid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048720, this, str) == null) {
            this.mMPDVid = str;
        }
    }

    public void setMaxNum(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048721, this, str) == null) {
            this.mMaxNum = str;
        }
    }

    public void setMoovSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048722, this, i2) == null) {
            this.mMoovSize = i2;
        }
    }

    public void setNetToast(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048723, this, z) == null) {
            this.mNetToast = z;
        }
    }

    public void setNid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048724, this, str) == null) {
            this.mNid = str;
        }
    }

    public void setOffline(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048725, this, z) == null) {
            this.mIsOffline = z;
        }
    }

    public void setOffset(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048726, this, i2) == null) {
            this.mOffset = i2;
        }
    }

    public void setOriginalUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048727, this, str) == null) {
            this.mOriginalUrl = str;
        }
    }

    public void setPage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048728, this, str) == null) {
            this.mPage = str;
        }
    }

    public void setPd(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048729, this, str) == null) {
            this.mPd = str;
        }
    }

    public void setPlayConf(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048730, this, str) == null) {
            this.mPlayConf = str;
        }
    }

    public void setPlayLoop(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048731, this, z) == null) {
            this.mIsPlayLoop = z;
        }
    }

    public void setPlayerId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048732, this, str) == null) {
            this.mPlayerId = str;
        }
    }

    public void setPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048733, this, i2) == null) {
            this.mPositionMs = i2 * 1000;
        }
    }

    public void setPositionMs(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048734, this, i2) == null) {
            this.mPositionMs = i2;
        }
    }

    public void setPoster(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048735, this, str) == null) {
            this.mPoster = str;
        }
    }

    public void setPrepareTime(long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048736, this, j2) == null) || j2 <= 0) {
            return;
        }
        this.mPrepareTime = j2;
    }

    public void setPreview6sUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048737, this, str) == null) {
            this.mPreview6sUrl = str;
        }
    }

    public void setProxy(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048738, this, str) == null) {
            this.mProxy = str;
        }
    }

    public void setRecommendList(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048739, this, str) == null) {
            this.mRecommendList = str;
        }
    }

    public void setReplayVideo(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048740, this, z) == null) {
            this.mIsReplayVideo = z;
            setStartPosition(z ? 0 : -1);
        }
    }

    public void setReserve(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048741, this, str) == null) {
            this.mReserve = str;
        }
    }

    public void setResourceType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048742, this, str) == null) {
            this.mResourceType = str;
        }
    }

    public void setSelectedIndex(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048743, this, i2) == null) {
            this.mSelectedIndex = i2;
        }
    }

    public void setSelectedNum(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048744, this, i2) == null) {
            this.mSelectedNum = i2;
        }
    }

    public void setSelectedVideoCurrentLength(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048745, this, str) == null) {
            this.mSelectedVideoCurrentLength = str;
        }
    }

    public void setSelectedVideoTotalLength(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048746, this, str) == null) {
            this.mSelectedVideoTotalLength = str;
        }
    }

    public void setSeriesKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048747, this, str) == null) {
            this.mSeriesKey = str;
        }
    }

    public void setSeriesType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048748, this, i2) == null) {
            this.mSeriesType = i2;
        }
    }

    public void setShareMode(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048749, this, jSONObject) == null) {
            if (jSONObject != null) {
                this.mIsHalfShare = jSONObject.optBoolean("half", false);
                this.mIsFullShare = jSONObject.optBoolean("full", false);
                return;
            }
            this.mIsHalfShare = false;
            this.mIsFullShare = false;
        }
    }

    public void setSiteDomain(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048750, this, str) == null) {
            this.mSiteDomain = str;
        }
    }

    public void setSiteName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048751, this, str) == null) {
            this.mSiteName = str;
        }
    }

    public void setStartOnPreparedEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048752, this, z) == null) {
            this.mStartOnPreparedEnable = z;
        }
    }

    public void setStartPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048753, this, i2) == null) {
            this.mStartPosition = i2;
        }
    }

    public void setTag(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048754, this, obj) == null) {
            this.mTag = obj;
        }
    }

    public void setTempVideoCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048755, this, i2) == null) {
            this.mTempVideoCount = i2;
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048756, this, str) == null) {
            this.mTitle = str;
        }
    }

    public void setTitleSizePx(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048757, this, i2) == null) {
            this.mTitleSizePx = i2;
        }
    }

    public void setUpdateInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048758, this, str) == null) {
            this.mUpdateInfo = str;
        }
    }

    public void setUpdateTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048759, this, j2) == null) {
            this.mUpdateTime = j2;
        }
    }

    public void setUrlExpireTime(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048760, this, str) == null) {
            this.mUrlExpireTime = str;
        }
    }

    public void setVPType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048761, this, str) == null) {
            this.mVPTYpe = str;
        }
    }

    public void setVid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048762, this, str) == null) {
            this.vid = str;
        }
    }

    public void setVideoAd(BdVideoAd bdVideoAd) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048763, this, bdVideoAd) == null) {
            this.mVideoAd = bdVideoAd;
        }
    }

    public void setVideoBps(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048764, this, i2) == null) {
            this.mBps = i2;
        }
    }

    public void setVideoFaceDetect(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048765, this, str) == null) {
            this.mHasFaceDetect = str;
        }
    }

    public void setVideoList(List<BdVideo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048766, this, list) == null) {
            this.mVideoList = list;
        }
    }

    public void setVideoType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048767, this, str) == null) {
            this.mVideoType = str;
        }
    }

    public void setWebPlayerExt(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048768, this, str) == null) {
            this.mWebPlayerExt = str;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048769, this)) == null) {
            boolean z = getVideoList() == null;
            StringBuilder sb = new StringBuilder();
            sb.append(" detail id: ");
            sb.append(TextUtils.isEmpty(getNid()) ? getVid() : getNid());
            sb.append(", title: ");
            sb.append(getTitle());
            sb.append(", video list size: ");
            sb.append(z ? null : Integer.valueOf(getVideoList().size()));
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
        return (String) invokeV.objValue;
    }

    public void updateClarityUrlList(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048770, this, str, z) == null) {
            ClarityUrlList clarityUrlList = this.mClarityList;
            try {
                setClarityUrlList(new JSONArray(str));
            } catch (JSONException e2) {
                e2.printStackTrace();
                this.mClarityList = new ClarityUrlList();
            }
            if (!z || clarityUrlList == null || clarityUrlList.size() <= 0) {
                return;
            }
            ClarityUrlList.c clarityByOriginRank = this.mClarityList.getClarityByOriginRank(clarityUrlList.getCurrentClarityUrl().f38189f);
            if (clarityByOriginRank != null) {
                this.mClarityList.setCurrentClarityUrl(clarityByOriginRank);
                if (c.a.c0.s.w.d.b()) {
                    this.mClarityList.setMultiRateSwitchRank(clarityByOriginRank.f38190g);
                    return;
                }
                return;
            }
            this.mClarityList.updateCurrentClarityToLowest();
        }
    }

    public void updateClarityUrlListFromMPD() {
        JSONArray b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048773, this) == null) || (b2 = c.a.c0.s.n0.a.b.b(this.mMPD)) == null) {
            return;
        }
        updateClarityUrlList(b2, true);
    }

    public void updateVideo(BdVideo bdVideo) {
        List<BdVideo> list;
        int size;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048774, this, bdVideo) == null) || (list = this.mVideoList) == null || (size = list.size()) <= 0) {
            return;
        }
        for (int i2 = 0; i2 < size; i2++) {
            BdVideo bdVideo2 = this.mVideoList.get(i2);
            if (bdVideo2.equalsCustom(bdVideo)) {
                this.mVideoList.remove(bdVideo2);
                this.mVideoList.add(bdVideo);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public BdVideoSeries m42clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                return (BdVideoSeries) super.clone();
            } catch (CloneNotSupportedException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (BdVideoSeries) invokeV.objValue;
    }

    public int getVideoIndex(long j2) {
        InterceptResult invokeJ;
        List<BdVideo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048657, this, j2)) == null) {
            if (j2 >= 0 && (list = this.mVideoList) != null) {
                for (BdVideo bdVideo : list) {
                    if (bdVideo.getId() == j2) {
                        return this.mVideoList.indexOf(bdVideo);
                    }
                }
            }
            return -1;
        }
        return invokeJ.intValue;
    }

    public void setClarityUrlList(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048691, this, str, z) == null) {
            if (z) {
                JSONArray b2 = c.a.c0.s.n0.a.b.b(str);
                if (b2 != null) {
                    setClarityUrlList(b2);
                    return;
                }
                return;
            }
            setClarityUrlList(str);
        }
    }

    public void setClarityUrlList(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048692, this, jSONArray) == null) {
            this.mClarityList = new ClarityUrlList(jSONArray, isMultiPlanSmartClarityEffective());
        }
    }

    public void updateClarityUrlList(String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048771, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z2) {
                JSONArray b2 = c.a.c0.s.n0.a.b.b(str);
                if (b2 != null) {
                    updateClarityUrlList(b2, z);
                    return;
                }
                return;
            }
            updateClarityUrlList(str, z);
        }
    }

    public void updateClarityUrlList(JSONArray jSONArray, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048772, this, jSONArray, z) == null) {
            updateClarityUrlList(jSONArray.toString(), z);
        }
    }
}
