package com.baidu.swan.games.view.button.base;

import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.FrameLayout;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.games.view.button.base.a;
/* loaded from: classes9.dex */
public class b extends EventTargetImpl implements a.InterfaceC0337a {
    protected ApiButton coQ;
    @V8JavascriptField
    public String image;
    @V8JavascriptField
    public a style;
    @V8JavascriptField
    public String text;
    @V8JavascriptField
    public String type;

    public b(JsObject jsObject, com.baidu.swan.games.e.b bVar) {
        super(bVar);
        this.type = "text";
        this.text = com.baidu.swan.apps.w.a.Rk().getString(a.h.aiapps_aigames_userinfo_button_text_des);
        n(jsObject);
    }

    @JavascriptInterface
    public void destroy() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.coQ != null) {
                    com.baidu.swan.games.view.c.aq(b.this.coQ);
                    b.this.coQ = null;
                }
            }
        });
    }

    @JavascriptInterface
    public void hide() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.coQ != null) {
                    b.this.coQ.hide();
                }
            }
        });
    }

    @JavascriptInterface
    public void show() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.coQ != null) {
                    b.this.coQ.show();
                }
            }
        });
    }

    @JavascriptInterface
    public void onFieldChangedCallback(final String str) {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.4
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.d("BaseButtonProxy", "onFieldChangedCallback fieldName=" + str);
                }
                if (b.this.coQ != null) {
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
                            b.this.coQ.setButtonText(b.this.text);
                            return;
                        case 1:
                            b.this.coQ.setImageUrl(b.this.image);
                            return;
                        default:
                            return;
                    }
                }
            }
        });
    }

    @Override // com.baidu.swan.games.view.button.base.a.InterfaceC0337a
    public void aob() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.5
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.coQ != null && !b.this.aod()) {
                    b.this.coQ.anS();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aoc() {
        if (this.coQ == null || this.style == null) {
            return false;
        }
        this.style.a(this);
        com.baidu.swan.apps.model.a.a.a aoe = aoe();
        return aoe != null && com.baidu.swan.games.view.c.c(this.coQ, aoe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aod() {
        com.baidu.swan.apps.model.a.a.a aoe;
        return (this.coQ == null || this.style == null || (aoe = aoe()) == null || !com.baidu.swan.games.view.c.b(this.coQ, aoe)) ? false : true;
    }

    private com.baidu.swan.apps.model.a.a.a aoe() {
        if (this.style == null || this.coQ == null) {
            return null;
        }
        int T = af.T(this.style.width);
        int T2 = af.T(this.style.height);
        int T3 = af.T(this.style.left);
        int T4 = af.T(this.style.top);
        int T5 = af.T(this.style.borderWidth);
        int i = T < T5 * 2 ? T5 * 2 : T;
        int i2 = T2 < T5 * 2 ? T5 * 2 : T2;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.coQ.getLayoutParams();
        if (layoutParams != null && layoutParams.width == i && layoutParams.height == i2 && layoutParams.leftMargin == T3 && layoutParams.topMargin == T4) {
            return null;
        }
        return new com.baidu.swan.apps.model.a.a.a(T3, T4, i, i2);
    }

    private void n(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("BaseButtonProxy", new StringBuilder().append("parse jsObject = ").append(c).toString() != null ? c.toString() : null);
        }
        if (c != null) {
            this.type = c.optString("type", this.type);
            this.text = c.optString("text", this.text);
            this.image = c.optString("image", this.image);
            com.baidu.swan.games.binding.model.c a = c.a("style", (com.baidu.swan.games.binding.model.c) null);
            this.style = a == null ? this.style : new a(a);
        }
    }
}
