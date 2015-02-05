package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class BdExpandImageView extends ImageView {
    private final boolean mEnabled;
    private final Paint paint;
    private float vV;
    protected float vW;
    protected float vX;
    private final float vY;
    private final Rect vZ;
    private final Rect wa;
    private int wb;
    private boolean wc;
    private float wd;
    private final DisplayMetrics we;

    public BdExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.vV = 0.0f;
        this.mEnabled = false;
        this.vZ = new Rect();
        this.wa = new Rect();
        setScaleType(ImageView.ScaleType.MATRIX);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.vV = obtainStyledAttributes.getDimensionPixelSize(1, 0) / 2;
        this.vW = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
        this.vX = getResources().getDisplayMetrics().widthPixels;
        this.vY = this.vW + (2.0f * this.vV);
        this.paint = new Paint();
        this.we = getResources().getDisplayMetrics();
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        this.wc = true;
        return super.setFrame(i, i2, i3, i4);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.wc) {
            jm();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.wc) {
            jm();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        jm();
    }

    private void jm() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            int measuredHeight = getMeasuredHeight();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.wd = intrinsicHeight / 10;
            this.wb = (int) (intrinsicHeight - (((((this.vY - measuredHeight) / 2.0f) * this.wd) / this.vV) * 2.0f));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Drawable drawable = getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            int scaledWidth = bitmap.getScaledWidth(this.we);
            int scaledHeight = (bitmap.getScaledHeight(this.we) - this.wb) / 2;
            this.vZ.set(0, scaledHeight, scaledWidth, this.wb + scaledHeight);
            int width = getWidth();
            float max = Math.max(width / scaledWidth, getHeight() / this.wb);
            int i = (int) (scaledWidth * max);
            int i2 = (i - width) / 2;
            this.wa.set(-i2, 0, i - (i2 * 2), (int) (max * this.wb));
            canvas.drawBitmap(bitmap, this.vZ, this.wa, this.paint);
        }
    }

    public boolean getEditable() {
        return false;
    }
}
