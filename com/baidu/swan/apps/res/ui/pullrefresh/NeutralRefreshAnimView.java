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
/* loaded from: classes8.dex */
public class NeutralRefreshAnimView extends View {
    private static final boolean DEBUG = b.DEBUG;
    private static final int dzV = ah.T(3.5f);
    private static final int dzW = Color.parseColor("#000000");
    private static final int dzX = ah.T(18.0f);
    private static final int dzY = dzX >> 1;
    private Paint dAa;
    private Paint dAb;
    private PointF dAc;
    private ValueAnimator dAd;
    private ValueAnimator dAe;
    private float dAf;
    private float dAg;
    private ValueAnimator dAh;
    private ValueAnimator dAi;
    private int dAj;
    private int dAk;
    private float dzZ;
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
        this.dAc = new PointF();
        this.dAa = new Paint(1);
        this.dAb = new Paint(1);
        this.dAa.setColor(dzW);
        this.dAb.setColor(dzW);
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        float f3 = f2 <= 1.0f ? f2 : 1.0f;
        this.dzZ = f3;
        iG(1);
        postInvalidate();
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "setAnimPercent, percent = " + f3);
        }
    }

    public boolean gg(int i) {
        if (this.dAb == null || this.dAa == null) {
            return false;
        }
        this.dAa.setColor(i);
        this.dAb.setColor(i);
        return true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
        this.dAc.set(this.mWidth >> 1, this.mHeight >> 1);
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
    public void iG(int i) {
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
            if (this.dzZ == 0.0f) {
                this.dAb.setAlpha(0);
                this.mCanvas.drawCircle(this.dAc.x, this.dAc.y, dzV, this.dAb);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            } else if (this.dzZ <= 0.5f) {
                int i = (int) (this.dzZ * 77.0f);
                this.dAb.setAlpha(i);
                this.mCanvas.drawCircle(this.dAc.x, this.dAc.y, dzV, this.dAb);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "first level,alpha=" + i);
                }
            } else if (this.dzZ < 1.0f) {
                int iH = iH((int) (this.dzZ * 77.0f));
                this.dAb.setAlpha(iH);
                float f = (this.dzZ - 0.5f) * 2.0f;
                int iH2 = iH((int) (26.0f * f));
                this.dAa.setAlpha(iH2);
                this.mCanvas.drawCircle(this.dAc.x + (dzY * f), this.dAc.y, dzV, this.dAb);
                this.mCanvas.drawCircle(this.dAc.x - (dzY * f), this.dAc.y, dzV, this.dAa);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "second level,mAnimPercent=" + this.dzZ);
                    Log.e("NeutralRefreshAnimView", "second level,rightBallAlpha=" + iH);
                    Log.e("NeutralRefreshAnimView", "second level,leftBallAlpha=" + iH2);
                    Log.e("NeutralRefreshAnimView", "second level,fraction=" + f);
                    Log.e("NeutralRefreshAnimView", "second level,HALF_MAX_DISTANCE * fraction=" + (f * dzY));
                }
            } else if (this.dzZ == 1.0f) {
                this.dAa.setAlpha(26);
                this.dAb.setAlpha(77);
                this.mCanvas.drawCircle(this.dAc.x + dzY, this.dAc.y, dzV, this.dAb);
                this.mCanvas.drawCircle(this.dAc.x - dzY, this.dAc.y, dzV, this.dAa);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "third level,mAnimPercent=" + this.dzZ);
                }
            }
        }
    }

    public void aHm() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshingAnim");
        }
        iG(2);
        aHn();
    }

    private void aHn() {
        aHl();
        this.dAe = ValueAnimator.ofFloat(1.0f, -1.0f);
        this.dAe.setDuration(480L);
        this.dAe.setRepeatMode(2);
        this.dAe.setRepeatCount(-1);
        this.dAe.setInterpolator(new AccelerateDecelerateInterpolator());
        this.dAe.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.dAf = NeutralRefreshAnimView.dzY * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mRightBallXPosi=" + NeutralRefreshAnimView.this.dAf + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.dAd = ValueAnimator.ofFloat(-1.0f, 1.0f);
        this.dAd.setDuration(480L);
        this.dAd.setRepeatMode(2);
        this.dAd.setRepeatCount(-1);
        this.dAd.setInterpolator(new AccelerateDecelerateInterpolator());
        this.dAd.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.dAg = NeutralRefreshAnimView.dzY * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mLeftBallXPosi=" + NeutralRefreshAnimView.this.dAg + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.mAnimatorSet = new AnimatorSet();
        this.mAnimatorSet.playTogether(this.dAd, this.dAe);
        this.mAnimatorSet.setDuration(480L);
        this.mAnimatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                NeutralRefreshAnimView.this.iG(4);
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
            this.dAb.setAlpha(77);
            this.mCanvas.drawCircle(this.dAc.x + this.dAf, this.dAc.y, dzV, this.dAb);
            this.dAa.setAlpha(26);
            this.mCanvas.drawCircle(this.dAc.x + this.dAg, this.dAc.y, dzV, this.dAa);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "performOnRefreshingAnim");
            }
        }
    }

    public void aHo() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshCompleteAnim");
        }
        stopAnim();
        iG(3);
        aHp();
    }

    private void aHp() {
        this.dAh = ValueAnimator.ofInt(26, 0);
        this.dAh.setDuration(300L);
        this.dAh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.dAj = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.dAj);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.dAh.isRunning()) {
            this.dAh.start();
        }
        this.dAi = ValueAnimator.ofInt(77, 0);
        this.dAi.setDuration(300L);
        this.dAi.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.dAk = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.dAj);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.dAi.isRunning()) {
            this.dAi.start();
        }
    }

    private void z(Canvas canvas) {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "performRefreshCompleteAnim");
        }
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.dAj = iH(this.dAj);
            this.dAk = iH(this.dAk);
            this.dAb.setAlpha(this.dAk);
            this.dAa.setAlpha(this.dAj);
            this.mCanvas.drawCircle(this.dAc.x + this.dAf, this.dAc.y, dzV, this.dAb);
            this.dAa.setAlpha(this.dAj);
            this.mCanvas.drawCircle(this.dAc.x + this.dAg, this.dAc.y, dzV, this.dAa);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "Complete:mAlpha=" + this.dAj);
                Log.e("NeutralRefreshAnimView", "Complete:mRightBallXPosi=" + this.dAf);
                Log.e("NeutralRefreshAnimView", "Complete:mLeftBallXPosi=" + this.dAg);
            }
        }
    }

    public void stopAnim() {
        aHl();
        clearAnimation();
        iG(1);
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

    private void aHl() {
        a(this.dAd, true);
        a(this.dAe, true);
        a(this.dAh, false);
        a(this.dAi, false);
        if (this.mAnimatorSet != null) {
            this.mAnimatorSet.removeAllListeners();
            this.mAnimatorSet.end();
            this.mAnimatorSet.cancel();
        }
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "resetAnimator");
        }
    }

    private int iH(int i) {
        int i2 = i < 0 ? 0 : i;
        if (i2 > 255) {
            return 255;
        }
        return i2;
    }
}
