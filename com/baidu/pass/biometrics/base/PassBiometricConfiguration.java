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
/* loaded from: classes7.dex */
public class PassBiometricConfiguration {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TARGET_TPL = "pp";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f41703a;
    public final String appId;
    public final String appSignKey;

    /* renamed from: b  reason: collision with root package name */
    public Application f41704b;
    public final String licenseFileName;
    public final String licenseID;
    public String passDomain;
    public boolean showPmnRationaleDialog;
    public final String sofireAppKey;
    public final int sofireHostID;
    public final String sofireSecKey;
    public final String tpl;

    /* renamed from: com.baidu.pass.biometrics.base.PassBiometricConfiguration$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f41705a;

        /* renamed from: b  reason: collision with root package name */
        public String f41706b;

        /* renamed from: c  reason: collision with root package name */
        public String f41707c;

        /* renamed from: d  reason: collision with root package name */
        public String f41708d;

        /* renamed from: e  reason: collision with root package name */
        public String f41709e;

        /* renamed from: f  reason: collision with root package name */
        public String f41710f;

        /* renamed from: g  reason: collision with root package name */
        public String f41711g;

        /* renamed from: h  reason: collision with root package name */
        public String f41712h;

        /* renamed from: i  reason: collision with root package name */
        public int f41713i;
        public boolean j;
        public boolean k;
        public Application l;
        public boolean m;

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
            this.j = false;
            this.k = false;
            this.m = true;
            this.l = application;
        }

        public PassBiometricConfiguration build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (!TextUtils.isEmpty(this.f41705a) && !TextUtils.isEmpty(this.f41706b) && !TextUtils.isEmpty(this.f41707c)) {
                    if (this.f41710f == null) {
                        this.f41710f = PassBioEnv.PASSPORT_DOMAIN;
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
                this.k = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setAgreeDangerousProtocol(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.m = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setProductLicenseInfo(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
                this.f41708d = str;
                this.f41709e = str2;
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder setProductLineInfo(String str, String str2, String str3) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, str, str2, str3)) == null) {
                this.f41705a = str;
                this.f41706b = str2;
                this.f41707c = str3;
                return this;
            }
            return (Builder) invokeLLL.objValue;
        }

        public Builder setRuntimeEnvironment(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.f41710f = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder showPmnRationaleDialog(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                this.j = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder sofireSdkConfig(String str, String str2, int i2) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048583, this, str, str2, i2)) == null) {
                this.f41711g = str;
                this.f41712h = str2;
                this.f41713i = i2;
                return this;
            }
            return (Builder) invokeLLI.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f41704b : (Application) invokeV.objValue;
    }

    public boolean isAgreeDangerousProtocol() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f41703a : invokeV.booleanValue;
    }

    public void setAgreeDangerousProtocol(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f41703a = z;
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
        this.f41703a = true;
        this.tpl = builder.f41705a;
        this.appId = builder.f41706b;
        this.appSignKey = builder.f41707c;
        this.passDomain = builder.f41710f;
        this.licenseID = builder.f41708d;
        this.licenseFileName = builder.f41709e;
        this.sofireAppKey = builder.f41711g;
        this.sofireSecKey = builder.f41712h;
        this.sofireHostID = builder.f41713i;
        this.f41703a = builder.m;
        debug(builder.k);
        this.showPmnRationaleDialog = builder.j;
        this.f41704b = builder.l;
    }
}
