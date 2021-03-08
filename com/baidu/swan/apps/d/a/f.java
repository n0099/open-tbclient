package com.baidu.swan.apps.d.a;

import android.os.Bundle;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes8.dex */
public final class f {
    private static final String TAG;
    private static com.baidu.swan.apps.a.a cFP;
    private static com.baidu.swan.apps.a.c cFQ;
    private static boolean cFR;
    public static final f cFS = new f();

    static {
        String simpleName = cFS.getClass().getSimpleName();
        p.o(simpleName, "SwanAppAllianceLoginHelper.javaClass.simpleName");
        TAG = simpleName;
    }

    private f() {
    }

    public final com.baidu.swan.apps.a.a ajD() {
        return cFP;
    }

    public final com.baidu.swan.apps.a.c ajE() {
        return cFQ;
    }

    public final boolean ajF() {
        return cFR;
    }

    public final void eQ(boolean z) {
        cFR = z;
    }

    public final void ajG() {
        d.cFN.ajz();
        h.cFV.ajK();
        eG(false);
    }

    public final boolean ajH() {
        if (g.ajJ() == null) {
            ajI();
        }
        Boolean ajJ = g.ajJ();
        if (ajJ == null) {
            p.eLc();
        }
        return ajJ.booleanValue();
    }

    public final void eG(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("status", z);
        DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), c.class, bundle);
    }

    private final void ajI() {
        boolean z;
        try {
            Class.forName("com.baidu.sapi2.SapiAccountManager");
            z = false;
        } catch (ClassNotFoundException e) {
            z = true;
        }
        g.e(Boolean.valueOf(z));
    }
}
