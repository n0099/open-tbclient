package com.baidu.swan.games.n;

import android.text.TextUtils;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes11.dex */
public class b {
    private com.baidu.swan.games.f.b cZK;

    public b(com.baidu.swan.games.f.b bVar) {
        this.cZK = bVar;
    }

    public void sb(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        cu(str, "keyboardinput");
    }

    public void sc(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        cu(str, "keyboardconfirm");
    }

    public void sd(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        cu(str, "keyboardcomplete");
    }

    private void cu(String str, String str2) {
        if (this.cZK != null && this.cZK.azB() != null && this.cZK.azB().hasEventListener(str2)) {
            com.baidu.swan.games.n.a.a aVar = new com.baidu.swan.games.n.a.a();
            aVar.value = str;
            JSEvent jSEvent = new JSEvent(str2);
            jSEvent.data = aVar;
            this.cZK.azB().dispatchEvent(jSEvent);
        }
    }
}
