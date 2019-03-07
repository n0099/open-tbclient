package com.baidu.pass.biometrics.base.armor;
/* loaded from: classes2.dex */
public class RimArmor {
    private static RimArmor ins;

    public native String getToken();

    private RimArmor() {
    }

    public static synchronized RimArmor getInstance() {
        RimArmor rimArmor;
        synchronized (RimArmor.class) {
            if (ins == null) {
                ins = new RimArmor();
            }
            rimArmor = ins;
        }
        return rimArmor;
    }
}
