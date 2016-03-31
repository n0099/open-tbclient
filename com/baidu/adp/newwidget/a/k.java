package com.baidu.adp.newwidget.a;

import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Shader;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class k extends a {
    protected BitmapShader CF;
    protected Matrix CE = new Matrix();
    protected RectF CG = new RectF();

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView) {
        int width = dVar.getWidth();
        int height = dVar.getHeight();
        PointF a = a(this.BI.left, this.BI.top, this.BH);
        int i = (int) a.x;
        int i2 = (int) a.y;
        PointF a2 = a(this.BI.right, this.BI.bottom, this.BH);
        int i3 = (int) a2.x;
        int i4 = (int) a2.y;
        this.CE.reset();
        this.CE.postScale((i3 - i) / width, (i4 - i2) / height);
        this.CE.postTranslate(i, i2);
        if (dVar.kA()) {
            this.CF = new BitmapShader(dVar.Ch.getBitmap(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        } else {
            this.CF = dVar.Ci.mQ();
        }
        if (this.CF != null) {
            this.CF.setLocalMatrix(this.CE);
            this.mPaint.setShader(this.CF);
            int width2 = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            this.CG.set(Math.max(i, 0), Math.max(i2, 0), Math.min(i3, width2), Math.min(i4, (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom()));
            if (this.BN.Ck) {
                float f = this.BN.Cl / 2.0f;
                if (!this.BN.Co) {
                    this.BJ.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                } else {
                    this.BJ.set(this.CG.left + f, this.CG.top + f, this.CG.right - f, this.CG.bottom - f);
                }
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        boolean kB = dVar.kB();
        if (kB) {
            dVar.Ci.M(true);
        }
        if (!this.BN.Cj) {
            canvas.drawRoundRect(this.CG, this.BN.mRadius, this.BN.mRadius, this.mPaint);
        } else {
            canvas.drawCircle((this.CG.right + this.CG.left) / 2.0f, (this.CG.top + this.CG.bottom) / 2.0f, Math.min(this.CG.width(), this.CG.height()) / 2.0f, this.mPaint);
        }
        if (kB) {
            dVar.Ci.M(false);
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.BN.Ck) {
            if (!this.BN.Cj) {
                canvas.drawRoundRect(this.BJ, this.BN.mRadius, this.BN.mRadius, this.BF);
            } else {
                canvas.drawCircle((this.CG.right + this.CG.left) / 2.0f, (this.CG.top + this.CG.bottom) / 2.0f, (Math.min(this.CG.width(), this.CG.height()) / 2.0f) - (this.BN.Cl / 2.0f), this.BF);
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.BN.Cs != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.BG.setColor(this.BN.Cs);
            if (!this.BN.Cj) {
                this.BQ.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
                canvas.drawRoundRect(this.BQ, this.BN.mRadius, this.BN.mRadius, this.BG);
            } else {
                float width = imageView.getWidth() / 2.0f;
                float height = imageView.getHeight() / 2.0f;
                canvas.drawCircle(width, height, Math.min(width, height) - (this.BN.Cl / 2.0f), this.BG);
            }
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
