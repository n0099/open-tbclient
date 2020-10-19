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
    private static final int eGB = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds62);
    private static final int eGC = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds210);
    private static final int eGD = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    public static final int eGE = eGC + eGB;
    public static final int eGF = eGD + eGB;
    private static final int eGG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds135);
    private static final int eGH = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds230);
    private static final float eGI = (float) ((eGG * 1.0d) / eGC);
    private static final float eGJ = (float) ((eGH * 1.0d) / eGD);
    private double cSC;
    private int dsW;
    private int dsX;
    boolean eGK;
    boolean eGL;
    boolean eGM;
    private int eGN;
    private boolean eGO;
    private int eGP;
    private int eGQ;
    private float eGR;
    private ContinuousAnimationView eGS;
    private FrameLayout.LayoutParams eGT;
    private d eGU;
    private c eGV;
    private a eGW;
    private b eGX;
    private ValueAnimator eGY;
    private boolean isLoading;

    /* loaded from: classes.dex */
    public interface a {
        void onCancel();
    }

    /* loaded from: classes.dex */
    public interface b {
        void boh();
    }

    /* loaded from: classes.dex */
    public interface c {
        void boi();
    }

    /* loaded from: classes.dex */
    public interface d {
        void boj();

        void c(int i, double d);

        void w(double d);
    }

    public PullRefreshFrameLayout(Context context) {
        super(context);
        this.eGK = false;
        this.eGL = false;
        this.eGM = false;
        this.isLoading = false;
        this.eGO = true;
        this.eGP = eGE;
        this.eGQ = eGG;
        this.eGR = eGI;
        init();
    }

    public PullRefreshFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eGK = false;
        this.eGL = false;
        this.eGM = false;
        this.isLoading = false;
        this.eGO = true;
        this.eGP = eGE;
        this.eGQ = eGG;
        this.eGR = eGI;
        init();
    }

    public PullRefreshFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eGK = false;
        this.eGL = false;
        this.eGM = false;
        this.isLoading = false;
        this.eGO = true;
        this.eGP = eGE;
        this.eGQ = eGG;
        this.eGR = eGI;
        init();
    }

    private void init() {
        this.eGS = new ContinuousAnimationView(getContext());
        this.eGT = new FrameLayout.LayoutParams(eGB, eGB);
        this.eGT.gravity = 49;
        this.eGT.topMargin = -eGB;
        this.eGS.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.eGS, this.eGT);
        this.eGS.bringToFront();
        this.eGS.setAnimation(R.raw.ad_refresh_load);
    }

    public void setInterceptScrollDown(boolean z) {
        this.eGM = z;
    }

    public void setFromFrs() {
        this.eGP = eGF;
        this.eGQ = eGH;
        this.eGR = eGJ;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!this.isLoading && this.eGO) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            switch (motionEvent.getAction()) {
                case 0:
                    this.eGK = false;
                    this.eGL = false;
                    this.dsX = y;
                    this.dsW = x;
                    break;
                case 1:
                case 3:
                    reset();
                    break;
                case 2:
                    int i = y - this.dsX;
                    int i2 = x - this.dsW;
                    if (!this.eGK) {
                        if (!this.eGL) {
                            if (this.eGM) {
                                if (i > 0 && Math.abs(i) > Math.abs(i2)) {
                                    this.eGL = false;
                                    this.eGK = true;
                                    z = true;
                                    break;
                                } else if (i < 0) {
                                    this.eGL = true;
                                    this.eGK = false;
                                    break;
                                }
                            } else {
                                this.eGL = true;
                                this.eGK = false;
                                break;
                            }
                        }
                    } else {
                        z = true;
                        break;
                    }
                    break;
            }
            this.dsX = y;
            this.dsW = x;
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
                this.dsX = y;
                this.dsW = x;
                return true;
            case 1:
                if (this.cSC < this.eGR && this.eGW != null) {
                    this.eGW.onCancel();
                    break;
                }
                break;
            case 2:
                int i = x - this.dsW;
                pA(y - this.dsX);
                this.dsX = y;
                this.dsW = x;
                return true;
            case 3:
                break;
            default:
                return true;
        }
        boe();
        reset();
        return true;
    }

    private void pA(int i) {
        int i2 = this.eGT.topMargin + i;
        if (i2 > this.eGP - eGB) {
            i2 = this.eGP - eGB;
        } else if (i2 < (-eGB)) {
            i2 = -eGB;
        }
        this.eGT.topMargin = i2;
        this.eGS.setLayoutParams(this.eGT);
        this.eGN += i;
        if (this.eGN > this.eGP) {
            this.eGN = this.eGP;
        } else if (this.eGN < 0) {
            this.eGN = 0;
        }
        this.cSC = (this.eGN * 1.0d) / this.eGP;
        if (this.eGU != null) {
            this.eGU.w(this.cSC);
        }
    }

    private void boe() {
        if (this.cSC >= this.eGR) {
            this.isLoading = true;
            this.eGY = ValueAnimator.ofFloat(this.eGT.topMargin, this.eGQ);
            this.eGY.setDuration(150L);
            this.eGY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    PullRefreshFrameLayout.this.eGT.topMargin = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    PullRefreshFrameLayout.this.eGS.setLayoutParams(PullRefreshFrameLayout.this.eGT);
                }
            });
            this.eGY.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    if (PullRefreshFrameLayout.this.eGX != null) {
                        PullRefreshFrameLayout.this.eGX.boh();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (PullRefreshFrameLayout.this.eGV != null) {
                        PullRefreshFrameLayout.this.eGV.boi();
                    }
                    PullRefreshFrameLayout.this.eGS.playAnimation();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.eGY.start();
            this.eGU.c(this.eGT.topMargin - this.eGQ, (this.eGQ * 1.0d) / this.eGT.topMargin);
            return;
        }
        bof();
    }

    public void bof() {
        hideLoading();
        if (this.eGU != null) {
            this.eGU.boj();
        }
    }

    public void dismissLoading() {
        if (this.isLoading) {
            hideLoading();
        }
    }

    private void hideLoading() {
        this.isLoading = false;
        if (this.eGT.topMargin > (-eGB)) {
            this.eGY = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.eGY.setDuration(300L);
            final int i = this.eGT.topMargin;
            this.eGY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (((float) (floatValue * 0.3d)) <= 0.0f) {
                    }
                    PullRefreshFrameLayout.this.eGS.setAlpha(floatValue);
                    PullRefreshFrameLayout.this.eGT.topMargin = (int) (floatValue * i);
                    PullRefreshFrameLayout.this.eGS.setLayoutParams(PullRefreshFrameLayout.this.eGT);
                }
            });
            this.eGY.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    PullRefreshFrameLayout.this.eGT.topMargin = -PullRefreshFrameLayout.eGB;
                    PullRefreshFrameLayout.this.eGS.setLayoutParams(PullRefreshFrameLayout.this.eGT);
                    PullRefreshFrameLayout.this.eGS.cancelAnimation();
                    PullRefreshFrameLayout.this.eGS.setFrame(0);
                    PullRefreshFrameLayout.this.eGS.setAlpha(1.0f);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.eGY.start();
        }
    }

    private void reset() {
        this.cSC = 0.0d;
        this.dsX = 0;
        this.dsW = 0;
        this.eGN = 0;
        this.eGK = false;
        this.eGL = false;
    }

    public void setOnTouchCallback(d dVar) {
        this.eGU = dVar;
    }

    public void setOnPullRefreshListener(c cVar) {
        this.eGV = cVar;
    }

    public void setOnCancelCallBack(a aVar) {
        this.eGW = aVar;
    }

    public void setOnLoadingStartCallback(b bVar) {
        this.eGX = bVar;
    }

    public void onDestroy() {
        if (this.eGS != null) {
            this.eGS.clearAnimation();
        }
        if (this.eGY != null) {
            this.eGY.cancel();
            this.eGY.removeAllListeners();
            this.eGY.removeAllUpdateListeners();
            this.eGY = null;
        }
        this.eGU = null;
        this.eGV = null;
        this.eGW = null;
    }

    public void bog() {
        this.eGS.bringToFront();
    }

    public void setRefreshing(boolean z) {
        if (z && this.eGO) {
            this.eGT.topMargin = this.eGQ;
            this.eGS.setLayoutParams(this.eGT);
            this.eGS.playAnimation();
            return;
        }
        hideLoading();
    }

    public void setEnable(boolean z) {
        this.eGO = z;
    }

    public boolean isEnable() {
        return this.eGO;
    }

    public boolean isLoading() {
        return this.isLoading;
    }
}
