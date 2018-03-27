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
    private int auA;
    private boolean auB;
    private float auC;
    private final DisplayMetrics auD;
    private float auu;
    protected float auv;
    protected float auw;
    private final float aux;
    private final Rect auy;
    private final Rect auz;
    private final Paint paint;

    public BdExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.auu = 0.0f;
        this.auy = new Rect();
        this.auz = new Rect();
        setScaleType(ImageView.ScaleType.MATRIX);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.auu = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0) / 2.0f;
        this.auv = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_beforeExpandHeight, 0);
        obtainStyledAttributes.recycle();
        this.auw = getResources().getDisplayMetrics().widthPixels;
        this.aux = this.auv + (this.auu * 2.0f);
        this.paint = new Paint();
        this.auD = getResources().getDisplayMetrics();
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        this.auB = true;
        return super.setFrame(i, i2, i3, i4);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.auB) {
            sp();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.auB) {
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
            this.auC = intrinsicHeight / 10.0f;
            this.auA = (int) (intrinsicHeight - (((((this.aux - measuredHeight) / 2.0f) * this.auC) / this.auu) * 2.0f));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Drawable drawable = getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            int scaledWidth = bitmap.getScaledWidth(this.auD);
            int scaledHeight = (bitmap.getScaledHeight(this.auD) - this.auA) / 2;
            this.auy.set(0, scaledHeight, scaledWidth, this.auA + scaledHeight);
            int width = getWidth();
            float max = Math.max(width / scaledWidth, getHeight() / this.auA);
            int i = (int) (scaledWidth * max);
            int i2 = (i - width) / 2;
            this.auz.set(-i2, 0, i - (i2 * 2), (int) (max * this.auA));
            canvas.drawBitmap(bitmap, this.auy, this.auz, this.paint);
        }
    }

    public boolean getEditable() {
        return false;
    }
}
