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
    private float Hi;
    protected float Hj;
    protected float Hk;
    private final float Hl;
    private final Rect Hm;
    private final Rect Hn;
    private int Ho;
    private boolean Hp;
    private float Hq;
    private final DisplayMetrics Hr;
    private final Paint paint;

    public BdExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Hi = 0.0f;
        this.Hm = new Rect();
        this.Hn = new Rect();
        setScaleType(ImageView.ScaleType.MATRIX);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.Hi = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0) / 2.0f;
        this.Hj = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_beforeExpandHeight, 0);
        obtainStyledAttributes.recycle();
        this.Hk = getResources().getDisplayMetrics().widthPixels;
        this.Hl = this.Hj + (this.Hi * 2.0f);
        this.paint = new Paint();
        this.Hr = getResources().getDisplayMetrics();
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        this.Hp = true;
        return super.setFrame(i, i2, i3, i4);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.Hp) {
            kY();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.Hp) {
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
            this.Hq = intrinsicHeight / 10.0f;
            this.Ho = (int) (intrinsicHeight - (((((this.Hl - measuredHeight) / 2.0f) * this.Hq) / this.Hi) * 2.0f));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Drawable drawable = getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            int scaledWidth = bitmap.getScaledWidth(this.Hr);
            int scaledHeight = (bitmap.getScaledHeight(this.Hr) - this.Ho) / 2;
            this.Hm.set(0, scaledHeight, scaledWidth, this.Ho + scaledHeight);
            int width = getWidth();
            float max = Math.max(width / scaledWidth, getHeight() / this.Ho);
            int i = (int) (scaledWidth * max);
            int i2 = (i - width) / 2;
            this.Hn.set(-i2, 0, i - (i2 * 2), (int) (max * this.Ho));
            canvas.drawBitmap(bitmap, this.Hm, this.Hn, this.paint);
        }
    }

    public boolean getEditable() {
        return false;
    }
}
