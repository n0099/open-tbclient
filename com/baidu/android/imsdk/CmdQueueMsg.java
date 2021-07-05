package com.baidu.android.imsdk;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class CmdQueueMsg implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<CmdQueueMsg> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public String body;
    public String extra;
    public int methodId;
    public String uuid;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-973365352, "Lcom/baidu/android/imsdk/CmdQueueMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-973365352, "Lcom/baidu/android/imsdk/CmdQueueMsg;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<CmdQueueMsg>() { // from class: com.baidu.android.imsdk.CmdQueueMsg.1
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
            public CmdQueueMsg createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? CmdQueueMsg.readFromParcel(parcel) : (CmdQueueMsg) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public CmdQueueMsg[] newArray(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? new CmdQueueMsg[i2] : (CmdQueueMsg[]) invokeI.objValue;
            }
        };
    }

    public CmdQueueMsg() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static CmdQueueMsg readFromParcel(Parcel parcel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, parcel)) == null) {
            CmdQueueMsg cmdQueueMsg = new CmdQueueMsg();
            cmdQueueMsg.setUuid(parcel.readString());
            cmdQueueMsg.setBody(parcel.readString());
            cmdQueueMsg.setMethodId(parcel.readInt());
            cmdQueueMsg.setExtra(parcel.readString());
            return cmdQueueMsg;
        }
        return (CmdQueueMsg) invokeL.objValue;
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

    public String getBody() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.body : (String) invokeV.objValue;
    }

    public String getExtra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.extra : (String) invokeV.objValue;
    }

    public int getMethodId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.methodId : invokeV.intValue;
    }

    public String getUuid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.uuid : (String) invokeV.objValue;
    }

    public void setBody(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.body = str;
        }
    }

    public void setExtra(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.extra = str;
        }
    }

    public void setMethodId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.methodId = i2;
        }
    }

    public void setUuid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.uuid = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, parcel, i2) == null) {
            parcel.writeString(this.uuid);
            parcel.writeString(this.body);
            parcel.writeInt(this.methodId);
            parcel.writeString(this.extra);
        }
    }
}
