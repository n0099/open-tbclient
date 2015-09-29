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
    private float GM;
    protected float GN;
    protected float GP;
    private final float GQ;
    private final Rect GR;
    private final Rect GS;
    private int GT;
    private boolean GU;
    private float GV;
    private final DisplayMetrics GW;
    private final Paint paint;

    public BdExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.GM = 0.0f;
        this.GR = new Rect();
        this.GS = new Rect();
        setScaleType(ImageView.ScaleType.MATRIX);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.GM = obtainStyledAttributes.getDimensionPixelSize(1, 0) / 2.0f;
        this.GN = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
        this.GP = getResources().getDisplayMetrics().widthPixels;
        this.GQ = this.GN + (this.GM * 2.0f);
        this.paint = new Paint();
        this.GW = getResources().getDisplayMetrics();
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        this.GU = true;
        return super.setFrame(i, i2, i3, i4);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.GU) {
            nj();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.GU) {
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
            this.GV = intrinsicHeight / 10.0f;
            this.GT = (int) (intrinsicHeight - (((((this.GQ - measuredHeight) / 2.0f) * this.GV) / this.GM) * 2.0f));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Drawable drawable = getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            int scaledWidth = bitmap.getScaledWidth(this.GW);
            int scaledHeight = (bitmap.getScaledHeight(this.GW) - this.GT) / 2;
            this.GR.set(0, scaledHeight, scaledWidth, this.GT + scaledHeight);
            int width = getWidth();
            float max = Math.max(width / scaledWidth, getHeight() / this.GT);
            int i = (int) (scaledWidth * max);
            int i2 = (i - width) / 2;
            this.GS.set(-i2, 0, i - (i2 * 2), (int) (max * this.GT));
            canvas.drawBitmap(bitmap, this.GR, this.GS, this.paint);
        }
    }

    public boolean getEditable() {
        return false;
    }
}
