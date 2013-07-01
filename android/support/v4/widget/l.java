package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.EdgeEffect;
/* loaded from: classes.dex */
class l {
    public static Object a(Context context) {
        return new EdgeEffect(context);
    }

    public static void a(Object obj, int i, int i2) {
        ((EdgeEffect) obj).setSize(i, i2);
    }

    public static boolean a(Object obj) {
        return ((EdgeEffect) obj).isFinished();
    }

    public static void b(Object obj) {
        ((EdgeEffect) obj).finish();
    }

    public static boolean a(Object obj, float f) {
        ((EdgeEffect) obj).onPull(f);
        return true;
    }

    public static boolean c(Object obj) {
        EdgeEffect edgeEffect = (EdgeEffect) obj;
        edgeEffect.onRelease();
        return edgeEffect.isFinished();
    }

    public static boolean a(Object obj, Canvas canvas) {
        return ((EdgeEffect) obj).draw(canvas);
    }
}
