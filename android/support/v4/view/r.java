package android.support.v4.view;

import android.os.Build;
import android.view.View;
/* loaded from: classes.dex */
public class r {
    static final v a;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 14) {
            a = new u();
        } else if (i >= 9) {
            a = new t();
        } else {
            a = new s();
        }
    }

    public static int a(View view) {
        return a.a(view);
    }

    public static boolean a(View view, int i) {
        return a.a(view, i);
    }
}
