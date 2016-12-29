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
    private float AW;
    protected float AX;
    protected float AY;
    private final float AZ;
    private final Rect Ba;
    private final Rect Bb;
    private int Bc;
    private boolean Bd;
    private float Be;
    private final DisplayMetrics Bf;
    private final Paint paint;

    public BdExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.AW = 0.0f;
        this.Ba = new Rect();
        this.Bb = new Rect();
        setScaleType(ImageView.ScaleType.MATRIX);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.AW = obtainStyledAttributes.getDimensionPixelSize(1, 0) / 2.0f;
        this.AX = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
        this.AY = getResources().getDisplayMetrics().widthPixels;
        this.AZ = this.AX + (this.AW * 2.0f);
        this.paint = new Paint();
        this.Bf = getResources().getDisplayMetrics();
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        this.Bd = true;
        return super.setFrame(i, i2, i3, i4);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.Bd) {
            kf();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.Bd) {
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
            this.Be = intrinsicHeight / 10.0f;
            this.Bc = (int) (intrinsicHeight - (((((this.AZ - measuredHeight) / 2.0f) * this.Be) / this.AW) * 2.0f));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Drawable drawable = getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            int scaledWidth = bitmap.getScaledWidth(this.Bf);
            int scaledHeight = (bitmap.getScaledHeight(this.Bf) - this.Bc) / 2;
            this.Ba.set(0, scaledHeight, scaledWidth, this.Bc + scaledHeight);
            int width = getWidth();
            float max = Math.max(width / scaledWidth, getHeight() / this.Bc);
            int i = (int) (scaledWidth * max);
            int i2 = (i - width) / 2;
            this.Bb.set(-i2, 0, i - (i2 * 2), (int) (max * this.Bc));
            canvas.drawBitmap(bitmap, this.Ba, this.Bb, this.paint);
        }
    }

    public boolean getEditable() {
        return false;
    }
}
