package com.baidu.searchbox.ng.ai.apps.core.container.init;

import android.support.annotation.NonNull;
import com.baidu.browser.sailor.webkit.loader.IWebkitLoaderListener;
/* loaded from: classes2.dex */
public class InitListenerAdapter implements IWebkitLoaderListener {
    private static final boolean DEBUG = false;
    private static final String TAG = "InitListenerAdapter";
    private NgWebViewInitListener mListener;

    public InitListenerAdapter(@NonNull NgWebViewInitListener ngWebViewInitListener) {
        this.mListener = ngWebViewInitListener;
    }

    @Override // com.baidu.browser.sailor.webkit.loader.IWebkitLoaderListener
    public void onLoadSysSDKSuccess() {
        this.mListener.onInitFinished();
    }

    @Override // com.baidu.browser.sailor.webkit.loader.IWebkitLoaderListener
    public void onLoadSysSDKFailed() {
        this.mListener.onInitFinished();
    }

    @Override // com.baidu.browser.sailor.webkit.loader.IWebkitLoaderListener
    public void onLoadZeusSDKSuccess() {
        this.mListener.onInitFinished();
    }

    @Override // com.baidu.browser.sailor.webkit.loader.IWebkitLoaderListener
    public void onLoadZeusSDKFailed() {
        this.mListener.onInitFinished();
    }

    @Override // com.baidu.browser.sailor.webkit.loader.IWebkitLoaderListener
    public void onInstallZeusSDKSuccess(byte b) {
    }

    @Override // com.baidu.browser.sailor.webkit.loader.IWebkitLoaderListener
    public void onInstallZeusSDKFailed(byte b, String str) {
    }
}
