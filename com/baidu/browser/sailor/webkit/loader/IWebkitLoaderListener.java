package com.baidu.browser.sailor.webkit.loader;

import androidx.annotation.Keep;
import com.baidu.browser.core.INoProGuard;
/* loaded from: classes10.dex */
public interface IWebkitLoaderListener extends INoProGuard {
    @Keep
    void onInstallZeusSDKFailed(byte b2, String str);

    @Keep
    void onInstallZeusSDKSuccess(byte b2);

    @Keep
    void onLoadSysSDKFailed();

    @Keep
    void onLoadSysSDKSuccess();

    @Keep
    void onLoadZeusSDKFailed();

    @Keep
    void onLoadZeusSDKSuccess();
}
