package com.baidu.swan.apps.ae;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.ae.c;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes10.dex */
public final class b extends com.baidu.swan.apps.process.a.a.a {
    @Override // com.baidu.swan.apps.process.a.a.a
    public void y(Bundle bundle) {
        c.a aDA;
        c.a aDA2;
        q.n(bundle, "params");
        String string = bundle.getString("openId");
        String string2 = bundle.getString("swanId");
        String string3 = bundle.getString("appId");
        String string4 = bundle.getString("hostName");
        if (ProcessUtils.isMainProcess()) {
            if (string != null && (aDA2 = c.dgE.aDA()) != null) {
                aDA2.R(string, string3, string4);
            }
            if (string2 == null || (aDA = c.dgE.aDA()) == null) {
                return;
            }
            aDA.Q(string2, string3, string4);
        }
    }
}
