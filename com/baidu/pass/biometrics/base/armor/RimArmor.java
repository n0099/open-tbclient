package com.baidu.pass.biometrics.base.armor;
/* loaded from: classes3.dex */
public class RimArmor {
    public static RimArmor a;

    public native String getToken();

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
}
