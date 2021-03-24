package com.baidu.pass.biometrics.base.armor;
/* loaded from: classes2.dex */
public class RimArmor {

    /* renamed from: a  reason: collision with root package name */
    public static RimArmor f9518a;

    public static synchronized RimArmor getInstance() {
        RimArmor rimArmor;
        synchronized (RimArmor.class) {
            if (f9518a == null) {
                f9518a = new RimArmor();
            }
            rimArmor = f9518a;
        }
        return rimArmor;
    }

    public native String getToken();
}
