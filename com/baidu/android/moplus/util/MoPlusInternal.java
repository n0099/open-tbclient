package com.baidu.android.moplus.util;

import android.content.Context;
/* loaded from: classes.dex */
public final class MoPlusInternal implements NoProGuard {
    private MoPlusInternal() {
    }

    public static void disableApplist(Context context) {
        if (b.e(context, context.getPackageName())) {
            b.a(context, false);
        }
    }

    public static void disableBdServer(Context context) {
        if (b.e(context, context.getPackageName())) {
            b.b(context, false);
        }
    }

    public static void disableService(Context context) {
        if (b.e(context, context.getPackageName())) {
            b.d(context, false);
        }
    }

    public static void disableStatistic(Context context) {
        if (b.e(context, context.getPackageName())) {
            b.f(context, false);
        }
    }

    public static void enableApplist(Context context) {
        if (b.e(context, context.getPackageName())) {
            b.a(context, true);
        }
    }

    public static void enableBdServer(Context context) {
        if (b.e(context, context.getPackageName())) {
            b.b(context, true);
        }
    }

    public static void enableService(Context context) {
        if (b.e(context, context.getPackageName())) {
            b.d(context, true);
        }
    }

    public static void enableStatistic(Context context) {
        if (b.e(context, context.getPackageName())) {
            b.f(context, true);
        }
    }

    public static boolean isDisableApps(Context context) {
        if (b.e(context, context.getPackageName())) {
            return b.f(context, context.getPackageName());
        }
        return false;
    }

    public static boolean isDisableBdServer(Context context) {
        if (b.e(context, context.getPackageName())) {
            return b.g(context, context.getPackageName());
        }
        return false;
    }

    public static boolean isDisableService(Context context) {
        if (b.e(context, context.getPackageName())) {
            return b.a(context);
        }
        return false;
    }

    public static boolean isStatisticDisabled(Context context) {
        if (b.e(context, context.getPackageName())) {
            return b.h(context);
        }
        return false;
    }
}
