package com.baidu.swan.apps.r;

import android.os.Bundle;
import com.baidu.swan.apps.r.f;
import java.io.IOException;
import java.nio.channels.Pipe;
/* loaded from: classes7.dex */
public class c extends f.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final String cne;
    private final com.baidu.swan.pms.a.d cnf;

    public c(String str, com.baidu.swan.pms.a.d dVar) {
        super("check_sign");
        this.cne = str;
        this.cnf = dVar;
    }

    @Override // com.baidu.swan.apps.r.f.a
    protected boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        com.baidu.swan.apps.an.a qm;
        com.baidu.swan.apps.u.d.a lT = com.baidu.swan.apps.u.d.a.lT(bundle.getString("launch_id"));
        lT.ajH().lW("SignChecker").gb(1);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            qm = com.baidu.swan.apps.core.pms.f.a.a(sourceChannel, this.cne, this.cnf);
        } catch (IOException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            qm = new com.baidu.swan.apps.an.a().bJ(11L).bK(2300L).qm("inputStream IOException:" + e.toString());
            com.baidu.swan.apps.an.e.avX().g(qm);
            lT.bx("SignChecker", qm.toString());
        } finally {
            com.baidu.swan.apps.aq.b.b.a(sourceChannel);
        }
        lT.bx("SignChecker", "Cost: " + (System.currentTimeMillis() - currentTimeMillis));
        boolean z = qm == null;
        if (qm != null) {
            lT.bx("SignChecker", qm.toString());
            ahg().putLong("result_error_code", qm.avT());
        }
        lT.bx("SignChecker", "done: " + z);
        return z;
    }
}
