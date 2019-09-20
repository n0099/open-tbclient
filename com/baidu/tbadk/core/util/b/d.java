package com.baidu.tbadk.core.util.b;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
import java.net.URL;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class d {
    public static String getHost(String str) {
        int indexOf;
        int max;
        if (k.isEmpty(str)) {
            return "";
        }
        try {
            return new URL(str).getHost();
        } catch (Exception e) {
            BdLog.e(e);
            if (!str.startsWith(HttpHost.DEFAULT_SCHEME_NAME) || (indexOf = str.indexOf(":")) == -1) {
                return "";
            }
            int i = indexOf + 3;
            int indexOf2 = str.indexOf(":", i);
            int indexOf3 = str.indexOf("/", i);
            if (indexOf2 == -1 || indexOf3 == -1) {
                max = Math.max(indexOf2, indexOf3);
            } else {
                max = Math.min(indexOf2, indexOf3);
            }
            if (max == -1 && i < str.length()) {
                return str.substring(i);
            }
            if (i != -1 && i < max) {
                return str.substring(i, max);
            }
            return "";
        }
    }
}
