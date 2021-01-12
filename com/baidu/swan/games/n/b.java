package com.baidu.swan.games.n;

import android.text.TextUtils;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes8.dex */
public class b {
    private com.baidu.swan.games.f.b egm;

    public b(com.baidu.swan.games.f.b bVar) {
        this.egm = bVar;
    }

    public void wB(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        dj(str, "keyboardinput");
    }

    public void wC(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        dj(str, "keyboardconfirm");
    }

    public void wD(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        dj(str, "keyboardcomplete");
    }

    private void dj(String str, String str2) {
        if (this.egm != null && this.egm.aVN() != null && this.egm.aVN().hasEventListener(str2)) {
            com.baidu.swan.games.n.a.a aVar = new com.baidu.swan.games.n.a.a();
            aVar.value = str;
            JSEvent jSEvent = new JSEvent(str2);
            jSEvent.data = aVar;
            this.egm.aVN().dispatchEvent(jSEvent);
        }
    }
}
