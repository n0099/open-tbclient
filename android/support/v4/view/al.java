package android.support.v4.view;

import android.os.Build;
import android.view.VelocityTracker;
/* loaded from: classes.dex */
public class al {

    /* renamed from: a  reason: collision with root package name */
    static final ao f331a;

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            f331a = new an();
        } else {
            f331a = new am();
        }
    }

    public static float a(VelocityTracker velocityTracker, int i) {
        return f331a.a(velocityTracker, i);
    }

    public static float b(VelocityTracker velocityTracker, int i) {
        return f331a.b(velocityTracker, i);
    }
}
