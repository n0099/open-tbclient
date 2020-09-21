package cn.com.chinatelecom.account.api.c;

import android.content.Context;
/* loaded from: classes14.dex */
public class f {
    private static g a = new j();

    public static String a() {
        return a.c();
    }

    public static String a(Context context) {
        return a.b(context) ? a.b() : a.a();
    }

    public static String a(Context context, String str, String str2, String str3, long j, String str4) {
        return a.b(context) ? a.b(context, str, str2, str3, j, str4) : a.a(context, str, str2, str3, j, str4);
    }

    public static String a(Context context, String str, String str2, String str3, String str4, long j, String str5) {
        return a.a(context, str, str2, str3, str4, j, str5);
    }

    public static String a(String str, String str2) {
        return a.a(str, str2);
    }

    public static String b(String str, String str2) {
        return a.b(str, str2);
    }
}
