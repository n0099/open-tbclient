package com.baidu.android.common.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.android.common.security.MD5Util;
import com.meizu.cloud.pushsdk.constants.PushConstants;
/* loaded from: classes.dex */
public final class Util {
    private Util() {
    }

    public static boolean hasOtherServiceRuninMyPid(Context context, String str) {
        for (ActivityManager.RunningServiceInfo runningServiceInfo : ((ActivityManager) context.getApplicationContext().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningServices(100)) {
            if (runningServiceInfo.pid == Process.myPid() && !TextUtils.equals(runningServiceInfo.service.getClassName(), str)) {
                return true;
            }
        }
        return false;
    }

    public static String toHexString(byte[] bArr, String str, boolean z) {
        return MD5Util.toHexString(bArr, str, z);
    }

    public static String toMd5(byte[] bArr, boolean z) {
        return MD5Util.toMd5(bArr, z);
    }
}
