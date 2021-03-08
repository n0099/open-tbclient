package com.baidu.l.b;

import android.content.Context;
import android.os.Process;
/* loaded from: classes5.dex */
public class a {
    public static int checkSelfPermission(Context context, String str) {
        if (str == null) {
            throw new IllegalArgumentException("permission is null");
        }
        return context.checkPermission(str, Process.myPid(), Process.myUid());
    }

    public static boolean checkPermissionGranted(Context context, String str) {
        return checkSelfPermission(context, str) == 0;
    }

    public static boolean T(Context context, String str) {
        return checkSelfPermission(context, str) == -1;
    }
}
