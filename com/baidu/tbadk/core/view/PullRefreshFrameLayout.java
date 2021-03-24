package com.baidu.tbadk.core.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.ContinuousAnimationView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class PullRefreshFrameLayout extends FrameLayout {
    public static final int A = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds144);
    public static final int B = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds210);
    public static final int C;
    public static final int D;
    public static final int E;
    public static final int F;
    public static final int G;
    public static final float H;
    public static final float I;

    /* renamed from: e  reason: collision with root package name */
    public boolean f13464e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f13465f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f13466g;

    /* renamed from: h  reason: collision with root package name */
    public int f13467h;
    public double i;
    public int j;
    public int k;
    public boolean l;
    public boolean m;
    public int n;
    public int o;
    public float p;
    public boolean q;
    public boolean r;
    public ContinuousAnimationView s;
    public FrameLayout.LayoutParams t;
    public i u;
    public h v;
    public f w;
    public g x;
    public ValueAnimator y;
    public final Animator.AnimatorListener z;

    /* loaded from: classes3.dex */
    public class a implements Animator.AnimatorListener {
        public a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            if (PullRefreshFrameLayout.this.r) {
                return;
            }
            PullRefreshFrameLayout.this.r = true;
            PullRefreshFrameLayout.this.s.setMinAndMaxFrame(19, 42);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            PullRefreshFrameLayout.this.t.topMargin = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
            PullRefreshFrameLayout.this.s.setLayoutParams(PullRefreshFrameLayout.this.t);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Animator.AnimatorListener {
        public c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (PullRefreshFrameLayout.this.v != null) {
                PullRefreshFrameLayout.this.v.m();
            }
            PullRefreshFrameLayout.this.s.playAnimation();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (PullRefreshFrameLayout.this.x != null) {
                PullRefreshFrameLayout.this.x.onLoadingStart();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f13471e;

        public d(int i) {
            this.f13471e = i;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            double d2 = floatValue;
            Double.isNaN(d2);
            int i = (((float) (d2 * 0.3d)) > 0.0f ? 1 : (((float) (d2 * 0.3d)) == 0.0f ? 0 : -1));
            PullRefreshFrameLayout.this.s.setAlpha(floatValue);
            PullRefreshFrameLayout.this.t.topMargin = (int) (this.f13471e * floatValue);
            PullRefreshFrameLayout.this.s.setLayoutParams(PullRefreshFrameLayout.this.t);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Animator.AnimatorListener {
        public e() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            PullRefreshFrameLayout.this.t.topMargin = -PullRefreshFrameLayout.A;
            PullRefreshFrameLayout.this.s.setLayoutParams(PullRefreshFrameLayout.this.t);
            PullRefreshFrameLayout.this.s.cancelAnimation();
            PullRefreshFrameLayout.this.s.setFrame(0);
            PullRefreshFrameLayout.this.s.setMinAndMaxProgress(0.0f, 1.0f);
            PullRefreshFrameLayout.this.s.setAlpha(1.0f);
            PullRefreshFrameLayout.this.s.loop(false);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes3.dex */
    public interface f {
        void onCancel();
    }

    /* loaded from: classes3.dex */
    public interface g {
        void onLoadingStart();
    }

    /* loaded from: classes3.dex */
    public interface h {
        void m();
    }

    /* loaded from: classes3.dex */
    public interface i {
        void o();

        void p(double d2);

        void q(int i, double d2);
    }

    static {
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
        C = dimensionPixelSize;
        int i2 = B;
        int i3 = A;
        D = i2 + i3;
        E = dimensionPixelSize + i3;
        F = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds135);
        int dimensionPixelSize2 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds230);
        G = dimensionPixelSize2;
        double d2 = F;
        Double.isNaN(d2);
        double d3 = B;
        Double.isNaN(d3);
        H = (float) ((d2 * 1.0d) / d3);
        double d4 = dimensionPixelSize2;
        Double.isNaN(d4);
        double d5 = C;
        Double.isNaN(d5);
        I = (float) ((d4 * 1.0d) / d5);
    }

    public PullRefreshFrameLayout(Context context) {
        super(context);
        this.f13464e = false;
        this.f13465f = false;
        this.f13466g = false;
        this.l = false;
        this.m = true;
        this.n = D;
        this.o = F;
        this.p = H;
        this.r = false;
        this.z = new a();
        m();
    }

    public void h() {
        this.s.bringToFront();
    }

    public void i() {
        if (this.l) {
            l();
        }
    }

    public final void j(int i2) {
        int i3 = this.t.topMargin + i2;
        int i4 = this.n;
        int i5 = A;
        if (i3 > i4 - i5) {
            i3 = i4 - i5;
        } else if (i3 < (-i5)) {
            i3 = -i5;
        }
        FrameLayout.LayoutParams layoutParams = this.t;
        layoutParams.topMargin = i3;
        this.s.setLayoutParams(layoutParams);
        int i6 = this.f13467h + i2;
        this.f13467h = i6;
        int i7 = this.n;
        if (i6 > i7) {
            this.f13467h = i7;
        } else if (i6 < 0) {
            this.f13467h = 0;
        }
        double d2 = this.f13467h;
        Double.isNaN(d2);
        double d3 = this.n;
        Double.isNaN(d3);
        double d4 = (d2 * 1.0d) / d3;
        this.i = d4;
        i iVar = this.u;
        if (iVar != null) {
            iVar.p(d4);
        }
    }

    public final void k() {
        if (this.i >= this.p) {
            this.l = true;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(this.t.topMargin, this.o);
            this.y = ofFloat;
            ofFloat.setDuration(150L);
            this.y.addUpdateListener(new b());
            this.y.addListener(new c());
            this.y.start();
            i iVar = this.u;
            int i2 = this.t.topMargin;
            int i3 = this.o;
            int i4 = i2 - i3;
            double d2 = i3;
            Double.isNaN(d2);
            double d3 = i2;
            Double.isNaN(d3);
            iVar.q(i4, (d2 * 1.0d) / d3);
            return;
        }
        p();
    }

    public final void l() {
        this.l = false;
        if (this.t.topMargin <= (-A)) {
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.y = ofFloat;
        ofFloat.setDuration(300L);
        this.y.addUpdateListener(new d(this.t.topMargin));
        this.y.addListener(new e());
        this.y.start();
    }

    public final void m() {
        this.s = new ContinuousAnimationView(getContext());
        int i2 = A;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i2, i2);
        this.t = layoutParams;
        layoutParams.gravity = 49;
        layoutParams.topMargin = -A;
        this.s.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.s, this.t);
        this.s.bringToFront();
        this.s.setMinAndMaxProgress(0.0f, 1.0f);
        this.s.setSpeed(1.3f);
        this.s.setAnimation(R.raw.lottie_frs_refresh);
    }

    public boolean n() {
        return this.m;
    }

    public boolean o() {
        return this.l;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0021, code lost:
        if (r7 != 3) goto L12;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!this.l && this.m) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        int i2 = y - this.k;
                        int i3 = x - this.j;
                        if (!this.f13464e) {
                            if (!this.f13465f) {
                                if (this.f13466g) {
                                    if (i2 > 0 && Math.abs(i2) > Math.abs(i3)) {
                                        this.f13465f = false;
                                        this.f13464e = true;
                                    } else if (i2 < 0) {
                                        this.f13465f = true;
                                        this.f13464e = false;
                                    }
                                } else {
                                    this.f13465f = true;
                                    this.f13464e = false;
                                }
                            }
                        }
                        z = true;
                    }
                }
                s();
            } else {
                this.f13464e = false;
                this.f13465f = false;
                this.k = y;
                this.j = x;
            }
            this.k = y;
            this.j = x;
        }
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001a, code lost:
        if (r6 != 3) goto L9;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        f fVar;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        this.q = false;
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    int i2 = y - this.k;
                    if (i2 > 0) {
                        this.q = true;
                    }
                    j(i2);
                    this.k = y;
                    this.j = x;
                }
            } else if (this.i < this.p && (fVar = this.w) != null) {
                fVar.onCancel();
            }
            k();
            s();
        } else {
            this.k = y;
            this.j = x;
        }
        return true;
    }

    public void p() {
        l();
        i iVar = this.u;
        if (iVar != null) {
            iVar.o();
        }
    }

    public void q() {
        ContinuousAnimationView continuousAnimationView = this.s;
        if (continuousAnimationView != null) {
            continuousAnimationView.clearAnimation();
        }
        ValueAnimator valueAnimator = this.y;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.y.removeAllListeners();
            this.y.removeAllUpdateListeners();
            this.y = null;
        }
        this.u = null;
        this.v = null;
        this.w = null;
    }

    public void r() {
        ContinuousAnimationView continuousAnimationView;
        if (!this.q || (continuousAnimationView = this.s) == null) {
            return;
        }
        continuousAnimationView.setAlpha((float) this.i);
        this.s.setFrame((int) (this.i * 10.0d));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public final void s() {
        this.i = 0.0d;
        this.k = 0;
        this.j = 0;
        this.f13467h = 0;
        this.f13464e = false;
        this.f13465f = false;
    }

    public void setEnable(boolean z) {
        this.m = z;
    }

    public void setFromFrs() {
        this.n = E;
        this.o = G;
        this.p = I;
    }

    public void setInterceptScrollDown(boolean z) {
        this.f13466g = z;
    }

    public void setOnCancelCallBack(f fVar) {
        this.w = fVar;
    }

    public void setOnLoadingStartCallback(g gVar) {
        this.x = gVar;
    }

    public void setOnPullRefreshListener(h hVar) {
        this.v = hVar;
    }

    public void setOnTouchCallback(i iVar) {
        this.u = iVar;
    }

    public void setRefreshing(boolean z) {
        if (z && this.m) {
            FrameLayout.LayoutParams layoutParams = this.t;
            layoutParams.topMargin = this.o;
            this.s.setLayoutParams(layoutParams);
            this.r = false;
            this.s.loop(true);
            this.s.setMinFrame(10);
            this.s.setRepeatMode(1);
            this.s.removeAllAnimatorListeners();
            this.s.addAnimatorListener(this.z);
            this.s.playAnimation();
            return;
        }
        l();
    }

    public PullRefreshFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13464e = false;
        this.f13465f = false;
        this.f13466g = false;
        this.l = false;
        this.m = true;
        this.n = D;
        this.o = F;
        this.p = H;
        this.r = false;
        this.z = new a();
        m();
    }

    public PullRefreshFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f13464e = false;
        this.f13465f = false;
        this.f13466g = false;
        this.l = false;
        this.m = true;
        this.n = D;
        this.o = F;
        this.p = H;
        this.r = false;
        this.z = new a();
        m();
    }
}
