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
        com.baidu.swan.apps.ak.a hY;
        com.baidu.swan.apps.v.c.a eR = com.baidu.swan.apps.v.c.a.eR(bundle.getString("launch_id"));
        eR.Fo().eU("SignChecker").cG(1);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            hY = com.baidu.swan.apps.core.pms.c.a.a(sourceChannel, this.axC, this.axD);
        } catch (IOException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            hY = new com.baidu.swan.apps.ak.a().Y(11L).Z(2300L).hY("inputStream IOException:" + e.toString());
            com.baidu.swan.apps.ak.e.Ok().b(hY);
            eR.ak("SignChecker", hY.toString());
        } finally {
            com.baidu.swan.apps.an.b.b.a(sourceChannel);
        }
        eR.ak("SignChecker", "Cost: " + (System.currentTimeMillis() - currentTimeMillis));
        boolean z = hY == null;
        if (hY != null) {
            eR.ak("SignChecker", hY.toString());
            Dy().putLong("result_error_code", hY.Og());
        }
        eR.ak("SignChecker", "done: " + z);
        return z;
    }
}
