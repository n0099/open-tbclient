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
import com.baidu.swan.apps.ao.ah;
/* loaded from: classes8.dex */
public class RefreshingAnimView extends View {
    private static final double dAY = Math.sqrt(2.0d);
    private float bUR;
    float dAZ;
    float dBa;
    float dBb;
    float dBc;
    float dBd;
    float dBe;
    float dBf;
    private PointF dBg;
    private Paint dBh;
    private a dBi;
    private RectF dBj;
    private PointF dBk;
    private PointF dBl;
    private PointF dBm;
    private float dBn;
    private int dBo;
    private int dBp;
    private ValueAnimator dBq;
    private float dBr;
    private float dBs;
    private ValueAnimator dBt;
    private boolean dzL;
    private Camera dzN;
    private Bitmap mBitmap;
    private Canvas mCanvas;
    private Matrix mMatrix;
    private Paint mPaint;
    private int mState;

    /* loaded from: classes8.dex */
    public interface a {
        void gK(boolean z);
    }

    static /* synthetic */ int a(RefreshingAnimView refreshingAnimView) {
        int i = refreshingAnimView.dBp;
        refreshingAnimView.dBp = i + 1;
        return i;
    }

    public RefreshingAnimView(Context context) {
        super(context);
        this.dAZ = 0.0f;
        this.dBa = 0.0f;
        this.dBb = 0.0f;
        this.dBc = 0.0f;
        this.dBd = 0.0f;
        this.dBe = 0.0f;
        this.dBf = 0.0f;
        this.bUR = 0.0f;
        this.dBg = new PointF();
        this.dBj = new RectF();
        this.dBk = new PointF();
        this.dBl = new PointF();
        this.dBm = new PointF();
        this.dBn = 0.0f;
        this.dBo = 0;
        this.dBp = 1;
        this.dBq = null;
        this.dBr = 0.0f;
        this.dBs = 0.0f;
        this.dBt = null;
        this.dzL = false;
        this.mState = 0;
        rX();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dAZ = 0.0f;
        this.dBa = 0.0f;
        this.dBb = 0.0f;
        this.dBc = 0.0f;
        this.dBd = 0.0f;
        this.dBe = 0.0f;
        this.dBf = 0.0f;
        this.bUR = 0.0f;
        this.dBg = new PointF();
        this.dBj = new RectF();
        this.dBk = new PointF();
        this.dBl = new PointF();
        this.dBm = new PointF();
        this.dBn = 0.0f;
        this.dBo = 0;
        this.dBp = 1;
        this.dBq = null;
        this.dBr = 0.0f;
        this.dBs = 0.0f;
        this.dBt = null;
        this.dzL = false;
        this.mState = 0;
        rX();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dAZ = 0.0f;
        this.dBa = 0.0f;
        this.dBb = 0.0f;
        this.dBc = 0.0f;
        this.dBd = 0.0f;
        this.dBe = 0.0f;
        this.dBf = 0.0f;
        this.bUR = 0.0f;
        this.dBg = new PointF();
        this.dBj = new RectF();
        this.dBk = new PointF();
        this.dBl = new PointF();
        this.dBm = new PointF();
        this.dBn = 0.0f;
        this.dBo = 0;
        this.dBp = 1;
        this.dBq = null;
        this.dBr = 0.0f;
        this.dBs = 0.0f;
        this.dBt = null;
        this.dzL = false;
        this.mState = 0;
        rX();
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        this.dAZ = f2 <= 1.0f ? f2 : 1.0f;
        aHA();
        postInvalidate();
    }

    public void aHz() {
        cS(300L);
    }

    private void cS(long j) {
        iG(2);
        if (this.dBt != null) {
            aHl();
        }
        this.dBt = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.dBt.setDuration(j);
        this.dBt.setInterpolator(new LinearInterpolator());
        this.dBt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.P(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.dBt.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                RefreshingAnimView.this.cT(750L);
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
        if (!this.dBt.isRunning()) {
            this.dBt.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cT(long j) {
        iG(3);
        if (this.dBq != null) {
            aHl();
        }
        this.dBq = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.dBq.setDuration(j);
        this.dBq.setInterpolator(new LinearInterpolator());
        this.dBq.setRepeatCount(-1);
        this.dBq.setRepeatMode(1);
        this.dBq.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.Q(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        if (this.dBo > 0) {
            this.dBq.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.4
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
                    if (RefreshingAnimView.this.dBp > RefreshingAnimView.this.dBo && RefreshingAnimView.this.dBi != null) {
                        RefreshingAnimView.this.dBi.gK(true);
                    }
                }
            });
        } else if (this.dBi != null) {
            this.dBi.gK(true);
        }
        if (!this.dBq.isRunning()) {
            this.dBq.start();
        }
    }

    public void setAtLeastRotateRounds(int i) {
        this.dBo = i;
    }

    public void setOnLoadingAnimationListener(a aVar) {
        this.dBi = aVar;
    }

    public void stopAnim() {
        aHl();
        clearAnimation();
        this.dAZ = 0.0f;
        this.dBp = 1;
        iG(1);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredWidth() > getHeight()) {
            this.bUR = getMeasuredHeight();
        } else {
            this.bUR = getMeasuredWidth();
        }
        this.dBc = ah.dip2px(getContext(), 8.0f);
        this.dBe = ah.dip2px(getContext(), 6.5f);
        this.dBn = ah.dip2px(getContext(), 5.0f);
        this.dBf = ah.dip2px(getContext(), 7.5f);
        float f = this.bUR / 2.0f;
        this.dBg.set(f, f);
        float f2 = f + ((float) (this.dBc / dAY));
        this.dBl.set(f2, f2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        switch (this.mState) {
            case 1:
                A(canvas);
                break;
            case 2:
                B(canvas);
                break;
            case 3:
                C(canvas);
                break;
        }
        canvas.restore();
    }

    private void A(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            if (this.dzL != com.baidu.swan.apps.t.a.axv().ail()) {
                this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
                this.dzL = com.baidu.swan.apps.t.a.axv().ail();
            }
            this.mPaint.setAlpha(76);
            this.dBj.set(this.dBg.x - this.dBc, this.dBg.y - this.dBc, this.dBg.x + this.dBc, this.dBg.y + this.dBc);
            this.mCanvas.drawArc(this.dBj, -90.0f, (-360.0f) * this.dBa, true, this.mPaint);
            this.mCanvas.drawCircle(this.dBg.x, this.dBg.y, this.dBd, this.dBh);
            if (this.dBb > 0.0f) {
                this.mCanvas.drawCircle(this.dBm.x, this.dBm.y, 0.75f, this.mPaint);
                this.mPaint.setStyle(Paint.Style.STROKE);
                this.mPaint.setStrokeWidth(ah.dip2px(getContext(), 1.5f));
                this.mCanvas.drawLine(this.dBl.x, this.dBl.y, this.dBm.x, this.dBm.y, this.mPaint);
            }
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    private void aHA() {
        this.dBa = this.dAZ;
        if (this.dAZ < 0.5f) {
            this.dBb = 0.0f;
            this.dBd = 0.0f;
            return;
        }
        this.dBd = ((this.dAZ - 0.5f) / 0.5f) * this.dBe;
        if (this.dAZ < 0.625f) {
            this.dBb = 0.0f;
            return;
        }
        this.dBb = (this.dAZ - 0.625f) / 0.375f;
        this.dBm.set(this.dBl.x + ((float) ((this.dBn * this.dBb) / dAY)), this.dBl.y + ((float) ((this.dBn * this.dBb) / dAY)));
    }

    private void B(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setAlpha((int) (255.0d * ((this.dBs * 0.3d) + 0.3d)));
            float f = this.dBl.x + ((float) (this.dBn / dAY));
            this.mCanvas.drawCircle(this.dBg.x, this.dBg.y, this.dBc, this.mPaint);
            this.mCanvas.drawCircle(this.dBg.x, this.dBg.y, this.dBe, this.dBh);
            this.mCanvas.drawCircle(f, f, 0.75f, this.mPaint);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(ah.dip2px(getContext(), 1.5f));
            this.mCanvas.drawLine(this.dBl.x, this.dBl.y, f, f, this.mPaint);
            this.mMatrix.reset();
            this.dzN.save();
            this.dzN.setLocation(0.0f, 0.0f, -100.0f);
            this.dzN.rotateY(this.dBs * 90.0f);
            this.dzN.getMatrix(this.mMatrix);
            this.dzN.restore();
            this.mMatrix.preTranslate(-this.dBg.x, -this.dBg.y);
            this.mMatrix.postTranslate(this.dBg.x, this.dBg.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(float f) {
        this.dBs = f;
        postInvalidate();
    }

    private void C(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            int abs = (int) ((((1.0d - (Math.abs(this.dBr - 0.5d) * 2.0d)) * 0.3d) + 0.3d) * 255.0d);
            if (this.dzL) {
                abs = (int) ((((1.0d - (Math.abs(this.dBr - 0.5d) * 2.0d)) * 0.2d) + 0.1d) * 255.0d);
            }
            this.mPaint.setAlpha(abs);
            this.mCanvas.drawCircle(this.dBg.x, this.dBg.y, this.dBf, this.mPaint);
            this.mMatrix.reset();
            this.dzN.save();
            this.dzN.setLocation(0.0f, 0.0f, -100.0f);
            this.dzN.rotateY((this.dBr * 360.0f) + 90.0f);
            this.dzN.getMatrix(this.mMatrix);
            this.dzN.restore();
            this.mMatrix.preTranslate(-this.dBg.x, -this.dBg.y);
            this.mMatrix.postTranslate(this.dBg.x, this.dBg.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(float f) {
        if (f < 0.2f) {
            this.dBr = (f / 0.2f) * 0.5f;
        } else {
            this.dBr = (((f - 0.2f) / 0.8f) * 0.5f) + 0.5f;
        }
        postInvalidate();
    }

    private void rX() {
        this.dzL = com.baidu.swan.apps.t.a.axv().ail();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
        this.dBh = new Paint();
        this.dBh.setAntiAlias(true);
        this.dBh.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.dzN = new Camera();
        this.mMatrix = new Matrix();
        iG(1);
    }

    private void iG(int i) {
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

    private void aHl() {
        if (this.dBt != null) {
            this.dBt.setRepeatCount(0);
            this.dBt.removeAllUpdateListeners();
            this.dBt.removeAllListeners();
            this.dBt.end();
            this.dBt.cancel();
        }
        if (this.dBq != null) {
            this.dBq.setRepeatCount(0);
            this.dBq.removeAllUpdateListeners();
            this.dBq.removeAllListeners();
            this.dBq.end();
            this.dBq.cancel();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aHl();
    }
}
