package com.baidu.tbadk.core.util;

import android.app.Activity;
import android.content.Context;
import android.support.v4.util.ArrayMap;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class aa {
    public static boolean aC(Context context) {
        boolean z;
        boolean z2;
        if (com.baidu.b.a.nw()) {
            if (context == null) {
                return false;
            }
            try {
                z = com.baidu.b.a.a.R(context, "android.permission.READ_PHONE_STATE");
            } catch (Exception e) {
                e = e;
                z = false;
            }
            try {
                z2 = aD(context);
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

    public static boolean aD(Context context) {
        if (com.baidu.b.a.nw()) {
            if (context != null) {
                try {
                    if (!com.baidu.b.a.a.R(context, "android.permission.ACCESS_FINE_LOCATION")) {
                        if (!com.baidu.b.a.a.R(context, "android.permission.ACCESS_COARSE_LOCATION")) {
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

    public static boolean aE(Context context) {
        if (!com.baidu.b.a.nw()) {
            return true;
        }
        if (context != null) {
            try {
                return com.baidu.b.a.a.R(context, "android.permission.CAMERA");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return false;
    }

    public static boolean aF(Context context) {
        if (!com.baidu.b.a.nw()) {
            return true;
        }
        if (context != null) {
            try {
                return com.baidu.b.a.a.R(context, "android.permission.RECORD_AUDIO");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return false;
    }

    public static boolean aG(Context context) {
        Context aK = aK(context);
        if (aK == null) {
            return true;
        }
        try {
            if (com.baidu.b.a.nw() && com.baidu.b.a.a.S(aK, "android.permission.RECORD_AUDIO")) {
                com.baidu.adp.lib.util.k.showToast(aK, d.l.record_audio_permission_denied_fun_disable);
                return true;
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        return false;
    }

    public static boolean aH(Context context) {
        if (!com.baidu.b.a.nw()) {
            return true;
        }
        if (context != null) {
            try {
                return com.baidu.b.a.a.R(context, "android.permission.READ_PHONE_STATE");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return false;
    }

    public static boolean aI(Context context) {
        if (!com.baidu.b.a.nw()) {
            return true;
        }
        if (context != null) {
            try {
                return com.baidu.b.a.a.R(context, "android.permission.WRITE_EXTERNAL_STORAGE");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return false;
    }

    public static boolean aJ(Context context) {
        Context aK = aK(context);
        if (aK == null) {
            return true;
        }
        try {
            if (com.baidu.b.a.nw() && com.baidu.b.a.a.S(aK, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                com.baidu.adp.lib.util.k.showToast(aK, d.l.write_external_storage_permission_denied_fun_disable);
                return true;
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        return false;
    }

    public static Context aK(Context context) {
        return context == null ? TbadkCoreApplication.getInst().getContext() : context;
    }

    public static void c(Activity activity, int i) {
        try {
            com.baidu.b.a.a.a(activity, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public static ArrayMap<String, Boolean> a(String[] strArr, int[] iArr) {
        if (strArr == null || strArr.length == 0 || iArr == null || iArr.length == 0) {
            return null;
        }
        ArrayMap<String, Boolean> arrayMap = new ArrayMap<>(strArr.length);
        for (int i = 0; i < strArr.length && i < iArr.length; i++) {
            arrayMap.put(strArr[i], Boolean.valueOf(iArr[i] == 0));
        }
        return arrayMap;
    }

    public static boolean d(Activity activity, int i) {
        ArrayList arrayList = new ArrayList(2);
        if (!aI(activity.getApplicationContext())) {
            arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
        }
        if (!aE(activity.getApplicationContext())) {
            arrayList.add("android.permission.CAMERA");
        }
        if (arrayList.size() == 0) {
            return false;
        }
        try {
            com.baidu.b.a.a.a(activity, (String[]) arrayList.toArray(new String[arrayList.size()]), i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        return true;
    }

    public static boolean e(Activity activity, int i) {
        ArrayList arrayList = new ArrayList();
        if (!aF(activity.getApplicationContext())) {
            arrayList.add("android.permission.RECORD_AUDIO");
        }
        if (arrayList.size() == 0) {
            return false;
        }
        try {
            com.baidu.b.a.a.a(activity, (String[]) arrayList.toArray(new String[arrayList.size()]), i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        return true;
    }
}
