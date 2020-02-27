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
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.as.af;
/* loaded from: classes11.dex */
public class RefreshingAnimView extends View {
    private static final double bMT = Math.sqrt(2.0d);
    private boolean bLF;
    float bMU;
    float bMV;
    float bMW;
    float bMX;
    float bMY;
    float bMZ;
    float bNa;
    private PointF bNb;
    private Paint bNc;
    private a bNd;
    private RectF bNe;
    private PointF bNf;
    private PointF bNg;
    private PointF bNh;
    private float bNi;
    private int bNj;
    private int bNk;
    private ValueAnimator bNl;
    private float bNm;
    private float bNn;
    private ValueAnimator bNo;
    private Bitmap mBitmap;
    private Camera mCamera;
    private Canvas mCanvas;
    private Matrix mMatrix;
    private Paint mPaint;
    private int mState;
    private float mWidth;

    /* loaded from: classes11.dex */
    public interface a {
        void dx(boolean z);
    }

    static /* synthetic */ int a(RefreshingAnimView refreshingAnimView) {
        int i = refreshingAnimView.bNk;
        refreshingAnimView.bNk = i + 1;
        return i;
    }

    public RefreshingAnimView(Context context) {
        super(context);
        this.bMU = 0.0f;
        this.bMV = 0.0f;
        this.bMW = 0.0f;
        this.bMX = 0.0f;
        this.bMY = 0.0f;
        this.bMZ = 0.0f;
        this.bNa = 0.0f;
        this.mWidth = 0.0f;
        this.bNb = new PointF();
        this.bNe = new RectF();
        this.bNf = new PointF();
        this.bNg = new PointF();
        this.bNh = new PointF();
        this.bNi = 0.0f;
        this.bNj = 0;
        this.bNk = 1;
        this.bNl = null;
        this.bNm = 0.0f;
        this.bNn = 0.0f;
        this.bNo = null;
        this.bLF = false;
        this.mState = 0;
        lQ();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bMU = 0.0f;
        this.bMV = 0.0f;
        this.bMW = 0.0f;
        this.bMX = 0.0f;
        this.bMY = 0.0f;
        this.bMZ = 0.0f;
        this.bNa = 0.0f;
        this.mWidth = 0.0f;
        this.bNb = new PointF();
        this.bNe = new RectF();
        this.bNf = new PointF();
        this.bNg = new PointF();
        this.bNh = new PointF();
        this.bNi = 0.0f;
        this.bNj = 0;
        this.bNk = 1;
        this.bNl = null;
        this.bNm = 0.0f;
        this.bNn = 0.0f;
        this.bNo = null;
        this.bLF = false;
        this.mState = 0;
        lQ();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bMU = 0.0f;
        this.bMV = 0.0f;
        this.bMW = 0.0f;
        this.bMX = 0.0f;
        this.bMY = 0.0f;
        this.bMZ = 0.0f;
        this.bNa = 0.0f;
        this.mWidth = 0.0f;
        this.bNb = new PointF();
        this.bNe = new RectF();
        this.bNf = new PointF();
        this.bNg = new PointF();
        this.bNh = new PointF();
        this.bNi = 0.0f;
        this.bNj = 0;
        this.bNk = 1;
        this.bNl = null;
        this.bNm = 0.0f;
        this.bNn = 0.0f;
        this.bNo = null;
        this.bLF = false;
        this.mState = 0;
        lQ();
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        this.bMU = f2 <= 1.0f ? f2 : 1.0f;
        acc();
        postInvalidate();
    }

    public void acb() {
        ay(300L);
    }

    private void ay(long j) {
        changeState(2);
        if (this.bNo != null) {
            abN();
        }
        this.bNo = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.bNo.setDuration(j);
        this.bNo.setInterpolator(new LinearInterpolator());
        this.bNo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.P(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.bNo.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                RefreshingAnimView.this.az(750L);
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
        if (!this.bNo.isRunning()) {
            this.bNo.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void az(long j) {
        changeState(3);
        if (this.bNl != null) {
            abN();
        }
        this.bNl = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.bNl.setDuration(j);
        this.bNl.setInterpolator(new LinearInterpolator());
        this.bNl.setRepeatCount(-1);
        this.bNl.setRepeatMode(1);
        this.bNl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.Q(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        if (this.bNj > 0) {
            this.bNl.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.4
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
                    if (RefreshingAnimView.this.bNk > RefreshingAnimView.this.bNj && RefreshingAnimView.this.bNd != null) {
                        RefreshingAnimView.this.bNd.dx(true);
                    }
                }
            });
        } else if (this.bNd != null) {
            this.bNd.dx(true);
        }
        if (!this.bNl.isRunning()) {
            this.bNl.start();
        }
    }

    public void setAtLeastRotateRounds(int i) {
        this.bNj = i;
    }

    public void setOnLoadingAnimationListener(a aVar) {
        this.bNd = aVar;
    }

    public void stopAnim() {
        abN();
        clearAnimation();
        this.bMU = 0.0f;
        this.bNk = 1;
        changeState(1);
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
        this.bMX = af.dip2px(getContext(), 8.0f);
        this.bMZ = af.dip2px(getContext(), 6.5f);
        this.bNi = af.dip2px(getContext(), 5.0f);
        this.bNa = af.dip2px(getContext(), 7.5f);
        float f = this.mWidth / 2.0f;
        this.bNb.set(f, f);
        float f2 = f + ((float) (this.bMX / bMT));
        this.bNg.set(f2, f2);
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
        }
        canvas.restore();
    }

    private void q(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            if (this.bLF != com.baidu.swan.apps.w.a.Uq().getNightModeSwitcherState()) {
                this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
                this.bLF = com.baidu.swan.apps.w.a.Uq().getNightModeSwitcherState();
            }
            this.mPaint.setAlpha(76);
            this.bNe.set(this.bNb.x - this.bMX, this.bNb.y - this.bMX, this.bNb.x + this.bMX, this.bNb.y + this.bMX);
            this.mCanvas.drawArc(this.bNe, -90.0f, (-360.0f) * this.bMV, true, this.mPaint);
            this.mCanvas.drawCircle(this.bNb.x, this.bNb.y, this.bMY, this.bNc);
            if (this.bMW > 0.0f) {
                this.mCanvas.drawCircle(this.bNh.x, this.bNh.y, 0.75f, this.mPaint);
                this.mPaint.setStyle(Paint.Style.STROKE);
                this.mPaint.setStrokeWidth(af.dip2px(getContext(), 1.5f));
                this.mCanvas.drawLine(this.bNg.x, this.bNg.y, this.bNh.x, this.bNh.y, this.mPaint);
            }
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    private void acc() {
        this.bMV = this.bMU;
        if (this.bMU < 0.5f) {
            this.bMW = 0.0f;
            this.bMY = 0.0f;
            return;
        }
        this.bMY = ((this.bMU - 0.5f) / 0.5f) * this.bMZ;
        if (this.bMU < 0.625f) {
            this.bMW = 0.0f;
            return;
        }
        this.bMW = (this.bMU - 0.625f) / 0.375f;
        this.bNh.set(this.bNg.x + ((float) ((this.bNi * this.bMW) / bMT)), this.bNg.y + ((float) ((this.bNi * this.bMW) / bMT)));
    }

    private void r(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setAlpha((int) (255.0d * ((this.bNn * 0.3d) + 0.3d)));
            float f = this.bNg.x + ((float) (this.bNi / bMT));
            this.mCanvas.drawCircle(this.bNb.x, this.bNb.y, this.bMX, this.mPaint);
            this.mCanvas.drawCircle(this.bNb.x, this.bNb.y, this.bMZ, this.bNc);
            this.mCanvas.drawCircle(f, f, 0.75f, this.mPaint);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(af.dip2px(getContext(), 1.5f));
            this.mCanvas.drawLine(this.bNg.x, this.bNg.y, f, f, this.mPaint);
            this.mMatrix.reset();
            this.mCamera.save();
            this.mCamera.setLocation(0.0f, 0.0f, -100.0f);
            this.mCamera.rotateY(this.bNn * 90.0f);
            this.mCamera.getMatrix(this.mMatrix);
            this.mCamera.restore();
            this.mMatrix.preTranslate(-this.bNb.x, -this.bNb.y);
            this.mMatrix.postTranslate(this.bNb.x, this.bNb.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(float f) {
        this.bNn = f;
        postInvalidate();
    }

    private void s(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            int abs = (int) ((((1.0d - (Math.abs(this.bNm - 0.5d) * 2.0d)) * 0.3d) + 0.3d) * 255.0d);
            if (this.bLF) {
                abs = (int) ((((1.0d - (Math.abs(this.bNm - 0.5d) * 2.0d)) * 0.2d) + 0.1d) * 255.0d);
            }
            this.mPaint.setAlpha(abs);
            this.mCanvas.drawCircle(this.bNb.x, this.bNb.y, this.bNa, this.mPaint);
            this.mMatrix.reset();
            this.mCamera.save();
            this.mCamera.setLocation(0.0f, 0.0f, -100.0f);
            this.mCamera.rotateY((this.bNm * 360.0f) + 90.0f);
            this.mCamera.getMatrix(this.mMatrix);
            this.mCamera.restore();
            this.mMatrix.preTranslate(-this.bNb.x, -this.bNb.y);
            this.mMatrix.postTranslate(this.bNb.x, this.bNb.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(float f) {
        if (f < 0.2f) {
            this.bNm = (f / 0.2f) * 0.5f;
        } else {
            this.bNm = (((f - 0.2f) / 0.8f) * 0.5f) + 0.5f;
        }
        postInvalidate();
    }

    private void lQ() {
        this.bLF = com.baidu.swan.apps.w.a.Uq().getNightModeSwitcherState();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
        this.bNc = new Paint();
        this.bNc.setAntiAlias(true);
        this.bNc.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.mCamera = new Camera();
        this.mMatrix = new Matrix();
        changeState(1);
    }

    private void changeState(int i) {
        this.mState = i;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            this.mBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            this.mCanvas = new Canvas(this.mBitmap);
        }
    }

    private void abN() {
        if (this.bNo != null) {
            this.bNo.setRepeatCount(0);
            this.bNo.removeAllUpdateListeners();
            this.bNo.removeAllListeners();
            this.bNo.end();
            this.bNo.cancel();
        }
        if (this.bNl != null) {
            this.bNl.setRepeatCount(0);
            this.bNl.removeAllUpdateListeners();
            this.bNl.removeAllListeners();
            this.bNl.end();
            this.bNl.cancel();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        abN();
    }
}
