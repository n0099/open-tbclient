package com.baidu.swan.pms;

import android.text.TextUtils;
import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.c.d.f;
import com.baidu.swan.pms.c.d.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes19.dex */
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
                    if (gVar.aKP() != null) {
                        a.putAll(gVar.aKP());
                    }
                    gVar.Zu();
                    d.aKM().aix().a(com.baidu.swan.pms.c.e.aLk(), a, gVar.aKQ(), new com.baidu.swan.pms.c.b.b(gVar, cVar));
                }
            }
        }
    }

    public static synchronized void a(com.baidu.swan.pms.c.d.b bVar, g gVar) {
        synchronized (c.class) {
            if (gVar != null) {
                if (bVar == null) {
                    gVar.b(new com.baidu.swan.pms.model.a(2100, "request对象为空"));
                } else if (bVar.aLK() == null || bVar.aLK().isEmpty()) {
                    gVar.b(new com.baidu.swan.pms.model.a(2100, "pkg List为空"));
                } else {
                    HashMap<String, String> a = com.baidu.swan.pms.c.b.a(bVar);
                    if (gVar.aKP() != null) {
                        a.putAll(gVar.aKP());
                    }
                    JSONObject b = com.baidu.swan.pms.c.b.b(bVar);
                    if (b == null) {
                        gVar.b(new com.baidu.swan.pms.model.a(2100, "构造请求body失败"));
                    } else {
                        if (gVar.aKR() != null) {
                            try {
                                for (Map.Entry<String, String> entry : gVar.aKR().entrySet()) {
                                    b.put(entry.getKey(), entry.getValue());
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        gVar.Zu();
                        d.aKM().aix().a(com.baidu.swan.pms.c.e.aLm(), a, gVar.aKQ(), b, new com.baidu.swan.pms.c.b.a(gVar, bVar));
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
                } else if (TextUtils.isEmpty(fVar.aLS())) {
                    gVar.b(new com.baidu.swan.pms.model.a(2100, "分包名为空"));
                } else {
                    HashMap<String, String> a = com.baidu.swan.pms.c.b.a(fVar);
                    if (gVar.aKP() != null) {
                        a.putAll(gVar.aKP());
                    }
                    gVar.Zu();
                    d.aKM().aix().a(com.baidu.swan.pms.c.e.aLk(), a, gVar.aKQ(), new com.baidu.swan.pms.c.b.d(gVar, fVar));
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
            if (gVar != null) {
                if (hVar == null) {
                    gVar.b(new com.baidu.swan.pms.model.a(2100, "request对象为空"));
                } else {
                    HashMap hashMap = new HashMap();
                    if (gVar.aKP() != null) {
                        hashMap.putAll(gVar.aKP());
                    }
                    gVar.Zu();
                    d.aKM().aix().a(com.baidu.swan.pms.c.e.aLl(), hashMap, gVar.aKQ(), aKL(), new com.baidu.swan.pms.c.b.e(gVar, hVar, gVar2));
                }
            }
        }
    }

    private static JSONObject aKL() {
        return com.baidu.swan.pms.node.e.aLX();
    }

    public static synchronized void a(com.baidu.swan.pms.c.d.d dVar, g gVar) {
        synchronized (c.class) {
            if (gVar != null) {
                if (dVar == null) {
                    gVar.b(new com.baidu.swan.pms.model.a(2100, "request对象为空"));
                } else {
                    HashMap<String, String> a = com.baidu.swan.pms.c.b.a(dVar);
                    if (gVar.aKP() != null) {
                        a.putAll(gVar.aKP());
                    }
                    gVar.Zu();
                    d.aKM().aix().a(com.baidu.swan.pms.c.e.aLn(), a, gVar.aKQ(), new com.baidu.swan.pms.c.b.c(gVar, dVar));
                }
            }
        }
    }

    public static synchronized boolean uo(String str) {
        boolean uo;
        synchronized (c.class) {
            uo = com.baidu.swan.pms.c.a.d.d.aLv().uo(str);
        }
        return uo;
    }

    public static synchronized boolean up(String str) {
        boolean up;
        synchronized (c.class) {
            up = com.baidu.swan.pms.c.a.d.d.aLv().up(str);
        }
        return up;
    }
}
