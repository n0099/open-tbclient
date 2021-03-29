package com.baidu.android.common.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import d.b.j.f;
/* loaded from: classes.dex */
public final class Util {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f2526a = false;

    /* renamed from: b  reason: collision with root package name */
    public static final String f2527b = "Util";

    public static boolean hasOtherServiceRuninMyPid(Context context, String str) {
        for (ActivityManager.RunningServiceInfo runningServiceInfo : ((ActivityManager) context.getApplicationContext().getSystemService("activity")).getRunningServices(100)) {
            if (runningServiceInfo.pid == Process.myPid() && !TextUtils.equals(runningServiceInfo.service.getClassName(), str)) {
                return true;
            }
        }
        return false;
    }

    public static String toHexString(byte[] bArr, String str, boolean z) {
        return f.c.a(bArr, str, z);
    }

    public static String toMd5(byte[] bArr, boolean z) {
        return f.c.b(bArr, z);
    }
}
