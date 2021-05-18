package com.baidu.pass.biometrics.base.armor;
/* loaded from: classes2.dex */
public class RimArmor {

    /* renamed from: a  reason: collision with root package name */
    public static RimArmor f9032a;

    public static synchronized RimArmor getInstance() {
        RimArmor rimArmor;
        synchronized (RimArmor.class) {
            if (f9032a == null) {
                f9032a = new RimArmor();
            }
            rimArmor = f9032a;
        }
        return rimArmor;
    }

    public native String getToken();
}
