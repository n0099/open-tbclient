package com.baidu.live.alablmsdk.a.b;

import android.text.TextUtils;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private static d aBm;
    private static boolean isDebug = false;
    private static StringBuilder aBl = new StringBuilder();

    public static void a(d dVar) {
        aBm = dVar;
    }

    public static void bh(boolean z) {
        isDebug = z;
    }

    public static boolean isDebug() {
        return isDebug;
    }

    public static void d(String str) {
        if (isDebug) {
            Log.d("blmsdk", str);
        }
    }

    public static void d(String str, String str2) {
        if (isDebug) {
            Log.d(str, str2);
        }
    }

    public static void ak(String str, String str2) {
        if (isDebug) {
            Log.d("blmsdk", str + str2);
        }
        fY(str);
    }

    public static void fY(String str) {
        String f = f(4000, str);
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(f)) {
            try {
                jSONObject.put("blm_msg", f);
            } catch (JSONException e) {
            }
        }
        a(b.LOG_ID, b.aBn, b.aBo, b.aBp, jSONObject);
    }

    private static synchronized String f(int i, String str) {
        String BX;
        synchronized (a.class) {
            try {
                if (aBl == null) {
                    aBl = new StringBuilder();
                }
                if (aBl.length() != 0) {
                    aBl.append(",");
                }
                aBl.append("[").append(d(System.currentTimeMillis(), "HH:mm:ss.SSS")).append("|").append(i).append("|").append(str).append("]");
            } catch (Exception e) {
            }
            BX = BX();
        }
        return BX;
    }

    private static String d(long j, String str) {
        return new SimpleDateFormat(str, Locale.getDefault()).format(new Date(j));
    }

    private static synchronized String BX() {
        String sb;
        synchronized (a.class) {
            if (aBl == null) {
                sb = "";
            } else {
                sb = aBl.toString();
                try {
                    aBl.delete(0, aBl.length());
                } catch (Exception e) {
                    aBl = new StringBuilder();
                }
            }
        }
        return sb;
    }

    private static synchronized void a(String str, String str2, String str3, String str4, JSONObject jSONObject) {
        synchronized (a.class) {
            if (aBm != null) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("type", str2);
                    jSONObject2.put("page", str3);
                    jSONObject2.put("value", str4);
                    if (jSONObject == null) {
                        jSONObject = new JSONObject();
                    }
                } catch (JSONException e) {
                }
                aBm.onLogReport(str, jSONObject2, jSONObject);
            }
        }
    }

    public static void release() {
        if (aBm != null) {
            aBm = null;
        }
    }
}
