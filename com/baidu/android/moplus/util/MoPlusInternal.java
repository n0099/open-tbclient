package com.baidu.android.moplus.util;

import android.content.Context;
/* loaded from: classes.dex */
public final class MoPlusInternal implements NoProGuard {
    private MoPlusInternal() {
    }

    public static void disableApplist(Context context) {
        if (a.e(context, context.getPackageName())) {
            a.a(context, false);
        }
    }

    public static void disableBdServer(Context context) {
        if (a.e(context, context.getPackageName())) {
            a.b(context, false);
        }
    }

    public static void disableService(Context context) {
        if (a.e(context, context.getPackageName())) {
            a.d(context, false);
        }
    }

    public static void disableStatistic(Context context) {
        if (a.e(context, context.getPackageName())) {
            a.f(context, false);
        }
    }

    public static void enableApplist(Context context) {
        if (a.e(context, context.getPackageName())) {
            a.a(context, true);
        }
    }

    public static void enableBdServer(Context context) {
        if (a.e(context, context.getPackageName())) {
            a.b(context, true);
        }
    }

    public static void enableService(Context context) {
        if (a.e(context, context.getPackageName())) {
            a.d(context, true);
        }
    }

    public static void enableStatistic(Context context) {
        if (a.e(context, context.getPackageName())) {
            a.f(context, true);
        }
    }

    public static boolean isDisableApps(Context context) {
        if (a.e(context, context.getPackageName())) {
            return a.f(context, context.getPackageName());
        }
        return false;
    }

    public static boolean isDisableBdServer(Context context) {
        if (a.e(context, context.getPackageName())) {
            return a.g(context, context.getPackageName());
        }
        return false;
    }

    public static boolean isDisableService(Context context) {
        if (a.e(context, context.getPackageName())) {
            return a.a(context);
        }
        return false;
    }

    public static boolean isStatisticDisabled(Context context) {
        if (a.e(context, context.getPackageName())) {
            return a.h(context);
        }
        return false;
    }
}
