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
    private float AY;
    protected float AZ;
    protected float Ba;
    private final float Bb;
    private final Rect Bc;
    private final Rect Bd;
    private int Be;
    private boolean Bf;
    private float Bg;
    private final DisplayMetrics Bh;
    private final Paint paint;

    public BdExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.AY = 0.0f;
        this.Bc = new Rect();
        this.Bd = new Rect();
        setScaleType(ImageView.ScaleType.MATRIX);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.AY = obtainStyledAttributes.getDimensionPixelSize(1, 0) / 2.0f;
        this.AZ = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
        this.Ba = getResources().getDisplayMetrics().widthPixels;
        this.Bb = this.AZ + (this.AY * 2.0f);
        this.paint = new Paint();
        this.Bh = getResources().getDisplayMetrics();
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        this.Bf = true;
        return super.setFrame(i, i2, i3, i4);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.Bf) {
            kf();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.Bf) {
            kf();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        kf();
    }

    private void kf() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            int measuredHeight = getMeasuredHeight();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.Bg = intrinsicHeight / 10.0f;
            this.Be = (int) (intrinsicHeight - (((((this.Bb - measuredHeight) / 2.0f) * this.Bg) / this.AY) * 2.0f));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Drawable drawable = getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            int scaledWidth = bitmap.getScaledWidth(this.Bh);
            int scaledHeight = (bitmap.getScaledHeight(this.Bh) - this.Be) / 2;
            this.Bc.set(0, scaledHeight, scaledWidth, this.Be + scaledHeight);
            int width = getWidth();
            float max = Math.max(width / scaledWidth, getHeight() / this.Be);
            int i = (int) (scaledWidth * max);
            int i2 = (i - width) / 2;
            this.Bd.set(-i2, 0, i - (i2 * 2), (int) (max * this.Be));
            canvas.drawBitmap(bitmap, this.Bc, this.Bd, this.paint);
        }
    }

    public boolean getEditable() {
        return false;
    }
}
