package android.support.v4.widget;

import android.view.View;
import android.widget.PopupMenu;
/* loaded from: classes2.dex */
class PopupMenuCompatKitKat {
    PopupMenuCompatKitKat() {
    }

    public static View.OnTouchListener getDragToOpenListener(Object obj) {
        return ((PopupMenu) obj).getDragToOpenListener();
    }
}
