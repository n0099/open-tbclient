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
    private static final double aJC = Math.sqrt(2.0d);
    private boolean aIi;
    private Canvas aIk;
    private Camera aIl;
    float aJD;
    float aJE;
    float aJF;
    float aJG;
    float aJH;
    float aJI;
    float aJJ;
    private PointF aJK;
    private Paint aJL;
    private a aJM;
    private RectF aJN;
    private PointF aJO;
    private PointF aJP;
    private PointF aJQ;
    private float aJR;
    private int aJS;
    private int aJT;
    private ValueAnimator aJU;
    private float aJV;
    private float aJW;
    private ValueAnimator aJX;
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
        int i = refreshingAnimView.aJT;
        refreshingAnimView.aJT = i + 1;
        return i;
    }

    public RefreshingAnimView(Context context) {
        super(context);
        this.aJD = 0.0f;
        this.aJE = 0.0f;
        this.aJF = 0.0f;
        this.aJG = 0.0f;
        this.aJH = 0.0f;
        this.aJI = 0.0f;
        this.aJJ = 0.0f;
        this.mWidth = 0.0f;
        this.aJK = new PointF();
        this.aJN = new RectF();
        this.aJO = new PointF();
        this.aJP = new PointF();
        this.aJQ = new PointF();
        this.aJR = 0.0f;
        this.aJS = 0;
        this.aJT = 1;
        this.aJU = null;
        this.aJV = 0.0f;
        this.aJW = 0.0f;
        this.aJX = null;
        this.aIi = false;
        this.mState = 0;
        qY();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aJD = 0.0f;
        this.aJE = 0.0f;
        this.aJF = 0.0f;
        this.aJG = 0.0f;
        this.aJH = 0.0f;
        this.aJI = 0.0f;
        this.aJJ = 0.0f;
        this.mWidth = 0.0f;
        this.aJK = new PointF();
        this.aJN = new RectF();
        this.aJO = new PointF();
        this.aJP = new PointF();
        this.aJQ = new PointF();
        this.aJR = 0.0f;
        this.aJS = 0;
        this.aJT = 1;
        this.aJU = null;
        this.aJV = 0.0f;
        this.aJW = 0.0f;
        this.aJX = null;
        this.aIi = false;
        this.mState = 0;
        qY();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aJD = 0.0f;
        this.aJE = 0.0f;
        this.aJF = 0.0f;
        this.aJG = 0.0f;
        this.aJH = 0.0f;
        this.aJI = 0.0f;
        this.aJJ = 0.0f;
        this.mWidth = 0.0f;
        this.aJK = new PointF();
        this.aJN = new RectF();
        this.aJO = new PointF();
        this.aJP = new PointF();
        this.aJQ = new PointF();
        this.aJR = 0.0f;
        this.aJS = 0;
        this.aJT = 1;
        this.aJU = null;
        this.aJV = 0.0f;
        this.aJW = 0.0f;
        this.aJX = null;
        this.aIi = false;
        this.mState = 0;
        qY();
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        this.aJD = f2 <= 1.0f ? f2 : 1.0f;
        HC();
        postInvalidate();
    }

    public void HB() {
        E(300L);
    }

    private void E(long j) {
        cS(2);
        if (this.aJX != null) {
            Hn();
        }
        this.aJX = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.aJX.setDuration(j);
        this.aJX.setInterpolator(new LinearInterpolator());
        this.aJX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.Z(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.aJX.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.2
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
        if (!this.aJX.isRunning()) {
            this.aJX.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(long j) {
        cS(3);
        if (this.aJU != null) {
            Hn();
        }
        this.aJU = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.aJU.setDuration(j);
        this.aJU.setInterpolator(new LinearInterpolator());
        this.aJU.setRepeatCount(-1);
        this.aJU.setRepeatMode(1);
        this.aJU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.aa(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        if (this.aJS > 0) {
            this.aJU.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.4
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
                    if (RefreshingAnimView.this.aJT > RefreshingAnimView.this.aJS && RefreshingAnimView.this.aJM != null) {
                        RefreshingAnimView.this.aJM.bE(true);
                    }
                }
            });
        } else if (this.aJM != null) {
            this.aJM.bE(true);
        }
        if (!this.aJU.isRunning()) {
            this.aJU.start();
        }
    }

    public void setAtLeastRotateRounds(int i) {
        this.aJS = i;
    }

    public void setOnLoadingAnimationListener(a aVar) {
        this.aJM = aVar;
    }

    public void stopAnim() {
        Hn();
        clearAnimation();
        this.aJD = 0.0f;
        this.aJT = 1;
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
        this.aJG = x.dip2px(getContext(), 8.0f);
        this.aJI = x.dip2px(getContext(), 6.5f);
        this.aJR = x.dip2px(getContext(), 5.0f);
        this.aJJ = x.dip2px(getContext(), 7.5f);
        float f = this.mWidth / 2.0f;
        this.aJK.set(f, f);
        float f2 = f + ((float) (this.aJG / aJC));
        this.aJP.set(f2, f2);
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
        Log.w("RefreshingAnimView", "onDraw->mState:" + HD() + ";AnimValue:" + this.aJD);
    }

    private void p(Canvas canvas) {
        if (this.mBitmap != null && this.aIk != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            if (this.aIi != com.baidu.swan.apps.u.a.CR().Dq()) {
                this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
                this.aIi = com.baidu.swan.apps.u.a.CR().Dq();
            }
            this.mPaint.setAlpha(76);
            this.aJN.set(this.aJK.x - this.aJG, this.aJK.y - this.aJG, this.aJK.x + this.aJG, this.aJK.y + this.aJG);
            this.aIk.drawArc(this.aJN, -90.0f, (-360.0f) * this.aJE, true, this.mPaint);
            this.aIk.drawCircle(this.aJK.x, this.aJK.y, this.aJH, this.aJL);
            if (this.aJF > 0.0f) {
                this.aIk.drawCircle(this.aJQ.x, this.aJQ.y, 0.75f, this.mPaint);
                this.mPaint.setStyle(Paint.Style.STROKE);
                this.mPaint.setStrokeWidth(x.dip2px(getContext(), 1.5f));
                this.aIk.drawLine(this.aJP.x, this.aJP.y, this.aJQ.x, this.aJQ.y, this.mPaint);
            }
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    private void HC() {
        this.aJE = this.aJD;
        if (this.aJD < 0.5f) {
            this.aJF = 0.0f;
            this.aJH = 0.0f;
            return;
        }
        this.aJH = ((this.aJD - 0.5f) / 0.5f) * this.aJI;
        if (this.aJD < 0.625f) {
            this.aJF = 0.0f;
            return;
        }
        this.aJF = (this.aJD - 0.625f) / 0.375f;
        this.aJQ.set(this.aJP.x + ((float) ((this.aJR * this.aJF) / aJC)), this.aJP.y + ((float) ((this.aJR * this.aJF) / aJC)));
    }

    private void q(Canvas canvas) {
        if (this.mBitmap != null && this.aIk != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setAlpha((int) (255.0d * ((this.aJW * 0.3d) + 0.3d)));
            float f = this.aJP.x + ((float) (this.aJR / aJC));
            this.aIk.drawCircle(this.aJK.x, this.aJK.y, this.aJG, this.mPaint);
            this.aIk.drawCircle(this.aJK.x, this.aJK.y, this.aJI, this.aJL);
            this.aIk.drawCircle(f, f, 0.75f, this.mPaint);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(x.dip2px(getContext(), 1.5f));
            this.aIk.drawLine(this.aJP.x, this.aJP.y, f, f, this.mPaint);
            this.mMatrix.reset();
            this.aIl.save();
            this.aIl.setLocation(0.0f, 0.0f, -100.0f);
            this.aIl.rotateY(this.aJW * 90.0f);
            this.aIl.getMatrix(this.mMatrix);
            this.aIl.restore();
            this.mMatrix.preTranslate(-this.aJK.x, -this.aJK.y);
            this.mMatrix.postTranslate(this.aJK.x, this.aJK.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(float f) {
        this.aJW = f;
        postInvalidate();
    }

    private void r(Canvas canvas) {
        if (this.mBitmap != null && this.aIk != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            int abs = (int) ((((1.0d - (Math.abs(this.aJV - 0.5d) * 2.0d)) * 0.3d) + 0.3d) * 255.0d);
            if (this.aIi) {
                abs = (int) ((((1.0d - (Math.abs(this.aJV - 0.5d) * 2.0d)) * 0.2d) + 0.1d) * 255.0d);
            }
            this.mPaint.setAlpha(abs);
            this.aIk.drawCircle(this.aJK.x, this.aJK.y, this.aJJ, this.mPaint);
            this.mMatrix.reset();
            this.aIl.save();
            this.aIl.setLocation(0.0f, 0.0f, -100.0f);
            this.aIl.rotateY((this.aJV * 360.0f) + 90.0f);
            this.aIl.getMatrix(this.mMatrix);
            this.aIl.restore();
            this.mMatrix.preTranslate(-this.aJK.x, -this.aJK.y);
            this.mMatrix.postTranslate(this.aJK.x, this.aJK.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa(float f) {
        if (f < 0.2f) {
            this.aJV = (f / 0.2f) * 0.5f;
        } else {
            this.aJV = (((f - 0.2f) / 0.8f) * 0.5f) + 0.5f;
        }
        postInvalidate();
    }

    private void qY() {
        this.aIi = com.baidu.swan.apps.u.a.CR().Dq();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
        this.aJL = new Paint();
        this.aJL.setAntiAlias(true);
        this.aJL.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.aIl = new Camera();
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
            this.aIk = new Canvas(this.mBitmap);
        }
    }

    private void Hn() {
        if (this.aJX != null) {
            this.aJX.setRepeatCount(0);
            this.aJX.removeAllUpdateListeners();
            this.aJX.removeAllListeners();
            this.aJX.end();
            this.aJX.cancel();
        }
        if (this.aJU != null) {
            this.aJU.setRepeatCount(0);
            this.aJU.removeAllUpdateListeners();
            this.aJU.removeAllListeners();
            this.aJU.end();
            this.aJU.cancel();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Hn();
    }
}
