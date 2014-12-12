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
    private float vS;
    protected float vT;
    protected float vU;
    private final float vV;
    private final Rect vW;
    private final Rect vX;
    private int vY;
    private boolean vZ;
    private float wa;
    private final DisplayMetrics wb;

    public BdExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.vS = 0.0f;
        this.mEnabled = false;
        this.vW = new Rect();
        this.vX = new Rect();
        setScaleType(ImageView.ScaleType.MATRIX);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.vS = obtainStyledAttributes.getDimensionPixelSize(1, 0) / 2;
        this.vT = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
        this.vU = getResources().getDisplayMetrics().widthPixels;
        this.vV = this.vT + (2.0f * this.vS);
        this.paint = new Paint();
        this.wb = getResources().getDisplayMetrics();
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        this.vZ = true;
        return super.setFrame(i, i2, i3, i4);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.vZ) {
            js();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.vZ) {
            js();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        js();
    }

    private void js() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            int measuredHeight = getMeasuredHeight();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.wa = intrinsicHeight / 10;
            this.vY = (int) (intrinsicHeight - (((((this.vV - measuredHeight) / 2.0f) * this.wa) / this.vS) * 2.0f));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Drawable drawable = getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            int scaledWidth = bitmap.getScaledWidth(this.wb);
            int scaledHeight = (bitmap.getScaledHeight(this.wb) - this.vY) / 2;
            this.vW.set(0, scaledHeight, scaledWidth, this.vY + scaledHeight);
            int width = getWidth();
            float max = Math.max(width / scaledWidth, getHeight() / this.vY);
            int i = (int) (scaledWidth * max);
            int i2 = (i - width) / 2;
            this.vX.set(-i2, 0, i - (i2 * 2), (int) (max * this.vY));
            canvas.drawBitmap(bitmap, this.vW, this.vX, this.paint);
        }
    }

    public boolean getEditable() {
        return false;
    }
}
