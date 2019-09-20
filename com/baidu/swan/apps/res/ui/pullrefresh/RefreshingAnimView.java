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
    private static final double aMB = Math.sqrt(2.0d);
    private boolean aLh;
    private Canvas aLj;
    private Camera aLk;
    float aMC;
    float aMD;
    float aME;
    float aMF;
    float aMG;
    float aMH;
    float aMI;
    private PointF aMJ;
    private Paint aMK;
    private a aML;
    private RectF aMM;
    private PointF aMN;
    private PointF aMO;
    private PointF aMP;
    private float aMQ;
    private int aMR;
    private int aMS;
    private ValueAnimator aMT;
    private float aMU;
    private float aMV;
    private ValueAnimator aMW;
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
        int i = refreshingAnimView.aMS;
        refreshingAnimView.aMS = i + 1;
        return i;
    }

    public RefreshingAnimView(Context context) {
        super(context);
        this.aMC = 0.0f;
        this.aMD = 0.0f;
        this.aME = 0.0f;
        this.aMF = 0.0f;
        this.aMG = 0.0f;
        this.aMH = 0.0f;
        this.aMI = 0.0f;
        this.mWidth = 0.0f;
        this.aMJ = new PointF();
        this.aMM = new RectF();
        this.aMN = new PointF();
        this.aMO = new PointF();
        this.aMP = new PointF();
        this.aMQ = 0.0f;
        this.aMR = 0;
        this.aMS = 1;
        this.aMT = null;
        this.aMU = 0.0f;
        this.aMV = 0.0f;
        this.aMW = null;
        this.aLh = false;
        this.mState = 0;
        qq();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aMC = 0.0f;
        this.aMD = 0.0f;
        this.aME = 0.0f;
        this.aMF = 0.0f;
        this.aMG = 0.0f;
        this.aMH = 0.0f;
        this.aMI = 0.0f;
        this.mWidth = 0.0f;
        this.aMJ = new PointF();
        this.aMM = new RectF();
        this.aMN = new PointF();
        this.aMO = new PointF();
        this.aMP = new PointF();
        this.aMQ = 0.0f;
        this.aMR = 0;
        this.aMS = 1;
        this.aMT = null;
        this.aMU = 0.0f;
        this.aMV = 0.0f;
        this.aMW = null;
        this.aLh = false;
        this.mState = 0;
        qq();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aMC = 0.0f;
        this.aMD = 0.0f;
        this.aME = 0.0f;
        this.aMF = 0.0f;
        this.aMG = 0.0f;
        this.aMH = 0.0f;
        this.aMI = 0.0f;
        this.mWidth = 0.0f;
        this.aMJ = new PointF();
        this.aMM = new RectF();
        this.aMN = new PointF();
        this.aMO = new PointF();
        this.aMP = new PointF();
        this.aMQ = 0.0f;
        this.aMR = 0;
        this.aMS = 1;
        this.aMT = null;
        this.aMU = 0.0f;
        this.aMV = 0.0f;
        this.aMW = null;
        this.aLh = false;
        this.mState = 0;
        qq();
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        this.aMC = f2 <= 1.0f ? f2 : 1.0f;
        KJ();
        postInvalidate();
    }

    public void KI() {
        Q(300L);
    }

    private void Q(long j) {
        db(2);
        if (this.aMW != null) {
            Ku();
        }
        this.aMW = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.aMW.setDuration(j);
        this.aMW.setInterpolator(new LinearInterpolator());
        this.aMW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.Z(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.aMW.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.2
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
        if (!this.aMW.isRunning()) {
            this.aMW.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(long j) {
        db(3);
        if (this.aMT != null) {
            Ku();
        }
        this.aMT = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.aMT.setDuration(j);
        this.aMT.setInterpolator(new LinearInterpolator());
        this.aMT.setRepeatCount(-1);
        this.aMT.setRepeatMode(1);
        this.aMT.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.aa(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        if (this.aMR > 0) {
            this.aMT.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.4
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
                    if (RefreshingAnimView.this.aMS > RefreshingAnimView.this.aMR && RefreshingAnimView.this.aML != null) {
                        RefreshingAnimView.this.aML.bQ(true);
                    }
                }
            });
        } else if (this.aML != null) {
            this.aML.bQ(true);
        }
        if (!this.aMT.isRunning()) {
            this.aMT.start();
        }
    }

    public void setAtLeastRotateRounds(int i) {
        this.aMR = i;
    }

    public void setOnLoadingAnimationListener(a aVar) {
        this.aML = aVar;
    }

    public void stopAnim() {
        Ku();
        clearAnimation();
        this.aMC = 0.0f;
        this.aMS = 1;
        db(1);
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
        this.aMF = z.dip2px(getContext(), 8.0f);
        this.aMH = z.dip2px(getContext(), 6.5f);
        this.aMQ = z.dip2px(getContext(), 5.0f);
        this.aMI = z.dip2px(getContext(), 7.5f);
        float f = this.mWidth / 2.0f;
        this.aMJ.set(f, f);
        float f2 = f + ((float) (this.aMF / aMB));
        this.aMO.set(f2, f2);
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
        Log.w("RefreshingAnimView", "onDraw->mState:" + KK() + ";AnimValue:" + this.aMC);
    }

    private void p(Canvas canvas) {
        if (this.mBitmap != null && this.aLj != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            if (this.aLh != com.baidu.swan.apps.u.a.EJ().Fi()) {
                this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
                this.aLh = com.baidu.swan.apps.u.a.EJ().Fi();
            }
            this.mPaint.setAlpha(76);
            this.aMM.set(this.aMJ.x - this.aMF, this.aMJ.y - this.aMF, this.aMJ.x + this.aMF, this.aMJ.y + this.aMF);
            this.aLj.drawArc(this.aMM, -90.0f, (-360.0f) * this.aMD, true, this.mPaint);
            this.aLj.drawCircle(this.aMJ.x, this.aMJ.y, this.aMG, this.aMK);
            if (this.aME > 0.0f) {
                this.aLj.drawCircle(this.aMP.x, this.aMP.y, 0.75f, this.mPaint);
                this.mPaint.setStyle(Paint.Style.STROKE);
                this.mPaint.setStrokeWidth(z.dip2px(getContext(), 1.5f));
                this.aLj.drawLine(this.aMO.x, this.aMO.y, this.aMP.x, this.aMP.y, this.mPaint);
            }
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    private void KJ() {
        this.aMD = this.aMC;
        if (this.aMC < 0.5f) {
            this.aME = 0.0f;
            this.aMG = 0.0f;
            return;
        }
        this.aMG = ((this.aMC - 0.5f) / 0.5f) * this.aMH;
        if (this.aMC < 0.625f) {
            this.aME = 0.0f;
            return;
        }
        this.aME = (this.aMC - 0.625f) / 0.375f;
        this.aMP.set(this.aMO.x + ((float) ((this.aMQ * this.aME) / aMB)), this.aMO.y + ((float) ((this.aMQ * this.aME) / aMB)));
    }

    private void q(Canvas canvas) {
        if (this.mBitmap != null && this.aLj != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setAlpha((int) (255.0d * ((this.aMV * 0.3d) + 0.3d)));
            float f = this.aMO.x + ((float) (this.aMQ / aMB));
            this.aLj.drawCircle(this.aMJ.x, this.aMJ.y, this.aMF, this.mPaint);
            this.aLj.drawCircle(this.aMJ.x, this.aMJ.y, this.aMH, this.aMK);
            this.aLj.drawCircle(f, f, 0.75f, this.mPaint);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(z.dip2px(getContext(), 1.5f));
            this.aLj.drawLine(this.aMO.x, this.aMO.y, f, f, this.mPaint);
            this.mMatrix.reset();
            this.aLk.save();
            this.aLk.setLocation(0.0f, 0.0f, -100.0f);
            this.aLk.rotateY(this.aMV * 90.0f);
            this.aLk.getMatrix(this.mMatrix);
            this.aLk.restore();
            this.mMatrix.preTranslate(-this.aMJ.x, -this.aMJ.y);
            this.mMatrix.postTranslate(this.aMJ.x, this.aMJ.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(float f) {
        this.aMV = f;
        postInvalidate();
    }

    private void r(Canvas canvas) {
        if (this.mBitmap != null && this.aLj != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            int abs = (int) ((((1.0d - (Math.abs(this.aMU - 0.5d) * 2.0d)) * 0.3d) + 0.3d) * 255.0d);
            if (this.aLh) {
                abs = (int) ((((1.0d - (Math.abs(this.aMU - 0.5d) * 2.0d)) * 0.2d) + 0.1d) * 255.0d);
            }
            this.mPaint.setAlpha(abs);
            this.aLj.drawCircle(this.aMJ.x, this.aMJ.y, this.aMI, this.mPaint);
            this.mMatrix.reset();
            this.aLk.save();
            this.aLk.setLocation(0.0f, 0.0f, -100.0f);
            this.aLk.rotateY((this.aMU * 360.0f) + 90.0f);
            this.aLk.getMatrix(this.mMatrix);
            this.aLk.restore();
            this.mMatrix.preTranslate(-this.aMJ.x, -this.aMJ.y);
            this.mMatrix.postTranslate(this.aMJ.x, this.aMJ.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa(float f) {
        if (f < 0.2f) {
            this.aMU = (f / 0.2f) * 0.5f;
        } else {
            this.aMU = (((f - 0.2f) / 0.8f) * 0.5f) + 0.5f;
        }
        postInvalidate();
    }

    private void qq() {
        this.aLh = com.baidu.swan.apps.u.a.EJ().Fi();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
        this.aMK = new Paint();
        this.aMK.setAntiAlias(true);
        this.aMK.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.aLk = new Camera();
        this.mMatrix = new Matrix();
        db(1);
    }

    private void db(int i) {
        this.mState = i;
    }

    private String KK() {
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
            this.aLj = new Canvas(this.mBitmap);
        }
    }

    private void Ku() {
        if (this.aMW != null) {
            this.aMW.setRepeatCount(0);
            this.aMW.removeAllUpdateListeners();
            this.aMW.removeAllListeners();
            this.aMW.end();
            this.aMW.cancel();
        }
        if (this.aMT != null) {
            this.aMT.setRepeatCount(0);
            this.aMT.removeAllUpdateListeners();
            this.aMT.removeAllListeners();
            this.aMT.end();
            this.aMT.cancel();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Ku();
    }
}
