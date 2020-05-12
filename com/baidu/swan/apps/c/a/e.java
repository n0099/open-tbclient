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
    private static com.baidu.swan.apps.a.a bAR;
    private static com.baidu.swan.apps.a.c bAS;
    private static boolean bAT;
    public static final e bAU = new e();

    static {
        String simpleName = bAU.getClass().getSimpleName();
        q.i(simpleName, "SwanAppAllianceLoginHelper.javaClass.simpleName");
        TAG = simpleName;
    }

    private e() {
    }

    public final com.baidu.swan.apps.a.a QZ() {
        return bAR;
    }

    public final com.baidu.swan.apps.a.c Ra() {
        return bAS;
    }

    public final boolean Rb() {
        return bAT;
    }

    public final void cW(boolean z) {
        bAT = z;
    }

    public final boolean isLogin() {
        if (f.Rf() == null) {
            Re();
        }
        if (q.k(f.Rf(), false)) {
            return false;
        }
        String Ri = g.bAX.Ri();
        if (!(Ri == null || l.isBlank(Ri))) {
            String uid = h.bAZ.getUid();
            if (!(uid == null || l.isBlank(uid))) {
                return true;
            }
        }
        return false;
    }

    public final void Rc() {
        g.bAX.Rj();
        h.bAZ.Rm();
        cP(false);
    }

    public final boolean Rd() {
        if (f.Rf() == null) {
            Re();
        }
        Boolean Rf = f.Rf();
        if (Rf == null) {
            q.dDS();
        }
        return Rf.booleanValue();
    }

    public final void cP(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("status", z);
        DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), c.class, bundle);
    }

    private final void Re() {
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
