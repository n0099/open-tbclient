package com.baidu.swan.apps.d.a;

import android.os.Bundle;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes8.dex */
public final class f {
    private static final String TAG;
    private static com.baidu.swan.apps.a.a bTP;
    private static com.baidu.swan.apps.a.c bTQ;
    private static boolean bTR;
    public static final f bTS = new f();

    static {
        String simpleName = bTS.getClass().getSimpleName();
        q.l((Object) simpleName, "SwanAppAllianceLoginHelper.javaClass.simpleName");
        TAG = simpleName;
    }

    private f() {
    }

    public final com.baidu.swan.apps.a.a abw() {
        return bTP;
    }

    public final com.baidu.swan.apps.a.c abx() {
        return bTQ;
    }

    public final boolean aby() {
        return bTR;
    }

    public final void dA(boolean z) {
        bTR = z;
    }

    public final void abz() {
        d.bTN.abs();
        h.bTV.abD();
        dr(false);
    }

    public final boolean abA() {
        if (g.abC() == null) {
            abB();
        }
        Boolean abC = g.abC();
        if (abC == null) {
            q.egj();
        }
        return abC.booleanValue();
    }

    public final void dr(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("status", z);
        DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), c.class, bundle);
    }

    private final void abB() {
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
