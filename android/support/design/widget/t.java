package android.support.design.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.design.widget.s;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import java.util.ArrayList;
/* loaded from: classes2.dex */
class t extends s.e {
    private static final Handler pM = new Handler(Looper.getMainLooper());
    private Interpolator mInterpolator;
    private long mStartTime;
    private ArrayList<s.e.a> sB;
    private ArrayList<s.e.b> sC;
    private boolean sx;
    private float sy;
    private final int[] sz = new int[2];
    private final float[] sA = new float[2];
    private long mDuration = 200;
    private final Runnable mRunnable = new Runnable() { // from class: android.support.design.widget.t.1
        @Override // java.lang.Runnable
        public void run() {
            t.this.update();
        }
    };

    @Override // android.support.design.widget.s.e
    public void start() {
        if (!this.sx) {
            if (this.mInterpolator == null) {
                this.mInterpolator = new AccelerateDecelerateInterpolator();
            }
            this.sx = true;
            this.sy = 0.0f;
            cF();
        }
    }

    final void cF() {
        this.mStartTime = SystemClock.uptimeMillis();
        cG();
        cH();
        pM.postDelayed(this.mRunnable, 10L);
    }

    @Override // android.support.design.widget.s.e
    public boolean isRunning() {
        return this.sx;
    }

    @Override // android.support.design.widget.s.e
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    @Override // android.support.design.widget.s.e
    public void a(s.e.a aVar) {
        if (this.sB == null) {
            this.sB = new ArrayList<>();
        }
        this.sB.add(aVar);
    }

    @Override // android.support.design.widget.s.e
    public void a(s.e.b bVar) {
        if (this.sC == null) {
            this.sC = new ArrayList<>();
        }
        this.sC.add(bVar);
    }

    @Override // android.support.design.widget.s.e
    public void q(int i, int i2) {
        this.sz[0] = i;
        this.sz[1] = i2;
    }

    @Override // android.support.design.widget.s.e
    public int cA() {
        return a.b(this.sz[0], this.sz[1], getAnimatedFraction());
    }

    @Override // android.support.design.widget.s.e
    public void e(float f, float f2) {
        this.sA[0] = f;
        this.sA[1] = f2;
    }

    @Override // android.support.design.widget.s.e
    public float cB() {
        return a.b(this.sA[0], this.sA[1], getAnimatedFraction());
    }

    @Override // android.support.design.widget.s.e
    public void setDuration(long j) {
        this.mDuration = j;
    }

    @Override // android.support.design.widget.s.e
    public void cancel() {
        this.sx = false;
        pM.removeCallbacks(this.mRunnable);
        cI();
        cJ();
    }

    @Override // android.support.design.widget.s.e
    public float getAnimatedFraction() {
        return this.sy;
    }

    @Override // android.support.design.widget.s.e
    public void end() {
        if (this.sx) {
            this.sx = false;
            pM.removeCallbacks(this.mRunnable);
            this.sy = 1.0f;
            cG();
            cJ();
        }
    }

    @Override // android.support.design.widget.s.e
    public long getDuration() {
        return this.mDuration;
    }

    final void update() {
        if (this.sx) {
            float constrain = m.constrain(((float) (SystemClock.uptimeMillis() - this.mStartTime)) / ((float) this.mDuration), 0.0f, 1.0f);
            if (this.mInterpolator != null) {
                constrain = this.mInterpolator.getInterpolation(constrain);
            }
            this.sy = constrain;
            cG();
            if (SystemClock.uptimeMillis() >= this.mStartTime + this.mDuration) {
                this.sx = false;
                cJ();
            }
        }
        if (this.sx) {
            pM.postDelayed(this.mRunnable, 10L);
        }
    }

    private void cG() {
        if (this.sC != null) {
            int size = this.sC.size();
            for (int i = 0; i < size; i++) {
                this.sC.get(i).cC();
            }
        }
    }

    private void cH() {
        if (this.sB != null) {
            int size = this.sB.size();
            for (int i = 0; i < size; i++) {
                this.sB.get(i).onAnimationStart();
            }
        }
    }

    private void cI() {
        if (this.sB != null) {
            int size = this.sB.size();
            for (int i = 0; i < size; i++) {
                this.sB.get(i).cD();
            }
        }
    }

    private void cJ() {
        if (this.sB != null) {
            int size = this.sB.size();
            for (int i = 0; i < size; i++) {
                this.sB.get(i).onAnimationEnd();
            }
        }
    }
}
