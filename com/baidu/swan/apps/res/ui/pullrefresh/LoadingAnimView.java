package com.baidu.swan.apps.res.ui.pullrefresh;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ah;
/* loaded from: classes8.dex */
public class LoadingAnimView extends View {
    private ValueAnimator dyk;
    private float dzM;
    private Camera dzN;
    private Bitmap mBitmap;
    private Canvas mCanvas;
    private Matrix mMatrix;
    private Paint mPaint;

    public LoadingAnimView(Context context) {
        super(context);
        this.dzM = 0.0f;
        init();
    }

    public LoadingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dzM = 0.0f;
        init();
    }

    public LoadingAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dzM = 0.0f;
        init();
    }

    public void init() {
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.dzN = new Camera();
        this.mMatrix = new Matrix();
        startAnim();
    }

    public void startAnim() {
        if (this.dyk != null) {
            aHl();
        }
        this.dyk = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.dyk.setDuration(750L);
        this.dyk.setRepeatCount(20);
        this.dyk.setRepeatMode(1);
        this.dyk.setInterpolator(new LinearInterpolator());
        this.dyk.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.LoadingAnimView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 0.4f) {
                    LoadingAnimView.this.dzM = (floatValue / 0.4f) * 0.25f;
                } else if (floatValue < 0.6f) {
                    LoadingAnimView.this.dzM = (((floatValue - 0.4f) / 0.2f) * 0.5f) + 0.25f;
                } else {
                    LoadingAnimView.this.dzM = (((floatValue - 0.6f) / 0.4f) * 0.25f) + 0.75f;
                }
                LoadingAnimView.this.postInvalidate();
            }
        });
        if (!this.dyk.isRunning()) {
            this.dyk.start();
        }
    }

    public void stopAnim() {
        aHl();
        clearAnimation();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mBitmap != null && this.mCanvas != null) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            int dip2px = ah.dip2px(getContext(), 6.0f);
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(getResources().getColor(a.c.aiapps_pull_load_footer_image_color));
            this.mPaint.setAlpha((int) (255.0d * (((1.0d - (2.0d * Math.abs(this.dzM - 0.5d))) * 0.3d) + 0.3d)));
            this.mCanvas.drawCircle(measuredWidth / 2.0f, measuredHeight / 2.0f, dip2px, this.mPaint);
            this.mMatrix.reset();
            this.dzN.save();
            this.dzN.setLocation(0.0f, 0.0f, -100.0f);
            this.dzN.rotateY(this.dzM * 360.0f);
            this.dzN.getMatrix(this.mMatrix);
            this.dzN.restore();
            this.mMatrix.preTranslate((-measuredWidth) / 2.0f, (-measuredHeight) / 2.0f);
            this.mMatrix.postTranslate(measuredWidth / 2.0f, measuredHeight / 2.0f);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        this.mCanvas = new Canvas(this.mBitmap);
    }

    private void aHl() {
        if (this.dyk != null) {
            this.dyk.setRepeatCount(0);
            this.dyk.removeAllUpdateListeners();
            this.dyk.removeAllListeners();
            this.dyk.end();
            this.dyk.cancel();
        }
    }
}
