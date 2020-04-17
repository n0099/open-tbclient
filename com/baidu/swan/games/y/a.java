package com.baidu.swan.games.y;

import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes11.dex */
public class a {
    public static void b(com.baidu.swan.games.e.a aVar, String str) {
        if (aVar != null && aVar.avM().hasEventListener("deviceOrientationChange")) {
            JSEvent jSEvent = new JSEvent("deviceOrientationChange");
            jSEvent.data = new com.baidu.swan.games.y.a.a(str);
            aVar.dispatchEvent(jSEvent);
        }
    }
}
