package com.baidu.swan.apps.res.ui.pullrefresh;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.baidu.swan.apps.an.j;
import com.baidu.swan.apps.an.z;
import com.baidu.swan.apps.b;
/* loaded from: classes2.dex */
public class NeutralRefreshAnimView extends View {
    private static final boolean DEBUG = b.DEBUG;
    private static final int beF = z.S(3.5f);
    private static final int beG = Color.parseColor("#000000");
    private static final int beH = z.S(18.0f);
    private static final int beI = beH >> 1;
    private float beJ;
    private Paint beK;
    private Paint beL;
    private PointF beM;
    private ValueAnimator beN;
    private ValueAnimator beO;
    private float beP;
    private float beQ;
    private ValueAnimator beR;
    private ValueAnimator beS;
    private int beT;
    private int beU;
    private AnimatorSet mAnimatorSet;
    private Bitmap mBitmap;
    private Canvas mCanvas;
    private int mHeight;
    private int mState;
    private int mWidth;

    public NeutralRefreshAnimView(Context context) {
        super(context);
        init();
    }

    public NeutralRefreshAnimView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.beM = new PointF();
        this.beK = new Paint(1);
        this.beL = new Paint(1);
        this.beK.setColor(beG);
        this.beL.setColor(beG);
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        float f3 = f2 <= 1.0f ? f2 : 1.0f;
        this.beJ = f3;
        dW(1);
        postInvalidate();
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "setAnimPercent, percent = " + f3);
        }
    }

    public boolean cK(int i) {
        if (this.beL == null || this.beK == null) {
            return false;
        }
        this.beK.setColor(i);
        this.beL.setColor(i);
        return true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
        this.beM.set(this.mWidth >> 1, this.mHeight >> 1);
    }

    @Override // android.view.View
    protected void onSizeChanged(final int i, final int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            j.b(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.1
                @Override // java.lang.Runnable
                public void run() {
                    NeutralRefreshAnimView.this.mBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                    NeutralRefreshAnimView.this.mCanvas = new Canvas(NeutralRefreshAnimView.this.mBitmap);
                }
            }, "CreateBitmapOnSizeChanged");
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        switch (this.mState) {
            case 1:
                q(canvas);
                break;
            case 2:
                r(canvas);
                break;
            case 3:
                s(canvas);
                break;
            case 4:
                r(canvas);
                break;
        }
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dW(int i) {
        this.mState = i;
        if (DEBUG) {
            Log.i("NeutralRefreshAnimView", "curr state:" + this.mState);
        }
    }

    private void q(Canvas canvas) {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "performPullToRefreshAnim");
        }
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            if (this.beJ == 0.0f) {
                this.beL.setAlpha(0);
                this.mCanvas.drawCircle(this.beM.x, this.beM.y, beF, this.beL);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            } else if (this.beJ <= 0.5f) {
                int i = (int) (this.beJ * 77.0f);
                this.beL.setAlpha(i);
                this.mCanvas.drawCircle(this.beM.x, this.beM.y, beF, this.beL);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "first level,alpha=" + i);
                }
            } else if (this.beJ < 1.0f) {
                int dX = dX((int) (this.beJ * 77.0f));
                this.beL.setAlpha(dX);
                float f = (this.beJ - 0.5f) * 2.0f;
                int dX2 = dX((int) (26.0f * f));
                this.beK.setAlpha(dX2);
                this.mCanvas.drawCircle(this.beM.x + (beI * f), this.beM.y, beF, this.beL);
                this.mCanvas.drawCircle(this.beM.x - (beI * f), this.beM.y, beF, this.beK);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "second level,mAnimPercent=" + this.beJ);
                    Log.e("NeutralRefreshAnimView", "second level,rightBallAlpha=" + dX);
                    Log.e("NeutralRefreshAnimView", "second level,leftBallAlpha=" + dX2);
                    Log.e("NeutralRefreshAnimView", "second level,fraction=" + f);
                    Log.e("NeutralRefreshAnimView", "second level,HALF_MAX_DISTANCE * fraction=" + (f * beI));
                }
            } else if (this.beJ == 1.0f) {
                this.beK.setAlpha(26);
                this.beL.setAlpha(77);
                this.mCanvas.drawCircle(this.beM.x + beI, this.beM.y, beF, this.beL);
                this.mCanvas.drawCircle(this.beM.x - beI, this.beM.y, beF, this.beK);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "third level,mAnimPercent=" + this.beJ);
                }
            }
        }
    }

    public void Po() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshingAnim");
        }
        dW(2);
        Pp();
    }

    private void Pp() {
        Pn();
        this.beO = ValueAnimator.ofFloat(1.0f, -1.0f);
        this.beO.setDuration(480L);
        this.beO.setRepeatMode(2);
        this.beO.setRepeatCount(-1);
        this.beO.setInterpolator(new AccelerateDecelerateInterpolator());
        this.beO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.beP = NeutralRefreshAnimView.beI * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mRightBallXPosi=" + NeutralRefreshAnimView.this.beP + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.beN = ValueAnimator.ofFloat(-1.0f, 1.0f);
        this.beN.setDuration(480L);
        this.beN.setRepeatMode(2);
        this.beN.setRepeatCount(-1);
        this.beN.setInterpolator(new AccelerateDecelerateInterpolator());
        this.beN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.beQ = NeutralRefreshAnimView.beI * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mLeftBallXPosi=" + NeutralRefreshAnimView.this.beQ + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.mAnimatorSet = new AnimatorSet();
        this.mAnimatorSet.playTogether(this.beN, this.beO);
        this.mAnimatorSet.setDuration(480L);
        this.mAnimatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                NeutralRefreshAnimView.this.dW(4);
                NeutralRefreshAnimView.this.postInvalidate();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        if (!this.mAnimatorSet.isRunning()) {
            this.mAnimatorSet.start();
        }
    }

    private void r(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.beL.setAlpha(77);
            this.mCanvas.drawCircle(this.beM.x + this.beP, this.beM.y, beF, this.beL);
            this.beK.setAlpha(26);
            this.mCanvas.drawCircle(this.beM.x + this.beQ, this.beM.y, beF, this.beK);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "performOnRefreshingAnim");
            }
        }
    }

    public void Pq() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshCompleteAnim");
        }
        stopAnim();
        dW(3);
        Pr();
    }

    private void Pr() {
        this.beR = ValueAnimator.ofInt(26, 0);
        this.beR.setDuration(300L);
        this.beR.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.beT = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.beT);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.beR.isRunning()) {
            this.beR.start();
        }
        this.beS = ValueAnimator.ofInt(77, 0);
        this.beS.setDuration(300L);
        this.beS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.beU = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.beT);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.beS.isRunning()) {
            this.beS.start();
        }
    }

    private void s(Canvas canvas) {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "performRefreshCompleteAnim");
        }
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.beT = dX(this.beT);
            this.beU = dX(this.beU);
            this.beL.setAlpha(this.beU);
            this.beK.setAlpha(this.beT);
            this.mCanvas.drawCircle(this.beM.x + this.beP, this.beM.y, beF, this.beL);
            this.beK.setAlpha(this.beT);
            this.mCanvas.drawCircle(this.beM.x + this.beQ, this.beM.y, beF, this.beK);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "Complete:mAlpha=" + this.beT);
                Log.e("NeutralRefreshAnimView", "Complete:mRightBallXPosi=" + this.beP);
                Log.e("NeutralRefreshAnimView", "Complete:mLeftBallXPosi=" + this.beQ);
            }
        }
    }

    public void stopAnim() {
        Pn();
        clearAnimation();
        dW(1);
        postInvalidate();
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "stopAnim");
        }
    }

    private void a(ValueAnimator valueAnimator, boolean z) {
        if (valueAnimator != null) {
            if (z) {
                valueAnimator.setRepeatCount(0);
            }
            valueAnimator.removeAllUpdateListeners();
            valueAnimator.removeAllListeners();
            valueAnimator.end();
            valueAnimator.cancel();
        }
    }

    private void Pn() {
        a(this.beN, true);
        a(this.beO, true);
        a(this.beR, false);
        a(this.beS, false);
        if (this.mAnimatorSet != null) {
            this.mAnimatorSet.removeAllListeners();
            this.mAnimatorSet.end();
            this.mAnimatorSet.cancel();
        }
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "resetAnimator");
        }
    }

    private int dX(int i) {
        int i2 = i < 0 ? 0 : i;
        if (i2 > 255) {
            return 255;
        }
        return i2;
    }
}
