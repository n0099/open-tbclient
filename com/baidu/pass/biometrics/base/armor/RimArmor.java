package com.baidu.pass.biometrics.base.armor;
/* loaded from: classes2.dex */
public class RimArmor {

    /* renamed from: a  reason: collision with root package name */
    public static RimArmor f8996a;

    public static synchronized RimArmor getInstance() {
        RimArmor rimArmor;
        synchronized (RimArmor.class) {
            if (f8996a == null) {
                f8996a = new RimArmor();
            }
            rimArmor = f8996a;
        }
        return rimArmor;
    }

    public native String getToken();
}
