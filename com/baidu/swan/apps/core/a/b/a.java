package com.baidu.swan.apps.core.a.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.pms.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: com.baidu.swan.apps.core.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0141a {
        void ca(int i);

        void zo();

        void zp();
    }

    public static void a(String str, InterfaceC0141a interfaceC0141a, final String str2) {
        if (TextUtils.isEmpty(str) && interfaceC0141a != null) {
            interfaceC0141a.zo();
        } else if (com.baidu.swan.apps.core.pms.a.cp(0)) {
            com.baidu.swan.pms.b.d.b bVar = new com.baidu.swan.pms.b.d.b(str, 0);
            bVar.kE("1");
            c.a(bVar, new com.baidu.swan.apps.core.pms.a.a(str, interfaceC0141a) { // from class: com.baidu.swan.apps.core.a.b.a.1
                @Override // com.baidu.swan.apps.core.pms.d, com.baidu.swan.pms.a.f
                public void zn() {
                    this.aqx = str2;
                }

                @Override // com.baidu.swan.pms.a.f, com.baidu.swan.pms.a.b
                public void X(String str3, String str4) {
                    super.X(str3, str4);
                    if (!TextUtils.isEmpty(str4) && TextUtils.equals(str3, "770") && this.aqi != null) {
                        this.aqi.add(new UbcFlowEvent(str4));
                    }
                }
            });
        } else {
            Context appContext = AppRuntime.getAppContext();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new b(appContext, str, interfaceC0141a, str2));
            com.baidu.b.a.a.init(appContext, ProcessUtils.isMainProcess());
            com.baidu.b.a.c.a.a(appContext, com.baidu.swan.apps.u.a.EL().Fj());
            com.baidu.b.a.c.a.b((List<Object>) arrayList, true);
        }
    }
}
