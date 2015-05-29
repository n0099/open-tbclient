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
    private float GL;
    protected float GM;
    protected float GN;
    private final float GP;
    private final Rect GQ;
    private final Rect GR;
    private int GS;
    private boolean GT;
    private float GU;
    private final DisplayMetrics GV;
    private final boolean mEnabled;
    private final Paint paint;

    public BdExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.GL = 0.0f;
        this.mEnabled = false;
        this.GQ = new Rect();
        this.GR = new Rect();
        setScaleType(ImageView.ScaleType.MATRIX);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.GL = obtainStyledAttributes.getDimensionPixelSize(1, 0) / 2;
        this.GM = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
        this.GN = getResources().getDisplayMetrics().widthPixels;
        this.GP = this.GM + (2.0f * this.GL);
        this.paint = new Paint();
        this.GV = getResources().getDisplayMetrics();
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        this.GT = true;
        return super.setFrame(i, i2, i3, i4);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.GT) {
            nb();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.GT) {
            nb();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        nb();
    }

    private void nb() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            int measuredHeight = getMeasuredHeight();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.GU = intrinsicHeight / 10;
            this.GS = (int) (intrinsicHeight - (((((this.GP - measuredHeight) / 2.0f) * this.GU) / this.GL) * 2.0f));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Drawable drawable = getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            int scaledWidth = bitmap.getScaledWidth(this.GV);
            int scaledHeight = (bitmap.getScaledHeight(this.GV) - this.GS) / 2;
            this.GQ.set(0, scaledHeight, scaledWidth, this.GS + scaledHeight);
            int width = getWidth();
            float max = Math.max(width / scaledWidth, getHeight() / this.GS);
            int i = (int) (scaledWidth * max);
            int i2 = (i - width) / 2;
            this.GR.set(-i2, 0, i - (i2 * 2), (int) (max * this.GS));
            canvas.drawBitmap(bitmap, this.GQ, this.GR, this.paint);
        }
    }

    public boolean getEditable() {
        return false;
    }
}
