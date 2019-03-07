package cn.jiguang.d.c;

import com.meizu.cloud.pushsdk.notification.model.ActVideoSetting;
/* loaded from: classes3.dex */
public final class q {
    private static i lZ = new i("Message Section", 3);
    private static String[] b = new String[4];
    private static String[] c = new String[4];

    static {
        lZ.a(3);
        lZ.a(true);
        lZ.a(0, "qd");
        lZ.a(1, "an");
        lZ.a(2, ActVideoSetting.ACT_URL);
        lZ.a(3, "ad");
        b[0] = "QUESTIONS";
        b[1] = "ANSWERS";
        b[2] = "AUTHORITY RECORDS";
        b[3] = "ADDITIONAL RECORDS";
        c[0] = "ZONE";
        c[1] = "PREREQUISITES";
        c[2] = "UPDATE RECORDS";
        c[3] = "ADDITIONAL RECORDS";
    }

    public static String a(int i) {
        return lZ.b(i);
    }
}
