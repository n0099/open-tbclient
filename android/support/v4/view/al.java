package android.support.v4.view;

import android.os.Build;
import android.view.VelocityTracker;
/* loaded from: classes.dex */
public class al {

    /* renamed from: a  reason: collision with root package name */
    static final ao f321a;

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            f321a = new an();
        } else {
            f321a = new am();
        }
    }

    public static float a(VelocityTracker velocityTracker, int i) {
        return f321a.a(velocityTracker, i);
    }

    public static float b(VelocityTracker velocityTracker, int i) {
        return f321a.b(velocityTracker, i);
    }
}
