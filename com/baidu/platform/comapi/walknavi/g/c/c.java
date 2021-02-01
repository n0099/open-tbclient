package com.baidu.platform.comapi.walknavi.g.c;

import android.app.ActivityManager;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    static Toast f4336a = null;

    public static void a(Context context, String str) {
        List<ActivityManager.RunningTaskInfo> list;
        if (context != null) {
            try {
                list = ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(1);
            } catch (SecurityException e) {
                Log.e("TipTool", "catch SecurityException");
                list = null;
            }
            if (list != null && list.get(0) != null && context.getPackageName().equals(list.get(0).baseActivity.getPackageName())) {
                if (f4336a != null) {
                    f4336a.cancel();
                }
                f4336a = Toast.makeText(context, str, str.length() > 15 ? 1 : 0);
                f4336a.show();
            }
        }
    }
}
