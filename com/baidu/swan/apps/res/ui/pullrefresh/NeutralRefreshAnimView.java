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
import com.baidu.swan.apps.aq.ag;
import com.baidu.swan.apps.aq.n;
import com.baidu.swan.apps.b;
/* loaded from: classes11.dex */
public class NeutralRefreshAnimView extends View {
    private static final boolean DEBUG = b.DEBUG;
    private static final int cBf = ag.D(3.5f);
    private static final int cBg = Color.parseColor("#000000");
    private static final int cBh = ag.D(18.0f);
    private static final int cBi = cBh >> 1;
    private float cBj;
    private Paint cBk;
    private Paint cBl;
    private PointF cBm;
    private ValueAnimator cBn;
    private ValueAnimator cBo;
    private float cBp;
    private float cBq;
    private ValueAnimator cBr;
    private ValueAnimator cBs;
    private int cBt;
    private int cBu;
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
        this.cBm = new PointF();
        this.cBk = new Paint(1);
        this.cBl = new Paint(1);
        this.cBk.setColor(cBg);
        this.cBl.setColor(cBg);
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        float f3 = f2 <= 1.0f ? f2 : 1.0f;
        this.cBj = f3;
        changeState(1);
        postInvalidate();
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "setAnimPercent, percent = " + f3);
        }
    }

    public boolean eu(int i) {
        if (this.cBl == null || this.cBk == null) {
            return false;
        }
        this.cBk.setColor(i);
        this.cBl.setColor(i);
        return true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
        this.cBm.set(this.mWidth >> 1, this.mHeight >> 1);
    }

    @Override // android.view.View
    protected void onSizeChanged(final int i, final int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            n.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.1
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
                o(canvas);
                break;
            case 2:
                p(canvas);
                break;
            case 3:
                q(canvas);
                break;
            case 4:
                p(canvas);
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

    private void o(Canvas canvas) {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "performPullToRefreshAnim");
        }
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            if (this.cBj == 0.0f) {
                this.cBl.setAlpha(0);
                this.mCanvas.drawCircle(this.cBm.x, this.cBm.y, cBf, this.cBl);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            } else if (this.cBj <= 0.5f) {
                int i = (int) (this.cBj * 77.0f);
                this.cBl.setAlpha(i);
                this.mCanvas.drawCircle(this.cBm.x, this.cBm.y, cBf, this.cBl);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "first level,alpha=" + i);
                }
            } else if (this.cBj < 1.0f) {
                int gx = gx((int) (this.cBj * 77.0f));
                this.cBl.setAlpha(gx);
                float f = (this.cBj - 0.5f) * 2.0f;
                int gx2 = gx((int) (26.0f * f));
                this.cBk.setAlpha(gx2);
                this.mCanvas.drawCircle(this.cBm.x + (cBi * f), this.cBm.y, cBf, this.cBl);
                this.mCanvas.drawCircle(this.cBm.x - (cBi * f), this.cBm.y, cBf, this.cBk);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "second level,mAnimPercent=" + this.cBj);
                    Log.e("NeutralRefreshAnimView", "second level,rightBallAlpha=" + gx);
                    Log.e("NeutralRefreshAnimView", "second level,leftBallAlpha=" + gx2);
                    Log.e("NeutralRefreshAnimView", "second level,fraction=" + f);
                    Log.e("NeutralRefreshAnimView", "second level,HALF_MAX_DISTANCE * fraction=" + (f * cBi));
                }
            } else if (this.cBj == 1.0f) {
                this.cBk.setAlpha(26);
                this.cBl.setAlpha(77);
                this.mCanvas.drawCircle(this.cBm.x + cBi, this.cBm.y, cBf, this.cBl);
                this.mCanvas.drawCircle(this.cBm.x - cBi, this.cBm.y, cBf, this.cBk);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "third level,mAnimPercent=" + this.cBj);
                }
            }
        }
    }

    public void aoR() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshingAnim");
        }
        changeState(2);
        aoS();
    }

    private void aoS() {
        aoQ();
        this.cBo = ValueAnimator.ofFloat(1.0f, -1.0f);
        this.cBo.setDuration(480L);
        this.cBo.setRepeatMode(2);
        this.cBo.setRepeatCount(-1);
        this.cBo.setInterpolator(new AccelerateDecelerateInterpolator());
        this.cBo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.cBp = NeutralRefreshAnimView.cBi * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mRightBallXPosi=" + NeutralRefreshAnimView.this.cBp + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.cBn = ValueAnimator.ofFloat(-1.0f, 1.0f);
        this.cBn.setDuration(480L);
        this.cBn.setRepeatMode(2);
        this.cBn.setRepeatCount(-1);
        this.cBn.setInterpolator(new AccelerateDecelerateInterpolator());
        this.cBn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.cBq = NeutralRefreshAnimView.cBi * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mLeftBallXPosi=" + NeutralRefreshAnimView.this.cBq + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.mAnimatorSet = new AnimatorSet();
        this.mAnimatorSet.playTogether(this.cBn, this.cBo);
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

    private void p(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.cBl.setAlpha(77);
            this.mCanvas.drawCircle(this.cBm.x + this.cBp, this.cBm.y, cBf, this.cBl);
            this.cBk.setAlpha(26);
            this.mCanvas.drawCircle(this.cBm.x + this.cBq, this.cBm.y, cBf, this.cBk);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "performOnRefreshingAnim");
            }
        }
    }

    public void aoT() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshCompleteAnim");
        }
        stopAnim();
        changeState(3);
        aoU();
    }

    private void aoU() {
        this.cBr = ValueAnimator.ofInt(26, 0);
        this.cBr.setDuration(300L);
        this.cBr.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.cBt = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.cBt);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.cBr.isRunning()) {
            this.cBr.start();
        }
        this.cBs = ValueAnimator.ofInt(77, 0);
        this.cBs.setDuration(300L);
        this.cBs.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.cBu = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.cBt);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.cBs.isRunning()) {
            this.cBs.start();
        }
    }

    private void q(Canvas canvas) {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "performRefreshCompleteAnim");
        }
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.cBt = gx(this.cBt);
            this.cBu = gx(this.cBu);
            this.cBl.setAlpha(this.cBu);
            this.cBk.setAlpha(this.cBt);
            this.mCanvas.drawCircle(this.cBm.x + this.cBp, this.cBm.y, cBf, this.cBl);
            this.cBk.setAlpha(this.cBt);
            this.mCanvas.drawCircle(this.cBm.x + this.cBq, this.cBm.y, cBf, this.cBk);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "Complete:mAlpha=" + this.cBt);
                Log.e("NeutralRefreshAnimView", "Complete:mRightBallXPosi=" + this.cBp);
                Log.e("NeutralRefreshAnimView", "Complete:mLeftBallXPosi=" + this.cBq);
            }
        }
    }

    public void stopAnim() {
        aoQ();
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

    private void aoQ() {
        a(this.cBn, true);
        a(this.cBo, true);
        a(this.cBr, false);
        a(this.cBs, false);
        if (this.mAnimatorSet != null) {
            this.mAnimatorSet.removeAllListeners();
            this.mAnimatorSet.end();
            this.mAnimatorSet.cancel();
        }
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "resetAnimator");
        }
    }

    private int gx(int i) {
        int i2 = i < 0 ? 0 : i;
        if (i2 > 255) {
            return 255;
        }
        return i2;
    }
}
