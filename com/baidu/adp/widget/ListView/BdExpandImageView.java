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
    private float yg;
    protected float yh;
    protected float yi;
    private final float yj;
    private final Rect yk;
    private final Rect yl;
    private int ym;
    private boolean yn;
    private float yo;
    private final DisplayMetrics yp;

    public BdExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.yg = 0.0f;
        this.yk = new Rect();
        this.yl = new Rect();
        setScaleType(ImageView.ScaleType.MATRIX);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.yg = obtainStyledAttributes.getDimensionPixelSize(1, 0) / 2.0f;
        this.yh = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
        this.yi = getResources().getDisplayMetrics().widthPixels;
        this.yj = this.yh + (this.yg * 2.0f);
        this.paint = new Paint();
        this.yp = getResources().getDisplayMetrics();
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        this.yn = true;
        return super.setFrame(i, i2, i3, i4);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.yn) {
            ji();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.yn) {
            ji();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        ji();
    }

    private void ji() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            int measuredHeight = getMeasuredHeight();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.yo = intrinsicHeight / 10.0f;
            this.ym = (int) (intrinsicHeight - (((((this.yj - measuredHeight) / 2.0f) * this.yo) / this.yg) * 2.0f));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Drawable drawable = getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            int scaledWidth = bitmap.getScaledWidth(this.yp);
            int scaledHeight = (bitmap.getScaledHeight(this.yp) - this.ym) / 2;
            this.yk.set(0, scaledHeight, scaledWidth, this.ym + scaledHeight);
            int width = getWidth();
            float max = Math.max(width / scaledWidth, getHeight() / this.ym);
            int i = (int) (scaledWidth * max);
            int i2 = (i - width) / 2;
            this.yl.set(-i2, 0, i - (i2 * 2), (int) (max * this.ym));
            canvas.drawBitmap(bitmap, this.yk, this.yl, this.paint);
        }
    }

    public boolean getEditable() {
        return false;
    }
}
