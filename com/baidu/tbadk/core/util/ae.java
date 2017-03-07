package com.baidu.tbadk.core.util;

import android.app.Activity;
import android.content.Context;
import android.support.v4.util.ArrayMap;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ae {
    public static boolean aw(Context context) {
        boolean z;
        boolean z2;
        if (com.baidu.a.a.nB()) {
            if (context == null) {
                return false;
            }
            try {
                z = com.baidu.a.a.a.M(context, "android.permission.READ_PHONE_STATE");
            } catch (Exception e) {
                e = e;
                z = false;
            }
            try {
                z2 = ax(context);
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

    public static boolean ax(Context context) {
        if (com.baidu.a.a.nB()) {
            if (context == null) {
                return false;
            }
            try {
                if (com.baidu.a.a.a.M(context, "android.permission.ACCESS_FINE_LOCATION")) {
                    return true;
                }
                return com.baidu.a.a.a.M(context, "android.permission.ACCESS_COARSE_LOCATION");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return true;
    }

    public static boolean ay(Context context) {
        if (!com.baidu.a.a.nB()) {
            return true;
        }
        if (context != null) {
            try {
                return com.baidu.a.a.a.M(context, "android.permission.CAMERA");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return false;
    }

    public static boolean az(Context context) {
        if (!com.baidu.a.a.nB()) {
            return true;
        }
        if (context != null) {
            try {
                return com.baidu.a.a.a.M(context, "android.permission.RECORD_AUDIO");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return false;
    }

    public static boolean aA(Context context) {
        Context aE = aE(context);
        if (aE == null) {
            return true;
        }
        try {
            if (com.baidu.a.a.nB() && com.baidu.a.a.a.N(aE, "android.permission.RECORD_AUDIO")) {
                com.baidu.adp.lib.util.k.showToast(aE, w.l.record_audio_permission_denied_fun_disable);
                return true;
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        return false;
    }

    public static boolean aB(Context context) {
        if (!com.baidu.a.a.nB()) {
            return true;
        }
        if (context != null) {
            try {
                return com.baidu.a.a.a.M(context, "android.permission.READ_PHONE_STATE");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return false;
    }

    public static boolean aC(Context context) {
        if (!com.baidu.a.a.nB()) {
            return true;
        }
        if (context != null) {
            try {
                return com.baidu.a.a.a.M(context, "android.permission.WRITE_EXTERNAL_STORAGE");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return false;
    }

    public static boolean aD(Context context) {
        Context aE = aE(context);
        if (aE == null) {
            return true;
        }
        try {
            if (com.baidu.a.a.nB() && com.baidu.a.a.a.N(aE, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                com.baidu.adp.lib.util.k.showToast(aE, w.l.write_external_storage_permission_denied_fun_disable);
                return true;
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        return false;
    }

    public static Context aE(Context context) {
        return context == null ? TbadkCoreApplication.m9getInst().getContext() : context;
    }

    public static void c(Activity activity, int i) {
        try {
            com.baidu.a.a.a.a(activity, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, i);
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
        if (!aC(activity.getApplicationContext())) {
            arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
        }
        if (!ay(activity.getApplicationContext())) {
            arrayList.add("android.permission.CAMERA");
        }
        if (arrayList.size() == 0) {
            return false;
        }
        try {
            com.baidu.a.a.a.a(activity, (String[]) arrayList.toArray(new String[arrayList.size()]), i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        return true;
    }
}
