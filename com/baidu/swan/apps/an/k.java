package com.baidu.swan.apps.an;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.File;
/* loaded from: classes2.dex */
public class k {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String aZX = "aiapps_folder" + File.separator + "feed_back_record.txt";

    public static void x(@NonNull final String str, final boolean z) {
        j.a(new Runnable() { // from class: com.baidu.swan.apps.an.k.1
            @Override // java.lang.Runnable
            public void run() {
                String str2 = AppRuntime.getAppContext().getFilesDir().getPath() + File.separator + k.aZX;
                if (k.DEBUG) {
                    Log.d("SwanAppFeedbackUtils", "recordFeedbackExtInfo: " + str);
                }
                com.baidu.swan.apps.t.a.e(str2, str, z);
            }
        }, "record_feedback_ext_info");
    }
}
