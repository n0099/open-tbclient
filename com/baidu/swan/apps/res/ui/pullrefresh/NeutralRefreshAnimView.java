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
/* loaded from: classes3.dex */
public class NeutralRefreshAnimView extends View {
    private static final boolean DEBUG = b.DEBUG;
    private static final int cOU = ah.H(3.5f);
    private static final int cOV = Color.parseColor("#000000");
    private static final int cOW = ah.H(18.0f);
    private static final int cOX = cOW >> 1;
    private float cOY;
    private Paint cOZ;
    private Paint cPa;
    private PointF cPb;
    private ValueAnimator cPc;
    private ValueAnimator cPd;
    private float cPe;
    private float cPf;
    private ValueAnimator cPg;
    private ValueAnimator cPh;
    private int cPi;
    private int cPj;
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
        this.cPb = new PointF();
        this.cOZ = new Paint(1);
        this.cPa = new Paint(1);
        this.cOZ.setColor(cOV);
        this.cPa.setColor(cOV);
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        float f3 = f2 <= 1.0f ? f2 : 1.0f;
        this.cOY = f3;
        iX(1);
        postInvalidate();
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "setAnimPercent, percent = " + f3);
        }
    }

    public boolean gD(int i) {
        if (this.cPa == null || this.cOZ == null) {
            return false;
        }
        this.cOZ.setColor(i);
        this.cPa.setColor(i);
        return true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
        this.cPb.set(this.mWidth >> 1, this.mHeight >> 1);
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
    public void iX(int i) {
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
            if (this.cOY == 0.0f) {
                this.cPa.setAlpha(0);
                this.mCanvas.drawCircle(this.cPb.x, this.cPb.y, cOU, this.cPa);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            } else if (this.cOY <= 0.5f) {
                int i = (int) (this.cOY * 77.0f);
                this.cPa.setAlpha(i);
                this.mCanvas.drawCircle(this.cPb.x, this.cPb.y, cOU, this.cPa);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "first level,alpha=" + i);
                }
            } else if (this.cOY < 1.0f) {
                int iY = iY((int) (this.cOY * 77.0f));
                this.cPa.setAlpha(iY);
                float f = (this.cOY - 0.5f) * 2.0f;
                int iY2 = iY((int) (26.0f * f));
                this.cOZ.setAlpha(iY2);
                this.mCanvas.drawCircle(this.cPb.x + (cOX * f), this.cPb.y, cOU, this.cPa);
                this.mCanvas.drawCircle(this.cPb.x - (cOX * f), this.cPb.y, cOU, this.cOZ);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "second level,mAnimPercent=" + this.cOY);
                    Log.e("NeutralRefreshAnimView", "second level,rightBallAlpha=" + iY);
                    Log.e("NeutralRefreshAnimView", "second level,leftBallAlpha=" + iY2);
                    Log.e("NeutralRefreshAnimView", "second level,fraction=" + f);
                    Log.e("NeutralRefreshAnimView", "second level,HALF_MAX_DISTANCE * fraction=" + (f * cOX));
                }
            } else if (this.cOY == 1.0f) {
                this.cOZ.setAlpha(26);
                this.cPa.setAlpha(77);
                this.mCanvas.drawCircle(this.cPb.x + cOX, this.cPb.y, cOU, this.cPa);
                this.mCanvas.drawCircle(this.cPb.x - cOX, this.cPb.y, cOU, this.cOZ);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "third level,mAnimPercent=" + this.cOY);
                }
            }
        }
    }

    public void azw() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshingAnim");
        }
        iX(2);
        azx();
    }

    private void azx() {
        azv();
        this.cPd = ValueAnimator.ofFloat(1.0f, -1.0f);
        this.cPd.setDuration(480L);
        this.cPd.setRepeatMode(2);
        this.cPd.setRepeatCount(-1);
        this.cPd.setInterpolator(new AccelerateDecelerateInterpolator());
        this.cPd.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.cPe = NeutralRefreshAnimView.cOX * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mRightBallXPosi=" + NeutralRefreshAnimView.this.cPe + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.cPc = ValueAnimator.ofFloat(-1.0f, 1.0f);
        this.cPc.setDuration(480L);
        this.cPc.setRepeatMode(2);
        this.cPc.setRepeatCount(-1);
        this.cPc.setInterpolator(new AccelerateDecelerateInterpolator());
        this.cPc.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.cPf = NeutralRefreshAnimView.cOX * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mLeftBallXPosi=" + NeutralRefreshAnimView.this.cPf + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.mAnimatorSet = new AnimatorSet();
        this.mAnimatorSet.playTogether(this.cPc, this.cPd);
        this.mAnimatorSet.setDuration(480L);
        this.mAnimatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                NeutralRefreshAnimView.this.iX(4);
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
            this.cPa.setAlpha(77);
            this.mCanvas.drawCircle(this.cPb.x + this.cPe, this.cPb.y, cOU, this.cPa);
            this.cOZ.setAlpha(26);
            this.mCanvas.drawCircle(this.cPb.x + this.cPf, this.cPb.y, cOU, this.cOZ);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "performOnRefreshingAnim");
            }
        }
    }

    public void azy() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshCompleteAnim");
        }
        stopAnim();
        iX(3);
        azz();
    }

    private void azz() {
        this.cPg = ValueAnimator.ofInt(26, 0);
        this.cPg.setDuration(300L);
        this.cPg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.cPi = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.cPi);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.cPg.isRunning()) {
            this.cPg.start();
        }
        this.cPh = ValueAnimator.ofInt(77, 0);
        this.cPh.setDuration(300L);
        this.cPh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.cPj = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.cPi);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.cPh.isRunning()) {
            this.cPh.start();
        }
    }

    private void s(Canvas canvas) {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "performRefreshCompleteAnim");
        }
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.cPi = iY(this.cPi);
            this.cPj = iY(this.cPj);
            this.cPa.setAlpha(this.cPj);
            this.cOZ.setAlpha(this.cPi);
            this.mCanvas.drawCircle(this.cPb.x + this.cPe, this.cPb.y, cOU, this.cPa);
            this.cOZ.setAlpha(this.cPi);
            this.mCanvas.drawCircle(this.cPb.x + this.cPf, this.cPb.y, cOU, this.cOZ);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "Complete:mAlpha=" + this.cPi);
                Log.e("NeutralRefreshAnimView", "Complete:mRightBallXPosi=" + this.cPe);
                Log.e("NeutralRefreshAnimView", "Complete:mLeftBallXPosi=" + this.cPf);
            }
        }
    }

    public void stopAnim() {
        azv();
        clearAnimation();
        iX(1);
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

    private void azv() {
        a(this.cPc, true);
        a(this.cPd, true);
        a(this.cPg, false);
        a(this.cPh, false);
        if (this.mAnimatorSet != null) {
            this.mAnimatorSet.removeAllListeners();
            this.mAnimatorSet.end();
            this.mAnimatorSet.cancel();
        }
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "resetAnimator");
        }
    }

    private int iY(int i) {
        int i2 = i < 0 ? 0 : i;
        if (i2 > 255) {
            return 255;
        }
        return i2;
    }
}
