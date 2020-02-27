package com.baidu.searchbox.ui.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.baidu.android.common.ui.R;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.facebook.drawee.drawable.g;
/* loaded from: classes13.dex */
public class BdPlaceHolderDrawable extends g {
    private static final boolean DEBUG = false;
    private static final String TAG = "BdPlaceHolderDrawable";
    private Matrix mDrawMatrix;
    private Paint mPaint;
    private Matrix mTempMatrix;

    public BdPlaceHolderDrawable(Drawable drawable) {
        super(drawable);
        this.mTempMatrix = new Matrix();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        drawBackground(canvas);
        drawDrawable(canvas);
    }

    protected void drawBackground(Canvas canvas) {
        Rect bounds = getBounds();
        this.mPaint.setColor(AppRuntime.getAppContext().getResources().getColor(R.color.bd_place_holder_stroke));
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(2.0f);
        canvas.drawRect(bounds, this.mPaint);
        Rect rect = new Rect(bounds.left + 1, bounds.top + 1, bounds.right - 1, bounds.bottom - 1);
        this.mPaint.setColor(AppRuntime.getAppContext().getResources().getColor(R.color.bd_place_holder_solid));
        this.mPaint.setStyle(Paint.Style.FILL);
        canvas.drawRect(rect, this.mPaint);
    }

    protected void drawDrawable(Canvas canvas) {
        if (this.mDrawMatrix != null) {
            int save = canvas.save();
            canvas.clipRect(getBounds());
            canvas.concat(this.mDrawMatrix);
            super.draw(canvas);
            canvas.restoreToCount(save);
            return;
        }
        super.draw(canvas);
    }

    void configureBounds() {
        Drawable current = getCurrent();
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        int intrinsicWidth = current.getIntrinsicWidth();
        int intrinsicHeight = current.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (intrinsicWidth == width && intrinsicHeight == height) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else {
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            getTransform(this.mTempMatrix, bounds, intrinsicWidth, intrinsicHeight, bounds.width() / intrinsicWidth, bounds.height() / intrinsicHeight);
            this.mDrawMatrix = this.mTempMatrix;
        }
    }

    public void getTransform(Matrix matrix, Rect rect, int i, int i2, float f, float f2) {
        float min = Math.min(Math.min(f, f2), 1.0f);
        float width = rect.left + ((rect.width() - (i * min)) * 0.5f);
        matrix.setScale(min, min);
        matrix.postTranslate((int) (width + 0.5f), (int) (rect.top + ((rect.height() - (i2 * min)) * 0.5f) + 0.5f));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        configureBounds();
    }
}
