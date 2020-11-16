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
    private static final int eTU = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds144);
    private static final int eTV = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds210);
    private static final int eTW = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    public static final int eTX = eTV + eTU;
    public static final int eTY = eTW + eTU;
    private static final int eTZ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds135);
    private static final int eUa = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds230);
    private static final float eUb = (float) ((eTZ * 1.0d) / eTV);
    private static final float eUc = (float) ((eUa * 1.0d) / eTW);
    private int Wc;
    private int dFF;
    private double dfo;
    boolean eUd;
    boolean eUe;
    boolean eUf;
    private int eUg;
    private boolean eUh;
    private int eUi;
    private int eUj;
    private float eUk;
    private boolean eUl;
    private boolean eUm;
    private ContinuousAnimationView eUn;
    private FrameLayout.LayoutParams eUo;
    private d eUp;
    private c eUq;
    private a eUr;
    private b eUs;
    private ValueAnimator eUt;
    private final Animator.AnimatorListener eUu;
    private boolean isLoading;

    /* loaded from: classes.dex */
    public interface a {
        void onCancel();
    }

    /* loaded from: classes.dex */
    public interface b {
        void brQ();
    }

    /* loaded from: classes.dex */
    public interface c {
        void brR();
    }

    /* loaded from: classes.dex */
    public interface d {
        void brS();

        void c(int i, double d);

        void w(double d);
    }

    public PullRefreshFrameLayout(Context context) {
        super(context);
        this.eUd = false;
        this.eUe = false;
        this.eUf = false;
        this.isLoading = false;
        this.eUh = true;
        this.eUi = eTX;
        this.eUj = eTZ;
        this.eUk = eUb;
        this.eUm = false;
        this.eUu = new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (!PullRefreshFrameLayout.this.eUm) {
                    PullRefreshFrameLayout.this.eUm = true;
                    PullRefreshFrameLayout.this.eUn.setMinAndMaxFrame(19, 42);
                }
            }
        };
        init();
    }

    public PullRefreshFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eUd = false;
        this.eUe = false;
        this.eUf = false;
        this.isLoading = false;
        this.eUh = true;
        this.eUi = eTX;
        this.eUj = eTZ;
        this.eUk = eUb;
        this.eUm = false;
        this.eUu = new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (!PullRefreshFrameLayout.this.eUm) {
                    PullRefreshFrameLayout.this.eUm = true;
                    PullRefreshFrameLayout.this.eUn.setMinAndMaxFrame(19, 42);
                }
            }
        };
        init();
    }

    public PullRefreshFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eUd = false;
        this.eUe = false;
        this.eUf = false;
        this.isLoading = false;
        this.eUh = true;
        this.eUi = eTX;
        this.eUj = eTZ;
        this.eUk = eUb;
        this.eUm = false;
        this.eUu = new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (!PullRefreshFrameLayout.this.eUm) {
                    PullRefreshFrameLayout.this.eUm = true;
                    PullRefreshFrameLayout.this.eUn.setMinAndMaxFrame(19, 42);
                }
            }
        };
        init();
    }

    private void init() {
        this.eUn = new ContinuousAnimationView(getContext());
        this.eUo = new FrameLayout.LayoutParams(eTU, eTU);
        this.eUo.gravity = 49;
        this.eUo.topMargin = -eTU;
        this.eUn.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.eUn, this.eUo);
        this.eUn.bringToFront();
        this.eUn.setMinAndMaxProgress(0.0f, 1.0f);
        this.eUn.setSpeed(1.3f);
        this.eUn.setAnimation(R.raw.lottie_frs_refresh);
    }

    public void setInterceptScrollDown(boolean z) {
        this.eUf = z;
    }

    public void setFromFrs() {
        this.eUi = eTY;
        this.eUj = eUa;
        this.eUk = eUc;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!this.isLoading && this.eUh) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            switch (motionEvent.getAction()) {
                case 0:
                    this.eUd = false;
                    this.eUe = false;
                    this.Wc = y;
                    this.dFF = x;
                    break;
                case 1:
                case 3:
                    reset();
                    break;
                case 2:
                    int i = y - this.Wc;
                    int i2 = x - this.dFF;
                    if (!this.eUd) {
                        if (!this.eUe) {
                            if (this.eUf) {
                                if (i > 0 && Math.abs(i) > Math.abs(i2)) {
                                    this.eUe = false;
                                    this.eUd = true;
                                    z = true;
                                    break;
                                } else if (i < 0) {
                                    this.eUe = true;
                                    this.eUd = false;
                                    break;
                                }
                            } else {
                                this.eUe = true;
                                this.eUd = false;
                                break;
                            }
                        }
                    } else {
                        z = true;
                        break;
                    }
                    break;
            }
            this.Wc = y;
            this.dFF = x;
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
        this.eUl = false;
        switch (motionEvent.getAction()) {
            case 0:
                this.Wc = y;
                this.dFF = x;
                break;
            case 1:
                if (this.dfo < this.eUk && this.eUr != null) {
                    this.eUr.onCancel();
                }
                brM();
                reset();
                break;
            case 2:
                int i = y - this.Wc;
                int i2 = x - this.dFF;
                if (i > 0) {
                    this.eUl = true;
                }
                qt(i);
                this.Wc = y;
                this.dFF = x;
                break;
            case 3:
                brM();
                reset();
                break;
        }
        return true;
    }

    private void qt(int i) {
        int i2 = this.eUo.topMargin + i;
        if (i2 > this.eUi - eTU) {
            i2 = this.eUi - eTU;
        } else if (i2 < (-eTU)) {
            i2 = -eTU;
        }
        this.eUo.topMargin = i2;
        this.eUn.setLayoutParams(this.eUo);
        this.eUg += i;
        if (this.eUg > this.eUi) {
            this.eUg = this.eUi;
        } else if (this.eUg < 0) {
            this.eUg = 0;
        }
        this.dfo = (this.eUg * 1.0d) / this.eUi;
        if (this.eUp != null) {
            this.eUp.w(this.dfo);
        }
    }

    private void brM() {
        if (this.dfo >= this.eUk) {
            this.isLoading = true;
            this.eUt = ValueAnimator.ofFloat(this.eUo.topMargin, this.eUj);
            this.eUt.setDuration(150L);
            this.eUt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    PullRefreshFrameLayout.this.eUo.topMargin = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    PullRefreshFrameLayout.this.eUn.setLayoutParams(PullRefreshFrameLayout.this.eUo);
                }
            });
            this.eUt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    if (PullRefreshFrameLayout.this.eUs != null) {
                        PullRefreshFrameLayout.this.eUs.brQ();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (PullRefreshFrameLayout.this.eUq != null) {
                        PullRefreshFrameLayout.this.eUq.brR();
                    }
                    PullRefreshFrameLayout.this.eUn.playAnimation();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.eUt.start();
            this.eUp.c(this.eUo.topMargin - this.eUj, (this.eUj * 1.0d) / this.eUo.topMargin);
            return;
        }
        brN();
    }

    public void brN() {
        hideLoading();
        if (this.eUp != null) {
            this.eUp.brS();
        }
    }

    public void dismissLoading() {
        if (this.isLoading) {
            hideLoading();
        }
    }

    private void hideLoading() {
        this.isLoading = false;
        if (this.eUo.topMargin > (-eTU)) {
            this.eUt = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.eUt.setDuration(300L);
            final int i = this.eUo.topMargin;
            this.eUt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (((float) (floatValue * 0.3d)) <= 0.0f) {
                    }
                    PullRefreshFrameLayout.this.eUn.setAlpha(floatValue);
                    PullRefreshFrameLayout.this.eUo.topMargin = (int) (floatValue * i);
                    PullRefreshFrameLayout.this.eUn.setLayoutParams(PullRefreshFrameLayout.this.eUo);
                }
            });
            this.eUt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    PullRefreshFrameLayout.this.eUo.topMargin = -PullRefreshFrameLayout.eTU;
                    PullRefreshFrameLayout.this.eUn.setLayoutParams(PullRefreshFrameLayout.this.eUo);
                    PullRefreshFrameLayout.this.eUn.cancelAnimation();
                    PullRefreshFrameLayout.this.eUn.setFrame(0);
                    PullRefreshFrameLayout.this.eUn.setMinAndMaxProgress(0.0f, 1.0f);
                    PullRefreshFrameLayout.this.eUn.setAlpha(1.0f);
                    PullRefreshFrameLayout.this.eUn.loop(false);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.eUt.start();
        }
    }

    private void reset() {
        this.dfo = 0.0d;
        this.Wc = 0;
        this.dFF = 0;
        this.eUg = 0;
        this.eUd = false;
        this.eUe = false;
    }

    public void setOnTouchCallback(d dVar) {
        this.eUp = dVar;
    }

    public void setOnPullRefreshListener(c cVar) {
        this.eUq = cVar;
    }

    public void setOnCancelCallBack(a aVar) {
        this.eUr = aVar;
    }

    public void setOnLoadingStartCallback(b bVar) {
        this.eUs = bVar;
    }

    public void onDestroy() {
        if (this.eUn != null) {
            this.eUn.clearAnimation();
        }
        if (this.eUt != null) {
            this.eUt.cancel();
            this.eUt.removeAllListeners();
            this.eUt.removeAllUpdateListeners();
            this.eUt = null;
        }
        this.eUp = null;
        this.eUq = null;
        this.eUr = null;
    }

    public void brO() {
        this.eUn.bringToFront();
    }

    public void setRefreshing(boolean z) {
        if (z && this.eUh) {
            this.eUo.topMargin = this.eUj;
            this.eUn.setLayoutParams(this.eUo);
            this.eUm = false;
            this.eUn.loop(true);
            this.eUn.setMinFrame(10);
            this.eUn.setRepeatMode(1);
            this.eUn.removeAllAnimatorListeners();
            this.eUn.addAnimatorListener(this.eUu);
            this.eUn.playAnimation();
            return;
        }
        hideLoading();
    }

    public void setEnable(boolean z) {
        this.eUh = z;
    }

    public boolean isEnable() {
        return this.eUh;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public void brP() {
        if (this.eUl && this.eUn != null) {
            this.eUn.setAlpha((float) this.dfo);
            this.eUn.setFrame((int) (this.dfo * 10.0d));
        }
    }
}
