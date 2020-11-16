package com.baidu.pass.biometrics.base.armor;
/* loaded from: classes9.dex */
public class RimArmor {

    /* renamed from: a  reason: collision with root package name */
    private static RimArmor f2691a;

    private RimArmor() {
    }

    public static synchronized RimArmor getInstance() {
        RimArmor rimArmor;
        synchronized (RimArmor.class) {
            if (f2691a == null) {
                f2691a = new RimArmor();
            }
            rimArmor = f2691a;
        }
        return rimArmor;
    }

    public native String getToken();
}
