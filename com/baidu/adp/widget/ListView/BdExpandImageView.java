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
    private float GW;
    protected float GX;
    protected float GY;
    private final float GZ;
    private final Rect Ha;
    private final Rect Hb;
    private int Hc;
    private boolean Hd;
    private float He;
    private final DisplayMetrics Hf;
    private final boolean mEnabled;
    private final Paint paint;

    public BdExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.GW = 0.0f;
        this.mEnabled = false;
        this.Ha = new Rect();
        this.Hb = new Rect();
        setScaleType(ImageView.ScaleType.MATRIX);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.GW = obtainStyledAttributes.getDimensionPixelSize(1, 0) / 2;
        this.GX = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
        this.GY = getResources().getDisplayMetrics().widthPixels;
        this.GZ = this.GX + (2.0f * this.GW);
        this.paint = new Paint();
        this.Hf = getResources().getDisplayMetrics();
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        this.Hd = true;
        return super.setFrame(i, i2, i3, i4);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.Hd) {
            mI();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.Hd) {
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
            this.He = intrinsicHeight / 10;
            this.Hc = (int) (intrinsicHeight - (((((this.GZ - measuredHeight) / 2.0f) * this.He) / this.GW) * 2.0f));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Drawable drawable = getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            int scaledWidth = bitmap.getScaledWidth(this.Hf);
            int scaledHeight = (bitmap.getScaledHeight(this.Hf) - this.Hc) / 2;
            this.Ha.set(0, scaledHeight, scaledWidth, this.Hc + scaledHeight);
            int width = getWidth();
            float max = Math.max(width / scaledWidth, getHeight() / this.Hc);
            int i = (int) (scaledWidth * max);
            int i2 = (i - width) / 2;
            this.Hb.set(-i2, 0, i - (i2 * 2), (int) (max * this.Hc));
            canvas.drawBitmap(bitmap, this.Ha, this.Hb, this.paint);
        }
    }

    public boolean getEditable() {
        return false;
    }
}
