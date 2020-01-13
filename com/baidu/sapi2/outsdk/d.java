package com.baidu.sapi2.outsdk;

import android.app.Application;
import com.baidu.pass.biometrics.base.PassBiometric;
import com.baidu.pass.biometrics.base.PassBiometricConfiguration;
import com.baidu.pass.biometrics.base.PassBiometricFactory;
import com.baidu.pass.biometrics.base.utils.PassBioEnv;
import com.baidu.pass.biometrics.face.liveness.PassFaceRecogManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.utils.enums.Domain;
/* loaded from: classes5.dex */
public class d {
    public void a(SapiConfiguration sapiConfiguration) {
        String str;
        PassBiometric biometric = PassBiometricFactory.getDefaultFactory().getBiometric(4);
        if (biometric == null || ((PassFaceRecogManager) biometric).getConfiguration() == null) {
            Domain domain = sapiConfiguration.environment;
            if (domain == Domain.DOMAIN_QA) {
                str = PassBioEnv.PASSPORT_QA_DOMAIN;
            } else {
                str = domain == Domain.DOMAIN_RD ? PassBioEnv.PASSPORT_RD_DOMAIN : PassBioEnv.PASSPORT_DOMAIN;
            }
            biometric.config(new PassBiometricConfiguration.Builder((Application) sapiConfiguration.context.getApplicationContext()).setProductLineInfo(sapiConfiguration.tpl, sapiConfiguration.appId, sapiConfiguration.appSignKey).setRuntimeEnvironment(str).debug(sapiConfiguration.debug).build());
        }
    }
}
