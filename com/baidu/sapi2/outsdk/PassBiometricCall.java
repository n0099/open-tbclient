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
        PassBiometric biometric = PassBiometricFactory.getDefaultFactory().getBiometric(4);
        if (biometric == null || ((PassFaceRecogManager) biometric).getConfiguration() == null) {
            biometric.config(new PassBiometricConfiguration.Builder((Application) sapiConfiguration.context.getApplicationContext()).setProductLineInfo(sapiConfiguration.tpl, sapiConfiguration.appId, sapiConfiguration.appSignKey).setRuntimeEnvironment(sapiConfiguration.environment == Domain.DOMAIN_QA ? PassBioEnv.PASSPORT_QA_DOMAIN : PassBioEnv.PASSPORT_DOMAIN).debug(sapiConfiguration.debug).build());
        }
    }
}
