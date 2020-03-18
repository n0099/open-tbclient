package com.baidu.swan.apps.t;

import android.os.Bundle;
import com.baidu.swan.apps.t.g;
import java.io.IOException;
import java.nio.channels.Pipe;
/* loaded from: classes11.dex */
public class d extends g.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final String bxF;
    private final com.baidu.swan.pms.a.d bxG;

    public d(String str, com.baidu.swan.pms.a.d dVar) {
        super("check_sign");
        this.bxF = str;
        this.bxG = dVar;
    }

    @Override // com.baidu.swan.apps.t.g.a
    protected boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        com.baidu.swan.apps.ap.a my;
        com.baidu.swan.apps.x.c.a iL = com.baidu.swan.apps.x.c.a.iL(bundle.getString("launch_id"));
        iL.Wm().iO("SignChecker").fm(1);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            my = com.baidu.swan.apps.core.pms.d.a.a(sourceChannel, this.bxF, this.bxG);
        } catch (IOException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            my = new com.baidu.swan.apps.ap.a().aI(11L).aJ(2300L).my("inputStream IOException:" + e.toString());
            com.baidu.swan.apps.ap.e.agr().f(my);
            iL.aS("SignChecker", my.toString());
        } finally {
            com.baidu.swan.apps.as.b.b.a(sourceChannel);
        }
        iL.aS("SignChecker", "Cost: " + (System.currentTimeMillis() - currentTimeMillis));
        boolean z = my == null;
        if (my != null) {
            iL.aS("SignChecker", my.toString());
            TW().putLong("result_error_code", my.agn());
        }
        iL.aS("SignChecker", "done: " + z);
        return z;
    }
}
