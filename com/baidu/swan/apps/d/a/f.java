package com.baidu.swan.apps.d.a;

import android.os.Bundle;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes8.dex */
public final class f {
    private static final String TAG;
    private static com.baidu.swan.apps.a.a cBT;
    private static com.baidu.swan.apps.a.c cBU;
    private static boolean cBV;
    public static final f cBW = new f();

    static {
        String simpleName = cBW.getClass().getSimpleName();
        p.n(simpleName, "SwanAppAllianceLoginHelper.javaClass.simpleName");
        TAG = simpleName;
    }

    private f() {
    }

    public final com.baidu.swan.apps.a.a ajc() {
        return cBT;
    }

    public final com.baidu.swan.apps.a.c ajd() {
        return cBU;
    }

    public final boolean aje() {
        return cBV;
    }

    public final void eO(boolean z) {
        cBV = z;
    }

    public final void ajf() {
        d.cBR.aiY();
        h.cBZ.ajj();
        eE(false);
    }

    public final boolean ajg() {
        if (g.aji() == null) {
            ajh();
        }
        Boolean aji = g.aji();
        if (aji == null) {
            p.eIW();
        }
        return aji.booleanValue();
    }

    public final void eE(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("status", z);
        DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), c.class, bundle);
    }

    private final void ajh() {
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
