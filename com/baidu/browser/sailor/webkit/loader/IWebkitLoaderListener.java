package com.baidu.browser.sailor.webkit.loader;

import com.baidu.browser.core.INoProGuard;
/* loaded from: classes.dex */
public interface IWebkitLoaderListener extends INoProGuard {
    void onInstallZeusSDKFailed(byte b, String str);

    void onInstallZeusSDKSuccess(byte b);

    void onLoadSysSDKFailed();

    void onLoadSysSDKSuccess();

    void onLoadZeusSDKFailed();

    void onLoadZeusSDKSuccess();
}
