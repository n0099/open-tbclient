package com.baidu.android.pushservice.util;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
public final class Internal implements NoProGuard {
    private Internal() {
    }

    public static Intent createBdussInent(Context context) {
        return n.e(context);
    }

    public static void disablePushConnection(Context context) {
        n.b(context, false);
    }

    public static void disablePushService(Context context) {
        n.a(context, false);
    }

    public static void enablePushConnection(Context context) {
        n.b(context, true);
    }

    public static void enablePushService(Context context) {
        n.a(context, true);
    }
}
