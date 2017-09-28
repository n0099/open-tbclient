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
    protected BitmapShader BU;
    protected Matrix BT = new Matrix();
    protected RectF BV = new RectF();

    @Override // com.baidu.adp.b.a.a
    public void a(d dVar, ImageView imageView) {
        int width = dVar.getWidth();
        int height = dVar.getHeight();
        PointF a = a(this.AX.left, this.AX.top, this.AW);
        int i = (int) a.x;
        int i2 = (int) a.y;
        PointF a2 = a(this.AX.right, this.AX.bottom, this.AW);
        int i3 = (int) a2.x;
        int i4 = (int) a2.y;
        this.BT.reset();
        this.BT.postScale((i3 - i) / width, (i4 - i2) / height);
        this.BT.postTranslate(i, i2);
        if (dVar.iD()) {
            this.BU = new BitmapShader(dVar.Bw.getBitmap(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        } else {
            this.BU = dVar.Bx.kT();
        }
        if (this.BU != null) {
            this.BU.setLocalMatrix(this.BT);
            this.mPaint.setShader(this.BU);
            int width2 = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            this.BV.set(Math.max(i, 0), Math.max(i2, 0), Math.min(i3, width2), Math.min(i4, (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom()));
            if (this.Bc.Bz) {
                float f = this.Bc.BA / 2.0f;
                if (!this.Bc.BD) {
                    this.AY.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                } else {
                    this.AY.set(this.BV.left + f, this.BV.top + f, this.BV.right - f, this.BV.bottom - f);
                }
            }
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        boolean iE = dVar.iE();
        if (iE) {
            dVar.Bx.S(true);
        }
        if (!this.Bc.By) {
            canvas.drawRoundRect(this.BV, this.Bc.mRadius, this.Bc.mRadius, this.mPaint);
        } else {
            canvas.drawCircle((this.BV.right + this.BV.left) / 2.0f, (this.BV.top + this.BV.bottom) / 2.0f, Math.min(this.BV.width(), this.BV.height()) / 2.0f, this.mPaint);
        }
        if (iE) {
            dVar.Bx.S(false);
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.Bc.Bz) {
            if (!this.Bc.By) {
                canvas.drawRoundRect(this.AY, this.Bc.mRadius, this.Bc.mRadius, this.AU);
            } else {
                canvas.drawCircle((this.BV.right + this.BV.left) / 2.0f, (this.BV.top + this.BV.bottom) / 2.0f, (Math.min(this.BV.width(), this.BV.height()) / 2.0f) - (this.Bc.BA / 2.0f), this.AU);
            }
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.Bc.BH != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.AV.setColor(this.Bc.BH);
            if (!this.Bc.By) {
                this.Bf.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
                canvas.drawRoundRect(this.Bf, this.Bc.mRadius, this.Bc.mRadius, this.AV);
            } else {
                float width = imageView.getWidth() / 2.0f;
                float height = imageView.getHeight() / 2.0f;
                canvas.drawCircle(width, height, Math.min(width, height) - (this.Bc.BA / 2.0f), this.AV);
            }
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
