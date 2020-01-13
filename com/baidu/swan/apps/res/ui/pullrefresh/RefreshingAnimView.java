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
/* loaded from: classes10.dex */
public class RefreshingAnimView extends View {
    private static final double bIO = Math.sqrt(2.0d);
    private boolean bHA;
    float bIP;
    float bIQ;
    float bIR;
    float bIS;
    float bIT;
    float bIU;
    float bIV;
    private PointF bIW;
    private Paint bIX;
    private a bIY;
    private RectF bIZ;
    private PointF bJa;
    private PointF bJb;
    private PointF bJc;
    private float bJd;
    private int bJe;
    private int bJf;
    private ValueAnimator bJg;
    private float bJh;
    private float bJi;
    private ValueAnimator bJj;
    private Bitmap mBitmap;
    private Camera mCamera;
    private Canvas mCanvas;
    private Matrix mMatrix;
    private Paint mPaint;
    private int mState;
    private float mWidth;

    /* loaded from: classes10.dex */
    public interface a {
        void dq(boolean z);
    }

    static /* synthetic */ int a(RefreshingAnimView refreshingAnimView) {
        int i = refreshingAnimView.bJf;
        refreshingAnimView.bJf = i + 1;
        return i;
    }

    public RefreshingAnimView(Context context) {
        super(context);
        this.bIP = 0.0f;
        this.bIQ = 0.0f;
        this.bIR = 0.0f;
        this.bIS = 0.0f;
        this.bIT = 0.0f;
        this.bIU = 0.0f;
        this.bIV = 0.0f;
        this.mWidth = 0.0f;
        this.bIW = new PointF();
        this.bIZ = new RectF();
        this.bJa = new PointF();
        this.bJb = new PointF();
        this.bJc = new PointF();
        this.bJd = 0.0f;
        this.bJe = 0;
        this.bJf = 1;
        this.bJg = null;
        this.bJh = 0.0f;
        this.bJi = 0.0f;
        this.bJj = null;
        this.bHA = false;
        this.mState = 0;
        lB();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bIP = 0.0f;
        this.bIQ = 0.0f;
        this.bIR = 0.0f;
        this.bIS = 0.0f;
        this.bIT = 0.0f;
        this.bIU = 0.0f;
        this.bIV = 0.0f;
        this.mWidth = 0.0f;
        this.bIW = new PointF();
        this.bIZ = new RectF();
        this.bJa = new PointF();
        this.bJb = new PointF();
        this.bJc = new PointF();
        this.bJd = 0.0f;
        this.bJe = 0;
        this.bJf = 1;
        this.bJg = null;
        this.bJh = 0.0f;
        this.bJi = 0.0f;
        this.bJj = null;
        this.bHA = false;
        this.mState = 0;
        lB();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bIP = 0.0f;
        this.bIQ = 0.0f;
        this.bIR = 0.0f;
        this.bIS = 0.0f;
        this.bIT = 0.0f;
        this.bIU = 0.0f;
        this.bIV = 0.0f;
        this.mWidth = 0.0f;
        this.bIW = new PointF();
        this.bIZ = new RectF();
        this.bJa = new PointF();
        this.bJb = new PointF();
        this.bJc = new PointF();
        this.bJd = 0.0f;
        this.bJe = 0;
        this.bJf = 1;
        this.bJg = null;
        this.bJh = 0.0f;
        this.bJi = 0.0f;
        this.bJj = null;
        this.bHA = false;
        this.mState = 0;
        lB();
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        this.bIP = f2 <= 1.0f ? f2 : 1.0f;
        ZO();
        postInvalidate();
    }

    public void ZN() {
        au(300L);
    }

    private void au(long j) {
        changeState(2);
        if (this.bJj != null) {
            Zz();
        }
        this.bJj = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.bJj.setDuration(j);
        this.bJj.setInterpolator(new LinearInterpolator());
        this.bJj.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.P(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.bJj.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                RefreshingAnimView.this.av(750L);
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
        if (!this.bJj.isRunning()) {
            this.bJj.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av(long j) {
        changeState(3);
        if (this.bJg != null) {
            Zz();
        }
        this.bJg = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.bJg.setDuration(j);
        this.bJg.setInterpolator(new LinearInterpolator());
        this.bJg.setRepeatCount(-1);
        this.bJg.setRepeatMode(1);
        this.bJg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.Q(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        if (this.bJe > 0) {
            this.bJg.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.4
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
                    if (RefreshingAnimView.this.bJf > RefreshingAnimView.this.bJe && RefreshingAnimView.this.bIY != null) {
                        RefreshingAnimView.this.bIY.dq(true);
                    }
                }
            });
        } else if (this.bIY != null) {
            this.bIY.dq(true);
        }
        if (!this.bJg.isRunning()) {
            this.bJg.start();
        }
    }

    public void setAtLeastRotateRounds(int i) {
        this.bJe = i;
    }

    public void setOnLoadingAnimationListener(a aVar) {
        this.bIY = aVar;
    }

    public void stopAnim() {
        Zz();
        clearAnimation();
        this.bIP = 0.0f;
        this.bJf = 1;
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
        this.bIS = af.dip2px(getContext(), 8.0f);
        this.bIU = af.dip2px(getContext(), 6.5f);
        this.bJd = af.dip2px(getContext(), 5.0f);
        this.bIV = af.dip2px(getContext(), 7.5f);
        float f = this.mWidth / 2.0f;
        this.bIW.set(f, f);
        float f2 = f + ((float) (this.bIS / bIO));
        this.bJb.set(f2, f2);
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
            if (this.bHA != com.baidu.swan.apps.w.a.Sc().getNightModeSwitcherState()) {
                this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
                this.bHA = com.baidu.swan.apps.w.a.Sc().getNightModeSwitcherState();
            }
            this.mPaint.setAlpha(76);
            this.bIZ.set(this.bIW.x - this.bIS, this.bIW.y - this.bIS, this.bIW.x + this.bIS, this.bIW.y + this.bIS);
            this.mCanvas.drawArc(this.bIZ, -90.0f, (-360.0f) * this.bIQ, true, this.mPaint);
            this.mCanvas.drawCircle(this.bIW.x, this.bIW.y, this.bIT, this.bIX);
            if (this.bIR > 0.0f) {
                this.mCanvas.drawCircle(this.bJc.x, this.bJc.y, 0.75f, this.mPaint);
                this.mPaint.setStyle(Paint.Style.STROKE);
                this.mPaint.setStrokeWidth(af.dip2px(getContext(), 1.5f));
                this.mCanvas.drawLine(this.bJb.x, this.bJb.y, this.bJc.x, this.bJc.y, this.mPaint);
            }
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    private void ZO() {
        this.bIQ = this.bIP;
        if (this.bIP < 0.5f) {
            this.bIR = 0.0f;
            this.bIT = 0.0f;
            return;
        }
        this.bIT = ((this.bIP - 0.5f) / 0.5f) * this.bIU;
        if (this.bIP < 0.625f) {
            this.bIR = 0.0f;
            return;
        }
        this.bIR = (this.bIP - 0.625f) / 0.375f;
        this.bJc.set(this.bJb.x + ((float) ((this.bJd * this.bIR) / bIO)), this.bJb.y + ((float) ((this.bJd * this.bIR) / bIO)));
    }

    private void r(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setAlpha((int) (255.0d * ((this.bJi * 0.3d) + 0.3d)));
            float f = this.bJb.x + ((float) (this.bJd / bIO));
            this.mCanvas.drawCircle(this.bIW.x, this.bIW.y, this.bIS, this.mPaint);
            this.mCanvas.drawCircle(this.bIW.x, this.bIW.y, this.bIU, this.bIX);
            this.mCanvas.drawCircle(f, f, 0.75f, this.mPaint);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(af.dip2px(getContext(), 1.5f));
            this.mCanvas.drawLine(this.bJb.x, this.bJb.y, f, f, this.mPaint);
            this.mMatrix.reset();
            this.mCamera.save();
            this.mCamera.setLocation(0.0f, 0.0f, -100.0f);
            this.mCamera.rotateY(this.bJi * 90.0f);
            this.mCamera.getMatrix(this.mMatrix);
            this.mCamera.restore();
            this.mMatrix.preTranslate(-this.bIW.x, -this.bIW.y);
            this.mMatrix.postTranslate(this.bIW.x, this.bIW.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(float f) {
        this.bJi = f;
        postInvalidate();
    }

    private void s(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            int abs = (int) ((((1.0d - (Math.abs(this.bJh - 0.5d) * 2.0d)) * 0.3d) + 0.3d) * 255.0d);
            if (this.bHA) {
                abs = (int) ((((1.0d - (Math.abs(this.bJh - 0.5d) * 2.0d)) * 0.2d) + 0.1d) * 255.0d);
            }
            this.mPaint.setAlpha(abs);
            this.mCanvas.drawCircle(this.bIW.x, this.bIW.y, this.bIV, this.mPaint);
            this.mMatrix.reset();
            this.mCamera.save();
            this.mCamera.setLocation(0.0f, 0.0f, -100.0f);
            this.mCamera.rotateY((this.bJh * 360.0f) + 90.0f);
            this.mCamera.getMatrix(this.mMatrix);
            this.mCamera.restore();
            this.mMatrix.preTranslate(-this.bIW.x, -this.bIW.y);
            this.mMatrix.postTranslate(this.bIW.x, this.bIW.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(float f) {
        if (f < 0.2f) {
            this.bJh = (f / 0.2f) * 0.5f;
        } else {
            this.bJh = (((f - 0.2f) / 0.8f) * 0.5f) + 0.5f;
        }
        postInvalidate();
    }

    private void lB() {
        this.bHA = com.baidu.swan.apps.w.a.Sc().getNightModeSwitcherState();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
        this.bIX = new Paint();
        this.bIX.setAntiAlias(true);
        this.bIX.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
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

    private void Zz() {
        if (this.bJj != null) {
            this.bJj.setRepeatCount(0);
            this.bJj.removeAllUpdateListeners();
            this.bJj.removeAllListeners();
            this.bJj.end();
            this.bJj.cancel();
        }
        if (this.bJg != null) {
            this.bJg.setRepeatCount(0);
            this.bJg.removeAllUpdateListeners();
            this.bJg.removeAllListeners();
            this.bJg.end();
            this.bJg.cancel();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Zz();
    }
}
