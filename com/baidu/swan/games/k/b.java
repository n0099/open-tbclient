package com.baidu.swan.games.k;

import android.text.TextUtils;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes2.dex */
public class b {
    private com.baidu.swan.games.e.b bBs;

    public b(com.baidu.swan.games.e.b bVar) {
        this.bBs = bVar;
    }

    public void km(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        bl(str, "keyboardinput");
    }

    public void kn(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        bl(str, "keyboardconfirm");
    }

    public void ko(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        bl(str, "keyboardcomplete");
    }

    private void bl(String str, String str2) {
        if (this.bBs != null && this.bBs.Wz() != null && this.bBs.Wz().hasEventListener(str2)) {
            com.baidu.swan.games.k.a.a aVar = new com.baidu.swan.games.k.a.a();
            aVar.value = str;
            JSEvent jSEvent = new JSEvent(str2);
            jSEvent.data = aVar;
            this.bBs.Wz().dispatchEvent(jSEvent);
        }
    }
}
