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
    private final Rect HA;
    private int HB;
    private boolean HC;
    private float HD;
    private final DisplayMetrics HE;
    private float Hv;
    protected float Hw;
    protected float Hx;
    private final float Hy;
    private final Rect Hz;
    private final Paint paint;

    public BdExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Hv = 0.0f;
        this.Hz = new Rect();
        this.HA = new Rect();
        setScaleType(ImageView.ScaleType.MATRIX);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.Hv = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0) / 2.0f;
        this.Hw = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_beforeExpandHeight, 0);
        obtainStyledAttributes.recycle();
        this.Hx = getResources().getDisplayMetrics().widthPixels;
        this.Hy = this.Hw + (this.Hv * 2.0f);
        this.paint = new Paint();
        this.HE = getResources().getDisplayMetrics();
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        this.HC = true;
        return super.setFrame(i, i2, i3, i4);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.HC) {
            kV();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.HC) {
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
            this.HD = intrinsicHeight / 10.0f;
            this.HB = (int) (intrinsicHeight - (((((this.Hy - measuredHeight) / 2.0f) * this.HD) / this.Hv) * 2.0f));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Drawable drawable = getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            int scaledWidth = bitmap.getScaledWidth(this.HE);
            int scaledHeight = (bitmap.getScaledHeight(this.HE) - this.HB) / 2;
            this.Hz.set(0, scaledHeight, scaledWidth, this.HB + scaledHeight);
            int width = getWidth();
            float max = Math.max(width / scaledWidth, getHeight() / this.HB);
            int i = (int) (scaledWidth * max);
            int i2 = (i - width) / 2;
            this.HA.set(-i2, 0, i - (i2 * 2), (int) (max * this.HB));
            canvas.drawBitmap(bitmap, this.Hz, this.HA, this.paint);
        }
    }

    public boolean getEditable() {
        return false;
    }
}
