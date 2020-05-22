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
                    if (gVar.aFS() != null) {
                        a.putAll(gVar.aFS());
                    }
                    gVar.Xw();
                    d.aFP().agc().a(com.baidu.swan.pms.c.e.aGn(), a, gVar.aFT(), new com.baidu.swan.pms.c.b.b(gVar, cVar));
                }
            }
        }
    }

    public static synchronized void a(com.baidu.swan.pms.c.d.b bVar, g gVar) {
        synchronized (c.class) {
            if (gVar != null) {
                if (bVar == null) {
                    gVar.b(new com.baidu.swan.pms.model.a(PushConstants.BROADCAST_MESSAGE_ARRIVE, "request对象为空"));
                } else if (bVar.aGN() == null || bVar.aGN().isEmpty()) {
                    gVar.b(new com.baidu.swan.pms.model.a(PushConstants.BROADCAST_MESSAGE_ARRIVE, "pkg List为空"));
                } else {
                    HashMap<String, String> a = com.baidu.swan.pms.c.b.a(bVar);
                    if (gVar.aFS() != null) {
                        a.putAll(gVar.aFS());
                    }
                    JSONObject b = com.baidu.swan.pms.c.b.b(bVar);
                    if (b == null) {
                        gVar.b(new com.baidu.swan.pms.model.a(PushConstants.BROADCAST_MESSAGE_ARRIVE, "构造请求body失败"));
                    } else {
                        if (gVar.aFU() != null) {
                            try {
                                for (Map.Entry<String, String> entry : gVar.aFU().entrySet()) {
                                    b.put(entry.getKey(), entry.getValue());
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        gVar.Xw();
                        d.aFP().agc().a(com.baidu.swan.pms.c.e.aGp(), a, gVar.aFT(), b, new com.baidu.swan.pms.c.b.a(gVar, bVar));
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
                } else if (TextUtils.isEmpty(eVar.aGV())) {
                    gVar.b(new com.baidu.swan.pms.model.a(PushConstants.BROADCAST_MESSAGE_ARRIVE, "分包名为空"));
                } else {
                    HashMap<String, String> a = com.baidu.swan.pms.c.b.a(eVar);
                    if (gVar.aFS() != null) {
                        a.putAll(gVar.aFS());
                    }
                    gVar.Xw();
                    d.aFP().agc().a(com.baidu.swan.pms.c.e.aGn(), a, gVar.aFT(), new com.baidu.swan.pms.c.b.d(gVar, eVar));
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
                    if (gVar2.aFS() != null) {
                        hashMap.putAll(gVar2.aFS());
                    }
                    gVar2.Xw();
                    d.aFP().agc().a(com.baidu.swan.pms.c.e.aGo(), hashMap, gVar2.aFT(), aFO(), new com.baidu.swan.pms.c.b.e(gVar2, gVar, gVar3));
                }
            }
        }
    }

    private static JSONObject aFO() {
        return com.baidu.swan.pms.node.e.aGZ();
    }

    public static synchronized void a(com.baidu.swan.pms.c.d.d dVar, g gVar) {
        synchronized (c.class) {
            if (gVar != null) {
                if (dVar == null) {
                    gVar.b(new com.baidu.swan.pms.model.a(PushConstants.BROADCAST_MESSAGE_ARRIVE, "request对象为空"));
                } else {
                    HashMap<String, String> a = com.baidu.swan.pms.c.b.a(dVar);
                    if (gVar.aFS() != null) {
                        a.putAll(gVar.aFS());
                    }
                    gVar.Xw();
                    d.aFP().agc().a(com.baidu.swan.pms.c.e.aGq(), a, gVar.aFT(), new com.baidu.swan.pms.c.b.c(gVar, dVar));
                }
            }
        }
    }

    public static synchronized boolean td(String str) {
        boolean td;
        synchronized (c.class) {
            td = com.baidu.swan.pms.c.a.d.d.aGy().td(str);
        }
        return td;
    }

    public static synchronized boolean te(String str) {
        boolean te;
        synchronized (c.class) {
            te = com.baidu.swan.pms.c.a.d.d.aGy().te(str);
        }
        return te;
    }
}
