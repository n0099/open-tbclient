package com.baidu.tbadk.core.util;

import android.text.TextPaint;
import com.baidu.tbadk.core.util.tbselector.utils.SelectorHelper;
import com.baidu.tieba.iu5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class MeasureTextLength {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public MeasureTextLength() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String fitTextLabel(String str, String str2, float f, TextPaint textPaint, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, str2, Float.valueOf(f), textPaint, str3})) == null) {
            if (textPaint == null) {
                textPaint = new TextPaint();
            }
            String measuredText = measuredText(textPaint, str, f - textPaint.measureText(str2), str2);
            if (str.length() > measuredText.length()) {
                return measuredText + str2;
            }
            return measuredText + str3;
        }
        return (String) invokeCommon.objValue;
    }

    public static String measuredText(TextPaint textPaint, String str, float f, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{textPaint, str, Float.valueOf(f), str2})) == null) {
            float measureText = textPaint.measureText(str);
            while (str.length() > 0 && measureText > f) {
                str = iu5.m(str, iu5.e(str) - 1);
                measureText = textPaint.measureText(str);
            }
            return str;
        }
        return (String) invokeCommon.objValue;
    }

    public static int spaceLength(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            return SelectorHelper.getResources().getDisplayMetrics().widthPixels - i;
        }
        return invokeI.intValue;
    }
}
