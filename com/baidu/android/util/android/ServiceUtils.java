package com.baidu.android.util.android;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
public class ServiceUtils {
    public static ComponentName startServiceSafely(Context context, Intent intent) {
        if (context != null && intent != null) {
            try {
                return context.startService(intent);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }
}
