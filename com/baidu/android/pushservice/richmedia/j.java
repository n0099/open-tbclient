package com.baidu.android.pushservice.richmedia;

import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
/* loaded from: classes.dex */
class j extends WebChromeClient {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MediaViewActivity f611a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(MediaViewActivity mediaViewActivity) {
        this.f611a = mediaViewActivity;
    }

    @Override // android.webkit.WebChromeClient
    public void onHideCustomView() {
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
    }
}
