package cn.jiguang.e;

import android.util.Log;
/* loaded from: classes3.dex */
public final class a {
    public static boolean a = true;
    private String b;

    private a() {
        this.b = "";
    }

    public a(String str) {
        this.b = "";
        this.b = "JIGUANG-" + str;
    }

    private static boolean a(int i) {
        return i >= 3;
    }

    public final void a(String str, String str2, Throwable th) {
        if (a && cn.jiguang.d.a.b && a(3)) {
            Log.d(this.b, "[" + str + "] " + str2, th);
        }
    }

    public final void b(String str, String str2, Throwable th) {
        if (a && cn.jiguang.d.a.b && a(4)) {
            Log.i(this.b, "[" + str + "] " + str2, th);
        }
    }

    public final void c(String str, String str2, Throwable th) {
        if (a && cn.jiguang.d.a.b && a(5)) {
            Log.w(this.b, "[" + str + "] " + str2, th);
        }
    }

    public final void d(String str, String str2, Throwable th) {
        if (a && a(6)) {
            Log.e(this.b, "[" + str + "] " + str2, th);
        }
    }
}
