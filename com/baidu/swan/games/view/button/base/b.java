package com.baidu.swan.games.view.button.base;

import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.FrameLayout;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.ai;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.games.view.button.base.a;
/* loaded from: classes7.dex */
public class b extends EventTargetImpl implements a.InterfaceC0460a {
    protected ApiButton dnZ;
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
        this.text = com.baidu.swan.apps.t.a.ahj().getString(a.h.aiapps_aigames_userinfo_button_text_des);
        p(jsObject);
    }

    @JavascriptInterface
    public void destroy() {
        al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.dnZ != null) {
                    com.baidu.swan.games.view.c.ay(b.this.dnZ);
                    b.this.dnZ = null;
                }
            }
        });
    }

    @JavascriptInterface
    public void hide() {
        al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.dnZ != null) {
                    b.this.dnZ.hide();
                }
            }
        });
    }

    @JavascriptInterface
    public void show() {
        al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.dnZ != null) {
                    b.this.dnZ.show();
                }
            }
        });
    }

    @JavascriptInterface
    public void onFieldChangedCallback(final String str) {
        al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.4
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.d("BaseButtonProxy", "onFieldChangedCallback fieldName=" + str);
                }
                if (b.this.dnZ != null) {
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
                            b.this.dnZ.setButtonText(b.this.text);
                            return;
                        case 1:
                            b.this.dnZ.setImageUrl(b.this.image);
                            return;
                        default:
                            return;
                    }
                }
            }
        });
    }

    @Override // com.baidu.swan.games.view.button.base.a.InterfaceC0460a
    public void aHP() {
        al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.5
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.dnZ != null && !b.this.aHR()) {
                    b.this.dnZ.aHH();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aHQ() {
        if (this.dnZ == null || this.style == null) {
            return false;
        }
        this.style.a(this);
        com.baidu.swan.apps.model.a.a.a aHS = aHS();
        return aHS != null && com.baidu.swan.games.view.c.c(this.dnZ, aHS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aHR() {
        com.baidu.swan.apps.model.a.a.a aHS;
        return (this.dnZ == null || this.style == null || (aHS = aHS()) == null || !com.baidu.swan.games.view.c.b(this.dnZ, aHS)) ? false : true;
    }

    private com.baidu.swan.apps.model.a.a.a aHS() {
        if (this.style == null || this.dnZ == null) {
            return null;
        }
        int D = ai.D(this.style.width);
        int D2 = ai.D(this.style.height);
        int D3 = ai.D(this.style.left);
        int D4 = ai.D(this.style.top);
        int D5 = ai.D(this.style.borderWidth);
        int i = D < D5 * 2 ? D5 * 2 : D;
        int i2 = D2 < D5 * 2 ? D5 * 2 : D2;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dnZ.getLayoutParams();
        if (layoutParams != null && layoutParams.width == i && layoutParams.height == i2 && layoutParams.leftMargin == D3 && layoutParams.topMargin == D4) {
            return null;
        }
        return new com.baidu.swan.apps.model.a.a.a(D3, D4, i, i2);
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
            com.baidu.swan.games.binding.model.c a = e.a("style", (com.baidu.swan.games.binding.model.c) null);
            this.style = a == null ? this.style : new a(a);
        }
    }
}
