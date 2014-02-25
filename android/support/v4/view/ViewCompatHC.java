package android.support.v4.view;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.view.View;
/* loaded from: classes.dex */
class ViewCompatHC {
    ViewCompatHC() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getFrameTime() {
        return ValueAnimator.getFrameDelay();
    }

    public static void setLayerType(View view, int i, Paint paint) {
        view.setLayerType(i, paint);
    }

    public static int getLayerType(View view) {
        return view.getLayerType();
    }
}
