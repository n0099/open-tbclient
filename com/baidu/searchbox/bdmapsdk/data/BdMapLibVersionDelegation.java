package com.baidu.searchbox.bdmapsdk.data;

import android.os.Bundle;
import com.baidu.searchbox.bdmapsdk.BdMapLibHelper;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
/* loaded from: classes4.dex */
public class BdMapLibVersionDelegation extends ProviderDelegation {
    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putString(BdMapLibHelper.PREF_MAP_LIB_VERSION, BdMapLibHelper.getMapLibVersion());
        return bundle2;
    }
}
