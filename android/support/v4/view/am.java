package android.support.v4.view;

import android.view.VelocityTracker;
/* loaded from: classes.dex */
class am implements ao {
    @Override // android.support.v4.view.ao
    public float a(VelocityTracker velocityTracker, int i) {
        return velocityTracker.getXVelocity();
    }

    @Override // android.support.v4.view.ao
    public float b(VelocityTracker velocityTracker, int i) {
        return velocityTracker.getYVelocity();
    }
}
