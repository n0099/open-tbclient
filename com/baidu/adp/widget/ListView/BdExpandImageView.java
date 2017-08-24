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
    private float IY;
    protected float IZ;
    protected float Ja;
    private final float Jb;
    private final Rect Jc;
    private final Rect Jd;
    private int Je;
    private boolean Jf;
    private float Jg;
    private final DisplayMetrics Jh;
    private final Paint paint;

    public BdExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.IY = 0.0f;
        this.Jc = new Rect();
        this.Jd = new Rect();
        setScaleType(ImageView.ScaleType.MATRIX);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.IY = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0) / 2.0f;
        this.IZ = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_beforeExpandHeight, 0);
        obtainStyledAttributes.recycle();
        this.Ja = getResources().getDisplayMetrics().widthPixels;
        this.Jb = this.IZ + (this.IY * 2.0f);
        this.paint = new Paint();
        this.Jh = getResources().getDisplayMetrics();
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        this.Jf = true;
        return super.setFrame(i, i2, i3, i4);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.Jf) {
            le();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.Jf) {
            le();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        le();
    }

    private void le() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            int measuredHeight = getMeasuredHeight();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.Jg = intrinsicHeight / 10.0f;
            this.Je = (int) (intrinsicHeight - (((((this.Jb - measuredHeight) / 2.0f) * this.Jg) / this.IY) * 2.0f));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Drawable drawable = getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            int scaledWidth = bitmap.getScaledWidth(this.Jh);
            int scaledHeight = (bitmap.getScaledHeight(this.Jh) - this.Je) / 2;
            this.Jc.set(0, scaledHeight, scaledWidth, this.Je + scaledHeight);
            int width = getWidth();
            float max = Math.max(width / scaledWidth, getHeight() / this.Je);
            int i = (int) (scaledWidth * max);
            int i2 = (i - width) / 2;
            this.Jd.set(-i2, 0, i - (i2 * 2), (int) (max * this.Je));
            canvas.drawBitmap(bitmap, this.Jc, this.Jd, this.paint);
        }
    }

    public boolean getEditable() {
        return false;
    }
}
