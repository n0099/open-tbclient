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
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.ao.p;
import com.baidu.swan.apps.b;
/* loaded from: classes9.dex */
public class NeutralRefreshAnimView extends View {
    private static final boolean DEBUG = b.DEBUG;
    private static final int dyu = ah.P(3.5f);
    private static final int dyv = Color.parseColor("#000000");
    private static final int dyw = ah.P(18.0f);
    private static final int dyx = dyw >> 1;
    private Paint dyA;
    private PointF dyB;
    private ValueAnimator dyC;
    private ValueAnimator dyD;
    private float dyE;
    private float dyF;
    private ValueAnimator dyG;
    private ValueAnimator dyH;
    private int dyI;
    private int dyJ;
    private float dyy;
    private Paint dyz;
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
        this.dyB = new PointF();
        this.dyz = new Paint(1);
        this.dyA = new Paint(1);
        this.dyz.setColor(dyv);
        this.dyA.setColor(dyv);
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        float f3 = f2 <= 1.0f ? f2 : 1.0f;
        this.dyy = f3;
        iF(1);
        postInvalidate();
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "setAnimPercent, percent = " + f3);
        }
    }

    public boolean gf(int i) {
        if (this.dyA == null || this.dyz == null) {
            return false;
        }
        this.dyz.setColor(i);
        this.dyA.setColor(i);
        return true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
        this.dyB.set(this.mWidth >> 1, this.mHeight >> 1);
    }

    @Override // android.view.View
    protected void onSizeChanged(final int i, final int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            p.b(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.1
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
                x(canvas);
                break;
            case 2:
                y(canvas);
                break;
            case 3:
                z(canvas);
                break;
            case 4:
                y(canvas);
                break;
        }
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iF(int i) {
        this.mState = i;
        if (DEBUG) {
            Log.i("NeutralRefreshAnimView", "curr state:" + this.mState);
        }
    }

    private void x(Canvas canvas) {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "performPullToRefreshAnim");
        }
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            if (this.dyy == 0.0f) {
                this.dyA.setAlpha(0);
                this.mCanvas.drawCircle(this.dyB.x, this.dyB.y, dyu, this.dyA);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            } else if (this.dyy <= 0.5f) {
                int i = (int) (this.dyy * 77.0f);
                this.dyA.setAlpha(i);
                this.mCanvas.drawCircle(this.dyB.x, this.dyB.y, dyu, this.dyA);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "first level,alpha=" + i);
                }
            } else if (this.dyy < 1.0f) {
                int iG = iG((int) (this.dyy * 77.0f));
                this.dyA.setAlpha(iG);
                float f = (this.dyy - 0.5f) * 2.0f;
                int iG2 = iG((int) (26.0f * f));
                this.dyz.setAlpha(iG2);
                this.mCanvas.drawCircle(this.dyB.x + (dyx * f), this.dyB.y, dyu, this.dyA);
                this.mCanvas.drawCircle(this.dyB.x - (dyx * f), this.dyB.y, dyu, this.dyz);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "second level,mAnimPercent=" + this.dyy);
                    Log.e("NeutralRefreshAnimView", "second level,rightBallAlpha=" + iG);
                    Log.e("NeutralRefreshAnimView", "second level,leftBallAlpha=" + iG2);
                    Log.e("NeutralRefreshAnimView", "second level,fraction=" + f);
                    Log.e("NeutralRefreshAnimView", "second level,HALF_MAX_DISTANCE * fraction=" + (f * dyx));
                }
            } else if (this.dyy == 1.0f) {
                this.dyz.setAlpha(26);
                this.dyA.setAlpha(77);
                this.mCanvas.drawCircle(this.dyB.x + dyx, this.dyB.y, dyu, this.dyA);
                this.mCanvas.drawCircle(this.dyB.x - dyx, this.dyB.y, dyu, this.dyz);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "third level,mAnimPercent=" + this.dyy);
                }
            }
        }
    }

    public void aHj() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshingAnim");
        }
        iF(2);
        aHk();
    }

    private void aHk() {
        aHi();
        this.dyD = ValueAnimator.ofFloat(1.0f, -1.0f);
        this.dyD.setDuration(480L);
        this.dyD.setRepeatMode(2);
        this.dyD.setRepeatCount(-1);
        this.dyD.setInterpolator(new AccelerateDecelerateInterpolator());
        this.dyD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.dyE = NeutralRefreshAnimView.dyx * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mRightBallXPosi=" + NeutralRefreshAnimView.this.dyE + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.dyC = ValueAnimator.ofFloat(-1.0f, 1.0f);
        this.dyC.setDuration(480L);
        this.dyC.setRepeatMode(2);
        this.dyC.setRepeatCount(-1);
        this.dyC.setInterpolator(new AccelerateDecelerateInterpolator());
        this.dyC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.dyF = NeutralRefreshAnimView.dyx * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mLeftBallXPosi=" + NeutralRefreshAnimView.this.dyF + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.mAnimatorSet = new AnimatorSet();
        this.mAnimatorSet.playTogether(this.dyC, this.dyD);
        this.mAnimatorSet.setDuration(480L);
        this.mAnimatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                NeutralRefreshAnimView.this.iF(4);
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

    private void y(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.dyA.setAlpha(77);
            this.mCanvas.drawCircle(this.dyB.x + this.dyE, this.dyB.y, dyu, this.dyA);
            this.dyz.setAlpha(26);
            this.mCanvas.drawCircle(this.dyB.x + this.dyF, this.dyB.y, dyu, this.dyz);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "performOnRefreshingAnim");
            }
        }
    }

    public void aHl() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshCompleteAnim");
        }
        stopAnim();
        iF(3);
        aHm();
    }

    private void aHm() {
        this.dyG = ValueAnimator.ofInt(26, 0);
        this.dyG.setDuration(300L);
        this.dyG.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.dyI = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.dyI);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.dyG.isRunning()) {
            this.dyG.start();
        }
        this.dyH = ValueAnimator.ofInt(77, 0);
        this.dyH.setDuration(300L);
        this.dyH.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.dyJ = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.dyI);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.dyH.isRunning()) {
            this.dyH.start();
        }
    }

    private void z(Canvas canvas) {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "performRefreshCompleteAnim");
        }
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.dyI = iG(this.dyI);
            this.dyJ = iG(this.dyJ);
            this.dyA.setAlpha(this.dyJ);
            this.dyz.setAlpha(this.dyI);
            this.mCanvas.drawCircle(this.dyB.x + this.dyE, this.dyB.y, dyu, this.dyA);
            this.dyz.setAlpha(this.dyI);
            this.mCanvas.drawCircle(this.dyB.x + this.dyF, this.dyB.y, dyu, this.dyz);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "Complete:mAlpha=" + this.dyI);
                Log.e("NeutralRefreshAnimView", "Complete:mRightBallXPosi=" + this.dyE);
                Log.e("NeutralRefreshAnimView", "Complete:mLeftBallXPosi=" + this.dyF);
            }
        }
    }

    public void stopAnim() {
        aHi();
        clearAnimation();
        iF(1);
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

    private void aHi() {
        a(this.dyC, true);
        a(this.dyD, true);
        a(this.dyG, false);
        a(this.dyH, false);
        if (this.mAnimatorSet != null) {
            this.mAnimatorSet.removeAllListeners();
            this.mAnimatorSet.end();
            this.mAnimatorSet.cancel();
        }
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "resetAnimator");
        }
    }

    private int iG(int i) {
        int i2 = i < 0 ? 0 : i;
        if (i2 > 255) {
            return 255;
        }
        return i2;
    }
}
