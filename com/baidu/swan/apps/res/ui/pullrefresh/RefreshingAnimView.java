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
    private static final double clQ = Math.sqrt(2.0d);
    private boolean ckC;
    float clR;
    float clS;
    float clT;
    float clU;
    float clV;
    float clW;
    float clX;
    private PointF clY;
    private Paint clZ;
    private a cma;
    private RectF cmb;
    private PointF cmc;
    private PointF cme;
    private PointF cmf;
    private float cmg;
    private int cmh;
    private int cmi;
    private ValueAnimator cmj;
    private float cmk;
    private float cml;
    private ValueAnimator cmm;
    private Bitmap mBitmap;
    private Camera mCamera;
    private Canvas mCanvas;
    private Matrix mMatrix;
    private Paint mPaint;
    private int mState;
    private float mWidth;

    /* loaded from: classes11.dex */
    public interface a {
        void eu(boolean z);
    }

    static /* synthetic */ int a(RefreshingAnimView refreshingAnimView) {
        int i = refreshingAnimView.cmi;
        refreshingAnimView.cmi = i + 1;
        return i;
    }

    public RefreshingAnimView(Context context) {
        super(context);
        this.clR = 0.0f;
        this.clS = 0.0f;
        this.clT = 0.0f;
        this.clU = 0.0f;
        this.clV = 0.0f;
        this.clW = 0.0f;
        this.clX = 0.0f;
        this.mWidth = 0.0f;
        this.clY = new PointF();
        this.cmb = new RectF();
        this.cmc = new PointF();
        this.cme = new PointF();
        this.cmf = new PointF();
        this.cmg = 0.0f;
        this.cmh = 0;
        this.cmi = 1;
        this.cmj = null;
        this.cmk = 0.0f;
        this.cml = 0.0f;
        this.cmm = null;
        this.ckC = false;
        this.mState = 0;
        qs();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.clR = 0.0f;
        this.clS = 0.0f;
        this.clT = 0.0f;
        this.clU = 0.0f;
        this.clV = 0.0f;
        this.clW = 0.0f;
        this.clX = 0.0f;
        this.mWidth = 0.0f;
        this.clY = new PointF();
        this.cmb = new RectF();
        this.cmc = new PointF();
        this.cme = new PointF();
        this.cmf = new PointF();
        this.cmg = 0.0f;
        this.cmh = 0;
        this.cmi = 1;
        this.cmj = null;
        this.cmk = 0.0f;
        this.cml = 0.0f;
        this.cmm = null;
        this.ckC = false;
        this.mState = 0;
        qs();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.clR = 0.0f;
        this.clS = 0.0f;
        this.clT = 0.0f;
        this.clU = 0.0f;
        this.clV = 0.0f;
        this.clW = 0.0f;
        this.clX = 0.0f;
        this.mWidth = 0.0f;
        this.clY = new PointF();
        this.cmb = new RectF();
        this.cmc = new PointF();
        this.cme = new PointF();
        this.cmf = new PointF();
        this.cmg = 0.0f;
        this.cmh = 0;
        this.cmi = 1;
        this.cmj = null;
        this.cmk = 0.0f;
        this.cml = 0.0f;
        this.cmm = null;
        this.ckC = false;
        this.mState = 0;
        qs();
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        this.clR = f2 <= 1.0f ? f2 : 1.0f;
        akm();
        postInvalidate();
    }

    public void akl() {
        bd(300L);
    }

    private void bd(long j) {
        changeState(2);
        if (this.cmm != null) {
            ajX();
        }
        this.cmm = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.cmm.setDuration(j);
        this.cmm.setInterpolator(new LinearInterpolator());
        this.cmm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.v(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.cmm.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                RefreshingAnimView.this.be(750L);
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
        if (!this.cmm.isRunning()) {
            this.cmm.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void be(long j) {
        changeState(3);
        if (this.cmj != null) {
            ajX();
        }
        this.cmj = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.cmj.setDuration(j);
        this.cmj.setInterpolator(new LinearInterpolator());
        this.cmj.setRepeatCount(-1);
        this.cmj.setRepeatMode(1);
        this.cmj.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.A(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        if (this.cmh > 0) {
            this.cmj.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.4
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
                    if (RefreshingAnimView.this.cmi > RefreshingAnimView.this.cmh && RefreshingAnimView.this.cma != null) {
                        RefreshingAnimView.this.cma.eu(true);
                    }
                }
            });
        } else if (this.cma != null) {
            this.cma.eu(true);
        }
        if (!this.cmj.isRunning()) {
            this.cmj.start();
        }
    }

    public void setAtLeastRotateRounds(int i) {
        this.cmh = i;
    }

    public void setOnLoadingAnimationListener(a aVar) {
        this.cma = aVar;
    }

    public void stopAnim() {
        ajX();
        clearAnimation();
        this.clR = 0.0f;
        this.cmi = 1;
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
        this.clU = af.dip2px(getContext(), 8.0f);
        this.clW = af.dip2px(getContext(), 6.5f);
        this.cmg = af.dip2px(getContext(), 5.0f);
        this.clX = af.dip2px(getContext(), 7.5f);
        float f = this.mWidth / 2.0f;
        this.clY.set(f, f);
        float f2 = f + ((float) (this.clU / clQ));
        this.cme.set(f2, f2);
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
            if (this.ckC != com.baidu.swan.apps.w.a.ack().getNightModeSwitcherState()) {
                this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
                this.ckC = com.baidu.swan.apps.w.a.ack().getNightModeSwitcherState();
            }
            this.mPaint.setAlpha(76);
            this.cmb.set(this.clY.x - this.clU, this.clY.y - this.clU, this.clY.x + this.clU, this.clY.y + this.clU);
            this.mCanvas.drawArc(this.cmb, -90.0f, (-360.0f) * this.clS, true, this.mPaint);
            this.mCanvas.drawCircle(this.clY.x, this.clY.y, this.clV, this.clZ);
            if (this.clT > 0.0f) {
                this.mCanvas.drawCircle(this.cmf.x, this.cmf.y, 0.75f, this.mPaint);
                this.mPaint.setStyle(Paint.Style.STROKE);
                this.mPaint.setStrokeWidth(af.dip2px(getContext(), 1.5f));
                this.mCanvas.drawLine(this.cme.x, this.cme.y, this.cmf.x, this.cmf.y, this.mPaint);
            }
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    private void akm() {
        this.clS = this.clR;
        if (this.clR < 0.5f) {
            this.clT = 0.0f;
            this.clV = 0.0f;
            return;
        }
        this.clV = ((this.clR - 0.5f) / 0.5f) * this.clW;
        if (this.clR < 0.625f) {
            this.clT = 0.0f;
            return;
        }
        this.clT = (this.clR - 0.625f) / 0.375f;
        this.cmf.set(this.cme.x + ((float) ((this.cmg * this.clT) / clQ)), this.cme.y + ((float) ((this.cmg * this.clT) / clQ)));
    }

    private void r(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setAlpha((int) (255.0d * ((this.cml * 0.3d) + 0.3d)));
            float f = this.cme.x + ((float) (this.cmg / clQ));
            this.mCanvas.drawCircle(this.clY.x, this.clY.y, this.clU, this.mPaint);
            this.mCanvas.drawCircle(this.clY.x, this.clY.y, this.clW, this.clZ);
            this.mCanvas.drawCircle(f, f, 0.75f, this.mPaint);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(af.dip2px(getContext(), 1.5f));
            this.mCanvas.drawLine(this.cme.x, this.cme.y, f, f, this.mPaint);
            this.mMatrix.reset();
            this.mCamera.save();
            this.mCamera.setLocation(0.0f, 0.0f, -100.0f);
            this.mCamera.rotateY(this.cml * 90.0f);
            this.mCamera.getMatrix(this.mMatrix);
            this.mCamera.restore();
            this.mMatrix.preTranslate(-this.clY.x, -this.clY.y);
            this.mMatrix.postTranslate(this.clY.x, this.clY.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(float f) {
        this.cml = f;
        postInvalidate();
    }

    private void s(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            int abs = (int) ((((1.0d - (Math.abs(this.cmk - 0.5d) * 2.0d)) * 0.3d) + 0.3d) * 255.0d);
            if (this.ckC) {
                abs = (int) ((((1.0d - (Math.abs(this.cmk - 0.5d) * 2.0d)) * 0.2d) + 0.1d) * 255.0d);
            }
            this.mPaint.setAlpha(abs);
            this.mCanvas.drawCircle(this.clY.x, this.clY.y, this.clX, this.mPaint);
            this.mMatrix.reset();
            this.mCamera.save();
            this.mCamera.setLocation(0.0f, 0.0f, -100.0f);
            this.mCamera.rotateY((this.cmk * 360.0f) + 90.0f);
            this.mCamera.getMatrix(this.mMatrix);
            this.mCamera.restore();
            this.mMatrix.preTranslate(-this.clY.x, -this.clY.y);
            this.mMatrix.postTranslate(this.clY.x, this.clY.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(float f) {
        if (f < 0.2f) {
            this.cmk = (f / 0.2f) * 0.5f;
        } else {
            this.cmk = (((f - 0.2f) / 0.8f) * 0.5f) + 0.5f;
        }
        postInvalidate();
    }

    private void qs() {
        this.ckC = com.baidu.swan.apps.w.a.ack().getNightModeSwitcherState();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
        this.clZ = new Paint();
        this.clZ.setAntiAlias(true);
        this.clZ.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
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

    private void ajX() {
        if (this.cmm != null) {
            this.cmm.setRepeatCount(0);
            this.cmm.removeAllUpdateListeners();
            this.cmm.removeAllListeners();
            this.cmm.end();
            this.cmm.cancel();
        }
        if (this.cmj != null) {
            this.cmj.setRepeatCount(0);
            this.cmj.removeAllUpdateListeners();
            this.cmj.removeAllListeners();
            this.cmj.end();
            this.cmj.cancel();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ajX();
    }
}
