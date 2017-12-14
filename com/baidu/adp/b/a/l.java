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
    protected BitmapShader BE;
    protected Matrix BD = new Matrix();
    protected RectF BF = new RectF();

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
        this.BD.reset();
        this.BD.postScale((i3 - i) / width, (i4 - i2) / height);
        this.BD.postTranslate(i, i2);
        if (dVar.iA()) {
            this.BE = new BitmapShader(dVar.Bg.getBitmap(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        } else {
            this.BE = dVar.Bh.kQ();
        }
        if (this.BE != null) {
            this.BE.setLocalMatrix(this.BD);
            this.mPaint.setShader(this.BE);
            int width2 = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            this.BF.set(Math.max(i, 0), Math.max(i2, 0), Math.min(i3, width2), Math.min(i4, (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom()));
            if (this.mArgs.Bj) {
                float f = this.mArgs.Bk / 2.0f;
                if (!this.mArgs.Bn) {
                    this.AY.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                } else {
                    this.AY.set(this.BF.left + f, this.BF.top + f, this.BF.right - f, this.BF.bottom - f);
                }
            }
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        boolean iB = dVar.iB();
        if (iB) {
            dVar.Bh.S(true);
        }
        if (!this.mArgs.Bi) {
            canvas.drawRoundRect(this.BF, this.mArgs.mRadius, this.mArgs.mRadius, this.mPaint);
        } else {
            canvas.drawCircle((this.BF.right + this.BF.left) / 2.0f, (this.BF.top + this.BF.bottom) / 2.0f, Math.min(this.BF.width(), this.BF.height()) / 2.0f, this.mPaint);
        }
        if (iB) {
            dVar.Bh.S(false);
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.mArgs.Bj) {
            if (!this.mArgs.Bi) {
                canvas.drawRoundRect(this.AY, this.mArgs.mRadius, this.mArgs.mRadius, this.AU);
            } else {
                canvas.drawCircle((this.BF.right + this.BF.left) / 2.0f, (this.BF.top + this.BF.bottom) / 2.0f, (Math.min(this.BF.width(), this.BF.height()) / 2.0f) - (this.mArgs.Bk / 2.0f), this.AU);
            }
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.mArgs.Br != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.AV.setColor(this.mArgs.Br);
            if (!this.mArgs.Bi) {
                this.Be.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
                canvas.drawRoundRect(this.Be, this.mArgs.mRadius, this.mArgs.mRadius, this.AV);
            } else {
                float width = imageView.getWidth() / 2.0f;
                float height = imageView.getHeight() / 2.0f;
                canvas.drawCircle(width, height, Math.min(width, height) - (this.mArgs.Bk / 2.0f), this.AV);
            }
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
