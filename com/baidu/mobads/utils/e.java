package com.baidu.mobads.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.webkit.WebView;
import java.io.PrintStream;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class e {
    public static WebView a(Activity activity, Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            String str = null;
            try {
                Iterator<ActivityManager.RunningAppProcessInfo> it = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ActivityManager.RunningAppProcessInfo next = it.next();
                    if (next.pid == Process.myPid()) {
                        str = next.processName;
                        break;
                    }
                }
                if (!TextUtils.isEmpty(str) && !TextUtils.equals(context.getApplicationInfo().packageName, str)) {
                    PrintStream printStream = System.out;
                    printStream.println("proxy add data " + str);
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
