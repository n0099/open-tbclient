package com.baidu.browser.sailor.webkit.loader;

import android.support.annotation.Keep;
/* loaded from: classes2.dex */
public interface IWebkitLoaderListener {
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
