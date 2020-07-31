package com.baidu.swan.apps.performance;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
/* loaded from: classes7.dex */
public class c extends ProviderDelegation {
    private static long cyk = -1;

    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putLong("result", com.baidu.swan.apps.t.a.ahv().TH());
        return bundle2;
    }

    public static long anz() {
        if (cyk >= 0) {
            return cyk;
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(com.baidu.swan.apps.t.a.ahj(), c.class, null);
        cyk = callOnMainWithContentProvider.isOk() ? callOnMainWithContentProvider.mResult.getLong("result", 0L) : 0L;
        return cyk;
    }
}
