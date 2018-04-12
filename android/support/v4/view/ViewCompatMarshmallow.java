package android.support.v4.view;

import android.view.View;
/* loaded from: classes2.dex */
class ViewCompatMarshmallow {
    ViewCompatMarshmallow() {
    }

    public static void setScrollIndicators(View view2, int i) {
        view2.setScrollIndicators(i);
    }

    public static void setScrollIndicators(View view2, int i, int i2) {
        view2.setScrollIndicators(i, i2);
    }

    public static int getScrollIndicators(View view2) {
        return view2.getScrollIndicators();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void offsetTopAndBottom(View view2, int i) {
        view2.offsetTopAndBottom(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void offsetLeftAndRight(View view2, int i) {
        view2.offsetLeftAndRight(i);
    }
}
