package com.baidu.swan.apps.r;

import android.os.Bundle;
import com.baidu.swan.apps.r.f;
import java.io.IOException;
import java.nio.channels.Pipe;
/* loaded from: classes9.dex */
public class c extends f.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final com.baidu.swan.pms.a.d dhn;
    private final String mSign;

    public c(String str, com.baidu.swan.pms.a.d dVar) {
        super("check_sign");
        this.mSign = str;
        this.dhn = dVar;
    }

    @Override // com.baidu.swan.apps.r.f.a
    protected boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        com.baidu.swan.apps.al.a uz;
        com.baidu.swan.apps.u.e.a pZ = com.baidu.swan.apps.u.e.a.pZ(bundle.getString("launch_id"));
        pZ.aCX().qc("SignChecker").jw(1);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            uz = com.baidu.swan.apps.core.pms.f.a.a(sourceChannel, this.mSign, this.dhn);
        } catch (IOException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            uz = new com.baidu.swan.apps.al.a().cV(11L).cW(2300L).uz("inputStream IOException:" + e.toString());
            com.baidu.swan.apps.al.e.aQK().j(uz);
            pZ.cb("SignChecker", uz.toString());
        } finally {
            com.baidu.swan.apps.ao.b.b.a(sourceChannel);
        }
        pZ.cb("SignChecker", "Cost: " + (System.currentTimeMillis() - currentTimeMillis));
        boolean z = uz == null;
        if (uz != null) {
            pZ.cb("SignChecker", uz.toString());
            aAp().putLong("result_error_code", uz.aQG());
        }
        pZ.cb("SignChecker", "done: " + z);
        return z;
    }
}
