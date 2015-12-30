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
    private final Rect HB;
    private int HC;
    private boolean HD;
    private float HE;
    private final DisplayMetrics HF;
    private float Hw;
    protected float Hx;
    protected float Hy;
    private final float Hz;
    private final Paint paint;

    public BdExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Hw = 0.0f;
        this.HA = new Rect();
        this.HB = new Rect();
        setScaleType(ImageView.ScaleType.MATRIX);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.Hw = obtainStyledAttributes.getDimensionPixelSize(1, 0) / 2.0f;
        this.Hx = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
        this.Hy = getResources().getDisplayMetrics().widthPixels;
        this.Hz = this.Hx + (this.Hw * 2.0f);
        this.paint = new Paint();
        this.HF = getResources().getDisplayMetrics();
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        this.HD = true;
        return super.setFrame(i, i2, i3, i4);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.HD) {
            mO();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.HD) {
            mO();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        mO();
    }

    private void mO() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            int measuredHeight = getMeasuredHeight();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.HE = intrinsicHeight / 10.0f;
            this.HC = (int) (intrinsicHeight - (((((this.Hz - measuredHeight) / 2.0f) * this.HE) / this.Hw) * 2.0f));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Drawable drawable = getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            int scaledWidth = bitmap.getScaledWidth(this.HF);
            int scaledHeight = (bitmap.getScaledHeight(this.HF) - this.HC) / 2;
            this.HA.set(0, scaledHeight, scaledWidth, this.HC + scaledHeight);
            int width = getWidth();
            float max = Math.max(width / scaledWidth, getHeight() / this.HC);
            int i = (int) (scaledWidth * max);
            int i2 = (i - width) / 2;
            this.HB.set(-i2, 0, i - (i2 * 2), (int) (max * this.HC));
            canvas.drawBitmap(bitmap, this.HA, this.HB, this.paint);
        }
    }

    public boolean getEditable() {
        return false;
    }
}
