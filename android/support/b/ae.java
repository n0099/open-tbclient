package android.support.b;

import android.animation.TimeInterpolator;
import android.support.annotation.RestrictTo;
import android.support.b.z;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
class ae extends z {
    int vH;
    ArrayList<z> vG = new ArrayList<>();
    boolean mStarted = false;
    private boolean vI = true;

    public ae aa(int i) {
        switch (i) {
            case 0:
                this.vI = true;
                break;
            case 1:
                this.vI = false;
                break;
            default:
                throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i);
        }
        return this;
    }

    public ae e(z zVar) {
        if (zVar != null) {
            this.vG.add(zVar);
            zVar.vs = this;
            if (this.mDuration >= 0) {
                zVar.h(this.mDuration);
            }
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.b.z
    /* renamed from: j */
    public ae h(long j) {
        super.h(j);
        if (this.mDuration >= 0) {
            int size = this.vG.size();
            for (int i = 0; i < size; i++) {
                this.vG.get(i).h(j);
            }
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.b.z
    /* renamed from: k */
    public ae i(long j) {
        return (ae) super.i(j);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.b.z
    /* renamed from: c */
    public ae b(TimeInterpolator timeInterpolator) {
        return (ae) super.b(timeInterpolator);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.b.z
    /* renamed from: N */
    public ae J(View view) {
        return (ae) super.J(view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.b.z
    /* renamed from: ab */
    public ae U(int i) {
        return (ae) super.U(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.b.z
    /* renamed from: c */
    public ae a(z.c cVar) {
        return (ae) super.a(cVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.b.z
    /* renamed from: ac */
    public ae V(int i) {
        return (ae) super.V(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.b.z
    /* renamed from: O */
    public ae K(View view) {
        return (ae) super.K(view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.b.z
    /* renamed from: d */
    public ae b(z.c cVar) {
        return (ae) super.b(cVar);
    }

    private void da() {
        a aVar = new a(this);
        Iterator<z> it = this.vG.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
        this.vH = this.vG.size();
    }

    @Override // android.support.b.z
    @RestrictTo
    protected void a(ViewGroup viewGroup, ag agVar, ag agVar2) {
        Iterator<z> it = this.vG.iterator();
        while (it.hasNext()) {
            it.next().a(viewGroup, agVar, agVar2);
        }
    }

    @Override // android.support.b.z
    @RestrictTo
    protected void cY() {
        if (this.vG.isEmpty()) {
            start();
            end();
            return;
        }
        da();
        if (!this.vI) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 >= this.vG.size()) {
                    break;
                }
                final z zVar = this.vG.get(i2);
                this.vG.get(i2 - 1).a(new z.d() { // from class: android.support.b.ae.1
                    @Override // android.support.b.z.d, android.support.b.z.c
                    public void a(z zVar2) {
                        zVar.cY();
                        zVar2.b(this);
                    }
                });
                i = i2 + 1;
            }
            z zVar2 = this.vG.get(0);
            if (zVar2 != null) {
                zVar2.cY();
                return;
            }
            return;
        }
        Iterator<z> it = this.vG.iterator();
        while (it.hasNext()) {
            it.next().cY();
        }
    }

    @Override // android.support.b.z
    public void captureStartValues(af afVar) {
        int id = afVar.view.getId();
        if (a(afVar.view, id)) {
            Iterator<z> it = this.vG.iterator();
            while (it.hasNext()) {
                z next = it.next();
                if (next.a(afVar.view, id)) {
                    next.captureStartValues(afVar);
                }
            }
        }
    }

    @Override // android.support.b.z
    public void captureEndValues(af afVar) {
        int id = afVar.view.getId();
        if (a(afVar.view, id)) {
            Iterator<z> it = this.vG.iterator();
            while (it.hasNext()) {
                z next = it.next();
                if (next.a(afVar.view, id)) {
                    next.captureEndValues(afVar);
                }
            }
        }
    }

    @Override // android.support.b.z
    @RestrictTo
    public void L(View view) {
        super.L(view);
        int size = this.vG.size();
        for (int i = 0; i < size; i++) {
            this.vG.get(i).L(view);
        }
    }

    @Override // android.support.b.z
    @RestrictTo
    public void M(View view) {
        super.M(view);
        int size = this.vG.size();
        for (int i = 0; i < size; i++) {
            this.vG.get(i).M(view);
        }
    }

    @Override // android.support.b.z
    String toString(String str) {
        String zVar = super.toString(str);
        int i = 0;
        while (i < this.vG.size()) {
            String str2 = zVar + "\n" + this.vG.get(i).toString(str + "  ");
            i++;
            zVar = str2;
        }
        return zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.b.z
    /* renamed from: db */
    public ae clone() {
        ae aeVar = (ae) super.clone();
        aeVar.vG = new ArrayList<>();
        int size = this.vG.size();
        for (int i = 0; i < size; i++) {
            aeVar.e(this.vG.get(i).clone());
        }
        return aeVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a extends z.d {
        ae vE;

        a(ae aeVar) {
            this.vE = aeVar;
        }

        @Override // android.support.b.z.d, android.support.b.z.c
        public void d(z zVar) {
            if (!this.vE.mStarted) {
                this.vE.start();
                this.vE.mStarted = true;
            }
        }

        @Override // android.support.b.z.d, android.support.b.z.c
        public void a(z zVar) {
            ae aeVar = this.vE;
            aeVar.vH--;
            if (this.vE.vH == 0) {
                this.vE.mStarted = false;
                this.vE.end();
            }
            zVar.b(this);
        }
    }
}
