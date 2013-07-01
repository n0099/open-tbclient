package android.support.v4.view;

import android.os.Build;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class z {

    /* renamed from: a  reason: collision with root package name */
    static final ac f101a;

    static {
        if (Build.VERSION.SDK_INT >= 5) {
            f101a = new ab();
        } else {
            f101a = new aa();
        }
    }

    public static int a(MotionEvent motionEvent) {
        return motionEvent.getAction() & 255;
    }

    public static int b(MotionEvent motionEvent) {
        return (motionEvent.getAction() & 65280) >> 8;
    }

    public static int a(MotionEvent motionEvent, int i) {
        return f101a.a(motionEvent, i);
    }

    public static int b(MotionEvent motionEvent, int i) {
        return f101a.b(motionEvent, i);
    }

    public static float c(MotionEvent motionEvent, int i) {
        return f101a.c(motionEvent, i);
    }

    public static float d(MotionEvent motionEvent, int i) {
        return f101a.d(motionEvent, i);
    }

    public static int c(MotionEvent motionEvent) {
        return f101a.a(motionEvent);
    }
}
