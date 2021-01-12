package com.baidu.live.alablmsdk.a.b;

import android.text.TextUtils;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    private static d awQ;
    private static boolean isDebug = false;
    private static StringBuilder awP = new StringBuilder();

    public static void a(d dVar) {
        awQ = dVar;
    }

    public static void ba(boolean z) {
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

    public static void ai(String str, String str2) {
        if (isDebug) {
            Log.d("blmsdk", str + str2);
        }
        ew(str);
    }

    public static void ew(String str) {
        String g = g(4000, str);
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(g)) {
            try {
                jSONObject.put("blm_msg", g);
            } catch (JSONException e) {
            }
        }
        a(b.LOG_ID, b.awR, b.awS, b.awT, jSONObject);
    }

    private static synchronized String g(int i, String str) {
        String xt;
        synchronized (a.class) {
            try {
                if (awP == null) {
                    awP = new StringBuilder();
                }
                if (awP.length() != 0) {
                    awP.append(",");
                }
                awP.append("[").append(d(System.currentTimeMillis(), "HH:mm:ss.SSS")).append("|").append(i).append("|").append(str).append("]");
            } catch (Exception e) {
            }
            xt = xt();
        }
        return xt;
    }

    private static String d(long j, String str) {
        return new SimpleDateFormat(str, Locale.getDefault()).format(new Date(j));
    }

    private static synchronized String xt() {
        String sb;
        synchronized (a.class) {
            if (awP == null) {
                sb = "";
            } else {
                sb = awP.toString();
                try {
                    awP.delete(0, awP.length());
                } catch (Exception e) {
                    awP = new StringBuilder();
                }
            }
        }
        return sb;
    }

    private static synchronized void a(String str, String str2, String str3, String str4, JSONObject jSONObject) {
        synchronized (a.class) {
            if (awQ != null) {
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
                awQ.onLogReport(str, jSONObject2, jSONObject);
            }
        }
    }

    public static void release() {
        if (awQ != null) {
            awQ = null;
        }
    }
}
