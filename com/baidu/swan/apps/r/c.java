package com.baidu.swan.apps.r;

import android.os.Bundle;
import com.baidu.swan.apps.r.f;
import java.io.IOException;
import java.nio.channels.Pipe;
/* loaded from: classes10.dex */
public class c extends f.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final com.baidu.swan.pms.a.d cRo;
    private final String mSign;

    public c(String str, com.baidu.swan.pms.a.d dVar) {
        super("check_sign");
        this.mSign = str;
        this.cRo = dVar;
    }

    @Override // com.baidu.swan.apps.r.f.a
    protected boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        com.baidu.swan.apps.am.a tM;
        com.baidu.swan.apps.u.e.a pr = com.baidu.swan.apps.u.e.a.pr(bundle.getString("launch_id"));
        pr.awE().pu("SignChecker").iX(1);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            tM = com.baidu.swan.apps.core.pms.f.a.a(sourceChannel, this.mSign, this.cRo);
        } catch (IOException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            tM = new com.baidu.swan.apps.am.a().bZ(11L).ca(2300L).tM("inputStream IOException:" + e.toString());
            com.baidu.swan.apps.am.e.aJt().j(tM);
            pr.bW("SignChecker", tM.toString());
        } finally {
            com.baidu.swan.apps.ap.b.b.a(sourceChannel);
        }
        pr.bW("SignChecker", "Cost: " + (System.currentTimeMillis() - currentTimeMillis));
        boolean z = tM == null;
        if (tM != null) {
            pr.bW("SignChecker", tM.toString());
            atX().putLong("result_error_code", tM.aJp());
        }
        pr.bW("SignChecker", "done: " + z);
        return z;
    }
}
