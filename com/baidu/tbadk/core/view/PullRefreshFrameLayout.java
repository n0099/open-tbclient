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
    private static final int fgp = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds144);
    private static final int fgq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds210);
    private static final int fgr = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    public static final int fgs = fgq + fgp;
    public static final int fgt = fgr + fgp;
    private static final int fgu = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds135);
    private static final int fgv = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds230);
    private static final float fgw = (float) ((fgu * 1.0d) / fgq);
    private static final float fgx = (float) ((fgv * 1.0d) / fgr);
    private int WV;
    private int dQK;
    private double dmw;
    boolean fgA;
    private int fgB;
    private boolean fgC;
    private int fgD;
    private int fgE;
    private float fgF;
    private boolean fgG;
    private boolean fgH;
    private ContinuousAnimationView fgI;
    private FrameLayout.LayoutParams fgJ;
    private d fgK;
    private c fgL;
    private a fgM;
    private b fgN;
    private ValueAnimator fgO;
    boolean fgy;
    boolean fgz;
    private boolean isLoading;
    private final Animator.AnimatorListener loadViewAnimListener;

    /* loaded from: classes.dex */
    public interface a {
        void onCancel();
    }

    /* loaded from: classes.dex */
    public interface b {
        void btR();
    }

    /* loaded from: classes.dex */
    public interface c {
        void btS();
    }

    /* loaded from: classes.dex */
    public interface d {
        void b(int i, double d);

        void btT();

        void q(double d);
    }

    public PullRefreshFrameLayout(Context context) {
        super(context);
        this.fgy = false;
        this.fgz = false;
        this.fgA = false;
        this.isLoading = false;
        this.fgC = true;
        this.fgD = fgs;
        this.fgE = fgu;
        this.fgF = fgw;
        this.fgH = false;
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
                if (!PullRefreshFrameLayout.this.fgH) {
                    PullRefreshFrameLayout.this.fgH = true;
                    PullRefreshFrameLayout.this.fgI.setMinAndMaxFrame(19, 42);
                }
            }
        };
        init();
    }

    public PullRefreshFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fgy = false;
        this.fgz = false;
        this.fgA = false;
        this.isLoading = false;
        this.fgC = true;
        this.fgD = fgs;
        this.fgE = fgu;
        this.fgF = fgw;
        this.fgH = false;
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
                if (!PullRefreshFrameLayout.this.fgH) {
                    PullRefreshFrameLayout.this.fgH = true;
                    PullRefreshFrameLayout.this.fgI.setMinAndMaxFrame(19, 42);
                }
            }
        };
        init();
    }

    public PullRefreshFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fgy = false;
        this.fgz = false;
        this.fgA = false;
        this.isLoading = false;
        this.fgC = true;
        this.fgD = fgs;
        this.fgE = fgu;
        this.fgF = fgw;
        this.fgH = false;
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
                if (!PullRefreshFrameLayout.this.fgH) {
                    PullRefreshFrameLayout.this.fgH = true;
                    PullRefreshFrameLayout.this.fgI.setMinAndMaxFrame(19, 42);
                }
            }
        };
        init();
    }

    private void init() {
        this.fgI = new ContinuousAnimationView(getContext());
        this.fgJ = new FrameLayout.LayoutParams(fgp, fgp);
        this.fgJ.gravity = 49;
        this.fgJ.topMargin = -fgp;
        this.fgI.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.fgI, this.fgJ);
        this.fgI.bringToFront();
        this.fgI.setMinAndMaxProgress(0.0f, 1.0f);
        this.fgI.setSpeed(1.3f);
        this.fgI.setAnimation(R.raw.lottie_frs_refresh);
    }

    public void setInterceptScrollDown(boolean z) {
        this.fgA = z;
    }

    public void setFromFrs() {
        this.fgD = fgt;
        this.fgE = fgv;
        this.fgF = fgx;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!this.isLoading && this.fgC) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            switch (motionEvent.getAction()) {
                case 0:
                    this.fgy = false;
                    this.fgz = false;
                    this.WV = y;
                    this.dQK = x;
                    break;
                case 1:
                case 3:
                    reset();
                    break;
                case 2:
                    int i = y - this.WV;
                    int i2 = x - this.dQK;
                    if (!this.fgy) {
                        if (!this.fgz) {
                            if (this.fgA) {
                                if (i > 0 && Math.abs(i) > Math.abs(i2)) {
                                    this.fgz = false;
                                    this.fgy = true;
                                    z = true;
                                    break;
                                } else if (i < 0) {
                                    this.fgz = true;
                                    this.fgy = false;
                                    break;
                                }
                            } else {
                                this.fgz = true;
                                this.fgy = false;
                                break;
                            }
                        }
                    } else {
                        z = true;
                        break;
                    }
                    break;
            }
            this.WV = y;
            this.dQK = x;
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
        this.fgG = false;
        switch (motionEvent.getAction()) {
            case 0:
                this.WV = y;
                this.dQK = x;
                break;
            case 1:
                if (this.dmw < this.fgF && this.fgM != null) {
                    this.fgM.onCancel();
                }
                btN();
                reset();
                break;
            case 2:
                int i = y - this.WV;
                int i2 = x - this.dQK;
                if (i > 0) {
                    this.fgG = true;
                }
                pA(i);
                this.WV = y;
                this.dQK = x;
                break;
            case 3:
                btN();
                reset();
                break;
        }
        return true;
    }

    private void pA(int i) {
        int i2 = this.fgJ.topMargin + i;
        if (i2 > this.fgD - fgp) {
            i2 = this.fgD - fgp;
        } else if (i2 < (-fgp)) {
            i2 = -fgp;
        }
        this.fgJ.topMargin = i2;
        this.fgI.setLayoutParams(this.fgJ);
        this.fgB += i;
        if (this.fgB > this.fgD) {
            this.fgB = this.fgD;
        } else if (this.fgB < 0) {
            this.fgB = 0;
        }
        this.dmw = (this.fgB * 1.0d) / this.fgD;
        if (this.fgK != null) {
            this.fgK.q(this.dmw);
        }
    }

    private void btN() {
        if (this.dmw >= this.fgF) {
            this.isLoading = true;
            this.fgO = ValueAnimator.ofFloat(this.fgJ.topMargin, this.fgE);
            this.fgO.setDuration(150L);
            this.fgO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    PullRefreshFrameLayout.this.fgJ.topMargin = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    PullRefreshFrameLayout.this.fgI.setLayoutParams(PullRefreshFrameLayout.this.fgJ);
                }
            });
            this.fgO.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    if (PullRefreshFrameLayout.this.fgN != null) {
                        PullRefreshFrameLayout.this.fgN.btR();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (PullRefreshFrameLayout.this.fgL != null) {
                        PullRefreshFrameLayout.this.fgL.btS();
                    }
                    PullRefreshFrameLayout.this.fgI.playAnimation();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.fgO.start();
            this.fgK.b(this.fgJ.topMargin - this.fgE, (this.fgE * 1.0d) / this.fgJ.topMargin);
            return;
        }
        btO();
    }

    public void btO() {
        hideLoading();
        if (this.fgK != null) {
            this.fgK.btT();
        }
    }

    public void dismissLoading() {
        if (this.isLoading) {
            hideLoading();
        }
    }

    private void hideLoading() {
        this.isLoading = false;
        if (this.fgJ.topMargin > (-fgp)) {
            this.fgO = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.fgO.setDuration(300L);
            final int i = this.fgJ.topMargin;
            this.fgO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (((float) (floatValue * 0.3d)) <= 0.0f) {
                    }
                    PullRefreshFrameLayout.this.fgI.setAlpha(floatValue);
                    PullRefreshFrameLayout.this.fgJ.topMargin = (int) (floatValue * i);
                    PullRefreshFrameLayout.this.fgI.setLayoutParams(PullRefreshFrameLayout.this.fgJ);
                }
            });
            this.fgO.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    PullRefreshFrameLayout.this.fgJ.topMargin = -PullRefreshFrameLayout.fgp;
                    PullRefreshFrameLayout.this.fgI.setLayoutParams(PullRefreshFrameLayout.this.fgJ);
                    PullRefreshFrameLayout.this.fgI.cancelAnimation();
                    PullRefreshFrameLayout.this.fgI.setFrame(0);
                    PullRefreshFrameLayout.this.fgI.setMinAndMaxProgress(0.0f, 1.0f);
                    PullRefreshFrameLayout.this.fgI.setAlpha(1.0f);
                    PullRefreshFrameLayout.this.fgI.loop(false);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.fgO.start();
        }
    }

    private void reset() {
        this.dmw = 0.0d;
        this.WV = 0;
        this.dQK = 0;
        this.fgB = 0;
        this.fgy = false;
        this.fgz = false;
    }

    public void setOnTouchCallback(d dVar) {
        this.fgK = dVar;
    }

    public void setOnPullRefreshListener(c cVar) {
        this.fgL = cVar;
    }

    public void setOnCancelCallBack(a aVar) {
        this.fgM = aVar;
    }

    public void setOnLoadingStartCallback(b bVar) {
        this.fgN = bVar;
    }

    public void onDestroy() {
        if (this.fgI != null) {
            this.fgI.clearAnimation();
        }
        if (this.fgO != null) {
            this.fgO.cancel();
            this.fgO.removeAllListeners();
            this.fgO.removeAllUpdateListeners();
            this.fgO = null;
        }
        this.fgK = null;
        this.fgL = null;
        this.fgM = null;
    }

    public void btP() {
        this.fgI.bringToFront();
    }

    public void setRefreshing(boolean z) {
        if (z && this.fgC) {
            this.fgJ.topMargin = this.fgE;
            this.fgI.setLayoutParams(this.fgJ);
            this.fgH = false;
            this.fgI.loop(true);
            this.fgI.setMinFrame(10);
            this.fgI.setRepeatMode(1);
            this.fgI.removeAllAnimatorListeners();
            this.fgI.addAnimatorListener(this.loadViewAnimListener);
            this.fgI.playAnimation();
            return;
        }
        hideLoading();
    }

    public void setEnable(boolean z) {
        this.fgC = z;
    }

    public boolean isEnable() {
        return this.fgC;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public void btQ() {
        if (this.fgG && this.fgI != null) {
            this.fgI.setAlpha((float) this.dmw);
            this.fgI.setFrame((int) (this.dmw * 10.0d));
        }
    }
}
