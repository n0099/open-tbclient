package com.baidu.swan.games.m;

import android.text.TextUtils;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes10.dex */
public class b {
    private com.baidu.swan.games.e.b clA;

    public b(com.baidu.swan.games.e.b bVar) {
        this.clA = bVar;
    }

    public void oX(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        bG(str, "keyboardinput");
    }

    public void oY(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        bG(str, "keyboardconfirm");
    }

    public void oZ(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        bG(str, "keyboardcomplete");
    }

    private void bG(String str, String str2) {
        if (this.clA != null && this.clA.alg() != null && this.clA.alg().hasEventListener(str2)) {
            com.baidu.swan.games.m.a.a aVar = new com.baidu.swan.games.m.a.a();
            aVar.value = str;
            JSEvent jSEvent = new JSEvent(str2);
            jSEvent.data = aVar;
            this.clA.alg().dispatchEvent(jSEvent);
        }
    }
}
