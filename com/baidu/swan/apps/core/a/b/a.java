package com.baidu.swan.apps.core.a.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.pms.c;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: com.baidu.swan.apps.core.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0130a {
        void bZ(int i);

        void yE();

        void yF();
    }

    public static void a(String str, InterfaceC0130a interfaceC0130a, final String str2) {
        if (TextUtils.isEmpty(str) && interfaceC0130a != null) {
            interfaceC0130a.yE();
        } else if (com.baidu.swan.apps.core.pms.a.co(0)) {
            com.baidu.swan.pms.b.d.b bVar = new com.baidu.swan.pms.b.d.b(str, 0);
            bVar.kv("1");
            c.a(bVar, new com.baidu.swan.apps.core.pms.a.a(str, interfaceC0130a) { // from class: com.baidu.swan.apps.core.a.b.a.1
                @Override // com.baidu.swan.apps.core.pms.d, com.baidu.swan.pms.a.f
                public void yD() {
                    this.apw = str2;
                }

                @Override // com.baidu.swan.pms.a.f, com.baidu.swan.pms.a.b
                public void X(String str3, String str4) {
                    super.X(str3, str4);
                    if (!TextUtils.isEmpty(str4) && TextUtils.equals(str3, "770") && this.apg != null) {
                        this.apg.add(new UbcFlowEvent(str4));
                    }
                }
            });
        } else {
            Context appContext = AppRuntime.getAppContext();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new b(appContext, str, interfaceC0130a, str2));
            com.baidu.b.a.a.init(appContext, ProcessUtils.isMainProcess());
            com.baidu.b.a.c.a.a(appContext, com.baidu.swan.apps.u.a.DY().Ew());
            com.baidu.b.a.c.a.b(arrayList, true);
        }
    }
}
