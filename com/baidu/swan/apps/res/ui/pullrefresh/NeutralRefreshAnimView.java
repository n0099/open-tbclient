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
import com.baidu.swan.apps.an.j;
import com.baidu.swan.apps.an.z;
import com.baidu.swan.apps.b;
/* loaded from: classes2.dex */
public class NeutralRefreshAnimView extends View {
    private static final boolean DEBUG = b.DEBUG;
    private static final int aKm = z.ad(3.5f);
    private static final int aKn = Color.parseColor("#000000");
    private static final int aKo = z.ad(18.0f);
    private static final int aKp = aKo >> 1;
    private int aKA;
    private int aKB;
    private Canvas aKd;
    private float aKq;
    private Paint aKr;
    private Paint aKs;
    private PointF aKt;
    private ValueAnimator aKu;
    private ValueAnimator aKv;
    private float aKw;
    private float aKx;
    private ValueAnimator aKy;
    private ValueAnimator aKz;
    private AnimatorSet mAnimatorSet;
    private Bitmap mBitmap;
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
        this.aKt = new PointF();
        this.aKr = new Paint(1);
        this.aKs = new Paint(1);
        this.aKr.setColor(aKn);
        this.aKs.setColor(aKn);
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        float f3 = f2 <= 1.0f ? f2 : 1.0f;
        this.aKq = f3;
        cX(1);
        postInvalidate();
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "setAnimPercent, percent = " + f3);
        }
    }

    public boolean bN(int i) {
        if (this.aKs == null || this.aKr == null) {
            return false;
        }
        this.aKr.setColor(i);
        this.aKs.setColor(i);
        return true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
        this.aKt.set(this.mWidth >> 1, this.mHeight >> 1);
    }

    @Override // android.view.View
    protected void onSizeChanged(final int i, final int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            j.b(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.1
                @Override // java.lang.Runnable
                public void run() {
                    NeutralRefreshAnimView.this.mBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                    NeutralRefreshAnimView.this.aKd = new Canvas(NeutralRefreshAnimView.this.mBitmap);
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
                m(canvas);
                break;
            case 2:
                n(canvas);
                break;
            case 3:
                o(canvas);
                break;
            case 4:
                n(canvas);
                break;
        }
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cX(int i) {
        this.mState = i;
        if (DEBUG) {
            Log.i("NeutralRefreshAnimView", "curr state:" + this.mState);
        }
    }

    private void m(Canvas canvas) {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "performPullToRefreshAnim");
        }
        if (this.mBitmap != null && this.aKd != null) {
            this.mBitmap.eraseColor(0);
            if (this.aKq == 0.0f) {
                this.aKs.setAlpha(0);
                this.aKd.drawCircle(this.aKt.x, this.aKt.y, aKm, this.aKs);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            } else if (this.aKq <= 0.5f) {
                int i = (int) (this.aKq * 77.0f);
                this.aKs.setAlpha(i);
                this.aKd.drawCircle(this.aKt.x, this.aKt.y, aKm, this.aKs);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "first level,alpha=" + i);
                }
            } else if (this.aKq < 1.0f) {
                int cY = cY((int) (this.aKq * 77.0f));
                this.aKs.setAlpha(cY);
                float f = (this.aKq - 0.5f) * 2.0f;
                int cY2 = cY((int) (26.0f * f));
                this.aKr.setAlpha(cY2);
                this.aKd.drawCircle(this.aKt.x + (aKp * f), this.aKt.y, aKm, this.aKs);
                this.aKd.drawCircle(this.aKt.x - (aKp * f), this.aKt.y, aKm, this.aKr);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "second level,mAnimPercent=" + this.aKq);
                    Log.e("NeutralRefreshAnimView", "second level,rightBallAlpha=" + cY);
                    Log.e("NeutralRefreshAnimView", "second level,leftBallAlpha=" + cY2);
                    Log.e("NeutralRefreshAnimView", "second level,fraction=" + f);
                    Log.e("NeutralRefreshAnimView", "second level,HALF_MAX_DISTANCE * fraction=" + (f * aKp));
                }
            } else if (this.aKq == 1.0f) {
                this.aKr.setAlpha(26);
                this.aKs.setAlpha(77);
                this.aKd.drawCircle(this.aKt.x + aKp, this.aKt.y, aKm, this.aKs);
                this.aKd.drawCircle(this.aKt.x - aKp, this.aKt.y, aKm, this.aKr);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "third level,mAnimPercent=" + this.aKq);
                }
            }
        }
    }

    public void JE() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshingAnim");
        }
        cX(2);
        JF();
    }

    private void JF() {
        JD();
        this.aKv = ValueAnimator.ofFloat(1.0f, -1.0f);
        this.aKv.setDuration(480L);
        this.aKv.setRepeatMode(2);
        this.aKv.setRepeatCount(-1);
        this.aKv.setInterpolator(new AccelerateDecelerateInterpolator());
        this.aKv.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.aKw = NeutralRefreshAnimView.aKp * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mRightBallXPosi=" + NeutralRefreshAnimView.this.aKw + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.aKu = ValueAnimator.ofFloat(-1.0f, 1.0f);
        this.aKu.setDuration(480L);
        this.aKu.setRepeatMode(2);
        this.aKu.setRepeatCount(-1);
        this.aKu.setInterpolator(new AccelerateDecelerateInterpolator());
        this.aKu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.aKx = NeutralRefreshAnimView.aKp * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mLeftBallXPosi=" + NeutralRefreshAnimView.this.aKx + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.mAnimatorSet = new AnimatorSet();
        this.mAnimatorSet.playTogether(this.aKu, this.aKv);
        this.mAnimatorSet.setDuration(480L);
        this.mAnimatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                NeutralRefreshAnimView.this.cX(4);
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

    private void n(Canvas canvas) {
        if (this.mBitmap != null && this.aKd != null) {
            this.mBitmap.eraseColor(0);
            this.aKs.setAlpha(77);
            this.aKd.drawCircle(this.aKt.x + this.aKw, this.aKt.y, aKm, this.aKs);
            this.aKr.setAlpha(26);
            this.aKd.drawCircle(this.aKt.x + this.aKx, this.aKt.y, aKm, this.aKr);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "performOnRefreshingAnim");
            }
        }
    }

    public void JG() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshCompleteAnim");
        }
        stopAnim();
        cX(3);
        JH();
    }

    private void JH() {
        this.aKy = ValueAnimator.ofInt(26, 0);
        this.aKy.setDuration(300L);
        this.aKy.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.aKA = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.aKA);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.aKy.isRunning()) {
            this.aKy.start();
        }
        this.aKz = ValueAnimator.ofInt(77, 0);
        this.aKz.setDuration(300L);
        this.aKz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.aKB = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.aKA);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.aKz.isRunning()) {
            this.aKz.start();
        }
    }

    private void o(Canvas canvas) {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "performRefreshCompleteAnim");
        }
        if (this.mBitmap != null && this.aKd != null) {
            this.mBitmap.eraseColor(0);
            this.aKA = cY(this.aKA);
            this.aKB = cY(this.aKB);
            this.aKs.setAlpha(this.aKB);
            this.aKr.setAlpha(this.aKA);
            this.aKd.drawCircle(this.aKt.x + this.aKw, this.aKt.y, aKm, this.aKs);
            this.aKr.setAlpha(this.aKA);
            this.aKd.drawCircle(this.aKt.x + this.aKx, this.aKt.y, aKm, this.aKr);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "Complete:mAlpha=" + this.aKA);
                Log.e("NeutralRefreshAnimView", "Complete:mRightBallXPosi=" + this.aKw);
                Log.e("NeutralRefreshAnimView", "Complete:mLeftBallXPosi=" + this.aKx);
            }
        }
    }

    public void stopAnim() {
        JD();
        clearAnimation();
        cX(1);
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

    private void JD() {
        a(this.aKu, true);
        a(this.aKv, true);
        a(this.aKy, false);
        a(this.aKz, false);
        if (this.mAnimatorSet != null) {
            this.mAnimatorSet.removeAllListeners();
            this.mAnimatorSet.end();
            this.mAnimatorSet.cancel();
        }
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "resetAnimator");
        }
    }

    private int cY(int i) {
        int i2 = i < 0 ? 0 : i;
        if (i2 > 255) {
            return 255;
        }
        return i2;
    }
}
