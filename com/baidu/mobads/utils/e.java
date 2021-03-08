package com.baidu.mobads.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.webkit.WebView;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class e {
    public static WebView a(Activity activity, Context context) {
        String str;
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                Iterator<ActivityManager.RunningAppProcessInfo> it = ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        str = null;
                        break;
                    }
                    ActivityManager.RunningAppProcessInfo next = it.next();
                    if (next.pid == Process.myPid()) {
                        str = next.processName;
                        break;
                    }
                }
                if (!TextUtils.isEmpty(str) && !TextUtils.equals(context.getApplicationInfo().packageName, str)) {
                    System.out.println("proxy add data " + str);
                    WebView.setDataDirectorySuffix(str);
                }
            } catch (Throwable th) {
                System.out.println("proxy add data error");
                th.printStackTrace();
            }
        }
        return new WebView(activity);
    }
}
