package com.baidu.swan.apps.r;

import android.os.Bundle;
import com.baidu.swan.apps.r.f;
import java.io.IOException;
import java.nio.channels.Pipe;
/* loaded from: classes10.dex */
public class c extends f.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final com.baidu.swan.pms.a.d cXh;
    private final String mSign;

    public c(String str, com.baidu.swan.pms.a.d dVar) {
        super("check_sign");
        this.mSign = str;
        this.cXh = dVar;
    }

    @Override // com.baidu.swan.apps.r.f.a
    protected boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        com.baidu.swan.apps.am.a ua;
        com.baidu.swan.apps.u.e.a pF = com.baidu.swan.apps.u.e.a.pF(bundle.getString("launch_id"));
        pF.aze().pI("SignChecker").jh(1);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            ua = com.baidu.swan.apps.core.pms.f.a.a(sourceChannel, this.mSign, this.cXh);
        } catch (IOException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            ua = new com.baidu.swan.apps.am.a().cv(11L).cw(2300L).ua("inputStream IOException:" + e.toString());
            com.baidu.swan.apps.am.e.aLT().j(ua);
            pF.bW("SignChecker", ua.toString());
        } finally {
            com.baidu.swan.apps.ap.b.b.a(sourceChannel);
        }
        pF.bW("SignChecker", "Cost: " + (System.currentTimeMillis() - currentTimeMillis));
        boolean z = ua == null;
        if (ua != null) {
            pF.bW("SignChecker", ua.toString());
            awx().putLong("result_error_code", ua.aLP());
        }
        pF.bW("SignChecker", "done: " + z);
        return z;
    }
}
