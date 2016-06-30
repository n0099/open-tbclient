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
    private final Paint paint;
    private float yi;
    protected float yj;
    protected float yk;
    private final float yl;
    private final Rect ym;
    private final Rect yn;
    private int yo;
    private boolean yp;
    private float yq;
    private final DisplayMetrics yr;

    public BdExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.yi = 0.0f;
        this.ym = new Rect();
        this.yn = new Rect();
        setScaleType(ImageView.ScaleType.MATRIX);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.yi = obtainStyledAttributes.getDimensionPixelSize(1, 0) / 2.0f;
        this.yj = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
        this.yk = getResources().getDisplayMetrics().widthPixels;
        this.yl = this.yj + (this.yi * 2.0f);
        this.paint = new Paint();
        this.yr = getResources().getDisplayMetrics();
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        this.yp = true;
        return super.setFrame(i, i2, i3, i4);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.yp) {
            jl();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.yp) {
            jl();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        jl();
    }

    private void jl() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            int measuredHeight = getMeasuredHeight();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.yq = intrinsicHeight / 10.0f;
            this.yo = (int) (intrinsicHeight - (((((this.yl - measuredHeight) / 2.0f) * this.yq) / this.yi) * 2.0f));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Drawable drawable = getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            int scaledWidth = bitmap.getScaledWidth(this.yr);
            int scaledHeight = (bitmap.getScaledHeight(this.yr) - this.yo) / 2;
            this.ym.set(0, scaledHeight, scaledWidth, this.yo + scaledHeight);
            int width = getWidth();
            float max = Math.max(width / scaledWidth, getHeight() / this.yo);
            int i = (int) (scaledWidth * max);
            int i2 = (i - width) / 2;
            this.yn.set(-i2, 0, i - (i2 * 2), (int) (max * this.yo));
            canvas.drawBitmap(bitmap, this.ym, this.yn, this.paint);
        }
    }

    public boolean getEditable() {
        return false;
    }
}
