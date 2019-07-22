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
    private static final int aKU = z.ad(3.5f);
    private static final int aKV = Color.parseColor("#000000");
    private static final int aKW = z.ad(18.0f);
    private static final int aKX = aKW >> 1;
    private Canvas aKL;
    private float aKY;
    private Paint aKZ;
    private Paint aLa;
    private PointF aLb;
    private ValueAnimator aLc;
    private ValueAnimator aLd;
    private float aLe;
    private float aLf;
    private ValueAnimator aLg;
    private ValueAnimator aLh;
    private int aLi;
    private int aLj;
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
        this.aLb = new PointF();
        this.aKZ = new Paint(1);
        this.aLa = new Paint(1);
        this.aKZ.setColor(aKV);
        this.aLa.setColor(aKV);
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        float f3 = f2 <= 1.0f ? f2 : 1.0f;
        this.aKY = f3;
        da(1);
        postInvalidate();
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "setAnimPercent, percent = " + f3);
        }
    }

    public boolean bN(int i) {
        if (this.aLa == null || this.aKZ == null) {
            return false;
        }
        this.aKZ.setColor(i);
        this.aLa.setColor(i);
        return true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
        this.aLb.set(this.mWidth >> 1, this.mHeight >> 1);
    }

    @Override // android.view.View
    protected void onSizeChanged(final int i, final int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            j.b(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.1
                @Override // java.lang.Runnable
                public void run() {
                    NeutralRefreshAnimView.this.mBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                    NeutralRefreshAnimView.this.aKL = new Canvas(NeutralRefreshAnimView.this.mBitmap);
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
    public void da(int i) {
        this.mState = i;
        if (DEBUG) {
            Log.i("NeutralRefreshAnimView", "curr state:" + this.mState);
        }
    }

    private void m(Canvas canvas) {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "performPullToRefreshAnim");
        }
        if (this.mBitmap != null && this.aKL != null) {
            this.mBitmap.eraseColor(0);
            if (this.aKY == 0.0f) {
                this.aLa.setAlpha(0);
                this.aKL.drawCircle(this.aLb.x, this.aLb.y, aKU, this.aLa);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            } else if (this.aKY <= 0.5f) {
                int i = (int) (this.aKY * 77.0f);
                this.aLa.setAlpha(i);
                this.aKL.drawCircle(this.aLb.x, this.aLb.y, aKU, this.aLa);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "first level,alpha=" + i);
                }
            } else if (this.aKY < 1.0f) {
                int db = db((int) (this.aKY * 77.0f));
                this.aLa.setAlpha(db);
                float f = (this.aKY - 0.5f) * 2.0f;
                int db2 = db((int) (26.0f * f));
                this.aKZ.setAlpha(db2);
                this.aKL.drawCircle(this.aLb.x + (aKX * f), this.aLb.y, aKU, this.aLa);
                this.aKL.drawCircle(this.aLb.x - (aKX * f), this.aLb.y, aKU, this.aKZ);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "second level,mAnimPercent=" + this.aKY);
                    Log.e("NeutralRefreshAnimView", "second level,rightBallAlpha=" + db);
                    Log.e("NeutralRefreshAnimView", "second level,leftBallAlpha=" + db2);
                    Log.e("NeutralRefreshAnimView", "second level,fraction=" + f);
                    Log.e("NeutralRefreshAnimView", "second level,HALF_MAX_DISTANCE * fraction=" + (f * aKX));
                }
            } else if (this.aKY == 1.0f) {
                this.aKZ.setAlpha(26);
                this.aLa.setAlpha(77);
                this.aKL.drawCircle(this.aLb.x + aKX, this.aLb.y, aKU, this.aLa);
                this.aKL.drawCircle(this.aLb.x - aKX, this.aLb.y, aKU, this.aKZ);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "third level,mAnimPercent=" + this.aKY);
                }
            }
        }
    }

    public void Kr() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshingAnim");
        }
        da(2);
        Ks();
    }

    private void Ks() {
        Kq();
        this.aLd = ValueAnimator.ofFloat(1.0f, -1.0f);
        this.aLd.setDuration(480L);
        this.aLd.setRepeatMode(2);
        this.aLd.setRepeatCount(-1);
        this.aLd.setInterpolator(new AccelerateDecelerateInterpolator());
        this.aLd.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.aLe = NeutralRefreshAnimView.aKX * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mRightBallXPosi=" + NeutralRefreshAnimView.this.aLe + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.aLc = ValueAnimator.ofFloat(-1.0f, 1.0f);
        this.aLc.setDuration(480L);
        this.aLc.setRepeatMode(2);
        this.aLc.setRepeatCount(-1);
        this.aLc.setInterpolator(new AccelerateDecelerateInterpolator());
        this.aLc.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.aLf = NeutralRefreshAnimView.aKX * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mLeftBallXPosi=" + NeutralRefreshAnimView.this.aLf + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.mAnimatorSet = new AnimatorSet();
        this.mAnimatorSet.playTogether(this.aLc, this.aLd);
        this.mAnimatorSet.setDuration(480L);
        this.mAnimatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                NeutralRefreshAnimView.this.da(4);
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
        if (this.mBitmap != null && this.aKL != null) {
            this.mBitmap.eraseColor(0);
            this.aLa.setAlpha(77);
            this.aKL.drawCircle(this.aLb.x + this.aLe, this.aLb.y, aKU, this.aLa);
            this.aKZ.setAlpha(26);
            this.aKL.drawCircle(this.aLb.x + this.aLf, this.aLb.y, aKU, this.aKZ);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "performOnRefreshingAnim");
            }
        }
    }

    public void Kt() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshCompleteAnim");
        }
        stopAnim();
        da(3);
        Ku();
    }

    private void Ku() {
        this.aLg = ValueAnimator.ofInt(26, 0);
        this.aLg.setDuration(300L);
        this.aLg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.aLi = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.aLi);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.aLg.isRunning()) {
            this.aLg.start();
        }
        this.aLh = ValueAnimator.ofInt(77, 0);
        this.aLh.setDuration(300L);
        this.aLh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.aLj = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.aLi);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.aLh.isRunning()) {
            this.aLh.start();
        }
    }

    private void o(Canvas canvas) {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "performRefreshCompleteAnim");
        }
        if (this.mBitmap != null && this.aKL != null) {
            this.mBitmap.eraseColor(0);
            this.aLi = db(this.aLi);
            this.aLj = db(this.aLj);
            this.aLa.setAlpha(this.aLj);
            this.aKZ.setAlpha(this.aLi);
            this.aKL.drawCircle(this.aLb.x + this.aLe, this.aLb.y, aKU, this.aLa);
            this.aKZ.setAlpha(this.aLi);
            this.aKL.drawCircle(this.aLb.x + this.aLf, this.aLb.y, aKU, this.aKZ);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "Complete:mAlpha=" + this.aLi);
                Log.e("NeutralRefreshAnimView", "Complete:mRightBallXPosi=" + this.aLe);
                Log.e("NeutralRefreshAnimView", "Complete:mLeftBallXPosi=" + this.aLf);
            }
        }
    }

    public void stopAnim() {
        Kq();
        clearAnimation();
        da(1);
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

    private void Kq() {
        a(this.aLc, true);
        a(this.aLd, true);
        a(this.aLg, false);
        a(this.aLh, false);
        if (this.mAnimatorSet != null) {
            this.mAnimatorSet.removeAllListeners();
            this.mAnimatorSet.end();
            this.mAnimatorSet.cancel();
        }
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "resetAnimator");
        }
    }

    private int db(int i) {
        int i2 = i < 0 ? 0 : i;
        if (i2 > 255) {
            return 255;
        }
        return i2;
    }
}
