package com.baidu.swan.bdprivate.a;

import android.os.Bundle;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class i extends ProviderDelegation {
    i() {
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putString("result", a.getZid(AppRuntime.getAppContext()));
        return bundle2;
    }
}
