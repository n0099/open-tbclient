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
    private float auH;
    protected float auI;
    protected float auJ;
    private final float auK;
    private final Rect auL;
    private final Rect auM;
    private int auN;
    private boolean auO;
    private float auP;
    private final DisplayMetrics auQ;
    private final Paint paint;

    public BdExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.auH = 0.0f;
        this.auL = new Rect();
        this.auM = new Rect();
        setScaleType(ImageView.ScaleType.MATRIX);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.auH = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0) / 2.0f;
        this.auI = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_beforeExpandHeight, 0);
        obtainStyledAttributes.recycle();
        this.auJ = getResources().getDisplayMetrics().widthPixels;
        this.auK = this.auI + (this.auH * 2.0f);
        this.paint = new Paint();
        this.auQ = getResources().getDisplayMetrics();
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        this.auO = true;
        return super.setFrame(i, i2, i3, i4);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.auO) {
            sr();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.auO) {
            sr();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        sr();
    }

    private void sr() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            int measuredHeight = getMeasuredHeight();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.auP = intrinsicHeight / 10.0f;
            this.auN = (int) (intrinsicHeight - (((((this.auK - measuredHeight) / 2.0f) * this.auP) / this.auH) * 2.0f));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Drawable drawable = getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            int scaledWidth = bitmap.getScaledWidth(this.auQ);
            int scaledHeight = (bitmap.getScaledHeight(this.auQ) - this.auN) / 2;
            this.auL.set(0, scaledHeight, scaledWidth, this.auN + scaledHeight);
            int width = getWidth();
            float max = Math.max(width / scaledWidth, getHeight() / this.auN);
            int i = (int) (scaledWidth * max);
            int i2 = (i - width) / 2;
            this.auM.set(-i2, 0, i - (i2 * 2), (int) (max * this.auN));
            canvas.drawBitmap(bitmap, this.auL, this.auM, this.paint);
        }
    }

    public boolean getEditable() {
        return false;
    }
}
