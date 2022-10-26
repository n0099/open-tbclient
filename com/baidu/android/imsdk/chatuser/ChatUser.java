package com.baidu.android.imsdk.chatuser;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.NoProGuard;
import com.baidu.android.imsdk.utils.PinYinUtils;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class ChatUser implements Parcelable, NoProGuard, PinYinUtils.PinYinObject {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public int mAccountType;
    public int mAttrBlack;
    public int mAttrDisturb;
    public long mBuid;
    public int mGroupStatus;
    public int mHasSpecialIdentity;
    public String mIconUrl;
    public String mIdentity;
    public IpInfo mIpInfo;
    public int mIsIpLocatonExist;
    public long mLastUpdate;
    public int mMarkTop;
    public long mMarkTopTime;
    public long mPhone;
    public int mPhoneRelation;
    public String mSchema;
    public int mSex;
    public int mShield;
    public long mShieldTime;
    public String mSpecialIdentity;
    public int mSubscribe;
    public String mTinyUrl;
    public long mUk;
    public String mUserDetail;
    public String mUserExt;
    public String mUserName;
    public String mUserNamePy;
    public String mVipId;
    public String vPortrait;

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public ChatUser getUser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this : (ChatUser) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-409915885, "Lcom/baidu/android/imsdk/chatuser/ChatUser;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-409915885, "Lcom/baidu/android/imsdk/chatuser/ChatUser;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator() { // from class: com.baidu.android.imsdk.chatuser.ChatUser.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            public ChatUser createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                    return new ChatUser(parcel);
                }
                return (ChatUser) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            public ChatUser[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                    return new ChatUser[i];
                }
                return (ChatUser[]) invokeI.objValue;
            }
        };
    }

    public int getAccountType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mAccountType;
        }
        return invokeV.intValue;
    }

    public int getBlack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mAttrBlack;
        }
        return invokeV.intValue;
    }

    public long getBuid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mBuid;
        }
        return invokeV.longValue;
    }

    public int getDisturb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mAttrDisturb;
        }
        return invokeV.intValue;
    }

    public int getGroupStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mGroupStatus;
        }
        return invokeV.intValue;
    }

    public int getHasSpecialIdentity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mHasSpecialIdentity;
        }
        return invokeV.intValue;
    }

    public String getIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mIconUrl;
        }
        return (String) invokeV.objValue;
    }

    public String getIdentity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mIdentity;
        }
        return (String) invokeV.objValue;
    }

    public IpInfo getIpInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mIpInfo;
        }
        return (IpInfo) invokeV.objValue;
    }

    @Deprecated
    public int getIsIpLocationExist() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mIsIpLocatonExist;
        }
        return invokeV.intValue;
    }

    public long getLastUpdate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mLastUpdate;
        }
        return invokeV.longValue;
    }

    public int getMarkTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mMarkTop;
        }
        return invokeV.intValue;
    }

    public long getMarkTopTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mMarkTopTime;
        }
        return invokeV.longValue;
    }

    public long getPhone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.mPhone;
        }
        return invokeV.longValue;
    }

    public int getPhoneRelation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.mPhoneRelation;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.android.imsdk.utils.PinYinUtils.PinYinObject
    public String getPy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (TextUtils.isEmpty(this.mUserNamePy)) {
                this.mUserNamePy = PinYinUtils.getPy(this.mUserNamePy);
            }
            return this.mUserNamePy;
        }
        return (String) invokeV.objValue;
    }

    public int getSex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.mSex;
        }
        return invokeV.intValue;
    }

    public int getShield() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.mShield;
        }
        return invokeV.intValue;
    }

    public long getShieldTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.mShieldTime;
        }
        return invokeV.longValue;
    }

    public String getSpecialIdentity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.mSpecialIdentity;
        }
        return (String) invokeV.objValue;
    }

    public int getSubscribe() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.mSubscribe;
        }
        return invokeV.intValue;
    }

    public String getTinyUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.mTinyUrl;
        }
        return (String) invokeV.objValue;
    }

    public long getUk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.mUk;
        }
        return invokeV.longValue;
    }

    public String getUserDetail() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.mUserDetail;
        }
        return (String) invokeV.objValue;
    }

    public String getUserExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.mUserExt;
        }
        return (String) invokeV.objValue;
    }

    @Deprecated
    public long getUserId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.mUk;
        }
        return invokeV.longValue;
    }

    public String getUserName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.mUserName;
        }
        return (String) invokeV.objValue;
    }

    public String getVPortrait() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.vPortrait;
        }
        return (String) invokeV.objValue;
    }

    public String getVipId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.mVipId;
        }
        return (String) invokeV.objValue;
    }

    public boolean isAnonymousUser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            if (this.mAccountType == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isIpLocationExist() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            if (this.mIsIpLocatonExist == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public ChatUser(long j, long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Long.valueOf(j2), str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mUserName = "";
        this.mIconUrl = "";
        this.mSex = 0;
        this.mTinyUrl = "";
        this.mPhone = 0L;
        this.mUserDetail = "";
        this.mUserNamePy = "";
        this.mAccountType = -1;
        this.mIsIpLocatonExist = 1;
        this.vPortrait = "";
        this.mVipId = "";
        this.mIdentity = "";
        this.mLastUpdate = 0L;
        this.mShield = 0;
        this.mShieldTime = 0L;
        this.mMarkTop = 0;
        this.mMarkTopTime = 0L;
        this.mSubscribe = 0;
        this.mPhoneRelation = 0;
        this.mHasSpecialIdentity = 0;
        this.mSpecialIdentity = "";
        this.mUserExt = "";
        this.mGroupStatus = 1;
        this.mUk = j;
        this.mBuid = j2;
        this.mUserName = str;
        this.mIconUrl = str2;
    }

    public ChatUser(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mUserName = "";
        this.mIconUrl = "";
        this.mSex = 0;
        this.mTinyUrl = "";
        this.mPhone = 0L;
        this.mUserDetail = "";
        this.mUserNamePy = "";
        this.mAccountType = -1;
        this.mIsIpLocatonExist = 1;
        this.vPortrait = "";
        this.mVipId = "";
        this.mIdentity = "";
        this.mLastUpdate = 0L;
        this.mShield = 0;
        this.mShieldTime = 0L;
        this.mMarkTop = 0;
        this.mMarkTopTime = 0L;
        this.mSubscribe = 0;
        this.mPhoneRelation = 0;
        this.mHasSpecialIdentity = 0;
        this.mSpecialIdentity = "";
        this.mUserExt = "";
        this.mGroupStatus = 1;
        this.mUk = parcel.readLong();
        this.mBuid = parcel.readLong();
        this.mUserName = parcel.readString();
        this.mIconUrl = parcel.readString();
        this.mSex = parcel.readInt();
        this.mTinyUrl = parcel.readString();
        this.mPhone = parcel.readLong();
        this.mUserDetail = parcel.readString();
        this.mUserNamePy = parcel.readString();
        this.mAccountType = parcel.readInt();
        this.mIsIpLocatonExist = parcel.readInt();
        this.mIpInfo = (IpInfo) parcel.readParcelable(IpInfo.class.getClassLoader());
        this.mVipId = parcel.readString();
        this.vPortrait = parcel.readString();
        this.mIdentity = parcel.readString();
        this.mLastUpdate = parcel.readLong();
        this.mShield = parcel.readInt();
        this.mShieldTime = parcel.readLong();
        this.mMarkTop = parcel.readInt();
        this.mMarkTopTime = parcel.readLong();
        this.mSubscribe = parcel.readInt();
        this.mPhoneRelation = parcel.readInt();
        this.mHasSpecialIdentity = parcel.readInt();
        this.mSpecialIdentity = parcel.readString();
        this.mUserExt = parcel.readString();
        this.mSchema = parcel.readString();
        this.mGroupStatus = parcel.readInt();
    }

    public String getSchema() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (TextUtils.isEmpty(this.mSchema) && !TextUtils.isEmpty(this.mUserExt)) {
                try {
                    this.mSchema = new JSONObject(this.mUserExt).optString("homepage", "");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return this.mSchema;
        }
        return (String) invokeV.objValue;
    }

    public void setAccountType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i) == null) {
            this.mAccountType = i;
        }
    }

    public void setBlack(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i) == null) {
            this.mAttrBlack = i;
        }
    }

    public void setDisturb(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i) == null) {
            this.mAttrDisturb = i;
        }
    }

    public void setGroupStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i) == null) {
            this.mGroupStatus = i;
        }
    }

    public void setHasSpecialIdentity(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i) == null) {
            this.mHasSpecialIdentity = i;
        }
    }

    public void setIconUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, str) == null) {
            this.mIconUrl = str;
        }
    }

    public void setIdentity(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, str) == null) {
            this.mIdentity = str;
        }
    }

    public void setIpInfo(IpInfo ipInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, ipInfo) == null) {
            this.mIpInfo = ipInfo;
        }
    }

    public void setIsIpLocationExist(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i) == null) {
            this.mIsIpLocatonExist = i;
        }
    }

    public void setLastUpdate(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048619, this, j) == null) {
            this.mLastUpdate = j;
        }
    }

    public void setMarkTop(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i) == null) {
            this.mMarkTop = i;
        }
    }

    public void setMarkTopTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048621, this, j) == null) {
            this.mMarkTopTime = j;
        }
    }

    public void setPhone(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048622, this, j) == null) {
            this.mPhone = j;
        }
    }

    public void setPhoneRelation(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i) == null) {
            this.mPhoneRelation = i;
        }
    }

    public void setSchema(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, str) == null) {
            this.mSchema = str;
        }
    }

    public void setSex(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i) == null) {
            this.mSex = i;
        }
    }

    public void setShield(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048626, this, i) == null) {
            this.mShield = i;
        }
    }

    public void setShieldTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048627, this, j) == null) {
            this.mShieldTime = j;
        }
    }

    public void setSpecialIdentity(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, str) == null) {
            this.mSpecialIdentity = str;
        }
    }

    public void setSubscribe(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048629, this, i) == null) {
            this.mSubscribe = i;
        }
    }

    public void setTinyUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, str) == null) {
            this.mTinyUrl = str;
        }
    }

    public void setUserDetail(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, str) == null) {
            this.mUserDetail = str;
        }
    }

    public void setUserExt(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, str) == null) {
            this.mUserExt = str;
            if (!TextUtils.isEmpty(str)) {
                try {
                    setSchema(new JSONObject(str).optString("homepage", ""));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Deprecated
    public void setUserNamePy(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, str) == null) {
            this.mUserNamePy = str;
        }
    }

    public void setVPortrait(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, str) == null) {
            this.vPortrait = str;
        }
    }

    public void setVipId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, str) == null) {
            this.mVipId = str;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            return "ChatUser [mUk=" + this.mUk + ", mBuid=" + this.mBuid + ", mUserName=" + this.mUserName + ", mIconUrl=" + this.mIconUrl + ", mSex=" + this.mSex + ", mTinyUrl=" + this.mTinyUrl + ", mPhone=" + this.mPhone + ", mUserDetail=" + this.mUserDetail + ", mUserNamePy=" + this.mUserNamePy + ", mAccountType=" + this.mAccountType + ", mIsIpLocatonExist=" + this.mIsIpLocatonExist + ", mIpInfo=" + this.mIpInfo + ", mAttrDisturb=" + this.mAttrDisturb + ", mAttrBlack=" + this.mAttrBlack + ", vPortrait=" + this.vPortrait + ", mIdentity=" + this.mIdentity + ", mLastUpdate=" + this.mLastUpdate + ", mShield=" + this.mShield + ", mShieldTime=" + this.mShieldTime + ", mVipId=" + this.mVipId + ", mMarkTop=" + this.mMarkTop + ", mMarkTopTime=" + this.mMarkTopTime + ", mSubscribe=" + this.mSubscribe + "mPhoneRelation=" + this.mPhoneRelation + ", mHasSpecialIdentity= " + this.mHasSpecialIdentity + ", mUserExt=" + this.mUserExt + ", mSchema=" + this.mSchema + ", mSpecialIdentity= " + this.mSpecialIdentity + ", mGroupStatus=" + this.mGroupStatus + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048637, this, parcel, i) == null) {
            parcel.writeLong(this.mUk);
            parcel.writeLong(this.mBuid);
            parcel.writeString(this.mUserName);
            parcel.writeString(this.mIconUrl);
            parcel.writeInt(this.mSex);
            parcel.writeString(this.mTinyUrl);
            parcel.writeLong(this.mPhone);
            parcel.writeString(this.mUserDetail);
            parcel.writeString(this.mUserNamePy);
            parcel.writeInt(this.mAccountType);
            parcel.writeInt(this.mIsIpLocatonExist);
            parcel.writeParcelable(this.mIpInfo, i);
            parcel.writeString(this.mVipId);
            parcel.writeString(this.vPortrait);
            parcel.writeString(this.mIdentity);
            parcel.writeLong(this.mLastUpdate);
            parcel.writeInt(this.mShield);
            parcel.writeLong(this.mShieldTime);
            parcel.writeInt(this.mMarkTop);
            parcel.writeLong(this.mMarkTopTime);
            parcel.writeInt(this.mSubscribe);
            parcel.writeInt(this.mPhoneRelation);
            parcel.writeInt(this.mHasSpecialIdentity);
            parcel.writeString(this.mSpecialIdentity);
            parcel.writeString(this.mUserExt);
            parcel.writeString(this.mSchema);
            parcel.writeInt(this.mGroupStatus);
        }
    }
}
