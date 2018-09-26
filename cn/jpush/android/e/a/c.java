package cn.jpush.android.e.a;

import android.os.Build;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
/* loaded from: classes3.dex */
public class c extends WebChromeClient {
    private final String a = "InjectedChromeClient";
    private d b;
    private boolean c;

    public c(String str, Class cls) {
        this.b = new d(str, cls);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        jsResult.confirm();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (Build.VERSION.SDK_INT < 17) {
            jsPromptResult.confirm(this.b.a(webView, str2));
            return true;
        }
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        webView.getSettings().setSavePassword(false);
        if (Build.VERSION.SDK_INT < 17) {
            if (i <= 25) {
                this.c = false;
            } else if (!this.c) {
                cn.jpush.android.d.f.a("InjectedChromeClient", "Android sdk version lesser than 17, Java—Js interact by injection!");
                webView.loadUrl(this.b.a());
                this.c = true;
            }
        }
        super.onProgressChanged(webView, i);
    }
}
