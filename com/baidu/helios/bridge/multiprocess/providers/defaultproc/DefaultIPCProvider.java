package com.baidu.helios.bridge.multiprocess.providers.defaultproc;

import com.baidu.helios.bridge.multiprocess.BaseIPCProvider;
/* loaded from: classes2.dex */
public class DefaultIPCProvider extends BaseIPCProvider {
    @Override // com.baidu.helios.bridge.multiprocess.BaseIPCProvider
    public String getAuthoritySuffix() {
        return ".helios.ipc.default";
    }
}
