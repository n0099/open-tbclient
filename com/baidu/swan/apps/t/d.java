package com.baidu.swan.apps.t;

import android.os.Bundle;
import com.baidu.swan.apps.t.g;
import java.io.IOException;
import java.nio.channels.Pipe;
/* loaded from: classes9.dex */
public class d extends g.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final String bsu;
    private final com.baidu.swan.pms.a.d bsv;

    public d(String str, com.baidu.swan.pms.a.d dVar) {
        super("check_sign");
        this.bsu = str;
        this.bsv = dVar;
    }

    @Override // com.baidu.swan.apps.t.g.a
    protected boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        com.baidu.swan.apps.ap.a mh;
        com.baidu.swan.apps.x.c.a iu = com.baidu.swan.apps.x.c.a.iu(bundle.getString("launch_id"));
        iu.Tw().ix("SignChecker").eV(1);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            mh = com.baidu.swan.apps.core.pms.d.a.a(sourceChannel, this.bsu, this.bsv);
        } catch (IOException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            mh = new com.baidu.swan.apps.ap.a().aB(11L).aC(2300L).mh("inputStream IOException:" + e.toString());
            com.baidu.swan.apps.ap.e.adF().f(mh);
            iu.aI("SignChecker", mh.toString());
        } finally {
            com.baidu.swan.apps.as.b.b.a(sourceChannel);
        }
        iu.aI("SignChecker", "Cost: " + (System.currentTimeMillis() - currentTimeMillis));
        boolean z = mh == null;
        if (mh != null) {
            iu.aI("SignChecker", mh.toString());
            Rh().putLong("result_error_code", mh.adB());
        }
        iu.aI("SignChecker", "done: " + z);
        return z;
    }
}
