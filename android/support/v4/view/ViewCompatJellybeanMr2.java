package android.support.v4.view;

import android.graphics.Rect;
import android.view.View;
/* loaded from: classes2.dex */
class ViewCompatJellybeanMr2 {
    public static Rect getClipBounds(View view) {
        return view.getClipBounds();
    }

    public static void setClipBounds(View view, Rect rect) {
        view.setClipBounds(rect);
    }

    public static boolean isInLayout(View view) {
        return view.isInLayout();
    }
}
