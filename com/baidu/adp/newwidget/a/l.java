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
        PointF a = a(this.qI.left, this.qI.top, this.qH);
        int i = (int) a.x;
        int i2 = (int) a.y;
        PointF a2 = a(this.qI.right, this.qI.bottom, this.qH);
        int i3 = (int) a2.x;
        int i4 = (int) a2.y;
        this.rH.reset();
        this.rH.postScale((i3 - i) / width, (i4 - i2) / height);
        this.rH.postTranslate(i, i2);
        if (dVar.gE()) {
            this.rI = new BitmapShader(dVar.rj.getBitmap(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        } else {
            this.rI = dVar.rk.ji();
        }
        if (this.rI != null) {
            this.rI.setLocalMatrix(this.rH);
            this.mPaint.setShader(this.rI);
            int width2 = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            this.rJ.set(Math.max(i, 0), Math.max(i2, 0), Math.min(i3, width2), Math.min(i4, (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom()));
            if (this.qM.rm) {
                float f = this.qM.ro / 2.0f;
                if (!this.qM.rr) {
                    this.qJ.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                } else {
                    this.qJ.set(this.rJ.left + f, this.rJ.top + f, this.rJ.right - f, this.rJ.bottom - f);
                }
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        boolean gF = dVar.gF();
        if (gF) {
            dVar.rk.P(true);
        }
        if (!this.qM.rl) {
            canvas.drawRoundRect(this.rJ, this.qM.mRadius, this.qM.mRadius, this.mPaint);
        } else {
            canvas.drawCircle((this.rJ.right + this.rJ.left) / 2.0f, (this.rJ.top + this.rJ.bottom) / 2.0f, Math.min(this.rJ.width(), this.rJ.height()) / 2.0f, this.mPaint);
        }
        if (gF) {
            dVar.rk.P(false);
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.qM.rm) {
            if (!this.qM.rl) {
                canvas.drawRoundRect(this.qJ, this.qM.mRadius, this.qM.mRadius, this.qF);
            } else {
                canvas.drawCircle((this.rJ.right + this.rJ.left) / 2.0f, (this.rJ.top + this.rJ.bottom) / 2.0f, (Math.min(this.rJ.width(), this.rJ.height()) / 2.0f) - (this.qM.ro / 2), this.qF);
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, ImageView imageView) {
        int scrollX;
        int scrollY;
        if (this.qM.rv != 0) {
            canvas.translate(imageView.getScrollX(), imageView.getScrollY());
            this.qG.setColor(this.qM.rv);
            if (!this.qM.rl) {
                this.qP.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
                canvas.drawRoundRect(this.qP, this.qM.mRadius, this.qM.mRadius, this.qG);
            } else {
                float width = imageView.getWidth() / 2;
                float height = imageView.getHeight() / 2;
                canvas.drawCircle(width, height, Math.min(width, height) - (this.qM.ro / 2), this.qG);
            }
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
