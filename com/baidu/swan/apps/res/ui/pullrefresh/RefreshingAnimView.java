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
/* loaded from: classes7.dex */
public class RefreshingAnimView extends View {
    private static final double doU = Math.sqrt(2.0d);
    private float bKb;
    private boolean dnE;
    float doV;
    float doW;
    float doX;
    float doY;
    float doZ;
    float dpa;
    float dpb;
    private PointF dpc;
    private Paint dpd;
    private a dpe;
    private RectF dpf;
    private PointF dpg;
    private PointF dph;
    private PointF dpi;
    private float dpj;
    private int dpk;
    private int dpl;
    private ValueAnimator dpm;
    private float dpn;
    private float dpo;
    private ValueAnimator dpp;
    private Bitmap mBitmap;
    private Camera mCamera;
    private Canvas mCanvas;
    private Matrix mMatrix;
    private Paint mPaint;
    private int mState;

    /* loaded from: classes7.dex */
    public interface a {
        void go(boolean z);
    }

    static /* synthetic */ int a(RefreshingAnimView refreshingAnimView) {
        int i = refreshingAnimView.dpl;
        refreshingAnimView.dpl = i + 1;
        return i;
    }

    public RefreshingAnimView(Context context) {
        super(context);
        this.doV = 0.0f;
        this.doW = 0.0f;
        this.doX = 0.0f;
        this.doY = 0.0f;
        this.doZ = 0.0f;
        this.dpa = 0.0f;
        this.dpb = 0.0f;
        this.bKb = 0.0f;
        this.dpc = new PointF();
        this.dpf = new RectF();
        this.dpg = new PointF();
        this.dph = new PointF();
        this.dpi = new PointF();
        this.dpj = 0.0f;
        this.dpk = 0;
        this.dpl = 1;
        this.dpm = null;
        this.dpn = 0.0f;
        this.dpo = 0.0f;
        this.dpp = null;
        this.dnE = false;
        this.mState = 0;
        sw();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.doV = 0.0f;
        this.doW = 0.0f;
        this.doX = 0.0f;
        this.doY = 0.0f;
        this.doZ = 0.0f;
        this.dpa = 0.0f;
        this.dpb = 0.0f;
        this.bKb = 0.0f;
        this.dpc = new PointF();
        this.dpf = new RectF();
        this.dpg = new PointF();
        this.dph = new PointF();
        this.dpi = new PointF();
        this.dpj = 0.0f;
        this.dpk = 0;
        this.dpl = 1;
        this.dpm = null;
        this.dpn = 0.0f;
        this.dpo = 0.0f;
        this.dpp = null;
        this.dnE = false;
        this.mState = 0;
        sw();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.doV = 0.0f;
        this.doW = 0.0f;
        this.doX = 0.0f;
        this.doY = 0.0f;
        this.doZ = 0.0f;
        this.dpa = 0.0f;
        this.dpb = 0.0f;
        this.bKb = 0.0f;
        this.dpc = new PointF();
        this.dpf = new RectF();
        this.dpg = new PointF();
        this.dph = new PointF();
        this.dpi = new PointF();
        this.dpj = 0.0f;
        this.dpk = 0;
        this.dpl = 1;
        this.dpm = null;
        this.dpn = 0.0f;
        this.dpo = 0.0f;
        this.dpp = null;
        this.dnE = false;
        this.mState = 0;
        sw();
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        this.doV = f2 <= 1.0f ? f2 : 1.0f;
        aGf();
        postInvalidate();
    }

    public void aGe() {
        cm(300L);
    }

    private void cm(long j) {
        jL(2);
        if (this.dpp != null) {
            aFQ();
        }
        this.dpp = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.dpp.setDuration(j);
        this.dpp.setInterpolator(new LinearInterpolator());
        this.dpp.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.K(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.dpp.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                RefreshingAnimView.this.cn(750L);
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
        if (!this.dpp.isRunning()) {
            this.dpp.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cn(long j) {
        jL(3);
        if (this.dpm != null) {
            aFQ();
        }
        this.dpm = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.dpm.setDuration(j);
        this.dpm.setInterpolator(new LinearInterpolator());
        this.dpm.setRepeatCount(-1);
        this.dpm.setRepeatMode(1);
        this.dpm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.L(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        if (this.dpk > 0) {
            this.dpm.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.4
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
                    if (RefreshingAnimView.this.dpl > RefreshingAnimView.this.dpk && RefreshingAnimView.this.dpe != null) {
                        RefreshingAnimView.this.dpe.go(true);
                    }
                }
            });
        } else if (this.dpe != null) {
            this.dpe.go(true);
        }
        if (!this.dpm.isRunning()) {
            this.dpm.start();
        }
    }

    public void setAtLeastRotateRounds(int i) {
        this.dpk = i;
    }

    public void setOnLoadingAnimationListener(a aVar) {
        this.dpe = aVar;
    }

    public void stopAnim() {
        aFQ();
        clearAnimation();
        this.doV = 0.0f;
        this.dpl = 1;
        jL(1);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredWidth() > getHeight()) {
            this.bKb = getMeasuredHeight();
        } else {
            this.bKb = getMeasuredWidth();
        }
        this.doY = ah.dip2px(getContext(), 8.0f);
        this.dpa = ah.dip2px(getContext(), 6.5f);
        this.dpj = ah.dip2px(getContext(), 5.0f);
        this.dpb = ah.dip2px(getContext(), 7.5f);
        float f = this.bKb / 2.0f;
        this.dpc.set(f, f);
        float f2 = f + ((float) (this.doY / doU));
        this.dph.set(f2, f2);
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
            if (this.dnE != com.baidu.swan.apps.t.a.awo().getNightModeSwitcherState()) {
                this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
                this.dnE = com.baidu.swan.apps.t.a.awo().getNightModeSwitcherState();
            }
            this.mPaint.setAlpha(76);
            this.dpf.set(this.dpc.x - this.doY, this.dpc.y - this.doY, this.dpc.x + this.doY, this.dpc.y + this.doY);
            this.mCanvas.drawArc(this.dpf, -90.0f, (-360.0f) * this.doW, true, this.mPaint);
            this.mCanvas.drawCircle(this.dpc.x, this.dpc.y, this.doZ, this.dpd);
            if (this.doX > 0.0f) {
                this.mCanvas.drawCircle(this.dpi.x, this.dpi.y, 0.75f, this.mPaint);
                this.mPaint.setStyle(Paint.Style.STROKE);
                this.mPaint.setStrokeWidth(ah.dip2px(getContext(), 1.5f));
                this.mCanvas.drawLine(this.dph.x, this.dph.y, this.dpi.x, this.dpi.y, this.mPaint);
            }
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    private void aGf() {
        this.doW = this.doV;
        if (this.doV < 0.5f) {
            this.doX = 0.0f;
            this.doZ = 0.0f;
            return;
        }
        this.doZ = ((this.doV - 0.5f) / 0.5f) * this.dpa;
        if (this.doV < 0.625f) {
            this.doX = 0.0f;
            return;
        }
        this.doX = (this.doV - 0.625f) / 0.375f;
        this.dpi.set(this.dph.x + ((float) ((this.dpj * this.doX) / doU)), this.dph.y + ((float) ((this.dpj * this.doX) / doU)));
    }

    private void u(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setAlpha((int) (255.0d * ((this.dpo * 0.3d) + 0.3d)));
            float f = this.dph.x + ((float) (this.dpj / doU));
            this.mCanvas.drawCircle(this.dpc.x, this.dpc.y, this.doY, this.mPaint);
            this.mCanvas.drawCircle(this.dpc.x, this.dpc.y, this.dpa, this.dpd);
            this.mCanvas.drawCircle(f, f, 0.75f, this.mPaint);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(ah.dip2px(getContext(), 1.5f));
            this.mCanvas.drawLine(this.dph.x, this.dph.y, f, f, this.mPaint);
            this.mMatrix.reset();
            this.mCamera.save();
            this.mCamera.setLocation(0.0f, 0.0f, -100.0f);
            this.mCamera.rotateY(this.dpo * 90.0f);
            this.mCamera.getMatrix(this.mMatrix);
            this.mCamera.restore();
            this.mMatrix.preTranslate(-this.dpc.x, -this.dpc.y);
            this.mMatrix.postTranslate(this.dpc.x, this.dpc.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(float f) {
        this.dpo = f;
        postInvalidate();
    }

    private void v(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            int abs = (int) ((((1.0d - (Math.abs(this.dpn - 0.5d) * 2.0d)) * 0.3d) + 0.3d) * 255.0d);
            if (this.dnE) {
                abs = (int) ((((1.0d - (Math.abs(this.dpn - 0.5d) * 2.0d)) * 0.2d) + 0.1d) * 255.0d);
            }
            this.mPaint.setAlpha(abs);
            this.mCanvas.drawCircle(this.dpc.x, this.dpc.y, this.dpb, this.mPaint);
            this.mMatrix.reset();
            this.mCamera.save();
            this.mCamera.setLocation(0.0f, 0.0f, -100.0f);
            this.mCamera.rotateY((this.dpn * 360.0f) + 90.0f);
            this.mCamera.getMatrix(this.mMatrix);
            this.mCamera.restore();
            this.mMatrix.preTranslate(-this.dpc.x, -this.dpc.y);
            this.mMatrix.postTranslate(this.dpc.x, this.dpc.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(float f) {
        if (f < 0.2f) {
            this.dpn = (f / 0.2f) * 0.5f;
        } else {
            this.dpn = (((f - 0.2f) / 0.8f) * 0.5f) + 0.5f;
        }
        postInvalidate();
    }

    private void sw() {
        this.dnE = com.baidu.swan.apps.t.a.awo().getNightModeSwitcherState();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
        this.dpd = new Paint();
        this.dpd.setAntiAlias(true);
        this.dpd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.mCamera = new Camera();
        this.mMatrix = new Matrix();
        jL(1);
    }

    private void jL(int i) {
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

    private void aFQ() {
        if (this.dpp != null) {
            this.dpp.setRepeatCount(0);
            this.dpp.removeAllUpdateListeners();
            this.dpp.removeAllListeners();
            this.dpp.end();
            this.dpp.cancel();
        }
        if (this.dpm != null) {
            this.dpm.setRepeatCount(0);
            this.dpm.removeAllUpdateListeners();
            this.dpm.removeAllListeners();
            this.dpm.end();
            this.dpm.cancel();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aFQ();
    }
}
