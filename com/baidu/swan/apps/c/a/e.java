package com.baidu.swan.apps.c.a;

import android.os.Bundle;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import kotlin.jvm.internal.q;
import kotlin.text.l;
@kotlin.h
/* loaded from: classes11.dex */
public final class e {
    private static final String TAG;
    private static com.baidu.swan.apps.a.a bcj;
    private static com.baidu.swan.apps.a.c bck;
    private static boolean bcl;
    public static final e bcm = new e();

    static {
        String simpleName = bcm.getClass().getSimpleName();
        q.i(simpleName, "SwanAppAllianceLoginHelper.javaClass.simpleName");
        TAG = simpleName;
    }

    private e() {
    }

    public final com.baidu.swan.apps.a.a Jj() {
        return bcj;
    }

    public final com.baidu.swan.apps.a.c Jk() {
        return bck;
    }

    public final boolean Jl() {
        return bcl;
    }

    public final void bZ(boolean z) {
        bcl = z;
    }

    public final boolean isLogin() {
        if (f.Jp() == null) {
            Jo();
        }
        if (q.h(f.Jp(), false)) {
            return false;
        }
        String Js = g.bcp.Js();
        if (!(Js == null || l.isBlank(Js))) {
            String uid = h.bcr.getUid();
            if (!(uid == null || l.isBlank(uid))) {
                return true;
            }
        }
        return false;
    }

    public final void Jm() {
        g.bcp.Jt();
        h.bcr.Jw();
        bS(false);
    }

    public final boolean Jn() {
        if (f.Jp() == null) {
            Jo();
        }
        Boolean Jp = f.Jp();
        if (Jp == null) {
            q.dKt();
        }
        return Jp.booleanValue();
    }

    public final void bS(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("status", z);
        DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), c.class, bundle);
    }

    private final void Jo() {
        boolean z;
        try {
            Class.forName("com.baidu.sapi2.SapiAccountManager");
            z = false;
        } catch (ClassNotFoundException e) {
            z = true;
        }
        f.c(Boolean.valueOf(z));
    }
}
