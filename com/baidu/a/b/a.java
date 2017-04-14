package com.baidu.a.b;

import android.content.Context;
import android.os.Process;
/* loaded from: classes.dex */
public class a {
    public static int P(Context context, String str) {
        if (str == null) {
            throw new IllegalArgumentException("permission is null");
        }
        return context.checkPermission(str, Process.myPid(), Process.myUid());
    }

    public static boolean Q(Context context, String str) {
        return P(context, str) == 0;
    }

    public static boolean R(Context context, String str) {
        return P(context, str) == -1;
    }
}
