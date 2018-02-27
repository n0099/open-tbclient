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
    r uT;
    Transition uX;
    private a uY;

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
        this.uT = rVar;
        if (obj == null) {
            this.uX = new b(rVar);
        } else {
            this.uX = (Transition) obj;
        }
    }

    @Override // android.support.b.q
    public q a(s sVar) {
        if (this.uY == null) {
            this.uY = new a();
            this.uX.addListener(this.uY);
        }
        this.uY.c(sVar);
        return this;
    }

    @Override // android.support.b.q
    public q b(s sVar) {
        if (this.uY != null) {
            this.uY.d(sVar);
            if (this.uY.isEmpty()) {
                this.uX.removeListener(this.uY);
                this.uY = null;
            }
        }
        return this;
    }

    @Override // android.support.b.q
    public q H(View view) {
        this.uX.addTarget(view);
        return this;
    }

    @Override // android.support.b.q
    public q T(int i) {
        this.uX.addTarget(i);
        return this;
    }

    @Override // android.support.b.q
    public void captureEndValues(af afVar) {
        TransitionValues transitionValues = new TransitionValues();
        a(afVar, transitionValues);
        this.uX.captureEndValues(transitionValues);
        a(transitionValues, afVar);
    }

    @Override // android.support.b.q
    public void captureStartValues(af afVar) {
        TransitionValues transitionValues = new TransitionValues();
        a(afVar, transitionValues);
        this.uX.captureStartValues(transitionValues);
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
        return this.uX.createAnimator(viewGroup, transitionValues, transitionValues2);
    }

    @Override // android.support.b.q
    public q b(View view, boolean z) {
        this.uX.excludeChildren(view, z);
        return this;
    }

    @Override // android.support.b.q
    public q f(int i, boolean z) {
        this.uX.excludeChildren(i, z);
        return this;
    }

    @Override // android.support.b.q
    public q a(Class cls, boolean z) {
        this.uX.excludeChildren(cls, z);
        return this;
    }

    @Override // android.support.b.q
    public q c(View view, boolean z) {
        this.uX.excludeTarget(view, z);
        return this;
    }

    @Override // android.support.b.q
    public q g(int i, boolean z) {
        this.uX.excludeTarget(i, z);
        return this;
    }

    @Override // android.support.b.q
    public q b(Class cls, boolean z) {
        this.uX.excludeTarget(cls, z);
        return this;
    }

    @Override // android.support.b.q
    public long getDuration() {
        return this.uX.getDuration();
    }

    @Override // android.support.b.q
    public q f(long j) {
        this.uX.setDuration(j);
        return this;
    }

    @Override // android.support.b.q
    public TimeInterpolator getInterpolator() {
        return this.uX.getInterpolator();
    }

    @Override // android.support.b.q
    public q a(TimeInterpolator timeInterpolator) {
        this.uX.setInterpolator(timeInterpolator);
        return this;
    }

    @Override // android.support.b.q
    public String getName() {
        return this.uX.getName();
    }

    @Override // android.support.b.q
    public long getStartDelay() {
        return this.uX.getStartDelay();
    }

    @Override // android.support.b.q
    public q g(long j) {
        this.uX.setStartDelay(j);
        return this;
    }

    @Override // android.support.b.q
    public List<Integer> getTargetIds() {
        return this.uX.getTargetIds();
    }

    @Override // android.support.b.q
    public List<View> getTargets() {
        return this.uX.getTargets();
    }

    @Override // android.support.b.q
    public String[] getTransitionProperties() {
        return this.uX.getTransitionProperties();
    }

    @Override // android.support.b.q
    public af getTransitionValues(View view, boolean z) {
        af afVar = new af();
        a(this.uX.getTransitionValues(view, z), afVar);
        return afVar;
    }

    @Override // android.support.b.q
    public q I(View view) {
        this.uX.removeTarget(view);
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
        return this.uX.toString();
    }

    /* loaded from: classes2.dex */
    private static class b extends Transition {
        private r uW;

        public b(r rVar) {
            this.uW = rVar;
        }

        @Override // android.transition.Transition
        public void captureStartValues(TransitionValues transitionValues) {
            t.a(this.uW, transitionValues);
        }

        @Override // android.transition.Transition
        public void captureEndValues(TransitionValues transitionValues) {
            t.b(this.uW, transitionValues);
        }

        @Override // android.transition.Transition
        public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
            return this.uW.createAnimator(viewGroup, t.a(transitionValues), t.a(transitionValues2));
        }
    }

    /* loaded from: classes2.dex */
    private class a implements Transition.TransitionListener {
        private final ArrayList<s> sA = new ArrayList<>();

        a() {
        }

        void c(s sVar) {
            this.sA.add(sVar);
        }

        void d(s sVar) {
            this.sA.remove(sVar);
        }

        boolean isEmpty() {
            return this.sA.isEmpty();
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
            Iterator<s> it = this.sA.iterator();
            while (it.hasNext()) {
                it.next().b(t.this.uT);
            }
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            Iterator<s> it = this.sA.iterator();
            while (it.hasNext()) {
                it.next().c(t.this.uT);
            }
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
            Iterator<s> it = this.sA.iterator();
            while (it.hasNext()) {
                it.next().d(t.this.uT);
            }
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
            Iterator<s> it = this.sA.iterator();
            while (it.hasNext()) {
                it.next().e(t.this.uT);
            }
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
            Iterator<s> it = this.sA.iterator();
            while (it.hasNext()) {
                it.next().f(t.this.uT);
            }
        }
    }
}
