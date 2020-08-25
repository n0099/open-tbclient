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
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.ap.p;
import com.baidu.swan.apps.b;
/* loaded from: classes8.dex */
public class NeutralRefreshAnimView extends View {
    private static final boolean DEBUG = b.DEBUG;
    private static final int cMQ = ah.H(3.5f);
    private static final int cMR = Color.parseColor("#000000");
    private static final int cMS = ah.H(18.0f);
    private static final int cMT = cMS >> 1;
    private float cMU;
    private Paint cMV;
    private Paint cMW;
    private PointF cMX;
    private ValueAnimator cMY;
    private ValueAnimator cMZ;
    private float cNa;
    private float cNb;
    private ValueAnimator cNc;
    private ValueAnimator cNd;
    private int cNe;
    private int cNf;
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
        this.cMX = new PointF();
        this.cMV = new Paint(1);
        this.cMW = new Paint(1);
        this.cMV.setColor(cMR);
        this.cMW.setColor(cMR);
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        float f3 = f2 <= 1.0f ? f2 : 1.0f;
        this.cMU = f3;
        changeState(1);
        postInvalidate();
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "setAnimPercent, percent = " + f3);
        }
    }

    public boolean gu(int i) {
        if (this.cMW == null || this.cMV == null) {
            return false;
        }
        this.cMV.setColor(i);
        this.cMW.setColor(i);
        return true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
        this.cMX.set(this.mWidth >> 1, this.mHeight >> 1);
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
    public void changeState(int i) {
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
            if (this.cMU == 0.0f) {
                this.cMW.setAlpha(0);
                this.mCanvas.drawCircle(this.cMX.x, this.cMX.y, cMQ, this.cMW);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            } else if (this.cMU <= 0.5f) {
                int i = (int) (this.cMU * 77.0f);
                this.cMW.setAlpha(i);
                this.mCanvas.drawCircle(this.cMX.x, this.cMX.y, cMQ, this.cMW);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "first level,alpha=" + i);
                }
            } else if (this.cMU < 1.0f) {
                int iN = iN((int) (this.cMU * 77.0f));
                this.cMW.setAlpha(iN);
                float f = (this.cMU - 0.5f) * 2.0f;
                int iN2 = iN((int) (26.0f * f));
                this.cMV.setAlpha(iN2);
                this.mCanvas.drawCircle(this.cMX.x + (cMT * f), this.cMX.y, cMQ, this.cMW);
                this.mCanvas.drawCircle(this.cMX.x - (cMT * f), this.cMX.y, cMQ, this.cMV);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "second level,mAnimPercent=" + this.cMU);
                    Log.e("NeutralRefreshAnimView", "second level,rightBallAlpha=" + iN);
                    Log.e("NeutralRefreshAnimView", "second level,leftBallAlpha=" + iN2);
                    Log.e("NeutralRefreshAnimView", "second level,fraction=" + f);
                    Log.e("NeutralRefreshAnimView", "second level,HALF_MAX_DISTANCE * fraction=" + (f * cMT));
                }
            } else if (this.cMU == 1.0f) {
                this.cMV.setAlpha(26);
                this.cMW.setAlpha(77);
                this.mCanvas.drawCircle(this.cMX.x + cMT, this.cMX.y, cMQ, this.cMW);
                this.mCanvas.drawCircle(this.cMX.x - cMT, this.cMX.y, cMQ, this.cMV);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "third level,mAnimPercent=" + this.cMU);
                }
            }
        }
    }

    public void ayN() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshingAnim");
        }
        changeState(2);
        ayO();
    }

    private void ayO() {
        ayM();
        this.cMZ = ValueAnimator.ofFloat(1.0f, -1.0f);
        this.cMZ.setDuration(480L);
        this.cMZ.setRepeatMode(2);
        this.cMZ.setRepeatCount(-1);
        this.cMZ.setInterpolator(new AccelerateDecelerateInterpolator());
        this.cMZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.cNa = NeutralRefreshAnimView.cMT * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mRightBallXPosi=" + NeutralRefreshAnimView.this.cNa + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.cMY = ValueAnimator.ofFloat(-1.0f, 1.0f);
        this.cMY.setDuration(480L);
        this.cMY.setRepeatMode(2);
        this.cMY.setRepeatCount(-1);
        this.cMY.setInterpolator(new AccelerateDecelerateInterpolator());
        this.cMY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.cNb = NeutralRefreshAnimView.cMT * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mLeftBallXPosi=" + NeutralRefreshAnimView.this.cNb + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.mAnimatorSet = new AnimatorSet();
        this.mAnimatorSet.playTogether(this.cMY, this.cMZ);
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

    private void r(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.cMW.setAlpha(77);
            this.mCanvas.drawCircle(this.cMX.x + this.cNa, this.cMX.y, cMQ, this.cMW);
            this.cMV.setAlpha(26);
            this.mCanvas.drawCircle(this.cMX.x + this.cNb, this.cMX.y, cMQ, this.cMV);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "performOnRefreshingAnim");
            }
        }
    }

    public void ayP() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshCompleteAnim");
        }
        stopAnim();
        changeState(3);
        ayQ();
    }

    private void ayQ() {
        this.cNc = ValueAnimator.ofInt(26, 0);
        this.cNc.setDuration(300L);
        this.cNc.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.cNe = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.cNe);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.cNc.isRunning()) {
            this.cNc.start();
        }
        this.cNd = ValueAnimator.ofInt(77, 0);
        this.cNd.setDuration(300L);
        this.cNd.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.cNf = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.cNe);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.cNd.isRunning()) {
            this.cNd.start();
        }
    }

    private void s(Canvas canvas) {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "performRefreshCompleteAnim");
        }
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.cNe = iN(this.cNe);
            this.cNf = iN(this.cNf);
            this.cMW.setAlpha(this.cNf);
            this.cMV.setAlpha(this.cNe);
            this.mCanvas.drawCircle(this.cMX.x + this.cNa, this.cMX.y, cMQ, this.cMW);
            this.cMV.setAlpha(this.cNe);
            this.mCanvas.drawCircle(this.cMX.x + this.cNb, this.cMX.y, cMQ, this.cMV);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "Complete:mAlpha=" + this.cNe);
                Log.e("NeutralRefreshAnimView", "Complete:mRightBallXPosi=" + this.cNa);
                Log.e("NeutralRefreshAnimView", "Complete:mLeftBallXPosi=" + this.cNb);
            }
        }
    }

    public void stopAnim() {
        ayM();
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

    private void ayM() {
        a(this.cMY, true);
        a(this.cMZ, true);
        a(this.cNc, false);
        a(this.cNd, false);
        if (this.mAnimatorSet != null) {
            this.mAnimatorSet.removeAllListeners();
            this.mAnimatorSet.end();
            this.mAnimatorSet.cancel();
        }
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "resetAnimator");
        }
    }

    private int iN(int i) {
        int i2 = i < 0 ? 0 : i;
        if (i2 > 255) {
            return 255;
        }
        return i2;
    }
}
