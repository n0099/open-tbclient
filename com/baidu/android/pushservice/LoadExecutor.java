package com.baidu.android.pushservice;

import android.content.Context;
import com.baidu.android.silentupdate.SilentManager;
/* loaded from: classes.dex */
public class LoadExecutor {
    private static final String a = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCYAFbG0oYmKgh6o7BhZIHf1njBpZXqyWBnYz2ip3Wp+s97OeA/pTe8xebuGJHwq4xbsGQrJWepIbUVrdjm6JRmdvuJhar7/hC/UNnUkJgYdYl10OZKlvcFFgK3V7XGBPplXldDnhbgscna3JG8U3025WSxZCP5vy/8cfxsEoVx5QIDAQAB";

    public static synchronized boolean loadPush(Context context) {
        boolean loadLib;
        synchronized (LoadExecutor.class) {
            try {
                context.getClassLoader().loadClass("com.baidu.android.pushservice.internal.PushManager");
                loadLib = true;
            } catch (ClassNotFoundException e) {
                SilentManager.setKey(a);
                loadLib = SilentManager.loadLib(context.getApplicationContext(), "frontia_plugin", "plugin-deploy.jar");
            }
        }
        return loadLib;
    }

    public static boolean isPushLibLoaded(Context context) {
        try {
            context.getClassLoader().loadClass("com.baidu.android.pushservice.internal.PushManager");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.baidu.android.pushservice.LoadExecutor$1] */
    public static void excuteMethod(final Runnable runnable, final Context context) {
        if (isPushLibLoaded(context)) {
            runnable.run();
        } else {
            new Thread() { // from class: com.baidu.android.pushservice.LoadExecutor.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    if (LoadExecutor.loadPush(context)) {
                        runnable.run();
                    }
                }
            }.start();
        }
    }
}
