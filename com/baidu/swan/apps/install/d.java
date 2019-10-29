package com.baidu.swan.apps.install;

import android.os.Bundle;
import com.baidu.swan.apps.install.g;
import java.io.IOException;
import java.nio.channels.Pipe;
/* loaded from: classes2.dex */
public class d extends g.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final String aRX;
    private final com.baidu.swan.pms.a.b aRY;

    public d(String str, com.baidu.swan.pms.a.b bVar) {
        super("check_sign");
        this.aRX = str;
        this.aRY = bVar;
    }

    @Override // com.baidu.swan.apps.install.g.a
    protected boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        com.baidu.swan.apps.ak.a iL;
        com.baidu.swan.apps.v.c.a fF = com.baidu.swan.apps.v.c.a.fF(bundle.getString("launch_id"));
        fF.KW().fI("SignChecker").dD(1);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            iL = com.baidu.swan.apps.core.pms.c.a.a(sourceChannel, this.aRX, this.aRY);
        } catch (IOException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            iL = new com.baidu.swan.apps.ak.a().as(11L).at(2300L).iL("inputStream IOException:" + e.toString());
            com.baidu.swan.apps.ak.e.TT().b(iL);
            fF.as("SignChecker", iL.toString());
        } finally {
            com.baidu.swan.apps.an.b.b.a(sourceChannel);
        }
        fF.as("SignChecker", "Cost: " + (System.currentTimeMillis() - currentTimeMillis));
        boolean z = iL == null;
        if (iL != null) {
            fF.as("SignChecker", iL.toString());
            Jf().putLong("result_error_code", iL.TP());
        }
        fF.as("SignChecker", "done: " + z);
        return z;
    }
}
