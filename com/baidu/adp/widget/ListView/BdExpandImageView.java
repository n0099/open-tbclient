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
/* loaded from: classes.dex */
public class BdExpandImageView extends ImageView {
    protected float a;
    protected float b;
    private float c;
    private final boolean d;
    private final float e;
    private final Rect f;
    private final Rect g;
    private int h;
    private boolean i;
    private final Paint j;
    private float k;
    private final DisplayMetrics l;

    public BdExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = 0.0f;
        this.d = false;
        this.f = new Rect();
        this.g = new Rect();
        setScaleType(ImageView.ScaleType.MATRIX);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.baidu.adp.g.ExpandListView);
        this.c = obtainStyledAttributes.getDimensionPixelSize(1, 0) / 2;
        this.a = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.b = getResources().getDisplayMetrics().widthPixels;
        this.e = this.a + (2.0f * this.c);
        this.j = new Paint();
        this.l = getResources().getDisplayMetrics();
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        this.i = true;
        return super.setFrame(i, i2, i3, i4);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (this.i) {
            a();
        }
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.i) {
            a();
        }
        super.setImageBitmap(bitmap);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        a();
    }

    private void a() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            int measuredHeight = getMeasuredHeight();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.k = intrinsicHeight / 10;
            this.h = (int) (intrinsicHeight - (((((this.e - measuredHeight) / 2.0f) * this.k) / this.c) * 2.0f));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable)) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            int scaledWidth = bitmap.getScaledWidth(this.l);
            int scaledHeight = (bitmap.getScaledHeight(this.l) - this.h) / 2;
            this.f.set(0, scaledHeight, scaledWidth, this.h + scaledHeight);
            int width = getWidth();
            float max = Math.max(width / scaledWidth, getHeight() / this.h);
            int i = (int) (scaledWidth * max);
            int i2 = (i - width) / 2;
            this.g.set(-i2, 0, i - (i2 * 2), (int) (max * this.h));
            canvas.drawBitmap(bitmap, this.f, this.g, this.j);
        }
    }

    public boolean getEditable() {
        return false;
    }
}
