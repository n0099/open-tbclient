package com.baidu.swan.pms;

import android.text.TextUtils;
import com.baidu.swan.pms.a.f;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class c {
    public static synchronized void a(com.baidu.swan.pms.b.d.b bVar, f fVar) {
        synchronized (c.class) {
            if (fVar != null) {
                if (bVar == null) {
                    fVar.a(new com.baidu.swan.pms.model.a(PushConstants.BROADCAST_MESSAGE_ARRIVE, "request对象为空"));
                } else if (TextUtils.isEmpty(bVar.getBundleId())) {
                    fVar.a(new com.baidu.swan.pms.model.a(PushConstants.BROADCAST_MESSAGE_ARRIVE, "bundleId为空"));
                } else {
                    HashMap<String, String> a = com.baidu.swan.pms.b.b.a(bVar);
                    if (fVar.Vj() != null) {
                        a.putAll(fVar.Vj());
                    }
                    fVar.yD();
                    com.baidu.swan.pms.b.a.a(com.baidu.swan.pms.b.e.Vy(), a, fVar.Vk(), new com.baidu.swan.pms.b.b.a(fVar, bVar));
                }
            }
        }
    }

    public static synchronized void a(com.baidu.swan.pms.b.d.d dVar, f fVar) {
        synchronized (c.class) {
            if (fVar != null) {
                if (dVar == null) {
                    fVar.a(new com.baidu.swan.pms.model.a(PushConstants.BROADCAST_MESSAGE_ARRIVE, "request对象为空"));
                } else if (TextUtils.isEmpty(dVar.getBundleId())) {
                    fVar.a(new com.baidu.swan.pms.model.a(PushConstants.BROADCAST_MESSAGE_ARRIVE, "bundleId为空"));
                } else if (TextUtils.isEmpty(dVar.VX())) {
                    fVar.a(new com.baidu.swan.pms.model.a(PushConstants.BROADCAST_MESSAGE_ARRIVE, "分包名为空"));
                } else {
                    HashMap<String, String> a = com.baidu.swan.pms.b.b.a(dVar);
                    if (fVar.Vj() != null) {
                        a.putAll(fVar.Vj());
                    }
                    fVar.yD();
                    com.baidu.swan.pms.b.a.a(com.baidu.swan.pms.b.e.Vy(), a, fVar.Vk(), new com.baidu.swan.pms.b.b.c(fVar, dVar));
                }
            }
        }
    }

    public static synchronized void a(com.baidu.swan.pms.b.d.f fVar, f fVar2) {
        synchronized (c.class) {
            if (fVar2 != null) {
                if (fVar == null) {
                    fVar2.a(new com.baidu.swan.pms.model.a(PushConstants.BROADCAST_MESSAGE_ARRIVE, "request对象为空"));
                } else {
                    HashMap<String, String> a = com.baidu.swan.pms.b.b.a(fVar);
                    if (fVar2.Vj() != null) {
                        a.putAll(fVar2.Vj());
                    }
                    fVar2.yD();
                    com.baidu.swan.pms.b.a.a(com.baidu.swan.pms.b.e.Vz(), a, fVar2.Vk(), new com.baidu.swan.pms.b.b.d(fVar2, fVar));
                }
            }
        }
    }

    public static synchronized void a(com.baidu.swan.pms.b.d.a aVar, f fVar) {
        synchronized (c.class) {
            if (fVar != null) {
                if (aVar == null) {
                    fVar.a(new com.baidu.swan.pms.model.a(PushConstants.BROADCAST_MESSAGE_ARRIVE, "request对象为空"));
                } else {
                    HashMap<String, String> a = com.baidu.swan.pms.b.b.a(aVar);
                    if (fVar.Vj() != null) {
                        a.putAll(fVar.Vj());
                    }
                    fVar.yD();
                    com.baidu.swan.pms.b.a.a(com.baidu.swan.pms.b.e.VA(), a, fVar.Vk(), new com.baidu.swan.pms.b.b.b(fVar, aVar));
                }
            }
        }
    }
}
