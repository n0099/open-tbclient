package com.baidu.sofire.b;

import android.content.Context;
import android.os.Process;
/* loaded from: classes.dex */
public final class l {
    public static boolean a(Context context) {
        try {
            return context.checkPermission("android.permission.READ_PHONE_STATE", Process.myPid(), Process.myUid()) != -1;
        } catch (Throwable th) {
            d.a(th);
            return false;
        }
    }
}
