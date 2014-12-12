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
    protected BitmapShader rD;
    protected Matrix rC = new Matrix();
    protected RectF rE = new RectF();

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView) {
        int width = dVar.getWidth();
        int height = dVar.getHeight();
        PointF a = a(this.qD.left, this.qD.top, this.qC);
        int i = (int) a.x;
        int i2 = (int) a.y;
        PointF a2 = a(this.qD.right, this.qD.bottom, this.qC);
        int i3 = (int) a2.x;
        int i4 = (int) a2.y;
        this.rC.reset();
        this.rC.postScale((i3 - i) / width, (i4 - i2) / height);
        this.rC.postTranslate(i, i2);
        if (dVar.gE()) {
            this.rD = new BitmapShader(dVar.re.getBitmap(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        } else {
            this.rD = dVar.rf.jo();
        }
        if (this.rD != null) {
            this.rD.setLocalMatrix(this.rC);
            this.mPaint.setShader(this.rD);
            int width2 = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            this.rE.set(Math.max(i, 0), Math.max(i2, 0), Math.min(i3, width2), Math.min(i4, (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom()));
            if (this.qH.rh) {
                float f = this.qH.ri / 2.0f;
                if (!this.qH.rl) {
                    this.qE.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                } else {
                    this.qE.set(this.rE.left + f, this.rE.top + f, this.rE.right - f, this.rE.bottom - f);
                }
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        boolean gF = dVar.gF();
        if (gF) {
            dVar.rf.P(true);
        }
        if (!this.qH.rg) {
            canvas.drawRoundRect(this.rE, this.qH.mRadius, this.qH.mRadius, this.mPaint);
        } else {
            canvas.drawCircle((this.rE.right + this.rE.left) / 2.0f, (this.rE.top + this.rE.bottom) / 2.0f, Math.min(this.rE.width(), this.rE.height()) / 2.0f, this.mPaint);
        }
        if (gF) {
            dVar.rf.P(false);
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.qH.rh) {
            if (!this.qH.rg) {
                canvas.drawRoundRect(this.qE, this.qH.mRadius, this.qH.mRadius, this.qA);
            } else {
                canvas.drawCircle((this.rE.right + this.rE.left) / 2.0f, (this.rE.top + this.rE.bottom) / 2.0f, (Math.min(this.rE.width(), this.rE.height()) / 2.0f) - (this.qH.ri / 2), this.qA);
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, ImageView imageView) {
        int scrollX;
        int scrollY;
        if (this.qH.rq != 0) {
            canvas.translate(imageView.getScrollX(), imageView.getScrollY());
            this.qB.setColor(this.qH.rq);
            if (!this.qH.rg) {
                this.qK.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
                canvas.drawRoundRect(this.qK, this.qH.mRadius, this.qH.mRadius, this.qB);
            } else {
                float width = imageView.getWidth() / 2;
                float height = imageView.getHeight() / 2;
                canvas.drawCircle(width, height, Math.min(width, height) - (this.qH.ri / 2), this.qB);
            }
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
