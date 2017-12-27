package android.support.v4.view;

import android.view.View;
/* loaded from: classes2.dex */
class ViewCompatMarshmallow {
    public static void setScrollIndicators(View view, int i) {
        view.setScrollIndicators(i);
    }

    public static void setScrollIndicators(View view, int i, int i2) {
        view.setScrollIndicators(i, i2);
    }

    public static int getScrollIndicators(View view) {
        return view.getScrollIndicators();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void offsetTopAndBottom(View view, int i) {
        view.offsetTopAndBottom(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void offsetLeftAndRight(View view, int i) {
        view.offsetLeftAndRight(i);
    }
}
