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
    private static final int djB = ah.L(3.5f);
    private static final int djC = Color.parseColor("#000000");
    private static final int djD = ah.L(18.0f);
    private static final int djE = djD >> 1;
    private float djF;
    private Paint djG;
    private Paint djH;
    private PointF djI;
    private ValueAnimator djJ;
    private ValueAnimator djK;
    private float djL;
    private float djM;
    private ValueAnimator djN;
    private ValueAnimator djO;
    private int djP;
    private int djQ;
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
        this.djI = new PointF();
        this.djG = new Paint(1);
        this.djH = new Paint(1);
        this.djG.setColor(djC);
        this.djH.setColor(djC);
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        float f3 = f2 <= 1.0f ? f2 : 1.0f;
        this.djF = f3;
        jF(1);
        postInvalidate();
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "setAnimPercent, percent = " + f3);
        }
    }

    public boolean hl(int i) {
        if (this.djH == null || this.djG == null) {
            return false;
        }
        this.djG.setColor(i);
        this.djH.setColor(i);
        return true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
        this.djI.set(this.mWidth >> 1, this.mHeight >> 1);
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
    public void jF(int i) {
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
            if (this.djF == 0.0f) {
                this.djH.setAlpha(0);
                this.mCanvas.drawCircle(this.djI.x, this.djI.y, djB, this.djH);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            } else if (this.djF <= 0.5f) {
                int i = (int) (this.djF * 77.0f);
                this.djH.setAlpha(i);
                this.mCanvas.drawCircle(this.djI.x, this.djI.y, djB, this.djH);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "first level,alpha=" + i);
                }
            } else if (this.djF < 1.0f) {
                int jG = jG((int) (this.djF * 77.0f));
                this.djH.setAlpha(jG);
                float f = (this.djF - 0.5f) * 2.0f;
                int jG2 = jG((int) (26.0f * f));
                this.djG.setAlpha(jG2);
                this.mCanvas.drawCircle(this.djI.x + (djE * f), this.djI.y, djB, this.djH);
                this.mCanvas.drawCircle(this.djI.x - (djE * f), this.djI.y, djB, this.djG);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "second level,mAnimPercent=" + this.djF);
                    Log.e("NeutralRefreshAnimView", "second level,rightBallAlpha=" + jG);
                    Log.e("NeutralRefreshAnimView", "second level,leftBallAlpha=" + jG2);
                    Log.e("NeutralRefreshAnimView", "second level,fraction=" + f);
                    Log.e("NeutralRefreshAnimView", "second level,HALF_MAX_DISTANCE * fraction=" + (f * djE));
                }
            } else if (this.djF == 1.0f) {
                this.djG.setAlpha(26);
                this.djH.setAlpha(77);
                this.mCanvas.drawCircle(this.djI.x + djE, this.djI.y, djB, this.djH);
                this.mCanvas.drawCircle(this.djI.x - djE, this.djI.y, djB, this.djG);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "third level,mAnimPercent=" + this.djF);
                }
            }
        }
    }

    public void aDZ() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshingAnim");
        }
        jF(2);
        aEa();
    }

    private void aEa() {
        aDY();
        this.djK = ValueAnimator.ofFloat(1.0f, -1.0f);
        this.djK.setDuration(480L);
        this.djK.setRepeatMode(2);
        this.djK.setRepeatCount(-1);
        this.djK.setInterpolator(new AccelerateDecelerateInterpolator());
        this.djK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.djL = NeutralRefreshAnimView.djE * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mRightBallXPosi=" + NeutralRefreshAnimView.this.djL + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.djJ = ValueAnimator.ofFloat(-1.0f, 1.0f);
        this.djJ.setDuration(480L);
        this.djJ.setRepeatMode(2);
        this.djJ.setRepeatCount(-1);
        this.djJ.setInterpolator(new AccelerateDecelerateInterpolator());
        this.djJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.djM = NeutralRefreshAnimView.djE * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mLeftBallXPosi=" + NeutralRefreshAnimView.this.djM + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.mAnimatorSet = new AnimatorSet();
        this.mAnimatorSet.playTogether(this.djJ, this.djK);
        this.mAnimatorSet.setDuration(480L);
        this.mAnimatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                NeutralRefreshAnimView.this.jF(4);
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
            this.djH.setAlpha(77);
            this.mCanvas.drawCircle(this.djI.x + this.djL, this.djI.y, djB, this.djH);
            this.djG.setAlpha(26);
            this.mCanvas.drawCircle(this.djI.x + this.djM, this.djI.y, djB, this.djG);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "performOnRefreshingAnim");
            }
        }
    }

    public void aEb() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshCompleteAnim");
        }
        stopAnim();
        jF(3);
        aEc();
    }

    private void aEc() {
        this.djN = ValueAnimator.ofInt(26, 0);
        this.djN.setDuration(300L);
        this.djN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.djP = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.djP);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.djN.isRunning()) {
            this.djN.start();
        }
        this.djO = ValueAnimator.ofInt(77, 0);
        this.djO.setDuration(300L);
        this.djO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.djQ = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.djP);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.djO.isRunning()) {
            this.djO.start();
        }
    }

    private void s(Canvas canvas) {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "performRefreshCompleteAnim");
        }
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.djP = jG(this.djP);
            this.djQ = jG(this.djQ);
            this.djH.setAlpha(this.djQ);
            this.djG.setAlpha(this.djP);
            this.mCanvas.drawCircle(this.djI.x + this.djL, this.djI.y, djB, this.djH);
            this.djG.setAlpha(this.djP);
            this.mCanvas.drawCircle(this.djI.x + this.djM, this.djI.y, djB, this.djG);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "Complete:mAlpha=" + this.djP);
                Log.e("NeutralRefreshAnimView", "Complete:mRightBallXPosi=" + this.djL);
                Log.e("NeutralRefreshAnimView", "Complete:mLeftBallXPosi=" + this.djM);
            }
        }
    }

    public void stopAnim() {
        aDY();
        clearAnimation();
        jF(1);
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

    private void aDY() {
        a(this.djJ, true);
        a(this.djK, true);
        a(this.djN, false);
        a(this.djO, false);
        if (this.mAnimatorSet != null) {
            this.mAnimatorSet.removeAllListeners();
            this.mAnimatorSet.end();
            this.mAnimatorSet.cancel();
        }
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "resetAnimator");
        }
    }

    private int jG(int i) {
        int i2 = i < 0 ? 0 : i;
        if (i2 > 255) {
            return 255;
        }
        return i2;
    }
}
