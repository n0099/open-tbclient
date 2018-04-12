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
    private float Fg;
    protected float Fh;
    protected float Fi;
    private final float Fj;
    private final Rect Fk;
    private final Rect Fl;
    private int Fm;
    private boolean Fn;
    private float Fo;
    private final DisplayMetrics Fp;
    private final Paint paint;

    public BdExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Fg = 0.0f;
        this.Fk = new Rect();
        this.Fl = new Rect();
        setScaleType(ImageView.ScaleType.MATRIX);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.Fg = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0) / 2.0f;
        this.Fh = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_beforeExpandHeight, 0);
        obtainStyledAttributes.recycle();
        this.Fi = getResources().getDisplayMetrics().widthPixels;
        this.Fj = this.Fh + (this.Fg * 2.0f);
        this.paint = new Paint();
        this.Fp = getResources().getDisplayMetrics();
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        this.Fn = true;
        return super.setFrame(i, i2, i3, i4);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.Fn) {
            kw();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.Fn) {
            kw();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        kw();
    }

    private void kw() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            int measuredHeight = getMeasuredHeight();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.Fo = intrinsicHeight / 10.0f;
            this.Fm = (int) (intrinsicHeight - (((((this.Fj - measuredHeight) / 2.0f) * this.Fo) / this.Fg) * 2.0f));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Drawable drawable = getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            int scaledWidth = bitmap.getScaledWidth(this.Fp);
            int scaledHeight = (bitmap.getScaledHeight(this.Fp) - this.Fm) / 2;
            this.Fk.set(0, scaledHeight, scaledWidth, this.Fm + scaledHeight);
            int width = getWidth();
            float max = Math.max(width / scaledWidth, getHeight() / this.Fm);
            int i = (int) (scaledWidth * max);
            int i2 = (i - width) / 2;
            this.Fl.set(-i2, 0, i - (i2 * 2), (int) (max * this.Fm));
            canvas.drawBitmap(bitmap, this.Fk, this.Fl, this.paint);
        }
    }

    public boolean getEditable() {
        return false;
    }
}
