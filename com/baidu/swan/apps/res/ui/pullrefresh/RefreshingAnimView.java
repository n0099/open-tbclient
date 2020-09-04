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
    private static final double cNZ = Math.sqrt(2.0d);
    private boolean cML;
    float cOa;
    float cOb;
    float cOc;
    float cOd;
    float cOe;
    float cOf;
    float cOg;
    private PointF cOh;
    private Paint cOi;
    private a cOj;
    private RectF cOk;
    private PointF cOl;
    private PointF cOm;
    private PointF cOn;
    private float cOo;
    private int cOp;
    private int cOq;
    private ValueAnimator cOr;
    private float cOs;
    private float cOt;
    private ValueAnimator cOu;
    private Bitmap mBitmap;
    private Camera mCamera;
    private Canvas mCanvas;
    private Matrix mMatrix;
    private Paint mPaint;
    private int mState;
    private float mWidth;

    /* loaded from: classes8.dex */
    public interface a {
        void fv(boolean z);
    }

    static /* synthetic */ int a(RefreshingAnimView refreshingAnimView) {
        int i = refreshingAnimView.cOq;
        refreshingAnimView.cOq = i + 1;
        return i;
    }

    public RefreshingAnimView(Context context) {
        super(context);
        this.cOa = 0.0f;
        this.cOb = 0.0f;
        this.cOc = 0.0f;
        this.cOd = 0.0f;
        this.cOe = 0.0f;
        this.cOf = 0.0f;
        this.cOg = 0.0f;
        this.mWidth = 0.0f;
        this.cOh = new PointF();
        this.cOk = new RectF();
        this.cOl = new PointF();
        this.cOm = new PointF();
        this.cOn = new PointF();
        this.cOo = 0.0f;
        this.cOp = 0;
        this.cOq = 1;
        this.cOr = null;
        this.cOs = 0.0f;
        this.cOt = 0.0f;
        this.cOu = null;
        this.cML = false;
        this.mState = 0;
        sr();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cOa = 0.0f;
        this.cOb = 0.0f;
        this.cOc = 0.0f;
        this.cOd = 0.0f;
        this.cOe = 0.0f;
        this.cOf = 0.0f;
        this.cOg = 0.0f;
        this.mWidth = 0.0f;
        this.cOh = new PointF();
        this.cOk = new RectF();
        this.cOl = new PointF();
        this.cOm = new PointF();
        this.cOn = new PointF();
        this.cOo = 0.0f;
        this.cOp = 0;
        this.cOq = 1;
        this.cOr = null;
        this.cOs = 0.0f;
        this.cOt = 0.0f;
        this.cOu = null;
        this.cML = false;
        this.mState = 0;
        sr();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cOa = 0.0f;
        this.cOb = 0.0f;
        this.cOc = 0.0f;
        this.cOd = 0.0f;
        this.cOe = 0.0f;
        this.cOf = 0.0f;
        this.cOg = 0.0f;
        this.mWidth = 0.0f;
        this.cOh = new PointF();
        this.cOk = new RectF();
        this.cOl = new PointF();
        this.cOm = new PointF();
        this.cOn = new PointF();
        this.cOo = 0.0f;
        this.cOp = 0;
        this.cOq = 1;
        this.cOr = null;
        this.cOs = 0.0f;
        this.cOt = 0.0f;
        this.cOu = null;
        this.cML = false;
        this.mState = 0;
        sr();
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        this.cOa = f2 <= 1.0f ? f2 : 1.0f;
        azb();
        postInvalidate();
    }

    public void aza() {
        bF(300L);
    }

    private void bF(long j) {
        changeState(2);
        if (this.cOu != null) {
            ayM();
        }
        this.cOu = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.cOu.setDuration(j);
        this.cOu.setInterpolator(new LinearInterpolator());
        this.cOu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.F(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.cOu.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.2
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
        if (!this.cOu.isRunning()) {
            this.cOu.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bG(long j) {
        changeState(3);
        if (this.cOr != null) {
            ayM();
        }
        this.cOr = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.cOr.setDuration(j);
        this.cOr.setInterpolator(new LinearInterpolator());
        this.cOr.setRepeatCount(-1);
        this.cOr.setRepeatMode(1);
        this.cOr.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.G(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        if (this.cOp > 0) {
            this.cOr.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.4
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
                    if (RefreshingAnimView.this.cOq > RefreshingAnimView.this.cOp && RefreshingAnimView.this.cOj != null) {
                        RefreshingAnimView.this.cOj.fv(true);
                    }
                }
            });
        } else if (this.cOj != null) {
            this.cOj.fv(true);
        }
        if (!this.cOr.isRunning()) {
            this.cOr.start();
        }
    }

    public void setAtLeastRotateRounds(int i) {
        this.cOp = i;
    }

    public void setOnLoadingAnimationListener(a aVar) {
        this.cOj = aVar;
    }

    public void stopAnim() {
        ayM();
        clearAnimation();
        this.cOa = 0.0f;
        this.cOq = 1;
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
        this.cOd = ah.dip2px(getContext(), 8.0f);
        this.cOf = ah.dip2px(getContext(), 6.5f);
        this.cOo = ah.dip2px(getContext(), 5.0f);
        this.cOg = ah.dip2px(getContext(), 7.5f);
        float f = this.mWidth / 2.0f;
        this.cOh.set(f, f);
        float f2 = f + ((float) (this.cOd / cNZ));
        this.cOm.set(f2, f2);
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
            if (this.cML != com.baidu.swan.apps.t.a.apf().getNightModeSwitcherState()) {
                this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
                this.cML = com.baidu.swan.apps.t.a.apf().getNightModeSwitcherState();
            }
            this.mPaint.setAlpha(76);
            this.cOk.set(this.cOh.x - this.cOd, this.cOh.y - this.cOd, this.cOh.x + this.cOd, this.cOh.y + this.cOd);
            this.mCanvas.drawArc(this.cOk, -90.0f, (-360.0f) * this.cOb, true, this.mPaint);
            this.mCanvas.drawCircle(this.cOh.x, this.cOh.y, this.cOe, this.cOi);
            if (this.cOc > 0.0f) {
                this.mCanvas.drawCircle(this.cOn.x, this.cOn.y, 0.75f, this.mPaint);
                this.mPaint.setStyle(Paint.Style.STROKE);
                this.mPaint.setStrokeWidth(ah.dip2px(getContext(), 1.5f));
                this.mCanvas.drawLine(this.cOm.x, this.cOm.y, this.cOn.x, this.cOn.y, this.mPaint);
            }
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    private void azb() {
        this.cOb = this.cOa;
        if (this.cOa < 0.5f) {
            this.cOc = 0.0f;
            this.cOe = 0.0f;
            return;
        }
        this.cOe = ((this.cOa - 0.5f) / 0.5f) * this.cOf;
        if (this.cOa < 0.625f) {
            this.cOc = 0.0f;
            return;
        }
        this.cOc = (this.cOa - 0.625f) / 0.375f;
        this.cOn.set(this.cOm.x + ((float) ((this.cOo * this.cOc) / cNZ)), this.cOm.y + ((float) ((this.cOo * this.cOc) / cNZ)));
    }

    private void u(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setAlpha((int) (255.0d * ((this.cOt * 0.3d) + 0.3d)));
            float f = this.cOm.x + ((float) (this.cOo / cNZ));
            this.mCanvas.drawCircle(this.cOh.x, this.cOh.y, this.cOd, this.mPaint);
            this.mCanvas.drawCircle(this.cOh.x, this.cOh.y, this.cOf, this.cOi);
            this.mCanvas.drawCircle(f, f, 0.75f, this.mPaint);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(ah.dip2px(getContext(), 1.5f));
            this.mCanvas.drawLine(this.cOm.x, this.cOm.y, f, f, this.mPaint);
            this.mMatrix.reset();
            this.mCamera.save();
            this.mCamera.setLocation(0.0f, 0.0f, -100.0f);
            this.mCamera.rotateY(this.cOt * 90.0f);
            this.mCamera.getMatrix(this.mMatrix);
            this.mCamera.restore();
            this.mMatrix.preTranslate(-this.cOh.x, -this.cOh.y);
            this.mMatrix.postTranslate(this.cOh.x, this.cOh.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(float f) {
        this.cOt = f;
        postInvalidate();
    }

    private void v(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            int abs = (int) ((((1.0d - (Math.abs(this.cOs - 0.5d) * 2.0d)) * 0.3d) + 0.3d) * 255.0d);
            if (this.cML) {
                abs = (int) ((((1.0d - (Math.abs(this.cOs - 0.5d) * 2.0d)) * 0.2d) + 0.1d) * 255.0d);
            }
            this.mPaint.setAlpha(abs);
            this.mCanvas.drawCircle(this.cOh.x, this.cOh.y, this.cOg, this.mPaint);
            this.mMatrix.reset();
            this.mCamera.save();
            this.mCamera.setLocation(0.0f, 0.0f, -100.0f);
            this.mCamera.rotateY((this.cOs * 360.0f) + 90.0f);
            this.mCamera.getMatrix(this.mMatrix);
            this.mCamera.restore();
            this.mMatrix.preTranslate(-this.cOh.x, -this.cOh.y);
            this.mMatrix.postTranslate(this.cOh.x, this.cOh.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(float f) {
        if (f < 0.2f) {
            this.cOs = (f / 0.2f) * 0.5f;
        } else {
            this.cOs = (((f - 0.2f) / 0.8f) * 0.5f) + 0.5f;
        }
        postInvalidate();
    }

    private void sr() {
        this.cML = com.baidu.swan.apps.t.a.apf().getNightModeSwitcherState();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
        this.cOi = new Paint();
        this.cOi.setAntiAlias(true);
        this.cOi.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
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
        if (this.cOu != null) {
            this.cOu.setRepeatCount(0);
            this.cOu.removeAllUpdateListeners();
            this.cOu.removeAllListeners();
            this.cOu.end();
            this.cOu.cancel();
        }
        if (this.cOr != null) {
            this.cOr.setRepeatCount(0);
            this.cOr.removeAllUpdateListeners();
            this.cOr.removeAllListeners();
            this.cOr.end();
            this.cOr.cancel();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ayM();
    }
}
