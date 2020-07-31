package com.baidu.swan.apps.storage.c;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
/* loaded from: classes7.dex */
public abstract class d extends ProviderDelegation {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    protected abstract Bundle a(c cVar);

    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public final Bundle execCall(Bundle bundle) {
        if (bundle.isEmpty()) {
            return Bundle.EMPTY;
        }
        return a(c.W(bundle));
    }
}
