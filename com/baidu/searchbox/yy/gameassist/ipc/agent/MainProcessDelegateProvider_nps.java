package com.baidu.searchbox.yy.gameassist.ipc.agent;

import com.baidu.nps.stub.component.NPSProvider;
import com.baidu.searchbox.live.gameassist.host.BuildConfig;
/* loaded from: classes4.dex */
public class MainProcessDelegateProvider_nps extends NPSProvider {
    public String getPackageName() {
        return BuildConfig.LIBRARY_PACKAGE_NAME;
    }

    @Override // com.baidu.nps.stub.component.NPSProvider, android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }
}
