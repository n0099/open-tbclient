package com.baidu.swan.apps.ap;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.Window;
import android.widget.Toast;
import com.baidu.swan.apps.a;
/* loaded from: classes7.dex */
public final class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void startActivitySafely(Activity activity, Intent intent) {
        startActivitySafely(activity, intent, true);
    }

    public static boolean startActivitySafely(Context context, Intent intent, boolean z) {
        return startActivitySafely(context, intent, z, true);
    }

    public static boolean startActivitySafely(Context context, Intent intent, boolean z, boolean z2) {
        if (z || !(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            if (z2) {
                Toast.makeText(context, a.h.activity_not_found, 0).show();
                return false;
            }
            return false;
        } catch (SecurityException e2) {
            if (z2) {
                Toast.makeText(context, a.h.activity_not_found, 0).show();
            }
            if (DEBUG) {
                Log.e("ActivityUtils", "Launcher does not have the permission to launch " + intent + ". Make sure to create a MAIN intent-filter for the corresponding activity or use the exported attribute for this activity.", e2);
                return false;
            }
            return false;
        }
    }

    public static boolean startActivitySafely(Context context, Intent intent) {
        return startActivitySafely(context, intent, false);
    }

    public static void M(Activity activity) {
        if (DEBUG) {
            Log.i("ActivityUtils", "tryFinishAndRemoveTask: " + activity);
        }
        if (activity != null && !activity.isDestroyed()) {
            if (Build.VERSION.SDK_INT >= 21) {
                activity.finishAndRemoveTask();
            } else {
                activity.finish();
            }
        }
    }

    public static void b(Activity activity, Dialog dialog) {
        if (activity != null && activity.getWindow() != null && activity.getWindow().getDecorView() != null && dialog != null && dialog.getWindow() != null && dialog.getWindow().getDecorView() != null) {
            dialog.getWindow().getDecorView().setSystemUiVisibility(activity.getWindow().getDecorView().getSystemUiVisibility());
        }
    }

    public static void N(Activity activity) {
        if (activity != null && activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
            Window window = activity.getWindow();
            window.setFlags(1024, 1024);
            window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | aLE());
        }
    }

    public static void O(Activity activity) {
        if (activity != null && activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
            Window window = activity.getWindow();
            window.clearFlags(1024);
            int systemUiVisibility = window.getDecorView().getSystemUiVisibility() & (aLE() ^ (-1));
            if (com.baidu.swan.apps.res.widget.a.SUPPORT_IMMERSION) {
                systemUiVisibility |= 5120;
            }
            window.getDecorView().setSystemUiVisibility(systemUiVisibility);
        }
    }

    public static int aLE() {
        return 5894;
    }
}
