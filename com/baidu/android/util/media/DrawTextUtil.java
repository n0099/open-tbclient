package com.baidu.android.util.media;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
/* loaded from: classes12.dex */
public class DrawTextUtil {
    static float[] sMeasuredWidth = new float[1];
    private Paint.FontMetrics mFontMetrics;
    private Paint mTextPaint;

    public DrawTextUtil(Paint paint) {
        this.mTextPaint = null;
        this.mFontMetrics = null;
        this.mTextPaint = paint;
        this.mFontMetrics = paint.getFontMetrics();
    }

    public String drawTextEx(Canvas canvas, Rect rect, String str, boolean z) {
        int i;
        if (str == null || str.length() == 0 || rect == null || rect.isEmpty()) {
            return str;
        }
        Paint paint = this.mTextPaint;
        Paint.FontMetrics fontMetrics = this.mFontMetrics;
        int length = str.length();
        int height = rect.height();
        int width = rect.width();
        int i2 = (int) (fontMetrics.bottom - fontMetrics.top);
        int i3 = rect.left;
        int i4 = z ? (int) ((rect.top + ((height + i2) / 2)) - fontMetrics.bottom) : (int) (rect.top - fontMetrics.bottom);
        int breakText = paint.breakText(str, 0, length, true, width, sMeasuredWidth);
        String str2 = null;
        if (breakText + 0 == length) {
            str2 = str;
        } else {
            if ((breakText + 0) - 1 <= str.length()) {
                str2 = str.substring(0, i) + StringHelper.STRING_MORE;
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            int save = canvas.save();
            canvas.clipRect(rect);
            canvas.drawText(str2, 0, str2.length(), i3, i4, paint);
            canvas.restoreToCount(save);
            return str2;
        }
        return str2;
    }

    public void drawText(Canvas canvas, Rect rect, String str, boolean z) {
        drawText(canvas, rect, str, z, false);
    }

    public void drawText(Canvas canvas, Rect rect, String str, boolean z, boolean z2) {
        int i;
        Paint.FontMetrics fontMetrics;
        if (str != null && str.length() != 0 && rect != null && !rect.isEmpty()) {
            Paint paint = this.mTextPaint;
            int i2 = rect.left;
            if (z) {
                i = ((int) (((rect.height() + ((int) (fontMetrics.bottom - fontMetrics.top))) / 2) - this.mFontMetrics.bottom)) + rect.top;
            } else {
                i = 0;
            }
            if (z2) {
                i2 = ((int) ((rect.width() - paint.measureText(str)) / 2.0f)) + rect.left;
            }
            int save = canvas.save();
            canvas.clipRect(rect);
            canvas.drawText(str, 0, str.length(), i2, i, paint);
            canvas.restoreToCount(save);
        }
    }

    public static int getTextLines(TextPaint textPaint, int i, String str) {
        if (textPaint == null || TextUtils.isEmpty(str) || i <= 0) {
            return 0;
        }
        return new StaticLayout(str, textPaint, i, Layout.Alignment.ALIGN_NORMAL, 0.0f, 0.0f, false).getLineCount();
    }

    public static int getTextLines(TextPaint textPaint, int i, SpannableStringBuilder spannableStringBuilder) {
        if (textPaint == null || TextUtils.isEmpty(spannableStringBuilder) || i <= 0) {
            return 0;
        }
        return new StaticLayout(spannableStringBuilder, textPaint, i, Layout.Alignment.ALIGN_NORMAL, 0.0f, 0.0f, false).getLineCount();
    }
}
