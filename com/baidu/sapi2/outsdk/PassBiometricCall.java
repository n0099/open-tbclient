package com.baidu.sapi2.outsdk;

import android.app.Application;
import com.baidu.pass.biometrics.base.PassBiometric;
import com.baidu.pass.biometrics.base.PassBiometricConfiguration;
import com.baidu.pass.biometrics.base.PassBiometricFactory;
import com.baidu.pass.biometrics.base.utils.PassBioEnv;
import com.baidu.pass.biometrics.face.liveness.PassFaceRecogManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.utils.enums.Domain;
/* loaded from: classes2.dex */
public class PassBiometricCall {
    public void initPassBioSDK(SapiConfiguration sapiConfiguration) {
        String str;
        PassBiometric biometric = PassBiometricFactory.getDefaultFactory().getBiometric(4);
        if (biometric != null && ((PassFaceRecogManager) biometric).getConfiguration() != null) {
            return;
        }
        if (sapiConfiguration.environment == Domain.DOMAIN_QA) {
            str = PassBioEnv.PASSPORT_QA_DOMAIN;
        } else {
            str = PassBioEnv.PASSPORT_DOMAIN;
        }
        PassBiometricConfiguration build = new PassBiometricConfiguration.Builder((Application) sapiConfiguration.context.getApplicationContext()).setProductLineInfo(sapiConfiguration.tpl, sapiConfiguration.appId, sapiConfiguration.appSignKey).sofireSdkConfig(sapiConfiguration.sofireAppKey, sapiConfiguration.sofireSecKey, sapiConfiguration.sofireHostID).setProductLicenseInfo(sapiConfiguration.faceLincenseID, sapiConfiguration.faceLincenseFile).setRuntimeEnvironment(str).debug(sapiConfiguration.debug).setAgreeDangerousProtocol(sapiConfiguration.isAgreeDangerousProtocol()).setFaceResPaths(sapiConfiguration.faceResPaths).build();
        if (biometric != null) {
            biometric.config(build);
        }
    }

    public void setFaceModuleAgreeDangerousProtocol(boolean z) {
        PassBiometric biometric = PassBiometricFactory.getDefaultFactory().getBiometric(4);
        if (biometric != null && ((PassFaceRecogManager) biometric).getConfiguration() != null) {
            biometric.setAgreeDangerousProtocol(z);
        }
    }
}
