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
    private static boolean bcA;
    public static final e bcB = new e();
    private static com.baidu.swan.apps.a.a bcy;
    private static com.baidu.swan.apps.a.c bcz;

    static {
        String simpleName = bcB.getClass().getSimpleName();
        q.i(simpleName, "SwanAppAllianceLoginHelper.javaClass.simpleName");
        TAG = simpleName;
    }

    private e() {
    }

    public final com.baidu.swan.apps.a.a Jo() {
        return bcy;
    }

    public final com.baidu.swan.apps.a.c Jp() {
        return bcz;
    }

    public final boolean Jq() {
        return bcA;
    }

    public final void ca(boolean z) {
        bcA = z;
    }

    public final boolean isLogin() {
        if (f.Ju() == null) {
            Jt();
        }
        if (q.h(f.Ju(), false)) {
            return false;
        }
        String Jx = g.bcE.Jx();
        if (!(Jx == null || l.isBlank(Jx))) {
            String uid = h.bcG.getUid();
            if (!(uid == null || l.isBlank(uid))) {
                return true;
            }
        }
        return false;
    }

    public final void Jr() {
        g.bcE.Jy();
        h.bcG.JB();
        bT(false);
    }

    public final boolean Js() {
        if (f.Ju() == null) {
            Jt();
        }
        Boolean Ju = f.Ju();
        if (Ju == null) {
            q.dKW();
        }
        return Ju.booleanValue();
    }

    public final void bT(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("status", z);
        DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), c.class, bundle);
    }

    private final void Jt() {
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
