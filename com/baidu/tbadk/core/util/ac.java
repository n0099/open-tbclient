package com.baidu.tbadk.core.util;

import android.app.Activity;
import android.content.Context;
import android.support.v4.util.ArrayMap;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ac {
    public static boolean aL(Context context) {
        boolean z;
        boolean z2;
        if (com.baidu.d.a.rz()) {
            if (context == null) {
                return false;
            }
            try {
                z = com.baidu.d.a.a.N(context, "android.permission.READ_PHONE_STATE");
            } catch (Exception e) {
                e = e;
                z = false;
            }
            try {
                z2 = aM(context);
            } catch (Exception e2) {
                e = e2;
                BdLog.e(e.getMessage());
                z2 = false;
                if (z2) {
                }
            }
            return !z2 && z;
        }
        return true;
    }

    public static boolean aM(Context context) {
        if (com.baidu.d.a.rz()) {
            if (context != null) {
                try {
                    if (!com.baidu.d.a.a.N(context, "android.permission.ACCESS_FINE_LOCATION")) {
                        if (!com.baidu.d.a.a.N(context, "android.permission.ACCESS_COARSE_LOCATION")) {
                            return false;
                        }
                    }
                    return true;
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public static boolean aN(Context context) {
        if (!com.baidu.d.a.rz()) {
            return true;
        }
        if (context != null) {
            try {
                return com.baidu.d.a.a.N(context, "android.permission.CAMERA");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return false;
    }

    public static boolean aO(Context context) {
        if (!com.baidu.d.a.rz()) {
            return true;
        }
        if (context != null) {
            try {
                return com.baidu.d.a.a.N(context, "android.permission.RECORD_AUDIO");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return false;
    }

    public static boolean aP(Context context) {
        if (!com.baidu.d.a.rz()) {
            return true;
        }
        if (context != null) {
            try {
                return com.baidu.d.a.a.N(context, "android.permission.READ_PHONE_STATE");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return false;
    }

    public static boolean aQ(Context context) {
        if (!com.baidu.d.a.rz()) {
            return true;
        }
        if (context != null) {
            try {
                return com.baidu.d.a.a.N(context, "android.permission.WRITE_EXTERNAL_STORAGE");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return false;
    }

    public static void d(Activity activity, int i) {
        try {
            com.baidu.d.a.a.requestPermissions(activity, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public static ArrayMap<String, Boolean> b(String[] strArr, int[] iArr) {
        if (strArr == null || strArr.length == 0 || iArr == null || iArr.length == 0) {
            return null;
        }
        ArrayMap<String, Boolean> arrayMap = new ArrayMap<>(strArr.length);
        for (int i = 0; i < strArr.length && i < iArr.length; i++) {
            arrayMap.put(strArr[i], Boolean.valueOf(iArr[i] == 0));
        }
        return arrayMap;
    }

    public static boolean e(Activity activity, int i) {
        ArrayList arrayList = new ArrayList(2);
        if (!aQ(activity.getApplicationContext())) {
            arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
        }
        if (!aN(activity.getApplicationContext())) {
            arrayList.add("android.permission.CAMERA");
        }
        if (arrayList.size() == 0) {
            return false;
        }
        try {
            com.baidu.d.a.a.requestPermissions(activity, (String[]) arrayList.toArray(new String[arrayList.size()]), i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        return true;
    }
}
