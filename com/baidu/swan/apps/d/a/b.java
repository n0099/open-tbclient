package com.baidu.swan.apps.d.a;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
/* loaded from: classes10.dex */
public class b extends ProviderDelegation {
    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(Bundle bundle) {
        a.X(getAgent().getContext(), bundle.getString("bduss"));
        return null;
    }
}
