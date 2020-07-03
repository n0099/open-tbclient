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
    private static final double cCk = Math.sqrt(2.0d);
    private boolean cAW;
    private int cCA;
    private int cCB;
    private ValueAnimator cCC;
    private float cCD;
    private float cCE;
    private ValueAnimator cCF;
    float cCl;
    float cCm;
    float cCn;
    float cCo;
    float cCp;
    float cCq;
    float cCr;
    private PointF cCs;
    private Paint cCt;
    private a cCu;
    private RectF cCv;
    private PointF cCw;
    private PointF cCx;
    private PointF cCy;
    private float cCz;
    private Bitmap mBitmap;
    private Camera mCamera;
    private Canvas mCanvas;
    private Matrix mMatrix;
    private Paint mPaint;
    private int mState;
    private float mWidth;

    /* loaded from: classes11.dex */
    public interface a {
        void eS(boolean z);
    }

    static /* synthetic */ int a(RefreshingAnimView refreshingAnimView) {
        int i = refreshingAnimView.cCB;
        refreshingAnimView.cCB = i + 1;
        return i;
    }

    public RefreshingAnimView(Context context) {
        super(context);
        this.cCl = 0.0f;
        this.cCm = 0.0f;
        this.cCn = 0.0f;
        this.cCo = 0.0f;
        this.cCp = 0.0f;
        this.cCq = 0.0f;
        this.cCr = 0.0f;
        this.mWidth = 0.0f;
        this.cCs = new PointF();
        this.cCv = new RectF();
        this.cCw = new PointF();
        this.cCx = new PointF();
        this.cCy = new PointF();
        this.cCz = 0.0f;
        this.cCA = 0;
        this.cCB = 1;
        this.cCC = null;
        this.cCD = 0.0f;
        this.cCE = 0.0f;
        this.cCF = null;
        this.cAW = false;
        this.mState = 0;
        qP();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cCl = 0.0f;
        this.cCm = 0.0f;
        this.cCn = 0.0f;
        this.cCo = 0.0f;
        this.cCp = 0.0f;
        this.cCq = 0.0f;
        this.cCr = 0.0f;
        this.mWidth = 0.0f;
        this.cCs = new PointF();
        this.cCv = new RectF();
        this.cCw = new PointF();
        this.cCx = new PointF();
        this.cCy = new PointF();
        this.cCz = 0.0f;
        this.cCA = 0;
        this.cCB = 1;
        this.cCC = null;
        this.cCD = 0.0f;
        this.cCE = 0.0f;
        this.cCF = null;
        this.cAW = false;
        this.mState = 0;
        qP();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cCl = 0.0f;
        this.cCm = 0.0f;
        this.cCn = 0.0f;
        this.cCo = 0.0f;
        this.cCp = 0.0f;
        this.cCq = 0.0f;
        this.cCr = 0.0f;
        this.mWidth = 0.0f;
        this.cCs = new PointF();
        this.cCv = new RectF();
        this.cCw = new PointF();
        this.cCx = new PointF();
        this.cCy = new PointF();
        this.cCz = 0.0f;
        this.cCA = 0;
        this.cCB = 1;
        this.cCC = null;
        this.cCD = 0.0f;
        this.cCE = 0.0f;
        this.cCF = null;
        this.cAW = false;
        this.mState = 0;
        qP();
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        this.cCl = f2 <= 1.0f ? f2 : 1.0f;
        apf();
        postInvalidate();
    }

    public void ape() {
        bn(300L);
    }

    private void bn(long j) {
        changeState(2);
        if (this.cCF != null) {
            aoQ();
        }
        this.cCF = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.cCF.setDuration(j);
        this.cCF.setInterpolator(new LinearInterpolator());
        this.cCF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.B(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.cCF.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.2
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
        if (!this.cCF.isRunning()) {
            this.cCF.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bo(long j) {
        changeState(3);
        if (this.cCC != null) {
            aoQ();
        }
        this.cCC = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.cCC.setDuration(j);
        this.cCC.setInterpolator(new LinearInterpolator());
        this.cCC.setRepeatCount(-1);
        this.cCC.setRepeatMode(1);
        this.cCC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.C(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        if (this.cCA > 0) {
            this.cCC.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.4
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
                    if (RefreshingAnimView.this.cCB > RefreshingAnimView.this.cCA && RefreshingAnimView.this.cCu != null) {
                        RefreshingAnimView.this.cCu.eS(true);
                    }
                }
            });
        } else if (this.cCu != null) {
            this.cCu.eS(true);
        }
        if (!this.cCC.isRunning()) {
            this.cCC.start();
        }
    }

    public void setAtLeastRotateRounds(int i) {
        this.cCA = i;
    }

    public void setOnLoadingAnimationListener(a aVar) {
        this.cCu = aVar;
    }

    public void stopAnim() {
        aoQ();
        clearAnimation();
        this.cCl = 0.0f;
        this.cCB = 1;
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
        this.cCo = ag.dip2px(getContext(), 8.0f);
        this.cCq = ag.dip2px(getContext(), 6.5f);
        this.cCz = ag.dip2px(getContext(), 5.0f);
        this.cCr = ag.dip2px(getContext(), 7.5f);
        float f = this.mWidth / 2.0f;
        this.cCs.set(f, f);
        float f2 = f + ((float) (this.cCo / cCk));
        this.cCx.set(f2, f2);
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
            if (this.cAW != com.baidu.swan.apps.u.a.ags().getNightModeSwitcherState()) {
                this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
                this.cAW = com.baidu.swan.apps.u.a.ags().getNightModeSwitcherState();
            }
            this.mPaint.setAlpha(76);
            this.cCv.set(this.cCs.x - this.cCo, this.cCs.y - this.cCo, this.cCs.x + this.cCo, this.cCs.y + this.cCo);
            this.mCanvas.drawArc(this.cCv, -90.0f, (-360.0f) * this.cCm, true, this.mPaint);
            this.mCanvas.drawCircle(this.cCs.x, this.cCs.y, this.cCp, this.cCt);
            if (this.cCn > 0.0f) {
                this.mCanvas.drawCircle(this.cCy.x, this.cCy.y, 0.75f, this.mPaint);
                this.mPaint.setStyle(Paint.Style.STROKE);
                this.mPaint.setStrokeWidth(ag.dip2px(getContext(), 1.5f));
                this.mCanvas.drawLine(this.cCx.x, this.cCx.y, this.cCy.x, this.cCy.y, this.mPaint);
            }
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    private void apf() {
        this.cCm = this.cCl;
        if (this.cCl < 0.5f) {
            this.cCn = 0.0f;
            this.cCp = 0.0f;
            return;
        }
        this.cCp = ((this.cCl - 0.5f) / 0.5f) * this.cCq;
        if (this.cCl < 0.625f) {
            this.cCn = 0.0f;
            return;
        }
        this.cCn = (this.cCl - 0.625f) / 0.375f;
        this.cCy.set(this.cCx.x + ((float) ((this.cCz * this.cCn) / cCk)), this.cCx.y + ((float) ((this.cCz * this.cCn) / cCk)));
    }

    private void s(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setAlpha((int) (255.0d * ((this.cCE * 0.3d) + 0.3d)));
            float f = this.cCx.x + ((float) (this.cCz / cCk));
            this.mCanvas.drawCircle(this.cCs.x, this.cCs.y, this.cCo, this.mPaint);
            this.mCanvas.drawCircle(this.cCs.x, this.cCs.y, this.cCq, this.cCt);
            this.mCanvas.drawCircle(f, f, 0.75f, this.mPaint);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(ag.dip2px(getContext(), 1.5f));
            this.mCanvas.drawLine(this.cCx.x, this.cCx.y, f, f, this.mPaint);
            this.mMatrix.reset();
            this.mCamera.save();
            this.mCamera.setLocation(0.0f, 0.0f, -100.0f);
            this.mCamera.rotateY(this.cCE * 90.0f);
            this.mCamera.getMatrix(this.mMatrix);
            this.mCamera.restore();
            this.mMatrix.preTranslate(-this.cCs.x, -this.cCs.y);
            this.mMatrix.postTranslate(this.cCs.x, this.cCs.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(float f) {
        this.cCE = f;
        postInvalidate();
    }

    private void t(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            int abs = (int) ((((1.0d - (Math.abs(this.cCD - 0.5d) * 2.0d)) * 0.3d) + 0.3d) * 255.0d);
            if (this.cAW) {
                abs = (int) ((((1.0d - (Math.abs(this.cCD - 0.5d) * 2.0d)) * 0.2d) + 0.1d) * 255.0d);
            }
            this.mPaint.setAlpha(abs);
            this.mCanvas.drawCircle(this.cCs.x, this.cCs.y, this.cCr, this.mPaint);
            this.mMatrix.reset();
            this.mCamera.save();
            this.mCamera.setLocation(0.0f, 0.0f, -100.0f);
            this.mCamera.rotateY((this.cCD * 360.0f) + 90.0f);
            this.mCamera.getMatrix(this.mMatrix);
            this.mCamera.restore();
            this.mMatrix.preTranslate(-this.cCs.x, -this.cCs.y);
            this.mMatrix.postTranslate(this.cCs.x, this.cCs.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(float f) {
        if (f < 0.2f) {
            this.cCD = (f / 0.2f) * 0.5f;
        } else {
            this.cCD = (((f - 0.2f) / 0.8f) * 0.5f) + 0.5f;
        }
        postInvalidate();
    }

    private void qP() {
        this.cAW = com.baidu.swan.apps.u.a.ags().getNightModeSwitcherState();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
        this.cCt = new Paint();
        this.cCt.setAntiAlias(true);
        this.cCt.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
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

    private void aoQ() {
        if (this.cCF != null) {
            this.cCF.setRepeatCount(0);
            this.cCF.removeAllUpdateListeners();
            this.cCF.removeAllListeners();
            this.cCF.end();
            this.cCF.cancel();
        }
        if (this.cCC != null) {
            this.cCC.setRepeatCount(0);
            this.cCC.removeAllUpdateListeners();
            this.cCC.removeAllListeners();
            this.cCC.end();
            this.cCC.cancel();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aoQ();
    }
}
