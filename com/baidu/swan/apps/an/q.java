package com.baidu.swan.apps.an;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationManagerCompat;
/* loaded from: classes2.dex */
public class q {
    public static boolean bH(@NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return NotificationManagerCompat.from(context).areNotificationsEnabled();
        }
        return true;
    }
}
