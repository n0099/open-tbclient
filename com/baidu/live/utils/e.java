package com.baidu.live.utils;

import android.text.TextUtils;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceConstant;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.baidu.searchbox.ui.animview.praise.guide.ControlShowManager;
import com.baidu.tbadk.pay.PayConfig;
import com.tencent.connect.common.Constants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class e {
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0199, code lost:
        if ((r8.getTime().getTime() - r9.parse(r10).getTime()) < 0) goto L58;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String fH(String str) {
        String substring;
        String substring2;
        int i = 0;
        String[] strArr = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};
        String[] strArr2 = {"7", "9", "10", "5", "8", "4", "2", "1", "6", "3", "7", "9", "10", "5", "8", "4", "2"};
        String str2 = "";
        if (str.length() != 15 && str.length() != 18) {
            return "身份证号错误";
        }
        if (str.length() == 18) {
            str2 = str.substring(0, 17);
        } else if (str.length() == 15) {
            str2 = str.substring(0, 6) + Constants.VIA_ACT_TYPE_NINETEEN + str.substring(6, 15);
        }
        if (!fI(str2)) {
            return "身份证号错误";
        }
        String substring3 = str2.substring(6, 10);
        substring = str2.substring(10, 12);
        substring2 = str2.substring(12, 14);
        if (!fJ(substring3 + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + substring + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + substring2)) {
            return "身份证号错误";
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(ControlShowManager.DAY_TIME_FORMAT);
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
        if (HU().get(str2.substring(0, 2)) == null) {
            return "身份证号错误";
        }
        for (int i2 = 0; i2 < 17; i2++) {
            i += Integer.parseInt(String.valueOf(str2.charAt(i2))) * Integer.parseInt(strArr2[i2]);
        }
        String str4 = str2 + strArr[i % 11];
        if (str.length() == 18 && !str4.equalsIgnoreCase(str)) {
            return "身份证号错误";
        }
        if (!fK(str)) {
            return "未满18岁哦";
        }
        return HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_SUCCESS;
    }

    private static Hashtable HU() {
        Hashtable hashtable = new Hashtable();
        hashtable.put("11", "北京");
        hashtable.put("12", "天津");
        hashtable.put(Constants.VIA_REPORT_TYPE_JOININ_GROUP, "河北");
        hashtable.put("14", "山西");
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
        hashtable.put(PayConfig.PAYMENT_POS_KEY_MANGA, "山东");
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
        hashtable.put(UgcUBCUtils.LAND_PAGE_PV, "台湾");
        hashtable.put("81", "香港");
        hashtable.put("82", "澳门");
        hashtable.put("91", "国外");
        return hashtable;
    }

    private static boolean fI(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public static boolean fJ(String str) {
        return Pattern.compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$").matcher(str).matches();
    }

    public static boolean fK(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 15) {
            return false;
        }
        try {
            return new Date().after(new SimpleDateFormat("yyyyMMdd").parse(String.valueOf(Integer.parseInt(str.substring(6, 10)) + 18) + str.substring(10, 14)));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
