package com.baidu.sofire.i;

import android.content.Context;
import android.os.Process;
/* loaded from: classes14.dex */
public final class s {
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
}
