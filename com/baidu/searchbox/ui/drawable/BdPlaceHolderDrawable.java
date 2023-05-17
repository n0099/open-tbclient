package com.baidu.searchbox.ui.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.tieba.R;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.drawee.drawable.ForwardingDrawable;
/* loaded from: classes4.dex */
public class BdPlaceHolderDrawable extends ForwardingDrawable {
    public static final boolean DEBUG = false;
    public static final String TAG = "BdPlaceHolderDrawable";
    public int mBgColor;
    public Matrix mDrawMatrix;
    public int mNightBgColor;
    public Paint mPaint;
    public int mRadius;
    public Matrix mTempMatrix;

    public BdPlaceHolderDrawable(Drawable drawable) {
        this(drawable, AppRuntime.getAppContext().getResources().getColor(R.color.obfuscated_res_0x7f060483), AppRuntime.getAppContext().getResources().getColor(R.color.obfuscated_res_0x7f060484), 0);
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        drawBackground(canvas);
        drawDrawable(canvas);
    }

    public void drawBackground(Canvas canvas) {
        Rect bounds = getBounds();
        if (this.mRadius > 0) {
            drawCircle(canvas, bounds);
        } else {
            drawRect(canvas, bounds);
        }
    }

    public void drawDrawable(Canvas canvas) {
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

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        configureBounds();
    }

    public BdPlaceHolderDrawable(Drawable drawable, int i, int i2, int i3) {
        super(drawable);
        this.mTempMatrix = new Matrix();
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mBgColor = i;
        this.mNightBgColor = i2;
        this.mRadius = i3;
    }

    private void drawCircle(Canvas canvas, Rect rect) {
        setPaintAttrs();
        canvas.drawCircle(rect.width() / 2, rect.height() / 2, this.mRadius, this.mPaint);
    }

    private void drawRect(Canvas canvas, Rect rect) {
        this.mPaint.setColor(AppRuntime.getAppContext().getResources().getColor(R.color.obfuscated_res_0x7f060485));
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(2.0f);
        canvas.drawRect(rect, this.mPaint);
        Rect rect2 = new Rect(rect.left + 1, rect.top + 1, rect.right - 1, rect.bottom - 1);
        setPaintAttrs();
        canvas.drawRect(rect2, this.mPaint);
    }

    private void setPaintAttrs() {
        if (NightModeHelper.getNightModeSwitcherState()) {
            this.mPaint.setColor(this.mNightBgColor);
        } else {
            this.mPaint.setColor(this.mBgColor);
        }
        this.mPaint.setStyle(Paint.Style.FILL);
    }

    @VisibleForTesting
    public void configureBounds() {
        Drawable current = getCurrent();
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        int intrinsicWidth = current.getIntrinsicWidth();
        int intrinsicHeight = current.getIntrinsicHeight();
        if (intrinsicWidth > 0 && intrinsicHeight > 0) {
            if (intrinsicWidth == width && intrinsicHeight == height) {
                current.setBounds(bounds);
                this.mDrawMatrix = null;
                return;
            }
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            getTransform(this.mTempMatrix, bounds, intrinsicWidth, intrinsicHeight, bounds.width() / intrinsicWidth, bounds.height() / intrinsicHeight);
            this.mDrawMatrix = this.mTempMatrix;
            return;
        }
        current.setBounds(bounds);
        this.mDrawMatrix = null;
    }

    public void getTransform(Matrix matrix, Rect rect, int i, int i2, float f, float f2) {
        float min = Math.min(Math.min(f, f2), 1.0f);
        float width = rect.left + ((rect.width() - (i * min)) * 0.5f);
        float height = rect.top + ((rect.height() - (i2 * min)) * 0.5f);
        matrix.setScale(min, min);
        matrix.postTranslate((int) (width + 0.5f), (int) (height + 0.5f));
    }
}
