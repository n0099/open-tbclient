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
/* loaded from: classes25.dex */
public class b extends EventTargetImpl implements a.InterfaceC0556a {
    protected ApiButton efO;
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
        this.text = com.baidu.swan.apps.t.a.aza().getString(a.h.aiapps_aigames_userinfo_button_text_des);
        p(jsObject);
    }

    @JavascriptInterface
    public void destroy() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.efO != null) {
                    com.baidu.swan.games.view.c.removeView(b.this.efO);
                    b.this.efO = null;
                }
            }
        });
    }

    @JavascriptInterface
    public void hide() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.efO != null) {
                    b.this.efO.hide();
                }
            }
        });
    }

    @JavascriptInterface
    public void show() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.efO != null) {
                    b.this.efO.show();
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
                if (b.this.efO != null) {
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
                            b.this.efO.setButtonText(b.this.text);
                            return;
                        case 1:
                            b.this.efO.setImageUrl(b.this.image);
                            return;
                        default:
                            return;
                    }
                }
            }
        });
    }

    @Override // com.baidu.swan.games.view.button.base.a.InterfaceC0556a
    public void baS() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.5
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.efO != null && !b.this.baU()) {
                    b.this.efO.baJ();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean baT() {
        if (this.efO == null || this.style == null) {
            return false;
        }
        this.style.a(this);
        com.baidu.swan.apps.model.a.a.a baV = baV();
        return baV != null && com.baidu.swan.games.view.c.c(this.efO, baV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean baU() {
        com.baidu.swan.apps.model.a.a.a baV;
        return (this.efO == null || this.style == null || (baV = baV()) == null || !com.baidu.swan.games.view.c.b(this.efO, baV)) ? false : true;
    }

    private com.baidu.swan.apps.model.a.a.a baV() {
        if (this.style == null || this.efO == null) {
            return null;
        }
        int M = ah.M(this.style.width);
        int M2 = ah.M(this.style.height);
        int M3 = ah.M(this.style.left);
        int M4 = ah.M(this.style.top);
        int M5 = ah.M(this.style.borderWidth);
        int i = M < M5 * 2 ? M5 * 2 : M;
        int i2 = M2 < M5 * 2 ? M5 * 2 : M2;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.efO.getLayoutParams();
        if (layoutParams != null && layoutParams.width == i && layoutParams.height == i2 && layoutParams.leftMargin == M3 && layoutParams.topMargin == M4) {
            return null;
        }
        return new com.baidu.swan.apps.model.a.a.a(M3, M4, i, i2);
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
