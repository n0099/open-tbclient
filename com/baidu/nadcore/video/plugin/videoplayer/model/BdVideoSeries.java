package com.baidu.nadcore.video.plugin.videoplayer.model;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.video.plugin.videoplayer.model.ClarityUrlList;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.ar0;
import com.baidu.tieba.ez0;
import com.baidu.tieba.rr0;
import com.baidu.tieba.sr0;
import com.baidu.tieba.tx0;
import com.baidu.tieba.yz0;
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
/* loaded from: classes2.dex */
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
    public List mCommentList;
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
    public int mTitleSizePx;
    public String mUpdateInfo;
    public long mUpdateTime;
    public String mUrlExpireTime;
    public String mVPTYpe;
    public BdVideoAd mVideoAd;
    public List mVideoList;
    public String mVideoType;
    public String mWebPlayerExt;
    public String vid;

    public BdVideoSeries() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    public boolean clearNewFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            setIsUpdate(false);
            ez0.a("is update: " + getIsUpdate());
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
        return invokeV.booleanValue;
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
                BdVideo bdVideo = (BdVideo) getVideoList().get(selectedIndex);
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
                BdVideo bdVideo = (BdVideo) getVideoList().get(selectedIndex);
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
                BdVideo bdVideo = (BdVideo) getVideoList().get(selectedIndex);
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

    public static void amendLastPagePd(BdVideoSeries bdVideoSeries, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, bdVideoSeries, str) != null) || bdVideoSeries == null) {
            return;
        }
        String extLog = bdVideoSeries.getExtLog();
        if (!TextUtils.isEmpty(extLog)) {
            JSONObject c = yz0.c(extLog);
            yz0.f(c, "lastpage_pd", str);
            bdVideoSeries.setExtLog(c.toString());
        }
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
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static int parseIntSafe(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, str, i)) == null) {
            if (TextUtils.isEmpty(str)) {
                return i;
            }
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                ez0.a(e.getMessage());
                return i;
            }
        }
        return invokeLI.intValue;
    }

    public void setClarityUrlList(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048691, this, str, z) == null) {
            if (z) {
                JSONArray b = tx0.b(str);
                if (b != null) {
                    setClarityUrlList(b);
                    return;
                }
                return;
            }
            setClarityUrlList(str);
        }
    }

    public void updateClarityUrlList(JSONArray jSONArray, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048772, this, jSONArray, z) == null) {
            updateClarityUrlList(jSONArray.toString(), z);
        }
    }

    public static String getFormattedLengthString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    int parseInt = Integer.parseInt(str);
                    if (parseInt < 0) {
                        return "";
                    }
                    return getTextWithSecond(parseInt);
                } catch (Exception e) {
                    ez0.f("getFormattedLengthString(" + str + SmallTailInfo.EMOTION_SUFFIX, e);
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public boolean containVideo(BdVideo bdVideo) {
        InterceptResult invokeL;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bdVideo)) == null) {
            List list = this.mVideoList;
            if (list == null || (size = list.size()) <= 0) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (((BdVideo) this.mVideoList.get(i)).equalsCustom(bdVideo)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int getVideoIndex(long j) {
        InterceptResult invokeJ;
        List<BdVideo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048657, this, j)) == null) {
            if (j >= 0 && (list = this.mVideoList) != null) {
                for (BdVideo bdVideo : list) {
                    if (bdVideo.getId() == j) {
                        return this.mVideoList.indexOf(bdVideo);
                    }
                }
            }
            return -1;
        }
        return invokeJ.intValue;
    }

    public void updateVideo(BdVideo bdVideo) {
        List list;
        int size;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048774, this, bdVideo) != null) || (list = this.mVideoList) == null || (size = list.size()) <= 0) {
            return;
        }
        for (int i = 0; i < size; i++) {
            BdVideo bdVideo2 = (BdVideo) this.mVideoList.get(i);
            if (bdVideo2.equalsCustom(bdVideo)) {
                this.mVideoList.remove(bdVideo2);
                this.mVideoList.add(bdVideo);
                return;
            }
        }
    }

    public static String getSearchID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return searchID;
        }
        return (String) invokeV.objValue;
    }

    private boolean isMultiPlanSmartClarityEffective() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            return !"search".equals(getFrom());
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public BdVideoSeries m38clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                return (BdVideoSeries) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (BdVideoSeries) invokeV.objValue;
    }

    public long getAccessTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mAccessTime;
        }
        return invokeV.longValue;
    }

    public String getAnimLogoDownloadScheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mAnimLogoDownloadScheme;
        }
        return (String) invokeV.objValue;
    }

    public String getAnimLogoDownloadToast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mAnimLogoDownloadToast;
        }
        return (String) invokeV.objValue;
    }

    public String getAnimLogoJumpScheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mAnimLogoJumpScheme;
        }
        return (String) invokeV.objValue;
    }

    public String getBrief() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mBrief;
        }
        return (String) invokeV.objValue;
    }

    public ClarityUrlList getClarityList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mClarityList;
        }
        return (ClarityUrlList) invokeV.objValue;
    }

    public String getClarityTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (TextUtils.isEmpty(this.mClarityTitle)) {
                return ar0.b().getResources().getString(R.string.obfuscated_res_0x7f0f0ba0);
            }
            return this.mClarityTitle;
        }
        return (String) invokeV.objValue;
    }

    public long getCreateTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.mCreateTime;
        }
        return invokeV.longValue;
    }

    public String getDetailId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.mDetailId;
        }
        return (String) invokeV.objValue;
    }

    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.mDurationMs / 1000;
        }
        return invokeV.intValue;
    }

    public int getDurationMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.mDurationMs;
        }
        return invokeV.intValue;
    }

    public String getExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.mExt;
        }
        return (String) invokeV.objValue;
    }

    public String getExtLog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.mExtLog;
        }
        return (String) invokeV.objValue;
    }

    public String getFloatDisable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.mFloatDisable;
        }
        return (String) invokeV.objValue;
    }

    public String getFormat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.mFormat;
        }
        return (String) invokeV.objValue;
    }

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

    public List getHotComments() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.mCommentList;
        }
        return (List) invokeV.objValue;
    }

    public String getHttpHeader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.mHttpHeader;
        }
        return (String) invokeV.objValue;
    }

    public long getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.mId;
        }
        return invokeV.longValue;
    }

    public String getImgUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.mImgUrl;
        }
        return (String) invokeV.objValue;
    }

    public String getIntro() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.mIntro;
        }
        return (String) invokeV.objValue;
    }

    public boolean getIsUpdate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.mIsUpdate;
        }
        return invokeV.booleanValue;
    }

    public int getLoadFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.mLoadFrom;
        }
        return invokeV.intValue;
    }

    public String getLongVideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.mLongVideo;
        }
        return (String) invokeV.objValue;
    }

    public String getMPD() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.mMPD;
        }
        return (String) invokeV.objValue;
    }

    public String getMPDUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.mMPDUrl;
        }
        return (String) invokeV.objValue;
    }

    public String getMPDVid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.mMPDVid;
        }
        return (String) invokeV.objValue;
    }

    public String getMaxNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.mMaxNum;
        }
        return (String) invokeV.objValue;
    }

    public int getMoovSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.mMoovSize;
        }
        return invokeV.intValue;
    }

    public String getNid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.mNid;
        }
        return (String) invokeV.objValue;
    }

    public int getOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.mOffset;
        }
        return invokeV.intValue;
    }

    public String getOriginalUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.mOriginalUrl;
        }
        return (String) invokeV.objValue;
    }

    public String getPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            String str = this.mPage;
            if (str == null) {
                return "";
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public String getPd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            String str = this.mPd;
            if (str == null) {
                return "";
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public String getPlayConf() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.mPlayConf;
        }
        return (String) invokeV.objValue;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return this.mPlayerId;
        }
        return (String) invokeV.objValue;
    }

    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.mPositionMs / 1000;
        }
        return invokeV.intValue;
    }

    public int getPositionMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return this.mPositionMs;
        }
        return invokeV.intValue;
    }

    public String getPoster() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return this.mPoster;
        }
        return (String) invokeV.objValue;
    }

    public long getPrepareTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.mPrepareTime;
        }
        return invokeV.longValue;
    }

    public String getPreview6sUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return this.mPreview6sUrl;
        }
        return (String) invokeV.objValue;
    }

    public String getProxy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return this.mProxy;
        }
        return (String) invokeV.objValue;
    }

    public String getRecommendList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return this.mRecommendList;
        }
        return (String) invokeV.objValue;
    }

    public String getReserve() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            return this.mReserve;
        }
        return (String) invokeV.objValue;
    }

    public String getResourceType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return this.mResourceType;
        }
        return (String) invokeV.objValue;
    }

    public int getSelectedIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return this.mSelectedIndex;
        }
        return invokeV.intValue;
    }

    public int getSelectedNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            return this.mSelectedNum;
        }
        return invokeV.intValue;
    }

    public String getSelectedVideoCurrentLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return this.mSelectedVideoCurrentLength;
        }
        return (String) invokeV.objValue;
    }

    public String getSelectedVideoTotalLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return this.mSelectedVideoTotalLength;
        }
        return (String) invokeV.objValue;
    }

    public String getSeriesKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return this.mSeriesKey;
        }
        return (String) invokeV.objValue;
    }

    public int getSeriesType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            return this.mSeriesType;
        }
        return invokeV.intValue;
    }

    public String getSiteDomain() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            return this.mSiteDomain;
        }
        return (String) invokeV.objValue;
    }

    public String getSiteName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            return this.mSiteName;
        }
        return (String) invokeV.objValue;
    }

    public boolean getStartOnPreparedEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            return this.mStartOnPreparedEnable;
        }
        return invokeV.booleanValue;
    }

    public int getStartPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            int i = this.mStartPosition;
            if (i < 0) {
                return -1;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public Object getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            return this.mTag;
        }
        return invokeV.objValue;
    }

    public int getTempVideoCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            return this.mTempVideoCount;
        }
        return invokeV.intValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            return this.mTitle;
        }
        return (String) invokeV.objValue;
    }

    public int getTitleSizePx() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            return this.mTitleSizePx;
        }
        return invokeV.intValue;
    }

    public String getUpdateInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            return this.mUpdateInfo;
        }
        return (String) invokeV.objValue;
    }

    public long getUpdateTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            return this.mUpdateTime;
        }
        return invokeV.longValue;
    }

    public String getUrlExpireTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            return this.mUrlExpireTime;
        }
        return (String) invokeV.objValue;
    }

    public String getVPType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            return this.mVPTYpe;
        }
        return (String) invokeV.objValue;
    }

    public String getVid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            if (TextUtils.isEmpty(this.vid)) {
                return "";
            }
            return this.vid;
        }
        return (String) invokeV.objValue;
    }

    public BdVideoAd getVideoAd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            return this.mVideoAd;
        }
        return (BdVideoAd) invokeV.objValue;
    }

    public int getVideoBps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            return this.mBps;
        }
        return invokeV.intValue;
    }

    public int getVideoCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            List list = this.mVideoList;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            return this.mHasFaceDetect;
        }
        return (String) invokeV.objValue;
    }

    public List getVideoList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            return this.mVideoList;
        }
        return (List) invokeV.objValue;
    }

    public String getVideoType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            return this.mVideoType;
        }
        return (String) invokeV.objValue;
    }

    public String getWebPlayerExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            return this.mWebPlayerExt;
        }
        return (String) invokeV.objValue;
    }

    public boolean hasDecodedMPD() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            return this.mHasDecodedMPD;
        }
        return invokeV.booleanValue;
    }

    public boolean hasLongVideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) {
            return !TextUtils.isEmpty(getLongVideo());
        }
        return invokeV.booleanValue;
    }

    public boolean hasPlayed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) {
            if (this.mSelectedIndex != -1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) {
            return super.hashCode();
        }
        return invokeV.intValue;
    }

    public boolean isContainSingleVideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) {
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
        return invokeV.booleanValue;
    }

    public boolean isFavorite() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) {
            return this.mIsFavorite;
        }
        return invokeV.booleanValue;
    }

    public boolean isFinished() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            return this.mIsFinished;
        }
        return invokeV.booleanValue;
    }

    public boolean isFromWebpage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) {
            return this.mIsFromWebpage;
        }
        return invokeV.booleanValue;
    }

    public boolean isFullShare() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            return this.mIsFullShare;
        }
        return invokeV.booleanValue;
    }

    public boolean isHalfShare() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) {
            return this.mIsHalfShare;
        }
        return invokeV.booleanValue;
    }

    public boolean isHistory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) {
            return this.mIsHistory;
        }
        return invokeV.booleanValue;
    }

    public boolean isIgnoreScheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            return this.mIsIgnoreScheme;
        }
        return invokeV.booleanValue;
    }

    public boolean isInteractVideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) {
            if (RESOURCE_TYPE_INTERACT.equals(getResourceType()) && rr0.a()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) {
            return this.mIsPlayLoop;
        }
        return invokeV.booleanValue;
    }

    public boolean isReplayVideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) {
            return this.mIsReplayVideo;
        }
        return invokeV.booleanValue;
    }

    public boolean ismAnimLogoEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) {
            return this.mAnimLogoEnable;
        }
        return invokeV.booleanValue;
    }

    public boolean needNetToast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) {
            return this.mNetToast;
        }
        return invokeV.booleanValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048682, this) == null) && this.mVideoList != null) {
            this.mVideoList = null;
        }
    }

    public void updateClarityUrlListFromMPD() {
        JSONArray b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048773, this) == null) && (b = tx0.b(this.mMPD)) != null) {
            updateClarityUrlList(b, true);
        }
    }

    public static String getTextWithSecond(int i) {
        InterceptResult invokeI;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i)) == null) {
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
        return (String) invokeI.objValue;
    }

    public String parseSite(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048681, this, str)) == null) {
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
        return (String) invokeL.objValue;
    }

    public static boolean hasFinishedPlayingVideo(BdVideo bdVideo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bdVideo)) == null) {
            if (bdVideo != null && bdVideo.getCurrentLength() != null && bdVideo.getTotalLength() != null) {
                return isLengthTheSameNotZero(bdVideo.getCurrentLength(), bdVideo.getTotalLength());
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void appendVideoList(List list) {
        List list2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, list) == null) && list != null && (list2 = this.mVideoList) != null) {
            list2.addAll(list);
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (!(obj instanceof BdVideoSeries) || (str = this.mDetailId) == null || !str.equals(((BdVideoSeries) obj).getDetailId())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public BdVideo findVideoByIndex(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            List list = this.mVideoList;
            if (list != null && i >= 0 && i < list.size()) {
                return (BdVideo) this.mVideoList.get(i);
            }
            return null;
        }
        return (BdVideo) invokeI.objValue;
    }

    public BdVideo getVideoByIndex(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048654, this, i)) == null) {
            List list = this.mVideoList;
            if (list != null && list.size() > 0 && i >= 0 && i < this.mVideoList.size()) {
                return (BdVideo) this.mVideoList.get(i);
            }
            return null;
        }
        return (BdVideo) invokeI.objValue;
    }

    public int getVideoIndex(BdVideo bdVideo) {
        InterceptResult invokeL;
        List list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048658, this, bdVideo)) == null) {
            if (bdVideo != null && (list = this.mVideoList) != null) {
                return list.indexOf(bdVideo);
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public void setAccessTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048683, this, j) == null) {
            this.mAccessTime = j;
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
            } catch (JSONException e) {
                if (ar0.f()) {
                    e.printStackTrace();
                }
                this.mClarityList = new ClarityUrlList();
            }
        }
    }

    public void setCreateTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048693, this, j) == null) {
            this.mCreateTime = j;
        }
    }

    public void setDetailId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048694, this, str) == null) {
            this.mDetailId = str;
        }
    }

    public void setDuration(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048695, this, i) == null) {
            this.mDurationMs = i * 1000;
        }
    }

    public void setDurationMs(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048696, this, i) == null) {
            this.mDurationMs = i;
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
            if (!TextUtils.isEmpty(str)) {
                searchID = yz0.c(str).optString("searchID");
            }
        }
    }

    public void setFavorite(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048699, this, z) == null) {
            this.mIsFavorite = z;
        }
    }

    public void setFloatingDisable(String str) {
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

    public void setHotCommentList(List list) {
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

    public void setId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048710, this, j) == null) {
            this.mId = j;
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

    public void setLoadFrom(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048716, this, i) == null) {
            this.mLoadFrom = i;
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

    public void setMoovSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048722, this, i) == null) {
            this.mMoovSize = i;
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

    public void setOffset(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048726, this, i) == null) {
            this.mOffset = i;
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

    public void setPosition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048733, this, i) == null) {
            this.mPositionMs = i * 1000;
        }
    }

    public void setPositionMs(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048734, this, i) == null) {
            this.mPositionMs = i;
        }
    }

    public void setPoster(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048735, this, str) == null) {
            this.mPoster = str;
        }
    }

    public void setPrepareTime(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048736, this, j) == null) && j > 0) {
            this.mPrepareTime = j;
        }
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
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048740, this, z) == null) {
            this.mIsReplayVideo = z;
            if (z) {
                i = 0;
            } else {
                i = -1;
            }
            setStartPosition(i);
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

    public void setSelectedIndex(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048743, this, i) == null) {
            this.mSelectedIndex = i;
        }
    }

    public void setSelectedNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048744, this, i) == null) {
            this.mSelectedNum = i;
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

    public void setSeriesType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048748, this, i) == null) {
            this.mSeriesType = i;
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

    public void setStartPosition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048753, this, i) == null) {
            this.mStartPosition = i;
        }
    }

    public void setTag(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048754, this, obj) == null) {
            this.mTag = obj;
        }
    }

    public void setTempVideoCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048755, this, i) == null) {
            this.mTempVideoCount = i;
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048756, this, str) == null) {
            this.mTitle = str;
        }
    }

    public void setTitleSizePx(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048757, this, i) == null) {
            this.mTitleSizePx = i;
        }
    }

    public void setUpdateInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048758, this, str) == null) {
            this.mUpdateInfo = str;
        }
    }

    public void setUpdateTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048759, this, j) == null) {
            this.mUpdateTime = j;
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

    public void setVideoBps(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048764, this, i) == null) {
            this.mBps = i;
        }
    }

    public void setVideoFaceDetect(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048765, this, str) == null) {
            this.mHasFaceDetect = str;
        }
    }

    public void setVideoList(List list) {
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

    public static double parseDoubleSafe(String str, double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{str, Double.valueOf(d)})) == null) {
            if (TextUtils.isEmpty(str)) {
                return d;
            }
            try {
                return Double.parseDouble(str);
            } catch (NumberFormatException e) {
                ez0.a(e.getMessage());
                return d;
            }
        }
        return invokeCommon.doubleValue;
    }

    public BdVideo getSelectedVideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            List list = this.mVideoList;
            if (list != null && list.size() > 0) {
                int i = this.mSelectedIndex;
                if (i < 0 || i >= this.mVideoList.size()) {
                    this.mSelectedIndex = 0;
                }
                return (BdVideo) this.mVideoList.get(this.mSelectedIndex);
            }
            return null;
        }
        return (BdVideo) invokeV.objValue;
    }

    public boolean hasFinishedPlayingAllVideos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            List list = this.mVideoList;
            if (list != null) {
                int size = list.size();
                int i = this.mSelectedIndex;
                if (size == i + 1) {
                    return hasFinishedPlayingVideo((BdVideo) this.mVideoList.get(i));
                }
                return false;
            }
            int i2 = this.mTempVideoCount;
            if (i2 != -1 && i2 == this.mSelectedIndex + 1) {
                return isLengthTheSameNotZero(this.mSelectedVideoCurrentLength, this.mSelectedVideoTotalLength);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void setClarityUrlList(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048692, this, jSONArray) == null) {
            this.mClarityList = new ClarityUrlList(jSONArray, isMultiPlanSmartClarityEffective());
        }
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        String nid;
        Integer valueOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048769, this)) == null) {
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
        return (String) invokeV.objValue;
    }

    public void updateClarityUrlList(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048770, this, str, z) == null) {
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
                    if (sr0.b()) {
                        this.mClarityList.setMultiRateSwitchRank(clarityByOriginRank.c);
                        return;
                    }
                    return;
                }
                this.mClarityList.updateCurrentClarityToLowest();
            }
        }
    }

    public void updateClarityUrlList(String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048771, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z2) {
                JSONArray b = tx0.b(str);
                if (b != null) {
                    updateClarityUrlList(b, z);
                    return;
                }
                return;
            }
            updateClarityUrlList(str, z);
        }
    }
}
