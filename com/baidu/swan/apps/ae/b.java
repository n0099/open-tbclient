package com.baidu.swan.apps.ae;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.ae.c;
import kotlin.e;
import kotlin.jvm.internal.p;
@e
/* loaded from: classes8.dex */
public final class b extends com.baidu.swan.apps.process.a.a.a {
    @Override // com.baidu.swan.apps.process.a.a.a
    public void y(Bundle bundle) {
        c.a aGa;
        c.a aGa2;
        p.o(bundle, "params");
        String string = bundle.getString("openId");
        String string2 = bundle.getString("swanId");
        String string3 = bundle.getString("appId");
        String string4 = bundle.getString("hostName");
        if (ProcessUtils.isMainProcess()) {
            if (string != null && (aGa2 = c.dsc.aGa()) != null) {
                aGa2.W(string, string3, string4);
            }
            if (string2 == null || (aGa = c.dsc.aGa()) == null) {
                return;
            }
            aGa.V(string2, string3, string4);
        }
    }
}
