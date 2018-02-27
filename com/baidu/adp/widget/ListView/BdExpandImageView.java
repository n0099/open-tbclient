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
    private boolean auA;
    private float auB;
    private final DisplayMetrics auC;
    private float aut;
    protected float auu;
    protected float auv;
    private final float auw;
    private final Rect aux;
    private final Rect auy;
    private int auz;
    private final Paint paint;

    public BdExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aut = 0.0f;
        this.aux = new Rect();
        this.auy = new Rect();
        setScaleType(ImageView.ScaleType.MATRIX);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.aut = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0) / 2.0f;
        this.auu = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_beforeExpandHeight, 0);
        obtainStyledAttributes.recycle();
        this.auv = getResources().getDisplayMetrics().widthPixels;
        this.auw = this.auu + (this.aut * 2.0f);
        this.paint = new Paint();
        this.auC = getResources().getDisplayMetrics();
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        this.auA = true;
        return super.setFrame(i, i2, i3, i4);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.auA) {
            sp();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.auA) {
            sp();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        sp();
    }

    private void sp() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            int measuredHeight = getMeasuredHeight();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.auB = intrinsicHeight / 10.0f;
            this.auz = (int) (intrinsicHeight - (((((this.auw - measuredHeight) / 2.0f) * this.auB) / this.aut) * 2.0f));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Drawable drawable = getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            int scaledWidth = bitmap.getScaledWidth(this.auC);
            int scaledHeight = (bitmap.getScaledHeight(this.auC) - this.auz) / 2;
            this.aux.set(0, scaledHeight, scaledWidth, this.auz + scaledHeight);
            int width = getWidth();
            float max = Math.max(width / scaledWidth, getHeight() / this.auz);
            int i = (int) (scaledWidth * max);
            int i2 = (i - width) / 2;
            this.auy.set(-i2, 0, i - (i2 * 2), (int) (max * this.auz));
            canvas.drawBitmap(bitmap, this.aux, this.auy, this.paint);
        }
    }

    public boolean getEditable() {
        return false;
    }
}
