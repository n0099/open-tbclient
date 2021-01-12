package com.baidu.swan.games.view.button.userinfo;

import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.games.v.d;
/* loaded from: classes8.dex */
public class b extends com.baidu.swan.games.view.button.base.b {
    public b(JsObject jsObject, com.baidu.swan.games.f.b bVar) {
        super(jsObject, bVar);
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.userinfo.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.games.view.c.getViewContext() != null) {
                    b.this.ekb = new UserInfoButton(com.baidu.swan.games.view.c.getViewContext(), b.this);
                    b.this.ekb.setType(b.this.type);
                    b.this.ekb.setButtonText(b.this.text);
                    b.this.ekb.setImageUrl(b.this.image);
                    b.this.ekb.setApiButtonStyle(b.this.style);
                    b.this.aZs();
                    b.this.aZw();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZw() {
        if (!d.aYb()) {
            com.baidu.swan.games.v.c.wR("Button shows early.");
        }
    }
}
