package com.baidu.swan.apps.ap;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.File;
/* loaded from: classes10.dex */
public class q {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String dxQ = "aiapps_folder" + File.separator + "feed_back_record.txt";

    public static void ai(@NonNull final String str, final boolean z) {
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.ap.q.1
            @Override // java.lang.Runnable
            public void run() {
                String str2 = AppRuntime.getAppContext().getFilesDir().getPath() + File.separator + q.dxQ;
                if (q.DEBUG) {
                    Log.d("SwanAppFeedbackUtils", "recordFeedbackExtInfo: " + str);
                }
                com.baidu.swan.apps.s.a.l(str2, str, z);
            }
        }, "record_feedback_ext_info");
    }
}
