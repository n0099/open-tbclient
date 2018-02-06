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
    protected BitmapShader apL;
    protected Matrix wD = new Matrix();
    protected RectF apM = new RectF();

    @Override // com.baidu.adp.b.a.a
    public void a(d dVar, ImageView imageView) {
        int width = dVar.getWidth();
        int height = dVar.getHeight();
        PointF a = a(this.aph.left, this.aph.top, this.apg);
        int i = (int) a.x;
        int i2 = (int) a.y;
        PointF a2 = a(this.aph.right, this.aph.bottom, this.apg);
        int i3 = (int) a2.x;
        int i4 = (int) a2.y;
        this.wD.reset();
        this.wD.postScale((i3 - i) / width, (i4 - i2) / height);
        this.wD.postTranslate(i, i2);
        if (dVar.qa()) {
            this.apL = new BitmapShader(dVar.apq.getBitmap(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        } else {
            this.apL = dVar.apr.sn();
        }
        if (this.apL != null) {
            this.apL.setLocalMatrix(this.wD);
            this.mPaint.setShader(this.apL);
            int width2 = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            this.apM.set(Math.max(i, 0), Math.max(i2, 0), Math.min(i3, width2), Math.min(i4, (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom()));
            if (this.mArgs.apt) {
                float f = this.mArgs.ou / 2.0f;
                if (!this.mArgs.apv) {
                    this.api.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                } else {
                    this.api.set(this.apM.left + f, this.apM.top + f, this.apM.right - f, this.apM.bottom - f);
                }
            }
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        boolean qb = dVar.qb();
        if (qb) {
            dVar.apr.aC(true);
        }
        if (!this.mArgs.aps) {
            canvas.drawRoundRect(this.apM, this.mArgs.mRadius, this.mArgs.mRadius, this.mPaint);
        } else {
            canvas.drawCircle((this.apM.right + this.apM.left) / 2.0f, (this.apM.top + this.apM.bottom) / 2.0f, Math.min(this.apM.width(), this.apM.height()) / 2.0f, this.mPaint);
        }
        if (qb) {
            dVar.apr.aC(false);
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.mArgs.apt) {
            if (!this.mArgs.aps) {
                canvas.drawRoundRect(this.api, this.mArgs.mRadius, this.mArgs.mRadius, this.ape);
            } else {
                canvas.drawCircle((this.apM.right + this.apM.left) / 2.0f, (this.apM.top + this.apM.bottom) / 2.0f, (Math.min(this.apM.width(), this.apM.height()) / 2.0f) - (this.mArgs.ou / 2.0f), this.ape);
            }
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.mArgs.apz != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.apf.setColor(this.mArgs.apz);
            if (!this.mArgs.aps) {
                this.apn.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
                canvas.drawRoundRect(this.apn, this.mArgs.mRadius, this.mArgs.mRadius, this.apf);
            } else {
                float width = imageView.getWidth() / 2.0f;
                float height = imageView.getHeight() / 2.0f;
                canvas.drawCircle(width, height, Math.min(width, height) - (this.mArgs.ou / 2.0f), this.apf);
            }
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
