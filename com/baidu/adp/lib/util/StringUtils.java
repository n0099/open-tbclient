package com.baidu.adp.lib.util;

import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class StringUtils {
    public static final String PASSWORD_PREFIX = "((?=.*\\d)(?=.*[a-zA-Z]).{6,20})";
    public static final String TIMEFORMAT = "yyyy-MM-dd HH:mm";
    public static final String lineSeparator = System.getProperty("line.separator");

    public static String SimpleDateFormat(Date date) {
        if (date == null) {
            return null;
        }
        return new SimpleDateFormat(TIMEFORMAT).format(date);
    }

    public static final void clearStringBuilder(StringBuilder sb) {
        if (sb == null || sb.length() <= 0) {
            return;
        }
        sb.delete(0, sb.length());
    }

    public static long getyyyyMMddHHTimeForNow() {
        Calendar calendar = Calendar.getInstance();
        return (calendar.get(1) * 1000000) + 0 + ((calendar.get(2) + 1) * 10000) + (calendar.get(5) * 100) + calendar.get(11);
    }

    public static Date handleDate(String str) {
        return handleDate(str, TIMEFORMAT);
    }

    public static boolean isChinese(char c2) {
        return Pattern.compile("[一-龥]").matcher(String.valueOf(c2)).find();
    }

    public static boolean isJSONArray(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                if (jSONArray.getJSONObject(0) != null) {
                    return true;
                }
            }
        } catch (Error | Exception unused) {
        }
        return false;
    }

    @Deprecated
    public static boolean isNULL(String str) {
        return str == null;
    }

    public static boolean isNull(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean isValidPassWord(String str) {
        if (TextUtils.isEmpty(str) || str.contains(" ")) {
            return false;
        }
        return str.matches(PASSWORD_PREFIX);
    }

    public static final String string(Object... objArr) {
        if (objArr != null) {
            StringBuffer stringBuffer = new StringBuffer();
            for (Object obj : objArr) {
                if (obj != null) {
                    if (obj instanceof String) {
                        stringBuffer.append((String) obj);
                    } else {
                        stringBuffer.append(String.valueOf(obj));
                    }
                }
            }
            return stringBuffer.toString();
        }
        return "";
    }

    public static String translateSecondsToString(int i) {
        if (i <= 0) {
            return "00:00";
        }
        int i2 = i / 60;
        if (i2 < 60) {
            return unitFormat(i2) + ":" + unitFormat(i % 60);
        }
        int i3 = i2 / 60;
        if (i3 > 99) {
            return "99:59:59";
        }
        int i4 = i2 % 60;
        return unitFormat(i3) + ":" + unitFormat(i4) + ":" + unitFormat((i - (i3 * 3600)) - (i4 * 60));
    }

    public static String unitFormat(int i) {
        if (i >= 0 && i < 10) {
            return "0" + Integer.toString(i);
        }
        return "" + i;
    }

    public static Date handleDate(String str, String str2) {
        if (str2 == null) {
            str2 = TIMEFORMAT;
        }
        if (str != null && str.length() != 0) {
            try {
                return new SimpleDateFormat(str2).parse(str);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static boolean isNull(String str, boolean z) {
        boolean z2 = str == null || str.trim().length() == 0;
        if (z2 || !z || str == null || !str.equalsIgnoreCase(StringUtil.NULL_STRING)) {
            return z2;
        }
        return true;
    }

    public static String SimpleDateFormat(Date date, String str) {
        if (date == null) {
            return null;
        }
        if (str == null) {
            str = TIMEFORMAT;
        }
        return new SimpleDateFormat(str).format(date);
    }
}
