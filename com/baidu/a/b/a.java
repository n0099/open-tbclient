package com.baidu.a.b;

import android.content.Context;
import android.os.Process;
/* loaded from: classes.dex */
public class a {
    public static int r(Context context, String str) {
        if (str == null) {
            throw new IllegalArgumentException("permission is null");
        }
        return context.checkPermission(str, Process.myPid(), Process.myUid());
    }

    public static boolean s(Context context, String str) {
        return r(context, str) == 0;
    }

    public static boolean t(Context context, String str) {
        return r(context, str) == -1;
    }
}
