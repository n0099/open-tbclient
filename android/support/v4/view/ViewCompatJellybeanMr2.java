package android.support.v4.view;

import android.graphics.Rect;
import android.view.View;
/* loaded from: classes2.dex */
class ViewCompatJellybeanMr2 {
    ViewCompatJellybeanMr2() {
    }

    public static Rect getClipBounds(View view2) {
        return view2.getClipBounds();
    }

    public static void setClipBounds(View view2, Rect rect) {
        view2.setClipBounds(rect);
    }

    public static boolean isInLayout(View view2) {
        return view2.isInLayout();
    }
}
