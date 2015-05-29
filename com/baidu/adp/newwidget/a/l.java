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
    protected BitmapShader Ck;
    protected Matrix Cj = new Matrix();
    protected RectF Cl = new RectF();

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView) {
        int width = dVar.getWidth();
        int height = dVar.getHeight();
        PointF a = a(this.Bl.left, this.Bl.top, this.Bk);
        int i = (int) a.x;
        int i2 = (int) a.y;
        PointF a2 = a(this.Bl.right, this.Bl.bottom, this.Bk);
        int i3 = (int) a2.x;
        int i4 = (int) a2.y;
        this.Cj.reset();
        this.Cj.postScale((i3 - i) / width, (i4 - i2) / height);
        this.Cj.postTranslate(i, i2);
        if (dVar.kq()) {
            this.Ck = new BitmapShader(dVar.BM.getBitmap(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        } else {
            this.Ck = dVar.BN.mY();
        }
        if (this.Ck != null) {
            this.Ck.setLocalMatrix(this.Cj);
            this.mPaint.setShader(this.Ck);
            int width2 = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            this.Cl.set(Math.max(i, 0), Math.max(i2, 0), Math.min(i3, width2), Math.min(i4, (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom()));
            if (this.Bp.BP) {
                float f = this.Bp.BQ / 2.0f;
                if (!this.Bp.BT) {
                    this.Bm.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                } else {
                    this.Bm.set(this.Cl.left + f, this.Cl.top + f, this.Cl.right - f, this.Cl.bottom - f);
                }
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        boolean kr = dVar.kr();
        if (kr) {
            dVar.BN.P(true);
        }
        if (!this.Bp.BO) {
            canvas.drawRoundRect(this.Cl, this.Bp.mRadius, this.Bp.mRadius, this.mPaint);
        } else {
            canvas.drawCircle((this.Cl.right + this.Cl.left) / 2.0f, (this.Cl.top + this.Cl.bottom) / 2.0f, Math.min(this.Cl.width(), this.Cl.height()) / 2.0f, this.mPaint);
        }
        if (kr) {
            dVar.BN.P(false);
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.Bp.BP) {
            if (!this.Bp.BO) {
                canvas.drawRoundRect(this.Bm, this.Bp.mRadius, this.Bp.mRadius, this.Bi);
            } else {
                canvas.drawCircle((this.Cl.right + this.Cl.left) / 2.0f, (this.Cl.top + this.Cl.bottom) / 2.0f, (Math.min(this.Cl.width(), this.Cl.height()) / 2.0f) - (this.Bp.BQ / 2), this.Bi);
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, ImageView imageView) {
        int scrollX;
        int scrollY;
        if (this.Bp.BX != 0) {
            canvas.translate(imageView.getScrollX(), imageView.getScrollY());
            this.Bj.setColor(this.Bp.BX);
            if (!this.Bp.BO) {
                this.Bs.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
                canvas.drawRoundRect(this.Bs, this.Bp.mRadius, this.Bp.mRadius, this.Bj);
            } else {
                float width = imageView.getWidth() / 2;
                float height = imageView.getHeight() / 2;
                canvas.drawCircle(width, height, Math.min(width, height) - (this.Bp.BQ / 2), this.Bj);
            }
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
