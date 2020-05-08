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
public class b extends EventTargetImpl implements a.InterfaceC0400a {
    protected ApiButton cSq;
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
        this.text = com.baidu.swan.apps.w.a.abN().getString(a.h.aiapps_aigames_userinfo_button_text_des);
        n(jsObject);
    }

    @JavascriptInterface
    public void destroy() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.cSq != null) {
                    com.baidu.swan.games.view.c.av(b.this.cSq);
                    b.this.cSq = null;
                }
            }
        });
    }

    @JavascriptInterface
    public void hide() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.cSq != null) {
                    b.this.cSq.hide();
                }
            }
        });
    }

    @JavascriptInterface
    public void show() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.cSq != null) {
                    b.this.cSq.show();
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
                if (b.this.cSq != null) {
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
                            b.this.cSq.setButtonText(b.this.text);
                            return;
                        case 1:
                            b.this.cSq.setImageUrl(b.this.image);
                            return;
                        default:
                            return;
                    }
                }
            }
        });
    }

    @Override // com.baidu.swan.games.view.button.base.a.InterfaceC0400a
    public void ayY() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.5
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.cSq != null && !b.this.aza()) {
                    b.this.cSq.ayQ();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ayZ() {
        if (this.cSq == null || this.style == null) {
            return false;
        }
        this.style.a(this);
        com.baidu.swan.apps.model.a.a.a azb = azb();
        return azb != null && com.baidu.swan.games.view.c.c(this.cSq, azb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aza() {
        com.baidu.swan.apps.model.a.a.a azb;
        return (this.cSq == null || this.style == null || (azb = azb()) == null || !com.baidu.swan.games.view.c.b(this.cSq, azb)) ? false : true;
    }

    private com.baidu.swan.apps.model.a.a.a azb() {
        if (this.style == null || this.cSq == null) {
            return null;
        }
        int C = af.C(this.style.width);
        int C2 = af.C(this.style.height);
        int C3 = af.C(this.style.left);
        int C4 = af.C(this.style.f1008top);
        int C5 = af.C(this.style.borderWidth);
        int i = C < C5 * 2 ? C5 * 2 : C;
        int i2 = C2 < C5 * 2 ? C5 * 2 : C2;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cSq.getLayoutParams();
        if (layoutParams != null && layoutParams.width == i && layoutParams.height == i2 && layoutParams.leftMargin == C3 && layoutParams.topMargin == C4) {
            return null;
        }
        return new com.baidu.swan.apps.model.a.a.a(C3, C4, i, i2);
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
