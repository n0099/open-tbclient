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
/* loaded from: classes10.dex */
public class b extends EventTargetImpl implements a.InterfaceC0520a {
    protected ApiButton dMi;
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
        this.text = com.baidu.swan.apps.t.a.asf().getString(a.h.aiapps_aigames_userinfo_button_text_des);
        p(jsObject);
    }

    @JavascriptInterface
    public void destroy() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.dMi != null) {
                    com.baidu.swan.games.view.c.removeView(b.this.dMi);
                    b.this.dMi = null;
                }
            }
        });
    }

    @JavascriptInterface
    public void hide() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.dMi != null) {
                    b.this.dMi.hide();
                }
            }
        });
    }

    @JavascriptInterface
    public void show() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.dMi != null) {
                    b.this.dMi.show();
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
                if (b.this.dMi != null) {
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
                            b.this.dMi.setButtonText(b.this.text);
                            return;
                        case 1:
                            b.this.dMi.setImageUrl(b.this.image);
                            return;
                        default:
                            return;
                    }
                }
            }
        });
    }

    @Override // com.baidu.swan.games.view.button.base.a.InterfaceC0520a
    public void aUa() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.5
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.dMi != null && !b.this.aUc()) {
                    b.this.dMi.aTS();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aUb() {
        if (this.dMi == null || this.style == null) {
            return false;
        }
        this.style.a(this);
        com.baidu.swan.apps.model.a.a.a aUd = aUd();
        return aUd != null && com.baidu.swan.games.view.c.c(this.dMi, aUd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aUc() {
        com.baidu.swan.apps.model.a.a.a aUd;
        return (this.dMi == null || this.style == null || (aUd = aUd()) == null || !com.baidu.swan.games.view.c.b(this.dMi, aUd)) ? false : true;
    }

    private com.baidu.swan.apps.model.a.a.a aUd() {
        if (this.style == null || this.dMi == null) {
            return null;
        }
        int J = ah.J(this.style.width);
        int J2 = ah.J(this.style.height);
        int J3 = ah.J(this.style.left);
        int J4 = ah.J(this.style.top);
        int J5 = ah.J(this.style.borderWidth);
        int i = J < J5 * 2 ? J5 * 2 : J;
        int i2 = J2 < J5 * 2 ? J5 * 2 : J2;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dMi.getLayoutParams();
        if (layoutParams != null && layoutParams.width == i && layoutParams.height == i2 && layoutParams.leftMargin == J3 && layoutParams.topMargin == J4) {
            return null;
        }
        return new com.baidu.swan.apps.model.a.a.a(J3, J4, i, i2);
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
