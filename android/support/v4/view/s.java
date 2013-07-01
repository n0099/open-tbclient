package android.support.v4.view;

import android.os.Build;
import android.view.KeyEvent;
/* loaded from: classes.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    static final w f100a;

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            f100a = new v();
        } else {
            f100a = new t();
        }
    }

    public static boolean a(KeyEvent keyEvent, int i) {
        return f100a.a(keyEvent.getMetaState(), i);
    }

    public static boolean a(KeyEvent keyEvent) {
        return f100a.b(keyEvent.getMetaState());
    }

    public static void b(KeyEvent keyEvent) {
        f100a.a(keyEvent);
    }
}
