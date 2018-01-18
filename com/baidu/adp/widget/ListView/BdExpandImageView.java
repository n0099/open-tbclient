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
    private float auE;
    protected float auF;
    protected float auG;
    private final float auH;
    private final Rect auI;
    private final Rect auJ;
    private int auK;
    private boolean auL;
    private float auM;
    private final DisplayMetrics auN;
    private final Paint paint;

    public BdExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.auE = 0.0f;
        this.auI = new Rect();
        this.auJ = new Rect();
        setScaleType(ImageView.ScaleType.MATRIX);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.auE = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0) / 2.0f;
        this.auF = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_beforeExpandHeight, 0);
        obtainStyledAttributes.recycle();
        this.auG = getResources().getDisplayMetrics().widthPixels;
        this.auH = this.auF + (this.auE * 2.0f);
        this.paint = new Paint();
        this.auN = getResources().getDisplayMetrics();
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        this.auL = true;
        return super.setFrame(i, i2, i3, i4);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.auL) {
            sq();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.auL) {
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
            this.auM = intrinsicHeight / 10.0f;
            this.auK = (int) (intrinsicHeight - (((((this.auH - measuredHeight) / 2.0f) * this.auM) / this.auE) * 2.0f));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Drawable drawable = getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            int scaledWidth = bitmap.getScaledWidth(this.auN);
            int scaledHeight = (bitmap.getScaledHeight(this.auN) - this.auK) / 2;
            this.auI.set(0, scaledHeight, scaledWidth, this.auK + scaledHeight);
            int width = getWidth();
            float max = Math.max(width / scaledWidth, getHeight() / this.auK);
            int i = (int) (scaledWidth * max);
            int i2 = (i - width) / 2;
            this.auJ.set(-i2, 0, i - (i2 * 2), (int) (max * this.auK));
            canvas.drawBitmap(bitmap, this.auI, this.auJ, this.paint);
        }
    }

    public boolean getEditable() {
        return false;
    }
}
