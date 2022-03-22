package com.baidu.swan.bdprivate.extensions.quicklogin;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.process.SwanAppIPCData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class QuickLoginInfo extends SwanAppIPCData {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<QuickLoginInfo> CREATOR;
    public static final boolean DEBUG;
    public transient /* synthetic */ FieldHolder $fh;
    public String agreeText;
    public String encryptPhoneNum;
    public boolean hasHistory;
    public int loginMode;
    public String serviceAgreement;
    public boolean supportQuickLogin;

    /* loaded from: classes4.dex */
    public static class a implements Parcelable.Creator<QuickLoginInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public QuickLoginInfo createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) ? new QuickLoginInfo(parcel, null) : (QuickLoginInfo) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public QuickLoginInfo[] newArray(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? new QuickLoginInfo[i] : (QuickLoginInfo[]) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(5936251, "Lcom/baidu/swan/bdprivate/extensions/quicklogin/QuickLoginInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(5936251, "Lcom/baidu/swan/bdprivate/extensions/quicklogin/QuickLoginInfo;");
                return;
            }
        }
        DEBUG = c.a.n0.a.a.a;
        CREATOR = new a();
    }

    public /* synthetic */ QuickLoginInfo(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Nullable
    public static QuickLoginInfo parseQuickLoginInfo(c.a.n0.b.g.d.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, aVar)) == null) {
            if (aVar == null) {
                return null;
            }
            QuickLoginInfo quickLoginInfo = new QuickLoginInfo();
            quickLoginInfo.supportQuickLogin = aVar.f();
            quickLoginInfo.encryptPhoneNum = aVar.c();
            quickLoginInfo.serviceAgreement = aVar.b();
            quickLoginInfo.hasHistory = aVar.d();
            quickLoginInfo.loginMode = aVar.e();
            quickLoginInfo.agreeText = aVar.a();
            return quickLoginInfo;
        }
        return (QuickLoginInfo) invokeL.objValue;
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

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "QuickLoginInfo{supportQuickLogin=" + this.supportQuickLogin + ", encryptPhoneNum='" + this.encryptPhoneNum + "', serviceAgreement='" + this.serviceAgreement + "', hasHistory=" + this.hasHistory + ", loginMode=" + this.loginMode + ", agreeText=" + this.agreeText + '}';
        }
        return (String) invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, parcel, i) == null) {
            parcel.writeByte(this.supportQuickLogin ? (byte) 1 : (byte) 0);
            parcel.writeString(this.encryptPhoneNum);
            parcel.writeString(this.serviceAgreement);
            parcel.writeByte(this.hasHistory ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.loginMode);
            parcel.writeString(this.agreeText);
        }
    }

    public QuickLoginInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public QuickLoginInfo(Parcel parcel) {
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
        this.supportQuickLogin = parcel.readByte() != 0;
        this.encryptPhoneNum = parcel.readString();
        this.serviceAgreement = parcel.readString();
        this.hasHistory = parcel.readByte() != 0;
        this.loginMode = parcel.readInt();
        this.agreeText = parcel.readString();
    }
}
