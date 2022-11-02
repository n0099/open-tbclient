package com.baidu.ala.utils;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Locale;
/* loaded from: classes.dex */
public class AlaStringHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public AlaStringHelper() {
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

    public static String formatLowercasekDou(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65537, null, f)) == null) {
            if (f < 100.0f) {
                return String.valueOf(f);
            }
            DecimalFormat decimalFormat = new DecimalFormat("0.0k");
            decimalFormat.setRoundingMode(RoundingMode.FLOOR);
            return decimalFormat.format(f / 1000.0d);
        }
        return (String) invokeF.objValue;
    }

    public static String numFormatMarkLevel(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65538, null, j)) == null) {
            if (j > 99990000) {
                return String.format("9999%s", Config.DEVICE_WIDTH);
            }
            if (j >= 100000) {
                return String.valueOf(j / 10000) + Config.DEVICE_WIDTH;
            }
            int i = (j > 10000L ? 1 : (j == 10000L ? 0 : -1));
            if (i > 0) {
                String format = String.format(Locale.getDefault(), "%.1f%s", Float.valueOf(((float) j) / 10000.0f), Config.DEVICE_WIDTH);
                if (!StringUtils.isNull(format) && format.endsWith(".0w") && format.indexOf(".0w") > 0 && format.indexOf(".0w") < format.length()) {
                    return format.substring(0, format.indexOf(".0w")) + Config.DEVICE_WIDTH;
                }
                return format;
            } else if (i == 0) {
                return "1w";
            } else {
                if (j < 0) {
                    return "--";
                }
                return "" + j;
            }
        }
        return (String) invokeJ.objValue;
    }
}
