package com.baidu.spswitch.emotion;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.widget.TextView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.spswitch.utils.UIUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class SpanStringUtils {
    public static final int IMAGE_SPACING = 5;
    public static final String TAG = "SpanStringUtils";

    /* loaded from: classes3.dex */
    public static class CenterImageSpan extends ImageSpan {
        public CenterImageSpan(Context context, Bitmap bitmap) {
            super(context, bitmap);
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f2, int i3, int i4, int i5, Paint paint) {
            Drawable drawable = getDrawable();
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            canvas.save();
            canvas.translate(f2, ((((fontMetricsInt.descent + i4) + i4) + fontMetricsInt.ascent) / 2) - (drawable.getBounds().bottom / 2));
            drawable.draw(canvas);
            canvas.restore();
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
            Rect bounds = getDrawable().getBounds();
            if (fontMetricsInt != null && fontMetricsInt.top == 0 && fontMetricsInt.ascent == 0 && fontMetricsInt.descent == 0 && fontMetricsInt.bottom == 0) {
                paint.getFontMetricsInt(fontMetricsInt);
            }
            return (int) (bounds.right + UIUtils.dp2px(AppRuntime.getAppContext(), 2.0f));
        }
    }

    /* loaded from: classes3.dex */
    public static class CenterImageSpanEditText extends ImageSpan {
        public CenterImageSpanEditText(Context context, Bitmap bitmap) {
            super(context, bitmap);
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f2, int i3, int i4, int i5, Paint paint) {
            Drawable drawable = getDrawable();
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            canvas.save();
            canvas.translate(f2, ((((fontMetricsInt.descent + i4) + i4) + fontMetricsInt.ascent) / 2) - (drawable.getBounds().bottom / 2));
            drawable.draw(canvas);
            canvas.restore();
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
            Rect bounds = getDrawable().getBounds();
            if (fontMetricsInt != null) {
                Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
                int i3 = fontMetricsInt2.bottom - fontMetricsInt2.top;
                int i4 = (bounds.bottom - bounds.top) / 2;
                int i5 = i3 / 4;
                int i6 = i4 - i5;
                int i7 = -(i4 + i5);
                fontMetricsInt.ascent = i7;
                fontMetricsInt.top = i7;
                int i8 = i6 + 3;
                fontMetricsInt.bottom = i8;
                fontMetricsInt.descent = i8;
            }
            return bounds.right + 5;
        }
    }

    public static SpannableString getEmotionContent(EmotionType emotionType, Context context, TextView textView, String str) {
        SpannableString spannableString = new SpannableString(str);
        context.getResources();
        Matcher matcher = Pattern.compile("\\[([一-龥\\w])+\\]").matcher(spannableString);
        while (matcher.find()) {
            String group = matcher.group();
            int start = matcher.start();
            int textSize = (int) ((textView.getTextSize() * 11.0f) / 10.0f);
            Bitmap emotionBitmapByName = EmotionUtils.getInstance().getEmotionBitmapByName(emotionType, group);
            if (emotionBitmapByName != null) {
                spannableString.setSpan(new CenterImageSpan(context, Bitmap.createScaledBitmap(emotionBitmapByName, textSize, textSize, true)), start, group.length() + start, 33);
            }
        }
        return spannableString;
    }

    public static int getRichCharacterCount(EmotionType emotionType, Context context, String str) {
        SpannableString spannableString = new SpannableString(str);
        int length = str.length();
        Matcher matcher = Pattern.compile("\\[([一-龥\\w])+\\]").matcher(spannableString);
        int i = 0;
        int i2 = 0;
        while (matcher.find()) {
            String group = matcher.group();
            if (EmotionUtils.getInstance().getEmotionFileByName(emotionType, group) != null) {
                i += group.length();
                i2++;
            }
        }
        return (length - i) + i2;
    }
}
