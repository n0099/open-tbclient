package com.baidu.swan.apps.c.a;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
/* loaded from: classes11.dex */
public class b extends ProviderDelegation {
    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(Bundle bundle) {
        a.N(getAgent().getContext(), bundle.getString("bduss"));
        return null;
    }
}
