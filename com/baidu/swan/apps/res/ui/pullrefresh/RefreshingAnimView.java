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
import com.baidu.swan.apps.ap.ah;
/* loaded from: classes8.dex */
public class RefreshingAnimView extends View {
    private static final double cNV = Math.sqrt(2.0d);
    private boolean cMH;
    float cNW;
    float cNX;
    float cNY;
    float cNZ;
    float cOa;
    float cOb;
    float cOc;
    private PointF cOd;
    private Paint cOe;
    private a cOf;
    private RectF cOg;
    private PointF cOh;
    private PointF cOi;
    private PointF cOj;
    private float cOk;
    private int cOl;
    private int cOm;
    private ValueAnimator cOn;
    private float cOo;
    private float cOp;
    private ValueAnimator cOq;
    private Bitmap mBitmap;
    private Camera mCamera;
    private Canvas mCanvas;
    private Matrix mMatrix;
    private Paint mPaint;
    private int mState;
    private float mWidth;

    /* loaded from: classes8.dex */
    public interface a {
        void fu(boolean z);
    }

    static /* synthetic */ int a(RefreshingAnimView refreshingAnimView) {
        int i = refreshingAnimView.cOm;
        refreshingAnimView.cOm = i + 1;
        return i;
    }

    public RefreshingAnimView(Context context) {
        super(context);
        this.cNW = 0.0f;
        this.cNX = 0.0f;
        this.cNY = 0.0f;
        this.cNZ = 0.0f;
        this.cOa = 0.0f;
        this.cOb = 0.0f;
        this.cOc = 0.0f;
        this.mWidth = 0.0f;
        this.cOd = new PointF();
        this.cOg = new RectF();
        this.cOh = new PointF();
        this.cOi = new PointF();
        this.cOj = new PointF();
        this.cOk = 0.0f;
        this.cOl = 0;
        this.cOm = 1;
        this.cOn = null;
        this.cOo = 0.0f;
        this.cOp = 0.0f;
        this.cOq = null;
        this.cMH = false;
        this.mState = 0;
        sr();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cNW = 0.0f;
        this.cNX = 0.0f;
        this.cNY = 0.0f;
        this.cNZ = 0.0f;
        this.cOa = 0.0f;
        this.cOb = 0.0f;
        this.cOc = 0.0f;
        this.mWidth = 0.0f;
        this.cOd = new PointF();
        this.cOg = new RectF();
        this.cOh = new PointF();
        this.cOi = new PointF();
        this.cOj = new PointF();
        this.cOk = 0.0f;
        this.cOl = 0;
        this.cOm = 1;
        this.cOn = null;
        this.cOo = 0.0f;
        this.cOp = 0.0f;
        this.cOq = null;
        this.cMH = false;
        this.mState = 0;
        sr();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cNW = 0.0f;
        this.cNX = 0.0f;
        this.cNY = 0.0f;
        this.cNZ = 0.0f;
        this.cOa = 0.0f;
        this.cOb = 0.0f;
        this.cOc = 0.0f;
        this.mWidth = 0.0f;
        this.cOd = new PointF();
        this.cOg = new RectF();
        this.cOh = new PointF();
        this.cOi = new PointF();
        this.cOj = new PointF();
        this.cOk = 0.0f;
        this.cOl = 0;
        this.cOm = 1;
        this.cOn = null;
        this.cOo = 0.0f;
        this.cOp = 0.0f;
        this.cOq = null;
        this.cMH = false;
        this.mState = 0;
        sr();
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        this.cNW = f2 <= 1.0f ? f2 : 1.0f;
        azb();
        postInvalidate();
    }

    public void aza() {
        bF(300L);
    }

    private void bF(long j) {
        changeState(2);
        if (this.cOq != null) {
            ayM();
        }
        this.cOq = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.cOq.setDuration(j);
        this.cOq.setInterpolator(new LinearInterpolator());
        this.cOq.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.F(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.cOq.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                RefreshingAnimView.this.bG(750L);
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
        if (!this.cOq.isRunning()) {
            this.cOq.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bG(long j) {
        changeState(3);
        if (this.cOn != null) {
            ayM();
        }
        this.cOn = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.cOn.setDuration(j);
        this.cOn.setInterpolator(new LinearInterpolator());
        this.cOn.setRepeatCount(-1);
        this.cOn.setRepeatMode(1);
        this.cOn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.G(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        if (this.cOl > 0) {
            this.cOn.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.4
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
                    if (RefreshingAnimView.this.cOm > RefreshingAnimView.this.cOl && RefreshingAnimView.this.cOf != null) {
                        RefreshingAnimView.this.cOf.fu(true);
                    }
                }
            });
        } else if (this.cOf != null) {
            this.cOf.fu(true);
        }
        if (!this.cOn.isRunning()) {
            this.cOn.start();
        }
    }

    public void setAtLeastRotateRounds(int i) {
        this.cOl = i;
    }

    public void setOnLoadingAnimationListener(a aVar) {
        this.cOf = aVar;
    }

    public void stopAnim() {
        ayM();
        clearAnimation();
        this.cNW = 0.0f;
        this.cOm = 1;
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
        this.cNZ = ah.dip2px(getContext(), 8.0f);
        this.cOb = ah.dip2px(getContext(), 6.5f);
        this.cOk = ah.dip2px(getContext(), 5.0f);
        this.cOc = ah.dip2px(getContext(), 7.5f);
        float f = this.mWidth / 2.0f;
        this.cOd.set(f, f);
        float f2 = f + ((float) (this.cNZ / cNV));
        this.cOi.set(f2, f2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        switch (this.mState) {
            case 1:
                t(canvas);
                break;
            case 2:
                u(canvas);
                break;
            case 3:
                v(canvas);
                break;
        }
        canvas.restore();
    }

    private void t(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            if (this.cMH != com.baidu.swan.apps.t.a.apf().getNightModeSwitcherState()) {
                this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
                this.cMH = com.baidu.swan.apps.t.a.apf().getNightModeSwitcherState();
            }
            this.mPaint.setAlpha(76);
            this.cOg.set(this.cOd.x - this.cNZ, this.cOd.y - this.cNZ, this.cOd.x + this.cNZ, this.cOd.y + this.cNZ);
            this.mCanvas.drawArc(this.cOg, -90.0f, (-360.0f) * this.cNX, true, this.mPaint);
            this.mCanvas.drawCircle(this.cOd.x, this.cOd.y, this.cOa, this.cOe);
            if (this.cNY > 0.0f) {
                this.mCanvas.drawCircle(this.cOj.x, this.cOj.y, 0.75f, this.mPaint);
                this.mPaint.setStyle(Paint.Style.STROKE);
                this.mPaint.setStrokeWidth(ah.dip2px(getContext(), 1.5f));
                this.mCanvas.drawLine(this.cOi.x, this.cOi.y, this.cOj.x, this.cOj.y, this.mPaint);
            }
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    private void azb() {
        this.cNX = this.cNW;
        if (this.cNW < 0.5f) {
            this.cNY = 0.0f;
            this.cOa = 0.0f;
            return;
        }
        this.cOa = ((this.cNW - 0.5f) / 0.5f) * this.cOb;
        if (this.cNW < 0.625f) {
            this.cNY = 0.0f;
            return;
        }
        this.cNY = (this.cNW - 0.625f) / 0.375f;
        this.cOj.set(this.cOi.x + ((float) ((this.cOk * this.cNY) / cNV)), this.cOi.y + ((float) ((this.cOk * this.cNY) / cNV)));
    }

    private void u(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setAlpha((int) (255.0d * ((this.cOp * 0.3d) + 0.3d)));
            float f = this.cOi.x + ((float) (this.cOk / cNV));
            this.mCanvas.drawCircle(this.cOd.x, this.cOd.y, this.cNZ, this.mPaint);
            this.mCanvas.drawCircle(this.cOd.x, this.cOd.y, this.cOb, this.cOe);
            this.mCanvas.drawCircle(f, f, 0.75f, this.mPaint);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(ah.dip2px(getContext(), 1.5f));
            this.mCanvas.drawLine(this.cOi.x, this.cOi.y, f, f, this.mPaint);
            this.mMatrix.reset();
            this.mCamera.save();
            this.mCamera.setLocation(0.0f, 0.0f, -100.0f);
            this.mCamera.rotateY(this.cOp * 90.0f);
            this.mCamera.getMatrix(this.mMatrix);
            this.mCamera.restore();
            this.mMatrix.preTranslate(-this.cOd.x, -this.cOd.y);
            this.mMatrix.postTranslate(this.cOd.x, this.cOd.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(float f) {
        this.cOp = f;
        postInvalidate();
    }

    private void v(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            int abs = (int) ((((1.0d - (Math.abs(this.cOo - 0.5d) * 2.0d)) * 0.3d) + 0.3d) * 255.0d);
            if (this.cMH) {
                abs = (int) ((((1.0d - (Math.abs(this.cOo - 0.5d) * 2.0d)) * 0.2d) + 0.1d) * 255.0d);
            }
            this.mPaint.setAlpha(abs);
            this.mCanvas.drawCircle(this.cOd.x, this.cOd.y, this.cOc, this.mPaint);
            this.mMatrix.reset();
            this.mCamera.save();
            this.mCamera.setLocation(0.0f, 0.0f, -100.0f);
            this.mCamera.rotateY((this.cOo * 360.0f) + 90.0f);
            this.mCamera.getMatrix(this.mMatrix);
            this.mCamera.restore();
            this.mMatrix.preTranslate(-this.cOd.x, -this.cOd.y);
            this.mMatrix.postTranslate(this.cOd.x, this.cOd.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(float f) {
        if (f < 0.2f) {
            this.cOo = (f / 0.2f) * 0.5f;
        } else {
            this.cOo = (((f - 0.2f) / 0.8f) * 0.5f) + 0.5f;
        }
        postInvalidate();
    }

    private void sr() {
        this.cMH = com.baidu.swan.apps.t.a.apf().getNightModeSwitcherState();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
        this.cOe = new Paint();
        this.cOe.setAntiAlias(true);
        this.cOe.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
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

    private void ayM() {
        if (this.cOq != null) {
            this.cOq.setRepeatCount(0);
            this.cOq.removeAllUpdateListeners();
            this.cOq.removeAllListeners();
            this.cOq.end();
            this.cOq.cancel();
        }
        if (this.cOn != null) {
            this.cOn.setRepeatCount(0);
            this.cOn.removeAllUpdateListeners();
            this.cOn.removeAllListeners();
            this.cOn.end();
            this.cOn.cancel();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ayM();
    }
}
