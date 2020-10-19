package com.baidu.platform.comapi.map.b;

import android.os.Build;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.baidu.platform.comapi.map.b.a;
/* loaded from: classes7.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public final int f2911a;
    public final int b;
    private VelocityTracker c;

    public f() {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(com.baidu.platform.comapi.b.e());
        if (viewConfiguration == null) {
            this.b = ViewConfiguration.getMinimumFlingVelocity();
            this.f2911a = ViewConfiguration.getMaximumFlingVelocity();
            return;
        }
        this.b = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f2911a = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    public void a() {
        this.c = VelocityTracker.obtain();
    }

    public void a(MotionEvent motionEvent) {
        if (this.c == null) {
            this.c = VelocityTracker.obtain();
        } else {
            this.c.addMovement(motionEvent);
        }
    }

    public void b() {
        if (this.c != null) {
            this.c.recycle();
            this.c = null;
        }
    }

    public Pair<a.d, a.d> c() {
        float xVelocity;
        float yVelocity;
        float xVelocity2;
        float yVelocity2;
        if (this.c == null) {
            return new Pair<>(new a.d(0.0d, 0.0d), new a.d(0.0d, 0.0d));
        }
        this.c.computeCurrentVelocity(1000, this.f2911a);
        if (Build.VERSION.SDK_INT < 8) {
            xVelocity = this.c.getXVelocity();
            yVelocity = this.c.getYVelocity();
            xVelocity2 = this.c.getXVelocity();
            yVelocity2 = this.c.getYVelocity();
        } else {
            xVelocity = this.c.getXVelocity(0);
            yVelocity = this.c.getYVelocity(0);
            xVelocity2 = this.c.getXVelocity(1);
            yVelocity2 = this.c.getYVelocity(1);
        }
        return new Pair<>(new a.d(xVelocity, yVelocity), new a.d(xVelocity2, yVelocity2));
    }
}
