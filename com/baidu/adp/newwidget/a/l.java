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
    protected BitmapShader CT;
    protected Matrix CS = new Matrix();
    protected RectF CU = new RectF();

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView) {
        int width = dVar.getWidth();
        int height = dVar.getHeight();
        PointF a = a(this.BW.left, this.BW.top, this.BV);
        int i = (int) a.x;
        int i2 = (int) a.y;
        PointF a2 = a(this.BW.right, this.BW.bottom, this.BV);
        int i3 = (int) a2.x;
        int i4 = (int) a2.y;
        this.CS.reset();
        this.CS.postScale((i3 - i) / width, (i4 - i2) / height);
        this.CS.postTranslate(i, i2);
        if (dVar.iB()) {
            this.CT = new BitmapShader(dVar.Cv.getBitmap(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        } else {
            this.CT = dVar.Cw.kT();
        }
        if (this.CT != null) {
            this.CT.setLocalMatrix(this.CS);
            this.mPaint.setShader(this.CT);
            int width2 = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            this.CU.set(Math.max(i, 0), Math.max(i2, 0), Math.min(i3, width2), Math.min(i4, (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom()));
            if (this.Cb.Cy) {
                float f = this.Cb.Cz / 2.0f;
                if (!this.Cb.CC) {
                    this.BX.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                } else {
                    this.BX.set(this.CU.left + f, this.CU.top + f, this.CU.right - f, this.CU.bottom - f);
                }
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        boolean iC = dVar.iC();
        if (iC) {
            dVar.Cw.R(true);
        }
        if (!this.Cb.Cx) {
            canvas.drawRoundRect(this.CU, this.Cb.mRadius, this.Cb.mRadius, this.mPaint);
        } else {
            canvas.drawCircle((this.CU.right + this.CU.left) / 2.0f, (this.CU.top + this.CU.bottom) / 2.0f, Math.min(this.CU.width(), this.CU.height()) / 2.0f, this.mPaint);
        }
        if (iC) {
            dVar.Cw.R(false);
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.Cb.Cy) {
            if (!this.Cb.Cx) {
                canvas.drawRoundRect(this.BX, this.Cb.mRadius, this.Cb.mRadius, this.BT);
            } else {
                canvas.drawCircle((this.CU.right + this.CU.left) / 2.0f, (this.CU.top + this.CU.bottom) / 2.0f, (Math.min(this.CU.width(), this.CU.height()) / 2.0f) - (this.Cb.Cz / 2.0f), this.BT);
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.Cb.CG != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.BU.setColor(this.Cb.CG);
            if (!this.Cb.Cx) {
                this.Ce.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
                canvas.drawRoundRect(this.Ce, this.Cb.mRadius, this.Cb.mRadius, this.BU);
            } else {
                float width = imageView.getWidth() / 2.0f;
                float height = imageView.getHeight() / 2.0f;
                canvas.drawCircle(width, height, Math.min(width, height) - (this.Cb.Cz / 2.0f), this.BU);
            }
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
