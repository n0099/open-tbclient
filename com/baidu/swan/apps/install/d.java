package com.baidu.swan.apps.install;

import android.os.Bundle;
import com.baidu.swan.apps.install.g;
import java.io.IOException;
import java.nio.channels.Pipe;
/* loaded from: classes2.dex */
public class d extends g.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final String ayH;
    private final com.baidu.swan.pms.a.b ayI;

    public d(String str, com.baidu.swan.pms.a.b bVar) {
        super("check_sign");
        this.ayH = str;
        this.ayI = bVar;
    }

    @Override // com.baidu.swan.apps.install.g.a
    protected boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        com.baidu.swan.apps.ak.a ii;
        com.baidu.swan.apps.v.c.a eY = com.baidu.swan.apps.v.c.a.eY(bundle.getString("launch_id"));
        eY.Gc().fb("SignChecker").cI(1);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            ii = com.baidu.swan.apps.core.pms.c.a.a(sourceChannel, this.ayH, this.ayI);
        } catch (IOException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            ii = new com.baidu.swan.apps.ak.a().Z(11L).aa(2300L).ii("inputStream IOException:" + e.toString());
            com.baidu.swan.apps.ak.e.Pd().b(ii);
            eY.ak("SignChecker", ii.toString());
        } finally {
            com.baidu.swan.apps.an.b.b.a(sourceChannel);
        }
        eY.ak("SignChecker", "Cost: " + (System.currentTimeMillis() - currentTimeMillis));
        boolean z = ii == null;
        if (ii != null) {
            eY.ak("SignChecker", ii.toString());
            El().putLong("result_error_code", ii.OZ());
        }
        eY.ak("SignChecker", "done: " + z);
        return z;
    }
}
