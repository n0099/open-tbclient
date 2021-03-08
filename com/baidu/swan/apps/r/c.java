package com.baidu.swan.apps.r;

import android.os.Bundle;
import com.baidu.swan.apps.r.f;
import java.io.IOException;
import java.nio.channels.Pipe;
/* loaded from: classes8.dex */
public class c extends f.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final com.baidu.swan.pms.a.d dgn;
    private final String mSign;

    public c(String str, com.baidu.swan.pms.a.d dVar) {
        super("check_sign");
        this.mSign = str;
        this.dgn = dVar;
    }

    @Override // com.baidu.swan.apps.r.f.a
    protected boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        com.baidu.swan.apps.al.a tO;
        com.baidu.swan.apps.u.e.a pn = com.baidu.swan.apps.u.e.a.pn(bundle.getString("launch_id"));
        pn.azE().pq("SignChecker").hU(1);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            tO = com.baidu.swan.apps.core.pms.f.a.a(sourceChannel, this.mSign, this.dgn);
        } catch (IOException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            tO = new com.baidu.swan.apps.al.a().db(11L).dc(2300L).tO("inputStream IOException:" + e.toString());
            com.baidu.swan.apps.al.e.aNm().j(tO);
            pn.bU("SignChecker", tO.toString());
        } finally {
            com.baidu.swan.apps.ao.b.b.a(sourceChannel);
        }
        pn.bU("SignChecker", "Cost: " + (System.currentTimeMillis() - currentTimeMillis));
        boolean z = tO == null;
        if (tO != null) {
            pn.bU("SignChecker", tO.toString());
            awW().putLong("result_error_code", tO.aNi());
        }
        pn.bU("SignChecker", "done: " + z);
        return z;
    }
}
