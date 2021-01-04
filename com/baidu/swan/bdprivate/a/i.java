package com.baidu.swan.bdprivate.a;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
/* loaded from: classes9.dex */
public class i extends ProviderDelegation {
    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        aa ej = a.ej(getAgent().getContext());
        bundle2.putString("NICK_NAME", ej.displayName);
        bundle2.putString("AVATAR_URL", ej.aWS);
        return bundle2;
    }
}
