package com.baidu.frontia;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Process;
import com.baidu.android.silentupdate.SilentManager;
/* loaded from: classes.dex */
public class FrontiaApplication extends Application {
    private static final String a = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCYAFbG0oYmKgh6o7BhZIHf1njBpZXqyWBnYz2ip3Wp+s97OeA/pTe8xebuGJHwq4xbsGQrJWepIbUVrdjm6JRmdvuJhar7/hC/UNnUkJgYdYl10OZKlvcFFgK3V7XGBPplXldDnhbgscna3JG8U3025WSxZCP5vy/8cfxsEoVx5QIDAQAB";

    private static boolean a(Context context) {
        SilentManager.setKey(a);
        SilentManager.enableRSA(false);
        return SilentManager.loadLib(context.getApplicationContext(), "frontia_plugin", "plugin-deploy.jar");
    }

    public static void initFrontia(Context context) {
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == myPid && !runningAppProcessInfo.processName.endsWith(context.getPackageName())) {
                if (!a(context.getApplicationContext())) {
                    Process.killProcess(myPid);
                }
                a(context.getApplicationContext());
            }
        }
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        initFrontia(getApplicationContext());
    }
}
