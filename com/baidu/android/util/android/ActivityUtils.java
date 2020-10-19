package com.baidu.android.util.android;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import java.io.File;
import java.util.List;
/* loaded from: classes8.dex */
public final class ActivityUtils {
    private static final boolean DEBUG = false;
    private static final String TAG = "ActivityUtils";

    public static void startActivitySafely(Activity activity, Intent intent) {
        startActivitySafely((Context) activity, intent, true);
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
                Toast.makeText(context, R.string.activity_not_found, 0).show();
                return false;
            }
            return false;
        } catch (SecurityException e2) {
            if (z2) {
                Toast.makeText(context, R.string.activity_not_found, 0).show();
            }
            if (DEBUG) {
                Log.e(TAG, "Launcher does not have the permission to launch " + intent + ". Make sure to create a MAIN intent-filter for the corresponding activity or use the exported attribute for this activity.", e2);
                return false;
            }
            return false;
        } catch (Exception e3) {
            if (DEBUG) {
                Log.d(TAG, e3.getMessage());
                return false;
            }
            return false;
        }
    }

    public static boolean startActivitySafely(Context context, Intent intent) {
        return startActivitySafely(context, intent, false);
    }

    public static boolean startActivitySafely(Context context, String str, String str2) {
        return startActivitySafely(context, str, str2, true);
    }

    public static boolean startActivitySafely(Context context, String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return startActivitySafely(context, new ComponentName(str, str2), z);
    }

    public static boolean startActivitySafely(Context context, ComponentName componentName) {
        return startActivitySafely(context, componentName, true);
    }

    public static boolean startActivitySafely(Context context, ComponentName componentName, boolean z) {
        if (componentName == null) {
            return false;
        }
        Intent intent = new Intent();
        intent.setComponent(componentName);
        return startActivitySafely(context, intent, true, z);
    }

    public static boolean startActivityForResultSafely(Context context, Intent intent, int i) {
        return startActivityForResultSafely((Activity) context, intent, i, false, false);
    }

    public static boolean startActivityForResultSafely(Activity activity, Intent intent, int i, boolean z, boolean z2) {
        if (z) {
            intent.addFlags(268435456);
        }
        try {
            activity.startActivityForResult(intent, i);
            return true;
        } catch (ActivityNotFoundException e) {
            if (z2) {
                Toast.makeText(activity, R.string.activity_not_found, 0).show();
                return false;
            }
            return false;
        } catch (SecurityException e2) {
            if (z2) {
                Toast.makeText(activity, R.string.activity_not_found, 0).show();
            }
            if (DEBUG) {
                Log.e(TAG, "Launcher does not have the permission to launch " + intent + ". Make sure to create a MAIN intent-filter for the corresponding activity or use the exported attribute for this activity.", e2);
                return false;
            }
            return false;
        }
    }

    public static void setTaskDescription(Activity activity, String str, Bitmap bitmap, int i) {
        if (Color.alpha(i) != 255) {
            i = Color.argb(255, Color.red(i), Color.green(i), Color.blue(i));
        }
        if (Build.VERSION.SDK_INT >= 21) {
            activity.setTaskDescription(new ActivityManager.TaskDescription(str, bitmap, i));
        }
    }

    public static boolean isIntentAvailable(Context context, Intent intent) {
        return intent != null && context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    public static boolean processFileUriIntent(Context context, File file, Intent intent) {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                Uri uriForFile = FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", file);
                if (uriForFile == null) {
                    return false;
                }
                intent.setDataAndType(uriForFile, intent.getType());
                List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
                if (queryIntentActivities == null) {
                    return true;
                }
                for (ResolveInfo resolveInfo : queryIntentActivities) {
                    if (resolveInfo.activityInfo != null && resolveInfo.activityInfo.packageName != null) {
                        context.grantUriPermission(resolveInfo.activityInfo.packageName, uriForFile, 1);
                    }
                }
            } catch (IllegalArgumentException e) {
                if (DEBUG) {
                    throw e;
                }
                return false;
            }
        }
        return true;
    }

    public static boolean isDestroyed(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return true;
        }
        return Build.VERSION.SDK_INT >= 17 && activity.isDestroyed();
    }
}
