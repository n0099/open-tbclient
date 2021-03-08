package com.baidu.swan.bdprivate.a;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
/* loaded from: classes8.dex */
public class i extends ProviderDelegation {
    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        aa eg = a.eg(getAgent().getContext());
        bundle2.putString("NICK_NAME", eg.displayName);
        bundle2.putString("AVATAR_URL", eg.aWJ);
        return bundle2;
    }
}
