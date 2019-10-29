package com.baidu.live.adp.widget;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
/* loaded from: classes6.dex */
public class RoundCornerDecor40 extends BitmapDrawable implements RoundCornerDecor {
    private RectF mActureRect;
    private int mHeight;
    private ImageView mImageView;
    private int mRadius;
    private Paint mRoundRectPaint;
    private float mScale;
    private BitmapShader mShader;
    private int mWidth;

    public RoundCornerDecor40(Resources resources, Bitmap bitmap) {
        super(resources, bitmap);
        this.mWidth = 0;
        this.mHeight = 0;
        this.mActureRect = new RectF();
    }

    public RoundCornerDecor40(Resources resources, Matrix matrix, ImageView imageView, Bitmap bitmap, int i, ColorFilter colorFilter) {
        super(resources, bitmap);
        this.mWidth = 0;
        this.mHeight = 0;
        this.mActureRect = new RectF();
        this.mImageView = imageView;
        this.mRadius = Math.max(0, i);
        this.mRoundRectPaint = new Paint();
        this.mRoundRectPaint.setAntiAlias(true);
        this.mRoundRectPaint.setFilterBitmap(true);
        if (colorFilter != null) {
            this.mRoundRectPaint.setColorFilter(colorFilter);
        }
        if (bitmap != null) {
            try {
                if (!bitmap.isRecycled()) {
                    this.mShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
                    if (matrix != null) {
                        this.mShader.setLocalMatrix(matrix);
                    }
                    this.mRoundRectPaint.setShader(this.mShader);
                }
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
                this.mShader = null;
            }
        }
    }

    @Override // android.graphics.drawable.Drawable, com.baidu.live.adp.widget.RoundCornerDecor
    public void setBounds(int i, int i2, int i3, int i4) {
        float f;
        float f2;
        super.setBounds(i, i2, i3, i4);
        int i5 = i3 - i;
        int i6 = i4 - i2;
        this.mWidth = this.mImageView.getMeasuredWidth();
        this.mHeight = this.mImageView.getMeasuredHeight();
        if (this.mHeight * i5 > this.mWidth * i6) {
            this.mScale = i6 / this.mHeight;
            f2 = (i5 - (this.mWidth * this.mScale)) * 0.5f;
            f = 0.0f;
        } else {
            this.mScale = i5 / this.mWidth;
            f = (i6 - (this.mHeight * this.mScale)) * 0.5f;
            f2 = 0.0f;
        }
        this.mActureRect.set(0.0f, 0.0f, this.mWidth * this.mScale, this.mHeight * this.mScale);
        this.mActureRect.offset(f2, f);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable, com.baidu.live.adp.widget.RoundCornerDecor
    public void draw(Canvas canvas) {
        if (this.mWidth != 0 && this.mHeight != 0) {
            canvas.drawRoundRect(this.mActureRect, (int) ((this.mRadius * this.mScale) + 0.5f), (int) ((this.mRadius * this.mScale) + 0.5f), this.mRoundRectPaint);
        }
    }

    @Override // com.baidu.live.adp.widget.RoundCornerDecor
    public void setColorFilterForSkin(ColorFilter colorFilter) {
        this.mRoundRectPaint.setColorFilter(colorFilter);
    }

    @Override // com.baidu.live.adp.widget.RoundCornerDecor
    public void setRadius(int i) {
        this.mRadius = i;
    }
}
