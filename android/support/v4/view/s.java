package android.support.v4.view;

import android.os.Build;
import android.view.KeyEvent;
/* loaded from: classes.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    static final w f343a;

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            f343a = new v();
        } else {
            f343a = new t();
        }
    }

    public static boolean a(KeyEvent keyEvent, int i) {
        return f343a.a(keyEvent.getMetaState(), i);
    }

    public static boolean a(KeyEvent keyEvent) {
        return f343a.b(keyEvent.getMetaState());
    }

    public static void b(KeyEvent keyEvent) {
        f343a.a(keyEvent);
    }
}
