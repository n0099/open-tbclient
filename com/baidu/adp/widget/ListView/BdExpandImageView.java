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
    private float HU;
    protected float HV;
    protected float HW;
    private final float HX;
    private final Rect HY;
    private final Rect HZ;
    private int Ia;
    private boolean Ib;
    private float Ic;
    private final DisplayMetrics Id;
    private final Paint paint;

    public BdExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.HU = 0.0f;
        this.HY = new Rect();
        this.HZ = new Rect();
        setScaleType(ImageView.ScaleType.MATRIX);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.HU = obtainStyledAttributes.getDimensionPixelSize(1, 0) / 2.0f;
        this.HV = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
        this.HW = getResources().getDisplayMetrics().widthPixels;
        this.HX = this.HV + (this.HU * 2.0f);
        this.paint = new Paint();
        this.Id = getResources().getDisplayMetrics();
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        this.Ib = true;
        return super.setFrame(i, i2, i3, i4);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.Ib) {
            kV();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.Ib) {
            kV();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        kV();
    }

    private void kV() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            int measuredHeight = getMeasuredHeight();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.Ic = intrinsicHeight / 10.0f;
            this.Ia = (int) (intrinsicHeight - (((((this.HX - measuredHeight) / 2.0f) * this.Ic) / this.HU) * 2.0f));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Drawable drawable = getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            int scaledWidth = bitmap.getScaledWidth(this.Id);
            int scaledHeight = (bitmap.getScaledHeight(this.Id) - this.Ia) / 2;
            this.HY.set(0, scaledHeight, scaledWidth, this.Ia + scaledHeight);
            int width = getWidth();
            float max = Math.max(width / scaledWidth, getHeight() / this.Ia);
            int i = (int) (scaledWidth * max);
            int i2 = (i - width) / 2;
            this.HZ.set(-i2, 0, i - (i2 * 2), (int) (max * this.Ia));
            canvas.drawBitmap(bitmap, this.HY, this.HZ, this.paint);
        }
    }

    public boolean getEditable() {
        return false;
    }
}
