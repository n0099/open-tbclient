package com.baidu.swan.apps.ap;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationManagerCompat;
/* loaded from: classes8.dex */
public class x {
    public static boolean cx(@NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return NotificationManagerCompat.from(context).areNotificationsEnabled();
        }
        return true;
    }
}
