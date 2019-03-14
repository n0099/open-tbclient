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
    private float OF;
    protected float OG;
    protected float OH;
    private final float OI;
    private int OJ;
    private boolean OL;
    private float OM;
    private final DisplayMetrics OO;
    private final Paint paint;
    private final Rect se;
    private final Rect sf;

    public BdExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.OF = 0.0f;
        this.se = new Rect();
        this.sf = new Rect();
        setScaleType(ImageView.ScaleType.MATRIX);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.OF = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0) / 2.0f;
        this.OG = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_beforeExpandHeight, 0);
        obtainStyledAttributes.recycle();
        this.OH = getResources().getDisplayMetrics().widthPixels;
        this.OI = this.OG + (this.OF * 2.0f);
        this.paint = new Paint();
        this.OO = getResources().getDisplayMetrics();
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        this.OL = true;
        return super.setFrame(i, i2, i3, i4);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.OL) {
            oI();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.OL) {
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
            this.OM = intrinsicHeight / 10.0f;
            this.OJ = (int) (intrinsicHeight - (((((this.OI - measuredHeight) / 2.0f) * this.OM) / this.OF) * 2.0f));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Drawable drawable = getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            int scaledWidth = bitmap.getScaledWidth(this.OO);
            int scaledHeight = (bitmap.getScaledHeight(this.OO) - this.OJ) / 2;
            this.se.set(0, scaledHeight, scaledWidth, this.OJ + scaledHeight);
            int width = getWidth();
            float max = Math.max(width / scaledWidth, getHeight() / this.OJ);
            int i = (int) (scaledWidth * max);
            int i2 = (i - width) / 2;
            this.sf.set(-i2, 0, i - (i2 * 2), (int) (max * this.OJ));
            canvas.drawBitmap(bitmap, this.se, this.sf, this.paint);
        }
    }

    public boolean getEditable() {
        return false;
    }
}
