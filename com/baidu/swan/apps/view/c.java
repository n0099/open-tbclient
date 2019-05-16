package com.baidu.swan.apps.view;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.swan.apps.core.i.d;
import com.baidu.swan.apps.core.i.e;
/* loaded from: classes2.dex */
public class c extends d {
    public c(Context context) {
        super(context);
        a(new b());
        a(new a());
        this.aor.setOnWebViewHookHandler(this);
    }

    @Override // com.baidu.swan.apps.core.i.d, com.baidu.swan.apps.core.i.c, com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public void loadUrl(String str) {
        this.atm = Pp();
        super.loadUrl(str);
    }

    protected boolean Pp() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.b, com.baidu.swan.apps.core.container.c
    public void yn() {
        if (this.ati != null) {
            this.ati.goBack();
        }
    }

    /* loaded from: classes2.dex */
    private class b extends d.C0138d {
        private b() {
            super();
        }

        @Override // com.baidu.swan.apps.core.i.d.C0138d, android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return (c.this.ati != null && c.this.ati.dQ(str)) || e.P(webView.getContext(), str);
        }
    }

    /* loaded from: classes2.dex */
    class a extends WebChromeClient {
        a() {
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            if (c.this.ati != null) {
                c.this.ati.da(str);
            }
        }
    }
}
