package com.baidu.swan.apps.r;

import android.os.Bundle;
import com.baidu.swan.apps.r.f;
import java.io.IOException;
import java.nio.channels.Pipe;
/* loaded from: classes8.dex */
public class c extends f.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final com.baidu.swan.pms.a.d dcz;
    private final String mSign;

    public c(String str, com.baidu.swan.pms.a.d dVar) {
        super("check_sign");
        this.mSign = str;
        this.dcz = dVar;
    }

    @Override // com.baidu.swan.apps.r.f.a
    protected boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        com.baidu.swan.apps.al.a aVar;
        com.baidu.swan.apps.u.e.a oO = com.baidu.swan.apps.u.e.a.oO(bundle.getString("launch_id"));
        oO.azd().oR("SignChecker").hQ(1);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            aVar = com.baidu.swan.apps.core.pms.f.a.a(sourceChannel, this.mSign, this.dcz);
        } catch (IOException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            aVar = new com.baidu.swan.apps.al.a().cV(11L).cW(2300L).to("inputStream IOException:" + e.toString());
            com.baidu.swan.apps.al.e.aMQ().j(aVar);
            oO.ca("SignChecker", aVar.toString());
        } finally {
            com.baidu.swan.apps.ao.b.b.a(sourceChannel);
        }
        oO.ca("SignChecker", "Cost: " + (System.currentTimeMillis() - currentTimeMillis));
        boolean z = aVar == null;
        if (aVar != null) {
            oO.ca("SignChecker", aVar.toString());
            awv().putLong("result_error_code", aVar.aMM());
        }
        oO.ca("SignChecker", "done: " + z);
        return z;
    }
}
