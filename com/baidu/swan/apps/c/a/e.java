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
    private static com.baidu.swan.apps.a.a bcl;
    private static com.baidu.swan.apps.a.c bcm;
    private static boolean bcn;
    public static final e bco = new e();

    static {
        String simpleName = bco.getClass().getSimpleName();
        q.i(simpleName, "SwanAppAllianceLoginHelper.javaClass.simpleName");
        TAG = simpleName;
    }

    private e() {
    }

    public final com.baidu.swan.apps.a.a Jl() {
        return bcl;
    }

    public final com.baidu.swan.apps.a.c Jm() {
        return bcm;
    }

    public final boolean Jn() {
        return bcn;
    }

    public final void bZ(boolean z) {
        bcn = z;
    }

    public final boolean isLogin() {
        if (f.Jr() == null) {
            Jq();
        }
        if (q.h(f.Jr(), false)) {
            return false;
        }
        String Ju = g.bcr.Ju();
        if (!(Ju == null || l.isBlank(Ju))) {
            String uid = h.bct.getUid();
            if (!(uid == null || l.isBlank(uid))) {
                return true;
            }
        }
        return false;
    }

    public final void Jo() {
        g.bcr.Jv();
        h.bct.Jy();
        bS(false);
    }

    public final boolean Jp() {
        if (f.Jr() == null) {
            Jq();
        }
        Boolean Jr = f.Jr();
        if (Jr == null) {
            q.dKw();
        }
        return Jr.booleanValue();
    }

    public final void bS(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("status", z);
        DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), c.class, bundle);
    }

    private final void Jq() {
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
