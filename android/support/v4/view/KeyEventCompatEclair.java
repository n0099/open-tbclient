package android.support.v4.view;

import android.view.KeyEvent;
/* loaded from: classes.dex */
class KeyEventCompatEclair {
    KeyEventCompatEclair() {
    }

    public static void startTracking(KeyEvent keyEvent) {
        keyEvent.startTracking();
    }

    public static boolean isTracking(KeyEvent keyEvent) {
        return keyEvent.isTracking();
    }
}
