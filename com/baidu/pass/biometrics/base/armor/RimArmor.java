package com.baidu.pass.biometrics.base.armor;
/* loaded from: classes6.dex */
public class RimArmor {
    private static RimArmor a;

    private RimArmor() {
    }

    public static synchronized RimArmor getInstance() {
        RimArmor rimArmor;
        synchronized (RimArmor.class) {
            if (a == null) {
                a = new RimArmor();
            }
            rimArmor = a;
        }
        return rimArmor;
    }

    public native String getToken();
}
