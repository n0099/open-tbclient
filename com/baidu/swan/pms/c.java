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
/* loaded from: classes3.dex */
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
                    if (gVar.bcs() != null) {
                        a2.putAll(gVar.bcs());
                    }
                    gVar.anI();
                    d.bcp().ayp().a(com.baidu.swan.pms.c.e.bcL(), a2, gVar.bct(), new com.baidu.swan.pms.c.b.b(gVar, cVar));
                }
            }
        }
    }

    public static synchronized void a(com.baidu.swan.pms.c.d.b bVar, g gVar) {
        synchronized (c.class) {
            if (gVar != null) {
                if (bVar == null) {
                    gVar.b(new com.baidu.swan.pms.model.a(2100, "request对象为空"));
                } else if (bVar.bdk() == null || bVar.bdk().isEmpty()) {
                    gVar.b(new com.baidu.swan.pms.model.a(2100, "pkg List为空"));
                } else {
                    HashMap<String, String> a2 = com.baidu.swan.pms.c.b.a(bVar);
                    if (gVar.bcs() != null) {
                        a2.putAll(gVar.bcs());
                    }
                    JSONObject b2 = com.baidu.swan.pms.c.b.b(bVar);
                    if (b2 == null) {
                        gVar.b(new com.baidu.swan.pms.model.a(2100, "构造请求body失败"));
                    } else {
                        if (gVar.bcu() != null) {
                            try {
                                for (Map.Entry<String, String> entry : gVar.bcu().entrySet()) {
                                    b2.put(entry.getKey(), entry.getValue());
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        gVar.anI();
                        d.bcp().ayp().a(com.baidu.swan.pms.c.e.bcN(), a2, gVar.bct(), b2, new com.baidu.swan.pms.c.b.a(gVar, bVar));
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
                } else if (TextUtils.isEmpty(fVar.bds())) {
                    gVar.b(new com.baidu.swan.pms.model.a(2100, "分包名为空"));
                } else {
                    HashMap<String, String> a2 = com.baidu.swan.pms.c.b.a(fVar);
                    if (gVar.bcs() != null) {
                        a2.putAll(gVar.bcs());
                    }
                    gVar.anI();
                    d.bcp().ayp().a(com.baidu.swan.pms.c.e.bcL(), a2, gVar.bct(), new com.baidu.swan.pms.c.b.d(gVar, fVar));
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
                    com.baidu.swan.pms.node.c<JSONArray> aue = aVar == null ? null : aVar.aue();
                    g aud = aVar == null ? null : aVar.aud();
                    HashMap hashMap = new HashMap();
                    if (gVar.bcs() != null) {
                        hashMap.putAll(gVar.bcs());
                    }
                    gVar.anI();
                    d.bcp().ayp().a(com.baidu.swan.pms.c.e.bcM(), hashMap, gVar.bct(), a(aue, (com.baidu.swan.pms.node.c<JSONObject>) null), new com.baidu.swan.pms.c.b.e(gVar, hVar, gVar2, aud));
                }
            }
        }
    }

    public static synchronized void a(com.baidu.swan.pms.d.a.a aVar) {
        synchronized (c.class) {
            if (aVar != null) {
                g aud = aVar.aud();
                if (aud != null) {
                    com.baidu.swan.pms.c.d.g auf = aVar.auf();
                    if (auf == null) {
                        aud.b(new com.baidu.swan.pms.model.a(2100, "request对象为空"));
                    } else {
                        Map<String, String> bcs = aud.bcs();
                        Map<String, String> hashMap = aud.bcs() != null ? new HashMap<>(bcs) : bcs;
                        aud.anI();
                        d.bcp().ayp().a(com.baidu.swan.pms.c.e.bcM(), hashMap, aud.bct(), a(aVar.aue(), (com.baidu.swan.pms.node.c<JSONObject>) null), new com.baidu.swan.pms.c.b.e(aud, auf, null, aud));
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
                    if (gVar.bcs() != null) {
                        a2.putAll(gVar.bcs());
                    }
                    gVar.anI();
                    d.bcp().ayp().a(com.baidu.swan.pms.c.e.bcO(), a2, gVar.bct(), new com.baidu.swan.pms.c.b.c(gVar, dVar));
                }
            }
        }
    }

    public static synchronized boolean xS(String str) {
        boolean xS;
        synchronized (c.class) {
            xS = com.baidu.swan.pms.c.a.d.d.bcW().xS(str);
        }
        return xS;
    }

    public static synchronized boolean xT(String str) {
        boolean xT;
        synchronized (c.class) {
            xT = com.baidu.swan.pms.c.a.d.d.bcW().xT(str);
        }
        return xT;
    }
}
