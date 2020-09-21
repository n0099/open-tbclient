package com.baidu.swan.apps.performance;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
/* loaded from: classes3.dex */
public class c extends ProviderDelegation {
    private static long cIi = -1;

    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putLong("result", com.baidu.swan.apps.t.a.apG().aaq());
        return bundle2;
    }

    public static long awd() {
        if (cIi >= 0) {
            return cIi;
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(com.baidu.swan.apps.t.a.apu(), c.class, null);
        cIi = callOnMainWithContentProvider.isOk() ? callOnMainWithContentProvider.mResult.getLong("result", 0L) : 0L;
        return cIi;
    }
}
