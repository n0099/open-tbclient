package com.baidu.swan.bdprivate.a;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
/* loaded from: classes3.dex */
public class i extends ProviderDelegation {
    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        aa de2 = a.de(getAgent().getContext());
        bundle2.putString("NICK_NAME", de2.displayName);
        bundle2.putString("AVATAR_URL", de2.baJ);
        return bundle2;
    }
}
