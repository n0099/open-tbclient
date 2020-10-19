package com.baidu.swan.games.n;

import android.text.TextUtils;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes10.dex */
public class b {
    private com.baidu.swan.games.f.b dIw;

    public b(com.baidu.swan.games.f.b bVar) {
        this.dIw = bVar;
    }

    public void wE(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        cY(str, "keyboardinput");
    }

    public void wF(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        cY(str, "keyboardconfirm");
    }

    public void wG(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        cY(str, "keyboardcomplete");
    }

    private void cY(String str, String str2) {
        if (this.dIw != null && this.dIw.aQv() != null && this.dIw.aQv().hasEventListener(str2)) {
            com.baidu.swan.games.n.a.a aVar = new com.baidu.swan.games.n.a.a();
            aVar.value = str;
            JSEvent jSEvent = new JSEvent(str2);
            jSEvent.data = aVar;
            this.dIw.aQv().dispatchEvent(jSEvent);
        }
    }
}
