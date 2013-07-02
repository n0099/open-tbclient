package android.support.v4.view;

import android.os.Build;
import android.view.VelocityTracker;
/* loaded from: classes.dex */
public class al {
    static final ao a;

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            a = new an();
        } else {
            a = new am();
        }
    }

    public static float a(VelocityTracker velocityTracker, int i) {
        return a.a(velocityTracker, i);
    }

    public static float b(VelocityTracker velocityTracker, int i) {
        return a.b(velocityTracker, i);
    }
}
