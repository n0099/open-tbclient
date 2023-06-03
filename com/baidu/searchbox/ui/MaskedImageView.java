package com.baidu.searchbox.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes4.dex */
public abstract class MaskedImageView extends ImageView {
    public static final int INT_VALUE = 31;
    public static final Xfermode MASK_XFERMODE = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    public Bitmap mMask;
    public Paint mPaint;
    public boolean mShouldMasked;

    public abstract Bitmap createMask();

    private void init() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setFilterBitmap(false);
        this.mPaint.setXfermode(MASK_XFERMODE);
    }

    public final void disableMask() {
        this.mShouldMasked = false;
    }

    public void enableMask() {
        this.mShouldMasked = true;
    }

    public final boolean isEnableMask() {
        return this.mShouldMasked;
    }

    public MaskedImageView(Context context) {
        super(context);
        this.mShouldMasked = false;
        init();
    }

    public MaskedImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mShouldMasked = false;
        init();
    }

    public MaskedImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mShouldMasked = false;
        init();
    }

    @Override // android.widget.ImageView, android.view.View
    @SuppressLint({"WrongConstant"})
    public void onDraw(Canvas canvas) {
        if (!isEnableMask()) {
            super.onDraw(canvas);
            return;
        }
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        super.onDraw(canvas);
        Bitmap bitmap = this.mMask;
        if (bitmap == null || bitmap.isRecycled()) {
            this.mMask = createMask();
        }
        Bitmap bitmap2 = this.mMask;
        if (bitmap2 != null) {
            canvas.drawBitmap(bitmap2, 0.0f, 0.0f, this.mPaint);
        }
        canvas.restoreToCount(saveLayer);
    }
}
