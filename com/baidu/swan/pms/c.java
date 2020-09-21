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
/* loaded from: classes24.dex */
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
                    if (gVar.aUc() != null) {
                        a.putAll(gVar.aUc());
                    }
                    gVar.agn();
                    d.aTZ().aqN().a(com.baidu.swan.pms.c.e.aUv(), a, gVar.aUd(), new com.baidu.swan.pms.c.b.b(gVar, cVar));
                }
            }
        }
    }

    public static synchronized void a(com.baidu.swan.pms.c.d.b bVar, g gVar) {
        synchronized (c.class) {
            if (gVar != null) {
                if (bVar == null) {
                    gVar.b(new com.baidu.swan.pms.model.a(2100, "request对象为空"));
                } else if (bVar.aUV() == null || bVar.aUV().isEmpty()) {
                    gVar.b(new com.baidu.swan.pms.model.a(2100, "pkg List为空"));
                } else {
                    HashMap<String, String> a = com.baidu.swan.pms.c.b.a(bVar);
                    if (gVar.aUc() != null) {
                        a.putAll(gVar.aUc());
                    }
                    JSONObject b = com.baidu.swan.pms.c.b.b(bVar);
                    if (b == null) {
                        gVar.b(new com.baidu.swan.pms.model.a(2100, "构造请求body失败"));
                    } else {
                        if (gVar.aUe() != null) {
                            try {
                                for (Map.Entry<String, String> entry : gVar.aUe().entrySet()) {
                                    b.put(entry.getKey(), entry.getValue());
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        gVar.agn();
                        d.aTZ().aqN().a(com.baidu.swan.pms.c.e.aUx(), a, gVar.aUd(), b, new com.baidu.swan.pms.c.b.a(gVar, bVar));
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
                } else if (TextUtils.isEmpty(fVar.aVd())) {
                    gVar.b(new com.baidu.swan.pms.model.a(2100, "分包名为空"));
                } else {
                    HashMap<String, String> a = com.baidu.swan.pms.c.b.a(fVar);
                    if (gVar.aUc() != null) {
                        a.putAll(gVar.aUc());
                    }
                    gVar.agn();
                    d.aTZ().aqN().a(com.baidu.swan.pms.c.e.aUv(), a, gVar.aUd(), new com.baidu.swan.pms.c.b.d(gVar, fVar));
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
                    com.baidu.swan.pms.node.c<JSONArray> amA = aVar == null ? null : aVar.amA();
                    g amz = aVar == null ? null : aVar.amz();
                    HashMap hashMap = new HashMap();
                    if (gVar.aUc() != null) {
                        hashMap.putAll(gVar.aUc());
                    }
                    gVar.agn();
                    d.aTZ().aqN().a(com.baidu.swan.pms.c.e.aUw(), hashMap, gVar.aUd(), a(amA, (com.baidu.swan.pms.node.c<JSONObject>) null), new com.baidu.swan.pms.c.b.e(gVar, hVar, gVar2, amz));
                }
            }
        }
    }

    public static synchronized void a(com.baidu.swan.pms.d.a.a aVar) {
        synchronized (c.class) {
            if (aVar != null) {
                g amz = aVar.amz();
                if (amz != null) {
                    com.baidu.swan.pms.c.d.g amB = aVar.amB();
                    if (amB == null) {
                        amz.b(new com.baidu.swan.pms.model.a(2100, "request对象为空"));
                    } else {
                        Map<String, String> aUc = amz.aUc();
                        Map<String, String> hashMap = amz.aUc() != null ? new HashMap<>(aUc) : aUc;
                        amz.agn();
                        d.aTZ().aqN().a(com.baidu.swan.pms.c.e.aUw(), hashMap, amz.aUd(), a(aVar.amA(), (com.baidu.swan.pms.node.c<JSONObject>) null), new com.baidu.swan.pms.c.b.e(amz, amB, null, amz));
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
                    if (gVar.aUc() != null) {
                        a.putAll(gVar.aUc());
                    }
                    gVar.agn();
                    d.aTZ().aqN().a(com.baidu.swan.pms.c.e.aUy(), a, gVar.aUd(), new com.baidu.swan.pms.c.b.c(gVar, dVar));
                }
            }
        }
    }

    public static synchronized boolean wQ(String str) {
        boolean wQ;
        synchronized (c.class) {
            wQ = com.baidu.swan.pms.c.a.d.d.aUG().wQ(str);
        }
        return wQ;
    }

    public static synchronized boolean wR(String str) {
        boolean wR;
        synchronized (c.class) {
            wR = com.baidu.swan.pms.c.a.d.d.aUG().wR(str);
        }
        return wR;
    }
}
