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
    private float Hg;
    protected float Hh;
    protected float Hi;
    private final float Hj;
    private final Rect Hk;
    private final Rect Hl;
    private int Hm;
    private boolean Hn;
    private float Ho;
    private final DisplayMetrics Hp;
    private final Paint paint;

    public BdExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Hg = 0.0f;
        this.Hk = new Rect();
        this.Hl = new Rect();
        setScaleType(ImageView.ScaleType.MATRIX);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.Hg = obtainStyledAttributes.getDimensionPixelSize(1, 0) / 2.0f;
        this.Hh = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
        this.Hi = getResources().getDisplayMetrics().widthPixels;
        this.Hj = this.Hh + (this.Hg * 2.0f);
        this.paint = new Paint();
        this.Hp = getResources().getDisplayMetrics();
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        this.Hn = true;
        return super.setFrame(i, i2, i3, i4);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.Hn) {
            nq();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.Hn) {
            nq();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        nq();
    }

    private void nq() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            int measuredHeight = getMeasuredHeight();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.Ho = intrinsicHeight / 10.0f;
            this.Hm = (int) (intrinsicHeight - (((((this.Hj - measuredHeight) / 2.0f) * this.Ho) / this.Hg) * 2.0f));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Drawable drawable = getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            int scaledWidth = bitmap.getScaledWidth(this.Hp);
            int scaledHeight = (bitmap.getScaledHeight(this.Hp) - this.Hm) / 2;
            this.Hk.set(0, scaledHeight, scaledWidth, this.Hm + scaledHeight);
            int width = getWidth();
            float max = Math.max(width / scaledWidth, getHeight() / this.Hm);
            int i = (int) (scaledWidth * max);
            int i2 = (i - width) / 2;
            this.Hl.set(-i2, 0, i - (i2 * 2), (int) (max * this.Hm));
            canvas.drawBitmap(bitmap, this.Hk, this.Hl, this.paint);
        }
    }

    public boolean getEditable() {
        return false;
    }
}
