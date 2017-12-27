package android.support.b;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
/* loaded from: classes2.dex */
abstract class q {
    public abstract q H(View view);

    public abstract q I(View view);

    public abstract q S(int i);

    public abstract q T(int i);

    public abstract q a(TimeInterpolator timeInterpolator);

    public abstract q a(s sVar);

    public abstract q a(Class cls, boolean z);

    public abstract void a(r rVar, Object obj);

    public abstract q b(s sVar);

    public abstract q b(View view, boolean z);

    public abstract q b(Class cls, boolean z);

    public abstract q c(int i, boolean z);

    public abstract q c(View view, boolean z);

    public abstract void captureEndValues(af afVar);

    public abstract void captureStartValues(af afVar);

    public abstract Animator createAnimator(ViewGroup viewGroup, af afVar, af afVar2);

    public abstract q d(int i, boolean z);

    public abstract q f(long j);

    public abstract q g(long j);

    public abstract long getDuration();

    public abstract TimeInterpolator getInterpolator();

    public abstract String getName();

    public abstract long getStartDelay();

    public abstract List<Integer> getTargetIds();

    public abstract List<View> getTargets();

    public abstract String[] getTransitionProperties();

    public abstract af getTransitionValues(View view, boolean z);

    public void a(r rVar) {
        a(rVar, (Object) null);
    }
}
