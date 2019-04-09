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
    public interface InterfaceC0127a {
        void bZ(int i);

        void xM();

        void xN();
    }

    public static void a(String str, InterfaceC0127a interfaceC0127a, final String str2) {
        if (TextUtils.isEmpty(str) && interfaceC0127a != null) {
            interfaceC0127a.xM();
        } else if (com.baidu.swan.apps.core.pms.a.vp()) {
            com.baidu.swan.pms.b.d.a aVar = new com.baidu.swan.pms.b.d.a(str, 0);
            aVar.jv("1");
            c.a(aVar, new com.baidu.swan.apps.core.pms.a.a(str, interfaceC0127a) { // from class: com.baidu.swan.apps.core.a.b.a.1
                @Override // com.baidu.swan.apps.core.pms.d, com.baidu.swan.pms.a.e
                public void xL() {
                    this.apj = str2;
                }

                @Override // com.baidu.swan.pms.a.e, com.baidu.swan.pms.a.b
                public void ac(String str3, String str4) {
                    super.ac(str3, str4);
                    if (!TextUtils.isEmpty(str4) && TextUtils.equals(str3, "770") && this.aoU != null) {
                        this.aoU.add(new UbcFlowEvent(str4));
                    }
                }
            });
        } else {
            Context appContext = AppRuntime.getAppContext();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new b(appContext, str, interfaceC0127a, str2));
            com.baidu.b.a.a.init(appContext, ProcessUtils.isMainProcess());
            com.baidu.b.a.c.a.a(appContext, com.baidu.swan.apps.u.a.CT().Dr());
            com.baidu.b.a.c.a.c(arrayList, true);
        }
    }
}
