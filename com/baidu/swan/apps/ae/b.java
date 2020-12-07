package com.baidu.swan.apps.ae;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.ae.c;
import kotlin.e;
import kotlin.jvm.internal.p;
@e
/* loaded from: classes25.dex */
public final class b extends com.baidu.swan.apps.process.a.a.a {
    @Override // com.baidu.swan.apps.process.a.a.a
    public void y(Bundle bundle) {
        c.a aIA;
        c.a aIA2;
        p.o(bundle, "params");
        String string = bundle.getString("openId");
        String string2 = bundle.getString("swanId");
        String string3 = bundle.getString("appId");
        String string4 = bundle.getString("hostName");
        if (ProcessUtils.isMainProcess()) {
            if (string != null && (aIA2 = c.drS.aIA()) != null) {
                aIA2.U(string, string3, string4);
            }
            if (string2 == null || (aIA = c.drS.aIA()) == null) {
                return;
            }
            aIA.T(string2, string3, string4);
        }
    }
}
