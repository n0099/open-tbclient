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
    private float Hh;
    protected float Hi;
    protected float Hj;
    private final float Hk;
    private final Rect Hl;
    private final Rect Hm;
    private int Hn;
    private boolean Ho;
    private float Hp;
    private final DisplayMetrics Hq;
    private final Paint paint;

    public BdExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Hh = 0.0f;
        this.Hl = new Rect();
        this.Hm = new Rect();
        setScaleType(ImageView.ScaleType.MATRIX);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.Hh = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0) / 2.0f;
        this.Hi = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_beforeExpandHeight, 0);
        obtainStyledAttributes.recycle();
        this.Hj = getResources().getDisplayMetrics().widthPixels;
        this.Hk = this.Hi + (this.Hh * 2.0f);
        this.paint = new Paint();
        this.Hq = getResources().getDisplayMetrics();
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        this.Ho = true;
        return super.setFrame(i, i2, i3, i4);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.Ho) {
            kY();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.Ho) {
            kY();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        kY();
    }

    private void kY() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            int measuredHeight = getMeasuredHeight();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.Hp = intrinsicHeight / 10.0f;
            this.Hn = (int) (intrinsicHeight - (((((this.Hk - measuredHeight) / 2.0f) * this.Hp) / this.Hh) * 2.0f));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Drawable drawable = getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            int scaledWidth = bitmap.getScaledWidth(this.Hq);
            int scaledHeight = (bitmap.getScaledHeight(this.Hq) - this.Hn) / 2;
            this.Hl.set(0, scaledHeight, scaledWidth, this.Hn + scaledHeight);
            int width = getWidth();
            float max = Math.max(width / scaledWidth, getHeight() / this.Hn);
            int i = (int) (scaledWidth * max);
            int i2 = (i - width) / 2;
            this.Hm.set(-i2, 0, i - (i2 * 2), (int) (max * this.Hn));
            canvas.drawBitmap(bitmap, this.Hl, this.Hm, this.paint);
        }
    }

    public boolean getEditable() {
        return false;
    }
}
