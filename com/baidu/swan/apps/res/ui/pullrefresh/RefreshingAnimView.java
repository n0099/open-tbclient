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
/* loaded from: classes10.dex */
public class RefreshingAnimView extends View {
    private static final double dce = Math.sqrt(2.0d);
    private boolean daQ;
    private ValueAnimator dcA;
    float dcf;
    float dcg;
    float dch;
    float dci;
    float dcj;
    float dck;
    float dcl;
    private PointF dcm;
    private Paint dcn;
    private a dco;
    private RectF dcp;
    private PointF dcq;
    private PointF dcr;
    private PointF dcs;
    private float dct;
    private int dcv;
    private int dcw;
    private ValueAnimator dcx;
    private float dcy;
    private float dcz;
    private Bitmap mBitmap;
    private Camera mCamera;
    private Canvas mCanvas;
    private Matrix mMatrix;
    private Paint mPaint;
    private int mState;
    private float mWidth;

    /* loaded from: classes10.dex */
    public interface a {
        void fP(boolean z);
    }

    static /* synthetic */ int a(RefreshingAnimView refreshingAnimView) {
        int i = refreshingAnimView.dcw;
        refreshingAnimView.dcw = i + 1;
        return i;
    }

    public RefreshingAnimView(Context context) {
        super(context);
        this.dcf = 0.0f;
        this.dcg = 0.0f;
        this.dch = 0.0f;
        this.dci = 0.0f;
        this.dcj = 0.0f;
        this.dck = 0.0f;
        this.dcl = 0.0f;
        this.mWidth = 0.0f;
        this.dcm = new PointF();
        this.dcp = new RectF();
        this.dcq = new PointF();
        this.dcr = new PointF();
        this.dcs = new PointF();
        this.dct = 0.0f;
        this.dcv = 0;
        this.dcw = 1;
        this.dcx = null;
        this.dcy = 0.0f;
        this.dcz = 0.0f;
        this.dcA = null;
        this.daQ = false;
        this.mState = 0;
        sw();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dcf = 0.0f;
        this.dcg = 0.0f;
        this.dch = 0.0f;
        this.dci = 0.0f;
        this.dcj = 0.0f;
        this.dck = 0.0f;
        this.dcl = 0.0f;
        this.mWidth = 0.0f;
        this.dcm = new PointF();
        this.dcp = new RectF();
        this.dcq = new PointF();
        this.dcr = new PointF();
        this.dcs = new PointF();
        this.dct = 0.0f;
        this.dcv = 0;
        this.dcw = 1;
        this.dcx = null;
        this.dcy = 0.0f;
        this.dcz = 0.0f;
        this.dcA = null;
        this.daQ = false;
        this.mState = 0;
        sw();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dcf = 0.0f;
        this.dcg = 0.0f;
        this.dch = 0.0f;
        this.dci = 0.0f;
        this.dcj = 0.0f;
        this.dck = 0.0f;
        this.dcl = 0.0f;
        this.mWidth = 0.0f;
        this.dcm = new PointF();
        this.dcp = new RectF();
        this.dcq = new PointF();
        this.dcr = new PointF();
        this.dcs = new PointF();
        this.dct = 0.0f;
        this.dcv = 0;
        this.dcw = 1;
        this.dcx = null;
        this.dcy = 0.0f;
        this.dcz = 0.0f;
        this.dcA = null;
        this.daQ = false;
        this.mState = 0;
        sw();
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        this.dcf = f2 <= 1.0f ? f2 : 1.0f;
        aCt();
        postInvalidate();
    }

    public void aCs() {
        bO(300L);
    }

    private void bO(long j) {
        ju(2);
        if (this.dcA != null) {
            aCe();
        }
        this.dcA = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.dcA.setDuration(j);
        this.dcA.setInterpolator(new LinearInterpolator());
        this.dcA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.H(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.dcA.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                RefreshingAnimView.this.bP(750L);
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
        if (!this.dcA.isRunning()) {
            this.dcA.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bP(long j) {
        ju(3);
        if (this.dcx != null) {
            aCe();
        }
        this.dcx = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.dcx.setDuration(j);
        this.dcx.setInterpolator(new LinearInterpolator());
        this.dcx.setRepeatCount(-1);
        this.dcx.setRepeatMode(1);
        this.dcx.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.I(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        if (this.dcv > 0) {
            this.dcx.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.RefreshingAnimView.4
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
                    if (RefreshingAnimView.this.dcw > RefreshingAnimView.this.dcv && RefreshingAnimView.this.dco != null) {
                        RefreshingAnimView.this.dco.fP(true);
                    }
                }
            });
        } else if (this.dco != null) {
            this.dco.fP(true);
        }
        if (!this.dcx.isRunning()) {
            this.dcx.start();
        }
    }

    public void setAtLeastRotateRounds(int i) {
        this.dcv = i;
    }

    public void setOnLoadingAnimationListener(a aVar) {
        this.dco = aVar;
    }

    public void stopAnim() {
        aCe();
        clearAnimation();
        this.dcf = 0.0f;
        this.dcw = 1;
        ju(1);
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
        this.dci = ah.dip2px(getContext(), 8.0f);
        this.dck = ah.dip2px(getContext(), 6.5f);
        this.dct = ah.dip2px(getContext(), 5.0f);
        this.dcl = ah.dip2px(getContext(), 7.5f);
        float f = this.mWidth / 2.0f;
        this.dcm.set(f, f);
        float f2 = f + ((float) (this.dci / dce));
        this.dcr.set(f2, f2);
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
            if (this.daQ != com.baidu.swan.apps.t.a.asC().getNightModeSwitcherState()) {
                this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
                this.daQ = com.baidu.swan.apps.t.a.asC().getNightModeSwitcherState();
            }
            this.mPaint.setAlpha(76);
            this.dcp.set(this.dcm.x - this.dci, this.dcm.y - this.dci, this.dcm.x + this.dci, this.dcm.y + this.dci);
            this.mCanvas.drawArc(this.dcp, -90.0f, (-360.0f) * this.dcg, true, this.mPaint);
            this.mCanvas.drawCircle(this.dcm.x, this.dcm.y, this.dcj, this.dcn);
            if (this.dch > 0.0f) {
                this.mCanvas.drawCircle(this.dcs.x, this.dcs.y, 0.75f, this.mPaint);
                this.mPaint.setStyle(Paint.Style.STROKE);
                this.mPaint.setStrokeWidth(ah.dip2px(getContext(), 1.5f));
                this.mCanvas.drawLine(this.dcr.x, this.dcr.y, this.dcs.x, this.dcs.y, this.mPaint);
            }
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    private void aCt() {
        this.dcg = this.dcf;
        if (this.dcf < 0.5f) {
            this.dch = 0.0f;
            this.dcj = 0.0f;
            return;
        }
        this.dcj = ((this.dcf - 0.5f) / 0.5f) * this.dck;
        if (this.dcf < 0.625f) {
            this.dch = 0.0f;
            return;
        }
        this.dch = (this.dcf - 0.625f) / 0.375f;
        this.dcs.set(this.dcr.x + ((float) ((this.dct * this.dch) / dce)), this.dcr.y + ((float) ((this.dct * this.dch) / dce)));
    }

    private void u(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setAlpha((int) (255.0d * ((this.dcz * 0.3d) + 0.3d)));
            float f = this.dcr.x + ((float) (this.dct / dce));
            this.mCanvas.drawCircle(this.dcm.x, this.dcm.y, this.dci, this.mPaint);
            this.mCanvas.drawCircle(this.dcm.x, this.dcm.y, this.dck, this.dcn);
            this.mCanvas.drawCircle(f, f, 0.75f, this.mPaint);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(ah.dip2px(getContext(), 1.5f));
            this.mCanvas.drawLine(this.dcr.x, this.dcr.y, f, f, this.mPaint);
            this.mMatrix.reset();
            this.mCamera.save();
            this.mCamera.setLocation(0.0f, 0.0f, -100.0f);
            this.mCamera.rotateY(this.dcz * 90.0f);
            this.mCamera.getMatrix(this.mMatrix);
            this.mCamera.restore();
            this.mMatrix.preTranslate(-this.dcm.x, -this.dcm.y);
            this.mMatrix.postTranslate(this.dcm.x, this.dcm.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(float f) {
        this.dcz = f;
        postInvalidate();
    }

    private void v(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            int abs = (int) ((((1.0d - (Math.abs(this.dcy - 0.5d) * 2.0d)) * 0.3d) + 0.3d) * 255.0d);
            if (this.daQ) {
                abs = (int) ((((1.0d - (Math.abs(this.dcy - 0.5d) * 2.0d)) * 0.2d) + 0.1d) * 255.0d);
            }
            this.mPaint.setAlpha(abs);
            this.mCanvas.drawCircle(this.dcm.x, this.dcm.y, this.dcl, this.mPaint);
            this.mMatrix.reset();
            this.mCamera.save();
            this.mCamera.setLocation(0.0f, 0.0f, -100.0f);
            this.mCamera.rotateY((this.dcy * 360.0f) + 90.0f);
            this.mCamera.getMatrix(this.mMatrix);
            this.mCamera.restore();
            this.mMatrix.preTranslate(-this.dcm.x, -this.dcm.y);
            this.mMatrix.postTranslate(this.dcm.x, this.dcm.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(float f) {
        if (f < 0.2f) {
            this.dcy = (f / 0.2f) * 0.5f;
        } else {
            this.dcy = (((f - 0.2f) / 0.8f) * 0.5f) + 0.5f;
        }
        postInvalidate();
    }

    private void sw() {
        this.daQ = com.baidu.swan.apps.t.a.asC().getNightModeSwitcherState();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_loading_refresh_anim_color));
        this.dcn = new Paint();
        this.dcn.setAntiAlias(true);
        this.dcn.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.mCamera = new Camera();
        this.mMatrix = new Matrix();
        ju(1);
    }

    private void ju(int i) {
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

    private void aCe() {
        if (this.dcA != null) {
            this.dcA.setRepeatCount(0);
            this.dcA.removeAllUpdateListeners();
            this.dcA.removeAllListeners();
            this.dcA.end();
            this.dcA.cancel();
        }
        if (this.dcx != null) {
            this.dcx.setRepeatCount(0);
            this.dcx.removeAllUpdateListeners();
            this.dcx.removeAllListeners();
            this.dcx.end();
            this.dcx.cancel();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aCe();
    }
}
