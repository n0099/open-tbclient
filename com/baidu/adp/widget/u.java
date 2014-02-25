package com.baidu.adp.widget;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Region;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class u extends BitmapDrawable implements t {
    private int a;
    private int b;
    private int c;
    private final Paint d;
    private Path e;
    private ImageView f;

    public u(Resources resources, Matrix matrix, ImageView imageView, Bitmap bitmap, int i, ColorFilter colorFilter) {
        super(resources, bitmap);
        this.a = 0;
        this.b = 0;
        this.e = new Path();
        this.f = imageView;
        this.c = Math.max(0, i);
        this.d = new Paint();
        this.d.setAntiAlias(true);
        this.d.setFilterBitmap(true);
        if (colorFilter != null) {
            this.d.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable, com.baidu.adp.widget.t
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        this.a = this.f.getMeasuredWidth();
        this.b = this.f.getMeasuredHeight();
        this.e.moveTo(0.0f, this.c);
        this.e.quadTo(0.0f, 0.0f, this.c, 0.0f);
        this.e.lineTo(this.a - this.c, 0.0f);
        this.e.quadTo(this.a, 0.0f, this.a, this.c);
        this.e.lineTo(this.a, this.b - this.c);
        this.e.quadTo(this.a, this.b, this.a - this.c, this.b);
        this.e.lineTo(this.c, this.b);
        this.e.quadTo(0.0f, this.b, 0.0f, this.b - this.c);
        this.e.lineTo(0.0f, this.c);
        this.e.close();
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable, com.baidu.adp.widget.t
    public void draw(Canvas canvas) {
        if (this.a != 0 && this.b != 0) {
            canvas.save();
            canvas.clipPath(this.e, Region.Op.INTERSECT);
            super.draw(canvas);
            canvas.restore();
        }
    }

    @Override // com.baidu.adp.widget.t
    public void a(ColorFilter colorFilter) {
        this.d.setColorFilter(colorFilter);
    }
}
