package com.baidu.adp.newwidget.ImageView;

import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Shader;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class k extends a {
    protected BitmapShader Ho;
    protected Matrix mShaderMatrix = new Matrix();
    protected RectF Hp = new RectF();

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(c cVar, ImageView imageView) {
        int width = cVar.getWidth();
        int height = cVar.getHeight();
        PointF a = a(this.GI.left, this.GI.top, this.GH);
        int i = (int) a.x;
        int i2 = (int) a.y;
        PointF a2 = a(this.GI.right, this.GI.bottom, this.GH);
        int i3 = (int) a2.x;
        int i4 = (int) a2.y;
        this.mShaderMatrix.reset();
        this.mShaderMatrix.postScale((i3 - i) / width, (i4 - i2) / height);
        this.mShaderMatrix.postTranslate(i, i2);
        if (cVar.lx()) {
            this.Ho = new BitmapShader(cVar.GQ.getBitmap(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        } else {
            this.Ho = cVar.GR.nQ();
        }
        if (this.Ho != null) {
            this.Ho.setLocalMatrix(this.mShaderMatrix);
            this.mPaint.setShader(this.Ho);
            int width2 = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            this.Hp.set(Math.max(i, 0), Math.max(i2, 0), Math.min(i3, width2), Math.min(i4, (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom()));
            if (this.mArgs.GV) {
                float f = this.mArgs.mBorderWidth / 2.0f;
                if (!this.mArgs.GX) {
                    this.GJ.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                } else {
                    this.GJ.set(this.Hp.left + f, this.Hp.top + f, this.Hp.right - f, this.Hp.bottom - f);
                }
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, c cVar, ImageView imageView) {
        boolean ly = cVar.ly();
        if (ly) {
            cVar.GR.ap(true);
        }
        if (!this.mArgs.GU) {
            canvas.drawRoundRect(this.Hp, this.mArgs.mRadius, this.mArgs.mRadius, this.mPaint);
        } else {
            canvas.drawCircle((this.Hp.right + this.Hp.left) / 2.0f, (this.Hp.top + this.Hp.bottom) / 2.0f, Math.min(this.Hp.width(), this.Hp.height()) / 2.0f, this.mPaint);
        }
        if (ly) {
            cVar.GR.ap(false);
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.mArgs.GV) {
            if (!this.mArgs.GU) {
                canvas.drawRoundRect(this.GJ, this.mArgs.mRadius, this.mArgs.mRadius, this.GF);
                return;
            }
            float f = (this.Hp.right + this.Hp.left) / 2.0f;
            float f2 = (this.Hp.top + this.Hp.bottom) / 2.0f;
            float min = Math.min(this.Hp.width(), this.Hp.height()) / 2.0f;
            if (min <= 0.0f) {
                f = (imageView.getRight() + imageView.getLeft()) / 2.0f;
                f2 = (imageView.getTop() + imageView.getBottom()) / 2.0f;
                min = Math.min(imageView.getWidth(), imageView.getHeight()) / 2.0f;
            }
            canvas.drawCircle(f, f2, min - (this.mArgs.mBorderWidth / 2.0f), this.GF);
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.mArgs.Hc != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.GG.setColor(this.mArgs.Hc);
            if (!this.mArgs.GU) {
                this.GO.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
                canvas.drawRoundRect(this.GO, this.mArgs.mRadius, this.mArgs.mRadius, this.GG);
            } else {
                float width = imageView.getWidth() / 2.0f;
                float height = imageView.getHeight() / 2.0f;
                canvas.drawCircle(width, height, Math.min(width, height) - (this.mArgs.mBorderWidth / 2.0f), this.GG);
            }
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
