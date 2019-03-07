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
    private float OE;
    protected float OF;
    protected float OG;
    private final float OH;
    private int OI;
    private boolean OJ;
    private float OL;
    private final DisplayMetrics OM;
    private final Paint paint;
    private final Rect se;
    private final Rect sf;

    public BdExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.OE = 0.0f;
        this.se = new Rect();
        this.sf = new Rect();
        setScaleType(ImageView.ScaleType.MATRIX);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.OE = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0) / 2.0f;
        this.OF = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_beforeExpandHeight, 0);
        obtainStyledAttributes.recycle();
        this.OG = getResources().getDisplayMetrics().widthPixels;
        this.OH = this.OF + (this.OE * 2.0f);
        this.paint = new Paint();
        this.OM = getResources().getDisplayMetrics();
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        this.OJ = true;
        return super.setFrame(i, i2, i3, i4);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.OJ) {
            oI();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.OJ) {
            oI();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        oI();
    }

    private void oI() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            int measuredHeight = getMeasuredHeight();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.OL = intrinsicHeight / 10.0f;
            this.OI = (int) (intrinsicHeight - (((((this.OH - measuredHeight) / 2.0f) * this.OL) / this.OE) * 2.0f));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Drawable drawable = getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            int scaledWidth = bitmap.getScaledWidth(this.OM);
            int scaledHeight = (bitmap.getScaledHeight(this.OM) - this.OI) / 2;
            this.se.set(0, scaledHeight, scaledWidth, this.OI + scaledHeight);
            int width = getWidth();
            float max = Math.max(width / scaledWidth, getHeight() / this.OI);
            int i = (int) (scaledWidth * max);
            int i2 = (i - width) / 2;
            this.sf.set(-i2, 0, i - (i2 * 2), (int) (max * this.OI));
            canvas.drawBitmap(bitmap, this.se, this.sf, this.paint);
        }
    }

    public boolean getEditable() {
        return false;
    }
}
