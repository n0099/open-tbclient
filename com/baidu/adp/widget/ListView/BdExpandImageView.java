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
    public float f2326e;

    /* renamed from: f  reason: collision with root package name */
    public float f2327f;

    /* renamed from: g  reason: collision with root package name */
    public final float f2328g;

    /* renamed from: h  reason: collision with root package name */
    public final Rect f2329h;

    /* renamed from: i  reason: collision with root package name */
    public final Rect f2330i;
    public int j;
    public boolean k;
    public final Paint l;
    public float m;

    public BdExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2326e = 0.0f;
        this.f2329h = new Rect();
        this.f2330i = new Rect();
        setScaleType(ImageView.ScaleType.MATRIX);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.f2326e = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0) / 2.0f;
        this.f2327f = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_beforeExpandHeight, 0);
        obtainStyledAttributes.recycle();
        int i2 = getResources().getDisplayMetrics().widthPixels;
        this.f2328g = this.f2327f + (this.f2326e * 2.0f);
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
            this.j = (int) (intrinsicHeight - (((f2 * ((this.f2328g - measuredHeight) / 2.0f)) / this.f2326e) * 2.0f));
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
        int i2 = this.j;
        int i3 = (height - i2) / 2;
        this.f2329h.set(0, i3, width, i2 + i3);
        int width2 = getWidth();
        float f2 = width;
        float max = Math.max(width2 / f2, getHeight() / this.j);
        int i4 = (int) (f2 * max);
        int i5 = (i4 - width2) / 2;
        this.f2330i.set(-i5, 0, i4 - (i5 * 2), (int) (this.j * max));
        canvas.drawBitmap(bitmap, this.f2329h, this.f2330i, this.l);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        a();
    }

    @Override // android.widget.ImageView
    public boolean setFrame(int i2, int i3, int i4, int i5) {
        this.k = true;
        return super.setFrame(i2, i3, i4, i5);
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
