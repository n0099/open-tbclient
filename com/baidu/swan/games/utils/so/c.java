package com.baidu.swan.games.utils.so;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.statistic.c;
import com.baidu.swan.games.utils.so.SoUtils;
import java.io.File;
import java.util.Arrays;
import java.util.Locale;
/* loaded from: classes11.dex */
public class c implements SoUtils.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    @Override // com.baidu.swan.games.utils.so.SoUtils.a
    public void onEvent(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            String str3 = Arrays.toString(new String[]{Build.CPU_ABI, Build.CPU_ABI2}) + "\n" + com.baidu.swan.apps.c.getVersion() + "\n" + sG("v8.engine") + "\n" + sG("zeusv8") + "\n" + str2;
            if (DEBUG) {
                Log.d("SoUbcDefaultImpl", "reportSoLoadInfo: " + str3);
            }
            new c.a(10007).oq(str).os(str3).or(com.baidu.swan.apps.runtime.e.aoH()).ahn();
        }
    }

    private String sG(String str) {
        File findSoFilesInLibrary = SoLoader.findSoFilesInLibrary(com.baidu.swan.apps.u.a.aeR(), str);
        return String.format(Locale.CHINA, "[%s:%s,size:%d]", str, findSoFilesInLibrary == null ? null : findSoFilesInLibrary.getAbsolutePath(), Long.valueOf(findSoFilesInLibrary == null ? 0L : findSoFilesInLibrary.length()));
    }
}
