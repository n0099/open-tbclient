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
    protected BitmapShader vF;
    protected Matrix vE = new Matrix();
    protected RectF vG = new RectF();

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView) {
        int width = dVar.getWidth();
        int height = dVar.getHeight();
        PointF a = a(this.uI.left, this.uI.top, this.uH);
        int i = (int) a.x;
        int i2 = (int) a.y;
        PointF a2 = a(this.uI.right, this.uI.bottom, this.uH);
        int i3 = (int) a2.x;
        int i4 = (int) a2.y;
        this.vE.reset();
        this.vE.postScale((i3 - i) / width, (i4 - i2) / height);
        this.vE.postTranslate(i, i2);
        if (dVar.hH()) {
            this.vF = new BitmapShader(dVar.vh.getBitmap(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        } else {
            this.vF = dVar.vi.jZ();
        }
        if (this.vF != null) {
            this.vF.setLocalMatrix(this.vE);
            this.mPaint.setShader(this.vF);
            int width2 = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            this.vG.set(Math.max(i, 0), Math.max(i2, 0), Math.min(i3, width2), Math.min(i4, (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom()));
            if (this.uN.vk) {
                float f = this.uN.vl / 2.0f;
                if (!this.uN.vo) {
                    this.uJ.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                } else {
                    this.uJ.set(this.vG.left + f, this.vG.top + f, this.vG.right - f, this.vG.bottom - f);
                }
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        boolean hI = dVar.hI();
        if (hI) {
            dVar.vi.Q(true);
        }
        if (!this.uN.vj) {
            canvas.drawRoundRect(this.vG, this.uN.mRadius, this.uN.mRadius, this.mPaint);
        } else {
            canvas.drawCircle((this.vG.right + this.vG.left) / 2.0f, (this.vG.top + this.vG.bottom) / 2.0f, Math.min(this.vG.width(), this.vG.height()) / 2.0f, this.mPaint);
        }
        if (hI) {
            dVar.vi.Q(false);
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.uN.vk) {
            if (!this.uN.vj) {
                canvas.drawRoundRect(this.uJ, this.uN.mRadius, this.uN.mRadius, this.uF);
            } else {
                canvas.drawCircle((this.vG.right + this.vG.left) / 2.0f, (this.vG.top + this.vG.bottom) / 2.0f, (Math.min(this.vG.width(), this.vG.height()) / 2.0f) - (this.uN.vl / 2.0f), this.uF);
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.uN.vs != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.uG.setColor(this.uN.vs);
            if (!this.uN.vj) {
                this.uQ.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
                canvas.drawRoundRect(this.uQ, this.uN.mRadius, this.uN.mRadius, this.uG);
            } else {
                float width = imageView.getWidth() / 2.0f;
                float height = imageView.getHeight() / 2.0f;
                canvas.drawCircle(width, height, Math.min(width, height) - (this.uN.vl / 2.0f), this.uG);
            }
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
