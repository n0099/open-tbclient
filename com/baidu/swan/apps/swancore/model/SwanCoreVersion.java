package com.baidu.swan.apps.swancore.model;

import android.os.Parcel;
import android.os.Parcelable;
import c.a.n0.a.v2.l0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.process.SwanAppIPCData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes6.dex */
public class SwanCoreVersion extends SwanAppIPCData {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<SwanCoreVersion> CREATOR;
    public static final int TYPE_DEBUG = 2;
    public static final int TYPE_PRESET = 0;
    public static final int TYPE_REMOTE = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public String swanCorePath;
    public int swanCoreType;
    public long swanCoreVersionCode;
    public String swanCoreVersionName;

    /* loaded from: classes6.dex */
    public static class a implements Parcelable.Creator<SwanCoreVersion> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SwanCoreVersion createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) ? new SwanCoreVersion(parcel, null) : (SwanCoreVersion) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SwanCoreVersion[] newArray(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new SwanCoreVersion[i2] : (SwanCoreVersion[]) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1560993621, "Lcom/baidu/swan/apps/swancore/model/SwanCoreVersion;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1560993621, "Lcom/baidu/swan/apps/swancore/model/SwanCoreVersion;");
                return;
            }
        }
        CREATOR = new a();
    }

    public /* synthetic */ SwanCoreVersion(Parcel parcel, a aVar) {
        this(parcel);
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

    public boolean isAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? l0.e(this.swanCorePath) : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "SwanCoreVersion{swanCorePath='" + this.swanCorePath + ExtendedMessageFormat.QUOTE + ", swanCoreVersionName=" + this.swanCoreVersionName + ", swanCoreVersionCode=" + this.swanCoreVersionCode + ", swanCoreType=" + this.swanCoreType + ", isAvailable=" + isAvailable() + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, parcel, i2) == null) {
            parcel.writeInt(this.swanCoreType);
            parcel.writeLong(this.swanCoreVersionCode);
            parcel.writeString(this.swanCoreVersionName);
            parcel.writeString(this.swanCorePath);
        }
    }

    public SwanCoreVersion() {
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

    public SwanCoreVersion(Parcel parcel) {
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
        this.swanCoreType = parcel.readInt();
        this.swanCoreVersionCode = parcel.readLong();
        this.swanCoreVersionName = parcel.readString();
        this.swanCorePath = parcel.readString();
    }
}
