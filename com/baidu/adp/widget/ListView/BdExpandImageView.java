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
    private float Ln;
    protected float Lo;
    protected float Lp;
    private final float Lq;
    private int Lr;
    private boolean Ls;
    private float Lt;
    private final DisplayMetrics Lu;
    private final Paint paint;
    private final Rect pe;
    private final Rect pf;

    public BdExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ln = 0.0f;
        this.pe = new Rect();
        this.pf = new Rect();
        setScaleType(ImageView.ScaleType.MATRIX);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.Ln = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0) / 2.0f;
        this.Lo = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_beforeExpandHeight, 0);
        obtainStyledAttributes.recycle();
        this.Lp = getResources().getDisplayMetrics().widthPixels;
        this.Lq = this.Lo + (this.Ln * 2.0f);
        this.paint = new Paint();
        this.Lu = getResources().getDisplayMetrics();
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        this.Ls = true;
        return super.setFrame(i, i2, i3, i4);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.Ls) {
            nj();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.Ls) {
            nj();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        nj();
    }

    private void nj() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            int measuredHeight = getMeasuredHeight();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.Lt = intrinsicHeight / 10.0f;
            this.Lr = (int) (intrinsicHeight - (((((this.Lq - measuredHeight) / 2.0f) * this.Lt) / this.Ln) * 2.0f));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Drawable drawable = getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            int scaledWidth = bitmap.getScaledWidth(this.Lu);
            int scaledHeight = (bitmap.getScaledHeight(this.Lu) - this.Lr) / 2;
            this.pe.set(0, scaledHeight, scaledWidth, this.Lr + scaledHeight);
            int width = getWidth();
            float max = Math.max(width / scaledWidth, getHeight() / this.Lr);
            int i = (int) (scaledWidth * max);
            int i2 = (i - width) / 2;
            this.pf.set(-i2, 0, i - (i2 * 2), (int) (max * this.Lr));
            canvas.drawBitmap(bitmap, this.pe, this.pf, this.paint);
        }
    }

    public boolean getEditable() {
        return false;
    }
}
