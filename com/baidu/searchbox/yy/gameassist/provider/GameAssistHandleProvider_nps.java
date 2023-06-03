package com.baidu.searchbox.yy.gameassist.provider;

import com.baidu.nps.stub.component.NPSProvider;
import com.baidu.searchbox.live.gameassist.host.BuildConfig;
/* loaded from: classes4.dex */
public class GameAssistHandleProvider_nps extends NPSProvider {
    public String getPackageName() {
        return BuildConfig.LIBRARY_PACKAGE_NAME;
    }

    @Override // com.baidu.nps.stub.component.NPSProvider, android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }
}
