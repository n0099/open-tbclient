package com.baidu.swan.games.m;

import android.text.TextUtils;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes9.dex */
public class b {
    private com.baidu.swan.games.e.b cln;

    public b(com.baidu.swan.games.e.b bVar) {
        this.cln = bVar;
    }

    public void oU(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        bF(str, "keyboardinput");
    }

    public void oV(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        bF(str, "keyboardconfirm");
    }

    public void oW(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        bF(str, "keyboardcomplete");
    }

    private void bF(String str, String str2) {
        if (this.cln != null && this.cln.akN() != null && this.cln.akN().hasEventListener(str2)) {
            com.baidu.swan.games.m.a.a aVar = new com.baidu.swan.games.m.a.a();
            aVar.value = str;
            JSEvent jSEvent = new JSEvent(str2);
            jSEvent.data = aVar;
            this.cln.akN().dispatchEvent(jSEvent);
        }
    }
}
