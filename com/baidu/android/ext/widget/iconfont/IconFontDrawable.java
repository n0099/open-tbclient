package com.baidu.android.ext.widget.iconfont;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.TextUtils;
/* loaded from: classes11.dex */
class IconFontDrawable extends Drawable {
    private static final int DEFAULT_COLOR = -16777216;
    private Context mContext;
    private String mFontPath;
    private String mIconFont;
    private int mIconFontColor = -16777216;
    private TextPaint mIconFontPaint;
    private Rect mTempRect;
    private float mX;
    private float mY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IconFontDrawable(Context context) {
        init(context);
    }

    IconFontDrawable(Context context, String str, String str2) {
        this.mFontPath = str;
        this.mIconFont = str2;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mIconFontPaint = new TextPaint(1);
        this.mIconFontPaint.setStyle(Paint.Style.FILL);
        this.mIconFontPaint.setTextAlign(Paint.Align.CENTER);
        this.mIconFontPaint.setUnderlineText(false);
        this.mIconFontPaint.setColor(this.mIconFontColor);
        this.mIconFontPaint.setAntiAlias(true);
        this.mTempRect = new Rect();
        if (!TextUtils.isEmpty(this.mFontPath)) {
            this.mIconFontPaint.setTypeface(TypefaceCache.getTypeface(this.mContext, this.mFontPath));
        }
    }

    public void setFontPath(String str) {
        if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, this.mFontPath)) {
            this.mFontPath = str;
            this.mIconFontPaint.setTypeface(TypefaceCache.getTypeface(this.mContext, this.mFontPath));
            invalidateSelf();
        }
    }

    public void setIconFont(String str) {
        if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, this.mIconFont)) {
            this.mIconFont = str;
            invalidateSelf();
        }
    }

    public void setIconFontColor(int i) {
        if (i != 0 && i != this.mIconFontColor) {
            this.mIconFontColor = i;
            this.mIconFontPaint.setColor(this.mIconFontColor);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (!TextUtils.isEmpty(this.mFontPath) && !TextUtils.isEmpty(this.mIconFont)) {
            Rect bounds = getBounds();
            if (bounds.width() != 0 || bounds.height() != 0) {
                this.mX = bounds.exactCenterX();
                Rect rect = this.mTempRect;
                int min = Math.min(bounds.height(), bounds.width());
                this.mIconFontPaint.setTextSize(min);
                this.mIconFontPaint.getTextBounds(this.mIconFont, 0, this.mIconFont.length(), rect);
                int height = rect.height();
                this.mY = ((bounds.top + ((min - height) / 2.0f)) + height) - rect.bottom;
                canvas.drawText(this.mIconFont, this.mX, this.mY, this.mIconFontPaint);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mIconFontPaint.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mIconFontPaint.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        int alpha = this.mIconFontPaint.getAlpha();
        if (alpha <= 0) {
            return -2;
        }
        if (alpha > 0 && alpha < 255) {
            return -3;
        }
        return -1;
    }
}
