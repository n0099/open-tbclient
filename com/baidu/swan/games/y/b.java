package com.baidu.swan.games.y;

import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes11.dex */
public class b {
    public static void v(com.baidu.swan.games.e.a aVar) {
        if (aVar != null && aVar.anu().hasEventListener("audiointerruptionbegin") && com.baidu.swan.games.audio.b.b.alz().alC()) {
            aVar.dispatchEvent(new JSEvent("audiointerruptionbegin"));
        }
    }

    public static void w(com.baidu.swan.games.e.a aVar) {
        if (aVar != null && aVar.anu().hasEventListener("audiointerruptionend")) {
            aVar.dispatchEvent(new JSEvent("audiointerruptionend"));
        }
    }
}
