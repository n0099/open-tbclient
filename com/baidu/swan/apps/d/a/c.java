package com.baidu.swan.apps.d.a;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
/* loaded from: classes9.dex */
public class c extends ProviderDelegation {
    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(Bundle bundle) {
        boolean z;
        if (bundle == null) {
            z = false;
        } else {
            z = bundle.getBoolean("status");
        }
        com.baidu.swan.apps.a.c amW = f.cGI.amW();
        if (amW != null) {
            amW.eI(z);
            return null;
        }
        return null;
    }
}
