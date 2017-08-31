package com.baidu.sofire.rp.f;

import android.content.Context;
import android.os.Process;
/* loaded from: classes.dex */
public final class j {
    public static boolean b(Context context, String[] strArr) {
        if (strArr != null) {
            for (String str : strArr) {
                if (context.checkPermission(str, Process.myPid(), Process.myUid()) == -1) {
                    return false;
                }
            }
        }
        return true;
    }
}
