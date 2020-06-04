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
import com.baidu.swan.apps.aq.ag;
import com.baidu.swan.apps.aq.n;
import com.baidu.swan.apps.b;
/* loaded from: classes11.dex */
public class NeutralRefreshAnimView extends View {
    private static final boolean DEBUG = b.DEBUG;
    private static final int cwv = ag.B(3.5f);
    private static final int cww = Color.parseColor("#000000");
    private static final int cwx = ag.B(18.0f);
    private static final int cwy = cwx >> 1;
    private Paint cwA;
    private Paint cwB;
    private PointF cwC;
    private ValueAnimator cwD;
    private ValueAnimator cwE;
    private float cwF;
    private float cwG;
    private ValueAnimator cwH;
    private ValueAnimator cwI;
    private int cwJ;
    private int cwK;
    private float cwz;
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
        this.cwC = new PointF();
        this.cwA = new Paint(1);
        this.cwB = new Paint(1);
        this.cwA.setColor(cww);
        this.cwB.setColor(cww);
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        float f3 = f2 <= 1.0f ? f2 : 1.0f;
        this.cwz = f3;
        changeState(1);
        postInvalidate();
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "setAnimPercent, percent = " + f3);
        }
    }

    public boolean ej(int i) {
        if (this.cwB == null || this.cwA == null) {
            return false;
        }
        this.cwA.setColor(i);
        this.cwB.setColor(i);
        return true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
        this.cwC.set(this.mWidth >> 1, this.mHeight >> 1);
    }

    @Override // android.view.View
    protected void onSizeChanged(final int i, final int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            n.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.1
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
            if (this.cwz == 0.0f) {
                this.cwB.setAlpha(0);
                this.mCanvas.drawCircle(this.cwC.x, this.cwC.y, cwv, this.cwB);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            } else if (this.cwz <= 0.5f) {
                int i = (int) (this.cwz * 77.0f);
                this.cwB.setAlpha(i);
                this.mCanvas.drawCircle(this.cwC.x, this.cwC.y, cwv, this.cwB);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "first level,alpha=" + i);
                }
            } else if (this.cwz < 1.0f) {
                int gl = gl((int) (this.cwz * 77.0f));
                this.cwB.setAlpha(gl);
                float f = (this.cwz - 0.5f) * 2.0f;
                int gl2 = gl((int) (26.0f * f));
                this.cwA.setAlpha(gl2);
                this.mCanvas.drawCircle(this.cwC.x + (cwy * f), this.cwC.y, cwv, this.cwB);
                this.mCanvas.drawCircle(this.cwC.x - (cwy * f), this.cwC.y, cwv, this.cwA);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "second level,mAnimPercent=" + this.cwz);
                    Log.e("NeutralRefreshAnimView", "second level,rightBallAlpha=" + gl);
                    Log.e("NeutralRefreshAnimView", "second level,leftBallAlpha=" + gl2);
                    Log.e("NeutralRefreshAnimView", "second level,fraction=" + f);
                    Log.e("NeutralRefreshAnimView", "second level,HALF_MAX_DISTANCE * fraction=" + (f * cwy));
                }
            } else if (this.cwz == 1.0f) {
                this.cwA.setAlpha(26);
                this.cwB.setAlpha(77);
                this.mCanvas.drawCircle(this.cwC.x + cwy, this.cwC.y, cwv, this.cwB);
                this.mCanvas.drawCircle(this.cwC.x - cwy, this.cwC.y, cwv, this.cwA);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "third level,mAnimPercent=" + this.cwz);
                }
            }
        }
    }

    public void anL() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshingAnim");
        }
        changeState(2);
        anM();
    }

    private void anM() {
        anK();
        this.cwE = ValueAnimator.ofFloat(1.0f, -1.0f);
        this.cwE.setDuration(480L);
        this.cwE.setRepeatMode(2);
        this.cwE.setRepeatCount(-1);
        this.cwE.setInterpolator(new AccelerateDecelerateInterpolator());
        this.cwE.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.cwF = NeutralRefreshAnimView.cwy * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mRightBallXPosi=" + NeutralRefreshAnimView.this.cwF + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.cwD = ValueAnimator.ofFloat(-1.0f, 1.0f);
        this.cwD.setDuration(480L);
        this.cwD.setRepeatMode(2);
        this.cwD.setRepeatCount(-1);
        this.cwD.setInterpolator(new AccelerateDecelerateInterpolator());
        this.cwD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.cwG = NeutralRefreshAnimView.cwy * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mLeftBallXPosi=" + NeutralRefreshAnimView.this.cwG + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.mAnimatorSet = new AnimatorSet();
        this.mAnimatorSet.playTogether(this.cwD, this.cwE);
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
            this.cwB.setAlpha(77);
            this.mCanvas.drawCircle(this.cwC.x + this.cwF, this.cwC.y, cwv, this.cwB);
            this.cwA.setAlpha(26);
            this.mCanvas.drawCircle(this.cwC.x + this.cwG, this.cwC.y, cwv, this.cwA);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "performOnRefreshingAnim");
            }
        }
    }

    public void anN() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshCompleteAnim");
        }
        stopAnim();
        changeState(3);
        anO();
    }

    private void anO() {
        this.cwH = ValueAnimator.ofInt(26, 0);
        this.cwH.setDuration(300L);
        this.cwH.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.cwJ = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.cwJ);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.cwH.isRunning()) {
            this.cwH.start();
        }
        this.cwI = ValueAnimator.ofInt(77, 0);
        this.cwI.setDuration(300L);
        this.cwI.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.cwK = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.cwJ);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.cwI.isRunning()) {
            this.cwI.start();
        }
    }

    private void q(Canvas canvas) {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "performRefreshCompleteAnim");
        }
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.cwJ = gl(this.cwJ);
            this.cwK = gl(this.cwK);
            this.cwB.setAlpha(this.cwK);
            this.cwA.setAlpha(this.cwJ);
            this.mCanvas.drawCircle(this.cwC.x + this.cwF, this.cwC.y, cwv, this.cwB);
            this.cwA.setAlpha(this.cwJ);
            this.mCanvas.drawCircle(this.cwC.x + this.cwG, this.cwC.y, cwv, this.cwA);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "Complete:mAlpha=" + this.cwJ);
                Log.e("NeutralRefreshAnimView", "Complete:mRightBallXPosi=" + this.cwF);
                Log.e("NeutralRefreshAnimView", "Complete:mLeftBallXPosi=" + this.cwG);
            }
        }
    }

    public void stopAnim() {
        anK();
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

    private void anK() {
        a(this.cwD, true);
        a(this.cwE, true);
        a(this.cwH, false);
        a(this.cwI, false);
        if (this.mAnimatorSet != null) {
            this.mAnimatorSet.removeAllListeners();
            this.mAnimatorSet.end();
            this.mAnimatorSet.cancel();
        }
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "resetAnimator");
        }
    }

    private int gl(int i) {
        int i2 = i < 0 ? 0 : i;
        if (i2 > 255) {
            return 255;
        }
        return i2;
    }
}
