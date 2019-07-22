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
    private static final double aMd = Math.sqrt(2.0d);
    private boolean aKJ;
    private Canvas aKL;
    private Camera aKM;
    float aMe;
    float aMf;
    float aMg;
    float aMh;
    float aMi;
    float aMj;
    float aMk;
    private PointF aMl;
    private Paint aMm;
    private a aMn;
    private RectF aMo;
    private PointF aMp;
    private PointF aMq;
    private PointF aMr;
    private float aMs;
    private int aMt;
    private int aMu;
    private ValueAnimator aMv;
    private float aMw;
    private float aMx;
    private ValueAnimator aMy;
    private Bitmap mBitmap;
    private Matrix mMatrix;
    private Paint mPaint;
    private int mState;
    private float mWidth;

    /* loaded from: classes2.dex */
    public interface a {
        void bQ(boolean z);
    }

    static /* synthetic */ int a(RefreshingAnimView refreshingAnimView) {
        int i = refreshingAnimView.aMu;
        refreshingAnimView.aMu = i + 1;
        return i;
    }

    public RefreshingAnimView(Context context) {
        super(context);
        this.aMe = 0.0f;
        this.aMf = 0.0f;
        this.aMg = 0.0f;
        this.aMh = 0.0f;
        this.aMi = 0.0f;
        this.aMj = 0.0f;
        this.aMk = 0.0f;
        this.mWidth = 0.0f;
        this.aMl = new PointF();
        this.aMo = new RectF();
        this.aMp = new PointF();
        this.aMq = new PointF();
        this.aMr = new PointF();
        this.aMs = 0.0f;
        this.aMt = 0;
        this.aMu = 1;
        this.aMv = null;
        this.aMw = 0.0f;
        this.aMx = 0.0f;
        this.aMy = null;
        this.aKJ = false;
        this.mState = 0;
        qp();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aMe = 0.0f;
        this.aMf = 0.0f;
        this.aMg = 0.0f;
        this.aMh = 0.0f;
        this.aMi = 0.0f;
        this.aMj = 0.0f;
        this.aMk = 0.0f;
        this.mWidth = 0.0f;
        this.aMl = new PointF();
        this.aMo = new RectF();
        this.aMp = new PointF();
        this.aMq = new PointF();
        this.aMr = new PointF();
        this.aMs = 0.0f;
        this.aMt = 0;
        this.aMu = 1;
        this.aMv = null;
        this.aMw = 0.0f;
        this.aMx = 0.0f;
        this.aMy = null;
        this.aKJ = false;
        this.mState = 0;
        qp();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aMe = 0.0f;
        this.aMf = 0.0f;
        this.aMg = 0.0f;
        this.aMh = 0.0f;
        this.aMi = 0.0f;
        this.aMj = 0.0f;
        this.aMk = 0.0f;
        this.mWidth = 0.0f;
        this.aMl = new PointF();
        this.aMo = new RectF();
        this.aMp = new PointF();
        this.aMq = new PointF();
        this.aMr = new PointF();
        this.aMs = 0.0f;
        this.aMt = 0;
        this.aMu = 1;
        this.aMv = null;
        this.aMw = 0.0f;
        this.aMx = 0.0f;
        this.aMy = null;
        this.aKJ = false;
        this.mState = 0;
        qp();
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        this.aMe = f2 <= 1.0f ? f2 : 1.0f;
        KF();
        postInvalidate();
    }

    public void KE() {
        Q(300L);
    }

    private void Q(long j) {
        da(2);
        if (this.aMy != null) {
            Kq();
        }
        this.aMy = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.aMy.setDuration(j);
        this.aMy.setInterpolator(new LinearInterpolator());
        this.aMy.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.Z(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.aMy.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                RefreshingAnimView.this.R(750L);
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
        if (!this.aMy.isRunning()) {
            this.aMy.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(long j) {
        da(3);
        if (this.aMv != null) {
            Kq();
        }
        this.aMv = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.aMv.setDuration(j);
        this.aMv.setInterpolator(new LinearInterpolator());
        this.aMv.setRepeatCount(-1);
        this.aMv.setRepeatMode(1);
        this.aMv.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.aa(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        if (this.aMt > 0) {
            this.aMv.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.4
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
                    if (RefreshingAnimView.this.aMu > RefreshingAnimView.this.aMt && RefreshingAnimView.this.aMn != null) {
                        RefreshingAnimView.this.aMn.bQ(true);
                    }
                }
            });
        } else if (this.aMn != null) {
            this.aMn.bQ(true);
        }
        if (!this.aMv.isRunning()) {
            this.aMv.start();
        }
    }

    public void setAtLeastRotateRounds(int i) {
        this.aMt = i;
    }

    public void setOnLoadingAnimationListener(a aVar) {
        this.aMn = aVar;
    }

    public void stopAnim() {
        Kq();
        clearAnimation();
        this.aMe = 0.0f;
        this.aMu = 1;
        da(1);
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
        this.aMh = z.dip2px(getContext(), 8.0f);
        this.aMj = z.dip2px(getContext(), 6.5f);
        this.aMs = z.dip2px(getContext(), 5.0f);
        this.aMk = z.dip2px(getContext(), 7.5f);
        float f = this.mWidth / 2.0f;
        this.aMl.set(f, f);
        float f2 = f + ((float) (this.aMh / aMd));
        this.aMq.set(f2, f2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        switch (this.mState) {
            case 1:
                p(canvas);
                break;
            case 2:
                q(canvas);
                break;
            case 3:
                r(canvas);
                break;
        }
        canvas.restore();
        Log.w("RefreshingAnimView", "onDraw->mState:" + KG() + ";AnimValue:" + this.aMe);
    }

    private void p(Canvas canvas) {
        if (this.mBitmap != null && this.aKL != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            if (this.aKJ != com.baidu.swan.apps.u.a.EF().Fe()) {
                this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
                this.aKJ = com.baidu.swan.apps.u.a.EF().Fe();
            }
            this.mPaint.setAlpha(76);
            this.aMo.set(this.aMl.x - this.aMh, this.aMl.y - this.aMh, this.aMl.x + this.aMh, this.aMl.y + this.aMh);
            this.aKL.drawArc(this.aMo, -90.0f, (-360.0f) * this.aMf, true, this.mPaint);
            this.aKL.drawCircle(this.aMl.x, this.aMl.y, this.aMi, this.aMm);
            if (this.aMg > 0.0f) {
                this.aKL.drawCircle(this.aMr.x, this.aMr.y, 0.75f, this.mPaint);
                this.mPaint.setStyle(Paint.Style.STROKE);
                this.mPaint.setStrokeWidth(z.dip2px(getContext(), 1.5f));
                this.aKL.drawLine(this.aMq.x, this.aMq.y, this.aMr.x, this.aMr.y, this.mPaint);
            }
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    private void KF() {
        this.aMf = this.aMe;
        if (this.aMe < 0.5f) {
            this.aMg = 0.0f;
            this.aMi = 0.0f;
            return;
        }
        this.aMi = ((this.aMe - 0.5f) / 0.5f) * this.aMj;
        if (this.aMe < 0.625f) {
            this.aMg = 0.0f;
            return;
        }
        this.aMg = (this.aMe - 0.625f) / 0.375f;
        this.aMr.set(this.aMq.x + ((float) ((this.aMs * this.aMg) / aMd)), this.aMq.y + ((float) ((this.aMs * this.aMg) / aMd)));
    }

    private void q(Canvas canvas) {
        if (this.mBitmap != null && this.aKL != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setAlpha((int) (255.0d * ((this.aMx * 0.3d) + 0.3d)));
            float f = this.aMq.x + ((float) (this.aMs / aMd));
            this.aKL.drawCircle(this.aMl.x, this.aMl.y, this.aMh, this.mPaint);
            this.aKL.drawCircle(this.aMl.x, this.aMl.y, this.aMj, this.aMm);
            this.aKL.drawCircle(f, f, 0.75f, this.mPaint);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(z.dip2px(getContext(), 1.5f));
            this.aKL.drawLine(this.aMq.x, this.aMq.y, f, f, this.mPaint);
            this.mMatrix.reset();
            this.aKM.save();
            this.aKM.setLocation(0.0f, 0.0f, -100.0f);
            this.aKM.rotateY(this.aMx * 90.0f);
            this.aKM.getMatrix(this.mMatrix);
            this.aKM.restore();
            this.mMatrix.preTranslate(-this.aMl.x, -this.aMl.y);
            this.mMatrix.postTranslate(this.aMl.x, this.aMl.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(float f) {
        this.aMx = f;
        postInvalidate();
    }

    private void r(Canvas canvas) {
        if (this.mBitmap != null && this.aKL != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            int abs = (int) ((((1.0d - (Math.abs(this.aMw - 0.5d) * 2.0d)) * 0.3d) + 0.3d) * 255.0d);
            if (this.aKJ) {
                abs = (int) ((((1.0d - (Math.abs(this.aMw - 0.5d) * 2.0d)) * 0.2d) + 0.1d) * 255.0d);
            }
            this.mPaint.setAlpha(abs);
            this.aKL.drawCircle(this.aMl.x, this.aMl.y, this.aMk, this.mPaint);
            this.mMatrix.reset();
            this.aKM.save();
            this.aKM.setLocation(0.0f, 0.0f, -100.0f);
            this.aKM.rotateY((this.aMw * 360.0f) + 90.0f);
            this.aKM.getMatrix(this.mMatrix);
            this.aKM.restore();
            this.mMatrix.preTranslate(-this.aMl.x, -this.aMl.y);
            this.mMatrix.postTranslate(this.aMl.x, this.aMl.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa(float f) {
        if (f < 0.2f) {
            this.aMw = (f / 0.2f) * 0.5f;
        } else {
            this.aMw = (((f - 0.2f) / 0.8f) * 0.5f) + 0.5f;
        }
        postInvalidate();
    }

    private void qp() {
        this.aKJ = com.baidu.swan.apps.u.a.EF().Fe();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
        this.aMm = new Paint();
        this.aMm.setAntiAlias(true);
        this.aMm.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.aKM = new Camera();
        this.mMatrix = new Matrix();
        da(1);
    }

    private void da(int i) {
        this.mState = i;
    }

    private String KG() {
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
            this.aKL = new Canvas(this.mBitmap);
        }
    }

    private void Kq() {
        if (this.aMy != null) {
            this.aMy.setRepeatCount(0);
            this.aMy.removeAllUpdateListeners();
            this.aMy.removeAllListeners();
            this.aMy.end();
            this.aMy.cancel();
        }
        if (this.aMv != null) {
            this.aMv.setRepeatCount(0);
            this.aMv.removeAllUpdateListeners();
            this.aMv.removeAllListeners();
            this.aMv.end();
            this.aMv.cancel();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Kq();
    }
}
