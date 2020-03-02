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
    private static final double bMU = Math.sqrt(2.0d);
    private boolean bLG;
    float bMV;
    float bMW;
    float bMX;
    float bMY;
    float bMZ;
    float bNa;
    float bNb;
    private PointF bNc;
    private Paint bNd;
    private a bNe;
    private RectF bNf;
    private PointF bNg;
    private PointF bNh;
    private PointF bNi;
    private float bNj;
    private int bNk;
    private int bNl;
    private ValueAnimator bNm;
    private float bNn;
    private float bNo;
    private ValueAnimator bNp;
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
        int i = refreshingAnimView.bNl;
        refreshingAnimView.bNl = i + 1;
        return i;
    }

    public RefreshingAnimView(Context context) {
        super(context);
        this.bMV = 0.0f;
        this.bMW = 0.0f;
        this.bMX = 0.0f;
        this.bMY = 0.0f;
        this.bMZ = 0.0f;
        this.bNa = 0.0f;
        this.bNb = 0.0f;
        this.mWidth = 0.0f;
        this.bNc = new PointF();
        this.bNf = new RectF();
        this.bNg = new PointF();
        this.bNh = new PointF();
        this.bNi = new PointF();
        this.bNj = 0.0f;
        this.bNk = 0;
        this.bNl = 1;
        this.bNm = null;
        this.bNn = 0.0f;
        this.bNo = 0.0f;
        this.bNp = null;
        this.bLG = false;
        this.mState = 0;
        lQ();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bMV = 0.0f;
        this.bMW = 0.0f;
        this.bMX = 0.0f;
        this.bMY = 0.0f;
        this.bMZ = 0.0f;
        this.bNa = 0.0f;
        this.bNb = 0.0f;
        this.mWidth = 0.0f;
        this.bNc = new PointF();
        this.bNf = new RectF();
        this.bNg = new PointF();
        this.bNh = new PointF();
        this.bNi = new PointF();
        this.bNj = 0.0f;
        this.bNk = 0;
        this.bNl = 1;
        this.bNm = null;
        this.bNn = 0.0f;
        this.bNo = 0.0f;
        this.bNp = null;
        this.bLG = false;
        this.mState = 0;
        lQ();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bMV = 0.0f;
        this.bMW = 0.0f;
        this.bMX = 0.0f;
        this.bMY = 0.0f;
        this.bMZ = 0.0f;
        this.bNa = 0.0f;
        this.bNb = 0.0f;
        this.mWidth = 0.0f;
        this.bNc = new PointF();
        this.bNf = new RectF();
        this.bNg = new PointF();
        this.bNh = new PointF();
        this.bNi = new PointF();
        this.bNj = 0.0f;
        this.bNk = 0;
        this.bNl = 1;
        this.bNm = null;
        this.bNn = 0.0f;
        this.bNo = 0.0f;
        this.bNp = null;
        this.bLG = false;
        this.mState = 0;
        lQ();
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        this.bMV = f2 <= 1.0f ? f2 : 1.0f;
        ace();
        postInvalidate();
    }

    public void acd() {
        ay(300L);
    }

    private void ay(long j) {
        changeState(2);
        if (this.bNp != null) {
            abP();
        }
        this.bNp = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.bNp.setDuration(j);
        this.bNp.setInterpolator(new LinearInterpolator());
        this.bNp.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.P(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.bNp.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.2
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
        if (!this.bNp.isRunning()) {
            this.bNp.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void az(long j) {
        changeState(3);
        if (this.bNm != null) {
            abP();
        }
        this.bNm = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.bNm.setDuration(j);
        this.bNm.setInterpolator(new LinearInterpolator());
        this.bNm.setRepeatCount(-1);
        this.bNm.setRepeatMode(1);
        this.bNm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.Q(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        if (this.bNk > 0) {
            this.bNm.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.4
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
                    if (RefreshingAnimView.this.bNl > RefreshingAnimView.this.bNk && RefreshingAnimView.this.bNe != null) {
                        RefreshingAnimView.this.bNe.dx(true);
                    }
                }
            });
        } else if (this.bNe != null) {
            this.bNe.dx(true);
        }
        if (!this.bNm.isRunning()) {
            this.bNm.start();
        }
    }

    public void setAtLeastRotateRounds(int i) {
        this.bNk = i;
    }

    public void setOnLoadingAnimationListener(a aVar) {
        this.bNe = aVar;
    }

    public void stopAnim() {
        abP();
        clearAnimation();
        this.bMV = 0.0f;
        this.bNl = 1;
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
        this.bMY = af.dip2px(getContext(), 8.0f);
        this.bNa = af.dip2px(getContext(), 6.5f);
        this.bNj = af.dip2px(getContext(), 5.0f);
        this.bNb = af.dip2px(getContext(), 7.5f);
        float f = this.mWidth / 2.0f;
        this.bNc.set(f, f);
        float f2 = f + ((float) (this.bMY / bMU));
        this.bNh.set(f2, f2);
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
            if (this.bLG != com.baidu.swan.apps.w.a.Us().getNightModeSwitcherState()) {
                this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
                this.bLG = com.baidu.swan.apps.w.a.Us().getNightModeSwitcherState();
            }
            this.mPaint.setAlpha(76);
            this.bNf.set(this.bNc.x - this.bMY, this.bNc.y - this.bMY, this.bNc.x + this.bMY, this.bNc.y + this.bMY);
            this.mCanvas.drawArc(this.bNf, -90.0f, (-360.0f) * this.bMW, true, this.mPaint);
            this.mCanvas.drawCircle(this.bNc.x, this.bNc.y, this.bMZ, this.bNd);
            if (this.bMX > 0.0f) {
                this.mCanvas.drawCircle(this.bNi.x, this.bNi.y, 0.75f, this.mPaint);
                this.mPaint.setStyle(Paint.Style.STROKE);
                this.mPaint.setStrokeWidth(af.dip2px(getContext(), 1.5f));
                this.mCanvas.drawLine(this.bNh.x, this.bNh.y, this.bNi.x, this.bNi.y, this.mPaint);
            }
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    private void ace() {
        this.bMW = this.bMV;
        if (this.bMV < 0.5f) {
            this.bMX = 0.0f;
            this.bMZ = 0.0f;
            return;
        }
        this.bMZ = ((this.bMV - 0.5f) / 0.5f) * this.bNa;
        if (this.bMV < 0.625f) {
            this.bMX = 0.0f;
            return;
        }
        this.bMX = (this.bMV - 0.625f) / 0.375f;
        this.bNi.set(this.bNh.x + ((float) ((this.bNj * this.bMX) / bMU)), this.bNh.y + ((float) ((this.bNj * this.bMX) / bMU)));
    }

    private void r(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setAlpha((int) (255.0d * ((this.bNo * 0.3d) + 0.3d)));
            float f = this.bNh.x + ((float) (this.bNj / bMU));
            this.mCanvas.drawCircle(this.bNc.x, this.bNc.y, this.bMY, this.mPaint);
            this.mCanvas.drawCircle(this.bNc.x, this.bNc.y, this.bNa, this.bNd);
            this.mCanvas.drawCircle(f, f, 0.75f, this.mPaint);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(af.dip2px(getContext(), 1.5f));
            this.mCanvas.drawLine(this.bNh.x, this.bNh.y, f, f, this.mPaint);
            this.mMatrix.reset();
            this.mCamera.save();
            this.mCamera.setLocation(0.0f, 0.0f, -100.0f);
            this.mCamera.rotateY(this.bNo * 90.0f);
            this.mCamera.getMatrix(this.mMatrix);
            this.mCamera.restore();
            this.mMatrix.preTranslate(-this.bNc.x, -this.bNc.y);
            this.mMatrix.postTranslate(this.bNc.x, this.bNc.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(float f) {
        this.bNo = f;
        postInvalidate();
    }

    private void s(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            int abs = (int) ((((1.0d - (Math.abs(this.bNn - 0.5d) * 2.0d)) * 0.3d) + 0.3d) * 255.0d);
            if (this.bLG) {
                abs = (int) ((((1.0d - (Math.abs(this.bNn - 0.5d) * 2.0d)) * 0.2d) + 0.1d) * 255.0d);
            }
            this.mPaint.setAlpha(abs);
            this.mCanvas.drawCircle(this.bNc.x, this.bNc.y, this.bNb, this.mPaint);
            this.mMatrix.reset();
            this.mCamera.save();
            this.mCamera.setLocation(0.0f, 0.0f, -100.0f);
            this.mCamera.rotateY((this.bNn * 360.0f) + 90.0f);
            this.mCamera.getMatrix(this.mMatrix);
            this.mCamera.restore();
            this.mMatrix.preTranslate(-this.bNc.x, -this.bNc.y);
            this.mMatrix.postTranslate(this.bNc.x, this.bNc.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(float f) {
        if (f < 0.2f) {
            this.bNn = (f / 0.2f) * 0.5f;
        } else {
            this.bNn = (((f - 0.2f) / 0.8f) * 0.5f) + 0.5f;
        }
        postInvalidate();
    }

    private void lQ() {
        this.bLG = com.baidu.swan.apps.w.a.Us().getNightModeSwitcherState();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
        this.bNd = new Paint();
        this.bNd.setAntiAlias(true);
        this.bNd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
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
        if (this.bNp != null) {
            this.bNp.setRepeatCount(0);
            this.bNp.removeAllUpdateListeners();
            this.bNp.removeAllListeners();
            this.bNp.end();
            this.bNp.cancel();
        }
        if (this.bNm != null) {
            this.bNm.setRepeatCount(0);
            this.bNm.removeAllUpdateListeners();
            this.bNm.removeAllListeners();
            this.bNm.end();
            this.bNm.cancel();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        abP();
    }
}
