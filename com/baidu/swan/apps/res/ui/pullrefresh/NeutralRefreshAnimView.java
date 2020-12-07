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
/* loaded from: classes25.dex */
public class NeutralRefreshAnimView extends View {
    private static final boolean DEBUG = b.DEBUG;
    private static final int duQ = ah.M(3.5f);
    private static final int duR = Color.parseColor("#000000");
    private static final int duS = ah.M(18.0f);
    private static final int duT = duS >> 1;
    private float duU;
    private Paint duV;
    private Paint duW;
    private PointF duX;
    private ValueAnimator duY;
    private ValueAnimator duZ;
    private float dva;
    private float dvb;
    private ValueAnimator dvc;
    private ValueAnimator dvd;
    private int dve;
    private int dvf;
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
        this.duX = new PointF();
        this.duV = new Paint(1);
        this.duW = new Paint(1);
        this.duV.setColor(duR);
        this.duW.setColor(duR);
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        float f3 = f2 <= 1.0f ? f2 : 1.0f;
        this.duU = f3;
        kj(1);
        postInvalidate();
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "setAnimPercent, percent = " + f3);
        }
    }

    public boolean hP(int i) {
        if (this.duW == null || this.duV == null) {
            return false;
        }
        this.duV.setColor(i);
        this.duW.setColor(i);
        return true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
        this.duX.set(this.mWidth >> 1, this.mHeight >> 1);
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
    public void kj(int i) {
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
            if (this.duU == 0.0f) {
                this.duW.setAlpha(0);
                this.mCanvas.drawCircle(this.duX.x, this.duX.y, duQ, this.duW);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            } else if (this.duU <= 0.5f) {
                int i = (int) (this.duU * 77.0f);
                this.duW.setAlpha(i);
                this.mCanvas.drawCircle(this.duX.x, this.duX.y, duQ, this.duW);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "first level,alpha=" + i);
                }
            } else if (this.duU < 1.0f) {
                int kk = kk((int) (this.duU * 77.0f));
                this.duW.setAlpha(kk);
                float f = (this.duU - 0.5f) * 2.0f;
                int kk2 = kk((int) (26.0f * f));
                this.duV.setAlpha(kk2);
                this.mCanvas.drawCircle(this.duX.x + (duT * f), this.duX.y, duQ, this.duW);
                this.mCanvas.drawCircle(this.duX.x - (duT * f), this.duX.y, duQ, this.duV);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "second level,mAnimPercent=" + this.duU);
                    Log.e("NeutralRefreshAnimView", "second level,rightBallAlpha=" + kk);
                    Log.e("NeutralRefreshAnimView", "second level,leftBallAlpha=" + kk2);
                    Log.e("NeutralRefreshAnimView", "second level,fraction=" + f);
                    Log.e("NeutralRefreshAnimView", "second level,HALF_MAX_DISTANCE * fraction=" + (f * duT));
                }
            } else if (this.duU == 1.0f) {
                this.duV.setAlpha(26);
                this.duW.setAlpha(77);
                this.mCanvas.drawCircle(this.duX.x + duT, this.duX.y, duQ, this.duW);
                this.mCanvas.drawCircle(this.duX.x - duT, this.duX.y, duQ, this.duV);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "third level,mAnimPercent=" + this.duU);
                }
            }
        }
    }

    public void aIZ() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshingAnim");
        }
        kj(2);
        aJa();
    }

    private void aJa() {
        aIY();
        this.duZ = ValueAnimator.ofFloat(1.0f, -1.0f);
        this.duZ.setDuration(480L);
        this.duZ.setRepeatMode(2);
        this.duZ.setRepeatCount(-1);
        this.duZ.setInterpolator(new AccelerateDecelerateInterpolator());
        this.duZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.dva = NeutralRefreshAnimView.duT * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mRightBallXPosi=" + NeutralRefreshAnimView.this.dva + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.duY = ValueAnimator.ofFloat(-1.0f, 1.0f);
        this.duY.setDuration(480L);
        this.duY.setRepeatMode(2);
        this.duY.setRepeatCount(-1);
        this.duY.setInterpolator(new AccelerateDecelerateInterpolator());
        this.duY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.dvb = NeutralRefreshAnimView.duT * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mLeftBallXPosi=" + NeutralRefreshAnimView.this.dvb + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.mAnimatorSet = new AnimatorSet();
        this.mAnimatorSet.playTogether(this.duY, this.duZ);
        this.mAnimatorSet.setDuration(480L);
        this.mAnimatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                NeutralRefreshAnimView.this.kj(4);
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
            this.duW.setAlpha(77);
            this.mCanvas.drawCircle(this.duX.x + this.dva, this.duX.y, duQ, this.duW);
            this.duV.setAlpha(26);
            this.mCanvas.drawCircle(this.duX.x + this.dvb, this.duX.y, duQ, this.duV);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "performOnRefreshingAnim");
            }
        }
    }

    public void aJb() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshCompleteAnim");
        }
        stopAnim();
        kj(3);
        aJc();
    }

    private void aJc() {
        this.dvc = ValueAnimator.ofInt(26, 0);
        this.dvc.setDuration(300L);
        this.dvc.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.dve = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.dve);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.dvc.isRunning()) {
            this.dvc.start();
        }
        this.dvd = ValueAnimator.ofInt(77, 0);
        this.dvd.setDuration(300L);
        this.dvd.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.dvf = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.dve);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.dvd.isRunning()) {
            this.dvd.start();
        }
    }

    private void s(Canvas canvas) {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "performRefreshCompleteAnim");
        }
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.dve = kk(this.dve);
            this.dvf = kk(this.dvf);
            this.duW.setAlpha(this.dvf);
            this.duV.setAlpha(this.dve);
            this.mCanvas.drawCircle(this.duX.x + this.dva, this.duX.y, duQ, this.duW);
            this.duV.setAlpha(this.dve);
            this.mCanvas.drawCircle(this.duX.x + this.dvb, this.duX.y, duQ, this.duV);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "Complete:mAlpha=" + this.dve);
                Log.e("NeutralRefreshAnimView", "Complete:mRightBallXPosi=" + this.dva);
                Log.e("NeutralRefreshAnimView", "Complete:mLeftBallXPosi=" + this.dvb);
            }
        }
    }

    public void stopAnim() {
        aIY();
        clearAnimation();
        kj(1);
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

    private void aIY() {
        a(this.duY, true);
        a(this.duZ, true);
        a(this.dvc, false);
        a(this.dvd, false);
        if (this.mAnimatorSet != null) {
            this.mAnimatorSet.removeAllListeners();
            this.mAnimatorSet.end();
            this.mAnimatorSet.cancel();
        }
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "resetAnimator");
        }
    }

    private int kk(int i) {
        int i2 = i < 0 ? 0 : i;
        if (i2 > 255) {
            return 255;
        }
        return i2;
    }
}
