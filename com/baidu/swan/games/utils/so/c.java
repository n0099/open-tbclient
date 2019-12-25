package com.baidu.swan.games.utils.so;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.statistic.a;
import com.baidu.swan.games.utils.so.SoUtils;
import java.io.File;
import java.util.Arrays;
import java.util.Locale;
/* loaded from: classes9.dex */
public class c implements SoUtils.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    @Override // com.baidu.swan.games.utils.so.SoUtils.a
    public void onEvent(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            String str3 = Arrays.toString(new String[]{Build.CPU_ABI, Build.CPU_ABI2}) + "\n" + com.baidu.swan.apps.c.getVersion() + "\n" + py("v8.engine") + "\n" + py("zeusv8") + "\n" + str2;
            if (DEBUG) {
                Log.d("SoUbcDefaultImpl", "reportSoLoadInfo: " + str3);
            }
            new a.C0285a(10007).ll(str).ln(str3).lm(com.baidu.swan.apps.runtime.e.ZU()).Tz();
        }
    }

    private String py(String str) {
        File findSoFilesInLibrary = SoLoader.findSoFilesInLibrary(com.baidu.swan.apps.w.a.Rk(), str);
        return String.format(Locale.CHINA, "[%s:%s,size:%d]", str, findSoFilesInLibrary == null ? null : findSoFilesInLibrary.getAbsolutePath(), Long.valueOf(findSoFilesInLibrary == null ? 0L : findSoFilesInLibrary.length()));
    }
}
