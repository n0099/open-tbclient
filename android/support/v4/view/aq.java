package android.support.v4.view;

import android.graphics.Paint;
import android.os.Build;
import android.view.View;
/* loaded from: classes.dex */
public class aq {
    static final ax a;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 17) {
            a = new aw();
        } else if (i >= 16) {
            a = new av();
        } else if (i >= 14) {
            a = new au();
        } else if (i >= 11) {
            a = new at();
        } else if (i >= 9) {
            a = new as();
        } else {
            a = new ar();
        }
    }

    public static boolean a(View view, int i) {
        return a.a(view, i);
    }

    public static int a(View view) {
        return a.a(view);
    }

    public static void a(View view, a aVar) {
        a.a(view, aVar);
    }

    public static void b(View view) {
        a.b(view);
    }

    public static void a(View view, int i, int i2, int i3, int i4) {
        a.a(view, i, i2, i3, i4);
    }

    public static void a(View view, Runnable runnable) {
        a.a(view, runnable);
    }

    public static int c(View view) {
        return a.c(view);
    }

    public static void b(View view, int i) {
        a.b(view, i);
    }

    public static void a(View view, int i, Paint paint) {
        a.a(view, i, paint);
    }

    public static int d(View view) {
        return a.d(view);
    }

    public static void a(View view, Paint paint) {
        a.a(view, paint);
    }

    public static int e(View view) {
        return a.e(view);
    }
}
