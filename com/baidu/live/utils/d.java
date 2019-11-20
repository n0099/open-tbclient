package com.baidu.live.utils;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceConstant;
import com.tencent.connect.common.Constants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
public class d {
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0199, code lost:
        if ((r8.getTime().getTime() - r9.parse(r10).getTime()) < 0) goto L58;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String cT(String str) {
        String substring;
        String substring2;
        int i = 0;
        String[] strArr = {"1", "0", "X", "9", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, "7", "6", "5", "4", "3", "2"};
        String[] strArr2 = {"7", "9", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, "5", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, "4", "2", "1", "6", "3", "7", "9", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, "5", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, "4", "2"};
        String str2 = "";
        if (str.length() != 15 && str.length() != 18) {
            return "身份证号错误";
        }
        if (str.length() == 18) {
            str2 = str.substring(0, 17);
        } else if (str.length() == 15) {
            str2 = str.substring(0, 6) + Constants.VIA_ACT_TYPE_NINETEEN + str.substring(6, 15);
        }
        if (!cU(str2)) {
            return "身份证号错误";
        }
        String substring3 = str2.substring(6, 10);
        substring = str2.substring(10, 12);
        substring2 = str2.substring(12, 14);
        if (!cV(substring3 + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + substring + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + substring2)) {
            return "身份证号错误";
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            String str3 = substring3 + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + substring + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + substring2;
            if (gregorianCalendar.get(1) - Integer.parseInt(substring3) <= 150) {
            }
            return "身份证号错误";
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (ParseException e2) {
            e2.printStackTrace();
        }
        if (Integer.parseInt(substring) > 12 || Integer.parseInt(substring) == 0) {
            return "身份证号错误";
        }
        if (Integer.parseInt(substring2) > 31 || Integer.parseInt(substring2) == 0) {
            return "身份证号错误";
        }
        if (wq().get(str2.substring(0, 2)) == null) {
            return "身份证号错误";
        }
        for (int i2 = 0; i2 < 17; i2++) {
            i += Integer.parseInt(String.valueOf(str2.charAt(i2))) * Integer.parseInt(strArr2[i2]);
        }
        String str4 = str2 + strArr[i % 11];
        if (str.length() == 18 && !str4.equalsIgnoreCase(str)) {
            return "身份证号错误";
        }
        if (!cW(str)) {
            return "未满18岁哦";
        }
        return HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_SUCCESS;
    }

    private static Hashtable wq() {
        Hashtable hashtable = new Hashtable();
        hashtable.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, "北京");
        hashtable.put(Constants.VIA_REPORT_TYPE_SET_AVATAR, "天津");
        hashtable.put(Constants.VIA_REPORT_TYPE_JOININ_GROUP, "河北");
        hashtable.put(Constants.VIA_REPORT_TYPE_MAKE_FRIEND, "山西");
        hashtable.put(Constants.VIA_REPORT_TYPE_WPA_STATE, "内蒙古");
        hashtable.put(Constants.VIA_REPORT_TYPE_QQFAVORITES, "辽宁");
        hashtable.put(Constants.VIA_REPORT_TYPE_DATALINE, "吉林");
        hashtable.put(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "黑龙江");
        hashtable.put("31", "上海");
        hashtable.put("32", "江苏");
        hashtable.put("33", "浙江");
        hashtable.put("34", "安徽");
        hashtable.put("35", "福建");
        hashtable.put("36", "江西");
        hashtable.put("37", "山东");
        hashtable.put("41", "河南");
        hashtable.put("42", "湖北");
        hashtable.put("43", "湖南");
        hashtable.put("44", "广东");
        hashtable.put("45", "广西");
        hashtable.put("46", "海南");
        hashtable.put("50", "重庆");
        hashtable.put("51", "四川");
        hashtable.put("52", "贵州");
        hashtable.put("53", "云南");
        hashtable.put("54", "西藏");
        hashtable.put("61", "陕西");
        hashtable.put("62", "甘肃");
        hashtable.put("63", "青海");
        hashtable.put("64", "宁夏");
        hashtable.put("65", "新疆");
        hashtable.put("71", "台湾");
        hashtable.put("81", "香港");
        hashtable.put("82", "澳门");
        hashtable.put("91", "国外");
        return hashtable;
    }

    private static boolean cU(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public static boolean cV(String str) {
        return Pattern.compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$").matcher(str).matches();
    }

    public static boolean cW(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 15) {
            return false;
        }
        try {
            Date parse = new SimpleDateFormat("yyyyMMdd").parse(String.valueOf(Integer.parseInt(str.substring(6, 10)) + 18) + str.substring(10, 14));
            Date date = new Date();
            Log.e("pengfei07", "isGrownUp true");
            return date.after(parse);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("pengfei07", "isGrownUp false");
            return false;
        }
    }
}
