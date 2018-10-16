package cn.jiguang.d.c;

import com.meizu.cloud.pushsdk.notification.model.ActVideoSetting;
/* loaded from: classes3.dex */
public final class q {
    private static i lW = new i("Message Section", 3);
    private static String[] b = new String[4];
    private static String[] c = new String[4];

    static {
        lW.a(3);
        lW.a(true);
        lW.a(0, "qd");
        lW.a(1, "an");
        lW.a(2, ActVideoSetting.ACT_URL);
        lW.a(3, "ad");
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
        return lW.b(i);
    }
}
