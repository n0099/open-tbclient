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
/* loaded from: classes6.dex */
public final class ChatUser implements Parcelable, NoProGuard, PinYinUtils.PinYinObject {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<ChatUser> CREATOR;
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
        CREATOR = new Parcelable.Creator<ChatUser>() { // from class: com.baidu.android.imsdk.chatuser.ChatUser.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ChatUser createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new ChatUser(parcel) : (ChatUser) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ChatUser[] newArray(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? new ChatUser[i2] : (ChatUser[]) invokeI.objValue;
            }
        };
    }

    public ChatUser(long j, long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Long.valueOf(j2), str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public int getAccountType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mAccountType : invokeV.intValue;
    }

    public int getBlack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mAttrBlack : invokeV.intValue;
    }

    public long getBuid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mBuid : invokeV.longValue;
    }

    public int getDisturb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mAttrDisturb : invokeV.intValue;
    }

    public int getGroupStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mGroupStatus : invokeV.intValue;
    }

    public int getHasSpecialIdentity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mHasSpecialIdentity : invokeV.intValue;
    }

    public String getIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mIconUrl : (String) invokeV.objValue;
    }

    public String getIdentity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mIdentity : (String) invokeV.objValue;
    }

    public IpInfo getIpInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mIpInfo : (IpInfo) invokeV.objValue;
    }

    @Deprecated
    public int getIsIpLocationExist() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mIsIpLocatonExist : invokeV.intValue;
    }

    public long getLastUpdate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mLastUpdate : invokeV.longValue;
    }

    public int getMarkTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mMarkTop : invokeV.intValue;
    }

    public long getMarkTopTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mMarkTopTime : invokeV.longValue;
    }

    public long getPhone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mPhone : invokeV.longValue;
    }

    public int getPhoneRelation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mPhoneRelation : invokeV.intValue;
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

    public String getSchema() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (TextUtils.isEmpty(this.mSchema) && !TextUtils.isEmpty(this.mUserExt)) {
                try {
                    this.mSchema = new JSONObject(this.mUserExt).optString("homepage", "");
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return this.mSchema;
        }
        return (String) invokeV.objValue;
    }

    public int getSex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mSex : invokeV.intValue;
    }

    public int getShield() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mShield : invokeV.intValue;
    }

    public long getShieldTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mShieldTime : invokeV.longValue;
    }

    public String getSpecialIdentity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mSpecialIdentity : (String) invokeV.objValue;
    }

    public int getSubscribe() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.mSubscribe : invokeV.intValue;
    }

    public String getTinyUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.mTinyUrl : (String) invokeV.objValue;
    }

    public long getUk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.mUk : invokeV.longValue;
    }

    public ChatUser getUser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this : (ChatUser) invokeV.objValue;
    }

    public String getUserDetail() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.mUserDetail : (String) invokeV.objValue;
    }

    public String getUserExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.mUserExt : (String) invokeV.objValue;
    }

    @Deprecated
    public long getUserId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.mUk : invokeV.longValue;
    }

    public String getUserName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.mUserName : (String) invokeV.objValue;
    }

    public String getVPortrait() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.vPortrait : (String) invokeV.objValue;
    }

    public String getVipId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.mVipId : (String) invokeV.objValue;
    }

    public boolean isAnonymousUser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.mAccountType == 0 : invokeV.booleanValue;
    }

    public boolean isIpLocationExist() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.mIsIpLocatonExist == 0 : invokeV.booleanValue;
    }

    public void setAccountType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            this.mAccountType = i2;
        }
    }

    public void setBlack(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
            this.mAttrBlack = i2;
        }
    }

    public void setDisturb(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i2) == null) {
            this.mAttrDisturb = i2;
        }
    }

    public void setGroupStatus(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i2) == null) {
            this.mGroupStatus = i2;
        }
    }

    public void setHasSpecialIdentity(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
            this.mHasSpecialIdentity = i2;
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

    public void setIsIpLocationExist(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i2) == null) {
            this.mIsIpLocatonExist = i2;
        }
    }

    public void setLastUpdate(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048619, this, j) == null) {
            this.mLastUpdate = j;
        }
    }

    public void setMarkTop(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i2) == null) {
            this.mMarkTop = i2;
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

    public void setPhoneRelation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i2) == null) {
            this.mPhoneRelation = i2;
        }
    }

    public void setSchema(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, str) == null) {
            this.mSchema = str;
        }
    }

    public void setSex(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i2) == null) {
            this.mSex = i2;
        }
    }

    public void setShield(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048626, this, i2) == null) {
            this.mShield = i2;
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

    public void setSubscribe(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048629, this, i2) == null) {
            this.mSubscribe = i2;
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
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                setSchema(new JSONObject(str).optString("homepage", ""));
            } catch (Exception e2) {
                e2.printStackTrace();
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
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048637, this, parcel, i2) == null) {
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
            parcel.writeParcelable(this.mIpInfo, i2);
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

    public ChatUser(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
}
