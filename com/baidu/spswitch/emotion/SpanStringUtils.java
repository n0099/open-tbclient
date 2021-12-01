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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.spswitch.utils.UIUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes9.dex */
public class SpanStringUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int IMAGE_SPACING = 5;
    public static final String TAG = "SpanStringUtils";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class CenterImageSpan extends ImageSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CenterImageSpan(Context context, Bitmap bitmap) {
            super(context, bitmap);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, bitmap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (Bitmap) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{canvas, charSequence, Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), paint}) == null) {
                Drawable drawable = getDrawable();
                Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
                canvas.save();
                canvas.translate(f2, ((((fontMetricsInt.descent + i5) + i5) + fontMetricsInt.ascent) / 2) - (drawable.getBounds().bottom / 2));
                drawable.draw(canvas);
                canvas.restore();
            }
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public int getSize(Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{paint, charSequence, Integer.valueOf(i2), Integer.valueOf(i3), fontMetricsInt})) == null) {
                Rect bounds = getDrawable().getBounds();
                if (fontMetricsInt != null && fontMetricsInt.top == 0 && fontMetricsInt.ascent == 0 && fontMetricsInt.descent == 0 && fontMetricsInt.bottom == 0) {
                    paint.getFontMetricsInt(fontMetricsInt);
                }
                return (int) (bounds.right + UIUtils.dp2px(AppRuntime.getAppContext(), 2.0f));
            }
            return invokeCommon.intValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class CenterImageSpanEditText extends ImageSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CenterImageSpanEditText(Context context, Bitmap bitmap) {
            super(context, bitmap);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, bitmap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (Bitmap) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{canvas, charSequence, Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), paint}) == null) {
                Drawable drawable = getDrawable();
                Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
                canvas.save();
                canvas.translate(f2, ((((fontMetricsInt.descent + i5) + i5) + fontMetricsInt.ascent) / 2) - (drawable.getBounds().bottom / 2));
                drawable.draw(canvas);
                canvas.restore();
            }
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public int getSize(Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{paint, charSequence, Integer.valueOf(i2), Integer.valueOf(i3), fontMetricsInt})) == null) {
                Rect bounds = getDrawable().getBounds();
                if (fontMetricsInt != null) {
                    Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
                    int i4 = fontMetricsInt2.bottom - fontMetricsInt2.top;
                    int i5 = (bounds.bottom - bounds.top) / 2;
                    int i6 = i4 / 4;
                    int i7 = i5 - i6;
                    int i8 = -(i5 + i6);
                    fontMetricsInt.ascent = i8;
                    fontMetricsInt.top = i8;
                    int i9 = i7 + 3;
                    fontMetricsInt.bottom = i9;
                    fontMetricsInt.descent = i9;
                }
                return bounds.right + 5;
            }
            return invokeCommon.intValue;
        }
    }

    public SpanStringUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static SpannableString getEmotionContent(EmotionType emotionType, Context context, TextView textView, String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, emotionType, context, textView, str)) == null) {
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
        return (SpannableString) invokeLLLL.objValue;
    }

    public static int getRichCharacterCount(EmotionType emotionType, Context context, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, emotionType, context, str)) == null) {
            SpannableString spannableString = new SpannableString(str);
            int length = str.length();
            Matcher matcher = Pattern.compile("\\[([一-龥\\w])+\\]").matcher(spannableString);
            int i2 = 0;
            int i3 = 0;
            while (matcher.find()) {
                String group = matcher.group();
                if (EmotionUtils.getInstance().getEmotionFileByName(emotionType, group) != null) {
                    i2 += group.length();
                    i3++;
                }
            }
            return (length - i2) + i3;
        }
        return invokeLLL.intValue;
    }
}
