package com.baidu.swan.apps.ao;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.File;
/* loaded from: classes9.dex */
public class q {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String dOW = "aiapps_folder" + File.separator + "feed_back_record.txt";

    public static void ai(@NonNull final String str, final boolean z) {
        p.a(new Runnable() { // from class: com.baidu.swan.apps.ao.q.1
            @Override // java.lang.Runnable
            public void run() {
                String str2 = AppRuntime.getAppContext().getFilesDir().getPath() + File.separator + q.dOW;
                if (q.DEBUG) {
                    Log.d("SwanAppFeedbackUtils", "recordFeedbackExtInfo: " + str);
                }
                com.baidu.swan.apps.s.a.p(str2, str, z);
            }
        }, "record_feedback_ext_info");
    }
}
