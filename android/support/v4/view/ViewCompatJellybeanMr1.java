package android.support.v4.view;

import android.graphics.Paint;
import android.view.Display;
import android.view.View;
/* loaded from: classes2.dex */
class ViewCompatJellybeanMr1 {
    ViewCompatJellybeanMr1() {
    }

    public static int getLabelFor(View view2) {
        return view2.getLabelFor();
    }

    public static void setLabelFor(View view2, int i) {
        view2.setLabelFor(i);
    }

    public static void setLayerPaint(View view2, Paint paint) {
        view2.setLayerPaint(paint);
    }

    public static int getLayoutDirection(View view2) {
        return view2.getLayoutDirection();
    }

    public static void setLayoutDirection(View view2, int i) {
        view2.setLayoutDirection(i);
    }

    public static int getPaddingStart(View view2) {
        return view2.getPaddingStart();
    }

    public static int getPaddingEnd(View view2) {
        return view2.getPaddingEnd();
    }

    public static void setPaddingRelative(View view2, int i, int i2, int i3, int i4) {
        view2.setPaddingRelative(i, i2, i3, i4);
    }

    public static int getWindowSystemUiVisibility(View view2) {
        return view2.getWindowSystemUiVisibility();
    }

    public static boolean isPaddingRelative(View view2) {
        return view2.isPaddingRelative();
    }

    public static Display getDisplay(View view2) {
        return view2.getDisplay();
    }
}
