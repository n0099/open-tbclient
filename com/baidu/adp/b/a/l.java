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
    protected BitmapShader apM;
    protected Matrix wD = new Matrix();
    protected RectF apN = new RectF();

    @Override // com.baidu.adp.b.a.a
    public void a(d dVar, ImageView imageView) {
        int width = dVar.getWidth();
        int height = dVar.getHeight();
        PointF a = a(this.api.left, this.api.top, this.aph);
        int i = (int) a.x;
        int i2 = (int) a.y;
        PointF a2 = a(this.api.right, this.api.bottom, this.aph);
        int i3 = (int) a2.x;
        int i4 = (int) a2.y;
        this.wD.reset();
        this.wD.postScale((i3 - i) / width, (i4 - i2) / height);
        this.wD.postTranslate(i, i2);
        if (dVar.qa()) {
            this.apM = new BitmapShader(dVar.apr.getBitmap(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        } else {
            this.apM = dVar.aps.sp();
        }
        if (this.apM != null) {
            this.apM.setLocalMatrix(this.wD);
            this.mPaint.setShader(this.apM);
            int width2 = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            this.apN.set(Math.max(i, 0), Math.max(i2, 0), Math.min(i3, width2), Math.min(i4, (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom()));
            if (this.mArgs.apu) {
                float f = this.mArgs.ou / 2.0f;
                if (!this.mArgs.apw) {
                    this.apj.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                } else {
                    this.apj.set(this.apN.left + f, this.apN.top + f, this.apN.right - f, this.apN.bottom - f);
                }
            }
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        boolean qb = dVar.qb();
        if (qb) {
            dVar.aps.az(true);
        }
        if (!this.mArgs.apt) {
            canvas.drawRoundRect(this.apN, this.mArgs.mRadius, this.mArgs.mRadius, this.mPaint);
        } else {
            canvas.drawCircle((this.apN.right + this.apN.left) / 2.0f, (this.apN.top + this.apN.bottom) / 2.0f, Math.min(this.apN.width(), this.apN.height()) / 2.0f, this.mPaint);
        }
        if (qb) {
            dVar.aps.az(false);
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.mArgs.apu) {
            if (!this.mArgs.apt) {
                canvas.drawRoundRect(this.apj, this.mArgs.mRadius, this.mArgs.mRadius, this.apf);
            } else {
                canvas.drawCircle((this.apN.right + this.apN.left) / 2.0f, (this.apN.top + this.apN.bottom) / 2.0f, (Math.min(this.apN.width(), this.apN.height()) / 2.0f) - (this.mArgs.ou / 2.0f), this.apf);
            }
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.mArgs.apA != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.apg.setColor(this.mArgs.apA);
            if (!this.mArgs.apt) {
                this.apo.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
                canvas.drawRoundRect(this.apo, this.mArgs.mRadius, this.mArgs.mRadius, this.apg);
            } else {
                float width = imageView.getWidth() / 2.0f;
                float height = imageView.getHeight() / 2.0f;
                canvas.drawCircle(width, height, Math.min(width, height) - (this.mArgs.ou / 2.0f), this.apg);
            }
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
