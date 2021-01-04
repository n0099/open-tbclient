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
/* loaded from: classes9.dex */
public class LoadingAnimView extends View {
    private float dAQ;
    private Camera dAR;
    private ValueAnimator dzn;
    private Bitmap mBitmap;
    private Canvas mCanvas;
    private Matrix mMatrix;
    private Paint mPaint;

    public LoadingAnimView(Context context) {
        super(context);
        this.dAQ = 0.0f;
        init();
    }

    public LoadingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dAQ = 0.0f;
        init();
    }

    public LoadingAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dAQ = 0.0f;
        init();
    }

    public void init() {
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.dAR = new Camera();
        this.mMatrix = new Matrix();
        startAnim();
    }

    public void startAnim() {
        if (this.dzn != null) {
            aKI();
        }
        this.dzn = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.dzn.setDuration(750L);
        this.dzn.setRepeatCount(20);
        this.dzn.setRepeatMode(1);
        this.dzn.setInterpolator(new LinearInterpolator());
        this.dzn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.LoadingAnimView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 0.4f) {
                    LoadingAnimView.this.dAQ = (floatValue / 0.4f) * 0.25f;
                } else if (floatValue < 0.6f) {
                    LoadingAnimView.this.dAQ = (((floatValue - 0.4f) / 0.2f) * 0.5f) + 0.25f;
                } else {
                    LoadingAnimView.this.dAQ = (((floatValue - 0.6f) / 0.4f) * 0.25f) + 0.75f;
                }
                LoadingAnimView.this.postInvalidate();
            }
        });
        if (!this.dzn.isRunning()) {
            this.dzn.start();
        }
    }

    public void stopAnim() {
        aKI();
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
            this.mPaint.setAlpha((int) (255.0d * (((1.0d - (2.0d * Math.abs(this.dAQ - 0.5d))) * 0.3d) + 0.3d)));
            this.mCanvas.drawCircle(measuredWidth / 2.0f, measuredHeight / 2.0f, dip2px, this.mPaint);
            this.mMatrix.reset();
            this.dAR.save();
            this.dAR.setLocation(0.0f, 0.0f, -100.0f);
            this.dAR.rotateY(this.dAQ * 360.0f);
            this.dAR.getMatrix(this.mMatrix);
            this.dAR.restore();
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

    private void aKI() {
        if (this.dzn != null) {
            this.dzn.setRepeatCount(0);
            this.dzn.removeAllUpdateListeners();
            this.dzn.removeAllListeners();
            this.dzn.end();
            this.dzn.cancel();
        }
    }
}
