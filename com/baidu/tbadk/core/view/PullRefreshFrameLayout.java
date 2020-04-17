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
    private static final int dGA = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds62);
    private static final int dGB = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds210);
    private static final int dGC = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    public static final int dGD = dGB + dGA;
    public static final int dGE = dGC + dGA;
    private static final int dGF = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds135);
    private static final int dGG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds230);
    private static final float dGH = (float) ((dGF * 1.0d) / dGB);
    private static final float dGI = (float) ((dGG * 1.0d) / dGC);
    private int cYy;
    private int cYz;
    private double ceX;
    boolean dGJ;
    boolean dGK;
    boolean dGL;
    private int dGM;
    private boolean dGN;
    private int dGO;
    private int dGP;
    private float dGQ;
    private ContinuousAnimationView dGR;
    private FrameLayout.LayoutParams dGS;
    private b dGT;
    private a dGU;
    private ValueAnimator dGV;
    private boolean isLoading;

    /* loaded from: classes.dex */
    public interface a {
        void aQn();
    }

    /* loaded from: classes.dex */
    public interface b {
        void aQo();

        void c(int i, double d);

        void m(double d);
    }

    public PullRefreshFrameLayout(Context context) {
        super(context);
        this.dGJ = false;
        this.dGK = false;
        this.dGL = false;
        this.isLoading = false;
        this.dGN = true;
        this.dGO = dGD;
        this.dGP = dGF;
        this.dGQ = dGH;
        init();
    }

    public PullRefreshFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dGJ = false;
        this.dGK = false;
        this.dGL = false;
        this.isLoading = false;
        this.dGN = true;
        this.dGO = dGD;
        this.dGP = dGF;
        this.dGQ = dGH;
        init();
    }

    public PullRefreshFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dGJ = false;
        this.dGK = false;
        this.dGL = false;
        this.isLoading = false;
        this.dGN = true;
        this.dGO = dGD;
        this.dGP = dGF;
        this.dGQ = dGH;
        init();
    }

    private void init() {
        this.dGR = new ContinuousAnimationView(getContext());
        this.dGS = new FrameLayout.LayoutParams(dGA, dGA);
        this.dGS.gravity = 49;
        this.dGS.topMargin = -dGA;
        this.dGR.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.dGR, this.dGS);
        this.dGR.bringToFront();
        this.dGR.setAnimation(R.raw.ad_refresh_load);
    }

    public void setInterceptScrollDown(boolean z) {
        this.dGL = z;
    }

    public void setFromFrs() {
        this.dGO = dGE;
        this.dGP = dGG;
        this.dGQ = dGI;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!this.isLoading && this.dGN) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            switch (motionEvent.getAction()) {
                case 0:
                    this.dGJ = false;
                    this.dGK = false;
                    this.cYz = y;
                    this.cYy = x;
                    break;
                case 1:
                case 3:
                    reset();
                    break;
                case 2:
                    int i = y - this.cYz;
                    int i2 = x - this.cYy;
                    if (!this.dGJ) {
                        if (!this.dGK) {
                            if (this.dGL) {
                                if (i > 0 && Math.abs(i) > Math.abs(i2)) {
                                    this.dGK = false;
                                    this.dGJ = true;
                                    z = true;
                                    break;
                                } else if (i < 0) {
                                    this.dGK = true;
                                    this.dGJ = false;
                                    break;
                                }
                            } else {
                                this.dGK = true;
                                this.dGJ = false;
                                break;
                            }
                        }
                    } else {
                        z = true;
                        break;
                    }
                    break;
            }
            this.cYz = y;
            this.cYy = x;
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
                this.cYz = y;
                this.cYy = x;
                return true;
            case 1:
            case 3:
                aQk();
                reset();
                return true;
            case 2:
                int i = x - this.cYy;
                lw(y - this.cYz);
                this.cYz = y;
                this.cYy = x;
                return true;
            default:
                return true;
        }
    }

    private void lw(int i) {
        int i2 = this.dGS.topMargin + i;
        if (i2 > this.dGO - dGA) {
            i2 = this.dGO - dGA;
        } else if (i2 < (-dGA)) {
            i2 = -dGA;
        }
        this.dGS.topMargin = i2;
        this.dGR.setLayoutParams(this.dGS);
        this.dGM += i;
        if (this.dGM > this.dGO) {
            this.dGM = this.dGO;
        } else if (this.dGM < 0) {
            this.dGM = 0;
        }
        this.ceX = (this.dGM * 1.0d) / this.dGO;
        if (this.dGT != null) {
            this.dGT.m(this.ceX);
        }
    }

    private void aQk() {
        if (this.ceX >= this.dGQ) {
            this.isLoading = true;
            this.dGV = ValueAnimator.ofFloat(this.dGS.topMargin, this.dGP);
            this.dGV.setDuration(150L);
            this.dGV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    PullRefreshFrameLayout.this.dGS.topMargin = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    PullRefreshFrameLayout.this.dGR.setLayoutParams(PullRefreshFrameLayout.this.dGS);
                }
            });
            this.dGV.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (PullRefreshFrameLayout.this.dGU != null) {
                        PullRefreshFrameLayout.this.dGU.aQn();
                    }
                    PullRefreshFrameLayout.this.dGR.playAnimation();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.dGV.start();
            this.dGT.c(this.dGS.topMargin - this.dGP, (this.dGP * 1.0d) / this.dGS.topMargin);
            return;
        }
        aQl();
    }

    public void aQl() {
        asi();
        if (this.dGT != null) {
            this.dGT.aQo();
        }
    }

    public void aqh() {
        if (this.isLoading) {
            asi();
        }
    }

    private void asi() {
        this.isLoading = false;
        if (this.dGS.topMargin > (-dGA)) {
            this.dGV = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.dGV.setDuration(300L);
            final int i = this.dGS.topMargin;
            this.dGV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (((float) (floatValue * 0.3d)) <= 0.0f) {
                    }
                    PullRefreshFrameLayout.this.dGR.setAlpha(floatValue);
                    PullRefreshFrameLayout.this.dGS.topMargin = (int) (floatValue * i);
                    PullRefreshFrameLayout.this.dGR.setLayoutParams(PullRefreshFrameLayout.this.dGS);
                }
            });
            this.dGV.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    PullRefreshFrameLayout.this.dGS.topMargin = -PullRefreshFrameLayout.dGA;
                    PullRefreshFrameLayout.this.dGR.setLayoutParams(PullRefreshFrameLayout.this.dGS);
                    PullRefreshFrameLayout.this.dGR.cancelAnimation();
                    PullRefreshFrameLayout.this.dGR.setFrame(0);
                    PullRefreshFrameLayout.this.dGR.setAlpha(1.0f);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.dGV.start();
        }
    }

    private void reset() {
        this.ceX = 0.0d;
        this.cYz = 0;
        this.cYy = 0;
        this.dGM = 0;
        this.dGJ = false;
        this.dGK = false;
    }

    public void setOnTouchCallback(b bVar) {
        this.dGT = bVar;
    }

    public void setOnPullRefreshListener(a aVar) {
        this.dGU = aVar;
    }

    public void onDestroy() {
        if (this.dGR != null) {
            this.dGR.clearAnimation();
        }
        if (this.dGV != null) {
            this.dGV.cancel();
            this.dGV.removeAllListeners();
            this.dGV.removeAllUpdateListeners();
            this.dGV = null;
        }
        this.dGT = null;
        this.dGU = null;
    }

    public void aQm() {
        this.dGR.bringToFront();
    }

    public void setRefreshing(boolean z) {
        if (z && this.dGN) {
            this.dGS.topMargin = this.dGP;
            this.dGR.setLayoutParams(this.dGS);
            this.dGR.playAnimation();
            return;
        }
        asi();
    }

    public void setEnable(boolean z) {
        this.dGN = z;
    }

    public boolean isEnable() {
        return this.dGN;
    }
}
