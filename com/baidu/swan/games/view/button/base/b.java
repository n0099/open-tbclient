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
public class b extends EventTargetImpl implements a.InterfaceC0532a {
    protected ApiButton ekb;
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
        this.text = com.baidu.swan.apps.t.a.awy().getString(a.h.aiapps_aigames_userinfo_button_text_des);
        p(jsObject);
    }

    @JavascriptInterface
    public void destroy() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.ekb != null) {
                    com.baidu.swan.games.view.c.removeView(b.this.ekb);
                    b.this.ekb = null;
                }
            }
        });
    }

    @JavascriptInterface
    public void hide() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.ekb != null) {
                    b.this.ekb.hide();
                }
            }
        });
    }

    @JavascriptInterface
    public void show() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.ekb != null) {
                    b.this.ekb.show();
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
                if (b.this.ekb != null) {
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
                            b.this.ekb.setButtonText(b.this.text);
                            return;
                        case 1:
                            b.this.ekb.setImageUrl(b.this.image);
                            return;
                        default:
                            return;
                    }
                }
            }
        });
    }

    @Override // com.baidu.swan.games.view.button.base.a.InterfaceC0532a
    public void aZr() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.5
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.ekb != null && !b.this.aZt()) {
                    b.this.ekb.aZi();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aZs() {
        if (this.ekb == null || this.style == null) {
            return false;
        }
        this.style.a(this);
        com.baidu.swan.apps.model.a.a.a aZu = aZu();
        return aZu != null && com.baidu.swan.games.view.c.c(this.ekb, aZu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aZt() {
        com.baidu.swan.apps.model.a.a.a aZu;
        return (this.ekb == null || this.style == null || (aZu = aZu()) == null || !com.baidu.swan.games.view.c.b(this.ekb, aZu)) ? false : true;
    }

    private com.baidu.swan.apps.model.a.a.a aZu() {
        if (this.style == null || this.ekb == null) {
            return null;
        }
        int O = ah.O(this.style.width);
        int O2 = ah.O(this.style.height);
        int O3 = ah.O(this.style.left);
        int O4 = ah.O(this.style.top);
        int O5 = ah.O(this.style.borderWidth);
        int i = O < O5 * 2 ? O5 * 2 : O;
        int i2 = O2 < O5 * 2 ? O5 * 2 : O2;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ekb.getLayoutParams();
        if (layoutParams != null && layoutParams.width == i && layoutParams.height == i2 && layoutParams.leftMargin == O3 && layoutParams.topMargin == O4) {
            return null;
        }
        return new com.baidu.swan.apps.model.a.a.a(O3, O4, i, i2);
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
