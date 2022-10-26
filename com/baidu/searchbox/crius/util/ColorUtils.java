package com.baidu.searchbox.crius.util;

import android.graphics.Color;
import android.text.TextUtils;
import com.baidu.searchbox.crius.CriusRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class ColorUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int getColorRes(boolean z, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)})) == null) ? (!z || i == 0 || i == Integer.MAX_VALUE) ? i2 : i : invokeCommon.intValue;
    }

    public ColorUtils() {
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

    public static int parseColor(String str) {
        InterceptResult invokeL;
        int parseColor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return Integer.MAX_VALUE;
            }
            try {
                if (str.startsWith("#")) {
                    parseColor = Color.parseColor(str);
                } else if (str.startsWith("$")) {
                    parseColor = CriusRuntime.context().getResources().getColor(CriusRuntime.context().getResources().getIdentifier(str.substring(1), "color", CriusRuntime.context().getPackageName()));
                } else {
                    parseColor = Color.parseColor("#" + str);
                }
                return parseColor;
            } catch (Throwable unused) {
                return Integer.MAX_VALUE;
            }
        }
        return invokeL.intValue;
    }
}
