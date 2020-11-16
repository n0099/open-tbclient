package com.baidu.swan.games.z;

import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes7.dex */
public class a {
    public static void b(com.baidu.swan.games.f.a aVar, String str) {
        if (aVar != null && aVar.aUh().hasEventListener("deviceOrientationChange")) {
            JSEvent jSEvent = new JSEvent("deviceOrientationChange");
            jSEvent.data = new com.baidu.swan.games.z.a.a(str);
            aVar.dispatchEvent(jSEvent);
        }
    }
}
