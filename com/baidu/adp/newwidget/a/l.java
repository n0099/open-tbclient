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
    protected BitmapShader tA;
    protected Matrix tz = new Matrix();
    protected RectF tB = new RectF();

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView) {
        int width = dVar.getWidth();
        int height = dVar.getHeight();
        PointF a = a(this.sA.left, this.sA.top, this.sz);
        int i = (int) a.x;
        int i2 = (int) a.y;
        PointF a2 = a(this.sA.right, this.sA.bottom, this.sz);
        int i3 = (int) a2.x;
        int i4 = (int) a2.y;
        this.tz.reset();
        this.tz.postScale((i3 - i) / width, (i4 - i2) / height);
        this.tz.postTranslate(i, i2);
        if (dVar.gO()) {
            this.tA = new BitmapShader(dVar.sZ.getBitmap(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        } else {
            this.tA = dVar.tb.jg();
        }
        if (this.tA != null) {
            this.tA.setLocalMatrix(this.tz);
            this.mPaint.setShader(this.tA);
            int width2 = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            this.tB.set(Math.max(i, 0), Math.max(i2, 0), Math.min(i3, width2), Math.min(i4, (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom()));
            if (this.sF.td) {
                float f = this.sF.te / 2.0f;
                if (!this.sF.th) {
                    this.sB.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                } else {
                    this.sB.set(this.tB.left + f, this.tB.top + f, this.tB.right - f, this.tB.bottom - f);
                }
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        boolean gP = dVar.gP();
        if (gP) {
            dVar.tb.O(true);
        }
        if (!this.sF.tc) {
            canvas.drawRoundRect(this.tB, this.sF.mRadius, this.sF.mRadius, this.mPaint);
        } else {
            canvas.drawCircle((this.tB.right + this.tB.left) / 2.0f, (this.tB.top + this.tB.bottom) / 2.0f, Math.min(this.tB.width(), this.tB.height()) / 2.0f, this.mPaint);
        }
        if (gP) {
            dVar.tb.O(false);
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.sF.td) {
            if (!this.sF.tc) {
                canvas.drawRoundRect(this.sB, this.sF.mRadius, this.sF.mRadius, this.sx);
            } else {
                canvas.drawCircle((this.tB.right + this.tB.left) / 2.0f, (this.tB.top + this.tB.bottom) / 2.0f, (Math.min(this.tB.width(), this.tB.height()) / 2.0f) - (this.sF.te / 2.0f), this.sx);
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.sF.tl != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.sy.setColor(this.sF.tl);
            if (!this.sF.tc) {
                this.sI.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
                canvas.drawRoundRect(this.sI, this.sF.mRadius, this.sF.mRadius, this.sy);
            } else {
                float width = imageView.getWidth() / 2.0f;
                float height = imageView.getHeight() / 2.0f;
                canvas.drawCircle(width, height, Math.min(width, height) - (this.sF.te / 2.0f), this.sy);
            }
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
