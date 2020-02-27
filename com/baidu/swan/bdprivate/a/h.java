package com.baidu.swan.bdprivate.a;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
/* loaded from: classes11.dex */
public class h extends ProviderDelegation {
    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        z de2 = a.de(getAgent().getContext());
        bundle2.putString("NICK_NAME", de2.displayName);
        bundle2.putString("AVATAR_URL", de2.aqo);
        return bundle2;
    }
}
