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
                    if (gVar.bbe() != null) {
                        a2.putAll(gVar.bbe());
                    }
                    gVar.ans();
                    d.bbb().axT().a(com.baidu.swan.pms.c.e.bbx(), a2, gVar.bbf(), new com.baidu.swan.pms.c.b.b(gVar, cVar));
                }
            }
        }
    }

    public static synchronized void a(com.baidu.swan.pms.c.d.b bVar, g gVar) {
        synchronized (c.class) {
            if (gVar != null) {
                if (bVar == null) {
                    gVar.b(new com.baidu.swan.pms.model.a(2100, "request对象为空"));
                } else if (bVar.bbX() == null || bVar.bbX().isEmpty()) {
                    gVar.b(new com.baidu.swan.pms.model.a(2100, "pkg List为空"));
                } else {
                    HashMap<String, String> a2 = com.baidu.swan.pms.c.b.a(bVar);
                    if (gVar.bbe() != null) {
                        a2.putAll(gVar.bbe());
                    }
                    JSONObject b = com.baidu.swan.pms.c.b.b(bVar);
                    if (b == null) {
                        gVar.b(new com.baidu.swan.pms.model.a(2100, "构造请求body失败"));
                    } else {
                        if (gVar.bbg() != null) {
                            try {
                                for (Map.Entry<String, String> entry : gVar.bbg().entrySet()) {
                                    b.put(entry.getKey(), entry.getValue());
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        gVar.ans();
                        d.bbb().axT().a(com.baidu.swan.pms.c.e.bbz(), a2, gVar.bbf(), b, new com.baidu.swan.pms.c.b.a(gVar, bVar));
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
                } else if (TextUtils.isEmpty(fVar.bcf())) {
                    gVar.b(new com.baidu.swan.pms.model.a(2100, "分包名为空"));
                } else {
                    HashMap<String, String> a2 = com.baidu.swan.pms.c.b.a(fVar);
                    if (gVar.bbe() != null) {
                        a2.putAll(gVar.bbe());
                    }
                    gVar.ans();
                    d.bbb().axT().a(com.baidu.swan.pms.c.e.bbx(), a2, gVar.bbf(), new com.baidu.swan.pms.c.b.d(gVar, fVar));
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
                    com.baidu.swan.pms.node.c<JSONArray> atH = aVar == null ? null : aVar.atH();
                    g atG = aVar == null ? null : aVar.atG();
                    HashMap hashMap = new HashMap();
                    if (gVar.bbe() != null) {
                        hashMap.putAll(gVar.bbe());
                    }
                    gVar.ans();
                    d.bbb().axT().a(com.baidu.swan.pms.c.e.bby(), hashMap, gVar.bbf(), a(atH, (com.baidu.swan.pms.node.c<JSONObject>) null), new com.baidu.swan.pms.c.b.e(gVar, hVar, gVar2, atG));
                }
            }
        }
    }

    public static synchronized void a(com.baidu.swan.pms.d.a.a aVar) {
        synchronized (c.class) {
            if (aVar != null) {
                g atG = aVar.atG();
                if (atG != null) {
                    com.baidu.swan.pms.c.d.g atI = aVar.atI();
                    if (atI == null) {
                        atG.b(new com.baidu.swan.pms.model.a(2100, "request对象为空"));
                    } else {
                        Map<String, String> bbe = atG.bbe();
                        Map<String, String> hashMap = atG.bbe() != null ? new HashMap<>(bbe) : bbe;
                        atG.ans();
                        d.bbb().axT().a(com.baidu.swan.pms.c.e.bby(), hashMap, atG.bbf(), a(aVar.atH(), (com.baidu.swan.pms.node.c<JSONObject>) null), new com.baidu.swan.pms.c.b.e(atG, atI, null, atG));
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
                    if (gVar.bbe() != null) {
                        a2.putAll(gVar.bbe());
                    }
                    gVar.ans();
                    d.bbb().axT().a(com.baidu.swan.pms.c.e.bbA(), a2, gVar.bbf(), new com.baidu.swan.pms.c.b.c(gVar, dVar));
                }
            }
        }
    }

    public static synchronized boolean yj(String str) {
        boolean yj;
        synchronized (c.class) {
            yj = com.baidu.swan.pms.c.a.d.d.bbI().yj(str);
        }
        return yj;
    }

    public static synchronized boolean yk(String str) {
        boolean yk;
        synchronized (c.class) {
            yk = com.baidu.swan.pms.c.a.d.d.bbI().yk(str);
        }
        return yk;
    }
}
