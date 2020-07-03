package com.baidu.swan.pms;

import android.text.TextUtils;
import com.baidu.swan.pms.a.g;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    public static synchronized void a(com.baidu.swan.pms.c.d.c cVar, g gVar) {
        synchronized (c.class) {
            if (gVar != null) {
                if (cVar == null) {
                    gVar.b(new com.baidu.swan.pms.model.a(PushConstants.BROADCAST_MESSAGE_ARRIVE, "request对象为空"));
                } else if (TextUtils.isEmpty(cVar.getBundleId())) {
                    gVar.b(new com.baidu.swan.pms.model.a(PushConstants.BROADCAST_MESSAGE_ARRIVE, "bundleId为空"));
                } else {
                    HashMap<String, String> a = com.baidu.swan.pms.c.b.a(cVar);
                    if (gVar.aGY() != null) {
                        a.putAll(gVar.aGY());
                    }
                    gVar.YC();
                    d.aGV().ahi().a(com.baidu.swan.pms.c.e.aHt(), a, gVar.aGZ(), new com.baidu.swan.pms.c.b.b(gVar, cVar));
                }
            }
        }
    }

    public static synchronized void a(com.baidu.swan.pms.c.d.b bVar, g gVar) {
        synchronized (c.class) {
            if (gVar != null) {
                if (bVar == null) {
                    gVar.b(new com.baidu.swan.pms.model.a(PushConstants.BROADCAST_MESSAGE_ARRIVE, "request对象为空"));
                } else if (bVar.aHT() == null || bVar.aHT().isEmpty()) {
                    gVar.b(new com.baidu.swan.pms.model.a(PushConstants.BROADCAST_MESSAGE_ARRIVE, "pkg List为空"));
                } else {
                    HashMap<String, String> a = com.baidu.swan.pms.c.b.a(bVar);
                    if (gVar.aGY() != null) {
                        a.putAll(gVar.aGY());
                    }
                    JSONObject b = com.baidu.swan.pms.c.b.b(bVar);
                    if (b == null) {
                        gVar.b(new com.baidu.swan.pms.model.a(PushConstants.BROADCAST_MESSAGE_ARRIVE, "构造请求body失败"));
                    } else {
                        if (gVar.aHa() != null) {
                            try {
                                for (Map.Entry<String, String> entry : gVar.aHa().entrySet()) {
                                    b.put(entry.getKey(), entry.getValue());
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        gVar.YC();
                        d.aGV().ahi().a(com.baidu.swan.pms.c.e.aHv(), a, gVar.aGZ(), b, new com.baidu.swan.pms.c.b.a(gVar, bVar));
                    }
                }
            }
        }
    }

    public static synchronized void a(com.baidu.swan.pms.c.d.e eVar, g gVar) {
        synchronized (c.class) {
            if (gVar != null) {
                if (eVar == null) {
                    gVar.b(new com.baidu.swan.pms.model.a(PushConstants.BROADCAST_MESSAGE_ARRIVE, "request对象为空"));
                } else if (TextUtils.isEmpty(eVar.getBundleId())) {
                    gVar.b(new com.baidu.swan.pms.model.a(PushConstants.BROADCAST_MESSAGE_ARRIVE, "bundleId为空"));
                } else if (TextUtils.isEmpty(eVar.aIb())) {
                    gVar.b(new com.baidu.swan.pms.model.a(PushConstants.BROADCAST_MESSAGE_ARRIVE, "分包名为空"));
                } else {
                    HashMap<String, String> a = com.baidu.swan.pms.c.b.a(eVar);
                    if (gVar.aGY() != null) {
                        a.putAll(gVar.aGY());
                    }
                    gVar.YC();
                    d.aGV().ahi().a(com.baidu.swan.pms.c.e.aHt(), a, gVar.aGZ(), new com.baidu.swan.pms.c.b.d(gVar, eVar));
                }
            }
        }
    }

    public static synchronized void a(com.baidu.swan.pms.c.d.g gVar, g gVar2) {
        synchronized (c.class) {
            a(gVar, gVar2, null);
        }
    }

    public static synchronized void a(com.baidu.swan.pms.c.d.g gVar, g gVar2, g gVar3) {
        synchronized (c.class) {
            if (gVar2 != null) {
                if (gVar == null) {
                    gVar2.b(new com.baidu.swan.pms.model.a(PushConstants.BROADCAST_MESSAGE_ARRIVE, "request对象为空"));
                } else {
                    HashMap hashMap = new HashMap();
                    if (gVar2.aGY() != null) {
                        hashMap.putAll(gVar2.aGY());
                    }
                    gVar2.YC();
                    d.aGV().ahi().a(com.baidu.swan.pms.c.e.aHu(), hashMap, gVar2.aGZ(), aGU(), new com.baidu.swan.pms.c.b.e(gVar2, gVar, gVar3));
                }
            }
        }
    }

    private static JSONObject aGU() {
        return com.baidu.swan.pms.node.e.aIf();
    }

    public static synchronized void a(com.baidu.swan.pms.c.d.d dVar, g gVar) {
        synchronized (c.class) {
            if (gVar != null) {
                if (dVar == null) {
                    gVar.b(new com.baidu.swan.pms.model.a(PushConstants.BROADCAST_MESSAGE_ARRIVE, "request对象为空"));
                } else {
                    HashMap<String, String> a = com.baidu.swan.pms.c.b.a(dVar);
                    if (gVar.aGY() != null) {
                        a.putAll(gVar.aGY());
                    }
                    gVar.YC();
                    d.aGV().ahi().a(com.baidu.swan.pms.c.e.aHw(), a, gVar.aGZ(), new com.baidu.swan.pms.c.b.c(gVar, dVar));
                }
            }
        }
    }

    public static synchronized boolean tl(String str) {
        boolean tl;
        synchronized (c.class) {
            tl = com.baidu.swan.pms.c.a.d.d.aHE().tl(str);
        }
        return tl;
    }

    public static synchronized boolean tm(String str) {
        boolean tm;
        synchronized (c.class) {
            tm = com.baidu.swan.pms.c.a.d.d.aHE().tm(str);
        }
        return tm;
    }
}
