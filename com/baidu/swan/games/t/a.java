package com.baidu.swan.games.t;

import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.games.audio.b.b;
/* loaded from: classes2.dex */
public class a {
    public static void y(com.baidu.swan.games.e.a aVar) {
        if (aVar != null && aVar.Wz().hasEventListener("audiointerruptionbegin") && b.VY()) {
            aVar.dispatchEvent(new JSEvent("audiointerruptionbegin"));
        }
    }

    public static void z(com.baidu.swan.games.e.a aVar) {
        if (aVar != null && aVar.Wz().hasEventListener("audiointerruptionend")) {
            aVar.dispatchEvent(new JSEvent("audiointerruptionend"));
        }
    }
}
