package com.baidu.pass.biometrics.base;

import android.app.Application;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.biometrics.base.utils.PassBioEnv;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class PassBiometricConfiguration {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TARGET_TPL = "pp";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f43929a;
    public final String appId;
    public final String appSignKey;

    /* renamed from: b  reason: collision with root package name */
    public Application f43930b;
    public final String licenseFileName;
    public final String licenseID;
    public String passDomain;
    public boolean showPmnRationaleDialog;
    public final String tpl;

    /* renamed from: com.baidu.pass.biometrics.base.PassBiometricConfiguration$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f43931a;

        /* renamed from: b  reason: collision with root package name */
        public String f43932b;

        /* renamed from: c  reason: collision with root package name */
        public String f43933c;

        /* renamed from: d  reason: collision with root package name */
        public String f43934d;

        /* renamed from: e  reason: collision with root package name */
        public String f43935e;

        /* renamed from: f  reason: collision with root package name */
        public String f43936f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f43937g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f43938h;

        /* renamed from: i  reason: collision with root package name */
        public Application f43939i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f43940j;

        public Builder(Application application) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {application};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43937g = false;
            this.f43938h = false;
            this.f43940j = true;
            this.f43939i = application;
        }

        public PassBiometricConfiguration build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (!TextUtils.isEmpty(this.f43931a) && !TextUtils.isEmpty(this.f43932b) && !TextUtils.isEmpty(this.f43933c)) {
                    if (this.f43936f == null) {
                        this.f43936f = PassBioEnv.PASSPORT_DOMAIN;
                    }
                    return new PassBiometricConfiguration(this, null);
                }
                throw new IllegalArgumentException("tpl, appId, appsignkey, passProductId can not be null, please use setProductLineInfo(String tpl, String appId, String appSignKey, String passProductId)to initialize them.");
            }
            return (PassBiometricConfiguration) invokeV.objValue;
        }

        public Builder debug(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                this.f43938h = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setAgreeDangerousProtocol(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.f43940j = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setProductLicenseInfo(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
                this.f43934d = str;
                this.f43935e = str2;
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder setProductLineInfo(String str, String str2, String str3) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, str, str2, str3)) == null) {
                this.f43931a = str;
                this.f43932b = str2;
                this.f43933c = str3;
                return this;
            }
            return (Builder) invokeLLL.objValue;
        }

        public Builder setRuntimeEnvironment(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.f43936f = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder showPmnRationaleDialog(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                this.f43937g = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }
    }

    public /* synthetic */ PassBiometricConfiguration(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public void debug(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            Log.enable(z);
        }
    }

    public Application getApplication() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f43930b : (Application) invokeV.objValue;
    }

    public boolean isAgreeDangerousProtocol() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f43929a : invokeV.booleanValue;
    }

    public void setAgreeDangerousProtocol(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f43929a = z;
        }
    }

    public PassBiometricConfiguration(Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f43929a = true;
        this.tpl = builder.f43931a;
        this.appId = builder.f43932b;
        this.appSignKey = builder.f43933c;
        this.passDomain = builder.f43936f;
        this.licenseID = builder.f43934d;
        this.licenseFileName = builder.f43935e;
        this.f43929a = builder.f43940j;
        debug(builder.f43938h);
        this.showPmnRationaleDialog = builder.f43937g;
        this.f43930b = builder.f43939i;
    }
}
