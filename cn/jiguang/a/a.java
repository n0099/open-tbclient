package cn.jiguang.a;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import cn.jiguang.api.d;
/* loaded from: classes3.dex */
public final class a {
    public static boolean b = true;
    private static boolean c;
    public static d jH;

    public static void a(Context context) {
        if (c) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT >= 14 && (context instanceof Application)) {
                String c2 = cn.jiguang.d.b.a.c(context);
                String packageName = context.getPackageName();
                if (c2 != null && packageName != null && context.getPackageName().equals(c2)) {
                    b = false;
                    ((Application) context).registerActivityLifecycleCallbacks(new cn.jiguang.a.a.d.a());
                }
            }
        } catch (Throwable th) {
            b = true;
        }
        c = true;
    }
}
