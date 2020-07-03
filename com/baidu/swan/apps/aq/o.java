package com.baidu.swan.apps.aq;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.File;
/* loaded from: classes11.dex */
public class o {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String cOF = "aiapps_folder" + File.separator + "feed_back_record.txt";

    public static void Y(@NonNull final String str, final boolean z) {
        n.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.aq.o.1
            @Override // java.lang.Runnable
            public void run() {
                String str2 = AppRuntime.getAppContext().getFilesDir().getPath() + File.separator + o.cOF;
                if (o.DEBUG) {
                    Log.d("SwanAppFeedbackUtils", "recordFeedbackExtInfo: " + str);
                }
                com.baidu.swan.apps.t.a.l(str2, str, z);
            }
        }, "record_feedback_ext_info");
    }
}
