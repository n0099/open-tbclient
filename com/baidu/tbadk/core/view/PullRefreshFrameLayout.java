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
    private static final int fkh = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds144);
    private static final int fki = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds210);
    private static final int fkj = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    public static final int fkk = fki + fkh;
    public static final int fkl = fkj + fkh;
    private static final int fkm = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds135);
    private static final int fkn = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds230);
    private static final float fko = (float) ((fkm * 1.0d) / fki);
    private static final float fkp = (float) ((fkn * 1.0d) / fkj);
    private int Yl;
    private int dUr;
    private double dql;
    private ContinuousAnimationView fkA;
    private FrameLayout.LayoutParams fkB;
    private d fkC;
    private c fkD;
    private a fkE;
    private b fkF;
    private ValueAnimator fkG;
    boolean fkq;
    boolean fkr;
    boolean fks;
    private int fkt;
    private boolean fku;
    private int fkv;
    private int fkw;
    private float fkx;
    private boolean fky;
    private boolean fkz;
    private boolean isLoading;
    private final Animator.AnimatorListener loadViewAnimListener;

    /* loaded from: classes.dex */
    public interface a {
        void onCancel();
    }

    /* loaded from: classes.dex */
    public interface b {
        void buo();
    }

    /* loaded from: classes.dex */
    public interface c {
        void bup();
    }

    /* loaded from: classes.dex */
    public interface d {
        void b(int i, double d);

        void buq();

        void q(double d);
    }

    public PullRefreshFrameLayout(Context context) {
        super(context);
        this.fkq = false;
        this.fkr = false;
        this.fks = false;
        this.isLoading = false;
        this.fku = true;
        this.fkv = fkk;
        this.fkw = fkm;
        this.fkx = fko;
        this.fkz = false;
        this.loadViewAnimListener = new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.1
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
                if (!PullRefreshFrameLayout.this.fkz) {
                    PullRefreshFrameLayout.this.fkz = true;
                    PullRefreshFrameLayout.this.fkA.setMinAndMaxFrame(19, 42);
                }
            }
        };
        init();
    }

    public PullRefreshFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fkq = false;
        this.fkr = false;
        this.fks = false;
        this.isLoading = false;
        this.fku = true;
        this.fkv = fkk;
        this.fkw = fkm;
        this.fkx = fko;
        this.fkz = false;
        this.loadViewAnimListener = new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.1
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
                if (!PullRefreshFrameLayout.this.fkz) {
                    PullRefreshFrameLayout.this.fkz = true;
                    PullRefreshFrameLayout.this.fkA.setMinAndMaxFrame(19, 42);
                }
            }
        };
        init();
    }

    public PullRefreshFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fkq = false;
        this.fkr = false;
        this.fks = false;
        this.isLoading = false;
        this.fku = true;
        this.fkv = fkk;
        this.fkw = fkm;
        this.fkx = fko;
        this.fkz = false;
        this.loadViewAnimListener = new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.1
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
                if (!PullRefreshFrameLayout.this.fkz) {
                    PullRefreshFrameLayout.this.fkz = true;
                    PullRefreshFrameLayout.this.fkA.setMinAndMaxFrame(19, 42);
                }
            }
        };
        init();
    }

    private void init() {
        this.fkA = new ContinuousAnimationView(getContext());
        this.fkB = new FrameLayout.LayoutParams(fkh, fkh);
        this.fkB.gravity = 49;
        this.fkB.topMargin = -fkh;
        this.fkA.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.fkA, this.fkB);
        this.fkA.bringToFront();
        this.fkA.setMinAndMaxProgress(0.0f, 1.0f);
        this.fkA.setSpeed(1.3f);
        this.fkA.setAnimation(R.raw.lottie_frs_refresh);
    }

    public void setInterceptScrollDown(boolean z) {
        this.fks = z;
    }

    public void setFromFrs() {
        this.fkv = fkl;
        this.fkw = fkn;
        this.fkx = fkp;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!this.isLoading && this.fku) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            switch (motionEvent.getAction()) {
                case 0:
                    this.fkq = false;
                    this.fkr = false;
                    this.Yl = y;
                    this.dUr = x;
                    break;
                case 1:
                case 3:
                    reset();
                    break;
                case 2:
                    int i = y - this.Yl;
                    int i2 = x - this.dUr;
                    if (!this.fkq) {
                        if (!this.fkr) {
                            if (this.fks) {
                                if (i > 0 && Math.abs(i) > Math.abs(i2)) {
                                    this.fkr = false;
                                    this.fkq = true;
                                    z = true;
                                    break;
                                } else if (i < 0) {
                                    this.fkr = true;
                                    this.fkq = false;
                                    break;
                                }
                            } else {
                                this.fkr = true;
                                this.fkq = false;
                                break;
                            }
                        }
                    } else {
                        z = true;
                        break;
                    }
                    break;
            }
            this.Yl = y;
            this.dUr = x;
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
        this.fky = false;
        switch (motionEvent.getAction()) {
            case 0:
                this.Yl = y;
                this.dUr = x;
                break;
            case 1:
                if (this.dql < this.fkx && this.fkE != null) {
                    this.fkE.onCancel();
                }
                buk();
                reset();
                break;
            case 2:
                int i = y - this.Yl;
                int i2 = x - this.dUr;
                if (i > 0) {
                    this.fky = true;
                }
                pG(i);
                this.Yl = y;
                this.dUr = x;
                break;
            case 3:
                buk();
                reset();
                break;
        }
        return true;
    }

    private void pG(int i) {
        int i2 = this.fkB.topMargin + i;
        if (i2 > this.fkv - fkh) {
            i2 = this.fkv - fkh;
        } else if (i2 < (-fkh)) {
            i2 = -fkh;
        }
        this.fkB.topMargin = i2;
        this.fkA.setLayoutParams(this.fkB);
        this.fkt += i;
        if (this.fkt > this.fkv) {
            this.fkt = this.fkv;
        } else if (this.fkt < 0) {
            this.fkt = 0;
        }
        this.dql = (this.fkt * 1.0d) / this.fkv;
        if (this.fkC != null) {
            this.fkC.q(this.dql);
        }
    }

    private void buk() {
        if (this.dql >= this.fkx) {
            this.isLoading = true;
            this.fkG = ValueAnimator.ofFloat(this.fkB.topMargin, this.fkw);
            this.fkG.setDuration(150L);
            this.fkG.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    PullRefreshFrameLayout.this.fkB.topMargin = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    PullRefreshFrameLayout.this.fkA.setLayoutParams(PullRefreshFrameLayout.this.fkB);
                }
            });
            this.fkG.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    if (PullRefreshFrameLayout.this.fkF != null) {
                        PullRefreshFrameLayout.this.fkF.buo();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (PullRefreshFrameLayout.this.fkD != null) {
                        PullRefreshFrameLayout.this.fkD.bup();
                    }
                    PullRefreshFrameLayout.this.fkA.playAnimation();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.fkG.start();
            this.fkC.b(this.fkB.topMargin - this.fkw, (this.fkw * 1.0d) / this.fkB.topMargin);
            return;
        }
        bul();
    }

    public void bul() {
        hideLoading();
        if (this.fkC != null) {
            this.fkC.buq();
        }
    }

    public void dismissLoading() {
        if (this.isLoading) {
            hideLoading();
        }
    }

    private void hideLoading() {
        this.isLoading = false;
        if (this.fkB.topMargin > (-fkh)) {
            this.fkG = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.fkG.setDuration(300L);
            final int i = this.fkB.topMargin;
            this.fkG.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (((float) (floatValue * 0.3d)) <= 0.0f) {
                    }
                    PullRefreshFrameLayout.this.fkA.setAlpha(floatValue);
                    PullRefreshFrameLayout.this.fkB.topMargin = (int) (floatValue * i);
                    PullRefreshFrameLayout.this.fkA.setLayoutParams(PullRefreshFrameLayout.this.fkB);
                }
            });
            this.fkG.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    PullRefreshFrameLayout.this.fkB.topMargin = -PullRefreshFrameLayout.fkh;
                    PullRefreshFrameLayout.this.fkA.setLayoutParams(PullRefreshFrameLayout.this.fkB);
                    PullRefreshFrameLayout.this.fkA.cancelAnimation();
                    PullRefreshFrameLayout.this.fkA.setFrame(0);
                    PullRefreshFrameLayout.this.fkA.setMinAndMaxProgress(0.0f, 1.0f);
                    PullRefreshFrameLayout.this.fkA.setAlpha(1.0f);
                    PullRefreshFrameLayout.this.fkA.loop(false);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.fkG.start();
        }
    }

    private void reset() {
        this.dql = 0.0d;
        this.Yl = 0;
        this.dUr = 0;
        this.fkt = 0;
        this.fkq = false;
        this.fkr = false;
    }

    public void setOnTouchCallback(d dVar) {
        this.fkC = dVar;
    }

    public void setOnPullRefreshListener(c cVar) {
        this.fkD = cVar;
    }

    public void setOnCancelCallBack(a aVar) {
        this.fkE = aVar;
    }

    public void setOnLoadingStartCallback(b bVar) {
        this.fkF = bVar;
    }

    public void onDestroy() {
        if (this.fkA != null) {
            this.fkA.clearAnimation();
        }
        if (this.fkG != null) {
            this.fkG.cancel();
            this.fkG.removeAllListeners();
            this.fkG.removeAllUpdateListeners();
            this.fkG = null;
        }
        this.fkC = null;
        this.fkD = null;
        this.fkE = null;
    }

    public void bum() {
        this.fkA.bringToFront();
    }

    public void setRefreshing(boolean z) {
        if (z && this.fku) {
            this.fkB.topMargin = this.fkw;
            this.fkA.setLayoutParams(this.fkB);
            this.fkz = false;
            this.fkA.loop(true);
            this.fkA.setMinFrame(10);
            this.fkA.setRepeatMode(1);
            this.fkA.removeAllAnimatorListeners();
            this.fkA.addAnimatorListener(this.loadViewAnimListener);
            this.fkA.playAnimation();
            return;
        }
        hideLoading();
    }

    public void setEnable(boolean z) {
        this.fku = z;
    }

    public boolean isEnable() {
        return this.fku;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public void bun() {
        if (this.fky && this.fkA != null) {
            this.fkA.setAlpha((float) this.dql);
            this.fkA.setFrame((int) (this.dql * 10.0d));
        }
    }
}
