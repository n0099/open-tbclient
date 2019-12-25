package com.baidu.swan.pms;

import android.text.TextUtils;
import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.c.e;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
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
                    if (gVar.aqJ() != null) {
                        a.putAll(gVar.aqJ());
                    }
                    gVar.Ko();
                    com.baidu.swan.pms.c.a.a(e.arc(), a, gVar.aqK(), new com.baidu.swan.pms.c.b.b(gVar, cVar));
                }
            }
        }
    }

    public static synchronized void a(com.baidu.swan.pms.c.d.b bVar, g gVar) {
        synchronized (c.class) {
            if (gVar != null) {
                if (bVar == null) {
                    gVar.a(new com.baidu.swan.pms.model.a(PushConstants.BROADCAST_MESSAGE_ARRIVE, "request对象为空"));
                } else if (bVar.arA() == null || bVar.arA().isEmpty()) {
                    gVar.a(new com.baidu.swan.pms.model.a(PushConstants.BROADCAST_MESSAGE_ARRIVE, "pkg List为空"));
                } else {
                    HashMap<String, String> a = com.baidu.swan.pms.c.b.a(bVar);
                    if (gVar.aqJ() != null) {
                        a.putAll(gVar.aqJ());
                    }
                    JSONObject b = com.baidu.swan.pms.c.b.b(bVar);
                    if (b == null) {
                        gVar.a(new com.baidu.swan.pms.model.a(PushConstants.BROADCAST_MESSAGE_ARRIVE, "构造请求body失败"));
                    } else {
                        if (gVar.aqL() != null) {
                            try {
                                for (Map.Entry<String, String> entry : gVar.aqL().entrySet()) {
                                    b.put(entry.getKey(), entry.getValue());
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        gVar.Ko();
                        com.baidu.swan.pms.c.a.a(e.are(), a, gVar.aqK(), b, new com.baidu.swan.pms.c.b.a(gVar, bVar));
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
                } else if (TextUtils.isEmpty(eVar.arI())) {
                    gVar.a(new com.baidu.swan.pms.model.a(PushConstants.BROADCAST_MESSAGE_ARRIVE, "分包名为空"));
                } else {
                    HashMap<String, String> a = com.baidu.swan.pms.c.b.a(eVar);
                    if (gVar.aqJ() != null) {
                        a.putAll(gVar.aqJ());
                    }
                    gVar.Ko();
                    com.baidu.swan.pms.c.a.a(e.arc(), a, gVar.aqK(), new com.baidu.swan.pms.c.b.d(gVar, eVar));
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
                    if (gVar2.aqJ() != null) {
                        a.putAll(gVar2.aqJ());
                    }
                    gVar2.Ko();
                    com.baidu.swan.pms.c.a.a(e.ard(), a, gVar2.aqK(), new com.baidu.swan.pms.c.b.e(gVar2, gVar));
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
                    if (gVar.aqJ() != null) {
                        a.putAll(gVar.aqJ());
                    }
                    gVar.Ko();
                    com.baidu.swan.pms.c.a.a(e.arf(), a, gVar.aqK(), new com.baidu.swan.pms.c.b.c(gVar, dVar));
                }
            }
        }
    }
}
