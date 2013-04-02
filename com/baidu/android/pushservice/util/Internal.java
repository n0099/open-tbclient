package com.baidu.android.pushservice.util;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
public final class Internal implements NoProGuard {
    private Internal() {
    }

    public static Intent createBdussInent(Context context) {
        return d.h(context);
    }

    public static void disableApplist(Context context) {
        d.a(context, false);
    }

    public static void disableBdServer(Context context) {
        d.b(context, false);
    }

    public static void disablePushConnection(Context context) {
        d.d(context, false);
    }

    public static void disablePushService(Context context) {
        d.c(context, false);
    }

    public static void enableApplist(Context context) {
        d.a(context, true);
    }

    public static void enableBdServer(Context context) {
        d.b(context, true);
    }

    public static void enablePushConnection(Context context) {
        d.d(context, true);
    }

    public static void enablePushService(Context context) {
        d.c(context, true);
    }

    public static boolean isDisableApps(Context context) {
        return d.f(context, context.getPackageName());
    }

    public static boolean isDisableBdServer(Context context) {
        return d.g(context, context.getPackageName());
    }

    public static boolean isDisableService(Context context) {
        return d.c(context);
    }
}
