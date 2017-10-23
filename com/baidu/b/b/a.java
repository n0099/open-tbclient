package com.baidu.b.b;

import android.content.Context;
import android.os.Process;
/* loaded from: classes.dex */
public class a {
    public static int L(Context context, String str) {
        if (str == null) {
            throw new IllegalArgumentException("permission is null");
        }
        return context.checkPermission(str, Process.myPid(), Process.myUid());
    }

    public static boolean M(Context context, String str) {
        return L(context, str) == 0;
    }

    public static boolean N(Context context, String str) {
        return L(context, str) == -1;
    }
}
