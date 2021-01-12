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
    private static final int dwn = ah.O(3.5f);
    private static final int dwo = Color.parseColor("#000000");
    private static final int dwp = ah.O(18.0f);
    private static final int dwq = dwp >> 1;
    private ValueAnimator dwA;
    private int dwB;
    private int dwC;
    private float dwr;
    private Paint dws;
    private Paint dwt;
    private PointF dwu;
    private ValueAnimator dwv;
    private ValueAnimator dww;
    private float dwx;
    private float dwy;
    private ValueAnimator dwz;
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
        this.dwu = new PointF();
        this.dws = new Paint(1);
        this.dwt = new Paint(1);
        this.dws.setColor(dwo);
        this.dwt.setColor(dwo);
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        float f3 = f2 <= 1.0f ? f2 : 1.0f;
        this.dwr = f3;
        iC(1);
        postInvalidate();
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "setAnimPercent, percent = " + f3);
        }
    }

    public boolean gc(int i) {
        if (this.dwt == null || this.dws == null) {
            return false;
        }
        this.dws.setColor(i);
        this.dwt.setColor(i);
        return true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
        this.dwu.set(this.mWidth >> 1, this.mHeight >> 1);
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
    public void iC(int i) {
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
            if (this.dwr == 0.0f) {
                this.dwt.setAlpha(0);
                this.mCanvas.drawCircle(this.dwu.x, this.dwu.y, dwn, this.dwt);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            } else if (this.dwr <= 0.5f) {
                int i = (int) (this.dwr * 77.0f);
                this.dwt.setAlpha(i);
                this.mCanvas.drawCircle(this.dwu.x, this.dwu.y, dwn, this.dwt);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "first level,alpha=" + i);
                }
            } else if (this.dwr < 1.0f) {
                int iD = iD((int) (this.dwr * 77.0f));
                this.dwt.setAlpha(iD);
                float f = (this.dwr - 0.5f) * 2.0f;
                int iD2 = iD((int) (26.0f * f));
                this.dws.setAlpha(iD2);
                this.mCanvas.drawCircle(this.dwu.x + (dwq * f), this.dwu.y, dwn, this.dwt);
                this.mCanvas.drawCircle(this.dwu.x - (dwq * f), this.dwu.y, dwn, this.dws);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "second level,mAnimPercent=" + this.dwr);
                    Log.e("NeutralRefreshAnimView", "second level,rightBallAlpha=" + iD);
                    Log.e("NeutralRefreshAnimView", "second level,leftBallAlpha=" + iD2);
                    Log.e("NeutralRefreshAnimView", "second level,fraction=" + f);
                    Log.e("NeutralRefreshAnimView", "second level,HALF_MAX_DISTANCE * fraction=" + (f * dwq));
                }
            } else if (this.dwr == 1.0f) {
                this.dws.setAlpha(26);
                this.dwt.setAlpha(77);
                this.mCanvas.drawCircle(this.dwu.x + dwq, this.dwu.y, dwn, this.dwt);
                this.mCanvas.drawCircle(this.dwu.x - dwq, this.dwu.y, dwn, this.dws);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "third level,mAnimPercent=" + this.dwr);
                }
            }
        }
    }

    public void aGQ() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshingAnim");
        }
        iC(2);
        aGR();
    }

    private void aGR() {
        aGP();
        this.dww = ValueAnimator.ofFloat(1.0f, -1.0f);
        this.dww.setDuration(480L);
        this.dww.setRepeatMode(2);
        this.dww.setRepeatCount(-1);
        this.dww.setInterpolator(new AccelerateDecelerateInterpolator());
        this.dww.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.dwx = NeutralRefreshAnimView.dwq * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mRightBallXPosi=" + NeutralRefreshAnimView.this.dwx + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.dwv = ValueAnimator.ofFloat(-1.0f, 1.0f);
        this.dwv.setDuration(480L);
        this.dwv.setRepeatMode(2);
        this.dwv.setRepeatCount(-1);
        this.dwv.setInterpolator(new AccelerateDecelerateInterpolator());
        this.dwv.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.dwy = NeutralRefreshAnimView.dwq * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mLeftBallXPosi=" + NeutralRefreshAnimView.this.dwy + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.mAnimatorSet = new AnimatorSet();
        this.mAnimatorSet.playTogether(this.dwv, this.dww);
        this.mAnimatorSet.setDuration(480L);
        this.mAnimatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                NeutralRefreshAnimView.this.iC(4);
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
            this.dwt.setAlpha(77);
            this.mCanvas.drawCircle(this.dwu.x + this.dwx, this.dwu.y, dwn, this.dwt);
            this.dws.setAlpha(26);
            this.mCanvas.drawCircle(this.dwu.x + this.dwy, this.dwu.y, dwn, this.dws);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "performOnRefreshingAnim");
            }
        }
    }

    public void aGS() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshCompleteAnim");
        }
        stopAnim();
        iC(3);
        aGT();
    }

    private void aGT() {
        this.dwz = ValueAnimator.ofInt(26, 0);
        this.dwz.setDuration(300L);
        this.dwz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.dwB = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.dwB);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.dwz.isRunning()) {
            this.dwz.start();
        }
        this.dwA = ValueAnimator.ofInt(77, 0);
        this.dwA.setDuration(300L);
        this.dwA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.dwC = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.dwB);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.dwA.isRunning()) {
            this.dwA.start();
        }
    }

    private void z(Canvas canvas) {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "performRefreshCompleteAnim");
        }
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.dwB = iD(this.dwB);
            this.dwC = iD(this.dwC);
            this.dwt.setAlpha(this.dwC);
            this.dws.setAlpha(this.dwB);
            this.mCanvas.drawCircle(this.dwu.x + this.dwx, this.dwu.y, dwn, this.dwt);
            this.dws.setAlpha(this.dwB);
            this.mCanvas.drawCircle(this.dwu.x + this.dwy, this.dwu.y, dwn, this.dws);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "Complete:mAlpha=" + this.dwB);
                Log.e("NeutralRefreshAnimView", "Complete:mRightBallXPosi=" + this.dwx);
                Log.e("NeutralRefreshAnimView", "Complete:mLeftBallXPosi=" + this.dwy);
            }
        }
    }

    public void stopAnim() {
        aGP();
        clearAnimation();
        iC(1);
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

    private void aGP() {
        a(this.dwv, true);
        a(this.dww, true);
        a(this.dwz, false);
        a(this.dwA, false);
        if (this.mAnimatorSet != null) {
            this.mAnimatorSet.removeAllListeners();
            this.mAnimatorSet.end();
            this.mAnimatorSet.cancel();
        }
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "resetAnimator");
        }
    }

    private int iD(int i) {
        int i2 = i < 0 ? 0 : i;
        if (i2 > 255) {
            return 255;
        }
        return i2;
    }
}
