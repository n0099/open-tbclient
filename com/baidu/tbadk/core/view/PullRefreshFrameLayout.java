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
    private static final int fiI = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds144);
    private static final int fiJ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds210);
    private static final int fiK = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    public static final int fiL = fiJ + fiI;
    public static final int fiM = fiK + fiI;
    private static final int fiN = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds135);
    private static final int fiO = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds230);
    private static final float fiP = (float) ((fiN * 1.0d) / fiJ);
    private static final float fiQ = (float) ((fiO * 1.0d) / fiK);
    private int WQ;
    private int dSQ;
    private double doJ;
    boolean fiR;
    boolean fiS;
    boolean fiT;
    private int fiU;
    private boolean fiV;
    private int fiW;
    private int fiX;
    private float fiY;
    private boolean fiZ;
    private boolean fja;
    private ContinuousAnimationView fjb;
    private FrameLayout.LayoutParams fjc;
    private d fjd;
    private c fje;
    private a fjf;
    private b fjg;
    private ValueAnimator fjh;
    private boolean isLoading;
    private final Animator.AnimatorListener loadViewAnimListener;

    /* loaded from: classes.dex */
    public interface a {
        void onCancel();
    }

    /* loaded from: classes.dex */
    public interface b {
        void bul();
    }

    /* loaded from: classes.dex */
    public interface c {
        void bum();
    }

    /* loaded from: classes.dex */
    public interface d {
        void b(int i, double d);

        void bun();

        void q(double d);
    }

    public PullRefreshFrameLayout(Context context) {
        super(context);
        this.fiR = false;
        this.fiS = false;
        this.fiT = false;
        this.isLoading = false;
        this.fiV = true;
        this.fiW = fiL;
        this.fiX = fiN;
        this.fiY = fiP;
        this.fja = false;
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
                if (!PullRefreshFrameLayout.this.fja) {
                    PullRefreshFrameLayout.this.fja = true;
                    PullRefreshFrameLayout.this.fjb.setMinAndMaxFrame(19, 42);
                }
            }
        };
        init();
    }

    public PullRefreshFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fiR = false;
        this.fiS = false;
        this.fiT = false;
        this.isLoading = false;
        this.fiV = true;
        this.fiW = fiL;
        this.fiX = fiN;
        this.fiY = fiP;
        this.fja = false;
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
                if (!PullRefreshFrameLayout.this.fja) {
                    PullRefreshFrameLayout.this.fja = true;
                    PullRefreshFrameLayout.this.fjb.setMinAndMaxFrame(19, 42);
                }
            }
        };
        init();
    }

    public PullRefreshFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fiR = false;
        this.fiS = false;
        this.fiT = false;
        this.isLoading = false;
        this.fiV = true;
        this.fiW = fiL;
        this.fiX = fiN;
        this.fiY = fiP;
        this.fja = false;
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
                if (!PullRefreshFrameLayout.this.fja) {
                    PullRefreshFrameLayout.this.fja = true;
                    PullRefreshFrameLayout.this.fjb.setMinAndMaxFrame(19, 42);
                }
            }
        };
        init();
    }

    private void init() {
        this.fjb = new ContinuousAnimationView(getContext());
        this.fjc = new FrameLayout.LayoutParams(fiI, fiI);
        this.fjc.gravity = 49;
        this.fjc.topMargin = -fiI;
        this.fjb.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.fjb, this.fjc);
        this.fjb.bringToFront();
        this.fjb.setMinAndMaxProgress(0.0f, 1.0f);
        this.fjb.setSpeed(1.3f);
        this.fjb.setAnimation(R.raw.lottie_frs_refresh);
    }

    public void setInterceptScrollDown(boolean z) {
        this.fiT = z;
    }

    public void setFromFrs() {
        this.fiW = fiM;
        this.fiX = fiO;
        this.fiY = fiQ;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!this.isLoading && this.fiV) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            switch (motionEvent.getAction()) {
                case 0:
                    this.fiR = false;
                    this.fiS = false;
                    this.WQ = y;
                    this.dSQ = x;
                    break;
                case 1:
                case 3:
                    reset();
                    break;
                case 2:
                    int i = y - this.WQ;
                    int i2 = x - this.dSQ;
                    if (!this.fiR) {
                        if (!this.fiS) {
                            if (this.fiT) {
                                if (i > 0 && Math.abs(i) > Math.abs(i2)) {
                                    this.fiS = false;
                                    this.fiR = true;
                                    z = true;
                                    break;
                                } else if (i < 0) {
                                    this.fiS = true;
                                    this.fiR = false;
                                    break;
                                }
                            } else {
                                this.fiS = true;
                                this.fiR = false;
                                break;
                            }
                        }
                    } else {
                        z = true;
                        break;
                    }
                    break;
            }
            this.WQ = y;
            this.dSQ = x;
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
        this.fiZ = false;
        switch (motionEvent.getAction()) {
            case 0:
                this.WQ = y;
                this.dSQ = x;
                break;
            case 1:
                if (this.doJ < this.fiY && this.fjf != null) {
                    this.fjf.onCancel();
                }
                buh();
                reset();
                break;
            case 2:
                int i = y - this.WQ;
                int i2 = x - this.dSQ;
                if (i > 0) {
                    this.fiZ = true;
                }
                pF(i);
                this.WQ = y;
                this.dSQ = x;
                break;
            case 3:
                buh();
                reset();
                break;
        }
        return true;
    }

    private void pF(int i) {
        int i2 = this.fjc.topMargin + i;
        if (i2 > this.fiW - fiI) {
            i2 = this.fiW - fiI;
        } else if (i2 < (-fiI)) {
            i2 = -fiI;
        }
        this.fjc.topMargin = i2;
        this.fjb.setLayoutParams(this.fjc);
        this.fiU += i;
        if (this.fiU > this.fiW) {
            this.fiU = this.fiW;
        } else if (this.fiU < 0) {
            this.fiU = 0;
        }
        this.doJ = (this.fiU * 1.0d) / this.fiW;
        if (this.fjd != null) {
            this.fjd.q(this.doJ);
        }
    }

    private void buh() {
        if (this.doJ >= this.fiY) {
            this.isLoading = true;
            this.fjh = ValueAnimator.ofFloat(this.fjc.topMargin, this.fiX);
            this.fjh.setDuration(150L);
            this.fjh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    PullRefreshFrameLayout.this.fjc.topMargin = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    PullRefreshFrameLayout.this.fjb.setLayoutParams(PullRefreshFrameLayout.this.fjc);
                }
            });
            this.fjh.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    if (PullRefreshFrameLayout.this.fjg != null) {
                        PullRefreshFrameLayout.this.fjg.bul();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (PullRefreshFrameLayout.this.fje != null) {
                        PullRefreshFrameLayout.this.fje.bum();
                    }
                    PullRefreshFrameLayout.this.fjb.playAnimation();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.fjh.start();
            this.fjd.b(this.fjc.topMargin - this.fiX, (this.fiX * 1.0d) / this.fjc.topMargin);
            return;
        }
        bui();
    }

    public void bui() {
        hideLoading();
        if (this.fjd != null) {
            this.fjd.bun();
        }
    }

    public void dismissLoading() {
        if (this.isLoading) {
            hideLoading();
        }
    }

    private void hideLoading() {
        this.isLoading = false;
        if (this.fjc.topMargin > (-fiI)) {
            this.fjh = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.fjh.setDuration(300L);
            final int i = this.fjc.topMargin;
            this.fjh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (((float) (floatValue * 0.3d)) <= 0.0f) {
                    }
                    PullRefreshFrameLayout.this.fjb.setAlpha(floatValue);
                    PullRefreshFrameLayout.this.fjc.topMargin = (int) (floatValue * i);
                    PullRefreshFrameLayout.this.fjb.setLayoutParams(PullRefreshFrameLayout.this.fjc);
                }
            });
            this.fjh.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    PullRefreshFrameLayout.this.fjc.topMargin = -PullRefreshFrameLayout.fiI;
                    PullRefreshFrameLayout.this.fjb.setLayoutParams(PullRefreshFrameLayout.this.fjc);
                    PullRefreshFrameLayout.this.fjb.cancelAnimation();
                    PullRefreshFrameLayout.this.fjb.setFrame(0);
                    PullRefreshFrameLayout.this.fjb.setMinAndMaxProgress(0.0f, 1.0f);
                    PullRefreshFrameLayout.this.fjb.setAlpha(1.0f);
                    PullRefreshFrameLayout.this.fjb.loop(false);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.fjh.start();
        }
    }

    private void reset() {
        this.doJ = 0.0d;
        this.WQ = 0;
        this.dSQ = 0;
        this.fiU = 0;
        this.fiR = false;
        this.fiS = false;
    }

    public void setOnTouchCallback(d dVar) {
        this.fjd = dVar;
    }

    public void setOnPullRefreshListener(c cVar) {
        this.fje = cVar;
    }

    public void setOnCancelCallBack(a aVar) {
        this.fjf = aVar;
    }

    public void setOnLoadingStartCallback(b bVar) {
        this.fjg = bVar;
    }

    public void onDestroy() {
        if (this.fjb != null) {
            this.fjb.clearAnimation();
        }
        if (this.fjh != null) {
            this.fjh.cancel();
            this.fjh.removeAllListeners();
            this.fjh.removeAllUpdateListeners();
            this.fjh = null;
        }
        this.fjd = null;
        this.fje = null;
        this.fjf = null;
    }

    public void buj() {
        this.fjb.bringToFront();
    }

    public void setRefreshing(boolean z) {
        if (z && this.fiV) {
            this.fjc.topMargin = this.fiX;
            this.fjb.setLayoutParams(this.fjc);
            this.fja = false;
            this.fjb.loop(true);
            this.fjb.setMinFrame(10);
            this.fjb.setRepeatMode(1);
            this.fjb.removeAllAnimatorListeners();
            this.fjb.addAnimatorListener(this.loadViewAnimListener);
            this.fjb.playAnimation();
            return;
        }
        hideLoading();
    }

    public void setEnable(boolean z) {
        this.fiV = z;
    }

    public boolean isEnable() {
        return this.fiV;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public void buk() {
        if (this.fiZ && this.fjb != null) {
            this.fjb.setAlpha((float) this.doJ);
            this.fjb.setFrame((int) (this.doJ * 10.0d));
        }
    }
}
