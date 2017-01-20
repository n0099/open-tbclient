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
    private float AH;
    protected float AI;
    protected float AJ;
    private final float AK;
    private final Rect AL;
    private final Rect AM;
    private int AN;
    private boolean AO;
    private float AP;
    private final DisplayMetrics AQ;
    private final Paint paint;

    public BdExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.AH = 0.0f;
        this.AL = new Rect();
        this.AM = new Rect();
        setScaleType(ImageView.ScaleType.MATRIX);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.AH = obtainStyledAttributes.getDimensionPixelSize(1, 0) / 2.0f;
        this.AI = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
        this.AJ = getResources().getDisplayMetrics().widthPixels;
        this.AK = this.AI + (this.AH * 2.0f);
        this.paint = new Paint();
        this.AQ = getResources().getDisplayMetrics();
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        this.AO = true;
        return super.setFrame(i, i2, i3, i4);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.AO) {
            kb();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.AO) {
            kb();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        kb();
    }

    private void kb() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            int measuredHeight = getMeasuredHeight();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.AP = intrinsicHeight / 10.0f;
            this.AN = (int) (intrinsicHeight - (((((this.AK - measuredHeight) / 2.0f) * this.AP) / this.AH) * 2.0f));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Drawable drawable = getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            int scaledWidth = bitmap.getScaledWidth(this.AQ);
            int scaledHeight = (bitmap.getScaledHeight(this.AQ) - this.AN) / 2;
            this.AL.set(0, scaledHeight, scaledWidth, this.AN + scaledHeight);
            int width = getWidth();
            float max = Math.max(width / scaledWidth, getHeight() / this.AN);
            int i = (int) (scaledWidth * max);
            int i2 = (i - width) / 2;
            this.AM.set(-i2, 0, i - (i2 * 2), (int) (max * this.AN));
            canvas.drawBitmap(bitmap, this.AL, this.AM, this.paint);
        }
    }

    public boolean getEditable() {
        return false;
    }
}
