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
/* loaded from: classes25.dex */
public class RefreshingAnimView extends View {
    private static final double dvV = Math.sqrt(2.0d);
    private float bPi;
    private boolean duG;
    private Camera duI;
    float dvW;
    float dvX;
    float dvY;
    float dvZ;
    float dwa;
    float dwb;
    float dwc;
    private PointF dwd;
    private Paint dwe;
    private a dwf;
    private RectF dwg;
    private PointF dwh;
    private PointF dwi;
    private PointF dwj;
    private float dwk;
    private int dwl;
    private int dwm;
    private ValueAnimator dwn;
    private float dwo;
    private float dwp;
    private ValueAnimator dwq;
    private Bitmap mBitmap;
    private Canvas mCanvas;
    private Matrix mMatrix;
    private Paint mPaint;
    private int mState;

    /* loaded from: classes25.dex */
    public interface a {
        void gD(boolean z);
    }

    static /* synthetic */ int a(RefreshingAnimView refreshingAnimView) {
        int i = refreshingAnimView.dwm;
        refreshingAnimView.dwm = i + 1;
        return i;
    }

    public RefreshingAnimView(Context context) {
        super(context);
        this.dvW = 0.0f;
        this.dvX = 0.0f;
        this.dvY = 0.0f;
        this.dvZ = 0.0f;
        this.dwa = 0.0f;
        this.dwb = 0.0f;
        this.dwc = 0.0f;
        this.bPi = 0.0f;
        this.dwd = new PointF();
        this.dwg = new RectF();
        this.dwh = new PointF();
        this.dwi = new PointF();
        this.dwj = new PointF();
        this.dwk = 0.0f;
        this.dwl = 0;
        this.dwm = 1;
        this.dwn = null;
        this.dwo = 0.0f;
        this.dwp = 0.0f;
        this.dwq = null;
        this.duG = false;
        this.mState = 0;
        sz();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dvW = 0.0f;
        this.dvX = 0.0f;
        this.dvY = 0.0f;
        this.dvZ = 0.0f;
        this.dwa = 0.0f;
        this.dwb = 0.0f;
        this.dwc = 0.0f;
        this.bPi = 0.0f;
        this.dwd = new PointF();
        this.dwg = new RectF();
        this.dwh = new PointF();
        this.dwi = new PointF();
        this.dwj = new PointF();
        this.dwk = 0.0f;
        this.dwl = 0;
        this.dwm = 1;
        this.dwn = null;
        this.dwo = 0.0f;
        this.dwp = 0.0f;
        this.dwq = null;
        this.duG = false;
        this.mState = 0;
        sz();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dvW = 0.0f;
        this.dvX = 0.0f;
        this.dvY = 0.0f;
        this.dvZ = 0.0f;
        this.dwa = 0.0f;
        this.dwb = 0.0f;
        this.dwc = 0.0f;
        this.bPi = 0.0f;
        this.dwd = new PointF();
        this.dwg = new RectF();
        this.dwh = new PointF();
        this.dwi = new PointF();
        this.dwj = new PointF();
        this.dwk = 0.0f;
        this.dwl = 0;
        this.dwm = 1;
        this.dwn = null;
        this.dwo = 0.0f;
        this.dwp = 0.0f;
        this.dwq = null;
        this.duG = false;
        this.mState = 0;
        sz();
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        this.dvW = f2 <= 1.0f ? f2 : 1.0f;
        aJn();
        postInvalidate();
    }

    public void aJm() {
        cL(300L);
    }

    private void cL(long j) {
        kj(2);
        if (this.dwq != null) {
            aIY();
        }
        this.dwq = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.dwq.setDuration(j);
        this.dwq.setInterpolator(new LinearInterpolator());
        this.dwq.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.K(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.dwq.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                RefreshingAnimView.this.cM(750L);
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
        if (!this.dwq.isRunning()) {
            this.dwq.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cM(long j) {
        kj(3);
        if (this.dwn != null) {
            aIY();
        }
        this.dwn = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.dwn.setDuration(j);
        this.dwn.setInterpolator(new LinearInterpolator());
        this.dwn.setRepeatCount(-1);
        this.dwn.setRepeatMode(1);
        this.dwn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.L(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        if (this.dwl > 0) {
            this.dwn.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.4
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
                    if (RefreshingAnimView.this.dwm > RefreshingAnimView.this.dwl && RefreshingAnimView.this.dwf != null) {
                        RefreshingAnimView.this.dwf.gD(true);
                    }
                }
            });
        } else if (this.dwf != null) {
            this.dwf.gD(true);
        }
        if (!this.dwn.isRunning()) {
            this.dwn.start();
        }
    }

    public void setAtLeastRotateRounds(int i) {
        this.dwl = i;
    }

    public void setOnLoadingAnimationListener(a aVar) {
        this.dwf = aVar;
    }

    public void stopAnim() {
        aIY();
        clearAnimation();
        this.dvW = 0.0f;
        this.dwm = 1;
        kj(1);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredWidth() > getHeight()) {
            this.bPi = getMeasuredHeight();
        } else {
            this.bPi = getMeasuredWidth();
        }
        this.dvZ = ah.dip2px(getContext(), 8.0f);
        this.dwb = ah.dip2px(getContext(), 6.5f);
        this.dwk = ah.dip2px(getContext(), 5.0f);
        this.dwc = ah.dip2px(getContext(), 7.5f);
        float f = this.bPi / 2.0f;
        this.dwd.set(f, f);
        float f2 = f + ((float) (this.dvZ / dvV));
        this.dwi.set(f2, f2);
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
            if (this.duG != com.baidu.swan.apps.t.a.azw().getNightModeSwitcherState()) {
                this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
                this.duG = com.baidu.swan.apps.t.a.azw().getNightModeSwitcherState();
            }
            this.mPaint.setAlpha(76);
            this.dwg.set(this.dwd.x - this.dvZ, this.dwd.y - this.dvZ, this.dwd.x + this.dvZ, this.dwd.y + this.dvZ);
            this.mCanvas.drawArc(this.dwg, -90.0f, (-360.0f) * this.dvX, true, this.mPaint);
            this.mCanvas.drawCircle(this.dwd.x, this.dwd.y, this.dwa, this.dwe);
            if (this.dvY > 0.0f) {
                this.mCanvas.drawCircle(this.dwj.x, this.dwj.y, 0.75f, this.mPaint);
                this.mPaint.setStyle(Paint.Style.STROKE);
                this.mPaint.setStrokeWidth(ah.dip2px(getContext(), 1.5f));
                this.mCanvas.drawLine(this.dwi.x, this.dwi.y, this.dwj.x, this.dwj.y, this.mPaint);
            }
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    private void aJn() {
        this.dvX = this.dvW;
        if (this.dvW < 0.5f) {
            this.dvY = 0.0f;
            this.dwa = 0.0f;
            return;
        }
        this.dwa = ((this.dvW - 0.5f) / 0.5f) * this.dwb;
        if (this.dvW < 0.625f) {
            this.dvY = 0.0f;
            return;
        }
        this.dvY = (this.dvW - 0.625f) / 0.375f;
        this.dwj.set(this.dwi.x + ((float) ((this.dwk * this.dvY) / dvV)), this.dwi.y + ((float) ((this.dwk * this.dvY) / dvV)));
    }

    private void u(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setAlpha((int) (255.0d * ((this.dwp * 0.3d) + 0.3d)));
            float f = this.dwi.x + ((float) (this.dwk / dvV));
            this.mCanvas.drawCircle(this.dwd.x, this.dwd.y, this.dvZ, this.mPaint);
            this.mCanvas.drawCircle(this.dwd.x, this.dwd.y, this.dwb, this.dwe);
            this.mCanvas.drawCircle(f, f, 0.75f, this.mPaint);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(ah.dip2px(getContext(), 1.5f));
            this.mCanvas.drawLine(this.dwi.x, this.dwi.y, f, f, this.mPaint);
            this.mMatrix.reset();
            this.duI.save();
            this.duI.setLocation(0.0f, 0.0f, -100.0f);
            this.duI.rotateY(this.dwp * 90.0f);
            this.duI.getMatrix(this.mMatrix);
            this.duI.restore();
            this.mMatrix.preTranslate(-this.dwd.x, -this.dwd.y);
            this.mMatrix.postTranslate(this.dwd.x, this.dwd.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(float f) {
        this.dwp = f;
        postInvalidate();
    }

    private void v(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            int abs = (int) ((((1.0d - (Math.abs(this.dwo - 0.5d) * 2.0d)) * 0.3d) + 0.3d) * 255.0d);
            if (this.duG) {
                abs = (int) ((((1.0d - (Math.abs(this.dwo - 0.5d) * 2.0d)) * 0.2d) + 0.1d) * 255.0d);
            }
            this.mPaint.setAlpha(abs);
            this.mCanvas.drawCircle(this.dwd.x, this.dwd.y, this.dwc, this.mPaint);
            this.mMatrix.reset();
            this.duI.save();
            this.duI.setLocation(0.0f, 0.0f, -100.0f);
            this.duI.rotateY((this.dwo * 360.0f) + 90.0f);
            this.duI.getMatrix(this.mMatrix);
            this.duI.restore();
            this.mMatrix.preTranslate(-this.dwd.x, -this.dwd.y);
            this.mMatrix.postTranslate(this.dwd.x, this.dwd.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(float f) {
        if (f < 0.2f) {
            this.dwo = (f / 0.2f) * 0.5f;
        } else {
            this.dwo = (((f - 0.2f) / 0.8f) * 0.5f) + 0.5f;
        }
        postInvalidate();
    }

    private void sz() {
        this.duG = com.baidu.swan.apps.t.a.azw().getNightModeSwitcherState();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
        this.dwe = new Paint();
        this.dwe.setAntiAlias(true);
        this.dwe.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.duI = new Camera();
        this.mMatrix = new Matrix();
        kj(1);
    }

    private void kj(int i) {
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

    private void aIY() {
        if (this.dwq != null) {
            this.dwq.setRepeatCount(0);
            this.dwq.removeAllUpdateListeners();
            this.dwq.removeAllListeners();
            this.dwq.end();
            this.dwq.cancel();
        }
        if (this.dwn != null) {
            this.dwn.setRepeatCount(0);
            this.dwn.removeAllUpdateListeners();
            this.dwn.removeAllListeners();
            this.dwn.end();
            this.dwn.cancel();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aIY();
    }
}
