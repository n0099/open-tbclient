package com.baidu.ala.utils;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;
/* loaded from: classes8.dex */
public class AlaStringHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public AlaStringHelper() {
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

    public static String formatLowercasekDou(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65537, null, f2)) == null) {
            if (f2 < 100.0f) {
                return String.valueOf(f2);
            }
            DecimalFormat decimalFormat = new DecimalFormat("0.0k");
            decimalFormat.setRoundingMode(RoundingMode.FLOOR);
            return decimalFormat.format(f2 / 1000.0d);
        }
        return (String) invokeF.objValue;
    }

    public static String formatTosepara(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65538, null, j2)) == null) ? new DecimalFormat("#,###").format(j2) : (String) invokeJ.objValue;
    }

    public static String formatkDou(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65539, null, j2)) == null) {
            DecimalFormat decimalFormat = new DecimalFormat("0.0K");
            decimalFormat.setRoundingMode(RoundingMode.FLOOR);
            return decimalFormat.format(j2 / 1000.0d);
        }
        return (String) invokeJ.objValue;
    }

    public static String getCountDownTime(Long l) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, l)) == null) ? new SimpleDateFormat("HH:mm:ss").format(new Date((l.longValue() * 1000) - 28800000)) : (String) invokeL.objValue;
    }

    public static String getGiftTimeLimitDesc(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            long j4 = j3 - j2;
            if (j4 < 60000) {
                return TbadkCoreApplication.getInst().getResources().getString(R.string.ala_time_limited_gift_last_one_minute);
            }
            StringBuilder sb = new StringBuilder(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_left_prefix));
            if (j4 < 3600000) {
                String string = TbadkCoreApplication.getInst().getResources().getString(R.string.time_minute);
                sb.append((int) (j4 / 60000));
                sb.append(string);
                return sb.toString();
            } else if (j4 < 86400000) {
                String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.time_hour);
                sb.append(j4 / 3600000);
                sb.append(string2);
                return sb.toString();
            } else {
                String string3 = TbadkCoreApplication.getInst().getResources().getString(R.string.day);
                sb.append(j4 / 86400000);
                sb.append(string3);
                return sb.toString();
            }
        }
        return (String) invokeCommon.objValue;
    }

    public static String getLeftTimeDesc(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65542, null, j2)) == null) {
            StringBuilder sb = new StringBuilder();
            if (j2 < 60) {
                String string = TbadkCoreApplication.getInst().getResources().getString(R.string.time_second);
                sb.append(j2);
                sb.append(string);
                return sb.toString();
            } else if (j2 < 3600) {
                String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.minute);
                sb.append((int) (j2 / 60));
                sb.append(string2);
                int i2 = (int) (j2 % 60);
                if (i2 > 0) {
                    String string3 = TbadkCoreApplication.getInst().getResources().getString(R.string.time_second);
                    sb.append(i2);
                    sb.append(string3);
                }
                return sb.toString();
            } else if (j2 < 86400) {
                String string4 = TbadkCoreApplication.getInst().getResources().getString(R.string.time_hour);
                sb.append((int) (j2 / 3600));
                sb.append(string4);
                int i3 = ((int) (j2 % 3600)) / 60;
                if (i3 > 0) {
                    String string5 = TbadkCoreApplication.getInst().getResources().getString(R.string.minute);
                    sb.append(i3);
                    sb.append(string5);
                }
                return sb.toString();
            } else {
                String string6 = TbadkCoreApplication.getInst().getResources().getString(R.string.day);
                sb.append((int) (j2 / 86400));
                sb.append(string6);
                int i4 = ((int) (j2 % 86400)) / 3600;
                if (i4 > 0) {
                    String string7 = TbadkCoreApplication.getInst().getResources().getString(R.string.time_hour);
                    sb.append(i4);
                    sb.append(string7);
                }
                return sb.toString();
            }
        }
        return (String) invokeJ.objValue;
    }

    public static String numFormatMarkLevel(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65543, null, j2)) == null) {
            if (j2 > 99990000) {
                return String.format("9999%s", "w");
            }
            if (j2 >= 100000) {
                return String.valueOf(j2 / 10000) + "w";
            }
            int i2 = (j2 > 10000L ? 1 : (j2 == 10000L ? 0 : -1));
            if (i2 <= 0) {
                if (i2 == 0) {
                    return "1w";
                }
                if (j2 < 0) {
                    return "--";
                }
                return "" + j2;
            }
            String format = String.format(Locale.getDefault(), "%.1f%s", Float.valueOf(((float) j2) / 10000.0f), "w");
            if (StringUtils.isNull(format) || !format.endsWith(".0w") || format.indexOf(".0w") <= 0 || format.indexOf(".0w") >= format.length()) {
                return format;
            }
            return format.substring(0, format.indexOf(".0w")) + "w";
        }
        return (String) invokeJ.objValue;
    }

    public static String numFormatOver10Wan(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65544, null, j2)) == null) {
            if (j2 > 99990000) {
                return "9999W+";
            }
            if (j2 >= 100000) {
                return String.format(Locale.getDefault(), "%dW", Long.valueOf(j2 / 10000));
            }
            return "" + j2;
        }
        return (String) invokeJ.objValue;
    }

    public static String numFormatOverWanForAudienceNum(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65545, null, j2)) == null) {
            if (j2 > 99990000) {
                return String.format("9999%s+", "w");
            }
            if (j2 >= 10000000) {
                return String.valueOf(j2 / 10000) + "w";
            }
            int i2 = (j2 > 10000L ? 1 : (j2 == 10000L ? 0 : -1));
            if (i2 > 0) {
                return String.format(Locale.getDefault(), "%.1f%s", Float.valueOf(((float) j2) / 10000.0f), "w");
            }
            if (i2 == 0) {
                return "1w";
            }
            if (j2 < 0) {
                return "--";
            }
            return "" + j2;
        }
        return (String) invokeJ.objValue;
    }

    public static String numFormatOverWanNaForAudienceNum(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65546, null, j2)) == null) {
            if (j2 > 99990000) {
                return String.format("9999%s+", TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan));
            }
            if (j2 >= 10000000) {
                return String.valueOf(j2 / 10000) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan);
            }
            int i2 = (j2 > 10000L ? 1 : (j2 == 10000L ? 0 : -1));
            if (i2 > 0) {
                return String.format(Locale.getDefault(), "%.1f%s", Float.valueOf(((float) j2) / 10000.0f), TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan));
            }
            if (i2 == 0) {
                return "1" + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan);
            } else if (j2 < 0) {
                return "--";
            } else {
                return "" + j2;
            }
        }
        return (String) invokeJ.objValue;
    }

    public static String stringForLastTime(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65547, null, i2)) == null) {
            if (i2 < 1) {
                i2 = 1;
            }
            int i3 = i2 % 60;
            int i4 = (i2 / 60) % 60;
            int i5 = i2 / 3600;
            StringBuilder sb = new StringBuilder();
            Formatter formatter = new Formatter(sb, Locale.getDefault());
            sb.setLength(0);
            return i5 > 0 ? formatter.format("%d:%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i3)).toString() : formatter.format("%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3)).toString();
        }
        return (String) invokeI.objValue;
    }
}
