package com.baidu.swan.d;

import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes10.dex */
public class h {
    public static String qV(String str) {
        int atQ = a.atQ();
        int atR = a.atR();
        int densityDpi = a.getDensityDpi();
        String os = a.getOS();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(atQ);
        stringBuffer.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        stringBuffer.append(atR);
        stringBuffer.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        stringBuffer.append(os);
        stringBuffer.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        stringBuffer.append(str);
        stringBuffer.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        stringBuffer.append(densityDpi);
        return stringBuffer.toString();
    }

    public static String addParam(String str, String str2, String str3) {
        StringBuilder sb;
        StringBuilder sb2;
        String str4 = null;
        if (!TextUtils.isEmpty(str)) {
            String str5 = str2 + ETAG.EQUAL;
            int indexOf = str.indexOf("?");
            if (indexOf < 0) {
                int indexOf2 = str.indexOf("#");
                if (indexOf2 < 0) {
                    sb2 = new StringBuilder(str);
                } else {
                    str4 = str.substring(indexOf2);
                    sb2 = new StringBuilder(str.substring(0, indexOf2));
                }
                sb2.append("?").append(str5).append(str3);
                if (str4 != null) {
                    sb2.append(str4);
                }
                return sb2.toString();
            } else if (str.indexOf(ETAG.ITEM_SEPARATOR + str5, indexOf) < 0 && str.indexOf("?" + str5, indexOf) < 0) {
                int indexOf3 = str.indexOf("#");
                if (indexOf3 < 0) {
                    sb = new StringBuilder(str);
                } else {
                    str4 = str.substring(indexOf3);
                    str = str.substring(0, indexOf3);
                    sb = new StringBuilder(str);
                }
                if (!str.endsWith(ETAG.ITEM_SEPARATOR) && !str.endsWith("?")) {
                    sb.append(ETAG.ITEM_SEPARATOR);
                }
                sb.append(str5).append(str3);
                if (str4 != null) {
                    sb.append(str4);
                }
                return sb.toString();
            } else {
                return str;
            }
        }
        return str;
    }
}
