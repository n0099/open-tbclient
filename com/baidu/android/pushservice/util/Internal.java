package com.baidu.android.pushservice.util;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
public final class Internal {
    private Internal() {
    }

    public static Intent createBdussInent(Context context) {
        return d.d(context);
    }

    public static void disablePushService(Context context) {
        d.a(context, false);
    }

    public static void enablePushService(Context context) {
        d.a(context, true);
    }
}
