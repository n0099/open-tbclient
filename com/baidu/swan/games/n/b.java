package com.baidu.swan.games.n;

import android.text.TextUtils;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes11.dex */
public class b {
    private com.baidu.swan.games.f.b dez;

    public b(com.baidu.swan.games.f.b bVar) {
        this.dez = bVar;
    }

    public void sj(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        cw(str, "keyboardinput");
    }

    public void sk(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        cw(str, "keyboardconfirm");
    }

    public void sl(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        cw(str, "keyboardcomplete");
    }

    private void cw(String str, String str2) {
        if (this.dez != null && this.dez.aAH() != null && this.dez.aAH().hasEventListener(str2)) {
            com.baidu.swan.games.n.a.a aVar = new com.baidu.swan.games.n.a.a();
            aVar.value = str;
            JSEvent jSEvent = new JSEvent(str2);
            jSEvent.data = aVar;
            this.dez.aAH().dispatchEvent(jSEvent);
        }
    }
}
