package com.baidu.swan.apps.r;

import android.os.Bundle;
import com.baidu.swan.apps.r.g;
import java.io.IOException;
import java.nio.channels.Pipe;
/* loaded from: classes11.dex */
public class d extends g.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final String cla;
    private final com.baidu.swan.pms.a.d clb;

    public d(String str, com.baidu.swan.pms.a.d dVar) {
        super("check_sign");
        this.cla = str;
        this.clb = dVar;
    }

    @Override // com.baidu.swan.apps.r.g.a
    protected boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        com.baidu.swan.apps.an.a pB;
        com.baidu.swan.apps.v.c.a ls = com.baidu.swan.apps.v.c.a.ls(bundle.getString("launch_id"));
        ls.aiq().lv("SignChecker").fR(1);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            pB = com.baidu.swan.apps.core.pms.f.a.a(sourceChannel, this.cla, this.clb);
        } catch (IOException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            pB = new com.baidu.swan.apps.an.a().bw(11L).bx(2300L).pB("inputStream IOException:" + e.toString());
            com.baidu.swan.apps.an.e.atW().g(pB);
            ls.bv("SignChecker", pB.toString());
        } finally {
            com.baidu.swan.apps.aq.b.b.a(sourceChannel);
        }
        ls.bv("SignChecker", "Cost: " + (System.currentTimeMillis() - currentTimeMillis));
        boolean z = pB == null;
        if (pB != null) {
            ls.bv("SignChecker", pB.toString());
            afU().putLong("result_error_code", pB.atS());
        }
        ls.bv("SignChecker", "done: " + z);
        return z;
    }
}
