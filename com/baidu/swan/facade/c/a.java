package com.baidu.swan.facade.c;

import android.os.Bundle;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
/* loaded from: classes20.dex */
public class a extends ProviderDelegation {
    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putString("result", com.baidu.swan.apps.t.a.apC().cb(AppRuntime.getAppContext()));
        return bundle2;
    }
}
