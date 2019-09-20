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
                if (com.baidu.swan.games.view.a.TB() != null) {
                    b.this.bmt = new UserInfoButton(com.baidu.swan.games.view.a.TB(), b.this);
                    b.this.bmt.setType(b.this.type);
                    b.this.bmt.setButtonText(b.this.text);
                    b.this.bmt.setImageUrl(b.this.image);
                    b.this.bmt.setApiButtonStyle(b.this.style);
                    b.this.TT();
                }
            }
        });
    }
}
