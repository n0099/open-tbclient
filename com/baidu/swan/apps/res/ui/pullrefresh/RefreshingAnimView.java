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
import com.baidu.swan.apps.ao.ah;
/* loaded from: classes9.dex */
public class RefreshingAnimView extends View {
    private static final double dCe = Math.sqrt(2.0d);
    private float bUn;
    private boolean dAP;
    private Camera dAR;
    float dCf;
    float dCg;
    float dCh;
    float dCi;
    float dCj;
    float dCk;
    float dCl;
    private PointF dCm;
    private Paint dCn;
    private a dCo;
    private RectF dCp;
    private PointF dCq;
    private PointF dCr;
    private PointF dCs;
    private float dCt;
    private int dCu;
    private int dCv;
    private ValueAnimator dCw;
    private float dCx;
    private float dCy;
    private ValueAnimator dCz;
    private Bitmap mBitmap;
    private Canvas mCanvas;
    private Matrix mMatrix;
    private Paint mPaint;
    private int mState;

    /* loaded from: classes9.dex */
    public interface a {
        void gM(boolean z);
    }

    static /* synthetic */ int a(RefreshingAnimView refreshingAnimView) {
        int i = refreshingAnimView.dCv;
        refreshingAnimView.dCv = i + 1;
        return i;
    }

    public RefreshingAnimView(Context context) {
        super(context);
        this.dCf = 0.0f;
        this.dCg = 0.0f;
        this.dCh = 0.0f;
        this.dCi = 0.0f;
        this.dCj = 0.0f;
        this.dCk = 0.0f;
        this.dCl = 0.0f;
        this.bUn = 0.0f;
        this.dCm = new PointF();
        this.dCp = new RectF();
        this.dCq = new PointF();
        this.dCr = new PointF();
        this.dCs = new PointF();
        this.dCt = 0.0f;
        this.dCu = 0;
        this.dCv = 1;
        this.dCw = null;
        this.dCx = 0.0f;
        this.dCy = 0.0f;
        this.dCz = null;
        this.dAP = false;
        this.mState = 0;
        sa();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dCf = 0.0f;
        this.dCg = 0.0f;
        this.dCh = 0.0f;
        this.dCi = 0.0f;
        this.dCj = 0.0f;
        this.dCk = 0.0f;
        this.dCl = 0.0f;
        this.bUn = 0.0f;
        this.dCm = new PointF();
        this.dCp = new RectF();
        this.dCq = new PointF();
        this.dCr = new PointF();
        this.dCs = new PointF();
        this.dCt = 0.0f;
        this.dCu = 0;
        this.dCv = 1;
        this.dCw = null;
        this.dCx = 0.0f;
        this.dCy = 0.0f;
        this.dCz = null;
        this.dAP = false;
        this.mState = 0;
        sa();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dCf = 0.0f;
        this.dCg = 0.0f;
        this.dCh = 0.0f;
        this.dCi = 0.0f;
        this.dCj = 0.0f;
        this.dCk = 0.0f;
        this.dCl = 0.0f;
        this.bUn = 0.0f;
        this.dCm = new PointF();
        this.dCp = new RectF();
        this.dCq = new PointF();
        this.dCr = new PointF();
        this.dCs = new PointF();
        this.dCt = 0.0f;
        this.dCu = 0;
        this.dCv = 1;
        this.dCw = null;
        this.dCx = 0.0f;
        this.dCy = 0.0f;
        this.dCz = null;
        this.dAP = false;
        this.mState = 0;
        sa();
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        this.dCf = f2 <= 1.0f ? f2 : 1.0f;
        aKX();
        postInvalidate();
    }

    public void aKW() {
        cM(300L);
    }

    private void cM(long j) {
        ki(2);
        if (this.dCz != null) {
            aKI();
        }
        this.dCz = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.dCz.setDuration(j);
        this.dCz.setInterpolator(new LinearInterpolator());
        this.dCz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.K(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.dCz.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                RefreshingAnimView.this.cN(750L);
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
        if (!this.dCz.isRunning()) {
            this.dCz.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cN(long j) {
        ki(3);
        if (this.dCw != null) {
            aKI();
        }
        this.dCw = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.dCw.setDuration(j);
        this.dCw.setInterpolator(new LinearInterpolator());
        this.dCw.setRepeatCount(-1);
        this.dCw.setRepeatMode(1);
        this.dCw.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.L(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        if (this.dCu > 0) {
            this.dCw.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.4
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
                    if (RefreshingAnimView.this.dCv > RefreshingAnimView.this.dCu && RefreshingAnimView.this.dCo != null) {
                        RefreshingAnimView.this.dCo.gM(true);
                    }
                }
            });
        } else if (this.dCo != null) {
            this.dCo.gM(true);
        }
        if (!this.dCw.isRunning()) {
            this.dCw.start();
        }
    }

    public void setAtLeastRotateRounds(int i) {
        this.dCu = i;
    }

    public void setOnLoadingAnimationListener(a aVar) {
        this.dCo = aVar;
    }

    public void stopAnim() {
        aKI();
        clearAnimation();
        this.dCf = 0.0f;
        this.dCv = 1;
        ki(1);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredWidth() > getHeight()) {
            this.bUn = getMeasuredHeight();
        } else {
            this.bUn = getMeasuredWidth();
        }
        this.dCi = ah.dip2px(getContext(), 8.0f);
        this.dCk = ah.dip2px(getContext(), 6.5f);
        this.dCt = ah.dip2px(getContext(), 5.0f);
        this.dCl = ah.dip2px(getContext(), 7.5f);
        float f = this.bUn / 2.0f;
        this.dCm.set(f, f);
        float f2 = f + ((float) (this.dCi / dCe));
        this.dCr.set(f2, f2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        switch (this.mState) {
            case 1:
                A(canvas);
                break;
            case 2:
                B(canvas);
                break;
            case 3:
                C(canvas);
                break;
        }
        canvas.restore();
    }

    private void A(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            if (this.dAP != com.baidu.swan.apps.t.a.aAN().alD()) {
                this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
                this.dAP = com.baidu.swan.apps.t.a.aAN().alD();
            }
            this.mPaint.setAlpha(76);
            this.dCp.set(this.dCm.x - this.dCi, this.dCm.y - this.dCi, this.dCm.x + this.dCi, this.dCm.y + this.dCi);
            this.mCanvas.drawArc(this.dCp, -90.0f, (-360.0f) * this.dCg, true, this.mPaint);
            this.mCanvas.drawCircle(this.dCm.x, this.dCm.y, this.dCj, this.dCn);
            if (this.dCh > 0.0f) {
                this.mCanvas.drawCircle(this.dCs.x, this.dCs.y, 0.75f, this.mPaint);
                this.mPaint.setStyle(Paint.Style.STROKE);
                this.mPaint.setStrokeWidth(ah.dip2px(getContext(), 1.5f));
                this.mCanvas.drawLine(this.dCr.x, this.dCr.y, this.dCs.x, this.dCs.y, this.mPaint);
            }
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    private void aKX() {
        this.dCg = this.dCf;
        if (this.dCf < 0.5f) {
            this.dCh = 0.0f;
            this.dCj = 0.0f;
            return;
        }
        this.dCj = ((this.dCf - 0.5f) / 0.5f) * this.dCk;
        if (this.dCf < 0.625f) {
            this.dCh = 0.0f;
            return;
        }
        this.dCh = (this.dCf - 0.625f) / 0.375f;
        this.dCs.set(this.dCr.x + ((float) ((this.dCt * this.dCh) / dCe)), this.dCr.y + ((float) ((this.dCt * this.dCh) / dCe)));
    }

    private void B(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setAlpha((int) (255.0d * ((this.dCy * 0.3d) + 0.3d)));
            float f = this.dCr.x + ((float) (this.dCt / dCe));
            this.mCanvas.drawCircle(this.dCm.x, this.dCm.y, this.dCi, this.mPaint);
            this.mCanvas.drawCircle(this.dCm.x, this.dCm.y, this.dCk, this.dCn);
            this.mCanvas.drawCircle(f, f, 0.75f, this.mPaint);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(ah.dip2px(getContext(), 1.5f));
            this.mCanvas.drawLine(this.dCr.x, this.dCr.y, f, f, this.mPaint);
            this.mMatrix.reset();
            this.dAR.save();
            this.dAR.setLocation(0.0f, 0.0f, -100.0f);
            this.dAR.rotateY(this.dCy * 90.0f);
            this.dAR.getMatrix(this.mMatrix);
            this.dAR.restore();
            this.mMatrix.preTranslate(-this.dCm.x, -this.dCm.y);
            this.mMatrix.postTranslate(this.dCm.x, this.dCm.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(float f) {
        this.dCy = f;
        postInvalidate();
    }

    private void C(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            int abs = (int) ((((1.0d - (Math.abs(this.dCx - 0.5d) * 2.0d)) * 0.3d) + 0.3d) * 255.0d);
            if (this.dAP) {
                abs = (int) ((((1.0d - (Math.abs(this.dCx - 0.5d) * 2.0d)) * 0.2d) + 0.1d) * 255.0d);
            }
            this.mPaint.setAlpha(abs);
            this.mCanvas.drawCircle(this.dCm.x, this.dCm.y, this.dCl, this.mPaint);
            this.mMatrix.reset();
            this.dAR.save();
            this.dAR.setLocation(0.0f, 0.0f, -100.0f);
            this.dAR.rotateY((this.dCx * 360.0f) + 90.0f);
            this.dAR.getMatrix(this.mMatrix);
            this.dAR.restore();
            this.mMatrix.preTranslate(-this.dCm.x, -this.dCm.y);
            this.mMatrix.postTranslate(this.dCm.x, this.dCm.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(float f) {
        if (f < 0.2f) {
            this.dCx = (f / 0.2f) * 0.5f;
        } else {
            this.dCx = (((f - 0.2f) / 0.8f) * 0.5f) + 0.5f;
        }
        postInvalidate();
    }

    private void sa() {
        this.dAP = com.baidu.swan.apps.t.a.aAN().alD();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
        this.dCn = new Paint();
        this.dCn.setAntiAlias(true);
        this.dCn.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.dAR = new Camera();
        this.mMatrix = new Matrix();
        ki(1);
    }

    private void ki(int i) {
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

    private void aKI() {
        if (this.dCz != null) {
            this.dCz.setRepeatCount(0);
            this.dCz.removeAllUpdateListeners();
            this.dCz.removeAllListeners();
            this.dCz.end();
            this.dCz.cancel();
        }
        if (this.dCw != null) {
            this.dCw.setRepeatCount(0);
            this.dCw.removeAllUpdateListeners();
            this.dCw.removeAllListeners();
            this.dCw.end();
            this.dCw.cancel();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aKI();
    }
}
