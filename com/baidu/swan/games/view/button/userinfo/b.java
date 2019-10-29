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
                if (com.baidu.swan.games.view.a.Ys() != null) {
                    b.this.bFf = new UserInfoButton(com.baidu.swan.games.view.a.Ys(), b.this);
                    b.this.bFf.setType(b.this.type);
                    b.this.bFf.setButtonText(b.this.text);
                    b.this.bFf.setImageUrl(b.this.image);
                    b.this.bFf.setApiButtonStyle(b.this.style);
                    b.this.YK();
                }
            }
        });
    }
}
