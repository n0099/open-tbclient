package android.support.b;

import android.transition.TransitionSet;
/* loaded from: classes2.dex */
class ad extends t implements ac {
    private TransitionSet vE = new TransitionSet();

    public ad(r rVar) {
        a(rVar, this.vE);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.b.ac
    /* renamed from: Z */
    public ad Y(int i) {
        this.vE.setOrdering(i);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.b.ac
    /* renamed from: c */
    public ad b(q qVar) {
        this.vE.addTransition(((t) qVar).uX);
        return this;
    }
}
