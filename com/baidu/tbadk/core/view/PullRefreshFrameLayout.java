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
    private static final int dUQ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds62);
    private static final int dUR = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds210);
    private static final int dUS = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    public static final int dUT = dUR + dUQ;
    public static final int dUU = dUS + dUQ;
    private static final int dUV = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds135);
    private static final int dUW = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds230);
    private static final float dUX = (float) ((dUV * 1.0d) / dUR);
    private static final float dUY = (float) ((dUW * 1.0d) / dUS);
    private double cpL;
    boolean dUZ;
    boolean dVa;
    boolean dVb;
    private int dVc;
    private boolean dVd;
    private int dVe;
    private int dVf;
    private float dVg;
    private ContinuousAnimationView dVh;
    private FrameLayout.LayoutParams dVi;
    private b dVj;
    private a dVk;
    private ValueAnimator dVl;
    private int djH;
    private int djI;
    private boolean isLoading;

    /* loaded from: classes.dex */
    public interface a {
        void aWp();
    }

    /* loaded from: classes.dex */
    public interface b {
        void aWq();

        void c(int i, double d);

        void n(double d);
    }

    public PullRefreshFrameLayout(Context context) {
        super(context);
        this.dUZ = false;
        this.dVa = false;
        this.dVb = false;
        this.isLoading = false;
        this.dVd = true;
        this.dVe = dUT;
        this.dVf = dUV;
        this.dVg = dUX;
        init();
    }

    public PullRefreshFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dUZ = false;
        this.dVa = false;
        this.dVb = false;
        this.isLoading = false;
        this.dVd = true;
        this.dVe = dUT;
        this.dVf = dUV;
        this.dVg = dUX;
        init();
    }

    public PullRefreshFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dUZ = false;
        this.dVa = false;
        this.dVb = false;
        this.isLoading = false;
        this.dVd = true;
        this.dVe = dUT;
        this.dVf = dUV;
        this.dVg = dUX;
        init();
    }

    private void init() {
        this.dVh = new ContinuousAnimationView(getContext());
        this.dVi = new FrameLayout.LayoutParams(dUQ, dUQ);
        this.dVi.gravity = 49;
        this.dVi.topMargin = -dUQ;
        this.dVh.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.dVh, this.dVi);
        this.dVh.bringToFront();
        this.dVh.setAnimation(R.raw.ad_refresh_load);
    }

    public void setInterceptScrollDown(boolean z) {
        this.dVb = z;
    }

    public void setFromFrs() {
        this.dVe = dUU;
        this.dVf = dUW;
        this.dVg = dUY;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!this.isLoading && this.dVd) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            switch (motionEvent.getAction()) {
                case 0:
                    this.dUZ = false;
                    this.dVa = false;
                    this.djI = y;
                    this.djH = x;
                    break;
                case 1:
                case 3:
                    reset();
                    break;
                case 2:
                    int i = y - this.djI;
                    int i2 = x - this.djH;
                    if (!this.dUZ) {
                        if (!this.dVa) {
                            if (this.dVb) {
                                if (i > 0 && Math.abs(i) > Math.abs(i2)) {
                                    this.dVa = false;
                                    this.dUZ = true;
                                    z = true;
                                    break;
                                } else if (i < 0) {
                                    this.dVa = true;
                                    this.dUZ = false;
                                    break;
                                }
                            } else {
                                this.dVa = true;
                                this.dUZ = false;
                                break;
                            }
                        }
                    } else {
                        z = true;
                        break;
                    }
                    break;
            }
            this.djI = y;
            this.djH = x;
        }
        return z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.djI = y;
                this.djH = x;
                return true;
            case 1:
            case 3:
                aWm();
                reset();
                return true;
            case 2:
                int i = x - this.djH;
                ma(y - this.djI);
                this.djI = y;
                this.djH = x;
                return true;
            default:
                return true;
        }
    }

    private void ma(int i) {
        int i2 = this.dVi.topMargin + i;
        if (i2 > this.dVe - dUQ) {
            i2 = this.dVe - dUQ;
        } else if (i2 < (-dUQ)) {
            i2 = -dUQ;
        }
        this.dVi.topMargin = i2;
        this.dVh.setLayoutParams(this.dVi);
        this.dVc += i;
        if (this.dVc > this.dVe) {
            this.dVc = this.dVe;
        } else if (this.dVc < 0) {
            this.dVc = 0;
        }
        this.cpL = (this.dVc * 1.0d) / this.dVe;
        if (this.dVj != null) {
            this.dVj.n(this.cpL);
        }
    }

    private void aWm() {
        if (this.cpL >= this.dVg) {
            this.isLoading = true;
            this.dVl = ValueAnimator.ofFloat(this.dVi.topMargin, this.dVf);
            this.dVl.setDuration(150L);
            this.dVl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    PullRefreshFrameLayout.this.dVi.topMargin = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    PullRefreshFrameLayout.this.dVh.setLayoutParams(PullRefreshFrameLayout.this.dVi);
                }
            });
            this.dVl.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (PullRefreshFrameLayout.this.dVk != null) {
                        PullRefreshFrameLayout.this.dVk.aWp();
                    }
                    PullRefreshFrameLayout.this.dVh.playAnimation();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.dVl.start();
            this.dVj.c(this.dVi.topMargin - this.dVf, (this.dVf * 1.0d) / this.dVi.topMargin);
            return;
        }
        aWn();
    }

    public void aWn() {
        hideLoading();
        if (this.dVj != null) {
            this.dVj.aWq();
        }
    }

    public void dismissLoading() {
        if (this.isLoading) {
            hideLoading();
        }
    }

    private void hideLoading() {
        this.isLoading = false;
        if (this.dVi.topMargin > (-dUQ)) {
            this.dVl = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.dVl.setDuration(300L);
            final int i = this.dVi.topMargin;
            this.dVl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (((float) (floatValue * 0.3d)) <= 0.0f) {
                    }
                    PullRefreshFrameLayout.this.dVh.setAlpha(floatValue);
                    PullRefreshFrameLayout.this.dVi.topMargin = (int) (floatValue * i);
                    PullRefreshFrameLayout.this.dVh.setLayoutParams(PullRefreshFrameLayout.this.dVi);
                }
            });
            this.dVl.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    PullRefreshFrameLayout.this.dVi.topMargin = -PullRefreshFrameLayout.dUQ;
                    PullRefreshFrameLayout.this.dVh.setLayoutParams(PullRefreshFrameLayout.this.dVi);
                    PullRefreshFrameLayout.this.dVh.cancelAnimation();
                    PullRefreshFrameLayout.this.dVh.setFrame(0);
                    PullRefreshFrameLayout.this.dVh.setAlpha(1.0f);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.dVl.start();
        }
    }

    private void reset() {
        this.cpL = 0.0d;
        this.djI = 0;
        this.djH = 0;
        this.dVc = 0;
        this.dUZ = false;
        this.dVa = false;
    }

    public void setOnTouchCallback(b bVar) {
        this.dVj = bVar;
    }

    public void setOnPullRefreshListener(a aVar) {
        this.dVk = aVar;
    }

    public void onDestroy() {
        if (this.dVh != null) {
            this.dVh.clearAnimation();
        }
        if (this.dVl != null) {
            this.dVl.cancel();
            this.dVl.removeAllListeners();
            this.dVl.removeAllUpdateListeners();
            this.dVl = null;
        }
        this.dVj = null;
        this.dVk = null;
    }

    public void aWo() {
        this.dVh.bringToFront();
    }

    public void setRefreshing(boolean z) {
        if (z && this.dVd) {
            this.dVi.topMargin = this.dVf;
            this.dVh.setLayoutParams(this.dVi);
            this.dVh.playAnimation();
            return;
        }
        hideLoading();
    }

    public void setEnable(boolean z) {
        this.dVd = z;
    }

    public boolean isEnable() {
        return this.dVd;
    }

    public boolean isLoading() {
        return this.isLoading;
    }
}
