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
    private float Lj;
    protected float Lk;
    protected float Ll;
    private final float Lm;
    private int Ln;
    private boolean Lo;
    private float Lp;
    private final DisplayMetrics Lq;
    private final Rect oT;
    private final Rect oU;
    private final Paint paint;

    public BdExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Lj = 0.0f;
        this.oT = new Rect();
        this.oU = new Rect();
        setScaleType(ImageView.ScaleType.MATRIX);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.Lj = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0) / 2.0f;
        this.Lk = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_beforeExpandHeight, 0);
        obtainStyledAttributes.recycle();
        this.Ll = getResources().getDisplayMetrics().widthPixels;
        this.Lm = this.Lk + (this.Lj * 2.0f);
        this.paint = new Paint();
        this.Lq = getResources().getDisplayMetrics();
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        this.Lo = true;
        return super.setFrame(i, i2, i3, i4);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.Lo) {
            nl();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.Lo) {
            nl();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        nl();
    }

    private void nl() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            int measuredHeight = getMeasuredHeight();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.Lp = intrinsicHeight / 10.0f;
            this.Ln = (int) (intrinsicHeight - (((((this.Lm - measuredHeight) / 2.0f) * this.Lp) / this.Lj) * 2.0f));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Drawable drawable = getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            int scaledWidth = bitmap.getScaledWidth(this.Lq);
            int scaledHeight = (bitmap.getScaledHeight(this.Lq) - this.Ln) / 2;
            this.oT.set(0, scaledHeight, scaledWidth, this.Ln + scaledHeight);
            int width = getWidth();
            float max = Math.max(width / scaledWidth, getHeight() / this.Ln);
            int i = (int) (scaledWidth * max);
            int i2 = (i - width) / 2;
            this.oU.set(-i2, 0, i - (i2 * 2), (int) (max * this.Ln));
            canvas.drawBitmap(bitmap, this.oT, this.oU, this.paint);
        }
    }

    public boolean getEditable() {
        return false;
    }
}
