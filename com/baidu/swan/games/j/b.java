package com.baidu.swan.games.j;

import android.text.TextUtils;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes2.dex */
public class b {
    private com.baidu.swan.games.e.b bdT;

    public b(com.baidu.swan.games.e.b bVar) {
        this.bdT = bVar;
    }

    public void iP(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        bb(str, "keyboardinput");
    }

    public void iQ(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        bb(str, "keyboardconfirm");
    }

    public void iR(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        bb(str, "keyboardcomplete");
    }

    private void bb(String str, String str2) {
        if (this.bdT != null && this.bdT.NT() != null && this.bdT.NT().hasEventListener(str2)) {
            com.baidu.swan.games.j.a.a aVar = new com.baidu.swan.games.j.a.a();
            aVar.value = str;
            JSEvent jSEvent = new JSEvent(str2);
            jSEvent.data = aVar;
            this.bdT.NT().dispatchEvent(jSEvent);
        }
    }
}
