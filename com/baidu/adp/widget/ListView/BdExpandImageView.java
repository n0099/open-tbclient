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
import android.widget.ImageView;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class BdExpandImageView extends ImageView {

    /* renamed from: e  reason: collision with root package name */
    public float f2290e;

    /* renamed from: f  reason: collision with root package name */
    public float f2291f;

    /* renamed from: g  reason: collision with root package name */
    public final float f2292g;

    /* renamed from: h  reason: collision with root package name */
    public final Rect f2293h;
    public final Rect i;
    public int j;
    public boolean k;
    public final Paint l;
    public float m;

    public BdExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2290e = 0.0f;
        this.f2293h = new Rect();
        this.i = new Rect();
        setScaleType(ImageView.ScaleType.MATRIX);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.f2290e = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0) / 2.0f;
        this.f2291f = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_beforeExpandHeight, 0);
        obtainStyledAttributes.recycle();
        int i = getResources().getDisplayMetrics().widthPixels;
        this.f2292g = this.f2291f + (this.f2290e * 2.0f);
        this.l = new Paint();
        getResources().getDisplayMetrics();
    }

    public final void a() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            int measuredHeight = getMeasuredHeight();
            float intrinsicHeight = drawable.getIntrinsicHeight();
            float f2 = intrinsicHeight / 10.0f;
            this.m = f2;
            this.j = (int) (intrinsicHeight - (((f2 * ((this.f2292g - measuredHeight) / 2.0f)) / this.f2290e) * 2.0f));
        }
    }

    public boolean getEditable() {
        return false;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable) || (bitmap = ((BitmapDrawable) drawable).getBitmap()) == null || bitmap.isRecycled()) {
            return;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i = this.j;
        int i2 = (height - i) / 2;
        this.f2293h.set(0, i2, width, i + i2);
        int width2 = getWidth();
        float f2 = width;
        float max = Math.max(width2 / f2, getHeight() / this.j);
        int i3 = (int) (f2 * max);
        int i4 = (i3 - width2) / 2;
        this.i.set(-i4, 0, i3 - (i4 * 2), (int) (this.j * max));
        canvas.drawBitmap(bitmap, this.f2293h, this.i, this.l);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        a();
    }

    @Override // android.widget.ImageView
    public boolean setFrame(int i, int i2, int i3, int i4) {
        this.k = true;
        return super.setFrame(i, i2, i3, i4);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.k) {
            a();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.k) {
            a();
        }
    }
}
