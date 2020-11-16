package com.baidu.swan.apps.d.a;

import android.os.Bundle;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes7.dex */
public final class f {
    private static final String TAG;
    private static com.baidu.swan.apps.a.a cuX;
    private static com.baidu.swan.apps.a.c cuY;
    private static boolean cuZ;
    public static final f cva = new f();

    static {
        String simpleName = cva.getClass().getSimpleName();
        q.m(simpleName, "SwanAppAllianceLoginHelper.javaClass.simpleName");
        TAG = simpleName;
    }

    private f() {
    }

    public final com.baidu.swan.apps.a.a aiD() {
        return cuX;
    }

    public final com.baidu.swan.apps.a.c aiE() {
        return cuY;
    }

    public final boolean aiF() {
        return cuZ;
    }

    public final void eu(boolean z) {
        cuZ = z;
    }

    public final void aiG() {
        d.cuV.aiz();
        h.cvd.aiK();
        el(false);
    }

    public final boolean aiH() {
        if (g.aiJ() == null) {
            aiI();
        }
        Boolean aiJ = g.aiJ();
        if (aiJ == null) {
            q.eBQ();
        }
        return aiJ.booleanValue();
    }

    public final void el(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("status", z);
        DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), c.class, bundle);
    }

    private final void aiI() {
        boolean z;
        try {
            Class.forName("com.baidu.sapi2.SapiAccountManager");
            z = false;
        } catch (ClassNotFoundException e) {
            z = true;
        }
        g.d(Boolean.valueOf(z));
    }
}
