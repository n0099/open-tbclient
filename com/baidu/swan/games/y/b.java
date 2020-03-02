package com.baidu.swan.games.y;

import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes11.dex */
public class b {
    public static void v(com.baidu.swan.games.e.a aVar) {
        if (aVar != null && aVar.anw().hasEventListener("audiointerruptionbegin") && com.baidu.swan.games.audio.b.b.alB().alE()) {
            aVar.dispatchEvent(new JSEvent("audiointerruptionbegin"));
        }
    }

    public static void w(com.baidu.swan.games.e.a aVar) {
        if (aVar != null && aVar.anw().hasEventListener("audiointerruptionend")) {
            aVar.dispatchEvent(new JSEvent("audiointerruptionend"));
        }
    }
}
