package com.baidu.swan.games.view.button.base;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.FrameLayout;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.an.z;
import com.baidu.swan.games.view.button.base.a;
/* loaded from: classes2.dex */
public class b extends EventTargetImpl implements a.InterfaceC0255a {
    protected ApiButton bEo;
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
        this.text = com.baidu.swan.apps.u.a.Jj().getString(a.h.aiapps_aigames_userinfo_button_text_des);
        o(jsObject);
    }

    @JavascriptInterface
    public void destroy() {
        ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.bEo != null) {
                    com.baidu.swan.games.view.a.at(b.this.bEo);
                    b.this.bEo = null;
                }
            }
        });
    }

    @JavascriptInterface
    public void hide() {
        ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.bEo != null) {
                    b.this.bEo.hide();
                }
            }
        });
    }

    @JavascriptInterface
    public void show() {
        ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.bEo != null) {
                    b.this.bEo.show();
                }
            }
        });
    }

    @JavascriptInterface
    public void onFieldChangedCallback(final String str) {
        ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.4
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.d("BaseButtonProxy", "onFieldChangedCallback fieldName=" + str);
                }
                if (b.this.bEo != null) {
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
                            b.this.bEo.setButtonText(b.this.text);
                            return;
                        case 1:
                            b.this.bEo.setImageUrl(b.this.image);
                            return;
                        default:
                            return;
                    }
                }
            }
        });
    }

    @Override // com.baidu.swan.games.view.button.base.a.InterfaceC0255a
    public void YH() {
        ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.5
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.bEo != null && !b.this.YJ()) {
                    b.this.bEo.Yy();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean YI() {
        if (this.bEo == null || this.style == null) {
            return false;
        }
        this.style.a(this);
        com.baidu.swan.apps.model.a.a.b YK = YK();
        return YK != null && com.baidu.swan.games.view.a.c(this.bEo, YK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean YJ() {
        com.baidu.swan.apps.model.a.a.b YK;
        return (this.bEo == null || this.style == null || (YK = YK()) == null || !com.baidu.swan.games.view.a.b(this.bEo, YK)) ? false : true;
    }

    private com.baidu.swan.apps.model.a.a.b YK() {
        if (this.style == null || this.bEo == null) {
            return null;
        }
        int S = z.S(this.style.width);
        int S2 = z.S(this.style.height);
        int S3 = z.S(this.style.left);
        int S4 = z.S(this.style.top);
        int S5 = z.S(this.style.borderWidth);
        int i = S < S5 * 2 ? S5 * 2 : S;
        int i2 = S2 < S5 * 2 ? S5 * 2 : S2;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bEo.getLayoutParams();
        if (layoutParams != null && layoutParams.width == i && layoutParams.height == i2 && layoutParams.leftMargin == S3 && layoutParams.topMargin == S4) {
            return null;
        }
        return new com.baidu.swan.apps.model.a.a.b(S3, S4, i, i2);
    }

    private void o(JsObject jsObject) {
        if (jsObject != null) {
            if (com.baidu.swan.apps.b.DEBUG) {
                com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
                Log.d("BaseButtonProxy", new StringBuilder().append("parse jsObject = ").append(c).toString() != null ? c.toString() : null);
            }
            for (int i = 0; i < jsObject.length(); i++) {
                String propertyName = jsObject.getPropertyName(i);
                if (!TextUtils.isEmpty(propertyName)) {
                    char c2 = 65535;
                    switch (propertyName.hashCode()) {
                        case 3556653:
                            if (propertyName.equals("text")) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case 3575610:
                            if (propertyName.equals("type")) {
                                c2 = 0;
                                break;
                            }
                            break;
                        case 100313435:
                            if (propertyName.equals("image")) {
                                c2 = 2;
                                break;
                            }
                            break;
                        case 109780401:
                            if (propertyName.equals("style")) {
                                c2 = 3;
                                break;
                            }
                            break;
                    }
                    switch (c2) {
                        case 0:
                            this.type = jsObject.toString(i);
                            break;
                        case 1:
                            this.text = jsObject.toString(i);
                            break;
                        case 2:
                            this.image = jsObject.toString(i);
                            break;
                        case 3:
                            this.style = new a(jsObject.toJsObject(i));
                            break;
                    }
                } else {
                    return;
                }
            }
        }
    }
}
