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
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.ap.p;
import com.baidu.swan.apps.b;
/* loaded from: classes7.dex */
public class NeutralRefreshAnimView extends View {
    private static final boolean DEBUG = b.DEBUG;
    private static final int dnN = ah.M(3.5f);
    private static final int dnO = Color.parseColor("#000000");
    private static final int dnP = ah.M(18.0f);
    private static final int dnQ = dnP >> 1;
    private float dnR;
    private Paint dnS;
    private Paint dnT;
    private PointF dnU;
    private ValueAnimator dnV;
    private ValueAnimator dnW;
    private float dnX;
    private float dnY;
    private ValueAnimator dnZ;
    private ValueAnimator doa;
    private int dob;
    private int dod;
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
        this.dnU = new PointF();
        this.dnS = new Paint(1);
        this.dnT = new Paint(1);
        this.dnS.setColor(dnO);
        this.dnT.setColor(dnO);
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        float f3 = f2 <= 1.0f ? f2 : 1.0f;
        this.dnR = f3;
        jL(1);
        postInvalidate();
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "setAnimPercent, percent = " + f3);
        }
    }

    public boolean hr(int i) {
        if (this.dnT == null || this.dnS == null) {
            return false;
        }
        this.dnS.setColor(i);
        this.dnT.setColor(i);
        return true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
        this.dnU.set(this.mWidth >> 1, this.mHeight >> 1);
    }

    @Override // android.view.View
    protected void onSizeChanged(final int i, final int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.1
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
    public void jL(int i) {
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
            if (this.dnR == 0.0f) {
                this.dnT.setAlpha(0);
                this.mCanvas.drawCircle(this.dnU.x, this.dnU.y, dnN, this.dnT);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            } else if (this.dnR <= 0.5f) {
                int i = (int) (this.dnR * 77.0f);
                this.dnT.setAlpha(i);
                this.mCanvas.drawCircle(this.dnU.x, this.dnU.y, dnN, this.dnT);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "first level,alpha=" + i);
                }
            } else if (this.dnR < 1.0f) {
                int jM = jM((int) (this.dnR * 77.0f));
                this.dnT.setAlpha(jM);
                float f = (this.dnR - 0.5f) * 2.0f;
                int jM2 = jM((int) (26.0f * f));
                this.dnS.setAlpha(jM2);
                this.mCanvas.drawCircle(this.dnU.x + (dnQ * f), this.dnU.y, dnN, this.dnT);
                this.mCanvas.drawCircle(this.dnU.x - (dnQ * f), this.dnU.y, dnN, this.dnS);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "second level,mAnimPercent=" + this.dnR);
                    Log.e("NeutralRefreshAnimView", "second level,rightBallAlpha=" + jM);
                    Log.e("NeutralRefreshAnimView", "second level,leftBallAlpha=" + jM2);
                    Log.e("NeutralRefreshAnimView", "second level,fraction=" + f);
                    Log.e("NeutralRefreshAnimView", "second level,HALF_MAX_DISTANCE * fraction=" + (f * dnQ));
                }
            } else if (this.dnR == 1.0f) {
                this.dnS.setAlpha(26);
                this.dnT.setAlpha(77);
                this.mCanvas.drawCircle(this.dnU.x + dnQ, this.dnU.y, dnN, this.dnT);
                this.mCanvas.drawCircle(this.dnU.x - dnQ, this.dnU.y, dnN, this.dnS);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "third level,mAnimPercent=" + this.dnR);
                }
            }
        }
    }

    public void aFR() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshingAnim");
        }
        jL(2);
        aFS();
    }

    private void aFS() {
        aFQ();
        this.dnW = ValueAnimator.ofFloat(1.0f, -1.0f);
        this.dnW.setDuration(480L);
        this.dnW.setRepeatMode(2);
        this.dnW.setRepeatCount(-1);
        this.dnW.setInterpolator(new AccelerateDecelerateInterpolator());
        this.dnW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.dnX = NeutralRefreshAnimView.dnQ * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mRightBallXPosi=" + NeutralRefreshAnimView.this.dnX + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.dnV = ValueAnimator.ofFloat(-1.0f, 1.0f);
        this.dnV.setDuration(480L);
        this.dnV.setRepeatMode(2);
        this.dnV.setRepeatCount(-1);
        this.dnV.setInterpolator(new AccelerateDecelerateInterpolator());
        this.dnV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.dnY = NeutralRefreshAnimView.dnQ * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mLeftBallXPosi=" + NeutralRefreshAnimView.this.dnY + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.mAnimatorSet = new AnimatorSet();
        this.mAnimatorSet.playTogether(this.dnV, this.dnW);
        this.mAnimatorSet.setDuration(480L);
        this.mAnimatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                NeutralRefreshAnimView.this.jL(4);
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
            this.dnT.setAlpha(77);
            this.mCanvas.drawCircle(this.dnU.x + this.dnX, this.dnU.y, dnN, this.dnT);
            this.dnS.setAlpha(26);
            this.mCanvas.drawCircle(this.dnU.x + this.dnY, this.dnU.y, dnN, this.dnS);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "performOnRefreshingAnim");
            }
        }
    }

    public void aFT() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshCompleteAnim");
        }
        stopAnim();
        jL(3);
        aFU();
    }

    private void aFU() {
        this.dnZ = ValueAnimator.ofInt(26, 0);
        this.dnZ.setDuration(300L);
        this.dnZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.dob = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.dob);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.dnZ.isRunning()) {
            this.dnZ.start();
        }
        this.doa = ValueAnimator.ofInt(77, 0);
        this.doa.setDuration(300L);
        this.doa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.dod = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.dob);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.doa.isRunning()) {
            this.doa.start();
        }
    }

    private void s(Canvas canvas) {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "performRefreshCompleteAnim");
        }
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.dob = jM(this.dob);
            this.dod = jM(this.dod);
            this.dnT.setAlpha(this.dod);
            this.dnS.setAlpha(this.dob);
            this.mCanvas.drawCircle(this.dnU.x + this.dnX, this.dnU.y, dnN, this.dnT);
            this.dnS.setAlpha(this.dob);
            this.mCanvas.drawCircle(this.dnU.x + this.dnY, this.dnU.y, dnN, this.dnS);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "Complete:mAlpha=" + this.dob);
                Log.e("NeutralRefreshAnimView", "Complete:mRightBallXPosi=" + this.dnX);
                Log.e("NeutralRefreshAnimView", "Complete:mLeftBallXPosi=" + this.dnY);
            }
        }
    }

    public void stopAnim() {
        aFQ();
        clearAnimation();
        jL(1);
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

    private void aFQ() {
        a(this.dnV, true);
        a(this.dnW, true);
        a(this.dnZ, false);
        a(this.doa, false);
        if (this.mAnimatorSet != null) {
            this.mAnimatorSet.removeAllListeners();
            this.mAnimatorSet.end();
            this.mAnimatorSet.cancel();
        }
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "resetAnimator");
        }
    }

    private int jM(int i) {
        int i2 = i < 0 ? 0 : i;
        if (i2 > 255) {
            return 255;
        }
        return i2;
    }
}
