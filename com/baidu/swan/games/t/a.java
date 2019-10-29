package com.baidu.swan.games.t;

import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.games.audio.b.b;
/* loaded from: classes2.dex */
public class a {
    public static void y(com.baidu.swan.games.e.a aVar) {
        if (aVar != null && aVar.WB().hasEventListener("audiointerruptionbegin") && b.Wa()) {
            aVar.dispatchEvent(new JSEvent("audiointerruptionbegin"));
        }
    }

    public static void z(com.baidu.swan.games.e.a aVar) {
        if (aVar != null && aVar.WB().hasEventListener("audiointerruptionend")) {
            aVar.dispatchEvent(new JSEvent("audiointerruptionend"));
        }
    }
}
