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
/* loaded from: classes10.dex */
public class NeutralRefreshAnimView extends View {
    private static final boolean DEBUG = b.DEBUG;
    private static final int bHJ = af.S(3.5f);
    private static final int bHK = Color.parseColor(BaseBrowseView.ROOT_VIEW_COLOR);
    private static final int bHL = af.S(18.0f);
    private static final int bHM = bHL >> 1;
    private float bHN;
    private Paint bHO;
    private Paint bHP;
    private PointF bHQ;
    private ValueAnimator bHR;
    private ValueAnimator bHS;
    private float bHT;
    private float bHU;
    private ValueAnimator bHV;
    private ValueAnimator bHW;
    private int bHX;
    private int bHY;
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
        this.bHQ = new PointF();
        this.bHO = new Paint(1);
        this.bHP = new Paint(1);
        this.bHO.setColor(bHK);
        this.bHP.setColor(bHK);
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        float f3 = f2 <= 1.0f ? f2 : 1.0f;
        this.bHN = f3;
        changeState(1);
        postInvalidate();
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "setAnimPercent, percent = " + f3);
        }
    }

    public boolean dG(int i) {
        if (this.bHP == null || this.bHO == null) {
            return false;
        }
        this.bHO.setColor(i);
        this.bHP.setColor(i);
        return true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
        this.bHQ.set(this.mWidth >> 1, this.mHeight >> 1);
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
            if (this.bHN == 0.0f) {
                this.bHP.setAlpha(0);
                this.mCanvas.drawCircle(this.bHQ.x, this.bHQ.y, bHJ, this.bHP);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            } else if (this.bHN <= 0.5f) {
                int i = (int) (this.bHN * 77.0f);
                this.bHP.setAlpha(i);
                this.mCanvas.drawCircle(this.bHQ.x, this.bHQ.y, bHJ, this.bHP);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "first level,alpha=" + i);
                }
            } else if (this.bHN < 1.0f) {
                int fv = fv((int) (this.bHN * 77.0f));
                this.bHP.setAlpha(fv);
                float f = (this.bHN - 0.5f) * 2.0f;
                int fv2 = fv((int) (26.0f * f));
                this.bHO.setAlpha(fv2);
                this.mCanvas.drawCircle(this.bHQ.x + (bHM * f), this.bHQ.y, bHJ, this.bHP);
                this.mCanvas.drawCircle(this.bHQ.x - (bHM * f), this.bHQ.y, bHJ, this.bHO);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "second level,mAnimPercent=" + this.bHN);
                    Log.e("NeutralRefreshAnimView", "second level,rightBallAlpha=" + fv);
                    Log.e("NeutralRefreshAnimView", "second level,leftBallAlpha=" + fv2);
                    Log.e("NeutralRefreshAnimView", "second level,fraction=" + f);
                    Log.e("NeutralRefreshAnimView", "second level,HALF_MAX_DISTANCE * fraction=" + (f * bHM));
                }
            } else if (this.bHN == 1.0f) {
                this.bHO.setAlpha(26);
                this.bHP.setAlpha(77);
                this.mCanvas.drawCircle(this.bHQ.x + bHM, this.bHQ.y, bHJ, this.bHP);
                this.mCanvas.drawCircle(this.bHQ.x - bHM, this.bHQ.y, bHJ, this.bHO);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "third level,mAnimPercent=" + this.bHN);
                }
            }
        }
    }

    public void ZA() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshingAnim");
        }
        changeState(2);
        ZB();
    }

    private void ZB() {
        Zz();
        this.bHS = ValueAnimator.ofFloat(1.0f, -1.0f);
        this.bHS.setDuration(480L);
        this.bHS.setRepeatMode(2);
        this.bHS.setRepeatCount(-1);
        this.bHS.setInterpolator(new AccelerateDecelerateInterpolator());
        this.bHS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.bHT = NeutralRefreshAnimView.bHM * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mRightBallXPosi=" + NeutralRefreshAnimView.this.bHT + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.bHR = ValueAnimator.ofFloat(-1.0f, 1.0f);
        this.bHR.setDuration(480L);
        this.bHR.setRepeatMode(2);
        this.bHR.setRepeatCount(-1);
        this.bHR.setInterpolator(new AccelerateDecelerateInterpolator());
        this.bHR.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.bHU = NeutralRefreshAnimView.bHM * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mLeftBallXPosi=" + NeutralRefreshAnimView.this.bHU + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.mAnimatorSet = new AnimatorSet();
        this.mAnimatorSet.playTogether(this.bHR, this.bHS);
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
            this.bHP.setAlpha(77);
            this.mCanvas.drawCircle(this.bHQ.x + this.bHT, this.bHQ.y, bHJ, this.bHP);
            this.bHO.setAlpha(26);
            this.mCanvas.drawCircle(this.bHQ.x + this.bHU, this.bHQ.y, bHJ, this.bHO);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "performOnRefreshingAnim");
            }
        }
    }

    public void ZC() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshCompleteAnim");
        }
        stopAnim();
        changeState(3);
        ZD();
    }

    private void ZD() {
        this.bHV = ValueAnimator.ofInt(26, 0);
        this.bHV.setDuration(300L);
        this.bHV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.bHX = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.bHX);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.bHV.isRunning()) {
            this.bHV.start();
        }
        this.bHW = ValueAnimator.ofInt(77, 0);
        this.bHW.setDuration(300L);
        this.bHW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.bHY = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.bHX);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.bHW.isRunning()) {
            this.bHW.start();
        }
    }

    private void p(Canvas canvas) {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "performRefreshCompleteAnim");
        }
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.bHX = fv(this.bHX);
            this.bHY = fv(this.bHY);
            this.bHP.setAlpha(this.bHY);
            this.bHO.setAlpha(this.bHX);
            this.mCanvas.drawCircle(this.bHQ.x + this.bHT, this.bHQ.y, bHJ, this.bHP);
            this.bHO.setAlpha(this.bHX);
            this.mCanvas.drawCircle(this.bHQ.x + this.bHU, this.bHQ.y, bHJ, this.bHO);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "Complete:mAlpha=" + this.bHX);
                Log.e("NeutralRefreshAnimView", "Complete:mRightBallXPosi=" + this.bHT);
                Log.e("NeutralRefreshAnimView", "Complete:mLeftBallXPosi=" + this.bHU);
            }
        }
    }

    public void stopAnim() {
        Zz();
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

    private void Zz() {
        a(this.bHR, true);
        a(this.bHS, true);
        a(this.bHV, false);
        a(this.bHW, false);
        if (this.mAnimatorSet != null) {
            this.mAnimatorSet.removeAllListeners();
            this.mAnimatorSet.end();
            this.mAnimatorSet.cancel();
        }
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "resetAnimator");
        }
    }

    private int fv(int i) {
        int i2 = i < 0 ? 0 : i;
        if (i2 > 255) {
            return 255;
        }
        return i2;
    }
}
