package android.support.v4.view;

import android.os.Build;
import android.view.ViewConfiguration;
/* loaded from: classes.dex */
public class y {
    static final ab a;

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            a = new aa();
        } else {
            a = new z();
        }
    }

    public static int a(ViewConfiguration viewConfiguration) {
        return a.a(viewConfiguration);
    }
}
