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
    private static final int esm = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds62);
    private static final int esn = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds210);
    private static final int eso = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    public static final int esp = esn + esm;
    public static final int esq = eso + esm;
    private static final int esr = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds135);
    private static final int ess = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds230);
    private static final float est = (float) ((esr * 1.0d) / esn);
    private static final float esu = (float) ((ess * 1.0d) / eso);
    private double cEz;
    private int deO;
    private int deP;
    private int esA;
    private int esB;
    private float esC;
    private ContinuousAnimationView esD;
    private FrameLayout.LayoutParams esE;
    private d esF;
    private c esG;
    private a esH;
    private b esI;
    private ValueAnimator esJ;
    boolean esv;
    boolean esw;
    boolean esx;
    private int esy;
    private boolean esz;
    private boolean isLoading;

    /* loaded from: classes.dex */
    public interface a {
        void onCancel();
    }

    /* loaded from: classes.dex */
    public interface b {
        void bkC();
    }

    /* loaded from: classes.dex */
    public interface c {
        void bkD();
    }

    /* loaded from: classes.dex */
    public interface d {
        void bkE();

        void c(int i, double d);

        void t(double d);
    }

    public PullRefreshFrameLayout(Context context) {
        super(context);
        this.esv = false;
        this.esw = false;
        this.esx = false;
        this.isLoading = false;
        this.esz = true;
        this.esA = esp;
        this.esB = esr;
        this.esC = est;
        init();
    }

    public PullRefreshFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.esv = false;
        this.esw = false;
        this.esx = false;
        this.isLoading = false;
        this.esz = true;
        this.esA = esp;
        this.esB = esr;
        this.esC = est;
        init();
    }

    public PullRefreshFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.esv = false;
        this.esw = false;
        this.esx = false;
        this.isLoading = false;
        this.esz = true;
        this.esA = esp;
        this.esB = esr;
        this.esC = est;
        init();
    }

    private void init() {
        this.esD = new ContinuousAnimationView(getContext());
        this.esE = new FrameLayout.LayoutParams(esm, esm);
        this.esE.gravity = 49;
        this.esE.topMargin = -esm;
        this.esD.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.esD, this.esE);
        this.esD.bringToFront();
        this.esD.setAnimation(R.raw.ad_refresh_load);
    }

    public void setInterceptScrollDown(boolean z) {
        this.esx = z;
    }

    public void setFromFrs() {
        this.esA = esq;
        this.esB = ess;
        this.esC = esu;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!this.isLoading && this.esz) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            switch (motionEvent.getAction()) {
                case 0:
                    this.esv = false;
                    this.esw = false;
                    this.deP = y;
                    this.deO = x;
                    break;
                case 1:
                case 3:
                    reset();
                    break;
                case 2:
                    int i = y - this.deP;
                    int i2 = x - this.deO;
                    if (!this.esv) {
                        if (!this.esw) {
                            if (this.esx) {
                                if (i > 0 && Math.abs(i) > Math.abs(i2)) {
                                    this.esw = false;
                                    this.esv = true;
                                    z = true;
                                    break;
                                } else if (i < 0) {
                                    this.esw = true;
                                    this.esv = false;
                                    break;
                                }
                            } else {
                                this.esw = true;
                                this.esv = false;
                                break;
                            }
                        }
                    } else {
                        z = true;
                        break;
                    }
                    break;
            }
            this.deP = y;
            this.deO = x;
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
                this.deP = y;
                this.deO = x;
                return true;
            case 1:
                if (this.cEz < this.esC && this.esH != null) {
                    this.esH.onCancel();
                    break;
                }
                break;
            case 2:
                int i = x - this.deO;
                oP(y - this.deP);
                this.deP = y;
                this.deO = x;
                return true;
            case 3:
                break;
            default:
                return true;
        }
        bkz();
        reset();
        return true;
    }

    private void oP(int i) {
        int i2 = this.esE.topMargin + i;
        if (i2 > this.esA - esm) {
            i2 = this.esA - esm;
        } else if (i2 < (-esm)) {
            i2 = -esm;
        }
        this.esE.topMargin = i2;
        this.esD.setLayoutParams(this.esE);
        this.esy += i;
        if (this.esy > this.esA) {
            this.esy = this.esA;
        } else if (this.esy < 0) {
            this.esy = 0;
        }
        this.cEz = (this.esy * 1.0d) / this.esA;
        if (this.esF != null) {
            this.esF.t(this.cEz);
        }
    }

    private void bkz() {
        if (this.cEz >= this.esC) {
            this.isLoading = true;
            this.esJ = ValueAnimator.ofFloat(this.esE.topMargin, this.esB);
            this.esJ.setDuration(150L);
            this.esJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    PullRefreshFrameLayout.this.esE.topMargin = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    PullRefreshFrameLayout.this.esD.setLayoutParams(PullRefreshFrameLayout.this.esE);
                }
            });
            this.esJ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    if (PullRefreshFrameLayout.this.esI != null) {
                        PullRefreshFrameLayout.this.esI.bkC();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (PullRefreshFrameLayout.this.esG != null) {
                        PullRefreshFrameLayout.this.esG.bkD();
                    }
                    PullRefreshFrameLayout.this.esD.playAnimation();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.esJ.start();
            this.esF.c(this.esE.topMargin - this.esB, (this.esB * 1.0d) / this.esE.topMargin);
            return;
        }
        bkA();
    }

    public void bkA() {
        hideLoading();
        if (this.esF != null) {
            this.esF.bkE();
        }
    }

    public void dismissLoading() {
        if (this.isLoading) {
            hideLoading();
        }
    }

    private void hideLoading() {
        this.isLoading = false;
        if (this.esE.topMargin > (-esm)) {
            this.esJ = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.esJ.setDuration(300L);
            final int i = this.esE.topMargin;
            this.esJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (((float) (floatValue * 0.3d)) <= 0.0f) {
                    }
                    PullRefreshFrameLayout.this.esD.setAlpha(floatValue);
                    PullRefreshFrameLayout.this.esE.topMargin = (int) (floatValue * i);
                    PullRefreshFrameLayout.this.esD.setLayoutParams(PullRefreshFrameLayout.this.esE);
                }
            });
            this.esJ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    PullRefreshFrameLayout.this.esE.topMargin = -PullRefreshFrameLayout.esm;
                    PullRefreshFrameLayout.this.esD.setLayoutParams(PullRefreshFrameLayout.this.esE);
                    PullRefreshFrameLayout.this.esD.cancelAnimation();
                    PullRefreshFrameLayout.this.esD.setFrame(0);
                    PullRefreshFrameLayout.this.esD.setAlpha(1.0f);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.esJ.start();
        }
    }

    private void reset() {
        this.cEz = 0.0d;
        this.deP = 0;
        this.deO = 0;
        this.esy = 0;
        this.esv = false;
        this.esw = false;
    }

    public void setOnTouchCallback(d dVar) {
        this.esF = dVar;
    }

    public void setOnPullRefreshListener(c cVar) {
        this.esG = cVar;
    }

    public void setOnCancelCallBack(a aVar) {
        this.esH = aVar;
    }

    public void setOnLoadingStartCallback(b bVar) {
        this.esI = bVar;
    }

    public void onDestroy() {
        if (this.esD != null) {
            this.esD.clearAnimation();
        }
        if (this.esJ != null) {
            this.esJ.cancel();
            this.esJ.removeAllListeners();
            this.esJ.removeAllUpdateListeners();
            this.esJ = null;
        }
        this.esF = null;
        this.esG = null;
        this.esH = null;
    }

    public void bkB() {
        this.esD.bringToFront();
    }

    public void setRefreshing(boolean z) {
        if (z && this.esz) {
            this.esE.topMargin = this.esB;
            this.esD.setLayoutParams(this.esE);
            this.esD.playAnimation();
            return;
        }
        hideLoading();
    }

    public void setEnable(boolean z) {
        this.esz = z;
    }

    public boolean isEnable() {
        return this.esz;
    }

    public boolean isLoading() {
        return this.isLoading;
    }
}
