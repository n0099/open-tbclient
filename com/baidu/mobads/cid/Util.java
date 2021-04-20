package com.baidu.mobads.cid;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.mobads.cid.cesium.d.b;
/* loaded from: classes2.dex */
public final class Util {
    public static boolean hasOtherServiceRuninMyPid(Context context, String str) {
        for (ActivityManager.RunningServiceInfo runningServiceInfo : ((ActivityManager) context.getApplicationContext().getSystemService("activity")).getRunningServices(100)) {
            if (runningServiceInfo.pid == Process.myPid() && !TextUtils.equals(runningServiceInfo.service.getClassName(), str)) {
                return true;
            }
        }
        return false;
    }

    public static String toHexString(byte[] bArr, String str, boolean z) {
        return b.a(bArr, str, z);
    }

    public static String toMd5(byte[] bArr, boolean z) {
        return b.a(bArr, z);
    }
}
