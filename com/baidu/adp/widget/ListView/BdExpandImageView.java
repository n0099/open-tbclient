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
    private float Fc;
    protected float Fd;
    protected float Fe;
    private final float Ff;
    private final Rect Fg;
    private final Rect Fh;
    private int Fi;
    private boolean Fj;
    private float Fk;
    private final DisplayMetrics Fl;
    private final Paint paint;

    public BdExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Fc = 0.0f;
        this.Fg = new Rect();
        this.Fh = new Rect();
        setScaleType(ImageView.ScaleType.MATRIX);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.Fc = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0) / 2.0f;
        this.Fd = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_beforeExpandHeight, 0);
        obtainStyledAttributes.recycle();
        this.Fe = getResources().getDisplayMetrics().widthPixels;
        this.Ff = this.Fd + (this.Fc * 2.0f);
        this.paint = new Paint();
        this.Fl = getResources().getDisplayMetrics();
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        this.Fj = true;
        return super.setFrame(i, i2, i3, i4);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.Fj) {
            kv();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.Fj) {
            kv();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        kv();
    }

    private void kv() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            int measuredHeight = getMeasuredHeight();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.Fk = intrinsicHeight / 10.0f;
            this.Fi = (int) (intrinsicHeight - (((((this.Ff - measuredHeight) / 2.0f) * this.Fk) / this.Fc) * 2.0f));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Drawable drawable = getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            int scaledWidth = bitmap.getScaledWidth(this.Fl);
            int scaledHeight = (bitmap.getScaledHeight(this.Fl) - this.Fi) / 2;
            this.Fg.set(0, scaledHeight, scaledWidth, this.Fi + scaledHeight);
            int width = getWidth();
            float max = Math.max(width / scaledWidth, getHeight() / this.Fi);
            int i = (int) (scaledWidth * max);
            int i2 = (i - width) / 2;
            this.Fh.set(-i2, 0, i - (i2 * 2), (int) (max * this.Fi));
            canvas.drawBitmap(bitmap, this.Fg, this.Fh, this.paint);
        }
    }

    public boolean getEditable() {
        return false;
    }
}
