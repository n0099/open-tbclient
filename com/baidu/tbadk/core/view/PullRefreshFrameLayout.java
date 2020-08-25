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
/* loaded from: classes2.dex */
public class PullRefreshFrameLayout extends FrameLayout {
    private static final int esi = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds62);
    private static final int esj = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds210);
    private static final int esk = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    public static final int esl = esj + esi;
    public static final int esm = esk + esi;
    private static final int esn = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds135);
    private static final int eso = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds230);
    private static final float esp = (float) ((esn * 1.0d) / esj);
    private static final float esq = (float) ((eso * 1.0d) / esk);
    private double cEv;
    private int deK;
    private int deL;
    private FrameLayout.LayoutParams esA;
    private d esB;
    private c esC;
    private a esD;
    private b esE;
    private ValueAnimator esF;
    boolean esr;
    boolean ess;
    boolean est;
    private int esu;
    private boolean esv;
    private int esw;
    private int esx;
    private float esy;
    private ContinuousAnimationView esz;
    private boolean isLoading;

    /* loaded from: classes2.dex */
    public interface a {
        void onCancel();
    }

    /* loaded from: classes2.dex */
    public interface b {
        void bkC();
    }

    /* loaded from: classes2.dex */
    public interface c {
        void bkD();
    }

    /* loaded from: classes2.dex */
    public interface d {
        void bkE();

        void c(int i, double d);

        void t(double d);
    }

    public PullRefreshFrameLayout(Context context) {
        super(context);
        this.esr = false;
        this.ess = false;
        this.est = false;
        this.isLoading = false;
        this.esv = true;
        this.esw = esl;
        this.esx = esn;
        this.esy = esp;
        init();
    }

    public PullRefreshFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.esr = false;
        this.ess = false;
        this.est = false;
        this.isLoading = false;
        this.esv = true;
        this.esw = esl;
        this.esx = esn;
        this.esy = esp;
        init();
    }

    public PullRefreshFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.esr = false;
        this.ess = false;
        this.est = false;
        this.isLoading = false;
        this.esv = true;
        this.esw = esl;
        this.esx = esn;
        this.esy = esp;
        init();
    }

    private void init() {
        this.esz = new ContinuousAnimationView(getContext());
        this.esA = new FrameLayout.LayoutParams(esi, esi);
        this.esA.gravity = 49;
        this.esA.topMargin = -esi;
        this.esz.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.esz, this.esA);
        this.esz.bringToFront();
        this.esz.setAnimation(R.raw.ad_refresh_load);
    }

    public void setInterceptScrollDown(boolean z) {
        this.est = z;
    }

    public void setFromFrs() {
        this.esw = esm;
        this.esx = eso;
        this.esy = esq;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!this.isLoading && this.esv) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            switch (motionEvent.getAction()) {
                case 0:
                    this.esr = false;
                    this.ess = false;
                    this.deL = y;
                    this.deK = x;
                    break;
                case 1:
                case 3:
                    reset();
                    break;
                case 2:
                    int i = y - this.deL;
                    int i2 = x - this.deK;
                    if (!this.esr) {
                        if (!this.ess) {
                            if (this.est) {
                                if (i > 0 && Math.abs(i) > Math.abs(i2)) {
                                    this.ess = false;
                                    this.esr = true;
                                    z = true;
                                    break;
                                } else if (i < 0) {
                                    this.ess = true;
                                    this.esr = false;
                                    break;
                                }
                            } else {
                                this.ess = true;
                                this.esr = false;
                                break;
                            }
                        }
                    } else {
                        z = true;
                        break;
                    }
                    break;
            }
            this.deL = y;
            this.deK = x;
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
                this.deL = y;
                this.deK = x;
                return true;
            case 1:
                if (this.cEv < this.esy && this.esD != null) {
                    this.esD.onCancel();
                    break;
                }
                break;
            case 2:
                int i = x - this.deK;
                oP(y - this.deL);
                this.deL = y;
                this.deK = x;
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
        int i2 = this.esA.topMargin + i;
        if (i2 > this.esw - esi) {
            i2 = this.esw - esi;
        } else if (i2 < (-esi)) {
            i2 = -esi;
        }
        this.esA.topMargin = i2;
        this.esz.setLayoutParams(this.esA);
        this.esu += i;
        if (this.esu > this.esw) {
            this.esu = this.esw;
        } else if (this.esu < 0) {
            this.esu = 0;
        }
        this.cEv = (this.esu * 1.0d) / this.esw;
        if (this.esB != null) {
            this.esB.t(this.cEv);
        }
    }

    private void bkz() {
        if (this.cEv >= this.esy) {
            this.isLoading = true;
            this.esF = ValueAnimator.ofFloat(this.esA.topMargin, this.esx);
            this.esF.setDuration(150L);
            this.esF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    PullRefreshFrameLayout.this.esA.topMargin = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    PullRefreshFrameLayout.this.esz.setLayoutParams(PullRefreshFrameLayout.this.esA);
                }
            });
            this.esF.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    if (PullRefreshFrameLayout.this.esE != null) {
                        PullRefreshFrameLayout.this.esE.bkC();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (PullRefreshFrameLayout.this.esC != null) {
                        PullRefreshFrameLayout.this.esC.bkD();
                    }
                    PullRefreshFrameLayout.this.esz.playAnimation();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.esF.start();
            this.esB.c(this.esA.topMargin - this.esx, (this.esx * 1.0d) / this.esA.topMargin);
            return;
        }
        bkA();
    }

    public void bkA() {
        hideLoading();
        if (this.esB != null) {
            this.esB.bkE();
        }
    }

    public void dismissLoading() {
        if (this.isLoading) {
            hideLoading();
        }
    }

    private void hideLoading() {
        this.isLoading = false;
        if (this.esA.topMargin > (-esi)) {
            this.esF = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.esF.setDuration(300L);
            final int i = this.esA.topMargin;
            this.esF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (((float) (floatValue * 0.3d)) <= 0.0f) {
                    }
                    PullRefreshFrameLayout.this.esz.setAlpha(floatValue);
                    PullRefreshFrameLayout.this.esA.topMargin = (int) (floatValue * i);
                    PullRefreshFrameLayout.this.esz.setLayoutParams(PullRefreshFrameLayout.this.esA);
                }
            });
            this.esF.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    PullRefreshFrameLayout.this.esA.topMargin = -PullRefreshFrameLayout.esi;
                    PullRefreshFrameLayout.this.esz.setLayoutParams(PullRefreshFrameLayout.this.esA);
                    PullRefreshFrameLayout.this.esz.cancelAnimation();
                    PullRefreshFrameLayout.this.esz.setFrame(0);
                    PullRefreshFrameLayout.this.esz.setAlpha(1.0f);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.esF.start();
        }
    }

    private void reset() {
        this.cEv = 0.0d;
        this.deL = 0;
        this.deK = 0;
        this.esu = 0;
        this.esr = false;
        this.ess = false;
    }

    public void setOnTouchCallback(d dVar) {
        this.esB = dVar;
    }

    public void setOnPullRefreshListener(c cVar) {
        this.esC = cVar;
    }

    public void setOnCancelCallBack(a aVar) {
        this.esD = aVar;
    }

    public void setOnLoadingStartCallback(b bVar) {
        this.esE = bVar;
    }

    public void onDestroy() {
        if (this.esz != null) {
            this.esz.clearAnimation();
        }
        if (this.esF != null) {
            this.esF.cancel();
            this.esF.removeAllListeners();
            this.esF.removeAllUpdateListeners();
            this.esF = null;
        }
        this.esB = null;
        this.esC = null;
        this.esD = null;
    }

    public void bkB() {
        this.esz.bringToFront();
    }

    public void setRefreshing(boolean z) {
        if (z && this.esv) {
            this.esA.topMargin = this.esx;
            this.esz.setLayoutParams(this.esA);
            this.esz.playAnimation();
            return;
        }
        hideLoading();
    }

    public void setEnable(boolean z) {
        this.esv = z;
    }

    public boolean isEnable() {
        return this.esv;
    }

    public boolean isLoading() {
        return this.isLoading;
    }
}
