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
    protected BitmapShader apJ;
    protected Matrix wD = new Matrix();
    protected RectF apK = new RectF();

    @Override // com.baidu.adp.b.a.a
    public void a(d dVar, ImageView imageView) {
        int width = dVar.getWidth();
        int height = dVar.getHeight();
        PointF a = a(this.apf.left, this.apf.top, this.ape);
        int i = (int) a.x;
        int i2 = (int) a.y;
        PointF a2 = a(this.apf.right, this.apf.bottom, this.ape);
        int i3 = (int) a2.x;
        int i4 = (int) a2.y;
        this.wD.reset();
        this.wD.postScale((i3 - i) / width, (i4 - i2) / height);
        this.wD.postTranslate(i, i2);
        if (dVar.pZ()) {
            this.apJ = new BitmapShader(dVar.apn.getBitmap(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        } else {
            this.apJ = dVar.apo.so();
        }
        if (this.apJ != null) {
            this.apJ.setLocalMatrix(this.wD);
            this.mPaint.setShader(this.apJ);
            int width2 = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            this.apK.set(Math.max(i, 0), Math.max(i2, 0), Math.min(i3, width2), Math.min(i4, (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom()));
            if (this.mArgs.apr) {
                float f = this.mArgs.ou / 2.0f;
                if (!this.mArgs.apt) {
                    this.apg.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                } else {
                    this.apg.set(this.apK.left + f, this.apK.top + f, this.apK.right - f, this.apK.bottom - f);
                }
            }
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        boolean qa = dVar.qa();
        if (qa) {
            dVar.apo.ay(true);
        }
        if (!this.mArgs.apq) {
            canvas.drawRoundRect(this.apK, this.mArgs.mRadius, this.mArgs.mRadius, this.mPaint);
        } else {
            canvas.drawCircle((this.apK.right + this.apK.left) / 2.0f, (this.apK.top + this.apK.bottom) / 2.0f, Math.min(this.apK.width(), this.apK.height()) / 2.0f, this.mPaint);
        }
        if (qa) {
            dVar.apo.ay(false);
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.mArgs.apr) {
            if (!this.mArgs.apq) {
                canvas.drawRoundRect(this.apg, this.mArgs.mRadius, this.mArgs.mRadius, this.apc);
            } else {
                canvas.drawCircle((this.apK.right + this.apK.left) / 2.0f, (this.apK.top + this.apK.bottom) / 2.0f, (Math.min(this.apK.width(), this.apK.height()) / 2.0f) - (this.mArgs.ou / 2.0f), this.apc);
            }
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.mArgs.apx != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.apd.setColor(this.mArgs.apx);
            if (!this.mArgs.apq) {
                this.apl.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
                canvas.drawRoundRect(this.apl, this.mArgs.mRadius, this.mArgs.mRadius, this.apd);
            } else {
                float width = imageView.getWidth() / 2.0f;
                float height = imageView.getHeight() / 2.0f;
                canvas.drawCircle(width, height, Math.min(width, height) - (this.mArgs.ou / 2.0f), this.apd);
            }
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
