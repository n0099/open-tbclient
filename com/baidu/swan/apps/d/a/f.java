package com.baidu.swan.apps.d.a;

import android.os.Bundle;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes9.dex */
public final class f {
    private static final String TAG;
    private static com.baidu.swan.apps.a.a cEp;
    private static com.baidu.swan.apps.a.c cEq;
    private static boolean cEr;
    public static final f cEs = new f();

    static {
        String simpleName = cEs.getClass().getSimpleName();
        p.n(simpleName, "SwanAppAllianceLoginHelper.javaClass.simpleName");
        TAG = simpleName;
    }

    private f() {
    }

    public final com.baidu.swan.apps.a.a ajA() {
        return cEp;
    }

    public final com.baidu.swan.apps.a.c ajB() {
        return cEq;
    }

    public final boolean ajC() {
        return cEr;
    }

    public final void eQ(boolean z) {
        cEr = z;
    }

    public final void ajD() {
        d.cEn.ajw();
        h.cEv.ajH();
        eG(false);
    }

    public final boolean ajE() {
        if (g.ajG() == null) {
            ajF();
        }
        Boolean ajG = g.ajG();
        if (ajG == null) {
            p.eLu();
        }
        return ajG.booleanValue();
    }

    public final void eG(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("status", z);
        DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), c.class, bundle);
    }

    private final void ajF() {
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
