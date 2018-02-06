package android.support.b;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class n implements r {
    q uS;

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
                this.uS = new o();
            } else if (Build.VERSION.SDK_INT >= 19) {
                this.uS = new t();
            } else {
                this.uS = new p();
            }
            this.uS.a(this);
        }
    }

    public n addListener(a aVar) {
        this.uS.a(aVar);
        return this;
    }

    public n addTarget(View view) {
        this.uS.H(view);
        return this;
    }

    public n addTarget(int i) {
        this.uS.T(i);
        return this;
    }

    @Override // android.support.b.r
    public Animator createAnimator(ViewGroup viewGroup, af afVar, af afVar2) {
        return null;
    }

    public n excludeChildren(View view, boolean z) {
        this.uS.b(view, z);
        return this;
    }

    public n excludeChildren(int i, boolean z) {
        this.uS.f(i, z);
        return this;
    }

    public n excludeChildren(Class cls, boolean z) {
        this.uS.a(cls, z);
        return this;
    }

    public n excludeTarget(View view, boolean z) {
        this.uS.c(view, z);
        return this;
    }

    public n excludeTarget(int i, boolean z) {
        this.uS.g(i, z);
        return this;
    }

    public n excludeTarget(Class cls, boolean z) {
        this.uS.b(cls, z);
        return this;
    }

    public long getDuration() {
        return this.uS.getDuration();
    }

    public n setDuration(long j) {
        this.uS.f(j);
        return this;
    }

    public TimeInterpolator getInterpolator() {
        return this.uS.getInterpolator();
    }

    public n setInterpolator(TimeInterpolator timeInterpolator) {
        this.uS.a(timeInterpolator);
        return this;
    }

    public String getName() {
        return this.uS.getName();
    }

    public long getStartDelay() {
        return this.uS.getStartDelay();
    }

    public n setStartDelay(long j) {
        this.uS.g(j);
        return this;
    }

    public List<Integer> getTargetIds() {
        return this.uS.getTargetIds();
    }

    public List<View> getTargets() {
        return this.uS.getTargets();
    }

    public String[] getTransitionProperties() {
        return this.uS.getTransitionProperties();
    }

    public af getTransitionValues(View view, boolean z) {
        return this.uS.getTransitionValues(view, z);
    }

    public n removeListener(a aVar) {
        this.uS.b(aVar);
        return this;
    }

    public n removeTarget(View view) {
        this.uS.I(view);
        return this;
    }

    public n removeTarget(int i) {
        this.uS.S(i);
        return this;
    }

    public String toString() {
        return this.uS.toString();
    }
}
