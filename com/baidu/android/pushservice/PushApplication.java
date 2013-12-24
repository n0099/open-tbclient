package com.baidu.android.pushservice;

import android.app.ActivityManager;
import android.app.Application;
import android.os.Process;
import com.baidu.android.silentupdate.SilentManager;
/* loaded from: classes.dex */
public class PushApplication extends Application {
    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        SilentManager.enableDebugMode(true);
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) getSystemService("activity")).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == myPid && !runningAppProcessInfo.processName.endsWith(getPackageName())) {
                SilentManager.setKey("key");
                SilentManager.loadLib(getApplicationContext(), "plugin", "pushservice.jar");
            }
        }
    }
}
