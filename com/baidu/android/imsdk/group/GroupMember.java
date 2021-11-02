package com.baidu.android.imsdk.group;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.NoProGuard;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class GroupMember implements Parcelable, NoProGuard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ADDSTATUSFAIL = 1;
    public static final int ADDSTATUSORIG = 2;
    public static final int ADDSTATUSSUC = 0;
    public static final Parcelable.Creator<GroupMember> CREATOR;
    public static final int ROLECOMMON = 0;
    public static final int ROLEMANAGER = 2;
    public static final int ROLEMASTER = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public int addStatus;
    public String groupid;
    public long jointime;
    public long mBduid;
    public String mName;
    public String mNickName;
    public String mPortrait;
    public long mUk;
    public int role;
    public int valid;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(836069337, "Lcom/baidu/android/imsdk/group/GroupMember;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(836069337, "Lcom/baidu/android/imsdk/group/GroupMember;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<GroupMember>() { // from class: com.baidu.android.imsdk.group.GroupMember.1
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
            public GroupMember createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new GroupMember(parcel) : (GroupMember) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public GroupMember[] newArray(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? new GroupMember[i2] : (GroupMember[]) invokeI.objValue;
            }
        };
    }

    public GroupMember(long j, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mUk = -1L;
        this.mName = "";
        this.role = 0;
        this.jointime = 0L;
        this.addStatus = 0;
        this.valid = 0;
        this.mNickName = "";
        this.mPortrait = "";
        this.mUk = j;
        this.mName = str;
        this.role = i2;
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

    public int getAddStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.addStatus : invokeV.intValue;
    }

    public long getBduid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mBduid : invokeV.longValue;
    }

    public String getGroupid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.groupid : (String) invokeV.objValue;
    }

    public long getJointime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.jointime : invokeV.longValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mName : (String) invokeV.objValue;
    }

    public String getNickName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mNickName : (String) invokeV.objValue;
    }

    public String getPortrait() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mPortrait : (String) invokeV.objValue;
    }

    public int getRole() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.role : invokeV.intValue;
    }

    public String getShowName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? TextUtils.isEmpty(this.mNickName) ? this.mName : this.mNickName : (String) invokeV.objValue;
    }

    public long getUk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mUk : invokeV.longValue;
    }

    public int getValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.valid : invokeV.intValue;
    }

    public void setAddStatus(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.addStatus = i2;
        }
    }

    public void setBduid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048589, this, j) == null) {
            this.mBduid = j;
        }
    }

    public void setGroupid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.groupid = str;
        }
    }

    public void setJointime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048591, this, j) == null) {
            this.jointime = j;
        }
    }

    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.mName = str;
        }
    }

    public void setNickName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.mNickName = str;
        }
    }

    public void setPortrait(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.mPortrait = str;
        }
    }

    public void setRole(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.role = i2;
        }
    }

    public void setValid(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.valid = i2;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return "GroupMember [groupid=" + this.groupid + ", mUk=" + this.mUk + ", mName=" + this.mName + ", mBduid=" + this.mBduid + ", role=" + this.role + ", jointime=" + this.jointime + ", addStatus=" + this.addStatus + ", valid=" + this.valid + ", mPortrait=" + getPortrait() + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048598, this, parcel, i2) == null) {
            parcel.writeLong(this.mUk);
            parcel.writeString(this.mName);
            parcel.writeInt(this.role);
            parcel.writeLong(this.jointime);
            parcel.writeLong(this.mBduid);
            parcel.writeString(this.groupid);
            parcel.writeString(getPortrait());
        }
    }

    public GroupMember(String str, long j, String str2, long j2, int i2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Long.valueOf(j), str2, Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mUk = -1L;
        this.mName = "";
        this.role = 0;
        this.jointime = 0L;
        this.addStatus = 0;
        this.valid = 0;
        this.mNickName = "";
        this.mPortrait = "";
        this.groupid = str;
        this.mUk = j;
        this.mName = str2;
        this.mBduid = j2;
        this.role = i2;
        this.jointime = j3;
    }

    public GroupMember(Parcel parcel) {
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
        this.mUk = -1L;
        this.mName = "";
        this.role = 0;
        this.jointime = 0L;
        this.addStatus = 0;
        this.valid = 0;
        this.mNickName = "";
        this.mPortrait = "";
        this.mUk = parcel.readLong();
        this.mName = parcel.readString();
        this.role = parcel.readInt();
        this.jointime = parcel.readLong();
        this.mBduid = parcel.readLong();
        this.groupid = parcel.readString();
        setPortrait(parcel.readString());
    }
}
