package com.baidu.swan.games.view.button.base;

import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.FrameLayout;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.games.view.button.base.a;
/* loaded from: classes10.dex */
public class b extends EventTargetImpl implements a.InterfaceC0546a {
    protected ApiButton eax;
    @V8JavascriptField
    public String image;
    @V8JavascriptField
    public a style;
    @V8JavascriptField
    public String text;
    @V8JavascriptField
    public String type;

    public b(JsObject jsObject, com.baidu.swan.games.f.b bVar) {
        super(bVar);
        this.type = "text";
        this.text = com.baidu.swan.apps.t.a.awA().getString(a.h.aiapps_aigames_userinfo_button_text_des);
        p(jsObject);
    }

    @JavascriptInterface
    public void destroy() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.eax != null) {
                    com.baidu.swan.games.view.c.removeView(b.this.eax);
                    b.this.eax = null;
                }
            }
        });
    }

    @JavascriptInterface
    public void hide() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.eax != null) {
                    b.this.eax.hide();
                }
            }
        });
    }

    @JavascriptInterface
    public void show() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.eax != null) {
                    b.this.eax.show();
                }
            }
        });
    }

    @JavascriptInterface
    public void onFieldChangedCallback(final String str) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.4
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.d("BaseButtonProxy", "onFieldChangedCallback fieldName=" + str);
                }
                if (b.this.eax != null) {
                    String str2 = str;
                    char c = 65535;
                    switch (str2.hashCode()) {
                        case 3556653:
                            if (str2.equals("text")) {
                                c = 0;
                                break;
                            }
                            break;
                        case 100313435:
                            if (str2.equals("image")) {
                                c = 1;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            b.this.eax.setButtonText(b.this.text);
                            return;
                        case 1:
                            b.this.eax.setImageUrl(b.this.image);
                            return;
                        default:
                            return;
                    }
                }
            }
        });
    }

    @Override // com.baidu.swan.games.view.button.base.a.InterfaceC0546a
    public void aYu() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.5
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.eax != null && !b.this.aYw()) {
                    b.this.eax.aYm();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aYv() {
        if (this.eax == null || this.style == null) {
            return false;
        }
        this.style.a(this);
        com.baidu.swan.apps.model.a.a.a aYx = aYx();
        return aYx != null && com.baidu.swan.games.view.c.c(this.eax, aYx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aYw() {
        com.baidu.swan.apps.model.a.a.a aYx;
        return (this.eax == null || this.style == null || (aYx = aYx()) == null || !com.baidu.swan.games.view.c.b(this.eax, aYx)) ? false : true;
    }

    private com.baidu.swan.apps.model.a.a.a aYx() {
        if (this.style == null || this.eax == null) {
            return null;
        }
        int N = ah.N(this.style.width);
        int N2 = ah.N(this.style.height);
        int N3 = ah.N(this.style.left);
        int N4 = ah.N(this.style.top);
        int N5 = ah.N(this.style.borderWidth);
        int i = N < N5 * 2 ? N5 * 2 : N;
        int i2 = N2 < N5 * 2 ? N5 * 2 : N2;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eax.getLayoutParams();
        if (layoutParams != null && layoutParams.width == i && layoutParams.height == i2 && layoutParams.leftMargin == N3 && layoutParams.topMargin == N4) {
            return null;
        }
        return new com.baidu.swan.apps.model.a.a.a(N3, N4, i, i2);
    }

    private void p(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("BaseButtonProxy", new StringBuilder().append("parse jsObject = ").append(e).toString() != null ? e.toString() : null);
        }
        if (e != null) {
            this.type = e.optString("type", this.type);
            this.text = e.optString("text", this.text);
            this.image = e.optString("image", this.image);
            com.baidu.swan.games.binding.model.c a2 = e.a("style", (com.baidu.swan.games.binding.model.c) null);
            this.style = a2 == null ? this.style : new a(a2);
        }
    }
}
