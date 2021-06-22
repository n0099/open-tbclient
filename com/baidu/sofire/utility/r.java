package com.baidu.sofire.utility;

import android.content.Context;
import android.os.Process;
/* loaded from: classes2.dex */
public final class r {
    public static boolean a(Context context, String[] strArr) {
        for (int i2 = 0; i2 <= 0; i2++) {
            try {
                if (context.checkPermission(strArr[0], Process.myPid(), Process.myUid()) == -1) {
                    return false;
                }
            } catch (Throwable unused) {
                c.a();
                return false;
            }
        }
        return true;
    }

    public static boolean b(Context context) {
        try {
            return context.checkPermission("android.permission.READ_EXTERNAL_STORAGE", Process.myPid(), Process.myUid()) != -1;
        } catch (Throwable unused) {
            c.a();
            return false;
        }
    }

    public static boolean a(Context context) {
        try {
            return context.checkPermission("android.permission.READ_PHONE_STATE", Process.myPid(), Process.myUid()) != -1;
        } catch (Throwable unused) {
            c.a();
            return false;
        }
    }
}
