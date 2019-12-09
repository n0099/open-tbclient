package com.baidu.sofire.i;

import android.content.Context;
import android.os.Process;
/* loaded from: classes2.dex */
public final class q {
    public static boolean a(Context context, String[] strArr) {
        for (int i = 0; i <= 0; i++) {
            try {
                if (context.checkPermission(strArr[0], Process.myPid(), Process.myUid()) == -1) {
                    return false;
                }
            } catch (Throwable th) {
                d.a();
                return false;
            }
        }
        return true;
    }
}
