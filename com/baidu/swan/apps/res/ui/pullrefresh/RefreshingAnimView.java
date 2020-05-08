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
    private static final double clW = Math.sqrt(2.0d);
    private boolean ckI;
    float clX;
    float clY;
    float clZ;
    float cma;
    float cmb;
    float cmc;
    float cme;
    private PointF cmf;
    private Paint cmg;
    private a cmh;
    private RectF cmi;
    private PointF cmj;
    private PointF cmk;
    private PointF cml;
    private float cmm;
    private int cmn;
    private int cmo;
    private ValueAnimator cmp;
    private float cmq;
    private float cmr;
    private ValueAnimator cms;
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
        int i = refreshingAnimView.cmo;
        refreshingAnimView.cmo = i + 1;
        return i;
    }

    public RefreshingAnimView(Context context) {
        super(context);
        this.clX = 0.0f;
        this.clY = 0.0f;
        this.clZ = 0.0f;
        this.cma = 0.0f;
        this.cmb = 0.0f;
        this.cmc = 0.0f;
        this.cme = 0.0f;
        this.mWidth = 0.0f;
        this.cmf = new PointF();
        this.cmi = new RectF();
        this.cmj = new PointF();
        this.cmk = new PointF();
        this.cml = new PointF();
        this.cmm = 0.0f;
        this.cmn = 0;
        this.cmo = 1;
        this.cmp = null;
        this.cmq = 0.0f;
        this.cmr = 0.0f;
        this.cms = null;
        this.ckI = false;
        this.mState = 0;
        qs();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.clX = 0.0f;
        this.clY = 0.0f;
        this.clZ = 0.0f;
        this.cma = 0.0f;
        this.cmb = 0.0f;
        this.cmc = 0.0f;
        this.cme = 0.0f;
        this.mWidth = 0.0f;
        this.cmf = new PointF();
        this.cmi = new RectF();
        this.cmj = new PointF();
        this.cmk = new PointF();
        this.cml = new PointF();
        this.cmm = 0.0f;
        this.cmn = 0;
        this.cmo = 1;
        this.cmp = null;
        this.cmq = 0.0f;
        this.cmr = 0.0f;
        this.cms = null;
        this.ckI = false;
        this.mState = 0;
        qs();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.clX = 0.0f;
        this.clY = 0.0f;
        this.clZ = 0.0f;
        this.cma = 0.0f;
        this.cmb = 0.0f;
        this.cmc = 0.0f;
        this.cme = 0.0f;
        this.mWidth = 0.0f;
        this.cmf = new PointF();
        this.cmi = new RectF();
        this.cmj = new PointF();
        this.cmk = new PointF();
        this.cml = new PointF();
        this.cmm = 0.0f;
        this.cmn = 0;
        this.cmo = 1;
        this.cmp = null;
        this.cmq = 0.0f;
        this.cmr = 0.0f;
        this.cms = null;
        this.ckI = false;
        this.mState = 0;
        qs();
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        this.clX = f2 <= 1.0f ? f2 : 1.0f;
        akl();
        postInvalidate();
    }

    public void akk() {
        bd(300L);
    }

    private void bd(long j) {
        changeState(2);
        if (this.cms != null) {
            ajW();
        }
        this.cms = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.cms.setDuration(j);
        this.cms.setInterpolator(new LinearInterpolator());
        this.cms.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.v(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.cms.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.2
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
        if (!this.cms.isRunning()) {
            this.cms.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void be(long j) {
        changeState(3);
        if (this.cmp != null) {
            ajW();
        }
        this.cmp = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.cmp.setDuration(j);
        this.cmp.setInterpolator(new LinearInterpolator());
        this.cmp.setRepeatCount(-1);
        this.cmp.setRepeatMode(1);
        this.cmp.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.A(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        if (this.cmn > 0) {
            this.cmp.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.4
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
                    if (RefreshingAnimView.this.cmo > RefreshingAnimView.this.cmn && RefreshingAnimView.this.cmh != null) {
                        RefreshingAnimView.this.cmh.eu(true);
                    }
                }
            });
        } else if (this.cmh != null) {
            this.cmh.eu(true);
        }
        if (!this.cmp.isRunning()) {
            this.cmp.start();
        }
    }

    public void setAtLeastRotateRounds(int i) {
        this.cmn = i;
    }

    public void setOnLoadingAnimationListener(a aVar) {
        this.cmh = aVar;
    }

    public void stopAnim() {
        ajW();
        clearAnimation();
        this.clX = 0.0f;
        this.cmo = 1;
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
        this.cma = af.dip2px(getContext(), 8.0f);
        this.cmc = af.dip2px(getContext(), 6.5f);
        this.cmm = af.dip2px(getContext(), 5.0f);
        this.cme = af.dip2px(getContext(), 7.5f);
        float f = this.mWidth / 2.0f;
        this.cmf.set(f, f);
        float f2 = f + ((float) (this.cma / clW));
        this.cmk.set(f2, f2);
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
            if (this.ckI != com.baidu.swan.apps.w.a.acj().getNightModeSwitcherState()) {
                this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
                this.ckI = com.baidu.swan.apps.w.a.acj().getNightModeSwitcherState();
            }
            this.mPaint.setAlpha(76);
            this.cmi.set(this.cmf.x - this.cma, this.cmf.y - this.cma, this.cmf.x + this.cma, this.cmf.y + this.cma);
            this.mCanvas.drawArc(this.cmi, -90.0f, (-360.0f) * this.clY, true, this.mPaint);
            this.mCanvas.drawCircle(this.cmf.x, this.cmf.y, this.cmb, this.cmg);
            if (this.clZ > 0.0f) {
                this.mCanvas.drawCircle(this.cml.x, this.cml.y, 0.75f, this.mPaint);
                this.mPaint.setStyle(Paint.Style.STROKE);
                this.mPaint.setStrokeWidth(af.dip2px(getContext(), 1.5f));
                this.mCanvas.drawLine(this.cmk.x, this.cmk.y, this.cml.x, this.cml.y, this.mPaint);
            }
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    private void akl() {
        this.clY = this.clX;
        if (this.clX < 0.5f) {
            this.clZ = 0.0f;
            this.cmb = 0.0f;
            return;
        }
        this.cmb = ((this.clX - 0.5f) / 0.5f) * this.cmc;
        if (this.clX < 0.625f) {
            this.clZ = 0.0f;
            return;
        }
        this.clZ = (this.clX - 0.625f) / 0.375f;
        this.cml.set(this.cmk.x + ((float) ((this.cmm * this.clZ) / clW)), this.cmk.y + ((float) ((this.cmm * this.clZ) / clW)));
    }

    private void r(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setAlpha((int) (255.0d * ((this.cmr * 0.3d) + 0.3d)));
            float f = this.cmk.x + ((float) (this.cmm / clW));
            this.mCanvas.drawCircle(this.cmf.x, this.cmf.y, this.cma, this.mPaint);
            this.mCanvas.drawCircle(this.cmf.x, this.cmf.y, this.cmc, this.cmg);
            this.mCanvas.drawCircle(f, f, 0.75f, this.mPaint);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(af.dip2px(getContext(), 1.5f));
            this.mCanvas.drawLine(this.cmk.x, this.cmk.y, f, f, this.mPaint);
            this.mMatrix.reset();
            this.mCamera.save();
            this.mCamera.setLocation(0.0f, 0.0f, -100.0f);
            this.mCamera.rotateY(this.cmr * 90.0f);
            this.mCamera.getMatrix(this.mMatrix);
            this.mCamera.restore();
            this.mMatrix.preTranslate(-this.cmf.x, -this.cmf.y);
            this.mMatrix.postTranslate(this.cmf.x, this.cmf.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(float f) {
        this.cmr = f;
        postInvalidate();
    }

    private void s(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            int abs = (int) ((((1.0d - (Math.abs(this.cmq - 0.5d) * 2.0d)) * 0.3d) + 0.3d) * 255.0d);
            if (this.ckI) {
                abs = (int) ((((1.0d - (Math.abs(this.cmq - 0.5d) * 2.0d)) * 0.2d) + 0.1d) * 255.0d);
            }
            this.mPaint.setAlpha(abs);
            this.mCanvas.drawCircle(this.cmf.x, this.cmf.y, this.cme, this.mPaint);
            this.mMatrix.reset();
            this.mCamera.save();
            this.mCamera.setLocation(0.0f, 0.0f, -100.0f);
            this.mCamera.rotateY((this.cmq * 360.0f) + 90.0f);
            this.mCamera.getMatrix(this.mMatrix);
            this.mCamera.restore();
            this.mMatrix.preTranslate(-this.cmf.x, -this.cmf.y);
            this.mMatrix.postTranslate(this.cmf.x, this.cmf.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(float f) {
        if (f < 0.2f) {
            this.cmq = (f / 0.2f) * 0.5f;
        } else {
            this.cmq = (((f - 0.2f) / 0.8f) * 0.5f) + 0.5f;
        }
        postInvalidate();
    }

    private void qs() {
        this.ckI = com.baidu.swan.apps.w.a.acj().getNightModeSwitcherState();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
        this.cmg = new Paint();
        this.cmg.setAntiAlias(true);
        this.cmg.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
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

    private void ajW() {
        if (this.cms != null) {
            this.cms.setRepeatCount(0);
            this.cms.removeAllUpdateListeners();
            this.cms.removeAllListeners();
            this.cms.end();
            this.cms.cancel();
        }
        if (this.cmp != null) {
            this.cmp.setRepeatCount(0);
            this.cmp.removeAllUpdateListeners();
            this.cmp.removeAllListeners();
            this.cmp.end();
            this.cmp.cancel();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ajW();
    }
}
