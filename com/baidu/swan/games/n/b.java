package com.baidu.swan.games.n;

import android.text.TextUtils;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes9.dex */
public class b {
    private com.baidu.swan.games.f.b ekY;

    public b(com.baidu.swan.games.f.b bVar) {
        this.ekY = bVar;
    }

    public void xM(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        dk(str, "keyboardinput");
    }

    public void xN(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        dk(str, "keyboardconfirm");
    }

    public void xO(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        dk(str, "keyboardcomplete");
    }

    private void dk(String str, String str2) {
        if (this.ekY != null && this.ekY.aZH() != null && this.ekY.aZH().hasEventListener(str2)) {
            com.baidu.swan.games.n.a.a aVar = new com.baidu.swan.games.n.a.a();
            aVar.value = str;
            JSEvent jSEvent = new JSEvent(str2);
            jSEvent.data = aVar;
            this.ekY.aZH().dispatchEvent(jSEvent);
        }
    }
}
