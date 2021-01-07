package com.baidu.swan.games.view.button.userinfo;

import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.games.v.d;
/* loaded from: classes9.dex */
public class b extends com.baidu.swan.games.view.button.base.b {
    public b(JsObject jsObject, com.baidu.swan.games.f.b bVar) {
        super(jsObject, bVar);
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.userinfo.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.games.view.c.getViewContext() != null) {
                    b.this.eoQ = new UserInfoButton(com.baidu.swan.games.view.c.getViewContext(), b.this);
                    b.this.eoQ.setType(b.this.type);
                    b.this.eoQ.setButtonText(b.this.text);
                    b.this.eoQ.setImageUrl(b.this.image);
                    b.this.eoQ.setApiButtonStyle(b.this.style);
                    b.this.bdm();
                    b.this.bdq();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdq() {
        if (!d.bbV()) {
            com.baidu.swan.games.v.c.yc("Button shows early.");
        }
    }
}
