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
    private float NK;
    protected float NL;
    protected float NM;
    private final float NN;
    private int NP;
    private boolean NQ;
    private float NR;
    private final DisplayMetrics NT;
    private final Paint paint;
    private final Rect rt;
    private final Rect ru;

    public BdExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.NK = 0.0f;
        this.rt = new Rect();
        this.ru = new Rect();
        setScaleType(ImageView.ScaleType.MATRIX);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.NK = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0) / 2.0f;
        this.NL = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_beforeExpandHeight, 0);
        obtainStyledAttributes.recycle();
        this.NM = getResources().getDisplayMetrics().widthPixels;
        this.NN = this.NL + (this.NK * 2.0f);
        this.paint = new Paint();
        this.NT = getResources().getDisplayMetrics();
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        this.NQ = true;
        return super.setFrame(i, i2, i3, i4);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.NQ) {
            or();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.NQ) {
            or();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        or();
    }

    private void or() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            int measuredHeight = getMeasuredHeight();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.NR = intrinsicHeight / 10.0f;
            this.NP = (int) (intrinsicHeight - (((((this.NN - measuredHeight) / 2.0f) * this.NR) / this.NK) * 2.0f));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Drawable drawable = getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            int scaledWidth = bitmap.getScaledWidth(this.NT);
            int scaledHeight = (bitmap.getScaledHeight(this.NT) - this.NP) / 2;
            this.rt.set(0, scaledHeight, scaledWidth, this.NP + scaledHeight);
            int width = getWidth();
            float max = Math.max(width / scaledWidth, getHeight() / this.NP);
            int i = (int) (scaledWidth * max);
            int i2 = (i - width) / 2;
            this.ru.set(-i2, 0, i - (i2 * 2), (int) (max * this.NP));
            canvas.drawBitmap(bitmap, this.rt, this.ru, this.paint);
        }
    }

    public boolean getEditable() {
        return false;
    }
}
