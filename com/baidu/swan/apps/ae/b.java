package com.baidu.swan.apps.ae;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.ae.c;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes3.dex */
public final class b extends com.baidu.swan.apps.process.a.a.a {
    @Override // com.baidu.swan.apps.process.a.a.a
    public void y(Bundle bundle) {
        c.a ayX;
        c.a ayX2;
        q.m(bundle, "params");
        String string = bundle.getString("openId");
        String string2 = bundle.getString("swanId");
        String string3 = bundle.getString("appId");
        String string4 = bundle.getString("hostName");
        if (ProcessUtils.isMainProcess()) {
            if (string != null && (ayX2 = c.cMa.ayX()) != null) {
                ayX2.J(string, string3, string4);
            }
            if (string2 == null || (ayX = c.cMa.ayX()) == null) {
                return;
            }
            ayX.I(string2, string3, string4);
        }
    }
}
