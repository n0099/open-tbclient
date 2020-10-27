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
public class b extends EventTargetImpl implements a.InterfaceC0534a {
    protected ApiButton dUF;
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
        this.text = com.baidu.swan.apps.t.a.aua().getString(a.h.aiapps_aigames_userinfo_button_text_des);
        p(jsObject);
    }

    @JavascriptInterface
    public void destroy() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.dUF != null) {
                    com.baidu.swan.games.view.c.removeView(b.this.dUF);
                    b.this.dUF = null;
                }
            }
        });
    }

    @JavascriptInterface
    public void hide() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.dUF != null) {
                    b.this.dUF.hide();
                }
            }
        });
    }

    @JavascriptInterface
    public void show() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.dUF != null) {
                    b.this.dUF.show();
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
                if (b.this.dUF != null) {
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
                            b.this.dUF.setButtonText(b.this.text);
                            return;
                        case 1:
                            b.this.dUF.setImageUrl(b.this.image);
                            return;
                        default:
                            return;
                    }
                }
            }
        });
    }

    @Override // com.baidu.swan.games.view.button.base.a.InterfaceC0534a
    public void aVU() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.5
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.dUF != null && !b.this.aVW()) {
                    b.this.dUF.aVM();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aVV() {
        if (this.dUF == null || this.style == null) {
            return false;
        }
        this.style.a(this);
        com.baidu.swan.apps.model.a.a.a aVX = aVX();
        return aVX != null && com.baidu.swan.games.view.c.c(this.dUF, aVX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aVW() {
        com.baidu.swan.apps.model.a.a.a aVX;
        return (this.dUF == null || this.style == null || (aVX = aVX()) == null || !com.baidu.swan.games.view.c.b(this.dUF, aVX)) ? false : true;
    }

    private com.baidu.swan.apps.model.a.a.a aVX() {
        if (this.style == null || this.dUF == null) {
            return null;
        }
        int L = ah.L(this.style.width);
        int L2 = ah.L(this.style.height);
        int L3 = ah.L(this.style.left);
        int L4 = ah.L(this.style.top);
        int L5 = ah.L(this.style.borderWidth);
        int i = L < L5 * 2 ? L5 * 2 : L;
        int i2 = L2 < L5 * 2 ? L5 * 2 : L2;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dUF.getLayoutParams();
        if (layoutParams != null && layoutParams.width == i && layoutParams.height == i2 && layoutParams.leftMargin == L3 && layoutParams.topMargin == L4) {
            return null;
        }
        return new com.baidu.swan.apps.model.a.a.a(L3, L4, i, i2);
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
