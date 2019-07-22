package com.baidu.swan.games.view.button.userinfo;

import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.an.ac;
/* loaded from: classes2.dex */
public class b extends com.baidu.swan.games.view.button.base.b {
    public b(JsObject jsObject, com.baidu.swan.games.e.b bVar) {
        super(jsObject, bVar);
        ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.userinfo.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.games.view.a.Tx() != null) {
                    b.this.blU = new UserInfoButton(com.baidu.swan.games.view.a.Tx(), b.this);
                    b.this.blU.setType(b.this.type);
                    b.this.blU.setButtonText(b.this.text);
                    b.this.blU.setImageUrl(b.this.image);
                    b.this.blU.setApiButtonStyle(b.this.style);
                    b.this.TP();
                }
            }
        });
    }
}
