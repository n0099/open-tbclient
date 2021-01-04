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
                    if (gVar.bfY() != null) {
                        a2.putAll(gVar.bfY());
                    }
                    gVar.are();
                    d.bfV().aBK().a(com.baidu.swan.pms.c.e.bgr(), a2, gVar.bfZ(), new com.baidu.swan.pms.c.b.b(gVar, cVar));
                }
            }
        }
    }

    public static synchronized void a(com.baidu.swan.pms.c.d.b bVar, g gVar) {
        synchronized (c.class) {
            if (gVar != null) {
                if (bVar == null) {
                    gVar.b(new com.baidu.swan.pms.model.a(2100, "request对象为空"));
                } else if (bVar.bgQ() == null || bVar.bgQ().isEmpty()) {
                    gVar.b(new com.baidu.swan.pms.model.a(2100, "pkg List为空"));
                } else {
                    HashMap<String, String> a2 = com.baidu.swan.pms.c.b.a(bVar);
                    if (gVar.bfY() != null) {
                        a2.putAll(gVar.bfY());
                    }
                    JSONObject b2 = com.baidu.swan.pms.c.b.b(bVar);
                    if (b2 == null) {
                        gVar.b(new com.baidu.swan.pms.model.a(2100, "构造请求body失败"));
                    } else {
                        if (gVar.bga() != null) {
                            try {
                                for (Map.Entry<String, String> entry : gVar.bga().entrySet()) {
                                    b2.put(entry.getKey(), entry.getValue());
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        gVar.are();
                        d.bfV().aBK().a(com.baidu.swan.pms.c.e.bgt(), a2, gVar.bfZ(), b2, new com.baidu.swan.pms.c.b.a(gVar, bVar));
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
                } else if (TextUtils.isEmpty(fVar.bgY())) {
                    gVar.b(new com.baidu.swan.pms.model.a(2100, "分包名为空"));
                } else {
                    HashMap<String, String> a2 = com.baidu.swan.pms.c.b.a(fVar);
                    if (gVar.bfY() != null) {
                        a2.putAll(gVar.bfY());
                    }
                    gVar.are();
                    d.bfV().aBK().a(com.baidu.swan.pms.c.e.bgr(), a2, gVar.bfZ(), new com.baidu.swan.pms.c.b.d(gVar, fVar));
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
                    com.baidu.swan.pms.node.c<JSONArray> axz = aVar == null ? null : aVar.axz();
                    g axy = aVar == null ? null : aVar.axy();
                    HashMap hashMap = new HashMap();
                    if (gVar.bfY() != null) {
                        hashMap.putAll(gVar.bfY());
                    }
                    gVar.are();
                    d.bfV().aBK().a(com.baidu.swan.pms.c.e.bgs(), hashMap, gVar.bfZ(), a(axz, (com.baidu.swan.pms.node.c<JSONObject>) null), new com.baidu.swan.pms.c.b.e(gVar, hVar, gVar2, axy));
                }
            }
        }
    }

    public static synchronized void a(com.baidu.swan.pms.d.a.a aVar) {
        synchronized (c.class) {
            if (aVar != null) {
                g axy = aVar.axy();
                if (axy != null) {
                    com.baidu.swan.pms.c.d.g axA = aVar.axA();
                    if (axA == null) {
                        axy.b(new com.baidu.swan.pms.model.a(2100, "request对象为空"));
                    } else {
                        Map<String, String> bfY = axy.bfY();
                        Map<String, String> hashMap = axy.bfY() != null ? new HashMap<>(bfY) : bfY;
                        axy.are();
                        d.bfV().aBK().a(com.baidu.swan.pms.c.e.bgs(), hashMap, axy.bfZ(), a(aVar.axz(), (com.baidu.swan.pms.node.c<JSONObject>) null), new com.baidu.swan.pms.c.b.e(axy, axA, null, axy));
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
                    if (gVar.bfY() != null) {
                        a2.putAll(gVar.bfY());
                    }
                    gVar.are();
                    d.bfV().aBK().a(com.baidu.swan.pms.c.e.bgu(), a2, gVar.bfZ(), new com.baidu.swan.pms.c.b.c(gVar, dVar));
                }
            }
        }
    }

    public static synchronized boolean yK(String str) {
        boolean yK;
        synchronized (c.class) {
            yK = com.baidu.swan.pms.c.a.d.d.bgC().yK(str);
        }
        return yK;
    }

    public static synchronized boolean yL(String str) {
        boolean yL;
        synchronized (c.class) {
            yL = com.baidu.swan.pms.c.a.d.d.bgC().yL(str);
        }
        return yL;
    }
}
