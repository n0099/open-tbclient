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
    protected BitmapShader vN;
    protected Matrix vM = new Matrix();
    protected RectF vO = new RectF();

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView) {
        int width = dVar.getWidth();
        int height = dVar.getHeight();
        PointF a = a(this.uQ.left, this.uQ.top, this.uP);
        int i = (int) a.x;
        int i2 = (int) a.y;
        PointF a2 = a(this.uQ.right, this.uQ.bottom, this.uP);
        int i3 = (int) a2.x;
        int i4 = (int) a2.y;
        this.vM.reset();
        this.vM.postScale((i3 - i) / width, (i4 - i2) / height);
        this.vM.postTranslate(i, i2);
        if (dVar.hJ()) {
            this.vN = new BitmapShader(dVar.vp.getBitmap(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        } else {
            this.vN = dVar.vq.kb();
        }
        if (this.vN != null) {
            this.vN.setLocalMatrix(this.vM);
            this.mPaint.setShader(this.vN);
            int width2 = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            this.vO.set(Math.max(i, 0), Math.max(i2, 0), Math.min(i3, width2), Math.min(i4, (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom()));
            if (this.uV.vs) {
                float f = this.uV.vt / 2.0f;
                if (!this.uV.vw) {
                    this.uR.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                } else {
                    this.uR.set(this.vO.left + f, this.vO.top + f, this.vO.right - f, this.vO.bottom - f);
                }
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        boolean hK = dVar.hK();
        if (hK) {
            dVar.vq.Q(true);
        }
        if (!this.uV.vr) {
            canvas.drawRoundRect(this.vO, this.uV.mRadius, this.uV.mRadius, this.mPaint);
        } else {
            canvas.drawCircle((this.vO.right + this.vO.left) / 2.0f, (this.vO.top + this.vO.bottom) / 2.0f, Math.min(this.vO.width(), this.vO.height()) / 2.0f, this.mPaint);
        }
        if (hK) {
            dVar.vq.Q(false);
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.uV.vs) {
            if (!this.uV.vr) {
                canvas.drawRoundRect(this.uR, this.uV.mRadius, this.uV.mRadius, this.uN);
            } else {
                canvas.drawCircle((this.vO.right + this.vO.left) / 2.0f, (this.vO.top + this.vO.bottom) / 2.0f, (Math.min(this.vO.width(), this.vO.height()) / 2.0f) - (this.uV.vt / 2.0f), this.uN);
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.uV.vA != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.uO.setColor(this.uV.vA);
            if (!this.uV.vr) {
                this.uY.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
                canvas.drawRoundRect(this.uY, this.uV.mRadius, this.uV.mRadius, this.uO);
            } else {
                float width = imageView.getWidth() / 2.0f;
                float height = imageView.getHeight() / 2.0f;
                canvas.drawCircle(width, height, Math.min(width, height) - (this.uV.vt / 2.0f), this.uO);
            }
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
