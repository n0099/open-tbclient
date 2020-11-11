package com.baidu.swan.apps.performance;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
/* loaded from: classes10.dex */
public class c extends ProviderDelegation {
    private static long diH = -1;

    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putLong("result", com.baidu.swan.apps.t.a.awM().ahw());
        return bundle2;
    }

    public static long aDi() {
        if (diH >= 0) {
            return diH;
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(com.baidu.swan.apps.t.a.awA(), c.class, null);
        diH = callOnMainWithContentProvider.isOk() ? callOnMainWithContentProvider.mResult.getLong("result", 0L) : 0L;
        return diH;
    }
}
