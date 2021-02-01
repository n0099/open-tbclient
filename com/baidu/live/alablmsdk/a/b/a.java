package com.baidu.live.alablmsdk.a.b;

import android.text.TextUtils;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private static d awF;
    private static boolean isDebug = false;
    private static StringBuilder awE = new StringBuilder();

    public static void a(d dVar) {
        awF = dVar;
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

    public static void ez(String str) {
        if (isDebug) {
            Log.d("blmquent", str);
        }
    }

    public static void d(String str, String str2) {
        if (isDebug) {
            Log.d(str, str2);
        }
    }

    public static void ag(String str, String str2) {
        if (isDebug) {
            Log.d("blmsdk", str + " " + str2);
        }
        eA(str);
    }

    public static void eA(String str) {
        String h = h(4000, str);
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(h)) {
            try {
                jSONObject.put("blm_msg", h);
            } catch (JSONException e) {
            }
        }
        a(b.LOG_ID, b.awG, b.awH, b.awI, jSONObject);
    }

    private static synchronized String h(int i, String str) {
        String xt;
        synchronized (a.class) {
            try {
                if (awE == null) {
                    awE = new StringBuilder();
                }
                if (awE.length() != 0) {
                    awE.append(",");
                }
                awE.append("[").append(d(System.currentTimeMillis(), "HH:mm:ss.SSS")).append("|").append(i).append("|").append(str).append("|").append("imlc=" + c.xu().xB()).append("]");
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
            if (awE == null) {
                sb = "";
            } else {
                sb = awE.toString();
                try {
                    awE.delete(0, awE.length());
                } catch (Exception e) {
                    awE = new StringBuilder();
                }
            }
        }
        return sb;
    }

    private static synchronized void a(String str, String str2, String str3, String str4, JSONObject jSONObject) {
        synchronized (a.class) {
            if (awF != null) {
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
                awF.onLogReport(str, jSONObject2, jSONObject);
            }
        }
    }

    public static void release() {
        if (awF != null) {
            awF = null;
        }
    }
}
