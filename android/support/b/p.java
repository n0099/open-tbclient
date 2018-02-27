package android.support.b;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.support.b.z;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
class p extends q {
    z uS;
    r uT;
    private a uU;

    @Override // android.support.b.q
    public void a(r rVar, Object obj) {
        this.uT = rVar;
        if (obj == null) {
            this.uS = new b(rVar);
        } else {
            this.uS = (z) obj;
        }
    }

    @Override // android.support.b.q
    public q a(s sVar) {
        if (this.uU == null) {
            this.uU = new a();
            this.uS.a(this.uU);
        }
        this.uU.c(sVar);
        return this;
    }

    @Override // android.support.b.q
    public q b(s sVar) {
        if (this.uU != null) {
            this.uU.d(sVar);
            if (this.uU.isEmpty()) {
                this.uS.b(this.uU);
                this.uU = null;
            }
        }
        return this;
    }

    @Override // android.support.b.q
    public q H(View view) {
        this.uS.J(view);
        return this;
    }

    @Override // android.support.b.q
    public q T(int i) {
        this.uS.U(i);
        return this;
    }

    @Override // android.support.b.q
    public void captureEndValues(af afVar) {
        this.uS.captureEndValues(afVar);
    }

    @Override // android.support.b.q
    public void captureStartValues(af afVar) {
        this.uS.captureStartValues(afVar);
    }

    @Override // android.support.b.q
    public Animator createAnimator(ViewGroup viewGroup, af afVar, af afVar2) {
        return this.uS.createAnimator(viewGroup, afVar, afVar2);
    }

    @Override // android.support.b.q
    public q b(View view, boolean z) {
        this.uS.e(view, z);
        return this;
    }

    @Override // android.support.b.q
    public q f(int i, boolean z) {
        this.uS.i(i, z);
        return this;
    }

    @Override // android.support.b.q
    public q a(Class cls, boolean z) {
        this.uS.d(cls, z);
        return this;
    }

    @Override // android.support.b.q
    public q c(View view, boolean z) {
        this.uS.d(view, z);
        return this;
    }

    @Override // android.support.b.q
    public q g(int i, boolean z) {
        this.uS.h(i, z);
        return this;
    }

    @Override // android.support.b.q
    public q b(Class cls, boolean z) {
        this.uS.c(cls, z);
        return this;
    }

    @Override // android.support.b.q
    public long getDuration() {
        return this.uS.getDuration();
    }

    @Override // android.support.b.q
    public q f(long j) {
        this.uS.h(j);
        return this;
    }

    @Override // android.support.b.q
    public TimeInterpolator getInterpolator() {
        return this.uS.getInterpolator();
    }

    @Override // android.support.b.q
    public q a(TimeInterpolator timeInterpolator) {
        this.uS.b(timeInterpolator);
        return this;
    }

    @Override // android.support.b.q
    public String getName() {
        return this.uS.getName();
    }

    @Override // android.support.b.q
    public long getStartDelay() {
        return this.uS.getStartDelay();
    }

    @Override // android.support.b.q
    public q g(long j) {
        this.uS.i(j);
        return this;
    }

    @Override // android.support.b.q
    public List<Integer> getTargetIds() {
        return this.uS.getTargetIds();
    }

    @Override // android.support.b.q
    public List<View> getTargets() {
        return this.uS.getTargets();
    }

    @Override // android.support.b.q
    public String[] getTransitionProperties() {
        return this.uS.getTransitionProperties();
    }

    @Override // android.support.b.q
    public af getTransitionValues(View view, boolean z) {
        return this.uS.getTransitionValues(view, z);
    }

    @Override // android.support.b.q
    public q I(View view) {
        this.uS.K(view);
        return this;
    }

    @Override // android.support.b.q
    public q S(int i) {
        this.uS.V(i);
        return this;
    }

    public String toString() {
        return this.uS.toString();
    }

    /* loaded from: classes2.dex */
    private static class b extends z {
        private r uW;

        public b(r rVar) {
            this.uW = rVar;
        }

        @Override // android.support.b.z
        public void captureStartValues(af afVar) {
            this.uW.captureStartValues(afVar);
        }

        @Override // android.support.b.z
        public void captureEndValues(af afVar) {
            this.uW.captureEndValues(afVar);
        }

        @Override // android.support.b.z
        public Animator createAnimator(ViewGroup viewGroup, af afVar, af afVar2) {
            return this.uW.createAnimator(viewGroup, afVar, afVar2);
        }
    }

    /* loaded from: classes2.dex */
    private class a implements z.c {
        private final ArrayList<s> sA = new ArrayList<>();

        a() {
        }

        public void c(s sVar) {
            this.sA.add(sVar);
        }

        public void d(s sVar) {
            this.sA.remove(sVar);
        }

        public boolean isEmpty() {
            return this.sA.isEmpty();
        }

        @Override // android.support.b.z.c
        public void d(z zVar) {
            Iterator<s> it = this.sA.iterator();
            while (it.hasNext()) {
                it.next().b(p.this.uT);
            }
        }

        @Override // android.support.b.z.c
        public void a(z zVar) {
            Iterator<s> it = this.sA.iterator();
            while (it.hasNext()) {
                it.next().c(p.this.uT);
            }
        }

        @Override // android.support.b.z.c
        public void b(z zVar) {
            Iterator<s> it = this.sA.iterator();
            while (it.hasNext()) {
                it.next().e(p.this.uT);
            }
        }

        @Override // android.support.b.z.c
        public void c(z zVar) {
            Iterator<s> it = this.sA.iterator();
            while (it.hasNext()) {
                it.next().f(p.this.uT);
            }
        }
    }
}
