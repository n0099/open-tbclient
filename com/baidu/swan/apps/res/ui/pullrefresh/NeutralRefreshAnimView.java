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
/* loaded from: classes10.dex */
public class NeutralRefreshAnimView extends View {
    private static final boolean DEBUG = b.DEBUG;
    private static final int dpw = ah.N(3.5f);
    private static final int dpx = Color.parseColor("#000000");
    private static final int dpy = ah.N(18.0f);
    private static final int dpz = dpy >> 1;
    private float dpA;
    private Paint dpB;
    private Paint dpC;
    private PointF dpD;
    private ValueAnimator dpE;
    private ValueAnimator dpF;
    private float dpG;
    private float dpH;
    private ValueAnimator dpI;
    private ValueAnimator dpJ;
    private int dpK;
    private int dpL;
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
        this.dpD = new PointF();
        this.dpB = new Paint(1);
        this.dpC = new Paint(1);
        this.dpB.setColor(dpx);
        this.dpC.setColor(dpx);
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        float f3 = f2 <= 1.0f ? f2 : 1.0f;
        this.dpA = f3;
        jP(1);
        postInvalidate();
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "setAnimPercent, percent = " + f3);
        }
    }

    public boolean hv(int i) {
        if (this.dpC == null || this.dpB == null) {
            return false;
        }
        this.dpB.setColor(i);
        this.dpC.setColor(i);
        return true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
        this.dpD.set(this.mWidth >> 1, this.mHeight >> 1);
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
    public void jP(int i) {
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
            if (this.dpA == 0.0f) {
                this.dpC.setAlpha(0);
                this.mCanvas.drawCircle(this.dpD.x, this.dpD.y, dpw, this.dpC);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            } else if (this.dpA <= 0.5f) {
                int i = (int) (this.dpA * 77.0f);
                this.dpC.setAlpha(i);
                this.mCanvas.drawCircle(this.dpD.x, this.dpD.y, dpw, this.dpC);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "first level,alpha=" + i);
                }
            } else if (this.dpA < 1.0f) {
                int jQ = jQ((int) (this.dpA * 77.0f));
                this.dpC.setAlpha(jQ);
                float f = (this.dpA - 0.5f) * 2.0f;
                int jQ2 = jQ((int) (26.0f * f));
                this.dpB.setAlpha(jQ2);
                this.mCanvas.drawCircle(this.dpD.x + (dpz * f), this.dpD.y, dpw, this.dpC);
                this.mCanvas.drawCircle(this.dpD.x - (dpz * f), this.dpD.y, dpw, this.dpB);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "second level,mAnimPercent=" + this.dpA);
                    Log.e("NeutralRefreshAnimView", "second level,rightBallAlpha=" + jQ);
                    Log.e("NeutralRefreshAnimView", "second level,leftBallAlpha=" + jQ2);
                    Log.e("NeutralRefreshAnimView", "second level,fraction=" + f);
                    Log.e("NeutralRefreshAnimView", "second level,HALF_MAX_DISTANCE * fraction=" + (f * dpz));
                }
            } else if (this.dpA == 1.0f) {
                this.dpB.setAlpha(26);
                this.dpC.setAlpha(77);
                this.mCanvas.drawCircle(this.dpD.x + dpz, this.dpD.y, dpw, this.dpC);
                this.mCanvas.drawCircle(this.dpD.x - dpz, this.dpD.y, dpw, this.dpB);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "third level,mAnimPercent=" + this.dpA);
                }
            }
        }
    }

    public void aGz() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshingAnim");
        }
        jP(2);
        aGA();
    }

    private void aGA() {
        aGy();
        this.dpF = ValueAnimator.ofFloat(1.0f, -1.0f);
        this.dpF.setDuration(480L);
        this.dpF.setRepeatMode(2);
        this.dpF.setRepeatCount(-1);
        this.dpF.setInterpolator(new AccelerateDecelerateInterpolator());
        this.dpF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.dpG = NeutralRefreshAnimView.dpz * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mRightBallXPosi=" + NeutralRefreshAnimView.this.dpG + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.dpE = ValueAnimator.ofFloat(-1.0f, 1.0f);
        this.dpE.setDuration(480L);
        this.dpE.setRepeatMode(2);
        this.dpE.setRepeatCount(-1);
        this.dpE.setInterpolator(new AccelerateDecelerateInterpolator());
        this.dpE.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.dpH = NeutralRefreshAnimView.dpz * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mLeftBallXPosi=" + NeutralRefreshAnimView.this.dpH + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.mAnimatorSet = new AnimatorSet();
        this.mAnimatorSet.playTogether(this.dpE, this.dpF);
        this.mAnimatorSet.setDuration(480L);
        this.mAnimatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                NeutralRefreshAnimView.this.jP(4);
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
            this.dpC.setAlpha(77);
            this.mCanvas.drawCircle(this.dpD.x + this.dpG, this.dpD.y, dpw, this.dpC);
            this.dpB.setAlpha(26);
            this.mCanvas.drawCircle(this.dpD.x + this.dpH, this.dpD.y, dpw, this.dpB);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "performOnRefreshingAnim");
            }
        }
    }

    public void aGB() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshCompleteAnim");
        }
        stopAnim();
        jP(3);
        aGC();
    }

    private void aGC() {
        this.dpI = ValueAnimator.ofInt(26, 0);
        this.dpI.setDuration(300L);
        this.dpI.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.dpK = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.dpK);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.dpI.isRunning()) {
            this.dpI.start();
        }
        this.dpJ = ValueAnimator.ofInt(77, 0);
        this.dpJ.setDuration(300L);
        this.dpJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.dpL = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.dpK);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.dpJ.isRunning()) {
            this.dpJ.start();
        }
    }

    private void s(Canvas canvas) {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "performRefreshCompleteAnim");
        }
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.dpK = jQ(this.dpK);
            this.dpL = jQ(this.dpL);
            this.dpC.setAlpha(this.dpL);
            this.dpB.setAlpha(this.dpK);
            this.mCanvas.drawCircle(this.dpD.x + this.dpG, this.dpD.y, dpw, this.dpC);
            this.dpB.setAlpha(this.dpK);
            this.mCanvas.drawCircle(this.dpD.x + this.dpH, this.dpD.y, dpw, this.dpB);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "Complete:mAlpha=" + this.dpK);
                Log.e("NeutralRefreshAnimView", "Complete:mRightBallXPosi=" + this.dpG);
                Log.e("NeutralRefreshAnimView", "Complete:mLeftBallXPosi=" + this.dpH);
            }
        }
    }

    public void stopAnim() {
        aGy();
        clearAnimation();
        jP(1);
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

    private void aGy() {
        a(this.dpE, true);
        a(this.dpF, true);
        a(this.dpI, false);
        a(this.dpJ, false);
        if (this.mAnimatorSet != null) {
            this.mAnimatorSet.removeAllListeners();
            this.mAnimatorSet.end();
            this.mAnimatorSet.cancel();
        }
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "resetAnimator");
        }
    }

    private int jQ(int i) {
        int i2 = i < 0 ? 0 : i;
        if (i2 > 255) {
            return 255;
        }
        return i2;
    }
}
