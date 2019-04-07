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
    private static final double aJB = Math.sqrt(2.0d);
    private boolean aIh;
    private Canvas aIj;
    private Camera aIk;
    float aJC;
    float aJD;
    float aJE;
    float aJF;
    float aJG;
    float aJH;
    float aJI;
    private PointF aJJ;
    private Paint aJK;
    private a aJL;
    private RectF aJM;
    private PointF aJN;
    private PointF aJO;
    private PointF aJP;
    private float aJQ;
    private int aJR;
    private int aJS;
    private ValueAnimator aJT;
    private float aJU;
    private float aJV;
    private ValueAnimator aJW;
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
        int i = refreshingAnimView.aJS;
        refreshingAnimView.aJS = i + 1;
        return i;
    }

    public RefreshingAnimView(Context context) {
        super(context);
        this.aJC = 0.0f;
        this.aJD = 0.0f;
        this.aJE = 0.0f;
        this.aJF = 0.0f;
        this.aJG = 0.0f;
        this.aJH = 0.0f;
        this.aJI = 0.0f;
        this.mWidth = 0.0f;
        this.aJJ = new PointF();
        this.aJM = new RectF();
        this.aJN = new PointF();
        this.aJO = new PointF();
        this.aJP = new PointF();
        this.aJQ = 0.0f;
        this.aJR = 0;
        this.aJS = 1;
        this.aJT = null;
        this.aJU = 0.0f;
        this.aJV = 0.0f;
        this.aJW = null;
        this.aIh = false;
        this.mState = 0;
        qY();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aJC = 0.0f;
        this.aJD = 0.0f;
        this.aJE = 0.0f;
        this.aJF = 0.0f;
        this.aJG = 0.0f;
        this.aJH = 0.0f;
        this.aJI = 0.0f;
        this.mWidth = 0.0f;
        this.aJJ = new PointF();
        this.aJM = new RectF();
        this.aJN = new PointF();
        this.aJO = new PointF();
        this.aJP = new PointF();
        this.aJQ = 0.0f;
        this.aJR = 0;
        this.aJS = 1;
        this.aJT = null;
        this.aJU = 0.0f;
        this.aJV = 0.0f;
        this.aJW = null;
        this.aIh = false;
        this.mState = 0;
        qY();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aJC = 0.0f;
        this.aJD = 0.0f;
        this.aJE = 0.0f;
        this.aJF = 0.0f;
        this.aJG = 0.0f;
        this.aJH = 0.0f;
        this.aJI = 0.0f;
        this.mWidth = 0.0f;
        this.aJJ = new PointF();
        this.aJM = new RectF();
        this.aJN = new PointF();
        this.aJO = new PointF();
        this.aJP = new PointF();
        this.aJQ = 0.0f;
        this.aJR = 0;
        this.aJS = 1;
        this.aJT = null;
        this.aJU = 0.0f;
        this.aJV = 0.0f;
        this.aJW = null;
        this.aIh = false;
        this.mState = 0;
        qY();
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        this.aJC = f2 <= 1.0f ? f2 : 1.0f;
        HC();
        postInvalidate();
    }

    public void HB() {
        E(300L);
    }

    private void E(long j) {
        cS(2);
        if (this.aJW != null) {
            Hn();
        }
        this.aJW = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.aJW.setDuration(j);
        this.aJW.setInterpolator(new LinearInterpolator());
        this.aJW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.Z(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.aJW.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.2
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
        if (!this.aJW.isRunning()) {
            this.aJW.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(long j) {
        cS(3);
        if (this.aJT != null) {
            Hn();
        }
        this.aJT = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.aJT.setDuration(j);
        this.aJT.setInterpolator(new LinearInterpolator());
        this.aJT.setRepeatCount(-1);
        this.aJT.setRepeatMode(1);
        this.aJT.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.aa(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        if (this.aJR > 0) {
            this.aJT.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.4
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
                    if (RefreshingAnimView.this.aJS > RefreshingAnimView.this.aJR && RefreshingAnimView.this.aJL != null) {
                        RefreshingAnimView.this.aJL.bE(true);
                    }
                }
            });
        } else if (this.aJL != null) {
            this.aJL.bE(true);
        }
        if (!this.aJT.isRunning()) {
            this.aJT.start();
        }
    }

    public void setAtLeastRotateRounds(int i) {
        this.aJR = i;
    }

    public void setOnLoadingAnimationListener(a aVar) {
        this.aJL = aVar;
    }

    public void stopAnim() {
        Hn();
        clearAnimation();
        this.aJC = 0.0f;
        this.aJS = 1;
        cS(1);
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
        this.aJF = x.dip2px(getContext(), 8.0f);
        this.aJH = x.dip2px(getContext(), 6.5f);
        this.aJQ = x.dip2px(getContext(), 5.0f);
        this.aJI = x.dip2px(getContext(), 7.5f);
        float f = this.mWidth / 2.0f;
        this.aJJ.set(f, f);
        float f2 = f + ((float) (this.aJF / aJB));
        this.aJO.set(f2, f2);
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
        Log.w("RefreshingAnimView", "onDraw->mState:" + HD() + ";AnimValue:" + this.aJC);
    }

    private void p(Canvas canvas) {
        if (this.mBitmap != null && this.aIj != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            if (this.aIh != com.baidu.swan.apps.u.a.CR().Dq()) {
                this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
                this.aIh = com.baidu.swan.apps.u.a.CR().Dq();
            }
            this.mPaint.setAlpha(76);
            this.aJM.set(this.aJJ.x - this.aJF, this.aJJ.y - this.aJF, this.aJJ.x + this.aJF, this.aJJ.y + this.aJF);
            this.aIj.drawArc(this.aJM, -90.0f, (-360.0f) * this.aJD, true, this.mPaint);
            this.aIj.drawCircle(this.aJJ.x, this.aJJ.y, this.aJG, this.aJK);
            if (this.aJE > 0.0f) {
                this.aIj.drawCircle(this.aJP.x, this.aJP.y, 0.75f, this.mPaint);
                this.mPaint.setStyle(Paint.Style.STROKE);
                this.mPaint.setStrokeWidth(x.dip2px(getContext(), 1.5f));
                this.aIj.drawLine(this.aJO.x, this.aJO.y, this.aJP.x, this.aJP.y, this.mPaint);
            }
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    private void HC() {
        this.aJD = this.aJC;
        if (this.aJC < 0.5f) {
            this.aJE = 0.0f;
            this.aJG = 0.0f;
            return;
        }
        this.aJG = ((this.aJC - 0.5f) / 0.5f) * this.aJH;
        if (this.aJC < 0.625f) {
            this.aJE = 0.0f;
            return;
        }
        this.aJE = (this.aJC - 0.625f) / 0.375f;
        this.aJP.set(this.aJO.x + ((float) ((this.aJQ * this.aJE) / aJB)), this.aJO.y + ((float) ((this.aJQ * this.aJE) / aJB)));
    }

    private void q(Canvas canvas) {
        if (this.mBitmap != null && this.aIj != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setAlpha((int) (255.0d * ((this.aJV * 0.3d) + 0.3d)));
            float f = this.aJO.x + ((float) (this.aJQ / aJB));
            this.aIj.drawCircle(this.aJJ.x, this.aJJ.y, this.aJF, this.mPaint);
            this.aIj.drawCircle(this.aJJ.x, this.aJJ.y, this.aJH, this.aJK);
            this.aIj.drawCircle(f, f, 0.75f, this.mPaint);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(x.dip2px(getContext(), 1.5f));
            this.aIj.drawLine(this.aJO.x, this.aJO.y, f, f, this.mPaint);
            this.mMatrix.reset();
            this.aIk.save();
            this.aIk.setLocation(0.0f, 0.0f, -100.0f);
            this.aIk.rotateY(this.aJV * 90.0f);
            this.aIk.getMatrix(this.mMatrix);
            this.aIk.restore();
            this.mMatrix.preTranslate(-this.aJJ.x, -this.aJJ.y);
            this.mMatrix.postTranslate(this.aJJ.x, this.aJJ.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(float f) {
        this.aJV = f;
        postInvalidate();
    }

    private void r(Canvas canvas) {
        if (this.mBitmap != null && this.aIj != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            int abs = (int) ((((1.0d - (Math.abs(this.aJU - 0.5d) * 2.0d)) * 0.3d) + 0.3d) * 255.0d);
            if (this.aIh) {
                abs = (int) ((((1.0d - (Math.abs(this.aJU - 0.5d) * 2.0d)) * 0.2d) + 0.1d) * 255.0d);
            }
            this.mPaint.setAlpha(abs);
            this.aIj.drawCircle(this.aJJ.x, this.aJJ.y, this.aJI, this.mPaint);
            this.mMatrix.reset();
            this.aIk.save();
            this.aIk.setLocation(0.0f, 0.0f, -100.0f);
            this.aIk.rotateY((this.aJU * 360.0f) + 90.0f);
            this.aIk.getMatrix(this.mMatrix);
            this.aIk.restore();
            this.mMatrix.preTranslate(-this.aJJ.x, -this.aJJ.y);
            this.mMatrix.postTranslate(this.aJJ.x, this.aJJ.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa(float f) {
        if (f < 0.2f) {
            this.aJU = (f / 0.2f) * 0.5f;
        } else {
            this.aJU = (((f - 0.2f) / 0.8f) * 0.5f) + 0.5f;
        }
        postInvalidate();
    }

    private void qY() {
        this.aIh = com.baidu.swan.apps.u.a.CR().Dq();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
        this.aJK = new Paint();
        this.aJK.setAntiAlias(true);
        this.aJK.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.aIk = new Camera();
        this.mMatrix = new Matrix();
        cS(1);
    }

    private void cS(int i) {
        this.mState = i;
    }

    private String HD() {
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
            this.aIj = new Canvas(this.mBitmap);
        }
    }

    private void Hn() {
        if (this.aJW != null) {
            this.aJW.setRepeatCount(0);
            this.aJW.removeAllUpdateListeners();
            this.aJW.removeAllListeners();
            this.aJW.end();
            this.aJW.cancel();
        }
        if (this.aJT != null) {
            this.aJT.setRepeatCount(0);
            this.aJT.removeAllUpdateListeners();
            this.aJT.removeAllListeners();
            this.aJT.end();
            this.aJT.cancel();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Hn();
    }
}
