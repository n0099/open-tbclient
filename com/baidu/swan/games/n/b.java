package com.baidu.swan.games.n;

import android.text.TextUtils;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes8.dex */
public class b {
    private com.baidu.swan.games.f.b duu;

    public b(com.baidu.swan.games.f.b bVar) {
        this.duu = bVar;
    }

    public void vz(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        cT(str, "keyboardinput");
    }

    public void vA(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        cT(str, "keyboardconfirm");
    }

    public void vB(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        cT(str, "keyboardcomplete");
    }

    private void cT(String str, String str2) {
        if (this.duu != null && this.duu.aNb() != null && this.duu.aNb().hasEventListener(str2)) {
            com.baidu.swan.games.n.a.a aVar = new com.baidu.swan.games.n.a.a();
            aVar.value = str;
            JSEvent jSEvent = new JSEvent(str2);
            jSEvent.data = aVar;
            this.duu.aNb().dispatchEvent(jSEvent);
        }
    }
}
