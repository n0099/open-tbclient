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
    private static d ayf;
    private static boolean isDebug = false;
    private static StringBuilder aye = new StringBuilder();

    public static void a(d dVar) {
        ayf = dVar;
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

    public static void eF(String str) {
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
        eG(str);
    }

    public static void eG(String str) {
        String h = h(4000, str);
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(h)) {
            try {
                jSONObject.put("blm_msg", h);
            } catch (JSONException e) {
            }
        }
        a(b.LOG_ID, b.ayg, b.ayh, b.ayi, jSONObject);
    }

    private static synchronized String h(int i, String str) {
        String xw;
        synchronized (a.class) {
            try {
                if (aye == null) {
                    aye = new StringBuilder();
                }
                if (aye.length() != 0) {
                    aye.append(",");
                }
                aye.append("[").append(d(System.currentTimeMillis(), "HH:mm:ss.SSS")).append("|").append(i).append("|").append(str).append("|").append("imlc=" + c.xx().xE()).append("]");
            } catch (Exception e) {
            }
            xw = xw();
        }
        return xw;
    }

    private static String d(long j, String str) {
        return new SimpleDateFormat(str, Locale.getDefault()).format(new Date(j));
    }

    private static synchronized String xw() {
        String sb;
        synchronized (a.class) {
            if (aye == null) {
                sb = "";
            } else {
                sb = aye.toString();
                try {
                    aye.delete(0, aye.length());
                } catch (Exception e) {
                    aye = new StringBuilder();
                }
            }
        }
        return sb;
    }

    private static synchronized void a(String str, String str2, String str3, String str4, JSONObject jSONObject) {
        synchronized (a.class) {
            if (ayf != null) {
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
                ayf.onLogReport(str, jSONObject2, jSONObject);
            }
        }
    }

    public static void release() {
        if (ayf != null) {
            ayf = null;
        }
    }
}
