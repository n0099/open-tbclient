package com.baidu.swan.apps.view;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.swan.apps.core.h.d;
import com.baidu.swan.apps.core.h.e;
/* loaded from: classes2.dex */
public class c extends d {
    public c(Context context) {
        super(context);
        a(new b());
        a(new a());
        this.anZ.setOnWebViewHookHandler(this);
    }

    @Override // com.baidu.swan.apps.core.h.d, com.baidu.swan.apps.core.h.c, com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public void loadUrl(String str) {
        this.asS = MI();
        super.loadUrl(str);
    }

    protected boolean MI() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.b, com.baidu.swan.apps.core.container.c
    public void xw() {
        if (this.asO != null) {
            this.asO.goBack();
        }
    }

    /* loaded from: classes2.dex */
    private class b extends d.C0106d {
        private b() {
            super();
        }

        @Override // com.baidu.swan.apps.core.h.d.C0106d, android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return (c.this.asO != null && c.this.asO.ea(str)) || e.ad(webView.getContext(), str);
        }
    }

    /* loaded from: classes2.dex */
    class a extends WebChromeClient {
        a() {
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            if (c.this.asO != null) {
                c.this.asO.dl(str);
            }
        }
    }
}
