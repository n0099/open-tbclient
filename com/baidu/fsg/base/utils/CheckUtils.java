package com.baidu.fsg.base.utils;

import android.annotation.SuppressLint;
import android.os.Environment;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.fsg.base.ApollonConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.regex.Pattern;
/* loaded from: classes10.dex */
public final class CheckUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "CheckUtils";

    /* renamed from: b  reason: collision with root package name */
    public static final int f34952b = 3;

    /* renamed from: c  reason: collision with root package name */
    public static final int f34953c = 12;

    /* renamed from: d  reason: collision with root package name */
    public static final int f34954d = 4;

    /* renamed from: e  reason: collision with root package name */
    public static long f34955e;
    public transient /* synthetic */ FieldHolder $fh;

    public CheckUtils() {
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

    @SuppressLint({"DefaultLocale"})
    public static boolean checkParams(String str) {
        InterceptResult invokeL;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        String str21;
        String str22;
        String str23;
        String str24;
        String str25;
        String str26;
        String str27;
        String str28;
        String str29;
        String str30;
        String decode;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                for (String str31 : str.toUpperCase().split("&")) {
                    String[] split = str31.split("=");
                    if (split != null && !TextUtils.isEmpty(split[0])) {
                        if ("CURRENCY".equals(split[0])) {
                            if (split.length > 1 && (decode = URLDecoder.decode(split[1])) != null && !Pattern.compile("^1$").matcher(decode).matches()) {
                                return false;
                            }
                        } else if ("EXTRA".equals(split[0])) {
                            if (split.length > 1 && (str30 = split[1]) != null && !Pattern.compile("^.{0,255}$").matcher(str30).matches()) {
                                return false;
                            }
                        } else if ("GOODS_DESC".equals(split[0])) {
                            if (split.length > 1 && (str29 = split[1]) != null && !Pattern.compile("^(.|\n){0,255}$").matcher(str29).matches()) {
                                return false;
                            }
                        } else if ("GOODS_URL".equals(split[0])) {
                            if (split.length > 1 && (str28 = split[1]) != null && !Pattern.compile("^$|^([hH][tT][tT][pP][sS]?://[0-9a-zA-Z\\-_.]+(:[0-9]+)?[0-9a-zA-Z$.+_\\-*()!`?,%/]*|baidureader://rd_doc_id[0-9a-zA-Z]{28})$").matcher(str28).matches()) {
                                return false;
                            }
                        } else if ("CHARSET".equals(split[0])) {
                            if (split.length > 1 && (str27 = split[1]) != null && !Pattern.compile("^1$").matcher(str27).matches()) {
                                return false;
                            }
                        } else if ("ORDER_TIME".equals(split[0])) {
                            if (split.length > 1 && (str26 = split[1]) != null && !Pattern.compile("^[0-9]{14}$").matcher(str26).matches()) {
                                return false;
                            }
                        } else if ("ORDER_NO".equals(split[0])) {
                            if (split.length > 1 && (str25 = split[1]) != null && !Pattern.compile("^[0-9a-zA-Z]{1,50}$").matcher(str25).matches()) {
                                return false;
                            }
                        } else if ("PAY_TYPE".equals(split[0])) {
                            if (split.length > 1 && (str24 = split[1]) != null && !Pattern.compile("^[0-9]$").matcher(str24).matches()) {
                                return false;
                            }
                        } else if ("RETURN_URL".equals(split[0])) {
                            if (split.length > 1 && (str23 = split[1]) != null && !Pattern.compile("^([hH][tT][tT][pP][sS]?://[0-9a-zA-Z\\-_.]+(:[0-9]+)?[0-9a-zA-Z$.+_\\-*()!`?,%/]*|baidureader://rd_doc_id[0-9a-zA-Z]{28})$").matcher(str23).matches()) {
                                return false;
                            }
                        } else if ("PAGE_URL".equals(split[0])) {
                            if (split.length > 1 && (str22 = split[1]) != null && !Pattern.compile("^$|^([hH][tT][tT][pP][sS]?://[0-9a-zA-Z\\-_.]+(:[0-9]+)?[0-9a-zA-Z$.+_\\-*()!`?,%/]*|baidureader://rd_doc_id[0-9a-zA-Z]{28})$").matcher(str22).matches()) {
                                return false;
                            }
                        } else if ("SPID".equals(split[0])) {
                            if (split.length > 1 && (str21 = split[1]) != null && !Pattern.compile("^[1-9][0-9]{9}$").matcher(str21).matches()) {
                                return false;
                            }
                        } else if ("TOTAL_AMOUNT".equals(split[0])) {
                            if (split.length > 1 && (str20 = split[1]) != null && !Pattern.compile("^[0-9][0-9]{0,13}").matcher(str20).matches()) {
                                return false;
                            }
                        } else if ("TRANS_AMOUNT".equals(split[0])) {
                            if (split.length > 1 && (str19 = split[1]) != null && !Pattern.compile("^$|^[0-9]{1,14}$").matcher(str19).matches()) {
                                return false;
                            }
                        } else if ("UNIT_AMOUNT".equals(split[0])) {
                            if (split.length > 1 && (str18 = split[1]) != null && !Pattern.compile("^$|^[0-9]{1,14}$").matcher(str18).matches()) {
                                return false;
                            }
                        } else if ("UNIT_COUNT".equals(split[0])) {
                            if (split.length > 1 && (str17 = split[1]) != null && !Pattern.compile("^$|^[0-9]{1,14}$").matcher(str17).matches()) {
                                return false;
                            }
                        } else if ("BANK_CODE".equals(split[0])) {
                            if (split.length > 1 && (str16 = split[1]) != null && !Pattern.compile("^$|^[0-9]{1,5}$").matcher(str16).matches()) {
                                return false;
                            }
                        } else if ("EXPIRE_TIME".equals(split[0])) {
                            if (split.length > 1 && (str15 = split[1]) != null && !Pattern.compile("^$|^[0-9]{14}$").matcher(str15).matches()) {
                                return false;
                            }
                        } else if ("GOODS_NAME".equals(split[0])) {
                            if (split.length > 1 && (str14 = split[1]) != null && !Pattern.compile("^$|^(.|\n){1,128}$").matcher(str14).matches()) {
                                return false;
                            }
                        } else if ("BUYER_NAME".equals(split[0])) {
                            if (split.length > 1 && (str13 = split[1]) != null && !Pattern.compile("^$|^.{1,255}$").matcher(str13).matches()) {
                                return false;
                            }
                        } else if ("VERSION".equals(split[0])) {
                            if (split.length > 1 && (str12 = split[1]) != null && !Pattern.compile("^$|^2$").matcher(str12).matches()) {
                                return false;
                            }
                        } else if ("SERVICE_TYPE".equals(split[0])) {
                            if (split.length > 1 && (str11 = split[1]) != null && !Pattern.compile("^$|^[0-9]$").matcher(str11).matches()) {
                                return false;
                            }
                        } else if ("PHONE_NUM".equals(split[0])) {
                            if (split.length > 1 && (str10 = split[1]) != null && !Pattern.compile("^$|^1[0-9]{10}$").matcher(str10).matches()) {
                                return false;
                            }
                        } else if ("USER_SOURCE_IP".equals(split[0])) {
                            if (split.length > 1 && (str9 = split[1]) != null && !Pattern.compile("^$|[\\.0-9]{1,30}$").matcher(str9).matches()) {
                                return false;
                            }
                        } else if ("CHECK_REFERER".equals(split[0])) {
                            if (split.length > 1 && (str8 = split[1]) != null && !Pattern.compile("^$").matcher(str8).matches()) {
                                return false;
                            }
                        } else if ("BANKCARD_NUM".equals(split[0])) {
                            if (split.length > 1 && (str7 = split[1]) != null && !Pattern.compile("$|^[0-9]{7,21}$").matcher(str7).matches()) {
                                return false;
                            }
                        } else if ("PREG_CHARSET".equals(split[0])) {
                            if (split.length > 1 && (str6 = split[1]) != null && !Pattern.compile("^1$").matcher(str6).matches()) {
                                return false;
                            }
                        } else if ("PREG_ORDERNO".equals(split[0])) {
                            if (split.length > 1 && (str5 = split[1]) != null && !Pattern.compile("^[0-9a-zA-Z]{1,50}$").matcher(str5).matches()) {
                                return false;
                            }
                        } else if ("PREG_ORDERNO_CAN_EMPTY".equals(split[0])) {
                            if (split.length > 1 && (str4 = split[1]) != null && !Pattern.compile("^$|^[0-9a-zA-Z]{1,50}$").matcher(str4).matches()) {
                                return false;
                            }
                        } else if ("PREG_SPID".equals(split[0])) {
                            if (split.length > 1 && (str3 = split[1]) != null && !Pattern.compile("^[1-9][0-9]{9}$").matcher(str3).matches()) {
                                return false;
                            }
                        } else if ("PREG_FOR_URL".equals(split[0]) && split.length > 1 && (str2 = split[1]) != null && !Pattern.compile("^([hH][tT][tT][pP][sS]?://[0-9a-zA-Z\\-_.]+(:[0-9]+)?[0-9a-zA-Z$.+_\\-*()!`?,%/]*|baidureader://rd_doc_id[0-9a-zA-Z]{28})$").matcher(str2).matches()) {
                            return false;
                        }
                    }
                }
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean isBandCardAvailable(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? Pattern.compile("^\\d{15,20}$").matcher(str).matches() : invokeL.booleanValue;
    }

    public static boolean isBandCardEndAvailable(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? str != null && str.length() == 3 : invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isExternalStorageWriteable() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (TextUtils.equals("mounted", Environment.getExternalStorageState())) {
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                if (externalStorageDirectory.exists() && externalStorageDirectory.canWrite()) {
                    File file = new File(externalStorageDirectory, ".test");
                    if (file.exists()) {
                        z = true;
                    } else {
                        try {
                            z = file.createNewFile();
                        } catch (IOException unused) {
                            boolean z2 = ApollonConstants.DEBUG;
                        }
                    }
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (ApollonConstants.DEBUG) {
                        String str = "Utility.isExternalStorageWriteable(" + z + ") cost " + (currentTimeMillis2 - currentTimeMillis) + "ms.";
                    }
                    return z;
                }
            }
            z = false;
            long currentTimeMillis22 = System.currentTimeMillis();
            if (ApollonConstants.DEBUG) {
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public static boolean isFastDoubleClick() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = currentTimeMillis - f34955e;
            LogUtil.logd("timeD=" + j2);
            if (0 >= j2 || j2 >= 500) {
                f34955e = currentTimeMillis;
                return false;
            }
            LogUtil.logd("点的太快了 timeD=" + j2);
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean isIDcardAvailable(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) ? Pattern.compile("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}[\\dxX]$|^[1-9]\\d{5}\\d{2}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$").matcher(str).matches() : invokeL.booleanValue;
    }

    public static boolean isMobileAvailable(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) ? Pattern.compile("^1[0-9]{10}$").matcher(str).matches() : invokeL.booleanValue;
    }

    public static boolean isMonthValid(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            try {
                int intValue = Integer.valueOf(str).intValue();
                if (intValue <= 12 && intValue >= 1) {
                    return Pattern.compile("^\\d{2}$").matcher(str).matches();
                }
            } catch (Exception unused) {
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isPayPasswordAvailable(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) ? Pattern.compile("[~!@#$%^&*()+-=\\[\\]\\{}|;':\",./<>?0-9a-zA-z]*").matcher(str).matches() : invokeL.booleanValue;
    }

    public static boolean isShowExitDialog(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65546, null, i2)) == null) {
            return false;
        }
        return invokeI.booleanValue;
    }

    public static boolean isUserNameAvailable(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) ? str != null && str.length() >= 2 && str.length() <= 40 : invokeL.booleanValue;
    }

    public static boolean isVodeAvailable(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) ? !TextUtils.isEmpty(str) && str.length() >= 4 : invokeL.booleanValue;
    }

    public static boolean isYearValid(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) ? Pattern.compile("^\\d{2}$").matcher(str).matches() : invokeL.booleanValue;
    }

    public static final String stripUrlParams(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            int indexOf = str.indexOf("?");
            return indexOf > 0 ? str.substring(0, indexOf) : str;
        }
        return (String) invokeL.objValue;
    }
}
