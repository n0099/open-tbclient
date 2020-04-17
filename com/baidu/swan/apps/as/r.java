package com.baidu.swan.apps.as;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
/* loaded from: classes11.dex */
public class r {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static int safeGetIntExtra(Intent intent, String str, int i) {
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

    public static String safeGetStringExtra(Intent intent, String str) {
        try {
            return intent.getStringExtra(str);
        } catch (Throwable th) {
            if (DEBUG) {
                Log.e("IntentUtils", "getStringExtra failed on intent " + intent);
            }
            return null;
        }
    }

    public static String e(Bundle bundle, String str) {
        try {
            return bundle.getString(str);
        } catch (Throwable th) {
            if (DEBUG) {
                Log.e("IntentUtils", "getStringExtra failed on bundle " + bundle);
            }
            return null;
        }
    }

    public static String safeGetString(Bundle bundle, String str) {
        try {
            return bundle.getString(str);
        } catch (Throwable th) {
            if (DEBUG) {
                Log.e("IntentUtils", "getString failed on bundle " + bundle);
            }
            return null;
        }
    }

    public static Bundle safeGetBundleExtra(Intent intent, String str) {
        try {
            return intent.getBundleExtra(str);
        } catch (Throwable th) {
            if (DEBUG) {
                Log.e("IntentUtils", "getBundleExtra failed on intent " + intent);
            }
            return null;
        }
    }

    public static Bundle safeGetBundle(Bundle bundle, String str) {
        try {
            return bundle.getBundle(str);
        } catch (Throwable th) {
            if (DEBUG) {
                Log.e("IntentUtils", "getBundle failed on bundle " + bundle);
            }
            return null;
        }
    }

    public static int a(Bundle bundle, String str, int i) {
        try {
            return bundle.getInt(str);
        } catch (Throwable th) {
            if (DEBUG) {
                Log.e("IntentUtils", "getInt failed on bundle " + bundle);
                return i;
            }
            return i;
        }
    }

    public static boolean c(Bundle bundle, String str, boolean z) {
        try {
            return bundle.getBoolean(str);
        } catch (Throwable th) {
            if (DEBUG) {
                Log.e("IntentUtils", "getBoolean failed on bundle " + bundle);
                return z;
            }
            return z;
        }
    }

    public static boolean checkActivityRefuseServiceAndFinish(Activity activity) {
        if (activity == null || !checkIntentRefuseService(activity.getIntent())) {
            return false;
        }
        try {
            c.P(activity);
            return true;
        } catch (Exception e) {
            return true;
        }
    }

    public static boolean checkIntentRefuseService(Intent intent) {
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
