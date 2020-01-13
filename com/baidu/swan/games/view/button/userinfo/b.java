package com.baidu.swan.games.view.button.userinfo;

import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.games.u.d;
/* loaded from: classes10.dex */
public class b extends com.baidu.swan.games.view.button.base.b {
    public b(JsObject jsObject, com.baidu.swan.games.e.b bVar) {
        super(jsObject, bVar);
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.userinfo.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.games.view.c.aob() != null) {
                    b.this.cpc = new UserInfoButton(com.baidu.swan.games.view.c.aob(), b.this);
                    b.this.cpc.setType(b.this.type);
                    b.this.cpc.setButtonText(b.this.text);
                    b.this.cpc.setImageUrl(b.this.image);
                    b.this.cpc.setApiButtonStyle(b.this.style);
                    b.this.aov();
                    b.this.aoz();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoz() {
        if (!d.anp()) {
            com.baidu.swan.games.u.c.pn("Button shows early.");
        }
    }
}
