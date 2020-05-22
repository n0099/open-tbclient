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
import com.baidu.swan.apps.aq.ag;
/* loaded from: classes11.dex */
public class RefreshingAnimView extends View {
    private static final double cxA = Math.sqrt(2.0d);
    private boolean cwm;
    float cxB;
    float cxC;
    float cxD;
    float cxE;
    float cxF;
    float cxG;
    float cxH;
    private PointF cxI;
    private Paint cxJ;
    private a cxK;
    private RectF cxL;
    private PointF cxM;
    private PointF cxN;
    private PointF cxO;
    private float cxP;
    private int cxQ;
    private int cxR;
    private ValueAnimator cxS;
    private float cxT;
    private float cxU;
    private ValueAnimator cxV;
    private Bitmap mBitmap;
    private Camera mCamera;
    private Canvas mCanvas;
    private Matrix mMatrix;
    private Paint mPaint;
    private int mState;
    private float mWidth;

    /* loaded from: classes11.dex */
    public interface a {
        void eN(boolean z);
    }

    static /* synthetic */ int a(RefreshingAnimView refreshingAnimView) {
        int i = refreshingAnimView.cxR;
        refreshingAnimView.cxR = i + 1;
        return i;
    }

    public RefreshingAnimView(Context context) {
        super(context);
        this.cxB = 0.0f;
        this.cxC = 0.0f;
        this.cxD = 0.0f;
        this.cxE = 0.0f;
        this.cxF = 0.0f;
        this.cxG = 0.0f;
        this.cxH = 0.0f;
        this.mWidth = 0.0f;
        this.cxI = new PointF();
        this.cxL = new RectF();
        this.cxM = new PointF();
        this.cxN = new PointF();
        this.cxO = new PointF();
        this.cxP = 0.0f;
        this.cxQ = 0;
        this.cxR = 1;
        this.cxS = null;
        this.cxT = 0.0f;
        this.cxU = 0.0f;
        this.cxV = null;
        this.cwm = false;
        this.mState = 0;
        qy();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cxB = 0.0f;
        this.cxC = 0.0f;
        this.cxD = 0.0f;
        this.cxE = 0.0f;
        this.cxF = 0.0f;
        this.cxG = 0.0f;
        this.cxH = 0.0f;
        this.mWidth = 0.0f;
        this.cxI = new PointF();
        this.cxL = new RectF();
        this.cxM = new PointF();
        this.cxN = new PointF();
        this.cxO = new PointF();
        this.cxP = 0.0f;
        this.cxQ = 0;
        this.cxR = 1;
        this.cxS = null;
        this.cxT = 0.0f;
        this.cxU = 0.0f;
        this.cxV = null;
        this.cwm = false;
        this.mState = 0;
        qy();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cxB = 0.0f;
        this.cxC = 0.0f;
        this.cxD = 0.0f;
        this.cxE = 0.0f;
        this.cxF = 0.0f;
        this.cxG = 0.0f;
        this.cxH = 0.0f;
        this.mWidth = 0.0f;
        this.cxI = new PointF();
        this.cxL = new RectF();
        this.cxM = new PointF();
        this.cxN = new PointF();
        this.cxO = new PointF();
        this.cxP = 0.0f;
        this.cxQ = 0;
        this.cxR = 1;
        this.cxS = null;
        this.cxT = 0.0f;
        this.cxU = 0.0f;
        this.cxV = null;
        this.cwm = false;
        this.mState = 0;
        qy();
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        this.cxB = f2 <= 1.0f ? f2 : 1.0f;
        anZ();
        postInvalidate();
    }

    public void anY() {
        bn(300L);
    }

    private void bn(long j) {
        changeState(2);
        if (this.cxV != null) {
            anK();
        }
        this.cxV = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.cxV.setDuration(j);
        this.cxV.setInterpolator(new LinearInterpolator());
        this.cxV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.v(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.cxV.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                RefreshingAnimView.this.bo(750L);
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
        if (!this.cxV.isRunning()) {
            this.cxV.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bo(long j) {
        changeState(3);
        if (this.cxS != null) {
            anK();
        }
        this.cxS = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.cxS.setDuration(j);
        this.cxS.setInterpolator(new LinearInterpolator());
        this.cxS.setRepeatCount(-1);
        this.cxS.setRepeatMode(1);
        this.cxS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.A(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        if (this.cxQ > 0) {
            this.cxS.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.4
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
                    if (RefreshingAnimView.this.cxR > RefreshingAnimView.this.cxQ && RefreshingAnimView.this.cxK != null) {
                        RefreshingAnimView.this.cxK.eN(true);
                    }
                }
            });
        } else if (this.cxK != null) {
            this.cxK.eN(true);
        }
        if (!this.cxS.isRunning()) {
            this.cxS.start();
        }
    }

    public void setAtLeastRotateRounds(int i) {
        this.cxQ = i;
    }

    public void setOnLoadingAnimationListener(a aVar) {
        this.cxK = aVar;
    }

    public void stopAnim() {
        anK();
        clearAnimation();
        this.cxB = 0.0f;
        this.cxR = 1;
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
        this.cxE = ag.dip2px(getContext(), 8.0f);
        this.cxG = ag.dip2px(getContext(), 6.5f);
        this.cxP = ag.dip2px(getContext(), 5.0f);
        this.cxH = ag.dip2px(getContext(), 7.5f);
        float f = this.mWidth / 2.0f;
        this.cxI.set(f, f);
        float f2 = f + ((float) (this.cxE / cxA));
        this.cxN.set(f2, f2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        switch (this.mState) {
            case 1:
                r(canvas);
                break;
            case 2:
                s(canvas);
                break;
            case 3:
                t(canvas);
                break;
        }
        canvas.restore();
    }

    private void r(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            if (this.cwm != com.baidu.swan.apps.u.a.afm().getNightModeSwitcherState()) {
                this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
                this.cwm = com.baidu.swan.apps.u.a.afm().getNightModeSwitcherState();
            }
            this.mPaint.setAlpha(76);
            this.cxL.set(this.cxI.x - this.cxE, this.cxI.y - this.cxE, this.cxI.x + this.cxE, this.cxI.y + this.cxE);
            this.mCanvas.drawArc(this.cxL, -90.0f, (-360.0f) * this.cxC, true, this.mPaint);
            this.mCanvas.drawCircle(this.cxI.x, this.cxI.y, this.cxF, this.cxJ);
            if (this.cxD > 0.0f) {
                this.mCanvas.drawCircle(this.cxO.x, this.cxO.y, 0.75f, this.mPaint);
                this.mPaint.setStyle(Paint.Style.STROKE);
                this.mPaint.setStrokeWidth(ag.dip2px(getContext(), 1.5f));
                this.mCanvas.drawLine(this.cxN.x, this.cxN.y, this.cxO.x, this.cxO.y, this.mPaint);
            }
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    private void anZ() {
        this.cxC = this.cxB;
        if (this.cxB < 0.5f) {
            this.cxD = 0.0f;
            this.cxF = 0.0f;
            return;
        }
        this.cxF = ((this.cxB - 0.5f) / 0.5f) * this.cxG;
        if (this.cxB < 0.625f) {
            this.cxD = 0.0f;
            return;
        }
        this.cxD = (this.cxB - 0.625f) / 0.375f;
        this.cxO.set(this.cxN.x + ((float) ((this.cxP * this.cxD) / cxA)), this.cxN.y + ((float) ((this.cxP * this.cxD) / cxA)));
    }

    private void s(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setAlpha((int) (255.0d * ((this.cxU * 0.3d) + 0.3d)));
            float f = this.cxN.x + ((float) (this.cxP / cxA));
            this.mCanvas.drawCircle(this.cxI.x, this.cxI.y, this.cxE, this.mPaint);
            this.mCanvas.drawCircle(this.cxI.x, this.cxI.y, this.cxG, this.cxJ);
            this.mCanvas.drawCircle(f, f, 0.75f, this.mPaint);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(ag.dip2px(getContext(), 1.5f));
            this.mCanvas.drawLine(this.cxN.x, this.cxN.y, f, f, this.mPaint);
            this.mMatrix.reset();
            this.mCamera.save();
            this.mCamera.setLocation(0.0f, 0.0f, -100.0f);
            this.mCamera.rotateY(this.cxU * 90.0f);
            this.mCamera.getMatrix(this.mMatrix);
            this.mCamera.restore();
            this.mMatrix.preTranslate(-this.cxI.x, -this.cxI.y);
            this.mMatrix.postTranslate(this.cxI.x, this.cxI.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(float f) {
        this.cxU = f;
        postInvalidate();
    }

    private void t(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            int abs = (int) ((((1.0d - (Math.abs(this.cxT - 0.5d) * 2.0d)) * 0.3d) + 0.3d) * 255.0d);
            if (this.cwm) {
                abs = (int) ((((1.0d - (Math.abs(this.cxT - 0.5d) * 2.0d)) * 0.2d) + 0.1d) * 255.0d);
            }
            this.mPaint.setAlpha(abs);
            this.mCanvas.drawCircle(this.cxI.x, this.cxI.y, this.cxH, this.mPaint);
            this.mMatrix.reset();
            this.mCamera.save();
            this.mCamera.setLocation(0.0f, 0.0f, -100.0f);
            this.mCamera.rotateY((this.cxT * 360.0f) + 90.0f);
            this.mCamera.getMatrix(this.mMatrix);
            this.mCamera.restore();
            this.mMatrix.preTranslate(-this.cxI.x, -this.cxI.y);
            this.mMatrix.postTranslate(this.cxI.x, this.cxI.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(float f) {
        if (f < 0.2f) {
            this.cxT = (f / 0.2f) * 0.5f;
        } else {
            this.cxT = (((f - 0.2f) / 0.8f) * 0.5f) + 0.5f;
        }
        postInvalidate();
    }

    private void qy() {
        this.cwm = com.baidu.swan.apps.u.a.afm().getNightModeSwitcherState();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
        this.cxJ = new Paint();
        this.cxJ.setAntiAlias(true);
        this.cxJ.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
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

    private void anK() {
        if (this.cxV != null) {
            this.cxV.setRepeatCount(0);
            this.cxV.removeAllUpdateListeners();
            this.cxV.removeAllListeners();
            this.cxV.end();
            this.cxV.cancel();
        }
        if (this.cxS != null) {
            this.cxS.setRepeatCount(0);
            this.cxS.removeAllUpdateListeners();
            this.cxS.removeAllListeners();
            this.cxS.end();
            this.cxS.cancel();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        anK();
    }
}
