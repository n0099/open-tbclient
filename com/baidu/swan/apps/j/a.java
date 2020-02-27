package com.baidu.swan.apps.j;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
/* loaded from: classes11.dex */
public class a extends ProviderDelegation {
    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(@NonNull Bundle bundle) {
        int i = bundle.getInt("type");
        c cVar = new c();
        String string = bundle.getString("param1");
        Bundle bundle2 = new Bundle();
        switch (i) {
            case 1:
                bundle2.putBoolean("result", cVar.shouldAcceptCookie(string, bundle.getString("param2")));
                break;
            case 2:
                bundle2.putBoolean("result", cVar.shouldSendCookie(string, bundle.getString("param2")));
                break;
            case 3:
                cVar.storeCookie(string, bundle.getStringArrayList("param2"));
                break;
            case 4:
                bundle2.putString("result", cVar.getCookie(string));
                break;
        }
        return bundle2;
    }
}
