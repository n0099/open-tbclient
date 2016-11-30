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
    protected BitmapShader vO;
    protected Matrix vN = new Matrix();
    protected RectF vP = new RectF();

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView) {
        int width = dVar.getWidth();
        int height = dVar.getHeight();
        PointF a = a(this.uR.left, this.uR.top, this.uQ);
        int i = (int) a.x;
        int i2 = (int) a.y;
        PointF a2 = a(this.uR.right, this.uR.bottom, this.uQ);
        int i3 = (int) a2.x;
        int i4 = (int) a2.y;
        this.vN.reset();
        this.vN.postScale((i3 - i) / width, (i4 - i2) / height);
        this.vN.postTranslate(i, i2);
        if (dVar.hJ()) {
            this.vO = new BitmapShader(dVar.vq.getBitmap(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        } else {
            this.vO = dVar.vr.kb();
        }
        if (this.vO != null) {
            this.vO.setLocalMatrix(this.vN);
            this.mPaint.setShader(this.vO);
            int width2 = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            this.vP.set(Math.max(i, 0), Math.max(i2, 0), Math.min(i3, width2), Math.min(i4, (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom()));
            if (this.uW.vt) {
                float f = this.uW.vu / 2.0f;
                if (!this.uW.vx) {
                    this.uS.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                } else {
                    this.uS.set(this.vP.left + f, this.vP.top + f, this.vP.right - f, this.vP.bottom - f);
                }
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        boolean hK = dVar.hK();
        if (hK) {
            dVar.vr.Q(true);
        }
        if (!this.uW.vs) {
            canvas.drawRoundRect(this.vP, this.uW.mRadius, this.uW.mRadius, this.mPaint);
        } else {
            canvas.drawCircle((this.vP.right + this.vP.left) / 2.0f, (this.vP.top + this.vP.bottom) / 2.0f, Math.min(this.vP.width(), this.vP.height()) / 2.0f, this.mPaint);
        }
        if (hK) {
            dVar.vr.Q(false);
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.uW.vt) {
            if (!this.uW.vs) {
                canvas.drawRoundRect(this.uS, this.uW.mRadius, this.uW.mRadius, this.uO);
            } else {
                canvas.drawCircle((this.vP.right + this.vP.left) / 2.0f, (this.vP.top + this.vP.bottom) / 2.0f, (Math.min(this.vP.width(), this.vP.height()) / 2.0f) - (this.uW.vu / 2.0f), this.uO);
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.uW.vB != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.uP.setColor(this.uW.vB);
            if (!this.uW.vs) {
                this.uZ.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
                canvas.drawRoundRect(this.uZ, this.uW.mRadius, this.uW.mRadius, this.uP);
            } else {
                float width = imageView.getWidth() / 2.0f;
                float height = imageView.getHeight() / 2.0f;
                canvas.drawCircle(width, height, Math.min(width, height) - (this.uW.vu / 2.0f), this.uP);
            }
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
