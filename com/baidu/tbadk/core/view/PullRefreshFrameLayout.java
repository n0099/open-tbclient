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
    private static final int eur = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds62);
    private static final int eus = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds210);
    private static final int eut = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    public static final int euu = eus + eur;
    public static final int euv = eut + eur;
    private static final int euw = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds135);
    private static final int eux = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds230);
    private static final float euy = (float) ((euw * 1.0d) / eus);
    private static final float euz = (float) ((eux * 1.0d) / eut);
    private double cGz;
    private int dgO;
    private int dgP;
    boolean euA;
    boolean euB;
    boolean euC;
    private int euD;
    private boolean euE;
    private int euF;
    private int euG;
    private float euH;
    private ContinuousAnimationView euI;
    private FrameLayout.LayoutParams euJ;
    private d euK;
    private c euL;
    private a euM;
    private b euN;
    private ValueAnimator euO;
    private boolean isLoading;

    /* loaded from: classes.dex */
    public interface a {
        void onCancel();
    }

    /* loaded from: classes.dex */
    public interface b {
        void blx();
    }

    /* loaded from: classes.dex */
    public interface c {
        void bly();
    }

    /* loaded from: classes.dex */
    public interface d {
        void blz();

        void c(int i, double d);

        void t(double d);
    }

    public PullRefreshFrameLayout(Context context) {
        super(context);
        this.euA = false;
        this.euB = false;
        this.euC = false;
        this.isLoading = false;
        this.euE = true;
        this.euF = euu;
        this.euG = euw;
        this.euH = euy;
        init();
    }

    public PullRefreshFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.euA = false;
        this.euB = false;
        this.euC = false;
        this.isLoading = false;
        this.euE = true;
        this.euF = euu;
        this.euG = euw;
        this.euH = euy;
        init();
    }

    public PullRefreshFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.euA = false;
        this.euB = false;
        this.euC = false;
        this.isLoading = false;
        this.euE = true;
        this.euF = euu;
        this.euG = euw;
        this.euH = euy;
        init();
    }

    private void init() {
        this.euI = new ContinuousAnimationView(getContext());
        this.euJ = new FrameLayout.LayoutParams(eur, eur);
        this.euJ.gravity = 49;
        this.euJ.topMargin = -eur;
        this.euI.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.euI, this.euJ);
        this.euI.bringToFront();
        this.euI.setAnimation(R.raw.ad_refresh_load);
    }

    public void setInterceptScrollDown(boolean z) {
        this.euC = z;
    }

    public void setFromFrs() {
        this.euF = euv;
        this.euG = eux;
        this.euH = euz;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!this.isLoading && this.euE) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            switch (motionEvent.getAction()) {
                case 0:
                    this.euA = false;
                    this.euB = false;
                    this.dgP = y;
                    this.dgO = x;
                    break;
                case 1:
                case 3:
                    reset();
                    break;
                case 2:
                    int i = y - this.dgP;
                    int i2 = x - this.dgO;
                    if (!this.euA) {
                        if (!this.euB) {
                            if (this.euC) {
                                if (i > 0 && Math.abs(i) > Math.abs(i2)) {
                                    this.euB = false;
                                    this.euA = true;
                                    z = true;
                                    break;
                                } else if (i < 0) {
                                    this.euB = true;
                                    this.euA = false;
                                    break;
                                }
                            } else {
                                this.euB = true;
                                this.euA = false;
                                break;
                            }
                        }
                    } else {
                        z = true;
                        break;
                    }
                    break;
            }
            this.dgP = y;
            this.dgO = x;
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
                this.dgP = y;
                this.dgO = x;
                return true;
            case 1:
                if (this.cGz < this.euH && this.euM != null) {
                    this.euM.onCancel();
                    break;
                }
                break;
            case 2:
                int i = x - this.dgO;
                pb(y - this.dgP);
                this.dgP = y;
                this.dgO = x;
                return true;
            case 3:
                break;
            default:
                return true;
        }
        blu();
        reset();
        return true;
    }

    private void pb(int i) {
        int i2 = this.euJ.topMargin + i;
        if (i2 > this.euF - eur) {
            i2 = this.euF - eur;
        } else if (i2 < (-eur)) {
            i2 = -eur;
        }
        this.euJ.topMargin = i2;
        this.euI.setLayoutParams(this.euJ);
        this.euD += i;
        if (this.euD > this.euF) {
            this.euD = this.euF;
        } else if (this.euD < 0) {
            this.euD = 0;
        }
        this.cGz = (this.euD * 1.0d) / this.euF;
        if (this.euK != null) {
            this.euK.t(this.cGz);
        }
    }

    private void blu() {
        if (this.cGz >= this.euH) {
            this.isLoading = true;
            this.euO = ValueAnimator.ofFloat(this.euJ.topMargin, this.euG);
            this.euO.setDuration(150L);
            this.euO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    PullRefreshFrameLayout.this.euJ.topMargin = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    PullRefreshFrameLayout.this.euI.setLayoutParams(PullRefreshFrameLayout.this.euJ);
                }
            });
            this.euO.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    if (PullRefreshFrameLayout.this.euN != null) {
                        PullRefreshFrameLayout.this.euN.blx();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (PullRefreshFrameLayout.this.euL != null) {
                        PullRefreshFrameLayout.this.euL.bly();
                    }
                    PullRefreshFrameLayout.this.euI.playAnimation();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.euO.start();
            this.euK.c(this.euJ.topMargin - this.euG, (this.euG * 1.0d) / this.euJ.topMargin);
            return;
        }
        blv();
    }

    public void blv() {
        hideLoading();
        if (this.euK != null) {
            this.euK.blz();
        }
    }

    public void dismissLoading() {
        if (this.isLoading) {
            hideLoading();
        }
    }

    private void hideLoading() {
        this.isLoading = false;
        if (this.euJ.topMargin > (-eur)) {
            this.euO = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.euO.setDuration(300L);
            final int i = this.euJ.topMargin;
            this.euO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (((float) (floatValue * 0.3d)) <= 0.0f) {
                    }
                    PullRefreshFrameLayout.this.euI.setAlpha(floatValue);
                    PullRefreshFrameLayout.this.euJ.topMargin = (int) (floatValue * i);
                    PullRefreshFrameLayout.this.euI.setLayoutParams(PullRefreshFrameLayout.this.euJ);
                }
            });
            this.euO.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    PullRefreshFrameLayout.this.euJ.topMargin = -PullRefreshFrameLayout.eur;
                    PullRefreshFrameLayout.this.euI.setLayoutParams(PullRefreshFrameLayout.this.euJ);
                    PullRefreshFrameLayout.this.euI.cancelAnimation();
                    PullRefreshFrameLayout.this.euI.setFrame(0);
                    PullRefreshFrameLayout.this.euI.setAlpha(1.0f);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.euO.start();
        }
    }

    private void reset() {
        this.cGz = 0.0d;
        this.dgP = 0;
        this.dgO = 0;
        this.euD = 0;
        this.euA = false;
        this.euB = false;
    }

    public void setOnTouchCallback(d dVar) {
        this.euK = dVar;
    }

    public void setOnPullRefreshListener(c cVar) {
        this.euL = cVar;
    }

    public void setOnCancelCallBack(a aVar) {
        this.euM = aVar;
    }

    public void setOnLoadingStartCallback(b bVar) {
        this.euN = bVar;
    }

    public void onDestroy() {
        if (this.euI != null) {
            this.euI.clearAnimation();
        }
        if (this.euO != null) {
            this.euO.cancel();
            this.euO.removeAllListeners();
            this.euO.removeAllUpdateListeners();
            this.euO = null;
        }
        this.euK = null;
        this.euL = null;
        this.euM = null;
    }

    public void blw() {
        this.euI.bringToFront();
    }

    public void setRefreshing(boolean z) {
        if (z && this.euE) {
            this.euJ.topMargin = this.euG;
            this.euI.setLayoutParams(this.euJ);
            this.euI.playAnimation();
            return;
        }
        hideLoading();
    }

    public void setEnable(boolean z) {
        this.euE = z;
    }

    public boolean isEnable() {
        return this.euE;
    }

    public boolean isLoading() {
        return this.isLoading;
    }
}
