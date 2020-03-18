package com.baidu.swan.pms;

import android.text.TextUtils;
import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.c.e;
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
                    gVar.a(new com.baidu.swan.pms.model.a(PushConstants.BROADCAST_MESSAGE_ARRIVE, "request对象为空"));
                } else if (TextUtils.isEmpty(cVar.getBundleId())) {
                    gVar.a(new com.baidu.swan.pms.model.a(PushConstants.BROADCAST_MESSAGE_ARRIVE, "bundleId为空"));
                } else {
                    HashMap<String, String> a = com.baidu.swan.pms.c.b.a(cVar);
                    if (gVar.atv() != null) {
                        a.putAll(gVar.atv());
                    }
                    gVar.Ne();
                    com.baidu.swan.pms.c.a.a(e.atO(), a, gVar.atw(), new com.baidu.swan.pms.c.b.b(gVar, cVar));
                }
            }
        }
    }

    public static synchronized void a(com.baidu.swan.pms.c.d.b bVar, g gVar) {
        synchronized (c.class) {
            if (gVar != null) {
                if (bVar == null) {
                    gVar.a(new com.baidu.swan.pms.model.a(PushConstants.BROADCAST_MESSAGE_ARRIVE, "request对象为空"));
                } else if (bVar.aum() == null || bVar.aum().isEmpty()) {
                    gVar.a(new com.baidu.swan.pms.model.a(PushConstants.BROADCAST_MESSAGE_ARRIVE, "pkg List为空"));
                } else {
                    HashMap<String, String> a = com.baidu.swan.pms.c.b.a(bVar);
                    if (gVar.atv() != null) {
                        a.putAll(gVar.atv());
                    }
                    JSONObject b = com.baidu.swan.pms.c.b.b(bVar);
                    if (b == null) {
                        gVar.a(new com.baidu.swan.pms.model.a(PushConstants.BROADCAST_MESSAGE_ARRIVE, "构造请求body失败"));
                    } else {
                        if (gVar.atx() != null) {
                            try {
                                for (Map.Entry<String, String> entry : gVar.atx().entrySet()) {
                                    b.put(entry.getKey(), entry.getValue());
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        gVar.Ne();
                        com.baidu.swan.pms.c.a.a(e.atQ(), a, gVar.atw(), b, new com.baidu.swan.pms.c.b.a(gVar, bVar));
                    }
                }
            }
        }
    }

    public static synchronized void a(com.baidu.swan.pms.c.d.e eVar, g gVar) {
        synchronized (c.class) {
            if (gVar != null) {
                if (eVar == null) {
                    gVar.a(new com.baidu.swan.pms.model.a(PushConstants.BROADCAST_MESSAGE_ARRIVE, "request对象为空"));
                } else if (TextUtils.isEmpty(eVar.getBundleId())) {
                    gVar.a(new com.baidu.swan.pms.model.a(PushConstants.BROADCAST_MESSAGE_ARRIVE, "bundleId为空"));
                } else if (TextUtils.isEmpty(eVar.auu())) {
                    gVar.a(new com.baidu.swan.pms.model.a(PushConstants.BROADCAST_MESSAGE_ARRIVE, "分包名为空"));
                } else {
                    HashMap<String, String> a = com.baidu.swan.pms.c.b.a(eVar);
                    if (gVar.atv() != null) {
                        a.putAll(gVar.atv());
                    }
                    gVar.Ne();
                    com.baidu.swan.pms.c.a.a(e.atO(), a, gVar.atw(), new com.baidu.swan.pms.c.b.d(gVar, eVar));
                }
            }
        }
    }

    public static synchronized void a(com.baidu.swan.pms.c.d.g gVar, g gVar2) {
        synchronized (c.class) {
            if (gVar2 != null) {
                if (gVar == null) {
                    gVar2.a(new com.baidu.swan.pms.model.a(PushConstants.BROADCAST_MESSAGE_ARRIVE, "request对象为空"));
                } else {
                    HashMap<String, String> a = com.baidu.swan.pms.c.b.a(gVar);
                    if (gVar2.atv() != null) {
                        a.putAll(gVar2.atv());
                    }
                    gVar2.Ne();
                    com.baidu.swan.pms.c.a.a(e.atP(), a, gVar2.atw(), new com.baidu.swan.pms.c.b.e(gVar2, gVar));
                }
            }
        }
    }

    public static synchronized void a(com.baidu.swan.pms.c.d.d dVar, g gVar) {
        synchronized (c.class) {
            if (gVar != null) {
                if (dVar == null) {
                    gVar.a(new com.baidu.swan.pms.model.a(PushConstants.BROADCAST_MESSAGE_ARRIVE, "request对象为空"));
                } else {
                    HashMap<String, String> a = com.baidu.swan.pms.c.b.a(dVar);
                    if (gVar.atv() != null) {
                        a.putAll(gVar.atv());
                    }
                    gVar.Ne();
                    com.baidu.swan.pms.c.a.a(e.atR(), a, gVar.atw(), new com.baidu.swan.pms.c.b.c(gVar, dVar));
                }
            }
        }
    }
}
