package android.support.v4.view;

import android.view.KeyEvent;
/* loaded from: classes.dex */
class e {
    public static boolean a(int i, int i2) {
        return KeyEvent.metaStateHasModifiers(i, i2);
    }

    public static boolean a(int i) {
        return KeyEvent.metaStateHasNoModifiers(i);
    }
}
