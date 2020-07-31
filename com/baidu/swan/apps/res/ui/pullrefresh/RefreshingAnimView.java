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
import com.baidu.swan.apps.aq.ai;
/* loaded from: classes7.dex */
public class RefreshingAnimView extends View {
    private static final double cEX = Math.sqrt(2.0d);
    private boolean cDJ;
    float cEY;
    float cEZ;
    float cFa;
    float cFb;
    float cFc;
    float cFd;
    float cFe;
    private PointF cFf;
    private Paint cFg;
    private a cFh;
    private RectF cFi;
    private PointF cFj;
    private PointF cFk;
    private PointF cFl;
    private float cFm;
    private int cFn;
    private int cFo;
    private ValueAnimator cFp;
    private float cFq;
    private float cFr;
    private ValueAnimator cFs;
    private Bitmap mBitmap;
    private Camera mCamera;
    private Canvas mCanvas;
    private Matrix mMatrix;
    private Paint mPaint;
    private int mState;
    private float mWidth;

    /* loaded from: classes7.dex */
    public interface a {
        void fb(boolean z);
    }

    static /* synthetic */ int a(RefreshingAnimView refreshingAnimView) {
        int i = refreshingAnimView.cFo;
        refreshingAnimView.cFo = i + 1;
        return i;
    }

    public RefreshingAnimView(Context context) {
        super(context);
        this.cEY = 0.0f;
        this.cEZ = 0.0f;
        this.cFa = 0.0f;
        this.cFb = 0.0f;
        this.cFc = 0.0f;
        this.cFd = 0.0f;
        this.cFe = 0.0f;
        this.mWidth = 0.0f;
        this.cFf = new PointF();
        this.cFi = new RectF();
        this.cFj = new PointF();
        this.cFk = new PointF();
        this.cFl = new PointF();
        this.cFm = 0.0f;
        this.cFn = 0;
        this.cFo = 1;
        this.cFp = null;
        this.cFq = 0.0f;
        this.cFr = 0.0f;
        this.cFs = null;
        this.cDJ = false;
        this.mState = 0;
        qS();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cEY = 0.0f;
        this.cEZ = 0.0f;
        this.cFa = 0.0f;
        this.cFb = 0.0f;
        this.cFc = 0.0f;
        this.cFd = 0.0f;
        this.cFe = 0.0f;
        this.mWidth = 0.0f;
        this.cFf = new PointF();
        this.cFi = new RectF();
        this.cFj = new PointF();
        this.cFk = new PointF();
        this.cFl = new PointF();
        this.cFm = 0.0f;
        this.cFn = 0;
        this.cFo = 1;
        this.cFp = null;
        this.cFq = 0.0f;
        this.cFr = 0.0f;
        this.cFs = null;
        this.cDJ = false;
        this.mState = 0;
        qS();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cEY = 0.0f;
        this.cEZ = 0.0f;
        this.cFa = 0.0f;
        this.cFb = 0.0f;
        this.cFc = 0.0f;
        this.cFd = 0.0f;
        this.cFe = 0.0f;
        this.mWidth = 0.0f;
        this.cFf = new PointF();
        this.cFi = new RectF();
        this.cFj = new PointF();
        this.cFk = new PointF();
        this.cFl = new PointF();
        this.cFm = 0.0f;
        this.cFn = 0;
        this.cFo = 1;
        this.cFp = null;
        this.cFq = 0.0f;
        this.cFr = 0.0f;
        this.cFs = null;
        this.cDJ = false;
        this.mState = 0;
        qS();
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        this.cEY = f2 <= 1.0f ? f2 : 1.0f;
        aqP();
        postInvalidate();
    }

    public void aqO() {
        by(300L);
    }

    private void by(long j) {
        changeState(2);
        if (this.cFs != null) {
            aqA();
        }
        this.cFs = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.cFs.setDuration(j);
        this.cFs.setInterpolator(new LinearInterpolator());
        this.cFs.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.B(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.cFs.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                RefreshingAnimView.this.bz(750L);
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
        if (!this.cFs.isRunning()) {
            this.cFs.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bz(long j) {
        changeState(3);
        if (this.cFp != null) {
            aqA();
        }
        this.cFp = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.cFp.setDuration(j);
        this.cFp.setInterpolator(new LinearInterpolator());
        this.cFp.setRepeatCount(-1);
        this.cFp.setRepeatMode(1);
        this.cFp.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.C(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        if (this.cFn > 0) {
            this.cFp.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.4
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
                    if (RefreshingAnimView.this.cFo > RefreshingAnimView.this.cFn && RefreshingAnimView.this.cFh != null) {
                        RefreshingAnimView.this.cFh.fb(true);
                    }
                }
            });
        } else if (this.cFh != null) {
            this.cFh.fb(true);
        }
        if (!this.cFp.isRunning()) {
            this.cFp.start();
        }
    }

    public void setAtLeastRotateRounds(int i) {
        this.cFn = i;
    }

    public void setOnLoadingAnimationListener(a aVar) {
        this.cFh = aVar;
    }

    public void stopAnim() {
        aqA();
        clearAnimation();
        this.cEY = 0.0f;
        this.cFo = 1;
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
        this.cFb = ai.dip2px(getContext(), 8.0f);
        this.cFd = ai.dip2px(getContext(), 6.5f);
        this.cFm = ai.dip2px(getContext(), 5.0f);
        this.cFe = ai.dip2px(getContext(), 7.5f);
        float f = this.mWidth / 2.0f;
        this.cFf.set(f, f);
        float f2 = f + ((float) (this.cFb / cEX));
        this.cFk.set(f2, f2);
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
            if (this.cDJ != com.baidu.swan.apps.t.a.ahF().getNightModeSwitcherState()) {
                this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
                this.cDJ = com.baidu.swan.apps.t.a.ahF().getNightModeSwitcherState();
            }
            this.mPaint.setAlpha(76);
            this.cFi.set(this.cFf.x - this.cFb, this.cFf.y - this.cFb, this.cFf.x + this.cFb, this.cFf.y + this.cFb);
            this.mCanvas.drawArc(this.cFi, -90.0f, (-360.0f) * this.cEZ, true, this.mPaint);
            this.mCanvas.drawCircle(this.cFf.x, this.cFf.y, this.cFc, this.cFg);
            if (this.cFa > 0.0f) {
                this.mCanvas.drawCircle(this.cFl.x, this.cFl.y, 0.75f, this.mPaint);
                this.mPaint.setStyle(Paint.Style.STROKE);
                this.mPaint.setStrokeWidth(ai.dip2px(getContext(), 1.5f));
                this.mCanvas.drawLine(this.cFk.x, this.cFk.y, this.cFl.x, this.cFl.y, this.mPaint);
            }
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    private void aqP() {
        this.cEZ = this.cEY;
        if (this.cEY < 0.5f) {
            this.cFa = 0.0f;
            this.cFc = 0.0f;
            return;
        }
        this.cFc = ((this.cEY - 0.5f) / 0.5f) * this.cFd;
        if (this.cEY < 0.625f) {
            this.cFa = 0.0f;
            return;
        }
        this.cFa = (this.cEY - 0.625f) / 0.375f;
        this.cFl.set(this.cFk.x + ((float) ((this.cFm * this.cFa) / cEX)), this.cFk.y + ((float) ((this.cFm * this.cFa) / cEX)));
    }

    private void s(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setAlpha((int) (255.0d * ((this.cFr * 0.3d) + 0.3d)));
            float f = this.cFk.x + ((float) (this.cFm / cEX));
            this.mCanvas.drawCircle(this.cFf.x, this.cFf.y, this.cFb, this.mPaint);
            this.mCanvas.drawCircle(this.cFf.x, this.cFf.y, this.cFd, this.cFg);
            this.mCanvas.drawCircle(f, f, 0.75f, this.mPaint);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(ai.dip2px(getContext(), 1.5f));
            this.mCanvas.drawLine(this.cFk.x, this.cFk.y, f, f, this.mPaint);
            this.mMatrix.reset();
            this.mCamera.save();
            this.mCamera.setLocation(0.0f, 0.0f, -100.0f);
            this.mCamera.rotateY(this.cFr * 90.0f);
            this.mCamera.getMatrix(this.mMatrix);
            this.mCamera.restore();
            this.mMatrix.preTranslate(-this.cFf.x, -this.cFf.y);
            this.mMatrix.postTranslate(this.cFf.x, this.cFf.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(float f) {
        this.cFr = f;
        postInvalidate();
    }

    private void t(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            int abs = (int) ((((1.0d - (Math.abs(this.cFq - 0.5d) * 2.0d)) * 0.3d) + 0.3d) * 255.0d);
            if (this.cDJ) {
                abs = (int) ((((1.0d - (Math.abs(this.cFq - 0.5d) * 2.0d)) * 0.2d) + 0.1d) * 255.0d);
            }
            this.mPaint.setAlpha(abs);
            this.mCanvas.drawCircle(this.cFf.x, this.cFf.y, this.cFe, this.mPaint);
            this.mMatrix.reset();
            this.mCamera.save();
            this.mCamera.setLocation(0.0f, 0.0f, -100.0f);
            this.mCamera.rotateY((this.cFq * 360.0f) + 90.0f);
            this.mCamera.getMatrix(this.mMatrix);
            this.mCamera.restore();
            this.mMatrix.preTranslate(-this.cFf.x, -this.cFf.y);
            this.mMatrix.postTranslate(this.cFf.x, this.cFf.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(float f) {
        if (f < 0.2f) {
            this.cFq = (f / 0.2f) * 0.5f;
        } else {
            this.cFq = (((f - 0.2f) / 0.8f) * 0.5f) + 0.5f;
        }
        postInvalidate();
    }

    private void qS() {
        this.cDJ = com.baidu.swan.apps.t.a.ahF().getNightModeSwitcherState();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
        this.cFg = new Paint();
        this.cFg.setAntiAlias(true);
        this.cFg.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
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

    private void aqA() {
        if (this.cFs != null) {
            this.cFs.setRepeatCount(0);
            this.cFs.removeAllUpdateListeners();
            this.cFs.removeAllListeners();
            this.cFs.end();
            this.cFs.cancel();
        }
        if (this.cFp != null) {
            this.cFp.setRepeatCount(0);
            this.cFp.removeAllUpdateListeners();
            this.cFp.removeAllListeners();
            this.cFp.end();
            this.cFp.cancel();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aqA();
    }
}
