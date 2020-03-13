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
/* loaded from: classes11.dex */
public class b extends EventTargetImpl implements a.InterfaceC0349a {
    protected ApiButton ctf;
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
        this.text = com.baidu.swan.apps.w.a.TW().getString(a.h.aiapps_aigames_userinfo_button_text_des);
        n(jsObject);
    }

    @JavascriptInterface
    public void destroy() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.ctf != null) {
                    com.baidu.swan.games.view.c.au(b.this.ctf);
                    b.this.ctf = null;
                }
            }
        });
    }

    @JavascriptInterface
    public void hide() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.ctf != null) {
                    b.this.ctf.hide();
                }
            }
        });
    }

    @JavascriptInterface
    public void show() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.ctf != null) {
                    b.this.ctf.show();
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
                if (b.this.ctf != null) {
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
                            b.this.ctf.setButtonText(b.this.text);
                            return;
                        case 1:
                            b.this.ctf.setImageUrl(b.this.image);
                            return;
                        default:
                            return;
                    }
                }
            }
        });
    }

    @Override // com.baidu.swan.games.view.button.base.a.InterfaceC0349a
    public void aqK() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.5
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.ctf != null && !b.this.aqM()) {
                    b.this.ctf.aqB();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aqL() {
        if (this.ctf == null || this.style == null) {
            return false;
        }
        this.style.a(this);
        com.baidu.swan.apps.model.a.a.a aqN = aqN();
        return aqN != null && com.baidu.swan.games.view.c.c(this.ctf, aqN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aqM() {
        com.baidu.swan.apps.model.a.a.a aqN;
        return (this.ctf == null || this.style == null || (aqN = aqN()) == null || !com.baidu.swan.games.view.c.b(this.ctf, aqN)) ? false : true;
    }

    private com.baidu.swan.apps.model.a.a.a aqN() {
        if (this.style == null || this.ctf == null) {
            return null;
        }
        int S = af.S(this.style.width);
        int S2 = af.S(this.style.height);
        int S3 = af.S(this.style.left);
        int S4 = af.S(this.style.f1013top);
        int S5 = af.S(this.style.borderWidth);
        int i = S < S5 * 2 ? S5 * 2 : S;
        int i2 = S2 < S5 * 2 ? S5 * 2 : S2;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ctf.getLayoutParams();
        if (layoutParams != null && layoutParams.width == i && layoutParams.height == i2 && layoutParams.leftMargin == S3 && layoutParams.topMargin == S4) {
            return null;
        }
        return new com.baidu.swan.apps.model.a.a.a(S3, S4, i, i2);
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
