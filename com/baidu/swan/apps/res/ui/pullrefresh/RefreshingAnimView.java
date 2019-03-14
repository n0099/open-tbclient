package com.baidu.swan.apps.res.ui.pullrefresh;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.x;
/* loaded from: classes2.dex */
public class RefreshingAnimView extends View {
    private static final double aJy = Math.sqrt(2.0d);
    private boolean aIe;
    private Canvas aIg;
    private Camera aIh;
    float aJA;
    float aJB;
    float aJC;
    float aJD;
    float aJE;
    float aJF;
    private PointF aJG;
    private Paint aJH;
    private a aJI;
    private RectF aJJ;
    private PointF aJK;
    private PointF aJL;
    private PointF aJM;
    private float aJN;
    private int aJO;
    private int aJP;
    private ValueAnimator aJQ;
    private float aJR;
    private float aJS;
    private ValueAnimator aJT;
    float aJz;
    private Bitmap mBitmap;
    private Matrix mMatrix;
    private Paint mPaint;
    private int mState;
    private float mWidth;

    /* loaded from: classes2.dex */
    public interface a {
        void bE(boolean z);
    }

    static /* synthetic */ int a(RefreshingAnimView refreshingAnimView) {
        int i = refreshingAnimView.aJP;
        refreshingAnimView.aJP = i + 1;
        return i;
    }

    public RefreshingAnimView(Context context) {
        super(context);
        this.aJz = 0.0f;
        this.aJA = 0.0f;
        this.aJB = 0.0f;
        this.aJC = 0.0f;
        this.aJD = 0.0f;
        this.aJE = 0.0f;
        this.aJF = 0.0f;
        this.mWidth = 0.0f;
        this.aJG = new PointF();
        this.aJJ = new RectF();
        this.aJK = new PointF();
        this.aJL = new PointF();
        this.aJM = new PointF();
        this.aJN = 0.0f;
        this.aJO = 0;
        this.aJP = 1;
        this.aJQ = null;
        this.aJR = 0.0f;
        this.aJS = 0.0f;
        this.aJT = null;
        this.aIe = false;
        this.mState = 0;
        qY();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aJz = 0.0f;
        this.aJA = 0.0f;
        this.aJB = 0.0f;
        this.aJC = 0.0f;
        this.aJD = 0.0f;
        this.aJE = 0.0f;
        this.aJF = 0.0f;
        this.mWidth = 0.0f;
        this.aJG = new PointF();
        this.aJJ = new RectF();
        this.aJK = new PointF();
        this.aJL = new PointF();
        this.aJM = new PointF();
        this.aJN = 0.0f;
        this.aJO = 0;
        this.aJP = 1;
        this.aJQ = null;
        this.aJR = 0.0f;
        this.aJS = 0.0f;
        this.aJT = null;
        this.aIe = false;
        this.mState = 0;
        qY();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aJz = 0.0f;
        this.aJA = 0.0f;
        this.aJB = 0.0f;
        this.aJC = 0.0f;
        this.aJD = 0.0f;
        this.aJE = 0.0f;
        this.aJF = 0.0f;
        this.mWidth = 0.0f;
        this.aJG = new PointF();
        this.aJJ = new RectF();
        this.aJK = new PointF();
        this.aJL = new PointF();
        this.aJM = new PointF();
        this.aJN = 0.0f;
        this.aJO = 0;
        this.aJP = 1;
        this.aJQ = null;
        this.aJR = 0.0f;
        this.aJS = 0.0f;
        this.aJT = null;
        this.aIe = false;
        this.mState = 0;
        qY();
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        this.aJz = f2 <= 1.0f ? f2 : 1.0f;
        HE();
        postInvalidate();
    }

    public void HD() {
        E(300L);
    }

    private void E(long j) {
        cT(2);
        if (this.aJT != null) {
            Hp();
        }
        this.aJT = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.aJT.setDuration(j);
        this.aJT.setInterpolator(new LinearInterpolator());
        this.aJT.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.Z(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.aJT.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                RefreshingAnimView.this.F(750L);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
            }
        });
        if (!this.aJT.isRunning()) {
            this.aJT.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(long j) {
        cT(3);
        if (this.aJQ != null) {
            Hp();
        }
        this.aJQ = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.aJQ.setDuration(j);
        this.aJQ.setInterpolator(new LinearInterpolator());
        this.aJQ.setRepeatCount(-1);
        this.aJQ.setRepeatMode(1);
        this.aJQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.aa(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        if (this.aJO > 0) {
            this.aJQ.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    super.onAnimationRepeat(animator);
                    RefreshingAnimView.a(RefreshingAnimView.this);
                    if (RefreshingAnimView.this.aJP > RefreshingAnimView.this.aJO && RefreshingAnimView.this.aJI != null) {
                        RefreshingAnimView.this.aJI.bE(true);
                    }
                }
            });
        } else if (this.aJI != null) {
            this.aJI.bE(true);
        }
        if (!this.aJQ.isRunning()) {
            this.aJQ.start();
        }
    }

    public void setAtLeastRotateRounds(int i) {
        this.aJO = i;
    }

    public void setOnLoadingAnimationListener(a aVar) {
        this.aJI = aVar;
    }

    public void stopAnim() {
        Hp();
        clearAnimation();
        this.aJz = 0.0f;
        this.aJP = 1;
        cT(1);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredWidth() > getHeight()) {
            this.mWidth = getMeasuredHeight();
        } else {
            this.mWidth = getMeasuredWidth();
        }
        this.aJC = x.dip2px(getContext(), 8.0f);
        this.aJE = x.dip2px(getContext(), 6.5f);
        this.aJN = x.dip2px(getContext(), 5.0f);
        this.aJF = x.dip2px(getContext(), 7.5f);
        float f = this.mWidth / 2.0f;
        this.aJG.set(f, f);
        float f2 = f + ((float) (this.aJC / aJy));
        this.aJL.set(f2, f2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        switch (this.mState) {
            case 1:
                p(canvas);
                break;
            case 2:
                q(canvas);
                break;
            case 3:
                r(canvas);
                break;
        }
        canvas.restore();
        Log.w("RefreshingAnimView", "onDraw->mState:" + HF() + ";AnimValue:" + this.aJz);
    }

    private void p(Canvas canvas) {
        if (this.mBitmap != null && this.aIg != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            if (this.aIe != com.baidu.swan.apps.u.a.CT().Ds()) {
                this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
                this.aIe = com.baidu.swan.apps.u.a.CT().Ds();
            }
            this.mPaint.setAlpha(76);
            this.aJJ.set(this.aJG.x - this.aJC, this.aJG.y - this.aJC, this.aJG.x + this.aJC, this.aJG.y + this.aJC);
            this.aIg.drawArc(this.aJJ, -90.0f, (-360.0f) * this.aJA, true, this.mPaint);
            this.aIg.drawCircle(this.aJG.x, this.aJG.y, this.aJD, this.aJH);
            if (this.aJB > 0.0f) {
                this.aIg.drawCircle(this.aJM.x, this.aJM.y, 0.75f, this.mPaint);
                this.mPaint.setStyle(Paint.Style.STROKE);
                this.mPaint.setStrokeWidth(x.dip2px(getContext(), 1.5f));
                this.aIg.drawLine(this.aJL.x, this.aJL.y, this.aJM.x, this.aJM.y, this.mPaint);
            }
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    private void HE() {
        this.aJA = this.aJz;
        if (this.aJz < 0.5f) {
            this.aJB = 0.0f;
            this.aJD = 0.0f;
            return;
        }
        this.aJD = ((this.aJz - 0.5f) / 0.5f) * this.aJE;
        if (this.aJz < 0.625f) {
            this.aJB = 0.0f;
            return;
        }
        this.aJB = (this.aJz - 0.625f) / 0.375f;
        this.aJM.set(this.aJL.x + ((float) ((this.aJN * this.aJB) / aJy)), this.aJL.y + ((float) ((this.aJN * this.aJB) / aJy)));
    }

    private void q(Canvas canvas) {
        if (this.mBitmap != null && this.aIg != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setAlpha((int) (255.0d * ((this.aJS * 0.3d) + 0.3d)));
            float f = this.aJL.x + ((float) (this.aJN / aJy));
            this.aIg.drawCircle(this.aJG.x, this.aJG.y, this.aJC, this.mPaint);
            this.aIg.drawCircle(this.aJG.x, this.aJG.y, this.aJE, this.aJH);
            this.aIg.drawCircle(f, f, 0.75f, this.mPaint);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(x.dip2px(getContext(), 1.5f));
            this.aIg.drawLine(this.aJL.x, this.aJL.y, f, f, this.mPaint);
            this.mMatrix.reset();
            this.aIh.save();
            this.aIh.setLocation(0.0f, 0.0f, -100.0f);
            this.aIh.rotateY(this.aJS * 90.0f);
            this.aIh.getMatrix(this.mMatrix);
            this.aIh.restore();
            this.mMatrix.preTranslate(-this.aJG.x, -this.aJG.y);
            this.mMatrix.postTranslate(this.aJG.x, this.aJG.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(float f) {
        this.aJS = f;
        postInvalidate();
    }

    private void r(Canvas canvas) {
        if (this.mBitmap != null && this.aIg != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            int abs = (int) ((((1.0d - (Math.abs(this.aJR - 0.5d) * 2.0d)) * 0.3d) + 0.3d) * 255.0d);
            if (this.aIe) {
                abs = (int) ((((1.0d - (Math.abs(this.aJR - 0.5d) * 2.0d)) * 0.2d) + 0.1d) * 255.0d);
            }
            this.mPaint.setAlpha(abs);
            this.aIg.drawCircle(this.aJG.x, this.aJG.y, this.aJF, this.mPaint);
            this.mMatrix.reset();
            this.aIh.save();
            this.aIh.setLocation(0.0f, 0.0f, -100.0f);
            this.aIh.rotateY((this.aJR * 360.0f) + 90.0f);
            this.aIh.getMatrix(this.mMatrix);
            this.aIh.restore();
            this.mMatrix.preTranslate(-this.aJG.x, -this.aJG.y);
            this.mMatrix.postTranslate(this.aJG.x, this.aJG.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa(float f) {
        if (f < 0.2f) {
            this.aJR = (f / 0.2f) * 0.5f;
        } else {
            this.aJR = (((f - 0.2f) / 0.8f) * 0.5f) + 0.5f;
        }
        postInvalidate();
    }

    private void qY() {
        this.aIe = com.baidu.swan.apps.u.a.CT().Ds();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
        this.aJH = new Paint();
        this.aJH.setAntiAlias(true);
        this.aJH.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.aIh = new Camera();
        this.mMatrix = new Matrix();
        cT(1);
    }

    private void cT(int i) {
        this.mState = i;
    }

    private String HF() {
        switch (this.mState) {
            case 1:
                return "Magnifier";
            case 2:
                return "Transitions";
            case 3:
                return "Radar";
            default:
                return "None";
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            this.mBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            this.aIg = new Canvas(this.mBitmap);
        }
    }

    private void Hp() {
        if (this.aJT != null) {
            this.aJT.setRepeatCount(0);
            this.aJT.removeAllUpdateListeners();
            this.aJT.removeAllListeners();
            this.aJT.end();
            this.aJT.cancel();
        }
        if (this.aJQ != null) {
            this.aJQ.setRepeatCount(0);
            this.aJQ.removeAllUpdateListeners();
            this.aJQ.removeAllListeners();
            this.aJQ.end();
            this.aJQ.cancel();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Hp();
    }
}
