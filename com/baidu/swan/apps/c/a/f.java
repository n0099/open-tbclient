package com.baidu.swan.apps.c.a;

import android.os.Bundle;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes11.dex */
public final class f {
    private static final String TAG;
    private static com.baidu.swan.apps.a.a bNB;
    private static com.baidu.swan.apps.a.c bNC;
    private static boolean bND;
    public static final f bNE = new f();

    static {
        String simpleName = bNE.getClass().getSimpleName();
        q.l((Object) simpleName, "SwanAppAllianceLoginHelper.javaClass.simpleName");
        TAG = simpleName;
    }

    private f() {
    }

    public final com.baidu.swan.apps.a.a UL() {
        return bNB;
    }

    public final com.baidu.swan.apps.a.c UM() {
        return bNC;
    }

    public final boolean UN() {
        return bND;
    }

    /* renamed from: do  reason: not valid java name */
    public final void m26do(boolean z) {
        bND = z;
    }

    public final void UO() {
        d.bNz.UH();
        h.bNH.US();
        dg(false);
    }

    public final boolean UP() {
        if (g.UR() == null) {
            UQ();
        }
        Boolean UR = g.UR();
        if (UR == null) {
            q.dQG();
        }
        return UR.booleanValue();
    }

    public final void dg(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("status", z);
        DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), c.class, bundle);
    }

    private final void UQ() {
        boolean z;
        try {
            Class.forName("com.baidu.sapi2.SapiAccountManager");
            z = false;
        } catch (ClassNotFoundException e) {
            z = true;
        }
        g.c(Boolean.valueOf(z));
    }
}
