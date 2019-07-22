package com.baidu.swan.apps.install;

import android.os.Bundle;
import com.baidu.swan.apps.install.g;
import java.io.IOException;
import java.nio.channels.Pipe;
/* loaded from: classes2.dex */
public class d extends g.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final String ayj;
    private final com.baidu.swan.pms.a.b ayk;

    public d(String str, com.baidu.swan.pms.a.b bVar) {
        super("check_sign");
        this.ayj = str;
        this.ayk = bVar;
    }

    @Override // com.baidu.swan.apps.install.g.a
    protected boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        com.baidu.swan.apps.ak.a ig;
        com.baidu.swan.apps.v.c.a eW = com.baidu.swan.apps.v.c.a.eW(bundle.getString("launch_id"));
        eW.FY().eZ("SignChecker").cH(1);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            ig = com.baidu.swan.apps.core.pms.c.a.a(sourceChannel, this.ayj, this.ayk);
        } catch (IOException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            ig = new com.baidu.swan.apps.ak.a().Z(11L).aa(2300L).ig("inputStream IOException:" + e.toString());
            com.baidu.swan.apps.ak.e.OZ().b(ig);
            eW.ak("SignChecker", ig.toString());
        } finally {
            com.baidu.swan.apps.an.b.b.a(sourceChannel);
        }
        eW.ak("SignChecker", "Cost: " + (System.currentTimeMillis() - currentTimeMillis));
        boolean z = ig == null;
        if (ig != null) {
            eW.ak("SignChecker", ig.toString());
            Eh().putLong("result_error_code", ig.OV());
        }
        eW.ak("SignChecker", "done: " + z);
        return z;
    }
}
