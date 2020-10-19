package com.baidu.swan.apps.r;

import android.os.Bundle;
import com.baidu.swan.apps.r.f;
import java.io.IOException;
import java.nio.channels.Pipe;
/* loaded from: classes10.dex */
public class c extends f.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final com.baidu.swan.pms.a.d cIS;
    private final String mSign;

    public c(String str, com.baidu.swan.pms.a.d dVar) {
        super("check_sign");
        this.mSign = str;
        this.cIS = dVar;
    }

    @Override // com.baidu.swan.apps.r.f.a
    protected boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        com.baidu.swan.apps.am.a tt;
        com.baidu.swan.apps.u.e.a oY = com.baidu.swan.apps.u.e.a.oY(bundle.getString("launch_id"));
        oY.auK().pb("SignChecker").iM(1);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            tt = com.baidu.swan.apps.core.pms.f.a.a(sourceChannel, this.mSign, this.cIS);
        } catch (IOException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            tt = new com.baidu.swan.apps.am.a().bX(11L).bY(2300L).tt("inputStream IOException:" + e.toString());
            com.baidu.swan.apps.am.e.aHz().j(tt);
            oY.bP("SignChecker", tt.toString());
        } finally {
            com.baidu.swan.apps.ap.b.b.a(sourceChannel);
        }
        oY.bP("SignChecker", "Cost: " + (System.currentTimeMillis() - currentTimeMillis));
        boolean z = tt == null;
        if (tt != null) {
            oY.bP("SignChecker", tt.toString());
            asc().putLong("result_error_code", tt.aHv());
        }
        oY.bP("SignChecker", "done: " + z);
        return z;
    }
}
