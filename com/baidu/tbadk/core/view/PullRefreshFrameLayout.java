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
    private static final int eir = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds62);
    private static final int eis = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds210);
    private static final int eit = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    public static final int eiu = eis + eir;
    public static final int eiv = eit + eir;
    private static final int eiw = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds135);
    private static final int eix = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds230);
    private static final float eiy = (float) ((eiw * 1.0d) / eis);
    private static final float eiz = (float) ((eix * 1.0d) / eit);
    private int cVE;
    private int cVF;
    private double cwB;
    boolean eiA;
    boolean eiB;
    boolean eiC;
    private int eiD;
    private boolean eiE;
    private int eiF;
    private int eiG;
    private float eiH;
    private ContinuousAnimationView eiI;
    private FrameLayout.LayoutParams eiJ;
    private b eiK;
    private a eiL;
    private ValueAnimator eiM;
    private boolean isLoading;

    /* loaded from: classes.dex */
    public interface a {
        void bcg();
    }

    /* loaded from: classes.dex */
    public interface b {
        void bch();

        void c(int i, double d);

        void n(double d);
    }

    public PullRefreshFrameLayout(Context context) {
        super(context);
        this.eiA = false;
        this.eiB = false;
        this.eiC = false;
        this.isLoading = false;
        this.eiE = true;
        this.eiF = eiu;
        this.eiG = eiw;
        this.eiH = eiy;
        init();
    }

    public PullRefreshFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eiA = false;
        this.eiB = false;
        this.eiC = false;
        this.isLoading = false;
        this.eiE = true;
        this.eiF = eiu;
        this.eiG = eiw;
        this.eiH = eiy;
        init();
    }

    public PullRefreshFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eiA = false;
        this.eiB = false;
        this.eiC = false;
        this.isLoading = false;
        this.eiE = true;
        this.eiF = eiu;
        this.eiG = eiw;
        this.eiH = eiy;
        init();
    }

    private void init() {
        this.eiI = new ContinuousAnimationView(getContext());
        this.eiJ = new FrameLayout.LayoutParams(eir, eir);
        this.eiJ.gravity = 49;
        this.eiJ.topMargin = -eir;
        this.eiI.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.eiI, this.eiJ);
        this.eiI.bringToFront();
        this.eiI.setAnimation(R.raw.ad_refresh_load);
    }

    public void setInterceptScrollDown(boolean z) {
        this.eiC = z;
    }

    public void setFromFrs() {
        this.eiF = eiv;
        this.eiG = eix;
        this.eiH = eiz;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!this.isLoading && this.eiE) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            switch (motionEvent.getAction()) {
                case 0:
                    this.eiA = false;
                    this.eiB = false;
                    this.cVF = y;
                    this.cVE = x;
                    break;
                case 1:
                case 3:
                    reset();
                    break;
                case 2:
                    int i = y - this.cVF;
                    int i2 = x - this.cVE;
                    if (!this.eiA) {
                        if (!this.eiB) {
                            if (this.eiC) {
                                if (i > 0 && Math.abs(i) > Math.abs(i2)) {
                                    this.eiB = false;
                                    this.eiA = true;
                                    z = true;
                                    break;
                                } else if (i < 0) {
                                    this.eiB = true;
                                    this.eiA = false;
                                    break;
                                }
                            } else {
                                this.eiB = true;
                                this.eiA = false;
                                break;
                            }
                        }
                    } else {
                        z = true;
                        break;
                    }
                    break;
            }
            this.cVF = y;
            this.cVE = x;
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
                this.cVF = y;
                this.cVE = x;
                return true;
            case 1:
            case 3:
                bcd();
                reset();
                return true;
            case 2:
                int i = x - this.cVE;
                mK(y - this.cVF);
                this.cVF = y;
                this.cVE = x;
                return true;
            default:
                return true;
        }
    }

    private void mK(int i) {
        int i2 = this.eiJ.topMargin + i;
        if (i2 > this.eiF - eir) {
            i2 = this.eiF - eir;
        } else if (i2 < (-eir)) {
            i2 = -eir;
        }
        this.eiJ.topMargin = i2;
        this.eiI.setLayoutParams(this.eiJ);
        this.eiD += i;
        if (this.eiD > this.eiF) {
            this.eiD = this.eiF;
        } else if (this.eiD < 0) {
            this.eiD = 0;
        }
        this.cwB = (this.eiD * 1.0d) / this.eiF;
        if (this.eiK != null) {
            this.eiK.n(this.cwB);
        }
    }

    private void bcd() {
        if (this.cwB >= this.eiH) {
            this.isLoading = true;
            this.eiM = ValueAnimator.ofFloat(this.eiJ.topMargin, this.eiG);
            this.eiM.setDuration(150L);
            this.eiM.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    PullRefreshFrameLayout.this.eiJ.topMargin = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    PullRefreshFrameLayout.this.eiI.setLayoutParams(PullRefreshFrameLayout.this.eiJ);
                }
            });
            this.eiM.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (PullRefreshFrameLayout.this.eiL != null) {
                        PullRefreshFrameLayout.this.eiL.bcg();
                    }
                    PullRefreshFrameLayout.this.eiI.playAnimation();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.eiM.start();
            this.eiK.c(this.eiJ.topMargin - this.eiG, (this.eiG * 1.0d) / this.eiJ.topMargin);
            return;
        }
        bce();
    }

    public void bce() {
        hideLoading();
        if (this.eiK != null) {
            this.eiK.bch();
        }
    }

    public void dismissLoading() {
        if (this.isLoading) {
            hideLoading();
        }
    }

    private void hideLoading() {
        this.isLoading = false;
        if (this.eiJ.topMargin > (-eir)) {
            this.eiM = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.eiM.setDuration(300L);
            final int i = this.eiJ.topMargin;
            this.eiM.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (((float) (floatValue * 0.3d)) <= 0.0f) {
                    }
                    PullRefreshFrameLayout.this.eiI.setAlpha(floatValue);
                    PullRefreshFrameLayout.this.eiJ.topMargin = (int) (floatValue * i);
                    PullRefreshFrameLayout.this.eiI.setLayoutParams(PullRefreshFrameLayout.this.eiJ);
                }
            });
            this.eiM.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    PullRefreshFrameLayout.this.eiJ.topMargin = -PullRefreshFrameLayout.eir;
                    PullRefreshFrameLayout.this.eiI.setLayoutParams(PullRefreshFrameLayout.this.eiJ);
                    PullRefreshFrameLayout.this.eiI.cancelAnimation();
                    PullRefreshFrameLayout.this.eiI.setFrame(0);
                    PullRefreshFrameLayout.this.eiI.setAlpha(1.0f);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.eiM.start();
        }
    }

    private void reset() {
        this.cwB = 0.0d;
        this.cVF = 0;
        this.cVE = 0;
        this.eiD = 0;
        this.eiA = false;
        this.eiB = false;
    }

    public void setOnTouchCallback(b bVar) {
        this.eiK = bVar;
    }

    public void setOnPullRefreshListener(a aVar) {
        this.eiL = aVar;
    }

    public void onDestroy() {
        if (this.eiI != null) {
            this.eiI.clearAnimation();
        }
        if (this.eiM != null) {
            this.eiM.cancel();
            this.eiM.removeAllListeners();
            this.eiM.removeAllUpdateListeners();
            this.eiM = null;
        }
        this.eiK = null;
        this.eiL = null;
    }

    public void bcf() {
        this.eiI.bringToFront();
    }

    public void setRefreshing(boolean z) {
        if (z && this.eiE) {
            this.eiJ.topMargin = this.eiG;
            this.eiI.setLayoutParams(this.eiJ);
            this.eiI.playAnimation();
            return;
        }
        hideLoading();
    }

    public void setEnable(boolean z) {
        this.eiE = z;
    }

    public boolean isEnable() {
        return this.eiE;
    }

    public boolean isLoading() {
        return this.isLoading;
    }
}
