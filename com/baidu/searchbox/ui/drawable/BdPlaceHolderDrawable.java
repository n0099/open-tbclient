package com.baidu.searchbox.ui.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.baidu.android.common.ui.R;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.skin.NightModeHelper;
import com.facebook.drawee.drawable.g;
/* loaded from: classes10.dex */
public class BdPlaceHolderDrawable extends g {
    private static final boolean DEBUG = false;
    private static final String TAG = "BdPlaceHolderDrawable";
    private int mBgColor;
    private Matrix mDrawMatrix;
    private int mNightBgColor;
    private Paint mPaint;
    private int mRadius;
    private Matrix mTempMatrix;

    public BdPlaceHolderDrawable(Drawable drawable) {
        this(drawable, AppRuntime.getAppContext().getResources().getColor(R.color.bd_place_holder_solid), AppRuntime.getAppContext().getResources().getColor(R.color.bd_place_holder_solid_night), 0);
    }

    public BdPlaceHolderDrawable(Drawable drawable, int i, int i2, int i3) {
        super(drawable);
        this.mTempMatrix = new Matrix();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mBgColor = i;
        this.mNightBgColor = i2;
        this.mRadius = i3;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        drawBackground(canvas);
        drawDrawable(canvas);
    }

    protected void drawBackground(Canvas canvas) {
        Rect bounds = getBounds();
        if (this.mRadius > 0) {
            drawCircle(canvas, bounds);
        } else {
            drawRect(canvas, bounds);
        }
    }

    private void drawRect(Canvas canvas, Rect rect) {
        this.mPaint.setColor(AppRuntime.getAppContext().getResources().getColor(R.color.bd_place_holder_stroke));
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(2.0f);
        canvas.drawRect(rect, this.mPaint);
        Rect rect2 = new Rect(rect.left + 1, rect.top + 1, rect.right - 1, rect.bottom - 1);
        setPaintAttrs();
        canvas.drawRect(rect2, this.mPaint);
    }

    private void drawCircle(Canvas canvas, Rect rect) {
        setPaintAttrs();
        canvas.drawCircle(rect.width() / 2, rect.height() / 2, this.mRadius, this.mPaint);
    }

    private void setPaintAttrs() {
        if (NightModeHelper.getNightModeSwitcherState()) {
            this.mPaint.setColor(this.mNightBgColor);
        } else {
            this.mPaint.setColor(this.mBgColor);
        }
        this.mPaint.setStyle(Paint.Style.FILL);
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
