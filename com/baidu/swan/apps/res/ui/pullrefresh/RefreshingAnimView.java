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
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.z;
/* loaded from: classes2.dex */
public class RefreshingAnimView extends View {
    private static final double bft = Math.sqrt(2.0d);
    private Camera aoR;
    private boolean bec;
    float bfA;
    private PointF bfB;
    private Paint bfC;
    private a bfD;
    private RectF bfE;
    private PointF bfF;
    private PointF bfG;
    private PointF bfH;
    private float bfI;
    private int bfJ;
    private int bfK;
    private ValueAnimator bfL;
    private float bfM;
    private float bfN;
    private ValueAnimator bfO;
    float bfu;
    float bfv;
    float bfw;
    float bfx;
    float bfy;
    float bfz;
    private Bitmap mBitmap;
    private Canvas mCanvas;
    private Matrix mMatrix;
    private Paint mPaint;
    private int mState;
    private float mWidth;

    /* loaded from: classes2.dex */
    public interface a {
        void ch(boolean z);
    }

    static /* synthetic */ int a(RefreshingAnimView refreshingAnimView) {
        int i = refreshingAnimView.bfK;
        refreshingAnimView.bfK = i + 1;
        return i;
    }

    public RefreshingAnimView(Context context) {
        super(context);
        this.bfu = 0.0f;
        this.bfv = 0.0f;
        this.bfw = 0.0f;
        this.bfx = 0.0f;
        this.bfy = 0.0f;
        this.bfz = 0.0f;
        this.bfA = 0.0f;
        this.mWidth = 0.0f;
        this.bfB = new PointF();
        this.bfE = new RectF();
        this.bfF = new PointF();
        this.bfG = new PointF();
        this.bfH = new PointF();
        this.bfI = 0.0f;
        this.bfJ = 0;
        this.bfK = 1;
        this.bfL = null;
        this.bfM = 0.0f;
        this.bfN = 0.0f;
        this.bfO = null;
        this.bec = false;
        this.mState = 0;
        lj();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bfu = 0.0f;
        this.bfv = 0.0f;
        this.bfw = 0.0f;
        this.bfx = 0.0f;
        this.bfy = 0.0f;
        this.bfz = 0.0f;
        this.bfA = 0.0f;
        this.mWidth = 0.0f;
        this.bfB = new PointF();
        this.bfE = new RectF();
        this.bfF = new PointF();
        this.bfG = new PointF();
        this.bfH = new PointF();
        this.bfI = 0.0f;
        this.bfJ = 0;
        this.bfK = 1;
        this.bfL = null;
        this.bfM = 0.0f;
        this.bfN = 0.0f;
        this.bfO = null;
        this.bec = false;
        this.mState = 0;
        lj();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bfu = 0.0f;
        this.bfv = 0.0f;
        this.bfw = 0.0f;
        this.bfx = 0.0f;
        this.bfy = 0.0f;
        this.bfz = 0.0f;
        this.bfA = 0.0f;
        this.mWidth = 0.0f;
        this.bfB = new PointF();
        this.bfE = new RectF();
        this.bfF = new PointF();
        this.bfG = new PointF();
        this.bfH = new PointF();
        this.bfI = 0.0f;
        this.bfJ = 0;
        this.bfK = 1;
        this.bfL = null;
        this.bfM = 0.0f;
        this.bfN = 0.0f;
        this.bfO = null;
        this.bec = false;
        this.mState = 0;
        lj();
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        this.bfu = f2 <= 1.0f ? f2 : 1.0f;
        PD();
        postInvalidate();
    }

    public void PC() {
        ai(300L);
    }

    private void ai(long j) {
        dW(2);
        if (this.bfO != null) {
            Po();
        }
        this.bfO = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.bfO.setDuration(j);
        this.bfO.setInterpolator(new LinearInterpolator());
        this.bfO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.O(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.bfO.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                RefreshingAnimView.this.aj(750L);
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
        if (!this.bfO.isRunning()) {
            this.bfO.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aj(long j) {
        dW(3);
        if (this.bfL != null) {
            Po();
        }
        this.bfL = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.bfL.setDuration(j);
        this.bfL.setInterpolator(new LinearInterpolator());
        this.bfL.setRepeatCount(-1);
        this.bfL.setRepeatMode(1);
        this.bfL.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.P(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        if (this.bfJ > 0) {
            this.bfL.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.4
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
                    if (RefreshingAnimView.this.bfK > RefreshingAnimView.this.bfJ && RefreshingAnimView.this.bfD != null) {
                        RefreshingAnimView.this.bfD.ch(true);
                    }
                }
            });
        } else if (this.bfD != null) {
            this.bfD.ch(true);
        }
        if (!this.bfL.isRunning()) {
            this.bfL.start();
        }
    }

    public void setAtLeastRotateRounds(int i) {
        this.bfJ = i;
    }

    public void setOnLoadingAnimationListener(a aVar) {
        this.bfD = aVar;
    }

    public void stopAnim() {
        Po();
        clearAnimation();
        this.bfu = 0.0f;
        this.bfK = 1;
        dW(1);
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
        this.bfx = z.dip2px(getContext(), 8.0f);
        this.bfz = z.dip2px(getContext(), 6.5f);
        this.bfI = z.dip2px(getContext(), 5.0f);
        this.bfA = z.dip2px(getContext(), 7.5f);
        float f = this.mWidth / 2.0f;
        this.bfB.set(f, f);
        float f2 = f + ((float) (this.bfx / bft));
        this.bfG.set(f2, f2);
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
        Log.w("RefreshingAnimView", "onDraw->mState:" + PE() + ";AnimValue:" + this.bfu);
    }

    private void t(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            if (this.bec != com.baidu.swan.apps.u.a.JE().Kd()) {
                this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
                this.bec = com.baidu.swan.apps.u.a.JE().Kd();
            }
            this.mPaint.setAlpha(76);
            this.bfE.set(this.bfB.x - this.bfx, this.bfB.y - this.bfx, this.bfB.x + this.bfx, this.bfB.y + this.bfx);
            this.mCanvas.drawArc(this.bfE, -90.0f, (-360.0f) * this.bfv, true, this.mPaint);
            this.mCanvas.drawCircle(this.bfB.x, this.bfB.y, this.bfy, this.bfC);
            if (this.bfw > 0.0f) {
                this.mCanvas.drawCircle(this.bfH.x, this.bfH.y, 0.75f, this.mPaint);
                this.mPaint.setStyle(Paint.Style.STROKE);
                this.mPaint.setStrokeWidth(z.dip2px(getContext(), 1.5f));
                this.mCanvas.drawLine(this.bfG.x, this.bfG.y, this.bfH.x, this.bfH.y, this.mPaint);
            }
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    private void PD() {
        this.bfv = this.bfu;
        if (this.bfu < 0.5f) {
            this.bfw = 0.0f;
            this.bfy = 0.0f;
            return;
        }
        this.bfy = ((this.bfu - 0.5f) / 0.5f) * this.bfz;
        if (this.bfu < 0.625f) {
            this.bfw = 0.0f;
            return;
        }
        this.bfw = (this.bfu - 0.625f) / 0.375f;
        this.bfH.set(this.bfG.x + ((float) ((this.bfI * this.bfw) / bft)), this.bfG.y + ((float) ((this.bfI * this.bfw) / bft)));
    }

    private void u(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setAlpha((int) (255.0d * ((this.bfN * 0.3d) + 0.3d)));
            float f = this.bfG.x + ((float) (this.bfI / bft));
            this.mCanvas.drawCircle(this.bfB.x, this.bfB.y, this.bfx, this.mPaint);
            this.mCanvas.drawCircle(this.bfB.x, this.bfB.y, this.bfz, this.bfC);
            this.mCanvas.drawCircle(f, f, 0.75f, this.mPaint);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(z.dip2px(getContext(), 1.5f));
            this.mCanvas.drawLine(this.bfG.x, this.bfG.y, f, f, this.mPaint);
            this.mMatrix.reset();
            this.aoR.save();
            this.aoR.setLocation(0.0f, 0.0f, -100.0f);
            this.aoR.rotateY(this.bfN * 90.0f);
            this.aoR.getMatrix(this.mMatrix);
            this.aoR.restore();
            this.mMatrix.preTranslate(-this.bfB.x, -this.bfB.y);
            this.mMatrix.postTranslate(this.bfB.x, this.bfB.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(float f) {
        this.bfN = f;
        postInvalidate();
    }

    private void v(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            int abs = (int) ((((1.0d - (Math.abs(this.bfM - 0.5d) * 2.0d)) * 0.3d) + 0.3d) * 255.0d);
            if (this.bec) {
                abs = (int) ((((1.0d - (Math.abs(this.bfM - 0.5d) * 2.0d)) * 0.2d) + 0.1d) * 255.0d);
            }
            this.mPaint.setAlpha(abs);
            this.mCanvas.drawCircle(this.bfB.x, this.bfB.y, this.bfA, this.mPaint);
            this.mMatrix.reset();
            this.aoR.save();
            this.aoR.setLocation(0.0f, 0.0f, -100.0f);
            this.aoR.rotateY((this.bfM * 360.0f) + 90.0f);
            this.aoR.getMatrix(this.mMatrix);
            this.aoR.restore();
            this.mMatrix.preTranslate(-this.bfB.x, -this.bfB.y);
            this.mMatrix.postTranslate(this.bfB.x, this.bfB.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(float f) {
        if (f < 0.2f) {
            this.bfM = (f / 0.2f) * 0.5f;
        } else {
            this.bfM = (((f - 0.2f) / 0.8f) * 0.5f) + 0.5f;
        }
        postInvalidate();
    }

    private void lj() {
        this.bec = com.baidu.swan.apps.u.a.JE().Kd();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
        this.bfC = new Paint();
        this.bfC.setAntiAlias(true);
        this.bfC.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.aoR = new Camera();
        this.mMatrix = new Matrix();
        dW(1);
    }

    private void dW(int i) {
        this.mState = i;
    }

    private String PE() {
        switch (this.mState) {
            case 1:
                return "Magnifier";
            case 2:
                return "Transitions";
            case 3:
                return "Radar";
            default:
                return "None";
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            this.mBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            this.mCanvas = new Canvas(this.mBitmap);
        }
    }

    private void Po() {
        if (this.bfO != null) {
            this.bfO.setRepeatCount(0);
            this.bfO.removeAllUpdateListeners();
            this.bfO.removeAllListeners();
            this.bfO.end();
            this.bfO.cancel();
        }
        if (this.bfL != null) {
            this.bfL.setRepeatCount(0);
            this.bfL.removeAllUpdateListeners();
            this.bfL.removeAllListeners();
            this.bfL.end();
            this.bfL.cancel();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Po();
    }
}
