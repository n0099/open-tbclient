package com.baidu.swan.games.n;

import android.text.TextUtils;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes8.dex */
public class b {
    private com.baidu.swan.games.f.b duq;

    public b(com.baidu.swan.games.f.b bVar) {
        this.duq = bVar;
    }

    public void vy(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        cT(str, "keyboardinput");
    }

    public void vz(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        cT(str, "keyboardconfirm");
    }

    public void vA(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        cT(str, "keyboardcomplete");
    }

    private void cT(String str, String str2) {
        if (this.duq != null && this.duq.aNb() != null && this.duq.aNb().hasEventListener(str2)) {
            com.baidu.swan.games.n.a.a aVar = new com.baidu.swan.games.n.a.a();
            aVar.value = str;
            JSEvent jSEvent = new JSEvent(str2);
            jSEvent.data = aVar;
            this.duq.aNb().dispatchEvent(jSEvent);
        }
    }
}
