package com.baidu.android.imsdk.group;

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
/* loaded from: classes.dex */
public class GroupInfo implements Parcelable, NoProGuard, PinYinUtils.PinYinObject {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<GroupInfo> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public int brief;
    public int mActiveState;
    public long mBduid;
    public long mCreateTime;
    public String mDescription;
    public int mDisturb;
    public int mGroupCapacity;
    public String mGroupId;
    public String mGroupName;
    public String mGroupNotice;
    public int mGroupVerify;
    public String mHeadUrl;
    public long mInfoVersion;
    public long mLocalInfoVersion;
    public long mLocalMembersVersion;
    public int mMarkTop;
    public long mMarkTopTime;
    public long mMembersVersion;
    public int mNum;
    public String mPinYin;
    public int mType;
    public long mUk;
    public int state;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(734867013, "Lcom/baidu/android/imsdk/group/GroupInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(734867013, "Lcom/baidu/android/imsdk/group/GroupInfo;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<GroupInfo>() { // from class: com.baidu.android.imsdk.group.GroupInfo.1
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
            public GroupInfo createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new GroupInfo(parcel) : (GroupInfo) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public GroupInfo[] newArray(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? new GroupInfo[i2] : (GroupInfo[]) invokeI.objValue;
            }
        };
    }

    public GroupInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mGroupName = "";
        this.mDescription = "";
        this.mType = 0;
        this.mGroupId = str;
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

    public int getActiveState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mActiveState : invokeV.intValue;
    }

    public int getBrief() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.brief : invokeV.intValue;
    }

    public long getBuid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mBduid : invokeV.longValue;
    }

    public long getCreateTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mCreateTime : invokeV.longValue;
    }

    public String getDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mDescription : (String) invokeV.objValue;
    }

    public int getDisturb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mDisturb : invokeV.intValue;
    }

    public int getGroupCapacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mGroupCapacity : invokeV.intValue;
    }

    public String getGroupId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mGroupId : (String) invokeV.objValue;
    }

    public String getGroupName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mGroupName : (String) invokeV.objValue;
    }

    public String getGroupNotice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mGroupNotice : (String) invokeV.objValue;
    }

    public int getGroupVerify() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mGroupVerify : invokeV.intValue;
    }

    public String getHeadUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mHeadUrl : (String) invokeV.objValue;
    }

    public long getInfoVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mInfoVersion : invokeV.longValue;
    }

    public long getLocalInfoVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mLocalInfoVersion : invokeV.longValue;
    }

    public long getLocalMembersVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mLocalMembersVersion : invokeV.longValue;
    }

    public int getMarkTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mMarkTop : invokeV.intValue;
    }

    public long getMarkTopTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mMarkTopTime : invokeV.longValue;
    }

    public long getMembersVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mMembersVersion : invokeV.longValue;
    }

    public int getNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mNum : invokeV.intValue;
    }

    @Override // com.baidu.android.imsdk.utils.PinYinUtils.PinYinObject
    public String getPy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (TextUtils.isEmpty(this.mPinYin)) {
                this.mPinYin = PinYinUtils.getPy(this.mGroupName);
            }
            return this.mPinYin;
        }
        return (String) invokeV.objValue;
    }

    public int getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.state : invokeV.intValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.mType : invokeV.intValue;
    }

    public long getUk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.mUk : invokeV.longValue;
    }

    public void setActiveState(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.mActiveState = i2;
        }
    }

    public void setBrief(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            this.brief = i2;
        }
    }

    public void setBuid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048602, this, j) == null) {
            this.mBduid = j;
        }
    }

    public void setCreateTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048603, this, j) == null) {
            this.mCreateTime = j;
        }
    }

    public void setDescription(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            this.mDescription = str;
        }
    }

    public void setDisturb(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            this.mDisturb = i2;
        }
    }

    public void setGroupCapacity(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            this.mGroupCapacity = i2;
        }
    }

    public void setGroupName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            this.mGroupName = str;
        }
    }

    public void setGroupNotice(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
            this.mGroupNotice = str;
        }
    }

    public void setGroupVerify(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i2) == null) {
            this.mGroupVerify = i2;
        }
    }

    public void setHeadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
            this.mHeadUrl = str;
        }
    }

    public void setInfoVersion(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048611, this, j) == null) {
            this.mInfoVersion = j;
        }
    }

    public void setLocalInfoVersion(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048612, this, j) == null) {
            this.mLocalInfoVersion = j;
        }
    }

    public void setLocalMembersVersion(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048613, this, j) == null) {
            this.mLocalMembersVersion = j;
        }
    }

    public void setMarkTop(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
            this.mMarkTop = i2;
        }
    }

    public void setMarkTopTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048615, this, j) == null) {
            this.mMarkTopTime = j;
        }
    }

    public void setMembersVersion(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048616, this, j) == null) {
            this.mMembersVersion = j;
        }
    }

    public void setNum(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i2) == null) {
            this.mNum = i2;
        }
    }

    public void setState(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i2) == null) {
            this.state = i2;
        }
    }

    public void setType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i2) == null) {
            this.mType = i2;
        }
    }

    public void setUk(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048620, this, j) == null) {
            this.mUk = j;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return "GroupInfo [mGroupId=" + this.mGroupId + ", mGroupName=" + this.mGroupName + ", mDescription=" + this.mDescription + ", mType=" + this.mType + ", mPinYin=" + this.mPinYin + ", mCreateTime=" + this.mCreateTime + ", mBduid=" + this.mBduid + ", mUk=" + this.mUk + ", mNum=" + this.mNum + ", mMembersVersion=" + this.mMembersVersion + ", mDisturb=" + this.mDisturb + ", state=" + this.state + ", activeState=" + this.mActiveState + " marktop = " + this.mMarkTop + " martTime = " + this.mMarkTopTime + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048622, this, parcel, i2) == null) {
            parcel.writeString(this.mGroupId);
            parcel.writeString(this.mGroupName);
            parcel.writeString(this.mDescription);
            parcel.writeInt(this.mDisturb);
            parcel.writeInt(this.state);
            parcel.writeInt(this.mType);
            parcel.writeInt(this.mNum);
            parcel.writeLong(this.mCreateTime);
            parcel.writeLong(this.mBduid);
            parcel.writeLong(this.mUk);
            parcel.writeInt(this.mActiveState);
            parcel.writeLong(this.mMembersVersion);
            parcel.writeInt(this.brief);
            parcel.writeInt(this.mMarkTop);
            parcel.writeLong(this.mMarkTopTime);
            parcel.writeString(this.mGroupNotice);
            parcel.writeInt(this.mGroupCapacity);
            parcel.writeInt(this.mGroupVerify);
            parcel.writeLong(this.mLocalMembersVersion);
            parcel.writeLong(this.mLocalInfoVersion);
            parcel.writeLong(this.mInfoVersion);
        }
    }

    public GroupInfo(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mGroupName = "";
        this.mDescription = "";
        this.mType = 0;
        this.mGroupId = parcel.readString();
        this.mGroupName = parcel.readString();
        this.mDescription = parcel.readString();
        this.mDisturb = parcel.readInt();
        this.state = parcel.readInt();
        this.mType = parcel.readInt();
        this.mNum = parcel.readInt();
        this.mCreateTime = parcel.readLong();
        this.mBduid = parcel.readLong();
        this.mUk = parcel.readLong();
        this.mActiveState = parcel.readInt();
        this.mMembersVersion = parcel.readLong();
        this.brief = parcel.readInt();
        this.mMarkTop = parcel.readInt();
        this.mMarkTopTime = parcel.readLong();
        this.mGroupNotice = parcel.readString();
        this.mGroupCapacity = parcel.readInt();
        this.mGroupVerify = parcel.readInt();
        this.mLocalMembersVersion = parcel.readLong();
        this.mLocalInfoVersion = parcel.readLong();
        this.mInfoVersion = parcel.readLong();
    }
}
