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
    private final float HA;
    private final Rect HB;
    private final Rect HC;
    private int HD;
    private boolean HE;
    private float HF;
    private final DisplayMetrics HG;
    private float Hx;
    protected float Hy;
    protected float Hz;
    private final Paint paint;

    public BdExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Hx = 0.0f;
        this.HB = new Rect();
        this.HC = new Rect();
        setScaleType(ImageView.ScaleType.MATRIX);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.Hx = obtainStyledAttributes.getDimensionPixelSize(1, 0) / 2.0f;
        this.Hy = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
        this.Hz = getResources().getDisplayMetrics().widthPixels;
        this.HA = this.Hy + (this.Hx * 2.0f);
        this.paint = new Paint();
        this.HG = getResources().getDisplayMetrics();
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        this.HE = true;
        return super.setFrame(i, i2, i3, i4);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.HE) {
            kZ();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.HE) {
            kZ();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        kZ();
    }

    private void kZ() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            int measuredHeight = getMeasuredHeight();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.HF = intrinsicHeight / 10.0f;
            this.HD = (int) (intrinsicHeight - (((((this.HA - measuredHeight) / 2.0f) * this.HF) / this.Hx) * 2.0f));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Drawable drawable = getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            int scaledWidth = bitmap.getScaledWidth(this.HG);
            int scaledHeight = (bitmap.getScaledHeight(this.HG) - this.HD) / 2;
            this.HB.set(0, scaledHeight, scaledWidth, this.HD + scaledHeight);
            int width = getWidth();
            float max = Math.max(width / scaledWidth, getHeight() / this.HD);
            int i = (int) (scaledWidth * max);
            int i2 = (i - width) / 2;
            this.HC.set(-i2, 0, i - (i2 * 2), (int) (max * this.HD));
            canvas.drawBitmap(bitmap, this.HB, this.HC, this.paint);
        }
    }

    public boolean getEditable() {
        return false;
    }
}
