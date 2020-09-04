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
/* loaded from: classes14.dex */
public class c {
    public static synchronized void a(com.baidu.swan.pms.c.d.c cVar, g gVar) {
        synchronized (c.class) {
            if (gVar != null) {
                if (cVar == null) {
                    gVar.b(new com.baidu.swan.pms.model.a(2100, "request对象为空"));
                } else if (TextUtils.isEmpty(cVar.getBundleId())) {
                    gVar.b(new com.baidu.swan.pms.model.a(2100, "bundleId为空"));
                } else {
                    HashMap<String, String> a = com.baidu.swan.pms.c.b.a(cVar);
                    if (gVar.aTq() != null) {
                        a.putAll(gVar.aTq());
                    }
                    gVar.afD();
                    d.aTn().aqd().a(com.baidu.swan.pms.c.e.aTJ(), a, gVar.aTr(), new com.baidu.swan.pms.c.b.b(gVar, cVar));
                }
            }
        }
    }

    public static synchronized void a(com.baidu.swan.pms.c.d.b bVar, g gVar) {
        synchronized (c.class) {
            if (gVar != null) {
                if (bVar == null) {
                    gVar.b(new com.baidu.swan.pms.model.a(2100, "request对象为空"));
                } else if (bVar.aUj() == null || bVar.aUj().isEmpty()) {
                    gVar.b(new com.baidu.swan.pms.model.a(2100, "pkg List为空"));
                } else {
                    HashMap<String, String> a = com.baidu.swan.pms.c.b.a(bVar);
                    if (gVar.aTq() != null) {
                        a.putAll(gVar.aTq());
                    }
                    JSONObject b = com.baidu.swan.pms.c.b.b(bVar);
                    if (b == null) {
                        gVar.b(new com.baidu.swan.pms.model.a(2100, "构造请求body失败"));
                    } else {
                        if (gVar.aTs() != null) {
                            try {
                                for (Map.Entry<String, String> entry : gVar.aTs().entrySet()) {
                                    b.put(entry.getKey(), entry.getValue());
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        gVar.afD();
                        d.aTn().aqd().a(com.baidu.swan.pms.c.e.aTL(), a, gVar.aTr(), b, new com.baidu.swan.pms.c.b.a(gVar, bVar));
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
                } else if (TextUtils.isEmpty(fVar.aUr())) {
                    gVar.b(new com.baidu.swan.pms.model.a(2100, "分包名为空"));
                } else {
                    HashMap<String, String> a = com.baidu.swan.pms.c.b.a(fVar);
                    if (gVar.aTq() != null) {
                        a.putAll(gVar.aTq());
                    }
                    gVar.afD();
                    d.aTn().aqd().a(com.baidu.swan.pms.c.e.aTJ(), a, gVar.aTr(), new com.baidu.swan.pms.c.b.d(gVar, fVar));
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
                    com.baidu.swan.pms.node.c<JSONArray> alQ = aVar == null ? null : aVar.alQ();
                    g alP = aVar == null ? null : aVar.alP();
                    HashMap hashMap = new HashMap();
                    if (gVar.aTq() != null) {
                        hashMap.putAll(gVar.aTq());
                    }
                    gVar.afD();
                    d.aTn().aqd().a(com.baidu.swan.pms.c.e.aTK(), hashMap, gVar.aTr(), a(alQ, (com.baidu.swan.pms.node.c<JSONObject>) null), new com.baidu.swan.pms.c.b.e(gVar, hVar, gVar2, alP));
                }
            }
        }
    }

    public static synchronized void a(com.baidu.swan.pms.d.a.a aVar) {
        synchronized (c.class) {
            if (aVar != null) {
                g alP = aVar.alP();
                if (alP != null) {
                    com.baidu.swan.pms.c.d.g alR = aVar.alR();
                    if (alR == null) {
                        alP.b(new com.baidu.swan.pms.model.a(2100, "request对象为空"));
                    } else {
                        Map<String, String> aTq = alP.aTq();
                        Map<String, String> hashMap = alP.aTq() != null ? new HashMap<>(aTq) : aTq;
                        alP.afD();
                        d.aTn().aqd().a(com.baidu.swan.pms.c.e.aTK(), hashMap, alP.aTr(), a(aVar.alQ(), (com.baidu.swan.pms.node.c<JSONObject>) null), new com.baidu.swan.pms.c.b.e(alP, alR, null, alP));
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
                    HashMap<String, String> a = com.baidu.swan.pms.c.b.a(dVar);
                    if (gVar.aTq() != null) {
                        a.putAll(gVar.aTq());
                    }
                    gVar.afD();
                    d.aTn().aqd().a(com.baidu.swan.pms.c.e.aTM(), a, gVar.aTr(), new com.baidu.swan.pms.c.b.c(gVar, dVar));
                }
            }
        }
    }

    public static synchronized boolean wx(String str) {
        boolean wx;
        synchronized (c.class) {
            wx = com.baidu.swan.pms.c.a.d.d.aTU().wx(str);
        }
        return wx;
    }

    public static synchronized boolean wy(String str) {
        boolean wy;
        synchronized (c.class) {
            wy = com.baidu.swan.pms.c.a.d.d.aTU().wy(str);
        }
        return wy;
    }
}
