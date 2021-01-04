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
/* loaded from: classes.dex */
public class PullRefreshFrameLayout extends FrameLayout {
    private static final int fla = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds144);
    private static final int flb = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds210);
    private static final int flc = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    public static final int fld = flb + fla;
    public static final int fle = flc + fla;
    private static final int flf = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds135);
    private static final int flg = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds230);
    private static final float flh = (float) ((flf * 1.0d) / flb);
    private static final float fli = (float) ((flg * 1.0d) / flc);
    private int WX;
    private int dVw;
    private double drm;
    boolean flj;
    boolean flk;
    boolean fll;
    private int flm;
    private boolean fln;
    private int flo;
    private int flp;
    private float flq;
    private boolean flr;
    private boolean fls;
    private ContinuousAnimationView flt;
    private FrameLayout.LayoutParams flu;
    private d flv;
    private c flw;
    private a flx;
    private b fly;
    private ValueAnimator flz;
    private boolean isLoading;
    private final Animator.AnimatorListener loadViewAnimListener;

    /* loaded from: classes.dex */
    public interface a {
        void onCancel();
    }

    /* loaded from: classes.dex */
    public interface b {
        void bxK();
    }

    /* loaded from: classes.dex */
    public interface c {
        void bxL();
    }

    /* loaded from: classes.dex */
    public interface d {
        void b(int i, double d);

        void bxM();

        void w(double d);
    }

    public PullRefreshFrameLayout(Context context) {
        super(context);
        this.flj = false;
        this.flk = false;
        this.fll = false;
        this.isLoading = false;
        this.fln = true;
        this.flo = fld;
        this.flp = flf;
        this.flq = flh;
        this.fls = false;
        this.loadViewAnimListener = new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (!PullRefreshFrameLayout.this.fls) {
                    PullRefreshFrameLayout.this.fls = true;
                    PullRefreshFrameLayout.this.flt.setMinAndMaxFrame(19, 42);
                }
            }
        };
        init();
    }

    public PullRefreshFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.flj = false;
        this.flk = false;
        this.fll = false;
        this.isLoading = false;
        this.fln = true;
        this.flo = fld;
        this.flp = flf;
        this.flq = flh;
        this.fls = false;
        this.loadViewAnimListener = new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (!PullRefreshFrameLayout.this.fls) {
                    PullRefreshFrameLayout.this.fls = true;
                    PullRefreshFrameLayout.this.flt.setMinAndMaxFrame(19, 42);
                }
            }
        };
        init();
    }

    public PullRefreshFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.flj = false;
        this.flk = false;
        this.fll = false;
        this.isLoading = false;
        this.fln = true;
        this.flo = fld;
        this.flp = flf;
        this.flq = flh;
        this.fls = false;
        this.loadViewAnimListener = new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (!PullRefreshFrameLayout.this.fls) {
                    PullRefreshFrameLayout.this.fls = true;
                    PullRefreshFrameLayout.this.flt.setMinAndMaxFrame(19, 42);
                }
            }
        };
        init();
    }

    private void init() {
        this.flt = new ContinuousAnimationView(getContext());
        this.flu = new FrameLayout.LayoutParams(fla, fla);
        this.flu.gravity = 49;
        this.flu.topMargin = -fla;
        this.flt.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.flt, this.flu);
        this.flt.bringToFront();
        this.flt.setMinAndMaxProgress(0.0f, 1.0f);
        this.flt.setSpeed(1.3f);
        this.flt.setAnimation(R.raw.lottie_frs_refresh);
    }

    public void setInterceptScrollDown(boolean z) {
        this.fll = z;
    }

    public void setFromFrs() {
        this.flo = fle;
        this.flp = flg;
        this.flq = fli;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!this.isLoading && this.fln) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            switch (motionEvent.getAction()) {
                case 0:
                    this.flj = false;
                    this.flk = false;
                    this.WX = y;
                    this.dVw = x;
                    break;
                case 1:
                case 3:
                    reset();
                    break;
                case 2:
                    int i = y - this.WX;
                    int i2 = x - this.dVw;
                    if (!this.flj) {
                        if (!this.flk) {
                            if (this.fll) {
                                if (i > 0 && Math.abs(i) > Math.abs(i2)) {
                                    this.flk = false;
                                    this.flj = true;
                                    z = true;
                                    break;
                                } else if (i < 0) {
                                    this.flk = true;
                                    this.flj = false;
                                    break;
                                }
                            } else {
                                this.flk = true;
                                this.flj = false;
                                break;
                            }
                        }
                    } else {
                        z = true;
                        break;
                    }
                    break;
            }
            this.WX = y;
            this.dVw = x;
        }
        return z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        this.flr = false;
        switch (motionEvent.getAction()) {
            case 0:
                this.WX = y;
                this.dVw = x;
                break;
            case 1:
                if (this.drm < this.flq && this.flx != null) {
                    this.flx.onCancel();
                }
                bxG();
                reset();
                break;
            case 2:
                int i = y - this.WX;
                int i2 = x - this.dVw;
                if (i > 0) {
                    this.flr = true;
                }
                rg(i);
                this.WX = y;
                this.dVw = x;
                break;
            case 3:
                bxG();
                reset();
                break;
        }
        return true;
    }

    private void rg(int i) {
        int i2 = this.flu.topMargin + i;
        if (i2 > this.flo - fla) {
            i2 = this.flo - fla;
        } else if (i2 < (-fla)) {
            i2 = -fla;
        }
        this.flu.topMargin = i2;
        this.flt.setLayoutParams(this.flu);
        this.flm += i;
        if (this.flm > this.flo) {
            this.flm = this.flo;
        } else if (this.flm < 0) {
            this.flm = 0;
        }
        this.drm = (this.flm * 1.0d) / this.flo;
        if (this.flv != null) {
            this.flv.w(this.drm);
        }
    }

    private void bxG() {
        if (this.drm >= this.flq) {
            this.isLoading = true;
            this.flz = ValueAnimator.ofFloat(this.flu.topMargin, this.flp);
            this.flz.setDuration(150L);
            this.flz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    PullRefreshFrameLayout.this.flu.topMargin = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    PullRefreshFrameLayout.this.flt.setLayoutParams(PullRefreshFrameLayout.this.flu);
                }
            });
            this.flz.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    if (PullRefreshFrameLayout.this.fly != null) {
                        PullRefreshFrameLayout.this.fly.bxK();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (PullRefreshFrameLayout.this.flw != null) {
                        PullRefreshFrameLayout.this.flw.bxL();
                    }
                    PullRefreshFrameLayout.this.flt.playAnimation();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.flz.start();
            this.flv.b(this.flu.topMargin - this.flp, (this.flp * 1.0d) / this.flu.topMargin);
            return;
        }
        bxH();
    }

    public void bxH() {
        hideLoading();
        if (this.flv != null) {
            this.flv.bxM();
        }
    }

    public void dismissLoading() {
        if (this.isLoading) {
            hideLoading();
        }
    }

    private void hideLoading() {
        this.isLoading = false;
        if (this.flu.topMargin > (-fla)) {
            this.flz = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.flz.setDuration(300L);
            final int i = this.flu.topMargin;
            this.flz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (((float) (floatValue * 0.3d)) <= 0.0f) {
                    }
                    PullRefreshFrameLayout.this.flt.setAlpha(floatValue);
                    PullRefreshFrameLayout.this.flu.topMargin = (int) (floatValue * i);
                    PullRefreshFrameLayout.this.flt.setLayoutParams(PullRefreshFrameLayout.this.flu);
                }
            });
            this.flz.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    PullRefreshFrameLayout.this.flu.topMargin = -PullRefreshFrameLayout.fla;
                    PullRefreshFrameLayout.this.flt.setLayoutParams(PullRefreshFrameLayout.this.flu);
                    PullRefreshFrameLayout.this.flt.cancelAnimation();
                    PullRefreshFrameLayout.this.flt.setFrame(0);
                    PullRefreshFrameLayout.this.flt.setMinAndMaxProgress(0.0f, 1.0f);
                    PullRefreshFrameLayout.this.flt.setAlpha(1.0f);
                    PullRefreshFrameLayout.this.flt.loop(false);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.flz.start();
        }
    }

    private void reset() {
        this.drm = 0.0d;
        this.WX = 0;
        this.dVw = 0;
        this.flm = 0;
        this.flj = false;
        this.flk = false;
    }

    public void setOnTouchCallback(d dVar) {
        this.flv = dVar;
    }

    public void setOnPullRefreshListener(c cVar) {
        this.flw = cVar;
    }

    public void setOnCancelCallBack(a aVar) {
        this.flx = aVar;
    }

    public void setOnLoadingStartCallback(b bVar) {
        this.fly = bVar;
    }

    public void onDestroy() {
        if (this.flt != null) {
            this.flt.clearAnimation();
        }
        if (this.flz != null) {
            this.flz.cancel();
            this.flz.removeAllListeners();
            this.flz.removeAllUpdateListeners();
            this.flz = null;
        }
        this.flv = null;
        this.flw = null;
        this.flx = null;
    }

    public void bxI() {
        this.flt.bringToFront();
    }

    public void setRefreshing(boolean z) {
        if (z && this.fln) {
            this.flu.topMargin = this.flp;
            this.flt.setLayoutParams(this.flu);
            this.fls = false;
            this.flt.loop(true);
            this.flt.setMinFrame(10);
            this.flt.setRepeatMode(1);
            this.flt.removeAllAnimatorListeners();
            this.flt.addAnimatorListener(this.loadViewAnimListener);
            this.flt.playAnimation();
            return;
        }
        hideLoading();
    }

    public void setEnable(boolean z) {
        this.fln = z;
    }

    public boolean isEnable() {
        return this.fln;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public void bxJ() {
        if (this.flr && this.flt != null) {
            this.flt.setAlpha((float) this.drm);
            this.flt.setFrame((int) (this.drm * 10.0d));
        }
    }
}
