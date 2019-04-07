package com.baidu.swan.games.view.button.userinfo;

import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.an.aa;
/* loaded from: classes2.dex */
public class b extends com.baidu.swan.games.view.button.base.b {
    public b(JsObject jsObject, com.baidu.swan.games.e.b bVar) {
        super(jsObject, bVar);
        aa.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.userinfo.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.games.view.a.Pl() != null) {
                    b.this.bfS = new UserInfoButton(com.baidu.swan.games.view.a.Pl(), b.this);
                    b.this.bfS.setType(b.this.type);
                    b.this.bfS.setButtonText(b.this.text);
                    b.this.bfS.setImageUrl(b.this.image);
                    b.this.bfS.setApiButtonStyle(b.this.style);
                    b.this.PB();
                }
            }
        });
    }
}
