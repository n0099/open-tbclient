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
/* loaded from: classes9.dex */
public class RefreshingAnimView extends View {
    private static final double bIe = Math.sqrt(2.0d);
    private Camera awL;
    private boolean bGQ;
    float bIf;
    float bIg;
    float bIh;
    float bIi;
    float bIj;
    float bIk;
    float bIl;
    private PointF bIm;
    private Paint bIn;
    private a bIo;
    private RectF bIp;
    private PointF bIq;
    private PointF bIr;
    private PointF bIs;
    private float bIt;
    private int bIu;
    private int bIv;
    private ValueAnimator bIw;
    private float bIx;
    private float bIy;
    private ValueAnimator bIz;
    private Bitmap mBitmap;
    private Canvas mCanvas;
    private Matrix mMatrix;
    private Paint mPaint;
    private int mState;
    private float mWidth;

    /* loaded from: classes9.dex */
    public interface a {
        void dl(boolean z);
    }

    static /* synthetic */ int a(RefreshingAnimView refreshingAnimView) {
        int i = refreshingAnimView.bIv;
        refreshingAnimView.bIv = i + 1;
        return i;
    }

    public RefreshingAnimView(Context context) {
        super(context);
        this.bIf = 0.0f;
        this.bIg = 0.0f;
        this.bIh = 0.0f;
        this.bIi = 0.0f;
        this.bIj = 0.0f;
        this.bIk = 0.0f;
        this.bIl = 0.0f;
        this.mWidth = 0.0f;
        this.bIm = new PointF();
        this.bIp = new RectF();
        this.bIq = new PointF();
        this.bIr = new PointF();
        this.bIs = new PointF();
        this.bIt = 0.0f;
        this.bIu = 0;
        this.bIv = 1;
        this.bIw = null;
        this.bIx = 0.0f;
        this.bIy = 0.0f;
        this.bIz = null;
        this.bGQ = false;
        this.mState = 0;
        lB();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bIf = 0.0f;
        this.bIg = 0.0f;
        this.bIh = 0.0f;
        this.bIi = 0.0f;
        this.bIj = 0.0f;
        this.bIk = 0.0f;
        this.bIl = 0.0f;
        this.mWidth = 0.0f;
        this.bIm = new PointF();
        this.bIp = new RectF();
        this.bIq = new PointF();
        this.bIr = new PointF();
        this.bIs = new PointF();
        this.bIt = 0.0f;
        this.bIu = 0;
        this.bIv = 1;
        this.bIw = null;
        this.bIx = 0.0f;
        this.bIy = 0.0f;
        this.bIz = null;
        this.bGQ = false;
        this.mState = 0;
        lB();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bIf = 0.0f;
        this.bIg = 0.0f;
        this.bIh = 0.0f;
        this.bIi = 0.0f;
        this.bIj = 0.0f;
        this.bIk = 0.0f;
        this.bIl = 0.0f;
        this.mWidth = 0.0f;
        this.bIm = new PointF();
        this.bIp = new RectF();
        this.bIq = new PointF();
        this.bIr = new PointF();
        this.bIs = new PointF();
        this.bIt = 0.0f;
        this.bIu = 0;
        this.bIv = 1;
        this.bIw = null;
        this.bIx = 0.0f;
        this.bIy = 0.0f;
        this.bIz = null;
        this.bGQ = false;
        this.mState = 0;
        lB();
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        this.bIf = f2 <= 1.0f ? f2 : 1.0f;
        Zr();
        postInvalidate();
    }

    public void Zq() {
        ar(300L);
    }

    private void ar(long j) {
        changeState(2);
        if (this.bIz != null) {
            Zc();
        }
        this.bIz = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.bIz.setDuration(j);
        this.bIz.setInterpolator(new LinearInterpolator());
        this.bIz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.Q(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.bIz.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                RefreshingAnimView.this.as(750L);
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
        if (!this.bIz.isRunning()) {
            this.bIz.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(long j) {
        changeState(3);
        if (this.bIw != null) {
            Zc();
        }
        this.bIw = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.bIw.setDuration(j);
        this.bIw.setInterpolator(new LinearInterpolator());
        this.bIw.setRepeatCount(-1);
        this.bIw.setRepeatMode(1);
        this.bIw.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.R(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        if (this.bIu > 0) {
            this.bIw.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.4
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
                    if (RefreshingAnimView.this.bIv > RefreshingAnimView.this.bIu && RefreshingAnimView.this.bIo != null) {
                        RefreshingAnimView.this.bIo.dl(true);
                    }
                }
            });
        } else if (this.bIo != null) {
            this.bIo.dl(true);
        }
        if (!this.bIw.isRunning()) {
            this.bIw.start();
        }
    }

    public void setAtLeastRotateRounds(int i) {
        this.bIu = i;
    }

    public void setOnLoadingAnimationListener(a aVar) {
        this.bIo = aVar;
    }

    public void stopAnim() {
        Zc();
        clearAnimation();
        this.bIf = 0.0f;
        this.bIv = 1;
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
        this.bIi = af.dip2px(getContext(), 8.0f);
        this.bIk = af.dip2px(getContext(), 6.5f);
        this.bIt = af.dip2px(getContext(), 5.0f);
        this.bIl = af.dip2px(getContext(), 7.5f);
        float f = this.mWidth / 2.0f;
        this.bIm.set(f, f);
        float f2 = f + ((float) (this.bIi / bIe));
        this.bIr.set(f2, f2);
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
            if (this.bGQ != com.baidu.swan.apps.w.a.RG().getNightModeSwitcherState()) {
                this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
                this.bGQ = com.baidu.swan.apps.w.a.RG().getNightModeSwitcherState();
            }
            this.mPaint.setAlpha(76);
            this.bIp.set(this.bIm.x - this.bIi, this.bIm.y - this.bIi, this.bIm.x + this.bIi, this.bIm.y + this.bIi);
            this.mCanvas.drawArc(this.bIp, -90.0f, (-360.0f) * this.bIg, true, this.mPaint);
            this.mCanvas.drawCircle(this.bIm.x, this.bIm.y, this.bIj, this.bIn);
            if (this.bIh > 0.0f) {
                this.mCanvas.drawCircle(this.bIs.x, this.bIs.y, 0.75f, this.mPaint);
                this.mPaint.setStyle(Paint.Style.STROKE);
                this.mPaint.setStrokeWidth(af.dip2px(getContext(), 1.5f));
                this.mCanvas.drawLine(this.bIr.x, this.bIr.y, this.bIs.x, this.bIs.y, this.mPaint);
            }
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    private void Zr() {
        this.bIg = this.bIf;
        if (this.bIf < 0.5f) {
            this.bIh = 0.0f;
            this.bIj = 0.0f;
            return;
        }
        this.bIj = ((this.bIf - 0.5f) / 0.5f) * this.bIk;
        if (this.bIf < 0.625f) {
            this.bIh = 0.0f;
            return;
        }
        this.bIh = (this.bIf - 0.625f) / 0.375f;
        this.bIs.set(this.bIr.x + ((float) ((this.bIt * this.bIh) / bIe)), this.bIr.y + ((float) ((this.bIt * this.bIh) / bIe)));
    }

    private void r(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setAlpha((int) (255.0d * ((this.bIy * 0.3d) + 0.3d)));
            float f = this.bIr.x + ((float) (this.bIt / bIe));
            this.mCanvas.drawCircle(this.bIm.x, this.bIm.y, this.bIi, this.mPaint);
            this.mCanvas.drawCircle(this.bIm.x, this.bIm.y, this.bIk, this.bIn);
            this.mCanvas.drawCircle(f, f, 0.75f, this.mPaint);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(af.dip2px(getContext(), 1.5f));
            this.mCanvas.drawLine(this.bIr.x, this.bIr.y, f, f, this.mPaint);
            this.mMatrix.reset();
            this.awL.save();
            this.awL.setLocation(0.0f, 0.0f, -100.0f);
            this.awL.rotateY(this.bIy * 90.0f);
            this.awL.getMatrix(this.mMatrix);
            this.awL.restore();
            this.mMatrix.preTranslate(-this.bIm.x, -this.bIm.y);
            this.mMatrix.postTranslate(this.bIm.x, this.bIm.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(float f) {
        this.bIy = f;
        postInvalidate();
    }

    private void s(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            int abs = (int) ((((1.0d - (Math.abs(this.bIx - 0.5d) * 2.0d)) * 0.3d) + 0.3d) * 255.0d);
            if (this.bGQ) {
                abs = (int) ((((1.0d - (Math.abs(this.bIx - 0.5d) * 2.0d)) * 0.2d) + 0.1d) * 255.0d);
            }
            this.mPaint.setAlpha(abs);
            this.mCanvas.drawCircle(this.bIm.x, this.bIm.y, this.bIl, this.mPaint);
            this.mMatrix.reset();
            this.awL.save();
            this.awL.setLocation(0.0f, 0.0f, -100.0f);
            this.awL.rotateY((this.bIx * 360.0f) + 90.0f);
            this.awL.getMatrix(this.mMatrix);
            this.awL.restore();
            this.mMatrix.preTranslate(-this.bIm.x, -this.bIm.y);
            this.mMatrix.postTranslate(this.bIm.x, this.bIm.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(float f) {
        if (f < 0.2f) {
            this.bIx = (f / 0.2f) * 0.5f;
        } else {
            this.bIx = (((f - 0.2f) / 0.8f) * 0.5f) + 0.5f;
        }
        postInvalidate();
    }

    private void lB() {
        this.bGQ = com.baidu.swan.apps.w.a.RG().getNightModeSwitcherState();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
        this.bIn = new Paint();
        this.bIn.setAntiAlias(true);
        this.bIn.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.awL = new Camera();
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

    private void Zc() {
        if (this.bIz != null) {
            this.bIz.setRepeatCount(0);
            this.bIz.removeAllUpdateListeners();
            this.bIz.removeAllListeners();
            this.bIz.end();
            this.bIz.cancel();
        }
        if (this.bIw != null) {
            this.bIw.setRepeatCount(0);
            this.bIw.removeAllUpdateListeners();
            this.bIw.removeAllListeners();
            this.bIw.end();
            this.bIw.cancel();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Zc();
    }
}
