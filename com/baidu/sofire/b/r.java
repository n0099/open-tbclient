package com.baidu.sofire.b;

import android.content.Context;
import android.os.Process;
/* loaded from: classes2.dex */
public final class r {
    public static boolean a(Context context, String[] strArr) {
        for (int i = 0; i <= 0; i++) {
            try {
                if (context.checkPermission(strArr[0], Process.myPid(), Process.myUid()) == -1) {
                    return false;
                }
            } catch (Throwable th) {
                e.a();
                return false;
            }
        }
        return true;
    }

    public static boolean a(Context context) {
        try {
            return context.checkPermission("android.permission.READ_PHONE_STATE", Process.myPid(), Process.myUid()) != -1;
        } catch (Throwable th) {
            e.a();
            return false;
        }
    }
}
