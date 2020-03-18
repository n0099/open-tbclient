package com.baidu.swan.games.m;

import android.text.TextUtils;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes11.dex */
public class b {
    private com.baidu.swan.games.e.b cpR;

    public b(com.baidu.swan.games.e.b bVar) {
        this.cpR = bVar;
    }

    public void pl(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        bO(str, "keyboardinput");
    }

    public void pm(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        bO(str, "keyboardconfirm");
    }

    public void pn(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        bO(str, "keyboardcomplete");
    }

    private void bO(String str, String str2) {
        if (this.cpR != null && this.cpR.anz() != null && this.cpR.anz().hasEventListener(str2)) {
            com.baidu.swan.games.m.a.a aVar = new com.baidu.swan.games.m.a.a();
            aVar.value = str;
            JSEvent jSEvent = new JSEvent(str2);
            jSEvent.data = aVar;
            this.cpR.anz().dispatchEvent(jSEvent);
        }
    }
}
