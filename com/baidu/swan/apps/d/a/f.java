package com.baidu.swan.apps.d.a;

import android.os.Bundle;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes25.dex */
public final class f {
    private static final String TAG;
    private static com.baidu.swan.apps.a.a cBP;
    private static com.baidu.swan.apps.a.c cBQ;
    private static boolean cBR;
    public static final f cBS = new f();

    static {
        String simpleName = cBS.getClass().getSimpleName();
        p.n(simpleName, "SwanAppAllianceLoginHelper.javaClass.simpleName");
        TAG = simpleName;
    }

    private f() {
    }

    public final com.baidu.swan.apps.a.a alL() {
        return cBP;
    }

    public final com.baidu.swan.apps.a.c alM() {
        return cBQ;
    }

    public final boolean alN() {
        return cBR;
    }

    public final void eJ(boolean z) {
        cBR = z;
    }

    public final void alO() {
        d.cBN.alH();
        h.cBV.alS();
        eA(false);
    }

    public final boolean alP() {
        if (g.alR() == null) {
            alQ();
        }
        Boolean alR = g.alR();
        if (alR == null) {
            p.eEa();
        }
        return alR.booleanValue();
    }

    public final void eA(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("status", z);
        DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), c.class, bundle);
    }

    private final void alQ() {
        boolean z;
        try {
            Class.forName("com.baidu.sapi2.SapiAccountManager");
            z = false;
        } catch (ClassNotFoundException e) {
            z = true;
        }
        g.d(Boolean.valueOf(z));
    }
}
