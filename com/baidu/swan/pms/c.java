package com.baidu.swan.pms;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.c.d.f;
import com.baidu.swan.pms.c.d.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
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
                    if (gVar.bfZ() != null) {
                        a2.putAll(gVar.bfZ());
                    }
                    gVar.arf();
                    d.bfW().aBL().a(com.baidu.swan.pms.c.e.bgs(), a2, gVar.bga(), new com.baidu.swan.pms.c.b.b(gVar, cVar));
                }
            }
        }
    }

    public static synchronized void a(com.baidu.swan.pms.c.d.b bVar, g gVar) {
        synchronized (c.class) {
            if (gVar != null) {
                if (bVar == null) {
                    gVar.b(new com.baidu.swan.pms.model.a(2100, "request对象为空"));
                } else if (bVar.bgR() == null || bVar.bgR().isEmpty()) {
                    gVar.b(new com.baidu.swan.pms.model.a(2100, "pkg List为空"));
                } else {
                    HashMap<String, String> a2 = com.baidu.swan.pms.c.b.a(bVar);
                    if (gVar.bfZ() != null) {
                        a2.putAll(gVar.bfZ());
                    }
                    JSONObject b2 = com.baidu.swan.pms.c.b.b(bVar);
                    if (b2 == null) {
                        gVar.b(new com.baidu.swan.pms.model.a(2100, "构造请求body失败"));
                    } else {
                        if (gVar.bgb() != null) {
                            try {
                                for (Map.Entry<String, String> entry : gVar.bgb().entrySet()) {
                                    b2.put(entry.getKey(), entry.getValue());
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        gVar.arf();
                        d.bfW().aBL().a(com.baidu.swan.pms.c.e.bgu(), a2, gVar.bga(), b2, new com.baidu.swan.pms.c.b.a(gVar, bVar));
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
                } else if (TextUtils.isEmpty(fVar.bgZ())) {
                    gVar.b(new com.baidu.swan.pms.model.a(2100, "分包名为空"));
                } else {
                    HashMap<String, String> a2 = com.baidu.swan.pms.c.b.a(fVar);
                    if (gVar.bfZ() != null) {
                        a2.putAll(gVar.bfZ());
                    }
                    gVar.arf();
                    d.bfW().aBL().a(com.baidu.swan.pms.c.e.bgs(), a2, gVar.bga(), new com.baidu.swan.pms.c.b.d(gVar, fVar));
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
                    com.baidu.swan.pms.node.c<JSONArray> axA = aVar == null ? null : aVar.axA();
                    g axz = aVar == null ? null : aVar.axz();
                    HashMap hashMap = new HashMap();
                    if (gVar.bfZ() != null) {
                        hashMap.putAll(gVar.bfZ());
                    }
                    gVar.arf();
                    d.bfW().aBL().a(com.baidu.swan.pms.c.e.bgt(), hashMap, gVar.bga(), a(axA, (com.baidu.swan.pms.node.c<JSONObject>) null), new com.baidu.swan.pms.c.b.e(gVar, hVar, gVar2, axz));
                }
            }
        }
    }

    public static synchronized void a(com.baidu.swan.pms.d.a.a aVar) {
        synchronized (c.class) {
            if (aVar != null) {
                g axz = aVar.axz();
                if (axz != null) {
                    com.baidu.swan.pms.c.d.g axB = aVar.axB();
                    if (axB == null) {
                        axz.b(new com.baidu.swan.pms.model.a(2100, "request对象为空"));
                    } else {
                        Map<String, String> bfZ = axz.bfZ();
                        Map<String, String> hashMap = axz.bfZ() != null ? new HashMap<>(bfZ) : bfZ;
                        axz.arf();
                        d.bfW().aBL().a(com.baidu.swan.pms.c.e.bgt(), hashMap, axz.bga(), a(aVar.axA(), (com.baidu.swan.pms.node.c<JSONObject>) null), new com.baidu.swan.pms.c.b.e(axz, axB, null, axz));
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
                    if (gVar.bfZ() != null) {
                        a2.putAll(gVar.bfZ());
                    }
                    gVar.arf();
                    d.bfW().aBL().a(com.baidu.swan.pms.c.e.bgv(), a2, gVar.bga(), new com.baidu.swan.pms.c.b.c(gVar, dVar));
                }
            }
        }
    }

    public static synchronized boolean yK(String str) {
        boolean yK;
        synchronized (c.class) {
            yK = com.baidu.swan.pms.c.a.d.d.bgD().yK(str);
        }
        return yK;
    }

    public static synchronized boolean yL(String str) {
        boolean yL;
        synchronized (c.class) {
            yL = com.baidu.swan.pms.c.a.d.d.bgD().yL(str);
        }
        return yL;
    }
}
