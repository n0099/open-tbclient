package android.support.v4.view;

import android.os.Build;
import android.view.VelocityTracker;
/* loaded from: classes.dex */
public class m {
    static final p a;

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            a = new o();
        } else {
            a = new n();
        }
    }

    public static float a(VelocityTracker velocityTracker, int i) {
        return a.a(velocityTracker, i);
    }
}
