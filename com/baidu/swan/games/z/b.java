package com.baidu.swan.games.z;

import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes7.dex */
public class b {
    public static void v(com.baidu.swan.games.f.a aVar) {
        if (aVar != null && aVar.aUh().hasEventListener("audiointerruptionbegin") && com.baidu.swan.games.audio.b.b.aSl().aSo()) {
            aVar.dispatchEvent(new JSEvent("audiointerruptionbegin"));
        }
    }

    public static void w(com.baidu.swan.games.f.a aVar) {
        if (aVar != null && aVar.aUh().hasEventListener("audiointerruptionend")) {
            aVar.dispatchEvent(new JSEvent("audiointerruptionend"));
        }
    }
}
