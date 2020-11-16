package com.baidu.swan.apps.r;

import android.os.Bundle;
import com.baidu.swan.apps.r.f;
import java.io.IOException;
import java.nio.channels.Pipe;
/* loaded from: classes7.dex */
public class c extends f.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final com.baidu.swan.pms.a.d cVx;
    private final String mSign;

    public c(String str, com.baidu.swan.pms.a.d dVar) {
        super("check_sign");
        this.mSign = str;
        this.cVx = dVar;
    }

    @Override // com.baidu.swan.apps.r.f.a
    protected boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        com.baidu.swan.apps.am.a tV;
        com.baidu.swan.apps.u.e.a pz = com.baidu.swan.apps.u.e.a.pz(bundle.getString("launch_id"));
        pz.ayw().pC("SignChecker").jd(1);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            tV = com.baidu.swan.apps.core.pms.f.a.a(sourceChannel, this.mSign, this.cVx);
        } catch (IOException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            tV = new com.baidu.swan.apps.am.a().cv(11L).cw(2300L).tV("inputStream IOException:" + e.toString());
            com.baidu.swan.apps.am.e.aLl().j(tV);
            pz.bV("SignChecker", tV.toString());
        } finally {
            com.baidu.swan.apps.ap.b.b.a(sourceChannel);
        }
        pz.bV("SignChecker", "Cost: " + (System.currentTimeMillis() - currentTimeMillis));
        boolean z = tV == null;
        if (tV != null) {
            pz.bV("SignChecker", tV.toString());
            avP().putLong("result_error_code", tV.aLh());
        }
        pz.bV("SignChecker", "done: " + z);
        return z;
    }
}
