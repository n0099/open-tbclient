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
/* loaded from: classes9.dex */
public class NeutralRefreshAnimView extends View {
    private static final boolean DEBUG = b.DEBUG;
    private static final int bGZ = af.T(3.5f);
    private static final int bHa = Color.parseColor(BaseBrowseView.ROOT_VIEW_COLOR);
    private static final int bHb = af.T(18.0f);
    private static final int bHc = bHb >> 1;
    private float bHd;
    private Paint bHe;
    private Paint bHf;
    private PointF bHg;
    private ValueAnimator bHh;
    private ValueAnimator bHi;
    private float bHj;
    private float bHk;
    private ValueAnimator bHl;
    private ValueAnimator bHm;
    private int bHn;
    private int bHo;
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
        this.bHg = new PointF();
        this.bHe = new Paint(1);
        this.bHf = new Paint(1);
        this.bHe.setColor(bHa);
        this.bHf.setColor(bHa);
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        float f3 = f2 <= 1.0f ? f2 : 1.0f;
        this.bHd = f3;
        changeState(1);
        postInvalidate();
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "setAnimPercent, percent = " + f3);
        }
    }

    public boolean dF(int i) {
        if (this.bHf == null || this.bHe == null) {
            return false;
        }
        this.bHe.setColor(i);
        this.bHf.setColor(i);
        return true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
        this.bHg.set(this.mWidth >> 1, this.mHeight >> 1);
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
            if (this.bHd == 0.0f) {
                this.bHf.setAlpha(0);
                this.mCanvas.drawCircle(this.bHg.x, this.bHg.y, bGZ, this.bHf);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            } else if (this.bHd <= 0.5f) {
                int i = (int) (this.bHd * 77.0f);
                this.bHf.setAlpha(i);
                this.mCanvas.drawCircle(this.bHg.x, this.bHg.y, bGZ, this.bHf);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "first level,alpha=" + i);
                }
            } else if (this.bHd < 1.0f) {
                int fu = fu((int) (this.bHd * 77.0f));
                this.bHf.setAlpha(fu);
                float f = (this.bHd - 0.5f) * 2.0f;
                int fu2 = fu((int) (26.0f * f));
                this.bHe.setAlpha(fu2);
                this.mCanvas.drawCircle(this.bHg.x + (bHc * f), this.bHg.y, bGZ, this.bHf);
                this.mCanvas.drawCircle(this.bHg.x - (bHc * f), this.bHg.y, bGZ, this.bHe);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "second level,mAnimPercent=" + this.bHd);
                    Log.e("NeutralRefreshAnimView", "second level,rightBallAlpha=" + fu);
                    Log.e("NeutralRefreshAnimView", "second level,leftBallAlpha=" + fu2);
                    Log.e("NeutralRefreshAnimView", "second level,fraction=" + f);
                    Log.e("NeutralRefreshAnimView", "second level,HALF_MAX_DISTANCE * fraction=" + (f * bHc));
                }
            } else if (this.bHd == 1.0f) {
                this.bHe.setAlpha(26);
                this.bHf.setAlpha(77);
                this.mCanvas.drawCircle(this.bHg.x + bHc, this.bHg.y, bGZ, this.bHf);
                this.mCanvas.drawCircle(this.bHg.x - bHc, this.bHg.y, bGZ, this.bHe);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "third level,mAnimPercent=" + this.bHd);
                }
            }
        }
    }

    public void Zd() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshingAnim");
        }
        changeState(2);
        Ze();
    }

    private void Ze() {
        Zc();
        this.bHi = ValueAnimator.ofFloat(1.0f, -1.0f);
        this.bHi.setDuration(480L);
        this.bHi.setRepeatMode(2);
        this.bHi.setRepeatCount(-1);
        this.bHi.setInterpolator(new AccelerateDecelerateInterpolator());
        this.bHi.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.bHj = NeutralRefreshAnimView.bHc * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mRightBallXPosi=" + NeutralRefreshAnimView.this.bHj + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.bHh = ValueAnimator.ofFloat(-1.0f, 1.0f);
        this.bHh.setDuration(480L);
        this.bHh.setRepeatMode(2);
        this.bHh.setRepeatCount(-1);
        this.bHh.setInterpolator(new AccelerateDecelerateInterpolator());
        this.bHh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.bHk = NeutralRefreshAnimView.bHc * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mLeftBallXPosi=" + NeutralRefreshAnimView.this.bHk + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.mAnimatorSet = new AnimatorSet();
        this.mAnimatorSet.playTogether(this.bHh, this.bHi);
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
            this.bHf.setAlpha(77);
            this.mCanvas.drawCircle(this.bHg.x + this.bHj, this.bHg.y, bGZ, this.bHf);
            this.bHe.setAlpha(26);
            this.mCanvas.drawCircle(this.bHg.x + this.bHk, this.bHg.y, bGZ, this.bHe);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "performOnRefreshingAnim");
            }
        }
    }

    public void Zf() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshCompleteAnim");
        }
        stopAnim();
        changeState(3);
        Zg();
    }

    private void Zg() {
        this.bHl = ValueAnimator.ofInt(26, 0);
        this.bHl.setDuration(300L);
        this.bHl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.bHn = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.bHn);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.bHl.isRunning()) {
            this.bHl.start();
        }
        this.bHm = ValueAnimator.ofInt(77, 0);
        this.bHm.setDuration(300L);
        this.bHm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.bHo = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.bHn);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.bHm.isRunning()) {
            this.bHm.start();
        }
    }

    private void p(Canvas canvas) {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "performRefreshCompleteAnim");
        }
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.bHn = fu(this.bHn);
            this.bHo = fu(this.bHo);
            this.bHf.setAlpha(this.bHo);
            this.bHe.setAlpha(this.bHn);
            this.mCanvas.drawCircle(this.bHg.x + this.bHj, this.bHg.y, bGZ, this.bHf);
            this.bHe.setAlpha(this.bHn);
            this.mCanvas.drawCircle(this.bHg.x + this.bHk, this.bHg.y, bGZ, this.bHe);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "Complete:mAlpha=" + this.bHn);
                Log.e("NeutralRefreshAnimView", "Complete:mRightBallXPosi=" + this.bHj);
                Log.e("NeutralRefreshAnimView", "Complete:mLeftBallXPosi=" + this.bHk);
            }
        }
    }

    public void stopAnim() {
        Zc();
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

    private void Zc() {
        a(this.bHh, true);
        a(this.bHi, true);
        a(this.bHl, false);
        a(this.bHm, false);
        if (this.mAnimatorSet != null) {
            this.mAnimatorSet.removeAllListeners();
            this.mAnimatorSet.end();
            this.mAnimatorSet.cancel();
        }
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "resetAnimator");
        }
    }

    private int fu(int i) {
        int i2 = i < 0 ? 0 : i;
        if (i2 > 255) {
            return 255;
        }
        return i2;
    }
}
