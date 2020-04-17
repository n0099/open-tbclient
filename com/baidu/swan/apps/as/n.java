package com.baidu.swan.apps.as;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.File;
/* loaded from: classes11.dex */
public class n {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String cxz = "aiapps_folder" + File.separator + "feed_back_record.txt";

    public static void J(@NonNull final String str, final boolean z) {
        m.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.as.n.1
            @Override // java.lang.Runnable
            public void run() {
                String str2 = AppRuntime.getAppContext().getFilesDir().getPath() + File.separator + n.cxz;
                if (n.DEBUG) {
                    Log.d("SwanAppFeedbackUtils", "recordFeedbackExtInfo: " + str);
                }
                com.baidu.swan.apps.v.a.j(str2, str, z);
            }
        }, "record_feedback_ext_info");
    }
}
