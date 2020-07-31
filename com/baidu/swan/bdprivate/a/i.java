package com.baidu.swan.bdprivate.a;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
/* loaded from: classes11.dex */
public class i extends ProviderDelegation {
    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        z cZ = a.cZ(getAgent().getContext());
        bundle2.putString("NICK_NAME", cZ.displayName);
        bundle2.putString("AVATAR_URL", cZ.aSW);
        return bundle2;
    }
}
