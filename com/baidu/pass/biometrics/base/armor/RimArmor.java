package com.baidu.pass.biometrics.base.armor;
/* loaded from: classes5.dex */
public class RimArmor {

    /* renamed from: a  reason: collision with root package name */
    private static RimArmor f3977a;

    private RimArmor() {
    }

    public static synchronized RimArmor getInstance() {
        RimArmor rimArmor;
        synchronized (RimArmor.class) {
            if (f3977a == null) {
                f3977a = new RimArmor();
            }
            rimArmor = f3977a;
        }
        return rimArmor;
    }

    public native String getToken();
}
