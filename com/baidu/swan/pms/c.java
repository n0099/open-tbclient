package com.baidu.swan.pms;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.c.d.f;
import com.baidu.swan.pms.c.d.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class c {
    public static synchronized void a(com.baidu.swan.pms.c.d.c cVar, g gVar) {
        synchronized (c.class) {
            if (gVar != null) {
                if (cVar == null) {
                    gVar.b(new com.baidu.swan.pms.model.a(2100, "request对象为空"));
                } else if (TextUtils.isEmpty(cVar.getBundleId())) {
                    gVar.b(new com.baidu.swan.pms.model.a(2100, "bundleId为空"));
                } else {
                    HashMap<String, String> a2 = com.baidu.swan.pms.c.b.a(cVar);
                    if (gVar.aWL() != null) {
                        a2.putAll(gVar.aWL());
                    }
                    gVar.aiY();
                    d.aWI().atz().a(com.baidu.swan.pms.c.e.aXe(), a2, gVar.aWM(), new com.baidu.swan.pms.c.b.b(gVar, cVar));
                }
            }
        }
    }

    public static synchronized void a(com.baidu.swan.pms.c.d.b bVar, g gVar) {
        synchronized (c.class) {
            if (gVar != null) {
                if (bVar == null) {
                    gVar.b(new com.baidu.swan.pms.model.a(2100, "request对象为空"));
                } else if (bVar.aXE() == null || bVar.aXE().isEmpty()) {
                    gVar.b(new com.baidu.swan.pms.model.a(2100, "pkg List为空"));
                } else {
                    HashMap<String, String> a2 = com.baidu.swan.pms.c.b.a(bVar);
                    if (gVar.aWL() != null) {
                        a2.putAll(gVar.aWL());
                    }
                    JSONObject b = com.baidu.swan.pms.c.b.b(bVar);
                    if (b == null) {
                        gVar.b(new com.baidu.swan.pms.model.a(2100, "构造请求body失败"));
                    } else {
                        if (gVar.aWN() != null) {
                            try {
                                for (Map.Entry<String, String> entry : gVar.aWN().entrySet()) {
                                    b.put(entry.getKey(), entry.getValue());
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        gVar.aiY();
                        d.aWI().atz().a(com.baidu.swan.pms.c.e.aXg(), a2, gVar.aWM(), b, new com.baidu.swan.pms.c.b.a(gVar, bVar));
                    }
                }
            }
        }
    }

    public static synchronized void a(f fVar, g gVar) {
        synchronized (c.class) {
            if (gVar != null) {
                if (fVar == null) {
                    gVar.b(new com.baidu.swan.pms.model.a(2100, "request对象为空"));
                } else if (TextUtils.isEmpty(fVar.getBundleId())) {
                    gVar.b(new com.baidu.swan.pms.model.a(2100, "bundleId为空"));
                } else if (TextUtils.isEmpty(fVar.aXM())) {
                    gVar.b(new com.baidu.swan.pms.model.a(2100, "分包名为空"));
                } else {
                    HashMap<String, String> a2 = com.baidu.swan.pms.c.b.a(fVar);
                    if (gVar.aWL() != null) {
                        a2.putAll(gVar.aWL());
                    }
                    gVar.aiY();
                    d.aWI().atz().a(com.baidu.swan.pms.c.e.aXe(), a2, gVar.aWM(), new com.baidu.swan.pms.c.b.d(gVar, fVar));
                }
            }
        }
    }

    public static synchronized void a(h hVar, g gVar) {
        synchronized (c.class) {
            a(hVar, gVar, null);
        }
    }

    public static synchronized void a(h hVar, g gVar, g gVar2) {
        synchronized (c.class) {
            a(hVar, gVar, gVar2, null);
        }
    }

    public static synchronized void a(h hVar, g gVar, g gVar2, @Nullable com.baidu.swan.pms.d.a.a aVar) {
        synchronized (c.class) {
            if (gVar != null) {
                if (hVar == null) {
                    gVar.b(new com.baidu.swan.pms.model.a(2100, "request对象为空"));
                } else {
                    com.baidu.swan.pms.node.c<JSONArray> apm = aVar == null ? null : aVar.apm();
                    g apl = aVar == null ? null : aVar.apl();
                    HashMap hashMap = new HashMap();
                    if (gVar.aWL() != null) {
                        hashMap.putAll(gVar.aWL());
                    }
                    gVar.aiY();
                    d.aWI().atz().a(com.baidu.swan.pms.c.e.aXf(), hashMap, gVar.aWM(), a(apm, (com.baidu.swan.pms.node.c<JSONObject>) null), new com.baidu.swan.pms.c.b.e(gVar, hVar, gVar2, apl));
                }
            }
        }
    }

    public static synchronized void a(com.baidu.swan.pms.d.a.a aVar) {
        synchronized (c.class) {
            if (aVar != null) {
                g apl = aVar.apl();
                if (apl != null) {
                    com.baidu.swan.pms.c.d.g apn = aVar.apn();
                    if (apn == null) {
                        apl.b(new com.baidu.swan.pms.model.a(2100, "request对象为空"));
                    } else {
                        Map<String, String> aWL = apl.aWL();
                        Map<String, String> hashMap = apl.aWL() != null ? new HashMap<>(aWL) : aWL;
                        apl.aiY();
                        d.aWI().atz().a(com.baidu.swan.pms.c.e.aXf(), hashMap, apl.aWM(), a(aVar.apm(), (com.baidu.swan.pms.node.c<JSONObject>) null), new com.baidu.swan.pms.c.b.e(apl, apn, null, apl));
                    }
                }
            }
        }
    }

    private static JSONObject a(@Nullable com.baidu.swan.pms.node.c<JSONArray> cVar, @Nullable com.baidu.swan.pms.node.c<JSONObject> cVar2) {
        return com.baidu.swan.pms.node.f.b(cVar, cVar2);
    }

    public static synchronized void a(com.baidu.swan.pms.c.d.d dVar, g gVar) {
        synchronized (c.class) {
            if (gVar != null) {
                if (dVar == null) {
                    gVar.b(new com.baidu.swan.pms.model.a(2100, "request对象为空"));
                } else {
                    HashMap<String, String> a2 = com.baidu.swan.pms.c.b.a(dVar);
                    if (gVar.aWL() != null) {
                        a2.putAll(gVar.aWL());
                    }
                    gVar.aiY();
                    d.aWI().atz().a(com.baidu.swan.pms.c.e.aXh(), a2, gVar.aWM(), new com.baidu.swan.pms.c.b.c(gVar, dVar));
                }
            }
        }
    }

    public static synchronized boolean xC(String str) {
        boolean xC;
        synchronized (c.class) {
            xC = com.baidu.swan.pms.c.a.d.d.aXp().xC(str);
        }
        return xC;
    }

    public static synchronized boolean xD(String str) {
        boolean xD;
        synchronized (c.class) {
            xD = com.baidu.swan.pms.c.a.d.d.aXp().xD(str);
        }
        return xD;
    }
}
