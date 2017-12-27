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
    protected BitmapShader apK;
    protected Matrix wD = new Matrix();
    protected RectF apL = new RectF();

    @Override // com.baidu.adp.b.a.a
    public void a(d dVar, ImageView imageView) {
        int width = dVar.getWidth();
        int height = dVar.getHeight();
        PointF a = a(this.apg.left, this.apg.top, this.apf);
        int i = (int) a.x;
        int i2 = (int) a.y;
        PointF a2 = a(this.apg.right, this.apg.bottom, this.apf);
        int i3 = (int) a2.x;
        int i4 = (int) a2.y;
        this.wD.reset();
        this.wD.postScale((i3 - i) / width, (i4 - i2) / height);
        this.wD.postTranslate(i, i2);
        if (dVar.pZ()) {
            this.apK = new BitmapShader(dVar.apo.getBitmap(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        } else {
            this.apK = dVar.apq.so();
        }
        if (this.apK != null) {
            this.apK.setLocalMatrix(this.wD);
            this.mPaint.setShader(this.apK);
            int width2 = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            this.apL.set(Math.max(i, 0), Math.max(i2, 0), Math.min(i3, width2), Math.min(i4, (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom()));
            if (this.mArgs.aps) {
                float f = this.mArgs.ou / 2.0f;
                if (!this.mArgs.apu) {
                    this.aph.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                } else {
                    this.aph.set(this.apL.left + f, this.apL.top + f, this.apL.right - f, this.apL.bottom - f);
                }
            }
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        boolean qa = dVar.qa();
        if (qa) {
            dVar.apq.ay(true);
        }
        if (!this.mArgs.apr) {
            canvas.drawRoundRect(this.apL, this.mArgs.mRadius, this.mArgs.mRadius, this.mPaint);
        } else {
            canvas.drawCircle((this.apL.right + this.apL.left) / 2.0f, (this.apL.top + this.apL.bottom) / 2.0f, Math.min(this.apL.width(), this.apL.height()) / 2.0f, this.mPaint);
        }
        if (qa) {
            dVar.apq.ay(false);
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.mArgs.aps) {
            if (!this.mArgs.apr) {
                canvas.drawRoundRect(this.aph, this.mArgs.mRadius, this.mArgs.mRadius, this.apd);
            } else {
                canvas.drawCircle((this.apL.right + this.apL.left) / 2.0f, (this.apL.top + this.apL.bottom) / 2.0f, (Math.min(this.apL.width(), this.apL.height()) / 2.0f) - (this.mArgs.ou / 2.0f), this.apd);
            }
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.mArgs.apy != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.ape.setColor(this.mArgs.apy);
            if (!this.mArgs.apr) {
                this.apm.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
                canvas.drawRoundRect(this.apm, this.mArgs.mRadius, this.mArgs.mRadius, this.ape);
            } else {
                float width = imageView.getWidth() / 2.0f;
                float height = imageView.getHeight() / 2.0f;
                canvas.drawCircle(width, height, Math.min(width, height) - (this.mArgs.ou / 2.0f), this.ape);
            }
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
