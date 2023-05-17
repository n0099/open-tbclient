package com.baidu.android.util.media;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Deprecated
/* loaded from: classes.dex */
public class DrawTextUtil {
    public static /* synthetic */ Interceptable $ic;
    public static float[] sMeasuredWidth;
    public transient /* synthetic */ FieldHolder $fh;
    public Paint.FontMetrics mFontMetrics;
    public Paint mTextPaint;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(436661374, "Lcom/baidu/android/util/media/DrawTextUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(436661374, "Lcom/baidu/android/util/media/DrawTextUtil;");
                return;
            }
        }
        sMeasuredWidth = new float[1];
    }

    public DrawTextUtil(Paint paint) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {paint};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mTextPaint = null;
        this.mFontMetrics = null;
        this.mTextPaint = paint;
        this.mFontMetrics = paint.getFontMetrics();
    }

    public static int getTextLines(TextPaint textPaint, int i, SpannableStringBuilder spannableStringBuilder) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65538, null, textPaint, i, spannableStringBuilder)) == null) {
            if (textPaint != null && !TextUtils.isEmpty(spannableStringBuilder) && i > 0) {
                return new StaticLayout(spannableStringBuilder, textPaint, i, Layout.Alignment.ALIGN_NORMAL, 0.0f, 0.0f, false).getLineCount();
            }
            return 0;
        }
        return invokeLIL.intValue;
    }

    public static int getTextLines(TextPaint textPaint, int i, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65539, null, textPaint, i, str)) == null) {
            if (textPaint != null && !TextUtils.isEmpty(str) && i > 0) {
                return new StaticLayout(str, textPaint, i, Layout.Alignment.ALIGN_NORMAL, 0.0f, 0.0f, false).getLineCount();
            }
            return 0;
        }
        return invokeLIL.intValue;
    }

    public void drawText(Canvas canvas, Rect rect, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{canvas, rect, str, Boolean.valueOf(z)}) == null) {
            drawText(canvas, rect, str, z, false);
        }
    }

    public void drawText(Canvas canvas, Rect rect, String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{canvas, rect, str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && str != null && str.length() != 0 && rect != null && !rect.isEmpty()) {
            Paint paint = this.mTextPaint;
            int i = rect.left;
            int i2 = 0;
            if (z) {
                Paint.FontMetrics fontMetrics = this.mFontMetrics;
                int height = rect.height();
                float f = fontMetrics.bottom;
                i2 = rect.top + ((int) (((height + ((int) (f - fontMetrics.top))) / 2) - f));
            }
            if (z2) {
                i = rect.left + ((int) ((rect.width() - paint.measureText(str)) / 2.0f));
            }
            int save = canvas.save();
            canvas.clipRect(rect);
            canvas.drawText(str, 0, str.length(), i, i2, paint);
            canvas.restoreToCount(save);
        }
    }

    public String drawTextEx(Canvas canvas, Rect rect, String str, boolean z) {
        InterceptResult invokeCommon;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{canvas, rect, str, Boolean.valueOf(z)})) == null) {
            if (str != null && str.length() != 0 && rect != null && !rect.isEmpty()) {
                Paint paint = this.mTextPaint;
                Paint.FontMetrics fontMetrics = this.mFontMetrics;
                int length = str.length();
                int height = rect.height();
                int width = rect.width();
                float f = fontMetrics.bottom;
                int i3 = (int) (f - fontMetrics.top);
                int i4 = rect.left;
                int i5 = (int) (rect.top - f);
                if (z) {
                    i5 = (int) ((i + ((height + i3) / 2)) - f);
                }
                int i6 = i5;
                int breakText = paint.breakText(str, 0, length, true, width, sMeasuredWidth) + 0;
                if (breakText != length) {
                    if (breakText - 1 <= str.length()) {
                        str = str.substring(0, i2) + StringHelper.STRING_MORE;
                    } else {
                        str = null;
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    int save = canvas.save();
                    canvas.clipRect(rect);
                    canvas.drawText(str, 0, str.length(), i4, i6, paint);
                    canvas.restoreToCount(save);
                }
            }
            return str;
        }
        return (String) invokeCommon.objValue;
    }
}
