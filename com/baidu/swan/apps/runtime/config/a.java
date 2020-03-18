package com.baidu.swan.apps.runtime.config;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes11.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Map<String, c> bPJ = null;

    public c a(String str, String str2, @NonNull c cVar) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return cVar;
        }
        if (this.bPJ == null) {
            this.bPJ = new TreeMap();
        }
        c cVar2 = this.bPJ.get(str2);
        if (cVar2 == null) {
            c b = b(str, str2, cVar);
            this.bPJ.put(str2, b);
            return b;
        }
        return cVar2;
    }

    private c b(String str, String str2, @NonNull c cVar) {
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
            String readFileData = com.baidu.swan.d.c.readFileData(file);
            return !TextUtils.isEmpty(readFileData) ? c.a(readFileData, cVar) : cVar;
        }
        return cVar;
    }
}
