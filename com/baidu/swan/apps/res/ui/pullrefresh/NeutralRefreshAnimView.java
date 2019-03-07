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
import com.baidu.swan.apps.c;
/* loaded from: classes2.dex */
public class NeutralRefreshAnimView extends View {
    private static final boolean DEBUG = c.DEBUG;
    private static final int aIo = x.ad(3.5f);
    private static final int aIp = Color.parseColor("#000000");
    private static final int aIq = x.ad(18.0f);
    private static final int aIr = aIq >> 1;
    private ValueAnimator aIA;
    private ValueAnimator aIB;
    private int aIC;
    private int aID;
    private Canvas aIf;
    private float aIs;
    private Paint aIt;
    private Paint aIu;
    private PointF aIv;
    private ValueAnimator aIw;
    private ValueAnimator aIx;
    private float aIy;
    private float aIz;
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
        this.aIv = new PointF();
        this.aIt = new Paint(1);
        this.aIu = new Paint(1);
        this.aIt.setColor(aIp);
        this.aIu.setColor(aIp);
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        float f3 = f2 <= 1.0f ? f2 : 1.0f;
        this.aIs = f3;
        cT(1);
        postInvalidate();
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "setAnimPercent, percent = " + f3);
        }
    }

    public boolean bO(int i) {
        if (this.aIu == null || this.aIt == null) {
            return false;
        }
        this.aIt.setColor(i);
        this.aIu.setColor(i);
        return true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
        this.aIv.set(this.mWidth >> 1, this.mHeight >> 1);
    }

    @Override // android.view.View
    protected void onSizeChanged(final int i, final int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            j.b(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.1
                @Override // java.lang.Runnable
                public void run() {
                    NeutralRefreshAnimView.this.mBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                    NeutralRefreshAnimView.this.aIf = new Canvas(NeutralRefreshAnimView.this.mBitmap);
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
    public void cT(int i) {
        this.mState = i;
        if (DEBUG) {
            Log.i("NeutralRefreshAnimView", "curr state:" + this.mState);
        }
    }

    private void m(Canvas canvas) {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "performPullToRefreshAnim");
        }
        if (this.mBitmap != null && this.aIf != null) {
            this.mBitmap.eraseColor(0);
            if (this.aIs == 0.0f) {
                this.aIu.setAlpha(0);
                this.aIf.drawCircle(this.aIv.x, this.aIv.y, aIo, this.aIu);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            } else if (this.aIs <= 0.5f) {
                int i = (int) (this.aIs * 77.0f);
                this.aIu.setAlpha(i);
                this.aIf.drawCircle(this.aIv.x, this.aIv.y, aIo, this.aIu);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "first level,alpha=" + i);
                }
            } else if (this.aIs < 1.0f) {
                int cU = cU((int) (this.aIs * 77.0f));
                this.aIu.setAlpha(cU);
                float f = (this.aIs - 0.5f) * 2.0f;
                int cU2 = cU((int) (26.0f * f));
                this.aIt.setAlpha(cU2);
                this.aIf.drawCircle(this.aIv.x + (aIr * f), this.aIv.y, aIo, this.aIu);
                this.aIf.drawCircle(this.aIv.x - (aIr * f), this.aIv.y, aIo, this.aIt);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "second level,mAnimPercent=" + this.aIs);
                    Log.e("NeutralRefreshAnimView", "second level,rightBallAlpha=" + cU);
                    Log.e("NeutralRefreshAnimView", "second level,leftBallAlpha=" + cU2);
                    Log.e("NeutralRefreshAnimView", "second level,fraction=" + f);
                    Log.e("NeutralRefreshAnimView", "second level,HALF_MAX_DISTANCE * fraction=" + (f * aIr));
                }
            } else if (this.aIs == 1.0f) {
                this.aIt.setAlpha(26);
                this.aIu.setAlpha(77);
                this.aIf.drawCircle(this.aIv.x + aIr, this.aIv.y, aIo, this.aIu);
                this.aIf.drawCircle(this.aIv.x - aIr, this.aIv.y, aIo, this.aIt);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "third level,mAnimPercent=" + this.aIs);
                }
            }
        }
    }

    public void Hq() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshingAnim");
        }
        cT(2);
        Hr();
    }

    private void Hr() {
        Hp();
        this.aIx = ValueAnimator.ofFloat(1.0f, -1.0f);
        this.aIx.setDuration(480L);
        this.aIx.setRepeatMode(2);
        this.aIx.setRepeatCount(-1);
        this.aIx.setInterpolator(new AccelerateDecelerateInterpolator());
        this.aIx.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.aIy = NeutralRefreshAnimView.aIr * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mRightBallXPosi=" + NeutralRefreshAnimView.this.aIy + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.aIw = ValueAnimator.ofFloat(-1.0f, 1.0f);
        this.aIw.setDuration(480L);
        this.aIw.setRepeatMode(2);
        this.aIw.setRepeatCount(-1);
        this.aIw.setInterpolator(new AccelerateDecelerateInterpolator());
        this.aIw.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.aIz = NeutralRefreshAnimView.aIr * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mLeftBallXPosi=" + NeutralRefreshAnimView.this.aIz + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.mAnimatorSet = new AnimatorSet();
        this.mAnimatorSet.playTogether(this.aIw, this.aIx);
        this.mAnimatorSet.setDuration(480L);
        this.mAnimatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                NeutralRefreshAnimView.this.cT(4);
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
        if (this.mBitmap != null && this.aIf != null) {
            this.mBitmap.eraseColor(0);
            this.aIu.setAlpha(77);
            this.aIf.drawCircle(this.aIv.x + this.aIy, this.aIv.y, aIo, this.aIu);
            this.aIt.setAlpha(26);
            this.aIf.drawCircle(this.aIv.x + this.aIz, this.aIv.y, aIo, this.aIt);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "performOnRefreshingAnim");
            }
        }
    }

    public void Hs() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshCompleteAnim");
        }
        stopAnim();
        cT(3);
        Ht();
    }

    private void Ht() {
        this.aIA = ValueAnimator.ofInt(26, 0);
        this.aIA.setDuration(300L);
        this.aIA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.aIC = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.aIC);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.aIA.isRunning()) {
            this.aIA.start();
        }
        this.aIB = ValueAnimator.ofInt(77, 0);
        this.aIB.setDuration(300L);
        this.aIB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.aID = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.aIC);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.aIB.isRunning()) {
            this.aIB.start();
        }
    }

    private void o(Canvas canvas) {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "performRefreshCompleteAnim");
        }
        if (this.mBitmap != null && this.aIf != null) {
            this.mBitmap.eraseColor(0);
            this.aIC = cU(this.aIC);
            this.aID = cU(this.aID);
            this.aIu.setAlpha(this.aID);
            this.aIt.setAlpha(this.aIC);
            this.aIf.drawCircle(this.aIv.x + this.aIy, this.aIv.y, aIo, this.aIu);
            this.aIt.setAlpha(this.aIC);
            this.aIf.drawCircle(this.aIv.x + this.aIz, this.aIv.y, aIo, this.aIt);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "Complete:mAlpha=" + this.aIC);
                Log.e("NeutralRefreshAnimView", "Complete:mRightBallXPosi=" + this.aIy);
                Log.e("NeutralRefreshAnimView", "Complete:mLeftBallXPosi=" + this.aIz);
            }
        }
    }

    public void stopAnim() {
        Hp();
        clearAnimation();
        cT(1);
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

    private void Hp() {
        a(this.aIw, true);
        a(this.aIx, true);
        a(this.aIA, false);
        a(this.aIB, false);
        if (this.mAnimatorSet != null) {
            this.mAnimatorSet.removeAllListeners();
            this.mAnimatorSet.end();
            this.mAnimatorSet.cancel();
        }
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "resetAnimator");
        }
    }

    private int cU(int i) {
        int i2 = i < 0 ? 0 : i;
        if (i2 > 255) {
            return 255;
        }
        return i2;
    }
}
