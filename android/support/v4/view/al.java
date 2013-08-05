package android.support.v4.view;

import android.os.Build;
import android.view.VelocityTracker;
/* loaded from: classes.dex */
public class al {

    /* renamed from: a  reason: collision with root package name */
    static final ao f313a;

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            f313a = new an();
        } else {
            f313a = new am();
        }
    }

    public static float a(VelocityTracker velocityTracker, int i) {
        return f313a.a(velocityTracker, i);
    }

    public static float b(VelocityTracker velocityTracker, int i) {
        return f313a.b(velocityTracker, i);
    }
}
