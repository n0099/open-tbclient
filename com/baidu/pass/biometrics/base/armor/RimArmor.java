package com.baidu.pass.biometrics.base.armor;
/* loaded from: classes9.dex */
public class RimArmor {

    /* renamed from: a  reason: collision with root package name */
    private static RimArmor f2693a;

    private RimArmor() {
    }

    public static synchronized RimArmor getInstance() {
        RimArmor rimArmor;
        synchronized (RimArmor.class) {
            if (f2693a == null) {
                f2693a = new RimArmor();
            }
            rimArmor = f2693a;
        }
        return rimArmor;
    }

    public native String getToken();
}
