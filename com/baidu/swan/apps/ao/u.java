package com.baidu.swan.apps.ao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
/* loaded from: classes9.dex */
public class u {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

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

    public static String g(Bundle bundle, String str) {
        try {
            return bundle.getString(str);
        } catch (Throwable th) {
            if (DEBUG) {
                Log.e("IntentUtils", "getStringExtra failed on bundle " + bundle);
            }
            return null;
        }
    }

    public static String h(Bundle bundle, String str) {
        try {
            return bundle.getString(str);
        } catch (Throwable th) {
            if (DEBUG) {
                Log.e("IntentUtils", "getString failed on bundle " + bundle);
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

    public static Bundle i(Bundle bundle, String str) {
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

    public static boolean M(Activity activity) {
        if (activity == null || !y(activity.getIntent())) {
            return false;
        }
        try {
            e.H(activity);
            return true;
        } catch (Exception e) {
            return true;
        }
    }

    public static boolean y(Intent intent) {
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
