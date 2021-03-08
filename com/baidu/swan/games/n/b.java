package com.baidu.swan.games.n;

import android.text.TextUtils;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes8.dex */
public class b {
    private com.baidu.swan.games.f.b ejU;

    public b(com.baidu.swan.games.f.b bVar) {
        this.ejU = bVar;
    }

    public void xb(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        dd(str, "keyboardinput");
    }

    public void xc(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        dd(str, "keyboardconfirm");
    }

    public void xd(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        dd(str, "keyboardcomplete");
    }

    private void dd(String str, String str2) {
        if (this.ejU != null && this.ejU.aWc() != null && this.ejU.aWc().hasEventListener(str2)) {
            com.baidu.swan.games.n.a.a aVar = new com.baidu.swan.games.n.a.a();
            aVar.value = str;
            JSEvent jSEvent = new JSEvent(str2);
            jSEvent.data = aVar;
            this.ejU.aWc().dispatchEvent(jSEvent);
        }
    }
}
