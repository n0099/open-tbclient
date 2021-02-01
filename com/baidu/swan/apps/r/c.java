package com.baidu.swan.apps.r;

import android.os.Bundle;
import com.baidu.swan.apps.r.f;
import java.io.IOException;
import java.nio.channels.Pipe;
/* loaded from: classes9.dex */
public class c extends f.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final com.baidu.swan.pms.a.d deM;
    private final String mSign;

    public c(String str, com.baidu.swan.pms.a.d dVar) {
        super("check_sign");
        this.mSign = str;
        this.deM = dVar;
    }

    @Override // com.baidu.swan.apps.r.f.a
    protected boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        com.baidu.swan.apps.al.a tH;
        com.baidu.swan.apps.u.e.a pg = com.baidu.swan.apps.u.e.a.pg(bundle.getString("launch_id"));
        pg.azB().pj("SignChecker").hT(1);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            tH = com.baidu.swan.apps.core.pms.f.a.a(sourceChannel, this.mSign, this.deM);
        } catch (IOException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            tH = new com.baidu.swan.apps.al.a().db(11L).dc(2300L).tH("inputStream IOException:" + e.toString());
            com.baidu.swan.apps.al.e.aNj().j(tH);
            pg.bU("SignChecker", tH.toString());
        } finally {
            com.baidu.swan.apps.ao.b.b.a(sourceChannel);
        }
        pg.bU("SignChecker", "Cost: " + (System.currentTimeMillis() - currentTimeMillis));
        boolean z = tH == null;
        if (tH != null) {
            pg.bU("SignChecker", tH.toString());
            awT().putLong("result_error_code", tH.aNf());
        }
        pg.bU("SignChecker", "done: " + z);
        return z;
    }
}
