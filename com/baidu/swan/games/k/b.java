package com.baidu.swan.games.k;

import android.text.TextUtils;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes2.dex */
public class b {
    private com.baidu.swan.games.e.b biX;

    public b(com.baidu.swan.games.e.b bVar) {
        this.biX = bVar;
    }

    public void jI(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        be(str, "keyboardinput");
    }

    public void jJ(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        be(str, "keyboardconfirm");
    }

    public void jK(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        be(str, "keyboardcomplete");
    }

    private void be(String str, String str2) {
        if (this.biX != null && this.biX.RG() != null && this.biX.RG().hasEventListener(str2)) {
            com.baidu.swan.games.k.a.a aVar = new com.baidu.swan.games.k.a.a();
            aVar.value = str;
            JSEvent jSEvent = new JSEvent(str2);
            jSEvent.data = aVar;
            this.biX.RG().dispatchEvent(jSEvent);
        }
    }
}
