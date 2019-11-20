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
    public interface InterfaceC0173a {
        void Ek();

        void El();

        void cW(int i);
    }

    public static void a(String str, InterfaceC0173a interfaceC0173a, final String str2) {
        if (TextUtils.isEmpty(str) && interfaceC0173a != null) {
            interfaceC0173a.Ek();
        } else if (com.baidu.swan.apps.core.pms.a.dl(0)) {
            com.baidu.swan.pms.b.d.b bVar = new com.baidu.swan.pms.b.d.b(str, 0);
            bVar.lg("1");
            c.a(bVar, new com.baidu.swan.apps.core.pms.a.a(str, interfaceC0173a) { // from class: com.baidu.swan.apps.core.a.b.a.1
                @Override // com.baidu.swan.apps.core.pms.d, com.baidu.swan.pms.a.f
                public void Ej() {
                    this.aJv = str2;
                }

                @Override // com.baidu.swan.pms.a.f, com.baidu.swan.pms.a.b
                public void af(String str3, String str4) {
                    super.af(str3, str4);
                    if (!TextUtils.isEmpty(str4) && TextUtils.equals(str3, "770") && this.aJg != null) {
                        this.aJg.add(new UbcFlowEvent(str4));
                    }
                }
            });
        } else {
            Context appContext = AppRuntime.getAppContext();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new b(appContext, str, interfaceC0173a, str2));
            com.baidu.a.a.a.init(appContext, ProcessUtils.isMainProcess());
            com.baidu.a.a.c.a.a(appContext, com.baidu.swan.apps.u.a.JG().Ke());
            com.baidu.a.a.c.a.b((List<Object>) arrayList, true);
        }
    }
}
