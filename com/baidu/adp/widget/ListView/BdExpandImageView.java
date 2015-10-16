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
    private float GN;
    protected float GP;
    protected float GQ;
    private final float GR;
    private final Rect GS;
    private final Rect GT;
    private int GU;
    private boolean GV;
    private float GW;
    private final DisplayMetrics GX;
    private final Paint paint;

    public BdExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.GN = 0.0f;
        this.GS = new Rect();
        this.GT = new Rect();
        setScaleType(ImageView.ScaleType.MATRIX);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.GN = obtainStyledAttributes.getDimensionPixelSize(1, 0) / 2.0f;
        this.GP = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
        this.GQ = getResources().getDisplayMetrics().widthPixels;
        this.GR = this.GP + (this.GN * 2.0f);
        this.paint = new Paint();
        this.GX = getResources().getDisplayMetrics();
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        this.GV = true;
        return super.setFrame(i, i2, i3, i4);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.GV) {
            nj();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.GV) {
            nj();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        nj();
    }

    private void nj() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            int measuredHeight = getMeasuredHeight();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.GW = intrinsicHeight / 10.0f;
            this.GU = (int) (intrinsicHeight - (((((this.GR - measuredHeight) / 2.0f) * this.GW) / this.GN) * 2.0f));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Drawable drawable = getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            int scaledWidth = bitmap.getScaledWidth(this.GX);
            int scaledHeight = (bitmap.getScaledHeight(this.GX) - this.GU) / 2;
            this.GS.set(0, scaledHeight, scaledWidth, this.GU + scaledHeight);
            int width = getWidth();
            float max = Math.max(width / scaledWidth, getHeight() / this.GU);
            int i = (int) (scaledWidth * max);
            int i2 = (i - width) / 2;
            this.GT.set(-i2, 0, i - (i2 * 2), (int) (max * this.GU));
            canvas.drawBitmap(bitmap, this.GS, this.GT, this.paint);
        }
    }

    public boolean getEditable() {
        return false;
    }
}
