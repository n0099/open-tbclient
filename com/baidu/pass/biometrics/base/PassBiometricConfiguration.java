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
    public boolean f44017a;
    public final String appId;
    public final String appSignKey;

    /* renamed from: b  reason: collision with root package name */
    public Application f44018b;
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
        public String f44019a;

        /* renamed from: b  reason: collision with root package name */
        public String f44020b;

        /* renamed from: c  reason: collision with root package name */
        public String f44021c;

        /* renamed from: d  reason: collision with root package name */
        public String f44022d;

        /* renamed from: e  reason: collision with root package name */
        public String f44023e;

        /* renamed from: f  reason: collision with root package name */
        public String f44024f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f44025g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f44026h;

        /* renamed from: i  reason: collision with root package name */
        public Application f44027i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f44028j;

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
            this.f44025g = false;
            this.f44026h = false;
            this.f44028j = true;
            this.f44027i = application;
        }

        public PassBiometricConfiguration build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (!TextUtils.isEmpty(this.f44019a) && !TextUtils.isEmpty(this.f44020b) && !TextUtils.isEmpty(this.f44021c)) {
                    if (this.f44024f == null) {
                        this.f44024f = PassBioEnv.PASSPORT_DOMAIN;
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
                this.f44026h = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setAgreeDangerousProtocol(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.f44028j = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setProductLicenseInfo(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
                this.f44022d = str;
                this.f44023e = str2;
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder setProductLineInfo(String str, String str2, String str3) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, str, str2, str3)) == null) {
                this.f44019a = str;
                this.f44020b = str2;
                this.f44021c = str3;
                return this;
            }
            return (Builder) invokeLLL.objValue;
        }

        public Builder setRuntimeEnvironment(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.f44024f = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder showPmnRationaleDialog(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                this.f44025g = z;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f44018b : (Application) invokeV.objValue;
    }

    public boolean isAgreeDangerousProtocol() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f44017a : invokeV.booleanValue;
    }

    public void setAgreeDangerousProtocol(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f44017a = z;
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
        this.f44017a = true;
        this.tpl = builder.f44019a;
        this.appId = builder.f44020b;
        this.appSignKey = builder.f44021c;
        this.passDomain = builder.f44024f;
        this.licenseID = builder.f44022d;
        this.licenseFileName = builder.f44023e;
        this.f44017a = builder.f44028j;
        debug(builder.f44026h);
        this.showPmnRationaleDialog = builder.f44025g;
        this.f44018b = builder.f44027i;
    }
}
