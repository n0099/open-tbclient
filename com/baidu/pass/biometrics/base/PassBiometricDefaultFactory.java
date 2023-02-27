package com.baidu.pass.biometrics.base;

import android.content.Context;
import com.baidu.pass.biometrics.base.callback.PassBiometricCallback;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.biometrics.base.dto.PassBiometricDto;
/* loaded from: classes2.dex */
public class PassBiometricDefaultFactory extends PassBiometricFactory {
    public static final int VERSION_CODE = 8;
    public static final String VERSION_NAME = "1.5.7";
    public static PassBiometricDefaultFactory a;

    private PassBiometric a() {
        return new PassBiometric() { // from class: com.baidu.pass.biometrics.base.PassBiometricDefaultFactory.1
            @Override // com.baidu.pass.biometrics.base.PassBiometric
            public void config(PassBiometricConfiguration passBiometricConfiguration) {
                Log.e(PassBiometricFactory.class.getSimpleName(), "ERROR with implement Biometric!");
            }

            @Override // com.baidu.pass.biometrics.base.PassBiometric
            public void setAgreeDangerousProtocol(boolean z) {
                Log.e(PassBiometricFactory.class.getSimpleName(), "setAgreeDangerousProtocol");
            }

            @Override // com.baidu.pass.biometrics.base.PassBiometric
            public void execute(PassBiometricOperation passBiometricOperation, PassBiometricCallback passBiometricCallback, PassBiometricDto passBiometricDto, Context context) {
                Log.e(PassBiometricFactory.class.getSimpleName(), "ERROR with implement Biometric!");
            }
        };
    }

    public static PassBiometricDefaultFactory getInstance() {
        if (a == null) {
            synchronized (PassBiometricDefaultFactory.class) {
                if (a == null) {
                    a = new PassBiometricDefaultFactory();
                }
            }
        }
        return a;
    }

    @Override // com.baidu.pass.biometrics.base.PassBiometricFactory
    public PassBiometric getBiometric(int i) {
        try {
            return (PassBiometric) Class.forName(BiometricType.a(i)).getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e) {
            Log.e(e);
            return a();
        }
    }
}
