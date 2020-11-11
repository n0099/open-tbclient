package com.baidu.swan.games.n;

import android.text.TextUtils;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes10.dex */
public class b {
    private com.baidu.swan.games.f.b dWL;

    public b(com.baidu.swan.games.f.b bVar) {
        this.dWL = bVar;
    }

    public void xl(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        df(str, "keyboardinput");
    }

    public void xm(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        df(str, "keyboardconfirm");
    }

    public void xn(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        df(str, "keyboardcomplete");
    }

    private void df(String str, String str2) {
        if (this.dWL != null && this.dWL.aUP() != null && this.dWL.aUP().hasEventListener(str2)) {
            com.baidu.swan.games.n.a.a aVar = new com.baidu.swan.games.n.a.a();
            aVar.value = str;
            JSEvent jSEvent = new JSEvent(str2);
            jSEvent.data = aVar;
            this.dWL.aUP().dispatchEvent(jSEvent);
        }
    }
}
