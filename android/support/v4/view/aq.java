package android.support.v4.view;

import android.graphics.Paint;
import android.os.Build;
import android.view.View;
/* loaded from: classes.dex */
public class aq {

    /* renamed from: a  reason: collision with root package name */
    static final ax f318a;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 17) {
            f318a = new aw();
        } else if (i >= 16) {
            f318a = new av();
        } else if (i >= 14) {
            f318a = new au();
        } else if (i >= 11) {
            f318a = new at();
        } else if (i >= 9) {
            f318a = new as();
        } else {
            f318a = new ar();
        }
    }

    public static boolean a(View view, int i) {
        return f318a.a(view, i);
    }

    public static int a(View view) {
        return f318a.a(view);
    }

    public static void a(View view, a aVar) {
        f318a.a(view, aVar);
    }

    public static void b(View view) {
        f318a.b(view);
    }

    public static void a(View view, int i, int i2, int i3, int i4) {
        f318a.a(view, i, i2, i3, i4);
    }

    public static void a(View view, Runnable runnable) {
        f318a.a(view, runnable);
    }

    public static int c(View view) {
        return f318a.c(view);
    }

    public static void b(View view, int i) {
        f318a.b(view, i);
    }

    public static void a(View view, int i, Paint paint) {
        f318a.a(view, i, paint);
    }

    public static int d(View view) {
        return f318a.d(view);
    }

    public static void a(View view, Paint paint) {
        f318a.a(view, paint);
    }

    public static int e(View view) {
        return f318a.e(view);
    }
}
