package com.baidu.live.adp.widget;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Region;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
/* loaded from: classes7.dex */
public class RoundCornerDecor23 extends BitmapDrawable implements RoundCornerDecor {
    private int mHeight;
    private final ImageView mImageView;
    private int mRadius;
    private final Path mRoundPath;
    private final Paint mRoundRectPaint;
    private int mWidth;

    public RoundCornerDecor23(Resources resources, Matrix matrix, ImageView imageView, Bitmap bitmap, int i, ColorFilter colorFilter) {
        super(resources, bitmap);
        this.mWidth = 0;
        this.mHeight = 0;
        this.mRoundPath = new Path();
        this.mImageView = imageView;
        this.mRadius = Math.max(0, i);
        this.mRoundRectPaint = new Paint();
        this.mRoundRectPaint.setAntiAlias(true);
        this.mRoundRectPaint.setFilterBitmap(true);
        if (colorFilter != null) {
            this.mRoundRectPaint.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable, com.baidu.live.adp.widget.RoundCornerDecor
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        this.mWidth = this.mImageView.getMeasuredWidth();
        this.mHeight = this.mImageView.getMeasuredHeight();
        this.mRoundPath.moveTo(0.0f, this.mRadius);
        this.mRoundPath.quadTo(0.0f, 0.0f, this.mRadius, 0.0f);
        this.mRoundPath.lineTo(this.mWidth - this.mRadius, 0.0f);
        this.mRoundPath.quadTo(this.mWidth, 0.0f, this.mWidth, this.mRadius);
        this.mRoundPath.lineTo(this.mWidth, this.mHeight - this.mRadius);
        this.mRoundPath.quadTo(this.mWidth, this.mHeight, this.mWidth - this.mRadius, this.mHeight);
        this.mRoundPath.lineTo(this.mRadius, this.mHeight);
        this.mRoundPath.quadTo(0.0f, this.mHeight, 0.0f, this.mHeight - this.mRadius);
        this.mRoundPath.lineTo(0.0f, this.mRadius);
        this.mRoundPath.close();
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable, com.baidu.live.adp.widget.RoundCornerDecor
    public void draw(Canvas canvas) {
        if (this.mWidth != 0 && this.mHeight != 0) {
            canvas.save();
            canvas.clipPath(this.mRoundPath, Region.Op.INTERSECT);
            super.draw(canvas);
            canvas.restore();
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
