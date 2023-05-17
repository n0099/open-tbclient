package com.baidu.searchbox.crius.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.searchbox.crius.render.OpacityController;
import com.baidu.searchbox.crius.ui.IOpacitySupport;
import com.facebook.drawee.debug.DebugControllerOverlayDrawable;
/* loaded from: classes3.dex */
public class RoundCornerRelativeLayout extends RelativeLayout implements IOpacitySupport {
    public Paint mBitmapPaint;
    public OpacityController mOpacityController;
    public int mStrokeColor;
    public Paint mStrokePaint;
    public float mStrokeWidth;
    public float[] radii;

    public RoundCornerRelativeLayout(Context context) {
        this(context, null, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSetPressed(boolean z) {
        super.dispatchSetPressed(z);
        OpacityController opacityController = this.mOpacityController;
        if (opacityController != null) {
            opacityController.updateOpacity(this, z);
        }
    }

    public void setCornerRadius(float f) {
        if (f > 0.0f) {
            setCornerRadius(f, f, f, f);
        }
    }

    @Override // com.baidu.searchbox.crius.ui.IOpacitySupport
    public void setOpacityController(OpacityController opacityController) {
        this.mOpacityController = opacityController;
    }

    public void setStrokeColor(int i) {
        this.mStrokeColor = i;
    }

    public RoundCornerRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private Bitmap makeRoundRectFrame(int i, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Path path = new Path();
        path.addRoundRect(new RectF(0.0f, 0.0f, i, i2), this.radii, Path.Direction.CW);
        Paint paint = new Paint(1);
        paint.setColor(DebugControllerOverlayDrawable.TEXT_COLOR_IMAGE_OK);
        canvas.drawPath(path, paint);
        return createBitmap;
    }

    public void setStroke(float f, int i) {
        this.mStrokeWidth = f;
        this.mStrokeColor = i;
        postInvalidate();
    }

    public RoundCornerRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.radii = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        this.mStrokeWidth = 0.0f;
        this.mStrokeColor = Integer.MAX_VALUE;
        init();
    }

    private void drawStroke(Canvas canvas, int i, int i2) {
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
        this.mStrokePaint.setStrokeWidth(this.mStrokeWidth);
        int i3 = this.mStrokeColor;
        if (i3 != Integer.MAX_VALUE) {
            this.mStrokePaint.setColor(i3);
        }
        this.mStrokePaint.setColor(-65536);
        Path path = new Path();
        path.addRoundRect(new RectF(0.0f, 0.0f, i, i2), this.radii, Path.Direction.CW);
        canvas.drawPath(path, this.mStrokePaint);
    }

    private void init() {
        this.mBitmapPaint = new Paint(1);
        this.mStrokePaint = new Paint(1);
    }

    private boolean isDrawRoundCorner() {
        for (int i = 0; i < 8; i++) {
            if (this.radii[i] > 0.0f) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (getWidth() > 0 && getHeight() > 0) {
            int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
            super.dispatchDraw(canvas);
            if (isDrawRoundCorner()) {
                Bitmap makeRoundRectFrame = makeRoundRectFrame(getWidth(), getHeight());
                this.mBitmapPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
                canvas.drawBitmap(makeRoundRectFrame, 0.0f, 0.0f, this.mBitmapPaint);
                this.mBitmapPaint.setXfermode(null);
            }
            if (this.mStrokeWidth > 0.0f) {
                drawStroke(canvas, getWidth(), getHeight());
            }
            canvas.restoreToCount(saveLayer);
            return;
        }
        super.dispatchDraw(canvas);
    }

    public void setCornerRadius(float f, float f2, float f3, float f4) {
        if (f > 0.0f || f2 > 0.0f || f3 > 0.0f || f4 > 0.0f) {
            float[] fArr = this.radii;
            fArr[0] = f;
            fArr[1] = f;
            fArr[2] = f2;
            fArr[3] = f2;
            fArr[4] = f3;
            fArr[5] = f3;
            fArr[6] = f4;
            fArr[7] = f4;
            postInvalidate();
        }
    }
}
