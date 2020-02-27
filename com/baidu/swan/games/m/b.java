package com.baidu.swan.games.m;

import android.text.TextUtils;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes11.dex */
public class b {
    private com.baidu.swan.games.e.b cpE;

    public b(com.baidu.swan.games.e.b bVar) {
        this.cpE = bVar;
    }

    public void pm(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        bP(str, "keyboardinput");
    }

    public void pn(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        bP(str, "keyboardconfirm");
    }

    public void po(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        bP(str, "keyboardcomplete");
    }

    private void bP(String str, String str2) {
        if (this.cpE != null && this.cpE.anu() != null && this.cpE.anu().hasEventListener(str2)) {
            com.baidu.swan.games.m.a.a aVar = new com.baidu.swan.games.m.a.a();
            aVar.value = str;
            JSEvent jSEvent = new JSEvent(str2);
            jSEvent.data = aVar;
            this.cpE.anu().dispatchEvent(jSEvent);
        }
    }
}
