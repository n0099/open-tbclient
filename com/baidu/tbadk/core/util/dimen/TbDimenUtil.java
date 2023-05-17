package com.baidu.tbadk.core.util.dimen;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class TbDimenUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public TbDimenUtil() {
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

    public static int dp2px(Context context, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65537, null, context, f)) == null) {
            return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
        }
        return invokeLF.intValue;
    }

    public static int sp2px(Context context, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65539, null, context, f)) == null) {
            return (int) TypedValue.applyDimension(2, f, context.getResources().getDisplayMetrics());
        }
        return invokeLF.intValue;
    }

    public static void setDensity(DisplayMetrics displayMetrics, float f, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65538, null, new Object[]{displayMetrics, Float.valueOf(f), Integer.valueOf(i)}) != null) || displayMetrics == null) {
            return;
        }
        displayMetrics.density = f;
        displayMetrics.densityDpi = i;
        displayMetrics.scaledDensity = f;
    }
}
