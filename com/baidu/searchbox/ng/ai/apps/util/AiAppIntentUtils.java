package com.baidu.searchbox.ng.ai.apps.util;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class AiAppIntentUtils {
    private static final boolean DEBUG = false;
    private static final String TAG = "IntentUtils";

    public static List<ComponentName> getIntentHandlers(Context context, Intent intent) {
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            arrayList.add(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name));
        }
        return arrayList;
    }

    public static boolean safeGetBooleanExtra(Intent intent, String str, boolean z) {
        try {
            return intent.getBooleanExtra(str, z);
        } catch (Throwable th) {
            return z;
        }
    }

    public static int safeGetIntExtra(Intent intent, String str, int i) {
        try {
            return intent.getIntExtra(str, i);
        } catch (Throwable th) {
            return i;
        }
    }

    public static long safeGetLongExtra(Intent intent, String str, long j) {
        try {
            return intent.getLongExtra(str, j);
        } catch (Throwable th) {
            return j;
        }
    }

    public static String safeGetStringExtra(Intent intent, String str) {
        try {
            return intent.getStringExtra(str);
        } catch (Throwable th) {
            return null;
        }
    }

    public static String safeGetString(Bundle bundle, String str) {
        try {
            return bundle.getString(str);
        } catch (Throwable th) {
            return null;
        }
    }

    public static Bundle safeGetBundleExtra(Intent intent, String str) {
        try {
            return intent.getBundleExtra(str);
        } catch (Throwable th) {
            return null;
        }
    }

    public static Bundle safeGetBundle(Bundle bundle, String str) {
        try {
            return bundle.getBundle(str);
        } catch (Throwable th) {
            return null;
        }
    }

    public static ArrayList<String> safeGetStringArrayListExtra(Intent intent, String str) {
        try {
            return intent.getStringArrayListExtra(str);
        } catch (Throwable th) {
            return null;
        }
    }

    public static byte[] safeGetByteArrayExtra(Intent intent, String str) {
        try {
            return intent.getByteArrayExtra(str);
        } catch (Throwable th) {
            return null;
        }
    }

    public static <T extends Parcelable> T safeGetParcelableExtra(Intent intent, String str) {
        try {
            return (T) intent.getParcelableExtra(str);
        } catch (Throwable th) {
            return null;
        }
    }

    public static boolean checkActivityRefuseServiceAndFinish(Activity activity) {
        if (activity == null || !checkIntentRefuseService(activity.getIntent())) {
            return false;
        }
        try {
            activity.finish();
            return true;
        } catch (Exception e) {
            return true;
        }
    }

    public static boolean checkIntentRefuseService(Intent intent) {
        Bundle extras;
        if (intent != null && (extras = intent.getExtras()) != null) {
            try {
                extras.isEmpty();
            } catch (Exception e) {
                return true;
            }
        }
        return false;
    }
}
