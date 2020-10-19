package com.baidu.platform.comapi.walknavi.g.d;

import android.app.ActivityManager;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.List;
/* loaded from: classes7.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    static Toast f3055a = null;

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
                if (f3055a != null) {
                    f3055a.cancel();
                }
                f3055a = Toast.makeText(context, str, str.length() > 15 ? 1 : 0);
                f3055a.show();
            }
        }
    }
}
