package com.baidu.pass.biometrics.base.armor;
/* loaded from: classes2.dex */
public class RimArmor {

    /* renamed from: a  reason: collision with root package name */
    public static RimArmor f8932a;

    public static synchronized RimArmor getInstance() {
        RimArmor rimArmor;
        synchronized (RimArmor.class) {
            if (f8932a == null) {
                f8932a = new RimArmor();
            }
            rimArmor = f8932a;
        }
        return rimArmor;
    }

    public native String getToken();
}
