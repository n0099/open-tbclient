package android.support.v4.view;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.view.View;
/* loaded from: classes.dex */
class az {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static long a() {
        return ValueAnimator.getFrameDelay();
    }

    public static void a(View view, int i, Paint paint) {
        view.setLayerType(i, paint);
    }

    public static int a(View view) {
        return view.getLayerType();
    }
}
