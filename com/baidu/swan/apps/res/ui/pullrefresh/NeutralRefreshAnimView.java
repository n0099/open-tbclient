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
    private static final int bLO = af.S(3.5f);
    private static final int bLP = Color.parseColor(BaseBrowseView.ROOT_VIEW_COLOR);
    private static final int bLQ = af.S(18.0f);
    private static final int bLR = bLQ >> 1;
    private float bLS;
    private Paint bLT;
    private Paint bLU;
    private PointF bLV;
    private ValueAnimator bLW;
    private ValueAnimator bLX;
    private float bLY;
    private float bLZ;
    private ValueAnimator bMa;
    private ValueAnimator bMb;
    private int bMc;
    private int bMd;
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
        this.bLV = new PointF();
        this.bLT = new Paint(1);
        this.bLU = new Paint(1);
        this.bLT.setColor(bLP);
        this.bLU.setColor(bLP);
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        float f3 = f2 <= 1.0f ? f2 : 1.0f;
        this.bLS = f3;
        changeState(1);
        postInvalidate();
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "setAnimPercent, percent = " + f3);
        }
    }

    public boolean dW(int i) {
        if (this.bLU == null || this.bLT == null) {
            return false;
        }
        this.bLT.setColor(i);
        this.bLU.setColor(i);
        return true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
        this.bLV.set(this.mWidth >> 1, this.mHeight >> 1);
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
            if (this.bLS == 0.0f) {
                this.bLU.setAlpha(0);
                this.mCanvas.drawCircle(this.bLV.x, this.bLV.y, bLO, this.bLU);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            } else if (this.bLS <= 0.5f) {
                int i = (int) (this.bLS * 77.0f);
                this.bLU.setAlpha(i);
                this.mCanvas.drawCircle(this.bLV.x, this.bLV.y, bLO, this.bLU);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "first level,alpha=" + i);
                }
            } else if (this.bLS < 1.0f) {
                int fL = fL((int) (this.bLS * 77.0f));
                this.bLU.setAlpha(fL);
                float f = (this.bLS - 0.5f) * 2.0f;
                int fL2 = fL((int) (26.0f * f));
                this.bLT.setAlpha(fL2);
                this.mCanvas.drawCircle(this.bLV.x + (bLR * f), this.bLV.y, bLO, this.bLU);
                this.mCanvas.drawCircle(this.bLV.x - (bLR * f), this.bLV.y, bLO, this.bLT);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "second level,mAnimPercent=" + this.bLS);
                    Log.e("NeutralRefreshAnimView", "second level,rightBallAlpha=" + fL);
                    Log.e("NeutralRefreshAnimView", "second level,leftBallAlpha=" + fL2);
                    Log.e("NeutralRefreshAnimView", "second level,fraction=" + f);
                    Log.e("NeutralRefreshAnimView", "second level,HALF_MAX_DISTANCE * fraction=" + (f * bLR));
                }
            } else if (this.bLS == 1.0f) {
                this.bLT.setAlpha(26);
                this.bLU.setAlpha(77);
                this.mCanvas.drawCircle(this.bLV.x + bLR, this.bLV.y, bLO, this.bLU);
                this.mCanvas.drawCircle(this.bLV.x - bLR, this.bLV.y, bLO, this.bLT);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "third level,mAnimPercent=" + this.bLS);
                }
            }
        }
    }

    public void abO() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshingAnim");
        }
        changeState(2);
        abP();
    }

    private void abP() {
        abN();
        this.bLX = ValueAnimator.ofFloat(1.0f, -1.0f);
        this.bLX.setDuration(480L);
        this.bLX.setRepeatMode(2);
        this.bLX.setRepeatCount(-1);
        this.bLX.setInterpolator(new AccelerateDecelerateInterpolator());
        this.bLX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.bLY = NeutralRefreshAnimView.bLR * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mRightBallXPosi=" + NeutralRefreshAnimView.this.bLY + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.bLW = ValueAnimator.ofFloat(-1.0f, 1.0f);
        this.bLW.setDuration(480L);
        this.bLW.setRepeatMode(2);
        this.bLW.setRepeatCount(-1);
        this.bLW.setInterpolator(new AccelerateDecelerateInterpolator());
        this.bLW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.bLZ = NeutralRefreshAnimView.bLR * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mLeftBallXPosi=" + NeutralRefreshAnimView.this.bLZ + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.mAnimatorSet = new AnimatorSet();
        this.mAnimatorSet.playTogether(this.bLW, this.bLX);
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
            this.bLU.setAlpha(77);
            this.mCanvas.drawCircle(this.bLV.x + this.bLY, this.bLV.y, bLO, this.bLU);
            this.bLT.setAlpha(26);
            this.mCanvas.drawCircle(this.bLV.x + this.bLZ, this.bLV.y, bLO, this.bLT);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "performOnRefreshingAnim");
            }
        }
    }

    public void abQ() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshCompleteAnim");
        }
        stopAnim();
        changeState(3);
        abR();
    }

    private void abR() {
        this.bMa = ValueAnimator.ofInt(26, 0);
        this.bMa.setDuration(300L);
        this.bMa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.bMc = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.bMc);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.bMa.isRunning()) {
            this.bMa.start();
        }
        this.bMb = ValueAnimator.ofInt(77, 0);
        this.bMb.setDuration(300L);
        this.bMb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.bMd = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.bMc);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.bMb.isRunning()) {
            this.bMb.start();
        }
    }

    private void p(Canvas canvas) {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "performRefreshCompleteAnim");
        }
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.bMc = fL(this.bMc);
            this.bMd = fL(this.bMd);
            this.bLU.setAlpha(this.bMd);
            this.bLT.setAlpha(this.bMc);
            this.mCanvas.drawCircle(this.bLV.x + this.bLY, this.bLV.y, bLO, this.bLU);
            this.bLT.setAlpha(this.bMc);
            this.mCanvas.drawCircle(this.bLV.x + this.bLZ, this.bLV.y, bLO, this.bLT);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "Complete:mAlpha=" + this.bMc);
                Log.e("NeutralRefreshAnimView", "Complete:mRightBallXPosi=" + this.bLY);
                Log.e("NeutralRefreshAnimView", "Complete:mLeftBallXPosi=" + this.bLZ);
            }
        }
    }

    public void stopAnim() {
        abN();
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

    private void abN() {
        a(this.bLW, true);
        a(this.bLX, true);
        a(this.bMa, false);
        a(this.bMb, false);
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
