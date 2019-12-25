package com.baidu.pass.biometrics.base.dynamicupdate;

import android.content.Context;
import android.os.Bundle;
import com.baidu.pass.biometrics.base.PassBiometricConfiguration;
/* loaded from: classes4.dex */
public class SoManager {
    public static boolean load(Context context, Bundle bundle) {
        return new LoadSo().load(context, bundle);
    }

    public static void checkVersion(PassBiometricConfiguration passBiometricConfiguration) {
        new UpdateSo().checkSoUpdate(passBiometricConfiguration);
    }
}
