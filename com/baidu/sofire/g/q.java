package com.baidu.sofire.g;

import android.content.Context;
import android.os.Process;
/* loaded from: classes3.dex */
public final class q {
    public static boolean a(Context context) {
        try {
            return context.checkPermission("android.permission.READ_PHONE_STATE", Process.myPid(), Process.myUid()) != -1;
        } catch (Throwable unused) {
            d.a();
            return false;
        }
    }

    public static boolean b(Context context) {
        try {
            return context.checkPermission("android.permission.READ_EXTERNAL_STORAGE", Process.myPid(), Process.myUid()) != -1;
        } catch (Throwable unused) {
            d.a();
            return false;
        }
    }
}
