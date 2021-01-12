package com.baidu.live.tbadk.util;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.webkit.internal.ETAG;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Map;
/* loaded from: classes10.dex */
public class WebviewHelper {
    public static final String TAG = "WebviewHelper";

    public static String getMatchStringFromURL(String str, String str2) {
        int indexOf = str.indexOf(str2);
        if (indexOf != -1) {
            int length = str2.length() + indexOf;
            int i = length;
            while (i < str.length() && str.charAt(i) != '&') {
                i++;
            }
            try {
                return URLDecoder.decode(str.substring(length, i));
            } catch (Exception e) {
                BdLog.e(e.toString());
                return "";
            }
        }
        return "";
    }

    public static String getUrlWithoutProtocol(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        if (str.contains("://")) {
            return str.substring(str.lastIndexOf("://") + 3);
        }
        if (str.contains(":?")) {
            return str.substring(str.lastIndexOf(":?") + 2);
        }
        if (str.contains(":")) {
            return str.substring(str.lastIndexOf(":") + 1);
        }
        return str;
    }

    public static String getParamFromURL(String str, String str2) {
        String[] split;
        String str3 = "";
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2) && (split = str.split("[?]")) != null && split.length >= 2) {
            for (int i = 1; i < split.length; i++) {
                String[] split2 = split[i].split(ETAG.ITEM_SEPARATOR);
                if (split2 != null && split2.length > 0) {
                    int length = split2.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 < length) {
                            String[] split3 = split2[i2].split("=");
                            if (split3.length == 2) {
                                String str4 = split3[0];
                                String str5 = split3[1];
                                if (str2.equals(str4)) {
                                    try {
                                        str3 = URLDecoder.decode(str5);
                                        break;
                                    } catch (Exception e) {
                                        str3 = str5;
                                    }
                                }
                            }
                            i2++;
                        }
                    }
                }
            }
        }
        return str3;
    }

    public static Bundle parserQuery(String str) {
        URL url;
        String query;
        String[] split;
        if (StringUtils.isNull(str)) {
            return null;
        }
        Bundle bundle = new Bundle();
        try {
            url = new URL(str);
            query = url.getQuery();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        if (StringUtils.isNull(query) || StringUtils.isNull(url.getPath()) || (split = query.split(ETAG.ITEM_SEPARATOR)) == null) {
            return null;
        }
        bundle.putString("path", url.getPath());
        for (String str2 : split) {
            String[] split2 = str2.split("=");
            if (split2 != null && split2.length == 2 && !StringUtils.isNull(split2[0])) {
                bundle.putString(split2[0], split2[1]);
            }
        }
        return bundle;
    }

    /* loaded from: classes10.dex */
    public static class TiebaCookieInfo {
        public String BDUSS;
        public String PTOKEN;

        public TiebaCookieInfo(String str, String str2) {
            this.BDUSS = "";
            this.PTOKEN = "";
            this.BDUSS = str;
            this.PTOKEN = str2;
        }

        public int hashCode() {
            return (((this.BDUSS == null ? 0 : this.BDUSS.hashCode()) + 31) * 31) + (this.PTOKEN != null ? this.PTOKEN.hashCode() : 0);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                TiebaCookieInfo tiebaCookieInfo = (TiebaCookieInfo) obj;
                if (this.BDUSS == null) {
                    if (tiebaCookieInfo.BDUSS != null) {
                        return false;
                    }
                } else if (!this.BDUSS.equals(tiebaCookieInfo.BDUSS)) {
                    return false;
                }
                return this.PTOKEN == null ? tiebaCookieInfo.PTOKEN == null : this.PTOKEN.equals(tiebaCookieInfo.PTOKEN);
            }
            return false;
        }
    }

    public static String addParamsForPageTranslucent(String str) {
        if (!StringHelper.isEmpty(str) && !str.contains("page_type")) {
            StringBuilder sb = new StringBuilder(str);
            if (str.contains("?")) {
                sb.append(ETAG.ITEM_SEPARATOR);
            } else {
                sb.append("?");
            }
            sb.append("page_type");
            sb.append("=");
            sb.append("open_full_screen_opacity_web_page");
            return sb.toString();
        }
        return str;
    }

    public static String addQueryParams(String str, Map<String, Object> map) {
        if (!TextUtils.isEmpty(str) && map != null && !map.isEmpty()) {
            StringBuilder sb = new StringBuilder(str);
            if (str.contains("?")) {
                sb.append(ETAG.ITEM_SEPARATOR);
            } else {
                sb.append("?");
            }
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (!TextUtils.isEmpty(entry.getKey())) {
                    sb.append(entry.getKey());
                    sb.append("=");
                    sb.append(entry.getValue() != null ? entry.getValue() : "");
                    sb.append(ETAG.ITEM_SEPARATOR);
                }
            }
            if (sb.charAt(sb.length() - 1) == '&') {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        }
        return str;
    }
}
