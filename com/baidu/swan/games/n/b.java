package com.baidu.swan.games.n;

import android.text.TextUtils;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes7.dex */
public class b {
    private com.baidu.swan.games.f.b dVd;

    public b(com.baidu.swan.games.f.b bVar) {
        this.dVd = bVar;
    }

    public void xg(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        de(str, "keyboardinput");
    }

    public void xh(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        de(str, "keyboardconfirm");
    }

    public void xi(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        de(str, "keyboardcomplete");
    }

    private void de(String str, String str2) {
        if (this.dVd != null && this.dVd.aUh() != null && this.dVd.aUh().hasEventListener(str2)) {
            com.baidu.swan.games.n.a.a aVar = new com.baidu.swan.games.n.a.a();
            aVar.value = str;
            JSEvent jSEvent = new JSEvent(str2);
            jSEvent.data = aVar;
            this.dVd.aUh().dispatchEvent(jSEvent);
        }
    }
}
