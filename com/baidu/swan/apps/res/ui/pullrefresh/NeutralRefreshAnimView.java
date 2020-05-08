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
    private static final int ckR = af.C(3.5f);
    private static final int ckS = Color.parseColor("#000000");
    private static final int ckT = af.C(18.0f);
    private static final int ckU = ckT >> 1;
    private float ckV;
    private Paint ckW;
    private Paint ckX;
    private PointF ckY;
    private ValueAnimator ckZ;
    private ValueAnimator cla;
    private float clb;
    private float clc;
    private ValueAnimator cld;
    private ValueAnimator cle;
    private int clf;
    private int clg;
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
        this.ckY = new PointF();
        this.ckW = new Paint(1);
        this.ckX = new Paint(1);
        this.ckW.setColor(ckS);
        this.ckX.setColor(ckS);
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        float f3 = f2 <= 1.0f ? f2 : 1.0f;
        this.ckV = f3;
        changeState(1);
        postInvalidate();
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "setAnimPercent, percent = " + f3);
        }
    }

    public boolean eb(int i) {
        if (this.ckX == null || this.ckW == null) {
            return false;
        }
        this.ckW.setColor(i);
        this.ckX.setColor(i);
        return true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
        this.ckY.set(this.mWidth >> 1, this.mHeight >> 1);
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
            if (this.ckV == 0.0f) {
                this.ckX.setAlpha(0);
                this.mCanvas.drawCircle(this.ckY.x, this.ckY.y, ckR, this.ckX);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            } else if (this.ckV <= 0.5f) {
                int i = (int) (this.ckV * 77.0f);
                this.ckX.setAlpha(i);
                this.mCanvas.drawCircle(this.ckY.x, this.ckY.y, ckR, this.ckX);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "first level,alpha=" + i);
                }
            } else if (this.ckV < 1.0f) {
                int fS = fS((int) (this.ckV * 77.0f));
                this.ckX.setAlpha(fS);
                float f = (this.ckV - 0.5f) * 2.0f;
                int fS2 = fS((int) (26.0f * f));
                this.ckW.setAlpha(fS2);
                this.mCanvas.drawCircle(this.ckY.x + (ckU * f), this.ckY.y, ckR, this.ckX);
                this.mCanvas.drawCircle(this.ckY.x - (ckU * f), this.ckY.y, ckR, this.ckW);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "second level,mAnimPercent=" + this.ckV);
                    Log.e("NeutralRefreshAnimView", "second level,rightBallAlpha=" + fS);
                    Log.e("NeutralRefreshAnimView", "second level,leftBallAlpha=" + fS2);
                    Log.e("NeutralRefreshAnimView", "second level,fraction=" + f);
                    Log.e("NeutralRefreshAnimView", "second level,HALF_MAX_DISTANCE * fraction=" + (f * ckU));
                }
            } else if (this.ckV == 1.0f) {
                this.ckW.setAlpha(26);
                this.ckX.setAlpha(77);
                this.mCanvas.drawCircle(this.ckY.x + ckU, this.ckY.y, ckR, this.ckX);
                this.mCanvas.drawCircle(this.ckY.x - ckU, this.ckY.y, ckR, this.ckW);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "third level,mAnimPercent=" + this.ckV);
                }
            }
        }
    }

    public void ajX() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshingAnim");
        }
        changeState(2);
        ajY();
    }

    private void ajY() {
        ajW();
        this.cla = ValueAnimator.ofFloat(1.0f, -1.0f);
        this.cla.setDuration(480L);
        this.cla.setRepeatMode(2);
        this.cla.setRepeatCount(-1);
        this.cla.setInterpolator(new AccelerateDecelerateInterpolator());
        this.cla.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.clb = NeutralRefreshAnimView.ckU * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mRightBallXPosi=" + NeutralRefreshAnimView.this.clb + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.ckZ = ValueAnimator.ofFloat(-1.0f, 1.0f);
        this.ckZ.setDuration(480L);
        this.ckZ.setRepeatMode(2);
        this.ckZ.setRepeatCount(-1);
        this.ckZ.setInterpolator(new AccelerateDecelerateInterpolator());
        this.ckZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.clc = NeutralRefreshAnimView.ckU * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mLeftBallXPosi=" + NeutralRefreshAnimView.this.clc + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.mAnimatorSet = new AnimatorSet();
        this.mAnimatorSet.playTogether(this.ckZ, this.cla);
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
            this.ckX.setAlpha(77);
            this.mCanvas.drawCircle(this.ckY.x + this.clb, this.ckY.y, ckR, this.ckX);
            this.ckW.setAlpha(26);
            this.mCanvas.drawCircle(this.ckY.x + this.clc, this.ckY.y, ckR, this.ckW);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "performOnRefreshingAnim");
            }
        }
    }

    public void ajZ() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshCompleteAnim");
        }
        stopAnim();
        changeState(3);
        aka();
    }

    private void aka() {
        this.cld = ValueAnimator.ofInt(26, 0);
        this.cld.setDuration(300L);
        this.cld.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.clf = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.clf);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.cld.isRunning()) {
            this.cld.start();
        }
        this.cle = ValueAnimator.ofInt(77, 0);
        this.cle.setDuration(300L);
        this.cle.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.clg = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.clf);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.cle.isRunning()) {
            this.cle.start();
        }
    }

    private void p(Canvas canvas) {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "performRefreshCompleteAnim");
        }
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.clf = fS(this.clf);
            this.clg = fS(this.clg);
            this.ckX.setAlpha(this.clg);
            this.ckW.setAlpha(this.clf);
            this.mCanvas.drawCircle(this.ckY.x + this.clb, this.ckY.y, ckR, this.ckX);
            this.ckW.setAlpha(this.clf);
            this.mCanvas.drawCircle(this.ckY.x + this.clc, this.ckY.y, ckR, this.ckW);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "Complete:mAlpha=" + this.clf);
                Log.e("NeutralRefreshAnimView", "Complete:mRightBallXPosi=" + this.clb);
                Log.e("NeutralRefreshAnimView", "Complete:mLeftBallXPosi=" + this.clc);
            }
        }
    }

    public void stopAnim() {
        ajW();
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

    private void ajW() {
        a(this.ckZ, true);
        a(this.cla, true);
        a(this.cld, false);
        a(this.cle, false);
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
