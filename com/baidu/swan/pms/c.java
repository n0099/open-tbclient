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
                    if (gVar.bcu() != null) {
                        a2.putAll(gVar.bcu());
                    }
                    gVar.anL();
                    d.bcr().ays().a(com.baidu.swan.pms.c.e.bcN(), a2, gVar.bcv(), new com.baidu.swan.pms.c.b.b(gVar, cVar));
                }
            }
        }
    }

    public static synchronized void a(com.baidu.swan.pms.c.d.b bVar, g gVar) {
        synchronized (c.class) {
            if (gVar != null) {
                if (bVar == null) {
                    gVar.b(new com.baidu.swan.pms.model.a(2100, "request对象为空"));
                } else if (bVar.bdm() == null || bVar.bdm().isEmpty()) {
                    gVar.b(new com.baidu.swan.pms.model.a(2100, "pkg List为空"));
                } else {
                    HashMap<String, String> a2 = com.baidu.swan.pms.c.b.a(bVar);
                    if (gVar.bcu() != null) {
                        a2.putAll(gVar.bcu());
                    }
                    JSONObject b = com.baidu.swan.pms.c.b.b(bVar);
                    if (b == null) {
                        gVar.b(new com.baidu.swan.pms.model.a(2100, "构造请求body失败"));
                    } else {
                        if (gVar.bcw() != null) {
                            try {
                                for (Map.Entry<String, String> entry : gVar.bcw().entrySet()) {
                                    b.put(entry.getKey(), entry.getValue());
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        gVar.anL();
                        d.bcr().ays().a(com.baidu.swan.pms.c.e.bcP(), a2, gVar.bcv(), b, new com.baidu.swan.pms.c.b.a(gVar, bVar));
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
                } else if (TextUtils.isEmpty(fVar.bdu())) {
                    gVar.b(new com.baidu.swan.pms.model.a(2100, "分包名为空"));
                } else {
                    HashMap<String, String> a2 = com.baidu.swan.pms.c.b.a(fVar);
                    if (gVar.bcu() != null) {
                        a2.putAll(gVar.bcu());
                    }
                    gVar.anL();
                    d.bcr().ays().a(com.baidu.swan.pms.c.e.bcN(), a2, gVar.bcv(), new com.baidu.swan.pms.c.b.d(gVar, fVar));
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
                    com.baidu.swan.pms.node.c<JSONArray> auh = aVar == null ? null : aVar.auh();
                    g aug = aVar == null ? null : aVar.aug();
                    HashMap hashMap = new HashMap();
                    if (gVar.bcu() != null) {
                        hashMap.putAll(gVar.bcu());
                    }
                    gVar.anL();
                    d.bcr().ays().a(com.baidu.swan.pms.c.e.bcO(), hashMap, gVar.bcv(), a(auh, (com.baidu.swan.pms.node.c<JSONObject>) null), new com.baidu.swan.pms.c.b.e(gVar, hVar, gVar2, aug));
                }
            }
        }
    }

    public static synchronized void a(com.baidu.swan.pms.d.a.a aVar) {
        synchronized (c.class) {
            if (aVar != null) {
                g aug = aVar.aug();
                if (aug != null) {
                    com.baidu.swan.pms.c.d.g aui = aVar.aui();
                    if (aui == null) {
                        aug.b(new com.baidu.swan.pms.model.a(2100, "request对象为空"));
                    } else {
                        Map<String, String> bcu = aug.bcu();
                        Map<String, String> hashMap = aug.bcu() != null ? new HashMap<>(bcu) : bcu;
                        aug.anL();
                        d.bcr().ays().a(com.baidu.swan.pms.c.e.bcO(), hashMap, aug.bcv(), a(aVar.auh(), (com.baidu.swan.pms.node.c<JSONObject>) null), new com.baidu.swan.pms.c.b.e(aug, aui, null, aug));
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
                    if (gVar.bcu() != null) {
                        a2.putAll(gVar.bcu());
                    }
                    gVar.anL();
                    d.bcr().ays().a(com.baidu.swan.pms.c.e.bcQ(), a2, gVar.bcv(), new com.baidu.swan.pms.c.b.c(gVar, dVar));
                }
            }
        }
    }

    public static synchronized boolean xZ(String str) {
        boolean xZ;
        synchronized (c.class) {
            xZ = com.baidu.swan.pms.c.a.d.d.bcY().xZ(str);
        }
        return xZ;
    }

    public static synchronized boolean ya(String str) {
        boolean ya;
        synchronized (c.class) {
            ya = com.baidu.swan.pms.c.a.d.d.bcY().ya(str);
        }
        return ya;
    }
}
