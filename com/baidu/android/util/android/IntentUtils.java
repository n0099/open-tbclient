package com.baidu.android.util.android;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import androidx.core.content.FileProvider;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class IntentUtils {
    public static boolean DEBUG = false;
    public static final String TAG = "IntentUtils";

    public static List<ComponentName> getIntentHandlers(Context context, Intent intent) {
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            arrayList.add(new ComponentName(activityInfo.packageName, activityInfo.name));
        }
        return arrayList;
    }

    public static boolean isAvailable(Context context, Intent intent) {
        return intent != null && context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

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

    public static boolean safeGetBooleanExtra(Intent intent, String str, boolean z) {
        try {
            return intent.getBooleanExtra(str, z);
        } catch (Throwable unused) {
            if (DEBUG) {
                Log.e(TAG, "getBooleanExtra failed on intent " + intent);
            }
            return z;
        }
    }

    public static Bundle safeGetBundle(Bundle bundle, String str) {
        try {
            return bundle.getBundle(str);
        } catch (Throwable unused) {
            if (DEBUG) {
                Log.e(TAG, "getBundle failed on bundle " + bundle);
                return null;
            }
            return null;
        }
    }

    public static Bundle safeGetBundleExtra(Intent intent, String str) {
        try {
            return intent.getBundleExtra(str);
        } catch (Throwable unused) {
            if (DEBUG) {
                Log.e(TAG, "getBundleExtra failed on intent " + intent);
                return null;
            }
            return null;
        }
    }

    public static byte[] safeGetByteArrayExtra(Intent intent, String str) {
        try {
            return intent.getByteArrayExtra(str);
        } catch (Throwable unused) {
            if (DEBUG) {
                Log.e(TAG, "getByteArrayExtra failed on intent " + intent);
                return null;
            }
            return null;
        }
    }

    public static int safeGetIntExtra(Intent intent, String str, int i2) {
        try {
            return intent.getIntExtra(str, i2);
        } catch (Throwable unused) {
            if (DEBUG) {
                Log.e(TAG, "getIntExtra failed on intent " + intent);
            }
            return i2;
        }
    }

    public static long safeGetLongExtra(Intent intent, String str, long j) {
        try {
            return intent.getLongExtra(str, j);
        } catch (Throwable unused) {
            if (DEBUG) {
                Log.e(TAG, "getLongExtra failed on intent " + intent);
            }
            return j;
        }
    }

    public static <T extends Parcelable> T safeGetParcelableExtra(Intent intent, String str) {
        try {
            return (T) intent.getParcelableExtra(str);
        } catch (Throwable unused) {
            if (DEBUG) {
                Log.e(TAG, "getByteArrayExtra failed on intent " + intent);
                return null;
            }
            return null;
        }
    }

    public static String safeGetString(Bundle bundle, String str) {
        try {
            return bundle.getString(str);
        } catch (Throwable unused) {
            if (DEBUG) {
                Log.e(TAG, "getString failed on bundle " + bundle);
                return null;
            }
            return null;
        }
    }

    public static ArrayList<String> safeGetStringArrayListExtra(Intent intent, String str) {
        try {
            return intent.getStringArrayListExtra(str);
        } catch (Throwable unused) {
            if (DEBUG) {
                Log.e(TAG, "getStringArrayListExtra failed on intent " + intent);
                return null;
            }
            return null;
        }
    }

    public static String safeGetStringExtra(Intent intent, String str) {
        try {
            return intent.getStringExtra(str);
        } catch (Throwable unused) {
            if (DEBUG) {
                Log.e(TAG, "getStringExtra failed on intent " + intent);
                return null;
            }
            return null;
        }
    }
}
