package com.baidu.swan.veloce;

import android.os.Bundle;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
/* loaded from: classes11.dex */
public class c extends ProviderDelegation {
    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(Bundle bundle) {
        try {
            return AppRuntime.getAppContext().getContentResolver().call(VeloceAppIpcProvider.cFL, VeloceAppIpcProvider.cFO, (String) null, bundle);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
