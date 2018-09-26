package cn.jiguang.a.a.b;

import android.content.Context;
import android.net.http.Headers;
import android.os.Handler;
import android.os.HandlerThread;
import cn.jiguang.d.d.aa;
import com.baidu.ar.constants.HttpConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class f {
    private static final Object d = new Object();
    private static volatile f kb;
    protected Handler b;
    private Context e;
    private a kc;
    private c kd;
    private h ke;
    private String f = "all";
    private boolean g = true;
    public boolean a = false;
    private String h = null;
    private String i = null;
    private String j = null;
    private boolean k = false;

    private f(Context context) {
        this.e = context;
        this.kc = new a(context, this);
        this.ke = new h(context);
        this.kd = new c(context, this);
    }

    public static e R(Context context) {
        e aY = kb != null ? kb.aY() : null;
        if (aY == null || !aY.a()) {
            aY = e.E(cn.jiguang.d.a.d.l(context));
        }
        return (aY == null || !aY.a()) ? new e(200.0d, 200.0d, 0.0d, 0.0f, 0.0f, "", 0L, false) : aY;
    }

    public static void a(Context context, boolean z) {
        if (context == null) {
            return;
        }
        if (kb == null) {
            synchronized (d) {
                if (kb == null) {
                    kb = new f(context);
                }
            }
        }
        kb.a = z;
        f fVar = kb;
        try {
            if (fVar.b == null) {
                HandlerThread handlerThread = new HandlerThread(Headers.LOCATION);
                handlerThread.start();
                fVar.b = new g(fVar, handlerThread.getLooper());
            }
            fVar.b.sendEmptyMessage(1000);
        } catch (Throwable th) {
        }
    }

    private boolean a(JSONArray jSONArray, JSONArray jSONArray2, String str) {
        if (cn.jiguang.g.i.a(str)) {
            if (!cn.jiguang.g.i.a(this.j)) {
                return false;
            }
        } else if (!str.equals(this.j)) {
            return false;
        }
        if (cn.jiguang.g.i.a(this.i)) {
            if (jSONArray2 != null && jSONArray2.length() != 0) {
                return false;
            }
        } else if (jSONArray2 == null) {
            return false;
        } else {
            if (jSONArray2.length() == 0) {
                return false;
            }
            if (!this.i.equals(jSONArray2.toString())) {
                return false;
            }
        }
        if (!cn.jiguang.g.i.a(this.h)) {
            if (jSONArray != null && jSONArray.length() != 0) {
                try {
                    String optString = ((JSONObject) jSONArray.get(0)).optString("ssid");
                    if (!cn.jiguang.g.i.a(optString)) {
                        if (!optString.equals(this.h)) {
                            return false;
                        }
                    }
                } catch (Exception e) {
                    return false;
                }
            }
            return false;
        } else if (jSONArray != null && jSONArray.length() != 0) {
            return false;
        }
        return true;
    }

    private e aY() {
        if (this.kd != null) {
            return this.kd.aX();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(f fVar) {
        fVar.kc.c();
        fVar.ke.a();
        fVar.kd.b();
    }

    private void c() {
        JSONObject I;
        boolean z;
        JSONArray jSONArray = null;
        if (cn.jiguang.d.a.d.d(this.e)) {
            JSONArray c = this.ke.c();
            JSONArray aW = this.kc.aW();
            e aY = this.a ? null : aY();
            JSONObject f = aY != null ? aY.f() : null;
            if (f == null && aW == null && c == null) {
                return;
            }
            String jSONObject = f != null ? f.toString() : "";
            if (a(c, aW, jSONObject)) {
                return;
            }
            if (f != null && f.length() > 0) {
                JSONArray jSONArray2 = new JSONArray();
                jSONArray2.put(f);
                jSONArray = jSONArray2;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                aa.a(this.e, jSONObject2, "loc_info");
                jSONObject2.put(HttpConstants.NETWORK_TYPE, cn.jiguang.g.a.e(this.e));
                jSONObject2.put("local_dns", cn.jiguang.g.a.b());
                if (c != null && c.length() > 0) {
                    jSONObject2.put("wifi", c);
                    this.h = ((JSONObject) c.get(0)).optString("ssid");
                }
                if (aW != null && aW.length() > 0) {
                    jSONObject2.put("cell", aW);
                    this.i = aW.toString();
                }
                if (!this.a && jSONArray != null && jSONArray.length() > 0) {
                    jSONObject2.put("gps", jSONArray);
                    this.j = jSONObject;
                }
                Context context = this.e;
                synchronized ("jpush_lbs_info.json") {
                    I = aa.I(context, "jpush_lbs_info.json");
                }
                JSONObject jSONObject3 = I == null ? new JSONObject() : I;
                JSONArray optJSONArray = jSONObject3.optJSONArray("content");
                JSONArray jSONArray3 = optJSONArray == null ? new JSONArray() : optJSONArray;
                try {
                    jSONArray3.put(jSONObject2);
                    long longValue = ((Long) cn.jiguang.d.a.d.b(context, "last_report_location", 0L)).longValue();
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - longValue > cn.jiguang.a.b.a.a(context)) {
                        cn.jiguang.d.a.d.a(context, "last_report_location", Long.valueOf(currentTimeMillis));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z && !((Boolean) cn.jiguang.d.a.d.b(context, "lbs_report_now", false)).booleanValue()) {
                        jSONObject3.put("content", jSONArray3);
                        synchronized ("jpush_lbs_info.json") {
                            aa.b(context, "jpush_lbs_info.json", jSONObject3);
                        }
                        return;
                    }
                    cn.jiguang.a.b.a.b(context, false);
                    cn.jiguang.d.a.d.a(context, "last_report_location", Long.valueOf(System.currentTimeMillis()));
                    aa.a(context, jSONArray3);
                    synchronized ("jpush_lbs_info.json") {
                        if (!aa.b(context, "jpush_lbs_info.json", null)) {
                            context.deleteFile("jpush_lbs_info.json");
                        }
                    }
                } catch (JSONException e) {
                    cn.jiguang.e.c.a("MyLocationManager", "unexpected on lbs reportPrepare", e);
                }
            } catch (JSONException e2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(f fVar) {
        if (cn.jiguang.g.a.a(fVar.e, "android.permission.ACCESS_COARSE_LOCATION")) {
            fVar.kc.a();
        } else {
            fVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a() {
        this.ke.b();
        this.kd.a(this.e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b() {
        JSONObject a;
        JSONObject a2;
        try {
            if (this.g) {
                if (this.f.equals("cell_towers")) {
                    if (cn.jiguang.d.a.d.d(this.e) && (a2 = cn.jiguang.g.a.a("loc_cell", this.kc.aW())) != null && a2.length() > 0) {
                        aa.a(this.e, a2);
                    }
                } else if (this.f.equals("wifi_towers")) {
                    if (cn.jiguang.d.a.d.d(this.e) && (a = cn.jiguang.g.a.a("loc_wifi", this.ke.c())) != null && a.length() > 0) {
                        aa.a(this.e, a);
                    }
                } else if (this.f.equals("gps")) {
                    if (cn.jiguang.d.a.d.d(this.e) && !this.a) {
                        e aY = aY();
                        JSONObject f = aY != null ? aY.f() : null;
                        if (f != null && f.length() > 0) {
                            JSONArray jSONArray = new JSONArray();
                            jSONArray.put(f);
                            JSONObject a3 = cn.jiguang.g.a.a("loc_gps", jSONArray);
                            if (a3 != null && a3.length() > 0) {
                                aa.a(this.e, a3);
                            }
                        }
                    }
                } else if (this.f.equals("all")) {
                    c();
                }
            }
        } catch (Exception e) {
        } finally {
            this.k = false;
        }
        if (this.b != null) {
            this.b.removeCallbacksAndMessages(null);
            try {
                this.b.getLooper().quit();
            } catch (Exception e2) {
            }
            this.b = null;
        }
    }
}
