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
    private static com.baidu.swan.apps.a.a bAM;
    private static com.baidu.swan.apps.a.c bAN;
    private static boolean bAO;
    public static final e bAP = new e();

    static {
        String simpleName = bAP.getClass().getSimpleName();
        q.i(simpleName, "SwanAppAllianceLoginHelper.javaClass.simpleName");
        TAG = simpleName;
    }

    private e() {
    }

    public final com.baidu.swan.apps.a.a Ra() {
        return bAM;
    }

    public final com.baidu.swan.apps.a.c Rb() {
        return bAN;
    }

    public final boolean Rc() {
        return bAO;
    }

    public final void cW(boolean z) {
        bAO = z;
    }

    public final boolean isLogin() {
        if (f.Rg() == null) {
            Rf();
        }
        if (q.k(f.Rg(), false)) {
            return false;
        }
        String Rj = g.bAS.Rj();
        if (!(Rj == null || l.isBlank(Rj))) {
            String uid = h.bAU.getUid();
            if (!(uid == null || l.isBlank(uid))) {
                return true;
            }
        }
        return false;
    }

    public final void Rd() {
        g.bAS.Rk();
        h.bAU.Rn();
        cP(false);
    }

    public final boolean Re() {
        if (f.Rg() == null) {
            Rf();
        }
        Boolean Rg = f.Rg();
        if (Rg == null) {
            q.dDV();
        }
        return Rg.booleanValue();
    }

    public final void cP(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("status", z);
        DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), c.class, bundle);
    }

    private final void Rf() {
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
