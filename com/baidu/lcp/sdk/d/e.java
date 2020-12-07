package com.baidu.lcp.sdk.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.text.TextUtils;
/* loaded from: classes14.dex */
public class e {
    private static String readStringData(Context context, String str, String str2) {
        if (context == null) {
            return "";
        }
        return context.getSharedPreferences("blcp_sp", 0).getString(str, str2);
    }

    private static void writeStringData(Context context, String str, String str2) {
        writeSPData(context, str, str2);
    }

    private static boolean readBooleanData(Context context, String str, boolean z) {
        if (context == null) {
            return false;
        }
        return context.getSharedPreferences("blcp_sp", 0).getBoolean(str, z);
    }

    private static void writeBooleanData(Context context, String str, boolean z) {
        writeSPData(context, str, Boolean.valueOf(z));
    }

    private static void writeSPData(Context context, final String str, final Object obj) {
        if (context != null) {
            try {
                final SharedPreferences sharedPreferences = context.getSharedPreferences("blcp_sp", 0);
                if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                    com.baidu.lcp.sdk.c.a.aH(context).submitForNetWork(new Runnable() { // from class: com.baidu.lcp.sdk.d.e.1
                        @Override // java.lang.Runnable
                        public void run() {
                            e.writeObjectData(sharedPreferences, str, obj);
                        }
                    });
                } else {
                    writeObjectData(sharedPreferences, str, obj);
                }
            } catch (Throwable th) {
                d.e("SpUtils", th.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void writeObjectData(SharedPreferences sharedPreferences, String str, Object obj) {
        if (obj instanceof Boolean) {
            sharedPreferences.edit().putBoolean(str, ((Boolean) obj).booleanValue()).apply();
        } else if (obj instanceof Integer) {
            sharedPreferences.edit().putInt(str, ((Integer) obj).intValue()).apply();
        } else if (obj instanceof Long) {
            sharedPreferences.edit().putLong(str, ((Long) obj).longValue()).apply();
        } else if (obj instanceof Float) {
            sharedPreferences.edit().putFloat(str, ((Float) obj).floatValue()).apply();
        } else if (obj instanceof String) {
            sharedPreferences.edit().putString(str, (String) obj).apply();
        }
    }

    private static int readIntData(Context context, String str, int i) {
        if (context == null) {
            return -1;
        }
        return context.getSharedPreferences("blcp_sp", 0).getInt(str, i);
    }

    private static void writeIntData(Context context, String str, int i) {
        writeSPData(context, str, Integer.valueOf(i));
    }

    public static void D(Context context, String str) {
        writeStringData(context, "blcp_token", str);
    }

    public static String getToken(Context context) {
        return readStringData(context, "blcp_token", "");
    }

    public static boolean aM(Context context) {
        return !TextUtils.isEmpty(getToken(context));
    }

    public static void d(Context context, String str, int i) {
        writeStringData(context, "protocol_priority" + i, str);
    }

    public static String k(Context context, int i) {
        return readStringData(context, "protocol_priority" + i, " : : ");
    }

    public static void l(Context context, int i) {
        writeIntData(context, "protocols_size", i);
    }

    public static int aN(Context context) {
        return readIntData(context, "protocols_size", 1);
    }

    public static void j(Context context, boolean z) {
        writeBooleanData(context, "bddns_enable", z);
    }

    public static boolean getBdDnsEnable(Context context) {
        return readBooleanData(context, "bddns_enable", false);
    }

    public static void k(Context context, boolean z) {
        writeBooleanData(context, "small_flow", z);
    }

    public static boolean aC(Context context) {
        return readBooleanData(context, "small_flow", false);
    }

    public static void E(Context context, String str) {
        writeStringData(context, "blcp_app_id", str);
    }

    public static String getAppId(Context context) {
        return readStringData(context, "blcp_app_id", "");
    }

    public static void F(Context context, String str) {
        writeStringData(context, "blcp_cuid", str);
    }

    public static String aO(Context context) {
        return readStringData(context, "blcp_cuid", "");
    }

    public static int aP(Context context) {
        return readIntData(context, "conn_type", 1);
    }

    public static void m(Context context, int i) {
        writeIntData(context, "conn_type", i);
    }

    public static void l(Context context, boolean z) {
        writeBooleanData(context, "lcp_debug", z);
    }

    public static void n(Context context, int i) {
        writeIntData(context, "lcp_env_debug", i);
    }

    public static boolean aQ(Context context) {
        return readBooleanData(context, "lcp_debug", false);
    }

    public static int aR(Context context) {
        return readIntData(context, "lcp_env_debug", 0);
    }

    public static void o(Context context, int i) {
        writeIntData(context, "key_vip_connect_type", i);
    }

    public static int aS(Context context) {
        return readIntData(context, "key_vip_connect_type", 3);
    }
}
