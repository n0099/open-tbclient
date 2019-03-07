package com.baidu.swan.apps.an;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
/* loaded from: classes2.dex */
public class m {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;

    public static boolean a(Intent intent, String str, boolean z) {
        try {
            return intent.getBooleanExtra(str, z);
        } catch (Throwable th) {
            if (DEBUG) {
                Log.e("IntentUtils", "getBooleanExtra failed on intent " + intent);
                return z;
            }
            return z;
        }
    }

    public static int a(Intent intent, String str, int i) {
        try {
            return intent.getIntExtra(str, i);
        } catch (Throwable th) {
            if (DEBUG) {
                Log.e("IntentUtils", "getIntExtra failed on intent " + intent);
                return i;
            }
            return i;
        }
    }

    public static long a(Intent intent, String str, long j) {
        try {
            return intent.getLongExtra(str, j);
        } catch (Throwable th) {
            if (DEBUG) {
                Log.e("IntentUtils", "getLongExtra failed on intent " + intent);
                return j;
            }
            return j;
        }
    }

    public static String a(Intent intent, String str) {
        try {
            return intent.getStringExtra(str);
        } catch (Throwable th) {
            if (DEBUG) {
                Log.e("IntentUtils", "getStringExtra failed on intent " + intent);
            }
            return null;
        }
    }

    public static Bundle b(Intent intent, String str) {
        try {
            return intent.getBundleExtra(str);
        } catch (Throwable th) {
            if (DEBUG) {
                Log.e("IntentUtils", "getBundleExtra failed on intent " + intent);
            }
            return null;
        }
    }

    public static <T extends Parcelable> T c(Intent intent, String str) {
        try {
            return (T) intent.getParcelableExtra(str);
        } catch (Throwable th) {
            if (DEBUG) {
                Log.e("IntentUtils", "getByteArrayExtra failed on intent " + intent);
            }
            return null;
        }
    }

    public static boolean N(Activity activity) {
        if (activity == null || !M(activity.getIntent())) {
            return false;
        }
        try {
            b.K(activity);
            return true;
        } catch (Exception e) {
            return true;
        }
    }

    public static boolean M(Intent intent) {
        if (intent != null) {
            try {
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    extras.isEmpty();
                }
            } catch (Exception e) {
                return true;
            }
        }
        return false;
    }
}
