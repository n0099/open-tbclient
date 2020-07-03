package com.baidu.swan.apps.aq;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationManagerCompat;
/* loaded from: classes11.dex */
public class v {
    public static boolean co(@NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return NotificationManagerCompat.from(context).areNotificationsEnabled();
        }
        return true;
    }
}
