package com.baidu.swan.apps.c.a;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
/* loaded from: classes10.dex */
public class c extends ProviderDelegation {
    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(Bundle bundle) {
        boolean z;
        if (bundle == null) {
            z = false;
        } else {
            z = bundle.getBoolean("status");
        }
        com.baidu.swan.apps.a.c GV = e.aYc.GV();
        if (GV != null) {
            GV.bK(z);
            return null;
        }
        return null;
    }
}
