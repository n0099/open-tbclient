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
                    if (gVar.aYE() != null) {
                        a2.putAll(gVar.aYE());
                    }
                    gVar.akS();
                    d.aYB().avt().a(com.baidu.swan.pms.c.e.aYX(), a2, gVar.aYF(), new com.baidu.swan.pms.c.b.b(gVar, cVar));
                }
            }
        }
    }

    public static synchronized void a(com.baidu.swan.pms.c.d.b bVar, g gVar) {
        synchronized (c.class) {
            if (gVar != null) {
                if (bVar == null) {
                    gVar.b(new com.baidu.swan.pms.model.a(2100, "request对象为空"));
                } else if (bVar.aZx() == null || bVar.aZx().isEmpty()) {
                    gVar.b(new com.baidu.swan.pms.model.a(2100, "pkg List为空"));
                } else {
                    HashMap<String, String> a2 = com.baidu.swan.pms.c.b.a(bVar);
                    if (gVar.aYE() != null) {
                        a2.putAll(gVar.aYE());
                    }
                    JSONObject b = com.baidu.swan.pms.c.b.b(bVar);
                    if (b == null) {
                        gVar.b(new com.baidu.swan.pms.model.a(2100, "构造请求body失败"));
                    } else {
                        if (gVar.aYG() != null) {
                            try {
                                for (Map.Entry<String, String> entry : gVar.aYG().entrySet()) {
                                    b.put(entry.getKey(), entry.getValue());
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        gVar.akS();
                        d.aYB().avt().a(com.baidu.swan.pms.c.e.aYZ(), a2, gVar.aYF(), b, new com.baidu.swan.pms.c.b.a(gVar, bVar));
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
                } else if (TextUtils.isEmpty(fVar.aZF())) {
                    gVar.b(new com.baidu.swan.pms.model.a(2100, "分包名为空"));
                } else {
                    HashMap<String, String> a2 = com.baidu.swan.pms.c.b.a(fVar);
                    if (gVar.aYE() != null) {
                        a2.putAll(gVar.aYE());
                    }
                    gVar.akS();
                    d.aYB().avt().a(com.baidu.swan.pms.c.e.aYX(), a2, gVar.aYF(), new com.baidu.swan.pms.c.b.d(gVar, fVar));
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
                    com.baidu.swan.pms.node.c<JSONArray> arg = aVar == null ? null : aVar.arg();
                    g arf = aVar == null ? null : aVar.arf();
                    HashMap hashMap = new HashMap();
                    if (gVar.aYE() != null) {
                        hashMap.putAll(gVar.aYE());
                    }
                    gVar.akS();
                    d.aYB().avt().a(com.baidu.swan.pms.c.e.aYY(), hashMap, gVar.aYF(), a(arg, (com.baidu.swan.pms.node.c<JSONObject>) null), new com.baidu.swan.pms.c.b.e(gVar, hVar, gVar2, arf));
                }
            }
        }
    }

    public static synchronized void a(com.baidu.swan.pms.d.a.a aVar) {
        synchronized (c.class) {
            if (aVar != null) {
                g arf = aVar.arf();
                if (arf != null) {
                    com.baidu.swan.pms.c.d.g arh = aVar.arh();
                    if (arh == null) {
                        arf.b(new com.baidu.swan.pms.model.a(2100, "request对象为空"));
                    } else {
                        Map<String, String> aYE = arf.aYE();
                        Map<String, String> hashMap = arf.aYE() != null ? new HashMap<>(aYE) : aYE;
                        arf.akS();
                        d.aYB().avt().a(com.baidu.swan.pms.c.e.aYY(), hashMap, arf.aYF(), a(aVar.arg(), (com.baidu.swan.pms.node.c<JSONObject>) null), new com.baidu.swan.pms.c.b.e(arf, arh, null, arf));
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
                    if (gVar.aYE() != null) {
                        a2.putAll(gVar.aYE());
                    }
                    gVar.akS();
                    d.aYB().avt().a(com.baidu.swan.pms.c.e.aZa(), a2, gVar.aYF(), new com.baidu.swan.pms.c.b.c(gVar, dVar));
                }
            }
        }
    }

    public static synchronized boolean xV(String str) {
        boolean xV;
        synchronized (c.class) {
            xV = com.baidu.swan.pms.c.a.d.d.aZi().xV(str);
        }
        return xV;
    }

    public static synchronized boolean xW(String str) {
        boolean xW;
        synchronized (c.class) {
            xW = com.baidu.swan.pms.c.a.d.d.aZi().xW(str);
        }
        return xW;
    }
}
