package com.baidu.swan.apps.t;

import android.os.Bundle;
import com.baidu.swan.apps.t.g;
import java.io.IOException;
import java.nio.channels.Pipe;
/* loaded from: classes11.dex */
public class d extends g.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final String bVR;
    private final com.baidu.swan.pms.a.d bVS;

    public d(String str, com.baidu.swan.pms.a.d dVar) {
        super("check_sign");
        this.bVR = str;
        this.bVS = dVar;
    }

    @Override // com.baidu.swan.apps.t.g.a
    protected boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        com.baidu.swan.apps.ap.a nL;
        com.baidu.swan.apps.x.c.a jY = com.baidu.swan.apps.x.c.a.jY(bundle.getString("launch_id"));
        jY.aea().kb("SignChecker").fr(1);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            nL = com.baidu.swan.apps.core.pms.d.a.a(sourceChannel, this.bVR, this.bVS);
        } catch (IOException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            nL = new com.baidu.swan.apps.ap.a().bn(11L).bo(2300L).nL("inputStream IOException:" + e.toString());
            com.baidu.swan.apps.ap.e.aov().f(nL);
            jY.bc("SignChecker", nL.toString());
        } finally {
            com.baidu.swan.apps.as.b.b.a(sourceChannel);
        }
        jY.bc("SignChecker", "Cost: " + (System.currentTimeMillis() - currentTimeMillis));
        boolean z = nL == null;
        if (nL != null) {
            jY.bc("SignChecker", nL.toString());
            abK().putLong("result_error_code", nL.aor());
        }
        jY.bc("SignChecker", "done: " + z);
        return z;
    }
}
