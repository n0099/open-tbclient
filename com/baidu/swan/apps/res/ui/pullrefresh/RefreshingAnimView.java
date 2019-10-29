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
    private static final double bfL = Math.sqrt(2.0d);
    private Camera apj;
    private boolean bew;
    float bfM;
    float bfN;
    float bfO;
    float bfP;
    float bfQ;
    float bfR;
    float bfS;
    private PointF bfT;
    private Paint bfU;
    private a bfV;
    private RectF bfW;
    private PointF bfX;
    private PointF bfY;
    private PointF bfZ;
    private float bga;
    private int bgb;
    private int bgc;
    private ValueAnimator bgd;
    private float bge;
    private float bgf;
    private ValueAnimator bgg;
    private Bitmap mBitmap;
    private Canvas mCanvas;
    private Matrix mMatrix;
    private Paint mPaint;
    private int mState;
    private float mWidth;

    /* loaded from: classes2.dex */
    public interface a {
        void ch(boolean z);
    }

    static /* synthetic */ int a(RefreshingAnimView refreshingAnimView) {
        int i = refreshingAnimView.bgc;
        refreshingAnimView.bgc = i + 1;
        return i;
    }

    public RefreshingAnimView(Context context) {
        super(context);
        this.bfM = 0.0f;
        this.bfN = 0.0f;
        this.bfO = 0.0f;
        this.bfP = 0.0f;
        this.bfQ = 0.0f;
        this.bfR = 0.0f;
        this.bfS = 0.0f;
        this.mWidth = 0.0f;
        this.bfT = new PointF();
        this.bfW = new RectF();
        this.bfX = new PointF();
        this.bfY = new PointF();
        this.bfZ = new PointF();
        this.bga = 0.0f;
        this.bgb = 0;
        this.bgc = 1;
        this.bgd = null;
        this.bge = 0.0f;
        this.bgf = 0.0f;
        this.bgg = null;
        this.bew = false;
        this.mState = 0;
        lj();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bfM = 0.0f;
        this.bfN = 0.0f;
        this.bfO = 0.0f;
        this.bfP = 0.0f;
        this.bfQ = 0.0f;
        this.bfR = 0.0f;
        this.bfS = 0.0f;
        this.mWidth = 0.0f;
        this.bfT = new PointF();
        this.bfW = new RectF();
        this.bfX = new PointF();
        this.bfY = new PointF();
        this.bfZ = new PointF();
        this.bga = 0.0f;
        this.bgb = 0;
        this.bgc = 1;
        this.bgd = null;
        this.bge = 0.0f;
        this.bgf = 0.0f;
        this.bgg = null;
        this.bew = false;
        this.mState = 0;
        lj();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bfM = 0.0f;
        this.bfN = 0.0f;
        this.bfO = 0.0f;
        this.bfP = 0.0f;
        this.bfQ = 0.0f;
        this.bfR = 0.0f;
        this.bfS = 0.0f;
        this.mWidth = 0.0f;
        this.bfT = new PointF();
        this.bfW = new RectF();
        this.bfX = new PointF();
        this.bfY = new PointF();
        this.bfZ = new PointF();
        this.bga = 0.0f;
        this.bgb = 0;
        this.bgc = 1;
        this.bgd = null;
        this.bge = 0.0f;
        this.bgf = 0.0f;
        this.bgg = null;
        this.bew = false;
        this.mState = 0;
        lj();
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        this.bfM = f2 <= 1.0f ? f2 : 1.0f;
        PC();
        postInvalidate();
    }

    public void PB() {
        aj(300L);
    }

    private void aj(long j) {
        dW(2);
        if (this.bgg != null) {
            Pn();
        }
        this.bgg = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.bgg.setDuration(j);
        this.bgg.setInterpolator(new LinearInterpolator());
        this.bgg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.O(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.bgg.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                RefreshingAnimView.this.ak(750L);
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
        if (!this.bgg.isRunning()) {
            this.bgg.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ak(long j) {
        dW(3);
        if (this.bgd != null) {
            Pn();
        }
        this.bgd = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.bgd.setDuration(j);
        this.bgd.setInterpolator(new LinearInterpolator());
        this.bgd.setRepeatCount(-1);
        this.bgd.setRepeatMode(1);
        this.bgd.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.P(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        if (this.bgb > 0) {
            this.bgd.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.4
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
                    if (RefreshingAnimView.this.bgc > RefreshingAnimView.this.bgb && RefreshingAnimView.this.bfV != null) {
                        RefreshingAnimView.this.bfV.ch(true);
                    }
                }
            });
        } else if (this.bfV != null) {
            this.bfV.ch(true);
        }
        if (!this.bgd.isRunning()) {
            this.bgd.start();
        }
    }

    public void setAtLeastRotateRounds(int i) {
        this.bgb = i;
    }

    public void setOnLoadingAnimationListener(a aVar) {
        this.bfV = aVar;
    }

    public void stopAnim() {
        Pn();
        clearAnimation();
        this.bfM = 0.0f;
        this.bgc = 1;
        dW(1);
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
        this.bfP = z.dip2px(getContext(), 8.0f);
        this.bfR = z.dip2px(getContext(), 6.5f);
        this.bga = z.dip2px(getContext(), 5.0f);
        this.bfS = z.dip2px(getContext(), 7.5f);
        float f = this.mWidth / 2.0f;
        this.bfT.set(f, f);
        float f2 = f + ((float) (this.bfP / bfL));
        this.bfY.set(f2, f2);
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
        Log.w("RefreshingAnimView", "onDraw->mState:" + PD() + ";AnimValue:" + this.bfM);
    }

    private void t(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            if (this.bew != com.baidu.swan.apps.u.a.JD().Kc()) {
                this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
                this.bew = com.baidu.swan.apps.u.a.JD().Kc();
            }
            this.mPaint.setAlpha(76);
            this.bfW.set(this.bfT.x - this.bfP, this.bfT.y - this.bfP, this.bfT.x + this.bfP, this.bfT.y + this.bfP);
            this.mCanvas.drawArc(this.bfW, -90.0f, (-360.0f) * this.bfN, true, this.mPaint);
            this.mCanvas.drawCircle(this.bfT.x, this.bfT.y, this.bfQ, this.bfU);
            if (this.bfO > 0.0f) {
                this.mCanvas.drawCircle(this.bfZ.x, this.bfZ.y, 0.75f, this.mPaint);
                this.mPaint.setStyle(Paint.Style.STROKE);
                this.mPaint.setStrokeWidth(z.dip2px(getContext(), 1.5f));
                this.mCanvas.drawLine(this.bfY.x, this.bfY.y, this.bfZ.x, this.bfZ.y, this.mPaint);
            }
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    private void PC() {
        this.bfN = this.bfM;
        if (this.bfM < 0.5f) {
            this.bfO = 0.0f;
            this.bfQ = 0.0f;
            return;
        }
        this.bfQ = ((this.bfM - 0.5f) / 0.5f) * this.bfR;
        if (this.bfM < 0.625f) {
            this.bfO = 0.0f;
            return;
        }
        this.bfO = (this.bfM - 0.625f) / 0.375f;
        this.bfZ.set(this.bfY.x + ((float) ((this.bga * this.bfO) / bfL)), this.bfY.y + ((float) ((this.bga * this.bfO) / bfL)));
    }

    private void u(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setAlpha((int) (255.0d * ((this.bgf * 0.3d) + 0.3d)));
            float f = this.bfY.x + ((float) (this.bga / bfL));
            this.mCanvas.drawCircle(this.bfT.x, this.bfT.y, this.bfP, this.mPaint);
            this.mCanvas.drawCircle(this.bfT.x, this.bfT.y, this.bfR, this.bfU);
            this.mCanvas.drawCircle(f, f, 0.75f, this.mPaint);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(z.dip2px(getContext(), 1.5f));
            this.mCanvas.drawLine(this.bfY.x, this.bfY.y, f, f, this.mPaint);
            this.mMatrix.reset();
            this.apj.save();
            this.apj.setLocation(0.0f, 0.0f, -100.0f);
            this.apj.rotateY(this.bgf * 90.0f);
            this.apj.getMatrix(this.mMatrix);
            this.apj.restore();
            this.mMatrix.preTranslate(-this.bfT.x, -this.bfT.y);
            this.mMatrix.postTranslate(this.bfT.x, this.bfT.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(float f) {
        this.bgf = f;
        postInvalidate();
    }

    private void v(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            int abs = (int) ((((1.0d - (Math.abs(this.bge - 0.5d) * 2.0d)) * 0.3d) + 0.3d) * 255.0d);
            if (this.bew) {
                abs = (int) ((((1.0d - (Math.abs(this.bge - 0.5d) * 2.0d)) * 0.2d) + 0.1d) * 255.0d);
            }
            this.mPaint.setAlpha(abs);
            this.mCanvas.drawCircle(this.bfT.x, this.bfT.y, this.bfS, this.mPaint);
            this.mMatrix.reset();
            this.apj.save();
            this.apj.setLocation(0.0f, 0.0f, -100.0f);
            this.apj.rotateY((this.bge * 360.0f) + 90.0f);
            this.apj.getMatrix(this.mMatrix);
            this.apj.restore();
            this.mMatrix.preTranslate(-this.bfT.x, -this.bfT.y);
            this.mMatrix.postTranslate(this.bfT.x, this.bfT.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(float f) {
        if (f < 0.2f) {
            this.bge = (f / 0.2f) * 0.5f;
        } else {
            this.bge = (((f - 0.2f) / 0.8f) * 0.5f) + 0.5f;
        }
        postInvalidate();
    }

    private void lj() {
        this.bew = com.baidu.swan.apps.u.a.JD().Kc();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
        this.bfU = new Paint();
        this.bfU.setAntiAlias(true);
        this.bfU.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.apj = new Camera();
        this.mMatrix = new Matrix();
        dW(1);
    }

    private void dW(int i) {
        this.mState = i;
    }

    private String PD() {
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
            this.mCanvas = new Canvas(this.mBitmap);
        }
    }

    private void Pn() {
        if (this.bgg != null) {
            this.bgg.setRepeatCount(0);
            this.bgg.removeAllUpdateListeners();
            this.bgg.removeAllListeners();
            this.bgg.end();
            this.bgg.cancel();
        }
        if (this.bgd != null) {
            this.bgd.setRepeatCount(0);
            this.bgd.removeAllUpdateListeners();
            this.bgd.removeAllListeners();
            this.bgd.end();
            this.bgd.cancel();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Pn();
    }
}
