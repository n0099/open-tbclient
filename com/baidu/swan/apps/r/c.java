package com.baidu.swan.apps.r;

import android.os.Bundle;
import com.baidu.swan.apps.r.f;
import java.io.IOException;
import java.nio.channels.Pipe;
/* loaded from: classes3.dex */
public class c extends f.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final String cwM;
    private final com.baidu.swan.pms.a.d cwN;

    public c(String str, com.baidu.swan.pms.a.d dVar) {
        super("check_sign");
        this.cwM = str;
        this.cwN = dVar;
    }

    @Override // com.baidu.swan.apps.r.f.a
    protected boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        com.baidu.swan.apps.am.a sH;
        com.baidu.swan.apps.u.e.a ol = com.baidu.swan.apps.u.e.a.ol(bundle.getString("launch_id"));
        ol.arY().op("SignChecker").ip(1);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            sH = com.baidu.swan.apps.core.pms.f.a.a(sourceChannel, this.cwM, this.cwN);
        } catch (IOException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            sH = new com.baidu.swan.apps.am.a().bP(11L).bQ(2300L).sH("inputStream IOException:" + e.toString());
            com.baidu.swan.apps.am.e.aEQ().j(sH);
            ol.bK("SignChecker", sH.toString());
        } finally {
            com.baidu.swan.apps.ap.b.b.a(sourceChannel);
        }
        ol.bK("SignChecker", "Cost: " + (System.currentTimeMillis() - currentTimeMillis));
        boolean z = sH == null;
        if (sH != null) {
            ol.bK("SignChecker", sH.toString());
            apr().putLong("result_error_code", sH.aEM());
        }
        ol.bK("SignChecker", "done: " + z);
        return z;
    }
}
