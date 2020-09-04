package com.baidu.swan.apps.r;

import android.os.Bundle;
import com.baidu.swan.apps.r.f;
import java.io.IOException;
import java.nio.channels.Pipe;
/* loaded from: classes8.dex */
public class c extends f.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final String cuL;
    private final com.baidu.swan.pms.a.d cuM;

    public c(String str, com.baidu.swan.pms.a.d dVar) {
        super("check_sign");
        this.cuL = str;
        this.cuM = dVar;
    }

    @Override // com.baidu.swan.apps.r.f.a
    protected boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        com.baidu.swan.apps.am.a sn;
        com.baidu.swan.apps.u.e.a nR = com.baidu.swan.apps.u.e.a.nR(bundle.getString("launch_id"));
        nR.aro().nU("SignChecker").m34if(1);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            sn = com.baidu.swan.apps.core.pms.f.a.a(sourceChannel, this.cuL, this.cuM);
        } catch (IOException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            sn = new com.baidu.swan.apps.am.a().bO(11L).bP(2300L).sn("inputStream IOException:" + e.toString());
            com.baidu.swan.apps.am.e.aEg().j(sn);
            nR.bK("SignChecker", sn.toString());
        } finally {
            com.baidu.swan.apps.ap.b.b.a(sourceChannel);
        }
        nR.bK("SignChecker", "Cost: " + (System.currentTimeMillis() - currentTimeMillis));
        boolean z = sn == null;
        if (sn != null) {
            nR.bK("SignChecker", sn.toString());
            aoG().putLong("result_error_code", sn.aEc());
        }
        nR.bK("SignChecker", "done: " + z);
        return z;
    }
}
