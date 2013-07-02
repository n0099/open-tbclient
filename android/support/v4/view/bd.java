package android.support.v4.view;

import android.os.Build;
import android.view.ViewConfiguration;
/* loaded from: classes.dex */
public class bd {
    static final bg a;

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            a = new bf();
        } else {
            a = new be();
        }
    }

    public static int a(ViewConfiguration viewConfiguration) {
        return a.a(viewConfiguration);
    }
}
