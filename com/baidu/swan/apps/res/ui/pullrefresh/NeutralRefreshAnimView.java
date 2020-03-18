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
    private static final int bMb = af.S(3.5f);
    private static final int bMc = Color.parseColor(BaseBrowseView.ROOT_VIEW_COLOR);
    private static final int bMd = af.S(18.0f);
    private static final int bMe = bMd >> 1;
    private float bMf;
    private Paint bMg;
    private Paint bMh;
    private PointF bMi;
    private ValueAnimator bMj;
    private ValueAnimator bMk;
    private float bMl;
    private float bMm;
    private ValueAnimator bMn;
    private ValueAnimator bMo;
    private int bMp;
    private int bMq;
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
        this.bMi = new PointF();
        this.bMg = new Paint(1);
        this.bMh = new Paint(1);
        this.bMg.setColor(bMc);
        this.bMh.setColor(bMc);
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        float f3 = f2 <= 1.0f ? f2 : 1.0f;
        this.bMf = f3;
        changeState(1);
        postInvalidate();
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "setAnimPercent, percent = " + f3);
        }
    }

    public boolean dW(int i) {
        if (this.bMh == null || this.bMg == null) {
            return false;
        }
        this.bMg.setColor(i);
        this.bMh.setColor(i);
        return true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
        this.bMi.set(this.mWidth >> 1, this.mHeight >> 1);
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
            if (this.bMf == 0.0f) {
                this.bMh.setAlpha(0);
                this.mCanvas.drawCircle(this.bMi.x, this.bMi.y, bMb, this.bMh);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            } else if (this.bMf <= 0.5f) {
                int i = (int) (this.bMf * 77.0f);
                this.bMh.setAlpha(i);
                this.mCanvas.drawCircle(this.bMi.x, this.bMi.y, bMb, this.bMh);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "first level,alpha=" + i);
                }
            } else if (this.bMf < 1.0f) {
                int fL = fL((int) (this.bMf * 77.0f));
                this.bMh.setAlpha(fL);
                float f = (this.bMf - 0.5f) * 2.0f;
                int fL2 = fL((int) (26.0f * f));
                this.bMg.setAlpha(fL2);
                this.mCanvas.drawCircle(this.bMi.x + (bMe * f), this.bMi.y, bMb, this.bMh);
                this.mCanvas.drawCircle(this.bMi.x - (bMe * f), this.bMi.y, bMb, this.bMg);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "second level,mAnimPercent=" + this.bMf);
                    Log.e("NeutralRefreshAnimView", "second level,rightBallAlpha=" + fL);
                    Log.e("NeutralRefreshAnimView", "second level,leftBallAlpha=" + fL2);
                    Log.e("NeutralRefreshAnimView", "second level,fraction=" + f);
                    Log.e("NeutralRefreshAnimView", "second level,HALF_MAX_DISTANCE * fraction=" + (f * bMe));
                }
            } else if (this.bMf == 1.0f) {
                this.bMg.setAlpha(26);
                this.bMh.setAlpha(77);
                this.mCanvas.drawCircle(this.bMi.x + bMe, this.bMi.y, bMb, this.bMh);
                this.mCanvas.drawCircle(this.bMi.x - bMe, this.bMi.y, bMb, this.bMg);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "third level,mAnimPercent=" + this.bMf);
                }
            }
        }
    }

    public void abT() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshingAnim");
        }
        changeState(2);
        abU();
    }

    private void abU() {
        abS();
        this.bMk = ValueAnimator.ofFloat(1.0f, -1.0f);
        this.bMk.setDuration(480L);
        this.bMk.setRepeatMode(2);
        this.bMk.setRepeatCount(-1);
        this.bMk.setInterpolator(new AccelerateDecelerateInterpolator());
        this.bMk.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.bMl = NeutralRefreshAnimView.bMe * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mRightBallXPosi=" + NeutralRefreshAnimView.this.bMl + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.bMj = ValueAnimator.ofFloat(-1.0f, 1.0f);
        this.bMj.setDuration(480L);
        this.bMj.setRepeatMode(2);
        this.bMj.setRepeatCount(-1);
        this.bMj.setInterpolator(new AccelerateDecelerateInterpolator());
        this.bMj.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.bMm = NeutralRefreshAnimView.bMe * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mLeftBallXPosi=" + NeutralRefreshAnimView.this.bMm + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.mAnimatorSet = new AnimatorSet();
        this.mAnimatorSet.playTogether(this.bMj, this.bMk);
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
            this.bMh.setAlpha(77);
            this.mCanvas.drawCircle(this.bMi.x + this.bMl, this.bMi.y, bMb, this.bMh);
            this.bMg.setAlpha(26);
            this.mCanvas.drawCircle(this.bMi.x + this.bMm, this.bMi.y, bMb, this.bMg);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "performOnRefreshingAnim");
            }
        }
    }

    public void abV() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshCompleteAnim");
        }
        stopAnim();
        changeState(3);
        abW();
    }

    private void abW() {
        this.bMn = ValueAnimator.ofInt(26, 0);
        this.bMn.setDuration(300L);
        this.bMn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.bMp = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.bMp);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.bMn.isRunning()) {
            this.bMn.start();
        }
        this.bMo = ValueAnimator.ofInt(77, 0);
        this.bMo.setDuration(300L);
        this.bMo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.bMq = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.bMp);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.bMo.isRunning()) {
            this.bMo.start();
        }
    }

    private void p(Canvas canvas) {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "performRefreshCompleteAnim");
        }
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.bMp = fL(this.bMp);
            this.bMq = fL(this.bMq);
            this.bMh.setAlpha(this.bMq);
            this.bMg.setAlpha(this.bMp);
            this.mCanvas.drawCircle(this.bMi.x + this.bMl, this.bMi.y, bMb, this.bMh);
            this.bMg.setAlpha(this.bMp);
            this.mCanvas.drawCircle(this.bMi.x + this.bMm, this.bMi.y, bMb, this.bMg);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "Complete:mAlpha=" + this.bMp);
                Log.e("NeutralRefreshAnimView", "Complete:mRightBallXPosi=" + this.bMl);
                Log.e("NeutralRefreshAnimView", "Complete:mLeftBallXPosi=" + this.bMm);
            }
        }
    }

    public void stopAnim() {
        abS();
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

    private void abS() {
        a(this.bMj, true);
        a(this.bMk, true);
        a(this.bMn, false);
        a(this.bMo, false);
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
