package com.baidu.pass.biometrics.base.armor;
/* loaded from: classes2.dex */
public class RimArmor {

    /* renamed from: a  reason: collision with root package name */
    public static RimArmor f9411a;

    public static synchronized RimArmor getInstance() {
        RimArmor rimArmor;
        synchronized (RimArmor.class) {
            if (f9411a == null) {
                f9411a = new RimArmor();
            }
            rimArmor = f9411a;
        }
        return rimArmor;
    }

    public native String getToken();
}
