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
    private static final int cMU = ah.H(3.5f);
    private static final int cMV = Color.parseColor("#000000");
    private static final int cMW = ah.H(18.0f);
    private static final int cMX = cMW >> 1;
    private float cMY;
    private Paint cMZ;
    private Paint cNa;
    private PointF cNb;
    private ValueAnimator cNc;
    private ValueAnimator cNd;
    private float cNe;
    private float cNf;
    private ValueAnimator cNg;
    private ValueAnimator cNh;
    private int cNi;
    private int cNj;
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
        this.cNb = new PointF();
        this.cMZ = new Paint(1);
        this.cNa = new Paint(1);
        this.cMZ.setColor(cMV);
        this.cNa.setColor(cMV);
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        float f3 = f2 <= 1.0f ? f2 : 1.0f;
        this.cMY = f3;
        changeState(1);
        postInvalidate();
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "setAnimPercent, percent = " + f3);
        }
    }

    public boolean gu(int i) {
        if (this.cNa == null || this.cMZ == null) {
            return false;
        }
        this.cMZ.setColor(i);
        this.cNa.setColor(i);
        return true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
        this.cNb.set(this.mWidth >> 1, this.mHeight >> 1);
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
            if (this.cMY == 0.0f) {
                this.cNa.setAlpha(0);
                this.mCanvas.drawCircle(this.cNb.x, this.cNb.y, cMU, this.cNa);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            } else if (this.cMY <= 0.5f) {
                int i = (int) (this.cMY * 77.0f);
                this.cNa.setAlpha(i);
                this.mCanvas.drawCircle(this.cNb.x, this.cNb.y, cMU, this.cNa);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "first level,alpha=" + i);
                }
            } else if (this.cMY < 1.0f) {
                int iN = iN((int) (this.cMY * 77.0f));
                this.cNa.setAlpha(iN);
                float f = (this.cMY - 0.5f) * 2.0f;
                int iN2 = iN((int) (26.0f * f));
                this.cMZ.setAlpha(iN2);
                this.mCanvas.drawCircle(this.cNb.x + (cMX * f), this.cNb.y, cMU, this.cNa);
                this.mCanvas.drawCircle(this.cNb.x - (cMX * f), this.cNb.y, cMU, this.cMZ);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "second level,mAnimPercent=" + this.cMY);
                    Log.e("NeutralRefreshAnimView", "second level,rightBallAlpha=" + iN);
                    Log.e("NeutralRefreshAnimView", "second level,leftBallAlpha=" + iN2);
                    Log.e("NeutralRefreshAnimView", "second level,fraction=" + f);
                    Log.e("NeutralRefreshAnimView", "second level,HALF_MAX_DISTANCE * fraction=" + (f * cMX));
                }
            } else if (this.cMY == 1.0f) {
                this.cMZ.setAlpha(26);
                this.cNa.setAlpha(77);
                this.mCanvas.drawCircle(this.cNb.x + cMX, this.cNb.y, cMU, this.cNa);
                this.mCanvas.drawCircle(this.cNb.x - cMX, this.cNb.y, cMU, this.cMZ);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "third level,mAnimPercent=" + this.cMY);
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
        this.cNd = ValueAnimator.ofFloat(1.0f, -1.0f);
        this.cNd.setDuration(480L);
        this.cNd.setRepeatMode(2);
        this.cNd.setRepeatCount(-1);
        this.cNd.setInterpolator(new AccelerateDecelerateInterpolator());
        this.cNd.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.cNe = NeutralRefreshAnimView.cMX * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mRightBallXPosi=" + NeutralRefreshAnimView.this.cNe + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.cNc = ValueAnimator.ofFloat(-1.0f, 1.0f);
        this.cNc.setDuration(480L);
        this.cNc.setRepeatMode(2);
        this.cNc.setRepeatCount(-1);
        this.cNc.setInterpolator(new AccelerateDecelerateInterpolator());
        this.cNc.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.cNf = NeutralRefreshAnimView.cMX * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mLeftBallXPosi=" + NeutralRefreshAnimView.this.cNf + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.mAnimatorSet = new AnimatorSet();
        this.mAnimatorSet.playTogether(this.cNc, this.cNd);
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
            this.cNa.setAlpha(77);
            this.mCanvas.drawCircle(this.cNb.x + this.cNe, this.cNb.y, cMU, this.cNa);
            this.cMZ.setAlpha(26);
            this.mCanvas.drawCircle(this.cNb.x + this.cNf, this.cNb.y, cMU, this.cMZ);
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
        this.cNg = ValueAnimator.ofInt(26, 0);
        this.cNg.setDuration(300L);
        this.cNg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.cNi = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.cNi);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.cNg.isRunning()) {
            this.cNg.start();
        }
        this.cNh = ValueAnimator.ofInt(77, 0);
        this.cNh.setDuration(300L);
        this.cNh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.cNj = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.cNi);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.cNh.isRunning()) {
            this.cNh.start();
        }
    }

    private void s(Canvas canvas) {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "performRefreshCompleteAnim");
        }
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.cNi = iN(this.cNi);
            this.cNj = iN(this.cNj);
            this.cNa.setAlpha(this.cNj);
            this.cMZ.setAlpha(this.cNi);
            this.mCanvas.drawCircle(this.cNb.x + this.cNe, this.cNb.y, cMU, this.cNa);
            this.cMZ.setAlpha(this.cNi);
            this.mCanvas.drawCircle(this.cNb.x + this.cNf, this.cNb.y, cMU, this.cMZ);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "Complete:mAlpha=" + this.cNi);
                Log.e("NeutralRefreshAnimView", "Complete:mRightBallXPosi=" + this.cNe);
                Log.e("NeutralRefreshAnimView", "Complete:mLeftBallXPosi=" + this.cNf);
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
        a(this.cNc, true);
        a(this.cNd, true);
        a(this.cNg, false);
        a(this.cNh, false);
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
