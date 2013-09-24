package com.baidu.adp.widget;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class p extends BitmapDrawable {

    /* renamed from: a  reason: collision with root package name */
    private int f523a;
    private int b;
    private final int c;
    private final Paint d;
    private RectF e;
    private BitmapShader f;
    private ImageView g;
    private float h;

    public p(Resources resources, Matrix matrix, ImageView imageView, Bitmap bitmap, int i) {
        super(resources, bitmap);
        this.f523a = 0;
        this.b = 0;
        this.e = new RectF();
        this.g = imageView;
        this.c = Math.max(0, i);
        this.d = new Paint();
        this.d.setAntiAlias(true);
        this.d.setFilterBitmap(true);
        try {
            this.f = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            if (matrix != null) {
                this.f.setLocalMatrix(matrix);
            }
            this.d.setShader(this.f);
        } catch (OutOfMemoryError e) {
            this.f = null;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        float f;
        float f2;
        super.setBounds(i, i2, i3, i4);
        int i5 = i3 - i;
        int i6 = i4 - i2;
        this.f523a = this.g.getMeasuredWidth();
        this.b = this.g.getMeasuredHeight();
        if (this.b * i5 > this.f523a * i6) {
            this.h = i6 / this.b;
            f2 = (i5 - (this.f523a * this.h)) * 0.5f;
            f = 0.0f;
        } else {
            this.h = i5 / this.f523a;
            f = (i6 - (this.b * this.h)) * 0.5f;
            f2 = 0.0f;
        }
        this.e.set(0.0f, 0.0f, this.f523a * this.h, this.b * this.h);
        this.e.offset(f2, f);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f523a != 0 && this.b != 0) {
            canvas.drawRoundRect(this.e, (int) ((this.c * this.h) + 0.5f), (int) ((this.c * this.h) + 0.5f), this.d);
        }
    }
}
