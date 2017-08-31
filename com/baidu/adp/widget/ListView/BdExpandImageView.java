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
    private float GQ;
    protected float GR;
    protected float GS;
    private final float GT;
    private final Rect GU;
    private final Rect GV;
    private int GW;
    private boolean GX;
    private float GY;
    private final DisplayMetrics GZ;
    private final Paint paint;

    public BdExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.GQ = 0.0f;
        this.GU = new Rect();
        this.GV = new Rect();
        setScaleType(ImageView.ScaleType.MATRIX);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.GQ = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0) / 2.0f;
        this.GR = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_beforeExpandHeight, 0);
        obtainStyledAttributes.recycle();
        this.GS = getResources().getDisplayMetrics().widthPixels;
        this.GT = this.GR + (this.GQ * 2.0f);
        this.paint = new Paint();
        this.GZ = getResources().getDisplayMetrics();
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        this.GX = true;
        return super.setFrame(i, i2, i3, i4);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.GX) {
            kW();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.GX) {
            kW();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        kW();
    }

    private void kW() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            int measuredHeight = getMeasuredHeight();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.GY = intrinsicHeight / 10.0f;
            this.GW = (int) (intrinsicHeight - (((((this.GT - measuredHeight) / 2.0f) * this.GY) / this.GQ) * 2.0f));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Drawable drawable = getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            int scaledWidth = bitmap.getScaledWidth(this.GZ);
            int scaledHeight = (bitmap.getScaledHeight(this.GZ) - this.GW) / 2;
            this.GU.set(0, scaledHeight, scaledWidth, this.GW + scaledHeight);
            int width = getWidth();
            float max = Math.max(width / scaledWidth, getHeight() / this.GW);
            int i = (int) (scaledWidth * max);
            int i2 = (i - width) / 2;
            this.GV.set(-i2, 0, i - (i2 * 2), (int) (max * this.GW));
            canvas.drawBitmap(bitmap, this.GU, this.GV, this.paint);
        }
    }

    public boolean getEditable() {
        return false;
    }
}
