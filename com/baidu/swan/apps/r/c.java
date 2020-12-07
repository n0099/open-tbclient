package com.baidu.swan.apps.r;

import android.os.Bundle;
import com.baidu.swan.apps.r.f;
import java.io.IOException;
import java.nio.channels.Pipe;
/* loaded from: classes25.dex */
public class c extends f.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final com.baidu.swan.pms.a.d dct;
    private final String mSign;

    public c(String str, com.baidu.swan.pms.a.d dVar) {
        super("check_sign");
        this.mSign = str;
        this.dct = dVar;
    }

    @Override // com.baidu.swan.apps.r.f.a
    protected boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        com.baidu.swan.apps.am.a uC;
        com.baidu.swan.apps.u.e.a qg = com.baidu.swan.apps.u.e.a.qg(bundle.getString("launch_id"));
        qg.aBF().qj("SignChecker").jB(1);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            uC = com.baidu.swan.apps.core.pms.f.a.a(sourceChannel, this.mSign, this.dct);
        } catch (IOException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            uC = new com.baidu.swan.apps.am.a().cU(11L).cV(2300L).uC("inputStream IOException:" + e.toString());
            com.baidu.swan.apps.am.e.aOs().j(uC);
            qg.cc("SignChecker", uC.toString());
        } finally {
            com.baidu.swan.apps.ap.b.b.a(sourceChannel);
        }
        qg.cc("SignChecker", "Cost: " + (System.currentTimeMillis() - currentTimeMillis));
        boolean z = uC == null;
        if (uC != null) {
            qg.cc("SignChecker", uC.toString());
            ayX().putLong("result_error_code", uC.aOo());
        }
        qg.cc("SignChecker", "done: " + z);
        return z;
    }
}
