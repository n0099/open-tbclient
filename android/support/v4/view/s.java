package android.support.v4.view;

import android.os.Build;
import android.view.KeyEvent;
/* loaded from: classes.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    static final w f333a;

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            f333a = new v();
        } else {
            f333a = new t();
        }
    }

    public static boolean a(KeyEvent keyEvent, int i) {
        return f333a.a(keyEvent.getMetaState(), i);
    }

    public static boolean a(KeyEvent keyEvent) {
        return f333a.b(keyEvent.getMetaState());
    }

    public static void b(KeyEvent keyEvent) {
        f333a.a(keyEvent);
    }
}
