package com.baidu.nadcore.video.plugin.videoplayer.model;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
@SuppressLint({"KotlinPropertyAccess"})
/* loaded from: classes2.dex */
public class BdVideo implements Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic = null;
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
    public transient /* synthetic */ FieldHolder $fh;
    public String mAlbumId;
    public String mBitRate;
    public String mCurrentLength;
    public int mDecodeMode;
    public int mDownloadFrom;
    public String mDownloadKey;
    public String mDownloadUrl;
    public long mId;
    public String mImgUrl;
    public boolean mIsNew;
    public String mLocalSavePath;
    public String mPlayUrl;
    public String mReserve;
    public long mSeriesId;
    public int mSeriesNum;
    public String mShowShare;
    public String mShowTitle;
    public String mSourceUrl;
    public Object mTag;
    public String mTitle;
    public String mTotalLength;
    public String mTvId;
    public int mType;
    public String mVideoFrom;
    public String mVideoId;
    public String mVideoType;

    public BdVideo() {
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
        this.mSeriesNum = 1;
        this.mTotalLength = "-1";
        this.mCurrentLength = "-1";
        this.mIsNew = false;
        this.mDecodeMode = 0;
        this.mDownloadKey = "";
        this.mDownloadFrom = 0;
        this.mAlbumId = "";
        this.mTvId = "";
        this.mVideoId = "";
        this.mVideoFrom = "";
        this.mVideoType = "";
        this.mType = 101;
    }

    public String getCurrentLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (!TextUtils.isEmpty(this.mCurrentLength) && this.mCurrentLength.contains(".")) {
                String str = this.mCurrentLength;
                return str.substring(0, str.indexOf("."));
            }
            return this.mCurrentLength;
        }
        return (String) invokeV.objValue;
    }

    public void clearWatchedInfo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mCurrentLength = "-1";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public BdVideo m39clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                return (BdVideo) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (BdVideo) invokeV.objValue;
    }

    public String getAlbumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mAlbumId;
        }
        return (String) invokeV.objValue;
    }

    public String getBitRate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mBitRate;
        }
        return (String) invokeV.objValue;
    }

    public int getDecodeMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mDecodeMode;
        }
        return invokeV.intValue;
    }

    public int getDownloadFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mDownloadFrom;
        }
        return invokeV.intValue;
    }

    public String getDownloadKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mDownloadKey;
        }
        return (String) invokeV.objValue;
    }

    public String getDownloadUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mDownloadUrl;
        }
        return (String) invokeV.objValue;
    }

    public long getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mId;
        }
        return invokeV.longValue;
    }

    public String getImgUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mImgUrl;
        }
        return (String) invokeV.objValue;
    }

    public String getLocalSavePath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mLocalSavePath;
        }
        return (String) invokeV.objValue;
    }

    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.mPlayUrl;
        }
        return (String) invokeV.objValue;
    }

    public String getReserve() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.mReserve;
        }
        return (String) invokeV.objValue;
    }

    public long getSeriesId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.mSeriesId;
        }
        return invokeV.longValue;
    }

    public int getSeriesNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.mSeriesNum;
        }
        return invokeV.intValue;
    }

    public boolean getShowShare() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return Boolean.parseBoolean(this.mShowShare);
        }
        return invokeV.booleanValue;
    }

    public boolean getShowTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return Boolean.parseBoolean(this.mShowTitle);
        }
        return invokeV.booleanValue;
    }

    public String getSourceUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.mSourceUrl;
        }
        return (String) invokeV.objValue;
    }

    public Object getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.mTag;
        }
        return invokeV.objValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.mTitle;
        }
        return (String) invokeV.objValue;
    }

    public String getTotalLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.mTotalLength;
        }
        return (String) invokeV.objValue;
    }

    public String getTvId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.mTvId;
        }
        return (String) invokeV.objValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.mType;
        }
        return invokeV.intValue;
    }

    public String getVideoFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.mVideoFrom;
        }
        return (String) invokeV.objValue;
    }

    public String getVideoId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.mVideoId;
        }
        return (String) invokeV.objValue;
    }

    public String getVideoType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.mVideoType;
        }
        return (String) invokeV.objValue;
    }

    public boolean isNew() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.mIsNew;
        }
        return invokeV.booleanValue;
    }

    public boolean equalsCustom(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
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
        return invokeL.booleanValue;
    }

    public void setAlbumId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            this.mAlbumId = str;
        }
    }

    public void setBitRate(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            this.mBitRate = str;
        }
    }

    public void setCurrentLength(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
            this.mCurrentLength = str;
        }
    }

    public void setDecodeMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i) == null) {
            this.mDecodeMode = i;
        }
    }

    public void setDownloadFrom(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i) == null) {
            this.mDownloadFrom = i;
        }
    }

    public void setDownloadKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            this.mDownloadKey = str;
        }
    }

    public void setDownloadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            this.mDownloadUrl = str;
        }
    }

    public void setId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048613, this, j) == null) {
            this.mId = j;
        }
    }

    public void setImgUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
            this.mImgUrl = str;
        }
    }

    public void setIsNew(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.mIsNew = z;
        }
    }

    public void setLocalSavePath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, str) == null) {
            this.mLocalSavePath = str;
        }
    }

    public void setPlayUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
            this.mPlayUrl = str;
        }
    }

    public void setReserve(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, str) == null) {
            this.mReserve = str;
        }
    }

    public void setSeriesId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048619, this, j) == null) {
            this.mSeriesId = j;
        }
    }

    public void setSeriesNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i) == null) {
            this.mSeriesNum = i;
        }
    }

    public void setShowShare(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, str) == null) {
            this.mShowShare = str;
        }
    }

    public void setShowTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            this.mShowTitle = str;
        }
    }

    public void setSourceUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, str) == null) {
            this.mSourceUrl = str;
        }
    }

    public void setTag(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, obj) == null) {
            this.mTag = obj;
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, str) == null) {
            this.mTitle = str;
        }
    }

    public void setTotalLength(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, str) == null) {
            this.mTotalLength = str;
        }
    }

    public void setTvId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, str) == null) {
            this.mTvId = str;
        }
    }

    public void setType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048628, this, i) == null) {
            this.mType = i;
        }
    }

    public void setVideoFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, str) == null) {
            this.mVideoFrom = str;
        }
    }

    public void setVideoId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, str) == null) {
            this.mVideoId = str;
        }
    }

    public void setVideoType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, str) == null) {
            this.mVideoType = str;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return "title: " + getTitle() + "\n play url: " + getPlayUrl() + "\n pos: " + getCurrentLength() + "\n total: " + getTotalLength() + "\n DL url: " + getDownloadUrl() + "\n local path: " + getLocalSavePath() + "\n download from: " + getDownloadFrom();
        }
        return (String) invokeV.objValue;
    }
}
