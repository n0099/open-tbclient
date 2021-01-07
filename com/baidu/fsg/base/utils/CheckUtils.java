package com.baidu.fsg.base.utils;

import android.annotation.SuppressLint;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.fsg.base.ApollonConstants;
import com.baidu.webkit.internal.ETAG;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
public final class CheckUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2016a = "CheckUtils";

    /* renamed from: b  reason: collision with root package name */
    private static final int f2017b = 3;
    private static final int c = 12;
    private static final int d = 4;
    private static long e;

    private CheckUtils() {
    }

    public static final String stripUrlParams(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int indexOf = str.indexOf("?");
        if (indexOf > 0) {
            return str.substring(0, indexOf);
        }
        return str;
    }

    public static boolean isIDcardAvailable(String str) {
        return Pattern.compile("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}[\\dxX]$|^[1-9]\\d{5}\\d{2}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$").matcher(str).matches();
    }

    public static boolean isUserNameAvailable(String str) {
        return str != null && str.length() >= 2 && str.length() <= 40;
    }

    public static boolean isBandCardAvailable(String str) {
        return Pattern.compile("^\\d{15,20}$").matcher(str).matches();
    }

    public static boolean isBandCardEndAvailable(String str) {
        return str != null && str.length() == 3;
    }

    public static boolean isYearValid(String str) {
        return Pattern.compile("^\\d{2}$").matcher(str).matches();
    }

    public static boolean isMonthValid(String str) {
        try {
            int intValue = Integer.valueOf(str).intValue();
            if (intValue > 12 || intValue < 1) {
                return false;
            }
            return Pattern.compile("^\\d{2}$").matcher(str).matches();
        } catch (Exception e2) {
            return false;
        }
    }

    public static boolean isPayPasswordAvailable(String str) {
        return Pattern.compile("[~!@#$%^&*()+-=\\[\\]\\{}|;':\",./<>?0-9a-zA-z]*").matcher(str).matches();
    }

    public static boolean isMobileAvailable(String str) {
        return Pattern.compile("^1[0-9]{10}$").matcher(str).matches();
    }

    public static boolean isVodeAvailable(String str) {
        return !TextUtils.isEmpty(str) && str.length() >= 4;
    }

    @SuppressLint({"DefaultLocale"})
    public static boolean checkParams(String str) {
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
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            for (String str31 : str.toUpperCase().split(ETAG.ITEM_SEPARATOR)) {
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
        } catch (Exception e2) {
            return false;
        }
    }

    public static boolean isShowExitDialog(int i) {
        return false;
    }

    public static boolean isExternalStorageWriteable() {
        boolean z = false;
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
                    } catch (IOException e2) {
                        if (ApollonConstants.DEBUG) {
                            Log.w(f2016a, "isExternalStorageWriteable() can't create test file.");
                        }
                    }
                }
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (ApollonConstants.DEBUG) {
            Log.i(f2016a, "Utility.isExternalStorageWriteable(" + z + ") cost " + (currentTimeMillis2 - currentTimeMillis) + "ms.");
        }
        return z;
    }

    public static boolean isFastDoubleClick() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - e;
        LogUtil.logd("timeD=" + j);
        if (0 < j && j < 500) {
            LogUtil.logd("点的太快了 timeD=" + j);
            return true;
        }
        e = currentTimeMillis;
        return false;
    }
}
