package com.baidu.adp.newwidget.a;

import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Shader;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class h extends a {
    private BitmapShader j;
    private Matrix i = new Matrix();
    private RectF k = new RectF();

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView) {
        int d = dVar.d();
        int e = dVar.e();
        PointF a = a(this.e.left, this.e.top, this.d);
        int i = (int) a.x;
        int i2 = (int) a.y;
        PointF a2 = a(this.e.right, this.e.bottom, this.d);
        int i3 = (int) a2.x;
        int i4 = (int) a2.y;
        this.i.reset();
        this.i.postScale((i3 - i) / d, (i4 - i2) / e);
        this.i.postTranslate(i, i2);
        if (dVar.a()) {
            this.j = new BitmapShader(dVar.a.getBitmap(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        } else {
            this.j = dVar.b.n();
        }
        if (this.j != null) {
            this.j.setLocalMatrix(this.i);
            this.a.setShader(this.j);
            int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            this.k.set(Math.max(i, 0), Math.max(i2, 0), Math.min(i3, width), Math.min(i4, (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom()));
            if (this.g.c) {
                float f = this.g.d / 2.0f;
                if (!this.g.g) {
                    this.f.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                } else {
                    this.f.set(this.k.left + f, this.k.top + f, this.k.right - f, this.k.bottom - f);
                }
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        boolean b = dVar.b();
        if (b) {
            dVar.b.a(true);
        }
        if (!this.g.b) {
            canvas.drawRoundRect(this.k, this.g.a, this.g.a, this.a);
        } else {
            canvas.drawCircle((this.k.right + this.k.left) / 2.0f, (this.k.top + this.k.bottom) / 2.0f, Math.min(this.k.width(), this.k.height()) / 2.0f, this.a);
        }
        if (b) {
            dVar.b.a(false);
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void c(Canvas canvas, ImageView imageView) {
        if (this.g.c) {
            if (!this.g.b) {
                canvas.drawRoundRect(this.f, this.g.a, this.g.a, this.b);
            } else {
                canvas.drawCircle((this.k.right + this.k.left) / 2.0f, (this.k.top + this.k.bottom) / 2.0f, (Math.min(this.k.width(), this.k.height()) / 2.0f) - (this.g.d / 2), this.b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, ImageView imageView) {
        int scrollX;
        int scrollY;
        if (this.g.l != 0) {
            canvas.translate(imageView.getScrollX(), imageView.getScrollY());
            this.c.setColor(this.g.l);
            if (!this.g.b) {
                this.h.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
                canvas.drawRoundRect(this.h, this.g.a, this.g.a, this.c);
            } else {
                float width = imageView.getWidth() / 2;
                float height = imageView.getHeight() / 2;
                canvas.drawCircle(width, height, Math.min(width, height) - (this.g.d / 2), this.c);
            }
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
