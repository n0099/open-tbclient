package android.support.v4.view;

import android.os.Build;
import android.view.KeyEvent;
/* loaded from: classes.dex */
public class a {
    static final d a;

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            a = new c();
        } else {
            a = new b();
        }
    }

    public static boolean a(KeyEvent keyEvent, int i) {
        return a.a(keyEvent.getMetaState(), i);
    }

    public static boolean a(KeyEvent keyEvent) {
        return a.b(keyEvent.getMetaState());
    }
}
