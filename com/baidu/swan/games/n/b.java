package com.baidu.swan.games.n;

import android.text.TextUtils;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes3.dex */
public class b {
    private com.baidu.swan.games.f.b dwv;

    public b(com.baidu.swan.games.f.b bVar) {
        this.dwv = bVar;
    }

    public void vS(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        cT(str, "keyboardinput");
    }

    public void vT(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        cT(str, "keyboardconfirm");
    }

    public void vU(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        cT(str, "keyboardcomplete");
    }

    private void cT(String str, String str2) {
        if (this.dwv != null && this.dwv.aNM() != null && this.dwv.aNM().hasEventListener(str2)) {
            com.baidu.swan.games.n.a.a aVar = new com.baidu.swan.games.n.a.a();
            aVar.value = str;
            JSEvent jSEvent = new JSEvent(str2);
            jSEvent.data = aVar;
            this.dwv.aNM().dispatchEvent(jSEvent);
        }
    }
}
