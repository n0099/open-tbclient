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
    private float Ll;
    protected float Lm;
    protected float Ln;
    private final float Lo;
    private int Lp;
    private boolean Lq;
    private float Lr;
    private final DisplayMetrics Ls;
    private final Paint paint;
    private final Rect pf;
    private final Rect pg;

    public BdExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ll = 0.0f;
        this.pf = new Rect();
        this.pg = new Rect();
        setScaleType(ImageView.ScaleType.MATRIX);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.Ll = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0) / 2.0f;
        this.Lm = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_beforeExpandHeight, 0);
        obtainStyledAttributes.recycle();
        this.Ln = getResources().getDisplayMetrics().widthPixels;
        this.Lo = this.Lm + (this.Ll * 2.0f);
        this.paint = new Paint();
        this.Ls = getResources().getDisplayMetrics();
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        this.Lq = true;
        return super.setFrame(i, i2, i3, i4);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.Lq) {
            nj();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.Lq) {
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
            this.Lr = intrinsicHeight / 10.0f;
            this.Lp = (int) (intrinsicHeight - (((((this.Lo - measuredHeight) / 2.0f) * this.Lr) / this.Ll) * 2.0f));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Drawable drawable = getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            int scaledWidth = bitmap.getScaledWidth(this.Ls);
            int scaledHeight = (bitmap.getScaledHeight(this.Ls) - this.Lp) / 2;
            this.pf.set(0, scaledHeight, scaledWidth, this.Lp + scaledHeight);
            int width = getWidth();
            float max = Math.max(width / scaledWidth, getHeight() / this.Lp);
            int i = (int) (scaledWidth * max);
            int i2 = (i - width) / 2;
            this.pg.set(-i2, 0, i - (i2 * 2), (int) (max * this.Lp));
            canvas.drawBitmap(bitmap, this.pf, this.pg, this.paint);
        }
    }

    public boolean getEditable() {
        return false;
    }
}
