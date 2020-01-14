package com.baidu.swan.apps.c.a;

import android.os.Bundle;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import kotlin.jvm.internal.q;
import kotlin.text.l;
/* loaded from: classes10.dex */
public final class e {
    private static final String TAG;
    private static com.baidu.swan.apps.a.a aXZ;
    private static com.baidu.swan.apps.a.c aYa;
    private static boolean aYb;
    public static final e aYc = new e();

    static {
        String simpleName = aYc.getClass().getSimpleName();
        q.i(simpleName, "SwanAppAllianceLoginHelper.javaClass.simpleName");
        TAG = simpleName;
    }

    private e() {
    }

    public final com.baidu.swan.apps.a.a GU() {
        return aXZ;
    }

    public final com.baidu.swan.apps.a.c GV() {
        return aYa;
    }

    public final boolean GW() {
        return aYb;
    }

    public final void bR(boolean z) {
        aYb = z;
    }

    public final boolean isLogin() {
        if (f.Ha() == null) {
            GZ();
        }
        if (q.h(f.Ha(), false)) {
            return false;
        }
        String Hd = g.aYf.Hd();
        if (!(Hd == null || l.isBlank(Hd))) {
            String uid = h.aYh.getUid();
            if (!(uid == null || l.isBlank(uid))) {
                return true;
            }
        }
        return false;
    }

    public final void GX() {
        g.aYf.He();
        h.aYh.Hh();
        bK(false);
    }

    public final boolean GY() {
        if (f.Ha() == null) {
            GZ();
        }
        Boolean Ha = f.Ha();
        if (Ha == null) {
            q.dJm();
        }
        return Ha.booleanValue();
    }

    public final void bK(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("status", z);
        DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), c.class, bundle);
    }

    private final void GZ() {
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
