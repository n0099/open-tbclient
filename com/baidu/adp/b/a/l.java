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
    protected BitmapShader Cx;
    protected Matrix Cw = new Matrix();
    protected RectF Cy = new RectF();

    @Override // com.baidu.adp.b.a.a
    public void a(d dVar, ImageView imageView) {
        int width = dVar.getWidth();
        int height = dVar.getHeight();
        PointF a = a(this.BA.left, this.BA.top, this.Bz);
        int i = (int) a.x;
        int i2 = (int) a.y;
        PointF a2 = a(this.BA.right, this.BA.bottom, this.Bz);
        int i3 = (int) a2.x;
        int i4 = (int) a2.y;
        this.Cw.reset();
        this.Cw.postScale((i3 - i) / width, (i4 - i2) / height);
        this.Cw.postTranslate(i, i2);
        if (dVar.iC()) {
            this.Cx = new BitmapShader(dVar.BZ.getBitmap(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        } else {
            this.Cx = dVar.Ca.kT();
        }
        if (this.Cx != null) {
            this.Cx.setLocalMatrix(this.Cw);
            this.mPaint.setShader(this.Cx);
            int width2 = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            this.Cy.set(Math.max(i, 0), Math.max(i2, 0), Math.min(i3, width2), Math.min(i4, (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom()));
            if (this.BF.Cc) {
                float f = this.BF.Cd / 2.0f;
                if (!this.BF.Cg) {
                    this.BB.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                } else {
                    this.BB.set(this.Cy.left + f, this.Cy.top + f, this.Cy.right - f, this.Cy.bottom - f);
                }
            }
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        boolean iD = dVar.iD();
        if (iD) {
            dVar.Ca.R(true);
        }
        if (!this.BF.Cb) {
            canvas.drawRoundRect(this.Cy, this.BF.mRadius, this.BF.mRadius, this.mPaint);
        } else {
            canvas.drawCircle((this.Cy.right + this.Cy.left) / 2.0f, (this.Cy.top + this.Cy.bottom) / 2.0f, Math.min(this.Cy.width(), this.Cy.height()) / 2.0f, this.mPaint);
        }
        if (iD) {
            dVar.Ca.R(false);
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.BF.Cc) {
            if (!this.BF.Cb) {
                canvas.drawRoundRect(this.BB, this.BF.mRadius, this.BF.mRadius, this.Bx);
            } else {
                canvas.drawCircle((this.Cy.right + this.Cy.left) / 2.0f, (this.Cy.top + this.Cy.bottom) / 2.0f, (Math.min(this.Cy.width(), this.Cy.height()) / 2.0f) - (this.BF.Cd / 2.0f), this.Bx);
            }
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.BF.Ck != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.By.setColor(this.BF.Ck);
            if (!this.BF.Cb) {
                this.BI.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
                canvas.drawRoundRect(this.BI, this.BF.mRadius, this.BF.mRadius, this.By);
            } else {
                float width = imageView.getWidth() / 2.0f;
                float height = imageView.getHeight() / 2.0f;
                canvas.drawCircle(width, height, Math.min(width, height) - (this.BF.Cd / 2.0f), this.By);
            }
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
