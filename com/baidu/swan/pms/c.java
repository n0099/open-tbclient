package com.baidu.swan.pms;

import android.text.TextUtils;
import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.c.e;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
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
                    if (gVar.arc() != null) {
                        a.putAll(gVar.arc());
                    }
                    gVar.KK();
                    com.baidu.swan.pms.c.a.a(e.arv(), a, gVar.ard(), new com.baidu.swan.pms.c.b.b(gVar, cVar));
                }
            }
        }
    }

    public static synchronized void a(com.baidu.swan.pms.c.d.b bVar, g gVar) {
        synchronized (c.class) {
            if (gVar != null) {
                if (bVar == null) {
                    gVar.a(new com.baidu.swan.pms.model.a(PushConstants.BROADCAST_MESSAGE_ARRIVE, "request对象为空"));
                } else if (bVar.arT() == null || bVar.arT().isEmpty()) {
                    gVar.a(new com.baidu.swan.pms.model.a(PushConstants.BROADCAST_MESSAGE_ARRIVE, "pkg List为空"));
                } else {
                    HashMap<String, String> a = com.baidu.swan.pms.c.b.a(bVar);
                    if (gVar.arc() != null) {
                        a.putAll(gVar.arc());
                    }
                    JSONObject b = com.baidu.swan.pms.c.b.b(bVar);
                    if (b == null) {
                        gVar.a(new com.baidu.swan.pms.model.a(PushConstants.BROADCAST_MESSAGE_ARRIVE, "构造请求body失败"));
                    } else {
                        if (gVar.are() != null) {
                            try {
                                for (Map.Entry<String, String> entry : gVar.are().entrySet()) {
                                    b.put(entry.getKey(), entry.getValue());
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        gVar.KK();
                        com.baidu.swan.pms.c.a.a(e.arx(), a, gVar.ard(), b, new com.baidu.swan.pms.c.b.a(gVar, bVar));
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
                } else if (TextUtils.isEmpty(eVar.asb())) {
                    gVar.a(new com.baidu.swan.pms.model.a(PushConstants.BROADCAST_MESSAGE_ARRIVE, "分包名为空"));
                } else {
                    HashMap<String, String> a = com.baidu.swan.pms.c.b.a(eVar);
                    if (gVar.arc() != null) {
                        a.putAll(gVar.arc());
                    }
                    gVar.KK();
                    com.baidu.swan.pms.c.a.a(e.arv(), a, gVar.ard(), new com.baidu.swan.pms.c.b.d(gVar, eVar));
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
                    if (gVar2.arc() != null) {
                        a.putAll(gVar2.arc());
                    }
                    gVar2.KK();
                    com.baidu.swan.pms.c.a.a(e.arw(), a, gVar2.ard(), new com.baidu.swan.pms.c.b.e(gVar2, gVar));
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
                    if (gVar.arc() != null) {
                        a.putAll(gVar.arc());
                    }
                    gVar.KK();
                    com.baidu.swan.pms.c.a.a(e.ary(), a, gVar.ard(), new com.baidu.swan.pms.c.b.c(gVar, dVar));
                }
            }
        }
    }
}
