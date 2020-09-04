package com.baidu.swan.apps.d.a;

import android.os.Bundle;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes8.dex */
public final class f {
    private static final String TAG;
    private static com.baidu.swan.apps.a.a bTT;
    private static com.baidu.swan.apps.a.c bTU;
    private static boolean bTV;
    public static final f bTW = new f();

    static {
        String simpleName = bTW.getClass().getSimpleName();
        q.l((Object) simpleName, "SwanAppAllianceLoginHelper.javaClass.simpleName");
        TAG = simpleName;
    }

    private f() {
    }

    public final com.baidu.swan.apps.a.a abw() {
        return bTT;
    }

    public final com.baidu.swan.apps.a.c abx() {
        return bTU;
    }

    public final boolean aby() {
        return bTV;
    }

    public final void dB(boolean z) {
        bTV = z;
    }

    public final void abz() {
        d.bTR.abs();
        h.bTZ.abD();
        ds(false);
    }

    public final boolean abA() {
        if (g.abC() == null) {
            abB();
        }
        Boolean abC = g.abC();
        if (abC == null) {
            q.egs();
        }
        return abC.booleanValue();
    }

    public final void ds(boolean z) {
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
