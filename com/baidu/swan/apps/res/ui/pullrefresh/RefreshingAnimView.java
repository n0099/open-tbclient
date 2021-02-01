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
/* loaded from: classes9.dex */
public class RefreshingAnimView extends View {
    private static final double dzx = Math.sqrt(2.0d);
    private float bTr;
    private boolean dyk;
    private Camera dym;
    float dzA;
    float dzB;
    float dzC;
    float dzD;
    float dzE;
    private PointF dzF;
    private Paint dzG;
    private a dzH;
    private RectF dzI;
    private PointF dzJ;
    private PointF dzK;
    private PointF dzL;
    private float dzM;
    private int dzN;
    private int dzO;
    private ValueAnimator dzP;
    private float dzQ;
    private float dzR;
    private ValueAnimator dzS;
    float dzy;
    float dzz;
    private Bitmap mBitmap;
    private Canvas mCanvas;
    private Matrix mMatrix;
    private Paint mPaint;
    private int mState;

    /* loaded from: classes9.dex */
    public interface a {
        void gK(boolean z);
    }

    static /* synthetic */ int a(RefreshingAnimView refreshingAnimView) {
        int i = refreshingAnimView.dzO;
        refreshingAnimView.dzO = i + 1;
        return i;
    }

    public RefreshingAnimView(Context context) {
        super(context);
        this.dzy = 0.0f;
        this.dzz = 0.0f;
        this.dzA = 0.0f;
        this.dzB = 0.0f;
        this.dzC = 0.0f;
        this.dzD = 0.0f;
        this.dzE = 0.0f;
        this.bTr = 0.0f;
        this.dzF = new PointF();
        this.dzI = new RectF();
        this.dzJ = new PointF();
        this.dzK = new PointF();
        this.dzL = new PointF();
        this.dzM = 0.0f;
        this.dzN = 0;
        this.dzO = 1;
        this.dzP = null;
        this.dzQ = 0.0f;
        this.dzR = 0.0f;
        this.dzS = null;
        this.dyk = false;
        this.mState = 0;
        rX();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dzy = 0.0f;
        this.dzz = 0.0f;
        this.dzA = 0.0f;
        this.dzB = 0.0f;
        this.dzC = 0.0f;
        this.dzD = 0.0f;
        this.dzE = 0.0f;
        this.bTr = 0.0f;
        this.dzF = new PointF();
        this.dzI = new RectF();
        this.dzJ = new PointF();
        this.dzK = new PointF();
        this.dzL = new PointF();
        this.dzM = 0.0f;
        this.dzN = 0;
        this.dzO = 1;
        this.dzP = null;
        this.dzQ = 0.0f;
        this.dzR = 0.0f;
        this.dzS = null;
        this.dyk = false;
        this.mState = 0;
        rX();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dzy = 0.0f;
        this.dzz = 0.0f;
        this.dzA = 0.0f;
        this.dzB = 0.0f;
        this.dzC = 0.0f;
        this.dzD = 0.0f;
        this.dzE = 0.0f;
        this.bTr = 0.0f;
        this.dzF = new PointF();
        this.dzI = new RectF();
        this.dzJ = new PointF();
        this.dzK = new PointF();
        this.dzL = new PointF();
        this.dzM = 0.0f;
        this.dzN = 0;
        this.dzO = 1;
        this.dzP = null;
        this.dzQ = 0.0f;
        this.dzR = 0.0f;
        this.dzS = null;
        this.dyk = false;
        this.mState = 0;
        rX();
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        this.dzy = f2 <= 1.0f ? f2 : 1.0f;
        aHx();
        postInvalidate();
    }

    public void aHw() {
        cS(300L);
    }

    private void cS(long j) {
        iF(2);
        if (this.dzS != null) {
            aHi();
        }
        this.dzS = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.dzS.setDuration(j);
        this.dzS.setInterpolator(new LinearInterpolator());
        this.dzS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.L(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.dzS.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.2
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
        if (!this.dzS.isRunning()) {
            this.dzS.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cT(long j) {
        iF(3);
        if (this.dzP != null) {
            aHi();
        }
        this.dzP = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.dzP.setDuration(j);
        this.dzP.setInterpolator(new LinearInterpolator());
        this.dzP.setRepeatCount(-1);
        this.dzP.setRepeatMode(1);
        this.dzP.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.M(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        if (this.dzN > 0) {
            this.dzP.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.4
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
                    if (RefreshingAnimView.this.dzO > RefreshingAnimView.this.dzN && RefreshingAnimView.this.dzH != null) {
                        RefreshingAnimView.this.dzH.gK(true);
                    }
                }
            });
        } else if (this.dzH != null) {
            this.dzH.gK(true);
        }
        if (!this.dzP.isRunning()) {
            this.dzP.start();
        }
    }

    public void setAtLeastRotateRounds(int i) {
        this.dzN = i;
    }

    public void setOnLoadingAnimationListener(a aVar) {
        this.dzH = aVar;
    }

    public void stopAnim() {
        aHi();
        clearAnimation();
        this.dzy = 0.0f;
        this.dzO = 1;
        iF(1);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredWidth() > getHeight()) {
            this.bTr = getMeasuredHeight();
        } else {
            this.bTr = getMeasuredWidth();
        }
        this.dzB = ah.dip2px(getContext(), 8.0f);
        this.dzD = ah.dip2px(getContext(), 6.5f);
        this.dzM = ah.dip2px(getContext(), 5.0f);
        this.dzE = ah.dip2px(getContext(), 7.5f);
        float f = this.bTr / 2.0f;
        this.dzF.set(f, f);
        float f2 = f + ((float) (this.dzB / dzx));
        this.dzK.set(f2, f2);
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
            if (this.dyk != com.baidu.swan.apps.t.a.axs().aii()) {
                this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
                this.dyk = com.baidu.swan.apps.t.a.axs().aii();
            }
            this.mPaint.setAlpha(76);
            this.dzI.set(this.dzF.x - this.dzB, this.dzF.y - this.dzB, this.dzF.x + this.dzB, this.dzF.y + this.dzB);
            this.mCanvas.drawArc(this.dzI, -90.0f, (-360.0f) * this.dzz, true, this.mPaint);
            this.mCanvas.drawCircle(this.dzF.x, this.dzF.y, this.dzC, this.dzG);
            if (this.dzA > 0.0f) {
                this.mCanvas.drawCircle(this.dzL.x, this.dzL.y, 0.75f, this.mPaint);
                this.mPaint.setStyle(Paint.Style.STROKE);
                this.mPaint.setStrokeWidth(ah.dip2px(getContext(), 1.5f));
                this.mCanvas.drawLine(this.dzK.x, this.dzK.y, this.dzL.x, this.dzL.y, this.mPaint);
            }
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    private void aHx() {
        this.dzz = this.dzy;
        if (this.dzy < 0.5f) {
            this.dzA = 0.0f;
            this.dzC = 0.0f;
            return;
        }
        this.dzC = ((this.dzy - 0.5f) / 0.5f) * this.dzD;
        if (this.dzy < 0.625f) {
            this.dzA = 0.0f;
            return;
        }
        this.dzA = (this.dzy - 0.625f) / 0.375f;
        this.dzL.set(this.dzK.x + ((float) ((this.dzM * this.dzA) / dzx)), this.dzK.y + ((float) ((this.dzM * this.dzA) / dzx)));
    }

    private void B(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setAlpha((int) (255.0d * ((this.dzR * 0.3d) + 0.3d)));
            float f = this.dzK.x + ((float) (this.dzM / dzx));
            this.mCanvas.drawCircle(this.dzF.x, this.dzF.y, this.dzB, this.mPaint);
            this.mCanvas.drawCircle(this.dzF.x, this.dzF.y, this.dzD, this.dzG);
            this.mCanvas.drawCircle(f, f, 0.75f, this.mPaint);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(ah.dip2px(getContext(), 1.5f));
            this.mCanvas.drawLine(this.dzK.x, this.dzK.y, f, f, this.mPaint);
            this.mMatrix.reset();
            this.dym.save();
            this.dym.setLocation(0.0f, 0.0f, -100.0f);
            this.dym.rotateY(this.dzR * 90.0f);
            this.dym.getMatrix(this.mMatrix);
            this.dym.restore();
            this.mMatrix.preTranslate(-this.dzF.x, -this.dzF.y);
            this.mMatrix.postTranslate(this.dzF.x, this.dzF.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(float f) {
        this.dzR = f;
        postInvalidate();
    }

    private void C(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            int abs = (int) ((((1.0d - (Math.abs(this.dzQ - 0.5d) * 2.0d)) * 0.3d) + 0.3d) * 255.0d);
            if (this.dyk) {
                abs = (int) ((((1.0d - (Math.abs(this.dzQ - 0.5d) * 2.0d)) * 0.2d) + 0.1d) * 255.0d);
            }
            this.mPaint.setAlpha(abs);
            this.mCanvas.drawCircle(this.dzF.x, this.dzF.y, this.dzE, this.mPaint);
            this.mMatrix.reset();
            this.dym.save();
            this.dym.setLocation(0.0f, 0.0f, -100.0f);
            this.dym.rotateY((this.dzQ * 360.0f) + 90.0f);
            this.dym.getMatrix(this.mMatrix);
            this.dym.restore();
            this.mMatrix.preTranslate(-this.dzF.x, -this.dzF.y);
            this.mMatrix.postTranslate(this.dzF.x, this.dzF.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(float f) {
        if (f < 0.2f) {
            this.dzQ = (f / 0.2f) * 0.5f;
        } else {
            this.dzQ = (((f - 0.2f) / 0.8f) * 0.5f) + 0.5f;
        }
        postInvalidate();
    }

    private void rX() {
        this.dyk = com.baidu.swan.apps.t.a.axs().aii();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
        this.dzG = new Paint();
        this.dzG.setAntiAlias(true);
        this.dzG.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.dym = new Camera();
        this.mMatrix = new Matrix();
        iF(1);
    }

    private void iF(int i) {
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

    private void aHi() {
        if (this.dzS != null) {
            this.dzS.setRepeatCount(0);
            this.dzS.removeAllUpdateListeners();
            this.dzS.removeAllListeners();
            this.dzS.end();
            this.dzS.cancel();
        }
        if (this.dzP != null) {
            this.dzP.setRepeatCount(0);
            this.dzP.removeAllUpdateListeners();
            this.dzP.removeAllListeners();
            this.dzP.end();
            this.dzP.cancel();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aHi();
    }
}
