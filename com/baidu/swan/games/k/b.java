package com.baidu.swan.games.k;

import android.text.TextUtils;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes2.dex */
public class b {
    private com.baidu.swan.games.e.b bik;

    public b(com.baidu.swan.games.e.b bVar) {
        this.bik = bVar;
    }

    public void jA(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        be(str, "keyboardinput");
    }

    public void jB(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        be(str, "keyboardconfirm");
    }

    public void jC(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        be(str, "keyboardcomplete");
    }

    private void be(String str, String str2) {
        if (this.bik != null && this.bik.QN() != null && this.bik.QN().hasEventListener(str2)) {
            com.baidu.swan.games.k.a.a aVar = new com.baidu.swan.games.k.a.a();
            aVar.value = str;
            JSEvent jSEvent = new JSEvent(str2);
            jSEvent.data = aVar;
            this.bik.QN().dispatchEvent(jSEvent);
        }
    }
}
