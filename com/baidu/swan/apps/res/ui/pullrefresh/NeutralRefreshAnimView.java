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
    private static final int dAZ = ah.O(3.5f);
    private static final int dBa = Color.parseColor("#000000");
    private static final int dBb = ah.O(18.0f);
    private static final int dBc = dBb >> 1;
    private float dBd;
    private Paint dBe;
    private Paint dBf;
    private PointF dBg;
    private ValueAnimator dBh;
    private ValueAnimator dBi;
    private float dBj;
    private float dBk;
    private ValueAnimator dBl;
    private ValueAnimator dBm;
    private int dBn;
    private int dBo;
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
        this.dBg = new PointF();
        this.dBe = new Paint(1);
        this.dBf = new Paint(1);
        this.dBe.setColor(dBa);
        this.dBf.setColor(dBa);
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        float f3 = f2 <= 1.0f ? f2 : 1.0f;
        this.dBd = f3;
        ki(1);
        postInvalidate();
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "setAnimPercent, percent = " + f3);
        }
    }

    public boolean hJ(int i) {
        if (this.dBf == null || this.dBe == null) {
            return false;
        }
        this.dBe.setColor(i);
        this.dBf.setColor(i);
        return true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
        this.dBg.set(this.mWidth >> 1, this.mHeight >> 1);
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
    public void ki(int i) {
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
            if (this.dBd == 0.0f) {
                this.dBf.setAlpha(0);
                this.mCanvas.drawCircle(this.dBg.x, this.dBg.y, dAZ, this.dBf);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            } else if (this.dBd <= 0.5f) {
                int i = (int) (this.dBd * 77.0f);
                this.dBf.setAlpha(i);
                this.mCanvas.drawCircle(this.dBg.x, this.dBg.y, dAZ, this.dBf);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "first level,alpha=" + i);
                }
            } else if (this.dBd < 1.0f) {
                int kj = kj((int) (this.dBd * 77.0f));
                this.dBf.setAlpha(kj);
                float f = (this.dBd - 0.5f) * 2.0f;
                int kj2 = kj((int) (26.0f * f));
                this.dBe.setAlpha(kj2);
                this.mCanvas.drawCircle(this.dBg.x + (dBc * f), this.dBg.y, dAZ, this.dBf);
                this.mCanvas.drawCircle(this.dBg.x - (dBc * f), this.dBg.y, dAZ, this.dBe);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "second level,mAnimPercent=" + this.dBd);
                    Log.e("NeutralRefreshAnimView", "second level,rightBallAlpha=" + kj);
                    Log.e("NeutralRefreshAnimView", "second level,leftBallAlpha=" + kj2);
                    Log.e("NeutralRefreshAnimView", "second level,fraction=" + f);
                    Log.e("NeutralRefreshAnimView", "second level,HALF_MAX_DISTANCE * fraction=" + (f * dBc));
                }
            } else if (this.dBd == 1.0f) {
                this.dBe.setAlpha(26);
                this.dBf.setAlpha(77);
                this.mCanvas.drawCircle(this.dBg.x + dBc, this.dBg.y, dAZ, this.dBf);
                this.mCanvas.drawCircle(this.dBg.x - dBc, this.dBg.y, dAZ, this.dBe);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "third level,mAnimPercent=" + this.dBd);
                }
            }
        }
    }

    public void aKJ() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshingAnim");
        }
        ki(2);
        aKK();
    }

    private void aKK() {
        aKI();
        this.dBi = ValueAnimator.ofFloat(1.0f, -1.0f);
        this.dBi.setDuration(480L);
        this.dBi.setRepeatMode(2);
        this.dBi.setRepeatCount(-1);
        this.dBi.setInterpolator(new AccelerateDecelerateInterpolator());
        this.dBi.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.dBj = NeutralRefreshAnimView.dBc * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mRightBallXPosi=" + NeutralRefreshAnimView.this.dBj + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.dBh = ValueAnimator.ofFloat(-1.0f, 1.0f);
        this.dBh.setDuration(480L);
        this.dBh.setRepeatMode(2);
        this.dBh.setRepeatCount(-1);
        this.dBh.setInterpolator(new AccelerateDecelerateInterpolator());
        this.dBh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.dBk = NeutralRefreshAnimView.dBc * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mLeftBallXPosi=" + NeutralRefreshAnimView.this.dBk + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.mAnimatorSet = new AnimatorSet();
        this.mAnimatorSet.playTogether(this.dBh, this.dBi);
        this.mAnimatorSet.setDuration(480L);
        this.mAnimatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                NeutralRefreshAnimView.this.ki(4);
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
            this.dBf.setAlpha(77);
            this.mCanvas.drawCircle(this.dBg.x + this.dBj, this.dBg.y, dAZ, this.dBf);
            this.dBe.setAlpha(26);
            this.mCanvas.drawCircle(this.dBg.x + this.dBk, this.dBg.y, dAZ, this.dBe);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "performOnRefreshingAnim");
            }
        }
    }

    public void aKL() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshCompleteAnim");
        }
        stopAnim();
        ki(3);
        aKM();
    }

    private void aKM() {
        this.dBl = ValueAnimator.ofInt(26, 0);
        this.dBl.setDuration(300L);
        this.dBl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.dBn = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.dBn);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.dBl.isRunning()) {
            this.dBl.start();
        }
        this.dBm = ValueAnimator.ofInt(77, 0);
        this.dBm.setDuration(300L);
        this.dBm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.dBo = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.dBn);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.dBm.isRunning()) {
            this.dBm.start();
        }
    }

    private void z(Canvas canvas) {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "performRefreshCompleteAnim");
        }
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.dBn = kj(this.dBn);
            this.dBo = kj(this.dBo);
            this.dBf.setAlpha(this.dBo);
            this.dBe.setAlpha(this.dBn);
            this.mCanvas.drawCircle(this.dBg.x + this.dBj, this.dBg.y, dAZ, this.dBf);
            this.dBe.setAlpha(this.dBn);
            this.mCanvas.drawCircle(this.dBg.x + this.dBk, this.dBg.y, dAZ, this.dBe);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "Complete:mAlpha=" + this.dBn);
                Log.e("NeutralRefreshAnimView", "Complete:mRightBallXPosi=" + this.dBj);
                Log.e("NeutralRefreshAnimView", "Complete:mLeftBallXPosi=" + this.dBk);
            }
        }
    }

    public void stopAnim() {
        aKI();
        clearAnimation();
        ki(1);
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

    private void aKI() {
        a(this.dBh, true);
        a(this.dBi, true);
        a(this.dBl, false);
        a(this.dBm, false);
        if (this.mAnimatorSet != null) {
            this.mAnimatorSet.removeAllListeners();
            this.mAnimatorSet.end();
            this.mAnimatorSet.cancel();
        }
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "resetAnimator");
        }
    }

    private int kj(int i) {
        int i2 = i < 0 ? 0 : i;
        if (i2 > 255) {
            return 255;
        }
        return i2;
    }
}
