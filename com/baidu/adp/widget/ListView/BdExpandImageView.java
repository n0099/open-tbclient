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
    private float GD;
    protected float GE;
    protected float GF;
    private final float GG;
    private final Rect GH;
    private final Rect GI;
    private int GJ;
    private boolean GK;
    private float GL;
    private final DisplayMetrics GM;
    private final Paint paint;

    public BdExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.GD = 0.0f;
        this.GH = new Rect();
        this.GI = new Rect();
        setScaleType(ImageView.ScaleType.MATRIX);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.GD = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0) / 2.0f;
        this.GE = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_beforeExpandHeight, 0);
        obtainStyledAttributes.recycle();
        this.GF = getResources().getDisplayMetrics().widthPixels;
        this.GG = this.GE + (this.GD * 2.0f);
        this.paint = new Paint();
        this.GM = getResources().getDisplayMetrics();
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        this.GK = true;
        return super.setFrame(i, i2, i3, i4);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.GK) {
            kS();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.GK) {
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
            this.GL = intrinsicHeight / 10.0f;
            this.GJ = (int) (intrinsicHeight - (((((this.GG - measuredHeight) / 2.0f) * this.GL) / this.GD) * 2.0f));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Drawable drawable = getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            int scaledWidth = bitmap.getScaledWidth(this.GM);
            int scaledHeight = (bitmap.getScaledHeight(this.GM) - this.GJ) / 2;
            this.GH.set(0, scaledHeight, scaledWidth, this.GJ + scaledHeight);
            int width = getWidth();
            float max = Math.max(width / scaledWidth, getHeight() / this.GJ);
            int i = (int) (scaledWidth * max);
            int i2 = (i - width) / 2;
            this.GI.set(-i2, 0, i - (i2 * 2), (int) (max * this.GJ));
            canvas.drawBitmap(bitmap, this.GH, this.GI, this.paint);
        }
    }

    public boolean getEditable() {
        return false;
    }
}
