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
    private static final int dGE = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds62);
    private static final int dGF = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds210);
    private static final int dGG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    public static final int dGH = dGF + dGE;
    public static final int dGI = dGG + dGE;
    private static final int dGJ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds135);
    private static final int dGK = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds230);
    private static final float dGL = (float) ((dGJ * 1.0d) / dGF);
    private static final float dGM = (float) ((dGK * 1.0d) / dGG);
    private int cYD;
    private int cYE;
    private double cfd;
    boolean dGN;
    boolean dGO;
    boolean dGP;
    private int dGQ;
    private boolean dGR;
    private int dGS;
    private int dGT;
    private float dGU;
    private ContinuousAnimationView dGV;
    private FrameLayout.LayoutParams dGW;
    private b dGX;
    private a dGY;
    private ValueAnimator dGZ;
    private boolean isLoading;

    /* loaded from: classes.dex */
    public interface a {
        void aQk();
    }

    /* loaded from: classes.dex */
    public interface b {
        void aQl();

        void c(int i, double d);

        void m(double d);
    }

    public PullRefreshFrameLayout(Context context) {
        super(context);
        this.dGN = false;
        this.dGO = false;
        this.dGP = false;
        this.isLoading = false;
        this.dGR = true;
        this.dGS = dGH;
        this.dGT = dGJ;
        this.dGU = dGL;
        init();
    }

    public PullRefreshFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dGN = false;
        this.dGO = false;
        this.dGP = false;
        this.isLoading = false;
        this.dGR = true;
        this.dGS = dGH;
        this.dGT = dGJ;
        this.dGU = dGL;
        init();
    }

    public PullRefreshFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dGN = false;
        this.dGO = false;
        this.dGP = false;
        this.isLoading = false;
        this.dGR = true;
        this.dGS = dGH;
        this.dGT = dGJ;
        this.dGU = dGL;
        init();
    }

    private void init() {
        this.dGV = new ContinuousAnimationView(getContext());
        this.dGW = new FrameLayout.LayoutParams(dGE, dGE);
        this.dGW.gravity = 49;
        this.dGW.topMargin = -dGE;
        this.dGV.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.dGV, this.dGW);
        this.dGV.bringToFront();
        this.dGV.setAnimation(R.raw.ad_refresh_load);
    }

    public void setInterceptScrollDown(boolean z) {
        this.dGP = z;
    }

    public void setFromFrs() {
        this.dGS = dGI;
        this.dGT = dGK;
        this.dGU = dGM;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!this.isLoading && this.dGR) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            switch (motionEvent.getAction()) {
                case 0:
                    this.dGN = false;
                    this.dGO = false;
                    this.cYE = y;
                    this.cYD = x;
                    break;
                case 1:
                case 3:
                    reset();
                    break;
                case 2:
                    int i = y - this.cYE;
                    int i2 = x - this.cYD;
                    if (!this.dGN) {
                        if (!this.dGO) {
                            if (this.dGP) {
                                if (i > 0 && Math.abs(i) > Math.abs(i2)) {
                                    this.dGO = false;
                                    this.dGN = true;
                                    z = true;
                                    break;
                                } else if (i < 0) {
                                    this.dGO = true;
                                    this.dGN = false;
                                    break;
                                }
                            } else {
                                this.dGO = true;
                                this.dGN = false;
                                break;
                            }
                        }
                    } else {
                        z = true;
                        break;
                    }
                    break;
            }
            this.cYE = y;
            this.cYD = x;
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
                this.cYE = y;
                this.cYD = x;
                return true;
            case 1:
            case 3:
                aQh();
                reset();
                return true;
            case 2:
                int i = x - this.cYD;
                lw(y - this.cYE);
                this.cYE = y;
                this.cYD = x;
                return true;
            default:
                return true;
        }
    }

    private void lw(int i) {
        int i2 = this.dGW.topMargin + i;
        if (i2 > this.dGS - dGE) {
            i2 = this.dGS - dGE;
        } else if (i2 < (-dGE)) {
            i2 = -dGE;
        }
        this.dGW.topMargin = i2;
        this.dGV.setLayoutParams(this.dGW);
        this.dGQ += i;
        if (this.dGQ > this.dGS) {
            this.dGQ = this.dGS;
        } else if (this.dGQ < 0) {
            this.dGQ = 0;
        }
        this.cfd = (this.dGQ * 1.0d) / this.dGS;
        if (this.dGX != null) {
            this.dGX.m(this.cfd);
        }
    }

    private void aQh() {
        if (this.cfd >= this.dGU) {
            this.isLoading = true;
            this.dGZ = ValueAnimator.ofFloat(this.dGW.topMargin, this.dGT);
            this.dGZ.setDuration(150L);
            this.dGZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    PullRefreshFrameLayout.this.dGW.topMargin = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    PullRefreshFrameLayout.this.dGV.setLayoutParams(PullRefreshFrameLayout.this.dGW);
                }
            });
            this.dGZ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (PullRefreshFrameLayout.this.dGY != null) {
                        PullRefreshFrameLayout.this.dGY.aQk();
                    }
                    PullRefreshFrameLayout.this.dGV.playAnimation();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.dGZ.start();
            this.dGX.c(this.dGW.topMargin - this.dGT, (this.dGT * 1.0d) / this.dGW.topMargin);
            return;
        }
        aQi();
    }

    public void aQi() {
        ash();
        if (this.dGX != null) {
            this.dGX.aQl();
        }
    }

    public void aqg() {
        if (this.isLoading) {
            ash();
        }
    }

    private void ash() {
        this.isLoading = false;
        if (this.dGW.topMargin > (-dGE)) {
            this.dGZ = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.dGZ.setDuration(300L);
            final int i = this.dGW.topMargin;
            this.dGZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (((float) (floatValue * 0.3d)) <= 0.0f) {
                    }
                    PullRefreshFrameLayout.this.dGV.setAlpha(floatValue);
                    PullRefreshFrameLayout.this.dGW.topMargin = (int) (floatValue * i);
                    PullRefreshFrameLayout.this.dGV.setLayoutParams(PullRefreshFrameLayout.this.dGW);
                }
            });
            this.dGZ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    PullRefreshFrameLayout.this.dGW.topMargin = -PullRefreshFrameLayout.dGE;
                    PullRefreshFrameLayout.this.dGV.setLayoutParams(PullRefreshFrameLayout.this.dGW);
                    PullRefreshFrameLayout.this.dGV.cancelAnimation();
                    PullRefreshFrameLayout.this.dGV.setFrame(0);
                    PullRefreshFrameLayout.this.dGV.setAlpha(1.0f);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.dGZ.start();
        }
    }

    private void reset() {
        this.cfd = 0.0d;
        this.cYE = 0;
        this.cYD = 0;
        this.dGQ = 0;
        this.dGN = false;
        this.dGO = false;
    }

    public void setOnTouchCallback(b bVar) {
        this.dGX = bVar;
    }

    public void setOnPullRefreshListener(a aVar) {
        this.dGY = aVar;
    }

    public void onDestroy() {
        if (this.dGV != null) {
            this.dGV.clearAnimation();
        }
        if (this.dGZ != null) {
            this.dGZ.cancel();
            this.dGZ.removeAllListeners();
            this.dGZ.removeAllUpdateListeners();
            this.dGZ = null;
        }
        this.dGX = null;
        this.dGY = null;
    }

    public void aQj() {
        this.dGV.bringToFront();
    }

    public void setRefreshing(boolean z) {
        if (z && this.dGR) {
            this.dGW.topMargin = this.dGT;
            this.dGV.setLayoutParams(this.dGW);
            this.dGV.playAnimation();
            return;
        }
        ash();
    }

    public void setEnable(boolean z) {
        this.dGR = z;
    }

    public boolean isEnable() {
        return this.dGR;
    }
}
