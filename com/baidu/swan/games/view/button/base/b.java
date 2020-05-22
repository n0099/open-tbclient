package com.baidu.swan.games.view.button.base;

import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.FrameLayout;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.ag;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.games.view.button.base.a;
/* loaded from: classes11.dex */
public class b extends EventTargetImpl implements a.InterfaceC0441a {
    protected ApiButton ddr;
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
        this.text = com.baidu.swan.apps.u.a.aeR().getString(a.h.aiapps_aigames_userinfo_button_text_des);
        p(jsObject);
    }

    @JavascriptInterface
    public void destroy() {
        aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.ddr != null) {
                    com.baidu.swan.games.view.c.av(b.this.ddr);
                    b.this.ddr = null;
                }
            }
        });
    }

    @JavascriptInterface
    public void hide() {
        aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.ddr != null) {
                    b.this.ddr.hide();
                }
            }
        });
    }

    @JavascriptInterface
    public void show() {
        aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.ddr != null) {
                    b.this.ddr.show();
                }
            }
        });
    }

    @JavascriptInterface
    public void onFieldChangedCallback(final String str) {
        aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.4
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.d("BaseButtonProxy", "onFieldChangedCallback fieldName=" + str);
                }
                if (b.this.ddr != null) {
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
                            b.this.ddr.setButtonText(b.this.text);
                            return;
                        case 1:
                            b.this.ddr.setImageUrl(b.this.image);
                            return;
                        default:
                            return;
                    }
                }
            }
        });
    }

    @Override // com.baidu.swan.games.view.button.base.a.InterfaceC0441a
    public void aCQ() {
        aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.5
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.ddr != null && !b.this.aCS()) {
                    b.this.ddr.aCI();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aCR() {
        if (this.ddr == null || this.style == null) {
            return false;
        }
        this.style.a(this);
        com.baidu.swan.apps.model.a.a.a aCT = aCT();
        return aCT != null && com.baidu.swan.games.view.c.c(this.ddr, aCT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aCS() {
        com.baidu.swan.apps.model.a.a.a aCT;
        return (this.ddr == null || this.style == null || (aCT = aCT()) == null || !com.baidu.swan.games.view.c.b(this.ddr, aCT)) ? false : true;
    }

    private com.baidu.swan.apps.model.a.a.a aCT() {
        if (this.style == null || this.ddr == null) {
            return null;
        }
        int B = ag.B(this.style.width);
        int B2 = ag.B(this.style.height);
        int B3 = ag.B(this.style.left);
        int B4 = ag.B(this.style.f1007top);
        int B5 = ag.B(this.style.borderWidth);
        int i = B < B5 * 2 ? B5 * 2 : B;
        int i2 = B2 < B5 * 2 ? B5 * 2 : B2;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ddr.getLayoutParams();
        if (layoutParams != null && layoutParams.width == i && layoutParams.height == i2 && layoutParams.leftMargin == B3 && layoutParams.topMargin == B4) {
            return null;
        }
        return new com.baidu.swan.apps.model.a.a.a(B3, B4, i, i2);
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
