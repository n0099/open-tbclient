package com.baidu.swan.apps.d.a;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
/* loaded from: classes25.dex */
public class c extends ProviderDelegation {
    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(Bundle bundle) {
        boolean z;
        if (bundle == null) {
            z = false;
        } else {
            z = bundle.getBoolean("status");
        }
        com.baidu.swan.apps.a.c alM = f.cBS.alM();
        if (alM != null) {
            alM.eA(z);
            return null;
        }
        return null;
    }
}
