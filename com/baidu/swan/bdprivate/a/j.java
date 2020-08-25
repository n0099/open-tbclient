package com.baidu.swan.bdprivate.a;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class j extends ProviderDelegation {
    j() {
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("result", a.isLogin(getAgent().getContext()));
        return bundle2;
    }
}
