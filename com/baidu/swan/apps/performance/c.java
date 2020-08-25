package com.baidu.swan.apps.performance;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
/* loaded from: classes8.dex */
public class c extends ProviderDelegation {
    private static long cGe = -1;

    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putLong("result", com.baidu.swan.apps.t.a.aoV().ZH());
        return bundle2;
    }

    public static long avu() {
        if (cGe >= 0) {
            return cGe;
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(com.baidu.swan.apps.t.a.aoJ(), c.class, null);
        cGe = callOnMainWithContentProvider.isOk() ? callOnMainWithContentProvider.mResult.getLong("result", 0L) : 0L;
        return cGe;
    }
}
