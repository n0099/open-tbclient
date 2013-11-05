package android.support.v4.view;

import android.os.Build;
import android.view.MotionEvent;
import com.tencent.mm.sdk.platformtools.Util;
/* loaded from: classes.dex */
public class z {

    /* renamed from: a  reason: collision with root package name */
    static final ac f344a;

    static {
        if (Build.VERSION.SDK_INT >= 5) {
            f344a = new ab();
        } else {
            f344a = new aa();
        }
    }

    public static int a(MotionEvent motionEvent) {
        return motionEvent.getAction() & Util.MASK_8BIT;
    }

    public static int b(MotionEvent motionEvent) {
        return (motionEvent.getAction() & 65280) >> 8;
    }

    public static int a(MotionEvent motionEvent, int i) {
        return f344a.a(motionEvent, i);
    }

    public static int b(MotionEvent motionEvent, int i) {
        return f344a.b(motionEvent, i);
    }

    public static float c(MotionEvent motionEvent, int i) {
        return f344a.c(motionEvent, i);
    }

    public static float d(MotionEvent motionEvent, int i) {
        return f344a.d(motionEvent, i);
    }

    public static int c(MotionEvent motionEvent) {
        return f344a.a(motionEvent);
    }
}
