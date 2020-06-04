package com.baidu.swan.apps.r;

import android.os.Bundle;
import com.baidu.swan.apps.r.g;
import java.io.IOException;
import java.nio.channels.Pipe;
/* loaded from: classes11.dex */
public class d extends g.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final String cgm;
    private final com.baidu.swan.pms.a.d cgn;

    public d(String str, com.baidu.swan.pms.a.d dVar) {
        super("check_sign");
        this.cgm = str;
        this.cgn = dVar;
    }

    @Override // com.baidu.swan.apps.r.g.a
    protected boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        com.baidu.swan.apps.an.a pt;
        com.baidu.swan.apps.v.c.a lk = com.baidu.swan.apps.v.c.a.lk(bundle.getString("launch_id"));
        lk.ahk().ln("SignChecker").fG(1);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            pt = com.baidu.swan.apps.core.pms.f.a.a(sourceChannel, this.cgm, this.cgn);
        } catch (IOException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            pt = new com.baidu.swan.apps.an.a().bw(11L).bx(2300L).pt("inputStream IOException:" + e.toString());
            com.baidu.swan.apps.an.e.asQ().g(pt);
            lk.bt("SignChecker", pt.toString());
        } finally {
            com.baidu.swan.apps.aq.b.b.a(sourceChannel);
        }
        lk.bt("SignChecker", "Cost: " + (System.currentTimeMillis() - currentTimeMillis));
        boolean z = pt == null;
        if (pt != null) {
            lk.bt("SignChecker", pt.toString());
            aeO().putLong("result_error_code", pt.asM());
        }
        lk.bt("SignChecker", "done: " + z);
        return z;
    }
}
