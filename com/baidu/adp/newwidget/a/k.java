package com.baidu.adp.newwidget.a;

import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Shader;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class k extends a {
    protected BitmapShader Ck;
    protected Matrix Cj = new Matrix();
    protected RectF Cl = new RectF();

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView) {
        int width = dVar.getWidth();
        int height = dVar.getHeight();
        PointF a = a(this.Bn.left, this.Bn.top, this.Bm);
        int i = (int) a.x;
        int i2 = (int) a.y;
        PointF a2 = a(this.Bn.right, this.Bn.bottom, this.Bm);
        int i3 = (int) a2.x;
        int i4 = (int) a2.y;
        this.Cj.reset();
        this.Cj.postScale((i3 - i) / width, (i4 - i2) / height);
        this.Cj.postTranslate(i, i2);
        if (dVar.ku()) {
            this.Ck = new BitmapShader(dVar.BM.getBitmap(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        } else {
            this.Ck = dVar.BN.mY();
        }
        if (this.Ck != null) {
            this.Ck.setLocalMatrix(this.Cj);
            this.mPaint.setShader(this.Ck);
            int width2 = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            this.Cl.set(Math.max(i, 0), Math.max(i2, 0), Math.min(i3, width2), Math.min(i4, (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom()));
            if (this.Bs.BP) {
                float f = this.Bs.BQ / 2.0f;
                if (!this.Bs.BT) {
                    this.Bo.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                } else {
                    this.Bo.set(this.Cl.left + f, this.Cl.top + f, this.Cl.right - f, this.Cl.bottom - f);
                }
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        boolean kv = dVar.kv();
        if (kv) {
            dVar.BN.N(true);
        }
        if (!this.Bs.BO) {
            canvas.drawRoundRect(this.Cl, this.Bs.mRadius, this.Bs.mRadius, this.mPaint);
        } else {
            canvas.drawCircle((this.Cl.right + this.Cl.left) / 2.0f, (this.Cl.top + this.Cl.bottom) / 2.0f, Math.min(this.Cl.width(), this.Cl.height()) / 2.0f, this.mPaint);
        }
        if (kv) {
            dVar.BN.N(false);
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.Bs.BP) {
            if (!this.Bs.BO) {
                canvas.drawRoundRect(this.Bo, this.Bs.mRadius, this.Bs.mRadius, this.Bk);
            } else {
                canvas.drawCircle((this.Cl.right + this.Cl.left) / 2.0f, (this.Cl.top + this.Cl.bottom) / 2.0f, (Math.min(this.Cl.width(), this.Cl.height()) / 2.0f) - (this.Bs.BQ / 2.0f), this.Bk);
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.Bs.BX != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.Bl.setColor(this.Bs.BX);
            if (!this.Bs.BO) {
                this.Bv.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
                canvas.drawRoundRect(this.Bv, this.Bs.mRadius, this.Bs.mRadius, this.Bl);
            } else {
                float width = imageView.getWidth() / 2.0f;
                float height = imageView.getHeight() / 2.0f;
                canvas.drawCircle(width, height, Math.min(width, height) - (this.Bs.BQ / 2.0f), this.Bl);
            }
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
