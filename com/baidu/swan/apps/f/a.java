package com.baidu.swan.apps.f;

import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.swan.apps.u.c.b;
/* loaded from: classes10.dex */
public class a {
    @Deprecated
    public static boolean lr(String str) {
        return (TextUtils.isEmpty(str) || str.contains(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)) ? false : true;
    }

    public static boolean a(b bVar) {
        return bVar != null && bVar.getType() == 0;
    }

    public static boolean b(b bVar) {
        return bVar != null && bVar.getType() == 1;
    }

    public static boolean c(b bVar) {
        return bVar != null && bVar.getType() == 2;
    }

    public static int ls(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (str.contains("_dev")) {
            return 1;
        }
        if (str.endsWith("_trial")) {
            return 3;
        }
        return str.contains("_trial") ? 2 : 0;
    }

    public static String lt(String str) {
        if (!TextUtils.isEmpty(str)) {
            int indexOf = str.indexOf("_dev");
            if (indexOf > 0) {
                return str.substring(0, indexOf);
            }
            int indexOf2 = str.indexOf("_trial");
            if (indexOf2 > 0) {
                return str.substring(0, indexOf2);
            }
            return str;
        }
        return str;
    }

    public static String lu(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf("_dev");
        if (lastIndexOf >= 0 && lastIndexOf < str.length()) {
            return str.substring(lastIndexOf);
        }
        int lastIndexOf2 = str.lastIndexOf("_trial");
        if (lastIndexOf2 >= 0 && lastIndexOf2 < str.length()) {
            return str.substring(lastIndexOf2);
        }
        return "";
    }
}
