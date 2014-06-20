package com.baidu.android.nebula.a;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
/* loaded from: classes.dex */
public final class f {
    private f() {
    }

    public static String a(byte[] bArr, boolean z) {
        return c.a(bArr, z);
    }

    public static boolean a(Context context, String str) {
        for (ActivityManager.RunningServiceInfo runningServiceInfo : ((ActivityManager) context.getApplicationContext().getSystemService("activity")).getRunningServices(100)) {
            if (runningServiceInfo.pid == Process.myPid() && !TextUtils.equals(runningServiceInfo.service.getClassName(), str)) {
                return true;
            }
        }
        return false;
    }
}
