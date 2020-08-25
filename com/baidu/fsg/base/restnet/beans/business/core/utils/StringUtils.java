package com.baidu.fsg.base.restnet.beans.business.core.utils;

import android.text.TextUtils;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.regex.Pattern;
/* loaded from: classes10.dex */
public abstract class StringUtils {
    public static String[] toStringArray(Collection<String> collection) {
        if (collection == null) {
            return null;
        }
        return (String[]) collection.toArray(new String[collection.size()]);
    }

    public static long parseLong(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            return 0L;
        }
    }

    public static int parseInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            return 0;
        }
    }

    public static float parseFloat(String str) {
        try {
            return Float.parseFloat(str);
        } catch (Exception e) {
            return 0.0f;
        }
    }

    public static BigDecimal parseBigDeceimal(String str) {
        try {
            return new BigDecimal(str);
        } catch (Exception e) {
            return BigDecimal.ZERO;
        }
    }

    public static BigDecimal yuan2FenBigDeceimal(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        try {
            return new BigDecimal(str).multiply(new BigDecimal("100")).setScale(0);
        } catch (Exception e) {
            return BigDecimal.ZERO;
        }
    }

    public static boolean isAmountMoreThanZero(String str) {
        BigDecimal bigDecimal;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            bigDecimal = new BigDecimal(str);
        } catch (Exception e) {
            bigDecimal = new BigDecimal("0");
        }
        return bigDecimal.compareTo(BigDecimal.ZERO) > 0;
    }

    public static String formatMoneyAmount(String str) {
        if (TextUtils.isEmpty(str)) {
            return "0.00";
        }
        if (str.contains(".")) {
            int indexOf = str.indexOf(".");
            String substring = str.substring(indexOf + 1);
            String substring2 = str.substring(0, indexOf);
            if (substring.length() < 2) {
                substring = substring + "0";
            }
            return substring2 + "." + substring;
        }
        return str + ".00";
    }

    public static String yuan2Fen(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        try {
            return String.valueOf(new BigDecimal(str).multiply(new BigDecimal("100")).setScale(0));
        } catch (Exception e) {
            return "0";
        }
    }

    public static BigDecimal fen2YuanBigDecimal(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        return new BigDecimal(str).divide(BigDecimal.valueOf(100L)).setScale(2);
    }

    public static String fen2Yuan(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        return new BigDecimal(str).divide(BigDecimal.valueOf(100L)).setScale(2).toString();
    }

    public static String priceAdd(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "0";
        }
        return new BigDecimal(str).add(new BigDecimal(str2)).toString();
    }

    public static String formatAmount(String str) {
        return fen2Yuan(yuan2Fen(str));
    }

    public static String trimAll(String str) {
        return !TextUtils.isEmpty(str) ? str.replace(" ", "") : "";
    }

    public static boolean isPhoneNumber(String str) {
        return Pattern.compile("^1[0-9]{10}$").matcher(str).matches();
    }

    public static boolean isEmail(String str) {
        return Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$").matcher(str).matches();
    }

    public static boolean isBankCardNumber(String str) {
        return Pattern.compile("^[1-9][0-9]{5,31}$").matcher(str).matches();
    }

    public static String formatPhoneNumber(String str) {
        StringBuffer stringBuffer;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int length = str.length();
        StringBuffer stringBuffer2 = new StringBuffer();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt >= '0' && charAt <= '9') {
                stringBuffer2.append(charAt);
            }
        }
        if (stringBuffer2.length() > 11) {
            stringBuffer = new StringBuffer(stringBuffer2.substring(stringBuffer2.length() - 11));
        } else if (stringBuffer2.length() < 11) {
            return null;
        } else {
            stringBuffer = stringBuffer2;
        }
        stringBuffer.insert(7, ' ');
        stringBuffer.insert(3, ' ');
        return stringBuffer.toString();
    }

    public static String replaceBom(String str) {
        if (!TextUtils.isEmpty(str) && str != null && str.startsWith("\ufeff")) {
            return str.substring(1);
        }
        return str;
    }
}
