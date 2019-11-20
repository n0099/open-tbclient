package com.baidu.swan.apps.ae.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Map<String, d> bkc = null;

    public d a(String str, String str2, @NonNull d dVar) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return dVar;
        }
        if (this.bkc == null) {
            this.bkc = new TreeMap();
        }
        d dVar2 = this.bkc.get(str2);
        if (dVar2 == null) {
            d b = b(str, str2, dVar);
            this.bkc.put(str2, b);
            return b;
        }
        return dVar2;
    }

    private d b(String str, String str2, @NonNull d dVar) {
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
        if (file.exists()) {
            String l = com.baidu.swan.c.a.l(file);
            return !TextUtils.isEmpty(l) ? d.a(l, dVar) : dVar;
        }
        return dVar;
    }
}
