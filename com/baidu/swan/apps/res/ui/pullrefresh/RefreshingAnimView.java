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
import com.baidu.swan.apps.an.x;
import com.baidu.swan.apps.b;
/* loaded from: classes2.dex */
public class RefreshingAnimView extends View {
    private static final double aJx = Math.sqrt(2.0d);
    private boolean aId;
    private Canvas aIf;
    private Camera aIg;
    float aJA;
    float aJB;
    float aJC;
    float aJD;
    float aJE;
    private PointF aJF;
    private Paint aJG;
    private a aJH;
    private RectF aJI;
    private PointF aJJ;
    private PointF aJK;
    private PointF aJL;
    private float aJM;
    private int aJN;
    private int aJO;
    private ValueAnimator aJP;
    private float aJQ;
    private float aJR;
    private ValueAnimator aJS;
    float aJy;
    float aJz;
    private Bitmap mBitmap;
    private Matrix mMatrix;
    private Paint mPaint;
    private int mState;
    private float mWidth;

    /* loaded from: classes2.dex */
    public interface a {
        void bE(boolean z);
    }

    static /* synthetic */ int a(RefreshingAnimView refreshingAnimView) {
        int i = refreshingAnimView.aJO;
        refreshingAnimView.aJO = i + 1;
        return i;
    }

    public RefreshingAnimView(Context context) {
        super(context);
        this.aJy = 0.0f;
        this.aJz = 0.0f;
        this.aJA = 0.0f;
        this.aJB = 0.0f;
        this.aJC = 0.0f;
        this.aJD = 0.0f;
        this.aJE = 0.0f;
        this.mWidth = 0.0f;
        this.aJF = new PointF();
        this.aJI = new RectF();
        this.aJJ = new PointF();
        this.aJK = new PointF();
        this.aJL = new PointF();
        this.aJM = 0.0f;
        this.aJN = 0;
        this.aJO = 1;
        this.aJP = null;
        this.aJQ = 0.0f;
        this.aJR = 0.0f;
        this.aJS = null;
        this.aId = false;
        this.mState = 0;
        qY();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aJy = 0.0f;
        this.aJz = 0.0f;
        this.aJA = 0.0f;
        this.aJB = 0.0f;
        this.aJC = 0.0f;
        this.aJD = 0.0f;
        this.aJE = 0.0f;
        this.mWidth = 0.0f;
        this.aJF = new PointF();
        this.aJI = new RectF();
        this.aJJ = new PointF();
        this.aJK = new PointF();
        this.aJL = new PointF();
        this.aJM = 0.0f;
        this.aJN = 0;
        this.aJO = 1;
        this.aJP = null;
        this.aJQ = 0.0f;
        this.aJR = 0.0f;
        this.aJS = null;
        this.aId = false;
        this.mState = 0;
        qY();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aJy = 0.0f;
        this.aJz = 0.0f;
        this.aJA = 0.0f;
        this.aJB = 0.0f;
        this.aJC = 0.0f;
        this.aJD = 0.0f;
        this.aJE = 0.0f;
        this.mWidth = 0.0f;
        this.aJF = new PointF();
        this.aJI = new RectF();
        this.aJJ = new PointF();
        this.aJK = new PointF();
        this.aJL = new PointF();
        this.aJM = 0.0f;
        this.aJN = 0;
        this.aJO = 1;
        this.aJP = null;
        this.aJQ = 0.0f;
        this.aJR = 0.0f;
        this.aJS = null;
        this.aId = false;
        this.mState = 0;
        qY();
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        this.aJy = f2 <= 1.0f ? f2 : 1.0f;
        HE();
        postInvalidate();
    }

    public void HD() {
        E(300L);
    }

    private void E(long j) {
        cT(2);
        if (this.aJS != null) {
            Hp();
        }
        this.aJS = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.aJS.setDuration(j);
        this.aJS.setInterpolator(new LinearInterpolator());
        this.aJS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.Z(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.aJS.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                RefreshingAnimView.this.F(750L);
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
        if (!this.aJS.isRunning()) {
            this.aJS.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(long j) {
        cT(3);
        if (this.aJP != null) {
            Hp();
        }
        this.aJP = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.aJP.setDuration(j);
        this.aJP.setInterpolator(new LinearInterpolator());
        this.aJP.setRepeatCount(-1);
        this.aJP.setRepeatMode(1);
        this.aJP.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.aa(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        if (this.aJN > 0) {
            this.aJP.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.4
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
                    if (RefreshingAnimView.this.aJO > RefreshingAnimView.this.aJN && RefreshingAnimView.this.aJH != null) {
                        RefreshingAnimView.this.aJH.bE(true);
                    }
                }
            });
        } else if (this.aJH != null) {
            this.aJH.bE(true);
        }
        if (!this.aJP.isRunning()) {
            this.aJP.start();
        }
    }

    public void setAtLeastRotateRounds(int i) {
        this.aJN = i;
    }

    public void setOnLoadingAnimationListener(a aVar) {
        this.aJH = aVar;
    }

    public void stopAnim() {
        Hp();
        clearAnimation();
        this.aJy = 0.0f;
        this.aJO = 1;
        cT(1);
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
        this.aJB = x.dip2px(getContext(), 8.0f);
        this.aJD = x.dip2px(getContext(), 6.5f);
        this.aJM = x.dip2px(getContext(), 5.0f);
        this.aJE = x.dip2px(getContext(), 7.5f);
        float f = this.mWidth / 2.0f;
        this.aJF.set(f, f);
        float f2 = f + ((float) (this.aJB / aJx));
        this.aJK.set(f2, f2);
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
        Log.w("RefreshingAnimView", "onDraw->mState:" + HF() + ";AnimValue:" + this.aJy);
    }

    private void p(Canvas canvas) {
        if (this.mBitmap != null && this.aIf != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            if (this.aId != com.baidu.swan.apps.u.a.CT().Ds()) {
                this.mPaint.setColor(getResources().getColor(b.c.aiapps_pull_loading_refresh_anim_color));
                this.aId = com.baidu.swan.apps.u.a.CT().Ds();
            }
            this.mPaint.setAlpha(76);
            this.aJI.set(this.aJF.x - this.aJB, this.aJF.y - this.aJB, this.aJF.x + this.aJB, this.aJF.y + this.aJB);
            this.aIf.drawArc(this.aJI, -90.0f, (-360.0f) * this.aJz, true, this.mPaint);
            this.aIf.drawCircle(this.aJF.x, this.aJF.y, this.aJC, this.aJG);
            if (this.aJA > 0.0f) {
                this.aIf.drawCircle(this.aJL.x, this.aJL.y, 0.75f, this.mPaint);
                this.mPaint.setStyle(Paint.Style.STROKE);
                this.mPaint.setStrokeWidth(x.dip2px(getContext(), 1.5f));
                this.aIf.drawLine(this.aJK.x, this.aJK.y, this.aJL.x, this.aJL.y, this.mPaint);
            }
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    private void HE() {
        this.aJz = this.aJy;
        if (this.aJy < 0.5f) {
            this.aJA = 0.0f;
            this.aJC = 0.0f;
            return;
        }
        this.aJC = ((this.aJy - 0.5f) / 0.5f) * this.aJD;
        if (this.aJy < 0.625f) {
            this.aJA = 0.0f;
            return;
        }
        this.aJA = (this.aJy - 0.625f) / 0.375f;
        this.aJL.set(this.aJK.x + ((float) ((this.aJM * this.aJA) / aJx)), this.aJK.y + ((float) ((this.aJM * this.aJA) / aJx)));
    }

    private void q(Canvas canvas) {
        if (this.mBitmap != null && this.aIf != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setAlpha((int) (255.0d * ((this.aJR * 0.3d) + 0.3d)));
            float f = this.aJK.x + ((float) (this.aJM / aJx));
            this.aIf.drawCircle(this.aJF.x, this.aJF.y, this.aJB, this.mPaint);
            this.aIf.drawCircle(this.aJF.x, this.aJF.y, this.aJD, this.aJG);
            this.aIf.drawCircle(f, f, 0.75f, this.mPaint);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(x.dip2px(getContext(), 1.5f));
            this.aIf.drawLine(this.aJK.x, this.aJK.y, f, f, this.mPaint);
            this.mMatrix.reset();
            this.aIg.save();
            this.aIg.setLocation(0.0f, 0.0f, -100.0f);
            this.aIg.rotateY(this.aJR * 90.0f);
            this.aIg.getMatrix(this.mMatrix);
            this.aIg.restore();
            this.mMatrix.preTranslate(-this.aJF.x, -this.aJF.y);
            this.mMatrix.postTranslate(this.aJF.x, this.aJF.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(float f) {
        this.aJR = f;
        postInvalidate();
    }

    private void r(Canvas canvas) {
        if (this.mBitmap != null && this.aIf != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            int abs = (int) ((((1.0d - (Math.abs(this.aJQ - 0.5d) * 2.0d)) * 0.3d) + 0.3d) * 255.0d);
            if (this.aId) {
                abs = (int) ((((1.0d - (Math.abs(this.aJQ - 0.5d) * 2.0d)) * 0.2d) + 0.1d) * 255.0d);
            }
            this.mPaint.setAlpha(abs);
            this.aIf.drawCircle(this.aJF.x, this.aJF.y, this.aJE, this.mPaint);
            this.mMatrix.reset();
            this.aIg.save();
            this.aIg.setLocation(0.0f, 0.0f, -100.0f);
            this.aIg.rotateY((this.aJQ * 360.0f) + 90.0f);
            this.aIg.getMatrix(this.mMatrix);
            this.aIg.restore();
            this.mMatrix.preTranslate(-this.aJF.x, -this.aJF.y);
            this.mMatrix.postTranslate(this.aJF.x, this.aJF.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa(float f) {
        if (f < 0.2f) {
            this.aJQ = (f / 0.2f) * 0.5f;
        } else {
            this.aJQ = (((f - 0.2f) / 0.8f) * 0.5f) + 0.5f;
        }
        postInvalidate();
    }

    private void qY() {
        this.aId = com.baidu.swan.apps.u.a.CT().Ds();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(getResources().getColor(b.c.aiapps_pull_loading_refresh_anim_color));
        this.aJG = new Paint();
        this.aJG.setAntiAlias(true);
        this.aJG.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.aIg = new Camera();
        this.mMatrix = new Matrix();
        cT(1);
    }

    private void cT(int i) {
        this.mState = i;
    }

    private String HF() {
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
            this.aIf = new Canvas(this.mBitmap);
        }
    }

    private void Hp() {
        if (this.aJS != null) {
            this.aJS.setRepeatCount(0);
            this.aJS.removeAllUpdateListeners();
            this.aJS.removeAllListeners();
            this.aJS.end();
            this.aJS.cancel();
        }
        if (this.aJP != null) {
            this.aJP.setRepeatCount(0);
            this.aJP.removeAllUpdateListeners();
            this.aJP.removeAllListeners();
            this.aJP.end();
            this.aJP.cancel();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Hp();
    }
}
