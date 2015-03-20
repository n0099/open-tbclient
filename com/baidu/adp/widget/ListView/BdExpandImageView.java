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
    private float GU;
    protected float GV;
    protected float GW;
    private final float GX;
    private final Rect GY;
    private final Rect GZ;
    private int Ha;
    private boolean Hb;
    private float Hc;
    private final DisplayMetrics Hd;
    private final boolean mEnabled;
    private final Paint paint;

    public BdExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.GU = 0.0f;
        this.mEnabled = false;
        this.GY = new Rect();
        this.GZ = new Rect();
        setScaleType(ImageView.ScaleType.MATRIX);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.GU = obtainStyledAttributes.getDimensionPixelSize(1, 0) / 2;
        this.GV = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
        this.GW = getResources().getDisplayMetrics().widthPixels;
        this.GX = this.GV + (2.0f * this.GU);
        this.paint = new Paint();
        this.Hd = getResources().getDisplayMetrics();
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        this.Hb = true;
        return super.setFrame(i, i2, i3, i4);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.Hb) {
            mI();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.Hb) {
            mI();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        mI();
    }

    private void mI() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            int measuredHeight = getMeasuredHeight();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.Hc = intrinsicHeight / 10;
            this.Ha = (int) (intrinsicHeight - (((((this.GX - measuredHeight) / 2.0f) * this.Hc) / this.GU) * 2.0f));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Drawable drawable = getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            int scaledWidth = bitmap.getScaledWidth(this.Hd);
            int scaledHeight = (bitmap.getScaledHeight(this.Hd) - this.Ha) / 2;
            this.GY.set(0, scaledHeight, scaledWidth, this.Ha + scaledHeight);
            int width = getWidth();
            float max = Math.max(width / scaledWidth, getHeight() / this.Ha);
            int i = (int) (scaledWidth * max);
            int i2 = (i - width) / 2;
            this.GZ.set(-i2, 0, i - (i2 * 2), (int) (max * this.Ha));
            canvas.drawBitmap(bitmap, this.GY, this.GZ, this.paint);
        }
    }

    public boolean getEditable() {
        return false;
    }
}
