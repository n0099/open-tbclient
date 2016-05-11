package com.baidu.a.b;

import android.content.Context;
import android.os.Process;
/* loaded from: classes.dex */
public class a {
    public static int q(Context context, String str) {
        if (str == null) {
            throw new IllegalArgumentException("permission is null");
        }
        return context.checkPermission(str, Process.myPid(), Process.myUid());
    }

    public static boolean r(Context context, String str) {
        return q(context, str) == 0;
    }

    public static boolean s(Context context, String str) {
        return q(context, str) == -1;
    }
}
