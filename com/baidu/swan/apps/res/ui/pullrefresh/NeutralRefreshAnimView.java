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
import com.baidu.searchbox.picture.component.BaseBrowseView;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.apps.b;
/* loaded from: classes11.dex */
public class NeutralRefreshAnimView extends View {
    private static final boolean DEBUG = b.DEBUG;
    private static final int bLP = af.S(3.5f);
    private static final int bLQ = Color.parseColor(BaseBrowseView.ROOT_VIEW_COLOR);
    private static final int bLR = af.S(18.0f);
    private static final int bLS = bLR >> 1;
    private float bLT;
    private Paint bLU;
    private Paint bLV;
    private PointF bLW;
    private ValueAnimator bLX;
    private ValueAnimator bLY;
    private float bLZ;
    private float bMa;
    private ValueAnimator bMb;
    private ValueAnimator bMc;
    private int bMd;
    private int bMe;
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
        this.bLW = new PointF();
        this.bLU = new Paint(1);
        this.bLV = new Paint(1);
        this.bLU.setColor(bLQ);
        this.bLV.setColor(bLQ);
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        float f3 = f2 <= 1.0f ? f2 : 1.0f;
        this.bLT = f3;
        changeState(1);
        postInvalidate();
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "setAnimPercent, percent = " + f3);
        }
    }

    public boolean dW(int i) {
        if (this.bLV == null || this.bLU == null) {
            return false;
        }
        this.bLU.setColor(i);
        this.bLV.setColor(i);
        return true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
        this.bLW.set(this.mWidth >> 1, this.mHeight >> 1);
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
            if (this.bLT == 0.0f) {
                this.bLV.setAlpha(0);
                this.mCanvas.drawCircle(this.bLW.x, this.bLW.y, bLP, this.bLV);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            } else if (this.bLT <= 0.5f) {
                int i = (int) (this.bLT * 77.0f);
                this.bLV.setAlpha(i);
                this.mCanvas.drawCircle(this.bLW.x, this.bLW.y, bLP, this.bLV);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "first level,alpha=" + i);
                }
            } else if (this.bLT < 1.0f) {
                int fL = fL((int) (this.bLT * 77.0f));
                this.bLV.setAlpha(fL);
                float f = (this.bLT - 0.5f) * 2.0f;
                int fL2 = fL((int) (26.0f * f));
                this.bLU.setAlpha(fL2);
                this.mCanvas.drawCircle(this.bLW.x + (bLS * f), this.bLW.y, bLP, this.bLV);
                this.mCanvas.drawCircle(this.bLW.x - (bLS * f), this.bLW.y, bLP, this.bLU);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "second level,mAnimPercent=" + this.bLT);
                    Log.e("NeutralRefreshAnimView", "second level,rightBallAlpha=" + fL);
                    Log.e("NeutralRefreshAnimView", "second level,leftBallAlpha=" + fL2);
                    Log.e("NeutralRefreshAnimView", "second level,fraction=" + f);
                    Log.e("NeutralRefreshAnimView", "second level,HALF_MAX_DISTANCE * fraction=" + (f * bLS));
                }
            } else if (this.bLT == 1.0f) {
                this.bLU.setAlpha(26);
                this.bLV.setAlpha(77);
                this.mCanvas.drawCircle(this.bLW.x + bLS, this.bLW.y, bLP, this.bLV);
                this.mCanvas.drawCircle(this.bLW.x - bLS, this.bLW.y, bLP, this.bLU);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "third level,mAnimPercent=" + this.bLT);
                }
            }
        }
    }

    public void abQ() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshingAnim");
        }
        changeState(2);
        abR();
    }

    private void abR() {
        abP();
        this.bLY = ValueAnimator.ofFloat(1.0f, -1.0f);
        this.bLY.setDuration(480L);
        this.bLY.setRepeatMode(2);
        this.bLY.setRepeatCount(-1);
        this.bLY.setInterpolator(new AccelerateDecelerateInterpolator());
        this.bLY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.bLZ = NeutralRefreshAnimView.bLS * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mRightBallXPosi=" + NeutralRefreshAnimView.this.bLZ + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.bLX = ValueAnimator.ofFloat(-1.0f, 1.0f);
        this.bLX.setDuration(480L);
        this.bLX.setRepeatMode(2);
        this.bLX.setRepeatCount(-1);
        this.bLX.setInterpolator(new AccelerateDecelerateInterpolator());
        this.bLX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.bMa = NeutralRefreshAnimView.bLS * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mLeftBallXPosi=" + NeutralRefreshAnimView.this.bMa + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.mAnimatorSet = new AnimatorSet();
        this.mAnimatorSet.playTogether(this.bLX, this.bLY);
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
            this.bLV.setAlpha(77);
            this.mCanvas.drawCircle(this.bLW.x + this.bLZ, this.bLW.y, bLP, this.bLV);
            this.bLU.setAlpha(26);
            this.mCanvas.drawCircle(this.bLW.x + this.bMa, this.bLW.y, bLP, this.bLU);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "performOnRefreshingAnim");
            }
        }
    }

    public void abS() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshCompleteAnim");
        }
        stopAnim();
        changeState(3);
        abT();
    }

    private void abT() {
        this.bMb = ValueAnimator.ofInt(26, 0);
        this.bMb.setDuration(300L);
        this.bMb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.bMd = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.bMd);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.bMb.isRunning()) {
            this.bMb.start();
        }
        this.bMc = ValueAnimator.ofInt(77, 0);
        this.bMc.setDuration(300L);
        this.bMc.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.bMe = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.bMd);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.bMc.isRunning()) {
            this.bMc.start();
        }
    }

    private void p(Canvas canvas) {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "performRefreshCompleteAnim");
        }
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.bMd = fL(this.bMd);
            this.bMe = fL(this.bMe);
            this.bLV.setAlpha(this.bMe);
            this.bLU.setAlpha(this.bMd);
            this.mCanvas.drawCircle(this.bLW.x + this.bLZ, this.bLW.y, bLP, this.bLV);
            this.bLU.setAlpha(this.bMd);
            this.mCanvas.drawCircle(this.bLW.x + this.bMa, this.bLW.y, bLP, this.bLU);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "Complete:mAlpha=" + this.bMd);
                Log.e("NeutralRefreshAnimView", "Complete:mRightBallXPosi=" + this.bLZ);
                Log.e("NeutralRefreshAnimView", "Complete:mLeftBallXPosi=" + this.bMa);
            }
        }
    }

    public void stopAnim() {
        abP();
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

    private void abP() {
        a(this.bLX, true);
        a(this.bLY, true);
        a(this.bMb, false);
        a(this.bMc, false);
        if (this.mAnimatorSet != null) {
            this.mAnimatorSet.removeAllListeners();
            this.mAnimatorSet.end();
            this.mAnimatorSet.cancel();
        }
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "resetAnimator");
        }
    }

    private int fL(int i) {
        int i2 = i < 0 ? 0 : i;
        if (i2 > 255) {
            return 255;
        }
        return i2;
    }
}
