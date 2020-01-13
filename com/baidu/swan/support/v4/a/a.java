package com.baidu.swan.support.v4.a;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.support.annotation.NonNull;
/* loaded from: classes10.dex */
public class a {
    public static final int getColor(Context context, int i) {
        return Build.VERSION.SDK_INT >= 23 ? b.getColor(context, i) : context.getResources().getColor(i);
    }

    public static int checkSelfPermission(@NonNull Context context, @NonNull String str) {
        if (str == null) {
            throw new IllegalArgumentException("permission is null");
        }
        return context.checkPermission(str, Process.myPid(), Process.myUid());
    }
}
