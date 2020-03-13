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
    private static final double bMV = Math.sqrt(2.0d);
    private boolean bLH;
    float bMW;
    float bMX;
    float bMY;
    float bMZ;
    float bNa;
    float bNb;
    float bNc;
    private PointF bNd;
    private Paint bNe;
    private a bNf;
    private RectF bNg;
    private PointF bNh;
    private PointF bNi;
    private PointF bNj;
    private float bNk;
    private int bNl;
    private int bNm;
    private ValueAnimator bNn;
    private float bNo;
    private float bNp;
    private ValueAnimator bNq;
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
        int i = refreshingAnimView.bNm;
        refreshingAnimView.bNm = i + 1;
        return i;
    }

    public RefreshingAnimView(Context context) {
        super(context);
        this.bMW = 0.0f;
        this.bMX = 0.0f;
        this.bMY = 0.0f;
        this.bMZ = 0.0f;
        this.bNa = 0.0f;
        this.bNb = 0.0f;
        this.bNc = 0.0f;
        this.mWidth = 0.0f;
        this.bNd = new PointF();
        this.bNg = new RectF();
        this.bNh = new PointF();
        this.bNi = new PointF();
        this.bNj = new PointF();
        this.bNk = 0.0f;
        this.bNl = 0;
        this.bNm = 1;
        this.bNn = null;
        this.bNo = 0.0f;
        this.bNp = 0.0f;
        this.bNq = null;
        this.bLH = false;
        this.mState = 0;
        lQ();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bMW = 0.0f;
        this.bMX = 0.0f;
        this.bMY = 0.0f;
        this.bMZ = 0.0f;
        this.bNa = 0.0f;
        this.bNb = 0.0f;
        this.bNc = 0.0f;
        this.mWidth = 0.0f;
        this.bNd = new PointF();
        this.bNg = new RectF();
        this.bNh = new PointF();
        this.bNi = new PointF();
        this.bNj = new PointF();
        this.bNk = 0.0f;
        this.bNl = 0;
        this.bNm = 1;
        this.bNn = null;
        this.bNo = 0.0f;
        this.bNp = 0.0f;
        this.bNq = null;
        this.bLH = false;
        this.mState = 0;
        lQ();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bMW = 0.0f;
        this.bMX = 0.0f;
        this.bMY = 0.0f;
        this.bMZ = 0.0f;
        this.bNa = 0.0f;
        this.bNb = 0.0f;
        this.bNc = 0.0f;
        this.mWidth = 0.0f;
        this.bNd = new PointF();
        this.bNg = new RectF();
        this.bNh = new PointF();
        this.bNi = new PointF();
        this.bNj = new PointF();
        this.bNk = 0.0f;
        this.bNl = 0;
        this.bNm = 1;
        this.bNn = null;
        this.bNo = 0.0f;
        this.bNp = 0.0f;
        this.bNq = null;
        this.bLH = false;
        this.mState = 0;
        lQ();
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        this.bMW = f2 <= 1.0f ? f2 : 1.0f;
        ace();
        postInvalidate();
    }

    public void acd() {
        ay(300L);
    }

    private void ay(long j) {
        changeState(2);
        if (this.bNq != null) {
            abP();
        }
        this.bNq = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.bNq.setDuration(j);
        this.bNq.setInterpolator(new LinearInterpolator());
        this.bNq.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.P(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.bNq.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.2
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
        if (!this.bNq.isRunning()) {
            this.bNq.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void az(long j) {
        changeState(3);
        if (this.bNn != null) {
            abP();
        }
        this.bNn = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.bNn.setDuration(j);
        this.bNn.setInterpolator(new LinearInterpolator());
        this.bNn.setRepeatCount(-1);
        this.bNn.setRepeatMode(1);
        this.bNn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.Q(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        if (this.bNl > 0) {
            this.bNn.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.4
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
                    if (RefreshingAnimView.this.bNm > RefreshingAnimView.this.bNl && RefreshingAnimView.this.bNf != null) {
                        RefreshingAnimView.this.bNf.dx(true);
                    }
                }
            });
        } else if (this.bNf != null) {
            this.bNf.dx(true);
        }
        if (!this.bNn.isRunning()) {
            this.bNn.start();
        }
    }

    public void setAtLeastRotateRounds(int i) {
        this.bNl = i;
    }

    public void setOnLoadingAnimationListener(a aVar) {
        this.bNf = aVar;
    }

    public void stopAnim() {
        abP();
        clearAnimation();
        this.bMW = 0.0f;
        this.bNm = 1;
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
        this.bMZ = af.dip2px(getContext(), 8.0f);
        this.bNb = af.dip2px(getContext(), 6.5f);
        this.bNk = af.dip2px(getContext(), 5.0f);
        this.bNc = af.dip2px(getContext(), 7.5f);
        float f = this.mWidth / 2.0f;
        this.bNd.set(f, f);
        float f2 = f + ((float) (this.bMZ / bMV));
        this.bNi.set(f2, f2);
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
            if (this.bLH != com.baidu.swan.apps.w.a.Us().getNightModeSwitcherState()) {
                this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
                this.bLH = com.baidu.swan.apps.w.a.Us().getNightModeSwitcherState();
            }
            this.mPaint.setAlpha(76);
            this.bNg.set(this.bNd.x - this.bMZ, this.bNd.y - this.bMZ, this.bNd.x + this.bMZ, this.bNd.y + this.bMZ);
            this.mCanvas.drawArc(this.bNg, -90.0f, (-360.0f) * this.bMX, true, this.mPaint);
            this.mCanvas.drawCircle(this.bNd.x, this.bNd.y, this.bNa, this.bNe);
            if (this.bMY > 0.0f) {
                this.mCanvas.drawCircle(this.bNj.x, this.bNj.y, 0.75f, this.mPaint);
                this.mPaint.setStyle(Paint.Style.STROKE);
                this.mPaint.setStrokeWidth(af.dip2px(getContext(), 1.5f));
                this.mCanvas.drawLine(this.bNi.x, this.bNi.y, this.bNj.x, this.bNj.y, this.mPaint);
            }
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    private void ace() {
        this.bMX = this.bMW;
        if (this.bMW < 0.5f) {
            this.bMY = 0.0f;
            this.bNa = 0.0f;
            return;
        }
        this.bNa = ((this.bMW - 0.5f) / 0.5f) * this.bNb;
        if (this.bMW < 0.625f) {
            this.bMY = 0.0f;
            return;
        }
        this.bMY = (this.bMW - 0.625f) / 0.375f;
        this.bNj.set(this.bNi.x + ((float) ((this.bNk * this.bMY) / bMV)), this.bNi.y + ((float) ((this.bNk * this.bMY) / bMV)));
    }

    private void r(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setAlpha((int) (255.0d * ((this.bNp * 0.3d) + 0.3d)));
            float f = this.bNi.x + ((float) (this.bNk / bMV));
            this.mCanvas.drawCircle(this.bNd.x, this.bNd.y, this.bMZ, this.mPaint);
            this.mCanvas.drawCircle(this.bNd.x, this.bNd.y, this.bNb, this.bNe);
            this.mCanvas.drawCircle(f, f, 0.75f, this.mPaint);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(af.dip2px(getContext(), 1.5f));
            this.mCanvas.drawLine(this.bNi.x, this.bNi.y, f, f, this.mPaint);
            this.mMatrix.reset();
            this.mCamera.save();
            this.mCamera.setLocation(0.0f, 0.0f, -100.0f);
            this.mCamera.rotateY(this.bNp * 90.0f);
            this.mCamera.getMatrix(this.mMatrix);
            this.mCamera.restore();
            this.mMatrix.preTranslate(-this.bNd.x, -this.bNd.y);
            this.mMatrix.postTranslate(this.bNd.x, this.bNd.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(float f) {
        this.bNp = f;
        postInvalidate();
    }

    private void s(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            int abs = (int) ((((1.0d - (Math.abs(this.bNo - 0.5d) * 2.0d)) * 0.3d) + 0.3d) * 255.0d);
            if (this.bLH) {
                abs = (int) ((((1.0d - (Math.abs(this.bNo - 0.5d) * 2.0d)) * 0.2d) + 0.1d) * 255.0d);
            }
            this.mPaint.setAlpha(abs);
            this.mCanvas.drawCircle(this.bNd.x, this.bNd.y, this.bNc, this.mPaint);
            this.mMatrix.reset();
            this.mCamera.save();
            this.mCamera.setLocation(0.0f, 0.0f, -100.0f);
            this.mCamera.rotateY((this.bNo * 360.0f) + 90.0f);
            this.mCamera.getMatrix(this.mMatrix);
            this.mCamera.restore();
            this.mMatrix.preTranslate(-this.bNd.x, -this.bNd.y);
            this.mMatrix.postTranslate(this.bNd.x, this.bNd.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(float f) {
        if (f < 0.2f) {
            this.bNo = (f / 0.2f) * 0.5f;
        } else {
            this.bNo = (((f - 0.2f) / 0.8f) * 0.5f) + 0.5f;
        }
        postInvalidate();
    }

    private void lQ() {
        this.bLH = com.baidu.swan.apps.w.a.Us().getNightModeSwitcherState();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
        this.bNe = new Paint();
        this.bNe.setAntiAlias(true);
        this.bNe.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
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

    private void abP() {
        if (this.bNq != null) {
            this.bNq.setRepeatCount(0);
            this.bNq.removeAllUpdateListeners();
            this.bNq.removeAllListeners();
            this.bNq.end();
            this.bNq.cancel();
        }
        if (this.bNn != null) {
            this.bNn.setRepeatCount(0);
            this.bNn.removeAllUpdateListeners();
            this.bNn.removeAllListeners();
            this.bNn.end();
            this.bNn.cancel();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        abP();
    }
}
