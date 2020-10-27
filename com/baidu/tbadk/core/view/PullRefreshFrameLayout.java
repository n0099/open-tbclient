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
    private static final int eOX = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds62);
    private static final int eOY = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds210);
    private static final int eOZ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    public static final int ePa = eOY + eOX;
    public static final int ePb = eOZ + eOX;
    private static final int ePc = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds135);
    private static final int ePd = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds230);
    private static final float ePe = (float) ((ePc * 1.0d) / eOY);
    private static final float ePf = (float) ((ePd * 1.0d) / eOZ);
    private int dBu;
    private int dBv;
    private double dba;
    boolean ePg;
    boolean ePh;
    boolean ePi;
    private int ePj;
    private boolean ePk;
    private int ePl;
    private int ePm;
    private float ePn;
    private ContinuousAnimationView ePo;
    private FrameLayout.LayoutParams ePp;
    private d ePq;
    private c ePr;
    private a ePs;
    private b ePt;
    private ValueAnimator ePu;
    private boolean isLoading;

    /* loaded from: classes.dex */
    public interface a {
        void onCancel();
    }

    /* loaded from: classes.dex */
    public interface b {
        void bqa();
    }

    /* loaded from: classes.dex */
    public interface c {
        void bqb();
    }

    /* loaded from: classes.dex */
    public interface d {
        void bqc();

        void c(int i, double d);

        void x(double d);
    }

    public PullRefreshFrameLayout(Context context) {
        super(context);
        this.ePg = false;
        this.ePh = false;
        this.ePi = false;
        this.isLoading = false;
        this.ePk = true;
        this.ePl = ePa;
        this.ePm = ePc;
        this.ePn = ePe;
        init();
    }

    public PullRefreshFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ePg = false;
        this.ePh = false;
        this.ePi = false;
        this.isLoading = false;
        this.ePk = true;
        this.ePl = ePa;
        this.ePm = ePc;
        this.ePn = ePe;
        init();
    }

    public PullRefreshFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ePg = false;
        this.ePh = false;
        this.ePi = false;
        this.isLoading = false;
        this.ePk = true;
        this.ePl = ePa;
        this.ePm = ePc;
        this.ePn = ePe;
        init();
    }

    private void init() {
        this.ePo = new ContinuousAnimationView(getContext());
        this.ePp = new FrameLayout.LayoutParams(eOX, eOX);
        this.ePp.gravity = 49;
        this.ePp.topMargin = -eOX;
        this.ePo.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.ePo, this.ePp);
        this.ePo.bringToFront();
        this.ePo.setAnimation(R.raw.ad_refresh_load);
    }

    public void setInterceptScrollDown(boolean z) {
        this.ePi = z;
    }

    public void setFromFrs() {
        this.ePl = ePb;
        this.ePm = ePd;
        this.ePn = ePf;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!this.isLoading && this.ePk) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            switch (motionEvent.getAction()) {
                case 0:
                    this.ePg = false;
                    this.ePh = false;
                    this.dBv = y;
                    this.dBu = x;
                    break;
                case 1:
                case 3:
                    reset();
                    break;
                case 2:
                    int i = y - this.dBv;
                    int i2 = x - this.dBu;
                    if (!this.ePg) {
                        if (!this.ePh) {
                            if (this.ePi) {
                                if (i > 0 && Math.abs(i) > Math.abs(i2)) {
                                    this.ePh = false;
                                    this.ePg = true;
                                    z = true;
                                    break;
                                } else if (i < 0) {
                                    this.ePh = true;
                                    this.ePg = false;
                                    break;
                                }
                            } else {
                                this.ePh = true;
                                this.ePg = false;
                                break;
                            }
                        }
                    } else {
                        z = true;
                        break;
                    }
                    break;
            }
            this.dBv = y;
            this.dBu = x;
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
                this.dBv = y;
                this.dBu = x;
                return true;
            case 1:
                if (this.dba < this.ePn && this.ePs != null) {
                    this.ePs.onCancel();
                    break;
                }
                break;
            case 2:
                int i = x - this.dBu;
                pL(y - this.dBv);
                this.dBv = y;
                this.dBu = x;
                return true;
            case 3:
                break;
            default:
                return true;
        }
        bpX();
        reset();
        return true;
    }

    private void pL(int i) {
        int i2 = this.ePp.topMargin + i;
        if (i2 > this.ePl - eOX) {
            i2 = this.ePl - eOX;
        } else if (i2 < (-eOX)) {
            i2 = -eOX;
        }
        this.ePp.topMargin = i2;
        this.ePo.setLayoutParams(this.ePp);
        this.ePj += i;
        if (this.ePj > this.ePl) {
            this.ePj = this.ePl;
        } else if (this.ePj < 0) {
            this.ePj = 0;
        }
        this.dba = (this.ePj * 1.0d) / this.ePl;
        if (this.ePq != null) {
            this.ePq.x(this.dba);
        }
    }

    private void bpX() {
        if (this.dba >= this.ePn) {
            this.isLoading = true;
            this.ePu = ValueAnimator.ofFloat(this.ePp.topMargin, this.ePm);
            this.ePu.setDuration(150L);
            this.ePu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    PullRefreshFrameLayout.this.ePp.topMargin = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    PullRefreshFrameLayout.this.ePo.setLayoutParams(PullRefreshFrameLayout.this.ePp);
                }
            });
            this.ePu.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    if (PullRefreshFrameLayout.this.ePt != null) {
                        PullRefreshFrameLayout.this.ePt.bqa();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (PullRefreshFrameLayout.this.ePr != null) {
                        PullRefreshFrameLayout.this.ePr.bqb();
                    }
                    PullRefreshFrameLayout.this.ePo.playAnimation();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.ePu.start();
            this.ePq.c(this.ePp.topMargin - this.ePm, (this.ePm * 1.0d) / this.ePp.topMargin);
            return;
        }
        bpY();
    }

    public void bpY() {
        hideLoading();
        if (this.ePq != null) {
            this.ePq.bqc();
        }
    }

    public void dismissLoading() {
        if (this.isLoading) {
            hideLoading();
        }
    }

    private void hideLoading() {
        this.isLoading = false;
        if (this.ePp.topMargin > (-eOX)) {
            this.ePu = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.ePu.setDuration(300L);
            final int i = this.ePp.topMargin;
            this.ePu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (((float) (floatValue * 0.3d)) <= 0.0f) {
                    }
                    PullRefreshFrameLayout.this.ePo.setAlpha(floatValue);
                    PullRefreshFrameLayout.this.ePp.topMargin = (int) (floatValue * i);
                    PullRefreshFrameLayout.this.ePo.setLayoutParams(PullRefreshFrameLayout.this.ePp);
                }
            });
            this.ePu.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    PullRefreshFrameLayout.this.ePp.topMargin = -PullRefreshFrameLayout.eOX;
                    PullRefreshFrameLayout.this.ePo.setLayoutParams(PullRefreshFrameLayout.this.ePp);
                    PullRefreshFrameLayout.this.ePo.cancelAnimation();
                    PullRefreshFrameLayout.this.ePo.setFrame(0);
                    PullRefreshFrameLayout.this.ePo.setAlpha(1.0f);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.ePu.start();
        }
    }

    private void reset() {
        this.dba = 0.0d;
        this.dBv = 0;
        this.dBu = 0;
        this.ePj = 0;
        this.ePg = false;
        this.ePh = false;
    }

    public void setOnTouchCallback(d dVar) {
        this.ePq = dVar;
    }

    public void setOnPullRefreshListener(c cVar) {
        this.ePr = cVar;
    }

    public void setOnCancelCallBack(a aVar) {
        this.ePs = aVar;
    }

    public void setOnLoadingStartCallback(b bVar) {
        this.ePt = bVar;
    }

    public void onDestroy() {
        if (this.ePo != null) {
            this.ePo.clearAnimation();
        }
        if (this.ePu != null) {
            this.ePu.cancel();
            this.ePu.removeAllListeners();
            this.ePu.removeAllUpdateListeners();
            this.ePu = null;
        }
        this.ePq = null;
        this.ePr = null;
        this.ePs = null;
    }

    public void bpZ() {
        this.ePo.bringToFront();
    }

    public void setRefreshing(boolean z) {
        if (z && this.ePk) {
            this.ePp.topMargin = this.ePm;
            this.ePo.setLayoutParams(this.ePp);
            this.ePo.playAnimation();
            return;
        }
        hideLoading();
    }

    public void setEnable(boolean z) {
        this.ePk = z;
    }

    public boolean isEnable() {
        return this.ePk;
    }

    public boolean isLoading() {
        return this.isLoading;
    }
}
