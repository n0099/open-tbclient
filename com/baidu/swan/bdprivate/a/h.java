package com.baidu.swan.bdprivate.a;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
/* loaded from: classes10.dex */
public class h extends ProviderDelegation {
    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        z da = a.da(getAgent().getContext());
        bundle2.putString("NICK_NAME", da.displayName);
        bundle2.putString("AVATAR_URL", da.bXf);
        return bundle2;
    }
}
