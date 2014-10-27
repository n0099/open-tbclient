package com.baidu.adp.newwidget.a;

import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Shader;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class l extends a {
    protected BitmapShader rI;
    protected Matrix rH = new Matrix();
    protected RectF rJ = new RectF();

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView) {
        int width = dVar.getWidth();
        int height = dVar.getHeight();
        PointF a = a(this.qJ.left, this.qJ.top, this.qI);
        int i = (int) a.x;
        int i2 = (int) a.y;
        PointF a2 = a(this.qJ.right, this.qJ.bottom, this.qI);
        int i3 = (int) a2.x;
        int i4 = (int) a2.y;
        this.rH.reset();
        this.rH.postScale((i3 - i) / width, (i4 - i2) / height);
        this.rH.postTranslate(i, i2);
        if (dVar.gD()) {
            this.rI = new BitmapShader(dVar.rk.getBitmap(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        } else {
            this.rI = dVar.rl.hr();
        }
        if (this.rI != null) {
            this.rI.setLocalMatrix(this.rH);
            this.gs.setShader(this.rI);
            int width2 = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            this.rJ.set(Math.max(i, 0), Math.max(i2, 0), Math.min(i3, width2), Math.min(i4, (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom()));
            if (this.qN.ro) {
                float f = this.qN.rp / 2.0f;
                if (!this.qN.rs) {
                    this.qK.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                } else {
                    this.qK.set(this.rJ.left + f, this.rJ.top + f, this.rJ.right - f, this.rJ.bottom - f);
                }
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        boolean gE = dVar.gE();
        if (gE) {
            dVar.rl.D(true);
        }
        if (!this.qN.rm) {
            canvas.drawRoundRect(this.rJ, this.qN.mRadius, this.qN.mRadius, this.gs);
        } else {
            canvas.drawCircle((this.rJ.right + this.rJ.left) / 2.0f, (this.rJ.top + this.rJ.bottom) / 2.0f, Math.min(this.rJ.width(), this.rJ.height()) / 2.0f, this.gs);
        }
        if (gE) {
            dVar.rl.D(false);
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.qN.ro) {
            if (!this.qN.rm) {
                canvas.drawRoundRect(this.qK, this.qN.mRadius, this.qN.mRadius, this.qG);
            } else {
                canvas.drawCircle((this.rJ.right + this.rJ.left) / 2.0f, (this.rJ.top + this.rJ.bottom) / 2.0f, (Math.min(this.rJ.width(), this.rJ.height()) / 2.0f) - (this.qN.rp / 2), this.qG);
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, ImageView imageView) {
        int scrollX;
        int scrollY;
        if (this.qN.rw != 0) {
            canvas.translate(imageView.getScrollX(), imageView.getScrollY());
            this.qH.setColor(this.qN.rw);
            if (!this.qN.rm) {
                this.qQ.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
                canvas.drawRoundRect(this.qQ, this.qN.mRadius, this.qN.mRadius, this.qH);
            } else {
                float width = imageView.getWidth() / 2;
                float height = imageView.getHeight() / 2;
                canvas.drawCircle(width, height, Math.min(width, height) - (this.qN.rp / 2), this.qH);
            }
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
