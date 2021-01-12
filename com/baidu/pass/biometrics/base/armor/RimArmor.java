package com.baidu.pass.biometrics.base.armor;
/* loaded from: classes5.dex */
public class RimArmor {

    /* renamed from: a  reason: collision with root package name */
    private static RimArmor f3939a;

    private RimArmor() {
    }

    public static synchronized RimArmor getInstance() {
        RimArmor rimArmor;
        synchronized (RimArmor.class) {
            if (f3939a == null) {
                f3939a = new RimArmor();
            }
            rimArmor = f3939a;
        }
        return rimArmor;
    }

    public native String getToken();
}
