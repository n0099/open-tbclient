package android.support.v4.widget;

import android.view.View;
import android.widget.ListPopupWindow;
/* loaded from: classes2.dex */
class ListPopupWindowCompatKitKat {
    ListPopupWindowCompatKitKat() {
    }

    public static View.OnTouchListener createDragToOpenListener(Object obj, View view2) {
        return ((ListPopupWindow) obj).createDragToOpenListener(view2);
    }
}
