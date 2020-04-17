package com.baidu.swan.bdprivate.a;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
/* loaded from: classes11.dex */
public class h extends ProviderDelegation {
    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        z cR = a.cR(getAgent().getContext());
        bundle2.putString("NICK_NAME", cR.displayName);
        bundle2.putString("AVATAR_URL", cR.aJi);
        return bundle2;
    }
}
