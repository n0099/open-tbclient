package cn.jiguang.a.c;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import cn.jiguang.a.a.c.k;
import cn.jiguang.api.h;
import cn.jiguang.d.h.e;
import cn.jiguang.d.i.f;
import cn.jiguang.g.i;
import com.baidu.sapi2.activity.social.WXLoginActivity;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a {
    private static String a(Context context, int i) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        if (i == 53) {
            try {
                jSONObject2 = new JSONObject(cn.jiguang.d.a.a.e(context));
            } catch (JSONException e) {
            }
            if (jSONObject2 == null) {
                e.ch().a(context);
                jSONObject = cn.jiguang.a.a.c.b.a(context, e.ch());
            } else {
                jSONObject = jSONObject2;
            }
            try {
                e.ch();
                byte an = e.an(context);
                e.ch();
                String d = e.d(context);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("rom_type", (int) an);
                if (d == null) {
                    d = "";
                }
                jSONObject3.put("regid", d);
                jSONObject.put("rom_info", jSONObject3);
            } catch (JSONException e2) {
            }
            JSONObject jSONObject4 = new JSONObject();
            try {
                jSONObject4.put(IntentConfig.CMD, i);
                jSONObject4.put("content", jSONObject);
            } catch (JSONException e3) {
            }
            return jSONObject4.toString();
        }
        return null;
    }

    private static JSONObject a(String str) {
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            try {
                return new JSONObject(cn.jiguang.d.h.a.a.b(str, ""));
            } catch (Exception e2) {
                e.printStackTrace();
                return null;
            }
        } catch (Exception e3) {
            return null;
        }
    }

    public static void a(int i) {
        try {
            if (cn.jiguang.d.a.d != null) {
                switch (i) {
                    case 4:
                        c.a(cn.jiguang.d.a.d);
                        break;
                    case 5:
                        Context context = cn.jiguang.d.a.d;
                        a(cn.jiguang.d.b.d.bN().bO());
                        break;
                    case 6:
                        break;
                    case 9:
                        c.b(cn.jiguang.d.a.d);
                        break;
                    case 44:
                        k.a(cn.jiguang.d.a.d);
                        break;
                }
            } else {
                cn.jiguang.e.c.c("CtrlMessageProcessor", "processCtrlReportByCmd failed because JCore.mApplicationContext is null");
            }
        } catch (Exception e) {
            cn.jiguang.e.c.c("CtrlMessageProcessor", "processCtrlReport exception:" + e.getMessage());
        }
    }

    public static void a(Context context, Handler handler, long j, h hVar) {
        char c;
        cn.jiguang.d.e.a.c cVar = (cn.jiguang.d.e.a.c) hVar;
        String b = cVar.b();
        JSONObject jSONObject = null;
        int i = -1;
        if (!i.a(b) && (jSONObject = a(b)) != null) {
            i = jSONObject.optInt(IntentConfig.CMD, -1);
        }
        long a = cVar.a();
        String a2 = a(context, i);
        long c2 = cn.jiguang.d.a.d.c(null);
        long f = cn.jiguang.d.a.a.f();
        int a3 = cn.jiguang.d.a.d.a();
        cn.jiguang.api.a.b bVar = new cn.jiguang.api.a.b(20480);
        bVar.l(0);
        bVar.k(1);
        bVar.k(25);
        bVar.h(f);
        bVar.g(a3);
        bVar.h(c2);
        bVar.l(0);
        bVar.h(a);
        if (a2 != null) {
            bVar.f(a2.getBytes());
        }
        bVar.l(bVar.current(), 0);
        byte[] a4 = cn.jiguang.d.e.a.a.b.a(bVar.toByteArray(), 1);
        if (a4 == null) {
            cn.jiguang.e.c.c("CtrlMessageProcessor", "reportCtrlReceived to report received failed - " + a);
            c = 65535;
        } else {
            if (cn.jiguang.d.g.c.cf().cg().j(a4) != 0) {
                cn.jiguang.e.c.c("CtrlMessageProcessor", "Failed to report received - " + a);
            }
            c = 0;
        }
        if (c != 0 || jSONObject == null) {
            return;
        }
        try {
            switch (jSONObject.optInt(IntentConfig.CMD)) {
                case 4:
                    c.a(context);
                    break;
                case 5:
                    a(context, handler, jSONObject);
                    break;
                case 9:
                    c.b(context);
                    break;
                case 44:
                    k.a(context);
                    break;
                case 45:
                    c(context, jSONObject);
                    break;
                case 50:
                    d(context, jSONObject);
                    break;
                case 51:
                    e(context, jSONObject);
                    break;
                case 52:
                    f(context, jSONObject);
                    break;
                case 54:
                    a(context, jSONObject);
                    break;
                case 55:
                    b(context, jSONObject);
                    break;
            }
        } catch (Exception e) {
            cn.jiguang.e.c.b("CtrlMessageProcessor", "unexpected!", e);
        }
    }

    private static void a(Context context, Handler handler, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("content");
            if (jSONObject2.optBoolean("disable")) {
                cn.jiguang.e.c.a("CtrlMessageProcessor", "lbs disabled...");
                cn.jiguang.a.b.a.a(context, false);
                return;
            }
            cn.jiguang.e.c.a("CtrlMessageProcessor", "lbs enabled...");
            cn.jiguang.a.b.a.a(context, true);
            cn.jiguang.a.b.a.b(context, true);
            long optLong = jSONObject2.optLong("frequency", 0L);
            cn.jiguang.d.a.d.a(context, "report_location_frequency", Long.valueOf(optLong > 0 ? optLong * 1000 : cn.jiguang.a.b.a.a(context)));
            a(handler);
        } catch (JSONException e) {
            cn.jiguang.e.c.a("CtrlMessageProcessor", "unexpected! has wrong with JSONException", e);
        }
    }

    private static void a(Context context, JSONObject jSONObject) {
        try {
            if (jSONObject.has("content")) {
                jSONObject = jSONObject.getJSONObject("content");
            }
            long j = jSONObject.getLong("interval");
            if (j < 0) {
                cn.jiguang.d.a.d.a(context, "app_running_collect_enable", false);
                return;
            }
            int optInt = jSONObject.optInt("app_type", 0);
            int optInt2 = jSONObject.optInt("process_type", 0);
            if (j > 0) {
                cn.jiguang.d.a.d.a(context, new cn.jiguang.g.b.a().a("app_running_collect_enable", (Serializable) true).a("app_running_collect_interval", Long.valueOf(j)).a("app_running_collect_app_type", Integer.valueOf(optInt)).a("app_running_collect_process_type", Integer.valueOf(optInt2)));
            } else {
                cn.jiguang.g.d.b(context, optInt, optInt2);
            }
        } catch (Exception e) {
        }
    }

    private static void a(Handler handler) {
        Message.obtain(handler, 1002).sendToTarget();
    }

    private static void b(Context context, JSONObject jSONObject) {
        try {
            int optInt = jSONObject.getJSONObject("content").optInt(WXLoginActivity.KEY_BASE_RESP_STATE, -1);
            if (optInt != -1) {
                if (optInt == 0) {
                    cn.jiguang.d.a.d.b(context, optInt);
                } else if (optInt == 1) {
                    cn.jiguang.d.a.d.b(context, optInt);
                    cn.jiguang.d.f.a.ce().a(context, cn.jiguang.api.e.getUid());
                    cn.jiguang.d.f.a.a(context, context.getPackageName());
                }
            }
        } catch (Exception e) {
        }
    }

    private static void c(Context context, JSONObject jSONObject) {
        try {
            long optLong = jSONObject.getJSONObject("content").optLong("interval", 0L);
            if (optLong <= 0 || optLong > cn.jiguang.a.b.a.a(context) / 1000) {
                return;
            }
            cn.jiguang.d.a.d.a(context, "location_collect_frequency", Long.valueOf(optLong * 1000));
        } catch (JSONException e) {
            cn.jiguang.e.c.a("CtrlMessageProcessor", "unexpected! has wrong with JSONException", e);
        }
    }

    private static void d(Context context, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("content");
            int optInt = jSONObject2.optInt("type");
            cn.jiguang.d.i.h cl = f.cj().cl();
            switch (optInt) {
                case 1:
                    String optString = jSONObject2.optString("pkgName");
                    String optString2 = jSONObject2.optString("serviceName");
                    cn.jiguang.d.d.a aVar = new cn.jiguang.d.d.a();
                    aVar.a = optString;
                    aVar.b = optString2;
                    cl.a(context, aVar);
                    break;
                case 2:
                    String optString3 = jSONObject2.optString("pkgName");
                    String optString4 = jSONObject2.optString("serviceName");
                    cn.jiguang.d.d.a aVar2 = new cn.jiguang.d.d.a();
                    aVar2.a = optString3;
                    aVar2.b = optString4;
                    cl.b(context, aVar2);
                    break;
            }
        } catch (SecurityException e) {
        } catch (JSONException e2) {
        } catch (Throwable th) {
        }
    }

    private static void e(Context context, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("content");
            boolean optBoolean = jSONObject2.optBoolean("uploadnumber", false);
            String optString = jSONObject2.optString("version", "");
            String optString2 = jSONObject2.optString("app_id", "");
            String optString3 = jSONObject2.optString("app_secret", "");
            JSONArray optJSONArray = jSONObject2.optJSONArray("carriers");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject3 = optJSONArray.getJSONObject(i);
                    if (jSONObject3 != null) {
                        String optString4 = jSONObject3.optString("carrier", "");
                        String optString5 = jSONObject3.optString("url", "");
                        if (!i.a(optString4) && !i.a(optString5)) {
                            int a = cn.jiguang.a.a.c.i.a(optString4);
                            if (!optString5.startsWith("http://")) {
                                optString5 = "http://" + optString5;
                            }
                            if (!optString5.endsWith("/")) {
                                optString5 = optString5 + "/";
                            }
                            if (a != -1 && a >= 0 && a < 3) {
                                cn.jiguang.d.a.a.a(context, "number_url" + a, optString5);
                            }
                        }
                    }
                }
            }
            if (!i.a(optString)) {
                cn.jiguang.d.a.a.a(context, "number_version", optString);
            }
            if (i.a(optString2)) {
                cn.jiguang.d.a.a.a(context, "number_appid", optString2);
            }
            if (i.a(optString3)) {
                cn.jiguang.d.a.a.a(context, "number_appsecret", optString3);
            }
            if (optBoolean) {
                cn.jiguang.a.b.a.c(context, true);
                if (cn.jiguang.g.a.e(context).toUpperCase().startsWith("WIFI")) {
                    return;
                }
                cn.jiguang.a.a.c.i.a(context);
            }
        } catch (Exception e) {
        }
    }

    private static void f(Context context, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("content");
            boolean optBoolean = jSONObject2.optBoolean("disable");
            long optLong = (optBoolean || !jSONObject2.has("frequency")) ? 0L : jSONObject2.optLong("frequency", 0L);
            cn.jiguang.d.a.d.a(context, "arpinfo_report_enable", Boolean.valueOf(!optBoolean));
            cn.jiguang.d.a.d.a(context, "report_arpinfo_frequency", Long.valueOf(1000 * optLong));
            if (optBoolean) {
                return;
            }
            try {
                cn.jiguang.a.a.a.c.a(context);
            } catch (Throwable th) {
            }
        } catch (JSONException e) {
            cn.jiguang.e.c.a("CtrlMessageProcessor", "unexpected! has wrong with JSONException", e);
        }
    }
}
