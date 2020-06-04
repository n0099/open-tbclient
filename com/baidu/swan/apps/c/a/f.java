package com.baidu.swan.apps.c.a;

import android.os.Bundle;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes11.dex */
public final class f {
    private static final String TAG;
    private static com.baidu.swan.apps.a.a bIN;
    private static com.baidu.swan.apps.a.c bIO;
    private static boolean bIP;
    public static final f bIQ = new f();

    static {
        String simpleName = bIQ.getClass().getSimpleName();
        q.l((Object) simpleName, "SwanAppAllianceLoginHelper.javaClass.simpleName");
        TAG = simpleName;
    }

    private f() {
    }

    public final com.baidu.swan.apps.a.a TF() {
        return bIN;
    }

    public final com.baidu.swan.apps.a.c TG() {
        return bIO;
    }

    public final boolean TH() {
        return bIP;
    }

    public final void dj(boolean z) {
        bIP = z;
    }

    public final void TI() {
        d.bIL.TB();
        h.bIT.TM();
        db(false);
    }

    public final boolean TJ() {
        if (g.TL() == null) {
            TK();
        }
        Boolean TL = g.TL();
        if (TL == null) {
            q.dMa();
        }
        return TL.booleanValue();
    }

    public final void db(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("status", z);
        DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), c.class, bundle);
    }

    private final void TK() {
        boolean z;
        try {
            Class.forName("com.baidu.sapi2.SapiAccountManager");
            z = false;
        } catch (ClassNotFoundException e) {
            z = true;
        }
        g.c(Boolean.valueOf(z));
    }
}
