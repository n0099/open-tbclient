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
/* loaded from: classes9.dex */
public class b extends EventTargetImpl implements a.InterfaceC0529a {
    protected ApiButton emi;
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
        this.text = com.baidu.swan.apps.t.a.awW().getString(a.h.aiapps_aigames_userinfo_button_text_des);
        p(jsObject);
    }

    @JavascriptInterface
    public void destroy() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.emi != null) {
                    com.baidu.swan.games.view.c.removeView(b.this.emi);
                    b.this.emi = null;
                }
            }
        });
    }

    @JavascriptInterface
    public void hide() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.emi != null) {
                    b.this.emi.hide();
                }
            }
        });
    }

    @JavascriptInterface
    public void show() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.emi != null) {
                    b.this.emi.show();
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
                if (b.this.emi != null) {
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
                            b.this.emi.setButtonText(b.this.text);
                            return;
                        case 1:
                            b.this.emi.setImageUrl(b.this.image);
                            return;
                        default:
                            return;
                    }
                }
            }
        });
    }

    @Override // com.baidu.swan.games.view.button.base.a.InterfaceC0529a
    public void aZE() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.5
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.emi != null && !b.this.aZG()) {
                    b.this.emi.aZu();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aZF() {
        if (this.emi == null || this.style == null) {
            return false;
        }
        this.style.a(this);
        com.baidu.swan.apps.model.a.a.a aZH = aZH();
        return aZH != null && com.baidu.swan.games.view.c.c(this.emi, aZH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aZG() {
        com.baidu.swan.apps.model.a.a.a aZH;
        return (this.emi == null || this.style == null || (aZH = aZH()) == null || !com.baidu.swan.games.view.c.b(this.emi, aZH)) ? false : true;
    }

    private com.baidu.swan.apps.model.a.a.a aZH() {
        if (this.style == null || this.emi == null) {
            return null;
        }
        int P = ah.P(this.style.width);
        int P2 = ah.P(this.style.height);
        int P3 = ah.P(this.style.left);
        int P4 = ah.P(this.style.top);
        int P5 = ah.P(this.style.borderWidth);
        int i = P < P5 * 2 ? P5 * 2 : P;
        int i2 = P2 < P5 * 2 ? P5 * 2 : P2;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.emi.getLayoutParams();
        if (layoutParams != null && layoutParams.width == i && layoutParams.height == i2 && layoutParams.leftMargin == P3 && layoutParams.topMargin == P4) {
            return null;
        }
        return new com.baidu.swan.apps.model.a.a.a(P3, P4, i, i2);
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
