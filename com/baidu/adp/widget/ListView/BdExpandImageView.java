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
    private float auF;
    protected float auG;
    protected float auH;
    private final float auI;
    private final Rect auJ;
    private final Rect auK;
    private int auL;
    private boolean auM;
    private float auN;
    private final DisplayMetrics auO;
    private final Paint paint;

    public BdExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.auF = 0.0f;
        this.auJ = new Rect();
        this.auK = new Rect();
        setScaleType(ImageView.ScaleType.MATRIX);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.auF = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0) / 2.0f;
        this.auG = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_beforeExpandHeight, 0);
        obtainStyledAttributes.recycle();
        this.auH = getResources().getDisplayMetrics().widthPixels;
        this.auI = this.auG + (this.auF * 2.0f);
        this.paint = new Paint();
        this.auO = getResources().getDisplayMetrics();
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        this.auM = true;
        return super.setFrame(i, i2, i3, i4);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.auM) {
            sq();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.auM) {
            sq();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        sq();
    }

    private void sq() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            int measuredHeight = getMeasuredHeight();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.auN = intrinsicHeight / 10.0f;
            this.auL = (int) (intrinsicHeight - (((((this.auI - measuredHeight) / 2.0f) * this.auN) / this.auF) * 2.0f));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Drawable drawable = getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            int scaledWidth = bitmap.getScaledWidth(this.auO);
            int scaledHeight = (bitmap.getScaledHeight(this.auO) - this.auL) / 2;
            this.auJ.set(0, scaledHeight, scaledWidth, this.auL + scaledHeight);
            int width = getWidth();
            float max = Math.max(width / scaledWidth, getHeight() / this.auL);
            int i = (int) (scaledWidth * max);
            int i2 = (i - width) / 2;
            this.auK.set(-i2, 0, i - (i2 * 2), (int) (max * this.auL));
            canvas.drawBitmap(bitmap, this.auJ, this.auK, this.paint);
        }
    }

    public boolean getEditable() {
        return false;
    }
}
