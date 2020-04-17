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
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.apps.b;
/* loaded from: classes11.dex */
public class NeutralRefreshAnimView extends View {
    private static final boolean DEBUG = b.DEBUG;
    private static final int ckL = af.C(3.5f);
    private static final int ckM = Color.parseColor("#000000");
    private static final int ckN = af.C(18.0f);
    private static final int ckO = ckN >> 1;
    private float ckP;
    private Paint ckQ;
    private Paint ckR;
    private PointF ckS;
    private ValueAnimator ckT;
    private ValueAnimator ckU;
    private float ckV;
    private float ckW;
    private ValueAnimator ckX;
    private ValueAnimator ckY;
    private int ckZ;
    private int cla;
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
        this.ckS = new PointF();
        this.ckQ = new Paint(1);
        this.ckR = new Paint(1);
        this.ckQ.setColor(ckM);
        this.ckR.setColor(ckM);
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        float f3 = f2 <= 1.0f ? f2 : 1.0f;
        this.ckP = f3;
        changeState(1);
        postInvalidate();
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "setAnimPercent, percent = " + f3);
        }
    }

    public boolean eb(int i) {
        if (this.ckR == null || this.ckQ == null) {
            return false;
        }
        this.ckQ.setColor(i);
        this.ckR.setColor(i);
        return true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
        this.ckS.set(this.mWidth >> 1, this.mHeight >> 1);
    }

    @Override // android.view.View
    protected void onSizeChanged(final int i, final int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.1
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
                n(canvas);
                break;
            case 2:
                o(canvas);
                break;
            case 3:
                p(canvas);
                break;
            case 4:
                o(canvas);
                break;
        }
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeState(int i) {
        this.mState = i;
        if (DEBUG) {
            Log.i("NeutralRefreshAnimView", "curr state:" + this.mState);
        }
    }

    private void n(Canvas canvas) {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "performPullToRefreshAnim");
        }
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            if (this.ckP == 0.0f) {
                this.ckR.setAlpha(0);
                this.mCanvas.drawCircle(this.ckS.x, this.ckS.y, ckL, this.ckR);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            } else if (this.ckP <= 0.5f) {
                int i = (int) (this.ckP * 77.0f);
                this.ckR.setAlpha(i);
                this.mCanvas.drawCircle(this.ckS.x, this.ckS.y, ckL, this.ckR);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "first level,alpha=" + i);
                }
            } else if (this.ckP < 1.0f) {
                int fS = fS((int) (this.ckP * 77.0f));
                this.ckR.setAlpha(fS);
                float f = (this.ckP - 0.5f) * 2.0f;
                int fS2 = fS((int) (26.0f * f));
                this.ckQ.setAlpha(fS2);
                this.mCanvas.drawCircle(this.ckS.x + (ckO * f), this.ckS.y, ckL, this.ckR);
                this.mCanvas.drawCircle(this.ckS.x - (ckO * f), this.ckS.y, ckL, this.ckQ);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "second level,mAnimPercent=" + this.ckP);
                    Log.e("NeutralRefreshAnimView", "second level,rightBallAlpha=" + fS);
                    Log.e("NeutralRefreshAnimView", "second level,leftBallAlpha=" + fS2);
                    Log.e("NeutralRefreshAnimView", "second level,fraction=" + f);
                    Log.e("NeutralRefreshAnimView", "second level,HALF_MAX_DISTANCE * fraction=" + (f * ckO));
                }
            } else if (this.ckP == 1.0f) {
                this.ckQ.setAlpha(26);
                this.ckR.setAlpha(77);
                this.mCanvas.drawCircle(this.ckS.x + ckO, this.ckS.y, ckL, this.ckR);
                this.mCanvas.drawCircle(this.ckS.x - ckO, this.ckS.y, ckL, this.ckQ);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "third level,mAnimPercent=" + this.ckP);
                }
            }
        }
    }

    public void ajY() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshingAnim");
        }
        changeState(2);
        ajZ();
    }

    private void ajZ() {
        ajX();
        this.ckU = ValueAnimator.ofFloat(1.0f, -1.0f);
        this.ckU.setDuration(480L);
        this.ckU.setRepeatMode(2);
        this.ckU.setRepeatCount(-1);
        this.ckU.setInterpolator(new AccelerateDecelerateInterpolator());
        this.ckU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.ckV = NeutralRefreshAnimView.ckO * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mRightBallXPosi=" + NeutralRefreshAnimView.this.ckV + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.ckT = ValueAnimator.ofFloat(-1.0f, 1.0f);
        this.ckT.setDuration(480L);
        this.ckT.setRepeatMode(2);
        this.ckT.setRepeatCount(-1);
        this.ckT.setInterpolator(new AccelerateDecelerateInterpolator());
        this.ckT.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.ckW = NeutralRefreshAnimView.ckO * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mLeftBallXPosi=" + NeutralRefreshAnimView.this.ckW + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.mAnimatorSet = new AnimatorSet();
        this.mAnimatorSet.playTogether(this.ckT, this.ckU);
        this.mAnimatorSet.setDuration(480L);
        this.mAnimatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                NeutralRefreshAnimView.this.changeState(4);
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

    private void o(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.ckR.setAlpha(77);
            this.mCanvas.drawCircle(this.ckS.x + this.ckV, this.ckS.y, ckL, this.ckR);
            this.ckQ.setAlpha(26);
            this.mCanvas.drawCircle(this.ckS.x + this.ckW, this.ckS.y, ckL, this.ckQ);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "performOnRefreshingAnim");
            }
        }
    }

    public void aka() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshCompleteAnim");
        }
        stopAnim();
        changeState(3);
        akb();
    }

    private void akb() {
        this.ckX = ValueAnimator.ofInt(26, 0);
        this.ckX.setDuration(300L);
        this.ckX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.ckZ = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.ckZ);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.ckX.isRunning()) {
            this.ckX.start();
        }
        this.ckY = ValueAnimator.ofInt(77, 0);
        this.ckY.setDuration(300L);
        this.ckY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.cla = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.ckZ);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.ckY.isRunning()) {
            this.ckY.start();
        }
    }

    private void p(Canvas canvas) {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "performRefreshCompleteAnim");
        }
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.ckZ = fS(this.ckZ);
            this.cla = fS(this.cla);
            this.ckR.setAlpha(this.cla);
            this.ckQ.setAlpha(this.ckZ);
            this.mCanvas.drawCircle(this.ckS.x + this.ckV, this.ckS.y, ckL, this.ckR);
            this.ckQ.setAlpha(this.ckZ);
            this.mCanvas.drawCircle(this.ckS.x + this.ckW, this.ckS.y, ckL, this.ckQ);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "Complete:mAlpha=" + this.ckZ);
                Log.e("NeutralRefreshAnimView", "Complete:mRightBallXPosi=" + this.ckV);
                Log.e("NeutralRefreshAnimView", "Complete:mLeftBallXPosi=" + this.ckW);
            }
        }
    }

    public void stopAnim() {
        ajX();
        clearAnimation();
        changeState(1);
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

    private void ajX() {
        a(this.ckT, true);
        a(this.ckU, true);
        a(this.ckX, false);
        a(this.ckY, false);
        if (this.mAnimatorSet != null) {
            this.mAnimatorSet.removeAllListeners();
            this.mAnimatorSet.end();
            this.mAnimatorSet.cancel();
        }
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "resetAnimator");
        }
    }

    private int fS(int i) {
        int i2 = i < 0 ? 0 : i;
        if (i2 > 255) {
            return 255;
        }
        return i2;
    }
}
