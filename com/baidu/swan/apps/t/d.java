package com.baidu.swan.apps.t;

import android.os.Bundle;
import com.baidu.swan.apps.t.g;
import java.io.IOException;
import java.nio.channels.Pipe;
/* loaded from: classes11.dex */
public class d extends g.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final String bxs;
    private final com.baidu.swan.pms.a.d bxt;

    public d(String str, com.baidu.swan.pms.a.d dVar) {
        super("check_sign");
        this.bxs = str;
        this.bxt = dVar;
    }

    @Override // com.baidu.swan.apps.t.g.a
    protected boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        com.baidu.swan.apps.ap.a mz;
        com.baidu.swan.apps.x.c.a iM = com.baidu.swan.apps.x.c.a.iM(bundle.getString("launch_id"));
        iM.Wh().iP("SignChecker").fm(1);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            mz = com.baidu.swan.apps.core.pms.d.a.a(sourceChannel, this.bxs, this.bxt);
        } catch (IOException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            mz = new com.baidu.swan.apps.ap.a().aI(11L).aJ(2300L).mz("inputStream IOException:" + e.toString());
            com.baidu.swan.apps.ap.e.agm().f(mz);
            iM.aT("SignChecker", mz.toString());
        } finally {
            com.baidu.swan.apps.as.b.b.a(sourceChannel);
        }
        iM.aT("SignChecker", "Cost: " + (System.currentTimeMillis() - currentTimeMillis));
        boolean z = mz == null;
        if (mz != null) {
            iM.aT("SignChecker", mz.toString());
            TR().putLong("result_error_code", mz.agi());
        }
        iM.aT("SignChecker", "done: " + z);
        return z;
    }
}
