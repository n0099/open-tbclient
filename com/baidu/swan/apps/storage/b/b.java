package com.baidu.swan.apps.storage.b;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
/* loaded from: classes2.dex */
public abstract class b extends ProviderDelegation {
    public static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;

    protected abstract Bundle a(a aVar);

    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public final Bundle execCall(Bundle bundle) {
        if (bundle.isEmpty()) {
            return Bundle.EMPTY;
        }
        return a(a.x(bundle));
    }
}
