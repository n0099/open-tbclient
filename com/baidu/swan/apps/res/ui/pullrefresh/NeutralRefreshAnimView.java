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
import com.baidu.swan.apps.aq.ai;
import com.baidu.swan.apps.aq.p;
import com.baidu.swan.apps.b;
/* loaded from: classes7.dex */
public class NeutralRefreshAnimView extends View {
    private static final boolean DEBUG = b.DEBUG;
    private static final int cDS = ai.D(3.5f);
    private static final int cDT = Color.parseColor("#000000");
    private static final int cDU = ai.D(18.0f);
    private static final int cDV = cDU >> 1;
    private float cDW;
    private Paint cDX;
    private Paint cDY;
    private PointF cDZ;
    private ValueAnimator cEa;
    private ValueAnimator cEb;
    private float cEc;
    private float cEd;
    private ValueAnimator cEe;
    private ValueAnimator cEf;
    private int cEg;
    private int cEh;
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
        this.cDZ = new PointF();
        this.cDX = new Paint(1);
        this.cDY = new Paint(1);
        this.cDX.setColor(cDT);
        this.cDY.setColor(cDT);
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        float f3 = f2 <= 1.0f ? f2 : 1.0f;
        this.cDW = f3;
        changeState(1);
        postInvalidate();
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "setAnimPercent, percent = " + f3);
        }
    }

    public boolean ew(int i) {
        if (this.cDY == null || this.cDX == null) {
            return false;
        }
        this.cDX.setColor(i);
        this.cDY.setColor(i);
        return true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
        this.cDZ.set(this.mWidth >> 1, this.mHeight >> 1);
    }

    @Override // android.view.View
    protected void onSizeChanged(final int i, final int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.1
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
                o(canvas);
                break;
            case 2:
                p(canvas);
                break;
            case 3:
                q(canvas);
                break;
            case 4:
                p(canvas);
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

    private void o(Canvas canvas) {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "performPullToRefreshAnim");
        }
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            if (this.cDW == 0.0f) {
                this.cDY.setAlpha(0);
                this.mCanvas.drawCircle(this.cDZ.x, this.cDZ.y, cDS, this.cDY);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            } else if (this.cDW <= 0.5f) {
                int i = (int) (this.cDW * 77.0f);
                this.cDY.setAlpha(i);
                this.mCanvas.drawCircle(this.cDZ.x, this.cDZ.y, cDS, this.cDY);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "first level,alpha=" + i);
                }
            } else if (this.cDW < 1.0f) {
                int gG = gG((int) (this.cDW * 77.0f));
                this.cDY.setAlpha(gG);
                float f = (this.cDW - 0.5f) * 2.0f;
                int gG2 = gG((int) (26.0f * f));
                this.cDX.setAlpha(gG2);
                this.mCanvas.drawCircle(this.cDZ.x + (cDV * f), this.cDZ.y, cDS, this.cDY);
                this.mCanvas.drawCircle(this.cDZ.x - (cDV * f), this.cDZ.y, cDS, this.cDX);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "second level,mAnimPercent=" + this.cDW);
                    Log.e("NeutralRefreshAnimView", "second level,rightBallAlpha=" + gG);
                    Log.e("NeutralRefreshAnimView", "second level,leftBallAlpha=" + gG2);
                    Log.e("NeutralRefreshAnimView", "second level,fraction=" + f);
                    Log.e("NeutralRefreshAnimView", "second level,HALF_MAX_DISTANCE * fraction=" + (f * cDV));
                }
            } else if (this.cDW == 1.0f) {
                this.cDX.setAlpha(26);
                this.cDY.setAlpha(77);
                this.mCanvas.drawCircle(this.cDZ.x + cDV, this.cDZ.y, cDS, this.cDY);
                this.mCanvas.drawCircle(this.cDZ.x - cDV, this.cDZ.y, cDS, this.cDX);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "third level,mAnimPercent=" + this.cDW);
                }
            }
        }
    }

    public void aqB() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshingAnim");
        }
        changeState(2);
        aqC();
    }

    private void aqC() {
        aqA();
        this.cEb = ValueAnimator.ofFloat(1.0f, -1.0f);
        this.cEb.setDuration(480L);
        this.cEb.setRepeatMode(2);
        this.cEb.setRepeatCount(-1);
        this.cEb.setInterpolator(new AccelerateDecelerateInterpolator());
        this.cEb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.cEc = NeutralRefreshAnimView.cDV * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mRightBallXPosi=" + NeutralRefreshAnimView.this.cEc + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.cEa = ValueAnimator.ofFloat(-1.0f, 1.0f);
        this.cEa.setDuration(480L);
        this.cEa.setRepeatMode(2);
        this.cEa.setRepeatCount(-1);
        this.cEa.setInterpolator(new AccelerateDecelerateInterpolator());
        this.cEa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.cEd = NeutralRefreshAnimView.cDV * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mLeftBallXPosi=" + NeutralRefreshAnimView.this.cEd + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.mAnimatorSet = new AnimatorSet();
        this.mAnimatorSet.playTogether(this.cEa, this.cEb);
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

    private void p(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.cDY.setAlpha(77);
            this.mCanvas.drawCircle(this.cDZ.x + this.cEc, this.cDZ.y, cDS, this.cDY);
            this.cDX.setAlpha(26);
            this.mCanvas.drawCircle(this.cDZ.x + this.cEd, this.cDZ.y, cDS, this.cDX);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "performOnRefreshingAnim");
            }
        }
    }

    public void aqD() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshCompleteAnim");
        }
        stopAnim();
        changeState(3);
        aqE();
    }

    private void aqE() {
        this.cEe = ValueAnimator.ofInt(26, 0);
        this.cEe.setDuration(300L);
        this.cEe.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.cEg = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.cEg);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.cEe.isRunning()) {
            this.cEe.start();
        }
        this.cEf = ValueAnimator.ofInt(77, 0);
        this.cEf.setDuration(300L);
        this.cEf.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.cEh = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.cEg);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.cEf.isRunning()) {
            this.cEf.start();
        }
    }

    private void q(Canvas canvas) {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "performRefreshCompleteAnim");
        }
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.cEg = gG(this.cEg);
            this.cEh = gG(this.cEh);
            this.cDY.setAlpha(this.cEh);
            this.cDX.setAlpha(this.cEg);
            this.mCanvas.drawCircle(this.cDZ.x + this.cEc, this.cDZ.y, cDS, this.cDY);
            this.cDX.setAlpha(this.cEg);
            this.mCanvas.drawCircle(this.cDZ.x + this.cEd, this.cDZ.y, cDS, this.cDX);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "Complete:mAlpha=" + this.cEg);
                Log.e("NeutralRefreshAnimView", "Complete:mRightBallXPosi=" + this.cEc);
                Log.e("NeutralRefreshAnimView", "Complete:mLeftBallXPosi=" + this.cEd);
            }
        }
    }

    public void stopAnim() {
        aqA();
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

    private void aqA() {
        a(this.cEa, true);
        a(this.cEb, true);
        a(this.cEe, false);
        a(this.cEf, false);
        if (this.mAnimatorSet != null) {
            this.mAnimatorSet.removeAllListeners();
            this.mAnimatorSet.end();
            this.mAnimatorSet.cancel();
        }
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "resetAnimator");
        }
    }

    private int gG(int i) {
        int i2 = i < 0 ? 0 : i;
        if (i2 > 255) {
            return 255;
        }
        return i2;
    }
}
