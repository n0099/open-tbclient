package com.baidu.swan.apps.runtime.config;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.r.d;
import java.io.File;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes8.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Map<String, c> cQM = null;

    public c a(String str, String str2, @NonNull c cVar) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return cVar;
        }
        if (this.cQM == null) {
            this.cQM = new TreeMap();
        }
        c cVar2 = this.cQM.get(str2);
        if (cVar2 == null) {
            c c = c(str, str2, cVar);
            this.cQM.put(str2, c);
            return c;
        }
        return cVar2;
    }

    public c b(String str, @NonNull String str2, @NonNull c cVar) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            c c = c(str, str2, cVar);
            this.cQM.put(str2, c);
            return c;
        }
        return cVar;
    }

    private c c(String str, String str2, @NonNull c cVar) {
        String cf = cf(str, str2);
        return TextUtils.isEmpty(cf) ? cVar : c.a(cf, cVar);
    }

    public static String cf(String str, String str2) {
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
        return d.v(file);
    }
}
