package com.baidu.swan.apps.extcore.model;

import android.os.Parcel;
import android.os.Parcelable;
import c.a.r0.a.z2.l0;
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
/* loaded from: classes11.dex */
public class ExtensionCore extends SwanAppIPCData {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<ExtensionCore> CREATOR;
    public static final int TYPE_DEBUG = 2;
    public static final int TYPE_PRESET = 0;
    public static final int TYPE_REMOTE = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public String extensionCorePath;
    public int extensionCoreType;
    public long extensionCoreVersionCode;
    public String extensionCoreVersionName;

    /* loaded from: classes11.dex */
    public static class a implements Parcelable.Creator<ExtensionCore> {
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
        public ExtensionCore createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) ? new ExtensionCore(parcel, null) : (ExtensionCore) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ExtensionCore[] newArray(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new ExtensionCore[i2] : (ExtensionCore[]) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1448924481, "Lcom/baidu/swan/apps/extcore/model/ExtensionCore;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1448924481, "Lcom/baidu/swan/apps/extcore/model/ExtensionCore;");
                return;
            }
        }
        CREATOR = new a();
    }

    public /* synthetic */ ExtensionCore(Parcel parcel, a aVar) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? l0.e(this.extensionCorePath) : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "ExtensionCore{extensionCoreType=" + this.extensionCoreType + ", extensionCoreVersionCode=" + this.extensionCoreVersionCode + ", extensionCoreVersionName=" + this.extensionCoreVersionName + ", extensionCorePath='" + this.extensionCorePath + ExtendedMessageFormat.QUOTE + ", isAvailable='" + isAvailable() + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, parcel, i2) == null) {
            parcel.writeInt(this.extensionCoreType);
            parcel.writeLong(this.extensionCoreVersionCode);
            parcel.writeString(this.extensionCoreVersionName);
            parcel.writeString(this.extensionCorePath);
        }
    }

    public ExtensionCore() {
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

    public ExtensionCore(Parcel parcel) {
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
        this.extensionCoreType = parcel.readInt();
        this.extensionCoreVersionCode = parcel.readLong();
        this.extensionCoreVersionName = parcel.readString();
        this.extensionCorePath = parcel.readString();
    }
}
