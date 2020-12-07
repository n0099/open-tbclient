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
    private static final int fbr = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds144);
    private static final int fbs = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds210);
    private static final int fbt = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    public static final int fbu = fbs + fbr;
    public static final int fbv = fbt + fbr;
    private static final int fbw = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds135);
    private static final int fbx = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds230);
    private static final float fby = (float) ((fbw * 1.0d) / fbs);
    private static final float fbz = (float) ((fbx * 1.0d) / fbt);
    private int WZ;
    private int dMD;
    private double dmn;
    boolean fbA;
    boolean fbB;
    boolean fbC;
    private int fbD;
    private boolean fbE;
    private int fbF;
    private int fbG;
    private float fbH;
    private boolean fbI;
    private boolean fbJ;
    private ContinuousAnimationView fbK;
    private FrameLayout.LayoutParams fbL;
    private d fbM;
    private c fbN;
    private a fbO;
    private b fbP;
    private ValueAnimator fbQ;
    private boolean isLoading;
    private final Animator.AnimatorListener loadViewAnimListener;

    /* loaded from: classes.dex */
    public interface a {
        void onCancel();
    }

    /* loaded from: classes.dex */
    public interface b {
        void bvp();
    }

    /* loaded from: classes.dex */
    public interface c {
        void bvq();
    }

    /* loaded from: classes.dex */
    public interface d {
        void bvr();

        void c(int i, double d);

        void w(double d);
    }

    public PullRefreshFrameLayout(Context context) {
        super(context);
        this.fbA = false;
        this.fbB = false;
        this.fbC = false;
        this.isLoading = false;
        this.fbE = true;
        this.fbF = fbu;
        this.fbG = fbw;
        this.fbH = fby;
        this.fbJ = false;
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
                if (!PullRefreshFrameLayout.this.fbJ) {
                    PullRefreshFrameLayout.this.fbJ = true;
                    PullRefreshFrameLayout.this.fbK.setMinAndMaxFrame(19, 42);
                }
            }
        };
        init();
    }

    public PullRefreshFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fbA = false;
        this.fbB = false;
        this.fbC = false;
        this.isLoading = false;
        this.fbE = true;
        this.fbF = fbu;
        this.fbG = fbw;
        this.fbH = fby;
        this.fbJ = false;
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
                if (!PullRefreshFrameLayout.this.fbJ) {
                    PullRefreshFrameLayout.this.fbJ = true;
                    PullRefreshFrameLayout.this.fbK.setMinAndMaxFrame(19, 42);
                }
            }
        };
        init();
    }

    public PullRefreshFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fbA = false;
        this.fbB = false;
        this.fbC = false;
        this.isLoading = false;
        this.fbE = true;
        this.fbF = fbu;
        this.fbG = fbw;
        this.fbH = fby;
        this.fbJ = false;
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
                if (!PullRefreshFrameLayout.this.fbJ) {
                    PullRefreshFrameLayout.this.fbJ = true;
                    PullRefreshFrameLayout.this.fbK.setMinAndMaxFrame(19, 42);
                }
            }
        };
        init();
    }

    private void init() {
        this.fbK = new ContinuousAnimationView(getContext());
        this.fbL = new FrameLayout.LayoutParams(fbr, fbr);
        this.fbL.gravity = 49;
        this.fbL.topMargin = -fbr;
        this.fbK.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.fbK, this.fbL);
        this.fbK.bringToFront();
        this.fbK.setMinAndMaxProgress(0.0f, 1.0f);
        this.fbK.setSpeed(1.3f);
        this.fbK.setAnimation(R.raw.lottie_frs_refresh);
    }

    public void setInterceptScrollDown(boolean z) {
        this.fbC = z;
    }

    public void setFromFrs() {
        this.fbF = fbv;
        this.fbG = fbx;
        this.fbH = fbz;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!this.isLoading && this.fbE) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            switch (motionEvent.getAction()) {
                case 0:
                    this.fbA = false;
                    this.fbB = false;
                    this.WZ = y;
                    this.dMD = x;
                    break;
                case 1:
                case 3:
                    reset();
                    break;
                case 2:
                    int i = y - this.WZ;
                    int i2 = x - this.dMD;
                    if (!this.fbA) {
                        if (!this.fbB) {
                            if (this.fbC) {
                                if (i > 0 && Math.abs(i) > Math.abs(i2)) {
                                    this.fbB = false;
                                    this.fbA = true;
                                    z = true;
                                    break;
                                } else if (i < 0) {
                                    this.fbB = true;
                                    this.fbA = false;
                                    break;
                                }
                            } else {
                                this.fbB = true;
                                this.fbA = false;
                                break;
                            }
                        }
                    } else {
                        z = true;
                        break;
                    }
                    break;
            }
            this.WZ = y;
            this.dMD = x;
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
        this.fbI = false;
        switch (motionEvent.getAction()) {
            case 0:
                this.WZ = y;
                this.dMD = x;
                break;
            case 1:
                if (this.dmn < this.fbH && this.fbO != null) {
                    this.fbO.onCancel();
                }
                bvl();
                reset();
                break;
            case 2:
                int i = y - this.WZ;
                int i2 = x - this.dMD;
                if (i > 0) {
                    this.fbI = true;
                }
                qU(i);
                this.WZ = y;
                this.dMD = x;
                break;
            case 3:
                bvl();
                reset();
                break;
        }
        return true;
    }

    private void qU(int i) {
        int i2 = this.fbL.topMargin + i;
        if (i2 > this.fbF - fbr) {
            i2 = this.fbF - fbr;
        } else if (i2 < (-fbr)) {
            i2 = -fbr;
        }
        this.fbL.topMargin = i2;
        this.fbK.setLayoutParams(this.fbL);
        this.fbD += i;
        if (this.fbD > this.fbF) {
            this.fbD = this.fbF;
        } else if (this.fbD < 0) {
            this.fbD = 0;
        }
        this.dmn = (this.fbD * 1.0d) / this.fbF;
        if (this.fbM != null) {
            this.fbM.w(this.dmn);
        }
    }

    private void bvl() {
        if (this.dmn >= this.fbH) {
            this.isLoading = true;
            this.fbQ = ValueAnimator.ofFloat(this.fbL.topMargin, this.fbG);
            this.fbQ.setDuration(150L);
            this.fbQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    PullRefreshFrameLayout.this.fbL.topMargin = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    PullRefreshFrameLayout.this.fbK.setLayoutParams(PullRefreshFrameLayout.this.fbL);
                }
            });
            this.fbQ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    if (PullRefreshFrameLayout.this.fbP != null) {
                        PullRefreshFrameLayout.this.fbP.bvp();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (PullRefreshFrameLayout.this.fbN != null) {
                        PullRefreshFrameLayout.this.fbN.bvq();
                    }
                    PullRefreshFrameLayout.this.fbK.playAnimation();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.fbQ.start();
            this.fbM.c(this.fbL.topMargin - this.fbG, (this.fbG * 1.0d) / this.fbL.topMargin);
            return;
        }
        bvm();
    }

    public void bvm() {
        hideLoading();
        if (this.fbM != null) {
            this.fbM.bvr();
        }
    }

    public void dismissLoading() {
        if (this.isLoading) {
            hideLoading();
        }
    }

    private void hideLoading() {
        this.isLoading = false;
        if (this.fbL.topMargin > (-fbr)) {
            this.fbQ = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.fbQ.setDuration(300L);
            final int i = this.fbL.topMargin;
            this.fbQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (((float) (floatValue * 0.3d)) <= 0.0f) {
                    }
                    PullRefreshFrameLayout.this.fbK.setAlpha(floatValue);
                    PullRefreshFrameLayout.this.fbL.topMargin = (int) (floatValue * i);
                    PullRefreshFrameLayout.this.fbK.setLayoutParams(PullRefreshFrameLayout.this.fbL);
                }
            });
            this.fbQ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.PullRefreshFrameLayout.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    PullRefreshFrameLayout.this.fbL.topMargin = -PullRefreshFrameLayout.fbr;
                    PullRefreshFrameLayout.this.fbK.setLayoutParams(PullRefreshFrameLayout.this.fbL);
                    PullRefreshFrameLayout.this.fbK.cancelAnimation();
                    PullRefreshFrameLayout.this.fbK.setFrame(0);
                    PullRefreshFrameLayout.this.fbK.setMinAndMaxProgress(0.0f, 1.0f);
                    PullRefreshFrameLayout.this.fbK.setAlpha(1.0f);
                    PullRefreshFrameLayout.this.fbK.loop(false);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.fbQ.start();
        }
    }

    private void reset() {
        this.dmn = 0.0d;
        this.WZ = 0;
        this.dMD = 0;
        this.fbD = 0;
        this.fbA = false;
        this.fbB = false;
    }

    public void setOnTouchCallback(d dVar) {
        this.fbM = dVar;
    }

    public void setOnPullRefreshListener(c cVar) {
        this.fbN = cVar;
    }

    public void setOnCancelCallBack(a aVar) {
        this.fbO = aVar;
    }

    public void setOnLoadingStartCallback(b bVar) {
        this.fbP = bVar;
    }

    public void onDestroy() {
        if (this.fbK != null) {
            this.fbK.clearAnimation();
        }
        if (this.fbQ != null) {
            this.fbQ.cancel();
            this.fbQ.removeAllListeners();
            this.fbQ.removeAllUpdateListeners();
            this.fbQ = null;
        }
        this.fbM = null;
        this.fbN = null;
        this.fbO = null;
    }

    public void bvn() {
        this.fbK.bringToFront();
    }

    public void setRefreshing(boolean z) {
        if (z && this.fbE) {
            this.fbL.topMargin = this.fbG;
            this.fbK.setLayoutParams(this.fbL);
            this.fbJ = false;
            this.fbK.loop(true);
            this.fbK.setMinFrame(10);
            this.fbK.setRepeatMode(1);
            this.fbK.removeAllAnimatorListeners();
            this.fbK.addAnimatorListener(this.loadViewAnimListener);
            this.fbK.playAnimation();
            return;
        }
        hideLoading();
    }

    public void setEnable(boolean z) {
        this.fbE = z;
    }

    public boolean isEnable() {
        return this.fbE;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public void bvo() {
        if (this.fbI && this.fbK != null) {
            this.fbK.setAlpha((float) this.dmn);
            this.fbK.setFrame((int) (this.dmn * 10.0d));
        }
    }
}
