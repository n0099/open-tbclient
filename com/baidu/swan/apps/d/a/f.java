package com.baidu.swan.apps.d.a;

import android.os.Bundle;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes10.dex */
public final class f {
    private static final String TAG;
    private static com.baidu.swan.apps.a.a cwH;
    private static com.baidu.swan.apps.a.c cwI;
    private static boolean cwJ;
    public static final f cwK = new f();

    static {
        String simpleName = cwK.getClass().getSimpleName();
        q.m(simpleName, "SwanAppAllianceLoginHelper.javaClass.simpleName");
        TAG = simpleName;
    }

    private f() {
    }

    public final com.baidu.swan.apps.a.a ajl() {
        return cwH;
    }

    public final com.baidu.swan.apps.a.c ajm() {
        return cwI;
    }

    public final boolean ajn() {
        return cwJ;
    }

    public final void er(boolean z) {
        cwJ = z;
    }

    public final void ajo() {
        d.cwF.ajh();
        h.cwN.ajs();
        ei(false);
    }

    public final boolean ajp() {
        if (g.ajr() == null) {
            ajq();
        }
        Boolean ajr = g.ajr();
        if (ajr == null) {
            q.eBP();
        }
        return ajr.booleanValue();
    }

    public final void ei(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("status", z);
        DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), c.class, bundle);
    }

    private final void ajq() {
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
