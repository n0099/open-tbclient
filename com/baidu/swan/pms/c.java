package com.baidu.swan.pms;

import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
/* loaded from: classes2.dex */
public class c {
    public static synchronized void a(com.baidu.swan.pms.b.d.a aVar, com.baidu.swan.pms.a.e eVar) {
        synchronized (c.class) {
            if (eVar != null) {
                if (aVar == null) {
                    eVar.a(new com.baidu.swan.pms.model.b(PushConstants.BROADCAST_MESSAGE_ARRIVE, "request对象为空"));
                } else if (TextUtils.isEmpty(aVar.getBundleId())) {
                    eVar.a(new com.baidu.swan.pms.model.b(PushConstants.BROADCAST_MESSAGE_ARRIVE, "bundleId为空"));
                } else {
                    String h = com.baidu.swan.pms.b.e.h(com.baidu.swan.pms.b.e.RN(), com.baidu.swan.pms.b.b.a(aVar));
                    eVar.xM();
                    com.baidu.swan.pms.b.a.a(h, eVar.Ry(), eVar.Rz(), new com.baidu.swan.pms.b.b.b(eVar, aVar));
                }
            }
        }
    }

    public static synchronized void a(com.baidu.swan.pms.b.d.b bVar, com.baidu.swan.pms.a.e eVar) {
        synchronized (c.class) {
            if (eVar != null) {
                if (bVar == null) {
                    eVar.a(new com.baidu.swan.pms.model.b(PushConstants.BROADCAST_MESSAGE_ARRIVE, "request对象为空"));
                } else if (TextUtils.isEmpty(bVar.getBundleId())) {
                    eVar.a(new com.baidu.swan.pms.model.b(PushConstants.BROADCAST_MESSAGE_ARRIVE, "bundleId为空"));
                } else if (TextUtils.isEmpty(bVar.Sl())) {
                    eVar.a(new com.baidu.swan.pms.model.b(PushConstants.BROADCAST_MESSAGE_ARRIVE, "分包名为空"));
                } else {
                    String h = com.baidu.swan.pms.b.e.h(com.baidu.swan.pms.b.e.RN(), com.baidu.swan.pms.b.b.a(bVar));
                    eVar.xM();
                    com.baidu.swan.pms.b.a.a(h, eVar.Ry(), eVar.Rz(), new com.baidu.swan.pms.b.b.c(eVar, bVar));
                }
            }
        }
    }

    public static synchronized void a(com.baidu.swan.pms.b.d.d dVar, com.baidu.swan.pms.a.e eVar) {
        synchronized (c.class) {
            if (eVar != null) {
                if (dVar == null) {
                    eVar.a(new com.baidu.swan.pms.model.b(PushConstants.BROADCAST_MESSAGE_ARRIVE, "request对象为空"));
                } else {
                    String h = com.baidu.swan.pms.b.e.h(com.baidu.swan.pms.b.e.RO(), com.baidu.swan.pms.b.b.a(dVar));
                    eVar.xM();
                    com.baidu.swan.pms.b.a.a(h, eVar.Ry(), eVar.Rz(), new com.baidu.swan.pms.b.b.a(eVar, dVar));
                }
            }
        }
    }
}
