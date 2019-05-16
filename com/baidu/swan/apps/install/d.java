package com.baidu.swan.apps.install;

import android.os.Bundle;
import com.baidu.swan.apps.install.g;
import java.io.IOException;
import java.nio.channels.Pipe;
/* loaded from: classes2.dex */
public class d extends g.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final String axC;
    private final com.baidu.swan.pms.a.b axD;

    public d(String str, com.baidu.swan.pms.a.b bVar) {
        super("check_sign");
        this.axC = str;
        this.axD = bVar;
    }

    @Override // com.baidu.swan.apps.install.g.a
    protected boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        com.baidu.swan.apps.ak.a hZ;
        com.baidu.swan.apps.v.c.a eS = com.baidu.swan.apps.v.c.a.eS(bundle.getString("launch_id"));
        eS.Fo().eV("SignChecker").cG(1);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            hZ = com.baidu.swan.apps.core.pms.c.a.a(sourceChannel, this.axC, this.axD);
        } catch (IOException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            hZ = new com.baidu.swan.apps.ak.a().Y(11L).Z(2300L).hZ("inputStream IOException:" + e.toString());
            com.baidu.swan.apps.ak.e.Ok().b(hZ);
            eS.ak("SignChecker", hZ.toString());
        } finally {
            com.baidu.swan.apps.an.b.b.a(sourceChannel);
        }
        eS.ak("SignChecker", "Cost: " + (System.currentTimeMillis() - currentTimeMillis));
        boolean z = hZ == null;
        if (hZ != null) {
            eS.ak("SignChecker", hZ.toString());
            Dy().putLong("result_error_code", hZ.Og());
        }
        eS.ak("SignChecker", "done: " + z);
        return z;
    }
}
