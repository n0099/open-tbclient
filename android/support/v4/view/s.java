package android.support.v4.view;

import android.os.Build;
import android.view.KeyEvent;
/* loaded from: classes.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    static final w f329a;

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            f329a = new v();
        } else {
            f329a = new t();
        }
    }

    public static boolean a(KeyEvent keyEvent, int i) {
        return f329a.a(keyEvent.getMetaState(), i);
    }

    public static boolean a(KeyEvent keyEvent) {
        return f329a.b(keyEvent.getMetaState());
    }

    public static void b(KeyEvent keyEvent) {
        f329a.a(keyEvent);
    }
}
