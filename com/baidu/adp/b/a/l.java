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
    protected BitmapShader BS;
    protected Matrix BR = new Matrix();
    protected RectF BT = new RectF();

    @Override // com.baidu.adp.b.a.a
    public void a(d dVar, ImageView imageView) {
        int width = dVar.getWidth();
        int height = dVar.getHeight();
        PointF a = a(this.AV.left, this.AV.top, this.AU);
        int i = (int) a.x;
        int i2 = (int) a.y;
        PointF a2 = a(this.AV.right, this.AV.bottom, this.AU);
        int i3 = (int) a2.x;
        int i4 = (int) a2.y;
        this.BR.reset();
        this.BR.postScale((i3 - i) / width, (i4 - i2) / height);
        this.BR.postTranslate(i, i2);
        if (dVar.iE()) {
            this.BS = new BitmapShader(dVar.Bu.getBitmap(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        } else {
            this.BS = dVar.Bv.kU();
        }
        if (this.BS != null) {
            this.BS.setLocalMatrix(this.BR);
            this.mPaint.setShader(this.BS);
            int width2 = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            this.BT.set(Math.max(i, 0), Math.max(i2, 0), Math.min(i3, width2), Math.min(i4, (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom()));
            if (this.Ba.Bx) {
                float f = this.Ba.By / 2.0f;
                if (!this.Ba.BB) {
                    this.AW.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                } else {
                    this.AW.set(this.BT.left + f, this.BT.top + f, this.BT.right - f, this.BT.bottom - f);
                }
            }
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        boolean iF = dVar.iF();
        if (iF) {
            dVar.Bv.S(true);
        }
        if (!this.Ba.Bw) {
            canvas.drawRoundRect(this.BT, this.Ba.mRadius, this.Ba.mRadius, this.mPaint);
        } else {
            canvas.drawCircle((this.BT.right + this.BT.left) / 2.0f, (this.BT.top + this.BT.bottom) / 2.0f, Math.min(this.BT.width(), this.BT.height()) / 2.0f, this.mPaint);
        }
        if (iF) {
            dVar.Bv.S(false);
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.Ba.Bx) {
            if (!this.Ba.Bw) {
                canvas.drawRoundRect(this.AW, this.Ba.mRadius, this.Ba.mRadius, this.AS);
            } else {
                canvas.drawCircle((this.BT.right + this.BT.left) / 2.0f, (this.BT.top + this.BT.bottom) / 2.0f, (Math.min(this.BT.width(), this.BT.height()) / 2.0f) - (this.Ba.By / 2.0f), this.AS);
            }
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.Ba.BF != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.AT.setColor(this.Ba.BF);
            if (!this.Ba.Bw) {
                this.Bd.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
                canvas.drawRoundRect(this.Bd, this.Ba.mRadius, this.Ba.mRadius, this.AT);
            } else {
                float width = imageView.getWidth() / 2.0f;
                float height = imageView.getHeight() / 2.0f;
                canvas.drawCircle(width, height, Math.min(width, height) - (this.Ba.By / 2.0f), this.AT);
            }
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
