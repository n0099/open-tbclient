package com.baidu.swan.apps.c.a;

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
        com.baidu.swan.apps.a.c Vr = f.bOu.Vr();
        if (Vr != null) {
            Vr.dj(z);
            return null;
        }
        return null;
    }
}
