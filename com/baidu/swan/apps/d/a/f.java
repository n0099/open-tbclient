package com.baidu.swan.apps.d.a;

import android.os.Bundle;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes10.dex */
public final class f {
    private static final String TAG;
    private static com.baidu.swan.apps.a.a cqJ;
    private static com.baidu.swan.apps.a.c cqK;
    private static boolean cqL;
    public static final f cqM = new f();

    static {
        String simpleName = cqM.getClass().getSimpleName();
        q.m(simpleName, "SwanAppAllianceLoginHelper.javaClass.simpleName");
        TAG = simpleName;
    }

    private f() {
    }

    public final com.baidu.swan.apps.a.a agL() {
        return cqJ;
    }

    public final com.baidu.swan.apps.a.c agM() {
        return cqK;
    }

    public final boolean agN() {
        return cqL;
    }

    public final void ei(boolean z) {
        cqL = z;
    }

    public final void agO() {
        d.cqH.agH();
        h.cqP.agS();
        dZ(false);
    }

    public final boolean agP() {
        if (g.agR() == null) {
            agQ();
        }
        Boolean agR = g.agR();
        if (agR == null) {
            q.eya();
        }
        return agR.booleanValue();
    }

    public final void dZ(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("status", z);
        DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), c.class, bundle);
    }

    private final void agQ() {
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
