package android.support.b;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class n implements r {
    q uR;

    /* loaded from: classes2.dex */
    public interface a extends s<n> {
    }

    @Override // android.support.b.r
    public abstract void captureEndValues(af afVar);

    @Override // android.support.b.r
    public abstract void captureStartValues(af afVar);

    public n() {
        this(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(boolean z) {
        if (!z) {
            if (Build.VERSION.SDK_INT >= 23) {
                this.uR = new o();
            } else if (Build.VERSION.SDK_INT >= 19) {
                this.uR = new t();
            } else {
                this.uR = new p();
            }
            this.uR.a(this);
        }
    }

    public n addListener(a aVar) {
        this.uR.a(aVar);
        return this;
    }

    public n addTarget(View view) {
        this.uR.H(view);
        return this;
    }

    public n addTarget(int i) {
        this.uR.T(i);
        return this;
    }

    @Override // android.support.b.r
    public Animator createAnimator(ViewGroup viewGroup, af afVar, af afVar2) {
        return null;
    }

    public n excludeChildren(View view, boolean z) {
        this.uR.b(view, z);
        return this;
    }

    public n excludeChildren(int i, boolean z) {
        this.uR.f(i, z);
        return this;
    }

    public n excludeChildren(Class cls, boolean z) {
        this.uR.a(cls, z);
        return this;
    }

    public n excludeTarget(View view, boolean z) {
        this.uR.c(view, z);
        return this;
    }

    public n excludeTarget(int i, boolean z) {
        this.uR.g(i, z);
        return this;
    }

    public n excludeTarget(Class cls, boolean z) {
        this.uR.b(cls, z);
        return this;
    }

    public long getDuration() {
        return this.uR.getDuration();
    }

    public n setDuration(long j) {
        this.uR.f(j);
        return this;
    }

    public TimeInterpolator getInterpolator() {
        return this.uR.getInterpolator();
    }

    public n setInterpolator(TimeInterpolator timeInterpolator) {
        this.uR.a(timeInterpolator);
        return this;
    }

    public String getName() {
        return this.uR.getName();
    }

    public long getStartDelay() {
        return this.uR.getStartDelay();
    }

    public n setStartDelay(long j) {
        this.uR.g(j);
        return this;
    }

    public List<Integer> getTargetIds() {
        return this.uR.getTargetIds();
    }

    public List<View> getTargets() {
        return this.uR.getTargets();
    }

    public String[] getTransitionProperties() {
        return this.uR.getTransitionProperties();
    }

    public af getTransitionValues(View view, boolean z) {
        return this.uR.getTransitionValues(view, z);
    }

    public n removeListener(a aVar) {
        this.uR.b(aVar);
        return this;
    }

    public n removeTarget(View view) {
        this.uR.I(view);
        return this;
    }

    public n removeTarget(int i) {
        this.uR.S(i);
        return this;
    }

    public String toString() {
        return this.uR.toString();
    }
}
