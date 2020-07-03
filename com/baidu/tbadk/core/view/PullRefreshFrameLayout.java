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
    private static final int ech = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds62);
    private static final int eci = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds210);
    private static final int ecj = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    public static final int eck = eci + ech;
    public static final int ecl = ecj + ech;
    private static final int ecm = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds135);
    private static final int ecn = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds230);
    private static final float eco = (float) ((ecm * 1.0d) / eci);
    private static final float ecp = (float) ((ecn * 1.0d) / ecj);
    private double cuA;
    private int dos;
    private int dot;
    private b ecA;
    private a ecB;
    private ValueAnimator ecC;
    boolean ecq;
    boolean ecr;
    boolean ecs;
    private int ect;
    private boolean ecu;
    private int ecv;
    private int ecw;
    private float ecx;
    private ContinuousAnimationView ecy;
    private FrameLayout.LayoutParams ecz;
    private boolean isLoading;

    /* loaded from: classes.dex */
    public interface a {
        void aYg();
    }

    /* loaded from: classes.dex */
    public interface b {
        void aYh();

        void c(int i, double d);

        void n(double d);
    }

    public PullRefreshFrameLayout(Context context) {
        super(context);
        this.ecq = false;
        this.ecr = false;
        this.ecs = false;
        this.isLoading = false;
        this.ecu = true;
        this.ecv = eck;
        this.ecw = ecm;
        this.ecx = eco;
        init();
    }

    public PullRefreshFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ecq = false;
        this.ecr = false;
        this.ecs = false;
        this.isLoading = false;
        this.ecu = true;
        this.ecv = eck;
        this.ecw = ecm;
        this.ecx = eco;
        init();
    }

    public PullRefreshFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ecq = false;
        this.ecr = false;
        this.ecs = false;
        this.isLoading = false;
        this.ecu = true;
        this.ecv = eck;
        this.ecw = ecm;
        this.ecx = eco;
        init();
    }

    private void init() {
        this.ecy = new ContinuousAnimationView(getContext());
        this.ecz = new FrameLayout.LayoutParams(ech, ech);
        this.ecz.gravity = 49;
        this.ecz.topMargin = -ech;
        this.ecy.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.ecy, this.ecz);
        this.ecy.bringToFront();
        this.ecy.setAnimation(R.raw.ad_refresh_load);
    }

    public void setInterceptScrollDown(boolean z) {
        this.ecs = z;
    }

    public void setFromFrs() {
        this.ecv = ecl;
        this.ecw = ecn;
        this.ecx = ecp;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!this.isLoading && this.ecu) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            switch (motionEvent.getAction()) {
                case 0:
                    this.ecq = false;
                    this.ecr = false;
                    this.dot = y;
                    this.dos = x;
                    break;
                case 1:
                case 3:
                    reset();
                    break;
                case 2:
                    int i = y - this.dot;
                    int i2 = x - this.dos;
                    if (!this.ecq) {
                        if (!this.ecr) {
                            if (this.ecs) {
                                if (i > 0 && Math.abs(i) > Math.abs(i2)) {
                                    this.ecr = false;
                                    this.ecq = true;
                                    z = true;
                                    break;
                                } else if (i < 0) {
                                    this.ecr = true;
                                    this.ecq = false;
                                    break;
                                }
                            } else {
                                this.ecr = true;
                                this.ecq = false;
                                break;
                            }
                        }
                    } else {
                        z = true;
                        break;
                    }
                    break;
            }
            this.dot = y;
            this.dos = x;
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
                this.dot = y;
                this.dos = x;
                return true;
            case 1:
            case 3:
                aYd();
                reset();
                return true;
            case 2:
                int i = x - this.dos;
                mr(y - this.dot);
                this.dot = y;
                this.dos = x;
                return true;
            default:
                return true;
        }
    }

    private void mr(int i) {
        int i2 = this.ecz.topMargin + i;
        if (i2 > this.ecv - ech) {
            i2 = this.ecv - ech;
        } else if (i2 < (-ech)) {
            i2 = -ech;
        }
        this.ecz.topMargin = i2;
        this.ecy.setLayoutParams(this.ecz);
        this.ect += i;
        if (this.ect > this.ecv) {
            this.ect = this.ecv;
        } else if (this.ect < 0) {
            this.ect = 0;
        }
        this.cuA = (this.ect * 1.0d) / this.ecv;
        if (this.ecA != null) {
            this.ecA.n(this.cuA);
        }
    }

    private void aYd() {
        if (this.cuA >= this.ecx) {
            this.isLoading = true;
            this.ecC = ValueAnimator.ofFloat(this.ecz.topMargin, this.ecw);
            this.ecC.setDuration(150L);
            this.ecC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    PullRefreshFrameLayout.this.ecz.topMargin = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    PullRefreshFrameLayout.this.ecy.setLayoutParams(PullRefreshFrameLayout.this.ecz);
                }
            });
            this.ecC.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (PullRefreshFrameLayout.this.ecB != null) {
                        PullRefreshFrameLayout.this.ecB.aYg();
                    }
                    PullRefreshFrameLayout.this.ecy.playAnimation();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.ecC.start();
            this.ecA.c(this.ecz.topMargin - this.ecw, (this.ecw * 1.0d) / this.ecz.topMargin);
            return;
        }
        aYe();
    }

    public void aYe() {
        hideLoading();
        if (this.ecA != null) {
            this.ecA.aYh();
        }
    }

    public void dismissLoading() {
        if (this.isLoading) {
            hideLoading();
        }
    }

    private void hideLoading() {
        this.isLoading = false;
        if (this.ecz.topMargin > (-ech)) {
            this.ecC = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.ecC.setDuration(300L);
            final int i = this.ecz.topMargin;
            this.ecC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (((float) (floatValue * 0.3d)) <= 0.0f) {
                    }
                    PullRefreshFrameLayout.this.ecy.setAlpha(floatValue);
                    PullRefreshFrameLayout.this.ecz.topMargin = (int) (floatValue * i);
                    PullRefreshFrameLayout.this.ecy.setLayoutParams(PullRefreshFrameLayout.this.ecz);
                }
            });
            this.ecC.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    PullRefreshFrameLayout.this.ecz.topMargin = -PullRefreshFrameLayout.ech;
                    PullRefreshFrameLayout.this.ecy.setLayoutParams(PullRefreshFrameLayout.this.ecz);
                    PullRefreshFrameLayout.this.ecy.cancelAnimation();
                    PullRefreshFrameLayout.this.ecy.setFrame(0);
                    PullRefreshFrameLayout.this.ecy.setAlpha(1.0f);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.ecC.start();
        }
    }

    private void reset() {
        this.cuA = 0.0d;
        this.dot = 0;
        this.dos = 0;
        this.ect = 0;
        this.ecq = false;
        this.ecr = false;
    }

    public void setOnTouchCallback(b bVar) {
        this.ecA = bVar;
    }

    public void setOnPullRefreshListener(a aVar) {
        this.ecB = aVar;
    }

    public void onDestroy() {
        if (this.ecy != null) {
            this.ecy.clearAnimation();
        }
        if (this.ecC != null) {
            this.ecC.cancel();
            this.ecC.removeAllListeners();
            this.ecC.removeAllUpdateListeners();
            this.ecC = null;
        }
        this.ecA = null;
        this.ecB = null;
    }

    public void aYf() {
        this.ecy.bringToFront();
    }

    public void setRefreshing(boolean z) {
        if (z && this.ecu) {
            this.ecz.topMargin = this.ecw;
            this.ecy.setLayoutParams(this.ecz);
            this.ecy.playAnimation();
            return;
        }
        hideLoading();
    }

    public void setEnable(boolean z) {
        this.ecu = z;
    }

    public boolean isEnable() {
        return this.ecu;
    }

    public boolean isLoading() {
        return this.isLoading;
    }
}
