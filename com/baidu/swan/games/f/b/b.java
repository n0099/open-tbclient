package com.baidu.swan.games.f.b;

import com.baidu.searchbox.v8engine.V8Engine;
/* loaded from: classes11.dex */
public class b {
    private V8Engine mV8Engine;

    public b(V8Engine v8Engine) {
        this.mV8Engine = v8Engine;
    }

    public void ck(String str, String str2) {
        this.mV8Engine.requireJSFileForOpenData(str, str2);
    }

    public void azL() {
        this.mV8Engine.destroyOpenDataContext();
    }
}
