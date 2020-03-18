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
    private static final double bNg = Math.sqrt(2.0d);
    private boolean bLS;
    private float bNA;
    private ValueAnimator bNB;
    float bNh;
    float bNi;
    float bNj;
    float bNk;
    float bNl;
    float bNm;
    float bNn;
    private PointF bNo;
    private Paint bNp;
    private a bNq;
    private RectF bNr;
    private PointF bNs;
    private PointF bNt;
    private PointF bNu;
    private float bNv;
    private int bNw;
    private int bNx;
    private ValueAnimator bNy;
    private float bNz;
    private Bitmap mBitmap;
    private Camera mCamera;
    private Canvas mCanvas;
    private Matrix mMatrix;
    private Paint mPaint;
    private int mState;
    private float mWidth;

    /* loaded from: classes11.dex */
    public interface a {
        void dy(boolean z);
    }

    static /* synthetic */ int a(RefreshingAnimView refreshingAnimView) {
        int i = refreshingAnimView.bNx;
        refreshingAnimView.bNx = i + 1;
        return i;
    }

    public RefreshingAnimView(Context context) {
        super(context);
        this.bNh = 0.0f;
        this.bNi = 0.0f;
        this.bNj = 0.0f;
        this.bNk = 0.0f;
        this.bNl = 0.0f;
        this.bNm = 0.0f;
        this.bNn = 0.0f;
        this.mWidth = 0.0f;
        this.bNo = new PointF();
        this.bNr = new RectF();
        this.bNs = new PointF();
        this.bNt = new PointF();
        this.bNu = new PointF();
        this.bNv = 0.0f;
        this.bNw = 0;
        this.bNx = 1;
        this.bNy = null;
        this.bNz = 0.0f;
        this.bNA = 0.0f;
        this.bNB = null;
        this.bLS = false;
        this.mState = 0;
        lQ();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bNh = 0.0f;
        this.bNi = 0.0f;
        this.bNj = 0.0f;
        this.bNk = 0.0f;
        this.bNl = 0.0f;
        this.bNm = 0.0f;
        this.bNn = 0.0f;
        this.mWidth = 0.0f;
        this.bNo = new PointF();
        this.bNr = new RectF();
        this.bNs = new PointF();
        this.bNt = new PointF();
        this.bNu = new PointF();
        this.bNv = 0.0f;
        this.bNw = 0;
        this.bNx = 1;
        this.bNy = null;
        this.bNz = 0.0f;
        this.bNA = 0.0f;
        this.bNB = null;
        this.bLS = false;
        this.mState = 0;
        lQ();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bNh = 0.0f;
        this.bNi = 0.0f;
        this.bNj = 0.0f;
        this.bNk = 0.0f;
        this.bNl = 0.0f;
        this.bNm = 0.0f;
        this.bNn = 0.0f;
        this.mWidth = 0.0f;
        this.bNo = new PointF();
        this.bNr = new RectF();
        this.bNs = new PointF();
        this.bNt = new PointF();
        this.bNu = new PointF();
        this.bNv = 0.0f;
        this.bNw = 0;
        this.bNx = 1;
        this.bNy = null;
        this.bNz = 0.0f;
        this.bNA = 0.0f;
        this.bNB = null;
        this.bLS = false;
        this.mState = 0;
        lQ();
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        this.bNh = f2 <= 1.0f ? f2 : 1.0f;
        ach();
        postInvalidate();
    }

    public void acg() {
        ay(300L);
    }

    private void ay(long j) {
        changeState(2);
        if (this.bNB != null) {
            abS();
        }
        this.bNB = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.bNB.setDuration(j);
        this.bNB.setInterpolator(new LinearInterpolator());
        this.bNB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.P(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.bNB.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.2
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
        if (!this.bNB.isRunning()) {
            this.bNB.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void az(long j) {
        changeState(3);
        if (this.bNy != null) {
            abS();
        }
        this.bNy = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.bNy.setDuration(j);
        this.bNy.setInterpolator(new LinearInterpolator());
        this.bNy.setRepeatCount(-1);
        this.bNy.setRepeatMode(1);
        this.bNy.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.Q(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        if (this.bNw > 0) {
            this.bNy.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.4
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
                    if (RefreshingAnimView.this.bNx > RefreshingAnimView.this.bNw && RefreshingAnimView.this.bNq != null) {
                        RefreshingAnimView.this.bNq.dy(true);
                    }
                }
            });
        } else if (this.bNq != null) {
            this.bNq.dy(true);
        }
        if (!this.bNy.isRunning()) {
            this.bNy.start();
        }
    }

    public void setAtLeastRotateRounds(int i) {
        this.bNw = i;
    }

    public void setOnLoadingAnimationListener(a aVar) {
        this.bNq = aVar;
    }

    public void stopAnim() {
        abS();
        clearAnimation();
        this.bNh = 0.0f;
        this.bNx = 1;
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
        this.bNk = af.dip2px(getContext(), 8.0f);
        this.bNm = af.dip2px(getContext(), 6.5f);
        this.bNv = af.dip2px(getContext(), 5.0f);
        this.bNn = af.dip2px(getContext(), 7.5f);
        float f = this.mWidth / 2.0f;
        this.bNo.set(f, f);
        float f2 = f + ((float) (this.bNk / bNg));
        this.bNt.set(f2, f2);
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
            if (this.bLS != com.baidu.swan.apps.w.a.Uv().getNightModeSwitcherState()) {
                this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
                this.bLS = com.baidu.swan.apps.w.a.Uv().getNightModeSwitcherState();
            }
            this.mPaint.setAlpha(76);
            this.bNr.set(this.bNo.x - this.bNk, this.bNo.y - this.bNk, this.bNo.x + this.bNk, this.bNo.y + this.bNk);
            this.mCanvas.drawArc(this.bNr, -90.0f, (-360.0f) * this.bNi, true, this.mPaint);
            this.mCanvas.drawCircle(this.bNo.x, this.bNo.y, this.bNl, this.bNp);
            if (this.bNj > 0.0f) {
                this.mCanvas.drawCircle(this.bNu.x, this.bNu.y, 0.75f, this.mPaint);
                this.mPaint.setStyle(Paint.Style.STROKE);
                this.mPaint.setStrokeWidth(af.dip2px(getContext(), 1.5f));
                this.mCanvas.drawLine(this.bNt.x, this.bNt.y, this.bNu.x, this.bNu.y, this.mPaint);
            }
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    private void ach() {
        this.bNi = this.bNh;
        if (this.bNh < 0.5f) {
            this.bNj = 0.0f;
            this.bNl = 0.0f;
            return;
        }
        this.bNl = ((this.bNh - 0.5f) / 0.5f) * this.bNm;
        if (this.bNh < 0.625f) {
            this.bNj = 0.0f;
            return;
        }
        this.bNj = (this.bNh - 0.625f) / 0.375f;
        this.bNu.set(this.bNt.x + ((float) ((this.bNv * this.bNj) / bNg)), this.bNt.y + ((float) ((this.bNv * this.bNj) / bNg)));
    }

    private void r(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setAlpha((int) (255.0d * ((this.bNA * 0.3d) + 0.3d)));
            float f = this.bNt.x + ((float) (this.bNv / bNg));
            this.mCanvas.drawCircle(this.bNo.x, this.bNo.y, this.bNk, this.mPaint);
            this.mCanvas.drawCircle(this.bNo.x, this.bNo.y, this.bNm, this.bNp);
            this.mCanvas.drawCircle(f, f, 0.75f, this.mPaint);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(af.dip2px(getContext(), 1.5f));
            this.mCanvas.drawLine(this.bNt.x, this.bNt.y, f, f, this.mPaint);
            this.mMatrix.reset();
            this.mCamera.save();
            this.mCamera.setLocation(0.0f, 0.0f, -100.0f);
            this.mCamera.rotateY(this.bNA * 90.0f);
            this.mCamera.getMatrix(this.mMatrix);
            this.mCamera.restore();
            this.mMatrix.preTranslate(-this.bNo.x, -this.bNo.y);
            this.mMatrix.postTranslate(this.bNo.x, this.bNo.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(float f) {
        this.bNA = f;
        postInvalidate();
    }

    private void s(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            int abs = (int) ((((1.0d - (Math.abs(this.bNz - 0.5d) * 2.0d)) * 0.3d) + 0.3d) * 255.0d);
            if (this.bLS) {
                abs = (int) ((((1.0d - (Math.abs(this.bNz - 0.5d) * 2.0d)) * 0.2d) + 0.1d) * 255.0d);
            }
            this.mPaint.setAlpha(abs);
            this.mCanvas.drawCircle(this.bNo.x, this.bNo.y, this.bNn, this.mPaint);
            this.mMatrix.reset();
            this.mCamera.save();
            this.mCamera.setLocation(0.0f, 0.0f, -100.0f);
            this.mCamera.rotateY((this.bNz * 360.0f) + 90.0f);
            this.mCamera.getMatrix(this.mMatrix);
            this.mCamera.restore();
            this.mMatrix.preTranslate(-this.bNo.x, -this.bNo.y);
            this.mMatrix.postTranslate(this.bNo.x, this.bNo.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(float f) {
        if (f < 0.2f) {
            this.bNz = (f / 0.2f) * 0.5f;
        } else {
            this.bNz = (((f - 0.2f) / 0.8f) * 0.5f) + 0.5f;
        }
        postInvalidate();
    }

    private void lQ() {
        this.bLS = com.baidu.swan.apps.w.a.Uv().getNightModeSwitcherState();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
        this.bNp = new Paint();
        this.bNp.setAntiAlias(true);
        this.bNp.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
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

    private void abS() {
        if (this.bNB != null) {
            this.bNB.setRepeatCount(0);
            this.bNB.removeAllUpdateListeners();
            this.bNB.removeAllListeners();
            this.bNB.end();
            this.bNB.cancel();
        }
        if (this.bNy != null) {
            this.bNy.setRepeatCount(0);
            this.bNy.removeAllUpdateListeners();
            this.bNy.removeAllListeners();
            this.bNy.end();
            this.bNy.cancel();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        abS();
    }
}
