package com.baidu.swan.games.view.button.base;

import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.FrameLayout;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.games.view.button.base.a;
/* loaded from: classes8.dex */
public class b extends EventTargetImpl implements a.InterfaceC0535a {
    protected ApiButton enL;
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
        this.text = com.baidu.swan.apps.t.a.awZ().getString(a.h.aiapps_aigames_userinfo_button_text_des);
        p(jsObject);
    }

    @JavascriptInterface
    public void destroy() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.enL != null) {
                    com.baidu.swan.games.view.c.removeView(b.this.enL);
                    b.this.enL = null;
                }
            }
        });
    }

    @JavascriptInterface
    public void hide() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.enL != null) {
                    b.this.enL.hide();
                }
            }
        });
    }

    @JavascriptInterface
    public void show() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.enL != null) {
                    b.this.enL.show();
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
                if (b.this.enL != null) {
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
                            b.this.enL.setButtonText(b.this.text);
                            return;
                        case 1:
                            b.this.enL.setImageUrl(b.this.image);
                            return;
                        default:
                            return;
                    }
                }
            }
        });
    }

    @Override // com.baidu.swan.games.view.button.base.a.InterfaceC0535a
    public void aZH() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.5
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.enL != null && !b.this.aZJ()) {
                    b.this.enL.aZx();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aZI() {
        if (this.enL == null || this.style == null) {
            return false;
        }
        this.style.a(this);
        com.baidu.swan.apps.model.a.a.a aZK = aZK();
        return aZK != null && com.baidu.swan.games.view.c.c(this.enL, aZK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aZJ() {
        com.baidu.swan.apps.model.a.a.a aZK;
        return (this.enL == null || this.style == null || (aZK = aZK()) == null || !com.baidu.swan.games.view.c.b(this.enL, aZK)) ? false : true;
    }

    private com.baidu.swan.apps.model.a.a.a aZK() {
        if (this.style == null || this.enL == null) {
            return null;
        }
        int T = ah.T(this.style.width);
        int T2 = ah.T(this.style.height);
        int T3 = ah.T(this.style.left);
        int T4 = ah.T(this.style.top);
        int T5 = ah.T(this.style.borderWidth);
        int i = T < T5 * 2 ? T5 * 2 : T;
        int i2 = T2 < T5 * 2 ? T5 * 2 : T2;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.enL.getLayoutParams();
        if (layoutParams != null && layoutParams.width == i && layoutParams.height == i2 && layoutParams.leftMargin == T3 && layoutParams.topMargin == T4) {
            return null;
        }
        return new com.baidu.swan.apps.model.a.a.a(T3, T4, i, i2);
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
