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
    private static final int bem = z.S(3.5f);
    private static final int ben = Color.parseColor("#000000");
    private static final int beo = z.S(18.0f);
    private static final int bep = beo >> 1;
    private ValueAnimator beA;
    private int beB;
    private int beC;
    private float beq;
    private Paint ber;
    private Paint bes;
    private PointF beu;
    private ValueAnimator bev;
    private ValueAnimator bew;
    private float bex;
    private float bey;
    private ValueAnimator bez;
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
        this.beu = new PointF();
        this.ber = new Paint(1);
        this.bes = new Paint(1);
        this.ber.setColor(ben);
        this.bes.setColor(ben);
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        float f3 = f2 <= 1.0f ? f2 : 1.0f;
        this.beq = f3;
        dW(1);
        postInvalidate();
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "setAnimPercent, percent = " + f3);
        }
    }

    public boolean cK(int i) {
        if (this.bes == null || this.ber == null) {
            return false;
        }
        this.ber.setColor(i);
        this.bes.setColor(i);
        return true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
        this.beu.set(this.mWidth >> 1, this.mHeight >> 1);
    }

    @Override // android.view.View
    protected void onSizeChanged(final int i, final int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            j.b(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.1
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
    public void dW(int i) {
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
            if (this.beq == 0.0f) {
                this.bes.setAlpha(0);
                this.mCanvas.drawCircle(this.beu.x, this.beu.y, bem, this.bes);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            } else if (this.beq <= 0.5f) {
                int i = (int) (this.beq * 77.0f);
                this.bes.setAlpha(i);
                this.mCanvas.drawCircle(this.beu.x, this.beu.y, bem, this.bes);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "first level,alpha=" + i);
                }
            } else if (this.beq < 1.0f) {
                int dX = dX((int) (this.beq * 77.0f));
                this.bes.setAlpha(dX);
                float f = (this.beq - 0.5f) * 2.0f;
                int dX2 = dX((int) (26.0f * f));
                this.ber.setAlpha(dX2);
                this.mCanvas.drawCircle(this.beu.x + (bep * f), this.beu.y, bem, this.bes);
                this.mCanvas.drawCircle(this.beu.x - (bep * f), this.beu.y, bem, this.ber);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "second level,mAnimPercent=" + this.beq);
                    Log.e("NeutralRefreshAnimView", "second level,rightBallAlpha=" + dX);
                    Log.e("NeutralRefreshAnimView", "second level,leftBallAlpha=" + dX2);
                    Log.e("NeutralRefreshAnimView", "second level,fraction=" + f);
                    Log.e("NeutralRefreshAnimView", "second level,HALF_MAX_DISTANCE * fraction=" + (f * bep));
                }
            } else if (this.beq == 1.0f) {
                this.ber.setAlpha(26);
                this.bes.setAlpha(77);
                this.mCanvas.drawCircle(this.beu.x + bep, this.beu.y, bem, this.bes);
                this.mCanvas.drawCircle(this.beu.x - bep, this.beu.y, bem, this.ber);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "third level,mAnimPercent=" + this.beq);
                }
            }
        }
    }

    public void Pp() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshingAnim");
        }
        dW(2);
        Pq();
    }

    private void Pq() {
        Po();
        this.bew = ValueAnimator.ofFloat(1.0f, -1.0f);
        this.bew.setDuration(480L);
        this.bew.setRepeatMode(2);
        this.bew.setRepeatCount(-1);
        this.bew.setInterpolator(new AccelerateDecelerateInterpolator());
        this.bew.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.bex = NeutralRefreshAnimView.bep * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mRightBallXPosi=" + NeutralRefreshAnimView.this.bex + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.bev = ValueAnimator.ofFloat(-1.0f, 1.0f);
        this.bev.setDuration(480L);
        this.bev.setRepeatMode(2);
        this.bev.setRepeatCount(-1);
        this.bev.setInterpolator(new AccelerateDecelerateInterpolator());
        this.bev.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.bey = NeutralRefreshAnimView.bep * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mLeftBallXPosi=" + NeutralRefreshAnimView.this.bey + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.mAnimatorSet = new AnimatorSet();
        this.mAnimatorSet.playTogether(this.bev, this.bew);
        this.mAnimatorSet.setDuration(480L);
        this.mAnimatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                NeutralRefreshAnimView.this.dW(4);
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
            this.bes.setAlpha(77);
            this.mCanvas.drawCircle(this.beu.x + this.bex, this.beu.y, bem, this.bes);
            this.ber.setAlpha(26);
            this.mCanvas.drawCircle(this.beu.x + this.bey, this.beu.y, bem, this.ber);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "performOnRefreshingAnim");
            }
        }
    }

    public void Pr() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshCompleteAnim");
        }
        stopAnim();
        dW(3);
        Ps();
    }

    private void Ps() {
        this.bez = ValueAnimator.ofInt(26, 0);
        this.bez.setDuration(300L);
        this.bez.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.beB = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.beB);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.bez.isRunning()) {
            this.bez.start();
        }
        this.beA = ValueAnimator.ofInt(77, 0);
        this.beA.setDuration(300L);
        this.beA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.beC = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.beB);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.beA.isRunning()) {
            this.beA.start();
        }
    }

    private void s(Canvas canvas) {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "performRefreshCompleteAnim");
        }
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.beB = dX(this.beB);
            this.beC = dX(this.beC);
            this.bes.setAlpha(this.beC);
            this.ber.setAlpha(this.beB);
            this.mCanvas.drawCircle(this.beu.x + this.bex, this.beu.y, bem, this.bes);
            this.ber.setAlpha(this.beB);
            this.mCanvas.drawCircle(this.beu.x + this.bey, this.beu.y, bem, this.ber);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "Complete:mAlpha=" + this.beB);
                Log.e("NeutralRefreshAnimView", "Complete:mRightBallXPosi=" + this.bex);
                Log.e("NeutralRefreshAnimView", "Complete:mLeftBallXPosi=" + this.bey);
            }
        }
    }

    public void stopAnim() {
        Po();
        clearAnimation();
        dW(1);
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

    private void Po() {
        a(this.bev, true);
        a(this.bew, true);
        a(this.bez, false);
        a(this.beA, false);
        if (this.mAnimatorSet != null) {
            this.mAnimatorSet.removeAllListeners();
            this.mAnimatorSet.end();
            this.mAnimatorSet.cancel();
        }
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "resetAnimator");
        }
    }

    private int dX(int i) {
        int i2 = i < 0 ? 0 : i;
        if (i2 > 255) {
            return 255;
        }
        return i2;
    }
}
