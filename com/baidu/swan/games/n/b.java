package com.baidu.swan.games.n;

import android.text.TextUtils;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes25.dex */
public class b {
    private com.baidu.swan.games.f.b ecb;

    public b(com.baidu.swan.games.f.b bVar) {
        this.ecb = bVar;
    }

    public void xN(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        dl(str, "keyboardinput");
    }

    public void xO(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        dl(str, "keyboardconfirm");
    }

    public void xP(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        dl(str, "keyboardcomplete");
    }

    private void dl(String str, String str2) {
        if (this.ecb != null && this.ecb.aXm() != null && this.ecb.aXm().hasEventListener(str2)) {
            com.baidu.swan.games.n.a.a aVar = new com.baidu.swan.games.n.a.a();
            aVar.value = str;
            JSEvent jSEvent = new JSEvent(str2);
            jSEvent.data = aVar;
            this.ecb.aXm().dispatchEvent(jSEvent);
        }
    }
}
