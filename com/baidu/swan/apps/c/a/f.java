package com.baidu.swan.apps.c.a;

import android.os.Bundle;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes7.dex */
public final class f {
    private static final String TAG;
    private static com.baidu.swan.apps.a.a bOr;
    private static com.baidu.swan.apps.a.c bOs;
    private static boolean bOt;
    public static final f bOu = new f();

    static {
        String simpleName = bOu.getClass().getSimpleName();
        q.l((Object) simpleName, "SwanAppAllianceLoginHelper.javaClass.simpleName");
        TAG = simpleName;
    }

    private f() {
    }

    public final com.baidu.swan.apps.a.a Vq() {
        return bOr;
    }

    public final com.baidu.swan.apps.a.c Vr() {
        return bOs;
    }

    public final boolean Vs() {
        return bOt;
    }

    public final void dr(boolean z) {
        bOt = z;
    }

    public final void Vt() {
        d.bOp.Vm();
        h.bOx.Vx();
        dj(false);
    }

    public final boolean Vu() {
        if (g.Vw() == null) {
            Vv();
        }
        Boolean Vw = g.Vw();
        if (Vw == null) {
            q.dUg();
        }
        return Vw.booleanValue();
    }

    public final void dj(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("status", z);
        DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), c.class, bundle);
    }

    private final void Vv() {
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
