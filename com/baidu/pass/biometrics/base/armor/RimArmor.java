package com.baidu.pass.biometrics.base.armor;
/* loaded from: classes5.dex */
public class RimArmor {

    /* renamed from: a  reason: collision with root package name */
    private static RimArmor f3976a;

    private RimArmor() {
    }

    public static synchronized RimArmor getInstance() {
        RimArmor rimArmor;
        synchronized (RimArmor.class) {
            if (f3976a == null) {
                f3976a = new RimArmor();
            }
            rimArmor = f3976a;
        }
        return rimArmor;
    }

    public native String getToken();
}
