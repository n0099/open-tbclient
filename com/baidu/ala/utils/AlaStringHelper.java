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

    public static String formatTosepara(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65538, null, j)) == null) ? new DecimalFormat("#,###").format(j) : (String) invokeJ.objValue;
    }

    public static String formatkDou(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65539, null, j)) == null) {
            DecimalFormat decimalFormat = new DecimalFormat("0.0K");
            decimalFormat.setRoundingMode(RoundingMode.FLOOR);
            return decimalFormat.format(j / 1000.0d);
        }
        return (String) invokeJ.objValue;
    }

    public static String getCountDownTime(Long l) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, l)) == null) ? new SimpleDateFormat("HH:mm:ss").format(new Date((l.longValue() * 1000) - 28800000)) : (String) invokeL.objValue;
    }

    public static String getGiftTimeLimitDesc(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            long j3 = j2 - j;
            if (j3 < 60000) {
                return TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f024b);
            }
            StringBuilder sb = new StringBuilder(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0220));
            if (j3 < 3600000) {
                String string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f13f6);
                sb.append((int) (j3 / 60000));
                sb.append(string);
                return sb.toString();
            } else if (j3 < 86400000) {
                String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f13ef);
                sb.append(j3 / 3600000);
                sb.append(string2);
                return sb.toString();
            } else {
                String string3 = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f048a);
                sb.append(j3 / 86400000);
                sb.append(string3);
                return sb.toString();
            }
        }
        return (String) invokeCommon.objValue;
    }

    public static String getLeftTimeDesc(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65542, null, j)) == null) {
            StringBuilder sb = new StringBuilder();
            if (j < 60) {
                String string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f13f8);
                sb.append(j);
                sb.append(string);
                return sb.toString();
            } else if (j < 3600) {
                String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0ad5);
                sb.append((int) (j / 60));
                sb.append(string2);
                int i = (int) (j % 60);
                if (i > 0) {
                    String string3 = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f13f8);
                    sb.append(i);
                    sb.append(string3);
                }
                return sb.toString();
            } else if (j < 86400) {
                String string4 = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f13ef);
                sb.append((int) (j / 3600));
                sb.append(string4);
                int i2 = ((int) (j % 3600)) / 60;
                if (i2 > 0) {
                    String string5 = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0ad5);
                    sb.append(i2);
                    sb.append(string5);
                }
                return sb.toString();
            } else {
                String string6 = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f048a);
                sb.append((int) (j / 86400));
                sb.append(string6);
                int i3 = ((int) (j % 86400)) / 3600;
                if (i3 > 0) {
                    String string7 = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f13ef);
                    sb.append(i3);
                    sb.append(string7);
                }
                return sb.toString();
            }
        }
        return (String) invokeJ.objValue;
    }

    public static String numFormatMarkLevel(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65543, null, j)) == null) {
            if (j > 99990000) {
                return String.format("9999%s", "w");
            }
            if (j >= 100000) {
                return String.valueOf(j / 10000) + "w";
            }
            int i = (j > 10000L ? 1 : (j == 10000L ? 0 : -1));
            if (i <= 0) {
                if (i == 0) {
                    return "1w";
                }
                if (j < 0) {
                    return "--";
                }
                return "" + j;
            }
            String format = String.format(Locale.getDefault(), "%.1f%s", Float.valueOf(((float) j) / 10000.0f), "w");
            if (StringUtils.isNull(format) || !format.endsWith(".0w") || format.indexOf(".0w") <= 0 || format.indexOf(".0w") >= format.length()) {
                return format;
            }
            return format.substring(0, format.indexOf(".0w")) + "w";
        }
        return (String) invokeJ.objValue;
    }

    public static String numFormatOver10Wan(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65544, null, j)) == null) {
            if (j > 99990000) {
                return "9999W+";
            }
            if (j >= 100000) {
                return String.format(Locale.getDefault(), "%dW", Long.valueOf(j / 10000));
            }
            return "" + j;
        }
        return (String) invokeJ.objValue;
    }

    public static String numFormatOverWanForAudienceNum(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65545, null, j)) == null) {
            if (j > 99990000) {
                return String.format("9999%s+", "w");
            }
            if (j >= 10000000) {
                return String.valueOf(j / 10000) + "w";
            }
            int i = (j > 10000L ? 1 : (j == 10000L ? 0 : -1));
            if (i > 0) {
                return String.format(Locale.getDefault(), "%.1f%s", Float.valueOf(((float) j) / 10000.0f), "w");
            }
            if (i == 0) {
                return "1w";
            }
            if (j < 0) {
                return "--";
            }
            return "" + j;
        }
        return (String) invokeJ.objValue;
    }

    public static String numFormatOverWanNaForAudienceNum(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65546, null, j)) == null) {
            if (j > 99990000) {
                return String.format("9999%s+", TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f14a7));
            }
            if (j >= 10000000) {
                return String.valueOf(j / 10000) + TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f14a7);
            }
            int i = (j > 10000L ? 1 : (j == 10000L ? 0 : -1));
            if (i > 0) {
                return String.format(Locale.getDefault(), "%.1f%s", Float.valueOf(((float) j) / 10000.0f), TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f14a7));
            }
            if (i == 0) {
                return "1" + TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f14a7);
            } else if (j < 0) {
                return "--";
            } else {
                return "" + j;
            }
        }
        return (String) invokeJ.objValue;
    }

    public static String stringForLastTime(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65547, null, i)) == null) {
            if (i < 1) {
                i = 1;
            }
            int i2 = i % 60;
            int i3 = (i / 60) % 60;
            int i4 = i / 3600;
            StringBuilder sb = new StringBuilder();
            Formatter formatter = new Formatter(sb, Locale.getDefault());
            sb.setLength(0);
            return i4 > 0 ? formatter.format("%d:%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i2)).toString() : formatter.format("%02d:%02d", Integer.valueOf(i3), Integer.valueOf(i2)).toString();
        }
        return (String) invokeI.objValue;
    }
}
