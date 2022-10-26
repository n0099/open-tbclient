package com.baidu.minivideo.plugin.capture.bean;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class VideoDraftBean implements Jsonable, Comparable, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mBackUpType;
    public String mCoverPath;
    public String mDraftName;
    public String mEffectData;
    public String mFilterValue;
    public String mFollowData;
    public String mLocalAlbumData;
    public String mLocalAlbumThemeData;
    public String mLocation;
    public String mMainTitle;
    public String mMusicData;
    public float mOriginMusicVolume;
    public String mPreProcessVideoPath;
    public int mResumePage;
    public int mResumeRoute;
    public boolean mSelected;
    public String mSubTitle;
    public long mTimeStamp;
    public String mTopicData;
    public String mUserID;
    public String mVideoPath;
    public String mVideoTempData;
    public int mVisibility;

    public VideoDraftBean() {
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
        this.mOriginMusicVolume = 1.0f;
        this.mSelected = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public VideoDraftBean m36clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                return (VideoDraftBean) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (VideoDraftBean) invokeV.objValue;
    }

    public int getBackupType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mBackUpType;
        }
        return invokeV.intValue;
    }

    public String getCoverPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mCoverPath;
        }
        return (String) invokeV.objValue;
    }

    public String getDraftName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mDraftName;
        }
        return (String) invokeV.objValue;
    }

    public boolean getDraftSelectedStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mSelected;
        }
        return invokeV.booleanValue;
    }

    public String getEffectData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mEffectData;
        }
        return (String) invokeV.objValue;
    }

    public String getFilterValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mFilterValue;
        }
        return (String) invokeV.objValue;
    }

    public String getFollowData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mFollowData;
        }
        return (String) invokeV.objValue;
    }

    public String getLocalAlbumData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mLocalAlbumData;
        }
        return (String) invokeV.objValue;
    }

    public String getLocalAlbumThemeData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.mLocalAlbumThemeData;
        }
        return (String) invokeV.objValue;
    }

    public String getLocation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.mLocation;
        }
        return (String) invokeV.objValue;
    }

    public String getMainTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.mMainTitle;
        }
        return (String) invokeV.objValue;
    }

    public String getMusicData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.mMusicData;
        }
        return (String) invokeV.objValue;
    }

    public float getOriginMusicVolume() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.mOriginMusicVolume;
        }
        return invokeV.floatValue;
    }

    public String getPreProcessVideoPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.mPreProcessVideoPath;
        }
        return (String) invokeV.objValue;
    }

    public int getResumePage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.mResumePage;
        }
        return invokeV.intValue;
    }

    public int getResumeRoute() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.mResumeRoute;
        }
        return invokeV.intValue;
    }

    public String getSubTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.mSubTitle;
        }
        return (String) invokeV.objValue;
    }

    public long getTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.mTimeStamp;
        }
        return invokeV.longValue;
    }

    public String getTopicData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.mTopicData;
        }
        return (String) invokeV.objValue;
    }

    public String getUserID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.mUserID;
        }
        return (String) invokeV.objValue;
    }

    public String getVideoPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.mVideoPath;
        }
        return (String) invokeV.objValue;
    }

    public String getVideoTempData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.mVideoTempData;
        }
        return (String) invokeV.objValue;
    }

    public int getVisibility() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.mVisibility;
        }
        return invokeV.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.mDraftName.hashCode() + (this.mMusicData.hashCode() * 31) + (this.mVideoTempData.hashCode() * 31);
        }
        return invokeV.intValue;
    }

    public VideoDraftBean(String str, String str2, long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Long.valueOf(j), Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mOriginMusicVolume = 1.0f;
        this.mSelected = false;
        this.mDraftName = str;
        this.mUserID = str2;
        this.mTimeStamp = j;
        this.mResumeRoute = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(VideoDraftBean videoDraftBean) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, videoDraftBean)) == null) {
            if (videoDraftBean == null) {
                return -1;
            }
            long j = this.mTimeStamp;
            long j2 = videoDraftBean.mTimeStamp;
            if (j > j2) {
                return 1;
            }
            if (j < j2) {
                return -1;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public void setBackUpType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            this.mBackUpType = i;
        }
    }

    public void setCoverPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
            this.mCoverPath = str;
        }
    }

    public void setDraftName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            this.mDraftName = str;
        }
    }

    public void setDraftSelected(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.mSelected = z;
        }
    }

    public void setEffectData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            this.mEffectData = str;
        }
    }

    public void setFilterValue(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            this.mFilterValue = str;
        }
    }

    public void setFollowData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            this.mFollowData = str;
        }
    }

    public void setLocalAlbumData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
            this.mLocalAlbumData = str;
        }
    }

    public void setLocalAlbumThemeData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, str) == null) {
            this.mLocalAlbumThemeData = str;
        }
    }

    public void setLocation(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, str) == null) {
            this.mLocation = str;
        }
    }

    public void setMainTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
            this.mMainTitle = str;
        }
    }

    public void setMusicData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, str) == null) {
            this.mMusicData = str;
        }
    }

    public void setOriginMusicVolume(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048619, this, f) == null) {
            this.mOriginMusicVolume = f;
        }
    }

    public void setPreProcessVideoPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, str) == null) {
            this.mPreProcessVideoPath = str;
        }
    }

    public void setResumePage(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i) == null) {
            this.mResumePage = i;
        }
    }

    public void setResumeRoute(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i) == null) {
            this.mResumeRoute = i;
        }
    }

    public void setSubTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, str) == null) {
            this.mSubTitle = str;
        }
    }

    public void setTimeStamp(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048624, this, j) == null) {
            this.mTimeStamp = j;
        }
    }

    public void setTopicData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, str) == null) {
            this.mTopicData = str;
        }
    }

    public void setUserID(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, str) == null) {
            this.mUserID = str;
        }
    }

    public void setVideoPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, str) == null) {
            this.mVideoPath = str;
        }
    }

    public void setVideoTempData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, str) == null) {
            this.mVideoTempData = str;
        }
    }

    public void setVisibility(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048629, this, i) == null) {
            this.mVisibility = i;
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (obj != null && VideoDraftBean.class == obj.getClass()) {
                VideoDraftBean videoDraftBean = (VideoDraftBean) obj;
                if (this.mDraftName.equals(videoDraftBean.getDraftName()) && ((this.mVideoTempData != null && videoDraftBean.getVideoTempData() != null && this.mVideoTempData.equals(videoDraftBean.getVideoTempData())) || this.mResumeRoute == 1)) {
                    if (this.mMusicData != null && videoDraftBean.getMusicData() != null) {
                        int indexOf = this.mMusicData.indexOf("sk");
                        return this.mMusicData.substring(indexOf).equals(videoDraftBean.getMusicData().substring(indexOf));
                    } else if (this.mMusicData == null && videoDraftBean.getMusicData() == null) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean equalsMusic(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (obj != null && VideoDraftBean.class == obj.getClass()) {
                VideoDraftBean videoDraftBean = (VideoDraftBean) obj;
                if (this.mDraftName.equals(videoDraftBean.getDraftName())) {
                    if (this.mMusicData != null && videoDraftBean.getMusicData() != null) {
                        int indexOf = this.mMusicData.indexOf("sk");
                        if (indexOf == -1 || indexOf >= videoDraftBean.getMusicData().length()) {
                            return false;
                        }
                        String substring = this.mMusicData.substring(indexOf);
                        if (indexOf >= videoDraftBean.getMusicData().length()) {
                            return false;
                        }
                        return substring.equals(videoDraftBean.getMusicData().substring(indexOf));
                    } else if (this.mMusicData == null && videoDraftBean.getMusicData() == null) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.minivideo.plugin.capture.bean.Jsonable
    public boolean parse(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.mDraftName = jSONObject.optString("mDraftName");
                this.mUserID = jSONObject.optString("mUserID");
                this.mVideoTempData = jSONObject.optString("mVideoTempData");
                this.mVideoPath = jSONObject.optString("mVideoPath");
                this.mMusicData = jSONObject.optString("mMusicData");
                this.mMainTitle = jSONObject.optString("mMainTitle");
                this.mSubTitle = jSONObject.optString("mSubTitle");
                this.mTopicData = jSONObject.optString("mTopicData");
                this.mVisibility = jSONObject.optInt("mVisibility");
                this.mResumeRoute = jSONObject.optInt("mResumeRoute");
                this.mTimeStamp = jSONObject.optLong("mTimeStamp");
                this.mResumePage = jSONObject.optInt("mResumePage");
                this.mBackUpType = jSONObject.optInt("mBackUpType");
                this.mEffectData = jSONObject.optString("mEffectData");
                this.mCoverPath = jSONObject.optString("mCoverPath");
                this.mLocation = jSONObject.optString("mLocation");
                this.mPreProcessVideoPath = jSONObject.optString("mPreProcessVideoPath");
                this.mFollowData = jSONObject.optString("mFollowData");
                this.mOriginMusicVolume = (float) jSONObject.optDouble("mOriginMusicVolume");
                return true;
            } catch (JSONException unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.minivideo.plugin.capture.bean.Jsonable
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("mDraftName", this.mDraftName);
                jSONObject.put("mUserID", this.mUserID);
                jSONObject.put("mVideoTempData", this.mVideoTempData);
                jSONObject.put("mVideoPath", this.mVideoPath);
                jSONObject.put("mMusicData", this.mMusicData);
                jSONObject.put("mMainTitle", this.mMainTitle);
                jSONObject.put("mSubTitle", this.mSubTitle);
                jSONObject.put("mTopicData", this.mTopicData);
                jSONObject.put("mVisibility", this.mVisibility);
                jSONObject.put("mResumeRoute", this.mResumeRoute);
                jSONObject.put("mTimeStamp", this.mTimeStamp);
                jSONObject.put("mResumePage", this.mResumePage);
                jSONObject.put("mBackUpType", this.mBackUpType);
                jSONObject.put("mEffectData", this.mEffectData);
                jSONObject.put("mCoverPath", this.mCoverPath);
                jSONObject.put("mLocation", this.mLocation);
                jSONObject.put("mPreProcessVideoPath", this.mPreProcessVideoPath);
                jSONObject.put("mFollowData", this.mFollowData);
                jSONObject.put("mOriginMusicVolume", this.mOriginMusicVolume);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
