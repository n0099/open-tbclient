package com.baidu.android.util.android;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import com.alibaba.fastjson.asm.Label;
import java.io.File;
import java.util.List;
/* loaded from: classes.dex */
public final class ActivityUtils {
    public static boolean DEBUG = false;
    public static final String TAG = "ActivityUtils";

    public static boolean isDestroyed(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return true;
        }
        return Build.VERSION.SDK_INT >= 17 && activity.isDestroyed();
    }

    @Deprecated
    public static boolean isIntentAvailable(Context context, Intent intent) {
        return intent != null && context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    @Deprecated
    public static boolean processFileUriIntent(Context context, File file, Intent intent) {
        String str;
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
                    ActivityInfo activityInfo = resolveInfo.activityInfo;
                    if (activityInfo != null && (str = activityInfo.packageName) != null) {
                        context.grantUriPermission(str, uriForFile, 1);
                    }
                }
            } catch (IllegalArgumentException e2) {
                if (DEBUG) {
                    throw e2;
                }
                return false;
            }
        }
        return true;
    }

    public static void setTaskDescription(Activity activity, String str, Bitmap bitmap, int i2) {
        if (Color.alpha(i2) != 255) {
            i2 = Color.argb(255, Color.red(i2), Color.green(i2), Color.blue(i2));
        }
        if (Build.VERSION.SDK_INT >= 21) {
            activity.setTaskDescription(new ActivityManager.TaskDescription(str, bitmap, i2));
        }
    }

    public static boolean startActivityForResultSafely(Context context, Intent intent, int i2) {
        return startActivityForResultSafely((Activity) context, intent, i2, false, false);
    }

    public static void startActivitySafely(Activity activity, Intent intent) {
        startActivitySafely((Context) activity, intent, true);
    }

    public static boolean startActivityForResultSafely(Activity activity, Intent intent, int i2, boolean z, boolean z2) {
        if (z) {
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        try {
            activity.startActivityForResult(intent, i2);
            return true;
        } catch (ActivityNotFoundException unused) {
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

    public static boolean startActivitySafely(Context context, Intent intent, boolean z) {
        return startActivitySafely(context, intent, z, true);
    }

    public static boolean startActivitySafely(Context context, Intent intent, boolean z, boolean z2) {
        if (z || !(context instanceof Activity)) {
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException unused) {
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
        if (componentName != null) {
            Intent intent = new Intent();
            intent.setComponent(componentName);
            return startActivitySafely(context, intent, true, z);
        }
        return false;
    }
}
