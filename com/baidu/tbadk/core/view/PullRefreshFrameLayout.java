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
    private static final int eUM = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds62);
    private static final int eUN = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds210);
    private static final int eUO = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    public static final int eUP = eUN + eUM;
    public static final int eUQ = eUO + eUM;
    private static final int eUR = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds135);
    private static final int eUS = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds230);
    private static final float eUT = (float) ((eUR * 1.0d) / eUN);
    private static final float eUU = (float) ((eUS * 1.0d) / eUO);
    private int dHm;
    private int dHn;
    private double dgV;
    boolean eUV;
    boolean eUW;
    boolean eUX;
    private int eUY;
    private boolean eUZ;
    private int eVa;
    private int eVb;
    private float eVc;
    private ContinuousAnimationView eVd;
    private FrameLayout.LayoutParams eVe;
    private d eVf;
    private c eVg;
    private a eVh;
    private b eVi;
    private ValueAnimator eVj;
    private boolean isLoading;

    /* loaded from: classes.dex */
    public interface a {
        void onCancel();
    }

    /* loaded from: classes.dex */
    public interface b {
        void bsA();
    }

    /* loaded from: classes.dex */
    public interface c {
        void bsB();
    }

    /* loaded from: classes.dex */
    public interface d {
        void bsC();

        void c(int i, double d);

        void x(double d);
    }

    public PullRefreshFrameLayout(Context context) {
        super(context);
        this.eUV = false;
        this.eUW = false;
        this.eUX = false;
        this.isLoading = false;
        this.eUZ = true;
        this.eVa = eUP;
        this.eVb = eUR;
        this.eVc = eUT;
        init();
    }

    public PullRefreshFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eUV = false;
        this.eUW = false;
        this.eUX = false;
        this.isLoading = false;
        this.eUZ = true;
        this.eVa = eUP;
        this.eVb = eUR;
        this.eVc = eUT;
        init();
    }

    public PullRefreshFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eUV = false;
        this.eUW = false;
        this.eUX = false;
        this.isLoading = false;
        this.eUZ = true;
        this.eVa = eUP;
        this.eVb = eUR;
        this.eVc = eUT;
        init();
    }

    private void init() {
        this.eVd = new ContinuousAnimationView(getContext());
        this.eVe = new FrameLayout.LayoutParams(eUM, eUM);
        this.eVe.gravity = 49;
        this.eVe.topMargin = -eUM;
        this.eVd.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.eVd, this.eVe);
        this.eVd.bringToFront();
        this.eVd.setAnimation(R.raw.ad_refresh_load);
    }

    public void setInterceptScrollDown(boolean z) {
        this.eUX = z;
    }

    public void setFromFrs() {
        this.eVa = eUQ;
        this.eVb = eUS;
        this.eVc = eUU;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!this.isLoading && this.eUZ) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            switch (motionEvent.getAction()) {
                case 0:
                    this.eUV = false;
                    this.eUW = false;
                    this.dHn = y;
                    this.dHm = x;
                    break;
                case 1:
                case 3:
                    reset();
                    break;
                case 2:
                    int i = y - this.dHn;
                    int i2 = x - this.dHm;
                    if (!this.eUV) {
                        if (!this.eUW) {
                            if (this.eUX) {
                                if (i > 0 && Math.abs(i) > Math.abs(i2)) {
                                    this.eUW = false;
                                    this.eUV = true;
                                    z = true;
                                    break;
                                } else if (i < 0) {
                                    this.eUW = true;
                                    this.eUV = false;
                                    break;
                                }
                            } else {
                                this.eUW = true;
                                this.eUV = false;
                                break;
                            }
                        }
                    } else {
                        z = true;
                        break;
                    }
                    break;
            }
            this.dHn = y;
            this.dHm = x;
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
        switch (motionEvent.getAction()) {
            case 0:
                this.dHn = y;
                this.dHm = x;
                return true;
            case 1:
                if (this.dgV < this.eVc && this.eVh != null) {
                    this.eVh.onCancel();
                    break;
                }
                break;
            case 2:
                int i = x - this.dHm;
                pV(y - this.dHn);
                this.dHn = y;
                this.dHm = x;
                return true;
            case 3:
                break;
            default:
                return true;
        }
        bsx();
        reset();
        return true;
    }

    private void pV(int i) {
        int i2 = this.eVe.topMargin + i;
        if (i2 > this.eVa - eUM) {
            i2 = this.eVa - eUM;
        } else if (i2 < (-eUM)) {
            i2 = -eUM;
        }
        this.eVe.topMargin = i2;
        this.eVd.setLayoutParams(this.eVe);
        this.eUY += i;
        if (this.eUY > this.eVa) {
            this.eUY = this.eVa;
        } else if (this.eUY < 0) {
            this.eUY = 0;
        }
        this.dgV = (this.eUY * 1.0d) / this.eVa;
        if (this.eVf != null) {
            this.eVf.x(this.dgV);
        }
    }

    private void bsx() {
        if (this.dgV >= this.eVc) {
            this.isLoading = true;
            this.eVj = ValueAnimator.ofFloat(this.eVe.topMargin, this.eVb);
            this.eVj.setDuration(150L);
            this.eVj.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    PullRefreshFrameLayout.this.eVe.topMargin = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    PullRefreshFrameLayout.this.eVd.setLayoutParams(PullRefreshFrameLayout.this.eVe);
                }
            });
            this.eVj.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    if (PullRefreshFrameLayout.this.eVi != null) {
                        PullRefreshFrameLayout.this.eVi.bsA();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (PullRefreshFrameLayout.this.eVg != null) {
                        PullRefreshFrameLayout.this.eVg.bsB();
                    }
                    PullRefreshFrameLayout.this.eVd.playAnimation();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.eVj.start();
            this.eVf.c(this.eVe.topMargin - this.eVb, (this.eVb * 1.0d) / this.eVe.topMargin);
            return;
        }
        bsy();
    }

    public void bsy() {
        hideLoading();
        if (this.eVf != null) {
            this.eVf.bsC();
        }
    }

    public void dismissLoading() {
        if (this.isLoading) {
            hideLoading();
        }
    }

    private void hideLoading() {
        this.isLoading = false;
        if (this.eVe.topMargin > (-eUM)) {
            this.eVj = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.eVj.setDuration(300L);
            final int i = this.eVe.topMargin;
            this.eVj.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (((float) (floatValue * 0.3d)) <= 0.0f) {
                    }
                    PullRefreshFrameLayout.this.eVd.setAlpha(floatValue);
                    PullRefreshFrameLayout.this.eVe.topMargin = (int) (floatValue * i);
                    PullRefreshFrameLayout.this.eVd.setLayoutParams(PullRefreshFrameLayout.this.eVe);
                }
            });
            this.eVj.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    PullRefreshFrameLayout.this.eVe.topMargin = -PullRefreshFrameLayout.eUM;
                    PullRefreshFrameLayout.this.eVd.setLayoutParams(PullRefreshFrameLayout.this.eVe);
                    PullRefreshFrameLayout.this.eVd.cancelAnimation();
                    PullRefreshFrameLayout.this.eVd.setFrame(0);
                    PullRefreshFrameLayout.this.eVd.setAlpha(1.0f);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.eVj.start();
        }
    }

    private void reset() {
        this.dgV = 0.0d;
        this.dHn = 0;
        this.dHm = 0;
        this.eUY = 0;
        this.eUV = false;
        this.eUW = false;
    }

    public void setOnTouchCallback(d dVar) {
        this.eVf = dVar;
    }

    public void setOnPullRefreshListener(c cVar) {
        this.eVg = cVar;
    }

    public void setOnCancelCallBack(a aVar) {
        this.eVh = aVar;
    }

    public void setOnLoadingStartCallback(b bVar) {
        this.eVi = bVar;
    }

    public void onDestroy() {
        if (this.eVd != null) {
            this.eVd.clearAnimation();
        }
        if (this.eVj != null) {
            this.eVj.cancel();
            this.eVj.removeAllListeners();
            this.eVj.removeAllUpdateListeners();
            this.eVj = null;
        }
        this.eVf = null;
        this.eVg = null;
        this.eVh = null;
    }

    public void bsz() {
        this.eVd.bringToFront();
    }

    public void setRefreshing(boolean z) {
        if (z && this.eUZ) {
            this.eVe.topMargin = this.eVb;
            this.eVd.setLayoutParams(this.eVe);
            this.eVd.playAnimation();
            return;
        }
        hideLoading();
    }

    public void setEnable(boolean z) {
        this.eUZ = z;
    }

    public boolean isEnable() {
        return this.eUZ;
    }

    public boolean isLoading() {
        return this.isLoading;
    }
}
