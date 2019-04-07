package com.baidu.swan.games.r;

import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.games.audio.b.b;
/* loaded from: classes2.dex */
public class a {
    public static void m(com.baidu.swan.games.e.a aVar) {
        if (aVar != null && aVar.NT().hasEventListener("audiointerruptionbegin") && b.Nt()) {
            aVar.dispatchEvent(new JSEvent("audiointerruptionbegin"));
        }
    }

    public static void n(com.baidu.swan.games.e.a aVar) {
        if (aVar != null && aVar.NT().hasEventListener("audiointerruptionend")) {
            aVar.dispatchEvent(new JSEvent("audiointerruptionend"));
        }
    }
}
