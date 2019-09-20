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
    private static final int aLs = z.ad(3.5f);
    private static final int aLt = Color.parseColor("#000000");
    private static final int aLu = z.ad(18.0f);
    private static final int aLv = aLu >> 1;
    private ValueAnimator aLA;
    private ValueAnimator aLB;
    private float aLC;
    private float aLD;
    private ValueAnimator aLE;
    private ValueAnimator aLF;
    private int aLG;
    private int aLH;
    private Canvas aLj;
    private float aLw;
    private Paint aLx;
    private Paint aLy;
    private PointF aLz;
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
        this.aLz = new PointF();
        this.aLx = new Paint(1);
        this.aLy = new Paint(1);
        this.aLx.setColor(aLt);
        this.aLy.setColor(aLt);
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        float f3 = f2 <= 1.0f ? f2 : 1.0f;
        this.aLw = f3;
        db(1);
        postInvalidate();
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "setAnimPercent, percent = " + f3);
        }
    }

    public boolean bO(int i) {
        if (this.aLy == null || this.aLx == null) {
            return false;
        }
        this.aLx.setColor(i);
        this.aLy.setColor(i);
        return true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
        this.aLz.set(this.mWidth >> 1, this.mHeight >> 1);
    }

    @Override // android.view.View
    protected void onSizeChanged(final int i, final int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            j.b(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.1
                @Override // java.lang.Runnable
                public void run() {
                    NeutralRefreshAnimView.this.mBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                    NeutralRefreshAnimView.this.aLj = new Canvas(NeutralRefreshAnimView.this.mBitmap);
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
    public void db(int i) {
        this.mState = i;
        if (DEBUG) {
            Log.i("NeutralRefreshAnimView", "curr state:" + this.mState);
        }
    }

    private void m(Canvas canvas) {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "performPullToRefreshAnim");
        }
        if (this.mBitmap != null && this.aLj != null) {
            this.mBitmap.eraseColor(0);
            if (this.aLw == 0.0f) {
                this.aLy.setAlpha(0);
                this.aLj.drawCircle(this.aLz.x, this.aLz.y, aLs, this.aLy);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            } else if (this.aLw <= 0.5f) {
                int i = (int) (this.aLw * 77.0f);
                this.aLy.setAlpha(i);
                this.aLj.drawCircle(this.aLz.x, this.aLz.y, aLs, this.aLy);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "first level,alpha=" + i);
                }
            } else if (this.aLw < 1.0f) {
                int dc = dc((int) (this.aLw * 77.0f));
                this.aLy.setAlpha(dc);
                float f = (this.aLw - 0.5f) * 2.0f;
                int dc2 = dc((int) (26.0f * f));
                this.aLx.setAlpha(dc2);
                this.aLj.drawCircle(this.aLz.x + (aLv * f), this.aLz.y, aLs, this.aLy);
                this.aLj.drawCircle(this.aLz.x - (aLv * f), this.aLz.y, aLs, this.aLx);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "second level,mAnimPercent=" + this.aLw);
                    Log.e("NeutralRefreshAnimView", "second level,rightBallAlpha=" + dc);
                    Log.e("NeutralRefreshAnimView", "second level,leftBallAlpha=" + dc2);
                    Log.e("NeutralRefreshAnimView", "second level,fraction=" + f);
                    Log.e("NeutralRefreshAnimView", "second level,HALF_MAX_DISTANCE * fraction=" + (f * aLv));
                }
            } else if (this.aLw == 1.0f) {
                this.aLx.setAlpha(26);
                this.aLy.setAlpha(77);
                this.aLj.drawCircle(this.aLz.x + aLv, this.aLz.y, aLs, this.aLy);
                this.aLj.drawCircle(this.aLz.x - aLv, this.aLz.y, aLs, this.aLx);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "third level,mAnimPercent=" + this.aLw);
                }
            }
        }
    }

    public void Kv() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshingAnim");
        }
        db(2);
        Kw();
    }

    private void Kw() {
        Ku();
        this.aLB = ValueAnimator.ofFloat(1.0f, -1.0f);
        this.aLB.setDuration(480L);
        this.aLB.setRepeatMode(2);
        this.aLB.setRepeatCount(-1);
        this.aLB.setInterpolator(new AccelerateDecelerateInterpolator());
        this.aLB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.aLC = NeutralRefreshAnimView.aLv * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mRightBallXPosi=" + NeutralRefreshAnimView.this.aLC + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.aLA = ValueAnimator.ofFloat(-1.0f, 1.0f);
        this.aLA.setDuration(480L);
        this.aLA.setRepeatMode(2);
        this.aLA.setRepeatCount(-1);
        this.aLA.setInterpolator(new AccelerateDecelerateInterpolator());
        this.aLA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.aLD = NeutralRefreshAnimView.aLv * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mLeftBallXPosi=" + NeutralRefreshAnimView.this.aLD + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.mAnimatorSet = new AnimatorSet();
        this.mAnimatorSet.playTogether(this.aLA, this.aLB);
        this.mAnimatorSet.setDuration(480L);
        this.mAnimatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                NeutralRefreshAnimView.this.db(4);
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
        if (this.mBitmap != null && this.aLj != null) {
            this.mBitmap.eraseColor(0);
            this.aLy.setAlpha(77);
            this.aLj.drawCircle(this.aLz.x + this.aLC, this.aLz.y, aLs, this.aLy);
            this.aLx.setAlpha(26);
            this.aLj.drawCircle(this.aLz.x + this.aLD, this.aLz.y, aLs, this.aLx);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "performOnRefreshingAnim");
            }
        }
    }

    public void Kx() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshCompleteAnim");
        }
        stopAnim();
        db(3);
        Ky();
    }

    private void Ky() {
        this.aLE = ValueAnimator.ofInt(26, 0);
        this.aLE.setDuration(300L);
        this.aLE.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.aLG = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.aLG);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.aLE.isRunning()) {
            this.aLE.start();
        }
        this.aLF = ValueAnimator.ofInt(77, 0);
        this.aLF.setDuration(300L);
        this.aLF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.aLH = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.aLG);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.aLF.isRunning()) {
            this.aLF.start();
        }
    }

    private void o(Canvas canvas) {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "performRefreshCompleteAnim");
        }
        if (this.mBitmap != null && this.aLj != null) {
            this.mBitmap.eraseColor(0);
            this.aLG = dc(this.aLG);
            this.aLH = dc(this.aLH);
            this.aLy.setAlpha(this.aLH);
            this.aLx.setAlpha(this.aLG);
            this.aLj.drawCircle(this.aLz.x + this.aLC, this.aLz.y, aLs, this.aLy);
            this.aLx.setAlpha(this.aLG);
            this.aLj.drawCircle(this.aLz.x + this.aLD, this.aLz.y, aLs, this.aLx);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "Complete:mAlpha=" + this.aLG);
                Log.e("NeutralRefreshAnimView", "Complete:mRightBallXPosi=" + this.aLC);
                Log.e("NeutralRefreshAnimView", "Complete:mLeftBallXPosi=" + this.aLD);
            }
        }
    }

    public void stopAnim() {
        Ku();
        clearAnimation();
        db(1);
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

    private void Ku() {
        a(this.aLA, true);
        a(this.aLB, true);
        a(this.aLE, false);
        a(this.aLF, false);
        if (this.mAnimatorSet != null) {
            this.mAnimatorSet.removeAllListeners();
            this.mAnimatorSet.end();
            this.mAnimatorSet.cancel();
        }
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "resetAnimator");
        }
    }

    private int dc(int i) {
        int i2 = i < 0 ? 0 : i;
        if (i2 > 255) {
            return 255;
        }
        return i2;
    }
}
