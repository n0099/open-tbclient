package com.baidu.swan.apps.r;

import android.os.Bundle;
import com.baidu.swan.apps.r.f;
import java.io.IOException;
import java.nio.channels.Pipe;
/* loaded from: classes8.dex */
public class c extends f.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final String cuH;
    private final com.baidu.swan.pms.a.d cuI;

    public c(String str, com.baidu.swan.pms.a.d dVar) {
        super("check_sign");
        this.cuH = str;
        this.cuI = dVar;
    }

    @Override // com.baidu.swan.apps.r.f.a
    protected boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        com.baidu.swan.apps.am.a sm;
        com.baidu.swan.apps.u.e.a nQ = com.baidu.swan.apps.u.e.a.nQ(bundle.getString("launch_id"));
        nQ.aro().nT("SignChecker").m34if(1);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            sm = com.baidu.swan.apps.core.pms.f.a.a(sourceChannel, this.cuH, this.cuI);
        } catch (IOException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            sm = new com.baidu.swan.apps.am.a().bO(11L).bP(2300L).sm("inputStream IOException:" + e.toString());
            com.baidu.swan.apps.am.e.aEg().j(sm);
            nQ.bK("SignChecker", sm.toString());
        } finally {
            com.baidu.swan.apps.ap.b.b.a(sourceChannel);
        }
        nQ.bK("SignChecker", "Cost: " + (System.currentTimeMillis() - currentTimeMillis));
        boolean z = sm == null;
        if (sm != null) {
            nQ.bK("SignChecker", sm.toString());
            aoG().putLong("result_error_code", sm.aEc());
        }
        nQ.bK("SignChecker", "done: " + z);
        return z;
    }
}
