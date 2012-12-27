package android.support.v4.view;

import android.os.Build;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class f {
    static final i a;

    static {
        if (Build.VERSION.SDK_INT >= 5) {
            a = new h();
        } else {
            a = new g();
        }
    }

    public static int a(MotionEvent motionEvent) {
        return (motionEvent.getAction() & 65280) >> 8;
    }

    public static int a(MotionEvent motionEvent, int i) {
        return a.a(motionEvent, i);
    }

    public static int b(MotionEvent motionEvent, int i) {
        return a.b(motionEvent, i);
    }

    public static float c(MotionEvent motionEvent, int i) {
        return a.c(motionEvent, i);
    }

    public static float d(MotionEvent motionEvent, int i) {
        return a.d(motionEvent, i);
    }
}
