package com.baidu.swan.apps.c.a;

import android.os.Bundle;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import kotlin.jvm.internal.p;
import kotlin.text.l;
/* loaded from: classes9.dex */
public final class e {
    private static final String TAG;
    private static com.baidu.swan.apps.a.a aXh;
    private static com.baidu.swan.apps.a.c aXi;
    private static boolean aXj;
    public static final e aXk = new e();

    static {
        String simpleName = aXk.getClass().getSimpleName();
        p.i(simpleName, "SwanAppAllianceLoginHelper.javaClass.simpleName");
        TAG = simpleName;
    }

    private e() {
    }

    public final com.baidu.swan.apps.a.a Gy() {
        return aXh;
    }

    public final com.baidu.swan.apps.a.c Gz() {
        return aXi;
    }

    public final boolean GA() {
        return aXj;
    }

    public final void bM(boolean z) {
        aXj = z;
    }

    public final boolean isLogin() {
        if (f.GE() == null) {
            GD();
        }
        if (p.h(f.GE(), false)) {
            return false;
        }
        String GH = g.aXn.GH();
        if (!(GH == null || l.isBlank(GH))) {
            String uid = h.aXp.getUid();
            if (!(uid == null || l.isBlank(uid))) {
                return true;
            }
        }
        return false;
    }

    public final void GB() {
        g.aXn.GI();
        h.aXp.GL();
        bF(false);
    }

    public final boolean GC() {
        if (f.GE() == null) {
            GD();
        }
        Boolean GE = f.GE();
        if (GE == null) {
            p.dER();
        }
        return GE.booleanValue();
    }

    public final void bF(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("status", z);
        DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), c.class, bundle);
    }

    private final void GD() {
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
