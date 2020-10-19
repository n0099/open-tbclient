package com.baidu.swan.apps.d.a;

import android.os.Bundle;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes10.dex */
public final class f {
    private static final String TAG;
    private static com.baidu.swan.apps.a.a cij;
    private static com.baidu.swan.apps.a.c cik;
    private static boolean cil;
    public static final f cim = new f();

    static {
        String simpleName = cim.getClass().getSimpleName();
        q.m(simpleName, "SwanAppAllianceLoginHelper.javaClass.simpleName");
        TAG = simpleName;
    }

    private f() {
    }

    public final com.baidu.swan.apps.a.a aeR() {
        return cij;
    }

    public final com.baidu.swan.apps.a.c aeS() {
        return cik;
    }

    public final boolean aeT() {
        return cil;
    }

    public final void dV(boolean z) {
        cil = z;
    }

    public final void aeU() {
        d.cih.aeN();
        h.cip.aeY();
        dM(false);
    }

    public final boolean aeV() {
        if (g.aeX() == null) {
            aeW();
        }
        Boolean aeX = g.aeX();
        if (aeX == null) {
            q.eob();
        }
        return aeX.booleanValue();
    }

    public final void dM(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("status", z);
        DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), c.class, bundle);
    }

    private final void aeW() {
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
