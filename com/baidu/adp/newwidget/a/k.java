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
    protected BitmapShader BT;
    protected Matrix BS = new Matrix();
    protected RectF BU = new RectF();

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView) {
        int width = dVar.getWidth();
        int height = dVar.getHeight();
        PointF a = a(this.AX.left, this.AX.top, this.AW);
        int i = (int) a.x;
        int i2 = (int) a.y;
        PointF a2 = a(this.AX.right, this.AX.bottom, this.AW);
        int i3 = (int) a2.x;
        int i4 = (int) a2.y;
        this.BS.reset();
        this.BS.postScale((i3 - i) / width, (i4 - i2) / height);
        this.BS.postTranslate(i, i2);
        if (dVar.kh()) {
            this.BT = new BitmapShader(dVar.Bv.getBitmap(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        } else {
            this.BT = dVar.Bw.ng();
        }
        if (this.BT != null) {
            this.BT.setLocalMatrix(this.BS);
            this.mPaint.setShader(this.BT);
            int width2 = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            this.BU.set(Math.max(i, 0), Math.max(i2, 0), Math.min(i3, width2), Math.min(i4, (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom()));
            if (this.Bb.By) {
                float f = this.Bb.Bz / 2.0f;
                if (!this.Bb.BC) {
                    this.AY.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                } else {
                    this.AY.set(this.BU.left + f, this.BU.top + f, this.BU.right - f, this.BU.bottom - f);
                }
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        boolean ki = dVar.ki();
        if (ki) {
            dVar.Bw.Q(true);
        }
        if (!this.Bb.Bx) {
            canvas.drawRoundRect(this.BU, this.Bb.mRadius, this.Bb.mRadius, this.mPaint);
        } else {
            canvas.drawCircle((this.BU.right + this.BU.left) / 2.0f, (this.BU.top + this.BU.bottom) / 2.0f, Math.min(this.BU.width(), this.BU.height()) / 2.0f, this.mPaint);
        }
        if (ki) {
            dVar.Bw.Q(false);
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.Bb.By) {
            if (!this.Bb.Bx) {
                canvas.drawRoundRect(this.AY, this.Bb.mRadius, this.Bb.mRadius, this.AU);
            } else {
                canvas.drawCircle((this.BU.right + this.BU.left) / 2.0f, (this.BU.top + this.BU.bottom) / 2.0f, (Math.min(this.BU.width(), this.BU.height()) / 2.0f) - (this.Bb.Bz / 2.0f), this.AU);
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.Bb.BG != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.AV.setColor(this.Bb.BG);
            if (!this.Bb.Bx) {
                this.Be.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
                canvas.drawRoundRect(this.Be, this.Bb.mRadius, this.Bb.mRadius, this.AV);
            } else {
                float width = imageView.getWidth() / 2.0f;
                float height = imageView.getHeight() / 2.0f;
                canvas.drawCircle(width, height, Math.min(width, height) - (this.Bb.Bz / 2.0f), this.AV);
            }
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
