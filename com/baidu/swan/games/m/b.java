package com.baidu.swan.games.m;

import android.text.TextUtils;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes11.dex */
public class b {
    private com.baidu.swan.games.e.b cpG;

    public b(com.baidu.swan.games.e.b bVar) {
        this.cpG = bVar;
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
        if (this.cpG != null && this.cpG.anw() != null && this.cpG.anw().hasEventListener(str2)) {
            com.baidu.swan.games.m.a.a aVar = new com.baidu.swan.games.m.a.a();
            aVar.value = str;
            JSEvent jSEvent = new JSEvent(str2);
            jSEvent.data = aVar;
            this.cpG.anw().dispatchEvent(jSEvent);
        }
    }
}
