package com.baidu.m.b;

import android.content.Context;
import android.os.Process;
/* JADX WARN: Classes with same name are omitted:
  classes17.dex
 */
/* loaded from: classes19.dex */
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

    public static boolean L(Context context, String str) {
        return checkSelfPermission(context, str) == -1;
    }
}
