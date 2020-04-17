package com.baidu.swan.games.m;

import android.text.TextUtils;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes11.dex */
public class b {
    private com.baidu.swan.games.e.b cON;

    public b(com.baidu.swan.games.e.b bVar) {
        this.cON = bVar;
    }

    public void qy(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        bZ(str, "keyboardinput");
    }

    public void qz(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        bZ(str, "keyboardconfirm");
    }

    public void qA(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        bZ(str, "keyboardcomplete");
    }

    private void bZ(String str, String str2) {
        if (this.cON != null && this.cON.avM() != null && this.cON.avM().hasEventListener(str2)) {
            com.baidu.swan.games.m.a.a aVar = new com.baidu.swan.games.m.a.a();
            aVar.value = str;
            JSEvent jSEvent = new JSEvent(str2);
            jSEvent.data = aVar;
            this.cON.avM().dispatchEvent(jSEvent);
        }
    }
}
