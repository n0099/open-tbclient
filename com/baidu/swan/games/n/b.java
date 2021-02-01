package com.baidu.swan.games.n;

import android.text.TextUtils;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes9.dex */
public class b {
    private com.baidu.swan.games.f.b eit;

    public b(com.baidu.swan.games.f.b bVar) {
        this.eit = bVar;
    }

    public void wU(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        dd(str, "keyboardinput");
    }

    public void wV(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        dd(str, "keyboardconfirm");
    }

    public void wW(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        dd(str, "keyboardcomplete");
    }

    private void dd(String str, String str2) {
        if (this.eit != null && this.eit.aVZ() != null && this.eit.aVZ().hasEventListener(str2)) {
            com.baidu.swan.games.n.a.a aVar = new com.baidu.swan.games.n.a.a();
            aVar.value = str;
            JSEvent jSEvent = new JSEvent(str2);
            jSEvent.data = aVar;
            this.eit.aVZ().dispatchEvent(jSEvent);
        }
    }
}
