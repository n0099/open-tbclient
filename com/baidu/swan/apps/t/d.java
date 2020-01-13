package com.baidu.swan.apps.t;

import android.os.Bundle;
import com.baidu.swan.apps.t.g;
import java.io.IOException;
import java.nio.channels.Pipe;
/* loaded from: classes10.dex */
public class d extends g.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final String bti;
    private final com.baidu.swan.pms.a.d btj;

    public d(String str, com.baidu.swan.pms.a.d dVar) {
        super("check_sign");
        this.bti = str;
        this.btj = dVar;
    }

    @Override // com.baidu.swan.apps.t.g.a
    protected boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        com.baidu.swan.apps.ap.a mk;
        com.baidu.swan.apps.x.c.a ix = com.baidu.swan.apps.x.c.a.ix(bundle.getString("launch_id"));
        ix.TT().iA("SignChecker").eW(1);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            mk = com.baidu.swan.apps.core.pms.d.a.a(sourceChannel, this.bti, this.btj);
        } catch (IOException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            mk = new com.baidu.swan.apps.ap.a().aE(11L).aF(2300L).mk("inputStream IOException:" + e.toString());
            com.baidu.swan.apps.ap.e.adY().f(mk);
            ix.aJ("SignChecker", mk.toString());
        } finally {
            com.baidu.swan.apps.as.b.b.a(sourceChannel);
        }
        ix.aJ("SignChecker", "Cost: " + (System.currentTimeMillis() - currentTimeMillis));
        boolean z = mk == null;
        if (mk != null) {
            ix.aJ("SignChecker", mk.toString());
            RD().putLong("result_error_code", mk.adU());
        }
        ix.aJ("SignChecker", "done: " + z);
        return z;
    }
}
