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
/* loaded from: classes7.dex */
public class b extends EventTargetImpl implements a.InterfaceC0544a {
    protected ApiButton dYP;
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
        this.text = com.baidu.swan.apps.t.a.avS().getString(a.h.aiapps_aigames_userinfo_button_text_des);
        p(jsObject);
    }

    @JavascriptInterface
    public void destroy() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.dYP != null) {
                    com.baidu.swan.games.view.c.removeView(b.this.dYP);
                    b.this.dYP = null;
                }
            }
        });
    }

    @JavascriptInterface
    public void hide() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.dYP != null) {
                    b.this.dYP.hide();
                }
            }
        });
    }

    @JavascriptInterface
    public void show() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.dYP != null) {
                    b.this.dYP.show();
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
                if (b.this.dYP != null) {
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
                            b.this.dYP.setButtonText(b.this.text);
                            return;
                        case 1:
                            b.this.dYP.setImageUrl(b.this.image);
                            return;
                        default:
                            return;
                    }
                }
            }
        });
    }

    @Override // com.baidu.swan.games.view.button.base.a.InterfaceC0544a
    public void aXN() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.5
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.dYP != null && !b.this.aXP()) {
                    b.this.dYP.aXE();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aXO() {
        if (this.dYP == null || this.style == null) {
            return false;
        }
        this.style.a(this);
        com.baidu.swan.apps.model.a.a.a aXQ = aXQ();
        return aXQ != null && com.baidu.swan.games.view.c.c(this.dYP, aXQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aXP() {
        com.baidu.swan.apps.model.a.a.a aXQ;
        return (this.dYP == null || this.style == null || (aXQ = aXQ()) == null || !com.baidu.swan.games.view.c.b(this.dYP, aXQ)) ? false : true;
    }

    private com.baidu.swan.apps.model.a.a.a aXQ() {
        if (this.style == null || this.dYP == null) {
            return null;
        }
        int M = ah.M(this.style.width);
        int M2 = ah.M(this.style.height);
        int M3 = ah.M(this.style.left);
        int M4 = ah.M(this.style.top);
        int M5 = ah.M(this.style.borderWidth);
        int i = M < M5 * 2 ? M5 * 2 : M;
        int i2 = M2 < M5 * 2 ? M5 * 2 : M2;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dYP.getLayoutParams();
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
