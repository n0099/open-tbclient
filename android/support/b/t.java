package android.support.b;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
class t extends q {
    r uU;
    Transition uY;
    private a uZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(TransitionValues transitionValues, af afVar) {
        if (transitionValues != null) {
            afVar.view = transitionValues.view;
            if (transitionValues.values.size() > 0) {
                afVar.values.putAll(transitionValues.values);
            }
        }
    }

    static void a(af afVar, TransitionValues transitionValues) {
        if (afVar != null) {
            transitionValues.view = afVar.view;
            if (afVar.values.size() > 0) {
                transitionValues.values.putAll(afVar.values);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(r rVar, TransitionValues transitionValues) {
        af afVar = new af();
        a(transitionValues, afVar);
        rVar.captureStartValues(afVar);
        a(afVar, transitionValues);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(r rVar, TransitionValues transitionValues) {
        af afVar = new af();
        a(transitionValues, afVar);
        rVar.captureEndValues(afVar);
        a(afVar, transitionValues);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static af a(TransitionValues transitionValues) {
        if (transitionValues == null) {
            return null;
        }
        af afVar = new af();
        a(transitionValues, afVar);
        return afVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TransitionValues c(af afVar) {
        if (afVar == null) {
            return null;
        }
        TransitionValues transitionValues = new TransitionValues();
        a(afVar, transitionValues);
        return transitionValues;
    }

    @Override // android.support.b.q
    public void a(r rVar, Object obj) {
        this.uU = rVar;
        if (obj == null) {
            this.uY = new b(rVar);
        } else {
            this.uY = (Transition) obj;
        }
    }

    @Override // android.support.b.q
    public q a(s sVar) {
        if (this.uZ == null) {
            this.uZ = new a();
            this.uY.addListener(this.uZ);
        }
        this.uZ.c(sVar);
        return this;
    }

    @Override // android.support.b.q
    public q b(s sVar) {
        if (this.uZ != null) {
            this.uZ.d(sVar);
            if (this.uZ.isEmpty()) {
                this.uY.removeListener(this.uZ);
                this.uZ = null;
            }
        }
        return this;
    }

    @Override // android.support.b.q
    public q H(View view) {
        this.uY.addTarget(view);
        return this;
    }

    @Override // android.support.b.q
    public q T(int i) {
        this.uY.addTarget(i);
        return this;
    }

    @Override // android.support.b.q
    public void captureEndValues(af afVar) {
        TransitionValues transitionValues = new TransitionValues();
        a(afVar, transitionValues);
        this.uY.captureEndValues(transitionValues);
        a(transitionValues, afVar);
    }

    @Override // android.support.b.q
    public void captureStartValues(af afVar) {
        TransitionValues transitionValues = new TransitionValues();
        a(afVar, transitionValues);
        this.uY.captureStartValues(transitionValues);
        a(transitionValues, afVar);
    }

    @Override // android.support.b.q
    public Animator createAnimator(ViewGroup viewGroup, af afVar, af afVar2) {
        TransitionValues transitionValues;
        TransitionValues transitionValues2 = null;
        if (afVar != null) {
            transitionValues = new TransitionValues();
            a(afVar, transitionValues);
        } else {
            transitionValues = null;
        }
        if (afVar2 != null) {
            transitionValues2 = new TransitionValues();
            a(afVar2, transitionValues2);
        }
        return this.uY.createAnimator(viewGroup, transitionValues, transitionValues2);
    }

    @Override // android.support.b.q
    public q b(View view, boolean z) {
        this.uY.excludeChildren(view, z);
        return this;
    }

    @Override // android.support.b.q
    public q f(int i, boolean z) {
        this.uY.excludeChildren(i, z);
        return this;
    }

    @Override // android.support.b.q
    public q a(Class cls, boolean z) {
        this.uY.excludeChildren(cls, z);
        return this;
    }

    @Override // android.support.b.q
    public q c(View view, boolean z) {
        this.uY.excludeTarget(view, z);
        return this;
    }

    @Override // android.support.b.q
    public q g(int i, boolean z) {
        this.uY.excludeTarget(i, z);
        return this;
    }

    @Override // android.support.b.q
    public q b(Class cls, boolean z) {
        this.uY.excludeTarget(cls, z);
        return this;
    }

    @Override // android.support.b.q
    public long getDuration() {
        return this.uY.getDuration();
    }

    @Override // android.support.b.q
    public q f(long j) {
        this.uY.setDuration(j);
        return this;
    }

    @Override // android.support.b.q
    public TimeInterpolator getInterpolator() {
        return this.uY.getInterpolator();
    }

    @Override // android.support.b.q
    public q a(TimeInterpolator timeInterpolator) {
        this.uY.setInterpolator(timeInterpolator);
        return this;
    }

    @Override // android.support.b.q
    public String getName() {
        return this.uY.getName();
    }

    @Override // android.support.b.q
    public long getStartDelay() {
        return this.uY.getStartDelay();
    }

    @Override // android.support.b.q
    public q g(long j) {
        this.uY.setStartDelay(j);
        return this;
    }

    @Override // android.support.b.q
    public List<Integer> getTargetIds() {
        return this.uY.getTargetIds();
    }

    @Override // android.support.b.q
    public List<View> getTargets() {
        return this.uY.getTargets();
    }

    @Override // android.support.b.q
    public String[] getTransitionProperties() {
        return this.uY.getTransitionProperties();
    }

    @Override // android.support.b.q
    public af getTransitionValues(View view, boolean z) {
        af afVar = new af();
        a(this.uY.getTransitionValues(view, z), afVar);
        return afVar;
    }

    @Override // android.support.b.q
    public q I(View view) {
        this.uY.removeTarget(view);
        return this;
    }

    @Override // android.support.b.q
    public q S(int i) {
        if (i > 0) {
            getTargetIds().remove(Integer.valueOf(i));
        }
        return this;
    }

    public String toString() {
        return this.uY.toString();
    }

    /* loaded from: classes2.dex */
    private static class b extends Transition {
        private r uX;

        public b(r rVar) {
            this.uX = rVar;
        }

        @Override // android.transition.Transition
        public void captureStartValues(TransitionValues transitionValues) {
            t.a(this.uX, transitionValues);
        }

        @Override // android.transition.Transition
        public void captureEndValues(TransitionValues transitionValues) {
            t.b(this.uX, transitionValues);
        }

        @Override // android.transition.Transition
        public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
            return this.uX.createAnimator(viewGroup, t.a(transitionValues), t.a(transitionValues2));
        }
    }

    /* loaded from: classes2.dex */
    private class a implements Transition.TransitionListener {
        private final ArrayList<s> sB = new ArrayList<>();

        a() {
        }

        void c(s sVar) {
            this.sB.add(sVar);
        }

        void d(s sVar) {
            this.sB.remove(sVar);
        }

        boolean isEmpty() {
            return this.sB.isEmpty();
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
            Iterator<s> it = this.sB.iterator();
            while (it.hasNext()) {
                it.next().b(t.this.uU);
            }
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            Iterator<s> it = this.sB.iterator();
            while (it.hasNext()) {
                it.next().c(t.this.uU);
            }
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
            Iterator<s> it = this.sB.iterator();
            while (it.hasNext()) {
                it.next().d(t.this.uU);
            }
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
            Iterator<s> it = this.sB.iterator();
            while (it.hasNext()) {
                it.next().e(t.this.uU);
            }
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
            Iterator<s> it = this.sB.iterator();
            while (it.hasNext()) {
                it.next().f(t.this.uU);
            }
        }
    }
}
