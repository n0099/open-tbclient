package com.baidu.swan.games.view.button.userinfo;

import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.games.u.d;
/* loaded from: classes11.dex */
public class b extends com.baidu.swan.games.view.button.base.b {
    public b(JsObject jsObject, com.baidu.swan.games.e.b bVar) {
        super(jsObject, bVar);
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.userinfo.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.games.view.c.aqp() != null) {
                    b.this.ctd = new UserInfoButton(com.baidu.swan.games.view.c.aqp(), b.this);
                    b.this.ctd.setType(b.this.type);
                    b.this.ctd.setButtonText(b.this.text);
                    b.this.ctd.setImageUrl(b.this.image);
                    b.this.ctd.setApiButtonStyle(b.this.style);
                    b.this.aqJ();
                    b.this.aqN();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqN() {
        if (!d.apD()) {
            com.baidu.swan.games.u.c.pC("Button shows early.");
        }
    }
}
