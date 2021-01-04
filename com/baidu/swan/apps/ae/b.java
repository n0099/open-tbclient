package com.baidu.swan.apps.ae;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.ae.c;
import kotlin.e;
import kotlin.jvm.internal.p;
@e
/* loaded from: classes9.dex */
public final class b extends com.baidu.swan.apps.process.a.a.a {
    @Override // com.baidu.swan.apps.process.a.a.a
    public void y(Bundle bundle) {
        c.a aJT;
        c.a aJT2;
        p.o(bundle, "params");
        String string = bundle.getString("openId");
        String string2 = bundle.getString("swanId");
        String string3 = bundle.getString("appId");
        String string4 = bundle.getString("hostName");
        if (ProcessUtils.isMainProcess()) {
            if (string != null && (aJT2 = c.dwQ.aJT()) != null) {
                aJT2.X(string, string3, string4);
            }
            if (string2 == null || (aJT = c.dwQ.aJT()) == null) {
                return;
            }
            aJT.W(string2, string3, string4);
        }
    }
}
