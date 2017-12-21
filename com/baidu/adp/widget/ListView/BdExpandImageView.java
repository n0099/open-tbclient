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
    private float GE;
    protected float GF;
    protected float GG;
    private final float GH;
    private final Rect GI;
    private final Rect GJ;
    private int GK;
    private boolean GL;
    private float GM;
    private final DisplayMetrics GN;
    private final Paint paint;

    public BdExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.GE = 0.0f;
        this.GI = new Rect();
        this.GJ = new Rect();
        setScaleType(ImageView.ScaleType.MATRIX);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.GE = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0) / 2.0f;
        this.GF = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_beforeExpandHeight, 0);
        obtainStyledAttributes.recycle();
        this.GG = getResources().getDisplayMetrics().widthPixels;
        this.GH = this.GF + (this.GE * 2.0f);
        this.paint = new Paint();
        this.GN = getResources().getDisplayMetrics();
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        this.GL = true;
        return super.setFrame(i, i2, i3, i4);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.GL) {
            kS();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.GL) {
            kS();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        kS();
    }

    private void kS() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            int measuredHeight = getMeasuredHeight();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.GM = intrinsicHeight / 10.0f;
            this.GK = (int) (intrinsicHeight - (((((this.GH - measuredHeight) / 2.0f) * this.GM) / this.GE) * 2.0f));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Drawable drawable = getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            int scaledWidth = bitmap.getScaledWidth(this.GN);
            int scaledHeight = (bitmap.getScaledHeight(this.GN) - this.GK) / 2;
            this.GI.set(0, scaledHeight, scaledWidth, this.GK + scaledHeight);
            int width = getWidth();
            float max = Math.max(width / scaledWidth, getHeight() / this.GK);
            int i = (int) (scaledWidth * max);
            int i2 = (i - width) / 2;
            this.GJ.set(-i2, 0, i - (i2 * 2), (int) (max * this.GK));
            canvas.drawBitmap(bitmap, this.GI, this.GJ, this.paint);
        }
    }

    public boolean getEditable() {
        return false;
    }
}
