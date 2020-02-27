package com.baidu.searchbox.process.ipc.delegate.provider;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.agent.provider.ProcessDelegateBaseProvider;
import com.baidu.searchbox.process.ipc.delegate.Delegation;
/* loaded from: classes11.dex */
public abstract class ProviderDelegation extends Delegation<ProcessDelegateBaseProvider> {
    public abstract Bundle execCall(Bundle bundle);
}
