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
/* loaded from: classes8.dex */
public class b extends EventTargetImpl implements a.InterfaceC0508a {
    protected ApiButton dyc;
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
        this.text = com.baidu.swan.apps.t.a.aoJ().getString(a.h.aiapps_aigames_userinfo_button_text_des);
        p(jsObject);
    }

    @JavascriptInterface
    public void destroy() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.dyc != null) {
                    com.baidu.swan.games.view.c.removeView(b.this.dyc);
                    b.this.dyc = null;
                }
            }
        });
    }

    @JavascriptInterface
    public void hide() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.dyc != null) {
                    b.this.dyc.hide();
                }
            }
        });
    }

    @JavascriptInterface
    public void show() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.dyc != null) {
                    b.this.dyc.show();
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
                if (b.this.dyc != null) {
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
                            b.this.dyc.setButtonText(b.this.text);
                            return;
                        case 1:
                            b.this.dyc.setImageUrl(b.this.image);
                            return;
                        default:
                            return;
                    }
                }
            }
        });
    }

    @Override // com.baidu.swan.games.view.button.base.a.InterfaceC0508a
    public void aQF() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.5
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.dyc != null && !b.this.aQH()) {
                    b.this.dyc.aQx();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aQG() {
        if (this.dyc == null || this.style == null) {
            return false;
        }
        this.style.a(this);
        com.baidu.swan.apps.model.a.a.a aQI = aQI();
        return aQI != null && com.baidu.swan.games.view.c.c(this.dyc, aQI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aQH() {
        com.baidu.swan.apps.model.a.a.a aQI;
        return (this.dyc == null || this.style == null || (aQI = aQI()) == null || !com.baidu.swan.games.view.c.b(this.dyc, aQI)) ? false : true;
    }

    private com.baidu.swan.apps.model.a.a.a aQI() {
        if (this.style == null || this.dyc == null) {
            return null;
        }
        int H = ah.H(this.style.width);
        int H2 = ah.H(this.style.height);
        int H3 = ah.H(this.style.left);
        int H4 = ah.H(this.style.top);
        int H5 = ah.H(this.style.borderWidth);
        int i = H < H5 * 2 ? H5 * 2 : H;
        int i2 = H2 < H5 * 2 ? H5 * 2 : H2;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dyc.getLayoutParams();
        if (layoutParams != null && layoutParams.width == i && layoutParams.height == i2 && layoutParams.leftMargin == H3 && layoutParams.topMargin == H4) {
            return null;
        }
        return new com.baidu.swan.apps.model.a.a.a(H3, H4, i, i2);
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
