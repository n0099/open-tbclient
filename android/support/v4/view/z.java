package android.support.v4.view;

import android.os.Build;
import android.view.MotionEvent;
import com.tencent.mm.sdk.platformtools.Util;
/* loaded from: classes.dex */
public class z {

    /* renamed from: a  reason: collision with root package name */
    static final ac f326a;

    static {
        if (Build.VERSION.SDK_INT >= 5) {
            f326a = new ab();
        } else {
            f326a = new aa();
        }
    }

    public static int a(MotionEvent motionEvent) {
        return motionEvent.getAction() & Util.MASK_8BIT;
    }

    public static int b(MotionEvent motionEvent) {
        return (motionEvent.getAction() & 65280) >> 8;
    }

    public static int a(MotionEvent motionEvent, int i) {
        return f326a.a(motionEvent, i);
    }

    public static int b(MotionEvent motionEvent, int i) {
        return f326a.b(motionEvent, i);
    }

    public static float c(MotionEvent motionEvent, int i) {
        return f326a.c(motionEvent, i);
    }

    public static float d(MotionEvent motionEvent, int i) {
        return f326a.d(motionEvent, i);
    }

    public static int c(MotionEvent motionEvent) {
        return f326a.a(motionEvent);
    }
}
