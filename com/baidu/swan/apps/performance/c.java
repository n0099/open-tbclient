package com.baidu.swan.apps.performance;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
/* loaded from: classes25.dex */
public class c extends ProviderDelegation {
    private static long dnY = -1;

    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putLong("result", com.baidu.swan.apps.t.a.azm().ajW());
        return bundle2;
    }

    public static long aFJ() {
        if (dnY >= 0) {
            return dnY;
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(com.baidu.swan.apps.t.a.aza(), c.class, null);
        dnY = callOnMainWithContentProvider.isOk() ? callOnMainWithContentProvider.mResult.getLong("result", 0L) : 0L;
        return dnY;
    }
}
