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
/* loaded from: classes8.dex */
public class RefreshingAnimView extends View {
    private static final double dxs = Math.sqrt(2.0d);
    private float bPB;
    private boolean dwd;
    private Camera dwf;
    private PointF dxA;
    private Paint dxB;
    private a dxC;
    private RectF dxD;
    private PointF dxE;
    private PointF dxF;
    private PointF dxG;
    private float dxH;
    private int dxI;
    private int dxJ;
    private ValueAnimator dxK;
    private float dxL;
    private float dxM;
    private ValueAnimator dxN;
    float dxt;
    float dxu;
    float dxv;
    float dxw;
    float dxx;
    float dxy;
    float dxz;
    private Bitmap mBitmap;
    private Canvas mCanvas;
    private Matrix mMatrix;
    private Paint mPaint;
    private int mState;

    /* loaded from: classes8.dex */
    public interface a {
        void gI(boolean z);
    }

    static /* synthetic */ int a(RefreshingAnimView refreshingAnimView) {
        int i = refreshingAnimView.dxJ;
        refreshingAnimView.dxJ = i + 1;
        return i;
    }

    public RefreshingAnimView(Context context) {
        super(context);
        this.dxt = 0.0f;
        this.dxu = 0.0f;
        this.dxv = 0.0f;
        this.dxw = 0.0f;
        this.dxx = 0.0f;
        this.dxy = 0.0f;
        this.dxz = 0.0f;
        this.bPB = 0.0f;
        this.dxA = new PointF();
        this.dxD = new RectF();
        this.dxE = new PointF();
        this.dxF = new PointF();
        this.dxG = new PointF();
        this.dxH = 0.0f;
        this.dxI = 0;
        this.dxJ = 1;
        this.dxK = null;
        this.dxL = 0.0f;
        this.dxM = 0.0f;
        this.dxN = null;
        this.dwd = false;
        this.mState = 0;
        sa();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dxt = 0.0f;
        this.dxu = 0.0f;
        this.dxv = 0.0f;
        this.dxw = 0.0f;
        this.dxx = 0.0f;
        this.dxy = 0.0f;
        this.dxz = 0.0f;
        this.bPB = 0.0f;
        this.dxA = new PointF();
        this.dxD = new RectF();
        this.dxE = new PointF();
        this.dxF = new PointF();
        this.dxG = new PointF();
        this.dxH = 0.0f;
        this.dxI = 0;
        this.dxJ = 1;
        this.dxK = null;
        this.dxL = 0.0f;
        this.dxM = 0.0f;
        this.dxN = null;
        this.dwd = false;
        this.mState = 0;
        sa();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dxt = 0.0f;
        this.dxu = 0.0f;
        this.dxv = 0.0f;
        this.dxw = 0.0f;
        this.dxx = 0.0f;
        this.dxy = 0.0f;
        this.dxz = 0.0f;
        this.bPB = 0.0f;
        this.dxA = new PointF();
        this.dxD = new RectF();
        this.dxE = new PointF();
        this.dxF = new PointF();
        this.dxG = new PointF();
        this.dxH = 0.0f;
        this.dxI = 0;
        this.dxJ = 1;
        this.dxK = null;
        this.dxL = 0.0f;
        this.dxM = 0.0f;
        this.dxN = null;
        this.dwd = false;
        this.mState = 0;
        sa();
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        this.dxt = f2 <= 1.0f ? f2 : 1.0f;
        aHe();
        postInvalidate();
    }

    public void aHd() {
        cM(300L);
    }

    private void cM(long j) {
        iC(2);
        if (this.dxN != null) {
            aGP();
        }
        this.dxN = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.dxN.setDuration(j);
        this.dxN.setInterpolator(new LinearInterpolator());
        this.dxN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.K(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.dxN.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.2
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
        if (!this.dxN.isRunning()) {
            this.dxN.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cN(long j) {
        iC(3);
        if (this.dxK != null) {
            aGP();
        }
        this.dxK = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.dxK.setDuration(j);
        this.dxK.setInterpolator(new LinearInterpolator());
        this.dxK.setRepeatCount(-1);
        this.dxK.setRepeatMode(1);
        this.dxK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.L(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        if (this.dxI > 0) {
            this.dxK.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.4
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
                    if (RefreshingAnimView.this.dxJ > RefreshingAnimView.this.dxI && RefreshingAnimView.this.dxC != null) {
                        RefreshingAnimView.this.dxC.gI(true);
                    }
                }
            });
        } else if (this.dxC != null) {
            this.dxC.gI(true);
        }
        if (!this.dxK.isRunning()) {
            this.dxK.start();
        }
    }

    public void setAtLeastRotateRounds(int i) {
        this.dxI = i;
    }

    public void setOnLoadingAnimationListener(a aVar) {
        this.dxC = aVar;
    }

    public void stopAnim() {
        aGP();
        clearAnimation();
        this.dxt = 0.0f;
        this.dxJ = 1;
        iC(1);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredWidth() > getHeight()) {
            this.bPB = getMeasuredHeight();
        } else {
            this.bPB = getMeasuredWidth();
        }
        this.dxw = ah.dip2px(getContext(), 8.0f);
        this.dxy = ah.dip2px(getContext(), 6.5f);
        this.dxH = ah.dip2px(getContext(), 5.0f);
        this.dxz = ah.dip2px(getContext(), 7.5f);
        float f = this.bPB / 2.0f;
        this.dxA.set(f, f);
        float f2 = f + ((float) (this.dxw / dxs));
        this.dxF.set(f2, f2);
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
            if (this.dwd != com.baidu.swan.apps.t.a.awU().ahK()) {
                this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
                this.dwd = com.baidu.swan.apps.t.a.awU().ahK();
            }
            this.mPaint.setAlpha(76);
            this.dxD.set(this.dxA.x - this.dxw, this.dxA.y - this.dxw, this.dxA.x + this.dxw, this.dxA.y + this.dxw);
            this.mCanvas.drawArc(this.dxD, -90.0f, (-360.0f) * this.dxu, true, this.mPaint);
            this.mCanvas.drawCircle(this.dxA.x, this.dxA.y, this.dxx, this.dxB);
            if (this.dxv > 0.0f) {
                this.mCanvas.drawCircle(this.dxG.x, this.dxG.y, 0.75f, this.mPaint);
                this.mPaint.setStyle(Paint.Style.STROKE);
                this.mPaint.setStrokeWidth(ah.dip2px(getContext(), 1.5f));
                this.mCanvas.drawLine(this.dxF.x, this.dxF.y, this.dxG.x, this.dxG.y, this.mPaint);
            }
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    private void aHe() {
        this.dxu = this.dxt;
        if (this.dxt < 0.5f) {
            this.dxv = 0.0f;
            this.dxx = 0.0f;
            return;
        }
        this.dxx = ((this.dxt - 0.5f) / 0.5f) * this.dxy;
        if (this.dxt < 0.625f) {
            this.dxv = 0.0f;
            return;
        }
        this.dxv = (this.dxt - 0.625f) / 0.375f;
        this.dxG.set(this.dxF.x + ((float) ((this.dxH * this.dxv) / dxs)), this.dxF.y + ((float) ((this.dxH * this.dxv) / dxs)));
    }

    private void B(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setAlpha((int) (255.0d * ((this.dxM * 0.3d) + 0.3d)));
            float f = this.dxF.x + ((float) (this.dxH / dxs));
            this.mCanvas.drawCircle(this.dxA.x, this.dxA.y, this.dxw, this.mPaint);
            this.mCanvas.drawCircle(this.dxA.x, this.dxA.y, this.dxy, this.dxB);
            this.mCanvas.drawCircle(f, f, 0.75f, this.mPaint);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(ah.dip2px(getContext(), 1.5f));
            this.mCanvas.drawLine(this.dxF.x, this.dxF.y, f, f, this.mPaint);
            this.mMatrix.reset();
            this.dwf.save();
            this.dwf.setLocation(0.0f, 0.0f, -100.0f);
            this.dwf.rotateY(this.dxM * 90.0f);
            this.dwf.getMatrix(this.mMatrix);
            this.dwf.restore();
            this.mMatrix.preTranslate(-this.dxA.x, -this.dxA.y);
            this.mMatrix.postTranslate(this.dxA.x, this.dxA.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(float f) {
        this.dxM = f;
        postInvalidate();
    }

    private void C(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            int abs = (int) ((((1.0d - (Math.abs(this.dxL - 0.5d) * 2.0d)) * 0.3d) + 0.3d) * 255.0d);
            if (this.dwd) {
                abs = (int) ((((1.0d - (Math.abs(this.dxL - 0.5d) * 2.0d)) * 0.2d) + 0.1d) * 255.0d);
            }
            this.mPaint.setAlpha(abs);
            this.mCanvas.drawCircle(this.dxA.x, this.dxA.y, this.dxz, this.mPaint);
            this.mMatrix.reset();
            this.dwf.save();
            this.dwf.setLocation(0.0f, 0.0f, -100.0f);
            this.dwf.rotateY((this.dxL * 360.0f) + 90.0f);
            this.dwf.getMatrix(this.mMatrix);
            this.dwf.restore();
            this.mMatrix.preTranslate(-this.dxA.x, -this.dxA.y);
            this.mMatrix.postTranslate(this.dxA.x, this.dxA.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(float f) {
        if (f < 0.2f) {
            this.dxL = (f / 0.2f) * 0.5f;
        } else {
            this.dxL = (((f - 0.2f) / 0.8f) * 0.5f) + 0.5f;
        }
        postInvalidate();
    }

    private void sa() {
        this.dwd = com.baidu.swan.apps.t.a.awU().ahK();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
        this.dxB = new Paint();
        this.dxB.setAntiAlias(true);
        this.dxB.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.dwf = new Camera();
        this.mMatrix = new Matrix();
        iC(1);
    }

    private void iC(int i) {
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

    private void aGP() {
        if (this.dxN != null) {
            this.dxN.setRepeatCount(0);
            this.dxN.removeAllUpdateListeners();
            this.dxN.removeAllListeners();
            this.dxN.end();
            this.dxN.cancel();
        }
        if (this.dxK != null) {
            this.dxK.setRepeatCount(0);
            this.dxK.removeAllUpdateListeners();
            this.dxK.removeAllListeners();
            this.dxK.end();
            this.dxK.cancel();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aGP();
    }
}
