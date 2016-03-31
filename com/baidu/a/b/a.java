package com.baidu.a.b;

import android.content.Context;
import android.os.Process;
/* loaded from: classes.dex */
public class a {
    public static int p(Context context, String str) {
        if (str == null) {
            throw new IllegalArgumentException("permission is null");
        }
        return context.checkPermission(str, Process.myPid(), Process.myUid());
    }

    public static boolean q(Context context, String str) {
        return p(context, str) == 0;
    }

    public static boolean r(Context context, String str) {
        return p(context, str) == -1;
    }

    public static boolean b(int[] iArr) {
        if (iArr == null || iArr.length < 1) {
            return false;
        }
        for (int i : iArr) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
