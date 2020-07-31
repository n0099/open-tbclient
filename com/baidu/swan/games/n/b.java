package com.baidu.swan.games.n;

import android.text.TextUtils;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes7.dex */
public class b {
    private com.baidu.swan.games.f.b dki;

    public b(com.baidu.swan.games.f.b bVar) {
        this.dki = bVar;
    }

    public void ti(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        cz(str, "keyboardinput");
    }

    public void tj(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        cz(str, "keyboardconfirm");
    }

    public void tk(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        cz(str, "keyboardcomplete");
    }

    private void cz(String str, String str2) {
        if (this.dki != null && this.dki.aEm() != null && this.dki.aEm().hasEventListener(str2)) {
            com.baidu.swan.games.n.a.a aVar = new com.baidu.swan.games.n.a.a();
            aVar.value = str;
            JSEvent jSEvent = new JSEvent(str2);
            jSEvent.data = aVar;
            this.dki.aEm().dispatchEvent(jSEvent);
        }
    }
}
