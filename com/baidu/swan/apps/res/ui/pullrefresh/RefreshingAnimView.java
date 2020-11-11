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
/* loaded from: classes10.dex */
public class RefreshingAnimView extends View {
    private static final double dqB = Math.sqrt(2.0d);
    private boolean dpn;
    float dqC;
    float dqD;
    float dqE;
    float dqF;
    float dqG;
    float dqH;
    float dqI;
    private PointF dqJ;
    private Paint dqK;
    private a dqL;
    private RectF dqM;
    private PointF dqN;
    private PointF dqO;
    private PointF dqP;
    private float dqQ;
    private int dqR;
    private int dqS;
    private ValueAnimator dqT;
    private float dqU;
    private float dqV;
    private ValueAnimator dqW;
    private Bitmap mBitmap;
    private Camera mCamera;
    private Canvas mCanvas;
    private Matrix mMatrix;
    private Paint mPaint;
    private int mState;
    private float mWidth;

    /* loaded from: classes10.dex */
    public interface a {
        void gl(boolean z);
    }

    static /* synthetic */ int a(RefreshingAnimView refreshingAnimView) {
        int i = refreshingAnimView.dqS;
        refreshingAnimView.dqS = i + 1;
        return i;
    }

    public RefreshingAnimView(Context context) {
        super(context);
        this.dqC = 0.0f;
        this.dqD = 0.0f;
        this.dqE = 0.0f;
        this.dqF = 0.0f;
        this.dqG = 0.0f;
        this.dqH = 0.0f;
        this.dqI = 0.0f;
        this.mWidth = 0.0f;
        this.dqJ = new PointF();
        this.dqM = new RectF();
        this.dqN = new PointF();
        this.dqO = new PointF();
        this.dqP = new PointF();
        this.dqQ = 0.0f;
        this.dqR = 0;
        this.dqS = 1;
        this.dqT = null;
        this.dqU = 0.0f;
        this.dqV = 0.0f;
        this.dqW = null;
        this.dpn = false;
        this.mState = 0;
        sw();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dqC = 0.0f;
        this.dqD = 0.0f;
        this.dqE = 0.0f;
        this.dqF = 0.0f;
        this.dqG = 0.0f;
        this.dqH = 0.0f;
        this.dqI = 0.0f;
        this.mWidth = 0.0f;
        this.dqJ = new PointF();
        this.dqM = new RectF();
        this.dqN = new PointF();
        this.dqO = new PointF();
        this.dqP = new PointF();
        this.dqQ = 0.0f;
        this.dqR = 0;
        this.dqS = 1;
        this.dqT = null;
        this.dqU = 0.0f;
        this.dqV = 0.0f;
        this.dqW = null;
        this.dpn = false;
        this.mState = 0;
        sw();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dqC = 0.0f;
        this.dqD = 0.0f;
        this.dqE = 0.0f;
        this.dqF = 0.0f;
        this.dqG = 0.0f;
        this.dqH = 0.0f;
        this.dqI = 0.0f;
        this.mWidth = 0.0f;
        this.dqJ = new PointF();
        this.dqM = new RectF();
        this.dqN = new PointF();
        this.dqO = new PointF();
        this.dqP = new PointF();
        this.dqQ = 0.0f;
        this.dqR = 0;
        this.dqS = 1;
        this.dqT = null;
        this.dqU = 0.0f;
        this.dqV = 0.0f;
        this.dqW = null;
        this.dpn = false;
        this.mState = 0;
        sw();
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        this.dqC = f2 <= 1.0f ? f2 : 1.0f;
        aGN();
        postInvalidate();
    }

    public void aGM() {
        cm(300L);
    }

    private void cm(long j) {
        jP(2);
        if (this.dqW != null) {
            aGy();
        }
        this.dqW = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.dqW.setDuration(j);
        this.dqW.setInterpolator(new LinearInterpolator());
        this.dqW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.L(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.dqW.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.2
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
        if (!this.dqW.isRunning()) {
            this.dqW.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cn(long j) {
        jP(3);
        if (this.dqT != null) {
            aGy();
        }
        this.dqT = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.dqT.setDuration(j);
        this.dqT.setInterpolator(new LinearInterpolator());
        this.dqT.setRepeatCount(-1);
        this.dqT.setRepeatMode(1);
        this.dqT.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.M(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        if (this.dqR > 0) {
            this.dqT.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.4
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
                    if (RefreshingAnimView.this.dqS > RefreshingAnimView.this.dqR && RefreshingAnimView.this.dqL != null) {
                        RefreshingAnimView.this.dqL.gl(true);
                    }
                }
            });
        } else if (this.dqL != null) {
            this.dqL.gl(true);
        }
        if (!this.dqT.isRunning()) {
            this.dqT.start();
        }
    }

    public void setAtLeastRotateRounds(int i) {
        this.dqR = i;
    }

    public void setOnLoadingAnimationListener(a aVar) {
        this.dqL = aVar;
    }

    public void stopAnim() {
        aGy();
        clearAnimation();
        this.dqC = 0.0f;
        this.dqS = 1;
        jP(1);
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
        this.dqF = ah.dip2px(getContext(), 8.0f);
        this.dqH = ah.dip2px(getContext(), 6.5f);
        this.dqQ = ah.dip2px(getContext(), 5.0f);
        this.dqI = ah.dip2px(getContext(), 7.5f);
        float f = this.mWidth / 2.0f;
        this.dqJ.set(f, f);
        float f2 = f + ((float) (this.dqF / dqB));
        this.dqO.set(f2, f2);
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
            if (this.dpn != com.baidu.swan.apps.t.a.awW().getNightModeSwitcherState()) {
                this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
                this.dpn = com.baidu.swan.apps.t.a.awW().getNightModeSwitcherState();
            }
            this.mPaint.setAlpha(76);
            this.dqM.set(this.dqJ.x - this.dqF, this.dqJ.y - this.dqF, this.dqJ.x + this.dqF, this.dqJ.y + this.dqF);
            this.mCanvas.drawArc(this.dqM, -90.0f, (-360.0f) * this.dqD, true, this.mPaint);
            this.mCanvas.drawCircle(this.dqJ.x, this.dqJ.y, this.dqG, this.dqK);
            if (this.dqE > 0.0f) {
                this.mCanvas.drawCircle(this.dqP.x, this.dqP.y, 0.75f, this.mPaint);
                this.mPaint.setStyle(Paint.Style.STROKE);
                this.mPaint.setStrokeWidth(ah.dip2px(getContext(), 1.5f));
                this.mCanvas.drawLine(this.dqO.x, this.dqO.y, this.dqP.x, this.dqP.y, this.mPaint);
            }
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    private void aGN() {
        this.dqD = this.dqC;
        if (this.dqC < 0.5f) {
            this.dqE = 0.0f;
            this.dqG = 0.0f;
            return;
        }
        this.dqG = ((this.dqC - 0.5f) / 0.5f) * this.dqH;
        if (this.dqC < 0.625f) {
            this.dqE = 0.0f;
            return;
        }
        this.dqE = (this.dqC - 0.625f) / 0.375f;
        this.dqP.set(this.dqO.x + ((float) ((this.dqQ * this.dqE) / dqB)), this.dqO.y + ((float) ((this.dqQ * this.dqE) / dqB)));
    }

    private void u(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setAlpha((int) (255.0d * ((this.dqV * 0.3d) + 0.3d)));
            float f = this.dqO.x + ((float) (this.dqQ / dqB));
            this.mCanvas.drawCircle(this.dqJ.x, this.dqJ.y, this.dqF, this.mPaint);
            this.mCanvas.drawCircle(this.dqJ.x, this.dqJ.y, this.dqH, this.dqK);
            this.mCanvas.drawCircle(f, f, 0.75f, this.mPaint);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(ah.dip2px(getContext(), 1.5f));
            this.mCanvas.drawLine(this.dqO.x, this.dqO.y, f, f, this.mPaint);
            this.mMatrix.reset();
            this.mCamera.save();
            this.mCamera.setLocation(0.0f, 0.0f, -100.0f);
            this.mCamera.rotateY(this.dqV * 90.0f);
            this.mCamera.getMatrix(this.mMatrix);
            this.mCamera.restore();
            this.mMatrix.preTranslate(-this.dqJ.x, -this.dqJ.y);
            this.mMatrix.postTranslate(this.dqJ.x, this.dqJ.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(float f) {
        this.dqV = f;
        postInvalidate();
    }

    private void v(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            int abs = (int) ((((1.0d - (Math.abs(this.dqU - 0.5d) * 2.0d)) * 0.3d) + 0.3d) * 255.0d);
            if (this.dpn) {
                abs = (int) ((((1.0d - (Math.abs(this.dqU - 0.5d) * 2.0d)) * 0.2d) + 0.1d) * 255.0d);
            }
            this.mPaint.setAlpha(abs);
            this.mCanvas.drawCircle(this.dqJ.x, this.dqJ.y, this.dqI, this.mPaint);
            this.mMatrix.reset();
            this.mCamera.save();
            this.mCamera.setLocation(0.0f, 0.0f, -100.0f);
            this.mCamera.rotateY((this.dqU * 360.0f) + 90.0f);
            this.mCamera.getMatrix(this.mMatrix);
            this.mCamera.restore();
            this.mMatrix.preTranslate(-this.dqJ.x, -this.dqJ.y);
            this.mMatrix.postTranslate(this.dqJ.x, this.dqJ.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(float f) {
        if (f < 0.2f) {
            this.dqU = (f / 0.2f) * 0.5f;
        } else {
            this.dqU = (((f - 0.2f) / 0.8f) * 0.5f) + 0.5f;
        }
        postInvalidate();
    }

    private void sw() {
        this.dpn = com.baidu.swan.apps.t.a.awW().getNightModeSwitcherState();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
        this.dqK = new Paint();
        this.dqK.setAntiAlias(true);
        this.dqK.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.mCamera = new Camera();
        this.mMatrix = new Matrix();
        jP(1);
    }

    private void jP(int i) {
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

    private void aGy() {
        if (this.dqW != null) {
            this.dqW.setRepeatCount(0);
            this.dqW.removeAllUpdateListeners();
            this.dqW.removeAllListeners();
            this.dqW.end();
            this.dqW.cancel();
        }
        if (this.dqT != null) {
            this.dqT.setRepeatCount(0);
            this.dqT.removeAllUpdateListeners();
            this.dqT.removeAllListeners();
            this.dqT.end();
            this.dqT.cancel();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aGy();
    }
}
