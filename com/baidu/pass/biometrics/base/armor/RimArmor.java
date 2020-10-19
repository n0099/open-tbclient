package com.baidu.pass.biometrics.base.armor;
/* loaded from: classes11.dex */
public class RimArmor {

    /* renamed from: a  reason: collision with root package name */
    private static RimArmor f2689a;

    private RimArmor() {
    }

    public static synchronized RimArmor getInstance() {
        RimArmor rimArmor;
        synchronized (RimArmor.class) {
            if (f2689a == null) {
                f2689a = new RimArmor();
            }
            rimArmor = f2689a;
        }
        return rimArmor;
    }

    public native String getToken();
}
