package cn.com.chinatelecom.account.api.c;

import android.content.Context;
/* loaded from: classes16.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static g f987a = new j();

    public static String a() {
        return f987a.c();
    }

    public static String a(Context context) {
        return a.b(context) ? f987a.b() : f987a.a();
    }

    public static String a(Context context, String str, String str2, String str3, long j, String str4) {
        return a.b(context) ? f987a.b(context, str, str2, str3, j, str4) : f987a.a(context, str, str2, str3, j, str4);
    }

    public static String a(Context context, String str, String str2, String str3, String str4, long j, String str5) {
        return f987a.a(context, str, str2, str3, str4, j, str5);
    }

    public static String a(String str, String str2) {
        return f987a.a(str, str2);
    }

    public static String b(String str, String str2) {
        return f987a.b(str, str2);
    }
}
