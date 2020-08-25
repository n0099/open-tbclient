package com.baidu.pass.biometrics.base.dynamicupdate;

import android.content.Context;
import android.os.Bundle;
import com.baidu.pass.biometrics.base.PassBiometricConfiguration;
/* loaded from: classes20.dex */
public class SoManager {
    public static void checkVersion(PassBiometricConfiguration passBiometricConfiguration) {
        new UpdateSo().checkSoUpdate(passBiometricConfiguration);
    }

    public static boolean load(Context context, Bundle bundle) {
        return new LoadSo().a(context, bundle);
    }
}
