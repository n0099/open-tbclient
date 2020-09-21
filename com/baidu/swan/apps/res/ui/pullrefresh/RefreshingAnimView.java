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
/* loaded from: classes3.dex */
public class RefreshingAnimView extends View {
    private static final double cPZ = Math.sqrt(2.0d);
    private boolean cOL;
    float cQa;
    float cQb;
    float cQc;
    float cQd;
    float cQe;
    float cQf;
    float cQg;
    private PointF cQh;
    private Paint cQi;
    private a cQj;
    private RectF cQk;
    private PointF cQl;
    private PointF cQm;
    private PointF cQn;
    private float cQo;
    private int cQp;
    private int cQq;
    private ValueAnimator cQr;
    private float cQs;
    private float cQt;
    private ValueAnimator cQu;
    private Bitmap mBitmap;
    private Camera mCamera;
    private Canvas mCanvas;
    private Matrix mMatrix;
    private Paint mPaint;
    private int mState;
    private float mWidth;

    /* loaded from: classes3.dex */
    public interface a {
        void ft(boolean z);
    }

    static /* synthetic */ int a(RefreshingAnimView refreshingAnimView) {
        int i = refreshingAnimView.cQq;
        refreshingAnimView.cQq = i + 1;
        return i;
    }

    public RefreshingAnimView(Context context) {
        super(context);
        this.cQa = 0.0f;
        this.cQb = 0.0f;
        this.cQc = 0.0f;
        this.cQd = 0.0f;
        this.cQe = 0.0f;
        this.cQf = 0.0f;
        this.cQg = 0.0f;
        this.mWidth = 0.0f;
        this.cQh = new PointF();
        this.cQk = new RectF();
        this.cQl = new PointF();
        this.cQm = new PointF();
        this.cQn = new PointF();
        this.cQo = 0.0f;
        this.cQp = 0;
        this.cQq = 1;
        this.cQr = null;
        this.cQs = 0.0f;
        this.cQt = 0.0f;
        this.cQu = null;
        this.cOL = false;
        this.mState = 0;
        sw();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cQa = 0.0f;
        this.cQb = 0.0f;
        this.cQc = 0.0f;
        this.cQd = 0.0f;
        this.cQe = 0.0f;
        this.cQf = 0.0f;
        this.cQg = 0.0f;
        this.mWidth = 0.0f;
        this.cQh = new PointF();
        this.cQk = new RectF();
        this.cQl = new PointF();
        this.cQm = new PointF();
        this.cQn = new PointF();
        this.cQo = 0.0f;
        this.cQp = 0;
        this.cQq = 1;
        this.cQr = null;
        this.cQs = 0.0f;
        this.cQt = 0.0f;
        this.cQu = null;
        this.cOL = false;
        this.mState = 0;
        sw();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cQa = 0.0f;
        this.cQb = 0.0f;
        this.cQc = 0.0f;
        this.cQd = 0.0f;
        this.cQe = 0.0f;
        this.cQf = 0.0f;
        this.cQg = 0.0f;
        this.mWidth = 0.0f;
        this.cQh = new PointF();
        this.cQk = new RectF();
        this.cQl = new PointF();
        this.cQm = new PointF();
        this.cQn = new PointF();
        this.cQo = 0.0f;
        this.cQp = 0;
        this.cQq = 1;
        this.cQr = null;
        this.cQs = 0.0f;
        this.cQt = 0.0f;
        this.cQu = null;
        this.cOL = false;
        this.mState = 0;
        sw();
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        this.cQa = f2 <= 1.0f ? f2 : 1.0f;
        azK();
        postInvalidate();
    }

    public void azJ() {
        bG(300L);
    }

    private void bG(long j) {
        iX(2);
        if (this.cQu != null) {
            azv();
        }
        this.cQu = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.cQu.setDuration(j);
        this.cQu.setInterpolator(new LinearInterpolator());
        this.cQu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.F(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.cQu.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                RefreshingAnimView.this.bH(750L);
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
        if (!this.cQu.isRunning()) {
            this.cQu.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bH(long j) {
        iX(3);
        if (this.cQr != null) {
            azv();
        }
        this.cQr = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.cQr.setDuration(j);
        this.cQr.setInterpolator(new LinearInterpolator());
        this.cQr.setRepeatCount(-1);
        this.cQr.setRepeatMode(1);
        this.cQr.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.G(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        if (this.cQp > 0) {
            this.cQr.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.4
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
                    if (RefreshingAnimView.this.cQq > RefreshingAnimView.this.cQp && RefreshingAnimView.this.cQj != null) {
                        RefreshingAnimView.this.cQj.ft(true);
                    }
                }
            });
        } else if (this.cQj != null) {
            this.cQj.ft(true);
        }
        if (!this.cQr.isRunning()) {
            this.cQr.start();
        }
    }

    public void setAtLeastRotateRounds(int i) {
        this.cQp = i;
    }

    public void setOnLoadingAnimationListener(a aVar) {
        this.cQj = aVar;
    }

    public void stopAnim() {
        azv();
        clearAnimation();
        this.cQa = 0.0f;
        this.cQq = 1;
        iX(1);
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
        this.cQd = ah.dip2px(getContext(), 8.0f);
        this.cQf = ah.dip2px(getContext(), 6.5f);
        this.cQo = ah.dip2px(getContext(), 5.0f);
        this.cQg = ah.dip2px(getContext(), 7.5f);
        float f = this.mWidth / 2.0f;
        this.cQh.set(f, f);
        float f2 = f + ((float) (this.cQd / cPZ));
        this.cQm.set(f2, f2);
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
            if (this.cOL != com.baidu.swan.apps.t.a.apQ().getNightModeSwitcherState()) {
                this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
                this.cOL = com.baidu.swan.apps.t.a.apQ().getNightModeSwitcherState();
            }
            this.mPaint.setAlpha(76);
            this.cQk.set(this.cQh.x - this.cQd, this.cQh.y - this.cQd, this.cQh.x + this.cQd, this.cQh.y + this.cQd);
            this.mCanvas.drawArc(this.cQk, -90.0f, (-360.0f) * this.cQb, true, this.mPaint);
            this.mCanvas.drawCircle(this.cQh.x, this.cQh.y, this.cQe, this.cQi);
            if (this.cQc > 0.0f) {
                this.mCanvas.drawCircle(this.cQn.x, this.cQn.y, 0.75f, this.mPaint);
                this.mPaint.setStyle(Paint.Style.STROKE);
                this.mPaint.setStrokeWidth(ah.dip2px(getContext(), 1.5f));
                this.mCanvas.drawLine(this.cQm.x, this.cQm.y, this.cQn.x, this.cQn.y, this.mPaint);
            }
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    private void azK() {
        this.cQb = this.cQa;
        if (this.cQa < 0.5f) {
            this.cQc = 0.0f;
            this.cQe = 0.0f;
            return;
        }
        this.cQe = ((this.cQa - 0.5f) / 0.5f) * this.cQf;
        if (this.cQa < 0.625f) {
            this.cQc = 0.0f;
            return;
        }
        this.cQc = (this.cQa - 0.625f) / 0.375f;
        this.cQn.set(this.cQm.x + ((float) ((this.cQo * this.cQc) / cPZ)), this.cQm.y + ((float) ((this.cQo * this.cQc) / cPZ)));
    }

    private void u(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setAlpha((int) (255.0d * ((this.cQt * 0.3d) + 0.3d)));
            float f = this.cQm.x + ((float) (this.cQo / cPZ));
            this.mCanvas.drawCircle(this.cQh.x, this.cQh.y, this.cQd, this.mPaint);
            this.mCanvas.drawCircle(this.cQh.x, this.cQh.y, this.cQf, this.cQi);
            this.mCanvas.drawCircle(f, f, 0.75f, this.mPaint);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(ah.dip2px(getContext(), 1.5f));
            this.mCanvas.drawLine(this.cQm.x, this.cQm.y, f, f, this.mPaint);
            this.mMatrix.reset();
            this.mCamera.save();
            this.mCamera.setLocation(0.0f, 0.0f, -100.0f);
            this.mCamera.rotateY(this.cQt * 90.0f);
            this.mCamera.getMatrix(this.mMatrix);
            this.mCamera.restore();
            this.mMatrix.preTranslate(-this.cQh.x, -this.cQh.y);
            this.mMatrix.postTranslate(this.cQh.x, this.cQh.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(float f) {
        this.cQt = f;
        postInvalidate();
    }

    private void v(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            int abs = (int) ((((1.0d - (Math.abs(this.cQs - 0.5d) * 2.0d)) * 0.3d) + 0.3d) * 255.0d);
            if (this.cOL) {
                abs = (int) ((((1.0d - (Math.abs(this.cQs - 0.5d) * 2.0d)) * 0.2d) + 0.1d) * 255.0d);
            }
            this.mPaint.setAlpha(abs);
            this.mCanvas.drawCircle(this.cQh.x, this.cQh.y, this.cQg, this.mPaint);
            this.mMatrix.reset();
            this.mCamera.save();
            this.mCamera.setLocation(0.0f, 0.0f, -100.0f);
            this.mCamera.rotateY((this.cQs * 360.0f) + 90.0f);
            this.mCamera.getMatrix(this.mMatrix);
            this.mCamera.restore();
            this.mMatrix.preTranslate(-this.cQh.x, -this.cQh.y);
            this.mMatrix.postTranslate(this.cQh.x, this.cQh.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(float f) {
        if (f < 0.2f) {
            this.cQs = (f / 0.2f) * 0.5f;
        } else {
            this.cQs = (((f - 0.2f) / 0.8f) * 0.5f) + 0.5f;
        }
        postInvalidate();
    }

    private void sw() {
        this.cOL = com.baidu.swan.apps.t.a.apQ().getNightModeSwitcherState();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
        this.cQi = new Paint();
        this.cQi.setAntiAlias(true);
        this.cQi.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.mCamera = new Camera();
        this.mMatrix = new Matrix();
        iX(1);
    }

    private void iX(int i) {
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

    private void azv() {
        if (this.cQu != null) {
            this.cQu.setRepeatCount(0);
            this.cQu.removeAllUpdateListeners();
            this.cQu.removeAllListeners();
            this.cQu.end();
            this.cQu.cancel();
        }
        if (this.cQr != null) {
            this.cQr.setRepeatCount(0);
            this.cQr.removeAllUpdateListeners();
            this.cQr.removeAllListeners();
            this.cQr.end();
            this.cQr.cancel();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        azv();
    }
}
