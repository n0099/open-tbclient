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
                    if (gVar.bdC() != null) {
                        a2.putAll(gVar.bdC());
                    }
                    gVar.apS();
                    d.bdz().aAt().a(com.baidu.swan.pms.c.e.bdV(), a2, gVar.bdD(), new com.baidu.swan.pms.c.b.b(gVar, cVar));
                }
            }
        }
    }

    public static synchronized void a(com.baidu.swan.pms.c.d.b bVar, g gVar) {
        synchronized (c.class) {
            if (gVar != null) {
                if (bVar == null) {
                    gVar.b(new com.baidu.swan.pms.model.a(2100, "request对象为空"));
                } else if (bVar.bev() == null || bVar.bev().isEmpty()) {
                    gVar.b(new com.baidu.swan.pms.model.a(2100, "pkg List为空"));
                } else {
                    HashMap<String, String> a2 = com.baidu.swan.pms.c.b.a(bVar);
                    if (gVar.bdC() != null) {
                        a2.putAll(gVar.bdC());
                    }
                    JSONObject b = com.baidu.swan.pms.c.b.b(bVar);
                    if (b == null) {
                        gVar.b(new com.baidu.swan.pms.model.a(2100, "构造请求body失败"));
                    } else {
                        if (gVar.bdE() != null) {
                            try {
                                for (Map.Entry<String, String> entry : gVar.bdE().entrySet()) {
                                    b.put(entry.getKey(), entry.getValue());
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        gVar.apS();
                        d.bdz().aAt().a(com.baidu.swan.pms.c.e.bdX(), a2, gVar.bdD(), b, new com.baidu.swan.pms.c.b.a(gVar, bVar));
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
                } else if (TextUtils.isEmpty(fVar.beD())) {
                    gVar.b(new com.baidu.swan.pms.model.a(2100, "分包名为空"));
                } else {
                    HashMap<String, String> a2 = com.baidu.swan.pms.c.b.a(fVar);
                    if (gVar.bdC() != null) {
                        a2.putAll(gVar.bdC());
                    }
                    gVar.apS();
                    d.bdz().aAt().a(com.baidu.swan.pms.c.e.bdV(), a2, gVar.bdD(), new com.baidu.swan.pms.c.b.d(gVar, fVar));
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
                    com.baidu.swan.pms.node.c<JSONArray> awh = aVar == null ? null : aVar.awh();
                    g awg = aVar == null ? null : aVar.awg();
                    HashMap hashMap = new HashMap();
                    if (gVar.bdC() != null) {
                        hashMap.putAll(gVar.bdC());
                    }
                    gVar.apS();
                    d.bdz().aAt().a(com.baidu.swan.pms.c.e.bdW(), hashMap, gVar.bdD(), a(awh, (com.baidu.swan.pms.node.c<JSONObject>) null), new com.baidu.swan.pms.c.b.e(gVar, hVar, gVar2, awg));
                }
            }
        }
    }

    public static synchronized void a(com.baidu.swan.pms.d.a.a aVar) {
        synchronized (c.class) {
            if (aVar != null) {
                g awg = aVar.awg();
                if (awg != null) {
                    com.baidu.swan.pms.c.d.g awi = aVar.awi();
                    if (awi == null) {
                        awg.b(new com.baidu.swan.pms.model.a(2100, "request对象为空"));
                    } else {
                        Map<String, String> bdC = awg.bdC();
                        Map<String, String> hashMap = awg.bdC() != null ? new HashMap<>(bdC) : bdC;
                        awg.apS();
                        d.bdz().aAt().a(com.baidu.swan.pms.c.e.bdW(), hashMap, awg.bdD(), a(aVar.awh(), (com.baidu.swan.pms.node.c<JSONObject>) null), new com.baidu.swan.pms.c.b.e(awg, awi, null, awg));
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
                    if (gVar.bdC() != null) {
                        a2.putAll(gVar.bdC());
                    }
                    gVar.apS();
                    d.bdz().aAt().a(com.baidu.swan.pms.c.e.bdY(), a2, gVar.bdD(), new com.baidu.swan.pms.c.b.c(gVar, dVar));
                }
            }
        }
    }

    public static synchronized boolean yL(String str) {
        boolean yL;
        synchronized (c.class) {
            yL = com.baidu.swan.pms.c.a.d.d.beg().yL(str);
        }
        return yL;
    }

    public static synchronized boolean yM(String str) {
        boolean yM;
        synchronized (c.class) {
            yM = com.baidu.swan.pms.c.a.d.d.beg().yM(str);
        }
        return yM;
    }
}
