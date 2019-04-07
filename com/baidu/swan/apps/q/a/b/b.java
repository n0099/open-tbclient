package com.baidu.swan.apps.q.a.b;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
/* loaded from: classes4.dex */
public class b extends ProviderDelegation {
    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(@NonNull Bundle bundle) {
        int i = bundle.getInt("type");
        CookieManager Dn = com.baidu.tieba.aiapps.apps.a.a.Dn();
        String string = bundle.getString("param1");
        Bundle bundle2 = new Bundle();
        switch (i) {
            case 1:
                bundle2.putBoolean("result", Dn.shouldAcceptCookie(string, bundle.getString("param2")));
                break;
            case 2:
                bundle2.putBoolean("result", Dn.shouldSendCookie(string, bundle.getString("param2")));
                break;
            case 3:
                Dn.storeCookie(string, bundle.getStringArrayList("param2"));
                break;
            case 4:
                bundle2.putString("result", Dn.getCookie(string));
                break;
        }
        return bundle2;
    }
}
