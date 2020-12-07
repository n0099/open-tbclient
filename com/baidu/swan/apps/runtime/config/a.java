package com.baidu.swan.apps.runtime.config;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.r.d;
import java.io.File;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes25.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Map<String, c> dyN = null;

    public c a(String str, String str2, @NonNull c cVar) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return cVar;
        }
        if (this.dyN == null) {
            this.dyN = new TreeMap();
        }
        c cVar2 = this.dyN.get(str2);
        if (cVar2 == null) {
            c c = c(str, str2, cVar);
            this.dyN.put(str2, c);
            return c;
        }
        return cVar2;
    }

    public c b(String str, @NonNull String str2, @NonNull c cVar) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            c c = c(str, str2, cVar);
            this.dyN.put(str2, c);
            return c;
        }
        return cVar;
    }

    private c c(String str, String str2, @NonNull c cVar) {
        String cx = cx(str, str2);
        return TextUtils.isEmpty(cx) ? cVar : c.a(cx, cVar);
    }

    public static String cx(String str, String str2) {
        String str3;
        if (str.endsWith(File.separator)) {
            str3 = str + str2 + ".json";
        } else {
            str3 = str + File.separator + str2 + ".json";
        }
        File file = new File(str3);
        if (DEBUG) {
            Log.d("PageConfigData", "parseConfigFile baseUrl : " + str + " ,page: " + str2 + " file exist:" + file.exists());
        }
        if (!file.exists()) {
            return null;
        }
        return d.x(file);
    }
}
