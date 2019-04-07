package com.baidu.swan.games.view.button.base;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.FrameLayout;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.an.x;
import com.baidu.swan.games.view.button.base.a;
/* loaded from: classes2.dex */
public class b extends EventTargetImpl implements a.InterfaceC0205a {
    protected ApiButton bfS;
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
        this.text = com.baidu.swan.apps.u.a.Cw().getString(a.h.aiapps_aigames_userinfo_button_text_des);
        n(jsObject);
    }

    @JavascriptInterface
    public void destroy() {
        aa.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.bfS != null) {
                    com.baidu.swan.games.view.a.ai(b.this.bfS);
                    b.this.bfS = null;
                }
            }
        });
    }

    @JavascriptInterface
    public void hide() {
        aa.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.bfS != null) {
                    b.this.bfS.hide();
                }
            }
        });
    }

    @JavascriptInterface
    public void show() {
        aa.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.bfS != null) {
                    b.this.bfS.show();
                }
            }
        });
    }

    @JavascriptInterface
    public void onFieldChangedCallback(final String str) {
        aa.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.4
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.d("BaseButtonProxy", "onFieldChangedCallback fieldName=" + str);
                }
                if (b.this.bfS != null) {
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
                            b.this.bfS.setButtonText(b.this.text);
                            return;
                        case 1:
                            b.this.bfS.setImageUrl(b.this.image);
                            return;
                        default:
                            return;
                    }
                }
            }
        });
    }

    @Override // com.baidu.swan.games.view.button.base.a.InterfaceC0205a
    public void PA() {
        aa.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.base.b.5
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.bfS != null && !b.this.PC()) {
                    b.this.bfS.Pr();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean PB() {
        if (this.bfS == null || this.style == null) {
            return false;
        }
        this.style.a(this);
        com.baidu.swan.apps.model.a.a.b PD = PD();
        return PD != null && com.baidu.swan.games.view.a.c(this.bfS, PD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean PC() {
        com.baidu.swan.apps.model.a.a.b PD;
        return (this.bfS == null || this.style == null || (PD = PD()) == null || !com.baidu.swan.games.view.a.b(this.bfS, PD)) ? false : true;
    }

    private com.baidu.swan.apps.model.a.a.b PD() {
        if (this.style == null || this.bfS == null) {
            return null;
        }
        int ad = x.ad(this.style.width);
        int ad2 = x.ad(this.style.height);
        int ad3 = x.ad(this.style.left);
        int ad4 = x.ad(this.style.top);
        int ad5 = x.ad(this.style.borderWidth);
        int i = ad < ad5 * 2 ? ad5 * 2 : ad;
        int i2 = ad2 < ad5 * 2 ? ad5 * 2 : ad2;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bfS.getLayoutParams();
        if (layoutParams != null && layoutParams.width == i && layoutParams.height == i2 && layoutParams.leftMargin == ad3 && layoutParams.topMargin == ad4) {
            return null;
        }
        return new com.baidu.swan.apps.model.a.a.b(ad3, ad4, i, i2);
    }

    private void n(JsObject jsObject) {
        if (jsObject != null) {
            if (com.baidu.swan.apps.b.DEBUG) {
                com.baidu.swan.games.binding.model.c b = com.baidu.swan.games.binding.model.c.b(jsObject);
                Log.d("BaseButtonProxy", new StringBuilder().append("parse jsObject = ").append(b).toString() != null ? b.toString() : null);
            }
            for (int i = 0; i < jsObject.length(); i++) {
                String propertyName = jsObject.getPropertyName(i);
                if (!TextUtils.isEmpty(propertyName)) {
                    char c = 65535;
                    switch (propertyName.hashCode()) {
                        case 3556653:
                            if (propertyName.equals("text")) {
                                c = 1;
                                break;
                            }
                            break;
                        case 3575610:
                            if (propertyName.equals("type")) {
                                c = 0;
                                break;
                            }
                            break;
                        case 100313435:
                            if (propertyName.equals("image")) {
                                c = 2;
                                break;
                            }
                            break;
                        case 109780401:
                            if (propertyName.equals(UnitedSchemeConstants.UNITED_SCHEME_STYLE)) {
                                c = 3;
                                break;
                            }
                            break;
                    }
                    switch (c) {
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
