package com.baidu.sapi2.outsdk;

import android.app.Application;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.base.PassBiometric;
import com.baidu.pass.biometrics.base.PassBiometricConfiguration;
import com.baidu.pass.biometrics.base.PassBiometricFactory;
import com.baidu.pass.biometrics.base.utils.PassBioEnv;
import com.baidu.pass.biometrics.face.liveness.PassFaceRecogManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class PassBiometricCall {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PassBiometricCall() {
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

    public void initPassBioSDK(SapiConfiguration sapiConfiguration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, sapiConfiguration) == null) {
            PassBiometric biometric = PassBiometricFactory.getDefaultFactory().getBiometric(4);
            if (biometric == null || ((PassFaceRecogManager) biometric).getConfiguration() == null) {
                PassBiometricConfiguration build = new PassBiometricConfiguration.Builder((Application) sapiConfiguration.context.getApplicationContext()).setProductLineInfo(sapiConfiguration.tpl, sapiConfiguration.appId, sapiConfiguration.appSignKey).sofireSdkConfig(sapiConfiguration.sofireAppKey, sapiConfiguration.sofireSecKey, sapiConfiguration.sofireHostID).setProductLicenseInfo(sapiConfiguration.faceLincenseID, sapiConfiguration.faceLincenseFile).setRuntimeEnvironment(sapiConfiguration.environment == Domain.DOMAIN_QA ? PassBioEnv.PASSPORT_QA_DOMAIN : PassBioEnv.PASSPORT_DOMAIN).debug(sapiConfiguration.debug).setAgreeDangerousProtocol(sapiConfiguration.isAgreeDangerousProtocol()).build();
                if (biometric != null) {
                    biometric.config(build);
                }
            }
        }
    }

    public void setFaceModuleAgreeDangerousProtocol(boolean z) {
        PassBiometric biometric;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (biometric = PassBiometricFactory.getDefaultFactory().getBiometric(4)) == null || ((PassFaceRecogManager) biometric).getConfiguration() == null) {
            return;
        }
        biometric.setAgreeDangerousProtocol(z);
    }
}
