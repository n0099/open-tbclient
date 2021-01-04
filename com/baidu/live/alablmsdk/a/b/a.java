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
    private static d aBD;
    private static boolean isDebug = false;
    private static StringBuilder aBC = new StringBuilder();

    public static void a(d dVar) {
        aBD = dVar;
    }

    public static void be(boolean z) {
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

    public static void aj(String str, String str2) {
        if (isDebug) {
            Log.d("blmsdk", str + str2);
        }
        fI(str);
    }

    public static void fI(String str) {
        String f = f(4000, str);
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(f)) {
            try {
                jSONObject.put("blm_msg", f);
            } catch (JSONException e) {
            }
        }
        a(b.LOG_ID, b.aBE, b.aBF, b.aBG, jSONObject);
    }

    private static synchronized String f(int i, String str) {
        String Bo;
        synchronized (a.class) {
            try {
                if (aBC == null) {
                    aBC = new StringBuilder();
                }
                if (aBC.length() != 0) {
                    aBC.append(",");
                }
                aBC.append("[").append(d(System.currentTimeMillis(), "HH:mm:ss.SSS")).append("|").append(i).append("|").append(str).append("]");
            } catch (Exception e) {
            }
            Bo = Bo();
        }
        return Bo;
    }

    private static String d(long j, String str) {
        return new SimpleDateFormat(str, Locale.getDefault()).format(new Date(j));
    }

    private static synchronized String Bo() {
        String sb;
        synchronized (a.class) {
            if (aBC == null) {
                sb = "";
            } else {
                sb = aBC.toString();
                try {
                    aBC.delete(0, aBC.length());
                } catch (Exception e) {
                    aBC = new StringBuilder();
                }
            }
        }
        return sb;
    }

    private static synchronized void a(String str, String str2, String str3, String str4, JSONObject jSONObject) {
        synchronized (a.class) {
            if (aBD != null) {
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
                aBD.onLogReport(str, jSONObject2, jSONObject);
            }
        }
    }

    public static void release() {
        if (aBD != null) {
            aBD = null;
        }
    }
}
