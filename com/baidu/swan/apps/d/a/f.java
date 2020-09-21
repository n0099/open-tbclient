package com.baidu.swan.apps.d.a;

import android.os.Bundle;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes3.dex */
public final class f {
    private static final String TAG;
    private static com.baidu.swan.apps.a.a bVU;
    private static com.baidu.swan.apps.a.c bVV;
    private static boolean bVW;
    public static final f bVX = new f();

    static {
        String simpleName = bVX.getClass().getSimpleName();
        q.l((Object) simpleName, "SwanAppAllianceLoginHelper.javaClass.simpleName");
        TAG = simpleName;
    }

    private f() {
    }

    public final com.baidu.swan.apps.a.a acf() {
        return bVU;
    }

    public final com.baidu.swan.apps.a.c acg() {
        return bVV;
    }

    public final boolean ach() {
        return bVW;
    }

    public final void dz(boolean z) {
        bVW = z;
    }

    public final void aci() {
        d.bVS.acb();
        h.bWa.acm();
        dq(false);
    }

    public final boolean acj() {
        if (g.acl() == null) {
            ack();
        }
        Boolean acl = g.acl();
        if (acl == null) {
            q.ekp();
        }
        return acl.booleanValue();
    }

    public final void dq(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("status", z);
        DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), c.class, bundle);
    }

    private final void ack() {
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
