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
    z uT;
    r uU;
    private a uV;

    @Override // android.support.b.q
    public void a(r rVar, Object obj) {
        this.uU = rVar;
        if (obj == null) {
            this.uT = new b(rVar);
        } else {
            this.uT = (z) obj;
        }
    }

    @Override // android.support.b.q
    public q a(s sVar) {
        if (this.uV == null) {
            this.uV = new a();
            this.uT.a(this.uV);
        }
        this.uV.c(sVar);
        return this;
    }

    @Override // android.support.b.q
    public q b(s sVar) {
        if (this.uV != null) {
            this.uV.d(sVar);
            if (this.uV.isEmpty()) {
                this.uT.b(this.uV);
                this.uV = null;
            }
        }
        return this;
    }

    @Override // android.support.b.q
    public q H(View view) {
        this.uT.J(view);
        return this;
    }

    @Override // android.support.b.q
    public q T(int i) {
        this.uT.U(i);
        return this;
    }

    @Override // android.support.b.q
    public void captureEndValues(af afVar) {
        this.uT.captureEndValues(afVar);
    }

    @Override // android.support.b.q
    public void captureStartValues(af afVar) {
        this.uT.captureStartValues(afVar);
    }

    @Override // android.support.b.q
    public Animator createAnimator(ViewGroup viewGroup, af afVar, af afVar2) {
        return this.uT.createAnimator(viewGroup, afVar, afVar2);
    }

    @Override // android.support.b.q
    public q b(View view, boolean z) {
        this.uT.e(view, z);
        return this;
    }

    @Override // android.support.b.q
    public q f(int i, boolean z) {
        this.uT.i(i, z);
        return this;
    }

    @Override // android.support.b.q
    public q a(Class cls, boolean z) {
        this.uT.d(cls, z);
        return this;
    }

    @Override // android.support.b.q
    public q c(View view, boolean z) {
        this.uT.d(view, z);
        return this;
    }

    @Override // android.support.b.q
    public q g(int i, boolean z) {
        this.uT.h(i, z);
        return this;
    }

    @Override // android.support.b.q
    public q b(Class cls, boolean z) {
        this.uT.c(cls, z);
        return this;
    }

    @Override // android.support.b.q
    public long getDuration() {
        return this.uT.getDuration();
    }

    @Override // android.support.b.q
    public q f(long j) {
        this.uT.h(j);
        return this;
    }

    @Override // android.support.b.q
    public TimeInterpolator getInterpolator() {
        return this.uT.getInterpolator();
    }

    @Override // android.support.b.q
    public q a(TimeInterpolator timeInterpolator) {
        this.uT.b(timeInterpolator);
        return this;
    }

    @Override // android.support.b.q
    public String getName() {
        return this.uT.getName();
    }

    @Override // android.support.b.q
    public long getStartDelay() {
        return this.uT.getStartDelay();
    }

    @Override // android.support.b.q
    public q g(long j) {
        this.uT.i(j);
        return this;
    }

    @Override // android.support.b.q
    public List<Integer> getTargetIds() {
        return this.uT.getTargetIds();
    }

    @Override // android.support.b.q
    public List<View> getTargets() {
        return this.uT.getTargets();
    }

    @Override // android.support.b.q
    public String[] getTransitionProperties() {
        return this.uT.getTransitionProperties();
    }

    @Override // android.support.b.q
    public af getTransitionValues(View view, boolean z) {
        return this.uT.getTransitionValues(view, z);
    }

    @Override // android.support.b.q
    public q I(View view) {
        this.uT.K(view);
        return this;
    }

    @Override // android.support.b.q
    public q S(int i) {
        this.uT.V(i);
        return this;
    }

    public String toString() {
        return this.uT.toString();
    }

    /* loaded from: classes2.dex */
    private static class b extends z {
        private r uX;

        public b(r rVar) {
            this.uX = rVar;
        }

        @Override // android.support.b.z
        public void captureStartValues(af afVar) {
            this.uX.captureStartValues(afVar);
        }

        @Override // android.support.b.z
        public void captureEndValues(af afVar) {
            this.uX.captureEndValues(afVar);
        }

        @Override // android.support.b.z
        public Animator createAnimator(ViewGroup viewGroup, af afVar, af afVar2) {
            return this.uX.createAnimator(viewGroup, afVar, afVar2);
        }
    }

    /* loaded from: classes2.dex */
    private class a implements z.c {
        private final ArrayList<s> sB = new ArrayList<>();

        a() {
        }

        public void c(s sVar) {
            this.sB.add(sVar);
        }

        public void d(s sVar) {
            this.sB.remove(sVar);
        }

        public boolean isEmpty() {
            return this.sB.isEmpty();
        }

        @Override // android.support.b.z.c
        public void d(z zVar) {
            Iterator<s> it = this.sB.iterator();
            while (it.hasNext()) {
                it.next().b(p.this.uU);
            }
        }

        @Override // android.support.b.z.c
        public void a(z zVar) {
            Iterator<s> it = this.sB.iterator();
            while (it.hasNext()) {
                it.next().c(p.this.uU);
            }
        }

        @Override // android.support.b.z.c
        public void b(z zVar) {
            Iterator<s> it = this.sB.iterator();
            while (it.hasNext()) {
                it.next().e(p.this.uU);
            }
        }

        @Override // android.support.b.z.c
        public void c(z zVar) {
            Iterator<s> it = this.sB.iterator();
            while (it.hasNext()) {
                it.next().f(p.this.uU);
            }
        }
    }
}
