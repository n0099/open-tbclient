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
    private float GP;
    protected float GQ;
    protected float GR;
    private final float GS;
    private final Rect GT;
    private final Rect GU;
    private int GV;
    private boolean GW;
    private float GX;
    private final DisplayMetrics GY;
    private final Paint paint;

    public BdExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.GP = 0.0f;
        this.GT = new Rect();
        this.GU = new Rect();
        setScaleType(ImageView.ScaleType.MATRIX);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.GP = obtainStyledAttributes.getDimensionPixelSize(1, 0) / 2.0f;
        this.GQ = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
        this.GR = getResources().getDisplayMetrics().widthPixels;
        this.GS = this.GQ + (this.GP * 2.0f);
        this.paint = new Paint();
        this.GY = getResources().getDisplayMetrics();
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        this.GW = true;
        return super.setFrame(i, i2, i3, i4);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.GW) {
            nk();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.GW) {
            nk();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        nk();
    }

    private void nk() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            int measuredHeight = getMeasuredHeight();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.GX = intrinsicHeight / 10.0f;
            this.GV = (int) (intrinsicHeight - (((((this.GS - measuredHeight) / 2.0f) * this.GX) / this.GP) * 2.0f));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Drawable drawable = getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            int scaledWidth = bitmap.getScaledWidth(this.GY);
            int scaledHeight = (bitmap.getScaledHeight(this.GY) - this.GV) / 2;
            this.GT.set(0, scaledHeight, scaledWidth, this.GV + scaledHeight);
            int width = getWidth();
            float max = Math.max(width / scaledWidth, getHeight() / this.GV);
            int i = (int) (scaledWidth * max);
            int i2 = (i - width) / 2;
            this.GU.set(-i2, 0, i - (i2 * 2), (int) (max * this.GV));
            canvas.drawBitmap(bitmap, this.GT, this.GU, this.paint);
        }
    }

    public boolean getEditable() {
        return false;
    }
}
