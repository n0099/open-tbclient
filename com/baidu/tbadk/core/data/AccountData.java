package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.UserVipInfoData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes3.dex */
public class AccountData implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 4126203103788833116L;
    public transient /* synthetic */ FieldHolder $fh;
    public String BDUSS;
    public String bjhAvatar;
    public String growthSwitch;
    public boolean isBigV;
    public int liveLevel;
    public String mAccount;
    public String mDisplayName;
    public int mGodType;
    public String mID;
    public int mIsActive;
    public boolean mIsSelectTail;
    public int mMemberCloseAdIsOpen;
    public int mMemberCloseAdVipClose;
    public String mMemberIconUrl;
    public int mMemberType;
    public int mNewGodStatus;
    public String mPassword;
    public long mPersonalGid;
    public int mSex;
    public String mStoken;
    public String mTbs;
    public long mTime;
    public List<IconData> mUserIcons;
    public UserVipInfoData mVipInfo;
    public String nameShow;
    public String personalBgUrl;
    public String portrait;
    public String uk;

    public AccountData() {
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
        this.mID = null;
        this.mAccount = null;
        this.mPassword = null;
        this.BDUSS = null;
        this.mTbs = null;
        this.mStoken = null;
        this.mIsActive = 0;
        this.mTime = 0L;
        this.mPersonalGid = 0L;
    }

    public String getAccount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mAccount : (String) invokeV.objValue;
    }

    public String getAccountNameShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (!TextUtils.isEmpty(this.nameShow)) {
                return this.nameShow;
            }
            if (!TextUtils.isEmpty(this.mDisplayName)) {
                return this.mDisplayName;
            }
            if (!TextUtils.isEmpty(this.mAccount)) {
                return this.mAccount;
            }
            return TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f006c);
        }
        return (String) invokeV.objValue;
    }

    public String getAvatar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!TextUtils.isEmpty(this.bjhAvatar)) {
                return this.bjhAvatar;
            }
            return this.portrait;
        }
        return (String) invokeV.objValue;
    }

    public String getBDUSS() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.BDUSS : (String) invokeV.objValue;
    }

    public String getDisplayName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mDisplayName : (String) invokeV.objValue;
    }

    public int getGodType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mGodType : invokeV.intValue;
    }

    public String getGrowthSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.growthSwitch : (String) invokeV.objValue;
    }

    public String getID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mID : (String) invokeV.objValue;
    }

    public int getIsActive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mIsActive : invokeV.intValue;
    }

    public boolean getIsSelectTail() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mIsSelectTail : invokeV.booleanValue;
    }

    public int getLiveLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.liveLevel : invokeV.intValue;
    }

    public int getMemberCloseAdIsOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mMemberCloseAdIsOpen : invokeV.intValue;
    }

    public int getMemberCloseAdVipClose() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mMemberCloseAdVipClose : invokeV.intValue;
    }

    public String getMemberIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mMemberIconUrl : (String) invokeV.objValue;
    }

    public int getMemberType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mMemberType : invokeV.intValue;
    }

    public int getNewGodStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mNewGodStatus : invokeV.intValue;
    }

    public String getPassword() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mPassword : (String) invokeV.objValue;
    }

    public String getPersonalBgUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.personalBgUrl : (String) invokeV.objValue;
    }

    public long getPersonalGid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mPersonalGid : invokeV.longValue;
    }

    public String getPortrait() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.portrait : (String) invokeV.objValue;
    }

    public int getSex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mSex : invokeV.intValue;
    }

    public String getStoken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mStoken : (String) invokeV.objValue;
    }

    public String getTbs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.mTbs : (String) invokeV.objValue;
    }

    public long getTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.mTime : invokeV.longValue;
    }

    public String getUk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.uk : (String) invokeV.objValue;
    }

    public List<IconData> getUserIcons() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.mUserIcons : (List) invokeV.objValue;
    }

    public UserVipInfoData getVipInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.mVipInfo : (UserVipInfoData) invokeV.objValue;
    }

    public boolean isBigV() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.isBigV : invokeV.booleanValue;
    }

    public boolean isMemberCloseAdIsOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.mMemberCloseAdIsOpen == 1 : invokeV.booleanValue;
    }

    public void setAccount(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.mAccount = str;
        }
    }

    public void setBDUSS(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            this.BDUSS = str;
        }
    }

    public void setBjhAvatar(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            this.bjhAvatar = str;
        }
    }

    public void setDisplayName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
            this.mDisplayName = str;
        }
    }

    public void setGodType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i) == null) {
            this.mGodType = i;
        }
    }

    public void setGrowthSwitch(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
            this.growthSwitch = str;
        }
    }

    public void setID(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            this.mID = str;
        }
    }

    public void setIsActive(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i) == null) {
            this.mIsActive = i;
        }
    }

    public void setIsBigV(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.isBigV = z;
        }
    }

    public void setIsSelectTail(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.mIsSelectTail = z;
        }
    }

    public void setLiveLevel(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i) == null) {
            this.liveLevel = i;
        }
    }

    public void setMemberCloseAdIsOpen(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i) == null) {
            this.mMemberCloseAdIsOpen = i;
        }
    }

    public void setMemberCloseAdVipClose(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i) == null) {
            this.mMemberCloseAdVipClose = i;
        }
    }

    public void setMemberIconUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, str) == null) {
            this.mMemberIconUrl = str;
        }
    }

    public void setMemberType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i) == null) {
            this.mMemberType = i;
        }
    }

    public void setNameShow(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, str) == null) {
            this.nameShow = str;
        }
    }

    public void setNewGodStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i) == null) {
            this.mNewGodStatus = i;
        }
    }

    public void setPassword(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            this.mPassword = str;
        }
    }

    public void setPersonalBgUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, str) == null) {
            this.personalBgUrl = str;
        }
    }

    public void setPersonalGid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048624, this, j) == null) {
            this.mPersonalGid = j;
        }
    }

    public void setPortrait(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, str) == null) {
            this.portrait = str;
        }
    }

    public void setSex(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048626, this, i) == null) {
            this.mSex = i;
        }
    }

    public void setStoken(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, str) == null) {
            this.mStoken = str;
        }
    }

    public void setTbs(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, str) == null) {
            this.mTbs = str;
        }
    }

    public void setTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048629, this, j) == null) {
            this.mTime = j;
        }
    }

    public void setUk(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, str) == null) {
            this.uk = str;
        }
    }

    public void setUserIcons(List<IconData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, list) == null) {
            this.mUserIcons = list;
        }
    }

    public void setVipInfo(UserVipInfoData userVipInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, userVipInfoData) == null) {
            this.mVipInfo = userVipInfoData;
        }
    }
}
