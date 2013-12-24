package com.baidu.android.pushservice.apiproxy;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
public class PushConstants {
    public static Intent createMethodIntent(Context context) {
        return com.baidu.android.pushservice.internal.PushConstants.createMethodIntent(context);
    }

    public static void restartPushService(Context context) {
        com.baidu.android.pushservice.internal.PushConstants.restartPushService(context);
    }

    public static void startPushService(Context context) {
        com.baidu.android.pushservice.internal.PushConstants.startPushService(context);
    }
}
