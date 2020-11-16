package com.baidu.swan.apps.d.a;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
/* loaded from: classes7.dex */
public class c extends ProviderDelegation {
    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(Bundle bundle) {
        boolean z;
        if (bundle == null) {
            z = false;
        } else {
            z = bundle.getBoolean("status");
        }
        com.baidu.swan.apps.a.c aiE = f.cva.aiE();
        if (aiE != null) {
            aiE.el(z);
            return null;
        }
        return null;
    }
}
