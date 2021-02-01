package com.baidu.swan.apps;

import android.app.Activity;
import android.app.ActivityManager;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class SwanRelayActivity extends Activity {
    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        ActivityManager activityManager;
        List<ActivityManager.AppTask> appTasks;
        super.onCreate(bundle);
        int intExtra = getIntent().getIntExtra("key_task_id", 0);
        if (intExtra > 0 && (activityManager = (ActivityManager) getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) != null && (appTasks = activityManager.getAppTasks()) != null && !appTasks.isEmpty()) {
            Iterator<ActivityManager.AppTask> it = appTasks.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityManager.AppTask next = it.next();
                if (next != null && next.getTaskInfo() != null && next.getTaskInfo().id == intExtra) {
                    next.moveToFront();
                    break;
                }
            }
        }
        finish();
    }
}
