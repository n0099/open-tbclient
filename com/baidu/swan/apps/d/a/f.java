package com.baidu.swan.apps.d.a;

import android.os.Bundle;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes9.dex */
public final class f {
    private static final String TAG;
    private static com.baidu.swan.apps.a.a cGF;
    private static com.baidu.swan.apps.a.c cGG;
    private static boolean cGH;
    public static final f cGI = new f();

    static {
        String simpleName = cGI.getClass().getSimpleName();
        p.n(simpleName, "SwanAppAllianceLoginHelper.javaClass.simpleName");
        TAG = simpleName;
    }

    private f() {
    }

    public final com.baidu.swan.apps.a.a amV() {
        return cGF;
    }

    public final com.baidu.swan.apps.a.c amW() {
        return cGG;
    }

    public final boolean amX() {
        return cGH;
    }

    public final void eS(boolean z) {
        cGH = z;
    }

    public final void amY() {
        d.cGD.amR();
        h.cGL.anc();
        eI(false);
    }

    public final boolean amZ() {
        if (g.anb() == null) {
            ana();
        }
        Boolean anb = g.anb();
        if (anb == null) {
            p.eMi();
        }
        return anb.booleanValue();
    }

    public final void eI(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("status", z);
        DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), c.class, bundle);
    }

    private final void ana() {
        boolean z;
        try {
            Class.forName("com.baidu.sapi2.SapiAccountManager");
            z = false;
        } catch (ClassNotFoundException e) {
            z = true;
        }
        g.e(Boolean.valueOf(z));
    }
}
