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
    protected BitmapShader BF;
    protected Matrix BE = new Matrix();
    protected RectF BG = new RectF();

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
        this.BE.reset();
        this.BE.postScale((i3 - i) / width, (i4 - i2) / height);
        this.BE.postTranslate(i, i2);
        if (dVar.iA()) {
            this.BF = new BitmapShader(dVar.Bh.getBitmap(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        } else {
            this.BF = dVar.Bi.kQ();
        }
        if (this.BF != null) {
            this.BF.setLocalMatrix(this.BE);
            this.mPaint.setShader(this.BF);
            int width2 = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            this.BG.set(Math.max(i, 0), Math.max(i2, 0), Math.min(i3, width2), Math.min(i4, (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom()));
            if (this.mArgs.Bk) {
                float f = this.mArgs.Bl / 2.0f;
                if (!this.mArgs.Bo) {
                    this.AZ.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                } else {
                    this.AZ.set(this.BG.left + f, this.BG.top + f, this.BG.right - f, this.BG.bottom - f);
                }
            }
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        boolean iB = dVar.iB();
        if (iB) {
            dVar.Bi.S(true);
        }
        if (!this.mArgs.Bj) {
            canvas.drawRoundRect(this.BG, this.mArgs.mRadius, this.mArgs.mRadius, this.mPaint);
        } else {
            canvas.drawCircle((this.BG.right + this.BG.left) / 2.0f, (this.BG.top + this.BG.bottom) / 2.0f, Math.min(this.BG.width(), this.BG.height()) / 2.0f, this.mPaint);
        }
        if (iB) {
            dVar.Bi.S(false);
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.mArgs.Bk) {
            if (!this.mArgs.Bj) {
                canvas.drawRoundRect(this.AZ, this.mArgs.mRadius, this.mArgs.mRadius, this.AV);
            } else {
                canvas.drawCircle((this.BG.right + this.BG.left) / 2.0f, (this.BG.top + this.BG.bottom) / 2.0f, (Math.min(this.BG.width(), this.BG.height()) / 2.0f) - (this.mArgs.Bl / 2.0f), this.AV);
            }
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.mArgs.Bs != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.AW.setColor(this.mArgs.Bs);
            if (!this.mArgs.Bj) {
                this.Bf.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
                canvas.drawRoundRect(this.Bf, this.mArgs.mRadius, this.mArgs.mRadius, this.AW);
            } else {
                float width = imageView.getWidth() / 2.0f;
                float height = imageView.getHeight() / 2.0f;
                canvas.drawCircle(width, height, Math.min(width, height) - (this.mArgs.Bl / 2.0f), this.AW);
            }
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
