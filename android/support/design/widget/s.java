package android.support.design.widget;

import android.view.animation.Interpolator;
/* loaded from: classes2.dex */
class s {
    private final e ss;

    /* loaded from: classes2.dex */
    interface a {
        void b(s sVar);

        void c(s sVar);

        void d(s sVar);
    }

    /* loaded from: classes2.dex */
    interface c {
        void a(s sVar);
    }

    /* loaded from: classes2.dex */
    interface d {
        s cE();
    }

    /* loaded from: classes2.dex */
    static abstract class e {

        /* loaded from: classes2.dex */
        interface a {
            void cD();

            void onAnimationEnd();

            void onAnimationStart();
        }

        /* loaded from: classes2.dex */
        interface b {
            void cC();
        }

        abstract void a(a aVar);

        abstract void a(b bVar);

        abstract int cA();

        abstract float cB();

        abstract void cancel();

        abstract void e(float f, float f2);

        abstract void end();

        abstract float getAnimatedFraction();

        abstract long getDuration();

        abstract boolean isRunning();

        abstract void q(int i, int i2);

        abstract void setDuration(long j);

        abstract void setInterpolator(Interpolator interpolator);

        abstract void start();
    }

    /* loaded from: classes2.dex */
    static class b implements a {
        @Override // android.support.design.widget.s.a
        public void c(s sVar) {
        }

        @Override // android.support.design.widget.s.a
        public void b(s sVar) {
        }

        @Override // android.support.design.widget.s.a
        public void d(s sVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(e eVar) {
        this.ss = eVar;
    }

    public void start() {
        this.ss.start();
    }

    public boolean isRunning() {
        return this.ss.isRunning();
    }

    public void setInterpolator(Interpolator interpolator) {
        this.ss.setInterpolator(interpolator);
    }

    public void a(final c cVar) {
        if (cVar != null) {
            this.ss.a(new e.b() { // from class: android.support.design.widget.s.1
                @Override // android.support.design.widget.s.e.b
                public void cC() {
                    cVar.a(s.this);
                }
            });
        } else {
            this.ss.a((e.b) null);
        }
    }

    public void a(final a aVar) {
        if (aVar != null) {
            this.ss.a(new e.a() { // from class: android.support.design.widget.s.2
                @Override // android.support.design.widget.s.e.a
                public void onAnimationStart() {
                    aVar.c(s.this);
                }

                @Override // android.support.design.widget.s.e.a
                public void onAnimationEnd() {
                    aVar.b(s.this);
                }

                @Override // android.support.design.widget.s.e.a
                public void cD() {
                    aVar.d(s.this);
                }
            });
        } else {
            this.ss.a((e.a) null);
        }
    }

    public void q(int i, int i2) {
        this.ss.q(i, i2);
    }

    public int cA() {
        return this.ss.cA();
    }

    public void e(float f, float f2) {
        this.ss.e(f, f2);
    }

    public float cB() {
        return this.ss.cB();
    }

    public void setDuration(long j) {
        this.ss.setDuration(j);
    }

    public void cancel() {
        this.ss.cancel();
    }

    public float getAnimatedFraction() {
        return this.ss.getAnimatedFraction();
    }

    public void end() {
        this.ss.end();
    }

    public long getDuration() {
        return this.ss.getDuration();
    }
}
