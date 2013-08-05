package android.support.v4.view;

import android.graphics.Paint;
import android.os.Build;
import android.view.View;
/* loaded from: classes.dex */
public class aq {

    /* renamed from: a  reason: collision with root package name */
    static final ax f314a;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 17) {
            f314a = new aw();
        } else if (i >= 16) {
            f314a = new av();
        } else if (i >= 14) {
            f314a = new au();
        } else if (i >= 11) {
            f314a = new at();
        } else if (i >= 9) {
            f314a = new as();
        } else {
            f314a = new ar();
        }
    }

    public static boolean a(View view, int i) {
        return f314a.a(view, i);
    }

    public static int a(View view) {
        return f314a.a(view);
    }

    public static void a(View view, a aVar) {
        f314a.a(view, aVar);
    }

    public static void b(View view) {
        f314a.b(view);
    }

    public static void a(View view, int i, int i2, int i3, int i4) {
        f314a.a(view, i, i2, i3, i4);
    }

    public static void a(View view, Runnable runnable) {
        f314a.a(view, runnable);
    }

    public static int c(View view) {
        return f314a.c(view);
    }

    public static void b(View view, int i) {
        f314a.b(view, i);
    }

    public static void a(View view, int i, Paint paint) {
        f314a.a(view, i, paint);
    }

    public static int d(View view) {
        return f314a.d(view);
    }

    public static void a(View view, Paint paint) {
        f314a.a(view, paint);
    }

    public static int e(View view) {
        return f314a.e(view);
    }
}
