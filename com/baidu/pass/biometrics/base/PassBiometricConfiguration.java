package com.baidu.pass.biometrics.base;

import android.app.Application;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.biometrics.base.utils.PassBioEnv;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes4.dex */
public class PassBiometricConfiguration {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TARGET_TPL = "pp";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public final String appId;
    public final String appSignKey;

    /* renamed from: b  reason: collision with root package name */
    public Application f27882b;
    public Map<String, String> faceResPaths;
    public final String licenseFileName;
    public final String licenseID;
    public String passDomain;
    public boolean showPmnRationaleDialog;
    public final String sofireAppKey;
    public final int sofireHostID;
    public final String sofireSecKey;
    public final String tpl;

    /* renamed from: com.baidu.pass.biometrics.base.PassBiometricConfiguration$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f27883b;

        /* renamed from: c  reason: collision with root package name */
        public String f27884c;

        /* renamed from: d  reason: collision with root package name */
        public String f27885d;

        /* renamed from: e  reason: collision with root package name */
        public String f27886e;

        /* renamed from: f  reason: collision with root package name */
        public String f27887f;

        /* renamed from: g  reason: collision with root package name */
        public String f27888g;

        /* renamed from: h  reason: collision with root package name */
        public String f27889h;
        public int i;
        public boolean j;
        public boolean k;
        public Application l;
        public boolean m;
        public Map<String, String> n;

        public Builder(Application application) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {application};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                if (!TextUtils.isEmpty(this.a) && !TextUtils.isEmpty(this.f27883b) && !TextUtils.isEmpty(this.f27884c)) {
                    if (this.f27887f == null) {
                        this.f27887f = PassBioEnv.PASSPORT_DOMAIN;
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

        public Builder setFaceResPaths(Map<String, String> map) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, map)) == null) {
                this.n = map;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setProductLicenseInfo(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
                this.f27885d = str;
                this.f27886e = str2;
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder setProductLineInfo(String str, String str2, String str3) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, str, str2, str3)) == null) {
                this.a = str;
                this.f27883b = str2;
                this.f27884c = str3;
                return this;
            }
            return (Builder) invokeLLL.objValue;
        }

        public Builder setRuntimeEnvironment(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.f27887f = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder showPmnRationaleDialog(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
                this.j = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder sofireSdkConfig(String str, String str2, int i) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, i)) == null) {
                this.f27888g = str;
                this.f27889h = str2;
                this.i = i;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f27882b : (Application) invokeV.objValue;
    }

    public boolean isAgreeDangerousProtocol() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : invokeV.booleanValue;
    }

    public void setAgreeDangerousProtocol(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.a = z;
        }
    }

    public PassBiometricConfiguration(Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = true;
        this.tpl = builder.a;
        this.appId = builder.f27883b;
        this.appSignKey = builder.f27884c;
        this.passDomain = builder.f27887f;
        this.licenseID = builder.f27885d;
        this.licenseFileName = builder.f27886e;
        this.sofireAppKey = builder.f27888g;
        this.sofireSecKey = builder.f27889h;
        this.sofireHostID = builder.i;
        this.a = builder.m;
        debug(builder.k);
        this.showPmnRationaleDialog = builder.j;
        this.f27882b = builder.l;
        this.faceResPaths = builder.n;
    }
}
