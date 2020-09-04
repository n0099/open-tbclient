package com.baidu.swan.bdprivate.a;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
/* loaded from: classes3.dex */
public class i extends ProviderDelegation {
    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        aa df = a.df(getAgent().getContext());
        bundle2.putString("NICK_NAME", df.displayName);
        bundle2.putString("AVATAR_URL", df.aYm);
        return bundle2;
    }
}
