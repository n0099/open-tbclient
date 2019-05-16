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
    private static final double aLv = Math.sqrt(2.0d);
    private boolean aKb;
    private Canvas aKd;
    private Camera aKe;
    float aLA;
    float aLB;
    float aLC;
    private PointF aLD;
    private Paint aLE;
    private a aLF;
    private RectF aLG;
    private PointF aLH;
    private PointF aLI;
    private PointF aLJ;
    private float aLK;
    private int aLL;
    private int aLM;
    private ValueAnimator aLN;
    private float aLO;
    private float aLP;
    private ValueAnimator aLQ;
    float aLw;
    float aLx;
    float aLy;
    float aLz;
    private Bitmap mBitmap;
    private Matrix mMatrix;
    private Paint mPaint;
    private int mState;
    private float mWidth;

    /* loaded from: classes2.dex */
    public interface a {
        void bN(boolean z);
    }

    static /* synthetic */ int a(RefreshingAnimView refreshingAnimView) {
        int i = refreshingAnimView.aLM;
        refreshingAnimView.aLM = i + 1;
        return i;
    }

    public RefreshingAnimView(Context context) {
        super(context);
        this.aLw = 0.0f;
        this.aLx = 0.0f;
        this.aLy = 0.0f;
        this.aLz = 0.0f;
        this.aLA = 0.0f;
        this.aLB = 0.0f;
        this.aLC = 0.0f;
        this.mWidth = 0.0f;
        this.aLD = new PointF();
        this.aLG = new RectF();
        this.aLH = new PointF();
        this.aLI = new PointF();
        this.aLJ = new PointF();
        this.aLK = 0.0f;
        this.aLL = 0;
        this.aLM = 1;
        this.aLN = null;
        this.aLO = 0.0f;
        this.aLP = 0.0f;
        this.aLQ = null;
        this.aKb = false;
        this.mState = 0;
        pT();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aLw = 0.0f;
        this.aLx = 0.0f;
        this.aLy = 0.0f;
        this.aLz = 0.0f;
        this.aLA = 0.0f;
        this.aLB = 0.0f;
        this.aLC = 0.0f;
        this.mWidth = 0.0f;
        this.aLD = new PointF();
        this.aLG = new RectF();
        this.aLH = new PointF();
        this.aLI = new PointF();
        this.aLJ = new PointF();
        this.aLK = 0.0f;
        this.aLL = 0;
        this.aLM = 1;
        this.aLN = null;
        this.aLO = 0.0f;
        this.aLP = 0.0f;
        this.aLQ = null;
        this.aKb = false;
        this.mState = 0;
        pT();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aLw = 0.0f;
        this.aLx = 0.0f;
        this.aLy = 0.0f;
        this.aLz = 0.0f;
        this.aLA = 0.0f;
        this.aLB = 0.0f;
        this.aLC = 0.0f;
        this.mWidth = 0.0f;
        this.aLD = new PointF();
        this.aLG = new RectF();
        this.aLH = new PointF();
        this.aLI = new PointF();
        this.aLJ = new PointF();
        this.aLK = 0.0f;
        this.aLL = 0;
        this.aLM = 1;
        this.aLN = null;
        this.aLO = 0.0f;
        this.aLP = 0.0f;
        this.aLQ = null;
        this.aKb = false;
        this.mState = 0;
        pT();
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        this.aLw = f2 <= 1.0f ? f2 : 1.0f;
        JS();
        postInvalidate();
    }

    public void JR() {
        Q(300L);
    }

    private void Q(long j) {
        cX(2);
        if (this.aLQ != null) {
            JD();
        }
        this.aLQ = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.aLQ.setDuration(j);
        this.aLQ.setInterpolator(new LinearInterpolator());
        this.aLQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.Z(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.aLQ.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.2
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
        if (!this.aLQ.isRunning()) {
            this.aLQ.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(long j) {
        cX(3);
        if (this.aLN != null) {
            JD();
        }
        this.aLN = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.aLN.setDuration(j);
        this.aLN.setInterpolator(new LinearInterpolator());
        this.aLN.setRepeatCount(-1);
        this.aLN.setRepeatMode(1);
        this.aLN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.aa(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        if (this.aLL > 0) {
            this.aLN.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.4
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
                    if (RefreshingAnimView.this.aLM > RefreshingAnimView.this.aLL && RefreshingAnimView.this.aLF != null) {
                        RefreshingAnimView.this.aLF.bN(true);
                    }
                }
            });
        } else if (this.aLF != null) {
            this.aLF.bN(true);
        }
        if (!this.aLN.isRunning()) {
            this.aLN.start();
        }
    }

    public void setAtLeastRotateRounds(int i) {
        this.aLL = i;
    }

    public void setOnLoadingAnimationListener(a aVar) {
        this.aLF = aVar;
    }

    public void stopAnim() {
        JD();
        clearAnimation();
        this.aLw = 0.0f;
        this.aLM = 1;
        cX(1);
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
        this.aLz = z.dip2px(getContext(), 8.0f);
        this.aLB = z.dip2px(getContext(), 6.5f);
        this.aLK = z.dip2px(getContext(), 5.0f);
        this.aLC = z.dip2px(getContext(), 7.5f);
        float f = this.mWidth / 2.0f;
        this.aLD.set(f, f);
        float f2 = f + ((float) (this.aLz / aLv));
        this.aLI.set(f2, f2);
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
        Log.w("RefreshingAnimView", "onDraw->mState:" + JT() + ";AnimValue:" + this.aLw);
    }

    private void p(Canvas canvas) {
        if (this.mBitmap != null && this.aKd != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            if (this.aKb != com.baidu.swan.apps.u.a.DW().Ev()) {
                this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
                this.aKb = com.baidu.swan.apps.u.a.DW().Ev();
            }
            this.mPaint.setAlpha(76);
            this.aLG.set(this.aLD.x - this.aLz, this.aLD.y - this.aLz, this.aLD.x + this.aLz, this.aLD.y + this.aLz);
            this.aKd.drawArc(this.aLG, -90.0f, (-360.0f) * this.aLx, true, this.mPaint);
            this.aKd.drawCircle(this.aLD.x, this.aLD.y, this.aLA, this.aLE);
            if (this.aLy > 0.0f) {
                this.aKd.drawCircle(this.aLJ.x, this.aLJ.y, 0.75f, this.mPaint);
                this.mPaint.setStyle(Paint.Style.STROKE);
                this.mPaint.setStrokeWidth(z.dip2px(getContext(), 1.5f));
                this.aKd.drawLine(this.aLI.x, this.aLI.y, this.aLJ.x, this.aLJ.y, this.mPaint);
            }
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    private void JS() {
        this.aLx = this.aLw;
        if (this.aLw < 0.5f) {
            this.aLy = 0.0f;
            this.aLA = 0.0f;
            return;
        }
        this.aLA = ((this.aLw - 0.5f) / 0.5f) * this.aLB;
        if (this.aLw < 0.625f) {
            this.aLy = 0.0f;
            return;
        }
        this.aLy = (this.aLw - 0.625f) / 0.375f;
        this.aLJ.set(this.aLI.x + ((float) ((this.aLK * this.aLy) / aLv)), this.aLI.y + ((float) ((this.aLK * this.aLy) / aLv)));
    }

    private void q(Canvas canvas) {
        if (this.mBitmap != null && this.aKd != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setAlpha((int) (255.0d * ((this.aLP * 0.3d) + 0.3d)));
            float f = this.aLI.x + ((float) (this.aLK / aLv));
            this.aKd.drawCircle(this.aLD.x, this.aLD.y, this.aLz, this.mPaint);
            this.aKd.drawCircle(this.aLD.x, this.aLD.y, this.aLB, this.aLE);
            this.aKd.drawCircle(f, f, 0.75f, this.mPaint);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(z.dip2px(getContext(), 1.5f));
            this.aKd.drawLine(this.aLI.x, this.aLI.y, f, f, this.mPaint);
            this.mMatrix.reset();
            this.aKe.save();
            this.aKe.setLocation(0.0f, 0.0f, -100.0f);
            this.aKe.rotateY(this.aLP * 90.0f);
            this.aKe.getMatrix(this.mMatrix);
            this.aKe.restore();
            this.mMatrix.preTranslate(-this.aLD.x, -this.aLD.y);
            this.mMatrix.postTranslate(this.aLD.x, this.aLD.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(float f) {
        this.aLP = f;
        postInvalidate();
    }

    private void r(Canvas canvas) {
        if (this.mBitmap != null && this.aKd != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            int abs = (int) ((((1.0d - (Math.abs(this.aLO - 0.5d) * 2.0d)) * 0.3d) + 0.3d) * 255.0d);
            if (this.aKb) {
                abs = (int) ((((1.0d - (Math.abs(this.aLO - 0.5d) * 2.0d)) * 0.2d) + 0.1d) * 255.0d);
            }
            this.mPaint.setAlpha(abs);
            this.aKd.drawCircle(this.aLD.x, this.aLD.y, this.aLC, this.mPaint);
            this.mMatrix.reset();
            this.aKe.save();
            this.aKe.setLocation(0.0f, 0.0f, -100.0f);
            this.aKe.rotateY((this.aLO * 360.0f) + 90.0f);
            this.aKe.getMatrix(this.mMatrix);
            this.aKe.restore();
            this.mMatrix.preTranslate(-this.aLD.x, -this.aLD.y);
            this.mMatrix.postTranslate(this.aLD.x, this.aLD.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa(float f) {
        if (f < 0.2f) {
            this.aLO = (f / 0.2f) * 0.5f;
        } else {
            this.aLO = (((f - 0.2f) / 0.8f) * 0.5f) + 0.5f;
        }
        postInvalidate();
    }

    private void pT() {
        this.aKb = com.baidu.swan.apps.u.a.DW().Ev();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
        this.aLE = new Paint();
        this.aLE.setAntiAlias(true);
        this.aLE.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.aKe = new Camera();
        this.mMatrix = new Matrix();
        cX(1);
    }

    private void cX(int i) {
        this.mState = i;
    }

    private String JT() {
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
            this.aKd = new Canvas(this.mBitmap);
        }
    }

    private void JD() {
        if (this.aLQ != null) {
            this.aLQ.setRepeatCount(0);
            this.aLQ.removeAllUpdateListeners();
            this.aLQ.removeAllListeners();
            this.aLQ.end();
            this.aLQ.cancel();
        }
        if (this.aLN != null) {
            this.aLN.setRepeatCount(0);
            this.aLN.removeAllUpdateListeners();
            this.aLN.removeAllListeners();
            this.aLN.end();
            this.aLN.cancel();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        JD();
    }
}
