package com.baidu.adp.b.a;

import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Shader;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class l extends a {
    protected BitmapShader BV;
    protected Matrix BU = new Matrix();
    protected RectF BW = new RectF();

    @Override // com.baidu.adp.b.a.a
    public void a(d dVar, ImageView imageView) {
        int width = dVar.getWidth();
        int height = dVar.getHeight();
        PointF a = a(this.AY.left, this.AY.top, this.AX);
        int i = (int) a.x;
        int i2 = (int) a.y;
        PointF a2 = a(this.AY.right, this.AY.bottom, this.AX);
        int i3 = (int) a2.x;
        int i4 = (int) a2.y;
        this.BU.reset();
        this.BU.postScale((i3 - i) / width, (i4 - i2) / height);
        this.BU.postTranslate(i, i2);
        if (dVar.iD()) {
            this.BV = new BitmapShader(dVar.Bx.getBitmap(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        } else {
            this.BV = dVar.By.kT();
        }
        if (this.BV != null) {
            this.BV.setLocalMatrix(this.BU);
            this.mPaint.setShader(this.BV);
            int width2 = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            this.BW.set(Math.max(i, 0), Math.max(i2, 0), Math.min(i3, width2), Math.min(i4, (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom()));
            if (this.Bd.BA) {
                float f = this.Bd.BB / 2.0f;
                if (!this.Bd.BE) {
                    this.AZ.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                } else {
                    this.AZ.set(this.BW.left + f, this.BW.top + f, this.BW.right - f, this.BW.bottom - f);
                }
            }
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        boolean iE = dVar.iE();
        if (iE) {
            dVar.By.S(true);
        }
        if (!this.Bd.Bz) {
            canvas.drawRoundRect(this.BW, this.Bd.mRadius, this.Bd.mRadius, this.mPaint);
        } else {
            canvas.drawCircle((this.BW.right + this.BW.left) / 2.0f, (this.BW.top + this.BW.bottom) / 2.0f, Math.min(this.BW.width(), this.BW.height()) / 2.0f, this.mPaint);
        }
        if (iE) {
            dVar.By.S(false);
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.Bd.BA) {
            if (!this.Bd.Bz) {
                canvas.drawRoundRect(this.AZ, this.Bd.mRadius, this.Bd.mRadius, this.AV);
            } else {
                canvas.drawCircle((this.BW.right + this.BW.left) / 2.0f, (this.BW.top + this.BW.bottom) / 2.0f, (Math.min(this.BW.width(), this.BW.height()) / 2.0f) - (this.Bd.BB / 2.0f), this.AV);
            }
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.Bd.BI != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.AW.setColor(this.Bd.BI);
            if (!this.Bd.Bz) {
                this.Bg.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
                canvas.drawRoundRect(this.Bg, this.Bd.mRadius, this.Bd.mRadius, this.AW);
            } else {
                float width = imageView.getWidth() / 2.0f;
                float height = imageView.getHeight() / 2.0f;
                canvas.drawCircle(width, height, Math.min(width, height) - (this.Bd.BB / 2.0f), this.AW);
            }
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
