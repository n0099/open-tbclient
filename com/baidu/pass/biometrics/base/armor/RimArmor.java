package com.baidu.pass.biometrics.base.armor;
/* loaded from: classes6.dex */
public class RimArmor {

    /* renamed from: a  reason: collision with root package name */
    private static RimArmor f2742a;

    private RimArmor() {
    }

    public static synchronized RimArmor getInstance() {
        RimArmor rimArmor;
        synchronized (RimArmor.class) {
            if (f2742a == null) {
                f2742a = new RimArmor();
            }
            rimArmor = f2742a;
        }
        return rimArmor;
    }

    public native String getToken();
}
