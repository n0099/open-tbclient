package com.baidu.browser.sailor.webkit.loader;

import android.support.annotation.Keep;
import com.baidu.browser.core.INoProGuard;
/* loaded from: classes11.dex */
public interface IWebkitLoaderListener extends INoProGuard {
    @Keep
    void onInstallZeusSDKFailed(byte b, String str);

    @Keep
    void onInstallZeusSDKSuccess(byte b);

    @Keep
    void onLoadSysSDKFailed();

    @Keep
    void onLoadSysSDKSuccess();

    @Keep
    void onLoadZeusSDKFailed();

    @Keep
    void onLoadZeusSDKSuccess();
}
