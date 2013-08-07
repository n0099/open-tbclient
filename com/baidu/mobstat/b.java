package com.baidu.mobstat;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static String f777a = "Android";
    private static JSONObject q = new JSONObject();
    private static b w = new b();
    private String b;
    private String e;
    private String f;
    private int g;
    private int h;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String c = null;
    private int d = -1;
    private String i = null;
    private int p = 0;
    private JSONArray r = new JSONArray();
    private JSONArray s = new JSONArray();
    private JSONArray t = new JSONArray();
    private JSONArray u = new JSONArray();
    private boolean v = false;

    private b() {
    }

    public static b a() {
        return w;
    }

    private String a(String str, Context context) {
        if (str.equals("000000000000000")) {
            String g = q.g(context);
            if (g != null) {
                g = g.replaceAll(":", "");
                str = g;
            }
            com.baidu.mobstat.a.b.a("stat", "imei=null,mac=" + g);
        }
        return str;
    }

    private void a(boolean z) {
        this.v = z;
    }

    private boolean d() {
        return this.v;
    }

    public void a(long j, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", j);
            jSONObject.put("c", str);
        } catch (JSONException e) {
            com.baidu.mobstat.a.b.a("stat", e);
        }
        c(jSONObject, false);
    }

    public synchronized void a(Context context) {
        if (this.d == -1) {
            com.baidu.mobstat.a.a.d(context, "android.permission.READ_PHONE_STATE");
            com.baidu.mobstat.a.a.d(context, "android.permission.INTERNET");
            com.baidu.mobstat.a.a.d(context, "android.permission.ACCESS_NETWORK_STATE");
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            this.b = Build.VERSION.SDK;
            this.k = Build.MODEL;
            try {
                this.f = telephonyManager.getDeviceId();
                this.f = a(this.f, context);
            } catch (Exception e) {
                com.baidu.mobstat.a.b.a(e);
            }
            try {
                this.j = telephonyManager.getNetworkOperator();
            } catch (Exception e2) {
                com.baidu.mobstat.a.b.a(e2);
            }
            try {
                this.g = q.a(context);
                this.h = q.b(context);
                if (context.getResources().getConfiguration().orientation == 2) {
                    com.baidu.mobstat.a.b.a("stat", "Configuration.ORIENTATION_LANDSCAPE");
                    this.g ^= this.h;
                    this.h = this.g ^ this.h;
                    this.g ^= this.h;
                }
            } catch (Exception e3) {
                com.baidu.mobstat.a.b.a(e3);
            }
            try {
                if (this.i == null) {
                    this.i = q.a(context, "BaiduMobAd_CHANNEL");
                }
            } catch (Exception e4) {
                com.baidu.mobstat.a.b.a(e4);
            }
            if (this.c == null) {
                this.c = q.a(context, "BaiduMobAd_STAT_ID");
            }
            try {
                this.d = q.c(context);
                this.e = q.d(context);
            } catch (Exception e5) {
                com.baidu.mobstat.a.b.a(e5);
            }
            try {
                String a2 = q.a(context, "BaiduMobAd_CELL_LOCATION");
                if (a2 == null || !a2.toLowerCase().equals("false")) {
                    this.l = q.e(context);
                } else {
                    this.l = "0_0_0";
                }
            } catch (Exception e6) {
                com.baidu.mobstat.a.b.a(e6);
            }
            try {
                this.m = q.f(context);
            } catch (Exception e7) {
                com.baidu.mobstat.a.b.a(e7);
            }
            try {
                this.n = q.h(context);
            } catch (Exception e8) {
                com.baidu.mobstat.a.b.a(e8);
            }
            try {
                this.o = q.i(context);
            } catch (Exception e9) {
                com.baidu.mobstat.a.b.a(e9);
            }
        }
    }

    public void a(Context context, boolean z) {
        boolean z2;
        com.baidu.mobstat.a.b.a("stat", "sendLogData() begin.");
        if (z) {
            try {
                if (!((WifiManager) context.getSystemService("wifi")).isWifiEnabled()) {
                    com.baidu.mobstat.a.b.a("stat", "sendLogData() does not send because of only_wifi setting");
                    return;
                }
            } catch (Exception e) {
                com.baidu.mobstat.a.b.a("stat", "sendLogData exception when get wifimanager");
                return;
            }
        }
        JSONObject jSONObject = new JSONObject();
        synchronized (q) {
            try {
                q.put("t", System.currentTimeMillis());
                q.put("ss", m.a().c());
                jSONObject.put("he", q);
                synchronized (this.r) {
                    try {
                        jSONObject.put("pr", this.r);
                        synchronized (this.s) {
                            try {
                                jSONObject.put("ev", this.s);
                                synchronized (this.t) {
                                    synchronized (this.u) {
                                        try {
                                            jSONObject.put("ex", this.u);
                                            String jSONObject2 = jSONObject.toString();
                                            com.baidu.mobstat.a.b.a("stat", "---Send Data Is:" + jSONObject2);
                                            try {
                                                q.a(context, "http://hmma.baidu.com/app.gif", jSONObject2, 50000, 50000);
                                                z2 = true;
                                            } catch (Exception e2) {
                                                com.baidu.mobstat.a.b.a("stat", e2);
                                                z2 = false;
                                            }
                                            if (z2) {
                                                a(false);
                                                this.u = new JSONArray();
                                                this.s = new JSONArray();
                                                this.r = new JSONArray();
                                                b(context);
                                                m.a().b();
                                                g.a().d(context);
                                            }
                                        } catch (JSONException e3) {
                                            com.baidu.mobstat.a.b.a("stat", e3);
                                            return;
                                        }
                                    }
                                }
                            } catch (JSONException e4) {
                                com.baidu.mobstat.a.b.a("stat", e4);
                                return;
                            }
                        }
                    } catch (JSONException e5) {
                        com.baidu.mobstat.a.b.a("stat", e5.toString());
                        return;
                    }
                }
            } catch (JSONException e6) {
                com.baidu.mobstat.a.b.a("stat", e6);
                return;
            }
        }
        com.baidu.mobstat.a.b.a("stat", "sendLogData() end.");
    }

    public void a(String str) {
        this.c = str;
    }

    public void a(String str, String str2, int i, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("i", str);
            jSONObject.put("l", str2);
            jSONObject.put("c", i);
            jSONObject.put("t", j);
            b(jSONObject, false);
            com.baidu.mobstat.a.b.a("stat", "put event:" + jSONObject.toString());
        } catch (JSONException e) {
            com.baidu.mobstat.a.b.a("stat", e);
        }
    }

    public void a(JSONObject jSONObject, boolean z) {
        if (jSONObject != null && !z) {
            int length = jSONObject.toString().getBytes().length;
            com.baidu.mobstat.a.b.a("stat", "putSession:addSize is:", Integer.valueOf(length));
            if (length + this.p > 204800) {
                com.baidu.mobstat.a.b.a("stat", "putSession: size is full!");
                return;
            }
        }
        synchronized (this.r) {
            try {
                this.r.put(this.r.length(), jSONObject);
            } catch (JSONException e) {
                com.baidu.mobstat.a.b.a("stat", e);
            }
        }
    }

    public synchronized void b() {
        if (q.length() <= 0) {
            try {
                q.put("o", f777a == null ? "" : f777a);
                q.put("s", this.b == null ? "" : this.b);
                q.put("k", this.c == null ? "" : this.c);
                q.put("v", "2.2");
                q.put("a", this.d);
                q.put("n", this.e == null ? "" : this.e);
                q.put("d", this.f == null ? "" : this.f);
                q.put("w", this.g);
                q.put("h", this.h);
                q.put("c", this.i == null ? "" : this.i);
                q.put("op", this.j == null ? "" : this.j);
                q.put("m", this.k == null ? "" : this.k);
                q.put("cl", this.l);
                q.put("gl", this.m == null ? "" : this.m);
                q.put("wl", this.n == null ? "" : this.n);
                q.put("l", this.o == null ? "" : this.o);
                q.put("t", System.currentTimeMillis());
                q.put("sq", 0);
                com.baidu.mobstat.a.b.a("stat", q.toString());
            } catch (JSONException e) {
                com.baidu.mobstat.a.b.a("stat", "header ini error");
                throw new RuntimeException("header ini error");
            }
        }
    }

    public void b(Context context) {
        com.baidu.mobstat.a.b.a("stat", "flush cache to __local_stat_cache.json");
        JSONObject jSONObject = new JSONObject();
        try {
            synchronized (this.r) {
                jSONObject.put("pr", new JSONArray(this.r.toString()));
            }
            synchronized (this.s) {
                jSONObject.put("ev", new JSONArray(this.s.toString()));
            }
            synchronized (this.u) {
                jSONObject.put("ex", new JSONArray(this.u.toString()));
            }
        } catch (JSONException e) {
            com.baidu.mobstat.a.b.a("stat", "flushLogWithoutHeader() construct cache error");
        }
        String jSONObject2 = jSONObject.toString();
        if (d()) {
            com.baidu.mobstat.a.b.a("stat", "cache.json exceed 204800B,stop flush.");
            return;
        }
        int length = jSONObject2.getBytes().length;
        if (length >= 204800) {
            a(true);
            return;
        }
        this.p = length;
        com.baidu.mobstat.a.b.a("stat", "flush:cacheFileSize is:" + this.p);
        com.baidu.mobstat.a.a.a(false, context, "__local_stat_cache.json", jSONObject2, false);
    }

    public void b(String str) {
        this.i = str;
    }

    public void b(JSONObject jSONObject, boolean z) {
        if (jSONObject != null && !z) {
            int length = jSONObject.toString().getBytes().length;
            com.baidu.mobstat.a.b.a("stat", "putEvent:eventSize is:", Integer.valueOf(length));
            if (length + this.p > 204800) {
                com.baidu.mobstat.a.b.a("stat", "putEvent: size is full!");
                return;
            }
        }
        try {
            String string = jSONObject.getString("i");
            String string2 = jSONObject.getString("l");
            long j = jSONObject.getLong("t") / Util.MILLSECONDS_OF_HOUR;
            synchronized (this.s) {
                int length2 = this.s.length();
                int i = length2;
                for (int i2 = 0; i2 < length2; i2++) {
                    try {
                        JSONObject jSONObject2 = this.s.getJSONObject(i2);
                        String string3 = jSONObject2.getString("i");
                        String string4 = jSONObject2.getString("l");
                        if (jSONObject2.getLong("t") / Util.MILLSECONDS_OF_HOUR == j && string3.equals(string) && string4.equals(string2)) {
                            int i3 = jSONObject2.getInt("c") + jSONObject.getInt("c");
                            try {
                                jSONObject2.remove("c");
                                jSONObject2.put("c", i3);
                                i = i2;
                            } catch (JSONException e) {
                                e = e;
                                i = i2;
                                com.baidu.mobstat.a.b.a("stat", e);
                            }
                        }
                    } catch (JSONException e2) {
                        e = e2;
                    }
                }
                if (i < length2) {
                    return;
                }
                try {
                    this.s.put(length2, jSONObject);
                } catch (JSONException e3) {
                    com.baidu.mobstat.a.b.a("stat", e3);
                }
            }
        } catch (JSONException e4) {
            com.baidu.mobstat.a.b.a("stat", e4);
        }
    }

    public void c(Context context) {
        com.baidu.mobstat.a.b.a("stat", "LoadLastSession()");
        if (context != null && com.baidu.mobstat.a.a.c(context, "__local_last_session.json")) {
            String a2 = com.baidu.mobstat.a.a.a(false, context, "__local_last_session.json");
            if (a2.equals("")) {
                com.baidu.mobstat.a.b.a("stat", "loadLastSession(): last_session.json file not found.");
                return;
            }
            com.baidu.mobstat.a.a.a(false, context, "__local_last_session.json", new JSONObject().toString(), false);
            c(a2);
            b(context);
        }
    }

    public void c(String str) {
        if (str.equals("{}") || str.equals("")) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            a(jSONObject, false);
            com.baidu.mobstat.a.b.a("stat", "Load last session:" + jSONObject);
        } catch (JSONException e) {
            com.baidu.mobstat.a.b.a("stat", "putSession()" + e);
        }
    }

    public void c(JSONObject jSONObject, boolean z) {
        if (jSONObject != null && !z) {
            int length = jSONObject.toString().getBytes().length;
            com.baidu.mobstat.a.b.a("stat", "putException:addSize is:", Integer.valueOf(length));
            if (length + this.p > 204800) {
                com.baidu.mobstat.a.b.a("stat", "putException: size is full!");
                return;
            }
        }
        synchronized (this.u) {
            try {
                this.u.put(this.u.length(), jSONObject);
            } catch (JSONException e) {
                com.baidu.mobstat.a.b.a("stat", e);
            }
        }
    }

    public boolean c() {
        return this.r.length() == 0 && this.s.length() == 0 && this.u.length() == 0;
    }

    public void d(Context context) {
        if (context != null && com.baidu.mobstat.a.a.c(context, "__local_stat_cache.json")) {
            String a2 = com.baidu.mobstat.a.a.a(false, context, "__local_stat_cache.json");
            if (a2.equals("")) {
                com.baidu.mobstat.a.b.a("stat", "stat_cache file not found.");
                return;
            }
            com.baidu.mobstat.a.b.a("stat", "loadStatData, ");
            try {
                this.p = a2.getBytes().length;
                com.baidu.mobstat.a.b.a("stat", "load Stat Data:cacheFileSize is:" + this.p);
                JSONObject jSONObject = new JSONObject(a2);
                com.baidu.mobstat.a.b.a("stat", "Load cache:" + a2);
                long currentTimeMillis = System.currentTimeMillis();
                JSONArray jSONArray = jSONObject.getJSONArray("pr");
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    if (currentTimeMillis - jSONObject2.getLong("s") <= 604800000) {
                        a(jSONObject2, true);
                    }
                }
                JSONArray jSONArray2 = jSONObject.getJSONArray("ev");
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
                    if (currentTimeMillis - jSONObject3.getLong("t") <= 604800000) {
                        b(jSONObject3, true);
                    }
                }
                JSONArray jSONArray3 = jSONObject.getJSONArray("ex");
                for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                    JSONObject jSONObject4 = jSONArray3.getJSONObject(i3);
                    if (currentTimeMillis - jSONObject4.getLong("t") <= 604800000) {
                        c(jSONObject4, true);
                    }
                }
            } catch (JSONException e) {
                com.baidu.mobstat.a.b.a("stat", "Load stat data error:" + e);
            }
        }
    }
}
