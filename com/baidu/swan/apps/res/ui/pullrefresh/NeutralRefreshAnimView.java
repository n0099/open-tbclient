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
import com.baidu.swan.apps.an.x;
import com.baidu.swan.apps.b;
/* loaded from: classes2.dex */
public class NeutralRefreshAnimView extends View {
    private static final boolean DEBUG = b.DEBUG;
    private static final int aIt = x.ad(3.5f);
    private static final int aIu = Color.parseColor("#000000");
    private static final int aIv = x.ad(18.0f);
    private static final int aIw = aIv >> 1;
    private PointF aIA;
    private ValueAnimator aIB;
    private ValueAnimator aIC;
    private float aID;
    private float aIE;
    private ValueAnimator aIF;
    private ValueAnimator aIG;
    private int aIH;
    private int aII;
    private Canvas aIk;
    private float aIx;
    private Paint aIy;
    private Paint aIz;
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
        this.aIA = new PointF();
        this.aIy = new Paint(1);
        this.aIz = new Paint(1);
        this.aIy.setColor(aIu);
        this.aIz.setColor(aIu);
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        float f3 = f2 <= 1.0f ? f2 : 1.0f;
        this.aIx = f3;
        cS(1);
        postInvalidate();
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "setAnimPercent, percent = " + f3);
        }
    }

    public boolean bN(int i) {
        if (this.aIz == null || this.aIy == null) {
            return false;
        }
        this.aIy.setColor(i);
        this.aIz.setColor(i);
        return true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
        this.aIA.set(this.mWidth >> 1, this.mHeight >> 1);
    }

    @Override // android.view.View
    protected void onSizeChanged(final int i, final int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            j.b(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.1
                @Override // java.lang.Runnable
                public void run() {
                    NeutralRefreshAnimView.this.mBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                    NeutralRefreshAnimView.this.aIk = new Canvas(NeutralRefreshAnimView.this.mBitmap);
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
    public void cS(int i) {
        this.mState = i;
        if (DEBUG) {
            Log.i("NeutralRefreshAnimView", "curr state:" + this.mState);
        }
    }

    private void m(Canvas canvas) {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "performPullToRefreshAnim");
        }
        if (this.mBitmap != null && this.aIk != null) {
            this.mBitmap.eraseColor(0);
            if (this.aIx == 0.0f) {
                this.aIz.setAlpha(0);
                this.aIk.drawCircle(this.aIA.x, this.aIA.y, aIt, this.aIz);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            } else if (this.aIx <= 0.5f) {
                int i = (int) (this.aIx * 77.0f);
                this.aIz.setAlpha(i);
                this.aIk.drawCircle(this.aIA.x, this.aIA.y, aIt, this.aIz);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "first level,alpha=" + i);
                }
            } else if (this.aIx < 1.0f) {
                int cT = cT((int) (this.aIx * 77.0f));
                this.aIz.setAlpha(cT);
                float f = (this.aIx - 0.5f) * 2.0f;
                int cT2 = cT((int) (26.0f * f));
                this.aIy.setAlpha(cT2);
                this.aIk.drawCircle(this.aIA.x + (aIw * f), this.aIA.y, aIt, this.aIz);
                this.aIk.drawCircle(this.aIA.x - (aIw * f), this.aIA.y, aIt, this.aIy);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "second level,mAnimPercent=" + this.aIx);
                    Log.e("NeutralRefreshAnimView", "second level,rightBallAlpha=" + cT);
                    Log.e("NeutralRefreshAnimView", "second level,leftBallAlpha=" + cT2);
                    Log.e("NeutralRefreshAnimView", "second level,fraction=" + f);
                    Log.e("NeutralRefreshAnimView", "second level,HALF_MAX_DISTANCE * fraction=" + (f * aIw));
                }
            } else if (this.aIx == 1.0f) {
                this.aIy.setAlpha(26);
                this.aIz.setAlpha(77);
                this.aIk.drawCircle(this.aIA.x + aIw, this.aIA.y, aIt, this.aIz);
                this.aIk.drawCircle(this.aIA.x - aIw, this.aIA.y, aIt, this.aIy);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "third level,mAnimPercent=" + this.aIx);
                }
            }
        }
    }

    public void Ho() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshingAnim");
        }
        cS(2);
        Hp();
    }

    private void Hp() {
        Hn();
        this.aIC = ValueAnimator.ofFloat(1.0f, -1.0f);
        this.aIC.setDuration(480L);
        this.aIC.setRepeatMode(2);
        this.aIC.setRepeatCount(-1);
        this.aIC.setInterpolator(new AccelerateDecelerateInterpolator());
        this.aIC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.aID = NeutralRefreshAnimView.aIw * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mRightBallXPosi=" + NeutralRefreshAnimView.this.aID + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.aIB = ValueAnimator.ofFloat(-1.0f, 1.0f);
        this.aIB.setDuration(480L);
        this.aIB.setRepeatMode(2);
        this.aIB.setRepeatCount(-1);
        this.aIB.setInterpolator(new AccelerateDecelerateInterpolator());
        this.aIB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.aIE = NeutralRefreshAnimView.aIw * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mLeftBallXPosi=" + NeutralRefreshAnimView.this.aIE + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.mAnimatorSet = new AnimatorSet();
        this.mAnimatorSet.playTogether(this.aIB, this.aIC);
        this.mAnimatorSet.setDuration(480L);
        this.mAnimatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                NeutralRefreshAnimView.this.cS(4);
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
        if (this.mBitmap != null && this.aIk != null) {
            this.mBitmap.eraseColor(0);
            this.aIz.setAlpha(77);
            this.aIk.drawCircle(this.aIA.x + this.aID, this.aIA.y, aIt, this.aIz);
            this.aIy.setAlpha(26);
            this.aIk.drawCircle(this.aIA.x + this.aIE, this.aIA.y, aIt, this.aIy);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "performOnRefreshingAnim");
            }
        }
    }

    public void Hq() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshCompleteAnim");
        }
        stopAnim();
        cS(3);
        Hr();
    }

    private void Hr() {
        this.aIF = ValueAnimator.ofInt(26, 0);
        this.aIF.setDuration(300L);
        this.aIF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.aIH = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.aIH);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.aIF.isRunning()) {
            this.aIF.start();
        }
        this.aIG = ValueAnimator.ofInt(77, 0);
        this.aIG.setDuration(300L);
        this.aIG.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.aII = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.aIH);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.aIG.isRunning()) {
            this.aIG.start();
        }
    }

    private void o(Canvas canvas) {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "performRefreshCompleteAnim");
        }
        if (this.mBitmap != null && this.aIk != null) {
            this.mBitmap.eraseColor(0);
            this.aIH = cT(this.aIH);
            this.aII = cT(this.aII);
            this.aIz.setAlpha(this.aII);
            this.aIy.setAlpha(this.aIH);
            this.aIk.drawCircle(this.aIA.x + this.aID, this.aIA.y, aIt, this.aIz);
            this.aIy.setAlpha(this.aIH);
            this.aIk.drawCircle(this.aIA.x + this.aIE, this.aIA.y, aIt, this.aIy);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "Complete:mAlpha=" + this.aIH);
                Log.e("NeutralRefreshAnimView", "Complete:mRightBallXPosi=" + this.aID);
                Log.e("NeutralRefreshAnimView", "Complete:mLeftBallXPosi=" + this.aIE);
            }
        }
    }

    public void stopAnim() {
        Hn();
        clearAnimation();
        cS(1);
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

    private void Hn() {
        a(this.aIB, true);
        a(this.aIC, true);
        a(this.aIF, false);
        a(this.aIG, false);
        if (this.mAnimatorSet != null) {
            this.mAnimatorSet.removeAllListeners();
            this.mAnimatorSet.end();
            this.mAnimatorSet.cancel();
        }
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "resetAnimator");
        }
    }

    private int cT(int i) {
        int i2 = i < 0 ? 0 : i;
        if (i2 > 255) {
            return 255;
        }
        return i2;
    }
}
